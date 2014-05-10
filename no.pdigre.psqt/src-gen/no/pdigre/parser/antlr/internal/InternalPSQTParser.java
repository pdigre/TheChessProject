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



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalPSQTParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_PSQT", "RULE_ID", "RULE_BASE", "RULE_INT", "RULE_PIECE", "RULE_VALUE", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'A'", "'B'", "'C'", "'D'", "'E'", "'F'", "'G'", "'H'", "'Pawn'", "'Knight'", "'Bishop'", "'Rook'", "'Queen'", "'King'"
    };
    public static final int RULE_PIECE=8;
    public static final int RULE_STRING=10;
    public static final int RULE_SL_COMMENT=12;
    public static final int T__19=19;
    public static final int RULE_VALUE=9;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int RULE_BASE=6;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int EOF=-1;
    public static final int RULE_ID=5;
    public static final int RULE_WS=13;
    public static final int RULE_ANY_OTHER=14;
    public static final int RULE_PSQT=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=7;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=11;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalPSQTParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalPSQTParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalPSQTParser.tokenNames; }
    public String getGrammarFileName() { return "../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g"; }



     	private PSQTGrammarAccess grammarAccess;
     	
        public InternalPSQTParser(TokenStream input, PSQTGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected PSQTGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:68:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:69:2: (iv_ruleModel= ruleModel EOF )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:70:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:77:1: ruleModel returns [EObject current=null] : (this_FDescription_0= ruleFDescription ( (lv_tables_1_0= ruleTable ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject this_FDescription_0 = null;

        EObject lv_tables_1_0 = null;


         enterRule(); 
            
        try {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:80:28: ( (this_FDescription_0= ruleFDescription ( (lv_tables_1_0= ruleTable ) )* ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:81:1: (this_FDescription_0= ruleFDescription ( (lv_tables_1_0= ruleTable ) )* )
            {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:81:1: (this_FDescription_0= ruleFDescription ( (lv_tables_1_0= ruleTable ) )* )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:82:5: this_FDescription_0= ruleFDescription ( (lv_tables_1_0= ruleTable ) )*
            {
             
                    newCompositeNode(grammarAccess.getModelAccess().getFDescriptionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleFDescription_in_ruleModel132);
            this_FDescription_0=ruleFDescription();

            state._fsp--;

             
                    current = this_FDescription_0; 
                    afterParserOrEnumRuleCall();
                
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:90:1: ( (lv_tables_1_0= ruleTable ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_PIECE) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:91:1: (lv_tables_1_0= ruleTable )
            	    {
            	    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:91:1: (lv_tables_1_0= ruleTable )
            	    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:92:3: lv_tables_1_0= ruleTable
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getTablesTableParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTable_in_ruleModel152);
            	    lv_tables_1_0=ruleTable();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"tables",
            	            		lv_tables_1_0, 
            	            		"Table");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleFDescription"
    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:116:1: entryRuleFDescription returns [EObject current=null] : iv_ruleFDescription= ruleFDescription EOF ;
    public final EObject entryRuleFDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFDescription = null;


        try {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:117:2: (iv_ruleFDescription= ruleFDescription EOF )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:118:2: iv_ruleFDescription= ruleFDescription EOF
            {
             newCompositeNode(grammarAccess.getFDescriptionRule()); 
            pushFollow(FOLLOW_ruleFDescription_in_entryRuleFDescription189);
            iv_ruleFDescription=ruleFDescription();

            state._fsp--;

             current =iv_ruleFDescription; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFDescription199); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFDescription"


    // $ANTLR start "ruleFDescription"
    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:125:1: ruleFDescription returns [EObject current=null] : (this_PSQT_0= RULE_PSQT ( (lv_name_1_0= RULE_ID ) ) this_BASE_2= RULE_BASE ( (lv_base_3_0= RULE_INT ) ) ) ;
    public final EObject ruleFDescription() throws RecognitionException {
        EObject current = null;

        Token this_PSQT_0=null;
        Token lv_name_1_0=null;
        Token this_BASE_2=null;
        Token lv_base_3_0=null;

         enterRule(); 
            
        try {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:128:28: ( (this_PSQT_0= RULE_PSQT ( (lv_name_1_0= RULE_ID ) ) this_BASE_2= RULE_BASE ( (lv_base_3_0= RULE_INT ) ) ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:129:1: (this_PSQT_0= RULE_PSQT ( (lv_name_1_0= RULE_ID ) ) this_BASE_2= RULE_BASE ( (lv_base_3_0= RULE_INT ) ) )
            {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:129:1: (this_PSQT_0= RULE_PSQT ( (lv_name_1_0= RULE_ID ) ) this_BASE_2= RULE_BASE ( (lv_base_3_0= RULE_INT ) ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:129:2: this_PSQT_0= RULE_PSQT ( (lv_name_1_0= RULE_ID ) ) this_BASE_2= RULE_BASE ( (lv_base_3_0= RULE_INT ) )
            {
            this_PSQT_0=(Token)match(input,RULE_PSQT,FOLLOW_RULE_PSQT_in_ruleFDescription235); 
             
                newLeafNode(this_PSQT_0, grammarAccess.getFDescriptionAccess().getPSQTTerminalRuleCall_0()); 
                
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:133:1: ( (lv_name_1_0= RULE_ID ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:134:1: (lv_name_1_0= RULE_ID )
            {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:134:1: (lv_name_1_0= RULE_ID )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:135:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFDescription251); 

            			newLeafNode(lv_name_1_0, grammarAccess.getFDescriptionAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFDescriptionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            this_BASE_2=(Token)match(input,RULE_BASE,FOLLOW_RULE_BASE_in_ruleFDescription267); 
             
                newLeafNode(this_BASE_2, grammarAccess.getFDescriptionAccess().getBASETerminalRuleCall_2()); 
                
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:155:1: ( (lv_base_3_0= RULE_INT ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:156:1: (lv_base_3_0= RULE_INT )
            {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:156:1: (lv_base_3_0= RULE_INT )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:157:3: lv_base_3_0= RULE_INT
            {
            lv_base_3_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleFDescription283); 

            			newLeafNode(lv_base_3_0, grammarAccess.getFDescriptionAccess().getBaseINTTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFDescriptionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"base",
                    		lv_base_3_0, 
                    		"INT");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFDescription"


    // $ANTLR start "entryRuleTable"
    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:181:1: entryRuleTable returns [EObject current=null] : iv_ruleTable= ruleTable EOF ;
    public final EObject entryRuleTable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTable = null;


        try {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:182:2: (iv_ruleTable= ruleTable EOF )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:183:2: iv_ruleTable= ruleTable EOF
            {
             newCompositeNode(grammarAccess.getTableRule()); 
            pushFollow(FOLLOW_ruleTable_in_entryRuleTable324);
            iv_ruleTable=ruleTable();

            state._fsp--;

             current =iv_ruleTable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTable334); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTable"


    // $ANTLR start "ruleTable"
    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:190:1: ruleTable returns [EObject current=null] : (this_TDescription_0= ruleTDescription ruleTHeader ( (lv_r_2_0= ruleRow ) ) ( (lv_r_3_0= ruleRow ) ) ( (lv_r_4_0= ruleRow ) ) ( (lv_r_5_0= ruleRow ) ) ( (lv_r_6_0= ruleRow ) ) ( (lv_r_7_0= ruleRow ) ) ( (lv_r_8_0= ruleRow ) ) ( (lv_r_9_0= ruleRow ) ) ) ;
    public final EObject ruleTable() throws RecognitionException {
        EObject current = null;

        EObject this_TDescription_0 = null;

        EObject lv_r_2_0 = null;

        EObject lv_r_3_0 = null;

        EObject lv_r_4_0 = null;

        EObject lv_r_5_0 = null;

        EObject lv_r_6_0 = null;

        EObject lv_r_7_0 = null;

        EObject lv_r_8_0 = null;

        EObject lv_r_9_0 = null;


         enterRule(); 
            
        try {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:193:28: ( (this_TDescription_0= ruleTDescription ruleTHeader ( (lv_r_2_0= ruleRow ) ) ( (lv_r_3_0= ruleRow ) ) ( (lv_r_4_0= ruleRow ) ) ( (lv_r_5_0= ruleRow ) ) ( (lv_r_6_0= ruleRow ) ) ( (lv_r_7_0= ruleRow ) ) ( (lv_r_8_0= ruleRow ) ) ( (lv_r_9_0= ruleRow ) ) ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:194:1: (this_TDescription_0= ruleTDescription ruleTHeader ( (lv_r_2_0= ruleRow ) ) ( (lv_r_3_0= ruleRow ) ) ( (lv_r_4_0= ruleRow ) ) ( (lv_r_5_0= ruleRow ) ) ( (lv_r_6_0= ruleRow ) ) ( (lv_r_7_0= ruleRow ) ) ( (lv_r_8_0= ruleRow ) ) ( (lv_r_9_0= ruleRow ) ) )
            {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:194:1: (this_TDescription_0= ruleTDescription ruleTHeader ( (lv_r_2_0= ruleRow ) ) ( (lv_r_3_0= ruleRow ) ) ( (lv_r_4_0= ruleRow ) ) ( (lv_r_5_0= ruleRow ) ) ( (lv_r_6_0= ruleRow ) ) ( (lv_r_7_0= ruleRow ) ) ( (lv_r_8_0= ruleRow ) ) ( (lv_r_9_0= ruleRow ) ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:195:5: this_TDescription_0= ruleTDescription ruleTHeader ( (lv_r_2_0= ruleRow ) ) ( (lv_r_3_0= ruleRow ) ) ( (lv_r_4_0= ruleRow ) ) ( (lv_r_5_0= ruleRow ) ) ( (lv_r_6_0= ruleRow ) ) ( (lv_r_7_0= ruleRow ) ) ( (lv_r_8_0= ruleRow ) ) ( (lv_r_9_0= ruleRow ) )
            {
             
                    newCompositeNode(grammarAccess.getTableAccess().getTDescriptionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleTDescription_in_ruleTable381);
            this_TDescription_0=ruleTDescription();

            state._fsp--;

             
                    current = this_TDescription_0; 
                    afterParserOrEnumRuleCall();
                
             
                    newCompositeNode(grammarAccess.getTableAccess().getTHeaderParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleTHeader_in_ruleTable396);
            ruleTHeader();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:211:1: ( (lv_r_2_0= ruleRow ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:212:1: (lv_r_2_0= ruleRow )
            {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:212:1: (lv_r_2_0= ruleRow )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:213:3: lv_r_2_0= ruleRow
            {
             
            	        newCompositeNode(grammarAccess.getTableAccess().getRRowParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleRow_in_ruleTable416);
            lv_r_2_0=ruleRow();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTableRule());
            	        }
                   		add(
                   			current, 
                   			"r",
                    		lv_r_2_0, 
                    		"Row");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:229:2: ( (lv_r_3_0= ruleRow ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:230:1: (lv_r_3_0= ruleRow )
            {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:230:1: (lv_r_3_0= ruleRow )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:231:3: lv_r_3_0= ruleRow
            {
             
            	        newCompositeNode(grammarAccess.getTableAccess().getRRowParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleRow_in_ruleTable437);
            lv_r_3_0=ruleRow();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTableRule());
            	        }
                   		add(
                   			current, 
                   			"r",
                    		lv_r_3_0, 
                    		"Row");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:247:2: ( (lv_r_4_0= ruleRow ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:248:1: (lv_r_4_0= ruleRow )
            {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:248:1: (lv_r_4_0= ruleRow )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:249:3: lv_r_4_0= ruleRow
            {
             
            	        newCompositeNode(grammarAccess.getTableAccess().getRRowParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleRow_in_ruleTable458);
            lv_r_4_0=ruleRow();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTableRule());
            	        }
                   		add(
                   			current, 
                   			"r",
                    		lv_r_4_0, 
                    		"Row");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:265:2: ( (lv_r_5_0= ruleRow ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:266:1: (lv_r_5_0= ruleRow )
            {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:266:1: (lv_r_5_0= ruleRow )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:267:3: lv_r_5_0= ruleRow
            {
             
            	        newCompositeNode(grammarAccess.getTableAccess().getRRowParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleRow_in_ruleTable479);
            lv_r_5_0=ruleRow();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTableRule());
            	        }
                   		add(
                   			current, 
                   			"r",
                    		lv_r_5_0, 
                    		"Row");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:283:2: ( (lv_r_6_0= ruleRow ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:284:1: (lv_r_6_0= ruleRow )
            {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:284:1: (lv_r_6_0= ruleRow )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:285:3: lv_r_6_0= ruleRow
            {
             
            	        newCompositeNode(grammarAccess.getTableAccess().getRRowParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_ruleRow_in_ruleTable500);
            lv_r_6_0=ruleRow();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTableRule());
            	        }
                   		add(
                   			current, 
                   			"r",
                    		lv_r_6_0, 
                    		"Row");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:301:2: ( (lv_r_7_0= ruleRow ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:302:1: (lv_r_7_0= ruleRow )
            {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:302:1: (lv_r_7_0= ruleRow )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:303:3: lv_r_7_0= ruleRow
            {
             
            	        newCompositeNode(grammarAccess.getTableAccess().getRRowParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_ruleRow_in_ruleTable521);
            lv_r_7_0=ruleRow();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTableRule());
            	        }
                   		add(
                   			current, 
                   			"r",
                    		lv_r_7_0, 
                    		"Row");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:319:2: ( (lv_r_8_0= ruleRow ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:320:1: (lv_r_8_0= ruleRow )
            {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:320:1: (lv_r_8_0= ruleRow )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:321:3: lv_r_8_0= ruleRow
            {
             
            	        newCompositeNode(grammarAccess.getTableAccess().getRRowParserRuleCall_8_0()); 
            	    
            pushFollow(FOLLOW_ruleRow_in_ruleTable542);
            lv_r_8_0=ruleRow();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTableRule());
            	        }
                   		add(
                   			current, 
                   			"r",
                    		lv_r_8_0, 
                    		"Row");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:337:2: ( (lv_r_9_0= ruleRow ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:338:1: (lv_r_9_0= ruleRow )
            {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:338:1: (lv_r_9_0= ruleRow )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:339:3: lv_r_9_0= ruleRow
            {
             
            	        newCompositeNode(grammarAccess.getTableAccess().getRRowParserRuleCall_9_0()); 
            	    
            pushFollow(FOLLOW_ruleRow_in_ruleTable563);
            lv_r_9_0=ruleRow();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTableRule());
            	        }
                   		add(
                   			current, 
                   			"r",
                    		lv_r_9_0, 
                    		"Row");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTable"


    // $ANTLR start "entryRuleTDescription"
    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:363:1: entryRuleTDescription returns [EObject current=null] : iv_ruleTDescription= ruleTDescription EOF ;
    public final EObject entryRuleTDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTDescription = null;


        try {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:364:2: (iv_ruleTDescription= ruleTDescription EOF )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:365:2: iv_ruleTDescription= ruleTDescription EOF
            {
             newCompositeNode(grammarAccess.getTDescriptionRule()); 
            pushFollow(FOLLOW_ruleTDescription_in_entryRuleTDescription599);
            iv_ruleTDescription=ruleTDescription();

            state._fsp--;

             current =iv_ruleTDescription; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTDescription609); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTDescription"


    // $ANTLR start "ruleTDescription"
    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:372:1: ruleTDescription returns [EObject current=null] : (this_PIECE_0= RULE_PIECE ( (lv_name_1_0= rulePieceType ) ) this_VALUE_2= RULE_VALUE ( (lv_value_3_0= RULE_INT ) ) ) ;
    public final EObject ruleTDescription() throws RecognitionException {
        EObject current = null;

        Token this_PIECE_0=null;
        Token this_VALUE_2=null;
        Token lv_value_3_0=null;
        Enumerator lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:375:28: ( (this_PIECE_0= RULE_PIECE ( (lv_name_1_0= rulePieceType ) ) this_VALUE_2= RULE_VALUE ( (lv_value_3_0= RULE_INT ) ) ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:376:1: (this_PIECE_0= RULE_PIECE ( (lv_name_1_0= rulePieceType ) ) this_VALUE_2= RULE_VALUE ( (lv_value_3_0= RULE_INT ) ) )
            {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:376:1: (this_PIECE_0= RULE_PIECE ( (lv_name_1_0= rulePieceType ) ) this_VALUE_2= RULE_VALUE ( (lv_value_3_0= RULE_INT ) ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:376:2: this_PIECE_0= RULE_PIECE ( (lv_name_1_0= rulePieceType ) ) this_VALUE_2= RULE_VALUE ( (lv_value_3_0= RULE_INT ) )
            {
            this_PIECE_0=(Token)match(input,RULE_PIECE,FOLLOW_RULE_PIECE_in_ruleTDescription645); 
             
                newLeafNode(this_PIECE_0, grammarAccess.getTDescriptionAccess().getPIECETerminalRuleCall_0()); 
                
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:380:1: ( (lv_name_1_0= rulePieceType ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:381:1: (lv_name_1_0= rulePieceType )
            {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:381:1: (lv_name_1_0= rulePieceType )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:382:3: lv_name_1_0= rulePieceType
            {
             
            	        newCompositeNode(grammarAccess.getTDescriptionAccess().getNamePieceTypeEnumRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_rulePieceType_in_ruleTDescription665);
            lv_name_1_0=rulePieceType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTDescriptionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"PieceType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            this_VALUE_2=(Token)match(input,RULE_VALUE,FOLLOW_RULE_VALUE_in_ruleTDescription676); 
             
                newLeafNode(this_VALUE_2, grammarAccess.getTDescriptionAccess().getVALUETerminalRuleCall_2()); 
                
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:402:1: ( (lv_value_3_0= RULE_INT ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:403:1: (lv_value_3_0= RULE_INT )
            {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:403:1: (lv_value_3_0= RULE_INT )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:404:3: lv_value_3_0= RULE_INT
            {
            lv_value_3_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTDescription692); 

            			newLeafNode(lv_value_3_0, grammarAccess.getTDescriptionAccess().getValueINTTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTDescriptionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_3_0, 
                    		"INT");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTDescription"


    // $ANTLR start "entryRuleTHeader"
    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:428:1: entryRuleTHeader returns [String current=null] : iv_ruleTHeader= ruleTHeader EOF ;
    public final String entryRuleTHeader() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTHeader = null;


        try {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:429:2: (iv_ruleTHeader= ruleTHeader EOF )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:430:2: iv_ruleTHeader= ruleTHeader EOF
            {
             newCompositeNode(grammarAccess.getTHeaderRule()); 
            pushFollow(FOLLOW_ruleTHeader_in_entryRuleTHeader734);
            iv_ruleTHeader=ruleTHeader();

            state._fsp--;

             current =iv_ruleTHeader.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTHeader745); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTHeader"


    // $ANTLR start "ruleTHeader"
    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:437:1: ruleTHeader returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'A' kw= 'B' kw= 'C' kw= 'D' kw= 'E' kw= 'F' kw= 'G' kw= 'H' ) ;
    public final AntlrDatatypeRuleToken ruleTHeader() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:440:28: ( (kw= 'A' kw= 'B' kw= 'C' kw= 'D' kw= 'E' kw= 'F' kw= 'G' kw= 'H' ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:441:1: (kw= 'A' kw= 'B' kw= 'C' kw= 'D' kw= 'E' kw= 'F' kw= 'G' kw= 'H' )
            {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:441:1: (kw= 'A' kw= 'B' kw= 'C' kw= 'D' kw= 'E' kw= 'F' kw= 'G' kw= 'H' )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:442:2: kw= 'A' kw= 'B' kw= 'C' kw= 'D' kw= 'E' kw= 'F' kw= 'G' kw= 'H'
            {
            kw=(Token)match(input,15,FOLLOW_15_in_ruleTHeader783); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getTHeaderAccess().getAKeyword_0()); 
                
            kw=(Token)match(input,16,FOLLOW_16_in_ruleTHeader796); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getTHeaderAccess().getBKeyword_1()); 
                
            kw=(Token)match(input,17,FOLLOW_17_in_ruleTHeader809); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getTHeaderAccess().getCKeyword_2()); 
                
            kw=(Token)match(input,18,FOLLOW_18_in_ruleTHeader822); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getTHeaderAccess().getDKeyword_3()); 
                
            kw=(Token)match(input,19,FOLLOW_19_in_ruleTHeader835); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getTHeaderAccess().getEKeyword_4()); 
                
            kw=(Token)match(input,20,FOLLOW_20_in_ruleTHeader848); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getTHeaderAccess().getFKeyword_5()); 
                
            kw=(Token)match(input,21,FOLLOW_21_in_ruleTHeader861); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getTHeaderAccess().getGKeyword_6()); 
                
            kw=(Token)match(input,22,FOLLOW_22_in_ruleTHeader874); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getTHeaderAccess().getHKeyword_7()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTHeader"


    // $ANTLR start "entryRuleRow"
    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:497:1: entryRuleRow returns [EObject current=null] : iv_ruleRow= ruleRow EOF ;
    public final EObject entryRuleRow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRow = null;


        try {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:498:2: (iv_ruleRow= ruleRow EOF )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:499:2: iv_ruleRow= ruleRow EOF
            {
             newCompositeNode(grammarAccess.getRowRule()); 
            pushFollow(FOLLOW_ruleRow_in_entryRuleRow914);
            iv_ruleRow=ruleRow();

            state._fsp--;

             current =iv_ruleRow; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRow924); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRow"


    // $ANTLR start "ruleRow"
    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:506:1: ruleRow returns [EObject current=null] : ( ( (lv_name_0_0= ruleRowLabel ) ) ( (lv_m_1_0= ruleMRow ) ) ( (lv_e_2_0= ruleERow ) ) ) ;
    public final EObject ruleRow() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_m_1_0 = null;

        EObject lv_e_2_0 = null;


         enterRule(); 
            
        try {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:509:28: ( ( ( (lv_name_0_0= ruleRowLabel ) ) ( (lv_m_1_0= ruleMRow ) ) ( (lv_e_2_0= ruleERow ) ) ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:510:1: ( ( (lv_name_0_0= ruleRowLabel ) ) ( (lv_m_1_0= ruleMRow ) ) ( (lv_e_2_0= ruleERow ) ) )
            {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:510:1: ( ( (lv_name_0_0= ruleRowLabel ) ) ( (lv_m_1_0= ruleMRow ) ) ( (lv_e_2_0= ruleERow ) ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:510:2: ( (lv_name_0_0= ruleRowLabel ) ) ( (lv_m_1_0= ruleMRow ) ) ( (lv_e_2_0= ruleERow ) )
            {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:510:2: ( (lv_name_0_0= ruleRowLabel ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:511:1: (lv_name_0_0= ruleRowLabel )
            {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:511:1: (lv_name_0_0= ruleRowLabel )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:512:3: lv_name_0_0= ruleRowLabel
            {
             
            	        newCompositeNode(grammarAccess.getRowAccess().getNameRowLabelParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleRowLabel_in_ruleRow970);
            lv_name_0_0=ruleRowLabel();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRowRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"RowLabel");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:528:2: ( (lv_m_1_0= ruleMRow ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:529:1: (lv_m_1_0= ruleMRow )
            {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:529:1: (lv_m_1_0= ruleMRow )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:530:3: lv_m_1_0= ruleMRow
            {
             
            	        newCompositeNode(grammarAccess.getRowAccess().getMMRowParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleMRow_in_ruleRow991);
            lv_m_1_0=ruleMRow();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRowRule());
            	        }
                   		set(
                   			current, 
                   			"m",
                    		lv_m_1_0, 
                    		"MRow");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:546:2: ( (lv_e_2_0= ruleERow ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:547:1: (lv_e_2_0= ruleERow )
            {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:547:1: (lv_e_2_0= ruleERow )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:548:3: lv_e_2_0= ruleERow
            {
             
            	        newCompositeNode(grammarAccess.getRowAccess().getEERowParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleERow_in_ruleRow1012);
            lv_e_2_0=ruleERow();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRowRule());
            	        }
                   		set(
                   			current, 
                   			"e",
                    		lv_e_2_0, 
                    		"ERow");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRow"


    // $ANTLR start "entryRuleRowLabel"
    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:572:1: entryRuleRowLabel returns [String current=null] : iv_ruleRowLabel= ruleRowLabel EOF ;
    public final String entryRuleRowLabel() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRowLabel = null;


        try {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:573:2: (iv_ruleRowLabel= ruleRowLabel EOF )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:574:2: iv_ruleRowLabel= ruleRowLabel EOF
            {
             newCompositeNode(grammarAccess.getRowLabelRule()); 
            pushFollow(FOLLOW_ruleRowLabel_in_entryRuleRowLabel1049);
            iv_ruleRowLabel=ruleRowLabel();

            state._fsp--;

             current =iv_ruleRowLabel.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRowLabel1060); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRowLabel"


    // $ANTLR start "ruleRowLabel"
    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:581:1: ruleRowLabel returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleRowLabel() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:584:28: (this_INT_0= RULE_INT )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:585:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleRowLabel1099); 

            		current.merge(this_INT_0);
                
             
                newLeafNode(this_INT_0, grammarAccess.getRowLabelAccess().getINTTerminalRuleCall()); 
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRowLabel"


    // $ANTLR start "entryRuleMRow"
    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:600:1: entryRuleMRow returns [EObject current=null] : iv_ruleMRow= ruleMRow EOF ;
    public final EObject entryRuleMRow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMRow = null;


        try {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:601:2: (iv_ruleMRow= ruleMRow EOF )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:602:2: iv_ruleMRow= ruleMRow EOF
            {
             newCompositeNode(grammarAccess.getMRowRule()); 
            pushFollow(FOLLOW_ruleMRow_in_entryRuleMRow1143);
            iv_ruleMRow=ruleMRow();

            state._fsp--;

             current =iv_ruleMRow; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMRow1153); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMRow"


    // $ANTLR start "ruleMRow"
    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:609:1: ruleMRow returns [EObject current=null] : ( (lv_name_0_0= ruleRow1 ) ) ;
    public final EObject ruleMRow() throws RecognitionException {
        EObject current = null;

        EObject lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:612:28: ( ( (lv_name_0_0= ruleRow1 ) ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:613:1: ( (lv_name_0_0= ruleRow1 ) )
            {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:613:1: ( (lv_name_0_0= ruleRow1 ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:614:1: (lv_name_0_0= ruleRow1 )
            {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:614:1: (lv_name_0_0= ruleRow1 )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:615:3: lv_name_0_0= ruleRow1
            {
             
            	        newCompositeNode(grammarAccess.getMRowAccess().getNameRow1ParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleRow1_in_ruleMRow1198);
            lv_name_0_0=ruleRow1();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMRowRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"Row1");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMRow"


    // $ANTLR start "entryRuleERow"
    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:639:1: entryRuleERow returns [EObject current=null] : iv_ruleERow= ruleERow EOF ;
    public final EObject entryRuleERow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleERow = null;


        try {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:640:2: (iv_ruleERow= ruleERow EOF )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:641:2: iv_ruleERow= ruleERow EOF
            {
             newCompositeNode(grammarAccess.getERowRule()); 
            pushFollow(FOLLOW_ruleERow_in_entryRuleERow1233);
            iv_ruleERow=ruleERow();

            state._fsp--;

             current =iv_ruleERow; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleERow1243); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleERow"


    // $ANTLR start "ruleERow"
    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:648:1: ruleERow returns [EObject current=null] : ( (lv_name_0_0= ruleRow1 ) ) ;
    public final EObject ruleERow() throws RecognitionException {
        EObject current = null;

        EObject lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:651:28: ( ( (lv_name_0_0= ruleRow1 ) ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:652:1: ( (lv_name_0_0= ruleRow1 ) )
            {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:652:1: ( (lv_name_0_0= ruleRow1 ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:653:1: (lv_name_0_0= ruleRow1 )
            {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:653:1: (lv_name_0_0= ruleRow1 )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:654:3: lv_name_0_0= ruleRow1
            {
             
            	        newCompositeNode(grammarAccess.getERowAccess().getNameRow1ParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleRow1_in_ruleERow1288);
            lv_name_0_0=ruleRow1();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getERowRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"Row1");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleERow"


    // $ANTLR start "entryRuleRow1"
    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:678:1: entryRuleRow1 returns [EObject current=null] : iv_ruleRow1= ruleRow1 EOF ;
    public final EObject entryRuleRow1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRow1 = null;


        try {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:679:2: (iv_ruleRow1= ruleRow1 EOF )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:680:2: iv_ruleRow1= ruleRow1 EOF
            {
             newCompositeNode(grammarAccess.getRow1Rule()); 
            pushFollow(FOLLOW_ruleRow1_in_entryRuleRow11323);
            iv_ruleRow1=ruleRow1();

            state._fsp--;

             current =iv_ruleRow1; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRow11333); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRow1"


    // $ANTLR start "ruleRow1"
    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:687:1: ruleRow1 returns [EObject current=null] : ( ( (lv_c_0_0= RULE_INT ) ) ( (lv_c_1_0= RULE_INT ) ) ( (lv_c_2_0= RULE_INT ) ) ( (lv_c_3_0= RULE_INT ) ) ( (lv_c_4_0= RULE_INT ) ) ( (lv_c_5_0= RULE_INT ) ) ( (lv_c_6_0= RULE_INT ) ) ( (lv_c_7_0= RULE_INT ) ) ) ;
    public final EObject ruleRow1() throws RecognitionException {
        EObject current = null;

        Token lv_c_0_0=null;
        Token lv_c_1_0=null;
        Token lv_c_2_0=null;
        Token lv_c_3_0=null;
        Token lv_c_4_0=null;
        Token lv_c_5_0=null;
        Token lv_c_6_0=null;
        Token lv_c_7_0=null;

         enterRule(); 
            
        try {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:690:28: ( ( ( (lv_c_0_0= RULE_INT ) ) ( (lv_c_1_0= RULE_INT ) ) ( (lv_c_2_0= RULE_INT ) ) ( (lv_c_3_0= RULE_INT ) ) ( (lv_c_4_0= RULE_INT ) ) ( (lv_c_5_0= RULE_INT ) ) ( (lv_c_6_0= RULE_INT ) ) ( (lv_c_7_0= RULE_INT ) ) ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:691:1: ( ( (lv_c_0_0= RULE_INT ) ) ( (lv_c_1_0= RULE_INT ) ) ( (lv_c_2_0= RULE_INT ) ) ( (lv_c_3_0= RULE_INT ) ) ( (lv_c_4_0= RULE_INT ) ) ( (lv_c_5_0= RULE_INT ) ) ( (lv_c_6_0= RULE_INT ) ) ( (lv_c_7_0= RULE_INT ) ) )
            {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:691:1: ( ( (lv_c_0_0= RULE_INT ) ) ( (lv_c_1_0= RULE_INT ) ) ( (lv_c_2_0= RULE_INT ) ) ( (lv_c_3_0= RULE_INT ) ) ( (lv_c_4_0= RULE_INT ) ) ( (lv_c_5_0= RULE_INT ) ) ( (lv_c_6_0= RULE_INT ) ) ( (lv_c_7_0= RULE_INT ) ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:691:2: ( (lv_c_0_0= RULE_INT ) ) ( (lv_c_1_0= RULE_INT ) ) ( (lv_c_2_0= RULE_INT ) ) ( (lv_c_3_0= RULE_INT ) ) ( (lv_c_4_0= RULE_INT ) ) ( (lv_c_5_0= RULE_INT ) ) ( (lv_c_6_0= RULE_INT ) ) ( (lv_c_7_0= RULE_INT ) )
            {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:691:2: ( (lv_c_0_0= RULE_INT ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:692:1: (lv_c_0_0= RULE_INT )
            {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:692:1: (lv_c_0_0= RULE_INT )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:693:3: lv_c_0_0= RULE_INT
            {
            lv_c_0_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleRow11375); 

            			newLeafNode(lv_c_0_0, grammarAccess.getRow1Access().getCINTTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRow1Rule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"c",
                    		lv_c_0_0, 
                    		"INT");
            	    

            }


            }

            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:709:2: ( (lv_c_1_0= RULE_INT ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:710:1: (lv_c_1_0= RULE_INT )
            {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:710:1: (lv_c_1_0= RULE_INT )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:711:3: lv_c_1_0= RULE_INT
            {
            lv_c_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleRow11397); 

            			newLeafNode(lv_c_1_0, grammarAccess.getRow1Access().getCINTTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRow1Rule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"c",
                    		lv_c_1_0, 
                    		"INT");
            	    

            }


            }

            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:727:2: ( (lv_c_2_0= RULE_INT ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:728:1: (lv_c_2_0= RULE_INT )
            {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:728:1: (lv_c_2_0= RULE_INT )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:729:3: lv_c_2_0= RULE_INT
            {
            lv_c_2_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleRow11419); 

            			newLeafNode(lv_c_2_0, grammarAccess.getRow1Access().getCINTTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRow1Rule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"c",
                    		lv_c_2_0, 
                    		"INT");
            	    

            }


            }

            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:745:2: ( (lv_c_3_0= RULE_INT ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:746:1: (lv_c_3_0= RULE_INT )
            {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:746:1: (lv_c_3_0= RULE_INT )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:747:3: lv_c_3_0= RULE_INT
            {
            lv_c_3_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleRow11441); 

            			newLeafNode(lv_c_3_0, grammarAccess.getRow1Access().getCINTTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRow1Rule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"c",
                    		lv_c_3_0, 
                    		"INT");
            	    

            }


            }

            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:763:2: ( (lv_c_4_0= RULE_INT ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:764:1: (lv_c_4_0= RULE_INT )
            {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:764:1: (lv_c_4_0= RULE_INT )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:765:3: lv_c_4_0= RULE_INT
            {
            lv_c_4_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleRow11463); 

            			newLeafNode(lv_c_4_0, grammarAccess.getRow1Access().getCINTTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRow1Rule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"c",
                    		lv_c_4_0, 
                    		"INT");
            	    

            }


            }

            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:781:2: ( (lv_c_5_0= RULE_INT ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:782:1: (lv_c_5_0= RULE_INT )
            {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:782:1: (lv_c_5_0= RULE_INT )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:783:3: lv_c_5_0= RULE_INT
            {
            lv_c_5_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleRow11485); 

            			newLeafNode(lv_c_5_0, grammarAccess.getRow1Access().getCINTTerminalRuleCall_5_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRow1Rule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"c",
                    		lv_c_5_0, 
                    		"INT");
            	    

            }


            }

            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:799:2: ( (lv_c_6_0= RULE_INT ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:800:1: (lv_c_6_0= RULE_INT )
            {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:800:1: (lv_c_6_0= RULE_INT )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:801:3: lv_c_6_0= RULE_INT
            {
            lv_c_6_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleRow11507); 

            			newLeafNode(lv_c_6_0, grammarAccess.getRow1Access().getCINTTerminalRuleCall_6_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRow1Rule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"c",
                    		lv_c_6_0, 
                    		"INT");
            	    

            }


            }

            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:817:2: ( (lv_c_7_0= RULE_INT ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:818:1: (lv_c_7_0= RULE_INT )
            {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:818:1: (lv_c_7_0= RULE_INT )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:819:3: lv_c_7_0= RULE_INT
            {
            lv_c_7_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleRow11529); 

            			newLeafNode(lv_c_7_0, grammarAccess.getRow1Access().getCINTTerminalRuleCall_7_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRow1Rule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"c",
                    		lv_c_7_0, 
                    		"INT");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRow1"


    // $ANTLR start "rulePieceType"
    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:843:1: rulePieceType returns [Enumerator current=null] : ( (enumLiteral_0= 'Pawn' ) | (enumLiteral_1= 'Knight' ) | (enumLiteral_2= 'Bishop' ) | (enumLiteral_3= 'Rook' ) | (enumLiteral_4= 'Queen' ) | (enumLiteral_5= 'King' ) ) ;
    public final Enumerator rulePieceType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;

         enterRule(); 
        try {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:845:28: ( ( (enumLiteral_0= 'Pawn' ) | (enumLiteral_1= 'Knight' ) | (enumLiteral_2= 'Bishop' ) | (enumLiteral_3= 'Rook' ) | (enumLiteral_4= 'Queen' ) | (enumLiteral_5= 'King' ) ) )
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:846:1: ( (enumLiteral_0= 'Pawn' ) | (enumLiteral_1= 'Knight' ) | (enumLiteral_2= 'Bishop' ) | (enumLiteral_3= 'Rook' ) | (enumLiteral_4= 'Queen' ) | (enumLiteral_5= 'King' ) )
            {
            // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:846:1: ( (enumLiteral_0= 'Pawn' ) | (enumLiteral_1= 'Knight' ) | (enumLiteral_2= 'Bishop' ) | (enumLiteral_3= 'Rook' ) | (enumLiteral_4= 'Queen' ) | (enumLiteral_5= 'King' ) )
            int alt2=6;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt2=1;
                }
                break;
            case 24:
                {
                alt2=2;
                }
                break;
            case 25:
                {
                alt2=3;
                }
                break;
            case 26:
                {
                alt2=4;
                }
                break;
            case 27:
                {
                alt2=5;
                }
                break;
            case 28:
                {
                alt2=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:846:2: (enumLiteral_0= 'Pawn' )
                    {
                    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:846:2: (enumLiteral_0= 'Pawn' )
                    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:846:4: enumLiteral_0= 'Pawn'
                    {
                    enumLiteral_0=(Token)match(input,23,FOLLOW_23_in_rulePieceType1584); 

                            current = grammarAccess.getPieceTypeAccess().getPAWNEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getPieceTypeAccess().getPAWNEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:852:6: (enumLiteral_1= 'Knight' )
                    {
                    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:852:6: (enumLiteral_1= 'Knight' )
                    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:852:8: enumLiteral_1= 'Knight'
                    {
                    enumLiteral_1=(Token)match(input,24,FOLLOW_24_in_rulePieceType1601); 

                            current = grammarAccess.getPieceTypeAccess().getKNIGHTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getPieceTypeAccess().getKNIGHTEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:858:6: (enumLiteral_2= 'Bishop' )
                    {
                    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:858:6: (enumLiteral_2= 'Bishop' )
                    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:858:8: enumLiteral_2= 'Bishop'
                    {
                    enumLiteral_2=(Token)match(input,25,FOLLOW_25_in_rulePieceType1618); 

                            current = grammarAccess.getPieceTypeAccess().getBISHOPEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getPieceTypeAccess().getBISHOPEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:864:6: (enumLiteral_3= 'Rook' )
                    {
                    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:864:6: (enumLiteral_3= 'Rook' )
                    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:864:8: enumLiteral_3= 'Rook'
                    {
                    enumLiteral_3=(Token)match(input,26,FOLLOW_26_in_rulePieceType1635); 

                            current = grammarAccess.getPieceTypeAccess().getROOKEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getPieceTypeAccess().getROOKEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:870:6: (enumLiteral_4= 'Queen' )
                    {
                    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:870:6: (enumLiteral_4= 'Queen' )
                    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:870:8: enumLiteral_4= 'Queen'
                    {
                    enumLiteral_4=(Token)match(input,27,FOLLOW_27_in_rulePieceType1652); 

                            current = grammarAccess.getPieceTypeAccess().getQUEENEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getPieceTypeAccess().getQUEENEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:876:6: (enumLiteral_5= 'King' )
                    {
                    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:876:6: (enumLiteral_5= 'King' )
                    // ../no.pdigre.psqt/src-gen/no/pdigre/parser/antlr/internal/InternalPSQT.g:876:8: enumLiteral_5= 'King'
                    {
                    enumLiteral_5=(Token)match(input,28,FOLLOW_28_in_rulePieceType1669); 

                            current = grammarAccess.getPieceTypeAccess().getKINGEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getPieceTypeAccess().getKINGEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePieceType"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFDescription_in_ruleModel132 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_ruleTable_in_ruleModel152 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_ruleFDescription_in_entryRuleFDescription189 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFDescription199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PSQT_in_ruleFDescription235 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFDescription251 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_BASE_in_ruleFDescription267 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleFDescription283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTable_in_entryRuleTable324 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTable334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTDescription_in_ruleTable381 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_ruleTHeader_in_ruleTable396 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleRow_in_ruleTable416 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleRow_in_ruleTable437 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleRow_in_ruleTable458 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleRow_in_ruleTable479 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleRow_in_ruleTable500 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleRow_in_ruleTable521 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleRow_in_ruleTable542 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleRow_in_ruleTable563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTDescription_in_entryRuleTDescription599 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTDescription609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PIECE_in_ruleTDescription645 = new BitSet(new long[]{0x000000001F800000L});
    public static final BitSet FOLLOW_rulePieceType_in_ruleTDescription665 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_VALUE_in_ruleTDescription676 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTDescription692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTHeader_in_entryRuleTHeader734 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTHeader745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleTHeader783 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleTHeader796 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleTHeader809 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleTHeader822 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleTHeader835 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleTHeader848 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleTHeader861 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleTHeader874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRow_in_entryRuleRow914 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRow924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRowLabel_in_ruleRow970 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleMRow_in_ruleRow991 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleERow_in_ruleRow1012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRowLabel_in_entryRuleRowLabel1049 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRowLabel1060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleRowLabel1099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMRow_in_entryRuleMRow1143 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMRow1153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRow1_in_ruleMRow1198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleERow_in_entryRuleERow1233 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleERow1243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRow1_in_ruleERow1288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRow1_in_entryRuleRow11323 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRow11333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleRow11375 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleRow11397 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleRow11419 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleRow11441 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleRow11463 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleRow11485 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleRow11507 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleRow11529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rulePieceType1584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rulePieceType1601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rulePieceType1618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rulePieceType1635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rulePieceType1652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rulePieceType1669 = new BitSet(new long[]{0x0000000000000002L});

}