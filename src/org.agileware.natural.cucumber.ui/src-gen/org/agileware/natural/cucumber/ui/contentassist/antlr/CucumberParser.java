/*
 * generated by Xtext
 */
package org.agileware.natural.cucumber.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.agileware.natural.cucumber.services.CucumberGrammarAccess;

public class CucumberParser extends AbstractContentAssistParser {
	
	@Inject
	private CucumberGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected org.agileware.natural.cucumber.ui.contentassist.antlr.internal.InternalCucumberParser createParser() {
		org.agileware.natural.cucumber.ui.contentassist.antlr.internal.InternalCucumberParser result = new org.agileware.natural.cucumber.ui.contentassist.antlr.internal.InternalCucumberParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getFeatureAccess().getScenariosAlternatives_6_0(), "rule__Feature__ScenariosAlternatives_6_0");
					put(grammarAccess.getTitleAccess().getAlternatives_0(), "rule__Title__Alternatives_0");
					put(grammarAccess.getTitleAccess().getAlternatives_1(), "rule__Title__Alternatives_1");
					put(grammarAccess.getNarrativeAccess().getAlternatives_0(), "rule__Narrative__Alternatives_0");
					put(grammarAccess.getNarrativeAccess().getAlternatives_1(), "rule__Narrative__Alternatives_1");
					put(grammarAccess.getStepDescriptionAccess().getAlternatives(), "rule__StepDescription__Alternatives");
					put(grammarAccess.getFeatureAccess().getGroup(), "rule__Feature__Group__0");
					put(grammarAccess.getBackgroundAccess().getGroup(), "rule__Background__Group__0");
					put(grammarAccess.getScenarioAccess().getGroup(), "rule__Scenario__Group__0");
					put(grammarAccess.getScenarioOutlineAccess().getGroup(), "rule__ScenarioOutline__Group__0");
					put(grammarAccess.getStepAccess().getGroup(), "rule__Step__Group__0");
					put(grammarAccess.getExamplesAccess().getGroup(), "rule__Examples__Group__0");
					put(grammarAccess.getTableAccess().getGroup(), "rule__Table__Group__0");
					put(grammarAccess.getDocStringAccess().getGroup(), "rule__DocString__Group__0");
					put(grammarAccess.getTitleAccess().getGroup(), "rule__Title__Group__0");
					put(grammarAccess.getNarrativeAccess().getGroup(), "rule__Narrative__Group__0");
					put(grammarAccess.getTagAccess().getGroup(), "rule__Tag__Group__0");
					put(grammarAccess.getFeatureAccess().getTagsAssignment_0(), "rule__Feature__TagsAssignment_0");
					put(grammarAccess.getFeatureAccess().getTitleAssignment_2(), "rule__Feature__TitleAssignment_2");
					put(grammarAccess.getFeatureAccess().getNarrativeAssignment_4(), "rule__Feature__NarrativeAssignment_4");
					put(grammarAccess.getFeatureAccess().getBackgroundAssignment_5(), "rule__Feature__BackgroundAssignment_5");
					put(grammarAccess.getFeatureAccess().getScenariosAssignment_6(), "rule__Feature__ScenariosAssignment_6");
					put(grammarAccess.getBackgroundAccess().getTitleAssignment_1(), "rule__Background__TitleAssignment_1");
					put(grammarAccess.getBackgroundAccess().getNarrativeAssignment_3(), "rule__Background__NarrativeAssignment_3");
					put(grammarAccess.getBackgroundAccess().getStepsAssignment_4(), "rule__Background__StepsAssignment_4");
					put(grammarAccess.getScenarioAccess().getTagsAssignment_0(), "rule__Scenario__TagsAssignment_0");
					put(grammarAccess.getScenarioAccess().getTitleAssignment_2(), "rule__Scenario__TitleAssignment_2");
					put(grammarAccess.getScenarioAccess().getNarrativeAssignment_4(), "rule__Scenario__NarrativeAssignment_4");
					put(grammarAccess.getScenarioAccess().getStepsAssignment_5(), "rule__Scenario__StepsAssignment_5");
					put(grammarAccess.getScenarioOutlineAccess().getTagsAssignment_0(), "rule__ScenarioOutline__TagsAssignment_0");
					put(grammarAccess.getScenarioOutlineAccess().getTitleAssignment_2(), "rule__ScenarioOutline__TitleAssignment_2");
					put(grammarAccess.getScenarioOutlineAccess().getNarrativeAssignment_4(), "rule__ScenarioOutline__NarrativeAssignment_4");
					put(grammarAccess.getScenarioOutlineAccess().getStepsAssignment_5(), "rule__ScenarioOutline__StepsAssignment_5");
					put(grammarAccess.getScenarioOutlineAccess().getExamplesAssignment_6(), "rule__ScenarioOutline__ExamplesAssignment_6");
					put(grammarAccess.getStepAccess().getDescriptionAssignment_1(), "rule__Step__DescriptionAssignment_1");
					put(grammarAccess.getStepAccess().getTablesAssignment_3(), "rule__Step__TablesAssignment_3");
					put(grammarAccess.getStepAccess().getCodeAssignment_4(), "rule__Step__CodeAssignment_4");
					put(grammarAccess.getStepAccess().getTablesAssignment_5(), "rule__Step__TablesAssignment_5");
					put(grammarAccess.getExamplesAccess().getTitleAssignment_1(), "rule__Examples__TitleAssignment_1");
					put(grammarAccess.getExamplesAccess().getNarrativeAssignment_3(), "rule__Examples__NarrativeAssignment_3");
					put(grammarAccess.getExamplesAccess().getTableAssignment_4(), "rule__Examples__TableAssignment_4");
					put(grammarAccess.getTableAccess().getRowsAssignment_0(), "rule__Table__RowsAssignment_0");
					put(grammarAccess.getDocStringAccess().getContentAssignment_0(), "rule__DocString__ContentAssignment_0");
					put(grammarAccess.getTagAccess().getIdAssignment_0(), "rule__Tag__IdAssignment_0");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.agileware.natural.cucumber.ui.contentassist.antlr.internal.InternalCucumberParser typedParser = (org.agileware.natural.cucumber.ui.contentassist.antlr.internal.InternalCucumberParser) parser;
			typedParser.entryRuleFeature();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_SL_COMMENT" };
	}
	
	public CucumberGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(CucumberGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
