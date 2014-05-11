/*
* generated by Xtext
*/
package no.pdigre.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import no.pdigre.services.PSQTGrammarAccess;

public class PSQTParser extends AbstractContentAssistParser {
	
	@Inject
	private PSQTGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected no.pdigre.ui.contentassist.antlr.internal.InternalPSQTParser createParser() {
		no.pdigre.ui.contentassist.antlr.internal.InternalPSQTParser result = new no.pdigre.ui.contentassist.antlr.internal.InternalPSQTParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getPieceTypeAccess().getAlternatives(), "rule__PieceType__Alternatives");
					put(grammarAccess.getPSQT_ModelAccess().getGroup(), "rule__PSQT_Model__Group__0");
					put(grammarAccess.getFDescriptionAccess().getGroup(), "rule__FDescription__Group__0");
					put(grammarAccess.getTableAccess().getGroup(), "rule__Table__Group__0");
					put(grammarAccess.getTDescriptionAccess().getGroup(), "rule__TDescription__Group__0");
					put(grammarAccess.getTHeaderAccess().getGroup(), "rule__THeader__Group__0");
					put(grammarAccess.getRowAccess().getGroup(), "rule__Row__Group__0");
					put(grammarAccess.getMRowAccess().getGroup(), "rule__MRow__Group__0");
					put(grammarAccess.getERowAccess().getGroup(), "rule__ERow__Group__0");
					put(grammarAccess.getPSQT_ModelAccess().getTablesAssignment_1(), "rule__PSQT_Model__TablesAssignment_1");
					put(grammarAccess.getFDescriptionAccess().getNameAssignment_1(), "rule__FDescription__NameAssignment_1");
					put(grammarAccess.getFDescriptionAccess().getBaseAssignment_3(), "rule__FDescription__BaseAssignment_3");
					put(grammarAccess.getFDescriptionAccess().getMglAssignment_5(), "rule__FDescription__MglAssignment_5");
					put(grammarAccess.getFDescriptionAccess().getEglAssignment_7(), "rule__FDescription__EglAssignment_7");
					put(grammarAccess.getTableAccess().getRAssignment_2(), "rule__Table__RAssignment_2");
					put(grammarAccess.getTableAccess().getRAssignment_3(), "rule__Table__RAssignment_3");
					put(grammarAccess.getTableAccess().getRAssignment_4(), "rule__Table__RAssignment_4");
					put(grammarAccess.getTableAccess().getRAssignment_5(), "rule__Table__RAssignment_5");
					put(grammarAccess.getTableAccess().getRAssignment_6(), "rule__Table__RAssignment_6");
					put(grammarAccess.getTableAccess().getRAssignment_7(), "rule__Table__RAssignment_7");
					put(grammarAccess.getTableAccess().getRAssignment_8(), "rule__Table__RAssignment_8");
					put(grammarAccess.getTableAccess().getRAssignment_9(), "rule__Table__RAssignment_9");
					put(grammarAccess.getTDescriptionAccess().getNameAssignment_1(), "rule__TDescription__NameAssignment_1");
					put(grammarAccess.getTDescriptionAccess().getMgAssignment_3(), "rule__TDescription__MgAssignment_3");
					put(grammarAccess.getTDescriptionAccess().getEgAssignment_5(), "rule__TDescription__EgAssignment_5");
					put(grammarAccess.getRowAccess().getNameAssignment_0(), "rule__Row__NameAssignment_0");
					put(grammarAccess.getRowAccess().getMidrowAssignment_1(), "rule__Row__MidrowAssignment_1");
					put(grammarAccess.getRowAccess().getEndrowAssignment_2(), "rule__Row__EndrowAssignment_2");
					put(grammarAccess.getMRowAccess().getC1Assignment_0(), "rule__MRow__C1Assignment_0");
					put(grammarAccess.getMRowAccess().getC2Assignment_1(), "rule__MRow__C2Assignment_1");
					put(grammarAccess.getMRowAccess().getC3Assignment_2(), "rule__MRow__C3Assignment_2");
					put(grammarAccess.getMRowAccess().getC4Assignment_3(), "rule__MRow__C4Assignment_3");
					put(grammarAccess.getMRowAccess().getC5Assignment_4(), "rule__MRow__C5Assignment_4");
					put(grammarAccess.getMRowAccess().getC6Assignment_5(), "rule__MRow__C6Assignment_5");
					put(grammarAccess.getMRowAccess().getC7Assignment_6(), "rule__MRow__C7Assignment_6");
					put(grammarAccess.getMRowAccess().getC8Assignment_7(), "rule__MRow__C8Assignment_7");
					put(grammarAccess.getERowAccess().getC1Assignment_0(), "rule__ERow__C1Assignment_0");
					put(grammarAccess.getERowAccess().getC2Assignment_1(), "rule__ERow__C2Assignment_1");
					put(grammarAccess.getERowAccess().getC3Assignment_2(), "rule__ERow__C3Assignment_2");
					put(grammarAccess.getERowAccess().getC4Assignment_3(), "rule__ERow__C4Assignment_3");
					put(grammarAccess.getERowAccess().getC5Assignment_4(), "rule__ERow__C5Assignment_4");
					put(grammarAccess.getERowAccess().getC6Assignment_5(), "rule__ERow__C6Assignment_5");
					put(grammarAccess.getERowAccess().getC7Assignment_6(), "rule__ERow__C7Assignment_6");
					put(grammarAccess.getERowAccess().getC8Assignment_7(), "rule__ERow__C8Assignment_7");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			no.pdigre.ui.contentassist.antlr.internal.InternalPSQTParser typedParser = (no.pdigre.ui.contentassist.antlr.internal.InternalPSQTParser) parser;
			typedParser.entryRulePSQT_Model();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public PSQTGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(PSQTGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
