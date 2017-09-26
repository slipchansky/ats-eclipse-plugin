package org.agileware.natural.common.data;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.agileware.natural.common.data.SnippetsCache.ListOfSnippets;
import org.eclipse.core.resources.IFile;

public class ProjectSnippetsCache {
	private Map<String, SnippetsCache> cache = new LinkedHashMap<> ();
	
	public void put (SnippetEntry e) {
		SnippetsCache snippets = cache.get(e.getFile().getFullPath().toPortableString());
		if (snippets == null) {
			snippets = new SnippetsCache();
			cache.put(e.getFile().getFullPath().toPortableString(), snippets);
		}
		snippets.put(e);
	} 
	
	public ListOfSnippets getMatchedSnippets (String name) {
		Set<Entry<String, SnippetsCache>> inFileEntries = cache.entrySet();
		ListOfSnippets result = new ListOfSnippets ();
		for (Entry<String, SnippetsCache> inFileEntry : inFileEntries) {
			if (!inFileEntry.getKey().endsWith(".feature")) // only snippets from includable features  
				result.addAll(inFileEntry.getValue().getMatchedSnippets(name));
			
		}
		return result;
	}
	
	public void clear (IFile file) {
		cache.remove(file.getFullPath().toPortableString());
	}

	public ListOfSnippets getAllSnippetsInFile(IFile file) {
		String key = file.getFullPath().toPortableString();
		SnippetsCache snippets = cache.get(key);
		if (snippets == null) return SnippetsCache.EMPTY;
		ListOfSnippets fileAccessibleSnippets = snippets.getAllSnippets();
		return fileAccessibleSnippets;
	}

	public ListOfSnippets getFileMatchedSnippets(IFile file,  String name) {
		SnippetsCache snippets = cache.get(file.getFullPath().toPortableString());
		if (snippets == null) return SnippetsCache.EMPTY;
		return snippets.getMatchedSnippets(name);
	}

	public void removeEntry(IFile file) {
		String key = file.getFullPath().toPortableString();
		if (cache.containsKey(key))
			cache.remove(key);
	}
	
}