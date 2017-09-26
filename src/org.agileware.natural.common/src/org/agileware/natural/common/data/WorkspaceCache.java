package org.agileware.natural.common.data;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.agileware.natural.common.data.SnippetsCache.ListOfSnippets;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;

public class WorkspaceCache {
	Map<String, ProjectSnippetsCache> projectCache = new LinkedHashMap<> ();
	
	public void add (SnippetEntry e) {
		String projectName = toProjectName(e);
		if (projectName == null) return;
		ProjectSnippetsCache snippets = getProjectCache(projectName);
		if (snippets == null) {
			snippets = newProjectCache(projectName);
		}
		snippets.put (e);
	}
	
	public void clear (IFile file) {
		String projectName = toProjectName (file);
		ProjectSnippetsCache projectSnippetsCache = getProjectCache(projectName);
		if (projectSnippetsCache  != null)
			projectSnippetsCache.clear(file);
	}

	private ProjectSnippetsCache getProjectCache(String projectName) {
		ProjectSnippetsCache snippets = projectCache.get(projectName);
		if (snippets == null) {
			snippets = newProjectCache(projectName);
		}
		return snippets;
	}

	private synchronized ProjectSnippetsCache newProjectCache(String projectName) {
		ProjectSnippetsCache snippets = projectCache.get(projectName);
		if (snippets != null) return snippets;
		snippets = new ProjectSnippetsCache();
		projectCache.put (projectName, snippets);
		return snippets;
	}
	
	
	public ListOfSnippets getMatchedSnippets (IFile file, String name) {
		String projectName = toProjectName (file);
		if (projectName==null) return SnippetsCache.EMPTY;
		ProjectSnippetsCache projectSnippetsCache = getProjectCache(projectName);
		
		ListOfSnippets listtOfSnippets = projectSnippetsCache.getMatchedSnippets(name);
		
		if (file.getFullPath().toPortableString().endsWith(".feature")) {
			 ListOfSnippets fileSnippets = projectSnippetsCache.getFileMatchedSnippets (file, name);
			 listtOfSnippets.addAll (fileSnippets);
		}
		return listtOfSnippets;
	}
	
	
	private String toProjectName(SnippetEntry e) {
		IProject project = e.getProject();
		if (project==null) {
			return null;
		}
		return toProjectName(project);
	}
	
	private String toProjectName(IFile file) {
		return toProjectName (file.getProject());
		
	}

	private String toProjectName(IProject project) {
		if (project == null) return null;
		return project.getFolder("src").getFullPath().toPortableString();
	}

	public boolean containsProject(IFile file) {
		String projectName = toProjectName (file);
		return projectCache.containsKey(projectName);
	}

	public void removeEntry(IFile resource) {
		String projectName = toProjectName (resource);
		if (!projectCache.containsKey(projectName)) return;
		ProjectSnippetsCache project = getProjectCache(projectName);
		project.removeEntry (resource);
		
	} 

}
