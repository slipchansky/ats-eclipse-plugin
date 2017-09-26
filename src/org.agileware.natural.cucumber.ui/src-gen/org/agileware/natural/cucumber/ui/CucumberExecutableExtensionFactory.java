/*
 * generated by Xtext
 */
package org.agileware.natural.cucumber.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import org.agileware.natural.cucumber.ui.internal.CucumberActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class CucumberExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return CucumberActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return CucumberActivator.getInstance().getInjector(CucumberActivator.ORG_AGILEWARE_NATURAL_CUCUMBER_CUCUMBER);
	}
	
}
