/*
 * generated by Xtext
 */
package org.agileware.natural.cucumber;

import org.eclipse.xtext.junit4.IInjectorProvider;

import com.google.inject.Injector;

public class CucumberUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return org.agileware.natural.cucumber.ui.internal.CucumberActivator.getInstance().getInjector("org.agileware.natural.cucumber.Cucumber");
	}

}
