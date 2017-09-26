package org.agileware.natural.common.data;

import java.util.ArrayList;

import org.agileware.natural.common.JavaAnnotationMatcher.MatchEntry;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.search.core.text.TextSearchMatchAccess;


/**
 * @author SLypchan
 *
 */
public class SnippetEntry extends MatchEntry<TextSearchMatchAccess> {
	
	
	String annotationValue;
	
	private IFile file;
	private int offset;
	private int length;
	private String text;
	private IProject project;

	public SnippetEntry(String annotationValue, TextSearchMatchAccess e) {
		super(e);
		this.annotationValue = annotationValue;
		this.project = e.getFile().getProject();
		this.file = e.getFile();
		this.offset = e.getMatchOffset();
		this.length = e.getMatchLength();
		this.text = e.getFileContent(offset, length);
	}
	
	



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annotationValue == null) ? 0 : annotationValue.hashCode());
		result = prime * result + ((file == null) ? 0 : file.getFullPath().hashCode());
		result = prime * result + length;
		result = prime * result + offset;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SnippetEntry other = (SnippetEntry) obj;
		if (annotationValue == null) {
			if (other.annotationValue != null)
				return false;
		} else if (!annotationValue.equals(other.annotationValue))
			return false;
		if (file == null) {
			if (other.file != null)
				return false;
		} else if (!file.getFullPath().equals(other.file.getFullPath()))
			return false;
		if (length != other.length)
			return false;
		if (offset != other.offset)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	public String getAnnotationValue() {
		return annotationValue;
	}

	public void setAnnotationValue(String annotationValue) {
		this.annotationValue = annotationValue;
	}

	public IFile getFile() {
		return file;
	}

	public int getOffset() {
		return offset;
	}

	public int getLength() {
		return length;
	}
	

	public void setOffset(int offset) {
		this.offset = offset;
	}





	public void setLength(int length) {
		this.length = length;
	}





	public String getText() {
		return text;
	}
	
	public IProject getProject() {
		return project;
	}

	@Override
	public String toString() {
		return annotationValue + "(" + file + ":=" + offset + ")";
	}
	

	

}
