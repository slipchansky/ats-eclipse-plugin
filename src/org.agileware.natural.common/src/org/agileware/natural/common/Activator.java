package org.agileware.natural.common;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	/**
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
//		IWorkspace workspace = ResourcesPlugin.getWorkspace();
//		IResourceChangeListener listener = new IResourceChangeListener  () {
//
//			@Override
//			public void resourceChanged(IResourceChangeEvent resourseChangeEvent) {
//				IResourceDelta delta = resourseChangeEvent.getDelta();
//				int kind = delta.getKind();
//				int flags = delta.getFlags();
//				IResource resource = delta.getResource();
//				IResourceDelta[] affected = delta.getAffectedChildren();
//				IResourceDelta delta0 = affected [0];
//				int k0 = delta0.getKind ();
//				int f0 = delta0.getFlags();
//				int bk = resourseChangeEvent.getBuildKind();
//				
//				IPath path = delta.getFullPath();
//				IPath projectRelativePath = delta.getProjectRelativePath();
//				int k = 0;
//				k++;
//				
//			}
//			
//		};
//		workspace.addResourceChangeListener(listener);
	}

	/**
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
