/*
* generated by Xtext
*/
package no.pdigre;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class PSQTStandaloneSetup extends PSQTStandaloneSetupGenerated{

	public static void doSetup() {
		new PSQTStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}
