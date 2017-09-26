package org.agileware.natural.common;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.agileware.natural.common.data.SnippetEntry;
import org.agileware.natural.common.data.SnippetsCache.ListOfSnippets;
import org.agileware.natural.common.data.WorkspaceCache;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.search.core.text.TextSearchEngine;
import org.eclipse.search.core.text.TextSearchMatchAccess;
import org.eclipse.search.core.text.TextSearchRequestor;
import org.eclipse.search.core.text.TextSearchScope;

import com.google.inject.Singleton;


@Singleton
public class SnippetsMatcher {
	static final Pattern ANY_FILES_PATTERN = Pattern.compile(".*");
	Set<String> alreadyInitetProjects = new HashSet<> ();
	
	private final static Pattern SNIPPET_FIND_PATTERN = TextSearchEngine
			.createPattern("alias \"[^\"]*\"|new snippet \"[^\"]*\"|go \\w*", true, true);
	
	
	private final static Pattern SNIPPET_DECLARATION_PATTERN = TextSearchEngine
			.createPattern(".*[new snippet|alias] \"([^\"]*)\"", true, true);
	
	private final static Pattern AS_SNIPPET_GO_PATTERN = TextSearchEngine
			.createPattern(".*go (\\w*)", true, true);
	
	private final WorkspaceCache workspaceCache = new WorkspaceCache ();
	
	
	
	
	private void retrieveSnippets(IResource resourceRoot) {
		IResource[] members = new IResource[]{resourceRoot};
		TextSearchScope wsscope = TextSearchScope.newSearchScope(members, ANY_FILES_PATTERN, true);
		TextSearchRequestor requestor = new TextSearchRequestor () {
			@Override
			public boolean acceptPatternMatch(TextSearchMatchAccess matchAccess) throws CoreException {
				int length = matchAccess.getMatchLength();
				int offset =  matchAccess.getMatchOffset();
				String entry = matchAccess.getFileContent(offset, length);
				Matcher matcher = SNIPPET_DECLARATION_PATTERN.matcher(entry);
				if (matcher.find()) {
					String snippetName = matcher.group (1);
					SnippetEntry snippetEntry = new SnippetEntry (snippetName, matchAccess);
					workspaceCache.add(snippetEntry);
				} else {
					matcher = AS_SNIPPET_GO_PATTERN.matcher(entry);
					if (matcher.find()) {
						String snippetName = matcher.group (1);
						SnippetEntry snippetEntry = new SnippetEntry (snippetName, matchAccess);
						workspaceCache.add(snippetEntry);
					}	
				}
				return super.acceptPatternMatch(matchAccess);
			}
		};
		TextSearchEngine.create().search(wsscope, requestor, SNIPPET_FIND_PATTERN, null);
	}
	
	
	private void checkInit(IFile file) {
			if (!alreadyInitetProjects.contains(file.getProject().getFullPath().toPortableString())) {
				retrieveProjectSnippets (file);
			}
	}
	
	private synchronized void retrieveProjectSnippets(IFile file) {
		if (alreadyInitetProjects.contains(file.getProject().getFullPath().toPortableString())) return;
		IResource resourceRoot = file.getProject().getFolder("src");
		retrieveSnippets(resourceRoot);
		alreadyInitetProjects.add(file.getProject().getFullPath().toPortableString());	
	}

	
	
	public void refresh(IFile resource) {
			if (!alreadyInitetProjects.contains(resource.getProject().getFullPath().toPortableString())) {
				return;
			}
			workspaceCache.removeEntry (resource);
			retrieveSnippets(resource);

			
			
	}

	public ListOfSnippets findSnippet(IFile file, String snippetName) {
		checkInit (file);
		ListOfSnippets snippets = workspaceCache.getMatchedSnippets(file, snippetName);
		return snippets;
	}
}
