/*
* generated by Xtext
*/
package no.pdigre.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.xtext.common.services.TerminalsGrammarAccess;

@Singleton
public class PSQTGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class ModelElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Model");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cFDescriptionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Assignment cTablesAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cTablesTableParserRuleCall_1_0 = (RuleCall)cTablesAssignment_1.eContents().get(0);
		
		//Model:
		//	FDescription tables+=Table*;
		public ParserRule getRule() { return rule; }

		//FDescription tables+=Table*
		public Group getGroup() { return cGroup; }

		//FDescription
		public RuleCall getFDescriptionParserRuleCall_0() { return cFDescriptionParserRuleCall_0; }

		//tables+=Table*
		public Assignment getTablesAssignment_1() { return cTablesAssignment_1; }

		//Table
		public RuleCall getTablesTableParserRuleCall_1_0() { return cTablesTableParserRuleCall_1_0; }
	}

	public class FDescriptionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "FDescription");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cPSQTTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final RuleCall cBASETerminalRuleCall_2 = (RuleCall)cGroup.eContents().get(2);
		private final Assignment cBaseAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cBaseINTTerminalRuleCall_3_0 = (RuleCall)cBaseAssignment_3.eContents().get(0);
		private final RuleCall cMIDLIMITTerminalRuleCall_4 = (RuleCall)cGroup.eContents().get(4);
		private final Assignment cMglAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cMglINTTerminalRuleCall_5_0 = (RuleCall)cMglAssignment_5.eContents().get(0);
		private final RuleCall cENDLIMITTerminalRuleCall_6 = (RuleCall)cGroup.eContents().get(6);
		private final Assignment cEglAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final RuleCall cEglINTTerminalRuleCall_7_0 = (RuleCall)cEglAssignment_7.eContents().get(0);
		
		////enum RowNumber : R1='1'|R2='2'|R3='3'|R4='4'|R5='5'|R6='6'|R7='7'|R8='8';
		//FDescription:
		//	PSQT name=ID BASE base=INT MIDLIMIT mgl=INT ENDLIMIT egl=INT;
		public ParserRule getRule() { return rule; }

		//PSQT name=ID BASE base=INT MIDLIMIT mgl=INT ENDLIMIT egl=INT
		public Group getGroup() { return cGroup; }

		//PSQT
		public RuleCall getPSQTTerminalRuleCall_0() { return cPSQTTerminalRuleCall_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//BASE
		public RuleCall getBASETerminalRuleCall_2() { return cBASETerminalRuleCall_2; }

		//base=INT
		public Assignment getBaseAssignment_3() { return cBaseAssignment_3; }

		//INT
		public RuleCall getBaseINTTerminalRuleCall_3_0() { return cBaseINTTerminalRuleCall_3_0; }

		//MIDLIMIT
		public RuleCall getMIDLIMITTerminalRuleCall_4() { return cMIDLIMITTerminalRuleCall_4; }

		//mgl=INT
		public Assignment getMglAssignment_5() { return cMglAssignment_5; }

		//INT
		public RuleCall getMglINTTerminalRuleCall_5_0() { return cMglINTTerminalRuleCall_5_0; }

		//ENDLIMIT
		public RuleCall getENDLIMITTerminalRuleCall_6() { return cENDLIMITTerminalRuleCall_6; }

		//egl=INT
		public Assignment getEglAssignment_7() { return cEglAssignment_7; }

		//INT
		public RuleCall getEglINTTerminalRuleCall_7_0() { return cEglINTTerminalRuleCall_7_0; }
	}

	public class TableElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Table");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cTDescriptionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final RuleCall cTHeaderParserRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Assignment cRAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cRRowParserRuleCall_2_0 = (RuleCall)cRAssignment_2.eContents().get(0);
		private final Assignment cRAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cRRowParserRuleCall_3_0 = (RuleCall)cRAssignment_3.eContents().get(0);
		private final Assignment cRAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cRRowParserRuleCall_4_0 = (RuleCall)cRAssignment_4.eContents().get(0);
		private final Assignment cRAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cRRowParserRuleCall_5_0 = (RuleCall)cRAssignment_5.eContents().get(0);
		private final Assignment cRAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cRRowParserRuleCall_6_0 = (RuleCall)cRAssignment_6.eContents().get(0);
		private final Assignment cRAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final RuleCall cRRowParserRuleCall_7_0 = (RuleCall)cRAssignment_7.eContents().get(0);
		private final Assignment cRAssignment_8 = (Assignment)cGroup.eContents().get(8);
		private final RuleCall cRRowParserRuleCall_8_0 = (RuleCall)cRAssignment_8.eContents().get(0);
		private final Assignment cRAssignment_9 = (Assignment)cGroup.eContents().get(9);
		private final RuleCall cRRowParserRuleCall_9_0 = (RuleCall)cRAssignment_9.eContents().get(0);
		
		//Table:
		//	TDescription THeader r+=Row r+=Row r+=Row r+=Row r+=Row r+=Row r+=Row r+=Row;
		public ParserRule getRule() { return rule; }

		//TDescription THeader r+=Row r+=Row r+=Row r+=Row r+=Row r+=Row r+=Row r+=Row
		public Group getGroup() { return cGroup; }

		//TDescription
		public RuleCall getTDescriptionParserRuleCall_0() { return cTDescriptionParserRuleCall_0; }

		//THeader
		public RuleCall getTHeaderParserRuleCall_1() { return cTHeaderParserRuleCall_1; }

		//r+=Row
		public Assignment getRAssignment_2() { return cRAssignment_2; }

		//Row
		public RuleCall getRRowParserRuleCall_2_0() { return cRRowParserRuleCall_2_0; }

		//r+=Row
		public Assignment getRAssignment_3() { return cRAssignment_3; }

		//Row
		public RuleCall getRRowParserRuleCall_3_0() { return cRRowParserRuleCall_3_0; }

		//r+=Row
		public Assignment getRAssignment_4() { return cRAssignment_4; }

		//Row
		public RuleCall getRRowParserRuleCall_4_0() { return cRRowParserRuleCall_4_0; }

		//r+=Row
		public Assignment getRAssignment_5() { return cRAssignment_5; }

		//Row
		public RuleCall getRRowParserRuleCall_5_0() { return cRRowParserRuleCall_5_0; }

		//r+=Row
		public Assignment getRAssignment_6() { return cRAssignment_6; }

		//Row
		public RuleCall getRRowParserRuleCall_6_0() { return cRRowParserRuleCall_6_0; }

		//r+=Row
		public Assignment getRAssignment_7() { return cRAssignment_7; }

		//Row
		public RuleCall getRRowParserRuleCall_7_0() { return cRRowParserRuleCall_7_0; }

		//r+=Row
		public Assignment getRAssignment_8() { return cRAssignment_8; }

		//Row
		public RuleCall getRRowParserRuleCall_8_0() { return cRRowParserRuleCall_8_0; }

		//r+=Row
		public Assignment getRAssignment_9() { return cRAssignment_9; }

		//Row
		public RuleCall getRRowParserRuleCall_9_0() { return cRRowParserRuleCall_9_0; }
	}

	public class TDescriptionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "TDescription");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cPIECETerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNamePieceTypeEnumRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final RuleCall cMIDGAMETerminalRuleCall_2 = (RuleCall)cGroup.eContents().get(2);
		private final Assignment cMgAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cMgINTTerminalRuleCall_3_0 = (RuleCall)cMgAssignment_3.eContents().get(0);
		private final RuleCall cENDGAMETerminalRuleCall_4 = (RuleCall)cGroup.eContents().get(4);
		private final Assignment cEgAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cEgINTTerminalRuleCall_5_0 = (RuleCall)cEgAssignment_5.eContents().get(0);
		
		//TDescription:
		//	PIECE name=PieceType MIDGAME mg=INT ENDGAME eg=INT;
		public ParserRule getRule() { return rule; }

		//PIECE name=PieceType MIDGAME mg=INT ENDGAME eg=INT
		public Group getGroup() { return cGroup; }

		//PIECE
		public RuleCall getPIECETerminalRuleCall_0() { return cPIECETerminalRuleCall_0; }

		//name=PieceType
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//PieceType
		public RuleCall getNamePieceTypeEnumRuleCall_1_0() { return cNamePieceTypeEnumRuleCall_1_0; }

		//MIDGAME
		public RuleCall getMIDGAMETerminalRuleCall_2() { return cMIDGAMETerminalRuleCall_2; }

		//mg=INT
		public Assignment getMgAssignment_3() { return cMgAssignment_3; }

		//INT
		public RuleCall getMgINTTerminalRuleCall_3_0() { return cMgINTTerminalRuleCall_3_0; }

		//ENDGAME
		public RuleCall getENDGAMETerminalRuleCall_4() { return cENDGAMETerminalRuleCall_4; }

		//eg=INT
		public Assignment getEgAssignment_5() { return cEgAssignment_5; }

		//INT
		public RuleCall getEgINTTerminalRuleCall_5_0() { return cEgINTTerminalRuleCall_5_0; }
	}

	public class THeaderElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "THeader");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cAKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cBKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cCKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cDKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Keyword cEKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Keyword cFKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Keyword cGKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Keyword cHKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//THeader:
		//	"A" "B" "C" "D" "E" "F" "G" "H";
		public ParserRule getRule() { return rule; }

		//"A" "B" "C" "D" "E" "F" "G" "H"
		public Group getGroup() { return cGroup; }

		//"A"
		public Keyword getAKeyword_0() { return cAKeyword_0; }

		//"B"
		public Keyword getBKeyword_1() { return cBKeyword_1; }

		//"C"
		public Keyword getCKeyword_2() { return cCKeyword_2; }

		//"D"
		public Keyword getDKeyword_3() { return cDKeyword_3; }

		//"E"
		public Keyword getEKeyword_4() { return cEKeyword_4; }

		//"F"
		public Keyword getFKeyword_5() { return cFKeyword_5; }

		//"G"
		public Keyword getGKeyword_6() { return cGKeyword_6; }

		//"H"
		public Keyword getHKeyword_7() { return cHKeyword_7; }
	}

	public class RowElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Row");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameRowLabelParserRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Assignment cMAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cMMRowParserRuleCall_1_0 = (RuleCall)cMAssignment_1.eContents().get(0);
		private final Assignment cEAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cEERowParserRuleCall_2_0 = (RuleCall)cEAssignment_2.eContents().get(0);
		
		//Row:
		//	name=RowLabel m=MRow e=ERow;
		public ParserRule getRule() { return rule; }

		//name=RowLabel m=MRow e=ERow
		public Group getGroup() { return cGroup; }

		//name=RowLabel
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//RowLabel
		public RuleCall getNameRowLabelParserRuleCall_0_0() { return cNameRowLabelParserRuleCall_0_0; }

		//m=MRow
		public Assignment getMAssignment_1() { return cMAssignment_1; }

		//MRow
		public RuleCall getMMRowParserRuleCall_1_0() { return cMMRowParserRuleCall_1_0; }

		//e=ERow
		public Assignment getEAssignment_2() { return cEAssignment_2; }

		//ERow
		public RuleCall getEERowParserRuleCall_2_0() { return cEERowParserRuleCall_2_0; }
	}

	public class RowLabelElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "RowLabel");
		private final RuleCall cINTTerminalRuleCall = (RuleCall)rule.eContents().get(1);
		
		//RowLabel returns ecore::EString:
		//	INT;
		public ParserRule getRule() { return rule; }

		//INT
		public RuleCall getINTTerminalRuleCall() { return cINTTerminalRuleCall; }
	}

	public class MRowElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "MRow");
		private final Assignment cNameAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cNameRow1ParserRuleCall_0 = (RuleCall)cNameAssignment.eContents().get(0);
		
		//MRow:
		//	name=Row1;
		public ParserRule getRule() { return rule; }

		//name=Row1
		public Assignment getNameAssignment() { return cNameAssignment; }

		//Row1
		public RuleCall getNameRow1ParserRuleCall_0() { return cNameRow1ParserRuleCall_0; }
	}

	public class ERowElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ERow");
		private final Assignment cNameAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cNameRow1ParserRuleCall_0 = (RuleCall)cNameAssignment.eContents().get(0);
		
		//ERow:
		//	name=Row1;
		public ParserRule getRule() { return rule; }

		//name=Row1
		public Assignment getNameAssignment() { return cNameAssignment; }

		//Row1
		public RuleCall getNameRow1ParserRuleCall_0() { return cNameRow1ParserRuleCall_0; }
	}

	public class Row1Elements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Row1");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cCAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cCINTTerminalRuleCall_0_0 = (RuleCall)cCAssignment_0.eContents().get(0);
		private final Assignment cCAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cCINTTerminalRuleCall_1_0 = (RuleCall)cCAssignment_1.eContents().get(0);
		private final Assignment cCAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cCINTTerminalRuleCall_2_0 = (RuleCall)cCAssignment_2.eContents().get(0);
		private final Assignment cCAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cCINTTerminalRuleCall_3_0 = (RuleCall)cCAssignment_3.eContents().get(0);
		private final Assignment cCAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cCINTTerminalRuleCall_4_0 = (RuleCall)cCAssignment_4.eContents().get(0);
		private final Assignment cCAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cCINTTerminalRuleCall_5_0 = (RuleCall)cCAssignment_5.eContents().get(0);
		private final Assignment cCAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cCINTTerminalRuleCall_6_0 = (RuleCall)cCAssignment_6.eContents().get(0);
		private final Assignment cCAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final RuleCall cCINTTerminalRuleCall_7_0 = (RuleCall)cCAssignment_7.eContents().get(0);
		
		//Row1:
		//	c+=INT c+=INT c+=INT c+=INT c+=INT c+=INT c+=INT c+=INT;
		public ParserRule getRule() { return rule; }

		//c+=INT c+=INT c+=INT c+=INT c+=INT c+=INT c+=INT c+=INT
		public Group getGroup() { return cGroup; }

		//c+=INT
		public Assignment getCAssignment_0() { return cCAssignment_0; }

		//INT
		public RuleCall getCINTTerminalRuleCall_0_0() { return cCINTTerminalRuleCall_0_0; }

		//c+=INT
		public Assignment getCAssignment_1() { return cCAssignment_1; }

		//INT
		public RuleCall getCINTTerminalRuleCall_1_0() { return cCINTTerminalRuleCall_1_0; }

		//c+=INT
		public Assignment getCAssignment_2() { return cCAssignment_2; }

		//INT
		public RuleCall getCINTTerminalRuleCall_2_0() { return cCINTTerminalRuleCall_2_0; }

		//c+=INT
		public Assignment getCAssignment_3() { return cCAssignment_3; }

		//INT
		public RuleCall getCINTTerminalRuleCall_3_0() { return cCINTTerminalRuleCall_3_0; }

		//c+=INT
		public Assignment getCAssignment_4() { return cCAssignment_4; }

		//INT
		public RuleCall getCINTTerminalRuleCall_4_0() { return cCINTTerminalRuleCall_4_0; }

		//c+=INT
		public Assignment getCAssignment_5() { return cCAssignment_5; }

		//INT
		public RuleCall getCINTTerminalRuleCall_5_0() { return cCINTTerminalRuleCall_5_0; }

		//c+=INT
		public Assignment getCAssignment_6() { return cCAssignment_6; }

		//INT
		public RuleCall getCINTTerminalRuleCall_6_0() { return cCINTTerminalRuleCall_6_0; }

		//c+=INT
		public Assignment getCAssignment_7() { return cCAssignment_7; }

		//INT
		public RuleCall getCINTTerminalRuleCall_7_0() { return cCINTTerminalRuleCall_7_0; }
	}
	
	
	public class PieceTypeElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "PieceType");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cPAWNEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cPAWNPawnKeyword_0_0 = (Keyword)cPAWNEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cKNIGHTEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cKNIGHTKnightKeyword_1_0 = (Keyword)cKNIGHTEnumLiteralDeclaration_1.eContents().get(0);
		private final EnumLiteralDeclaration cBISHOPEnumLiteralDeclaration_2 = (EnumLiteralDeclaration)cAlternatives.eContents().get(2);
		private final Keyword cBISHOPBishopKeyword_2_0 = (Keyword)cBISHOPEnumLiteralDeclaration_2.eContents().get(0);
		private final EnumLiteralDeclaration cROOKEnumLiteralDeclaration_3 = (EnumLiteralDeclaration)cAlternatives.eContents().get(3);
		private final Keyword cROOKRookKeyword_3_0 = (Keyword)cROOKEnumLiteralDeclaration_3.eContents().get(0);
		private final EnumLiteralDeclaration cQUEENEnumLiteralDeclaration_4 = (EnumLiteralDeclaration)cAlternatives.eContents().get(4);
		private final Keyword cQUEENQueenKeyword_4_0 = (Keyword)cQUEENEnumLiteralDeclaration_4.eContents().get(0);
		private final EnumLiteralDeclaration cKINGEnumLiteralDeclaration_5 = (EnumLiteralDeclaration)cAlternatives.eContents().get(5);
		private final Keyword cKINGKingKeyword_5_0 = (Keyword)cKINGEnumLiteralDeclaration_5.eContents().get(0);
		
		//enum PieceType:
		//	PAWN="Pawn" | KNIGHT="Knight" | BISHOP="Bishop" | ROOK="Rook" | QUEEN="Queen" | KING="King";
		public EnumRule getRule() { return rule; }

		//PAWN="Pawn" | KNIGHT="Knight" | BISHOP="Bishop" | ROOK="Rook" | QUEEN="Queen" | KING="King"
		public Alternatives getAlternatives() { return cAlternatives; }

		//PAWN="Pawn"
		public EnumLiteralDeclaration getPAWNEnumLiteralDeclaration_0() { return cPAWNEnumLiteralDeclaration_0; }

		//"Pawn"
		public Keyword getPAWNPawnKeyword_0_0() { return cPAWNPawnKeyword_0_0; }

		//KNIGHT="Knight"
		public EnumLiteralDeclaration getKNIGHTEnumLiteralDeclaration_1() { return cKNIGHTEnumLiteralDeclaration_1; }

		//"Knight"
		public Keyword getKNIGHTKnightKeyword_1_0() { return cKNIGHTKnightKeyword_1_0; }

		//BISHOP="Bishop"
		public EnumLiteralDeclaration getBISHOPEnumLiteralDeclaration_2() { return cBISHOPEnumLiteralDeclaration_2; }

		//"Bishop"
		public Keyword getBISHOPBishopKeyword_2_0() { return cBISHOPBishopKeyword_2_0; }

		//ROOK="Rook"
		public EnumLiteralDeclaration getROOKEnumLiteralDeclaration_3() { return cROOKEnumLiteralDeclaration_3; }

		//"Rook"
		public Keyword getROOKRookKeyword_3_0() { return cROOKRookKeyword_3_0; }

		//QUEEN="Queen"
		public EnumLiteralDeclaration getQUEENEnumLiteralDeclaration_4() { return cQUEENEnumLiteralDeclaration_4; }

		//"Queen"
		public Keyword getQUEENQueenKeyword_4_0() { return cQUEENQueenKeyword_4_0; }

		//KING="King"
		public EnumLiteralDeclaration getKINGEnumLiteralDeclaration_5() { return cKINGEnumLiteralDeclaration_5; }

		//"King"
		public Keyword getKINGKingKeyword_5_0() { return cKINGKingKeyword_5_0; }
	}
	
	private ModelElements pModel;
	private PieceTypeElements unknownRulePieceType;
	private FDescriptionElements pFDescription;
	private TableElements pTable;
	private TDescriptionElements pTDescription;
	private THeaderElements pTHeader;
	private RowElements pRow;
	private RowLabelElements pRowLabel;
	private MRowElements pMRow;
	private ERowElements pERow;
	private Row1Elements pRow1;
	private TerminalRule tINT;
	private TerminalRule tPSQT;
	private TerminalRule tBASE;
	private TerminalRule tPIECE;
	private TerminalRule tMIDLIMIT;
	private TerminalRule tENDLIMIT;
	private TerminalRule tMIDGAME;
	private TerminalRule tENDGAME;
	
	private final Grammar grammar;

	private TerminalsGrammarAccess gaTerminals;

	@Inject
	public PSQTGrammarAccess(GrammarProvider grammarProvider,
		TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("no.pdigre.PSQT".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	
	public Grammar getGrammar() {
		return grammar;
	}
	

	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//Model:
	//	FDescription tables+=Table*;
	public ModelElements getModelAccess() {
		return (pModel != null) ? pModel : (pModel = new ModelElements());
	}
	
	public ParserRule getModelRule() {
		return getModelAccess().getRule();
	}

	//enum PieceType:
	//	PAWN="Pawn" | KNIGHT="Knight" | BISHOP="Bishop" | ROOK="Rook" | QUEEN="Queen" | KING="King";
	public PieceTypeElements getPieceTypeAccess() {
		return (unknownRulePieceType != null) ? unknownRulePieceType : (unknownRulePieceType = new PieceTypeElements());
	}
	
	public EnumRule getPieceTypeRule() {
		return getPieceTypeAccess().getRule();
	}

	////enum RowNumber : R1='1'|R2='2'|R3='3'|R4='4'|R5='5'|R6='6'|R7='7'|R8='8';
	//FDescription:
	//	PSQT name=ID BASE base=INT MIDLIMIT mgl=INT ENDLIMIT egl=INT;
	public FDescriptionElements getFDescriptionAccess() {
		return (pFDescription != null) ? pFDescription : (pFDescription = new FDescriptionElements());
	}
	
	public ParserRule getFDescriptionRule() {
		return getFDescriptionAccess().getRule();
	}

	//Table:
	//	TDescription THeader r+=Row r+=Row r+=Row r+=Row r+=Row r+=Row r+=Row r+=Row;
	public TableElements getTableAccess() {
		return (pTable != null) ? pTable : (pTable = new TableElements());
	}
	
	public ParserRule getTableRule() {
		return getTableAccess().getRule();
	}

	//TDescription:
	//	PIECE name=PieceType MIDGAME mg=INT ENDGAME eg=INT;
	public TDescriptionElements getTDescriptionAccess() {
		return (pTDescription != null) ? pTDescription : (pTDescription = new TDescriptionElements());
	}
	
	public ParserRule getTDescriptionRule() {
		return getTDescriptionAccess().getRule();
	}

	//THeader:
	//	"A" "B" "C" "D" "E" "F" "G" "H";
	public THeaderElements getTHeaderAccess() {
		return (pTHeader != null) ? pTHeader : (pTHeader = new THeaderElements());
	}
	
	public ParserRule getTHeaderRule() {
		return getTHeaderAccess().getRule();
	}

	//Row:
	//	name=RowLabel m=MRow e=ERow;
	public RowElements getRowAccess() {
		return (pRow != null) ? pRow : (pRow = new RowElements());
	}
	
	public ParserRule getRowRule() {
		return getRowAccess().getRule();
	}

	//RowLabel returns ecore::EString:
	//	INT;
	public RowLabelElements getRowLabelAccess() {
		return (pRowLabel != null) ? pRowLabel : (pRowLabel = new RowLabelElements());
	}
	
	public ParserRule getRowLabelRule() {
		return getRowLabelAccess().getRule();
	}

	//MRow:
	//	name=Row1;
	public MRowElements getMRowAccess() {
		return (pMRow != null) ? pMRow : (pMRow = new MRowElements());
	}
	
	public ParserRule getMRowRule() {
		return getMRowAccess().getRule();
	}

	//ERow:
	//	name=Row1;
	public ERowElements getERowAccess() {
		return (pERow != null) ? pERow : (pERow = new ERowElements());
	}
	
	public ParserRule getERowRule() {
		return getERowAccess().getRule();
	}

	//Row1:
	//	c+=INT c+=INT c+=INT c+=INT c+=INT c+=INT c+=INT c+=INT;
	public Row1Elements getRow1Access() {
		return (pRow1 != null) ? pRow1 : (pRow1 = new Row1Elements());
	}
	
	public ParserRule getRow1Rule() {
		return getRow1Access().getRule();
	}

	//terminal INT returns ecore::EInt:
	//	"-"? "0".."9"+;
	public TerminalRule getINTRule() {
		return (tINT != null) ? tINT : (tINT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "INT"));
	} 

	//terminal PSQT:
	//	"PSQT:";
	public TerminalRule getPSQTRule() {
		return (tPSQT != null) ? tPSQT : (tPSQT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "PSQT"));
	} 

	//terminal BASE:
	//	"Base:";
	public TerminalRule getBASERule() {
		return (tBASE != null) ? tBASE : (tBASE = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "BASE"));
	} 

	//terminal PIECE:
	//	"Piece:";
	public TerminalRule getPIECERule() {
		return (tPIECE != null) ? tPIECE : (tPIECE = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "PIECE"));
	} 

	//terminal MIDLIMIT:
	//	"MidLimit:";
	public TerminalRule getMIDLIMITRule() {
		return (tMIDLIMIT != null) ? tMIDLIMIT : (tMIDLIMIT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "MIDLIMIT"));
	} 

	//terminal ENDLIMIT:
	//	"EndLimit:";
	public TerminalRule getENDLIMITRule() {
		return (tENDLIMIT != null) ? tENDLIMIT : (tENDLIMIT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "ENDLIMIT"));
	} 

	//terminal MIDGAME:
	//	"MidGame:";
	public TerminalRule getMIDGAMERule() {
		return (tMIDGAME != null) ? tMIDGAME : (tMIDGAME = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "MIDGAME"));
	} 

	//terminal ENDGAME:
	//	"EndGame:";
	public TerminalRule getENDGAMERule() {
		return (tENDGAME != null) ? tENDGAME : (tENDGAME = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "ENDGAME"));
	} 

	//terminal ID:
	//	"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	} 

	//terminal STRING:
	//	"\"" ("\\" ("b" | "t" | "n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\""))* "\"" | "\'" ("\\" ("b" | "t" |
	//	"n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\'"))* "\'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	} 

	//terminal ML_COMMENT:
	//	"/ *"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	} 

	//terminal SL_COMMENT:
	//	"//" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	} 

	//terminal WS:
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	} 

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	} 
}
