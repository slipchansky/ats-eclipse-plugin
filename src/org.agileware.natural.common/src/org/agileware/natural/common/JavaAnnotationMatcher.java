package org.agileware.natural.common;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.agileware.natural.common.data.SnippetEntry;
import org.agileware.natural.common.data.SnippetsCache.ListOfSnippets;
import org.agileware.natural.common.util.StasUtil;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IAnnotation;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchMatch;
import org.eclipse.jdt.core.search.SearchParticipant;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.SearchRequestor;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class JavaAnnotationMatcher {

	@Inject
	private AbstractAnnotationDescriptor descriptor;
	
	@Inject
	private SnippetsMatcher snippetsMatcher;
	

	private Map<ICompilationUnit, List<Entry>> cache = new ConcurrentHashMap<ICompilationUnit, List<Entry>>();

	protected IJavaSearchScope getScope(String filter) {
		if (filter == null)
			return SearchEngine.createWorkspaceScope();

		String[] names = filter.split(",");
		final List<IJavaElement> packages = new ArrayList<IJavaElement>();

		SearchPattern pattern = null;
		for (String name : names) {
			SearchPattern current = SearchPattern.createPattern(name.trim(), IJavaSearchConstants.PACKAGE,
					IJavaSearchConstants.ALL_OCCURRENCES, SearchPattern.R_EXACT_MATCH | SearchPattern.R_CASE_SENSITIVE);
			if (pattern == null) {
				pattern = current;
			} else {
				pattern = SearchPattern.createOrPattern(pattern, current);
			}
		}
		try {
			new SearchEngine().search(pattern, new SearchParticipant[] { SearchEngine.getDefaultSearchParticipant() },
					SearchEngine.createWorkspaceScope(), new SearchRequestor() {
						public void acceptSearchMatch(SearchMatch match) throws CoreException {
							packages.add((IJavaElement) match.getElement());
						}
					}, null);
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return SearchEngine.createJavaSearchScope(packages.toArray(new IJavaElement[0]));
	}


	public void findMatches(URI uri, final String description, final Command command) {
		IFile file = StasUtil.toFile(uri.path());
		findMatches(file, description, command);
	}

	public void findMatches(IFile file, final String description, final Command command) {
		findCode(description, command);
		findSnippet(file, description, command);
	}

	private void findCode(final String description, final Command command) {
		if (cache.isEmpty ()) {
			retrieveAnnotatedMethods();
		}
		
		if (!cache.isEmpty()) {
			for (List<Entry> entries : cache.values()) {
				for (Entry entry : entries) {
					if (description.matches(entry.annotationValue)) {
						command.match(entry.annotationValue, entry.method);
					}
				}
			}
			return;
		}

		
	}

	private synchronized void retrieveAnnotatedMethods() {
		if (!cache.isEmpty ()) {
			return;
		}		
		
		SearchPattern pattern = null;
		for (final String annotationName : descriptor.getNames()) {
			SearchPattern current = SearchPattern.createPattern(annotationName, IJavaSearchConstants.ANNOTATION_TYPE,
					IJavaSearchConstants.ANNOTATION_TYPE_REFERENCE,
					SearchPattern.R_EXACT_MATCH | SearchPattern.R_CASE_SENSITIVE);
			if (pattern == null) {
				pattern = current;
			} else {
				pattern = SearchPattern.createOrPattern(pattern, current);
			}
		}

		try {
			IJavaSearchScope scope = this.getScope(null);
			new SearchEngine().search(pattern, new SearchParticipant[] { SearchEngine.getDefaultSearchParticipant() },
					scope, new SearchRequestor() {
						public void acceptSearchMatch(SearchMatch match) throws CoreException {
							if (match.getElement() instanceof IMethod) {
								IMethod method = (IMethod) match.getElement();
								IAnnotation[] annotations = method.getAnnotations();
								for (IAnnotation type : annotations) {
									// check annotation package
									if (AbstractAnnotationDescriptor.checkPackage(type, descriptor.getPackage())) {
										// verify pattern
										String annotationValue = (String) type.getMemberValuePairs()[0].getValue();
										List<Entry> entries = cache.get(method.getCompilationUnit());
										if (entries == null) {
											entries = new ArrayList<Entry>();
											cache.put(method.getCompilationUnit(), entries);
										}
										MethodMatchEntry methodMatchEntry = new MethodMatchEntry(method);
										addEntry(annotationValue, entries, methodMatchEntry);
									}
								}
							}
						}

					}, null);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	private void addEntry(String annotationValue, List<Entry> entries, MethodMatchEntry methodMatchEntry) {
		methodMatchEntry.getEntry().getKey();
		for (Entry e  : entries) {
			MethodMatchEntry m = (MethodMatchEntry)e.getMethod ();
			if (m.getEntry().getKey().equals(methodMatchEntry.getEntry().getKey())) return;
		}
		entries.add(new Entry(annotationValue, methodMatchEntry));
	}

	private void findSnippet(IResource resource, String sdescription, final Command command) {
			
			IPath fullPath = resource.getFullPath();
			IWorkspaceRoot workspace = ResourcesPlugin.getWorkspace().getRoot();
			IFile file = workspace.getFile(fullPath);
				if (file == null) 
				return;
			
			findSnippets(sdescription, command, file);
	}
	

	private void findSnippets(String description, final Command command, IFile file) {
		ListOfSnippets snippets = snippetsMatcher.findSnippet(file, description); 
		for (SnippetEntry e : snippets ) {
			  command.match(description, e);
		}
	}


	private String toKey (IProject cproject) {
		if (cproject == null) return null;
		return cproject.getFolder("src").getFullPath().toPortableString();
	}



	public Collection<String> findProposals(Collection<String> proposals) {
		if (cache.isEmpty()) { // stas. suggestions
			findCode("", new Command() {
				boolean found = false;

				@Override
				public void match(String annotationValue, MatchEntry method) {
					found = true;
				}

				@Override
				public boolean matched() {
					return found;
				}
			});
		}

		for (List<Entry> entries : cache.values()) {
			for (Entry entry : entries) {
				String proposal = compileProposal(entry);
				if (proposal==null) continue;
				if (!proposals.contains (proposal)) {
					proposals.add(proposal);
				}
			}
		}

		//findSnippetProposals("", proposals, "", "");
		return proposals;
	}
	
	private final static Set <String> exclude  = new HashSet<String>(Arrays.asList(
			"<v> == <v>",
			"<v> <= <v>",
			"<v> >= <v>",
			"<v> < <v>",
			"<v> > <v>",
			"<v> != <v>",
			"? ? ?",
			"?",
			"? equals to ?",
			"@?",
			"abort ?",
			"add ?",
			"add:",
			"begin ?"
	));

	private String compileProposal(Entry entry) {
		String str = entry.getAnnotationValue();
		if (str.startsWith("^")) str = str.substring(1);
		if (str.endsWith("$")) str = str.substring(0, str.length()-1);
		str = makeItReadable(str);
		return str;
	}


	public void evict(ICompilationUnit element) {
		cache.clear();
		System.out.println(">>> cache cleared");
	}

	public static class MatchEntry<T> {
		T entry;

		public MatchEntry(T e) {
			this.entry = e;
		}

		public T getEntry() {
			return entry;
		}
	}

	public static class MethodMatchEntry extends MatchEntry<IMethod> {
		public MethodMatchEntry(IMethod e) {
			super(e);
		}
	}


	public static interface Command {
		void match(String annotationValue, MatchEntry method);

		boolean matched();
	}

	public static class Entry {
		private String annotationValue;
		private MatchEntry method;

		private Entry(String annotationValue, MatchEntry method) {
			this.annotationValue = annotationValue;
			this.method = method;
		}

		public MatchEntry getMethod() {
			return method;
		}

		public String getAnnotationValue() {
			return annotationValue;
		}
	}


	private static final Pattern CALL_SNIPPET_PATTERN = Pattern.compile("^perform (.*) using$" + "|^perform (.*) with$"
			+ "|^perform \"([^\"]*)\"$" + "|^@(.*$)" + "|^(.*)\\;$" + "|^(.*)\\.$");
	
	private static final Pattern BRACE_PATTERN = Pattern.compile("^\"([^\"]*)\"$");
	public String getSnippetName(String str) {
		Matcher matcher = CALL_SNIPPET_PATTERN.matcher(str);
		if (matcher.find()) {
			for (int i = 1; i <= 6; i++) {
				try {
					String s = matcher.group(i);
					if (s != null) {
						matcher = BRACE_PATTERN.matcher(s);
						if (matcher.find()) {
							s = matcher.group(1);
						}
						return s;
					}
				} catch (Throwable e) {
					return null;
				}
			}

		}
		return null;
	}

	

	private static void makeItReadable(InputStream in, StringBuilder builder, boolean doOutput) throws IOException {
		int c = 0;
		while ( (c = in.read()) != -1) {
			if (c=='\\') {
				if ( (c = in.read()) == -1 ) break;
				if (doOutput) {
					builder.append(Character.toString((char)c));
				}
				continue;
			}
			if (c=='(') {
				builder.append("?");
				makeItReadable(in, builder, false);
				continue;
			}
			if (c == ')')
				break;
			
			if (doOutput) {
				builder.append(Character.toString((char)c));
			}
		}
	}
	
	
	private static String makeItReadable (String str) {
		byte[] bytes = str.getBytes();
		StringBuilder builder = new StringBuilder ();
		try (InputStream in = new ByteArrayInputStream (bytes)) {
				makeItReadable (in, builder, true);
			
		} catch (IOException e) {
			return str;
		}
		return builder.toString();
	}
	
	
}
