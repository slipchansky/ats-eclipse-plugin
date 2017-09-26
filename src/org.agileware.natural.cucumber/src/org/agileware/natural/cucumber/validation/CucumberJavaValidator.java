package org.agileware.natural.cucumber.validation;

import org.agileware.natural.common.JavaAnnotationMatcher;
import org.agileware.natural.common.JavaAnnotationMatcher.MatchEntry;
import org.agileware.natural.common.JavaAnnotationMatcher.MethodMatchEntry;
import org.agileware.natural.common.SnippetsMatcher;
import org.agileware.natural.common.data.SnippetEntry;
import org.agileware.natural.common.util.StasUtil;
import org.agileware.natural.cucumber.cucumber.CucumberPackage;
import org.agileware.natural.cucumber.cucumber.Step;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.validation.Check;

import com.google.inject.Inject;

public class CucumberJavaValidator extends AbstractCucumberJavaValidator {
	
	@Inject
	private JavaAnnotationMatcher matcher;
	
	@Inject
	SnippetsMatcher snippetMatcher;
	
	public CucumberJavaValidator () {
	}
	
	@Check
	public void preStepMatching(org.agileware.natural.cucumber.cucumber.Feature feature) {
		Resource resource = feature.eResource();
		IFile file = null;
		if (resource != null) {
			file = StasUtil.toFile (resource.getURI().path());
			snippetMatcher.refresh(file);
		}
	}
	
	@Check
	public void checkStepMatching(Step step) {
		final Counter counter = new Counter();
		String description = step.getDescription().trim();
		
		Resource resource = step.eResource();
		
		IFile file = null;
		if (resource != null) {
			file = StasUtil.toFile (resource.getURI().path());
			snippetMatcher.refresh(file);
		}
		
		
		String snippetName = matcher.getSnippetName (description);
		if (snippetName != null && file != null) {
			if (!isSnippet (file, snippetName)) {
				if (description.equals ("@last")||description.equals("last;")||description.equals("last.")||description.startsWith("$") || description.startsWith("@$") ||  (description.startsWith("<") && (description.endsWith(">;") || description.endsWith(">.")) ) )
					warning("Snippet name substitution. Watch yourself! `" + description + "`", CucumberPackage.Literals.STEP__DESCRIPTION);
				else
					error("No snippet found `" + description + "`", CucumberPackage.Literals.STEP__DESCRIPTION);
				return;
			} 
			if (moreThanOneSnippet (file, snippetName)) {
				warning("More than one snippet found  `" + description + "`", CucumberPackage.Literals.STEP__DESCRIPTION);
			}
			return;
		} 
		
		matcher.findMatches(file, description, counter); // stas ? at autocomplete ?
		
		if (counter.get() == 0) {
			warning("No definition found for `" + description + "`", CucumberPackage.Literals.STEP__DESCRIPTION);
		} else if (counter.get() > 1) {
			warning("Multiple definitions found for `" + description + "`", CucumberPackage.Literals.STEP__DESCRIPTION);
		} 
		
	}



	private final static class Counter implements JavaAnnotationMatcher.Command {
		int methodCount = 0;
		int textCount = 0;
		
		public int get() {
			if (methodCount > 1 || textCount > 1) return methodCount+textCount;
			if (methodCount == 0 && textCount == 0) return 0;
			return 1;
		}
		
		public boolean noSnippets() {
			return textCount == 0;
		}

		public void match(String annotationValue, MatchEntry entry) {
			if (entry instanceof MethodMatchEntry)
				this.methodCount++;
			else
			if (entry instanceof SnippetEntry) {
				textCount ++;
			}
		}
		
		@Override
		public boolean matched() {
			return get() > 0;
		}
	}
	

	public boolean isSnippet(IFile file, String snippetName) {
		return !snippetMatcher.findSnippet (file, snippetName).isEmpty();
	}

	public boolean moreThanOneSnippet(IFile file, String snippetName) {
		return snippetMatcher.findSnippet (file, snippetName).size() > 1;
	}
	
	
	
	
//	@Override
//	protected final boolean internalValidate(EClass class1, EObject object, DiagnosticChain diagnostics,
//			Map<Object, Object> context) {
//		
//	}
	
}
