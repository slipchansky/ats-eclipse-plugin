package org.agileware.natural.common;

import java.util.List;

import org.eclipse.core.internal.events.ResourceDelta;
import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.core.ElementChangedEvent;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IElementChangedListener;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaElementDelta;

import com.google.inject.Inject;

public class JavaElementChangeReporter implements IElementChangedListener {
	
	@Inject
	private JavaAnnotationMatcher matcher;
	
	@Override
	public void elementChanged(ElementChangedEvent event) {
//		IResource resource = null;
//		try {
//			ResourceDelta d = (ResourceDelta)event.getDelta().getAffectedChildren()[0].getAffectedChildren()[0].getResourceDeltas()[0];
//			resource = d.getResource();
//		} catch (Throwable e) {
//			// TODO cope this case
//		}
//		if (resource != null) {
//			String fullPath = resource.getFullPath().toPortableString();
//			if (fullPath.endsWith(".f") || fullPath.endsWith(".feature")) {
//				// TODO improve it! you can rescan "resource" directly!
//				matcher.clearSnippetsCache(resource);
//			}
//		}
		traverse(event.getDelta(), null); //
	}

	void traverse(IJavaElementDelta delta, List<JavaHyperlink> hyperlinks) {
		if (delta.getElement().getElementType() == IJavaElement.COMPILATION_UNIT) {
			if ((delta.getFlags() & IJavaElementDelta.F_PRIMARY_RESOURCE) > 0) {
				matcher.evict((ICompilationUnit)delta.getElement());
			}
		}  
		
		for (IJavaElementDelta child : delta.getAffectedChildren()) {
			this.traverse(child, hyperlinks);
		}
	}
}