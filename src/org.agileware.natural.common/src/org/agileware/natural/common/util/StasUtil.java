package org.agileware.natural.common.util;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;

public class StasUtil {
	
	public static IFile toFile(String sPath) {
		IFile file;
		if (sPath.startsWith("/resource"))
			 sPath = sPath.substring ("/resource".length());
		Path path = new Path (sPath);
		IWorkspaceRoot workspace = ResourcesPlugin.getWorkspace().getRoot();
		file = workspace.getFile(path);
		return file;
	}

}
