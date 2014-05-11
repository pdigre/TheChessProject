package no.pdigre.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import no.pdigre.services.PSQTGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalPSQTParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_PSQT", "RULE_BASE", "RULE_MIDLIMIT", "RULE_ENDLIMIT", "RULE_PIECE", "RULE_MIDGAME", "RULE_ENDGAME", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Pawn'", "'Knight'", "'Bishop'", "'Rook'", "'Queen'", "'King'", "'A'", "'B'", "'C'", "'D'", "'E'", "'F'", "'G'", "'H'"
    };
    public static final int RULE_MIDGAME=10;
    public static final int RULE_ENDGAME=11;
    public static final int RULE_PIECE=9;
    public static final int RULE_STRING=13;
    public static final int RULE_SL_COMMENT=15;
    public static final int T__19=19;
    public static final int RULE_MIDLIMIT=7;
    public static final int RULE_BASE=6;
    public static final int T__18=18;
    public static final int RULE_ENDLIMIT=8;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_ID=12;
    public static final int RULE_WS=16;
    public static final int RULE_ANY_OTHER=17;
    public static final int RULE_PSQT=5;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=4;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=14;
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
    public String getGrammarFileName() { return "../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g"; }


     
     	private PSQTGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(PSQTGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleModel"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:61:1: ( ruleModel EOF )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:62:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel61);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:69:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:73:2: ( ( ( rule__Model__Group__0 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:74:1: ( ( rule__Model__Group__0 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:74:1: ( ( rule__Model__Group__0 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:75:1: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:76:1: ( rule__Model__Group__0 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:76:2: rule__Model__Group__0
            {
            pushFollow(FOLLOW_rule__Model__Group__0_in_ruleModel94);
            rule__Model__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleFDescription"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:88:1: entryRuleFDescription : ruleFDescription EOF ;
    public final void entryRuleFDescription() throws RecognitionException {
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:89:1: ( ruleFDescription EOF )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:90:1: ruleFDescription EOF
            {
             before(grammarAccess.getFDescriptionRule()); 
            pushFollow(FOLLOW_ruleFDescription_in_entryRuleFDescription121);
            ruleFDescription();

            state._fsp--;

             after(grammarAccess.getFDescriptionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFDescription128); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFDescription"


    // $ANTLR start "ruleFDescription"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:97:1: ruleFDescription : ( ( rule__FDescription__Group__0 ) ) ;
    public final void ruleFDescription() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:101:2: ( ( ( rule__FDescription__Group__0 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:102:1: ( ( rule__FDescription__Group__0 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:102:1: ( ( rule__FDescription__Group__0 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:103:1: ( rule__FDescription__Group__0 )
            {
             before(grammarAccess.getFDescriptionAccess().getGroup()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:104:1: ( rule__FDescription__Group__0 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:104:2: rule__FDescription__Group__0
            {
            pushFollow(FOLLOW_rule__FDescription__Group__0_in_ruleFDescription154);
            rule__FDescription__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFDescriptionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFDescription"


    // $ANTLR start "entryRuleTable"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:116:1: entryRuleTable : ruleTable EOF ;
    public final void entryRuleTable() throws RecognitionException {
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:117:1: ( ruleTable EOF )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:118:1: ruleTable EOF
            {
             before(grammarAccess.getTableRule()); 
            pushFollow(FOLLOW_ruleTable_in_entryRuleTable181);
            ruleTable();

            state._fsp--;

             after(grammarAccess.getTableRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTable188); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTable"


    // $ANTLR start "ruleTable"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:125:1: ruleTable : ( ( rule__Table__Group__0 ) ) ;
    public final void ruleTable() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:129:2: ( ( ( rule__Table__Group__0 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:130:1: ( ( rule__Table__Group__0 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:130:1: ( ( rule__Table__Group__0 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:131:1: ( rule__Table__Group__0 )
            {
             before(grammarAccess.getTableAccess().getGroup()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:132:1: ( rule__Table__Group__0 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:132:2: rule__Table__Group__0
            {
            pushFollow(FOLLOW_rule__Table__Group__0_in_ruleTable214);
            rule__Table__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTableAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTable"


    // $ANTLR start "entryRuleTDescription"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:144:1: entryRuleTDescription : ruleTDescription EOF ;
    public final void entryRuleTDescription() throws RecognitionException {
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:145:1: ( ruleTDescription EOF )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:146:1: ruleTDescription EOF
            {
             before(grammarAccess.getTDescriptionRule()); 
            pushFollow(FOLLOW_ruleTDescription_in_entryRuleTDescription241);
            ruleTDescription();

            state._fsp--;

             after(grammarAccess.getTDescriptionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTDescription248); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTDescription"


    // $ANTLR start "ruleTDescription"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:153:1: ruleTDescription : ( ( rule__TDescription__Group__0 ) ) ;
    public final void ruleTDescription() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:157:2: ( ( ( rule__TDescription__Group__0 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:158:1: ( ( rule__TDescription__Group__0 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:158:1: ( ( rule__TDescription__Group__0 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:159:1: ( rule__TDescription__Group__0 )
            {
             before(grammarAccess.getTDescriptionAccess().getGroup()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:160:1: ( rule__TDescription__Group__0 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:160:2: rule__TDescription__Group__0
            {
            pushFollow(FOLLOW_rule__TDescription__Group__0_in_ruleTDescription274);
            rule__TDescription__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTDescriptionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTDescription"


    // $ANTLR start "entryRuleTHeader"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:172:1: entryRuleTHeader : ruleTHeader EOF ;
    public final void entryRuleTHeader() throws RecognitionException {
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:173:1: ( ruleTHeader EOF )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:174:1: ruleTHeader EOF
            {
             before(grammarAccess.getTHeaderRule()); 
            pushFollow(FOLLOW_ruleTHeader_in_entryRuleTHeader301);
            ruleTHeader();

            state._fsp--;

             after(grammarAccess.getTHeaderRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTHeader308); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTHeader"


    // $ANTLR start "ruleTHeader"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:181:1: ruleTHeader : ( ( rule__THeader__Group__0 ) ) ;
    public final void ruleTHeader() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:185:2: ( ( ( rule__THeader__Group__0 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:186:1: ( ( rule__THeader__Group__0 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:186:1: ( ( rule__THeader__Group__0 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:187:1: ( rule__THeader__Group__0 )
            {
             before(grammarAccess.getTHeaderAccess().getGroup()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:188:1: ( rule__THeader__Group__0 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:188:2: rule__THeader__Group__0
            {
            pushFollow(FOLLOW_rule__THeader__Group__0_in_ruleTHeader334);
            rule__THeader__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTHeaderAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTHeader"


    // $ANTLR start "entryRuleRow"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:200:1: entryRuleRow : ruleRow EOF ;
    public final void entryRuleRow() throws RecognitionException {
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:201:1: ( ruleRow EOF )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:202:1: ruleRow EOF
            {
             before(grammarAccess.getRowRule()); 
            pushFollow(FOLLOW_ruleRow_in_entryRuleRow361);
            ruleRow();

            state._fsp--;

             after(grammarAccess.getRowRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRow368); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRow"


    // $ANTLR start "ruleRow"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:209:1: ruleRow : ( ( rule__Row__Group__0 ) ) ;
    public final void ruleRow() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:213:2: ( ( ( rule__Row__Group__0 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:214:1: ( ( rule__Row__Group__0 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:214:1: ( ( rule__Row__Group__0 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:215:1: ( rule__Row__Group__0 )
            {
             before(grammarAccess.getRowAccess().getGroup()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:216:1: ( rule__Row__Group__0 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:216:2: rule__Row__Group__0
            {
            pushFollow(FOLLOW_rule__Row__Group__0_in_ruleRow394);
            rule__Row__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRowAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRow"


    // $ANTLR start "entryRuleRowLabel"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:228:1: entryRuleRowLabel : ruleRowLabel EOF ;
    public final void entryRuleRowLabel() throws RecognitionException {
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:229:1: ( ruleRowLabel EOF )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:230:1: ruleRowLabel EOF
            {
             before(grammarAccess.getRowLabelRule()); 
            pushFollow(FOLLOW_ruleRowLabel_in_entryRuleRowLabel421);
            ruleRowLabel();

            state._fsp--;

             after(grammarAccess.getRowLabelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRowLabel428); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRowLabel"


    // $ANTLR start "ruleRowLabel"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:237:1: ruleRowLabel : ( RULE_INT ) ;
    public final void ruleRowLabel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:241:2: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:242:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:242:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:243:1: RULE_INT
            {
             before(grammarAccess.getRowLabelAccess().getINTTerminalRuleCall()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleRowLabel454); 
             after(grammarAccess.getRowLabelAccess().getINTTerminalRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRowLabel"


    // $ANTLR start "entryRuleMRow"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:256:1: entryRuleMRow : ruleMRow EOF ;
    public final void entryRuleMRow() throws RecognitionException {
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:257:1: ( ruleMRow EOF )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:258:1: ruleMRow EOF
            {
             before(grammarAccess.getMRowRule()); 
            pushFollow(FOLLOW_ruleMRow_in_entryRuleMRow480);
            ruleMRow();

            state._fsp--;

             after(grammarAccess.getMRowRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMRow487); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMRow"


    // $ANTLR start "ruleMRow"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:265:1: ruleMRow : ( ( rule__MRow__NameAssignment ) ) ;
    public final void ruleMRow() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:269:2: ( ( ( rule__MRow__NameAssignment ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:270:1: ( ( rule__MRow__NameAssignment ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:270:1: ( ( rule__MRow__NameAssignment ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:271:1: ( rule__MRow__NameAssignment )
            {
             before(grammarAccess.getMRowAccess().getNameAssignment()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:272:1: ( rule__MRow__NameAssignment )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:272:2: rule__MRow__NameAssignment
            {
            pushFollow(FOLLOW_rule__MRow__NameAssignment_in_ruleMRow513);
            rule__MRow__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getMRowAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMRow"


    // $ANTLR start "entryRuleERow"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:284:1: entryRuleERow : ruleERow EOF ;
    public final void entryRuleERow() throws RecognitionException {
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:285:1: ( ruleERow EOF )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:286:1: ruleERow EOF
            {
             before(grammarAccess.getERowRule()); 
            pushFollow(FOLLOW_ruleERow_in_entryRuleERow540);
            ruleERow();

            state._fsp--;

             after(grammarAccess.getERowRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleERow547); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleERow"


    // $ANTLR start "ruleERow"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:293:1: ruleERow : ( ( rule__ERow__NameAssignment ) ) ;
    public final void ruleERow() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:297:2: ( ( ( rule__ERow__NameAssignment ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:298:1: ( ( rule__ERow__NameAssignment ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:298:1: ( ( rule__ERow__NameAssignment ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:299:1: ( rule__ERow__NameAssignment )
            {
             before(grammarAccess.getERowAccess().getNameAssignment()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:300:1: ( rule__ERow__NameAssignment )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:300:2: rule__ERow__NameAssignment
            {
            pushFollow(FOLLOW_rule__ERow__NameAssignment_in_ruleERow573);
            rule__ERow__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getERowAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleERow"


    // $ANTLR start "entryRuleRow1"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:312:1: entryRuleRow1 : ruleRow1 EOF ;
    public final void entryRuleRow1() throws RecognitionException {
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:313:1: ( ruleRow1 EOF )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:314:1: ruleRow1 EOF
            {
             before(grammarAccess.getRow1Rule()); 
            pushFollow(FOLLOW_ruleRow1_in_entryRuleRow1600);
            ruleRow1();

            state._fsp--;

             after(grammarAccess.getRow1Rule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRow1607); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRow1"


    // $ANTLR start "ruleRow1"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:321:1: ruleRow1 : ( ( rule__Row1__Group__0 ) ) ;
    public final void ruleRow1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:325:2: ( ( ( rule__Row1__Group__0 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:326:1: ( ( rule__Row1__Group__0 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:326:1: ( ( rule__Row1__Group__0 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:327:1: ( rule__Row1__Group__0 )
            {
             before(grammarAccess.getRow1Access().getGroup()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:328:1: ( rule__Row1__Group__0 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:328:2: rule__Row1__Group__0
            {
            pushFollow(FOLLOW_rule__Row1__Group__0_in_ruleRow1633);
            rule__Row1__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRow1Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRow1"


    // $ANTLR start "rulePieceType"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:341:1: rulePieceType : ( ( rule__PieceType__Alternatives ) ) ;
    public final void rulePieceType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:345:1: ( ( ( rule__PieceType__Alternatives ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:346:1: ( ( rule__PieceType__Alternatives ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:346:1: ( ( rule__PieceType__Alternatives ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:347:1: ( rule__PieceType__Alternatives )
            {
             before(grammarAccess.getPieceTypeAccess().getAlternatives()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:348:1: ( rule__PieceType__Alternatives )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:348:2: rule__PieceType__Alternatives
            {
            pushFollow(FOLLOW_rule__PieceType__Alternatives_in_rulePieceType670);
            rule__PieceType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPieceTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePieceType"


    // $ANTLR start "rule__PieceType__Alternatives"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:359:1: rule__PieceType__Alternatives : ( ( ( 'Pawn' ) ) | ( ( 'Knight' ) ) | ( ( 'Bishop' ) ) | ( ( 'Rook' ) ) | ( ( 'Queen' ) ) | ( ( 'King' ) ) );
    public final void rule__PieceType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:363:1: ( ( ( 'Pawn' ) ) | ( ( 'Knight' ) ) | ( ( 'Bishop' ) ) | ( ( 'Rook' ) ) | ( ( 'Queen' ) ) | ( ( 'King' ) ) )
            int alt1=6;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt1=1;
                }
                break;
            case 19:
                {
                alt1=2;
                }
                break;
            case 20:
                {
                alt1=3;
                }
                break;
            case 21:
                {
                alt1=4;
                }
                break;
            case 22:
                {
                alt1=5;
                }
                break;
            case 23:
                {
                alt1=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:364:1: ( ( 'Pawn' ) )
                    {
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:364:1: ( ( 'Pawn' ) )
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:365:1: ( 'Pawn' )
                    {
                     before(grammarAccess.getPieceTypeAccess().getPAWNEnumLiteralDeclaration_0()); 
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:366:1: ( 'Pawn' )
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:366:3: 'Pawn'
                    {
                    match(input,18,FOLLOW_18_in_rule__PieceType__Alternatives706); 

                    }

                     after(grammarAccess.getPieceTypeAccess().getPAWNEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:371:6: ( ( 'Knight' ) )
                    {
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:371:6: ( ( 'Knight' ) )
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:372:1: ( 'Knight' )
                    {
                     before(grammarAccess.getPieceTypeAccess().getKNIGHTEnumLiteralDeclaration_1()); 
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:373:1: ( 'Knight' )
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:373:3: 'Knight'
                    {
                    match(input,19,FOLLOW_19_in_rule__PieceType__Alternatives727); 

                    }

                     after(grammarAccess.getPieceTypeAccess().getKNIGHTEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:378:6: ( ( 'Bishop' ) )
                    {
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:378:6: ( ( 'Bishop' ) )
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:379:1: ( 'Bishop' )
                    {
                     before(grammarAccess.getPieceTypeAccess().getBISHOPEnumLiteralDeclaration_2()); 
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:380:1: ( 'Bishop' )
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:380:3: 'Bishop'
                    {
                    match(input,20,FOLLOW_20_in_rule__PieceType__Alternatives748); 

                    }

                     after(grammarAccess.getPieceTypeAccess().getBISHOPEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:385:6: ( ( 'Rook' ) )
                    {
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:385:6: ( ( 'Rook' ) )
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:386:1: ( 'Rook' )
                    {
                     before(grammarAccess.getPieceTypeAccess().getROOKEnumLiteralDeclaration_3()); 
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:387:1: ( 'Rook' )
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:387:3: 'Rook'
                    {
                    match(input,21,FOLLOW_21_in_rule__PieceType__Alternatives769); 

                    }

                     after(grammarAccess.getPieceTypeAccess().getROOKEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:392:6: ( ( 'Queen' ) )
                    {
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:392:6: ( ( 'Queen' ) )
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:393:1: ( 'Queen' )
                    {
                     before(grammarAccess.getPieceTypeAccess().getQUEENEnumLiteralDeclaration_4()); 
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:394:1: ( 'Queen' )
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:394:3: 'Queen'
                    {
                    match(input,22,FOLLOW_22_in_rule__PieceType__Alternatives790); 

                    }

                     after(grammarAccess.getPieceTypeAccess().getQUEENEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:399:6: ( ( 'King' ) )
                    {
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:399:6: ( ( 'King' ) )
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:400:1: ( 'King' )
                    {
                     before(grammarAccess.getPieceTypeAccess().getKINGEnumLiteralDeclaration_5()); 
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:401:1: ( 'King' )
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:401:3: 'King'
                    {
                    match(input,23,FOLLOW_23_in_rule__PieceType__Alternatives811); 

                    }

                     after(grammarAccess.getPieceTypeAccess().getKINGEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PieceType__Alternatives"


    // $ANTLR start "rule__Model__Group__0"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:413:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:417:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:418:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__0844);
            rule__Model__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__1_in_rule__Model__Group__0847);
            rule__Model__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0"


    // $ANTLR start "rule__Model__Group__0__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:425:1: rule__Model__Group__0__Impl : ( ruleFDescription ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:429:1: ( ( ruleFDescription ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:430:1: ( ruleFDescription )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:430:1: ( ruleFDescription )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:431:1: ruleFDescription
            {
             before(grammarAccess.getModelAccess().getFDescriptionParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleFDescription_in_rule__Model__Group__0__Impl874);
            ruleFDescription();

            state._fsp--;

             after(grammarAccess.getModelAccess().getFDescriptionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0__Impl"


    // $ANTLR start "rule__Model__Group__1"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:442:1: rule__Model__Group__1 : rule__Model__Group__1__Impl ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:446:1: ( rule__Model__Group__1__Impl )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:447:2: rule__Model__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__1903);
            rule__Model__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1"


    // $ANTLR start "rule__Model__Group__1__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:453:1: rule__Model__Group__1__Impl : ( ( rule__Model__TablesAssignment_1 )* ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:457:1: ( ( ( rule__Model__TablesAssignment_1 )* ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:458:1: ( ( rule__Model__TablesAssignment_1 )* )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:458:1: ( ( rule__Model__TablesAssignment_1 )* )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:459:1: ( rule__Model__TablesAssignment_1 )*
            {
             before(grammarAccess.getModelAccess().getTablesAssignment_1()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:460:1: ( rule__Model__TablesAssignment_1 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_PIECE) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:460:2: rule__Model__TablesAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__Model__TablesAssignment_1_in_rule__Model__Group__1__Impl930);
            	    rule__Model__TablesAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getTablesAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1__Impl"


    // $ANTLR start "rule__FDescription__Group__0"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:474:1: rule__FDescription__Group__0 : rule__FDescription__Group__0__Impl rule__FDescription__Group__1 ;
    public final void rule__FDescription__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:478:1: ( rule__FDescription__Group__0__Impl rule__FDescription__Group__1 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:479:2: rule__FDescription__Group__0__Impl rule__FDescription__Group__1
            {
            pushFollow(FOLLOW_rule__FDescription__Group__0__Impl_in_rule__FDescription__Group__0965);
            rule__FDescription__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FDescription__Group__1_in_rule__FDescription__Group__0968);
            rule__FDescription__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FDescription__Group__0"


    // $ANTLR start "rule__FDescription__Group__0__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:486:1: rule__FDescription__Group__0__Impl : ( RULE_PSQT ) ;
    public final void rule__FDescription__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:490:1: ( ( RULE_PSQT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:491:1: ( RULE_PSQT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:491:1: ( RULE_PSQT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:492:1: RULE_PSQT
            {
             before(grammarAccess.getFDescriptionAccess().getPSQTTerminalRuleCall_0()); 
            match(input,RULE_PSQT,FOLLOW_RULE_PSQT_in_rule__FDescription__Group__0__Impl995); 
             after(grammarAccess.getFDescriptionAccess().getPSQTTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FDescription__Group__0__Impl"


    // $ANTLR start "rule__FDescription__Group__1"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:503:1: rule__FDescription__Group__1 : rule__FDescription__Group__1__Impl rule__FDescription__Group__2 ;
    public final void rule__FDescription__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:507:1: ( rule__FDescription__Group__1__Impl rule__FDescription__Group__2 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:508:2: rule__FDescription__Group__1__Impl rule__FDescription__Group__2
            {
            pushFollow(FOLLOW_rule__FDescription__Group__1__Impl_in_rule__FDescription__Group__11024);
            rule__FDescription__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FDescription__Group__2_in_rule__FDescription__Group__11027);
            rule__FDescription__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FDescription__Group__1"


    // $ANTLR start "rule__FDescription__Group__1__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:515:1: rule__FDescription__Group__1__Impl : ( ( rule__FDescription__NameAssignment_1 ) ) ;
    public final void rule__FDescription__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:519:1: ( ( ( rule__FDescription__NameAssignment_1 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:520:1: ( ( rule__FDescription__NameAssignment_1 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:520:1: ( ( rule__FDescription__NameAssignment_1 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:521:1: ( rule__FDescription__NameAssignment_1 )
            {
             before(grammarAccess.getFDescriptionAccess().getNameAssignment_1()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:522:1: ( rule__FDescription__NameAssignment_1 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:522:2: rule__FDescription__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__FDescription__NameAssignment_1_in_rule__FDescription__Group__1__Impl1054);
            rule__FDescription__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getFDescriptionAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FDescription__Group__1__Impl"


    // $ANTLR start "rule__FDescription__Group__2"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:532:1: rule__FDescription__Group__2 : rule__FDescription__Group__2__Impl rule__FDescription__Group__3 ;
    public final void rule__FDescription__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:536:1: ( rule__FDescription__Group__2__Impl rule__FDescription__Group__3 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:537:2: rule__FDescription__Group__2__Impl rule__FDescription__Group__3
            {
            pushFollow(FOLLOW_rule__FDescription__Group__2__Impl_in_rule__FDescription__Group__21084);
            rule__FDescription__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FDescription__Group__3_in_rule__FDescription__Group__21087);
            rule__FDescription__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FDescription__Group__2"


    // $ANTLR start "rule__FDescription__Group__2__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:544:1: rule__FDescription__Group__2__Impl : ( RULE_BASE ) ;
    public final void rule__FDescription__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:548:1: ( ( RULE_BASE ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:549:1: ( RULE_BASE )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:549:1: ( RULE_BASE )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:550:1: RULE_BASE
            {
             before(grammarAccess.getFDescriptionAccess().getBASETerminalRuleCall_2()); 
            match(input,RULE_BASE,FOLLOW_RULE_BASE_in_rule__FDescription__Group__2__Impl1114); 
             after(grammarAccess.getFDescriptionAccess().getBASETerminalRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FDescription__Group__2__Impl"


    // $ANTLR start "rule__FDescription__Group__3"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:561:1: rule__FDescription__Group__3 : rule__FDescription__Group__3__Impl rule__FDescription__Group__4 ;
    public final void rule__FDescription__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:565:1: ( rule__FDescription__Group__3__Impl rule__FDescription__Group__4 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:566:2: rule__FDescription__Group__3__Impl rule__FDescription__Group__4
            {
            pushFollow(FOLLOW_rule__FDescription__Group__3__Impl_in_rule__FDescription__Group__31143);
            rule__FDescription__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FDescription__Group__4_in_rule__FDescription__Group__31146);
            rule__FDescription__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FDescription__Group__3"


    // $ANTLR start "rule__FDescription__Group__3__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:573:1: rule__FDescription__Group__3__Impl : ( ( rule__FDescription__BaseAssignment_3 ) ) ;
    public final void rule__FDescription__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:577:1: ( ( ( rule__FDescription__BaseAssignment_3 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:578:1: ( ( rule__FDescription__BaseAssignment_3 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:578:1: ( ( rule__FDescription__BaseAssignment_3 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:579:1: ( rule__FDescription__BaseAssignment_3 )
            {
             before(grammarAccess.getFDescriptionAccess().getBaseAssignment_3()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:580:1: ( rule__FDescription__BaseAssignment_3 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:580:2: rule__FDescription__BaseAssignment_3
            {
            pushFollow(FOLLOW_rule__FDescription__BaseAssignment_3_in_rule__FDescription__Group__3__Impl1173);
            rule__FDescription__BaseAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getFDescriptionAccess().getBaseAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FDescription__Group__3__Impl"


    // $ANTLR start "rule__FDescription__Group__4"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:590:1: rule__FDescription__Group__4 : rule__FDescription__Group__4__Impl rule__FDescription__Group__5 ;
    public final void rule__FDescription__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:594:1: ( rule__FDescription__Group__4__Impl rule__FDescription__Group__5 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:595:2: rule__FDescription__Group__4__Impl rule__FDescription__Group__5
            {
            pushFollow(FOLLOW_rule__FDescription__Group__4__Impl_in_rule__FDescription__Group__41203);
            rule__FDescription__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FDescription__Group__5_in_rule__FDescription__Group__41206);
            rule__FDescription__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FDescription__Group__4"


    // $ANTLR start "rule__FDescription__Group__4__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:602:1: rule__FDescription__Group__4__Impl : ( RULE_MIDLIMIT ) ;
    public final void rule__FDescription__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:606:1: ( ( RULE_MIDLIMIT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:607:1: ( RULE_MIDLIMIT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:607:1: ( RULE_MIDLIMIT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:608:1: RULE_MIDLIMIT
            {
             before(grammarAccess.getFDescriptionAccess().getMIDLIMITTerminalRuleCall_4()); 
            match(input,RULE_MIDLIMIT,FOLLOW_RULE_MIDLIMIT_in_rule__FDescription__Group__4__Impl1233); 
             after(grammarAccess.getFDescriptionAccess().getMIDLIMITTerminalRuleCall_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FDescription__Group__4__Impl"


    // $ANTLR start "rule__FDescription__Group__5"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:619:1: rule__FDescription__Group__5 : rule__FDescription__Group__5__Impl rule__FDescription__Group__6 ;
    public final void rule__FDescription__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:623:1: ( rule__FDescription__Group__5__Impl rule__FDescription__Group__6 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:624:2: rule__FDescription__Group__5__Impl rule__FDescription__Group__6
            {
            pushFollow(FOLLOW_rule__FDescription__Group__5__Impl_in_rule__FDescription__Group__51262);
            rule__FDescription__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FDescription__Group__6_in_rule__FDescription__Group__51265);
            rule__FDescription__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FDescription__Group__5"


    // $ANTLR start "rule__FDescription__Group__5__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:631:1: rule__FDescription__Group__5__Impl : ( ( rule__FDescription__MglAssignment_5 ) ) ;
    public final void rule__FDescription__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:635:1: ( ( ( rule__FDescription__MglAssignment_5 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:636:1: ( ( rule__FDescription__MglAssignment_5 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:636:1: ( ( rule__FDescription__MglAssignment_5 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:637:1: ( rule__FDescription__MglAssignment_5 )
            {
             before(grammarAccess.getFDescriptionAccess().getMglAssignment_5()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:638:1: ( rule__FDescription__MglAssignment_5 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:638:2: rule__FDescription__MglAssignment_5
            {
            pushFollow(FOLLOW_rule__FDescription__MglAssignment_5_in_rule__FDescription__Group__5__Impl1292);
            rule__FDescription__MglAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getFDescriptionAccess().getMglAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FDescription__Group__5__Impl"


    // $ANTLR start "rule__FDescription__Group__6"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:648:1: rule__FDescription__Group__6 : rule__FDescription__Group__6__Impl rule__FDescription__Group__7 ;
    public final void rule__FDescription__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:652:1: ( rule__FDescription__Group__6__Impl rule__FDescription__Group__7 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:653:2: rule__FDescription__Group__6__Impl rule__FDescription__Group__7
            {
            pushFollow(FOLLOW_rule__FDescription__Group__6__Impl_in_rule__FDescription__Group__61322);
            rule__FDescription__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FDescription__Group__7_in_rule__FDescription__Group__61325);
            rule__FDescription__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FDescription__Group__6"


    // $ANTLR start "rule__FDescription__Group__6__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:660:1: rule__FDescription__Group__6__Impl : ( RULE_ENDLIMIT ) ;
    public final void rule__FDescription__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:664:1: ( ( RULE_ENDLIMIT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:665:1: ( RULE_ENDLIMIT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:665:1: ( RULE_ENDLIMIT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:666:1: RULE_ENDLIMIT
            {
             before(grammarAccess.getFDescriptionAccess().getENDLIMITTerminalRuleCall_6()); 
            match(input,RULE_ENDLIMIT,FOLLOW_RULE_ENDLIMIT_in_rule__FDescription__Group__6__Impl1352); 
             after(grammarAccess.getFDescriptionAccess().getENDLIMITTerminalRuleCall_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FDescription__Group__6__Impl"


    // $ANTLR start "rule__FDescription__Group__7"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:677:1: rule__FDescription__Group__7 : rule__FDescription__Group__7__Impl ;
    public final void rule__FDescription__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:681:1: ( rule__FDescription__Group__7__Impl )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:682:2: rule__FDescription__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__FDescription__Group__7__Impl_in_rule__FDescription__Group__71381);
            rule__FDescription__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FDescription__Group__7"


    // $ANTLR start "rule__FDescription__Group__7__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:688:1: rule__FDescription__Group__7__Impl : ( ( rule__FDescription__EglAssignment_7 ) ) ;
    public final void rule__FDescription__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:692:1: ( ( ( rule__FDescription__EglAssignment_7 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:693:1: ( ( rule__FDescription__EglAssignment_7 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:693:1: ( ( rule__FDescription__EglAssignment_7 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:694:1: ( rule__FDescription__EglAssignment_7 )
            {
             before(grammarAccess.getFDescriptionAccess().getEglAssignment_7()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:695:1: ( rule__FDescription__EglAssignment_7 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:695:2: rule__FDescription__EglAssignment_7
            {
            pushFollow(FOLLOW_rule__FDescription__EglAssignment_7_in_rule__FDescription__Group__7__Impl1408);
            rule__FDescription__EglAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getFDescriptionAccess().getEglAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FDescription__Group__7__Impl"


    // $ANTLR start "rule__Table__Group__0"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:721:1: rule__Table__Group__0 : rule__Table__Group__0__Impl rule__Table__Group__1 ;
    public final void rule__Table__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:725:1: ( rule__Table__Group__0__Impl rule__Table__Group__1 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:726:2: rule__Table__Group__0__Impl rule__Table__Group__1
            {
            pushFollow(FOLLOW_rule__Table__Group__0__Impl_in_rule__Table__Group__01454);
            rule__Table__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Table__Group__1_in_rule__Table__Group__01457);
            rule__Table__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__0"


    // $ANTLR start "rule__Table__Group__0__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:733:1: rule__Table__Group__0__Impl : ( ruleTDescription ) ;
    public final void rule__Table__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:737:1: ( ( ruleTDescription ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:738:1: ( ruleTDescription )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:738:1: ( ruleTDescription )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:739:1: ruleTDescription
            {
             before(grammarAccess.getTableAccess().getTDescriptionParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleTDescription_in_rule__Table__Group__0__Impl1484);
            ruleTDescription();

            state._fsp--;

             after(grammarAccess.getTableAccess().getTDescriptionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__0__Impl"


    // $ANTLR start "rule__Table__Group__1"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:750:1: rule__Table__Group__1 : rule__Table__Group__1__Impl rule__Table__Group__2 ;
    public final void rule__Table__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:754:1: ( rule__Table__Group__1__Impl rule__Table__Group__2 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:755:2: rule__Table__Group__1__Impl rule__Table__Group__2
            {
            pushFollow(FOLLOW_rule__Table__Group__1__Impl_in_rule__Table__Group__11513);
            rule__Table__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Table__Group__2_in_rule__Table__Group__11516);
            rule__Table__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__1"


    // $ANTLR start "rule__Table__Group__1__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:762:1: rule__Table__Group__1__Impl : ( ruleTHeader ) ;
    public final void rule__Table__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:766:1: ( ( ruleTHeader ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:767:1: ( ruleTHeader )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:767:1: ( ruleTHeader )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:768:1: ruleTHeader
            {
             before(grammarAccess.getTableAccess().getTHeaderParserRuleCall_1()); 
            pushFollow(FOLLOW_ruleTHeader_in_rule__Table__Group__1__Impl1543);
            ruleTHeader();

            state._fsp--;

             after(grammarAccess.getTableAccess().getTHeaderParserRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__1__Impl"


    // $ANTLR start "rule__Table__Group__2"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:779:1: rule__Table__Group__2 : rule__Table__Group__2__Impl rule__Table__Group__3 ;
    public final void rule__Table__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:783:1: ( rule__Table__Group__2__Impl rule__Table__Group__3 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:784:2: rule__Table__Group__2__Impl rule__Table__Group__3
            {
            pushFollow(FOLLOW_rule__Table__Group__2__Impl_in_rule__Table__Group__21572);
            rule__Table__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Table__Group__3_in_rule__Table__Group__21575);
            rule__Table__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__2"


    // $ANTLR start "rule__Table__Group__2__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:791:1: rule__Table__Group__2__Impl : ( ( rule__Table__RAssignment_2 ) ) ;
    public final void rule__Table__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:795:1: ( ( ( rule__Table__RAssignment_2 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:796:1: ( ( rule__Table__RAssignment_2 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:796:1: ( ( rule__Table__RAssignment_2 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:797:1: ( rule__Table__RAssignment_2 )
            {
             before(grammarAccess.getTableAccess().getRAssignment_2()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:798:1: ( rule__Table__RAssignment_2 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:798:2: rule__Table__RAssignment_2
            {
            pushFollow(FOLLOW_rule__Table__RAssignment_2_in_rule__Table__Group__2__Impl1602);
            rule__Table__RAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTableAccess().getRAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__2__Impl"


    // $ANTLR start "rule__Table__Group__3"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:808:1: rule__Table__Group__3 : rule__Table__Group__3__Impl rule__Table__Group__4 ;
    public final void rule__Table__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:812:1: ( rule__Table__Group__3__Impl rule__Table__Group__4 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:813:2: rule__Table__Group__3__Impl rule__Table__Group__4
            {
            pushFollow(FOLLOW_rule__Table__Group__3__Impl_in_rule__Table__Group__31632);
            rule__Table__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Table__Group__4_in_rule__Table__Group__31635);
            rule__Table__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__3"


    // $ANTLR start "rule__Table__Group__3__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:820:1: rule__Table__Group__3__Impl : ( ( rule__Table__RAssignment_3 ) ) ;
    public final void rule__Table__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:824:1: ( ( ( rule__Table__RAssignment_3 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:825:1: ( ( rule__Table__RAssignment_3 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:825:1: ( ( rule__Table__RAssignment_3 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:826:1: ( rule__Table__RAssignment_3 )
            {
             before(grammarAccess.getTableAccess().getRAssignment_3()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:827:1: ( rule__Table__RAssignment_3 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:827:2: rule__Table__RAssignment_3
            {
            pushFollow(FOLLOW_rule__Table__RAssignment_3_in_rule__Table__Group__3__Impl1662);
            rule__Table__RAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getTableAccess().getRAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__3__Impl"


    // $ANTLR start "rule__Table__Group__4"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:837:1: rule__Table__Group__4 : rule__Table__Group__4__Impl rule__Table__Group__5 ;
    public final void rule__Table__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:841:1: ( rule__Table__Group__4__Impl rule__Table__Group__5 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:842:2: rule__Table__Group__4__Impl rule__Table__Group__5
            {
            pushFollow(FOLLOW_rule__Table__Group__4__Impl_in_rule__Table__Group__41692);
            rule__Table__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Table__Group__5_in_rule__Table__Group__41695);
            rule__Table__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__4"


    // $ANTLR start "rule__Table__Group__4__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:849:1: rule__Table__Group__4__Impl : ( ( rule__Table__RAssignment_4 ) ) ;
    public final void rule__Table__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:853:1: ( ( ( rule__Table__RAssignment_4 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:854:1: ( ( rule__Table__RAssignment_4 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:854:1: ( ( rule__Table__RAssignment_4 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:855:1: ( rule__Table__RAssignment_4 )
            {
             before(grammarAccess.getTableAccess().getRAssignment_4()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:856:1: ( rule__Table__RAssignment_4 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:856:2: rule__Table__RAssignment_4
            {
            pushFollow(FOLLOW_rule__Table__RAssignment_4_in_rule__Table__Group__4__Impl1722);
            rule__Table__RAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getTableAccess().getRAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__4__Impl"


    // $ANTLR start "rule__Table__Group__5"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:866:1: rule__Table__Group__5 : rule__Table__Group__5__Impl rule__Table__Group__6 ;
    public final void rule__Table__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:870:1: ( rule__Table__Group__5__Impl rule__Table__Group__6 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:871:2: rule__Table__Group__5__Impl rule__Table__Group__6
            {
            pushFollow(FOLLOW_rule__Table__Group__5__Impl_in_rule__Table__Group__51752);
            rule__Table__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Table__Group__6_in_rule__Table__Group__51755);
            rule__Table__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__5"


    // $ANTLR start "rule__Table__Group__5__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:878:1: rule__Table__Group__5__Impl : ( ( rule__Table__RAssignment_5 ) ) ;
    public final void rule__Table__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:882:1: ( ( ( rule__Table__RAssignment_5 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:883:1: ( ( rule__Table__RAssignment_5 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:883:1: ( ( rule__Table__RAssignment_5 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:884:1: ( rule__Table__RAssignment_5 )
            {
             before(grammarAccess.getTableAccess().getRAssignment_5()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:885:1: ( rule__Table__RAssignment_5 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:885:2: rule__Table__RAssignment_5
            {
            pushFollow(FOLLOW_rule__Table__RAssignment_5_in_rule__Table__Group__5__Impl1782);
            rule__Table__RAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getTableAccess().getRAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__5__Impl"


    // $ANTLR start "rule__Table__Group__6"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:895:1: rule__Table__Group__6 : rule__Table__Group__6__Impl rule__Table__Group__7 ;
    public final void rule__Table__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:899:1: ( rule__Table__Group__6__Impl rule__Table__Group__7 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:900:2: rule__Table__Group__6__Impl rule__Table__Group__7
            {
            pushFollow(FOLLOW_rule__Table__Group__6__Impl_in_rule__Table__Group__61812);
            rule__Table__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Table__Group__7_in_rule__Table__Group__61815);
            rule__Table__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__6"


    // $ANTLR start "rule__Table__Group__6__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:907:1: rule__Table__Group__6__Impl : ( ( rule__Table__RAssignment_6 ) ) ;
    public final void rule__Table__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:911:1: ( ( ( rule__Table__RAssignment_6 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:912:1: ( ( rule__Table__RAssignment_6 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:912:1: ( ( rule__Table__RAssignment_6 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:913:1: ( rule__Table__RAssignment_6 )
            {
             before(grammarAccess.getTableAccess().getRAssignment_6()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:914:1: ( rule__Table__RAssignment_6 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:914:2: rule__Table__RAssignment_6
            {
            pushFollow(FOLLOW_rule__Table__RAssignment_6_in_rule__Table__Group__6__Impl1842);
            rule__Table__RAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getTableAccess().getRAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__6__Impl"


    // $ANTLR start "rule__Table__Group__7"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:924:1: rule__Table__Group__7 : rule__Table__Group__7__Impl rule__Table__Group__8 ;
    public final void rule__Table__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:928:1: ( rule__Table__Group__7__Impl rule__Table__Group__8 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:929:2: rule__Table__Group__7__Impl rule__Table__Group__8
            {
            pushFollow(FOLLOW_rule__Table__Group__7__Impl_in_rule__Table__Group__71872);
            rule__Table__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Table__Group__8_in_rule__Table__Group__71875);
            rule__Table__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__7"


    // $ANTLR start "rule__Table__Group__7__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:936:1: rule__Table__Group__7__Impl : ( ( rule__Table__RAssignment_7 ) ) ;
    public final void rule__Table__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:940:1: ( ( ( rule__Table__RAssignment_7 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:941:1: ( ( rule__Table__RAssignment_7 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:941:1: ( ( rule__Table__RAssignment_7 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:942:1: ( rule__Table__RAssignment_7 )
            {
             before(grammarAccess.getTableAccess().getRAssignment_7()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:943:1: ( rule__Table__RAssignment_7 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:943:2: rule__Table__RAssignment_7
            {
            pushFollow(FOLLOW_rule__Table__RAssignment_7_in_rule__Table__Group__7__Impl1902);
            rule__Table__RAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getTableAccess().getRAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__7__Impl"


    // $ANTLR start "rule__Table__Group__8"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:953:1: rule__Table__Group__8 : rule__Table__Group__8__Impl rule__Table__Group__9 ;
    public final void rule__Table__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:957:1: ( rule__Table__Group__8__Impl rule__Table__Group__9 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:958:2: rule__Table__Group__8__Impl rule__Table__Group__9
            {
            pushFollow(FOLLOW_rule__Table__Group__8__Impl_in_rule__Table__Group__81932);
            rule__Table__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Table__Group__9_in_rule__Table__Group__81935);
            rule__Table__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__8"


    // $ANTLR start "rule__Table__Group__8__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:965:1: rule__Table__Group__8__Impl : ( ( rule__Table__RAssignment_8 ) ) ;
    public final void rule__Table__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:969:1: ( ( ( rule__Table__RAssignment_8 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:970:1: ( ( rule__Table__RAssignment_8 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:970:1: ( ( rule__Table__RAssignment_8 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:971:1: ( rule__Table__RAssignment_8 )
            {
             before(grammarAccess.getTableAccess().getRAssignment_8()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:972:1: ( rule__Table__RAssignment_8 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:972:2: rule__Table__RAssignment_8
            {
            pushFollow(FOLLOW_rule__Table__RAssignment_8_in_rule__Table__Group__8__Impl1962);
            rule__Table__RAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getTableAccess().getRAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__8__Impl"


    // $ANTLR start "rule__Table__Group__9"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:982:1: rule__Table__Group__9 : rule__Table__Group__9__Impl ;
    public final void rule__Table__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:986:1: ( rule__Table__Group__9__Impl )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:987:2: rule__Table__Group__9__Impl
            {
            pushFollow(FOLLOW_rule__Table__Group__9__Impl_in_rule__Table__Group__91992);
            rule__Table__Group__9__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__9"


    // $ANTLR start "rule__Table__Group__9__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:993:1: rule__Table__Group__9__Impl : ( ( rule__Table__RAssignment_9 ) ) ;
    public final void rule__Table__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:997:1: ( ( ( rule__Table__RAssignment_9 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:998:1: ( ( rule__Table__RAssignment_9 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:998:1: ( ( rule__Table__RAssignment_9 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:999:1: ( rule__Table__RAssignment_9 )
            {
             before(grammarAccess.getTableAccess().getRAssignment_9()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1000:1: ( rule__Table__RAssignment_9 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1000:2: rule__Table__RAssignment_9
            {
            pushFollow(FOLLOW_rule__Table__RAssignment_9_in_rule__Table__Group__9__Impl2019);
            rule__Table__RAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getTableAccess().getRAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__9__Impl"


    // $ANTLR start "rule__TDescription__Group__0"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1030:1: rule__TDescription__Group__0 : rule__TDescription__Group__0__Impl rule__TDescription__Group__1 ;
    public final void rule__TDescription__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1034:1: ( rule__TDescription__Group__0__Impl rule__TDescription__Group__1 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1035:2: rule__TDescription__Group__0__Impl rule__TDescription__Group__1
            {
            pushFollow(FOLLOW_rule__TDescription__Group__0__Impl_in_rule__TDescription__Group__02069);
            rule__TDescription__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TDescription__Group__1_in_rule__TDescription__Group__02072);
            rule__TDescription__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TDescription__Group__0"


    // $ANTLR start "rule__TDescription__Group__0__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1042:1: rule__TDescription__Group__0__Impl : ( RULE_PIECE ) ;
    public final void rule__TDescription__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1046:1: ( ( RULE_PIECE ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1047:1: ( RULE_PIECE )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1047:1: ( RULE_PIECE )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1048:1: RULE_PIECE
            {
             before(grammarAccess.getTDescriptionAccess().getPIECETerminalRuleCall_0()); 
            match(input,RULE_PIECE,FOLLOW_RULE_PIECE_in_rule__TDescription__Group__0__Impl2099); 
             after(grammarAccess.getTDescriptionAccess().getPIECETerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TDescription__Group__0__Impl"


    // $ANTLR start "rule__TDescription__Group__1"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1059:1: rule__TDescription__Group__1 : rule__TDescription__Group__1__Impl rule__TDescription__Group__2 ;
    public final void rule__TDescription__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1063:1: ( rule__TDescription__Group__1__Impl rule__TDescription__Group__2 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1064:2: rule__TDescription__Group__1__Impl rule__TDescription__Group__2
            {
            pushFollow(FOLLOW_rule__TDescription__Group__1__Impl_in_rule__TDescription__Group__12128);
            rule__TDescription__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TDescription__Group__2_in_rule__TDescription__Group__12131);
            rule__TDescription__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TDescription__Group__1"


    // $ANTLR start "rule__TDescription__Group__1__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1071:1: rule__TDescription__Group__1__Impl : ( ( rule__TDescription__NameAssignment_1 ) ) ;
    public final void rule__TDescription__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1075:1: ( ( ( rule__TDescription__NameAssignment_1 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1076:1: ( ( rule__TDescription__NameAssignment_1 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1076:1: ( ( rule__TDescription__NameAssignment_1 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1077:1: ( rule__TDescription__NameAssignment_1 )
            {
             before(grammarAccess.getTDescriptionAccess().getNameAssignment_1()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1078:1: ( rule__TDescription__NameAssignment_1 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1078:2: rule__TDescription__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__TDescription__NameAssignment_1_in_rule__TDescription__Group__1__Impl2158);
            rule__TDescription__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTDescriptionAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TDescription__Group__1__Impl"


    // $ANTLR start "rule__TDescription__Group__2"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1088:1: rule__TDescription__Group__2 : rule__TDescription__Group__2__Impl rule__TDescription__Group__3 ;
    public final void rule__TDescription__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1092:1: ( rule__TDescription__Group__2__Impl rule__TDescription__Group__3 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1093:2: rule__TDescription__Group__2__Impl rule__TDescription__Group__3
            {
            pushFollow(FOLLOW_rule__TDescription__Group__2__Impl_in_rule__TDescription__Group__22188);
            rule__TDescription__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TDescription__Group__3_in_rule__TDescription__Group__22191);
            rule__TDescription__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TDescription__Group__2"


    // $ANTLR start "rule__TDescription__Group__2__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1100:1: rule__TDescription__Group__2__Impl : ( RULE_MIDGAME ) ;
    public final void rule__TDescription__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1104:1: ( ( RULE_MIDGAME ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1105:1: ( RULE_MIDGAME )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1105:1: ( RULE_MIDGAME )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1106:1: RULE_MIDGAME
            {
             before(grammarAccess.getTDescriptionAccess().getMIDGAMETerminalRuleCall_2()); 
            match(input,RULE_MIDGAME,FOLLOW_RULE_MIDGAME_in_rule__TDescription__Group__2__Impl2218); 
             after(grammarAccess.getTDescriptionAccess().getMIDGAMETerminalRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TDescription__Group__2__Impl"


    // $ANTLR start "rule__TDescription__Group__3"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1117:1: rule__TDescription__Group__3 : rule__TDescription__Group__3__Impl rule__TDescription__Group__4 ;
    public final void rule__TDescription__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1121:1: ( rule__TDescription__Group__3__Impl rule__TDescription__Group__4 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1122:2: rule__TDescription__Group__3__Impl rule__TDescription__Group__4
            {
            pushFollow(FOLLOW_rule__TDescription__Group__3__Impl_in_rule__TDescription__Group__32247);
            rule__TDescription__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TDescription__Group__4_in_rule__TDescription__Group__32250);
            rule__TDescription__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TDescription__Group__3"


    // $ANTLR start "rule__TDescription__Group__3__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1129:1: rule__TDescription__Group__3__Impl : ( ( rule__TDescription__MgAssignment_3 ) ) ;
    public final void rule__TDescription__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1133:1: ( ( ( rule__TDescription__MgAssignment_3 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1134:1: ( ( rule__TDescription__MgAssignment_3 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1134:1: ( ( rule__TDescription__MgAssignment_3 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1135:1: ( rule__TDescription__MgAssignment_3 )
            {
             before(grammarAccess.getTDescriptionAccess().getMgAssignment_3()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1136:1: ( rule__TDescription__MgAssignment_3 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1136:2: rule__TDescription__MgAssignment_3
            {
            pushFollow(FOLLOW_rule__TDescription__MgAssignment_3_in_rule__TDescription__Group__3__Impl2277);
            rule__TDescription__MgAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getTDescriptionAccess().getMgAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TDescription__Group__3__Impl"


    // $ANTLR start "rule__TDescription__Group__4"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1146:1: rule__TDescription__Group__4 : rule__TDescription__Group__4__Impl rule__TDescription__Group__5 ;
    public final void rule__TDescription__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1150:1: ( rule__TDescription__Group__4__Impl rule__TDescription__Group__5 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1151:2: rule__TDescription__Group__4__Impl rule__TDescription__Group__5
            {
            pushFollow(FOLLOW_rule__TDescription__Group__4__Impl_in_rule__TDescription__Group__42307);
            rule__TDescription__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TDescription__Group__5_in_rule__TDescription__Group__42310);
            rule__TDescription__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TDescription__Group__4"


    // $ANTLR start "rule__TDescription__Group__4__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1158:1: rule__TDescription__Group__4__Impl : ( RULE_ENDGAME ) ;
    public final void rule__TDescription__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1162:1: ( ( RULE_ENDGAME ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1163:1: ( RULE_ENDGAME )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1163:1: ( RULE_ENDGAME )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1164:1: RULE_ENDGAME
            {
             before(grammarAccess.getTDescriptionAccess().getENDGAMETerminalRuleCall_4()); 
            match(input,RULE_ENDGAME,FOLLOW_RULE_ENDGAME_in_rule__TDescription__Group__4__Impl2337); 
             after(grammarAccess.getTDescriptionAccess().getENDGAMETerminalRuleCall_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TDescription__Group__4__Impl"


    // $ANTLR start "rule__TDescription__Group__5"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1175:1: rule__TDescription__Group__5 : rule__TDescription__Group__5__Impl ;
    public final void rule__TDescription__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1179:1: ( rule__TDescription__Group__5__Impl )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1180:2: rule__TDescription__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__TDescription__Group__5__Impl_in_rule__TDescription__Group__52366);
            rule__TDescription__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TDescription__Group__5"


    // $ANTLR start "rule__TDescription__Group__5__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1186:1: rule__TDescription__Group__5__Impl : ( ( rule__TDescription__EgAssignment_5 ) ) ;
    public final void rule__TDescription__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1190:1: ( ( ( rule__TDescription__EgAssignment_5 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1191:1: ( ( rule__TDescription__EgAssignment_5 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1191:1: ( ( rule__TDescription__EgAssignment_5 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1192:1: ( rule__TDescription__EgAssignment_5 )
            {
             before(grammarAccess.getTDescriptionAccess().getEgAssignment_5()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1193:1: ( rule__TDescription__EgAssignment_5 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1193:2: rule__TDescription__EgAssignment_5
            {
            pushFollow(FOLLOW_rule__TDescription__EgAssignment_5_in_rule__TDescription__Group__5__Impl2393);
            rule__TDescription__EgAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getTDescriptionAccess().getEgAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TDescription__Group__5__Impl"


    // $ANTLR start "rule__THeader__Group__0"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1215:1: rule__THeader__Group__0 : rule__THeader__Group__0__Impl rule__THeader__Group__1 ;
    public final void rule__THeader__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1219:1: ( rule__THeader__Group__0__Impl rule__THeader__Group__1 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1220:2: rule__THeader__Group__0__Impl rule__THeader__Group__1
            {
            pushFollow(FOLLOW_rule__THeader__Group__0__Impl_in_rule__THeader__Group__02435);
            rule__THeader__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__THeader__Group__1_in_rule__THeader__Group__02438);
            rule__THeader__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__THeader__Group__0"


    // $ANTLR start "rule__THeader__Group__0__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1227:1: rule__THeader__Group__0__Impl : ( 'A' ) ;
    public final void rule__THeader__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1231:1: ( ( 'A' ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1232:1: ( 'A' )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1232:1: ( 'A' )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1233:1: 'A'
            {
             before(grammarAccess.getTHeaderAccess().getAKeyword_0()); 
            match(input,24,FOLLOW_24_in_rule__THeader__Group__0__Impl2466); 
             after(grammarAccess.getTHeaderAccess().getAKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__THeader__Group__0__Impl"


    // $ANTLR start "rule__THeader__Group__1"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1246:1: rule__THeader__Group__1 : rule__THeader__Group__1__Impl rule__THeader__Group__2 ;
    public final void rule__THeader__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1250:1: ( rule__THeader__Group__1__Impl rule__THeader__Group__2 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1251:2: rule__THeader__Group__1__Impl rule__THeader__Group__2
            {
            pushFollow(FOLLOW_rule__THeader__Group__1__Impl_in_rule__THeader__Group__12497);
            rule__THeader__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__THeader__Group__2_in_rule__THeader__Group__12500);
            rule__THeader__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__THeader__Group__1"


    // $ANTLR start "rule__THeader__Group__1__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1258:1: rule__THeader__Group__1__Impl : ( 'B' ) ;
    public final void rule__THeader__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1262:1: ( ( 'B' ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1263:1: ( 'B' )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1263:1: ( 'B' )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1264:1: 'B'
            {
             before(grammarAccess.getTHeaderAccess().getBKeyword_1()); 
            match(input,25,FOLLOW_25_in_rule__THeader__Group__1__Impl2528); 
             after(grammarAccess.getTHeaderAccess().getBKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__THeader__Group__1__Impl"


    // $ANTLR start "rule__THeader__Group__2"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1277:1: rule__THeader__Group__2 : rule__THeader__Group__2__Impl rule__THeader__Group__3 ;
    public final void rule__THeader__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1281:1: ( rule__THeader__Group__2__Impl rule__THeader__Group__3 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1282:2: rule__THeader__Group__2__Impl rule__THeader__Group__3
            {
            pushFollow(FOLLOW_rule__THeader__Group__2__Impl_in_rule__THeader__Group__22559);
            rule__THeader__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__THeader__Group__3_in_rule__THeader__Group__22562);
            rule__THeader__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__THeader__Group__2"


    // $ANTLR start "rule__THeader__Group__2__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1289:1: rule__THeader__Group__2__Impl : ( 'C' ) ;
    public final void rule__THeader__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1293:1: ( ( 'C' ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1294:1: ( 'C' )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1294:1: ( 'C' )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1295:1: 'C'
            {
             before(grammarAccess.getTHeaderAccess().getCKeyword_2()); 
            match(input,26,FOLLOW_26_in_rule__THeader__Group__2__Impl2590); 
             after(grammarAccess.getTHeaderAccess().getCKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__THeader__Group__2__Impl"


    // $ANTLR start "rule__THeader__Group__3"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1308:1: rule__THeader__Group__3 : rule__THeader__Group__3__Impl rule__THeader__Group__4 ;
    public final void rule__THeader__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1312:1: ( rule__THeader__Group__3__Impl rule__THeader__Group__4 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1313:2: rule__THeader__Group__3__Impl rule__THeader__Group__4
            {
            pushFollow(FOLLOW_rule__THeader__Group__3__Impl_in_rule__THeader__Group__32621);
            rule__THeader__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__THeader__Group__4_in_rule__THeader__Group__32624);
            rule__THeader__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__THeader__Group__3"


    // $ANTLR start "rule__THeader__Group__3__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1320:1: rule__THeader__Group__3__Impl : ( 'D' ) ;
    public final void rule__THeader__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1324:1: ( ( 'D' ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1325:1: ( 'D' )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1325:1: ( 'D' )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1326:1: 'D'
            {
             before(grammarAccess.getTHeaderAccess().getDKeyword_3()); 
            match(input,27,FOLLOW_27_in_rule__THeader__Group__3__Impl2652); 
             after(grammarAccess.getTHeaderAccess().getDKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__THeader__Group__3__Impl"


    // $ANTLR start "rule__THeader__Group__4"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1339:1: rule__THeader__Group__4 : rule__THeader__Group__4__Impl rule__THeader__Group__5 ;
    public final void rule__THeader__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1343:1: ( rule__THeader__Group__4__Impl rule__THeader__Group__5 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1344:2: rule__THeader__Group__4__Impl rule__THeader__Group__5
            {
            pushFollow(FOLLOW_rule__THeader__Group__4__Impl_in_rule__THeader__Group__42683);
            rule__THeader__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__THeader__Group__5_in_rule__THeader__Group__42686);
            rule__THeader__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__THeader__Group__4"


    // $ANTLR start "rule__THeader__Group__4__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1351:1: rule__THeader__Group__4__Impl : ( 'E' ) ;
    public final void rule__THeader__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1355:1: ( ( 'E' ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1356:1: ( 'E' )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1356:1: ( 'E' )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1357:1: 'E'
            {
             before(grammarAccess.getTHeaderAccess().getEKeyword_4()); 
            match(input,28,FOLLOW_28_in_rule__THeader__Group__4__Impl2714); 
             after(grammarAccess.getTHeaderAccess().getEKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__THeader__Group__4__Impl"


    // $ANTLR start "rule__THeader__Group__5"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1370:1: rule__THeader__Group__5 : rule__THeader__Group__5__Impl rule__THeader__Group__6 ;
    public final void rule__THeader__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1374:1: ( rule__THeader__Group__5__Impl rule__THeader__Group__6 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1375:2: rule__THeader__Group__5__Impl rule__THeader__Group__6
            {
            pushFollow(FOLLOW_rule__THeader__Group__5__Impl_in_rule__THeader__Group__52745);
            rule__THeader__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__THeader__Group__6_in_rule__THeader__Group__52748);
            rule__THeader__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__THeader__Group__5"


    // $ANTLR start "rule__THeader__Group__5__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1382:1: rule__THeader__Group__5__Impl : ( 'F' ) ;
    public final void rule__THeader__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1386:1: ( ( 'F' ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1387:1: ( 'F' )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1387:1: ( 'F' )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1388:1: 'F'
            {
             before(grammarAccess.getTHeaderAccess().getFKeyword_5()); 
            match(input,29,FOLLOW_29_in_rule__THeader__Group__5__Impl2776); 
             after(grammarAccess.getTHeaderAccess().getFKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__THeader__Group__5__Impl"


    // $ANTLR start "rule__THeader__Group__6"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1401:1: rule__THeader__Group__6 : rule__THeader__Group__6__Impl rule__THeader__Group__7 ;
    public final void rule__THeader__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1405:1: ( rule__THeader__Group__6__Impl rule__THeader__Group__7 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1406:2: rule__THeader__Group__6__Impl rule__THeader__Group__7
            {
            pushFollow(FOLLOW_rule__THeader__Group__6__Impl_in_rule__THeader__Group__62807);
            rule__THeader__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__THeader__Group__7_in_rule__THeader__Group__62810);
            rule__THeader__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__THeader__Group__6"


    // $ANTLR start "rule__THeader__Group__6__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1413:1: rule__THeader__Group__6__Impl : ( 'G' ) ;
    public final void rule__THeader__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1417:1: ( ( 'G' ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1418:1: ( 'G' )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1418:1: ( 'G' )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1419:1: 'G'
            {
             before(grammarAccess.getTHeaderAccess().getGKeyword_6()); 
            match(input,30,FOLLOW_30_in_rule__THeader__Group__6__Impl2838); 
             after(grammarAccess.getTHeaderAccess().getGKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__THeader__Group__6__Impl"


    // $ANTLR start "rule__THeader__Group__7"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1432:1: rule__THeader__Group__7 : rule__THeader__Group__7__Impl ;
    public final void rule__THeader__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1436:1: ( rule__THeader__Group__7__Impl )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1437:2: rule__THeader__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__THeader__Group__7__Impl_in_rule__THeader__Group__72869);
            rule__THeader__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__THeader__Group__7"


    // $ANTLR start "rule__THeader__Group__7__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1443:1: rule__THeader__Group__7__Impl : ( 'H' ) ;
    public final void rule__THeader__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1447:1: ( ( 'H' ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1448:1: ( 'H' )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1448:1: ( 'H' )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1449:1: 'H'
            {
             before(grammarAccess.getTHeaderAccess().getHKeyword_7()); 
            match(input,31,FOLLOW_31_in_rule__THeader__Group__7__Impl2897); 
             after(grammarAccess.getTHeaderAccess().getHKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__THeader__Group__7__Impl"


    // $ANTLR start "rule__Row__Group__0"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1478:1: rule__Row__Group__0 : rule__Row__Group__0__Impl rule__Row__Group__1 ;
    public final void rule__Row__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1482:1: ( rule__Row__Group__0__Impl rule__Row__Group__1 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1483:2: rule__Row__Group__0__Impl rule__Row__Group__1
            {
            pushFollow(FOLLOW_rule__Row__Group__0__Impl_in_rule__Row__Group__02944);
            rule__Row__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Row__Group__1_in_rule__Row__Group__02947);
            rule__Row__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Row__Group__0"


    // $ANTLR start "rule__Row__Group__0__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1490:1: rule__Row__Group__0__Impl : ( ( rule__Row__NameAssignment_0 ) ) ;
    public final void rule__Row__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1494:1: ( ( ( rule__Row__NameAssignment_0 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1495:1: ( ( rule__Row__NameAssignment_0 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1495:1: ( ( rule__Row__NameAssignment_0 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1496:1: ( rule__Row__NameAssignment_0 )
            {
             before(grammarAccess.getRowAccess().getNameAssignment_0()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1497:1: ( rule__Row__NameAssignment_0 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1497:2: rule__Row__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Row__NameAssignment_0_in_rule__Row__Group__0__Impl2974);
            rule__Row__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getRowAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Row__Group__0__Impl"


    // $ANTLR start "rule__Row__Group__1"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1507:1: rule__Row__Group__1 : rule__Row__Group__1__Impl rule__Row__Group__2 ;
    public final void rule__Row__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1511:1: ( rule__Row__Group__1__Impl rule__Row__Group__2 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1512:2: rule__Row__Group__1__Impl rule__Row__Group__2
            {
            pushFollow(FOLLOW_rule__Row__Group__1__Impl_in_rule__Row__Group__13004);
            rule__Row__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Row__Group__2_in_rule__Row__Group__13007);
            rule__Row__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Row__Group__1"


    // $ANTLR start "rule__Row__Group__1__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1519:1: rule__Row__Group__1__Impl : ( ( rule__Row__MAssignment_1 ) ) ;
    public final void rule__Row__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1523:1: ( ( ( rule__Row__MAssignment_1 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1524:1: ( ( rule__Row__MAssignment_1 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1524:1: ( ( rule__Row__MAssignment_1 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1525:1: ( rule__Row__MAssignment_1 )
            {
             before(grammarAccess.getRowAccess().getMAssignment_1()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1526:1: ( rule__Row__MAssignment_1 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1526:2: rule__Row__MAssignment_1
            {
            pushFollow(FOLLOW_rule__Row__MAssignment_1_in_rule__Row__Group__1__Impl3034);
            rule__Row__MAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRowAccess().getMAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Row__Group__1__Impl"


    // $ANTLR start "rule__Row__Group__2"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1536:1: rule__Row__Group__2 : rule__Row__Group__2__Impl ;
    public final void rule__Row__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1540:1: ( rule__Row__Group__2__Impl )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1541:2: rule__Row__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Row__Group__2__Impl_in_rule__Row__Group__23064);
            rule__Row__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Row__Group__2"


    // $ANTLR start "rule__Row__Group__2__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1547:1: rule__Row__Group__2__Impl : ( ( rule__Row__EAssignment_2 ) ) ;
    public final void rule__Row__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1551:1: ( ( ( rule__Row__EAssignment_2 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1552:1: ( ( rule__Row__EAssignment_2 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1552:1: ( ( rule__Row__EAssignment_2 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1553:1: ( rule__Row__EAssignment_2 )
            {
             before(grammarAccess.getRowAccess().getEAssignment_2()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1554:1: ( rule__Row__EAssignment_2 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1554:2: rule__Row__EAssignment_2
            {
            pushFollow(FOLLOW_rule__Row__EAssignment_2_in_rule__Row__Group__2__Impl3091);
            rule__Row__EAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getRowAccess().getEAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Row__Group__2__Impl"


    // $ANTLR start "rule__Row1__Group__0"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1570:1: rule__Row1__Group__0 : rule__Row1__Group__0__Impl rule__Row1__Group__1 ;
    public final void rule__Row1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1574:1: ( rule__Row1__Group__0__Impl rule__Row1__Group__1 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1575:2: rule__Row1__Group__0__Impl rule__Row1__Group__1
            {
            pushFollow(FOLLOW_rule__Row1__Group__0__Impl_in_rule__Row1__Group__03127);
            rule__Row1__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Row1__Group__1_in_rule__Row1__Group__03130);
            rule__Row1__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Row1__Group__0"


    // $ANTLR start "rule__Row1__Group__0__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1582:1: rule__Row1__Group__0__Impl : ( ( rule__Row1__CAssignment_0 ) ) ;
    public final void rule__Row1__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1586:1: ( ( ( rule__Row1__CAssignment_0 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1587:1: ( ( rule__Row1__CAssignment_0 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1587:1: ( ( rule__Row1__CAssignment_0 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1588:1: ( rule__Row1__CAssignment_0 )
            {
             before(grammarAccess.getRow1Access().getCAssignment_0()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1589:1: ( rule__Row1__CAssignment_0 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1589:2: rule__Row1__CAssignment_0
            {
            pushFollow(FOLLOW_rule__Row1__CAssignment_0_in_rule__Row1__Group__0__Impl3157);
            rule__Row1__CAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getRow1Access().getCAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Row1__Group__0__Impl"


    // $ANTLR start "rule__Row1__Group__1"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1599:1: rule__Row1__Group__1 : rule__Row1__Group__1__Impl rule__Row1__Group__2 ;
    public final void rule__Row1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1603:1: ( rule__Row1__Group__1__Impl rule__Row1__Group__2 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1604:2: rule__Row1__Group__1__Impl rule__Row1__Group__2
            {
            pushFollow(FOLLOW_rule__Row1__Group__1__Impl_in_rule__Row1__Group__13187);
            rule__Row1__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Row1__Group__2_in_rule__Row1__Group__13190);
            rule__Row1__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Row1__Group__1"


    // $ANTLR start "rule__Row1__Group__1__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1611:1: rule__Row1__Group__1__Impl : ( ( rule__Row1__CAssignment_1 ) ) ;
    public final void rule__Row1__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1615:1: ( ( ( rule__Row1__CAssignment_1 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1616:1: ( ( rule__Row1__CAssignment_1 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1616:1: ( ( rule__Row1__CAssignment_1 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1617:1: ( rule__Row1__CAssignment_1 )
            {
             before(grammarAccess.getRow1Access().getCAssignment_1()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1618:1: ( rule__Row1__CAssignment_1 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1618:2: rule__Row1__CAssignment_1
            {
            pushFollow(FOLLOW_rule__Row1__CAssignment_1_in_rule__Row1__Group__1__Impl3217);
            rule__Row1__CAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRow1Access().getCAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Row1__Group__1__Impl"


    // $ANTLR start "rule__Row1__Group__2"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1628:1: rule__Row1__Group__2 : rule__Row1__Group__2__Impl rule__Row1__Group__3 ;
    public final void rule__Row1__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1632:1: ( rule__Row1__Group__2__Impl rule__Row1__Group__3 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1633:2: rule__Row1__Group__2__Impl rule__Row1__Group__3
            {
            pushFollow(FOLLOW_rule__Row1__Group__2__Impl_in_rule__Row1__Group__23247);
            rule__Row1__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Row1__Group__3_in_rule__Row1__Group__23250);
            rule__Row1__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Row1__Group__2"


    // $ANTLR start "rule__Row1__Group__2__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1640:1: rule__Row1__Group__2__Impl : ( ( rule__Row1__CAssignment_2 ) ) ;
    public final void rule__Row1__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1644:1: ( ( ( rule__Row1__CAssignment_2 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1645:1: ( ( rule__Row1__CAssignment_2 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1645:1: ( ( rule__Row1__CAssignment_2 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1646:1: ( rule__Row1__CAssignment_2 )
            {
             before(grammarAccess.getRow1Access().getCAssignment_2()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1647:1: ( rule__Row1__CAssignment_2 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1647:2: rule__Row1__CAssignment_2
            {
            pushFollow(FOLLOW_rule__Row1__CAssignment_2_in_rule__Row1__Group__2__Impl3277);
            rule__Row1__CAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getRow1Access().getCAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Row1__Group__2__Impl"


    // $ANTLR start "rule__Row1__Group__3"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1657:1: rule__Row1__Group__3 : rule__Row1__Group__3__Impl rule__Row1__Group__4 ;
    public final void rule__Row1__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1661:1: ( rule__Row1__Group__3__Impl rule__Row1__Group__4 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1662:2: rule__Row1__Group__3__Impl rule__Row1__Group__4
            {
            pushFollow(FOLLOW_rule__Row1__Group__3__Impl_in_rule__Row1__Group__33307);
            rule__Row1__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Row1__Group__4_in_rule__Row1__Group__33310);
            rule__Row1__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Row1__Group__3"


    // $ANTLR start "rule__Row1__Group__3__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1669:1: rule__Row1__Group__3__Impl : ( ( rule__Row1__CAssignment_3 ) ) ;
    public final void rule__Row1__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1673:1: ( ( ( rule__Row1__CAssignment_3 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1674:1: ( ( rule__Row1__CAssignment_3 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1674:1: ( ( rule__Row1__CAssignment_3 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1675:1: ( rule__Row1__CAssignment_3 )
            {
             before(grammarAccess.getRow1Access().getCAssignment_3()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1676:1: ( rule__Row1__CAssignment_3 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1676:2: rule__Row1__CAssignment_3
            {
            pushFollow(FOLLOW_rule__Row1__CAssignment_3_in_rule__Row1__Group__3__Impl3337);
            rule__Row1__CAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getRow1Access().getCAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Row1__Group__3__Impl"


    // $ANTLR start "rule__Row1__Group__4"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1686:1: rule__Row1__Group__4 : rule__Row1__Group__4__Impl rule__Row1__Group__5 ;
    public final void rule__Row1__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1690:1: ( rule__Row1__Group__4__Impl rule__Row1__Group__5 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1691:2: rule__Row1__Group__4__Impl rule__Row1__Group__5
            {
            pushFollow(FOLLOW_rule__Row1__Group__4__Impl_in_rule__Row1__Group__43367);
            rule__Row1__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Row1__Group__5_in_rule__Row1__Group__43370);
            rule__Row1__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Row1__Group__4"


    // $ANTLR start "rule__Row1__Group__4__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1698:1: rule__Row1__Group__4__Impl : ( ( rule__Row1__CAssignment_4 ) ) ;
    public final void rule__Row1__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1702:1: ( ( ( rule__Row1__CAssignment_4 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1703:1: ( ( rule__Row1__CAssignment_4 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1703:1: ( ( rule__Row1__CAssignment_4 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1704:1: ( rule__Row1__CAssignment_4 )
            {
             before(grammarAccess.getRow1Access().getCAssignment_4()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1705:1: ( rule__Row1__CAssignment_4 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1705:2: rule__Row1__CAssignment_4
            {
            pushFollow(FOLLOW_rule__Row1__CAssignment_4_in_rule__Row1__Group__4__Impl3397);
            rule__Row1__CAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getRow1Access().getCAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Row1__Group__4__Impl"


    // $ANTLR start "rule__Row1__Group__5"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1715:1: rule__Row1__Group__5 : rule__Row1__Group__5__Impl rule__Row1__Group__6 ;
    public final void rule__Row1__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1719:1: ( rule__Row1__Group__5__Impl rule__Row1__Group__6 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1720:2: rule__Row1__Group__5__Impl rule__Row1__Group__6
            {
            pushFollow(FOLLOW_rule__Row1__Group__5__Impl_in_rule__Row1__Group__53427);
            rule__Row1__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Row1__Group__6_in_rule__Row1__Group__53430);
            rule__Row1__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Row1__Group__5"


    // $ANTLR start "rule__Row1__Group__5__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1727:1: rule__Row1__Group__5__Impl : ( ( rule__Row1__CAssignment_5 ) ) ;
    public final void rule__Row1__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1731:1: ( ( ( rule__Row1__CAssignment_5 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1732:1: ( ( rule__Row1__CAssignment_5 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1732:1: ( ( rule__Row1__CAssignment_5 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1733:1: ( rule__Row1__CAssignment_5 )
            {
             before(grammarAccess.getRow1Access().getCAssignment_5()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1734:1: ( rule__Row1__CAssignment_5 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1734:2: rule__Row1__CAssignment_5
            {
            pushFollow(FOLLOW_rule__Row1__CAssignment_5_in_rule__Row1__Group__5__Impl3457);
            rule__Row1__CAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getRow1Access().getCAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Row1__Group__5__Impl"


    // $ANTLR start "rule__Row1__Group__6"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1744:1: rule__Row1__Group__6 : rule__Row1__Group__6__Impl rule__Row1__Group__7 ;
    public final void rule__Row1__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1748:1: ( rule__Row1__Group__6__Impl rule__Row1__Group__7 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1749:2: rule__Row1__Group__6__Impl rule__Row1__Group__7
            {
            pushFollow(FOLLOW_rule__Row1__Group__6__Impl_in_rule__Row1__Group__63487);
            rule__Row1__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Row1__Group__7_in_rule__Row1__Group__63490);
            rule__Row1__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Row1__Group__6"


    // $ANTLR start "rule__Row1__Group__6__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1756:1: rule__Row1__Group__6__Impl : ( ( rule__Row1__CAssignment_6 ) ) ;
    public final void rule__Row1__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1760:1: ( ( ( rule__Row1__CAssignment_6 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1761:1: ( ( rule__Row1__CAssignment_6 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1761:1: ( ( rule__Row1__CAssignment_6 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1762:1: ( rule__Row1__CAssignment_6 )
            {
             before(grammarAccess.getRow1Access().getCAssignment_6()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1763:1: ( rule__Row1__CAssignment_6 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1763:2: rule__Row1__CAssignment_6
            {
            pushFollow(FOLLOW_rule__Row1__CAssignment_6_in_rule__Row1__Group__6__Impl3517);
            rule__Row1__CAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getRow1Access().getCAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Row1__Group__6__Impl"


    // $ANTLR start "rule__Row1__Group__7"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1773:1: rule__Row1__Group__7 : rule__Row1__Group__7__Impl ;
    public final void rule__Row1__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1777:1: ( rule__Row1__Group__7__Impl )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1778:2: rule__Row1__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__Row1__Group__7__Impl_in_rule__Row1__Group__73547);
            rule__Row1__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Row1__Group__7"


    // $ANTLR start "rule__Row1__Group__7__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1784:1: rule__Row1__Group__7__Impl : ( ( rule__Row1__CAssignment_7 ) ) ;
    public final void rule__Row1__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1788:1: ( ( ( rule__Row1__CAssignment_7 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1789:1: ( ( rule__Row1__CAssignment_7 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1789:1: ( ( rule__Row1__CAssignment_7 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1790:1: ( rule__Row1__CAssignment_7 )
            {
             before(grammarAccess.getRow1Access().getCAssignment_7()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1791:1: ( rule__Row1__CAssignment_7 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1791:2: rule__Row1__CAssignment_7
            {
            pushFollow(FOLLOW_rule__Row1__CAssignment_7_in_rule__Row1__Group__7__Impl3574);
            rule__Row1__CAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getRow1Access().getCAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Row1__Group__7__Impl"


    // $ANTLR start "rule__Model__TablesAssignment_1"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1818:1: rule__Model__TablesAssignment_1 : ( ruleTable ) ;
    public final void rule__Model__TablesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1822:1: ( ( ruleTable ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1823:1: ( ruleTable )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1823:1: ( ruleTable )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1824:1: ruleTable
            {
             before(grammarAccess.getModelAccess().getTablesTableParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleTable_in_rule__Model__TablesAssignment_13625);
            ruleTable();

            state._fsp--;

             after(grammarAccess.getModelAccess().getTablesTableParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__TablesAssignment_1"


    // $ANTLR start "rule__FDescription__NameAssignment_1"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1833:1: rule__FDescription__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__FDescription__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1837:1: ( ( RULE_ID ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1838:1: ( RULE_ID )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1838:1: ( RULE_ID )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1839:1: RULE_ID
            {
             before(grammarAccess.getFDescriptionAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FDescription__NameAssignment_13656); 
             after(grammarAccess.getFDescriptionAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FDescription__NameAssignment_1"


    // $ANTLR start "rule__FDescription__BaseAssignment_3"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1848:1: rule__FDescription__BaseAssignment_3 : ( RULE_INT ) ;
    public final void rule__FDescription__BaseAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1852:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1853:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1853:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1854:1: RULE_INT
            {
             before(grammarAccess.getFDescriptionAccess().getBaseINTTerminalRuleCall_3_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__FDescription__BaseAssignment_33687); 
             after(grammarAccess.getFDescriptionAccess().getBaseINTTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FDescription__BaseAssignment_3"


    // $ANTLR start "rule__FDescription__MglAssignment_5"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1863:1: rule__FDescription__MglAssignment_5 : ( RULE_INT ) ;
    public final void rule__FDescription__MglAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1867:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1868:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1868:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1869:1: RULE_INT
            {
             before(grammarAccess.getFDescriptionAccess().getMglINTTerminalRuleCall_5_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__FDescription__MglAssignment_53718); 
             after(grammarAccess.getFDescriptionAccess().getMglINTTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FDescription__MglAssignment_5"


    // $ANTLR start "rule__FDescription__EglAssignment_7"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1878:1: rule__FDescription__EglAssignment_7 : ( RULE_INT ) ;
    public final void rule__FDescription__EglAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1882:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1883:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1883:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1884:1: RULE_INT
            {
             before(grammarAccess.getFDescriptionAccess().getEglINTTerminalRuleCall_7_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__FDescription__EglAssignment_73749); 
             after(grammarAccess.getFDescriptionAccess().getEglINTTerminalRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FDescription__EglAssignment_7"


    // $ANTLR start "rule__Table__RAssignment_2"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1893:1: rule__Table__RAssignment_2 : ( ruleRow ) ;
    public final void rule__Table__RAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1897:1: ( ( ruleRow ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1898:1: ( ruleRow )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1898:1: ( ruleRow )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1899:1: ruleRow
            {
             before(grammarAccess.getTableAccess().getRRowParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleRow_in_rule__Table__RAssignment_23780);
            ruleRow();

            state._fsp--;

             after(grammarAccess.getTableAccess().getRRowParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__RAssignment_2"


    // $ANTLR start "rule__Table__RAssignment_3"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1908:1: rule__Table__RAssignment_3 : ( ruleRow ) ;
    public final void rule__Table__RAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1912:1: ( ( ruleRow ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1913:1: ( ruleRow )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1913:1: ( ruleRow )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1914:1: ruleRow
            {
             before(grammarAccess.getTableAccess().getRRowParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleRow_in_rule__Table__RAssignment_33811);
            ruleRow();

            state._fsp--;

             after(grammarAccess.getTableAccess().getRRowParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__RAssignment_3"


    // $ANTLR start "rule__Table__RAssignment_4"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1923:1: rule__Table__RAssignment_4 : ( ruleRow ) ;
    public final void rule__Table__RAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1927:1: ( ( ruleRow ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1928:1: ( ruleRow )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1928:1: ( ruleRow )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1929:1: ruleRow
            {
             before(grammarAccess.getTableAccess().getRRowParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleRow_in_rule__Table__RAssignment_43842);
            ruleRow();

            state._fsp--;

             after(grammarAccess.getTableAccess().getRRowParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__RAssignment_4"


    // $ANTLR start "rule__Table__RAssignment_5"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1938:1: rule__Table__RAssignment_5 : ( ruleRow ) ;
    public final void rule__Table__RAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1942:1: ( ( ruleRow ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1943:1: ( ruleRow )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1943:1: ( ruleRow )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1944:1: ruleRow
            {
             before(grammarAccess.getTableAccess().getRRowParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleRow_in_rule__Table__RAssignment_53873);
            ruleRow();

            state._fsp--;

             after(grammarAccess.getTableAccess().getRRowParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__RAssignment_5"


    // $ANTLR start "rule__Table__RAssignment_6"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1953:1: rule__Table__RAssignment_6 : ( ruleRow ) ;
    public final void rule__Table__RAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1957:1: ( ( ruleRow ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1958:1: ( ruleRow )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1958:1: ( ruleRow )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1959:1: ruleRow
            {
             before(grammarAccess.getTableAccess().getRRowParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleRow_in_rule__Table__RAssignment_63904);
            ruleRow();

            state._fsp--;

             after(grammarAccess.getTableAccess().getRRowParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__RAssignment_6"


    // $ANTLR start "rule__Table__RAssignment_7"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1968:1: rule__Table__RAssignment_7 : ( ruleRow ) ;
    public final void rule__Table__RAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1972:1: ( ( ruleRow ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1973:1: ( ruleRow )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1973:1: ( ruleRow )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1974:1: ruleRow
            {
             before(grammarAccess.getTableAccess().getRRowParserRuleCall_7_0()); 
            pushFollow(FOLLOW_ruleRow_in_rule__Table__RAssignment_73935);
            ruleRow();

            state._fsp--;

             after(grammarAccess.getTableAccess().getRRowParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__RAssignment_7"


    // $ANTLR start "rule__Table__RAssignment_8"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1983:1: rule__Table__RAssignment_8 : ( ruleRow ) ;
    public final void rule__Table__RAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1987:1: ( ( ruleRow ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1988:1: ( ruleRow )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1988:1: ( ruleRow )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1989:1: ruleRow
            {
             before(grammarAccess.getTableAccess().getRRowParserRuleCall_8_0()); 
            pushFollow(FOLLOW_ruleRow_in_rule__Table__RAssignment_83966);
            ruleRow();

            state._fsp--;

             after(grammarAccess.getTableAccess().getRRowParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__RAssignment_8"


    // $ANTLR start "rule__Table__RAssignment_9"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1998:1: rule__Table__RAssignment_9 : ( ruleRow ) ;
    public final void rule__Table__RAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2002:1: ( ( ruleRow ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2003:1: ( ruleRow )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2003:1: ( ruleRow )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2004:1: ruleRow
            {
             before(grammarAccess.getTableAccess().getRRowParserRuleCall_9_0()); 
            pushFollow(FOLLOW_ruleRow_in_rule__Table__RAssignment_93997);
            ruleRow();

            state._fsp--;

             after(grammarAccess.getTableAccess().getRRowParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__RAssignment_9"


    // $ANTLR start "rule__TDescription__NameAssignment_1"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2013:1: rule__TDescription__NameAssignment_1 : ( rulePieceType ) ;
    public final void rule__TDescription__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2017:1: ( ( rulePieceType ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2018:1: ( rulePieceType )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2018:1: ( rulePieceType )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2019:1: rulePieceType
            {
             before(grammarAccess.getTDescriptionAccess().getNamePieceTypeEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_rulePieceType_in_rule__TDescription__NameAssignment_14028);
            rulePieceType();

            state._fsp--;

             after(grammarAccess.getTDescriptionAccess().getNamePieceTypeEnumRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TDescription__NameAssignment_1"


    // $ANTLR start "rule__TDescription__MgAssignment_3"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2028:1: rule__TDescription__MgAssignment_3 : ( RULE_INT ) ;
    public final void rule__TDescription__MgAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2032:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2033:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2033:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2034:1: RULE_INT
            {
             before(grammarAccess.getTDescriptionAccess().getMgINTTerminalRuleCall_3_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__TDescription__MgAssignment_34059); 
             after(grammarAccess.getTDescriptionAccess().getMgINTTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TDescription__MgAssignment_3"


    // $ANTLR start "rule__TDescription__EgAssignment_5"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2043:1: rule__TDescription__EgAssignment_5 : ( RULE_INT ) ;
    public final void rule__TDescription__EgAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2047:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2048:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2048:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2049:1: RULE_INT
            {
             before(grammarAccess.getTDescriptionAccess().getEgINTTerminalRuleCall_5_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__TDescription__EgAssignment_54090); 
             after(grammarAccess.getTDescriptionAccess().getEgINTTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TDescription__EgAssignment_5"


    // $ANTLR start "rule__Row__NameAssignment_0"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2058:1: rule__Row__NameAssignment_0 : ( ruleRowLabel ) ;
    public final void rule__Row__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2062:1: ( ( ruleRowLabel ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2063:1: ( ruleRowLabel )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2063:1: ( ruleRowLabel )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2064:1: ruleRowLabel
            {
             before(grammarAccess.getRowAccess().getNameRowLabelParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleRowLabel_in_rule__Row__NameAssignment_04121);
            ruleRowLabel();

            state._fsp--;

             after(grammarAccess.getRowAccess().getNameRowLabelParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Row__NameAssignment_0"


    // $ANTLR start "rule__Row__MAssignment_1"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2073:1: rule__Row__MAssignment_1 : ( ruleMRow ) ;
    public final void rule__Row__MAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2077:1: ( ( ruleMRow ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2078:1: ( ruleMRow )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2078:1: ( ruleMRow )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2079:1: ruleMRow
            {
             before(grammarAccess.getRowAccess().getMMRowParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleMRow_in_rule__Row__MAssignment_14152);
            ruleMRow();

            state._fsp--;

             after(grammarAccess.getRowAccess().getMMRowParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Row__MAssignment_1"


    // $ANTLR start "rule__Row__EAssignment_2"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2088:1: rule__Row__EAssignment_2 : ( ruleERow ) ;
    public final void rule__Row__EAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2092:1: ( ( ruleERow ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2093:1: ( ruleERow )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2093:1: ( ruleERow )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2094:1: ruleERow
            {
             before(grammarAccess.getRowAccess().getEERowParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleERow_in_rule__Row__EAssignment_24183);
            ruleERow();

            state._fsp--;

             after(grammarAccess.getRowAccess().getEERowParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Row__EAssignment_2"


    // $ANTLR start "rule__MRow__NameAssignment"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2103:1: rule__MRow__NameAssignment : ( ruleRow1 ) ;
    public final void rule__MRow__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2107:1: ( ( ruleRow1 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2108:1: ( ruleRow1 )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2108:1: ( ruleRow1 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2109:1: ruleRow1
            {
             before(grammarAccess.getMRowAccess().getNameRow1ParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleRow1_in_rule__MRow__NameAssignment4214);
            ruleRow1();

            state._fsp--;

             after(grammarAccess.getMRowAccess().getNameRow1ParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MRow__NameAssignment"


    // $ANTLR start "rule__ERow__NameAssignment"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2118:1: rule__ERow__NameAssignment : ( ruleRow1 ) ;
    public final void rule__ERow__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2122:1: ( ( ruleRow1 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2123:1: ( ruleRow1 )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2123:1: ( ruleRow1 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2124:1: ruleRow1
            {
             before(grammarAccess.getERowAccess().getNameRow1ParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleRow1_in_rule__ERow__NameAssignment4245);
            ruleRow1();

            state._fsp--;

             after(grammarAccess.getERowAccess().getNameRow1ParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ERow__NameAssignment"


    // $ANTLR start "rule__Row1__CAssignment_0"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2133:1: rule__Row1__CAssignment_0 : ( RULE_INT ) ;
    public final void rule__Row1__CAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2137:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2138:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2138:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2139:1: RULE_INT
            {
             before(grammarAccess.getRow1Access().getCINTTerminalRuleCall_0_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Row1__CAssignment_04276); 
             after(grammarAccess.getRow1Access().getCINTTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Row1__CAssignment_0"


    // $ANTLR start "rule__Row1__CAssignment_1"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2148:1: rule__Row1__CAssignment_1 : ( RULE_INT ) ;
    public final void rule__Row1__CAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2152:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2153:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2153:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2154:1: RULE_INT
            {
             before(grammarAccess.getRow1Access().getCINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Row1__CAssignment_14307); 
             after(grammarAccess.getRow1Access().getCINTTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Row1__CAssignment_1"


    // $ANTLR start "rule__Row1__CAssignment_2"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2163:1: rule__Row1__CAssignment_2 : ( RULE_INT ) ;
    public final void rule__Row1__CAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2167:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2168:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2168:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2169:1: RULE_INT
            {
             before(grammarAccess.getRow1Access().getCINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Row1__CAssignment_24338); 
             after(grammarAccess.getRow1Access().getCINTTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Row1__CAssignment_2"


    // $ANTLR start "rule__Row1__CAssignment_3"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2178:1: rule__Row1__CAssignment_3 : ( RULE_INT ) ;
    public final void rule__Row1__CAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2182:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2183:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2183:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2184:1: RULE_INT
            {
             before(grammarAccess.getRow1Access().getCINTTerminalRuleCall_3_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Row1__CAssignment_34369); 
             after(grammarAccess.getRow1Access().getCINTTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Row1__CAssignment_3"


    // $ANTLR start "rule__Row1__CAssignment_4"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2193:1: rule__Row1__CAssignment_4 : ( RULE_INT ) ;
    public final void rule__Row1__CAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2197:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2198:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2198:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2199:1: RULE_INT
            {
             before(grammarAccess.getRow1Access().getCINTTerminalRuleCall_4_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Row1__CAssignment_44400); 
             after(grammarAccess.getRow1Access().getCINTTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Row1__CAssignment_4"


    // $ANTLR start "rule__Row1__CAssignment_5"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2208:1: rule__Row1__CAssignment_5 : ( RULE_INT ) ;
    public final void rule__Row1__CAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2212:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2213:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2213:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2214:1: RULE_INT
            {
             before(grammarAccess.getRow1Access().getCINTTerminalRuleCall_5_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Row1__CAssignment_54431); 
             after(grammarAccess.getRow1Access().getCINTTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Row1__CAssignment_5"


    // $ANTLR start "rule__Row1__CAssignment_6"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2223:1: rule__Row1__CAssignment_6 : ( RULE_INT ) ;
    public final void rule__Row1__CAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2227:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2228:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2228:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2229:1: RULE_INT
            {
             before(grammarAccess.getRow1Access().getCINTTerminalRuleCall_6_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Row1__CAssignment_64462); 
             after(grammarAccess.getRow1Access().getCINTTerminalRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Row1__CAssignment_6"


    // $ANTLR start "rule__Row1__CAssignment_7"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2238:1: rule__Row1__CAssignment_7 : ( RULE_INT ) ;
    public final void rule__Row1__CAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2242:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2243:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2243:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2244:1: RULE_INT
            {
             before(grammarAccess.getRow1Access().getCINTTerminalRuleCall_7_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Row1__CAssignment_74493); 
             after(grammarAccess.getRow1Access().getCINTTerminalRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Row1__CAssignment_7"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFDescription_in_entryRuleFDescription121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFDescription128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FDescription__Group__0_in_ruleFDescription154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTable_in_entryRuleTable181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTable188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__Group__0_in_ruleTable214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTDescription_in_entryRuleTDescription241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTDescription248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TDescription__Group__0_in_ruleTDescription274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTHeader_in_entryRuleTHeader301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTHeader308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__THeader__Group__0_in_ruleTHeader334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRow_in_entryRuleRow361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRow368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row__Group__0_in_ruleRow394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRowLabel_in_entryRuleRowLabel421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRowLabel428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleRowLabel454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMRow_in_entryRuleMRow480 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMRow487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MRow__NameAssignment_in_ruleMRow513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleERow_in_entryRuleERow540 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleERow547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ERow__NameAssignment_in_ruleERow573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRow1_in_entryRuleRow1600 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRow1607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row1__Group__0_in_ruleRow1633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PieceType__Alternatives_in_rulePieceType670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__PieceType__Alternatives706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__PieceType__Alternatives727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__PieceType__Alternatives748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__PieceType__Alternatives769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__PieceType__Alternatives790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__PieceType__Alternatives811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__0844 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__0847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFDescription_in_rule__Model__Group__0__Impl874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__1903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__TablesAssignment_1_in_rule__Model__Group__1__Impl930 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_rule__FDescription__Group__0__Impl_in_rule__FDescription__Group__0965 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__FDescription__Group__1_in_rule__FDescription__Group__0968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PSQT_in_rule__FDescription__Group__0__Impl995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FDescription__Group__1__Impl_in_rule__FDescription__Group__11024 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__FDescription__Group__2_in_rule__FDescription__Group__11027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FDescription__NameAssignment_1_in_rule__FDescription__Group__1__Impl1054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FDescription__Group__2__Impl_in_rule__FDescription__Group__21084 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FDescription__Group__3_in_rule__FDescription__Group__21087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BASE_in_rule__FDescription__Group__2__Impl1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FDescription__Group__3__Impl_in_rule__FDescription__Group__31143 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__FDescription__Group__4_in_rule__FDescription__Group__31146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FDescription__BaseAssignment_3_in_rule__FDescription__Group__3__Impl1173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FDescription__Group__4__Impl_in_rule__FDescription__Group__41203 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FDescription__Group__5_in_rule__FDescription__Group__41206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MIDLIMIT_in_rule__FDescription__Group__4__Impl1233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FDescription__Group__5__Impl_in_rule__FDescription__Group__51262 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__FDescription__Group__6_in_rule__FDescription__Group__51265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FDescription__MglAssignment_5_in_rule__FDescription__Group__5__Impl1292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FDescription__Group__6__Impl_in_rule__FDescription__Group__61322 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FDescription__Group__7_in_rule__FDescription__Group__61325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ENDLIMIT_in_rule__FDescription__Group__6__Impl1352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FDescription__Group__7__Impl_in_rule__FDescription__Group__71381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FDescription__EglAssignment_7_in_rule__FDescription__Group__7__Impl1408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__Group__0__Impl_in_rule__Table__Group__01454 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__Table__Group__1_in_rule__Table__Group__01457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTDescription_in_rule__Table__Group__0__Impl1484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__Group__1__Impl_in_rule__Table__Group__11513 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Table__Group__2_in_rule__Table__Group__11516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTHeader_in_rule__Table__Group__1__Impl1543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__Group__2__Impl_in_rule__Table__Group__21572 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Table__Group__3_in_rule__Table__Group__21575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__RAssignment_2_in_rule__Table__Group__2__Impl1602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__Group__3__Impl_in_rule__Table__Group__31632 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Table__Group__4_in_rule__Table__Group__31635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__RAssignment_3_in_rule__Table__Group__3__Impl1662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__Group__4__Impl_in_rule__Table__Group__41692 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Table__Group__5_in_rule__Table__Group__41695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__RAssignment_4_in_rule__Table__Group__4__Impl1722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__Group__5__Impl_in_rule__Table__Group__51752 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Table__Group__6_in_rule__Table__Group__51755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__RAssignment_5_in_rule__Table__Group__5__Impl1782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__Group__6__Impl_in_rule__Table__Group__61812 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Table__Group__7_in_rule__Table__Group__61815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__RAssignment_6_in_rule__Table__Group__6__Impl1842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__Group__7__Impl_in_rule__Table__Group__71872 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Table__Group__8_in_rule__Table__Group__71875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__RAssignment_7_in_rule__Table__Group__7__Impl1902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__Group__8__Impl_in_rule__Table__Group__81932 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Table__Group__9_in_rule__Table__Group__81935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__RAssignment_8_in_rule__Table__Group__8__Impl1962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__Group__9__Impl_in_rule__Table__Group__91992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__RAssignment_9_in_rule__Table__Group__9__Impl2019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TDescription__Group__0__Impl_in_rule__TDescription__Group__02069 = new BitSet(new long[]{0x0000000000FC0000L});
    public static final BitSet FOLLOW_rule__TDescription__Group__1_in_rule__TDescription__Group__02072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PIECE_in_rule__TDescription__Group__0__Impl2099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TDescription__Group__1__Impl_in_rule__TDescription__Group__12128 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__TDescription__Group__2_in_rule__TDescription__Group__12131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TDescription__NameAssignment_1_in_rule__TDescription__Group__1__Impl2158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TDescription__Group__2__Impl_in_rule__TDescription__Group__22188 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__TDescription__Group__3_in_rule__TDescription__Group__22191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MIDGAME_in_rule__TDescription__Group__2__Impl2218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TDescription__Group__3__Impl_in_rule__TDescription__Group__32247 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_rule__TDescription__Group__4_in_rule__TDescription__Group__32250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TDescription__MgAssignment_3_in_rule__TDescription__Group__3__Impl2277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TDescription__Group__4__Impl_in_rule__TDescription__Group__42307 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__TDescription__Group__5_in_rule__TDescription__Group__42310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ENDGAME_in_rule__TDescription__Group__4__Impl2337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TDescription__Group__5__Impl_in_rule__TDescription__Group__52366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TDescription__EgAssignment_5_in_rule__TDescription__Group__5__Impl2393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__THeader__Group__0__Impl_in_rule__THeader__Group__02435 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__THeader__Group__1_in_rule__THeader__Group__02438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__THeader__Group__0__Impl2466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__THeader__Group__1__Impl_in_rule__THeader__Group__12497 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__THeader__Group__2_in_rule__THeader__Group__12500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__THeader__Group__1__Impl2528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__THeader__Group__2__Impl_in_rule__THeader__Group__22559 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__THeader__Group__3_in_rule__THeader__Group__22562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__THeader__Group__2__Impl2590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__THeader__Group__3__Impl_in_rule__THeader__Group__32621 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__THeader__Group__4_in_rule__THeader__Group__32624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__THeader__Group__3__Impl2652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__THeader__Group__4__Impl_in_rule__THeader__Group__42683 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__THeader__Group__5_in_rule__THeader__Group__42686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__THeader__Group__4__Impl2714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__THeader__Group__5__Impl_in_rule__THeader__Group__52745 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__THeader__Group__6_in_rule__THeader__Group__52748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__THeader__Group__5__Impl2776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__THeader__Group__6__Impl_in_rule__THeader__Group__62807 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__THeader__Group__7_in_rule__THeader__Group__62810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__THeader__Group__6__Impl2838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__THeader__Group__7__Impl_in_rule__THeader__Group__72869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__THeader__Group__7__Impl2897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row__Group__0__Impl_in_rule__Row__Group__02944 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Row__Group__1_in_rule__Row__Group__02947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row__NameAssignment_0_in_rule__Row__Group__0__Impl2974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row__Group__1__Impl_in_rule__Row__Group__13004 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Row__Group__2_in_rule__Row__Group__13007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row__MAssignment_1_in_rule__Row__Group__1__Impl3034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row__Group__2__Impl_in_rule__Row__Group__23064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row__EAssignment_2_in_rule__Row__Group__2__Impl3091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row1__Group__0__Impl_in_rule__Row1__Group__03127 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Row1__Group__1_in_rule__Row1__Group__03130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row1__CAssignment_0_in_rule__Row1__Group__0__Impl3157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row1__Group__1__Impl_in_rule__Row1__Group__13187 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Row1__Group__2_in_rule__Row1__Group__13190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row1__CAssignment_1_in_rule__Row1__Group__1__Impl3217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row1__Group__2__Impl_in_rule__Row1__Group__23247 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Row1__Group__3_in_rule__Row1__Group__23250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row1__CAssignment_2_in_rule__Row1__Group__2__Impl3277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row1__Group__3__Impl_in_rule__Row1__Group__33307 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Row1__Group__4_in_rule__Row1__Group__33310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row1__CAssignment_3_in_rule__Row1__Group__3__Impl3337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row1__Group__4__Impl_in_rule__Row1__Group__43367 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Row1__Group__5_in_rule__Row1__Group__43370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row1__CAssignment_4_in_rule__Row1__Group__4__Impl3397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row1__Group__5__Impl_in_rule__Row1__Group__53427 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Row1__Group__6_in_rule__Row1__Group__53430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row1__CAssignment_5_in_rule__Row1__Group__5__Impl3457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row1__Group__6__Impl_in_rule__Row1__Group__63487 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Row1__Group__7_in_rule__Row1__Group__63490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row1__CAssignment_6_in_rule__Row1__Group__6__Impl3517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row1__Group__7__Impl_in_rule__Row1__Group__73547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row1__CAssignment_7_in_rule__Row1__Group__7__Impl3574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTable_in_rule__Model__TablesAssignment_13625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FDescription__NameAssignment_13656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__FDescription__BaseAssignment_33687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__FDescription__MglAssignment_53718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__FDescription__EglAssignment_73749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRow_in_rule__Table__RAssignment_23780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRow_in_rule__Table__RAssignment_33811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRow_in_rule__Table__RAssignment_43842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRow_in_rule__Table__RAssignment_53873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRow_in_rule__Table__RAssignment_63904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRow_in_rule__Table__RAssignment_73935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRow_in_rule__Table__RAssignment_83966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRow_in_rule__Table__RAssignment_93997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePieceType_in_rule__TDescription__NameAssignment_14028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__TDescription__MgAssignment_34059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__TDescription__EgAssignment_54090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRowLabel_in_rule__Row__NameAssignment_04121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMRow_in_rule__Row__MAssignment_14152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleERow_in_rule__Row__EAssignment_24183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRow1_in_rule__MRow__NameAssignment4214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRow1_in_rule__ERow__NameAssignment4245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Row1__CAssignment_04276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Row1__CAssignment_14307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Row1__CAssignment_24338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Row1__CAssignment_34369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Row1__CAssignment_44400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Row1__CAssignment_54431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Row1__CAssignment_64462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Row1__CAssignment_74493 = new BitSet(new long[]{0x0000000000000002L});

}