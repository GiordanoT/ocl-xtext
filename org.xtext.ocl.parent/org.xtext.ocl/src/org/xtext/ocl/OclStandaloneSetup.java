/*
 * generated by Xtext 2.26.0-SNAPSHOT
 */
package org.xtext.ocl;


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
public class OclStandaloneSetup extends OclStandaloneSetupGenerated {

	public static void doSetup() {
		new OclStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}
