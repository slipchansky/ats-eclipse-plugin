package org.agileware.natural.common;

import org.agileware.natural.common.data.SnippetEntry;
import org.eclipse.core.internal.resources.Marker;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.core.ISourceRange;
import org.eclipse.jdt.core.ISourceReference;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.search.core.text.TextSearchMatchAccess;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.views.markers.MarkerViewUtil;

public class FileHyperlink implements IHyperlink {

	private Region region;
	private String text;
	private SnippetEntry entry;

	public FileHyperlink(String text, SnippetEntry entry, Region region) {
		this.entry = entry;
		this.region = region;
		this.text = text;

	}

	@Override
	public IRegion getHyperlinkRegion() {
		return region;
	}

	@Override
	public String getHyperlinkText() {
		return text;
	}

	@Override
	public String getTypeLabel() {
		return text;
	}
	
	public static class SnippetRange implements ISourceRange {
		private int offset;
		private int length;
		public SnippetRange (int offset, int length) {
			this.offset = offset;
			this.length  = length;
		}

		@Override
		public int getLength() {
			return length;
		}

		@Override
		public int getOffset() {
			return offset;
		}
		
	}
	
	public static class SnippetReference implements ISourceReference {
		
		private SnippetRange range;
		
		public SnippetReference (int offset, int length) {
			range = new SnippetRange (offset, length);
		}
		
		@Override
		public boolean exists() {
			return true;
		}

		@Override
		public ISourceRange getNameRange() throws JavaModelException {
			return range;
		}

		@Override
		public String getSource() throws JavaModelException {
			return "hidden source";
		}

		@Override
		public ISourceRange getSourceRange() throws JavaModelException {
			return range;
		}
	}

	@Override
	public void open() {
		final IEditorPart editorPart;
		try {
			IFile file = entry.getFile();

			editorPart = IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(), file, true);
			ITextEditor editor = (ITextEditor)editorPart;
			editor.selectAndReveal(entry.getOffset(), entry.getLength ());
			
//			final SnippetReference reference = new SnippetReference (entry.offset, entry.length);
//			new Thread () {
//				public void run() {
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					JavaUI.revealInEditor(editorPart, reference);
//				};
//			}.start();
			
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
