package org.agileware.natural.cucumber.ui;

import org.agileware.natural.common.AbstractAnnotationDescriptor;
import org.agileware.natural.common.JavaElementChangeReporter;
import org.agileware.natural.common.SnippetsMatcher;
import org.agileware.natural.common.util.StasUtil;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jdt.core.ElementChangedEvent;
import org.eclipse.jdt.core.JavaCore;

import com.google.inject.Inject;

@SuppressWarnings("unused")
public class CucumberActivator extends org.agileware.natural.cucumber.ui.internal.CucumberActivator {
	
	@Inject
	SnippetsMatcher snippetMatcher;
	
	
	@Inject
	public void setJavaElementChangeReporter(JavaElementChangeReporter reporter) {
		// Listen to Java class changes
		JavaCore.addElementChangedListener(reporter, ElementChangedEvent.POST_CHANGE);
	}
	
	
}
