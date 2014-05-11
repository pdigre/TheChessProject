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




    // $ANTLR start "entryRulePSQT_Model"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:60:1: entryRulePSQT_Model : rulePSQT_Model EOF ;
    public final void entryRulePSQT_Model() throws RecognitionException {
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:61:1: ( rulePSQT_Model EOF )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:62:1: rulePSQT_Model EOF
            {
             before(grammarAccess.getPSQT_ModelRule()); 
            pushFollow(FOLLOW_rulePSQT_Model_in_entryRulePSQT_Model61);
            rulePSQT_Model();

            state._fsp--;

             after(grammarAccess.getPSQT_ModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePSQT_Model68); 

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
    // $ANTLR end "entryRulePSQT_Model"


    // $ANTLR start "rulePSQT_Model"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:69:1: rulePSQT_Model : ( ( rule__PSQT_Model__Group__0 ) ) ;
    public final void rulePSQT_Model() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:73:2: ( ( ( rule__PSQT_Model__Group__0 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:74:1: ( ( rule__PSQT_Model__Group__0 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:74:1: ( ( rule__PSQT_Model__Group__0 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:75:1: ( rule__PSQT_Model__Group__0 )
            {
             before(grammarAccess.getPSQT_ModelAccess().getGroup()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:76:1: ( rule__PSQT_Model__Group__0 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:76:2: rule__PSQT_Model__Group__0
            {
            pushFollow(FOLLOW_rule__PSQT_Model__Group__0_in_rulePSQT_Model94);
            rule__PSQT_Model__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPSQT_ModelAccess().getGroup()); 

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
    // $ANTLR end "rulePSQT_Model"


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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:265:1: ruleMRow : ( ( rule__MRow__Group__0 ) ) ;
    public final void ruleMRow() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:269:2: ( ( ( rule__MRow__Group__0 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:270:1: ( ( rule__MRow__Group__0 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:270:1: ( ( rule__MRow__Group__0 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:271:1: ( rule__MRow__Group__0 )
            {
             before(grammarAccess.getMRowAccess().getGroup()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:272:1: ( rule__MRow__Group__0 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:272:2: rule__MRow__Group__0
            {
            pushFollow(FOLLOW_rule__MRow__Group__0_in_ruleMRow513);
            rule__MRow__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMRowAccess().getGroup()); 

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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:293:1: ruleERow : ( ( rule__ERow__Group__0 ) ) ;
    public final void ruleERow() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:297:2: ( ( ( rule__ERow__Group__0 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:298:1: ( ( rule__ERow__Group__0 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:298:1: ( ( rule__ERow__Group__0 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:299:1: ( rule__ERow__Group__0 )
            {
             before(grammarAccess.getERowAccess().getGroup()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:300:1: ( rule__ERow__Group__0 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:300:2: rule__ERow__Group__0
            {
            pushFollow(FOLLOW_rule__ERow__Group__0_in_ruleERow573);
            rule__ERow__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getERowAccess().getGroup()); 

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


    // $ANTLR start "rulePieceType"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:313:1: rulePieceType : ( ( rule__PieceType__Alternatives ) ) ;
    public final void rulePieceType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:317:1: ( ( ( rule__PieceType__Alternatives ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:318:1: ( ( rule__PieceType__Alternatives ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:318:1: ( ( rule__PieceType__Alternatives ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:319:1: ( rule__PieceType__Alternatives )
            {
             before(grammarAccess.getPieceTypeAccess().getAlternatives()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:320:1: ( rule__PieceType__Alternatives )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:320:2: rule__PieceType__Alternatives
            {
            pushFollow(FOLLOW_rule__PieceType__Alternatives_in_rulePieceType610);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:331:1: rule__PieceType__Alternatives : ( ( ( 'Pawn' ) ) | ( ( 'Knight' ) ) | ( ( 'Bishop' ) ) | ( ( 'Rook' ) ) | ( ( 'Queen' ) ) | ( ( 'King' ) ) );
    public final void rule__PieceType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:335:1: ( ( ( 'Pawn' ) ) | ( ( 'Knight' ) ) | ( ( 'Bishop' ) ) | ( ( 'Rook' ) ) | ( ( 'Queen' ) ) | ( ( 'King' ) ) )
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
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:336:1: ( ( 'Pawn' ) )
                    {
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:336:1: ( ( 'Pawn' ) )
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:337:1: ( 'Pawn' )
                    {
                     before(grammarAccess.getPieceTypeAccess().getPAWNEnumLiteralDeclaration_0()); 
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:338:1: ( 'Pawn' )
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:338:3: 'Pawn'
                    {
                    match(input,18,FOLLOW_18_in_rule__PieceType__Alternatives646); 

                    }

                     after(grammarAccess.getPieceTypeAccess().getPAWNEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:343:6: ( ( 'Knight' ) )
                    {
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:343:6: ( ( 'Knight' ) )
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:344:1: ( 'Knight' )
                    {
                     before(grammarAccess.getPieceTypeAccess().getKNIGHTEnumLiteralDeclaration_1()); 
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:345:1: ( 'Knight' )
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:345:3: 'Knight'
                    {
                    match(input,19,FOLLOW_19_in_rule__PieceType__Alternatives667); 

                    }

                     after(grammarAccess.getPieceTypeAccess().getKNIGHTEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:350:6: ( ( 'Bishop' ) )
                    {
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:350:6: ( ( 'Bishop' ) )
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:351:1: ( 'Bishop' )
                    {
                     before(grammarAccess.getPieceTypeAccess().getBISHOPEnumLiteralDeclaration_2()); 
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:352:1: ( 'Bishop' )
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:352:3: 'Bishop'
                    {
                    match(input,20,FOLLOW_20_in_rule__PieceType__Alternatives688); 

                    }

                     after(grammarAccess.getPieceTypeAccess().getBISHOPEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:357:6: ( ( 'Rook' ) )
                    {
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:357:6: ( ( 'Rook' ) )
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:358:1: ( 'Rook' )
                    {
                     before(grammarAccess.getPieceTypeAccess().getROOKEnumLiteralDeclaration_3()); 
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:359:1: ( 'Rook' )
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:359:3: 'Rook'
                    {
                    match(input,21,FOLLOW_21_in_rule__PieceType__Alternatives709); 

                    }

                     after(grammarAccess.getPieceTypeAccess().getROOKEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:364:6: ( ( 'Queen' ) )
                    {
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:364:6: ( ( 'Queen' ) )
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:365:1: ( 'Queen' )
                    {
                     before(grammarAccess.getPieceTypeAccess().getQUEENEnumLiteralDeclaration_4()); 
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:366:1: ( 'Queen' )
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:366:3: 'Queen'
                    {
                    match(input,22,FOLLOW_22_in_rule__PieceType__Alternatives730); 

                    }

                     after(grammarAccess.getPieceTypeAccess().getQUEENEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:371:6: ( ( 'King' ) )
                    {
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:371:6: ( ( 'King' ) )
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:372:1: ( 'King' )
                    {
                     before(grammarAccess.getPieceTypeAccess().getKINGEnumLiteralDeclaration_5()); 
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:373:1: ( 'King' )
                    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:373:3: 'King'
                    {
                    match(input,23,FOLLOW_23_in_rule__PieceType__Alternatives751); 

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


    // $ANTLR start "rule__PSQT_Model__Group__0"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:385:1: rule__PSQT_Model__Group__0 : rule__PSQT_Model__Group__0__Impl rule__PSQT_Model__Group__1 ;
    public final void rule__PSQT_Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:389:1: ( rule__PSQT_Model__Group__0__Impl rule__PSQT_Model__Group__1 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:390:2: rule__PSQT_Model__Group__0__Impl rule__PSQT_Model__Group__1
            {
            pushFollow(FOLLOW_rule__PSQT_Model__Group__0__Impl_in_rule__PSQT_Model__Group__0784);
            rule__PSQT_Model__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PSQT_Model__Group__1_in_rule__PSQT_Model__Group__0787);
            rule__PSQT_Model__Group__1();

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
    // $ANTLR end "rule__PSQT_Model__Group__0"


    // $ANTLR start "rule__PSQT_Model__Group__0__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:397:1: rule__PSQT_Model__Group__0__Impl : ( ruleFDescription ) ;
    public final void rule__PSQT_Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:401:1: ( ( ruleFDescription ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:402:1: ( ruleFDescription )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:402:1: ( ruleFDescription )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:403:1: ruleFDescription
            {
             before(grammarAccess.getPSQT_ModelAccess().getFDescriptionParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleFDescription_in_rule__PSQT_Model__Group__0__Impl814);
            ruleFDescription();

            state._fsp--;

             after(grammarAccess.getPSQT_ModelAccess().getFDescriptionParserRuleCall_0()); 

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
    // $ANTLR end "rule__PSQT_Model__Group__0__Impl"


    // $ANTLR start "rule__PSQT_Model__Group__1"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:414:1: rule__PSQT_Model__Group__1 : rule__PSQT_Model__Group__1__Impl ;
    public final void rule__PSQT_Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:418:1: ( rule__PSQT_Model__Group__1__Impl )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:419:2: rule__PSQT_Model__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__PSQT_Model__Group__1__Impl_in_rule__PSQT_Model__Group__1843);
            rule__PSQT_Model__Group__1__Impl();

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
    // $ANTLR end "rule__PSQT_Model__Group__1"


    // $ANTLR start "rule__PSQT_Model__Group__1__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:425:1: rule__PSQT_Model__Group__1__Impl : ( ( rule__PSQT_Model__TablesAssignment_1 )* ) ;
    public final void rule__PSQT_Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:429:1: ( ( ( rule__PSQT_Model__TablesAssignment_1 )* ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:430:1: ( ( rule__PSQT_Model__TablesAssignment_1 )* )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:430:1: ( ( rule__PSQT_Model__TablesAssignment_1 )* )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:431:1: ( rule__PSQT_Model__TablesAssignment_1 )*
            {
             before(grammarAccess.getPSQT_ModelAccess().getTablesAssignment_1()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:432:1: ( rule__PSQT_Model__TablesAssignment_1 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_PIECE) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:432:2: rule__PSQT_Model__TablesAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__PSQT_Model__TablesAssignment_1_in_rule__PSQT_Model__Group__1__Impl870);
            	    rule__PSQT_Model__TablesAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getPSQT_ModelAccess().getTablesAssignment_1()); 

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
    // $ANTLR end "rule__PSQT_Model__Group__1__Impl"


    // $ANTLR start "rule__FDescription__Group__0"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:446:1: rule__FDescription__Group__0 : rule__FDescription__Group__0__Impl rule__FDescription__Group__1 ;
    public final void rule__FDescription__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:450:1: ( rule__FDescription__Group__0__Impl rule__FDescription__Group__1 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:451:2: rule__FDescription__Group__0__Impl rule__FDescription__Group__1
            {
            pushFollow(FOLLOW_rule__FDescription__Group__0__Impl_in_rule__FDescription__Group__0905);
            rule__FDescription__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FDescription__Group__1_in_rule__FDescription__Group__0908);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:458:1: rule__FDescription__Group__0__Impl : ( RULE_PSQT ) ;
    public final void rule__FDescription__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:462:1: ( ( RULE_PSQT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:463:1: ( RULE_PSQT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:463:1: ( RULE_PSQT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:464:1: RULE_PSQT
            {
             before(grammarAccess.getFDescriptionAccess().getPSQTTerminalRuleCall_0()); 
            match(input,RULE_PSQT,FOLLOW_RULE_PSQT_in_rule__FDescription__Group__0__Impl935); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:475:1: rule__FDescription__Group__1 : rule__FDescription__Group__1__Impl rule__FDescription__Group__2 ;
    public final void rule__FDescription__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:479:1: ( rule__FDescription__Group__1__Impl rule__FDescription__Group__2 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:480:2: rule__FDescription__Group__1__Impl rule__FDescription__Group__2
            {
            pushFollow(FOLLOW_rule__FDescription__Group__1__Impl_in_rule__FDescription__Group__1964);
            rule__FDescription__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FDescription__Group__2_in_rule__FDescription__Group__1967);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:487:1: rule__FDescription__Group__1__Impl : ( ( rule__FDescription__NameAssignment_1 ) ) ;
    public final void rule__FDescription__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:491:1: ( ( ( rule__FDescription__NameAssignment_1 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:492:1: ( ( rule__FDescription__NameAssignment_1 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:492:1: ( ( rule__FDescription__NameAssignment_1 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:493:1: ( rule__FDescription__NameAssignment_1 )
            {
             before(grammarAccess.getFDescriptionAccess().getNameAssignment_1()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:494:1: ( rule__FDescription__NameAssignment_1 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:494:2: rule__FDescription__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__FDescription__NameAssignment_1_in_rule__FDescription__Group__1__Impl994);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:504:1: rule__FDescription__Group__2 : rule__FDescription__Group__2__Impl rule__FDescription__Group__3 ;
    public final void rule__FDescription__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:508:1: ( rule__FDescription__Group__2__Impl rule__FDescription__Group__3 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:509:2: rule__FDescription__Group__2__Impl rule__FDescription__Group__3
            {
            pushFollow(FOLLOW_rule__FDescription__Group__2__Impl_in_rule__FDescription__Group__21024);
            rule__FDescription__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FDescription__Group__3_in_rule__FDescription__Group__21027);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:516:1: rule__FDescription__Group__2__Impl : ( RULE_BASE ) ;
    public final void rule__FDescription__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:520:1: ( ( RULE_BASE ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:521:1: ( RULE_BASE )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:521:1: ( RULE_BASE )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:522:1: RULE_BASE
            {
             before(grammarAccess.getFDescriptionAccess().getBASETerminalRuleCall_2()); 
            match(input,RULE_BASE,FOLLOW_RULE_BASE_in_rule__FDescription__Group__2__Impl1054); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:533:1: rule__FDescription__Group__3 : rule__FDescription__Group__3__Impl rule__FDescription__Group__4 ;
    public final void rule__FDescription__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:537:1: ( rule__FDescription__Group__3__Impl rule__FDescription__Group__4 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:538:2: rule__FDescription__Group__3__Impl rule__FDescription__Group__4
            {
            pushFollow(FOLLOW_rule__FDescription__Group__3__Impl_in_rule__FDescription__Group__31083);
            rule__FDescription__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FDescription__Group__4_in_rule__FDescription__Group__31086);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:545:1: rule__FDescription__Group__3__Impl : ( ( rule__FDescription__BaseAssignment_3 ) ) ;
    public final void rule__FDescription__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:549:1: ( ( ( rule__FDescription__BaseAssignment_3 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:550:1: ( ( rule__FDescription__BaseAssignment_3 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:550:1: ( ( rule__FDescription__BaseAssignment_3 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:551:1: ( rule__FDescription__BaseAssignment_3 )
            {
             before(grammarAccess.getFDescriptionAccess().getBaseAssignment_3()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:552:1: ( rule__FDescription__BaseAssignment_3 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:552:2: rule__FDescription__BaseAssignment_3
            {
            pushFollow(FOLLOW_rule__FDescription__BaseAssignment_3_in_rule__FDescription__Group__3__Impl1113);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:562:1: rule__FDescription__Group__4 : rule__FDescription__Group__4__Impl rule__FDescription__Group__5 ;
    public final void rule__FDescription__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:566:1: ( rule__FDescription__Group__4__Impl rule__FDescription__Group__5 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:567:2: rule__FDescription__Group__4__Impl rule__FDescription__Group__5
            {
            pushFollow(FOLLOW_rule__FDescription__Group__4__Impl_in_rule__FDescription__Group__41143);
            rule__FDescription__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FDescription__Group__5_in_rule__FDescription__Group__41146);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:574:1: rule__FDescription__Group__4__Impl : ( RULE_MIDLIMIT ) ;
    public final void rule__FDescription__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:578:1: ( ( RULE_MIDLIMIT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:579:1: ( RULE_MIDLIMIT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:579:1: ( RULE_MIDLIMIT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:580:1: RULE_MIDLIMIT
            {
             before(grammarAccess.getFDescriptionAccess().getMIDLIMITTerminalRuleCall_4()); 
            match(input,RULE_MIDLIMIT,FOLLOW_RULE_MIDLIMIT_in_rule__FDescription__Group__4__Impl1173); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:591:1: rule__FDescription__Group__5 : rule__FDescription__Group__5__Impl rule__FDescription__Group__6 ;
    public final void rule__FDescription__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:595:1: ( rule__FDescription__Group__5__Impl rule__FDescription__Group__6 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:596:2: rule__FDescription__Group__5__Impl rule__FDescription__Group__6
            {
            pushFollow(FOLLOW_rule__FDescription__Group__5__Impl_in_rule__FDescription__Group__51202);
            rule__FDescription__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FDescription__Group__6_in_rule__FDescription__Group__51205);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:603:1: rule__FDescription__Group__5__Impl : ( ( rule__FDescription__MglAssignment_5 ) ) ;
    public final void rule__FDescription__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:607:1: ( ( ( rule__FDescription__MglAssignment_5 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:608:1: ( ( rule__FDescription__MglAssignment_5 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:608:1: ( ( rule__FDescription__MglAssignment_5 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:609:1: ( rule__FDescription__MglAssignment_5 )
            {
             before(grammarAccess.getFDescriptionAccess().getMglAssignment_5()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:610:1: ( rule__FDescription__MglAssignment_5 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:610:2: rule__FDescription__MglAssignment_5
            {
            pushFollow(FOLLOW_rule__FDescription__MglAssignment_5_in_rule__FDescription__Group__5__Impl1232);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:620:1: rule__FDescription__Group__6 : rule__FDescription__Group__6__Impl rule__FDescription__Group__7 ;
    public final void rule__FDescription__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:624:1: ( rule__FDescription__Group__6__Impl rule__FDescription__Group__7 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:625:2: rule__FDescription__Group__6__Impl rule__FDescription__Group__7
            {
            pushFollow(FOLLOW_rule__FDescription__Group__6__Impl_in_rule__FDescription__Group__61262);
            rule__FDescription__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FDescription__Group__7_in_rule__FDescription__Group__61265);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:632:1: rule__FDescription__Group__6__Impl : ( RULE_ENDLIMIT ) ;
    public final void rule__FDescription__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:636:1: ( ( RULE_ENDLIMIT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:637:1: ( RULE_ENDLIMIT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:637:1: ( RULE_ENDLIMIT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:638:1: RULE_ENDLIMIT
            {
             before(grammarAccess.getFDescriptionAccess().getENDLIMITTerminalRuleCall_6()); 
            match(input,RULE_ENDLIMIT,FOLLOW_RULE_ENDLIMIT_in_rule__FDescription__Group__6__Impl1292); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:649:1: rule__FDescription__Group__7 : rule__FDescription__Group__7__Impl ;
    public final void rule__FDescription__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:653:1: ( rule__FDescription__Group__7__Impl )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:654:2: rule__FDescription__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__FDescription__Group__7__Impl_in_rule__FDescription__Group__71321);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:660:1: rule__FDescription__Group__7__Impl : ( ( rule__FDescription__EglAssignment_7 ) ) ;
    public final void rule__FDescription__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:664:1: ( ( ( rule__FDescription__EglAssignment_7 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:665:1: ( ( rule__FDescription__EglAssignment_7 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:665:1: ( ( rule__FDescription__EglAssignment_7 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:666:1: ( rule__FDescription__EglAssignment_7 )
            {
             before(grammarAccess.getFDescriptionAccess().getEglAssignment_7()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:667:1: ( rule__FDescription__EglAssignment_7 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:667:2: rule__FDescription__EglAssignment_7
            {
            pushFollow(FOLLOW_rule__FDescription__EglAssignment_7_in_rule__FDescription__Group__7__Impl1348);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:693:1: rule__Table__Group__0 : rule__Table__Group__0__Impl rule__Table__Group__1 ;
    public final void rule__Table__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:697:1: ( rule__Table__Group__0__Impl rule__Table__Group__1 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:698:2: rule__Table__Group__0__Impl rule__Table__Group__1
            {
            pushFollow(FOLLOW_rule__Table__Group__0__Impl_in_rule__Table__Group__01394);
            rule__Table__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Table__Group__1_in_rule__Table__Group__01397);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:705:1: rule__Table__Group__0__Impl : ( ruleTDescription ) ;
    public final void rule__Table__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:709:1: ( ( ruleTDescription ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:710:1: ( ruleTDescription )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:710:1: ( ruleTDescription )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:711:1: ruleTDescription
            {
             before(grammarAccess.getTableAccess().getTDescriptionParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleTDescription_in_rule__Table__Group__0__Impl1424);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:722:1: rule__Table__Group__1 : rule__Table__Group__1__Impl rule__Table__Group__2 ;
    public final void rule__Table__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:726:1: ( rule__Table__Group__1__Impl rule__Table__Group__2 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:727:2: rule__Table__Group__1__Impl rule__Table__Group__2
            {
            pushFollow(FOLLOW_rule__Table__Group__1__Impl_in_rule__Table__Group__11453);
            rule__Table__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Table__Group__2_in_rule__Table__Group__11456);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:734:1: rule__Table__Group__1__Impl : ( ruleTHeader ) ;
    public final void rule__Table__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:738:1: ( ( ruleTHeader ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:739:1: ( ruleTHeader )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:739:1: ( ruleTHeader )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:740:1: ruleTHeader
            {
             before(grammarAccess.getTableAccess().getTHeaderParserRuleCall_1()); 
            pushFollow(FOLLOW_ruleTHeader_in_rule__Table__Group__1__Impl1483);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:751:1: rule__Table__Group__2 : rule__Table__Group__2__Impl rule__Table__Group__3 ;
    public final void rule__Table__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:755:1: ( rule__Table__Group__2__Impl rule__Table__Group__3 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:756:2: rule__Table__Group__2__Impl rule__Table__Group__3
            {
            pushFollow(FOLLOW_rule__Table__Group__2__Impl_in_rule__Table__Group__21512);
            rule__Table__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Table__Group__3_in_rule__Table__Group__21515);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:763:1: rule__Table__Group__2__Impl : ( ( rule__Table__RAssignment_2 ) ) ;
    public final void rule__Table__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:767:1: ( ( ( rule__Table__RAssignment_2 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:768:1: ( ( rule__Table__RAssignment_2 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:768:1: ( ( rule__Table__RAssignment_2 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:769:1: ( rule__Table__RAssignment_2 )
            {
             before(grammarAccess.getTableAccess().getRAssignment_2()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:770:1: ( rule__Table__RAssignment_2 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:770:2: rule__Table__RAssignment_2
            {
            pushFollow(FOLLOW_rule__Table__RAssignment_2_in_rule__Table__Group__2__Impl1542);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:780:1: rule__Table__Group__3 : rule__Table__Group__3__Impl rule__Table__Group__4 ;
    public final void rule__Table__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:784:1: ( rule__Table__Group__3__Impl rule__Table__Group__4 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:785:2: rule__Table__Group__3__Impl rule__Table__Group__4
            {
            pushFollow(FOLLOW_rule__Table__Group__3__Impl_in_rule__Table__Group__31572);
            rule__Table__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Table__Group__4_in_rule__Table__Group__31575);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:792:1: rule__Table__Group__3__Impl : ( ( rule__Table__RAssignment_3 ) ) ;
    public final void rule__Table__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:796:1: ( ( ( rule__Table__RAssignment_3 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:797:1: ( ( rule__Table__RAssignment_3 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:797:1: ( ( rule__Table__RAssignment_3 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:798:1: ( rule__Table__RAssignment_3 )
            {
             before(grammarAccess.getTableAccess().getRAssignment_3()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:799:1: ( rule__Table__RAssignment_3 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:799:2: rule__Table__RAssignment_3
            {
            pushFollow(FOLLOW_rule__Table__RAssignment_3_in_rule__Table__Group__3__Impl1602);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:809:1: rule__Table__Group__4 : rule__Table__Group__4__Impl rule__Table__Group__5 ;
    public final void rule__Table__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:813:1: ( rule__Table__Group__4__Impl rule__Table__Group__5 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:814:2: rule__Table__Group__4__Impl rule__Table__Group__5
            {
            pushFollow(FOLLOW_rule__Table__Group__4__Impl_in_rule__Table__Group__41632);
            rule__Table__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Table__Group__5_in_rule__Table__Group__41635);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:821:1: rule__Table__Group__4__Impl : ( ( rule__Table__RAssignment_4 ) ) ;
    public final void rule__Table__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:825:1: ( ( ( rule__Table__RAssignment_4 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:826:1: ( ( rule__Table__RAssignment_4 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:826:1: ( ( rule__Table__RAssignment_4 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:827:1: ( rule__Table__RAssignment_4 )
            {
             before(grammarAccess.getTableAccess().getRAssignment_4()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:828:1: ( rule__Table__RAssignment_4 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:828:2: rule__Table__RAssignment_4
            {
            pushFollow(FOLLOW_rule__Table__RAssignment_4_in_rule__Table__Group__4__Impl1662);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:838:1: rule__Table__Group__5 : rule__Table__Group__5__Impl rule__Table__Group__6 ;
    public final void rule__Table__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:842:1: ( rule__Table__Group__5__Impl rule__Table__Group__6 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:843:2: rule__Table__Group__5__Impl rule__Table__Group__6
            {
            pushFollow(FOLLOW_rule__Table__Group__5__Impl_in_rule__Table__Group__51692);
            rule__Table__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Table__Group__6_in_rule__Table__Group__51695);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:850:1: rule__Table__Group__5__Impl : ( ( rule__Table__RAssignment_5 ) ) ;
    public final void rule__Table__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:854:1: ( ( ( rule__Table__RAssignment_5 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:855:1: ( ( rule__Table__RAssignment_5 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:855:1: ( ( rule__Table__RAssignment_5 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:856:1: ( rule__Table__RAssignment_5 )
            {
             before(grammarAccess.getTableAccess().getRAssignment_5()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:857:1: ( rule__Table__RAssignment_5 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:857:2: rule__Table__RAssignment_5
            {
            pushFollow(FOLLOW_rule__Table__RAssignment_5_in_rule__Table__Group__5__Impl1722);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:867:1: rule__Table__Group__6 : rule__Table__Group__6__Impl rule__Table__Group__7 ;
    public final void rule__Table__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:871:1: ( rule__Table__Group__6__Impl rule__Table__Group__7 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:872:2: rule__Table__Group__6__Impl rule__Table__Group__7
            {
            pushFollow(FOLLOW_rule__Table__Group__6__Impl_in_rule__Table__Group__61752);
            rule__Table__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Table__Group__7_in_rule__Table__Group__61755);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:879:1: rule__Table__Group__6__Impl : ( ( rule__Table__RAssignment_6 ) ) ;
    public final void rule__Table__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:883:1: ( ( ( rule__Table__RAssignment_6 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:884:1: ( ( rule__Table__RAssignment_6 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:884:1: ( ( rule__Table__RAssignment_6 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:885:1: ( rule__Table__RAssignment_6 )
            {
             before(grammarAccess.getTableAccess().getRAssignment_6()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:886:1: ( rule__Table__RAssignment_6 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:886:2: rule__Table__RAssignment_6
            {
            pushFollow(FOLLOW_rule__Table__RAssignment_6_in_rule__Table__Group__6__Impl1782);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:896:1: rule__Table__Group__7 : rule__Table__Group__7__Impl rule__Table__Group__8 ;
    public final void rule__Table__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:900:1: ( rule__Table__Group__7__Impl rule__Table__Group__8 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:901:2: rule__Table__Group__7__Impl rule__Table__Group__8
            {
            pushFollow(FOLLOW_rule__Table__Group__7__Impl_in_rule__Table__Group__71812);
            rule__Table__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Table__Group__8_in_rule__Table__Group__71815);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:908:1: rule__Table__Group__7__Impl : ( ( rule__Table__RAssignment_7 ) ) ;
    public final void rule__Table__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:912:1: ( ( ( rule__Table__RAssignment_7 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:913:1: ( ( rule__Table__RAssignment_7 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:913:1: ( ( rule__Table__RAssignment_7 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:914:1: ( rule__Table__RAssignment_7 )
            {
             before(grammarAccess.getTableAccess().getRAssignment_7()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:915:1: ( rule__Table__RAssignment_7 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:915:2: rule__Table__RAssignment_7
            {
            pushFollow(FOLLOW_rule__Table__RAssignment_7_in_rule__Table__Group__7__Impl1842);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:925:1: rule__Table__Group__8 : rule__Table__Group__8__Impl rule__Table__Group__9 ;
    public final void rule__Table__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:929:1: ( rule__Table__Group__8__Impl rule__Table__Group__9 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:930:2: rule__Table__Group__8__Impl rule__Table__Group__9
            {
            pushFollow(FOLLOW_rule__Table__Group__8__Impl_in_rule__Table__Group__81872);
            rule__Table__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Table__Group__9_in_rule__Table__Group__81875);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:937:1: rule__Table__Group__8__Impl : ( ( rule__Table__RAssignment_8 ) ) ;
    public final void rule__Table__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:941:1: ( ( ( rule__Table__RAssignment_8 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:942:1: ( ( rule__Table__RAssignment_8 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:942:1: ( ( rule__Table__RAssignment_8 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:943:1: ( rule__Table__RAssignment_8 )
            {
             before(grammarAccess.getTableAccess().getRAssignment_8()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:944:1: ( rule__Table__RAssignment_8 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:944:2: rule__Table__RAssignment_8
            {
            pushFollow(FOLLOW_rule__Table__RAssignment_8_in_rule__Table__Group__8__Impl1902);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:954:1: rule__Table__Group__9 : rule__Table__Group__9__Impl ;
    public final void rule__Table__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:958:1: ( rule__Table__Group__9__Impl )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:959:2: rule__Table__Group__9__Impl
            {
            pushFollow(FOLLOW_rule__Table__Group__9__Impl_in_rule__Table__Group__91932);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:965:1: rule__Table__Group__9__Impl : ( ( rule__Table__RAssignment_9 ) ) ;
    public final void rule__Table__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:969:1: ( ( ( rule__Table__RAssignment_9 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:970:1: ( ( rule__Table__RAssignment_9 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:970:1: ( ( rule__Table__RAssignment_9 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:971:1: ( rule__Table__RAssignment_9 )
            {
             before(grammarAccess.getTableAccess().getRAssignment_9()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:972:1: ( rule__Table__RAssignment_9 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:972:2: rule__Table__RAssignment_9
            {
            pushFollow(FOLLOW_rule__Table__RAssignment_9_in_rule__Table__Group__9__Impl1959);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1002:1: rule__TDescription__Group__0 : rule__TDescription__Group__0__Impl rule__TDescription__Group__1 ;
    public final void rule__TDescription__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1006:1: ( rule__TDescription__Group__0__Impl rule__TDescription__Group__1 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1007:2: rule__TDescription__Group__0__Impl rule__TDescription__Group__1
            {
            pushFollow(FOLLOW_rule__TDescription__Group__0__Impl_in_rule__TDescription__Group__02009);
            rule__TDescription__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TDescription__Group__1_in_rule__TDescription__Group__02012);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1014:1: rule__TDescription__Group__0__Impl : ( RULE_PIECE ) ;
    public final void rule__TDescription__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1018:1: ( ( RULE_PIECE ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1019:1: ( RULE_PIECE )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1019:1: ( RULE_PIECE )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1020:1: RULE_PIECE
            {
             before(grammarAccess.getTDescriptionAccess().getPIECETerminalRuleCall_0()); 
            match(input,RULE_PIECE,FOLLOW_RULE_PIECE_in_rule__TDescription__Group__0__Impl2039); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1031:1: rule__TDescription__Group__1 : rule__TDescription__Group__1__Impl rule__TDescription__Group__2 ;
    public final void rule__TDescription__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1035:1: ( rule__TDescription__Group__1__Impl rule__TDescription__Group__2 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1036:2: rule__TDescription__Group__1__Impl rule__TDescription__Group__2
            {
            pushFollow(FOLLOW_rule__TDescription__Group__1__Impl_in_rule__TDescription__Group__12068);
            rule__TDescription__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TDescription__Group__2_in_rule__TDescription__Group__12071);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1043:1: rule__TDescription__Group__1__Impl : ( ( rule__TDescription__NameAssignment_1 ) ) ;
    public final void rule__TDescription__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1047:1: ( ( ( rule__TDescription__NameAssignment_1 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1048:1: ( ( rule__TDescription__NameAssignment_1 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1048:1: ( ( rule__TDescription__NameAssignment_1 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1049:1: ( rule__TDescription__NameAssignment_1 )
            {
             before(grammarAccess.getTDescriptionAccess().getNameAssignment_1()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1050:1: ( rule__TDescription__NameAssignment_1 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1050:2: rule__TDescription__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__TDescription__NameAssignment_1_in_rule__TDescription__Group__1__Impl2098);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1060:1: rule__TDescription__Group__2 : rule__TDescription__Group__2__Impl rule__TDescription__Group__3 ;
    public final void rule__TDescription__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1064:1: ( rule__TDescription__Group__2__Impl rule__TDescription__Group__3 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1065:2: rule__TDescription__Group__2__Impl rule__TDescription__Group__3
            {
            pushFollow(FOLLOW_rule__TDescription__Group__2__Impl_in_rule__TDescription__Group__22128);
            rule__TDescription__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TDescription__Group__3_in_rule__TDescription__Group__22131);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1072:1: rule__TDescription__Group__2__Impl : ( RULE_MIDGAME ) ;
    public final void rule__TDescription__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1076:1: ( ( RULE_MIDGAME ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1077:1: ( RULE_MIDGAME )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1077:1: ( RULE_MIDGAME )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1078:1: RULE_MIDGAME
            {
             before(grammarAccess.getTDescriptionAccess().getMIDGAMETerminalRuleCall_2()); 
            match(input,RULE_MIDGAME,FOLLOW_RULE_MIDGAME_in_rule__TDescription__Group__2__Impl2158); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1089:1: rule__TDescription__Group__3 : rule__TDescription__Group__3__Impl rule__TDescription__Group__4 ;
    public final void rule__TDescription__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1093:1: ( rule__TDescription__Group__3__Impl rule__TDescription__Group__4 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1094:2: rule__TDescription__Group__3__Impl rule__TDescription__Group__4
            {
            pushFollow(FOLLOW_rule__TDescription__Group__3__Impl_in_rule__TDescription__Group__32187);
            rule__TDescription__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TDescription__Group__4_in_rule__TDescription__Group__32190);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1101:1: rule__TDescription__Group__3__Impl : ( ( rule__TDescription__MgAssignment_3 ) ) ;
    public final void rule__TDescription__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1105:1: ( ( ( rule__TDescription__MgAssignment_3 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1106:1: ( ( rule__TDescription__MgAssignment_3 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1106:1: ( ( rule__TDescription__MgAssignment_3 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1107:1: ( rule__TDescription__MgAssignment_3 )
            {
             before(grammarAccess.getTDescriptionAccess().getMgAssignment_3()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1108:1: ( rule__TDescription__MgAssignment_3 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1108:2: rule__TDescription__MgAssignment_3
            {
            pushFollow(FOLLOW_rule__TDescription__MgAssignment_3_in_rule__TDescription__Group__3__Impl2217);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1118:1: rule__TDescription__Group__4 : rule__TDescription__Group__4__Impl rule__TDescription__Group__5 ;
    public final void rule__TDescription__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1122:1: ( rule__TDescription__Group__4__Impl rule__TDescription__Group__5 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1123:2: rule__TDescription__Group__4__Impl rule__TDescription__Group__5
            {
            pushFollow(FOLLOW_rule__TDescription__Group__4__Impl_in_rule__TDescription__Group__42247);
            rule__TDescription__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TDescription__Group__5_in_rule__TDescription__Group__42250);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1130:1: rule__TDescription__Group__4__Impl : ( RULE_ENDGAME ) ;
    public final void rule__TDescription__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1134:1: ( ( RULE_ENDGAME ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1135:1: ( RULE_ENDGAME )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1135:1: ( RULE_ENDGAME )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1136:1: RULE_ENDGAME
            {
             before(grammarAccess.getTDescriptionAccess().getENDGAMETerminalRuleCall_4()); 
            match(input,RULE_ENDGAME,FOLLOW_RULE_ENDGAME_in_rule__TDescription__Group__4__Impl2277); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1147:1: rule__TDescription__Group__5 : rule__TDescription__Group__5__Impl ;
    public final void rule__TDescription__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1151:1: ( rule__TDescription__Group__5__Impl )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1152:2: rule__TDescription__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__TDescription__Group__5__Impl_in_rule__TDescription__Group__52306);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1158:1: rule__TDescription__Group__5__Impl : ( ( rule__TDescription__EgAssignment_5 ) ) ;
    public final void rule__TDescription__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1162:1: ( ( ( rule__TDescription__EgAssignment_5 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1163:1: ( ( rule__TDescription__EgAssignment_5 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1163:1: ( ( rule__TDescription__EgAssignment_5 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1164:1: ( rule__TDescription__EgAssignment_5 )
            {
             before(grammarAccess.getTDescriptionAccess().getEgAssignment_5()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1165:1: ( rule__TDescription__EgAssignment_5 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1165:2: rule__TDescription__EgAssignment_5
            {
            pushFollow(FOLLOW_rule__TDescription__EgAssignment_5_in_rule__TDescription__Group__5__Impl2333);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1187:1: rule__THeader__Group__0 : rule__THeader__Group__0__Impl rule__THeader__Group__1 ;
    public final void rule__THeader__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1191:1: ( rule__THeader__Group__0__Impl rule__THeader__Group__1 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1192:2: rule__THeader__Group__0__Impl rule__THeader__Group__1
            {
            pushFollow(FOLLOW_rule__THeader__Group__0__Impl_in_rule__THeader__Group__02375);
            rule__THeader__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__THeader__Group__1_in_rule__THeader__Group__02378);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1199:1: rule__THeader__Group__0__Impl : ( 'A' ) ;
    public final void rule__THeader__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1203:1: ( ( 'A' ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1204:1: ( 'A' )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1204:1: ( 'A' )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1205:1: 'A'
            {
             before(grammarAccess.getTHeaderAccess().getAKeyword_0()); 
            match(input,24,FOLLOW_24_in_rule__THeader__Group__0__Impl2406); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1218:1: rule__THeader__Group__1 : rule__THeader__Group__1__Impl rule__THeader__Group__2 ;
    public final void rule__THeader__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1222:1: ( rule__THeader__Group__1__Impl rule__THeader__Group__2 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1223:2: rule__THeader__Group__1__Impl rule__THeader__Group__2
            {
            pushFollow(FOLLOW_rule__THeader__Group__1__Impl_in_rule__THeader__Group__12437);
            rule__THeader__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__THeader__Group__2_in_rule__THeader__Group__12440);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1230:1: rule__THeader__Group__1__Impl : ( 'B' ) ;
    public final void rule__THeader__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1234:1: ( ( 'B' ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1235:1: ( 'B' )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1235:1: ( 'B' )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1236:1: 'B'
            {
             before(grammarAccess.getTHeaderAccess().getBKeyword_1()); 
            match(input,25,FOLLOW_25_in_rule__THeader__Group__1__Impl2468); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1249:1: rule__THeader__Group__2 : rule__THeader__Group__2__Impl rule__THeader__Group__3 ;
    public final void rule__THeader__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1253:1: ( rule__THeader__Group__2__Impl rule__THeader__Group__3 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1254:2: rule__THeader__Group__2__Impl rule__THeader__Group__3
            {
            pushFollow(FOLLOW_rule__THeader__Group__2__Impl_in_rule__THeader__Group__22499);
            rule__THeader__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__THeader__Group__3_in_rule__THeader__Group__22502);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1261:1: rule__THeader__Group__2__Impl : ( 'C' ) ;
    public final void rule__THeader__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1265:1: ( ( 'C' ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1266:1: ( 'C' )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1266:1: ( 'C' )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1267:1: 'C'
            {
             before(grammarAccess.getTHeaderAccess().getCKeyword_2()); 
            match(input,26,FOLLOW_26_in_rule__THeader__Group__2__Impl2530); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1280:1: rule__THeader__Group__3 : rule__THeader__Group__3__Impl rule__THeader__Group__4 ;
    public final void rule__THeader__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1284:1: ( rule__THeader__Group__3__Impl rule__THeader__Group__4 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1285:2: rule__THeader__Group__3__Impl rule__THeader__Group__4
            {
            pushFollow(FOLLOW_rule__THeader__Group__3__Impl_in_rule__THeader__Group__32561);
            rule__THeader__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__THeader__Group__4_in_rule__THeader__Group__32564);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1292:1: rule__THeader__Group__3__Impl : ( 'D' ) ;
    public final void rule__THeader__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1296:1: ( ( 'D' ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1297:1: ( 'D' )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1297:1: ( 'D' )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1298:1: 'D'
            {
             before(grammarAccess.getTHeaderAccess().getDKeyword_3()); 
            match(input,27,FOLLOW_27_in_rule__THeader__Group__3__Impl2592); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1311:1: rule__THeader__Group__4 : rule__THeader__Group__4__Impl rule__THeader__Group__5 ;
    public final void rule__THeader__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1315:1: ( rule__THeader__Group__4__Impl rule__THeader__Group__5 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1316:2: rule__THeader__Group__4__Impl rule__THeader__Group__5
            {
            pushFollow(FOLLOW_rule__THeader__Group__4__Impl_in_rule__THeader__Group__42623);
            rule__THeader__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__THeader__Group__5_in_rule__THeader__Group__42626);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1323:1: rule__THeader__Group__4__Impl : ( 'E' ) ;
    public final void rule__THeader__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1327:1: ( ( 'E' ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1328:1: ( 'E' )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1328:1: ( 'E' )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1329:1: 'E'
            {
             before(grammarAccess.getTHeaderAccess().getEKeyword_4()); 
            match(input,28,FOLLOW_28_in_rule__THeader__Group__4__Impl2654); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1342:1: rule__THeader__Group__5 : rule__THeader__Group__5__Impl rule__THeader__Group__6 ;
    public final void rule__THeader__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1346:1: ( rule__THeader__Group__5__Impl rule__THeader__Group__6 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1347:2: rule__THeader__Group__5__Impl rule__THeader__Group__6
            {
            pushFollow(FOLLOW_rule__THeader__Group__5__Impl_in_rule__THeader__Group__52685);
            rule__THeader__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__THeader__Group__6_in_rule__THeader__Group__52688);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1354:1: rule__THeader__Group__5__Impl : ( 'F' ) ;
    public final void rule__THeader__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1358:1: ( ( 'F' ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1359:1: ( 'F' )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1359:1: ( 'F' )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1360:1: 'F'
            {
             before(grammarAccess.getTHeaderAccess().getFKeyword_5()); 
            match(input,29,FOLLOW_29_in_rule__THeader__Group__5__Impl2716); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1373:1: rule__THeader__Group__6 : rule__THeader__Group__6__Impl rule__THeader__Group__7 ;
    public final void rule__THeader__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1377:1: ( rule__THeader__Group__6__Impl rule__THeader__Group__7 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1378:2: rule__THeader__Group__6__Impl rule__THeader__Group__7
            {
            pushFollow(FOLLOW_rule__THeader__Group__6__Impl_in_rule__THeader__Group__62747);
            rule__THeader__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__THeader__Group__7_in_rule__THeader__Group__62750);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1385:1: rule__THeader__Group__6__Impl : ( 'G' ) ;
    public final void rule__THeader__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1389:1: ( ( 'G' ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1390:1: ( 'G' )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1390:1: ( 'G' )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1391:1: 'G'
            {
             before(grammarAccess.getTHeaderAccess().getGKeyword_6()); 
            match(input,30,FOLLOW_30_in_rule__THeader__Group__6__Impl2778); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1404:1: rule__THeader__Group__7 : rule__THeader__Group__7__Impl ;
    public final void rule__THeader__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1408:1: ( rule__THeader__Group__7__Impl )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1409:2: rule__THeader__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__THeader__Group__7__Impl_in_rule__THeader__Group__72809);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1415:1: rule__THeader__Group__7__Impl : ( 'H' ) ;
    public final void rule__THeader__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1419:1: ( ( 'H' ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1420:1: ( 'H' )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1420:1: ( 'H' )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1421:1: 'H'
            {
             before(grammarAccess.getTHeaderAccess().getHKeyword_7()); 
            match(input,31,FOLLOW_31_in_rule__THeader__Group__7__Impl2837); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1450:1: rule__Row__Group__0 : rule__Row__Group__0__Impl rule__Row__Group__1 ;
    public final void rule__Row__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1454:1: ( rule__Row__Group__0__Impl rule__Row__Group__1 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1455:2: rule__Row__Group__0__Impl rule__Row__Group__1
            {
            pushFollow(FOLLOW_rule__Row__Group__0__Impl_in_rule__Row__Group__02884);
            rule__Row__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Row__Group__1_in_rule__Row__Group__02887);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1462:1: rule__Row__Group__0__Impl : ( ( rule__Row__NameAssignment_0 ) ) ;
    public final void rule__Row__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1466:1: ( ( ( rule__Row__NameAssignment_0 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1467:1: ( ( rule__Row__NameAssignment_0 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1467:1: ( ( rule__Row__NameAssignment_0 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1468:1: ( rule__Row__NameAssignment_0 )
            {
             before(grammarAccess.getRowAccess().getNameAssignment_0()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1469:1: ( rule__Row__NameAssignment_0 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1469:2: rule__Row__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Row__NameAssignment_0_in_rule__Row__Group__0__Impl2914);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1479:1: rule__Row__Group__1 : rule__Row__Group__1__Impl rule__Row__Group__2 ;
    public final void rule__Row__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1483:1: ( rule__Row__Group__1__Impl rule__Row__Group__2 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1484:2: rule__Row__Group__1__Impl rule__Row__Group__2
            {
            pushFollow(FOLLOW_rule__Row__Group__1__Impl_in_rule__Row__Group__12944);
            rule__Row__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Row__Group__2_in_rule__Row__Group__12947);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1491:1: rule__Row__Group__1__Impl : ( ( rule__Row__MidrowAssignment_1 ) ) ;
    public final void rule__Row__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1495:1: ( ( ( rule__Row__MidrowAssignment_1 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1496:1: ( ( rule__Row__MidrowAssignment_1 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1496:1: ( ( rule__Row__MidrowAssignment_1 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1497:1: ( rule__Row__MidrowAssignment_1 )
            {
             before(grammarAccess.getRowAccess().getMidrowAssignment_1()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1498:1: ( rule__Row__MidrowAssignment_1 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1498:2: rule__Row__MidrowAssignment_1
            {
            pushFollow(FOLLOW_rule__Row__MidrowAssignment_1_in_rule__Row__Group__1__Impl2974);
            rule__Row__MidrowAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRowAccess().getMidrowAssignment_1()); 

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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1508:1: rule__Row__Group__2 : rule__Row__Group__2__Impl ;
    public final void rule__Row__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1512:1: ( rule__Row__Group__2__Impl )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1513:2: rule__Row__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Row__Group__2__Impl_in_rule__Row__Group__23004);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1519:1: rule__Row__Group__2__Impl : ( ( rule__Row__EndrowAssignment_2 ) ) ;
    public final void rule__Row__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1523:1: ( ( ( rule__Row__EndrowAssignment_2 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1524:1: ( ( rule__Row__EndrowAssignment_2 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1524:1: ( ( rule__Row__EndrowAssignment_2 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1525:1: ( rule__Row__EndrowAssignment_2 )
            {
             before(grammarAccess.getRowAccess().getEndrowAssignment_2()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1526:1: ( rule__Row__EndrowAssignment_2 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1526:2: rule__Row__EndrowAssignment_2
            {
            pushFollow(FOLLOW_rule__Row__EndrowAssignment_2_in_rule__Row__Group__2__Impl3031);
            rule__Row__EndrowAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getRowAccess().getEndrowAssignment_2()); 

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


    // $ANTLR start "rule__MRow__Group__0"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1542:1: rule__MRow__Group__0 : rule__MRow__Group__0__Impl rule__MRow__Group__1 ;
    public final void rule__MRow__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1546:1: ( rule__MRow__Group__0__Impl rule__MRow__Group__1 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1547:2: rule__MRow__Group__0__Impl rule__MRow__Group__1
            {
            pushFollow(FOLLOW_rule__MRow__Group__0__Impl_in_rule__MRow__Group__03067);
            rule__MRow__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MRow__Group__1_in_rule__MRow__Group__03070);
            rule__MRow__Group__1();

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
    // $ANTLR end "rule__MRow__Group__0"


    // $ANTLR start "rule__MRow__Group__0__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1554:1: rule__MRow__Group__0__Impl : ( ( rule__MRow__C1Assignment_0 ) ) ;
    public final void rule__MRow__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1558:1: ( ( ( rule__MRow__C1Assignment_0 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1559:1: ( ( rule__MRow__C1Assignment_0 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1559:1: ( ( rule__MRow__C1Assignment_0 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1560:1: ( rule__MRow__C1Assignment_0 )
            {
             before(grammarAccess.getMRowAccess().getC1Assignment_0()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1561:1: ( rule__MRow__C1Assignment_0 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1561:2: rule__MRow__C1Assignment_0
            {
            pushFollow(FOLLOW_rule__MRow__C1Assignment_0_in_rule__MRow__Group__0__Impl3097);
            rule__MRow__C1Assignment_0();

            state._fsp--;


            }

             after(grammarAccess.getMRowAccess().getC1Assignment_0()); 

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
    // $ANTLR end "rule__MRow__Group__0__Impl"


    // $ANTLR start "rule__MRow__Group__1"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1571:1: rule__MRow__Group__1 : rule__MRow__Group__1__Impl rule__MRow__Group__2 ;
    public final void rule__MRow__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1575:1: ( rule__MRow__Group__1__Impl rule__MRow__Group__2 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1576:2: rule__MRow__Group__1__Impl rule__MRow__Group__2
            {
            pushFollow(FOLLOW_rule__MRow__Group__1__Impl_in_rule__MRow__Group__13127);
            rule__MRow__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MRow__Group__2_in_rule__MRow__Group__13130);
            rule__MRow__Group__2();

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
    // $ANTLR end "rule__MRow__Group__1"


    // $ANTLR start "rule__MRow__Group__1__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1583:1: rule__MRow__Group__1__Impl : ( ( rule__MRow__C2Assignment_1 ) ) ;
    public final void rule__MRow__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1587:1: ( ( ( rule__MRow__C2Assignment_1 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1588:1: ( ( rule__MRow__C2Assignment_1 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1588:1: ( ( rule__MRow__C2Assignment_1 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1589:1: ( rule__MRow__C2Assignment_1 )
            {
             before(grammarAccess.getMRowAccess().getC2Assignment_1()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1590:1: ( rule__MRow__C2Assignment_1 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1590:2: rule__MRow__C2Assignment_1
            {
            pushFollow(FOLLOW_rule__MRow__C2Assignment_1_in_rule__MRow__Group__1__Impl3157);
            rule__MRow__C2Assignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMRowAccess().getC2Assignment_1()); 

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
    // $ANTLR end "rule__MRow__Group__1__Impl"


    // $ANTLR start "rule__MRow__Group__2"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1600:1: rule__MRow__Group__2 : rule__MRow__Group__2__Impl rule__MRow__Group__3 ;
    public final void rule__MRow__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1604:1: ( rule__MRow__Group__2__Impl rule__MRow__Group__3 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1605:2: rule__MRow__Group__2__Impl rule__MRow__Group__3
            {
            pushFollow(FOLLOW_rule__MRow__Group__2__Impl_in_rule__MRow__Group__23187);
            rule__MRow__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MRow__Group__3_in_rule__MRow__Group__23190);
            rule__MRow__Group__3();

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
    // $ANTLR end "rule__MRow__Group__2"


    // $ANTLR start "rule__MRow__Group__2__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1612:1: rule__MRow__Group__2__Impl : ( ( rule__MRow__C3Assignment_2 ) ) ;
    public final void rule__MRow__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1616:1: ( ( ( rule__MRow__C3Assignment_2 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1617:1: ( ( rule__MRow__C3Assignment_2 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1617:1: ( ( rule__MRow__C3Assignment_2 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1618:1: ( rule__MRow__C3Assignment_2 )
            {
             before(grammarAccess.getMRowAccess().getC3Assignment_2()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1619:1: ( rule__MRow__C3Assignment_2 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1619:2: rule__MRow__C3Assignment_2
            {
            pushFollow(FOLLOW_rule__MRow__C3Assignment_2_in_rule__MRow__Group__2__Impl3217);
            rule__MRow__C3Assignment_2();

            state._fsp--;


            }

             after(grammarAccess.getMRowAccess().getC3Assignment_2()); 

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
    // $ANTLR end "rule__MRow__Group__2__Impl"


    // $ANTLR start "rule__MRow__Group__3"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1629:1: rule__MRow__Group__3 : rule__MRow__Group__3__Impl rule__MRow__Group__4 ;
    public final void rule__MRow__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1633:1: ( rule__MRow__Group__3__Impl rule__MRow__Group__4 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1634:2: rule__MRow__Group__3__Impl rule__MRow__Group__4
            {
            pushFollow(FOLLOW_rule__MRow__Group__3__Impl_in_rule__MRow__Group__33247);
            rule__MRow__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MRow__Group__4_in_rule__MRow__Group__33250);
            rule__MRow__Group__4();

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
    // $ANTLR end "rule__MRow__Group__3"


    // $ANTLR start "rule__MRow__Group__3__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1641:1: rule__MRow__Group__3__Impl : ( ( rule__MRow__C4Assignment_3 ) ) ;
    public final void rule__MRow__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1645:1: ( ( ( rule__MRow__C4Assignment_3 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1646:1: ( ( rule__MRow__C4Assignment_3 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1646:1: ( ( rule__MRow__C4Assignment_3 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1647:1: ( rule__MRow__C4Assignment_3 )
            {
             before(grammarAccess.getMRowAccess().getC4Assignment_3()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1648:1: ( rule__MRow__C4Assignment_3 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1648:2: rule__MRow__C4Assignment_3
            {
            pushFollow(FOLLOW_rule__MRow__C4Assignment_3_in_rule__MRow__Group__3__Impl3277);
            rule__MRow__C4Assignment_3();

            state._fsp--;


            }

             after(grammarAccess.getMRowAccess().getC4Assignment_3()); 

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
    // $ANTLR end "rule__MRow__Group__3__Impl"


    // $ANTLR start "rule__MRow__Group__4"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1658:1: rule__MRow__Group__4 : rule__MRow__Group__4__Impl rule__MRow__Group__5 ;
    public final void rule__MRow__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1662:1: ( rule__MRow__Group__4__Impl rule__MRow__Group__5 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1663:2: rule__MRow__Group__4__Impl rule__MRow__Group__5
            {
            pushFollow(FOLLOW_rule__MRow__Group__4__Impl_in_rule__MRow__Group__43307);
            rule__MRow__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MRow__Group__5_in_rule__MRow__Group__43310);
            rule__MRow__Group__5();

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
    // $ANTLR end "rule__MRow__Group__4"


    // $ANTLR start "rule__MRow__Group__4__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1670:1: rule__MRow__Group__4__Impl : ( ( rule__MRow__C5Assignment_4 ) ) ;
    public final void rule__MRow__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1674:1: ( ( ( rule__MRow__C5Assignment_4 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1675:1: ( ( rule__MRow__C5Assignment_4 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1675:1: ( ( rule__MRow__C5Assignment_4 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1676:1: ( rule__MRow__C5Assignment_4 )
            {
             before(grammarAccess.getMRowAccess().getC5Assignment_4()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1677:1: ( rule__MRow__C5Assignment_4 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1677:2: rule__MRow__C5Assignment_4
            {
            pushFollow(FOLLOW_rule__MRow__C5Assignment_4_in_rule__MRow__Group__4__Impl3337);
            rule__MRow__C5Assignment_4();

            state._fsp--;


            }

             after(grammarAccess.getMRowAccess().getC5Assignment_4()); 

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
    // $ANTLR end "rule__MRow__Group__4__Impl"


    // $ANTLR start "rule__MRow__Group__5"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1687:1: rule__MRow__Group__5 : rule__MRow__Group__5__Impl rule__MRow__Group__6 ;
    public final void rule__MRow__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1691:1: ( rule__MRow__Group__5__Impl rule__MRow__Group__6 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1692:2: rule__MRow__Group__5__Impl rule__MRow__Group__6
            {
            pushFollow(FOLLOW_rule__MRow__Group__5__Impl_in_rule__MRow__Group__53367);
            rule__MRow__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MRow__Group__6_in_rule__MRow__Group__53370);
            rule__MRow__Group__6();

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
    // $ANTLR end "rule__MRow__Group__5"


    // $ANTLR start "rule__MRow__Group__5__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1699:1: rule__MRow__Group__5__Impl : ( ( rule__MRow__C6Assignment_5 ) ) ;
    public final void rule__MRow__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1703:1: ( ( ( rule__MRow__C6Assignment_5 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1704:1: ( ( rule__MRow__C6Assignment_5 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1704:1: ( ( rule__MRow__C6Assignment_5 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1705:1: ( rule__MRow__C6Assignment_5 )
            {
             before(grammarAccess.getMRowAccess().getC6Assignment_5()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1706:1: ( rule__MRow__C6Assignment_5 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1706:2: rule__MRow__C6Assignment_5
            {
            pushFollow(FOLLOW_rule__MRow__C6Assignment_5_in_rule__MRow__Group__5__Impl3397);
            rule__MRow__C6Assignment_5();

            state._fsp--;


            }

             after(grammarAccess.getMRowAccess().getC6Assignment_5()); 

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
    // $ANTLR end "rule__MRow__Group__5__Impl"


    // $ANTLR start "rule__MRow__Group__6"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1716:1: rule__MRow__Group__6 : rule__MRow__Group__6__Impl rule__MRow__Group__7 ;
    public final void rule__MRow__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1720:1: ( rule__MRow__Group__6__Impl rule__MRow__Group__7 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1721:2: rule__MRow__Group__6__Impl rule__MRow__Group__7
            {
            pushFollow(FOLLOW_rule__MRow__Group__6__Impl_in_rule__MRow__Group__63427);
            rule__MRow__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MRow__Group__7_in_rule__MRow__Group__63430);
            rule__MRow__Group__7();

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
    // $ANTLR end "rule__MRow__Group__6"


    // $ANTLR start "rule__MRow__Group__6__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1728:1: rule__MRow__Group__6__Impl : ( ( rule__MRow__C7Assignment_6 ) ) ;
    public final void rule__MRow__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1732:1: ( ( ( rule__MRow__C7Assignment_6 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1733:1: ( ( rule__MRow__C7Assignment_6 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1733:1: ( ( rule__MRow__C7Assignment_6 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1734:1: ( rule__MRow__C7Assignment_6 )
            {
             before(grammarAccess.getMRowAccess().getC7Assignment_6()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1735:1: ( rule__MRow__C7Assignment_6 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1735:2: rule__MRow__C7Assignment_6
            {
            pushFollow(FOLLOW_rule__MRow__C7Assignment_6_in_rule__MRow__Group__6__Impl3457);
            rule__MRow__C7Assignment_6();

            state._fsp--;


            }

             after(grammarAccess.getMRowAccess().getC7Assignment_6()); 

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
    // $ANTLR end "rule__MRow__Group__6__Impl"


    // $ANTLR start "rule__MRow__Group__7"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1745:1: rule__MRow__Group__7 : rule__MRow__Group__7__Impl ;
    public final void rule__MRow__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1749:1: ( rule__MRow__Group__7__Impl )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1750:2: rule__MRow__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__MRow__Group__7__Impl_in_rule__MRow__Group__73487);
            rule__MRow__Group__7__Impl();

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
    // $ANTLR end "rule__MRow__Group__7"


    // $ANTLR start "rule__MRow__Group__7__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1756:1: rule__MRow__Group__7__Impl : ( ( rule__MRow__C8Assignment_7 ) ) ;
    public final void rule__MRow__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1760:1: ( ( ( rule__MRow__C8Assignment_7 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1761:1: ( ( rule__MRow__C8Assignment_7 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1761:1: ( ( rule__MRow__C8Assignment_7 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1762:1: ( rule__MRow__C8Assignment_7 )
            {
             before(grammarAccess.getMRowAccess().getC8Assignment_7()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1763:1: ( rule__MRow__C8Assignment_7 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1763:2: rule__MRow__C8Assignment_7
            {
            pushFollow(FOLLOW_rule__MRow__C8Assignment_7_in_rule__MRow__Group__7__Impl3514);
            rule__MRow__C8Assignment_7();

            state._fsp--;


            }

             after(grammarAccess.getMRowAccess().getC8Assignment_7()); 

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
    // $ANTLR end "rule__MRow__Group__7__Impl"


    // $ANTLR start "rule__ERow__Group__0"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1789:1: rule__ERow__Group__0 : rule__ERow__Group__0__Impl rule__ERow__Group__1 ;
    public final void rule__ERow__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1793:1: ( rule__ERow__Group__0__Impl rule__ERow__Group__1 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1794:2: rule__ERow__Group__0__Impl rule__ERow__Group__1
            {
            pushFollow(FOLLOW_rule__ERow__Group__0__Impl_in_rule__ERow__Group__03560);
            rule__ERow__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ERow__Group__1_in_rule__ERow__Group__03563);
            rule__ERow__Group__1();

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
    // $ANTLR end "rule__ERow__Group__0"


    // $ANTLR start "rule__ERow__Group__0__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1801:1: rule__ERow__Group__0__Impl : ( ( rule__ERow__C1Assignment_0 ) ) ;
    public final void rule__ERow__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1805:1: ( ( ( rule__ERow__C1Assignment_0 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1806:1: ( ( rule__ERow__C1Assignment_0 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1806:1: ( ( rule__ERow__C1Assignment_0 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1807:1: ( rule__ERow__C1Assignment_0 )
            {
             before(grammarAccess.getERowAccess().getC1Assignment_0()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1808:1: ( rule__ERow__C1Assignment_0 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1808:2: rule__ERow__C1Assignment_0
            {
            pushFollow(FOLLOW_rule__ERow__C1Assignment_0_in_rule__ERow__Group__0__Impl3590);
            rule__ERow__C1Assignment_0();

            state._fsp--;


            }

             after(grammarAccess.getERowAccess().getC1Assignment_0()); 

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
    // $ANTLR end "rule__ERow__Group__0__Impl"


    // $ANTLR start "rule__ERow__Group__1"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1818:1: rule__ERow__Group__1 : rule__ERow__Group__1__Impl rule__ERow__Group__2 ;
    public final void rule__ERow__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1822:1: ( rule__ERow__Group__1__Impl rule__ERow__Group__2 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1823:2: rule__ERow__Group__1__Impl rule__ERow__Group__2
            {
            pushFollow(FOLLOW_rule__ERow__Group__1__Impl_in_rule__ERow__Group__13620);
            rule__ERow__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ERow__Group__2_in_rule__ERow__Group__13623);
            rule__ERow__Group__2();

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
    // $ANTLR end "rule__ERow__Group__1"


    // $ANTLR start "rule__ERow__Group__1__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1830:1: rule__ERow__Group__1__Impl : ( ( rule__ERow__C2Assignment_1 ) ) ;
    public final void rule__ERow__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1834:1: ( ( ( rule__ERow__C2Assignment_1 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1835:1: ( ( rule__ERow__C2Assignment_1 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1835:1: ( ( rule__ERow__C2Assignment_1 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1836:1: ( rule__ERow__C2Assignment_1 )
            {
             before(grammarAccess.getERowAccess().getC2Assignment_1()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1837:1: ( rule__ERow__C2Assignment_1 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1837:2: rule__ERow__C2Assignment_1
            {
            pushFollow(FOLLOW_rule__ERow__C2Assignment_1_in_rule__ERow__Group__1__Impl3650);
            rule__ERow__C2Assignment_1();

            state._fsp--;


            }

             after(grammarAccess.getERowAccess().getC2Assignment_1()); 

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
    // $ANTLR end "rule__ERow__Group__1__Impl"


    // $ANTLR start "rule__ERow__Group__2"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1847:1: rule__ERow__Group__2 : rule__ERow__Group__2__Impl rule__ERow__Group__3 ;
    public final void rule__ERow__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1851:1: ( rule__ERow__Group__2__Impl rule__ERow__Group__3 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1852:2: rule__ERow__Group__2__Impl rule__ERow__Group__3
            {
            pushFollow(FOLLOW_rule__ERow__Group__2__Impl_in_rule__ERow__Group__23680);
            rule__ERow__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ERow__Group__3_in_rule__ERow__Group__23683);
            rule__ERow__Group__3();

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
    // $ANTLR end "rule__ERow__Group__2"


    // $ANTLR start "rule__ERow__Group__2__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1859:1: rule__ERow__Group__2__Impl : ( ( rule__ERow__C3Assignment_2 ) ) ;
    public final void rule__ERow__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1863:1: ( ( ( rule__ERow__C3Assignment_2 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1864:1: ( ( rule__ERow__C3Assignment_2 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1864:1: ( ( rule__ERow__C3Assignment_2 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1865:1: ( rule__ERow__C3Assignment_2 )
            {
             before(grammarAccess.getERowAccess().getC3Assignment_2()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1866:1: ( rule__ERow__C3Assignment_2 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1866:2: rule__ERow__C3Assignment_2
            {
            pushFollow(FOLLOW_rule__ERow__C3Assignment_2_in_rule__ERow__Group__2__Impl3710);
            rule__ERow__C3Assignment_2();

            state._fsp--;


            }

             after(grammarAccess.getERowAccess().getC3Assignment_2()); 

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
    // $ANTLR end "rule__ERow__Group__2__Impl"


    // $ANTLR start "rule__ERow__Group__3"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1876:1: rule__ERow__Group__3 : rule__ERow__Group__3__Impl rule__ERow__Group__4 ;
    public final void rule__ERow__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1880:1: ( rule__ERow__Group__3__Impl rule__ERow__Group__4 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1881:2: rule__ERow__Group__3__Impl rule__ERow__Group__4
            {
            pushFollow(FOLLOW_rule__ERow__Group__3__Impl_in_rule__ERow__Group__33740);
            rule__ERow__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ERow__Group__4_in_rule__ERow__Group__33743);
            rule__ERow__Group__4();

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
    // $ANTLR end "rule__ERow__Group__3"


    // $ANTLR start "rule__ERow__Group__3__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1888:1: rule__ERow__Group__3__Impl : ( ( rule__ERow__C4Assignment_3 ) ) ;
    public final void rule__ERow__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1892:1: ( ( ( rule__ERow__C4Assignment_3 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1893:1: ( ( rule__ERow__C4Assignment_3 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1893:1: ( ( rule__ERow__C4Assignment_3 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1894:1: ( rule__ERow__C4Assignment_3 )
            {
             before(grammarAccess.getERowAccess().getC4Assignment_3()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1895:1: ( rule__ERow__C4Assignment_3 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1895:2: rule__ERow__C4Assignment_3
            {
            pushFollow(FOLLOW_rule__ERow__C4Assignment_3_in_rule__ERow__Group__3__Impl3770);
            rule__ERow__C4Assignment_3();

            state._fsp--;


            }

             after(grammarAccess.getERowAccess().getC4Assignment_3()); 

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
    // $ANTLR end "rule__ERow__Group__3__Impl"


    // $ANTLR start "rule__ERow__Group__4"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1905:1: rule__ERow__Group__4 : rule__ERow__Group__4__Impl rule__ERow__Group__5 ;
    public final void rule__ERow__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1909:1: ( rule__ERow__Group__4__Impl rule__ERow__Group__5 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1910:2: rule__ERow__Group__4__Impl rule__ERow__Group__5
            {
            pushFollow(FOLLOW_rule__ERow__Group__4__Impl_in_rule__ERow__Group__43800);
            rule__ERow__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ERow__Group__5_in_rule__ERow__Group__43803);
            rule__ERow__Group__5();

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
    // $ANTLR end "rule__ERow__Group__4"


    // $ANTLR start "rule__ERow__Group__4__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1917:1: rule__ERow__Group__4__Impl : ( ( rule__ERow__C5Assignment_4 ) ) ;
    public final void rule__ERow__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1921:1: ( ( ( rule__ERow__C5Assignment_4 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1922:1: ( ( rule__ERow__C5Assignment_4 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1922:1: ( ( rule__ERow__C5Assignment_4 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1923:1: ( rule__ERow__C5Assignment_4 )
            {
             before(grammarAccess.getERowAccess().getC5Assignment_4()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1924:1: ( rule__ERow__C5Assignment_4 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1924:2: rule__ERow__C5Assignment_4
            {
            pushFollow(FOLLOW_rule__ERow__C5Assignment_4_in_rule__ERow__Group__4__Impl3830);
            rule__ERow__C5Assignment_4();

            state._fsp--;


            }

             after(grammarAccess.getERowAccess().getC5Assignment_4()); 

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
    // $ANTLR end "rule__ERow__Group__4__Impl"


    // $ANTLR start "rule__ERow__Group__5"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1934:1: rule__ERow__Group__5 : rule__ERow__Group__5__Impl rule__ERow__Group__6 ;
    public final void rule__ERow__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1938:1: ( rule__ERow__Group__5__Impl rule__ERow__Group__6 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1939:2: rule__ERow__Group__5__Impl rule__ERow__Group__6
            {
            pushFollow(FOLLOW_rule__ERow__Group__5__Impl_in_rule__ERow__Group__53860);
            rule__ERow__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ERow__Group__6_in_rule__ERow__Group__53863);
            rule__ERow__Group__6();

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
    // $ANTLR end "rule__ERow__Group__5"


    // $ANTLR start "rule__ERow__Group__5__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1946:1: rule__ERow__Group__5__Impl : ( ( rule__ERow__C6Assignment_5 ) ) ;
    public final void rule__ERow__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1950:1: ( ( ( rule__ERow__C6Assignment_5 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1951:1: ( ( rule__ERow__C6Assignment_5 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1951:1: ( ( rule__ERow__C6Assignment_5 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1952:1: ( rule__ERow__C6Assignment_5 )
            {
             before(grammarAccess.getERowAccess().getC6Assignment_5()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1953:1: ( rule__ERow__C6Assignment_5 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1953:2: rule__ERow__C6Assignment_5
            {
            pushFollow(FOLLOW_rule__ERow__C6Assignment_5_in_rule__ERow__Group__5__Impl3890);
            rule__ERow__C6Assignment_5();

            state._fsp--;


            }

             after(grammarAccess.getERowAccess().getC6Assignment_5()); 

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
    // $ANTLR end "rule__ERow__Group__5__Impl"


    // $ANTLR start "rule__ERow__Group__6"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1963:1: rule__ERow__Group__6 : rule__ERow__Group__6__Impl rule__ERow__Group__7 ;
    public final void rule__ERow__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1967:1: ( rule__ERow__Group__6__Impl rule__ERow__Group__7 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1968:2: rule__ERow__Group__6__Impl rule__ERow__Group__7
            {
            pushFollow(FOLLOW_rule__ERow__Group__6__Impl_in_rule__ERow__Group__63920);
            rule__ERow__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ERow__Group__7_in_rule__ERow__Group__63923);
            rule__ERow__Group__7();

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
    // $ANTLR end "rule__ERow__Group__6"


    // $ANTLR start "rule__ERow__Group__6__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1975:1: rule__ERow__Group__6__Impl : ( ( rule__ERow__C7Assignment_6 ) ) ;
    public final void rule__ERow__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1979:1: ( ( ( rule__ERow__C7Assignment_6 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1980:1: ( ( rule__ERow__C7Assignment_6 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1980:1: ( ( rule__ERow__C7Assignment_6 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1981:1: ( rule__ERow__C7Assignment_6 )
            {
             before(grammarAccess.getERowAccess().getC7Assignment_6()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1982:1: ( rule__ERow__C7Assignment_6 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1982:2: rule__ERow__C7Assignment_6
            {
            pushFollow(FOLLOW_rule__ERow__C7Assignment_6_in_rule__ERow__Group__6__Impl3950);
            rule__ERow__C7Assignment_6();

            state._fsp--;


            }

             after(grammarAccess.getERowAccess().getC7Assignment_6()); 

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
    // $ANTLR end "rule__ERow__Group__6__Impl"


    // $ANTLR start "rule__ERow__Group__7"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1992:1: rule__ERow__Group__7 : rule__ERow__Group__7__Impl ;
    public final void rule__ERow__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1996:1: ( rule__ERow__Group__7__Impl )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1997:2: rule__ERow__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__ERow__Group__7__Impl_in_rule__ERow__Group__73980);
            rule__ERow__Group__7__Impl();

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
    // $ANTLR end "rule__ERow__Group__7"


    // $ANTLR start "rule__ERow__Group__7__Impl"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2003:1: rule__ERow__Group__7__Impl : ( ( rule__ERow__C8Assignment_7 ) ) ;
    public final void rule__ERow__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2007:1: ( ( ( rule__ERow__C8Assignment_7 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2008:1: ( ( rule__ERow__C8Assignment_7 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2008:1: ( ( rule__ERow__C8Assignment_7 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2009:1: ( rule__ERow__C8Assignment_7 )
            {
             before(grammarAccess.getERowAccess().getC8Assignment_7()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2010:1: ( rule__ERow__C8Assignment_7 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2010:2: rule__ERow__C8Assignment_7
            {
            pushFollow(FOLLOW_rule__ERow__C8Assignment_7_in_rule__ERow__Group__7__Impl4007);
            rule__ERow__C8Assignment_7();

            state._fsp--;


            }

             after(grammarAccess.getERowAccess().getC8Assignment_7()); 

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
    // $ANTLR end "rule__ERow__Group__7__Impl"


    // $ANTLR start "rule__PSQT_Model__TablesAssignment_1"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2037:1: rule__PSQT_Model__TablesAssignment_1 : ( ruleTable ) ;
    public final void rule__PSQT_Model__TablesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2041:1: ( ( ruleTable ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2042:1: ( ruleTable )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2042:1: ( ruleTable )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2043:1: ruleTable
            {
             before(grammarAccess.getPSQT_ModelAccess().getTablesTableParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleTable_in_rule__PSQT_Model__TablesAssignment_14058);
            ruleTable();

            state._fsp--;

             after(grammarAccess.getPSQT_ModelAccess().getTablesTableParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__PSQT_Model__TablesAssignment_1"


    // $ANTLR start "rule__FDescription__NameAssignment_1"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2052:1: rule__FDescription__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__FDescription__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2056:1: ( ( RULE_ID ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2057:1: ( RULE_ID )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2057:1: ( RULE_ID )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2058:1: RULE_ID
            {
             before(grammarAccess.getFDescriptionAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FDescription__NameAssignment_14089); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2067:1: rule__FDescription__BaseAssignment_3 : ( RULE_INT ) ;
    public final void rule__FDescription__BaseAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2071:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2072:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2072:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2073:1: RULE_INT
            {
             before(grammarAccess.getFDescriptionAccess().getBaseINTTerminalRuleCall_3_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__FDescription__BaseAssignment_34120); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2082:1: rule__FDescription__MglAssignment_5 : ( RULE_INT ) ;
    public final void rule__FDescription__MglAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2086:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2087:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2087:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2088:1: RULE_INT
            {
             before(grammarAccess.getFDescriptionAccess().getMglINTTerminalRuleCall_5_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__FDescription__MglAssignment_54151); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2097:1: rule__FDescription__EglAssignment_7 : ( RULE_INT ) ;
    public final void rule__FDescription__EglAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2101:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2102:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2102:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2103:1: RULE_INT
            {
             before(grammarAccess.getFDescriptionAccess().getEglINTTerminalRuleCall_7_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__FDescription__EglAssignment_74182); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2112:1: rule__Table__RAssignment_2 : ( ruleRow ) ;
    public final void rule__Table__RAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2116:1: ( ( ruleRow ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2117:1: ( ruleRow )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2117:1: ( ruleRow )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2118:1: ruleRow
            {
             before(grammarAccess.getTableAccess().getRRowParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleRow_in_rule__Table__RAssignment_24213);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2127:1: rule__Table__RAssignment_3 : ( ruleRow ) ;
    public final void rule__Table__RAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2131:1: ( ( ruleRow ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2132:1: ( ruleRow )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2132:1: ( ruleRow )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2133:1: ruleRow
            {
             before(grammarAccess.getTableAccess().getRRowParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleRow_in_rule__Table__RAssignment_34244);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2142:1: rule__Table__RAssignment_4 : ( ruleRow ) ;
    public final void rule__Table__RAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2146:1: ( ( ruleRow ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2147:1: ( ruleRow )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2147:1: ( ruleRow )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2148:1: ruleRow
            {
             before(grammarAccess.getTableAccess().getRRowParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleRow_in_rule__Table__RAssignment_44275);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2157:1: rule__Table__RAssignment_5 : ( ruleRow ) ;
    public final void rule__Table__RAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2161:1: ( ( ruleRow ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2162:1: ( ruleRow )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2162:1: ( ruleRow )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2163:1: ruleRow
            {
             before(grammarAccess.getTableAccess().getRRowParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleRow_in_rule__Table__RAssignment_54306);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2172:1: rule__Table__RAssignment_6 : ( ruleRow ) ;
    public final void rule__Table__RAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2176:1: ( ( ruleRow ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2177:1: ( ruleRow )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2177:1: ( ruleRow )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2178:1: ruleRow
            {
             before(grammarAccess.getTableAccess().getRRowParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleRow_in_rule__Table__RAssignment_64337);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2187:1: rule__Table__RAssignment_7 : ( ruleRow ) ;
    public final void rule__Table__RAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2191:1: ( ( ruleRow ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2192:1: ( ruleRow )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2192:1: ( ruleRow )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2193:1: ruleRow
            {
             before(grammarAccess.getTableAccess().getRRowParserRuleCall_7_0()); 
            pushFollow(FOLLOW_ruleRow_in_rule__Table__RAssignment_74368);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2202:1: rule__Table__RAssignment_8 : ( ruleRow ) ;
    public final void rule__Table__RAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2206:1: ( ( ruleRow ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2207:1: ( ruleRow )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2207:1: ( ruleRow )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2208:1: ruleRow
            {
             before(grammarAccess.getTableAccess().getRRowParserRuleCall_8_0()); 
            pushFollow(FOLLOW_ruleRow_in_rule__Table__RAssignment_84399);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2217:1: rule__Table__RAssignment_9 : ( ruleRow ) ;
    public final void rule__Table__RAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2221:1: ( ( ruleRow ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2222:1: ( ruleRow )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2222:1: ( ruleRow )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2223:1: ruleRow
            {
             before(grammarAccess.getTableAccess().getRRowParserRuleCall_9_0()); 
            pushFollow(FOLLOW_ruleRow_in_rule__Table__RAssignment_94430);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2232:1: rule__TDescription__NameAssignment_1 : ( rulePieceType ) ;
    public final void rule__TDescription__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2236:1: ( ( rulePieceType ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2237:1: ( rulePieceType )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2237:1: ( rulePieceType )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2238:1: rulePieceType
            {
             before(grammarAccess.getTDescriptionAccess().getNamePieceTypeEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_rulePieceType_in_rule__TDescription__NameAssignment_14461);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2247:1: rule__TDescription__MgAssignment_3 : ( RULE_INT ) ;
    public final void rule__TDescription__MgAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2251:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2252:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2252:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2253:1: RULE_INT
            {
             before(grammarAccess.getTDescriptionAccess().getMgINTTerminalRuleCall_3_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__TDescription__MgAssignment_34492); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2262:1: rule__TDescription__EgAssignment_5 : ( RULE_INT ) ;
    public final void rule__TDescription__EgAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2266:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2267:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2267:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2268:1: RULE_INT
            {
             before(grammarAccess.getTDescriptionAccess().getEgINTTerminalRuleCall_5_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__TDescription__EgAssignment_54523); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2277:1: rule__Row__NameAssignment_0 : ( ruleRowLabel ) ;
    public final void rule__Row__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2281:1: ( ( ruleRowLabel ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2282:1: ( ruleRowLabel )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2282:1: ( ruleRowLabel )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2283:1: ruleRowLabel
            {
             before(grammarAccess.getRowAccess().getNameRowLabelParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleRowLabel_in_rule__Row__NameAssignment_04554);
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


    // $ANTLR start "rule__Row__MidrowAssignment_1"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2292:1: rule__Row__MidrowAssignment_1 : ( ruleMRow ) ;
    public final void rule__Row__MidrowAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2296:1: ( ( ruleMRow ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2297:1: ( ruleMRow )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2297:1: ( ruleMRow )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2298:1: ruleMRow
            {
             before(grammarAccess.getRowAccess().getMidrowMRowParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleMRow_in_rule__Row__MidrowAssignment_14585);
            ruleMRow();

            state._fsp--;

             after(grammarAccess.getRowAccess().getMidrowMRowParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__Row__MidrowAssignment_1"


    // $ANTLR start "rule__Row__EndrowAssignment_2"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2307:1: rule__Row__EndrowAssignment_2 : ( ruleERow ) ;
    public final void rule__Row__EndrowAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2311:1: ( ( ruleERow ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2312:1: ( ruleERow )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2312:1: ( ruleERow )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2313:1: ruleERow
            {
             before(grammarAccess.getRowAccess().getEndrowERowParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleERow_in_rule__Row__EndrowAssignment_24616);
            ruleERow();

            state._fsp--;

             after(grammarAccess.getRowAccess().getEndrowERowParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__Row__EndrowAssignment_2"


    // $ANTLR start "rule__MRow__C1Assignment_0"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2322:1: rule__MRow__C1Assignment_0 : ( RULE_INT ) ;
    public final void rule__MRow__C1Assignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2326:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2327:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2327:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2328:1: RULE_INT
            {
             before(grammarAccess.getMRowAccess().getC1INTTerminalRuleCall_0_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__MRow__C1Assignment_04647); 
             after(grammarAccess.getMRowAccess().getC1INTTerminalRuleCall_0_0()); 

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
    // $ANTLR end "rule__MRow__C1Assignment_0"


    // $ANTLR start "rule__MRow__C2Assignment_1"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2337:1: rule__MRow__C2Assignment_1 : ( RULE_INT ) ;
    public final void rule__MRow__C2Assignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2341:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2342:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2342:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2343:1: RULE_INT
            {
             before(grammarAccess.getMRowAccess().getC2INTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__MRow__C2Assignment_14678); 
             after(grammarAccess.getMRowAccess().getC2INTTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__MRow__C2Assignment_1"


    // $ANTLR start "rule__MRow__C3Assignment_2"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2352:1: rule__MRow__C3Assignment_2 : ( RULE_INT ) ;
    public final void rule__MRow__C3Assignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2356:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2357:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2357:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2358:1: RULE_INT
            {
             before(grammarAccess.getMRowAccess().getC3INTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__MRow__C3Assignment_24709); 
             after(grammarAccess.getMRowAccess().getC3INTTerminalRuleCall_2_0()); 

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
    // $ANTLR end "rule__MRow__C3Assignment_2"


    // $ANTLR start "rule__MRow__C4Assignment_3"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2367:1: rule__MRow__C4Assignment_3 : ( RULE_INT ) ;
    public final void rule__MRow__C4Assignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2371:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2372:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2372:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2373:1: RULE_INT
            {
             before(grammarAccess.getMRowAccess().getC4INTTerminalRuleCall_3_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__MRow__C4Assignment_34740); 
             after(grammarAccess.getMRowAccess().getC4INTTerminalRuleCall_3_0()); 

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
    // $ANTLR end "rule__MRow__C4Assignment_3"


    // $ANTLR start "rule__MRow__C5Assignment_4"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2382:1: rule__MRow__C5Assignment_4 : ( RULE_INT ) ;
    public final void rule__MRow__C5Assignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2386:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2387:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2387:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2388:1: RULE_INT
            {
             before(grammarAccess.getMRowAccess().getC5INTTerminalRuleCall_4_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__MRow__C5Assignment_44771); 
             after(grammarAccess.getMRowAccess().getC5INTTerminalRuleCall_4_0()); 

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
    // $ANTLR end "rule__MRow__C5Assignment_4"


    // $ANTLR start "rule__MRow__C6Assignment_5"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2397:1: rule__MRow__C6Assignment_5 : ( RULE_INT ) ;
    public final void rule__MRow__C6Assignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2401:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2402:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2402:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2403:1: RULE_INT
            {
             before(grammarAccess.getMRowAccess().getC6INTTerminalRuleCall_5_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__MRow__C6Assignment_54802); 
             after(grammarAccess.getMRowAccess().getC6INTTerminalRuleCall_5_0()); 

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
    // $ANTLR end "rule__MRow__C6Assignment_5"


    // $ANTLR start "rule__MRow__C7Assignment_6"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2412:1: rule__MRow__C7Assignment_6 : ( RULE_INT ) ;
    public final void rule__MRow__C7Assignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2416:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2417:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2417:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2418:1: RULE_INT
            {
             before(grammarAccess.getMRowAccess().getC7INTTerminalRuleCall_6_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__MRow__C7Assignment_64833); 
             after(grammarAccess.getMRowAccess().getC7INTTerminalRuleCall_6_0()); 

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
    // $ANTLR end "rule__MRow__C7Assignment_6"


    // $ANTLR start "rule__MRow__C8Assignment_7"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2427:1: rule__MRow__C8Assignment_7 : ( RULE_INT ) ;
    public final void rule__MRow__C8Assignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2431:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2432:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2432:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2433:1: RULE_INT
            {
             before(grammarAccess.getMRowAccess().getC8INTTerminalRuleCall_7_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__MRow__C8Assignment_74864); 
             after(grammarAccess.getMRowAccess().getC8INTTerminalRuleCall_7_0()); 

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
    // $ANTLR end "rule__MRow__C8Assignment_7"


    // $ANTLR start "rule__ERow__C1Assignment_0"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2442:1: rule__ERow__C1Assignment_0 : ( RULE_INT ) ;
    public final void rule__ERow__C1Assignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2446:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2447:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2447:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2448:1: RULE_INT
            {
             before(grammarAccess.getERowAccess().getC1INTTerminalRuleCall_0_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__ERow__C1Assignment_04895); 
             after(grammarAccess.getERowAccess().getC1INTTerminalRuleCall_0_0()); 

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
    // $ANTLR end "rule__ERow__C1Assignment_0"


    // $ANTLR start "rule__ERow__C2Assignment_1"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2457:1: rule__ERow__C2Assignment_1 : ( RULE_INT ) ;
    public final void rule__ERow__C2Assignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2461:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2462:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2462:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2463:1: RULE_INT
            {
             before(grammarAccess.getERowAccess().getC2INTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__ERow__C2Assignment_14926); 
             after(grammarAccess.getERowAccess().getC2INTTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__ERow__C2Assignment_1"


    // $ANTLR start "rule__ERow__C3Assignment_2"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2472:1: rule__ERow__C3Assignment_2 : ( RULE_INT ) ;
    public final void rule__ERow__C3Assignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2476:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2477:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2477:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2478:1: RULE_INT
            {
             before(grammarAccess.getERowAccess().getC3INTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__ERow__C3Assignment_24957); 
             after(grammarAccess.getERowAccess().getC3INTTerminalRuleCall_2_0()); 

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
    // $ANTLR end "rule__ERow__C3Assignment_2"


    // $ANTLR start "rule__ERow__C4Assignment_3"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2487:1: rule__ERow__C4Assignment_3 : ( RULE_INT ) ;
    public final void rule__ERow__C4Assignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2491:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2492:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2492:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2493:1: RULE_INT
            {
             before(grammarAccess.getERowAccess().getC4INTTerminalRuleCall_3_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__ERow__C4Assignment_34988); 
             after(grammarAccess.getERowAccess().getC4INTTerminalRuleCall_3_0()); 

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
    // $ANTLR end "rule__ERow__C4Assignment_3"


    // $ANTLR start "rule__ERow__C5Assignment_4"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2502:1: rule__ERow__C5Assignment_4 : ( RULE_INT ) ;
    public final void rule__ERow__C5Assignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2506:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2507:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2507:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2508:1: RULE_INT
            {
             before(grammarAccess.getERowAccess().getC5INTTerminalRuleCall_4_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__ERow__C5Assignment_45019); 
             after(grammarAccess.getERowAccess().getC5INTTerminalRuleCall_4_0()); 

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
    // $ANTLR end "rule__ERow__C5Assignment_4"


    // $ANTLR start "rule__ERow__C6Assignment_5"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2517:1: rule__ERow__C6Assignment_5 : ( RULE_INT ) ;
    public final void rule__ERow__C6Assignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2521:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2522:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2522:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2523:1: RULE_INT
            {
             before(grammarAccess.getERowAccess().getC6INTTerminalRuleCall_5_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__ERow__C6Assignment_55050); 
             after(grammarAccess.getERowAccess().getC6INTTerminalRuleCall_5_0()); 

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
    // $ANTLR end "rule__ERow__C6Assignment_5"


    // $ANTLR start "rule__ERow__C7Assignment_6"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2532:1: rule__ERow__C7Assignment_6 : ( RULE_INT ) ;
    public final void rule__ERow__C7Assignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2536:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2537:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2537:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2538:1: RULE_INT
            {
             before(grammarAccess.getERowAccess().getC7INTTerminalRuleCall_6_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__ERow__C7Assignment_65081); 
             after(grammarAccess.getERowAccess().getC7INTTerminalRuleCall_6_0()); 

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
    // $ANTLR end "rule__ERow__C7Assignment_6"


    // $ANTLR start "rule__ERow__C8Assignment_7"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2547:1: rule__ERow__C8Assignment_7 : ( RULE_INT ) ;
    public final void rule__ERow__C8Assignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2551:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2552:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2552:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2553:1: RULE_INT
            {
             before(grammarAccess.getERowAccess().getC8INTTerminalRuleCall_7_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__ERow__C8Assignment_75112); 
             after(grammarAccess.getERowAccess().getC8INTTerminalRuleCall_7_0()); 

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
    // $ANTLR end "rule__ERow__C8Assignment_7"

    // Delegated rules


 

    public static final BitSet FOLLOW_rulePSQT_Model_in_entryRulePSQT_Model61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePSQT_Model68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PSQT_Model__Group__0_in_rulePSQT_Model94 = new BitSet(new long[]{0x0000000000000002L});
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
    public static final BitSet FOLLOW_rule__MRow__Group__0_in_ruleMRow513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleERow_in_entryRuleERow540 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleERow547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ERow__Group__0_in_ruleERow573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PieceType__Alternatives_in_rulePieceType610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__PieceType__Alternatives646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__PieceType__Alternatives667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__PieceType__Alternatives688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__PieceType__Alternatives709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__PieceType__Alternatives730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__PieceType__Alternatives751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PSQT_Model__Group__0__Impl_in_rule__PSQT_Model__Group__0784 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_rule__PSQT_Model__Group__1_in_rule__PSQT_Model__Group__0787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFDescription_in_rule__PSQT_Model__Group__0__Impl814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PSQT_Model__Group__1__Impl_in_rule__PSQT_Model__Group__1843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PSQT_Model__TablesAssignment_1_in_rule__PSQT_Model__Group__1__Impl870 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_rule__FDescription__Group__0__Impl_in_rule__FDescription__Group__0905 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__FDescription__Group__1_in_rule__FDescription__Group__0908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PSQT_in_rule__FDescription__Group__0__Impl935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FDescription__Group__1__Impl_in_rule__FDescription__Group__1964 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__FDescription__Group__2_in_rule__FDescription__Group__1967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FDescription__NameAssignment_1_in_rule__FDescription__Group__1__Impl994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FDescription__Group__2__Impl_in_rule__FDescription__Group__21024 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FDescription__Group__3_in_rule__FDescription__Group__21027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BASE_in_rule__FDescription__Group__2__Impl1054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FDescription__Group__3__Impl_in_rule__FDescription__Group__31083 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__FDescription__Group__4_in_rule__FDescription__Group__31086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FDescription__BaseAssignment_3_in_rule__FDescription__Group__3__Impl1113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FDescription__Group__4__Impl_in_rule__FDescription__Group__41143 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FDescription__Group__5_in_rule__FDescription__Group__41146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MIDLIMIT_in_rule__FDescription__Group__4__Impl1173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FDescription__Group__5__Impl_in_rule__FDescription__Group__51202 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__FDescription__Group__6_in_rule__FDescription__Group__51205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FDescription__MglAssignment_5_in_rule__FDescription__Group__5__Impl1232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FDescription__Group__6__Impl_in_rule__FDescription__Group__61262 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FDescription__Group__7_in_rule__FDescription__Group__61265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ENDLIMIT_in_rule__FDescription__Group__6__Impl1292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FDescription__Group__7__Impl_in_rule__FDescription__Group__71321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FDescription__EglAssignment_7_in_rule__FDescription__Group__7__Impl1348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__Group__0__Impl_in_rule__Table__Group__01394 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__Table__Group__1_in_rule__Table__Group__01397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTDescription_in_rule__Table__Group__0__Impl1424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__Group__1__Impl_in_rule__Table__Group__11453 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Table__Group__2_in_rule__Table__Group__11456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTHeader_in_rule__Table__Group__1__Impl1483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__Group__2__Impl_in_rule__Table__Group__21512 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Table__Group__3_in_rule__Table__Group__21515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__RAssignment_2_in_rule__Table__Group__2__Impl1542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__Group__3__Impl_in_rule__Table__Group__31572 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Table__Group__4_in_rule__Table__Group__31575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__RAssignment_3_in_rule__Table__Group__3__Impl1602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__Group__4__Impl_in_rule__Table__Group__41632 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Table__Group__5_in_rule__Table__Group__41635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__RAssignment_4_in_rule__Table__Group__4__Impl1662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__Group__5__Impl_in_rule__Table__Group__51692 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Table__Group__6_in_rule__Table__Group__51695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__RAssignment_5_in_rule__Table__Group__5__Impl1722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__Group__6__Impl_in_rule__Table__Group__61752 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Table__Group__7_in_rule__Table__Group__61755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__RAssignment_6_in_rule__Table__Group__6__Impl1782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__Group__7__Impl_in_rule__Table__Group__71812 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Table__Group__8_in_rule__Table__Group__71815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__RAssignment_7_in_rule__Table__Group__7__Impl1842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__Group__8__Impl_in_rule__Table__Group__81872 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Table__Group__9_in_rule__Table__Group__81875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__RAssignment_8_in_rule__Table__Group__8__Impl1902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__Group__9__Impl_in_rule__Table__Group__91932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__RAssignment_9_in_rule__Table__Group__9__Impl1959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TDescription__Group__0__Impl_in_rule__TDescription__Group__02009 = new BitSet(new long[]{0x0000000000FC0000L});
    public static final BitSet FOLLOW_rule__TDescription__Group__1_in_rule__TDescription__Group__02012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PIECE_in_rule__TDescription__Group__0__Impl2039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TDescription__Group__1__Impl_in_rule__TDescription__Group__12068 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__TDescription__Group__2_in_rule__TDescription__Group__12071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TDescription__NameAssignment_1_in_rule__TDescription__Group__1__Impl2098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TDescription__Group__2__Impl_in_rule__TDescription__Group__22128 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__TDescription__Group__3_in_rule__TDescription__Group__22131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MIDGAME_in_rule__TDescription__Group__2__Impl2158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TDescription__Group__3__Impl_in_rule__TDescription__Group__32187 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_rule__TDescription__Group__4_in_rule__TDescription__Group__32190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TDescription__MgAssignment_3_in_rule__TDescription__Group__3__Impl2217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TDescription__Group__4__Impl_in_rule__TDescription__Group__42247 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__TDescription__Group__5_in_rule__TDescription__Group__42250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ENDGAME_in_rule__TDescription__Group__4__Impl2277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TDescription__Group__5__Impl_in_rule__TDescription__Group__52306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TDescription__EgAssignment_5_in_rule__TDescription__Group__5__Impl2333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__THeader__Group__0__Impl_in_rule__THeader__Group__02375 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__THeader__Group__1_in_rule__THeader__Group__02378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__THeader__Group__0__Impl2406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__THeader__Group__1__Impl_in_rule__THeader__Group__12437 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__THeader__Group__2_in_rule__THeader__Group__12440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__THeader__Group__1__Impl2468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__THeader__Group__2__Impl_in_rule__THeader__Group__22499 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__THeader__Group__3_in_rule__THeader__Group__22502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__THeader__Group__2__Impl2530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__THeader__Group__3__Impl_in_rule__THeader__Group__32561 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__THeader__Group__4_in_rule__THeader__Group__32564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__THeader__Group__3__Impl2592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__THeader__Group__4__Impl_in_rule__THeader__Group__42623 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__THeader__Group__5_in_rule__THeader__Group__42626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__THeader__Group__4__Impl2654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__THeader__Group__5__Impl_in_rule__THeader__Group__52685 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__THeader__Group__6_in_rule__THeader__Group__52688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__THeader__Group__5__Impl2716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__THeader__Group__6__Impl_in_rule__THeader__Group__62747 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__THeader__Group__7_in_rule__THeader__Group__62750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__THeader__Group__6__Impl2778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__THeader__Group__7__Impl_in_rule__THeader__Group__72809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__THeader__Group__7__Impl2837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row__Group__0__Impl_in_rule__Row__Group__02884 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Row__Group__1_in_rule__Row__Group__02887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row__NameAssignment_0_in_rule__Row__Group__0__Impl2914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row__Group__1__Impl_in_rule__Row__Group__12944 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Row__Group__2_in_rule__Row__Group__12947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row__MidrowAssignment_1_in_rule__Row__Group__1__Impl2974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row__Group__2__Impl_in_rule__Row__Group__23004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row__EndrowAssignment_2_in_rule__Row__Group__2__Impl3031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MRow__Group__0__Impl_in_rule__MRow__Group__03067 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__MRow__Group__1_in_rule__MRow__Group__03070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MRow__C1Assignment_0_in_rule__MRow__Group__0__Impl3097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MRow__Group__1__Impl_in_rule__MRow__Group__13127 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__MRow__Group__2_in_rule__MRow__Group__13130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MRow__C2Assignment_1_in_rule__MRow__Group__1__Impl3157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MRow__Group__2__Impl_in_rule__MRow__Group__23187 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__MRow__Group__3_in_rule__MRow__Group__23190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MRow__C3Assignment_2_in_rule__MRow__Group__2__Impl3217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MRow__Group__3__Impl_in_rule__MRow__Group__33247 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__MRow__Group__4_in_rule__MRow__Group__33250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MRow__C4Assignment_3_in_rule__MRow__Group__3__Impl3277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MRow__Group__4__Impl_in_rule__MRow__Group__43307 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__MRow__Group__5_in_rule__MRow__Group__43310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MRow__C5Assignment_4_in_rule__MRow__Group__4__Impl3337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MRow__Group__5__Impl_in_rule__MRow__Group__53367 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__MRow__Group__6_in_rule__MRow__Group__53370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MRow__C6Assignment_5_in_rule__MRow__Group__5__Impl3397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MRow__Group__6__Impl_in_rule__MRow__Group__63427 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__MRow__Group__7_in_rule__MRow__Group__63430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MRow__C7Assignment_6_in_rule__MRow__Group__6__Impl3457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MRow__Group__7__Impl_in_rule__MRow__Group__73487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MRow__C8Assignment_7_in_rule__MRow__Group__7__Impl3514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ERow__Group__0__Impl_in_rule__ERow__Group__03560 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ERow__Group__1_in_rule__ERow__Group__03563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ERow__C1Assignment_0_in_rule__ERow__Group__0__Impl3590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ERow__Group__1__Impl_in_rule__ERow__Group__13620 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ERow__Group__2_in_rule__ERow__Group__13623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ERow__C2Assignment_1_in_rule__ERow__Group__1__Impl3650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ERow__Group__2__Impl_in_rule__ERow__Group__23680 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ERow__Group__3_in_rule__ERow__Group__23683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ERow__C3Assignment_2_in_rule__ERow__Group__2__Impl3710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ERow__Group__3__Impl_in_rule__ERow__Group__33740 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ERow__Group__4_in_rule__ERow__Group__33743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ERow__C4Assignment_3_in_rule__ERow__Group__3__Impl3770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ERow__Group__4__Impl_in_rule__ERow__Group__43800 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ERow__Group__5_in_rule__ERow__Group__43803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ERow__C5Assignment_4_in_rule__ERow__Group__4__Impl3830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ERow__Group__5__Impl_in_rule__ERow__Group__53860 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ERow__Group__6_in_rule__ERow__Group__53863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ERow__C6Assignment_5_in_rule__ERow__Group__5__Impl3890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ERow__Group__6__Impl_in_rule__ERow__Group__63920 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ERow__Group__7_in_rule__ERow__Group__63923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ERow__C7Assignment_6_in_rule__ERow__Group__6__Impl3950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ERow__Group__7__Impl_in_rule__ERow__Group__73980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ERow__C8Assignment_7_in_rule__ERow__Group__7__Impl4007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTable_in_rule__PSQT_Model__TablesAssignment_14058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FDescription__NameAssignment_14089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__FDescription__BaseAssignment_34120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__FDescription__MglAssignment_54151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__FDescription__EglAssignment_74182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRow_in_rule__Table__RAssignment_24213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRow_in_rule__Table__RAssignment_34244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRow_in_rule__Table__RAssignment_44275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRow_in_rule__Table__RAssignment_54306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRow_in_rule__Table__RAssignment_64337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRow_in_rule__Table__RAssignment_74368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRow_in_rule__Table__RAssignment_84399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRow_in_rule__Table__RAssignment_94430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePieceType_in_rule__TDescription__NameAssignment_14461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__TDescription__MgAssignment_34492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__TDescription__EgAssignment_54523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRowLabel_in_rule__Row__NameAssignment_04554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMRow_in_rule__Row__MidrowAssignment_14585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleERow_in_rule__Row__EndrowAssignment_24616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__MRow__C1Assignment_04647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__MRow__C2Assignment_14678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__MRow__C3Assignment_24709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__MRow__C4Assignment_34740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__MRow__C5Assignment_44771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__MRow__C6Assignment_54802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__MRow__C7Assignment_64833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__MRow__C8Assignment_74864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__ERow__C1Assignment_04895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__ERow__C2Assignment_14926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__ERow__C3Assignment_24957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__ERow__C4Assignment_34988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__ERow__C5Assignment_45019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__ERow__C6Assignment_55050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__ERow__C7Assignment_65081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__ERow__C8Assignment_75112 = new BitSet(new long[]{0x0000000000000002L});

}