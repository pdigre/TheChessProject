/*
* generated by Xtext
*/
grammar InternalPSQT;

options {
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package no.pdigre.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package no.pdigre.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import no.pdigre.services.PSQTGrammarAccess;

}

@parser::members {

 	private PSQTGrammarAccess grammarAccess;
 	
    public InternalPSQTParser(TokenStream input, PSQTGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "PSQT_Model";	
   	}
   	
   	@Override
   	protected PSQTGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRulePSQT_Model
entryRulePSQT_Model returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getPSQT_ModelRule()); }
	 iv_rulePSQT_Model=rulePSQT_Model 
	 { $current=$iv_rulePSQT_Model.current; } 
	 EOF 
;

// Rule PSQT_Model
rulePSQT_Model returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getPSQT_ModelAccess().getFDescriptionParserRuleCall_0()); 
    }
    this_FDescription_0=ruleFDescription
    { 
        $current = $this_FDescription_0.current; 
        afterParserOrEnumRuleCall();
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getPSQT_ModelAccess().getTablesTableParserRuleCall_1_0()); 
	    }
		lv_tables_1_0=ruleTable		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPSQT_ModelRule());
	        }
       		add(
       			$current, 
       			"tables",
        		lv_tables_1_0, 
        		"Table");
	        afterParserOrEnumRuleCall();
	    }

)
)*)
;





// Entry rule entryRuleFDescription
entryRuleFDescription returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getFDescriptionRule()); }
	 iv_ruleFDescription=ruleFDescription 
	 { $current=$iv_ruleFDescription.current; } 
	 EOF 
;

// Rule FDescription
ruleFDescription returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(this_PSQT_0=RULE_PSQT
    { 
    newLeafNode(this_PSQT_0, grammarAccess.getFDescriptionAccess().getPSQTTerminalRuleCall_0()); 
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getFDescriptionAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getFDescriptionRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
)this_BASE_2=RULE_BASE
    { 
    newLeafNode(this_BASE_2, grammarAccess.getFDescriptionAccess().getBASETerminalRuleCall_2()); 
    }
(
(
		lv_base_3_0=RULE_INT
		{
			newLeafNode(lv_base_3_0, grammarAccess.getFDescriptionAccess().getBaseINTTerminalRuleCall_3_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getFDescriptionRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"base",
        		lv_base_3_0, 
        		"INT");
	    }

)
)this_MIDLIMIT_4=RULE_MIDLIMIT
    { 
    newLeafNode(this_MIDLIMIT_4, grammarAccess.getFDescriptionAccess().getMIDLIMITTerminalRuleCall_4()); 
    }
(
(
		lv_mgl_5_0=RULE_INT
		{
			newLeafNode(lv_mgl_5_0, grammarAccess.getFDescriptionAccess().getMglINTTerminalRuleCall_5_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getFDescriptionRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"mgl",
        		lv_mgl_5_0, 
        		"INT");
	    }

)
)this_ENDLIMIT_6=RULE_ENDLIMIT
    { 
    newLeafNode(this_ENDLIMIT_6, grammarAccess.getFDescriptionAccess().getENDLIMITTerminalRuleCall_6()); 
    }
(
(
		lv_egl_7_0=RULE_INT
		{
			newLeafNode(lv_egl_7_0, grammarAccess.getFDescriptionAccess().getEglINTTerminalRuleCall_7_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getFDescriptionRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"egl",
        		lv_egl_7_0, 
        		"INT");
	    }

)
))
;





// Entry rule entryRuleTable
entryRuleTable returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getTableRule()); }
	 iv_ruleTable=ruleTable 
	 { $current=$iv_ruleTable.current; } 
	 EOF 
;

// Rule Table
ruleTable returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getTableAccess().getTDescriptionParserRuleCall_0()); 
    }
    this_TDescription_0=ruleTDescription
    { 
        $current = $this_TDescription_0.current; 
        afterParserOrEnumRuleCall();
    }

    { 
        newCompositeNode(grammarAccess.getTableAccess().getTHeaderParserRuleCall_1()); 
    }
ruleTHeader
    { 
        afterParserOrEnumRuleCall();
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getTableAccess().getRRowParserRuleCall_2_0()); 
	    }
		lv_r_2_0=ruleRow		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTableRule());
	        }
       		add(
       			$current, 
       			"r",
        		lv_r_2_0, 
        		"Row");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getTableAccess().getRRowParserRuleCall_3_0()); 
	    }
		lv_r_3_0=ruleRow		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTableRule());
	        }
       		add(
       			$current, 
       			"r",
        		lv_r_3_0, 
        		"Row");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getTableAccess().getRRowParserRuleCall_4_0()); 
	    }
		lv_r_4_0=ruleRow		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTableRule());
	        }
       		add(
       			$current, 
       			"r",
        		lv_r_4_0, 
        		"Row");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getTableAccess().getRRowParserRuleCall_5_0()); 
	    }
		lv_r_5_0=ruleRow		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTableRule());
	        }
       		add(
       			$current, 
       			"r",
        		lv_r_5_0, 
        		"Row");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getTableAccess().getRRowParserRuleCall_6_0()); 
	    }
		lv_r_6_0=ruleRow		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTableRule());
	        }
       		add(
       			$current, 
       			"r",
        		lv_r_6_0, 
        		"Row");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getTableAccess().getRRowParserRuleCall_7_0()); 
	    }
		lv_r_7_0=ruleRow		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTableRule());
	        }
       		add(
       			$current, 
       			"r",
        		lv_r_7_0, 
        		"Row");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getTableAccess().getRRowParserRuleCall_8_0()); 
	    }
		lv_r_8_0=ruleRow		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTableRule());
	        }
       		add(
       			$current, 
       			"r",
        		lv_r_8_0, 
        		"Row");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getTableAccess().getRRowParserRuleCall_9_0()); 
	    }
		lv_r_9_0=ruleRow		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTableRule());
	        }
       		add(
       			$current, 
       			"r",
        		lv_r_9_0, 
        		"Row");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleTDescription
entryRuleTDescription returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getTDescriptionRule()); }
	 iv_ruleTDescription=ruleTDescription 
	 { $current=$iv_ruleTDescription.current; } 
	 EOF 
;

// Rule TDescription
ruleTDescription returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(this_PIECE_0=RULE_PIECE
    { 
    newLeafNode(this_PIECE_0, grammarAccess.getTDescriptionAccess().getPIECETerminalRuleCall_0()); 
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getTDescriptionAccess().getNamePieceTypeEnumRuleCall_1_0()); 
	    }
		lv_name_1_0=rulePieceType		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTDescriptionRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"PieceType");
	        afterParserOrEnumRuleCall();
	    }

)
)this_MIDGAME_2=RULE_MIDGAME
    { 
    newLeafNode(this_MIDGAME_2, grammarAccess.getTDescriptionAccess().getMIDGAMETerminalRuleCall_2()); 
    }
(
(
		lv_mg_3_0=RULE_INT
		{
			newLeafNode(lv_mg_3_0, grammarAccess.getTDescriptionAccess().getMgINTTerminalRuleCall_3_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getTDescriptionRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"mg",
        		lv_mg_3_0, 
        		"INT");
	    }

)
)this_ENDGAME_4=RULE_ENDGAME
    { 
    newLeafNode(this_ENDGAME_4, grammarAccess.getTDescriptionAccess().getENDGAMETerminalRuleCall_4()); 
    }
(
(
		lv_eg_5_0=RULE_INT
		{
			newLeafNode(lv_eg_5_0, grammarAccess.getTDescriptionAccess().getEgINTTerminalRuleCall_5_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getTDescriptionRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"eg",
        		lv_eg_5_0, 
        		"INT");
	    }

)
))
;





// Entry rule entryRuleTHeader
entryRuleTHeader returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getTHeaderRule()); } 
	 iv_ruleTHeader=ruleTHeader 
	 { $current=$iv_ruleTHeader.current.getText(); }  
	 EOF 
;

// Rule THeader
ruleTHeader returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	kw='A' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getTHeaderAccess().getAKeyword_0()); 
    }

	kw='B' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getTHeaderAccess().getBKeyword_1()); 
    }

	kw='C' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getTHeaderAccess().getCKeyword_2()); 
    }

	kw='D' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getTHeaderAccess().getDKeyword_3()); 
    }

	kw='E' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getTHeaderAccess().getEKeyword_4()); 
    }

	kw='F' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getTHeaderAccess().getFKeyword_5()); 
    }

	kw='G' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getTHeaderAccess().getGKeyword_6()); 
    }

	kw='H' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getTHeaderAccess().getHKeyword_7()); 
    }
)
    ;





// Entry rule entryRuleRow
entryRuleRow returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getRowRule()); }
	 iv_ruleRow=ruleRow 
	 { $current=$iv_ruleRow.current; } 
	 EOF 
;

// Rule Row
ruleRow returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getRowAccess().getNameRowLabelParserRuleCall_0_0()); 
	    }
		lv_name_0_0=ruleRowLabel		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getRowRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_0_0, 
        		"RowLabel");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getRowAccess().getMidrowMRowParserRuleCall_1_0()); 
	    }
		lv_midrow_1_0=ruleMRow		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getRowRule());
	        }
       		set(
       			$current, 
       			"midrow",
        		lv_midrow_1_0, 
        		"MRow");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getRowAccess().getEndrowMRowParserRuleCall_2_0()); 
	    }
		lv_endrow_2_0=ruleMRow		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getRowRule());
	        }
       		set(
       			$current, 
       			"endrow",
        		lv_endrow_2_0, 
        		"MRow");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleRowLabel
entryRuleRowLabel returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getRowLabelRule()); } 
	 iv_ruleRowLabel=ruleRowLabel 
	 { $current=$iv_ruleRowLabel.current.getText(); }  
	 EOF 
;

// Rule RowLabel
ruleRowLabel returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
    this_INT_0=RULE_INT    {
		$current.merge(this_INT_0);
    }

    { 
    newLeafNode(this_INT_0, grammarAccess.getRowLabelAccess().getINTTerminalRuleCall()); 
    }

    ;





// Entry rule entryRuleMRow
entryRuleMRow returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMRowRule()); }
	 iv_ruleMRow=ruleMRow 
	 { $current=$iv_ruleMRow.current; } 
	 EOF 
;

// Rule MRow
ruleMRow returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_c1_0_0=RULE_INT
		{
			newLeafNode(lv_c1_0_0, grammarAccess.getMRowAccess().getC1INTTerminalRuleCall_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMRowRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"c1",
        		lv_c1_0_0, 
        		"INT");
	    }

)
)(
(
		lv_c2_1_0=RULE_INT
		{
			newLeafNode(lv_c2_1_0, grammarAccess.getMRowAccess().getC2INTTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMRowRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"c2",
        		lv_c2_1_0, 
        		"INT");
	    }

)
)(
(
		lv_c3_2_0=RULE_INT
		{
			newLeafNode(lv_c3_2_0, grammarAccess.getMRowAccess().getC3INTTerminalRuleCall_2_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMRowRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"c3",
        		lv_c3_2_0, 
        		"INT");
	    }

)
)(
(
		lv_c4_3_0=RULE_INT
		{
			newLeafNode(lv_c4_3_0, grammarAccess.getMRowAccess().getC4INTTerminalRuleCall_3_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMRowRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"c4",
        		lv_c4_3_0, 
        		"INT");
	    }

)
)(
(
		lv_c5_4_0=RULE_INT
		{
			newLeafNode(lv_c5_4_0, grammarAccess.getMRowAccess().getC5INTTerminalRuleCall_4_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMRowRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"c5",
        		lv_c5_4_0, 
        		"INT");
	    }

)
)(
(
		lv_c6_5_0=RULE_INT
		{
			newLeafNode(lv_c6_5_0, grammarAccess.getMRowAccess().getC6INTTerminalRuleCall_5_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMRowRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"c6",
        		lv_c6_5_0, 
        		"INT");
	    }

)
)(
(
		lv_c7_6_0=RULE_INT
		{
			newLeafNode(lv_c7_6_0, grammarAccess.getMRowAccess().getC7INTTerminalRuleCall_6_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMRowRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"c7",
        		lv_c7_6_0, 
        		"INT");
	    }

)
)(
(
		lv_c8_7_0=RULE_INT
		{
			newLeafNode(lv_c8_7_0, grammarAccess.getMRowAccess().getC8INTTerminalRuleCall_7_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMRowRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"c8",
        		lv_c8_7_0, 
        		"INT");
	    }

)
))
;





// Rule PieceType
rulePieceType returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='Pawn' 
	{
        $current = grammarAccess.getPieceTypeAccess().getPAWNEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getPieceTypeAccess().getPAWNEnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='Knight' 
	{
        $current = grammarAccess.getPieceTypeAccess().getKNIGHTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getPieceTypeAccess().getKNIGHTEnumLiteralDeclaration_1()); 
    }
)
    |(	enumLiteral_2='Bishop' 
	{
        $current = grammarAccess.getPieceTypeAccess().getBISHOPEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getPieceTypeAccess().getBISHOPEnumLiteralDeclaration_2()); 
    }
)
    |(	enumLiteral_3='Rook' 
	{
        $current = grammarAccess.getPieceTypeAccess().getROOKEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_3, grammarAccess.getPieceTypeAccess().getROOKEnumLiteralDeclaration_3()); 
    }
)
    |(	enumLiteral_4='Queen' 
	{
        $current = grammarAccess.getPieceTypeAccess().getQUEENEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_4, grammarAccess.getPieceTypeAccess().getQUEENEnumLiteralDeclaration_4()); 
    }
)
    |(	enumLiteral_5='King' 
	{
        $current = grammarAccess.getPieceTypeAccess().getKINGEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_5, grammarAccess.getPieceTypeAccess().getKINGEnumLiteralDeclaration_5()); 
    }
));



RULE_INT : '-'? ('0'..'9')+;

RULE_PSQT : 'PSQT:';

RULE_BASE : 'Base:';

RULE_PIECE : 'Piece:';

RULE_MIDLIMIT : 'MidLimit:';

RULE_ENDLIMIT : 'EndLimit:';

RULE_MIDGAME : 'MidGame:';

RULE_ENDGAME : 'EndGame:';

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


