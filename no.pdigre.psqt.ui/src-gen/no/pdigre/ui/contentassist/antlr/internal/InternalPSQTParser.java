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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_PSQT", "RULE_BASE", "RULE_PIECE", "RULE_VALUE", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Pawn'", "'Knight'", "'Bishop'", "'Rook'", "'Queen'", "'King'", "'A'", "'B'", "'C'", "'D'", "'E'", "'F'", "'G'", "'H'"
    };
    public static final int RULE_PIECE=7;
    public static final int RULE_STRING=10;
    public static final int RULE_SL_COMMENT=12;
    public static final int T__19=19;
    public static final int RULE_VALUE=8;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int RULE_BASE=6;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int EOF=-1;
    public static final int RULE_ID=9;
    public static final int RULE_WS=13;
    public static final int RULE_ANY_OTHER=14;
    public static final int RULE_PSQT=5;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=4;
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
            case 15:
                {
                alt1=1;
                }
                break;
            case 16:
                {
                alt1=2;
                }
                break;
            case 17:
                {
                alt1=3;
                }
                break;
            case 18:
                {
                alt1=4;
                }
                break;
            case 19:
                {
                alt1=5;
                }
                break;
            case 20:
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
                    match(input,15,FOLLOW_15_in_rule__PieceType__Alternatives706); 

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
                    match(input,16,FOLLOW_16_in_rule__PieceType__Alternatives727); 

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
                    match(input,17,FOLLOW_17_in_rule__PieceType__Alternatives748); 

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
                    match(input,18,FOLLOW_18_in_rule__PieceType__Alternatives769); 

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
                    match(input,19,FOLLOW_19_in_rule__PieceType__Alternatives790); 

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
                    match(input,20,FOLLOW_20_in_rule__PieceType__Alternatives811); 

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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:561:1: rule__FDescription__Group__3 : rule__FDescription__Group__3__Impl ;
    public final void rule__FDescription__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:565:1: ( rule__FDescription__Group__3__Impl )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:566:2: rule__FDescription__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__FDescription__Group__3__Impl_in_rule__FDescription__Group__31143);
            rule__FDescription__Group__3__Impl();

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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:572:1: rule__FDescription__Group__3__Impl : ( ( rule__FDescription__BaseAssignment_3 ) ) ;
    public final void rule__FDescription__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:576:1: ( ( ( rule__FDescription__BaseAssignment_3 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:577:1: ( ( rule__FDescription__BaseAssignment_3 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:577:1: ( ( rule__FDescription__BaseAssignment_3 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:578:1: ( rule__FDescription__BaseAssignment_3 )
            {
             before(grammarAccess.getFDescriptionAccess().getBaseAssignment_3()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:579:1: ( rule__FDescription__BaseAssignment_3 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:579:2: rule__FDescription__BaseAssignment_3
            {
            pushFollow(FOLLOW_rule__FDescription__BaseAssignment_3_in_rule__FDescription__Group__3__Impl1170);
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


    // $ANTLR start "rule__Table__Group__0"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:597:1: rule__Table__Group__0 : rule__Table__Group__0__Impl rule__Table__Group__1 ;
    public final void rule__Table__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:601:1: ( rule__Table__Group__0__Impl rule__Table__Group__1 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:602:2: rule__Table__Group__0__Impl rule__Table__Group__1
            {
            pushFollow(FOLLOW_rule__Table__Group__0__Impl_in_rule__Table__Group__01208);
            rule__Table__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Table__Group__1_in_rule__Table__Group__01211);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:609:1: rule__Table__Group__0__Impl : ( ruleTDescription ) ;
    public final void rule__Table__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:613:1: ( ( ruleTDescription ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:614:1: ( ruleTDescription )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:614:1: ( ruleTDescription )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:615:1: ruleTDescription
            {
             before(grammarAccess.getTableAccess().getTDescriptionParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleTDescription_in_rule__Table__Group__0__Impl1238);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:626:1: rule__Table__Group__1 : rule__Table__Group__1__Impl rule__Table__Group__2 ;
    public final void rule__Table__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:630:1: ( rule__Table__Group__1__Impl rule__Table__Group__2 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:631:2: rule__Table__Group__1__Impl rule__Table__Group__2
            {
            pushFollow(FOLLOW_rule__Table__Group__1__Impl_in_rule__Table__Group__11267);
            rule__Table__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Table__Group__2_in_rule__Table__Group__11270);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:638:1: rule__Table__Group__1__Impl : ( ruleTHeader ) ;
    public final void rule__Table__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:642:1: ( ( ruleTHeader ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:643:1: ( ruleTHeader )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:643:1: ( ruleTHeader )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:644:1: ruleTHeader
            {
             before(grammarAccess.getTableAccess().getTHeaderParserRuleCall_1()); 
            pushFollow(FOLLOW_ruleTHeader_in_rule__Table__Group__1__Impl1297);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:655:1: rule__Table__Group__2 : rule__Table__Group__2__Impl rule__Table__Group__3 ;
    public final void rule__Table__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:659:1: ( rule__Table__Group__2__Impl rule__Table__Group__3 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:660:2: rule__Table__Group__2__Impl rule__Table__Group__3
            {
            pushFollow(FOLLOW_rule__Table__Group__2__Impl_in_rule__Table__Group__21326);
            rule__Table__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Table__Group__3_in_rule__Table__Group__21329);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:667:1: rule__Table__Group__2__Impl : ( ( rule__Table__RAssignment_2 ) ) ;
    public final void rule__Table__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:671:1: ( ( ( rule__Table__RAssignment_2 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:672:1: ( ( rule__Table__RAssignment_2 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:672:1: ( ( rule__Table__RAssignment_2 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:673:1: ( rule__Table__RAssignment_2 )
            {
             before(grammarAccess.getTableAccess().getRAssignment_2()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:674:1: ( rule__Table__RAssignment_2 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:674:2: rule__Table__RAssignment_2
            {
            pushFollow(FOLLOW_rule__Table__RAssignment_2_in_rule__Table__Group__2__Impl1356);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:684:1: rule__Table__Group__3 : rule__Table__Group__3__Impl rule__Table__Group__4 ;
    public final void rule__Table__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:688:1: ( rule__Table__Group__3__Impl rule__Table__Group__4 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:689:2: rule__Table__Group__3__Impl rule__Table__Group__4
            {
            pushFollow(FOLLOW_rule__Table__Group__3__Impl_in_rule__Table__Group__31386);
            rule__Table__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Table__Group__4_in_rule__Table__Group__31389);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:696:1: rule__Table__Group__3__Impl : ( ( rule__Table__RAssignment_3 ) ) ;
    public final void rule__Table__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:700:1: ( ( ( rule__Table__RAssignment_3 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:701:1: ( ( rule__Table__RAssignment_3 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:701:1: ( ( rule__Table__RAssignment_3 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:702:1: ( rule__Table__RAssignment_3 )
            {
             before(grammarAccess.getTableAccess().getRAssignment_3()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:703:1: ( rule__Table__RAssignment_3 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:703:2: rule__Table__RAssignment_3
            {
            pushFollow(FOLLOW_rule__Table__RAssignment_3_in_rule__Table__Group__3__Impl1416);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:713:1: rule__Table__Group__4 : rule__Table__Group__4__Impl rule__Table__Group__5 ;
    public final void rule__Table__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:717:1: ( rule__Table__Group__4__Impl rule__Table__Group__5 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:718:2: rule__Table__Group__4__Impl rule__Table__Group__5
            {
            pushFollow(FOLLOW_rule__Table__Group__4__Impl_in_rule__Table__Group__41446);
            rule__Table__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Table__Group__5_in_rule__Table__Group__41449);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:725:1: rule__Table__Group__4__Impl : ( ( rule__Table__RAssignment_4 ) ) ;
    public final void rule__Table__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:729:1: ( ( ( rule__Table__RAssignment_4 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:730:1: ( ( rule__Table__RAssignment_4 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:730:1: ( ( rule__Table__RAssignment_4 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:731:1: ( rule__Table__RAssignment_4 )
            {
             before(grammarAccess.getTableAccess().getRAssignment_4()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:732:1: ( rule__Table__RAssignment_4 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:732:2: rule__Table__RAssignment_4
            {
            pushFollow(FOLLOW_rule__Table__RAssignment_4_in_rule__Table__Group__4__Impl1476);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:742:1: rule__Table__Group__5 : rule__Table__Group__5__Impl rule__Table__Group__6 ;
    public final void rule__Table__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:746:1: ( rule__Table__Group__5__Impl rule__Table__Group__6 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:747:2: rule__Table__Group__5__Impl rule__Table__Group__6
            {
            pushFollow(FOLLOW_rule__Table__Group__5__Impl_in_rule__Table__Group__51506);
            rule__Table__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Table__Group__6_in_rule__Table__Group__51509);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:754:1: rule__Table__Group__5__Impl : ( ( rule__Table__RAssignment_5 ) ) ;
    public final void rule__Table__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:758:1: ( ( ( rule__Table__RAssignment_5 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:759:1: ( ( rule__Table__RAssignment_5 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:759:1: ( ( rule__Table__RAssignment_5 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:760:1: ( rule__Table__RAssignment_5 )
            {
             before(grammarAccess.getTableAccess().getRAssignment_5()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:761:1: ( rule__Table__RAssignment_5 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:761:2: rule__Table__RAssignment_5
            {
            pushFollow(FOLLOW_rule__Table__RAssignment_5_in_rule__Table__Group__5__Impl1536);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:771:1: rule__Table__Group__6 : rule__Table__Group__6__Impl rule__Table__Group__7 ;
    public final void rule__Table__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:775:1: ( rule__Table__Group__6__Impl rule__Table__Group__7 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:776:2: rule__Table__Group__6__Impl rule__Table__Group__7
            {
            pushFollow(FOLLOW_rule__Table__Group__6__Impl_in_rule__Table__Group__61566);
            rule__Table__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Table__Group__7_in_rule__Table__Group__61569);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:783:1: rule__Table__Group__6__Impl : ( ( rule__Table__RAssignment_6 ) ) ;
    public final void rule__Table__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:787:1: ( ( ( rule__Table__RAssignment_6 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:788:1: ( ( rule__Table__RAssignment_6 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:788:1: ( ( rule__Table__RAssignment_6 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:789:1: ( rule__Table__RAssignment_6 )
            {
             before(grammarAccess.getTableAccess().getRAssignment_6()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:790:1: ( rule__Table__RAssignment_6 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:790:2: rule__Table__RAssignment_6
            {
            pushFollow(FOLLOW_rule__Table__RAssignment_6_in_rule__Table__Group__6__Impl1596);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:800:1: rule__Table__Group__7 : rule__Table__Group__7__Impl rule__Table__Group__8 ;
    public final void rule__Table__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:804:1: ( rule__Table__Group__7__Impl rule__Table__Group__8 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:805:2: rule__Table__Group__7__Impl rule__Table__Group__8
            {
            pushFollow(FOLLOW_rule__Table__Group__7__Impl_in_rule__Table__Group__71626);
            rule__Table__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Table__Group__8_in_rule__Table__Group__71629);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:812:1: rule__Table__Group__7__Impl : ( ( rule__Table__RAssignment_7 ) ) ;
    public final void rule__Table__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:816:1: ( ( ( rule__Table__RAssignment_7 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:817:1: ( ( rule__Table__RAssignment_7 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:817:1: ( ( rule__Table__RAssignment_7 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:818:1: ( rule__Table__RAssignment_7 )
            {
             before(grammarAccess.getTableAccess().getRAssignment_7()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:819:1: ( rule__Table__RAssignment_7 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:819:2: rule__Table__RAssignment_7
            {
            pushFollow(FOLLOW_rule__Table__RAssignment_7_in_rule__Table__Group__7__Impl1656);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:829:1: rule__Table__Group__8 : rule__Table__Group__8__Impl rule__Table__Group__9 ;
    public final void rule__Table__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:833:1: ( rule__Table__Group__8__Impl rule__Table__Group__9 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:834:2: rule__Table__Group__8__Impl rule__Table__Group__9
            {
            pushFollow(FOLLOW_rule__Table__Group__8__Impl_in_rule__Table__Group__81686);
            rule__Table__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Table__Group__9_in_rule__Table__Group__81689);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:841:1: rule__Table__Group__8__Impl : ( ( rule__Table__RAssignment_8 ) ) ;
    public final void rule__Table__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:845:1: ( ( ( rule__Table__RAssignment_8 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:846:1: ( ( rule__Table__RAssignment_8 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:846:1: ( ( rule__Table__RAssignment_8 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:847:1: ( rule__Table__RAssignment_8 )
            {
             before(grammarAccess.getTableAccess().getRAssignment_8()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:848:1: ( rule__Table__RAssignment_8 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:848:2: rule__Table__RAssignment_8
            {
            pushFollow(FOLLOW_rule__Table__RAssignment_8_in_rule__Table__Group__8__Impl1716);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:858:1: rule__Table__Group__9 : rule__Table__Group__9__Impl ;
    public final void rule__Table__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:862:1: ( rule__Table__Group__9__Impl )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:863:2: rule__Table__Group__9__Impl
            {
            pushFollow(FOLLOW_rule__Table__Group__9__Impl_in_rule__Table__Group__91746);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:869:1: rule__Table__Group__9__Impl : ( ( rule__Table__RAssignment_9 ) ) ;
    public final void rule__Table__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:873:1: ( ( ( rule__Table__RAssignment_9 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:874:1: ( ( rule__Table__RAssignment_9 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:874:1: ( ( rule__Table__RAssignment_9 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:875:1: ( rule__Table__RAssignment_9 )
            {
             before(grammarAccess.getTableAccess().getRAssignment_9()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:876:1: ( rule__Table__RAssignment_9 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:876:2: rule__Table__RAssignment_9
            {
            pushFollow(FOLLOW_rule__Table__RAssignment_9_in_rule__Table__Group__9__Impl1773);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:906:1: rule__TDescription__Group__0 : rule__TDescription__Group__0__Impl rule__TDescription__Group__1 ;
    public final void rule__TDescription__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:910:1: ( rule__TDescription__Group__0__Impl rule__TDescription__Group__1 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:911:2: rule__TDescription__Group__0__Impl rule__TDescription__Group__1
            {
            pushFollow(FOLLOW_rule__TDescription__Group__0__Impl_in_rule__TDescription__Group__01823);
            rule__TDescription__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TDescription__Group__1_in_rule__TDescription__Group__01826);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:918:1: rule__TDescription__Group__0__Impl : ( RULE_PIECE ) ;
    public final void rule__TDescription__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:922:1: ( ( RULE_PIECE ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:923:1: ( RULE_PIECE )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:923:1: ( RULE_PIECE )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:924:1: RULE_PIECE
            {
             before(grammarAccess.getTDescriptionAccess().getPIECETerminalRuleCall_0()); 
            match(input,RULE_PIECE,FOLLOW_RULE_PIECE_in_rule__TDescription__Group__0__Impl1853); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:935:1: rule__TDescription__Group__1 : rule__TDescription__Group__1__Impl rule__TDescription__Group__2 ;
    public final void rule__TDescription__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:939:1: ( rule__TDescription__Group__1__Impl rule__TDescription__Group__2 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:940:2: rule__TDescription__Group__1__Impl rule__TDescription__Group__2
            {
            pushFollow(FOLLOW_rule__TDescription__Group__1__Impl_in_rule__TDescription__Group__11882);
            rule__TDescription__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TDescription__Group__2_in_rule__TDescription__Group__11885);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:947:1: rule__TDescription__Group__1__Impl : ( ( rule__TDescription__NameAssignment_1 ) ) ;
    public final void rule__TDescription__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:951:1: ( ( ( rule__TDescription__NameAssignment_1 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:952:1: ( ( rule__TDescription__NameAssignment_1 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:952:1: ( ( rule__TDescription__NameAssignment_1 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:953:1: ( rule__TDescription__NameAssignment_1 )
            {
             before(grammarAccess.getTDescriptionAccess().getNameAssignment_1()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:954:1: ( rule__TDescription__NameAssignment_1 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:954:2: rule__TDescription__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__TDescription__NameAssignment_1_in_rule__TDescription__Group__1__Impl1912);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:964:1: rule__TDescription__Group__2 : rule__TDescription__Group__2__Impl rule__TDescription__Group__3 ;
    public final void rule__TDescription__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:968:1: ( rule__TDescription__Group__2__Impl rule__TDescription__Group__3 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:969:2: rule__TDescription__Group__2__Impl rule__TDescription__Group__3
            {
            pushFollow(FOLLOW_rule__TDescription__Group__2__Impl_in_rule__TDescription__Group__21942);
            rule__TDescription__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TDescription__Group__3_in_rule__TDescription__Group__21945);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:976:1: rule__TDescription__Group__2__Impl : ( RULE_VALUE ) ;
    public final void rule__TDescription__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:980:1: ( ( RULE_VALUE ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:981:1: ( RULE_VALUE )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:981:1: ( RULE_VALUE )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:982:1: RULE_VALUE
            {
             before(grammarAccess.getTDescriptionAccess().getVALUETerminalRuleCall_2()); 
            match(input,RULE_VALUE,FOLLOW_RULE_VALUE_in_rule__TDescription__Group__2__Impl1972); 
             after(grammarAccess.getTDescriptionAccess().getVALUETerminalRuleCall_2()); 

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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:993:1: rule__TDescription__Group__3 : rule__TDescription__Group__3__Impl ;
    public final void rule__TDescription__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:997:1: ( rule__TDescription__Group__3__Impl )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:998:2: rule__TDescription__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__TDescription__Group__3__Impl_in_rule__TDescription__Group__32001);
            rule__TDescription__Group__3__Impl();

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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1004:1: rule__TDescription__Group__3__Impl : ( ( rule__TDescription__ValueAssignment_3 ) ) ;
    public final void rule__TDescription__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1008:1: ( ( ( rule__TDescription__ValueAssignment_3 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1009:1: ( ( rule__TDescription__ValueAssignment_3 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1009:1: ( ( rule__TDescription__ValueAssignment_3 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1010:1: ( rule__TDescription__ValueAssignment_3 )
            {
             before(grammarAccess.getTDescriptionAccess().getValueAssignment_3()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1011:1: ( rule__TDescription__ValueAssignment_3 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1011:2: rule__TDescription__ValueAssignment_3
            {
            pushFollow(FOLLOW_rule__TDescription__ValueAssignment_3_in_rule__TDescription__Group__3__Impl2028);
            rule__TDescription__ValueAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getTDescriptionAccess().getValueAssignment_3()); 

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


    // $ANTLR start "rule__THeader__Group__0"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1029:1: rule__THeader__Group__0 : rule__THeader__Group__0__Impl rule__THeader__Group__1 ;
    public final void rule__THeader__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1033:1: ( rule__THeader__Group__0__Impl rule__THeader__Group__1 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1034:2: rule__THeader__Group__0__Impl rule__THeader__Group__1
            {
            pushFollow(FOLLOW_rule__THeader__Group__0__Impl_in_rule__THeader__Group__02066);
            rule__THeader__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__THeader__Group__1_in_rule__THeader__Group__02069);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1041:1: rule__THeader__Group__0__Impl : ( 'A' ) ;
    public final void rule__THeader__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1045:1: ( ( 'A' ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1046:1: ( 'A' )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1046:1: ( 'A' )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1047:1: 'A'
            {
             before(grammarAccess.getTHeaderAccess().getAKeyword_0()); 
            match(input,21,FOLLOW_21_in_rule__THeader__Group__0__Impl2097); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1060:1: rule__THeader__Group__1 : rule__THeader__Group__1__Impl rule__THeader__Group__2 ;
    public final void rule__THeader__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1064:1: ( rule__THeader__Group__1__Impl rule__THeader__Group__2 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1065:2: rule__THeader__Group__1__Impl rule__THeader__Group__2
            {
            pushFollow(FOLLOW_rule__THeader__Group__1__Impl_in_rule__THeader__Group__12128);
            rule__THeader__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__THeader__Group__2_in_rule__THeader__Group__12131);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1072:1: rule__THeader__Group__1__Impl : ( 'B' ) ;
    public final void rule__THeader__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1076:1: ( ( 'B' ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1077:1: ( 'B' )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1077:1: ( 'B' )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1078:1: 'B'
            {
             before(grammarAccess.getTHeaderAccess().getBKeyword_1()); 
            match(input,22,FOLLOW_22_in_rule__THeader__Group__1__Impl2159); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1091:1: rule__THeader__Group__2 : rule__THeader__Group__2__Impl rule__THeader__Group__3 ;
    public final void rule__THeader__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1095:1: ( rule__THeader__Group__2__Impl rule__THeader__Group__3 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1096:2: rule__THeader__Group__2__Impl rule__THeader__Group__3
            {
            pushFollow(FOLLOW_rule__THeader__Group__2__Impl_in_rule__THeader__Group__22190);
            rule__THeader__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__THeader__Group__3_in_rule__THeader__Group__22193);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1103:1: rule__THeader__Group__2__Impl : ( 'C' ) ;
    public final void rule__THeader__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1107:1: ( ( 'C' ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1108:1: ( 'C' )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1108:1: ( 'C' )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1109:1: 'C'
            {
             before(grammarAccess.getTHeaderAccess().getCKeyword_2()); 
            match(input,23,FOLLOW_23_in_rule__THeader__Group__2__Impl2221); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1122:1: rule__THeader__Group__3 : rule__THeader__Group__3__Impl rule__THeader__Group__4 ;
    public final void rule__THeader__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1126:1: ( rule__THeader__Group__3__Impl rule__THeader__Group__4 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1127:2: rule__THeader__Group__3__Impl rule__THeader__Group__4
            {
            pushFollow(FOLLOW_rule__THeader__Group__3__Impl_in_rule__THeader__Group__32252);
            rule__THeader__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__THeader__Group__4_in_rule__THeader__Group__32255);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1134:1: rule__THeader__Group__3__Impl : ( 'D' ) ;
    public final void rule__THeader__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1138:1: ( ( 'D' ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1139:1: ( 'D' )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1139:1: ( 'D' )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1140:1: 'D'
            {
             before(grammarAccess.getTHeaderAccess().getDKeyword_3()); 
            match(input,24,FOLLOW_24_in_rule__THeader__Group__3__Impl2283); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1153:1: rule__THeader__Group__4 : rule__THeader__Group__4__Impl rule__THeader__Group__5 ;
    public final void rule__THeader__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1157:1: ( rule__THeader__Group__4__Impl rule__THeader__Group__5 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1158:2: rule__THeader__Group__4__Impl rule__THeader__Group__5
            {
            pushFollow(FOLLOW_rule__THeader__Group__4__Impl_in_rule__THeader__Group__42314);
            rule__THeader__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__THeader__Group__5_in_rule__THeader__Group__42317);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1165:1: rule__THeader__Group__4__Impl : ( 'E' ) ;
    public final void rule__THeader__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1169:1: ( ( 'E' ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1170:1: ( 'E' )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1170:1: ( 'E' )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1171:1: 'E'
            {
             before(grammarAccess.getTHeaderAccess().getEKeyword_4()); 
            match(input,25,FOLLOW_25_in_rule__THeader__Group__4__Impl2345); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1184:1: rule__THeader__Group__5 : rule__THeader__Group__5__Impl rule__THeader__Group__6 ;
    public final void rule__THeader__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1188:1: ( rule__THeader__Group__5__Impl rule__THeader__Group__6 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1189:2: rule__THeader__Group__5__Impl rule__THeader__Group__6
            {
            pushFollow(FOLLOW_rule__THeader__Group__5__Impl_in_rule__THeader__Group__52376);
            rule__THeader__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__THeader__Group__6_in_rule__THeader__Group__52379);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1196:1: rule__THeader__Group__5__Impl : ( 'F' ) ;
    public final void rule__THeader__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1200:1: ( ( 'F' ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1201:1: ( 'F' )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1201:1: ( 'F' )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1202:1: 'F'
            {
             before(grammarAccess.getTHeaderAccess().getFKeyword_5()); 
            match(input,26,FOLLOW_26_in_rule__THeader__Group__5__Impl2407); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1215:1: rule__THeader__Group__6 : rule__THeader__Group__6__Impl rule__THeader__Group__7 ;
    public final void rule__THeader__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1219:1: ( rule__THeader__Group__6__Impl rule__THeader__Group__7 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1220:2: rule__THeader__Group__6__Impl rule__THeader__Group__7
            {
            pushFollow(FOLLOW_rule__THeader__Group__6__Impl_in_rule__THeader__Group__62438);
            rule__THeader__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__THeader__Group__7_in_rule__THeader__Group__62441);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1227:1: rule__THeader__Group__6__Impl : ( 'G' ) ;
    public final void rule__THeader__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1231:1: ( ( 'G' ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1232:1: ( 'G' )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1232:1: ( 'G' )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1233:1: 'G'
            {
             before(grammarAccess.getTHeaderAccess().getGKeyword_6()); 
            match(input,27,FOLLOW_27_in_rule__THeader__Group__6__Impl2469); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1246:1: rule__THeader__Group__7 : rule__THeader__Group__7__Impl ;
    public final void rule__THeader__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1250:1: ( rule__THeader__Group__7__Impl )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1251:2: rule__THeader__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__THeader__Group__7__Impl_in_rule__THeader__Group__72500);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1257:1: rule__THeader__Group__7__Impl : ( 'H' ) ;
    public final void rule__THeader__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1261:1: ( ( 'H' ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1262:1: ( 'H' )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1262:1: ( 'H' )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1263:1: 'H'
            {
             before(grammarAccess.getTHeaderAccess().getHKeyword_7()); 
            match(input,28,FOLLOW_28_in_rule__THeader__Group__7__Impl2528); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1292:1: rule__Row__Group__0 : rule__Row__Group__0__Impl rule__Row__Group__1 ;
    public final void rule__Row__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1296:1: ( rule__Row__Group__0__Impl rule__Row__Group__1 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1297:2: rule__Row__Group__0__Impl rule__Row__Group__1
            {
            pushFollow(FOLLOW_rule__Row__Group__0__Impl_in_rule__Row__Group__02575);
            rule__Row__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Row__Group__1_in_rule__Row__Group__02578);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1304:1: rule__Row__Group__0__Impl : ( ( rule__Row__NameAssignment_0 ) ) ;
    public final void rule__Row__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1308:1: ( ( ( rule__Row__NameAssignment_0 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1309:1: ( ( rule__Row__NameAssignment_0 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1309:1: ( ( rule__Row__NameAssignment_0 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1310:1: ( rule__Row__NameAssignment_0 )
            {
             before(grammarAccess.getRowAccess().getNameAssignment_0()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1311:1: ( rule__Row__NameAssignment_0 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1311:2: rule__Row__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Row__NameAssignment_0_in_rule__Row__Group__0__Impl2605);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1321:1: rule__Row__Group__1 : rule__Row__Group__1__Impl rule__Row__Group__2 ;
    public final void rule__Row__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1325:1: ( rule__Row__Group__1__Impl rule__Row__Group__2 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1326:2: rule__Row__Group__1__Impl rule__Row__Group__2
            {
            pushFollow(FOLLOW_rule__Row__Group__1__Impl_in_rule__Row__Group__12635);
            rule__Row__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Row__Group__2_in_rule__Row__Group__12638);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1333:1: rule__Row__Group__1__Impl : ( ( rule__Row__MAssignment_1 ) ) ;
    public final void rule__Row__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1337:1: ( ( ( rule__Row__MAssignment_1 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1338:1: ( ( rule__Row__MAssignment_1 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1338:1: ( ( rule__Row__MAssignment_1 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1339:1: ( rule__Row__MAssignment_1 )
            {
             before(grammarAccess.getRowAccess().getMAssignment_1()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1340:1: ( rule__Row__MAssignment_1 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1340:2: rule__Row__MAssignment_1
            {
            pushFollow(FOLLOW_rule__Row__MAssignment_1_in_rule__Row__Group__1__Impl2665);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1350:1: rule__Row__Group__2 : rule__Row__Group__2__Impl ;
    public final void rule__Row__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1354:1: ( rule__Row__Group__2__Impl )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1355:2: rule__Row__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Row__Group__2__Impl_in_rule__Row__Group__22695);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1361:1: rule__Row__Group__2__Impl : ( ( rule__Row__EAssignment_2 ) ) ;
    public final void rule__Row__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1365:1: ( ( ( rule__Row__EAssignment_2 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1366:1: ( ( rule__Row__EAssignment_2 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1366:1: ( ( rule__Row__EAssignment_2 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1367:1: ( rule__Row__EAssignment_2 )
            {
             before(grammarAccess.getRowAccess().getEAssignment_2()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1368:1: ( rule__Row__EAssignment_2 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1368:2: rule__Row__EAssignment_2
            {
            pushFollow(FOLLOW_rule__Row__EAssignment_2_in_rule__Row__Group__2__Impl2722);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1384:1: rule__Row1__Group__0 : rule__Row1__Group__0__Impl rule__Row1__Group__1 ;
    public final void rule__Row1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1388:1: ( rule__Row1__Group__0__Impl rule__Row1__Group__1 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1389:2: rule__Row1__Group__0__Impl rule__Row1__Group__1
            {
            pushFollow(FOLLOW_rule__Row1__Group__0__Impl_in_rule__Row1__Group__02758);
            rule__Row1__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Row1__Group__1_in_rule__Row1__Group__02761);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1396:1: rule__Row1__Group__0__Impl : ( ( rule__Row1__CAssignment_0 ) ) ;
    public final void rule__Row1__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1400:1: ( ( ( rule__Row1__CAssignment_0 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1401:1: ( ( rule__Row1__CAssignment_0 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1401:1: ( ( rule__Row1__CAssignment_0 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1402:1: ( rule__Row1__CAssignment_0 )
            {
             before(grammarAccess.getRow1Access().getCAssignment_0()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1403:1: ( rule__Row1__CAssignment_0 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1403:2: rule__Row1__CAssignment_0
            {
            pushFollow(FOLLOW_rule__Row1__CAssignment_0_in_rule__Row1__Group__0__Impl2788);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1413:1: rule__Row1__Group__1 : rule__Row1__Group__1__Impl rule__Row1__Group__2 ;
    public final void rule__Row1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1417:1: ( rule__Row1__Group__1__Impl rule__Row1__Group__2 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1418:2: rule__Row1__Group__1__Impl rule__Row1__Group__2
            {
            pushFollow(FOLLOW_rule__Row1__Group__1__Impl_in_rule__Row1__Group__12818);
            rule__Row1__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Row1__Group__2_in_rule__Row1__Group__12821);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1425:1: rule__Row1__Group__1__Impl : ( ( rule__Row1__CAssignment_1 ) ) ;
    public final void rule__Row1__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1429:1: ( ( ( rule__Row1__CAssignment_1 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1430:1: ( ( rule__Row1__CAssignment_1 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1430:1: ( ( rule__Row1__CAssignment_1 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1431:1: ( rule__Row1__CAssignment_1 )
            {
             before(grammarAccess.getRow1Access().getCAssignment_1()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1432:1: ( rule__Row1__CAssignment_1 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1432:2: rule__Row1__CAssignment_1
            {
            pushFollow(FOLLOW_rule__Row1__CAssignment_1_in_rule__Row1__Group__1__Impl2848);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1442:1: rule__Row1__Group__2 : rule__Row1__Group__2__Impl rule__Row1__Group__3 ;
    public final void rule__Row1__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1446:1: ( rule__Row1__Group__2__Impl rule__Row1__Group__3 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1447:2: rule__Row1__Group__2__Impl rule__Row1__Group__3
            {
            pushFollow(FOLLOW_rule__Row1__Group__2__Impl_in_rule__Row1__Group__22878);
            rule__Row1__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Row1__Group__3_in_rule__Row1__Group__22881);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1454:1: rule__Row1__Group__2__Impl : ( ( rule__Row1__CAssignment_2 ) ) ;
    public final void rule__Row1__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1458:1: ( ( ( rule__Row1__CAssignment_2 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1459:1: ( ( rule__Row1__CAssignment_2 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1459:1: ( ( rule__Row1__CAssignment_2 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1460:1: ( rule__Row1__CAssignment_2 )
            {
             before(grammarAccess.getRow1Access().getCAssignment_2()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1461:1: ( rule__Row1__CAssignment_2 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1461:2: rule__Row1__CAssignment_2
            {
            pushFollow(FOLLOW_rule__Row1__CAssignment_2_in_rule__Row1__Group__2__Impl2908);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1471:1: rule__Row1__Group__3 : rule__Row1__Group__3__Impl rule__Row1__Group__4 ;
    public final void rule__Row1__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1475:1: ( rule__Row1__Group__3__Impl rule__Row1__Group__4 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1476:2: rule__Row1__Group__3__Impl rule__Row1__Group__4
            {
            pushFollow(FOLLOW_rule__Row1__Group__3__Impl_in_rule__Row1__Group__32938);
            rule__Row1__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Row1__Group__4_in_rule__Row1__Group__32941);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1483:1: rule__Row1__Group__3__Impl : ( ( rule__Row1__CAssignment_3 ) ) ;
    public final void rule__Row1__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1487:1: ( ( ( rule__Row1__CAssignment_3 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1488:1: ( ( rule__Row1__CAssignment_3 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1488:1: ( ( rule__Row1__CAssignment_3 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1489:1: ( rule__Row1__CAssignment_3 )
            {
             before(grammarAccess.getRow1Access().getCAssignment_3()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1490:1: ( rule__Row1__CAssignment_3 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1490:2: rule__Row1__CAssignment_3
            {
            pushFollow(FOLLOW_rule__Row1__CAssignment_3_in_rule__Row1__Group__3__Impl2968);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1500:1: rule__Row1__Group__4 : rule__Row1__Group__4__Impl rule__Row1__Group__5 ;
    public final void rule__Row1__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1504:1: ( rule__Row1__Group__4__Impl rule__Row1__Group__5 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1505:2: rule__Row1__Group__4__Impl rule__Row1__Group__5
            {
            pushFollow(FOLLOW_rule__Row1__Group__4__Impl_in_rule__Row1__Group__42998);
            rule__Row1__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Row1__Group__5_in_rule__Row1__Group__43001);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1512:1: rule__Row1__Group__4__Impl : ( ( rule__Row1__CAssignment_4 ) ) ;
    public final void rule__Row1__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1516:1: ( ( ( rule__Row1__CAssignment_4 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1517:1: ( ( rule__Row1__CAssignment_4 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1517:1: ( ( rule__Row1__CAssignment_4 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1518:1: ( rule__Row1__CAssignment_4 )
            {
             before(grammarAccess.getRow1Access().getCAssignment_4()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1519:1: ( rule__Row1__CAssignment_4 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1519:2: rule__Row1__CAssignment_4
            {
            pushFollow(FOLLOW_rule__Row1__CAssignment_4_in_rule__Row1__Group__4__Impl3028);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1529:1: rule__Row1__Group__5 : rule__Row1__Group__5__Impl rule__Row1__Group__6 ;
    public final void rule__Row1__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1533:1: ( rule__Row1__Group__5__Impl rule__Row1__Group__6 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1534:2: rule__Row1__Group__5__Impl rule__Row1__Group__6
            {
            pushFollow(FOLLOW_rule__Row1__Group__5__Impl_in_rule__Row1__Group__53058);
            rule__Row1__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Row1__Group__6_in_rule__Row1__Group__53061);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1541:1: rule__Row1__Group__5__Impl : ( ( rule__Row1__CAssignment_5 ) ) ;
    public final void rule__Row1__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1545:1: ( ( ( rule__Row1__CAssignment_5 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1546:1: ( ( rule__Row1__CAssignment_5 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1546:1: ( ( rule__Row1__CAssignment_5 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1547:1: ( rule__Row1__CAssignment_5 )
            {
             before(grammarAccess.getRow1Access().getCAssignment_5()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1548:1: ( rule__Row1__CAssignment_5 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1548:2: rule__Row1__CAssignment_5
            {
            pushFollow(FOLLOW_rule__Row1__CAssignment_5_in_rule__Row1__Group__5__Impl3088);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1558:1: rule__Row1__Group__6 : rule__Row1__Group__6__Impl rule__Row1__Group__7 ;
    public final void rule__Row1__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1562:1: ( rule__Row1__Group__6__Impl rule__Row1__Group__7 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1563:2: rule__Row1__Group__6__Impl rule__Row1__Group__7
            {
            pushFollow(FOLLOW_rule__Row1__Group__6__Impl_in_rule__Row1__Group__63118);
            rule__Row1__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Row1__Group__7_in_rule__Row1__Group__63121);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1570:1: rule__Row1__Group__6__Impl : ( ( rule__Row1__CAssignment_6 ) ) ;
    public final void rule__Row1__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1574:1: ( ( ( rule__Row1__CAssignment_6 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1575:1: ( ( rule__Row1__CAssignment_6 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1575:1: ( ( rule__Row1__CAssignment_6 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1576:1: ( rule__Row1__CAssignment_6 )
            {
             before(grammarAccess.getRow1Access().getCAssignment_6()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1577:1: ( rule__Row1__CAssignment_6 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1577:2: rule__Row1__CAssignment_6
            {
            pushFollow(FOLLOW_rule__Row1__CAssignment_6_in_rule__Row1__Group__6__Impl3148);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1587:1: rule__Row1__Group__7 : rule__Row1__Group__7__Impl ;
    public final void rule__Row1__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1591:1: ( rule__Row1__Group__7__Impl )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1592:2: rule__Row1__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__Row1__Group__7__Impl_in_rule__Row1__Group__73178);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1598:1: rule__Row1__Group__7__Impl : ( ( rule__Row1__CAssignment_7 ) ) ;
    public final void rule__Row1__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1602:1: ( ( ( rule__Row1__CAssignment_7 ) ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1603:1: ( ( rule__Row1__CAssignment_7 ) )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1603:1: ( ( rule__Row1__CAssignment_7 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1604:1: ( rule__Row1__CAssignment_7 )
            {
             before(grammarAccess.getRow1Access().getCAssignment_7()); 
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1605:1: ( rule__Row1__CAssignment_7 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1605:2: rule__Row1__CAssignment_7
            {
            pushFollow(FOLLOW_rule__Row1__CAssignment_7_in_rule__Row1__Group__7__Impl3205);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1632:1: rule__Model__TablesAssignment_1 : ( ruleTable ) ;
    public final void rule__Model__TablesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1636:1: ( ( ruleTable ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1637:1: ( ruleTable )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1637:1: ( ruleTable )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1638:1: ruleTable
            {
             before(grammarAccess.getModelAccess().getTablesTableParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleTable_in_rule__Model__TablesAssignment_13256);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1647:1: rule__FDescription__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__FDescription__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1651:1: ( ( RULE_ID ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1652:1: ( RULE_ID )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1652:1: ( RULE_ID )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1653:1: RULE_ID
            {
             before(grammarAccess.getFDescriptionAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FDescription__NameAssignment_13287); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1662:1: rule__FDescription__BaseAssignment_3 : ( RULE_INT ) ;
    public final void rule__FDescription__BaseAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1666:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1667:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1667:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1668:1: RULE_INT
            {
             before(grammarAccess.getFDescriptionAccess().getBaseINTTerminalRuleCall_3_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__FDescription__BaseAssignment_33318); 
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


    // $ANTLR start "rule__Table__RAssignment_2"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1677:1: rule__Table__RAssignment_2 : ( ruleRow ) ;
    public final void rule__Table__RAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1681:1: ( ( ruleRow ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1682:1: ( ruleRow )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1682:1: ( ruleRow )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1683:1: ruleRow
            {
             before(grammarAccess.getTableAccess().getRRowParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleRow_in_rule__Table__RAssignment_23349);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1692:1: rule__Table__RAssignment_3 : ( ruleRow ) ;
    public final void rule__Table__RAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1696:1: ( ( ruleRow ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1697:1: ( ruleRow )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1697:1: ( ruleRow )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1698:1: ruleRow
            {
             before(grammarAccess.getTableAccess().getRRowParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleRow_in_rule__Table__RAssignment_33380);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1707:1: rule__Table__RAssignment_4 : ( ruleRow ) ;
    public final void rule__Table__RAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1711:1: ( ( ruleRow ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1712:1: ( ruleRow )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1712:1: ( ruleRow )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1713:1: ruleRow
            {
             before(grammarAccess.getTableAccess().getRRowParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleRow_in_rule__Table__RAssignment_43411);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1722:1: rule__Table__RAssignment_5 : ( ruleRow ) ;
    public final void rule__Table__RAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1726:1: ( ( ruleRow ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1727:1: ( ruleRow )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1727:1: ( ruleRow )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1728:1: ruleRow
            {
             before(grammarAccess.getTableAccess().getRRowParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleRow_in_rule__Table__RAssignment_53442);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1737:1: rule__Table__RAssignment_6 : ( ruleRow ) ;
    public final void rule__Table__RAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1741:1: ( ( ruleRow ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1742:1: ( ruleRow )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1742:1: ( ruleRow )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1743:1: ruleRow
            {
             before(grammarAccess.getTableAccess().getRRowParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleRow_in_rule__Table__RAssignment_63473);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1752:1: rule__Table__RAssignment_7 : ( ruleRow ) ;
    public final void rule__Table__RAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1756:1: ( ( ruleRow ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1757:1: ( ruleRow )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1757:1: ( ruleRow )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1758:1: ruleRow
            {
             before(grammarAccess.getTableAccess().getRRowParserRuleCall_7_0()); 
            pushFollow(FOLLOW_ruleRow_in_rule__Table__RAssignment_73504);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1767:1: rule__Table__RAssignment_8 : ( ruleRow ) ;
    public final void rule__Table__RAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1771:1: ( ( ruleRow ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1772:1: ( ruleRow )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1772:1: ( ruleRow )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1773:1: ruleRow
            {
             before(grammarAccess.getTableAccess().getRRowParserRuleCall_8_0()); 
            pushFollow(FOLLOW_ruleRow_in_rule__Table__RAssignment_83535);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1782:1: rule__Table__RAssignment_9 : ( ruleRow ) ;
    public final void rule__Table__RAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1786:1: ( ( ruleRow ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1787:1: ( ruleRow )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1787:1: ( ruleRow )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1788:1: ruleRow
            {
             before(grammarAccess.getTableAccess().getRRowParserRuleCall_9_0()); 
            pushFollow(FOLLOW_ruleRow_in_rule__Table__RAssignment_93566);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1797:1: rule__TDescription__NameAssignment_1 : ( rulePieceType ) ;
    public final void rule__TDescription__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1801:1: ( ( rulePieceType ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1802:1: ( rulePieceType )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1802:1: ( rulePieceType )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1803:1: rulePieceType
            {
             before(grammarAccess.getTDescriptionAccess().getNamePieceTypeEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_rulePieceType_in_rule__TDescription__NameAssignment_13597);
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


    // $ANTLR start "rule__TDescription__ValueAssignment_3"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1812:1: rule__TDescription__ValueAssignment_3 : ( RULE_INT ) ;
    public final void rule__TDescription__ValueAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1816:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1817:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1817:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1818:1: RULE_INT
            {
             before(grammarAccess.getTDescriptionAccess().getValueINTTerminalRuleCall_3_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__TDescription__ValueAssignment_33628); 
             after(grammarAccess.getTDescriptionAccess().getValueINTTerminalRuleCall_3_0()); 

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
    // $ANTLR end "rule__TDescription__ValueAssignment_3"


    // $ANTLR start "rule__Row__NameAssignment_0"
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1827:1: rule__Row__NameAssignment_0 : ( ruleRowLabel ) ;
    public final void rule__Row__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1831:1: ( ( ruleRowLabel ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1832:1: ( ruleRowLabel )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1832:1: ( ruleRowLabel )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1833:1: ruleRowLabel
            {
             before(grammarAccess.getRowAccess().getNameRowLabelParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleRowLabel_in_rule__Row__NameAssignment_03659);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1842:1: rule__Row__MAssignment_1 : ( ruleMRow ) ;
    public final void rule__Row__MAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1846:1: ( ( ruleMRow ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1847:1: ( ruleMRow )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1847:1: ( ruleMRow )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1848:1: ruleMRow
            {
             before(grammarAccess.getRowAccess().getMMRowParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleMRow_in_rule__Row__MAssignment_13690);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1857:1: rule__Row__EAssignment_2 : ( ruleERow ) ;
    public final void rule__Row__EAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1861:1: ( ( ruleERow ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1862:1: ( ruleERow )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1862:1: ( ruleERow )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1863:1: ruleERow
            {
             before(grammarAccess.getRowAccess().getEERowParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleERow_in_rule__Row__EAssignment_23721);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1872:1: rule__MRow__NameAssignment : ( ruleRow1 ) ;
    public final void rule__MRow__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1876:1: ( ( ruleRow1 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1877:1: ( ruleRow1 )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1877:1: ( ruleRow1 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1878:1: ruleRow1
            {
             before(grammarAccess.getMRowAccess().getNameRow1ParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleRow1_in_rule__MRow__NameAssignment3752);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1887:1: rule__ERow__NameAssignment : ( ruleRow1 ) ;
    public final void rule__ERow__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1891:1: ( ( ruleRow1 ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1892:1: ( ruleRow1 )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1892:1: ( ruleRow1 )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1893:1: ruleRow1
            {
             before(grammarAccess.getERowAccess().getNameRow1ParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleRow1_in_rule__ERow__NameAssignment3783);
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1902:1: rule__Row1__CAssignment_0 : ( RULE_INT ) ;
    public final void rule__Row1__CAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1906:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1907:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1907:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1908:1: RULE_INT
            {
             before(grammarAccess.getRow1Access().getCINTTerminalRuleCall_0_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Row1__CAssignment_03814); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1917:1: rule__Row1__CAssignment_1 : ( RULE_INT ) ;
    public final void rule__Row1__CAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1921:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1922:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1922:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1923:1: RULE_INT
            {
             before(grammarAccess.getRow1Access().getCINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Row1__CAssignment_13845); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1932:1: rule__Row1__CAssignment_2 : ( RULE_INT ) ;
    public final void rule__Row1__CAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1936:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1937:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1937:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1938:1: RULE_INT
            {
             before(grammarAccess.getRow1Access().getCINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Row1__CAssignment_23876); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1947:1: rule__Row1__CAssignment_3 : ( RULE_INT ) ;
    public final void rule__Row1__CAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1951:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1952:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1952:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1953:1: RULE_INT
            {
             before(grammarAccess.getRow1Access().getCINTTerminalRuleCall_3_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Row1__CAssignment_33907); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1962:1: rule__Row1__CAssignment_4 : ( RULE_INT ) ;
    public final void rule__Row1__CAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1966:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1967:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1967:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1968:1: RULE_INT
            {
             before(grammarAccess.getRow1Access().getCINTTerminalRuleCall_4_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Row1__CAssignment_43938); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1977:1: rule__Row1__CAssignment_5 : ( RULE_INT ) ;
    public final void rule__Row1__CAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1981:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1982:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1982:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1983:1: RULE_INT
            {
             before(grammarAccess.getRow1Access().getCINTTerminalRuleCall_5_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Row1__CAssignment_53969); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1992:1: rule__Row1__CAssignment_6 : ( RULE_INT ) ;
    public final void rule__Row1__CAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1996:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1997:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1997:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:1998:1: RULE_INT
            {
             before(grammarAccess.getRow1Access().getCINTTerminalRuleCall_6_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Row1__CAssignment_64000); 
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
    // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2007:1: rule__Row1__CAssignment_7 : ( RULE_INT ) ;
    public final void rule__Row1__CAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2011:1: ( ( RULE_INT ) )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2012:1: ( RULE_INT )
            {
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2012:1: ( RULE_INT )
            // ../no.pdigre.psqt.ui/src-gen/no/pdigre/ui/contentassist/antlr/internal/InternalPSQT.g:2013:1: RULE_INT
            {
             before(grammarAccess.getRow1Access().getCINTTerminalRuleCall_7_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Row1__CAssignment_74031); 
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
    public static final BitSet FOLLOW_15_in_rule__PieceType__Alternatives706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__PieceType__Alternatives727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__PieceType__Alternatives748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__PieceType__Alternatives769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__PieceType__Alternatives790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__PieceType__Alternatives811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__0844 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__0847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFDescription_in_rule__Model__Group__0__Impl874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__1903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__TablesAssignment_1_in_rule__Model__Group__1__Impl930 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_rule__FDescription__Group__0__Impl_in_rule__FDescription__Group__0965 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_rule__FDescription__Group__1_in_rule__FDescription__Group__0968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PSQT_in_rule__FDescription__Group__0__Impl995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FDescription__Group__1__Impl_in_rule__FDescription__Group__11024 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__FDescription__Group__2_in_rule__FDescription__Group__11027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FDescription__NameAssignment_1_in_rule__FDescription__Group__1__Impl1054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FDescription__Group__2__Impl_in_rule__FDescription__Group__21084 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FDescription__Group__3_in_rule__FDescription__Group__21087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BASE_in_rule__FDescription__Group__2__Impl1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FDescription__Group__3__Impl_in_rule__FDescription__Group__31143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FDescription__BaseAssignment_3_in_rule__FDescription__Group__3__Impl1170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__Group__0__Impl_in_rule__Table__Group__01208 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__Table__Group__1_in_rule__Table__Group__01211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTDescription_in_rule__Table__Group__0__Impl1238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__Group__1__Impl_in_rule__Table__Group__11267 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Table__Group__2_in_rule__Table__Group__11270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTHeader_in_rule__Table__Group__1__Impl1297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__Group__2__Impl_in_rule__Table__Group__21326 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Table__Group__3_in_rule__Table__Group__21329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__RAssignment_2_in_rule__Table__Group__2__Impl1356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__Group__3__Impl_in_rule__Table__Group__31386 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Table__Group__4_in_rule__Table__Group__31389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__RAssignment_3_in_rule__Table__Group__3__Impl1416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__Group__4__Impl_in_rule__Table__Group__41446 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Table__Group__5_in_rule__Table__Group__41449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__RAssignment_4_in_rule__Table__Group__4__Impl1476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__Group__5__Impl_in_rule__Table__Group__51506 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Table__Group__6_in_rule__Table__Group__51509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__RAssignment_5_in_rule__Table__Group__5__Impl1536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__Group__6__Impl_in_rule__Table__Group__61566 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Table__Group__7_in_rule__Table__Group__61569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__RAssignment_6_in_rule__Table__Group__6__Impl1596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__Group__7__Impl_in_rule__Table__Group__71626 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Table__Group__8_in_rule__Table__Group__71629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__RAssignment_7_in_rule__Table__Group__7__Impl1656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__Group__8__Impl_in_rule__Table__Group__81686 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Table__Group__9_in_rule__Table__Group__81689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__RAssignment_8_in_rule__Table__Group__8__Impl1716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__Group__9__Impl_in_rule__Table__Group__91746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Table__RAssignment_9_in_rule__Table__Group__9__Impl1773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TDescription__Group__0__Impl_in_rule__TDescription__Group__01823 = new BitSet(new long[]{0x00000000001F8000L});
    public static final BitSet FOLLOW_rule__TDescription__Group__1_in_rule__TDescription__Group__01826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PIECE_in_rule__TDescription__Group__0__Impl1853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TDescription__Group__1__Impl_in_rule__TDescription__Group__11882 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__TDescription__Group__2_in_rule__TDescription__Group__11885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TDescription__NameAssignment_1_in_rule__TDescription__Group__1__Impl1912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TDescription__Group__2__Impl_in_rule__TDescription__Group__21942 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__TDescription__Group__3_in_rule__TDescription__Group__21945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VALUE_in_rule__TDescription__Group__2__Impl1972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TDescription__Group__3__Impl_in_rule__TDescription__Group__32001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TDescription__ValueAssignment_3_in_rule__TDescription__Group__3__Impl2028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__THeader__Group__0__Impl_in_rule__THeader__Group__02066 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__THeader__Group__1_in_rule__THeader__Group__02069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__THeader__Group__0__Impl2097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__THeader__Group__1__Impl_in_rule__THeader__Group__12128 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__THeader__Group__2_in_rule__THeader__Group__12131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__THeader__Group__1__Impl2159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__THeader__Group__2__Impl_in_rule__THeader__Group__22190 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__THeader__Group__3_in_rule__THeader__Group__22193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__THeader__Group__2__Impl2221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__THeader__Group__3__Impl_in_rule__THeader__Group__32252 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__THeader__Group__4_in_rule__THeader__Group__32255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__THeader__Group__3__Impl2283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__THeader__Group__4__Impl_in_rule__THeader__Group__42314 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__THeader__Group__5_in_rule__THeader__Group__42317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__THeader__Group__4__Impl2345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__THeader__Group__5__Impl_in_rule__THeader__Group__52376 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__THeader__Group__6_in_rule__THeader__Group__52379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__THeader__Group__5__Impl2407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__THeader__Group__6__Impl_in_rule__THeader__Group__62438 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__THeader__Group__7_in_rule__THeader__Group__62441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__THeader__Group__6__Impl2469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__THeader__Group__7__Impl_in_rule__THeader__Group__72500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__THeader__Group__7__Impl2528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row__Group__0__Impl_in_rule__Row__Group__02575 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Row__Group__1_in_rule__Row__Group__02578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row__NameAssignment_0_in_rule__Row__Group__0__Impl2605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row__Group__1__Impl_in_rule__Row__Group__12635 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Row__Group__2_in_rule__Row__Group__12638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row__MAssignment_1_in_rule__Row__Group__1__Impl2665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row__Group__2__Impl_in_rule__Row__Group__22695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row__EAssignment_2_in_rule__Row__Group__2__Impl2722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row1__Group__0__Impl_in_rule__Row1__Group__02758 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Row1__Group__1_in_rule__Row1__Group__02761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row1__CAssignment_0_in_rule__Row1__Group__0__Impl2788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row1__Group__1__Impl_in_rule__Row1__Group__12818 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Row1__Group__2_in_rule__Row1__Group__12821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row1__CAssignment_1_in_rule__Row1__Group__1__Impl2848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row1__Group__2__Impl_in_rule__Row1__Group__22878 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Row1__Group__3_in_rule__Row1__Group__22881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row1__CAssignment_2_in_rule__Row1__Group__2__Impl2908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row1__Group__3__Impl_in_rule__Row1__Group__32938 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Row1__Group__4_in_rule__Row1__Group__32941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row1__CAssignment_3_in_rule__Row1__Group__3__Impl2968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row1__Group__4__Impl_in_rule__Row1__Group__42998 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Row1__Group__5_in_rule__Row1__Group__43001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row1__CAssignment_4_in_rule__Row1__Group__4__Impl3028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row1__Group__5__Impl_in_rule__Row1__Group__53058 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Row1__Group__6_in_rule__Row1__Group__53061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row1__CAssignment_5_in_rule__Row1__Group__5__Impl3088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row1__Group__6__Impl_in_rule__Row1__Group__63118 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Row1__Group__7_in_rule__Row1__Group__63121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row1__CAssignment_6_in_rule__Row1__Group__6__Impl3148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row1__Group__7__Impl_in_rule__Row1__Group__73178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Row1__CAssignment_7_in_rule__Row1__Group__7__Impl3205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTable_in_rule__Model__TablesAssignment_13256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FDescription__NameAssignment_13287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__FDescription__BaseAssignment_33318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRow_in_rule__Table__RAssignment_23349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRow_in_rule__Table__RAssignment_33380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRow_in_rule__Table__RAssignment_43411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRow_in_rule__Table__RAssignment_53442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRow_in_rule__Table__RAssignment_63473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRow_in_rule__Table__RAssignment_73504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRow_in_rule__Table__RAssignment_83535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRow_in_rule__Table__RAssignment_93566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePieceType_in_rule__TDescription__NameAssignment_13597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__TDescription__ValueAssignment_33628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRowLabel_in_rule__Row__NameAssignment_03659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMRow_in_rule__Row__MAssignment_13690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleERow_in_rule__Row__EAssignment_23721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRow1_in_rule__MRow__NameAssignment3752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRow1_in_rule__ERow__NameAssignment3783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Row1__CAssignment_03814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Row1__CAssignment_13845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Row1__CAssignment_23876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Row1__CAssignment_33907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Row1__CAssignment_43938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Row1__CAssignment_53969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Row1__CAssignment_64000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Row1__CAssignment_74031 = new BitSet(new long[]{0x0000000000000002L});

}