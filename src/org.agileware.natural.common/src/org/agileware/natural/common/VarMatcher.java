package org.agileware.natural.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.agileware.natural.common.data.SnippetEntry;
import org.agileware.natural.common.util.StasUtil;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.search.core.text.TextSearchEngine;
import org.eclipse.search.core.text.TextSearchMatchAccess;
import org.eclipse.search.core.text.TextSearchRequestor;
import org.eclipse.search.core.text.TextSearchScope;
import org.eclipse.xtext.resource.XtextResource;

import com.google.inject.Singleton;


@Singleton
public class VarMatcher {

	private final static String VAR_EXPRESSION1 = "set (\\w*)";
	private final static String VAR_EXPRESSION2 = "remember (\\w*)";
	private final static String VAR_EXPRESSION3 = "remember \\$(\\w*)";
	private final static String VAR_EXPRESSION4 = "def (\\w*)";
	private final static String VAR_EXPRESSION5 = "defremember (\\w*)";
	private final static String VAR_EXPRESSION6 = "for each (\\w*) of .*";
	private final static String VAR_EXPRESSION7 = "repeat (\\w*) \\d* times";
	private final static String VAR_EXPRESSION8 = ".* to (\\w*)";
	
	private final static String [] VAR_EXPRESSIONS = new String [] {VAR_EXPRESSION1, VAR_EXPRESSION2, VAR_EXPRESSION3, VAR_EXPRESSION4, VAR_EXPRESSION5, VAR_EXPRESSION6, VAR_EXPRESSION7, VAR_EXPRESSION8};
	
	private static final String ANY_NEWVAR_EXPRESSION = String.join("|", VAR_EXPRESSIONS);
	
	private final static Pattern NEWVAR_PATTERN = TextSearchEngine
			.createPattern(ANY_NEWVAR_EXPRESSION, true, true);
	
	private final Pattern [] EACH_MATCH_PATTERNS = new Pattern [VAR_EXPRESSIONS.length]; 
	
	
	public VarMatcher () {
		
		int i = 0;
		for (String s : VAR_EXPRESSIONS) {
			EACH_MATCH_PATTERNS[i++] = Pattern.compile(s);
		}
	}
	
	
	public List<SnippetEntry>  retrieveVars(IResource resourceRoot) {
		IResource[] members = new IResource[]{resourceRoot};
		final List<SnippetEntry> result = new ArrayList<SnippetEntry> ();
		TextSearchScope wsscope = TextSearchScope.newSearchScope(members, SnippetsMatcher.ANY_FILES_PATTERN, true);
		TextSearchRequestor requestor = new TextSearchRequestor () {
			@Override
			public boolean acceptPatternMatch(TextSearchMatchAccess matchAccess) throws CoreException {
				int length = matchAccess.getMatchLength();
				int offset =  matchAccess.getMatchOffset();
				String entry = matchAccess.getFileContent(offset, length);
				
				
				for (Pattern p : EACH_MATCH_PATTERNS) {
					Matcher matcher = p.matcher(entry);
					if (matcher.find()) {
						int varOffset = matcher.start(1);
						String varName = matcher.group(1);
						if (varName != null) {
							SnippetEntry varEntry = new SnippetEntry (varName, matchAccess);
							varEntry.setOffset(offset + varOffset);
							varEntry.setLength(varName.length());
							result.add(varEntry);
							break;
						}
					}
				} 
					
				return super.acceptPatternMatch(matchAccess);
			}
		};
		TextSearchEngine.create().search(wsscope, requestor, NEWVAR_PATTERN, null);
		return result;
	}


	public List<SnippetEntry> retrieveVars(ResourceImpl resource) {
		URI uri = resource.getURI();
		IFile file = StasUtil.toFile(uri.path());
		return retrieveVars (file);
	}
	
	private final static Pattern VAR_USE_PATTERN = Pattern.compile("\\$(\\w*)");
	public List<IHyperlink>  findVarHyperlinks(ResourceImpl resource, String description, int offset) {
		URI uri = resource.getURI();
		IFile file = StasUtil.toFile(uri.path());
		List<SnippetEntry> varDeclarations = retrieveVars(resource);
		
		int i = 0;
		List<IHyperlink> results = new ArrayList<IHyperlink>  ();
		for (; i<varDeclarations.size(); i++) {
			SnippetEntry varDeclaration = varDeclarations.get(i);
			if (varDeclaration.getOffset() > offset) break;
		}
		
		Matcher matcher = VAR_USE_PATTERN.matcher(description);
		while (matcher.find()) {
		    addVarHyperlinks (file, offset+matcher.start(), results, varDeclarations, matcher.group(1), i);
		}
		return results;
	}


	private void addVarHyperlinks(IFile file, int offset, List<IHyperlink> results, List<SnippetEntry> varDeclarations, String varName, int index) {
		for (index--;index>=0;index--) {
			SnippetEntry vd = varDeclarations.get(index);
			if (vd.getAnnotationValue().equals(varName)) {
				Region region = new Region (offset, varName.length());
				results.add(new FileHyperlink(varName, vd, region));
				return;
			}
		}
		
	}


	public void findVarProposals(XtextResource resource, int offset, String prefix, String suffix, Collection<String> proposals) {
		URI uri = resource.getURI();
		IFile file = StasUtil.toFile(uri.path());
		List<SnippetEntry> varDeclarations = retrieveVars(resource);
		int i = 0;
		for (; i<varDeclarations.size(); i++) {
			SnippetEntry varDeclaration = varDeclarations.get(i);
			if (varDeclaration.getOffset() > offset) break;
		}
		i--;
		
		for (;i>=0;i--) {
			SnippetEntry varDeclaration = varDeclarations.get(i);
			proposals.add(prefix +'$'+varDeclaration.getAnnotationValue());
		}
		
	}
	
	public static void main(String[] args) {
		String str = "for each person of $personsArray begin";
		Matcher matcher = NEWVAR_PATTERN.matcher(str);
		while (matcher.find()) {
			int intex = matcher.start ();
			String s = matcher.group(1);
			int k = 0;
			k++;
		}
		
	}
	
}
