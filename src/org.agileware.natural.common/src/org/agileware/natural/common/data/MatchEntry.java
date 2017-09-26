package org.agileware.natural.common.data;

public class MatchEntry<T> {
	T entry;

	public MatchEntry(T e) {
		this.entry = e;
	}

	public T getEntry() {
		return entry;
	}
}
