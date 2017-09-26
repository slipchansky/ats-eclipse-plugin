package org.agileware.natural.common.data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.agileware.natural.common.data.SnippetsCache.ListOfSnippets;

public class SnippetsCache  {
	public static class ListOfSnippets extends ArrayList<SnippetEntry> {}
	static ListOfSnippets EMPTY  = new ListOfSnippets (){

		@Override
		public SnippetEntry set(int index, SnippetEntry element) {
			return null;
		}

		@Override
		public boolean add(SnippetEntry e) {
			return false;
		}

		@Override
		public void add(int index, SnippetEntry element) {
		}

		@Override
		public SnippetEntry remove(int index) {
			return null;
		}
	};
	
	private Map<String, ListOfSnippets> snippets = new LinkedHashMap<String, ListOfSnippets> ();
	
	public void put (SnippetEntry snippet) {
		ListOfSnippets items = snippets.get(snippet.getAnnotationValue());
		if (items == null) {
			items = new ListOfSnippets();
			snippets.put(snippet.getAnnotationValue(), items);
		}
		items.add(snippet);
	}
	
	public ListOfSnippets getMatchedSnippets (String name) {
		name = name.trim();
		if (name.length()==0) {
			return allSnippets ();
		}
		
		ListOfSnippets items = snippets.get(name);
		if (items == null) return EMPTY;
		return items;
	}

	private ListOfSnippets allSnippets() {
		Set<Entry<String, ListOfSnippets>> entries = snippets.entrySet();
		ListOfSnippets result = new ListOfSnippets ();
		for (Entry<String, ListOfSnippets> e : entries) {
			result.addAll(e.getValue());
		}  
		return result;
	}

	public ListOfSnippets getAllSnippets() {
		ListOfSnippets result = new ListOfSnippets ();
		Set<Entry<String, ListOfSnippets>> entries = snippets.entrySet();
		for (Entry<String, ListOfSnippets> e : entries) {
			result.addAll (e.getValue());
		}
		return result;
	}
	 
	

}
