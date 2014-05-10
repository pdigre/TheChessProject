/*
* generated by Xtext
*/
package no.pdigre.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import no.pdigre.services.PSQTGrammarAccess;

public class PSQTParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private PSQTGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected no.pdigre.parser.antlr.internal.InternalPSQTParser createParser(XtextTokenStream stream) {
		return new no.pdigre.parser.antlr.internal.InternalPSQTParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "Model";
	}
	
	public PSQTGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(PSQTGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
