package org.xtext.ocl.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.xtext.ocl.services.OclGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalOclParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_TYPENAME_TERMINAL", "RULE_COLON", "RULE_DOUBLE_COLON", "RULE_STRING", "RULE_NUMBER", "RULE_NAME_TERMINAL", "RULE_LOWER", "RULE_UPPER", "RULE_LETTER", "RULE_DIGIT", "RULE_IDCHAR", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'inv:'", "'pre:'", "'post:'", "'allInstaces'", "'oclType'", "'toString'", "'refImmediateComposite'", "'size'", "'toInteger'", "'toUpper'", "'toReal'", "'toLower'", "'toSequence'", "'trim'", "'isEmpty'", "'oclIsUndefined'", "'floor'", "'round'", "'notEmpty'", "'asBag'", "'asSequence'", "'sum'", "'asSet'", "'flatten'", "'first'", "'last'", "'oclTypeOf'", "'oclisKindOf'", "'concat'", "'startsWith'", "'endsWith'", "'indexOf'", "'lastIndexOf'", "'split'", "'replaceAll'", "'regexReplaceAll'", "'substring'", "'subSequence'", "'subOrderedSet'", "'Set'", "'Bag'", "'Sequence'", "'Collection'", "'.'", "'->'", "'-'", "'not'", "'*'", "'/'", "'+'", "'='", "'>'", "'<'", "'>='", "'<='", "'<>'", "'and'", "'or'", "'xor'", "'implies'", "'context'", "'('", "')'", "'if'", "'then'", "'endif'", "'else'", "'#'", "'enum'", "'{'", "'}'", "','", "'..'", "'['", "']'", "'|'", "'@'", "'()'", "'at'"
    };
    public static final int T__50=50;
    public static final int RULE_IDCHAR=14;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=15;
    public static final int RULE_DIGIT=13;
    public static final int RULE_COLON=5;
    public static final int RULE_INT=16;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=17;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int RULE_LOWER=10;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_UPPER=11;
    public static final int RULE_LETTER=12;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__90=90;
    public static final int T__99=99;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int RULE_DOUBLE_COLON=6;
    public static final int RULE_NAME_TERMINAL=9;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__21=21;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=7;
    public static final int RULE_SL_COMMENT=18;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=19;
    public static final int RULE_ANY_OTHER=20;
    public static final int RULE_NUMBER=8;
    public static final int RULE_TYPENAME_TERMINAL=4;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;

    // delegates
    // delegators


        public InternalOclParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalOclParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalOclParser.tokenNames; }
    public String getGrammarFileName() { return "InternalOcl.g"; }


    	private OclGrammarAccess grammarAccess;

    	public void setGrammarAccess(OclGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleStart"
    // InternalOcl.g:53:1: entryRuleStart : ruleStart EOF ;
    public final void entryRuleStart() throws RecognitionException {
        try {
            // InternalOcl.g:54:1: ( ruleStart EOF )
            // InternalOcl.g:55:1: ruleStart EOF
            {
             before(grammarAccess.getStartRule()); 
            pushFollow(FOLLOW_1);
            ruleStart();

            state._fsp--;

             after(grammarAccess.getStartRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleStart"


    // $ANTLR start "ruleStart"
    // InternalOcl.g:62:1: ruleStart : ( ( rule__Start__Alternatives ) ) ;
    public final void ruleStart() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:66:2: ( ( ( rule__Start__Alternatives ) ) )
            // InternalOcl.g:67:2: ( ( rule__Start__Alternatives ) )
            {
            // InternalOcl.g:67:2: ( ( rule__Start__Alternatives ) )
            // InternalOcl.g:68:3: ( rule__Start__Alternatives )
            {
             before(grammarAccess.getStartAccess().getAlternatives()); 
            // InternalOcl.g:69:3: ( rule__Start__Alternatives )
            // InternalOcl.g:69:4: rule__Start__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Start__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getStartAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStart"


    // $ANTLR start "entryRuleContextExpression"
    // InternalOcl.g:78:1: entryRuleContextExpression : ruleContextExpression EOF ;
    public final void entryRuleContextExpression() throws RecognitionException {
        try {
            // InternalOcl.g:79:1: ( ruleContextExpression EOF )
            // InternalOcl.g:80:1: ruleContextExpression EOF
            {
             before(grammarAccess.getContextExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleContextExpression();

            state._fsp--;

             after(grammarAccess.getContextExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleContextExpression"


    // $ANTLR start "ruleContextExpression"
    // InternalOcl.g:87:1: ruleContextExpression : ( ( rule__ContextExpression__Group__0 ) ) ;
    public final void ruleContextExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:91:2: ( ( ( rule__ContextExpression__Group__0 ) ) )
            // InternalOcl.g:92:2: ( ( rule__ContextExpression__Group__0 ) )
            {
            // InternalOcl.g:92:2: ( ( rule__ContextExpression__Group__0 ) )
            // InternalOcl.g:93:3: ( rule__ContextExpression__Group__0 )
            {
             before(grammarAccess.getContextExpressionAccess().getGroup()); 
            // InternalOcl.g:94:3: ( rule__ContextExpression__Group__0 )
            // InternalOcl.g:94:4: rule__ContextExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ContextExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getContextExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleContextExpression"


    // $ANTLR start "entryRuleExpression"
    // InternalOcl.g:103:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // InternalOcl.g:104:1: ( ruleExpression EOF )
            // InternalOcl.g:105:1: ruleExpression EOF
            {
             before(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalOcl.g:112:1: ruleExpression : ( ruleLogicalExpression ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:116:2: ( ( ruleLogicalExpression ) )
            // InternalOcl.g:117:2: ( ruleLogicalExpression )
            {
            // InternalOcl.g:117:2: ( ruleLogicalExpression )
            // InternalOcl.g:118:3: ruleLogicalExpression
            {
             before(grammarAccess.getExpressionAccess().getLogicalExpressionParserRuleCall()); 
            pushFollow(FOLLOW_2);
            ruleLogicalExpression();

            state._fsp--;

             after(grammarAccess.getExpressionAccess().getLogicalExpressionParserRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleLogicalExpression"
    // InternalOcl.g:128:1: entryRuleLogicalExpression : ruleLogicalExpression EOF ;
    public final void entryRuleLogicalExpression() throws RecognitionException {
        try {
            // InternalOcl.g:129:1: ( ruleLogicalExpression EOF )
            // InternalOcl.g:130:1: ruleLogicalExpression EOF
            {
             before(grammarAccess.getLogicalExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleLogicalExpression();

            state._fsp--;

             after(grammarAccess.getLogicalExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleLogicalExpression"


    // $ANTLR start "ruleLogicalExpression"
    // InternalOcl.g:137:1: ruleLogicalExpression : ( ( rule__LogicalExpression__Group__0 ) ) ;
    public final void ruleLogicalExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:141:2: ( ( ( rule__LogicalExpression__Group__0 ) ) )
            // InternalOcl.g:142:2: ( ( rule__LogicalExpression__Group__0 ) )
            {
            // InternalOcl.g:142:2: ( ( rule__LogicalExpression__Group__0 ) )
            // InternalOcl.g:143:3: ( rule__LogicalExpression__Group__0 )
            {
             before(grammarAccess.getLogicalExpressionAccess().getGroup()); 
            // InternalOcl.g:144:3: ( rule__LogicalExpression__Group__0 )
            // InternalOcl.g:144:4: rule__LogicalExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__LogicalExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLogicalExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLogicalExpression"


    // $ANTLR start "entryRuleRelationalExpression"
    // InternalOcl.g:153:1: entryRuleRelationalExpression : ruleRelationalExpression EOF ;
    public final void entryRuleRelationalExpression() throws RecognitionException {
        try {
            // InternalOcl.g:154:1: ( ruleRelationalExpression EOF )
            // InternalOcl.g:155:1: ruleRelationalExpression EOF
            {
             before(grammarAccess.getRelationalExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleRelationalExpression();

            state._fsp--;

             after(grammarAccess.getRelationalExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleRelationalExpression"


    // $ANTLR start "ruleRelationalExpression"
    // InternalOcl.g:162:1: ruleRelationalExpression : ( ( rule__RelationalExpression__Group__0 ) ) ;
    public final void ruleRelationalExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:166:2: ( ( ( rule__RelationalExpression__Group__0 ) ) )
            // InternalOcl.g:167:2: ( ( rule__RelationalExpression__Group__0 ) )
            {
            // InternalOcl.g:167:2: ( ( rule__RelationalExpression__Group__0 ) )
            // InternalOcl.g:168:3: ( rule__RelationalExpression__Group__0 )
            {
             before(grammarAccess.getRelationalExpressionAccess().getGroup()); 
            // InternalOcl.g:169:3: ( rule__RelationalExpression__Group__0 )
            // InternalOcl.g:169:4: rule__RelationalExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RelationalExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRelationalExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRelationalExpression"


    // $ANTLR start "entryRuleAdditiveExpression"
    // InternalOcl.g:178:1: entryRuleAdditiveExpression : ruleAdditiveExpression EOF ;
    public final void entryRuleAdditiveExpression() throws RecognitionException {
        try {
            // InternalOcl.g:179:1: ( ruleAdditiveExpression EOF )
            // InternalOcl.g:180:1: ruleAdditiveExpression EOF
            {
             before(grammarAccess.getAdditiveExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleAdditiveExpression();

            state._fsp--;

             after(grammarAccess.getAdditiveExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleAdditiveExpression"


    // $ANTLR start "ruleAdditiveExpression"
    // InternalOcl.g:187:1: ruleAdditiveExpression : ( ( rule__AdditiveExpression__Group__0 ) ) ;
    public final void ruleAdditiveExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:191:2: ( ( ( rule__AdditiveExpression__Group__0 ) ) )
            // InternalOcl.g:192:2: ( ( rule__AdditiveExpression__Group__0 ) )
            {
            // InternalOcl.g:192:2: ( ( rule__AdditiveExpression__Group__0 ) )
            // InternalOcl.g:193:3: ( rule__AdditiveExpression__Group__0 )
            {
             before(grammarAccess.getAdditiveExpressionAccess().getGroup()); 
            // InternalOcl.g:194:3: ( rule__AdditiveExpression__Group__0 )
            // InternalOcl.g:194:4: rule__AdditiveExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AdditiveExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAdditiveExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleMultiplicativeExpression"
    // InternalOcl.g:203:1: entryRuleMultiplicativeExpression : ruleMultiplicativeExpression EOF ;
    public final void entryRuleMultiplicativeExpression() throws RecognitionException {
        try {
            // InternalOcl.g:204:1: ( ruleMultiplicativeExpression EOF )
            // InternalOcl.g:205:1: ruleMultiplicativeExpression EOF
            {
             before(grammarAccess.getMultiplicativeExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleMultiplicativeExpression();

            state._fsp--;

             after(grammarAccess.getMultiplicativeExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleMultiplicativeExpression"


    // $ANTLR start "ruleMultiplicativeExpression"
    // InternalOcl.g:212:1: ruleMultiplicativeExpression : ( ( rule__MultiplicativeExpression__Group__0 ) ) ;
    public final void ruleMultiplicativeExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:216:2: ( ( ( rule__MultiplicativeExpression__Group__0 ) ) )
            // InternalOcl.g:217:2: ( ( rule__MultiplicativeExpression__Group__0 ) )
            {
            // InternalOcl.g:217:2: ( ( rule__MultiplicativeExpression__Group__0 ) )
            // InternalOcl.g:218:3: ( rule__MultiplicativeExpression__Group__0 )
            {
             before(grammarAccess.getMultiplicativeExpressionAccess().getGroup()); 
            // InternalOcl.g:219:3: ( rule__MultiplicativeExpression__Group__0 )
            // InternalOcl.g:219:4: rule__MultiplicativeExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MultiplicativeExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMultiplicativeExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMultiplicativeExpression"


    // $ANTLR start "entryRuleUnaryExpression"
    // InternalOcl.g:228:1: entryRuleUnaryExpression : ruleUnaryExpression EOF ;
    public final void entryRuleUnaryExpression() throws RecognitionException {
        try {
            // InternalOcl.g:229:1: ( ruleUnaryExpression EOF )
            // InternalOcl.g:230:1: ruleUnaryExpression EOF
            {
             before(grammarAccess.getUnaryExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleUnaryExpression();

            state._fsp--;

             after(grammarAccess.getUnaryExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleUnaryExpression"


    // $ANTLR start "ruleUnaryExpression"
    // InternalOcl.g:237:1: ruleUnaryExpression : ( ( rule__UnaryExpression__Group__0 ) ) ;
    public final void ruleUnaryExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:241:2: ( ( ( rule__UnaryExpression__Group__0 ) ) )
            // InternalOcl.g:242:2: ( ( rule__UnaryExpression__Group__0 ) )
            {
            // InternalOcl.g:242:2: ( ( rule__UnaryExpression__Group__0 ) )
            // InternalOcl.g:243:3: ( rule__UnaryExpression__Group__0 )
            {
             before(grammarAccess.getUnaryExpressionAccess().getGroup()); 
            // InternalOcl.g:244:3: ( rule__UnaryExpression__Group__0 )
            // InternalOcl.g:244:4: rule__UnaryExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__UnaryExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUnaryExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnaryExpression"


    // $ANTLR start "entryRulePostfixExpression"
    // InternalOcl.g:253:1: entryRulePostfixExpression : rulePostfixExpression EOF ;
    public final void entryRulePostfixExpression() throws RecognitionException {
        try {
            // InternalOcl.g:254:1: ( rulePostfixExpression EOF )
            // InternalOcl.g:255:1: rulePostfixExpression EOF
            {
             before(grammarAccess.getPostfixExpressionRule()); 
            pushFollow(FOLLOW_1);
            rulePostfixExpression();

            state._fsp--;

             after(grammarAccess.getPostfixExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRulePostfixExpression"


    // $ANTLR start "rulePostfixExpression"
    // InternalOcl.g:262:1: rulePostfixExpression : ( ( rule__PostfixExpression__Group__0 ) ) ;
    public final void rulePostfixExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:266:2: ( ( ( rule__PostfixExpression__Group__0 ) ) )
            // InternalOcl.g:267:2: ( ( rule__PostfixExpression__Group__0 ) )
            {
            // InternalOcl.g:267:2: ( ( rule__PostfixExpression__Group__0 ) )
            // InternalOcl.g:268:3: ( rule__PostfixExpression__Group__0 )
            {
             before(grammarAccess.getPostfixExpressionAccess().getGroup()); 
            // InternalOcl.g:269:3: ( rule__PostfixExpression__Group__0 )
            // InternalOcl.g:269:4: rule__PostfixExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PostfixExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPostfixExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePostfixExpression"


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalOcl.g:278:1: entryRulePrimaryExpression : rulePrimaryExpression EOF ;
    public final void entryRulePrimaryExpression() throws RecognitionException {
        try {
            // InternalOcl.g:279:1: ( rulePrimaryExpression EOF )
            // InternalOcl.g:280:1: rulePrimaryExpression EOF
            {
             before(grammarAccess.getPrimaryExpressionRule()); 
            pushFollow(FOLLOW_1);
            rulePrimaryExpression();

            state._fsp--;

             after(grammarAccess.getPrimaryExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // InternalOcl.g:287:1: rulePrimaryExpression : ( ( rule__PrimaryExpression__Alternatives ) ) ;
    public final void rulePrimaryExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:291:2: ( ( ( rule__PrimaryExpression__Alternatives ) ) )
            // InternalOcl.g:292:2: ( ( rule__PrimaryExpression__Alternatives ) )
            {
            // InternalOcl.g:292:2: ( ( rule__PrimaryExpression__Alternatives ) )
            // InternalOcl.g:293:3: ( rule__PrimaryExpression__Alternatives )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getAlternatives()); 
            // InternalOcl.g:294:3: ( rule__PrimaryExpression__Alternatives )
            // InternalOcl.g:294:4: rule__PrimaryExpression__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPrimaryExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleIfExpression"
    // InternalOcl.g:303:1: entryRuleIfExpression : ruleIfExpression EOF ;
    public final void entryRuleIfExpression() throws RecognitionException {
        try {
            // InternalOcl.g:304:1: ( ruleIfExpression EOF )
            // InternalOcl.g:305:1: ruleIfExpression EOF
            {
             before(grammarAccess.getIfExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleIfExpression();

            state._fsp--;

             after(grammarAccess.getIfExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleIfExpression"


    // $ANTLR start "ruleIfExpression"
    // InternalOcl.g:312:1: ruleIfExpression : ( ( rule__IfExpression__Group__0 ) ) ;
    public final void ruleIfExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:316:2: ( ( ( rule__IfExpression__Group__0 ) ) )
            // InternalOcl.g:317:2: ( ( rule__IfExpression__Group__0 ) )
            {
            // InternalOcl.g:317:2: ( ( rule__IfExpression__Group__0 ) )
            // InternalOcl.g:318:3: ( rule__IfExpression__Group__0 )
            {
             before(grammarAccess.getIfExpressionAccess().getGroup()); 
            // InternalOcl.g:319:3: ( rule__IfExpression__Group__0 )
            // InternalOcl.g:319:4: rule__IfExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__IfExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIfExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIfExpression"


    // $ANTLR start "entryRuleFeatureCallParameters"
    // InternalOcl.g:328:1: entryRuleFeatureCallParameters : ruleFeatureCallParameters EOF ;
    public final void entryRuleFeatureCallParameters() throws RecognitionException {
        try {
            // InternalOcl.g:329:1: ( ruleFeatureCallParameters EOF )
            // InternalOcl.g:330:1: ruleFeatureCallParameters EOF
            {
             before(grammarAccess.getFeatureCallParametersRule()); 
            pushFollow(FOLLOW_1);
            ruleFeatureCallParameters();

            state._fsp--;

             after(grammarAccess.getFeatureCallParametersRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleFeatureCallParameters"


    // $ANTLR start "ruleFeatureCallParameters"
    // InternalOcl.g:337:1: ruleFeatureCallParameters : ( ( rule__FeatureCallParameters__Group__0 ) ) ;
    public final void ruleFeatureCallParameters() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:341:2: ( ( ( rule__FeatureCallParameters__Group__0 ) ) )
            // InternalOcl.g:342:2: ( ( rule__FeatureCallParameters__Group__0 ) )
            {
            // InternalOcl.g:342:2: ( ( rule__FeatureCallParameters__Group__0 ) )
            // InternalOcl.g:343:3: ( rule__FeatureCallParameters__Group__0 )
            {
             before(grammarAccess.getFeatureCallParametersAccess().getGroup()); 
            // InternalOcl.g:344:3: ( rule__FeatureCallParameters__Group__0 )
            // InternalOcl.g:344:4: rule__FeatureCallParameters__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FeatureCallParameters__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFeatureCallParametersAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFeatureCallParameters"


    // $ANTLR start "entryRuleLiteral"
    // InternalOcl.g:353:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        try {
            // InternalOcl.g:354:1: ( ruleLiteral EOF )
            // InternalOcl.g:355:1: ruleLiteral EOF
            {
             before(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_1);
            ruleLiteral();

            state._fsp--;

             after(grammarAccess.getLiteralRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // InternalOcl.g:362:1: ruleLiteral : ( ( rule__Literal__Alternatives ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:366:2: ( ( ( rule__Literal__Alternatives ) ) )
            // InternalOcl.g:367:2: ( ( rule__Literal__Alternatives ) )
            {
            // InternalOcl.g:367:2: ( ( rule__Literal__Alternatives ) )
            // InternalOcl.g:368:3: ( rule__Literal__Alternatives )
            {
             before(grammarAccess.getLiteralAccess().getAlternatives()); 
            // InternalOcl.g:369:3: ( rule__Literal__Alternatives )
            // InternalOcl.g:369:4: rule__Literal__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Literal__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLiteralAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleEnumerationType"
    // InternalOcl.g:378:1: entryRuleEnumerationType : ruleEnumerationType EOF ;
    public final void entryRuleEnumerationType() throws RecognitionException {
        try {
            // InternalOcl.g:379:1: ( ruleEnumerationType EOF )
            // InternalOcl.g:380:1: ruleEnumerationType EOF
            {
             before(grammarAccess.getEnumerationTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleEnumerationType();

            state._fsp--;

             after(grammarAccess.getEnumerationTypeRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleEnumerationType"


    // $ANTLR start "ruleEnumerationType"
    // InternalOcl.g:387:1: ruleEnumerationType : ( ( rule__EnumerationType__Group__0 ) ) ;
    public final void ruleEnumerationType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:391:2: ( ( ( rule__EnumerationType__Group__0 ) ) )
            // InternalOcl.g:392:2: ( ( rule__EnumerationType__Group__0 ) )
            {
            // InternalOcl.g:392:2: ( ( rule__EnumerationType__Group__0 ) )
            // InternalOcl.g:393:3: ( rule__EnumerationType__Group__0 )
            {
             before(grammarAccess.getEnumerationTypeAccess().getGroup()); 
            // InternalOcl.g:394:3: ( rule__EnumerationType__Group__0 )
            // InternalOcl.g:394:4: rule__EnumerationType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EnumerationType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEnumerationTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEnumerationType"


    // $ANTLR start "entryRuleSimpleTypeSpecifier"
    // InternalOcl.g:403:1: entryRuleSimpleTypeSpecifier : ruleSimpleTypeSpecifier EOF ;
    public final void entryRuleSimpleTypeSpecifier() throws RecognitionException {
        try {
            // InternalOcl.g:404:1: ( ruleSimpleTypeSpecifier EOF )
            // InternalOcl.g:405:1: ruleSimpleTypeSpecifier EOF
            {
             before(grammarAccess.getSimpleTypeSpecifierRule()); 
            pushFollow(FOLLOW_1);
            ruleSimpleTypeSpecifier();

            state._fsp--;

             after(grammarAccess.getSimpleTypeSpecifierRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleSimpleTypeSpecifier"


    // $ANTLR start "ruleSimpleTypeSpecifier"
    // InternalOcl.g:412:1: ruleSimpleTypeSpecifier : ( ( rule__SimpleTypeSpecifier__Alternatives ) ) ;
    public final void ruleSimpleTypeSpecifier() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:416:2: ( ( ( rule__SimpleTypeSpecifier__Alternatives ) ) )
            // InternalOcl.g:417:2: ( ( rule__SimpleTypeSpecifier__Alternatives ) )
            {
            // InternalOcl.g:417:2: ( ( rule__SimpleTypeSpecifier__Alternatives ) )
            // InternalOcl.g:418:3: ( rule__SimpleTypeSpecifier__Alternatives )
            {
             before(grammarAccess.getSimpleTypeSpecifierAccess().getAlternatives()); 
            // InternalOcl.g:419:3: ( rule__SimpleTypeSpecifier__Alternatives )
            // InternalOcl.g:419:4: rule__SimpleTypeSpecifier__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__SimpleTypeSpecifier__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getSimpleTypeSpecifierAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSimpleTypeSpecifier"


    // $ANTLR start "entryRuleLiteralCollection"
    // InternalOcl.g:428:1: entryRuleLiteralCollection : ruleLiteralCollection EOF ;
    public final void entryRuleLiteralCollection() throws RecognitionException {
        try {
            // InternalOcl.g:429:1: ( ruleLiteralCollection EOF )
            // InternalOcl.g:430:1: ruleLiteralCollection EOF
            {
             before(grammarAccess.getLiteralCollectionRule()); 
            pushFollow(FOLLOW_1);
            ruleLiteralCollection();

            state._fsp--;

             after(grammarAccess.getLiteralCollectionRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleLiteralCollection"


    // $ANTLR start "ruleLiteralCollection"
    // InternalOcl.g:437:1: ruleLiteralCollection : ( ( rule__LiteralCollection__Group__0 ) ) ;
    public final void ruleLiteralCollection() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:441:2: ( ( ( rule__LiteralCollection__Group__0 ) ) )
            // InternalOcl.g:442:2: ( ( rule__LiteralCollection__Group__0 ) )
            {
            // InternalOcl.g:442:2: ( ( rule__LiteralCollection__Group__0 ) )
            // InternalOcl.g:443:3: ( rule__LiteralCollection__Group__0 )
            {
             before(grammarAccess.getLiteralCollectionAccess().getGroup()); 
            // InternalOcl.g:444:3: ( rule__LiteralCollection__Group__0 )
            // InternalOcl.g:444:4: rule__LiteralCollection__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__LiteralCollection__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLiteralCollectionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLiteralCollection"


    // $ANTLR start "entryRuleExpressionListOrRange"
    // InternalOcl.g:453:1: entryRuleExpressionListOrRange : ruleExpressionListOrRange EOF ;
    public final void entryRuleExpressionListOrRange() throws RecognitionException {
        try {
            // InternalOcl.g:454:1: ( ruleExpressionListOrRange EOF )
            // InternalOcl.g:455:1: ruleExpressionListOrRange EOF
            {
             before(grammarAccess.getExpressionListOrRangeRule()); 
            pushFollow(FOLLOW_1);
            ruleExpressionListOrRange();

            state._fsp--;

             after(grammarAccess.getExpressionListOrRangeRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleExpressionListOrRange"


    // $ANTLR start "ruleExpressionListOrRange"
    // InternalOcl.g:462:1: ruleExpressionListOrRange : ( ( rule__ExpressionListOrRange__Group__0 ) ) ;
    public final void ruleExpressionListOrRange() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:466:2: ( ( ( rule__ExpressionListOrRange__Group__0 ) ) )
            // InternalOcl.g:467:2: ( ( rule__ExpressionListOrRange__Group__0 ) )
            {
            // InternalOcl.g:467:2: ( ( rule__ExpressionListOrRange__Group__0 ) )
            // InternalOcl.g:468:3: ( rule__ExpressionListOrRange__Group__0 )
            {
             before(grammarAccess.getExpressionListOrRangeAccess().getGroup()); 
            // InternalOcl.g:469:3: ( rule__ExpressionListOrRange__Group__0 )
            // InternalOcl.g:469:4: rule__ExpressionListOrRange__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ExpressionListOrRange__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getExpressionListOrRangeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExpressionListOrRange"


    // $ANTLR start "entryRuleFeatureCall"
    // InternalOcl.g:478:1: entryRuleFeatureCall : ruleFeatureCall EOF ;
    public final void entryRuleFeatureCall() throws RecognitionException {
        try {
            // InternalOcl.g:479:1: ( ruleFeatureCall EOF )
            // InternalOcl.g:480:1: ruleFeatureCall EOF
            {
             before(grammarAccess.getFeatureCallRule()); 
            pushFollow(FOLLOW_1);
            ruleFeatureCall();

            state._fsp--;

             after(grammarAccess.getFeatureCallRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleFeatureCall"


    // $ANTLR start "ruleFeatureCall"
    // InternalOcl.g:487:1: ruleFeatureCall : ( ( rule__FeatureCall__Group__0 ) ) ;
    public final void ruleFeatureCall() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:491:2: ( ( ( rule__FeatureCall__Group__0 ) ) )
            // InternalOcl.g:492:2: ( ( rule__FeatureCall__Group__0 ) )
            {
            // InternalOcl.g:492:2: ( ( rule__FeatureCall__Group__0 ) )
            // InternalOcl.g:493:3: ( rule__FeatureCall__Group__0 )
            {
             before(grammarAccess.getFeatureCallAccess().getGroup()); 
            // InternalOcl.g:494:3: ( rule__FeatureCall__Group__0 )
            // InternalOcl.g:494:4: rule__FeatureCall__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FeatureCall__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFeatureCallAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFeatureCall"


    // $ANTLR start "entryRuleQualifiers"
    // InternalOcl.g:503:1: entryRuleQualifiers : ruleQualifiers EOF ;
    public final void entryRuleQualifiers() throws RecognitionException {
        try {
            // InternalOcl.g:504:1: ( ruleQualifiers EOF )
            // InternalOcl.g:505:1: ruleQualifiers EOF
            {
             before(grammarAccess.getQualifiersRule()); 
            pushFollow(FOLLOW_1);
            ruleQualifiers();

            state._fsp--;

             after(grammarAccess.getQualifiersRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleQualifiers"


    // $ANTLR start "ruleQualifiers"
    // InternalOcl.g:512:1: ruleQualifiers : ( ( rule__Qualifiers__Group__0 ) ) ;
    public final void ruleQualifiers() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:516:2: ( ( ( rule__Qualifiers__Group__0 ) ) )
            // InternalOcl.g:517:2: ( ( rule__Qualifiers__Group__0 ) )
            {
            // InternalOcl.g:517:2: ( ( rule__Qualifiers__Group__0 ) )
            // InternalOcl.g:518:3: ( rule__Qualifiers__Group__0 )
            {
             before(grammarAccess.getQualifiersAccess().getGroup()); 
            // InternalOcl.g:519:3: ( rule__Qualifiers__Group__0 )
            // InternalOcl.g:519:4: rule__Qualifiers__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Qualifiers__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiersAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiers"


    // $ANTLR start "entryRuleDeclarator"
    // InternalOcl.g:528:1: entryRuleDeclarator : ruleDeclarator EOF ;
    public final void entryRuleDeclarator() throws RecognitionException {
        try {
            // InternalOcl.g:529:1: ( ruleDeclarator EOF )
            // InternalOcl.g:530:1: ruleDeclarator EOF
            {
             before(grammarAccess.getDeclaratorRule()); 
            pushFollow(FOLLOW_1);
            ruleDeclarator();

            state._fsp--;

             after(grammarAccess.getDeclaratorRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleDeclarator"


    // $ANTLR start "ruleDeclarator"
    // InternalOcl.g:537:1: ruleDeclarator : ( ( rule__Declarator__Group__0 ) ) ;
    public final void ruleDeclarator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:541:2: ( ( ( rule__Declarator__Group__0 ) ) )
            // InternalOcl.g:542:2: ( ( rule__Declarator__Group__0 ) )
            {
            // InternalOcl.g:542:2: ( ( rule__Declarator__Group__0 ) )
            // InternalOcl.g:543:3: ( rule__Declarator__Group__0 )
            {
             before(grammarAccess.getDeclaratorAccess().getGroup()); 
            // InternalOcl.g:544:3: ( rule__Declarator__Group__0 )
            // InternalOcl.g:544:4: rule__Declarator__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Declarator__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDeclaratorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDeclarator"


    // $ANTLR start "entryRulePathTypeName"
    // InternalOcl.g:553:1: entryRulePathTypeName : rulePathTypeName EOF ;
    public final void entryRulePathTypeName() throws RecognitionException {
        try {
            // InternalOcl.g:554:1: ( rulePathTypeName EOF )
            // InternalOcl.g:555:1: rulePathTypeName EOF
            {
             before(grammarAccess.getPathTypeNameRule()); 
            pushFollow(FOLLOW_1);
            rulePathTypeName();

            state._fsp--;

             after(grammarAccess.getPathTypeNameRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRulePathTypeName"


    // $ANTLR start "rulePathTypeName"
    // InternalOcl.g:562:1: rulePathTypeName : ( ( rule__PathTypeName__Group__0 ) ) ;
    public final void rulePathTypeName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:566:2: ( ( ( rule__PathTypeName__Group__0 ) ) )
            // InternalOcl.g:567:2: ( ( rule__PathTypeName__Group__0 ) )
            {
            // InternalOcl.g:567:2: ( ( rule__PathTypeName__Group__0 ) )
            // InternalOcl.g:568:3: ( rule__PathTypeName__Group__0 )
            {
             before(grammarAccess.getPathTypeNameAccess().getGroup()); 
            // InternalOcl.g:569:3: ( rule__PathTypeName__Group__0 )
            // InternalOcl.g:569:4: rule__PathTypeName__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PathTypeName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPathTypeNameAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePathTypeName"


    // $ANTLR start "entryRulePathName"
    // InternalOcl.g:578:1: entryRulePathName : rulePathName EOF ;
    public final void entryRulePathName() throws RecognitionException {
        try {
            // InternalOcl.g:579:1: ( rulePathName EOF )
            // InternalOcl.g:580:1: rulePathName EOF
            {
             before(grammarAccess.getPathNameRule()); 
            pushFollow(FOLLOW_1);
            rulePathName();

            state._fsp--;

             after(grammarAccess.getPathNameRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRulePathName"


    // $ANTLR start "rulePathName"
    // InternalOcl.g:587:1: rulePathName : ( ( rule__PathName__Group__0 ) ) ;
    public final void rulePathName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:591:2: ( ( ( rule__PathName__Group__0 ) ) )
            // InternalOcl.g:592:2: ( ( rule__PathName__Group__0 ) )
            {
            // InternalOcl.g:592:2: ( ( rule__PathName__Group__0 ) )
            // InternalOcl.g:593:3: ( rule__PathName__Group__0 )
            {
             before(grammarAccess.getPathNameAccess().getGroup()); 
            // InternalOcl.g:594:3: ( rule__PathName__Group__0 )
            // InternalOcl.g:594:4: rule__PathName__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PathName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPathNameAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePathName"


    // $ANTLR start "entryRuleTimeExpression"
    // InternalOcl.g:603:1: entryRuleTimeExpression : ruleTimeExpression EOF ;
    public final void entryRuleTimeExpression() throws RecognitionException {
        try {
            // InternalOcl.g:604:1: ( ruleTimeExpression EOF )
            // InternalOcl.g:605:1: ruleTimeExpression EOF
            {
             before(grammarAccess.getTimeExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleTimeExpression();

            state._fsp--;

             after(grammarAccess.getTimeExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleTimeExpression"


    // $ANTLR start "ruleTimeExpression"
    // InternalOcl.g:612:1: ruleTimeExpression : ( ( rule__TimeExpression__Group__0 ) ) ;
    public final void ruleTimeExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:616:2: ( ( ( rule__TimeExpression__Group__0 ) ) )
            // InternalOcl.g:617:2: ( ( rule__TimeExpression__Group__0 ) )
            {
            // InternalOcl.g:617:2: ( ( rule__TimeExpression__Group__0 ) )
            // InternalOcl.g:618:3: ( rule__TimeExpression__Group__0 )
            {
             before(grammarAccess.getTimeExpressionAccess().getGroup()); 
            // InternalOcl.g:619:3: ( rule__TimeExpression__Group__0 )
            // InternalOcl.g:619:4: rule__TimeExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TimeExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTimeExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTimeExpression"


    // $ANTLR start "entryRuleActualParameterList"
    // InternalOcl.g:628:1: entryRuleActualParameterList : ruleActualParameterList EOF ;
    public final void entryRuleActualParameterList() throws RecognitionException {
        try {
            // InternalOcl.g:629:1: ( ruleActualParameterList EOF )
            // InternalOcl.g:630:1: ruleActualParameterList EOF
            {
             before(grammarAccess.getActualParameterListRule()); 
            pushFollow(FOLLOW_1);
            ruleActualParameterList();

            state._fsp--;

             after(grammarAccess.getActualParameterListRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleActualParameterList"


    // $ANTLR start "ruleActualParameterList"
    // InternalOcl.g:637:1: ruleActualParameterList : ( ( rule__ActualParameterList__Group__0 ) ) ;
    public final void ruleActualParameterList() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:641:2: ( ( ( rule__ActualParameterList__Group__0 ) ) )
            // InternalOcl.g:642:2: ( ( rule__ActualParameterList__Group__0 ) )
            {
            // InternalOcl.g:642:2: ( ( rule__ActualParameterList__Group__0 ) )
            // InternalOcl.g:643:3: ( rule__ActualParameterList__Group__0 )
            {
             before(grammarAccess.getActualParameterListAccess().getGroup()); 
            // InternalOcl.g:644:3: ( rule__ActualParameterList__Group__0 )
            // InternalOcl.g:644:4: rule__ActualParameterList__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ActualParameterList__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getActualParameterListAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleActualParameterList"


    // $ANTLR start "entryRuleTypeName"
    // InternalOcl.g:653:1: entryRuleTypeName : ruleTypeName EOF ;
    public final void entryRuleTypeName() throws RecognitionException {
        try {
            // InternalOcl.g:654:1: ( ruleTypeName EOF )
            // InternalOcl.g:655:1: ruleTypeName EOF
            {
             before(grammarAccess.getTypeNameRule()); 
            pushFollow(FOLLOW_1);
            ruleTypeName();

            state._fsp--;

             after(grammarAccess.getTypeNameRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleTypeName"


    // $ANTLR start "ruleTypeName"
    // InternalOcl.g:662:1: ruleTypeName : ( ( rule__TypeName__NameAssignment ) ) ;
    public final void ruleTypeName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:666:2: ( ( ( rule__TypeName__NameAssignment ) ) )
            // InternalOcl.g:667:2: ( ( rule__TypeName__NameAssignment ) )
            {
            // InternalOcl.g:667:2: ( ( rule__TypeName__NameAssignment ) )
            // InternalOcl.g:668:3: ( rule__TypeName__NameAssignment )
            {
             before(grammarAccess.getTypeNameAccess().getNameAssignment()); 
            // InternalOcl.g:669:3: ( rule__TypeName__NameAssignment )
            // InternalOcl.g:669:4: rule__TypeName__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__TypeName__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getTypeNameAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTypeName"


    // $ANTLR start "entryRuleName"
    // InternalOcl.g:678:1: entryRuleName : ruleName EOF ;
    public final void entryRuleName() throws RecognitionException {
        try {
            // InternalOcl.g:679:1: ( ruleName EOF )
            // InternalOcl.g:680:1: ruleName EOF
            {
             before(grammarAccess.getNameRule()); 
            pushFollow(FOLLOW_1);
            ruleName();

            state._fsp--;

             after(grammarAccess.getNameRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleName"


    // $ANTLR start "ruleName"
    // InternalOcl.g:687:1: ruleName : ( ( rule__Name__Alternatives ) ) ;
    public final void ruleName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:691:2: ( ( ( rule__Name__Alternatives ) ) )
            // InternalOcl.g:692:2: ( ( rule__Name__Alternatives ) )
            {
            // InternalOcl.g:692:2: ( ( rule__Name__Alternatives ) )
            // InternalOcl.g:693:3: ( rule__Name__Alternatives )
            {
             before(grammarAccess.getNameAccess().getAlternatives()); 
            // InternalOcl.g:694:3: ( rule__Name__Alternatives )
            // InternalOcl.g:694:4: rule__Name__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Name__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getNameAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleName"


    // $ANTLR start "entryRuleAttribute"
    // InternalOcl.g:703:1: entryRuleAttribute : ruleAttribute EOF ;
    public final void entryRuleAttribute() throws RecognitionException {
        try {
            // InternalOcl.g:704:1: ( ruleAttribute EOF )
            // InternalOcl.g:705:1: ruleAttribute EOF
            {
             before(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_1);
            ruleAttribute();

            state._fsp--;

             after(grammarAccess.getAttributeRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalOcl.g:712:1: ruleAttribute : ( ( rule__Attribute__NameAssignment ) ) ;
    public final void ruleAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:716:2: ( ( ( rule__Attribute__NameAssignment ) ) )
            // InternalOcl.g:717:2: ( ( rule__Attribute__NameAssignment ) )
            {
            // InternalOcl.g:717:2: ( ( rule__Attribute__NameAssignment ) )
            // InternalOcl.g:718:3: ( rule__Attribute__NameAssignment )
            {
             before(grammarAccess.getAttributeAccess().getNameAssignment()); 
            // InternalOcl.g:719:3: ( rule__Attribute__NameAssignment )
            // InternalOcl.g:719:4: rule__Attribute__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleFunction"
    // InternalOcl.g:728:1: entryRuleFunction : ruleFunction EOF ;
    public final void entryRuleFunction() throws RecognitionException {
        try {
            // InternalOcl.g:729:1: ( ruleFunction EOF )
            // InternalOcl.g:730:1: ruleFunction EOF
            {
             before(grammarAccess.getFunctionRule()); 
            pushFollow(FOLLOW_1);
            ruleFunction();

            state._fsp--;

             after(grammarAccess.getFunctionRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleFunction"


    // $ANTLR start "ruleFunction"
    // InternalOcl.g:737:1: ruleFunction : ( ( rule__Function__Alternatives ) ) ;
    public final void ruleFunction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:741:2: ( ( ( rule__Function__Alternatives ) ) )
            // InternalOcl.g:742:2: ( ( rule__Function__Alternatives ) )
            {
            // InternalOcl.g:742:2: ( ( rule__Function__Alternatives ) )
            // InternalOcl.g:743:3: ( rule__Function__Alternatives )
            {
             before(grammarAccess.getFunctionAccess().getAlternatives()); 
            // InternalOcl.g:744:3: ( rule__Function__Alternatives )
            // InternalOcl.g:744:4: rule__Function__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Function__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getFunctionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRuleNoParamFunction"
    // InternalOcl.g:753:1: entryRuleNoParamFunction : ruleNoParamFunction EOF ;
    public final void entryRuleNoParamFunction() throws RecognitionException {
        try {
            // InternalOcl.g:754:1: ( ruleNoParamFunction EOF )
            // InternalOcl.g:755:1: ruleNoParamFunction EOF
            {
             before(grammarAccess.getNoParamFunctionRule()); 
            pushFollow(FOLLOW_1);
            ruleNoParamFunction();

            state._fsp--;

             after(grammarAccess.getNoParamFunctionRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleNoParamFunction"


    // $ANTLR start "ruleNoParamFunction"
    // InternalOcl.g:762:1: ruleNoParamFunction : ( ( rule__NoParamFunction__Group__0 ) ) ;
    public final void ruleNoParamFunction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:766:2: ( ( ( rule__NoParamFunction__Group__0 ) ) )
            // InternalOcl.g:767:2: ( ( rule__NoParamFunction__Group__0 ) )
            {
            // InternalOcl.g:767:2: ( ( rule__NoParamFunction__Group__0 ) )
            // InternalOcl.g:768:3: ( rule__NoParamFunction__Group__0 )
            {
             before(grammarAccess.getNoParamFunctionAccess().getGroup()); 
            // InternalOcl.g:769:3: ( rule__NoParamFunction__Group__0 )
            // InternalOcl.g:769:4: rule__NoParamFunction__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__NoParamFunction__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNoParamFunctionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNoParamFunction"


    // $ANTLR start "entryRuleOneTypeParamFunction"
    // InternalOcl.g:778:1: entryRuleOneTypeParamFunction : ruleOneTypeParamFunction EOF ;
    public final void entryRuleOneTypeParamFunction() throws RecognitionException {
        try {
            // InternalOcl.g:779:1: ( ruleOneTypeParamFunction EOF )
            // InternalOcl.g:780:1: ruleOneTypeParamFunction EOF
            {
             before(grammarAccess.getOneTypeParamFunctionRule()); 
            pushFollow(FOLLOW_1);
            ruleOneTypeParamFunction();

            state._fsp--;

             after(grammarAccess.getOneTypeParamFunctionRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleOneTypeParamFunction"


    // $ANTLR start "ruleOneTypeParamFunction"
    // InternalOcl.g:787:1: ruleOneTypeParamFunction : ( ( rule__OneTypeParamFunction__Group__0 ) ) ;
    public final void ruleOneTypeParamFunction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:791:2: ( ( ( rule__OneTypeParamFunction__Group__0 ) ) )
            // InternalOcl.g:792:2: ( ( rule__OneTypeParamFunction__Group__0 ) )
            {
            // InternalOcl.g:792:2: ( ( rule__OneTypeParamFunction__Group__0 ) )
            // InternalOcl.g:793:3: ( rule__OneTypeParamFunction__Group__0 )
            {
             before(grammarAccess.getOneTypeParamFunctionAccess().getGroup()); 
            // InternalOcl.g:794:3: ( rule__OneTypeParamFunction__Group__0 )
            // InternalOcl.g:794:4: rule__OneTypeParamFunction__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__OneTypeParamFunction__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOneTypeParamFunctionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOneTypeParamFunction"


    // $ANTLR start "entryRuleOneStringParamFunction"
    // InternalOcl.g:803:1: entryRuleOneStringParamFunction : ruleOneStringParamFunction EOF ;
    public final void entryRuleOneStringParamFunction() throws RecognitionException {
        try {
            // InternalOcl.g:804:1: ( ruleOneStringParamFunction EOF )
            // InternalOcl.g:805:1: ruleOneStringParamFunction EOF
            {
             before(grammarAccess.getOneStringParamFunctionRule()); 
            pushFollow(FOLLOW_1);
            ruleOneStringParamFunction();

            state._fsp--;

             after(grammarAccess.getOneStringParamFunctionRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleOneStringParamFunction"


    // $ANTLR start "ruleOneStringParamFunction"
    // InternalOcl.g:812:1: ruleOneStringParamFunction : ( ( rule__OneStringParamFunction__Group__0 ) ) ;
    public final void ruleOneStringParamFunction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:816:2: ( ( ( rule__OneStringParamFunction__Group__0 ) ) )
            // InternalOcl.g:817:2: ( ( rule__OneStringParamFunction__Group__0 ) )
            {
            // InternalOcl.g:817:2: ( ( rule__OneStringParamFunction__Group__0 ) )
            // InternalOcl.g:818:3: ( rule__OneStringParamFunction__Group__0 )
            {
             before(grammarAccess.getOneStringParamFunctionAccess().getGroup()); 
            // InternalOcl.g:819:3: ( rule__OneStringParamFunction__Group__0 )
            // InternalOcl.g:819:4: rule__OneStringParamFunction__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__OneStringParamFunction__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOneStringParamFunctionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOneStringParamFunction"


    // $ANTLR start "entryRuleTwoStringParamFunction"
    // InternalOcl.g:828:1: entryRuleTwoStringParamFunction : ruleTwoStringParamFunction EOF ;
    public final void entryRuleTwoStringParamFunction() throws RecognitionException {
        try {
            // InternalOcl.g:829:1: ( ruleTwoStringParamFunction EOF )
            // InternalOcl.g:830:1: ruleTwoStringParamFunction EOF
            {
             before(grammarAccess.getTwoStringParamFunctionRule()); 
            pushFollow(FOLLOW_1);
            ruleTwoStringParamFunction();

            state._fsp--;

             after(grammarAccess.getTwoStringParamFunctionRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleTwoStringParamFunction"


    // $ANTLR start "ruleTwoStringParamFunction"
    // InternalOcl.g:837:1: ruleTwoStringParamFunction : ( ( rule__TwoStringParamFunction__Group__0 ) ) ;
    public final void ruleTwoStringParamFunction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:841:2: ( ( ( rule__TwoStringParamFunction__Group__0 ) ) )
            // InternalOcl.g:842:2: ( ( rule__TwoStringParamFunction__Group__0 ) )
            {
            // InternalOcl.g:842:2: ( ( rule__TwoStringParamFunction__Group__0 ) )
            // InternalOcl.g:843:3: ( rule__TwoStringParamFunction__Group__0 )
            {
             before(grammarAccess.getTwoStringParamFunctionAccess().getGroup()); 
            // InternalOcl.g:844:3: ( rule__TwoStringParamFunction__Group__0 )
            // InternalOcl.g:844:4: rule__TwoStringParamFunction__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TwoStringParamFunction__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTwoStringParamFunctionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTwoStringParamFunction"


    // $ANTLR start "entryRuleOneIntegerParamFunction"
    // InternalOcl.g:853:1: entryRuleOneIntegerParamFunction : ruleOneIntegerParamFunction EOF ;
    public final void entryRuleOneIntegerParamFunction() throws RecognitionException {
        try {
            // InternalOcl.g:854:1: ( ruleOneIntegerParamFunction EOF )
            // InternalOcl.g:855:1: ruleOneIntegerParamFunction EOF
            {
             before(grammarAccess.getOneIntegerParamFunctionRule()); 
            pushFollow(FOLLOW_1);
            ruleOneIntegerParamFunction();

            state._fsp--;

             after(grammarAccess.getOneIntegerParamFunctionRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleOneIntegerParamFunction"


    // $ANTLR start "ruleOneIntegerParamFunction"
    // InternalOcl.g:862:1: ruleOneIntegerParamFunction : ( ( rule__OneIntegerParamFunction__Group__0 ) ) ;
    public final void ruleOneIntegerParamFunction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:866:2: ( ( ( rule__OneIntegerParamFunction__Group__0 ) ) )
            // InternalOcl.g:867:2: ( ( rule__OneIntegerParamFunction__Group__0 ) )
            {
            // InternalOcl.g:867:2: ( ( rule__OneIntegerParamFunction__Group__0 ) )
            // InternalOcl.g:868:3: ( rule__OneIntegerParamFunction__Group__0 )
            {
             before(grammarAccess.getOneIntegerParamFunctionAccess().getGroup()); 
            // InternalOcl.g:869:3: ( rule__OneIntegerParamFunction__Group__0 )
            // InternalOcl.g:869:4: rule__OneIntegerParamFunction__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__OneIntegerParamFunction__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOneIntegerParamFunctionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOneIntegerParamFunction"


    // $ANTLR start "entryRuleTwoIntegerParamFunction"
    // InternalOcl.g:878:1: entryRuleTwoIntegerParamFunction : ruleTwoIntegerParamFunction EOF ;
    public final void entryRuleTwoIntegerParamFunction() throws RecognitionException {
        try {
            // InternalOcl.g:879:1: ( ruleTwoIntegerParamFunction EOF )
            // InternalOcl.g:880:1: ruleTwoIntegerParamFunction EOF
            {
             before(grammarAccess.getTwoIntegerParamFunctionRule()); 
            pushFollow(FOLLOW_1);
            ruleTwoIntegerParamFunction();

            state._fsp--;

             after(grammarAccess.getTwoIntegerParamFunctionRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleTwoIntegerParamFunction"


    // $ANTLR start "ruleTwoIntegerParamFunction"
    // InternalOcl.g:887:1: ruleTwoIntegerParamFunction : ( ( rule__TwoIntegerParamFunction__Group__0 ) ) ;
    public final void ruleTwoIntegerParamFunction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:891:2: ( ( ( rule__TwoIntegerParamFunction__Group__0 ) ) )
            // InternalOcl.g:892:2: ( ( rule__TwoIntegerParamFunction__Group__0 ) )
            {
            // InternalOcl.g:892:2: ( ( rule__TwoIntegerParamFunction__Group__0 ) )
            // InternalOcl.g:893:3: ( rule__TwoIntegerParamFunction__Group__0 )
            {
             before(grammarAccess.getTwoIntegerParamFunctionAccess().getGroup()); 
            // InternalOcl.g:894:3: ( rule__TwoIntegerParamFunction__Group__0 )
            // InternalOcl.g:894:4: rule__TwoIntegerParamFunction__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TwoIntegerParamFunction__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTwoIntegerParamFunctionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTwoIntegerParamFunction"


    // $ANTLR start "entryRuleCollectionKind"
    // InternalOcl.g:903:1: entryRuleCollectionKind : ruleCollectionKind EOF ;
    public final void entryRuleCollectionKind() throws RecognitionException {
        try {
            // InternalOcl.g:904:1: ( ruleCollectionKind EOF )
            // InternalOcl.g:905:1: ruleCollectionKind EOF
            {
             before(grammarAccess.getCollectionKindRule()); 
            pushFollow(FOLLOW_1);
            ruleCollectionKind();

            state._fsp--;

             after(grammarAccess.getCollectionKindRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleCollectionKind"


    // $ANTLR start "ruleCollectionKind"
    // InternalOcl.g:912:1: ruleCollectionKind : ( ( rule__CollectionKind__NameAssignment ) ) ;
    public final void ruleCollectionKind() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:916:2: ( ( ( rule__CollectionKind__NameAssignment ) ) )
            // InternalOcl.g:917:2: ( ( rule__CollectionKind__NameAssignment ) )
            {
            // InternalOcl.g:917:2: ( ( rule__CollectionKind__NameAssignment ) )
            // InternalOcl.g:918:3: ( rule__CollectionKind__NameAssignment )
            {
             before(grammarAccess.getCollectionKindAccess().getNameAssignment()); 
            // InternalOcl.g:919:3: ( rule__CollectionKind__NameAssignment )
            // InternalOcl.g:919:4: rule__CollectionKind__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__CollectionKind__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getCollectionKindAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCollectionKind"


    // $ANTLR start "entryRuleNavigationOperator"
    // InternalOcl.g:928:1: entryRuleNavigationOperator : ruleNavigationOperator EOF ;
    public final void entryRuleNavigationOperator() throws RecognitionException {
        try {
            // InternalOcl.g:929:1: ( ruleNavigationOperator EOF )
            // InternalOcl.g:930:1: ruleNavigationOperator EOF
            {
             before(grammarAccess.getNavigationOperatorRule()); 
            pushFollow(FOLLOW_1);
            ruleNavigationOperator();

            state._fsp--;

             after(grammarAccess.getNavigationOperatorRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleNavigationOperator"


    // $ANTLR start "ruleNavigationOperator"
    // InternalOcl.g:937:1: ruleNavigationOperator : ( ( rule__NavigationOperator__NameAssignment ) ) ;
    public final void ruleNavigationOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:941:2: ( ( ( rule__NavigationOperator__NameAssignment ) ) )
            // InternalOcl.g:942:2: ( ( rule__NavigationOperator__NameAssignment ) )
            {
            // InternalOcl.g:942:2: ( ( rule__NavigationOperator__NameAssignment ) )
            // InternalOcl.g:943:3: ( rule__NavigationOperator__NameAssignment )
            {
             before(grammarAccess.getNavigationOperatorAccess().getNameAssignment()); 
            // InternalOcl.g:944:3: ( rule__NavigationOperator__NameAssignment )
            // InternalOcl.g:944:4: rule__NavigationOperator__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__NavigationOperator__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getNavigationOperatorAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNavigationOperator"


    // $ANTLR start "entryRuleUnaryOperator"
    // InternalOcl.g:953:1: entryRuleUnaryOperator : ruleUnaryOperator EOF ;
    public final void entryRuleUnaryOperator() throws RecognitionException {
        try {
            // InternalOcl.g:954:1: ( ruleUnaryOperator EOF )
            // InternalOcl.g:955:1: ruleUnaryOperator EOF
            {
             before(grammarAccess.getUnaryOperatorRule()); 
            pushFollow(FOLLOW_1);
            ruleUnaryOperator();

            state._fsp--;

             after(grammarAccess.getUnaryOperatorRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleUnaryOperator"


    // $ANTLR start "ruleUnaryOperator"
    // InternalOcl.g:962:1: ruleUnaryOperator : ( ( rule__UnaryOperator__NameAssignment ) ) ;
    public final void ruleUnaryOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:966:2: ( ( ( rule__UnaryOperator__NameAssignment ) ) )
            // InternalOcl.g:967:2: ( ( rule__UnaryOperator__NameAssignment ) )
            {
            // InternalOcl.g:967:2: ( ( rule__UnaryOperator__NameAssignment ) )
            // InternalOcl.g:968:3: ( rule__UnaryOperator__NameAssignment )
            {
             before(grammarAccess.getUnaryOperatorAccess().getNameAssignment()); 
            // InternalOcl.g:969:3: ( rule__UnaryOperator__NameAssignment )
            // InternalOcl.g:969:4: rule__UnaryOperator__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__UnaryOperator__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getUnaryOperatorAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnaryOperator"


    // $ANTLR start "entryRuleMultiplyOperator"
    // InternalOcl.g:978:1: entryRuleMultiplyOperator : ruleMultiplyOperator EOF ;
    public final void entryRuleMultiplyOperator() throws RecognitionException {
        try {
            // InternalOcl.g:979:1: ( ruleMultiplyOperator EOF )
            // InternalOcl.g:980:1: ruleMultiplyOperator EOF
            {
             before(grammarAccess.getMultiplyOperatorRule()); 
            pushFollow(FOLLOW_1);
            ruleMultiplyOperator();

            state._fsp--;

             after(grammarAccess.getMultiplyOperatorRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleMultiplyOperator"


    // $ANTLR start "ruleMultiplyOperator"
    // InternalOcl.g:987:1: ruleMultiplyOperator : ( ( rule__MultiplyOperator__NameAssignment ) ) ;
    public final void ruleMultiplyOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:991:2: ( ( ( rule__MultiplyOperator__NameAssignment ) ) )
            // InternalOcl.g:992:2: ( ( rule__MultiplyOperator__NameAssignment ) )
            {
            // InternalOcl.g:992:2: ( ( rule__MultiplyOperator__NameAssignment ) )
            // InternalOcl.g:993:3: ( rule__MultiplyOperator__NameAssignment )
            {
             before(grammarAccess.getMultiplyOperatorAccess().getNameAssignment()); 
            // InternalOcl.g:994:3: ( rule__MultiplyOperator__NameAssignment )
            // InternalOcl.g:994:4: rule__MultiplyOperator__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__MultiplyOperator__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getMultiplyOperatorAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMultiplyOperator"


    // $ANTLR start "entryRuleAddOperator"
    // InternalOcl.g:1003:1: entryRuleAddOperator : ruleAddOperator EOF ;
    public final void entryRuleAddOperator() throws RecognitionException {
        try {
            // InternalOcl.g:1004:1: ( ruleAddOperator EOF )
            // InternalOcl.g:1005:1: ruleAddOperator EOF
            {
             before(grammarAccess.getAddOperatorRule()); 
            pushFollow(FOLLOW_1);
            ruleAddOperator();

            state._fsp--;

             after(grammarAccess.getAddOperatorRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleAddOperator"


    // $ANTLR start "ruleAddOperator"
    // InternalOcl.g:1012:1: ruleAddOperator : ( ( rule__AddOperator__NameAssignment ) ) ;
    public final void ruleAddOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1016:2: ( ( ( rule__AddOperator__NameAssignment ) ) )
            // InternalOcl.g:1017:2: ( ( rule__AddOperator__NameAssignment ) )
            {
            // InternalOcl.g:1017:2: ( ( rule__AddOperator__NameAssignment ) )
            // InternalOcl.g:1018:3: ( rule__AddOperator__NameAssignment )
            {
             before(grammarAccess.getAddOperatorAccess().getNameAssignment()); 
            // InternalOcl.g:1019:3: ( rule__AddOperator__NameAssignment )
            // InternalOcl.g:1019:4: rule__AddOperator__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__AddOperator__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getAddOperatorAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAddOperator"


    // $ANTLR start "entryRuleRelationalOperator"
    // InternalOcl.g:1028:1: entryRuleRelationalOperator : ruleRelationalOperator EOF ;
    public final void entryRuleRelationalOperator() throws RecognitionException {
        try {
            // InternalOcl.g:1029:1: ( ruleRelationalOperator EOF )
            // InternalOcl.g:1030:1: ruleRelationalOperator EOF
            {
             before(grammarAccess.getRelationalOperatorRule()); 
            pushFollow(FOLLOW_1);
            ruleRelationalOperator();

            state._fsp--;

             after(grammarAccess.getRelationalOperatorRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleRelationalOperator"


    // $ANTLR start "ruleRelationalOperator"
    // InternalOcl.g:1037:1: ruleRelationalOperator : ( ( rule__RelationalOperator__NameAssignment ) ) ;
    public final void ruleRelationalOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1041:2: ( ( ( rule__RelationalOperator__NameAssignment ) ) )
            // InternalOcl.g:1042:2: ( ( rule__RelationalOperator__NameAssignment ) )
            {
            // InternalOcl.g:1042:2: ( ( rule__RelationalOperator__NameAssignment ) )
            // InternalOcl.g:1043:3: ( rule__RelationalOperator__NameAssignment )
            {
             before(grammarAccess.getRelationalOperatorAccess().getNameAssignment()); 
            // InternalOcl.g:1044:3: ( rule__RelationalOperator__NameAssignment )
            // InternalOcl.g:1044:4: rule__RelationalOperator__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__RelationalOperator__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getRelationalOperatorAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRelationalOperator"


    // $ANTLR start "entryRuleLogicalOperator"
    // InternalOcl.g:1053:1: entryRuleLogicalOperator : ruleLogicalOperator EOF ;
    public final void entryRuleLogicalOperator() throws RecognitionException {
        try {
            // InternalOcl.g:1054:1: ( ruleLogicalOperator EOF )
            // InternalOcl.g:1055:1: ruleLogicalOperator EOF
            {
             before(grammarAccess.getLogicalOperatorRule()); 
            pushFollow(FOLLOW_1);
            ruleLogicalOperator();

            state._fsp--;

             after(grammarAccess.getLogicalOperatorRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleLogicalOperator"


    // $ANTLR start "ruleLogicalOperator"
    // InternalOcl.g:1062:1: ruleLogicalOperator : ( ( rule__LogicalOperator__NameAssignment ) ) ;
    public final void ruleLogicalOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1066:2: ( ( ( rule__LogicalOperator__NameAssignment ) ) )
            // InternalOcl.g:1067:2: ( ( rule__LogicalOperator__NameAssignment ) )
            {
            // InternalOcl.g:1067:2: ( ( rule__LogicalOperator__NameAssignment ) )
            // InternalOcl.g:1068:3: ( rule__LogicalOperator__NameAssignment )
            {
             before(grammarAccess.getLogicalOperatorAccess().getNameAssignment()); 
            // InternalOcl.g:1069:3: ( rule__LogicalOperator__NameAssignment )
            // InternalOcl.g:1069:4: rule__LogicalOperator__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__LogicalOperator__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getLogicalOperatorAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLogicalOperator"


    // $ANTLR start "rule__Start__Alternatives"
    // InternalOcl.g:1077:1: rule__Start__Alternatives : ( ( ( ruleExpression )? ) | ( ruleContextExpression ) );
    public final void rule__Start__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1081:1: ( ( ( ruleExpression )? ) | ( ruleContextExpression ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==EOF||LA2_0==RULE_TYPENAME_TERMINAL||(LA2_0>=RULE_STRING && LA2_0<=RULE_NAME_TERMINAL)||(LA2_0>=24 && LA2_0<=63)||(LA2_0>=66 && LA2_0<=67)||LA2_0==82||LA2_0==84||LA2_0==88||LA2_0==99) ) {
                alt2=1;
            }
            else if ( (LA2_0==81) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalOcl.g:1082:2: ( ( ruleExpression )? )
                    {
                    // InternalOcl.g:1082:2: ( ( ruleExpression )? )
                    // InternalOcl.g:1083:3: ( ruleExpression )?
                    {
                     before(grammarAccess.getStartAccess().getExpressionParserRuleCall_0()); 
                    // InternalOcl.g:1084:3: ( ruleExpression )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==RULE_TYPENAME_TERMINAL||(LA1_0>=RULE_STRING && LA1_0<=RULE_NAME_TERMINAL)||(LA1_0>=24 && LA1_0<=63)||(LA1_0>=66 && LA1_0<=67)||LA1_0==82||LA1_0==84||LA1_0==88||LA1_0==99) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // InternalOcl.g:1084:4: ruleExpression
                            {
                            pushFollow(FOLLOW_2);
                            ruleExpression();

                            state._fsp--;


                            }
                            break;

                    }

                     after(grammarAccess.getStartAccess().getExpressionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOcl.g:1088:2: ( ruleContextExpression )
                    {
                    // InternalOcl.g:1088:2: ( ruleContextExpression )
                    // InternalOcl.g:1089:3: ruleContextExpression
                    {
                     before(grammarAccess.getStartAccess().getContextExpressionParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleContextExpression();

                    state._fsp--;

                     after(grammarAccess.getStartAccess().getContextExpressionParserRuleCall_1()); 

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
    // $ANTLR end "rule__Start__Alternatives"


    // $ANTLR start "rule__ContextExpression__Alternatives_2"
    // InternalOcl.g:1098:1: rule__ContextExpression__Alternatives_2 : ( ( 'inv:' ) | ( 'pre:' ) | ( 'post:' ) );
    public final void rule__ContextExpression__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1102:1: ( ( 'inv:' ) | ( 'pre:' ) | ( 'post:' ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt3=1;
                }
                break;
            case 22:
                {
                alt3=2;
                }
                break;
            case 23:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalOcl.g:1103:2: ( 'inv:' )
                    {
                    // InternalOcl.g:1103:2: ( 'inv:' )
                    // InternalOcl.g:1104:3: 'inv:'
                    {
                     before(grammarAccess.getContextExpressionAccess().getInvKeyword_2_0()); 
                    match(input,21,FOLLOW_2); 
                     after(grammarAccess.getContextExpressionAccess().getInvKeyword_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOcl.g:1109:2: ( 'pre:' )
                    {
                    // InternalOcl.g:1109:2: ( 'pre:' )
                    // InternalOcl.g:1110:3: 'pre:'
                    {
                     before(grammarAccess.getContextExpressionAccess().getPreKeyword_2_1()); 
                    match(input,22,FOLLOW_2); 
                     after(grammarAccess.getContextExpressionAccess().getPreKeyword_2_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOcl.g:1115:2: ( 'post:' )
                    {
                    // InternalOcl.g:1115:2: ( 'post:' )
                    // InternalOcl.g:1116:3: 'post:'
                    {
                     before(grammarAccess.getContextExpressionAccess().getPostKeyword_2_2()); 
                    match(input,23,FOLLOW_2); 
                     after(grammarAccess.getContextExpressionAccess().getPostKeyword_2_2()); 

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
    // $ANTLR end "rule__ContextExpression__Alternatives_2"


    // $ANTLR start "rule__PrimaryExpression__Alternatives"
    // InternalOcl.g:1125:1: rule__PrimaryExpression__Alternatives : ( ( ruleLiteralCollection ) | ( ruleLiteral ) | ( ruleFeatureCall ) | ( ( rule__PrimaryExpression__Group_3__0 ) ) | ( ruleIfExpression ) );
    public final void rule__PrimaryExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1129:1: ( ( ruleLiteralCollection ) | ( ruleLiteral ) | ( ruleFeatureCall ) | ( ( rule__PrimaryExpression__Group_3__0 ) ) | ( ruleIfExpression ) )
            int alt4=5;
            switch ( input.LA(1) ) {
            case 60:
            case 61:
            case 62:
            case 63:
                {
                alt4=1;
                }
                break;
            case RULE_STRING:
            case RULE_NUMBER:
            case 88:
                {
                alt4=2;
                }
                break;
            case RULE_TYPENAME_TERMINAL:
            case RULE_NAME_TERMINAL:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 99:
                {
                alt4=3;
                }
                break;
            case 82:
                {
                alt4=4;
                }
                break;
            case 84:
                {
                alt4=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalOcl.g:1130:2: ( ruleLiteralCollection )
                    {
                    // InternalOcl.g:1130:2: ( ruleLiteralCollection )
                    // InternalOcl.g:1131:3: ruleLiteralCollection
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getLiteralCollectionParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleLiteralCollection();

                    state._fsp--;

                     after(grammarAccess.getPrimaryExpressionAccess().getLiteralCollectionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOcl.g:1136:2: ( ruleLiteral )
                    {
                    // InternalOcl.g:1136:2: ( ruleLiteral )
                    // InternalOcl.g:1137:3: ruleLiteral
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getLiteralParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleLiteral();

                    state._fsp--;

                     after(grammarAccess.getPrimaryExpressionAccess().getLiteralParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOcl.g:1142:2: ( ruleFeatureCall )
                    {
                    // InternalOcl.g:1142:2: ( ruleFeatureCall )
                    // InternalOcl.g:1143:3: ruleFeatureCall
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getFeatureCallParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleFeatureCall();

                    state._fsp--;

                     after(grammarAccess.getPrimaryExpressionAccess().getFeatureCallParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalOcl.g:1148:2: ( ( rule__PrimaryExpression__Group_3__0 ) )
                    {
                    // InternalOcl.g:1148:2: ( ( rule__PrimaryExpression__Group_3__0 ) )
                    // InternalOcl.g:1149:3: ( rule__PrimaryExpression__Group_3__0 )
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getGroup_3()); 
                    // InternalOcl.g:1150:3: ( rule__PrimaryExpression__Group_3__0 )
                    // InternalOcl.g:1150:4: rule__PrimaryExpression__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrimaryExpression__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimaryExpressionAccess().getGroup_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalOcl.g:1154:2: ( ruleIfExpression )
                    {
                    // InternalOcl.g:1154:2: ( ruleIfExpression )
                    // InternalOcl.g:1155:3: ruleIfExpression
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getIfExpressionParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleIfExpression();

                    state._fsp--;

                     after(grammarAccess.getPrimaryExpressionAccess().getIfExpressionParserRuleCall_4()); 

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
    // $ANTLR end "rule__PrimaryExpression__Alternatives"


    // $ANTLR start "rule__Literal__Alternatives"
    // InternalOcl.g:1164:1: rule__Literal__Alternatives : ( ( ( rule__Literal__NameAssignment_0 ) ) | ( ( rule__Literal__NameAssignment_1 ) ) | ( ( rule__Literal__Group_2__0 ) ) );
    public final void rule__Literal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1168:1: ( ( ( rule__Literal__NameAssignment_0 ) ) | ( ( rule__Literal__NameAssignment_1 ) ) | ( ( rule__Literal__Group_2__0 ) ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt5=1;
                }
                break;
            case RULE_NUMBER:
                {
                alt5=2;
                }
                break;
            case 88:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalOcl.g:1169:2: ( ( rule__Literal__NameAssignment_0 ) )
                    {
                    // InternalOcl.g:1169:2: ( ( rule__Literal__NameAssignment_0 ) )
                    // InternalOcl.g:1170:3: ( rule__Literal__NameAssignment_0 )
                    {
                     before(grammarAccess.getLiteralAccess().getNameAssignment_0()); 
                    // InternalOcl.g:1171:3: ( rule__Literal__NameAssignment_0 )
                    // InternalOcl.g:1171:4: rule__Literal__NameAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Literal__NameAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getLiteralAccess().getNameAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOcl.g:1175:2: ( ( rule__Literal__NameAssignment_1 ) )
                    {
                    // InternalOcl.g:1175:2: ( ( rule__Literal__NameAssignment_1 ) )
                    // InternalOcl.g:1176:3: ( rule__Literal__NameAssignment_1 )
                    {
                     before(grammarAccess.getLiteralAccess().getNameAssignment_1()); 
                    // InternalOcl.g:1177:3: ( rule__Literal__NameAssignment_1 )
                    // InternalOcl.g:1177:4: rule__Literal__NameAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Literal__NameAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getLiteralAccess().getNameAssignment_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOcl.g:1181:2: ( ( rule__Literal__Group_2__0 ) )
                    {
                    // InternalOcl.g:1181:2: ( ( rule__Literal__Group_2__0 ) )
                    // InternalOcl.g:1182:3: ( rule__Literal__Group_2__0 )
                    {
                     before(grammarAccess.getLiteralAccess().getGroup_2()); 
                    // InternalOcl.g:1183:3: ( rule__Literal__Group_2__0 )
                    // InternalOcl.g:1183:4: rule__Literal__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Literal__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getLiteralAccess().getGroup_2()); 

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
    // $ANTLR end "rule__Literal__Alternatives"


    // $ANTLR start "rule__SimpleTypeSpecifier__Alternatives"
    // InternalOcl.g:1191:1: rule__SimpleTypeSpecifier__Alternatives : ( ( rulePathTypeName ) | ( ruleEnumerationType ) );
    public final void rule__SimpleTypeSpecifier__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1195:1: ( ( rulePathTypeName ) | ( ruleEnumerationType ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_TYPENAME_TERMINAL) ) {
                alt6=1;
            }
            else if ( (LA6_0==89) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalOcl.g:1196:2: ( rulePathTypeName )
                    {
                    // InternalOcl.g:1196:2: ( rulePathTypeName )
                    // InternalOcl.g:1197:3: rulePathTypeName
                    {
                     before(grammarAccess.getSimpleTypeSpecifierAccess().getPathTypeNameParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    rulePathTypeName();

                    state._fsp--;

                     after(grammarAccess.getSimpleTypeSpecifierAccess().getPathTypeNameParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOcl.g:1202:2: ( ruleEnumerationType )
                    {
                    // InternalOcl.g:1202:2: ( ruleEnumerationType )
                    // InternalOcl.g:1203:3: ruleEnumerationType
                    {
                     before(grammarAccess.getSimpleTypeSpecifierAccess().getEnumerationTypeParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleEnumerationType();

                    state._fsp--;

                     after(grammarAccess.getSimpleTypeSpecifierAccess().getEnumerationTypeParserRuleCall_1()); 

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
    // $ANTLR end "rule__SimpleTypeSpecifier__Alternatives"


    // $ANTLR start "rule__ExpressionListOrRange__Alternatives_1"
    // InternalOcl.g:1212:1: rule__ExpressionListOrRange__Alternatives_1 : ( ( ( ( rule__ExpressionListOrRange__Group_1_0__0 ) ) ( ( rule__ExpressionListOrRange__Group_1_0__0 )* ) ) | ( ( rule__ExpressionListOrRange__Group_1_1__0 ) ) );
    public final void rule__ExpressionListOrRange__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1216:1: ( ( ( ( rule__ExpressionListOrRange__Group_1_0__0 ) ) ( ( rule__ExpressionListOrRange__Group_1_0__0 )* ) ) | ( ( rule__ExpressionListOrRange__Group_1_1__0 ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==92) ) {
                alt8=1;
            }
            else if ( (LA8_0==93) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalOcl.g:1217:2: ( ( ( rule__ExpressionListOrRange__Group_1_0__0 ) ) ( ( rule__ExpressionListOrRange__Group_1_0__0 )* ) )
                    {
                    // InternalOcl.g:1217:2: ( ( ( rule__ExpressionListOrRange__Group_1_0__0 ) ) ( ( rule__ExpressionListOrRange__Group_1_0__0 )* ) )
                    // InternalOcl.g:1218:3: ( ( rule__ExpressionListOrRange__Group_1_0__0 ) ) ( ( rule__ExpressionListOrRange__Group_1_0__0 )* )
                    {
                    // InternalOcl.g:1218:3: ( ( rule__ExpressionListOrRange__Group_1_0__0 ) )
                    // InternalOcl.g:1219:4: ( rule__ExpressionListOrRange__Group_1_0__0 )
                    {
                     before(grammarAccess.getExpressionListOrRangeAccess().getGroup_1_0()); 
                    // InternalOcl.g:1220:4: ( rule__ExpressionListOrRange__Group_1_0__0 )
                    // InternalOcl.g:1220:5: rule__ExpressionListOrRange__Group_1_0__0
                    {
                    pushFollow(FOLLOW_3);
                    rule__ExpressionListOrRange__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getExpressionListOrRangeAccess().getGroup_1_0()); 

                    }

                    // InternalOcl.g:1223:3: ( ( rule__ExpressionListOrRange__Group_1_0__0 )* )
                    // InternalOcl.g:1224:4: ( rule__ExpressionListOrRange__Group_1_0__0 )*
                    {
                     before(grammarAccess.getExpressionListOrRangeAccess().getGroup_1_0()); 
                    // InternalOcl.g:1225:4: ( rule__ExpressionListOrRange__Group_1_0__0 )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==92) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalOcl.g:1225:5: rule__ExpressionListOrRange__Group_1_0__0
                    	    {
                    	    pushFollow(FOLLOW_3);
                    	    rule__ExpressionListOrRange__Group_1_0__0();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                     after(grammarAccess.getExpressionListOrRangeAccess().getGroup_1_0()); 

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalOcl.g:1230:2: ( ( rule__ExpressionListOrRange__Group_1_1__0 ) )
                    {
                    // InternalOcl.g:1230:2: ( ( rule__ExpressionListOrRange__Group_1_1__0 ) )
                    // InternalOcl.g:1231:3: ( rule__ExpressionListOrRange__Group_1_1__0 )
                    {
                     before(grammarAccess.getExpressionListOrRangeAccess().getGroup_1_1()); 
                    // InternalOcl.g:1232:3: ( rule__ExpressionListOrRange__Group_1_1__0 )
                    // InternalOcl.g:1232:4: rule__ExpressionListOrRange__Group_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ExpressionListOrRange__Group_1_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getExpressionListOrRangeAccess().getGroup_1_1()); 

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
    // $ANTLR end "rule__ExpressionListOrRange__Alternatives_1"


    // $ANTLR start "rule__PathName__LeftAlternatives_0_0"
    // InternalOcl.g:1240:1: rule__PathName__LeftAlternatives_0_0 : ( ( ruleTypeName ) | ( ruleName ) );
    public final void rule__PathName__LeftAlternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1244:1: ( ( ruleTypeName ) | ( ruleName ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_TYPENAME_TERMINAL) ) {
                alt9=1;
            }
            else if ( (LA9_0==RULE_NAME_TERMINAL||(LA9_0>=24 && LA9_0<=59)||LA9_0==99) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalOcl.g:1245:2: ( ruleTypeName )
                    {
                    // InternalOcl.g:1245:2: ( ruleTypeName )
                    // InternalOcl.g:1246:3: ruleTypeName
                    {
                     before(grammarAccess.getPathNameAccess().getLeftTypeNameParserRuleCall_0_0_0()); 
                    pushFollow(FOLLOW_2);
                    ruleTypeName();

                    state._fsp--;

                     after(grammarAccess.getPathNameAccess().getLeftTypeNameParserRuleCall_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOcl.g:1251:2: ( ruleName )
                    {
                    // InternalOcl.g:1251:2: ( ruleName )
                    // InternalOcl.g:1252:3: ruleName
                    {
                     before(grammarAccess.getPathNameAccess().getLeftNameParserRuleCall_0_0_1()); 
                    pushFollow(FOLLOW_2);
                    ruleName();

                    state._fsp--;

                     after(grammarAccess.getPathNameAccess().getLeftNameParserRuleCall_0_0_1()); 

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
    // $ANTLR end "rule__PathName__LeftAlternatives_0_0"


    // $ANTLR start "rule__PathName__RightsAlternatives_1_1_0"
    // InternalOcl.g:1261:1: rule__PathName__RightsAlternatives_1_1_0 : ( ( ruleTypeName ) | ( ruleName ) );
    public final void rule__PathName__RightsAlternatives_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1265:1: ( ( ruleTypeName ) | ( ruleName ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_TYPENAME_TERMINAL) ) {
                alt10=1;
            }
            else if ( (LA10_0==RULE_NAME_TERMINAL||(LA10_0>=24 && LA10_0<=59)||LA10_0==99) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalOcl.g:1266:2: ( ruleTypeName )
                    {
                    // InternalOcl.g:1266:2: ( ruleTypeName )
                    // InternalOcl.g:1267:3: ruleTypeName
                    {
                     before(grammarAccess.getPathNameAccess().getRightsTypeNameParserRuleCall_1_1_0_0()); 
                    pushFollow(FOLLOW_2);
                    ruleTypeName();

                    state._fsp--;

                     after(grammarAccess.getPathNameAccess().getRightsTypeNameParserRuleCall_1_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOcl.g:1272:2: ( ruleName )
                    {
                    // InternalOcl.g:1272:2: ( ruleName )
                    // InternalOcl.g:1273:3: ruleName
                    {
                     before(grammarAccess.getPathNameAccess().getRightsNameParserRuleCall_1_1_0_1()); 
                    pushFollow(FOLLOW_2);
                    ruleName();

                    state._fsp--;

                     after(grammarAccess.getPathNameAccess().getRightsNameParserRuleCall_1_1_0_1()); 

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
    // $ANTLR end "rule__PathName__RightsAlternatives_1_1_0"


    // $ANTLR start "rule__Name__Alternatives"
    // InternalOcl.g:1282:1: rule__Name__Alternatives : ( ( ruleAttribute ) | ( ruleFunction ) );
    public final void rule__Name__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1286:1: ( ( ruleAttribute ) | ( ruleFunction ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_NAME_TERMINAL) ) {
                alt11=1;
            }
            else if ( ((LA11_0>=24 && LA11_0<=59)||LA11_0==99) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalOcl.g:1287:2: ( ruleAttribute )
                    {
                    // InternalOcl.g:1287:2: ( ruleAttribute )
                    // InternalOcl.g:1288:3: ruleAttribute
                    {
                     before(grammarAccess.getNameAccess().getAttributeParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleAttribute();

                    state._fsp--;

                     after(grammarAccess.getNameAccess().getAttributeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOcl.g:1293:2: ( ruleFunction )
                    {
                    // InternalOcl.g:1293:2: ( ruleFunction )
                    // InternalOcl.g:1294:3: ruleFunction
                    {
                     before(grammarAccess.getNameAccess().getFunctionParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleFunction();

                    state._fsp--;

                     after(grammarAccess.getNameAccess().getFunctionParserRuleCall_1()); 

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
    // $ANTLR end "rule__Name__Alternatives"


    // $ANTLR start "rule__Function__Alternatives"
    // InternalOcl.g:1303:1: rule__Function__Alternatives : ( ( ruleNoParamFunction ) | ( ruleOneTypeParamFunction ) | ( ruleOneStringParamFunction ) | ( ruleTwoStringParamFunction ) | ( ruleTwoIntegerParamFunction ) | ( ruleOneIntegerParamFunction ) );
    public final void rule__Function__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1307:1: ( ( ruleNoParamFunction ) | ( ruleOneTypeParamFunction ) | ( ruleOneStringParamFunction ) | ( ruleTwoStringParamFunction ) | ( ruleTwoIntegerParamFunction ) | ( ruleOneIntegerParamFunction ) )
            int alt12=6;
            switch ( input.LA(1) ) {
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
                {
                alt12=1;
                }
                break;
            case 47:
            case 48:
                {
                alt12=2;
                }
                break;
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
                {
                alt12=3;
                }
                break;
            case 55:
            case 56:
                {
                alt12=4;
                }
                break;
            case 57:
            case 58:
            case 59:
                {
                alt12=5;
                }
                break;
            case 99:
                {
                alt12=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalOcl.g:1308:2: ( ruleNoParamFunction )
                    {
                    // InternalOcl.g:1308:2: ( ruleNoParamFunction )
                    // InternalOcl.g:1309:3: ruleNoParamFunction
                    {
                     before(grammarAccess.getFunctionAccess().getNoParamFunctionParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleNoParamFunction();

                    state._fsp--;

                     after(grammarAccess.getFunctionAccess().getNoParamFunctionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOcl.g:1314:2: ( ruleOneTypeParamFunction )
                    {
                    // InternalOcl.g:1314:2: ( ruleOneTypeParamFunction )
                    // InternalOcl.g:1315:3: ruleOneTypeParamFunction
                    {
                     before(grammarAccess.getFunctionAccess().getOneTypeParamFunctionParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleOneTypeParamFunction();

                    state._fsp--;

                     after(grammarAccess.getFunctionAccess().getOneTypeParamFunctionParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOcl.g:1320:2: ( ruleOneStringParamFunction )
                    {
                    // InternalOcl.g:1320:2: ( ruleOneStringParamFunction )
                    // InternalOcl.g:1321:3: ruleOneStringParamFunction
                    {
                     before(grammarAccess.getFunctionAccess().getOneStringParamFunctionParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleOneStringParamFunction();

                    state._fsp--;

                     after(grammarAccess.getFunctionAccess().getOneStringParamFunctionParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalOcl.g:1326:2: ( ruleTwoStringParamFunction )
                    {
                    // InternalOcl.g:1326:2: ( ruleTwoStringParamFunction )
                    // InternalOcl.g:1327:3: ruleTwoStringParamFunction
                    {
                     before(grammarAccess.getFunctionAccess().getTwoStringParamFunctionParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleTwoStringParamFunction();

                    state._fsp--;

                     after(grammarAccess.getFunctionAccess().getTwoStringParamFunctionParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalOcl.g:1332:2: ( ruleTwoIntegerParamFunction )
                    {
                    // InternalOcl.g:1332:2: ( ruleTwoIntegerParamFunction )
                    // InternalOcl.g:1333:3: ruleTwoIntegerParamFunction
                    {
                     before(grammarAccess.getFunctionAccess().getTwoIntegerParamFunctionParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleTwoIntegerParamFunction();

                    state._fsp--;

                     after(grammarAccess.getFunctionAccess().getTwoIntegerParamFunctionParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalOcl.g:1338:2: ( ruleOneIntegerParamFunction )
                    {
                    // InternalOcl.g:1338:2: ( ruleOneIntegerParamFunction )
                    // InternalOcl.g:1339:3: ruleOneIntegerParamFunction
                    {
                     before(grammarAccess.getFunctionAccess().getOneIntegerParamFunctionParserRuleCall_5()); 
                    pushFollow(FOLLOW_2);
                    ruleOneIntegerParamFunction();

                    state._fsp--;

                     after(grammarAccess.getFunctionAccess().getOneIntegerParamFunctionParserRuleCall_5()); 

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
    // $ANTLR end "rule__Function__Alternatives"


    // $ANTLR start "rule__NoParamFunction__NameAlternatives_0_0"
    // InternalOcl.g:1348:1: rule__NoParamFunction__NameAlternatives_0_0 : ( ( 'allInstaces' ) | ( 'oclType' ) | ( 'toString' ) | ( 'refImmediateComposite' ) | ( 'size' ) | ( 'toInteger' ) | ( 'toUpper' ) | ( 'toReal' ) | ( 'toLower' ) | ( 'toSequence' ) | ( 'trim' ) | ( 'isEmpty' ) | ( 'oclIsUndefined' ) | ( 'floor' ) | ( 'round' ) | ( 'notEmpty' ) | ( 'asBag' ) | ( 'asSequence' ) | ( 'sum' ) | ( 'asSet' ) | ( 'flatten' ) | ( 'first' ) | ( 'last' ) );
    public final void rule__NoParamFunction__NameAlternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1352:1: ( ( 'allInstaces' ) | ( 'oclType' ) | ( 'toString' ) | ( 'refImmediateComposite' ) | ( 'size' ) | ( 'toInteger' ) | ( 'toUpper' ) | ( 'toReal' ) | ( 'toLower' ) | ( 'toSequence' ) | ( 'trim' ) | ( 'isEmpty' ) | ( 'oclIsUndefined' ) | ( 'floor' ) | ( 'round' ) | ( 'notEmpty' ) | ( 'asBag' ) | ( 'asSequence' ) | ( 'sum' ) | ( 'asSet' ) | ( 'flatten' ) | ( 'first' ) | ( 'last' ) )
            int alt13=23;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt13=1;
                }
                break;
            case 25:
                {
                alt13=2;
                }
                break;
            case 26:
                {
                alt13=3;
                }
                break;
            case 27:
                {
                alt13=4;
                }
                break;
            case 28:
                {
                alt13=5;
                }
                break;
            case 29:
                {
                alt13=6;
                }
                break;
            case 30:
                {
                alt13=7;
                }
                break;
            case 31:
                {
                alt13=8;
                }
                break;
            case 32:
                {
                alt13=9;
                }
                break;
            case 33:
                {
                alt13=10;
                }
                break;
            case 34:
                {
                alt13=11;
                }
                break;
            case 35:
                {
                alt13=12;
                }
                break;
            case 36:
                {
                alt13=13;
                }
                break;
            case 37:
                {
                alt13=14;
                }
                break;
            case 38:
                {
                alt13=15;
                }
                break;
            case 39:
                {
                alt13=16;
                }
                break;
            case 40:
                {
                alt13=17;
                }
                break;
            case 41:
                {
                alt13=18;
                }
                break;
            case 42:
                {
                alt13=19;
                }
                break;
            case 43:
                {
                alt13=20;
                }
                break;
            case 44:
                {
                alt13=21;
                }
                break;
            case 45:
                {
                alt13=22;
                }
                break;
            case 46:
                {
                alt13=23;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalOcl.g:1353:2: ( 'allInstaces' )
                    {
                    // InternalOcl.g:1353:2: ( 'allInstaces' )
                    // InternalOcl.g:1354:3: 'allInstaces'
                    {
                     before(grammarAccess.getNoParamFunctionAccess().getNameAllInstacesKeyword_0_0_0()); 
                    match(input,24,FOLLOW_2); 
                     after(grammarAccess.getNoParamFunctionAccess().getNameAllInstacesKeyword_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOcl.g:1359:2: ( 'oclType' )
                    {
                    // InternalOcl.g:1359:2: ( 'oclType' )
                    // InternalOcl.g:1360:3: 'oclType'
                    {
                     before(grammarAccess.getNoParamFunctionAccess().getNameOclTypeKeyword_0_0_1()); 
                    match(input,25,FOLLOW_2); 
                     after(grammarAccess.getNoParamFunctionAccess().getNameOclTypeKeyword_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOcl.g:1365:2: ( 'toString' )
                    {
                    // InternalOcl.g:1365:2: ( 'toString' )
                    // InternalOcl.g:1366:3: 'toString'
                    {
                     before(grammarAccess.getNoParamFunctionAccess().getNameToStringKeyword_0_0_2()); 
                    match(input,26,FOLLOW_2); 
                     after(grammarAccess.getNoParamFunctionAccess().getNameToStringKeyword_0_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalOcl.g:1371:2: ( 'refImmediateComposite' )
                    {
                    // InternalOcl.g:1371:2: ( 'refImmediateComposite' )
                    // InternalOcl.g:1372:3: 'refImmediateComposite'
                    {
                     before(grammarAccess.getNoParamFunctionAccess().getNameRefImmediateCompositeKeyword_0_0_3()); 
                    match(input,27,FOLLOW_2); 
                     after(grammarAccess.getNoParamFunctionAccess().getNameRefImmediateCompositeKeyword_0_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalOcl.g:1377:2: ( 'size' )
                    {
                    // InternalOcl.g:1377:2: ( 'size' )
                    // InternalOcl.g:1378:3: 'size'
                    {
                     before(grammarAccess.getNoParamFunctionAccess().getNameSizeKeyword_0_0_4()); 
                    match(input,28,FOLLOW_2); 
                     after(grammarAccess.getNoParamFunctionAccess().getNameSizeKeyword_0_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalOcl.g:1383:2: ( 'toInteger' )
                    {
                    // InternalOcl.g:1383:2: ( 'toInteger' )
                    // InternalOcl.g:1384:3: 'toInteger'
                    {
                     before(grammarAccess.getNoParamFunctionAccess().getNameToIntegerKeyword_0_0_5()); 
                    match(input,29,FOLLOW_2); 
                     after(grammarAccess.getNoParamFunctionAccess().getNameToIntegerKeyword_0_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalOcl.g:1389:2: ( 'toUpper' )
                    {
                    // InternalOcl.g:1389:2: ( 'toUpper' )
                    // InternalOcl.g:1390:3: 'toUpper'
                    {
                     before(grammarAccess.getNoParamFunctionAccess().getNameToUpperKeyword_0_0_6()); 
                    match(input,30,FOLLOW_2); 
                     after(grammarAccess.getNoParamFunctionAccess().getNameToUpperKeyword_0_0_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalOcl.g:1395:2: ( 'toReal' )
                    {
                    // InternalOcl.g:1395:2: ( 'toReal' )
                    // InternalOcl.g:1396:3: 'toReal'
                    {
                     before(grammarAccess.getNoParamFunctionAccess().getNameToRealKeyword_0_0_7()); 
                    match(input,31,FOLLOW_2); 
                     after(grammarAccess.getNoParamFunctionAccess().getNameToRealKeyword_0_0_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalOcl.g:1401:2: ( 'toLower' )
                    {
                    // InternalOcl.g:1401:2: ( 'toLower' )
                    // InternalOcl.g:1402:3: 'toLower'
                    {
                     before(grammarAccess.getNoParamFunctionAccess().getNameToLowerKeyword_0_0_8()); 
                    match(input,32,FOLLOW_2); 
                     after(grammarAccess.getNoParamFunctionAccess().getNameToLowerKeyword_0_0_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalOcl.g:1407:2: ( 'toSequence' )
                    {
                    // InternalOcl.g:1407:2: ( 'toSequence' )
                    // InternalOcl.g:1408:3: 'toSequence'
                    {
                     before(grammarAccess.getNoParamFunctionAccess().getNameToSequenceKeyword_0_0_9()); 
                    match(input,33,FOLLOW_2); 
                     after(grammarAccess.getNoParamFunctionAccess().getNameToSequenceKeyword_0_0_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalOcl.g:1413:2: ( 'trim' )
                    {
                    // InternalOcl.g:1413:2: ( 'trim' )
                    // InternalOcl.g:1414:3: 'trim'
                    {
                     before(grammarAccess.getNoParamFunctionAccess().getNameTrimKeyword_0_0_10()); 
                    match(input,34,FOLLOW_2); 
                     after(grammarAccess.getNoParamFunctionAccess().getNameTrimKeyword_0_0_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalOcl.g:1419:2: ( 'isEmpty' )
                    {
                    // InternalOcl.g:1419:2: ( 'isEmpty' )
                    // InternalOcl.g:1420:3: 'isEmpty'
                    {
                     before(grammarAccess.getNoParamFunctionAccess().getNameIsEmptyKeyword_0_0_11()); 
                    match(input,35,FOLLOW_2); 
                     after(grammarAccess.getNoParamFunctionAccess().getNameIsEmptyKeyword_0_0_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalOcl.g:1425:2: ( 'oclIsUndefined' )
                    {
                    // InternalOcl.g:1425:2: ( 'oclIsUndefined' )
                    // InternalOcl.g:1426:3: 'oclIsUndefined'
                    {
                     before(grammarAccess.getNoParamFunctionAccess().getNameOclIsUndefinedKeyword_0_0_12()); 
                    match(input,36,FOLLOW_2); 
                     after(grammarAccess.getNoParamFunctionAccess().getNameOclIsUndefinedKeyword_0_0_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalOcl.g:1431:2: ( 'floor' )
                    {
                    // InternalOcl.g:1431:2: ( 'floor' )
                    // InternalOcl.g:1432:3: 'floor'
                    {
                     before(grammarAccess.getNoParamFunctionAccess().getNameFloorKeyword_0_0_13()); 
                    match(input,37,FOLLOW_2); 
                     after(grammarAccess.getNoParamFunctionAccess().getNameFloorKeyword_0_0_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalOcl.g:1437:2: ( 'round' )
                    {
                    // InternalOcl.g:1437:2: ( 'round' )
                    // InternalOcl.g:1438:3: 'round'
                    {
                     before(grammarAccess.getNoParamFunctionAccess().getNameRoundKeyword_0_0_14()); 
                    match(input,38,FOLLOW_2); 
                     after(grammarAccess.getNoParamFunctionAccess().getNameRoundKeyword_0_0_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalOcl.g:1443:2: ( 'notEmpty' )
                    {
                    // InternalOcl.g:1443:2: ( 'notEmpty' )
                    // InternalOcl.g:1444:3: 'notEmpty'
                    {
                     before(grammarAccess.getNoParamFunctionAccess().getNameNotEmptyKeyword_0_0_15()); 
                    match(input,39,FOLLOW_2); 
                     after(grammarAccess.getNoParamFunctionAccess().getNameNotEmptyKeyword_0_0_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalOcl.g:1449:2: ( 'asBag' )
                    {
                    // InternalOcl.g:1449:2: ( 'asBag' )
                    // InternalOcl.g:1450:3: 'asBag'
                    {
                     before(grammarAccess.getNoParamFunctionAccess().getNameAsBagKeyword_0_0_16()); 
                    match(input,40,FOLLOW_2); 
                     after(grammarAccess.getNoParamFunctionAccess().getNameAsBagKeyword_0_0_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalOcl.g:1455:2: ( 'asSequence' )
                    {
                    // InternalOcl.g:1455:2: ( 'asSequence' )
                    // InternalOcl.g:1456:3: 'asSequence'
                    {
                     before(grammarAccess.getNoParamFunctionAccess().getNameAsSequenceKeyword_0_0_17()); 
                    match(input,41,FOLLOW_2); 
                     after(grammarAccess.getNoParamFunctionAccess().getNameAsSequenceKeyword_0_0_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalOcl.g:1461:2: ( 'sum' )
                    {
                    // InternalOcl.g:1461:2: ( 'sum' )
                    // InternalOcl.g:1462:3: 'sum'
                    {
                     before(grammarAccess.getNoParamFunctionAccess().getNameSumKeyword_0_0_18()); 
                    match(input,42,FOLLOW_2); 
                     after(grammarAccess.getNoParamFunctionAccess().getNameSumKeyword_0_0_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalOcl.g:1467:2: ( 'asSet' )
                    {
                    // InternalOcl.g:1467:2: ( 'asSet' )
                    // InternalOcl.g:1468:3: 'asSet'
                    {
                     before(grammarAccess.getNoParamFunctionAccess().getNameAsSetKeyword_0_0_19()); 
                    match(input,43,FOLLOW_2); 
                     after(grammarAccess.getNoParamFunctionAccess().getNameAsSetKeyword_0_0_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalOcl.g:1473:2: ( 'flatten' )
                    {
                    // InternalOcl.g:1473:2: ( 'flatten' )
                    // InternalOcl.g:1474:3: 'flatten'
                    {
                     before(grammarAccess.getNoParamFunctionAccess().getNameFlattenKeyword_0_0_20()); 
                    match(input,44,FOLLOW_2); 
                     after(grammarAccess.getNoParamFunctionAccess().getNameFlattenKeyword_0_0_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalOcl.g:1479:2: ( 'first' )
                    {
                    // InternalOcl.g:1479:2: ( 'first' )
                    // InternalOcl.g:1480:3: 'first'
                    {
                     before(grammarAccess.getNoParamFunctionAccess().getNameFirstKeyword_0_0_21()); 
                    match(input,45,FOLLOW_2); 
                     after(grammarAccess.getNoParamFunctionAccess().getNameFirstKeyword_0_0_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalOcl.g:1485:2: ( 'last' )
                    {
                    // InternalOcl.g:1485:2: ( 'last' )
                    // InternalOcl.g:1486:3: 'last'
                    {
                     before(grammarAccess.getNoParamFunctionAccess().getNameLastKeyword_0_0_22()); 
                    match(input,46,FOLLOW_2); 
                     after(grammarAccess.getNoParamFunctionAccess().getNameLastKeyword_0_0_22()); 

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
    // $ANTLR end "rule__NoParamFunction__NameAlternatives_0_0"


    // $ANTLR start "rule__OneTypeParamFunction__NameAlternatives_0_0"
    // InternalOcl.g:1495:1: rule__OneTypeParamFunction__NameAlternatives_0_0 : ( ( 'oclTypeOf' ) | ( 'oclisKindOf' ) );
    public final void rule__OneTypeParamFunction__NameAlternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1499:1: ( ( 'oclTypeOf' ) | ( 'oclisKindOf' ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==47) ) {
                alt14=1;
            }
            else if ( (LA14_0==48) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalOcl.g:1500:2: ( 'oclTypeOf' )
                    {
                    // InternalOcl.g:1500:2: ( 'oclTypeOf' )
                    // InternalOcl.g:1501:3: 'oclTypeOf'
                    {
                     before(grammarAccess.getOneTypeParamFunctionAccess().getNameOclTypeOfKeyword_0_0_0()); 
                    match(input,47,FOLLOW_2); 
                     after(grammarAccess.getOneTypeParamFunctionAccess().getNameOclTypeOfKeyword_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOcl.g:1506:2: ( 'oclisKindOf' )
                    {
                    // InternalOcl.g:1506:2: ( 'oclisKindOf' )
                    // InternalOcl.g:1507:3: 'oclisKindOf'
                    {
                     before(grammarAccess.getOneTypeParamFunctionAccess().getNameOclisKindOfKeyword_0_0_1()); 
                    match(input,48,FOLLOW_2); 
                     after(grammarAccess.getOneTypeParamFunctionAccess().getNameOclisKindOfKeyword_0_0_1()); 

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
    // $ANTLR end "rule__OneTypeParamFunction__NameAlternatives_0_0"


    // $ANTLR start "rule__OneStringParamFunction__NameAlternatives_0_0"
    // InternalOcl.g:1516:1: rule__OneStringParamFunction__NameAlternatives_0_0 : ( ( 'concat' ) | ( 'startsWith' ) | ( 'endsWith' ) | ( 'indexOf' ) | ( 'lastIndexOf' ) | ( 'split' ) );
    public final void rule__OneStringParamFunction__NameAlternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1520:1: ( ( 'concat' ) | ( 'startsWith' ) | ( 'endsWith' ) | ( 'indexOf' ) | ( 'lastIndexOf' ) | ( 'split' ) )
            int alt15=6;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt15=1;
                }
                break;
            case 50:
                {
                alt15=2;
                }
                break;
            case 51:
                {
                alt15=3;
                }
                break;
            case 52:
                {
                alt15=4;
                }
                break;
            case 53:
                {
                alt15=5;
                }
                break;
            case 54:
                {
                alt15=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalOcl.g:1521:2: ( 'concat' )
                    {
                    // InternalOcl.g:1521:2: ( 'concat' )
                    // InternalOcl.g:1522:3: 'concat'
                    {
                     before(grammarAccess.getOneStringParamFunctionAccess().getNameConcatKeyword_0_0_0()); 
                    match(input,49,FOLLOW_2); 
                     after(grammarAccess.getOneStringParamFunctionAccess().getNameConcatKeyword_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOcl.g:1527:2: ( 'startsWith' )
                    {
                    // InternalOcl.g:1527:2: ( 'startsWith' )
                    // InternalOcl.g:1528:3: 'startsWith'
                    {
                     before(grammarAccess.getOneStringParamFunctionAccess().getNameStartsWithKeyword_0_0_1()); 
                    match(input,50,FOLLOW_2); 
                     after(grammarAccess.getOneStringParamFunctionAccess().getNameStartsWithKeyword_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOcl.g:1533:2: ( 'endsWith' )
                    {
                    // InternalOcl.g:1533:2: ( 'endsWith' )
                    // InternalOcl.g:1534:3: 'endsWith'
                    {
                     before(grammarAccess.getOneStringParamFunctionAccess().getNameEndsWithKeyword_0_0_2()); 
                    match(input,51,FOLLOW_2); 
                     after(grammarAccess.getOneStringParamFunctionAccess().getNameEndsWithKeyword_0_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalOcl.g:1539:2: ( 'indexOf' )
                    {
                    // InternalOcl.g:1539:2: ( 'indexOf' )
                    // InternalOcl.g:1540:3: 'indexOf'
                    {
                     before(grammarAccess.getOneStringParamFunctionAccess().getNameIndexOfKeyword_0_0_3()); 
                    match(input,52,FOLLOW_2); 
                     after(grammarAccess.getOneStringParamFunctionAccess().getNameIndexOfKeyword_0_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalOcl.g:1545:2: ( 'lastIndexOf' )
                    {
                    // InternalOcl.g:1545:2: ( 'lastIndexOf' )
                    // InternalOcl.g:1546:3: 'lastIndexOf'
                    {
                     before(grammarAccess.getOneStringParamFunctionAccess().getNameLastIndexOfKeyword_0_0_4()); 
                    match(input,53,FOLLOW_2); 
                     after(grammarAccess.getOneStringParamFunctionAccess().getNameLastIndexOfKeyword_0_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalOcl.g:1551:2: ( 'split' )
                    {
                    // InternalOcl.g:1551:2: ( 'split' )
                    // InternalOcl.g:1552:3: 'split'
                    {
                     before(grammarAccess.getOneStringParamFunctionAccess().getNameSplitKeyword_0_0_5()); 
                    match(input,54,FOLLOW_2); 
                     after(grammarAccess.getOneStringParamFunctionAccess().getNameSplitKeyword_0_0_5()); 

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
    // $ANTLR end "rule__OneStringParamFunction__NameAlternatives_0_0"


    // $ANTLR start "rule__TwoStringParamFunction__NameAlternatives_0_0"
    // InternalOcl.g:1561:1: rule__TwoStringParamFunction__NameAlternatives_0_0 : ( ( 'replaceAll' ) | ( 'regexReplaceAll' ) );
    public final void rule__TwoStringParamFunction__NameAlternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1565:1: ( ( 'replaceAll' ) | ( 'regexReplaceAll' ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==55) ) {
                alt16=1;
            }
            else if ( (LA16_0==56) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalOcl.g:1566:2: ( 'replaceAll' )
                    {
                    // InternalOcl.g:1566:2: ( 'replaceAll' )
                    // InternalOcl.g:1567:3: 'replaceAll'
                    {
                     before(grammarAccess.getTwoStringParamFunctionAccess().getNameReplaceAllKeyword_0_0_0()); 
                    match(input,55,FOLLOW_2); 
                     after(grammarAccess.getTwoStringParamFunctionAccess().getNameReplaceAllKeyword_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOcl.g:1572:2: ( 'regexReplaceAll' )
                    {
                    // InternalOcl.g:1572:2: ( 'regexReplaceAll' )
                    // InternalOcl.g:1573:3: 'regexReplaceAll'
                    {
                     before(grammarAccess.getTwoStringParamFunctionAccess().getNameRegexReplaceAllKeyword_0_0_1()); 
                    match(input,56,FOLLOW_2); 
                     after(grammarAccess.getTwoStringParamFunctionAccess().getNameRegexReplaceAllKeyword_0_0_1()); 

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
    // $ANTLR end "rule__TwoStringParamFunction__NameAlternatives_0_0"


    // $ANTLR start "rule__TwoIntegerParamFunction__NameAlternatives_0_0"
    // InternalOcl.g:1582:1: rule__TwoIntegerParamFunction__NameAlternatives_0_0 : ( ( 'substring' ) | ( 'subSequence' ) | ( 'subOrderedSet' ) );
    public final void rule__TwoIntegerParamFunction__NameAlternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1586:1: ( ( 'substring' ) | ( 'subSequence' ) | ( 'subOrderedSet' ) )
            int alt17=3;
            switch ( input.LA(1) ) {
            case 57:
                {
                alt17=1;
                }
                break;
            case 58:
                {
                alt17=2;
                }
                break;
            case 59:
                {
                alt17=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // InternalOcl.g:1587:2: ( 'substring' )
                    {
                    // InternalOcl.g:1587:2: ( 'substring' )
                    // InternalOcl.g:1588:3: 'substring'
                    {
                     before(grammarAccess.getTwoIntegerParamFunctionAccess().getNameSubstringKeyword_0_0_0()); 
                    match(input,57,FOLLOW_2); 
                     after(grammarAccess.getTwoIntegerParamFunctionAccess().getNameSubstringKeyword_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOcl.g:1593:2: ( 'subSequence' )
                    {
                    // InternalOcl.g:1593:2: ( 'subSequence' )
                    // InternalOcl.g:1594:3: 'subSequence'
                    {
                     before(grammarAccess.getTwoIntegerParamFunctionAccess().getNameSubSequenceKeyword_0_0_1()); 
                    match(input,58,FOLLOW_2); 
                     after(grammarAccess.getTwoIntegerParamFunctionAccess().getNameSubSequenceKeyword_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOcl.g:1599:2: ( 'subOrderedSet' )
                    {
                    // InternalOcl.g:1599:2: ( 'subOrderedSet' )
                    // InternalOcl.g:1600:3: 'subOrderedSet'
                    {
                     before(grammarAccess.getTwoIntegerParamFunctionAccess().getNameSubOrderedSetKeyword_0_0_2()); 
                    match(input,59,FOLLOW_2); 
                     after(grammarAccess.getTwoIntegerParamFunctionAccess().getNameSubOrderedSetKeyword_0_0_2()); 

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
    // $ANTLR end "rule__TwoIntegerParamFunction__NameAlternatives_0_0"


    // $ANTLR start "rule__CollectionKind__NameAlternatives_0"
    // InternalOcl.g:1609:1: rule__CollectionKind__NameAlternatives_0 : ( ( 'Set' ) | ( 'Bag' ) | ( 'Sequence' ) | ( 'Collection' ) );
    public final void rule__CollectionKind__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1613:1: ( ( 'Set' ) | ( 'Bag' ) | ( 'Sequence' ) | ( 'Collection' ) )
            int alt18=4;
            switch ( input.LA(1) ) {
            case 60:
                {
                alt18=1;
                }
                break;
            case 61:
                {
                alt18=2;
                }
                break;
            case 62:
                {
                alt18=3;
                }
                break;
            case 63:
                {
                alt18=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalOcl.g:1614:2: ( 'Set' )
                    {
                    // InternalOcl.g:1614:2: ( 'Set' )
                    // InternalOcl.g:1615:3: 'Set'
                    {
                     before(grammarAccess.getCollectionKindAccess().getNameSetKeyword_0_0()); 
                    match(input,60,FOLLOW_2); 
                     after(grammarAccess.getCollectionKindAccess().getNameSetKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOcl.g:1620:2: ( 'Bag' )
                    {
                    // InternalOcl.g:1620:2: ( 'Bag' )
                    // InternalOcl.g:1621:3: 'Bag'
                    {
                     before(grammarAccess.getCollectionKindAccess().getNameBagKeyword_0_1()); 
                    match(input,61,FOLLOW_2); 
                     after(grammarAccess.getCollectionKindAccess().getNameBagKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOcl.g:1626:2: ( 'Sequence' )
                    {
                    // InternalOcl.g:1626:2: ( 'Sequence' )
                    // InternalOcl.g:1627:3: 'Sequence'
                    {
                     before(grammarAccess.getCollectionKindAccess().getNameSequenceKeyword_0_2()); 
                    match(input,62,FOLLOW_2); 
                     after(grammarAccess.getCollectionKindAccess().getNameSequenceKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalOcl.g:1632:2: ( 'Collection' )
                    {
                    // InternalOcl.g:1632:2: ( 'Collection' )
                    // InternalOcl.g:1633:3: 'Collection'
                    {
                     before(grammarAccess.getCollectionKindAccess().getNameCollectionKeyword_0_3()); 
                    match(input,63,FOLLOW_2); 
                     after(grammarAccess.getCollectionKindAccess().getNameCollectionKeyword_0_3()); 

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
    // $ANTLR end "rule__CollectionKind__NameAlternatives_0"


    // $ANTLR start "rule__NavigationOperator__NameAlternatives_0"
    // InternalOcl.g:1642:1: rule__NavigationOperator__NameAlternatives_0 : ( ( '.' ) | ( '->' ) );
    public final void rule__NavigationOperator__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1646:1: ( ( '.' ) | ( '->' ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==64) ) {
                alt19=1;
            }
            else if ( (LA19_0==65) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalOcl.g:1647:2: ( '.' )
                    {
                    // InternalOcl.g:1647:2: ( '.' )
                    // InternalOcl.g:1648:3: '.'
                    {
                     before(grammarAccess.getNavigationOperatorAccess().getNameFullStopKeyword_0_0()); 
                    match(input,64,FOLLOW_2); 
                     after(grammarAccess.getNavigationOperatorAccess().getNameFullStopKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOcl.g:1653:2: ( '->' )
                    {
                    // InternalOcl.g:1653:2: ( '->' )
                    // InternalOcl.g:1654:3: '->'
                    {
                     before(grammarAccess.getNavigationOperatorAccess().getNameHyphenMinusGreaterThanSignKeyword_0_1()); 
                    match(input,65,FOLLOW_2); 
                     after(grammarAccess.getNavigationOperatorAccess().getNameHyphenMinusGreaterThanSignKeyword_0_1()); 

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
    // $ANTLR end "rule__NavigationOperator__NameAlternatives_0"


    // $ANTLR start "rule__UnaryOperator__NameAlternatives_0"
    // InternalOcl.g:1663:1: rule__UnaryOperator__NameAlternatives_0 : ( ( '-' ) | ( 'not' ) );
    public final void rule__UnaryOperator__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1667:1: ( ( '-' ) | ( 'not' ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==66) ) {
                alt20=1;
            }
            else if ( (LA20_0==67) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalOcl.g:1668:2: ( '-' )
                    {
                    // InternalOcl.g:1668:2: ( '-' )
                    // InternalOcl.g:1669:3: '-'
                    {
                     before(grammarAccess.getUnaryOperatorAccess().getNameHyphenMinusKeyword_0_0()); 
                    match(input,66,FOLLOW_2); 
                     after(grammarAccess.getUnaryOperatorAccess().getNameHyphenMinusKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOcl.g:1674:2: ( 'not' )
                    {
                    // InternalOcl.g:1674:2: ( 'not' )
                    // InternalOcl.g:1675:3: 'not'
                    {
                     before(grammarAccess.getUnaryOperatorAccess().getNameNotKeyword_0_1()); 
                    match(input,67,FOLLOW_2); 
                     after(grammarAccess.getUnaryOperatorAccess().getNameNotKeyword_0_1()); 

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
    // $ANTLR end "rule__UnaryOperator__NameAlternatives_0"


    // $ANTLR start "rule__MultiplyOperator__NameAlternatives_0"
    // InternalOcl.g:1684:1: rule__MultiplyOperator__NameAlternatives_0 : ( ( '*' ) | ( '/' ) );
    public final void rule__MultiplyOperator__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1688:1: ( ( '*' ) | ( '/' ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==68) ) {
                alt21=1;
            }
            else if ( (LA21_0==69) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalOcl.g:1689:2: ( '*' )
                    {
                    // InternalOcl.g:1689:2: ( '*' )
                    // InternalOcl.g:1690:3: '*'
                    {
                     before(grammarAccess.getMultiplyOperatorAccess().getNameAsteriskKeyword_0_0()); 
                    match(input,68,FOLLOW_2); 
                     after(grammarAccess.getMultiplyOperatorAccess().getNameAsteriskKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOcl.g:1695:2: ( '/' )
                    {
                    // InternalOcl.g:1695:2: ( '/' )
                    // InternalOcl.g:1696:3: '/'
                    {
                     before(grammarAccess.getMultiplyOperatorAccess().getNameSolidusKeyword_0_1()); 
                    match(input,69,FOLLOW_2); 
                     after(grammarAccess.getMultiplyOperatorAccess().getNameSolidusKeyword_0_1()); 

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
    // $ANTLR end "rule__MultiplyOperator__NameAlternatives_0"


    // $ANTLR start "rule__AddOperator__NameAlternatives_0"
    // InternalOcl.g:1705:1: rule__AddOperator__NameAlternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__AddOperator__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1709:1: ( ( '+' ) | ( '-' ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==70) ) {
                alt22=1;
            }
            else if ( (LA22_0==66) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalOcl.g:1710:2: ( '+' )
                    {
                    // InternalOcl.g:1710:2: ( '+' )
                    // InternalOcl.g:1711:3: '+'
                    {
                     before(grammarAccess.getAddOperatorAccess().getNamePlusSignKeyword_0_0()); 
                    match(input,70,FOLLOW_2); 
                     after(grammarAccess.getAddOperatorAccess().getNamePlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOcl.g:1716:2: ( '-' )
                    {
                    // InternalOcl.g:1716:2: ( '-' )
                    // InternalOcl.g:1717:3: '-'
                    {
                     before(grammarAccess.getAddOperatorAccess().getNameHyphenMinusKeyword_0_1()); 
                    match(input,66,FOLLOW_2); 
                     after(grammarAccess.getAddOperatorAccess().getNameHyphenMinusKeyword_0_1()); 

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
    // $ANTLR end "rule__AddOperator__NameAlternatives_0"


    // $ANTLR start "rule__RelationalOperator__NameAlternatives_0"
    // InternalOcl.g:1726:1: rule__RelationalOperator__NameAlternatives_0 : ( ( '=' ) | ( '>' ) | ( '<' ) | ( '>=' ) | ( '<=' ) | ( '<>' ) );
    public final void rule__RelationalOperator__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1730:1: ( ( '=' ) | ( '>' ) | ( '<' ) | ( '>=' ) | ( '<=' ) | ( '<>' ) )
            int alt23=6;
            switch ( input.LA(1) ) {
            case 71:
                {
                alt23=1;
                }
                break;
            case 72:
                {
                alt23=2;
                }
                break;
            case 73:
                {
                alt23=3;
                }
                break;
            case 74:
                {
                alt23=4;
                }
                break;
            case 75:
                {
                alt23=5;
                }
                break;
            case 76:
                {
                alt23=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalOcl.g:1731:2: ( '=' )
                    {
                    // InternalOcl.g:1731:2: ( '=' )
                    // InternalOcl.g:1732:3: '='
                    {
                     before(grammarAccess.getRelationalOperatorAccess().getNameEqualsSignKeyword_0_0()); 
                    match(input,71,FOLLOW_2); 
                     after(grammarAccess.getRelationalOperatorAccess().getNameEqualsSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOcl.g:1737:2: ( '>' )
                    {
                    // InternalOcl.g:1737:2: ( '>' )
                    // InternalOcl.g:1738:3: '>'
                    {
                     before(grammarAccess.getRelationalOperatorAccess().getNameGreaterThanSignKeyword_0_1()); 
                    match(input,72,FOLLOW_2); 
                     after(grammarAccess.getRelationalOperatorAccess().getNameGreaterThanSignKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOcl.g:1743:2: ( '<' )
                    {
                    // InternalOcl.g:1743:2: ( '<' )
                    // InternalOcl.g:1744:3: '<'
                    {
                     before(grammarAccess.getRelationalOperatorAccess().getNameLessThanSignKeyword_0_2()); 
                    match(input,73,FOLLOW_2); 
                     after(grammarAccess.getRelationalOperatorAccess().getNameLessThanSignKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalOcl.g:1749:2: ( '>=' )
                    {
                    // InternalOcl.g:1749:2: ( '>=' )
                    // InternalOcl.g:1750:3: '>='
                    {
                     before(grammarAccess.getRelationalOperatorAccess().getNameGreaterThanSignEqualsSignKeyword_0_3()); 
                    match(input,74,FOLLOW_2); 
                     after(grammarAccess.getRelationalOperatorAccess().getNameGreaterThanSignEqualsSignKeyword_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalOcl.g:1755:2: ( '<=' )
                    {
                    // InternalOcl.g:1755:2: ( '<=' )
                    // InternalOcl.g:1756:3: '<='
                    {
                     before(grammarAccess.getRelationalOperatorAccess().getNameLessThanSignEqualsSignKeyword_0_4()); 
                    match(input,75,FOLLOW_2); 
                     after(grammarAccess.getRelationalOperatorAccess().getNameLessThanSignEqualsSignKeyword_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalOcl.g:1761:2: ( '<>' )
                    {
                    // InternalOcl.g:1761:2: ( '<>' )
                    // InternalOcl.g:1762:3: '<>'
                    {
                     before(grammarAccess.getRelationalOperatorAccess().getNameLessThanSignGreaterThanSignKeyword_0_5()); 
                    match(input,76,FOLLOW_2); 
                     after(grammarAccess.getRelationalOperatorAccess().getNameLessThanSignGreaterThanSignKeyword_0_5()); 

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
    // $ANTLR end "rule__RelationalOperator__NameAlternatives_0"


    // $ANTLR start "rule__LogicalOperator__NameAlternatives_0"
    // InternalOcl.g:1771:1: rule__LogicalOperator__NameAlternatives_0 : ( ( 'and' ) | ( 'or' ) | ( 'xor' ) | ( 'implies' ) );
    public final void rule__LogicalOperator__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1775:1: ( ( 'and' ) | ( 'or' ) | ( 'xor' ) | ( 'implies' ) )
            int alt24=4;
            switch ( input.LA(1) ) {
            case 77:
                {
                alt24=1;
                }
                break;
            case 78:
                {
                alt24=2;
                }
                break;
            case 79:
                {
                alt24=3;
                }
                break;
            case 80:
                {
                alt24=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // InternalOcl.g:1776:2: ( 'and' )
                    {
                    // InternalOcl.g:1776:2: ( 'and' )
                    // InternalOcl.g:1777:3: 'and'
                    {
                     before(grammarAccess.getLogicalOperatorAccess().getNameAndKeyword_0_0()); 
                    match(input,77,FOLLOW_2); 
                     after(grammarAccess.getLogicalOperatorAccess().getNameAndKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOcl.g:1782:2: ( 'or' )
                    {
                    // InternalOcl.g:1782:2: ( 'or' )
                    // InternalOcl.g:1783:3: 'or'
                    {
                     before(grammarAccess.getLogicalOperatorAccess().getNameOrKeyword_0_1()); 
                    match(input,78,FOLLOW_2); 
                     after(grammarAccess.getLogicalOperatorAccess().getNameOrKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOcl.g:1788:2: ( 'xor' )
                    {
                    // InternalOcl.g:1788:2: ( 'xor' )
                    // InternalOcl.g:1789:3: 'xor'
                    {
                     before(grammarAccess.getLogicalOperatorAccess().getNameXorKeyword_0_2()); 
                    match(input,79,FOLLOW_2); 
                     after(grammarAccess.getLogicalOperatorAccess().getNameXorKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalOcl.g:1794:2: ( 'implies' )
                    {
                    // InternalOcl.g:1794:2: ( 'implies' )
                    // InternalOcl.g:1795:3: 'implies'
                    {
                     before(grammarAccess.getLogicalOperatorAccess().getNameImpliesKeyword_0_3()); 
                    match(input,80,FOLLOW_2); 
                     after(grammarAccess.getLogicalOperatorAccess().getNameImpliesKeyword_0_3()); 

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
    // $ANTLR end "rule__LogicalOperator__NameAlternatives_0"


    // $ANTLR start "rule__ContextExpression__Group__0"
    // InternalOcl.g:1804:1: rule__ContextExpression__Group__0 : rule__ContextExpression__Group__0__Impl rule__ContextExpression__Group__1 ;
    public final void rule__ContextExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1808:1: ( rule__ContextExpression__Group__0__Impl rule__ContextExpression__Group__1 )
            // InternalOcl.g:1809:2: rule__ContextExpression__Group__0__Impl rule__ContextExpression__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__ContextExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ContextExpression__Group__1();

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
    // $ANTLR end "rule__ContextExpression__Group__0"


    // $ANTLR start "rule__ContextExpression__Group__0__Impl"
    // InternalOcl.g:1816:1: rule__ContextExpression__Group__0__Impl : ( 'context' ) ;
    public final void rule__ContextExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1820:1: ( ( 'context' ) )
            // InternalOcl.g:1821:1: ( 'context' )
            {
            // InternalOcl.g:1821:1: ( 'context' )
            // InternalOcl.g:1822:2: 'context'
            {
             before(grammarAccess.getContextExpressionAccess().getContextKeyword_0()); 
            match(input,81,FOLLOW_2); 
             after(grammarAccess.getContextExpressionAccess().getContextKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextExpression__Group__0__Impl"


    // $ANTLR start "rule__ContextExpression__Group__1"
    // InternalOcl.g:1831:1: rule__ContextExpression__Group__1 : rule__ContextExpression__Group__1__Impl rule__ContextExpression__Group__2 ;
    public final void rule__ContextExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1835:1: ( rule__ContextExpression__Group__1__Impl rule__ContextExpression__Group__2 )
            // InternalOcl.g:1836:2: rule__ContextExpression__Group__1__Impl rule__ContextExpression__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__ContextExpression__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ContextExpression__Group__2();

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
    // $ANTLR end "rule__ContextExpression__Group__1"


    // $ANTLR start "rule__ContextExpression__Group__1__Impl"
    // InternalOcl.g:1843:1: rule__ContextExpression__Group__1__Impl : ( RULE_TYPENAME_TERMINAL ) ;
    public final void rule__ContextExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1847:1: ( ( RULE_TYPENAME_TERMINAL ) )
            // InternalOcl.g:1848:1: ( RULE_TYPENAME_TERMINAL )
            {
            // InternalOcl.g:1848:1: ( RULE_TYPENAME_TERMINAL )
            // InternalOcl.g:1849:2: RULE_TYPENAME_TERMINAL
            {
             before(grammarAccess.getContextExpressionAccess().getTYPENAME_TERMINALTerminalRuleCall_1()); 
            match(input,RULE_TYPENAME_TERMINAL,FOLLOW_2); 
             after(grammarAccess.getContextExpressionAccess().getTYPENAME_TERMINALTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextExpression__Group__1__Impl"


    // $ANTLR start "rule__ContextExpression__Group__2"
    // InternalOcl.g:1858:1: rule__ContextExpression__Group__2 : rule__ContextExpression__Group__2__Impl rule__ContextExpression__Group__3 ;
    public final void rule__ContextExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1862:1: ( rule__ContextExpression__Group__2__Impl rule__ContextExpression__Group__3 )
            // InternalOcl.g:1863:2: rule__ContextExpression__Group__2__Impl rule__ContextExpression__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__ContextExpression__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ContextExpression__Group__3();

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
    // $ANTLR end "rule__ContextExpression__Group__2"


    // $ANTLR start "rule__ContextExpression__Group__2__Impl"
    // InternalOcl.g:1870:1: rule__ContextExpression__Group__2__Impl : ( ( rule__ContextExpression__Alternatives_2 ) ) ;
    public final void rule__ContextExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1874:1: ( ( ( rule__ContextExpression__Alternatives_2 ) ) )
            // InternalOcl.g:1875:1: ( ( rule__ContextExpression__Alternatives_2 ) )
            {
            // InternalOcl.g:1875:1: ( ( rule__ContextExpression__Alternatives_2 ) )
            // InternalOcl.g:1876:2: ( rule__ContextExpression__Alternatives_2 )
            {
             before(grammarAccess.getContextExpressionAccess().getAlternatives_2()); 
            // InternalOcl.g:1877:2: ( rule__ContextExpression__Alternatives_2 )
            // InternalOcl.g:1877:3: rule__ContextExpression__Alternatives_2
            {
            pushFollow(FOLLOW_2);
            rule__ContextExpression__Alternatives_2();

            state._fsp--;


            }

             after(grammarAccess.getContextExpressionAccess().getAlternatives_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextExpression__Group__2__Impl"


    // $ANTLR start "rule__ContextExpression__Group__3"
    // InternalOcl.g:1885:1: rule__ContextExpression__Group__3 : rule__ContextExpression__Group__3__Impl ;
    public final void rule__ContextExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1889:1: ( rule__ContextExpression__Group__3__Impl )
            // InternalOcl.g:1890:2: rule__ContextExpression__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ContextExpression__Group__3__Impl();

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
    // $ANTLR end "rule__ContextExpression__Group__3"


    // $ANTLR start "rule__ContextExpression__Group__3__Impl"
    // InternalOcl.g:1896:1: rule__ContextExpression__Group__3__Impl : ( ruleExpression ) ;
    public final void rule__ContextExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1900:1: ( ( ruleExpression ) )
            // InternalOcl.g:1901:1: ( ruleExpression )
            {
            // InternalOcl.g:1901:1: ( ruleExpression )
            // InternalOcl.g:1902:2: ruleExpression
            {
             before(grammarAccess.getContextExpressionAccess().getExpressionParserRuleCall_3()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getContextExpressionAccess().getExpressionParserRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextExpression__Group__3__Impl"


    // $ANTLR start "rule__LogicalExpression__Group__0"
    // InternalOcl.g:1912:1: rule__LogicalExpression__Group__0 : rule__LogicalExpression__Group__0__Impl rule__LogicalExpression__Group__1 ;
    public final void rule__LogicalExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1916:1: ( rule__LogicalExpression__Group__0__Impl rule__LogicalExpression__Group__1 )
            // InternalOcl.g:1917:2: rule__LogicalExpression__Group__0__Impl rule__LogicalExpression__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__LogicalExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LogicalExpression__Group__1();

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
    // $ANTLR end "rule__LogicalExpression__Group__0"


    // $ANTLR start "rule__LogicalExpression__Group__0__Impl"
    // InternalOcl.g:1924:1: rule__LogicalExpression__Group__0__Impl : ( ( rule__LogicalExpression__ExpAssignment_0 ) ) ;
    public final void rule__LogicalExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1928:1: ( ( ( rule__LogicalExpression__ExpAssignment_0 ) ) )
            // InternalOcl.g:1929:1: ( ( rule__LogicalExpression__ExpAssignment_0 ) )
            {
            // InternalOcl.g:1929:1: ( ( rule__LogicalExpression__ExpAssignment_0 ) )
            // InternalOcl.g:1930:2: ( rule__LogicalExpression__ExpAssignment_0 )
            {
             before(grammarAccess.getLogicalExpressionAccess().getExpAssignment_0()); 
            // InternalOcl.g:1931:2: ( rule__LogicalExpression__ExpAssignment_0 )
            // InternalOcl.g:1931:3: rule__LogicalExpression__ExpAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__LogicalExpression__ExpAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getLogicalExpressionAccess().getExpAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalExpression__Group__0__Impl"


    // $ANTLR start "rule__LogicalExpression__Group__1"
    // InternalOcl.g:1939:1: rule__LogicalExpression__Group__1 : rule__LogicalExpression__Group__1__Impl ;
    public final void rule__LogicalExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1943:1: ( rule__LogicalExpression__Group__1__Impl )
            // InternalOcl.g:1944:2: rule__LogicalExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LogicalExpression__Group__1__Impl();

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
    // $ANTLR end "rule__LogicalExpression__Group__1"


    // $ANTLR start "rule__LogicalExpression__Group__1__Impl"
    // InternalOcl.g:1950:1: rule__LogicalExpression__Group__1__Impl : ( ( rule__LogicalExpression__Group_1__0 )* ) ;
    public final void rule__LogicalExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1954:1: ( ( ( rule__LogicalExpression__Group_1__0 )* ) )
            // InternalOcl.g:1955:1: ( ( rule__LogicalExpression__Group_1__0 )* )
            {
            // InternalOcl.g:1955:1: ( ( rule__LogicalExpression__Group_1__0 )* )
            // InternalOcl.g:1956:2: ( rule__LogicalExpression__Group_1__0 )*
            {
             before(grammarAccess.getLogicalExpressionAccess().getGroup_1()); 
            // InternalOcl.g:1957:2: ( rule__LogicalExpression__Group_1__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=77 && LA25_0<=80)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalOcl.g:1957:3: rule__LogicalExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__LogicalExpression__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getLogicalExpressionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalExpression__Group__1__Impl"


    // $ANTLR start "rule__LogicalExpression__Group_1__0"
    // InternalOcl.g:1966:1: rule__LogicalExpression__Group_1__0 : rule__LogicalExpression__Group_1__0__Impl rule__LogicalExpression__Group_1__1 ;
    public final void rule__LogicalExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1970:1: ( rule__LogicalExpression__Group_1__0__Impl rule__LogicalExpression__Group_1__1 )
            // InternalOcl.g:1971:2: rule__LogicalExpression__Group_1__0__Impl rule__LogicalExpression__Group_1__1
            {
            pushFollow(FOLLOW_6);
            rule__LogicalExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LogicalExpression__Group_1__1();

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
    // $ANTLR end "rule__LogicalExpression__Group_1__0"


    // $ANTLR start "rule__LogicalExpression__Group_1__0__Impl"
    // InternalOcl.g:1978:1: rule__LogicalExpression__Group_1__0__Impl : ( ( rule__LogicalExpression__OpAssignment_1_0 ) ) ;
    public final void rule__LogicalExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1982:1: ( ( ( rule__LogicalExpression__OpAssignment_1_0 ) ) )
            // InternalOcl.g:1983:1: ( ( rule__LogicalExpression__OpAssignment_1_0 ) )
            {
            // InternalOcl.g:1983:1: ( ( rule__LogicalExpression__OpAssignment_1_0 ) )
            // InternalOcl.g:1984:2: ( rule__LogicalExpression__OpAssignment_1_0 )
            {
             before(grammarAccess.getLogicalExpressionAccess().getOpAssignment_1_0()); 
            // InternalOcl.g:1985:2: ( rule__LogicalExpression__OpAssignment_1_0 )
            // InternalOcl.g:1985:3: rule__LogicalExpression__OpAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__LogicalExpression__OpAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getLogicalExpressionAccess().getOpAssignment_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalExpression__Group_1__0__Impl"


    // $ANTLR start "rule__LogicalExpression__Group_1__1"
    // InternalOcl.g:1993:1: rule__LogicalExpression__Group_1__1 : rule__LogicalExpression__Group_1__1__Impl ;
    public final void rule__LogicalExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:1997:1: ( rule__LogicalExpression__Group_1__1__Impl )
            // InternalOcl.g:1998:2: rule__LogicalExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LogicalExpression__Group_1__1__Impl();

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
    // $ANTLR end "rule__LogicalExpression__Group_1__1"


    // $ANTLR start "rule__LogicalExpression__Group_1__1__Impl"
    // InternalOcl.g:2004:1: rule__LogicalExpression__Group_1__1__Impl : ( ( rule__LogicalExpression__ExpAssignment_1_1 ) ) ;
    public final void rule__LogicalExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2008:1: ( ( ( rule__LogicalExpression__ExpAssignment_1_1 ) ) )
            // InternalOcl.g:2009:1: ( ( rule__LogicalExpression__ExpAssignment_1_1 ) )
            {
            // InternalOcl.g:2009:1: ( ( rule__LogicalExpression__ExpAssignment_1_1 ) )
            // InternalOcl.g:2010:2: ( rule__LogicalExpression__ExpAssignment_1_1 )
            {
             before(grammarAccess.getLogicalExpressionAccess().getExpAssignment_1_1()); 
            // InternalOcl.g:2011:2: ( rule__LogicalExpression__ExpAssignment_1_1 )
            // InternalOcl.g:2011:3: rule__LogicalExpression__ExpAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__LogicalExpression__ExpAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getLogicalExpressionAccess().getExpAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalExpression__Group_1__1__Impl"


    // $ANTLR start "rule__RelationalExpression__Group__0"
    // InternalOcl.g:2020:1: rule__RelationalExpression__Group__0 : rule__RelationalExpression__Group__0__Impl rule__RelationalExpression__Group__1 ;
    public final void rule__RelationalExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2024:1: ( rule__RelationalExpression__Group__0__Impl rule__RelationalExpression__Group__1 )
            // InternalOcl.g:2025:2: rule__RelationalExpression__Group__0__Impl rule__RelationalExpression__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__RelationalExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RelationalExpression__Group__1();

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
    // $ANTLR end "rule__RelationalExpression__Group__0"


    // $ANTLR start "rule__RelationalExpression__Group__0__Impl"
    // InternalOcl.g:2032:1: rule__RelationalExpression__Group__0__Impl : ( ( rule__RelationalExpression__ExpAssignment_0 ) ) ;
    public final void rule__RelationalExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2036:1: ( ( ( rule__RelationalExpression__ExpAssignment_0 ) ) )
            // InternalOcl.g:2037:1: ( ( rule__RelationalExpression__ExpAssignment_0 ) )
            {
            // InternalOcl.g:2037:1: ( ( rule__RelationalExpression__ExpAssignment_0 ) )
            // InternalOcl.g:2038:2: ( rule__RelationalExpression__ExpAssignment_0 )
            {
             before(grammarAccess.getRelationalExpressionAccess().getExpAssignment_0()); 
            // InternalOcl.g:2039:2: ( rule__RelationalExpression__ExpAssignment_0 )
            // InternalOcl.g:2039:3: rule__RelationalExpression__ExpAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__RelationalExpression__ExpAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getRelationalExpressionAccess().getExpAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpression__Group__0__Impl"


    // $ANTLR start "rule__RelationalExpression__Group__1"
    // InternalOcl.g:2047:1: rule__RelationalExpression__Group__1 : rule__RelationalExpression__Group__1__Impl ;
    public final void rule__RelationalExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2051:1: ( rule__RelationalExpression__Group__1__Impl )
            // InternalOcl.g:2052:2: rule__RelationalExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RelationalExpression__Group__1__Impl();

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
    // $ANTLR end "rule__RelationalExpression__Group__1"


    // $ANTLR start "rule__RelationalExpression__Group__1__Impl"
    // InternalOcl.g:2058:1: rule__RelationalExpression__Group__1__Impl : ( ( rule__RelationalExpression__Group_1__0 )? ) ;
    public final void rule__RelationalExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2062:1: ( ( ( rule__RelationalExpression__Group_1__0 )? ) )
            // InternalOcl.g:2063:1: ( ( rule__RelationalExpression__Group_1__0 )? )
            {
            // InternalOcl.g:2063:1: ( ( rule__RelationalExpression__Group_1__0 )? )
            // InternalOcl.g:2064:2: ( rule__RelationalExpression__Group_1__0 )?
            {
             before(grammarAccess.getRelationalExpressionAccess().getGroup_1()); 
            // InternalOcl.g:2065:2: ( rule__RelationalExpression__Group_1__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=71 && LA26_0<=76)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalOcl.g:2065:3: rule__RelationalExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__RelationalExpression__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRelationalExpressionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpression__Group__1__Impl"


    // $ANTLR start "rule__RelationalExpression__Group_1__0"
    // InternalOcl.g:2074:1: rule__RelationalExpression__Group_1__0 : rule__RelationalExpression__Group_1__0__Impl rule__RelationalExpression__Group_1__1 ;
    public final void rule__RelationalExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2078:1: ( rule__RelationalExpression__Group_1__0__Impl rule__RelationalExpression__Group_1__1 )
            // InternalOcl.g:2079:2: rule__RelationalExpression__Group_1__0__Impl rule__RelationalExpression__Group_1__1
            {
            pushFollow(FOLLOW_6);
            rule__RelationalExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RelationalExpression__Group_1__1();

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
    // $ANTLR end "rule__RelationalExpression__Group_1__0"


    // $ANTLR start "rule__RelationalExpression__Group_1__0__Impl"
    // InternalOcl.g:2086:1: rule__RelationalExpression__Group_1__0__Impl : ( ( rule__RelationalExpression__OpAssignment_1_0 ) ) ;
    public final void rule__RelationalExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2090:1: ( ( ( rule__RelationalExpression__OpAssignment_1_0 ) ) )
            // InternalOcl.g:2091:1: ( ( rule__RelationalExpression__OpAssignment_1_0 ) )
            {
            // InternalOcl.g:2091:1: ( ( rule__RelationalExpression__OpAssignment_1_0 ) )
            // InternalOcl.g:2092:2: ( rule__RelationalExpression__OpAssignment_1_0 )
            {
             before(grammarAccess.getRelationalExpressionAccess().getOpAssignment_1_0()); 
            // InternalOcl.g:2093:2: ( rule__RelationalExpression__OpAssignment_1_0 )
            // InternalOcl.g:2093:3: rule__RelationalExpression__OpAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__RelationalExpression__OpAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getRelationalExpressionAccess().getOpAssignment_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpression__Group_1__0__Impl"


    // $ANTLR start "rule__RelationalExpression__Group_1__1"
    // InternalOcl.g:2101:1: rule__RelationalExpression__Group_1__1 : rule__RelationalExpression__Group_1__1__Impl ;
    public final void rule__RelationalExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2105:1: ( rule__RelationalExpression__Group_1__1__Impl )
            // InternalOcl.g:2106:2: rule__RelationalExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RelationalExpression__Group_1__1__Impl();

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
    // $ANTLR end "rule__RelationalExpression__Group_1__1"


    // $ANTLR start "rule__RelationalExpression__Group_1__1__Impl"
    // InternalOcl.g:2112:1: rule__RelationalExpression__Group_1__1__Impl : ( ( rule__RelationalExpression__ExpAssignment_1_1 ) ) ;
    public final void rule__RelationalExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2116:1: ( ( ( rule__RelationalExpression__ExpAssignment_1_1 ) ) )
            // InternalOcl.g:2117:1: ( ( rule__RelationalExpression__ExpAssignment_1_1 ) )
            {
            // InternalOcl.g:2117:1: ( ( rule__RelationalExpression__ExpAssignment_1_1 ) )
            // InternalOcl.g:2118:2: ( rule__RelationalExpression__ExpAssignment_1_1 )
            {
             before(grammarAccess.getRelationalExpressionAccess().getExpAssignment_1_1()); 
            // InternalOcl.g:2119:2: ( rule__RelationalExpression__ExpAssignment_1_1 )
            // InternalOcl.g:2119:3: rule__RelationalExpression__ExpAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__RelationalExpression__ExpAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getRelationalExpressionAccess().getExpAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpression__Group_1__1__Impl"


    // $ANTLR start "rule__AdditiveExpression__Group__0"
    // InternalOcl.g:2128:1: rule__AdditiveExpression__Group__0 : rule__AdditiveExpression__Group__0__Impl rule__AdditiveExpression__Group__1 ;
    public final void rule__AdditiveExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2132:1: ( rule__AdditiveExpression__Group__0__Impl rule__AdditiveExpression__Group__1 )
            // InternalOcl.g:2133:2: rule__AdditiveExpression__Group__0__Impl rule__AdditiveExpression__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__AdditiveExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AdditiveExpression__Group__1();

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
    // $ANTLR end "rule__AdditiveExpression__Group__0"


    // $ANTLR start "rule__AdditiveExpression__Group__0__Impl"
    // InternalOcl.g:2140:1: rule__AdditiveExpression__Group__0__Impl : ( ( rule__AdditiveExpression__ExpAssignment_0 ) ) ;
    public final void rule__AdditiveExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2144:1: ( ( ( rule__AdditiveExpression__ExpAssignment_0 ) ) )
            // InternalOcl.g:2145:1: ( ( rule__AdditiveExpression__ExpAssignment_0 ) )
            {
            // InternalOcl.g:2145:1: ( ( rule__AdditiveExpression__ExpAssignment_0 ) )
            // InternalOcl.g:2146:2: ( rule__AdditiveExpression__ExpAssignment_0 )
            {
             before(grammarAccess.getAdditiveExpressionAccess().getExpAssignment_0()); 
            // InternalOcl.g:2147:2: ( rule__AdditiveExpression__ExpAssignment_0 )
            // InternalOcl.g:2147:3: rule__AdditiveExpression__ExpAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__AdditiveExpression__ExpAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getAdditiveExpressionAccess().getExpAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpression__Group__0__Impl"


    // $ANTLR start "rule__AdditiveExpression__Group__1"
    // InternalOcl.g:2155:1: rule__AdditiveExpression__Group__1 : rule__AdditiveExpression__Group__1__Impl ;
    public final void rule__AdditiveExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2159:1: ( rule__AdditiveExpression__Group__1__Impl )
            // InternalOcl.g:2160:2: rule__AdditiveExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AdditiveExpression__Group__1__Impl();

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
    // $ANTLR end "rule__AdditiveExpression__Group__1"


    // $ANTLR start "rule__AdditiveExpression__Group__1__Impl"
    // InternalOcl.g:2166:1: rule__AdditiveExpression__Group__1__Impl : ( ( rule__AdditiveExpression__Group_1__0 )* ) ;
    public final void rule__AdditiveExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2170:1: ( ( ( rule__AdditiveExpression__Group_1__0 )* ) )
            // InternalOcl.g:2171:1: ( ( rule__AdditiveExpression__Group_1__0 )* )
            {
            // InternalOcl.g:2171:1: ( ( rule__AdditiveExpression__Group_1__0 )* )
            // InternalOcl.g:2172:2: ( rule__AdditiveExpression__Group_1__0 )*
            {
             before(grammarAccess.getAdditiveExpressionAccess().getGroup_1()); 
            // InternalOcl.g:2173:2: ( rule__AdditiveExpression__Group_1__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==66||LA27_0==70) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalOcl.g:2173:3: rule__AdditiveExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__AdditiveExpression__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

             after(grammarAccess.getAdditiveExpressionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpression__Group__1__Impl"


    // $ANTLR start "rule__AdditiveExpression__Group_1__0"
    // InternalOcl.g:2182:1: rule__AdditiveExpression__Group_1__0 : rule__AdditiveExpression__Group_1__0__Impl rule__AdditiveExpression__Group_1__1 ;
    public final void rule__AdditiveExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2186:1: ( rule__AdditiveExpression__Group_1__0__Impl rule__AdditiveExpression__Group_1__1 )
            // InternalOcl.g:2187:2: rule__AdditiveExpression__Group_1__0__Impl rule__AdditiveExpression__Group_1__1
            {
            pushFollow(FOLLOW_6);
            rule__AdditiveExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AdditiveExpression__Group_1__1();

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
    // $ANTLR end "rule__AdditiveExpression__Group_1__0"


    // $ANTLR start "rule__AdditiveExpression__Group_1__0__Impl"
    // InternalOcl.g:2194:1: rule__AdditiveExpression__Group_1__0__Impl : ( ( rule__AdditiveExpression__OpAssignment_1_0 ) ) ;
    public final void rule__AdditiveExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2198:1: ( ( ( rule__AdditiveExpression__OpAssignment_1_0 ) ) )
            // InternalOcl.g:2199:1: ( ( rule__AdditiveExpression__OpAssignment_1_0 ) )
            {
            // InternalOcl.g:2199:1: ( ( rule__AdditiveExpression__OpAssignment_1_0 ) )
            // InternalOcl.g:2200:2: ( rule__AdditiveExpression__OpAssignment_1_0 )
            {
             before(grammarAccess.getAdditiveExpressionAccess().getOpAssignment_1_0()); 
            // InternalOcl.g:2201:2: ( rule__AdditiveExpression__OpAssignment_1_0 )
            // InternalOcl.g:2201:3: rule__AdditiveExpression__OpAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__AdditiveExpression__OpAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getAdditiveExpressionAccess().getOpAssignment_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpression__Group_1__0__Impl"


    // $ANTLR start "rule__AdditiveExpression__Group_1__1"
    // InternalOcl.g:2209:1: rule__AdditiveExpression__Group_1__1 : rule__AdditiveExpression__Group_1__1__Impl ;
    public final void rule__AdditiveExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2213:1: ( rule__AdditiveExpression__Group_1__1__Impl )
            // InternalOcl.g:2214:2: rule__AdditiveExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AdditiveExpression__Group_1__1__Impl();

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
    // $ANTLR end "rule__AdditiveExpression__Group_1__1"


    // $ANTLR start "rule__AdditiveExpression__Group_1__1__Impl"
    // InternalOcl.g:2220:1: rule__AdditiveExpression__Group_1__1__Impl : ( ( rule__AdditiveExpression__ExpAssignment_1_1 ) ) ;
    public final void rule__AdditiveExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2224:1: ( ( ( rule__AdditiveExpression__ExpAssignment_1_1 ) ) )
            // InternalOcl.g:2225:1: ( ( rule__AdditiveExpression__ExpAssignment_1_1 ) )
            {
            // InternalOcl.g:2225:1: ( ( rule__AdditiveExpression__ExpAssignment_1_1 ) )
            // InternalOcl.g:2226:2: ( rule__AdditiveExpression__ExpAssignment_1_1 )
            {
             before(grammarAccess.getAdditiveExpressionAccess().getExpAssignment_1_1()); 
            // InternalOcl.g:2227:2: ( rule__AdditiveExpression__ExpAssignment_1_1 )
            // InternalOcl.g:2227:3: rule__AdditiveExpression__ExpAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__AdditiveExpression__ExpAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getAdditiveExpressionAccess().getExpAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpression__Group_1__1__Impl"


    // $ANTLR start "rule__MultiplicativeExpression__Group__0"
    // InternalOcl.g:2236:1: rule__MultiplicativeExpression__Group__0 : rule__MultiplicativeExpression__Group__0__Impl rule__MultiplicativeExpression__Group__1 ;
    public final void rule__MultiplicativeExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2240:1: ( rule__MultiplicativeExpression__Group__0__Impl rule__MultiplicativeExpression__Group__1 )
            // InternalOcl.g:2241:2: rule__MultiplicativeExpression__Group__0__Impl rule__MultiplicativeExpression__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__MultiplicativeExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiplicativeExpression__Group__1();

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
    // $ANTLR end "rule__MultiplicativeExpression__Group__0"


    // $ANTLR start "rule__MultiplicativeExpression__Group__0__Impl"
    // InternalOcl.g:2248:1: rule__MultiplicativeExpression__Group__0__Impl : ( ( rule__MultiplicativeExpression__ExpAssignment_0 ) ) ;
    public final void rule__MultiplicativeExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2252:1: ( ( ( rule__MultiplicativeExpression__ExpAssignment_0 ) ) )
            // InternalOcl.g:2253:1: ( ( rule__MultiplicativeExpression__ExpAssignment_0 ) )
            {
            // InternalOcl.g:2253:1: ( ( rule__MultiplicativeExpression__ExpAssignment_0 ) )
            // InternalOcl.g:2254:2: ( rule__MultiplicativeExpression__ExpAssignment_0 )
            {
             before(grammarAccess.getMultiplicativeExpressionAccess().getExpAssignment_0()); 
            // InternalOcl.g:2255:2: ( rule__MultiplicativeExpression__ExpAssignment_0 )
            // InternalOcl.g:2255:3: rule__MultiplicativeExpression__ExpAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__MultiplicativeExpression__ExpAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getMultiplicativeExpressionAccess().getExpAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpression__Group__0__Impl"


    // $ANTLR start "rule__MultiplicativeExpression__Group__1"
    // InternalOcl.g:2263:1: rule__MultiplicativeExpression__Group__1 : rule__MultiplicativeExpression__Group__1__Impl ;
    public final void rule__MultiplicativeExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2267:1: ( rule__MultiplicativeExpression__Group__1__Impl )
            // InternalOcl.g:2268:2: rule__MultiplicativeExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MultiplicativeExpression__Group__1__Impl();

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
    // $ANTLR end "rule__MultiplicativeExpression__Group__1"


    // $ANTLR start "rule__MultiplicativeExpression__Group__1__Impl"
    // InternalOcl.g:2274:1: rule__MultiplicativeExpression__Group__1__Impl : ( ( rule__MultiplicativeExpression__Group_1__0 )* ) ;
    public final void rule__MultiplicativeExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2278:1: ( ( ( rule__MultiplicativeExpression__Group_1__0 )* ) )
            // InternalOcl.g:2279:1: ( ( rule__MultiplicativeExpression__Group_1__0 )* )
            {
            // InternalOcl.g:2279:1: ( ( rule__MultiplicativeExpression__Group_1__0 )* )
            // InternalOcl.g:2280:2: ( rule__MultiplicativeExpression__Group_1__0 )*
            {
             before(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1()); 
            // InternalOcl.g:2281:2: ( rule__MultiplicativeExpression__Group_1__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>=68 && LA28_0<=69)) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalOcl.g:2281:3: rule__MultiplicativeExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__MultiplicativeExpression__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

             after(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpression__Group__1__Impl"


    // $ANTLR start "rule__MultiplicativeExpression__Group_1__0"
    // InternalOcl.g:2290:1: rule__MultiplicativeExpression__Group_1__0 : rule__MultiplicativeExpression__Group_1__0__Impl rule__MultiplicativeExpression__Group_1__1 ;
    public final void rule__MultiplicativeExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2294:1: ( rule__MultiplicativeExpression__Group_1__0__Impl rule__MultiplicativeExpression__Group_1__1 )
            // InternalOcl.g:2295:2: rule__MultiplicativeExpression__Group_1__0__Impl rule__MultiplicativeExpression__Group_1__1
            {
            pushFollow(FOLLOW_6);
            rule__MultiplicativeExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiplicativeExpression__Group_1__1();

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
    // $ANTLR end "rule__MultiplicativeExpression__Group_1__0"


    // $ANTLR start "rule__MultiplicativeExpression__Group_1__0__Impl"
    // InternalOcl.g:2302:1: rule__MultiplicativeExpression__Group_1__0__Impl : ( ( rule__MultiplicativeExpression__OpAssignment_1_0 ) ) ;
    public final void rule__MultiplicativeExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2306:1: ( ( ( rule__MultiplicativeExpression__OpAssignment_1_0 ) ) )
            // InternalOcl.g:2307:1: ( ( rule__MultiplicativeExpression__OpAssignment_1_0 ) )
            {
            // InternalOcl.g:2307:1: ( ( rule__MultiplicativeExpression__OpAssignment_1_0 ) )
            // InternalOcl.g:2308:2: ( rule__MultiplicativeExpression__OpAssignment_1_0 )
            {
             before(grammarAccess.getMultiplicativeExpressionAccess().getOpAssignment_1_0()); 
            // InternalOcl.g:2309:2: ( rule__MultiplicativeExpression__OpAssignment_1_0 )
            // InternalOcl.g:2309:3: rule__MultiplicativeExpression__OpAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__MultiplicativeExpression__OpAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getMultiplicativeExpressionAccess().getOpAssignment_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpression__Group_1__0__Impl"


    // $ANTLR start "rule__MultiplicativeExpression__Group_1__1"
    // InternalOcl.g:2317:1: rule__MultiplicativeExpression__Group_1__1 : rule__MultiplicativeExpression__Group_1__1__Impl ;
    public final void rule__MultiplicativeExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2321:1: ( rule__MultiplicativeExpression__Group_1__1__Impl )
            // InternalOcl.g:2322:2: rule__MultiplicativeExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MultiplicativeExpression__Group_1__1__Impl();

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
    // $ANTLR end "rule__MultiplicativeExpression__Group_1__1"


    // $ANTLR start "rule__MultiplicativeExpression__Group_1__1__Impl"
    // InternalOcl.g:2328:1: rule__MultiplicativeExpression__Group_1__1__Impl : ( ( rule__MultiplicativeExpression__ExpAssignment_1_1 ) ) ;
    public final void rule__MultiplicativeExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2332:1: ( ( ( rule__MultiplicativeExpression__ExpAssignment_1_1 ) ) )
            // InternalOcl.g:2333:1: ( ( rule__MultiplicativeExpression__ExpAssignment_1_1 ) )
            {
            // InternalOcl.g:2333:1: ( ( rule__MultiplicativeExpression__ExpAssignment_1_1 ) )
            // InternalOcl.g:2334:2: ( rule__MultiplicativeExpression__ExpAssignment_1_1 )
            {
             before(grammarAccess.getMultiplicativeExpressionAccess().getExpAssignment_1_1()); 
            // InternalOcl.g:2335:2: ( rule__MultiplicativeExpression__ExpAssignment_1_1 )
            // InternalOcl.g:2335:3: rule__MultiplicativeExpression__ExpAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__MultiplicativeExpression__ExpAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getMultiplicativeExpressionAccess().getExpAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpression__Group_1__1__Impl"


    // $ANTLR start "rule__UnaryExpression__Group__0"
    // InternalOcl.g:2344:1: rule__UnaryExpression__Group__0 : rule__UnaryExpression__Group__0__Impl rule__UnaryExpression__Group__1 ;
    public final void rule__UnaryExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2348:1: ( rule__UnaryExpression__Group__0__Impl rule__UnaryExpression__Group__1 )
            // InternalOcl.g:2349:2: rule__UnaryExpression__Group__0__Impl rule__UnaryExpression__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__UnaryExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__UnaryExpression__Group__1();

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
    // $ANTLR end "rule__UnaryExpression__Group__0"


    // $ANTLR start "rule__UnaryExpression__Group__0__Impl"
    // InternalOcl.g:2356:1: rule__UnaryExpression__Group__0__Impl : ( ( rule__UnaryExpression__OpAssignment_0 )* ) ;
    public final void rule__UnaryExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2360:1: ( ( ( rule__UnaryExpression__OpAssignment_0 )* ) )
            // InternalOcl.g:2361:1: ( ( rule__UnaryExpression__OpAssignment_0 )* )
            {
            // InternalOcl.g:2361:1: ( ( rule__UnaryExpression__OpAssignment_0 )* )
            // InternalOcl.g:2362:2: ( rule__UnaryExpression__OpAssignment_0 )*
            {
             before(grammarAccess.getUnaryExpressionAccess().getOpAssignment_0()); 
            // InternalOcl.g:2363:2: ( rule__UnaryExpression__OpAssignment_0 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=66 && LA29_0<=67)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalOcl.g:2363:3: rule__UnaryExpression__OpAssignment_0
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__UnaryExpression__OpAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

             after(grammarAccess.getUnaryExpressionAccess().getOpAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryExpression__Group__0__Impl"


    // $ANTLR start "rule__UnaryExpression__Group__1"
    // InternalOcl.g:2371:1: rule__UnaryExpression__Group__1 : rule__UnaryExpression__Group__1__Impl ;
    public final void rule__UnaryExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2375:1: ( rule__UnaryExpression__Group__1__Impl )
            // InternalOcl.g:2376:2: rule__UnaryExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__UnaryExpression__Group__1__Impl();

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
    // $ANTLR end "rule__UnaryExpression__Group__1"


    // $ANTLR start "rule__UnaryExpression__Group__1__Impl"
    // InternalOcl.g:2382:1: rule__UnaryExpression__Group__1__Impl : ( ( rule__UnaryExpression__ExpAssignment_1 ) ) ;
    public final void rule__UnaryExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2386:1: ( ( ( rule__UnaryExpression__ExpAssignment_1 ) ) )
            // InternalOcl.g:2387:1: ( ( rule__UnaryExpression__ExpAssignment_1 ) )
            {
            // InternalOcl.g:2387:1: ( ( rule__UnaryExpression__ExpAssignment_1 ) )
            // InternalOcl.g:2388:2: ( rule__UnaryExpression__ExpAssignment_1 )
            {
             before(grammarAccess.getUnaryExpressionAccess().getExpAssignment_1()); 
            // InternalOcl.g:2389:2: ( rule__UnaryExpression__ExpAssignment_1 )
            // InternalOcl.g:2389:3: rule__UnaryExpression__ExpAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__UnaryExpression__ExpAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getUnaryExpressionAccess().getExpAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryExpression__Group__1__Impl"


    // $ANTLR start "rule__PostfixExpression__Group__0"
    // InternalOcl.g:2398:1: rule__PostfixExpression__Group__0 : rule__PostfixExpression__Group__0__Impl rule__PostfixExpression__Group__1 ;
    public final void rule__PostfixExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2402:1: ( rule__PostfixExpression__Group__0__Impl rule__PostfixExpression__Group__1 )
            // InternalOcl.g:2403:2: rule__PostfixExpression__Group__0__Impl rule__PostfixExpression__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__PostfixExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PostfixExpression__Group__1();

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
    // $ANTLR end "rule__PostfixExpression__Group__0"


    // $ANTLR start "rule__PostfixExpression__Group__0__Impl"
    // InternalOcl.g:2410:1: rule__PostfixExpression__Group__0__Impl : ( rulePrimaryExpression ) ;
    public final void rule__PostfixExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2414:1: ( ( rulePrimaryExpression ) )
            // InternalOcl.g:2415:1: ( rulePrimaryExpression )
            {
            // InternalOcl.g:2415:1: ( rulePrimaryExpression )
            // InternalOcl.g:2416:2: rulePrimaryExpression
            {
             before(grammarAccess.getPostfixExpressionAccess().getPrimaryExpressionParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            rulePrimaryExpression();

            state._fsp--;

             after(grammarAccess.getPostfixExpressionAccess().getPrimaryExpressionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PostfixExpression__Group__0__Impl"


    // $ANTLR start "rule__PostfixExpression__Group__1"
    // InternalOcl.g:2425:1: rule__PostfixExpression__Group__1 : rule__PostfixExpression__Group__1__Impl ;
    public final void rule__PostfixExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2429:1: ( rule__PostfixExpression__Group__1__Impl )
            // InternalOcl.g:2430:2: rule__PostfixExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PostfixExpression__Group__1__Impl();

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
    // $ANTLR end "rule__PostfixExpression__Group__1"


    // $ANTLR start "rule__PostfixExpression__Group__1__Impl"
    // InternalOcl.g:2436:1: rule__PostfixExpression__Group__1__Impl : ( ( rule__PostfixExpression__Group_1__0 )* ) ;
    public final void rule__PostfixExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2440:1: ( ( ( rule__PostfixExpression__Group_1__0 )* ) )
            // InternalOcl.g:2441:1: ( ( rule__PostfixExpression__Group_1__0 )* )
            {
            // InternalOcl.g:2441:1: ( ( rule__PostfixExpression__Group_1__0 )* )
            // InternalOcl.g:2442:2: ( rule__PostfixExpression__Group_1__0 )*
            {
             before(grammarAccess.getPostfixExpressionAccess().getGroup_1()); 
            // InternalOcl.g:2443:2: ( rule__PostfixExpression__Group_1__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( ((LA30_0>=64 && LA30_0<=65)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalOcl.g:2443:3: rule__PostfixExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__PostfixExpression__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

             after(grammarAccess.getPostfixExpressionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PostfixExpression__Group__1__Impl"


    // $ANTLR start "rule__PostfixExpression__Group_1__0"
    // InternalOcl.g:2452:1: rule__PostfixExpression__Group_1__0 : rule__PostfixExpression__Group_1__0__Impl rule__PostfixExpression__Group_1__1 ;
    public final void rule__PostfixExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2456:1: ( rule__PostfixExpression__Group_1__0__Impl rule__PostfixExpression__Group_1__1 )
            // InternalOcl.g:2457:2: rule__PostfixExpression__Group_1__0__Impl rule__PostfixExpression__Group_1__1
            {
            pushFollow(FOLLOW_17);
            rule__PostfixExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PostfixExpression__Group_1__1();

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
    // $ANTLR end "rule__PostfixExpression__Group_1__0"


    // $ANTLR start "rule__PostfixExpression__Group_1__0__Impl"
    // InternalOcl.g:2464:1: rule__PostfixExpression__Group_1__0__Impl : ( ( rule__PostfixExpression__OpAssignment_1_0 ) ) ;
    public final void rule__PostfixExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2468:1: ( ( ( rule__PostfixExpression__OpAssignment_1_0 ) ) )
            // InternalOcl.g:2469:1: ( ( rule__PostfixExpression__OpAssignment_1_0 ) )
            {
            // InternalOcl.g:2469:1: ( ( rule__PostfixExpression__OpAssignment_1_0 ) )
            // InternalOcl.g:2470:2: ( rule__PostfixExpression__OpAssignment_1_0 )
            {
             before(grammarAccess.getPostfixExpressionAccess().getOpAssignment_1_0()); 
            // InternalOcl.g:2471:2: ( rule__PostfixExpression__OpAssignment_1_0 )
            // InternalOcl.g:2471:3: rule__PostfixExpression__OpAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__PostfixExpression__OpAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getPostfixExpressionAccess().getOpAssignment_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PostfixExpression__Group_1__0__Impl"


    // $ANTLR start "rule__PostfixExpression__Group_1__1"
    // InternalOcl.g:2479:1: rule__PostfixExpression__Group_1__1 : rule__PostfixExpression__Group_1__1__Impl ;
    public final void rule__PostfixExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2483:1: ( rule__PostfixExpression__Group_1__1__Impl )
            // InternalOcl.g:2484:2: rule__PostfixExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PostfixExpression__Group_1__1__Impl();

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
    // $ANTLR end "rule__PostfixExpression__Group_1__1"


    // $ANTLR start "rule__PostfixExpression__Group_1__1__Impl"
    // InternalOcl.g:2490:1: rule__PostfixExpression__Group_1__1__Impl : ( ( rule__PostfixExpression__FeaturesAssignment_1_1 ) ) ;
    public final void rule__PostfixExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2494:1: ( ( ( rule__PostfixExpression__FeaturesAssignment_1_1 ) ) )
            // InternalOcl.g:2495:1: ( ( rule__PostfixExpression__FeaturesAssignment_1_1 ) )
            {
            // InternalOcl.g:2495:1: ( ( rule__PostfixExpression__FeaturesAssignment_1_1 ) )
            // InternalOcl.g:2496:2: ( rule__PostfixExpression__FeaturesAssignment_1_1 )
            {
             before(grammarAccess.getPostfixExpressionAccess().getFeaturesAssignment_1_1()); 
            // InternalOcl.g:2497:2: ( rule__PostfixExpression__FeaturesAssignment_1_1 )
            // InternalOcl.g:2497:3: rule__PostfixExpression__FeaturesAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__PostfixExpression__FeaturesAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getPostfixExpressionAccess().getFeaturesAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PostfixExpression__Group_1__1__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_3__0"
    // InternalOcl.g:2506:1: rule__PrimaryExpression__Group_3__0 : rule__PrimaryExpression__Group_3__0__Impl rule__PrimaryExpression__Group_3__1 ;
    public final void rule__PrimaryExpression__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2510:1: ( rule__PrimaryExpression__Group_3__0__Impl rule__PrimaryExpression__Group_3__1 )
            // InternalOcl.g:2511:2: rule__PrimaryExpression__Group_3__0__Impl rule__PrimaryExpression__Group_3__1
            {
            pushFollow(FOLLOW_6);
            rule__PrimaryExpression__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__Group_3__1();

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
    // $ANTLR end "rule__PrimaryExpression__Group_3__0"


    // $ANTLR start "rule__PrimaryExpression__Group_3__0__Impl"
    // InternalOcl.g:2518:1: rule__PrimaryExpression__Group_3__0__Impl : ( '(' ) ;
    public final void rule__PrimaryExpression__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2522:1: ( ( '(' ) )
            // InternalOcl.g:2523:1: ( '(' )
            {
            // InternalOcl.g:2523:1: ( '(' )
            // InternalOcl.g:2524:2: '('
            {
             before(grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_3_0()); 
            match(input,82,FOLLOW_2); 
             after(grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_3__0__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_3__1"
    // InternalOcl.g:2533:1: rule__PrimaryExpression__Group_3__1 : rule__PrimaryExpression__Group_3__1__Impl rule__PrimaryExpression__Group_3__2 ;
    public final void rule__PrimaryExpression__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2537:1: ( rule__PrimaryExpression__Group_3__1__Impl rule__PrimaryExpression__Group_3__2 )
            // InternalOcl.g:2538:2: rule__PrimaryExpression__Group_3__1__Impl rule__PrimaryExpression__Group_3__2
            {
            pushFollow(FOLLOW_18);
            rule__PrimaryExpression__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__Group_3__2();

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
    // $ANTLR end "rule__PrimaryExpression__Group_3__1"


    // $ANTLR start "rule__PrimaryExpression__Group_3__1__Impl"
    // InternalOcl.g:2545:1: rule__PrimaryExpression__Group_3__1__Impl : ( ruleExpression ) ;
    public final void rule__PrimaryExpression__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2549:1: ( ( ruleExpression ) )
            // InternalOcl.g:2550:1: ( ruleExpression )
            {
            // InternalOcl.g:2550:1: ( ruleExpression )
            // InternalOcl.g:2551:2: ruleExpression
            {
             before(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_3_1()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_3__1__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_3__2"
    // InternalOcl.g:2560:1: rule__PrimaryExpression__Group_3__2 : rule__PrimaryExpression__Group_3__2__Impl ;
    public final void rule__PrimaryExpression__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2564:1: ( rule__PrimaryExpression__Group_3__2__Impl )
            // InternalOcl.g:2565:2: rule__PrimaryExpression__Group_3__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__Group_3__2__Impl();

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
    // $ANTLR end "rule__PrimaryExpression__Group_3__2"


    // $ANTLR start "rule__PrimaryExpression__Group_3__2__Impl"
    // InternalOcl.g:2571:1: rule__PrimaryExpression__Group_3__2__Impl : ( ')' ) ;
    public final void rule__PrimaryExpression__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2575:1: ( ( ')' ) )
            // InternalOcl.g:2576:1: ( ')' )
            {
            // InternalOcl.g:2576:1: ( ')' )
            // InternalOcl.g:2577:2: ')'
            {
             before(grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_3_2()); 
            match(input,83,FOLLOW_2); 
             after(grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_3__2__Impl"


    // $ANTLR start "rule__IfExpression__Group__0"
    // InternalOcl.g:2587:1: rule__IfExpression__Group__0 : rule__IfExpression__Group__0__Impl rule__IfExpression__Group__1 ;
    public final void rule__IfExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2591:1: ( rule__IfExpression__Group__0__Impl rule__IfExpression__Group__1 )
            // InternalOcl.g:2592:2: rule__IfExpression__Group__0__Impl rule__IfExpression__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__IfExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IfExpression__Group__1();

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
    // $ANTLR end "rule__IfExpression__Group__0"


    // $ANTLR start "rule__IfExpression__Group__0__Impl"
    // InternalOcl.g:2599:1: rule__IfExpression__Group__0__Impl : ( 'if' ) ;
    public final void rule__IfExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2603:1: ( ( 'if' ) )
            // InternalOcl.g:2604:1: ( 'if' )
            {
            // InternalOcl.g:2604:1: ( 'if' )
            // InternalOcl.g:2605:2: 'if'
            {
             before(grammarAccess.getIfExpressionAccess().getIfKeyword_0()); 
            match(input,84,FOLLOW_2); 
             after(grammarAccess.getIfExpressionAccess().getIfKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExpression__Group__0__Impl"


    // $ANTLR start "rule__IfExpression__Group__1"
    // InternalOcl.g:2614:1: rule__IfExpression__Group__1 : rule__IfExpression__Group__1__Impl rule__IfExpression__Group__2 ;
    public final void rule__IfExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2618:1: ( rule__IfExpression__Group__1__Impl rule__IfExpression__Group__2 )
            // InternalOcl.g:2619:2: rule__IfExpression__Group__1__Impl rule__IfExpression__Group__2
            {
            pushFollow(FOLLOW_19);
            rule__IfExpression__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IfExpression__Group__2();

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
    // $ANTLR end "rule__IfExpression__Group__1"


    // $ANTLR start "rule__IfExpression__Group__1__Impl"
    // InternalOcl.g:2626:1: rule__IfExpression__Group__1__Impl : ( ( rule__IfExpression__ExpAssignment_1 ) ) ;
    public final void rule__IfExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2630:1: ( ( ( rule__IfExpression__ExpAssignment_1 ) ) )
            // InternalOcl.g:2631:1: ( ( rule__IfExpression__ExpAssignment_1 ) )
            {
            // InternalOcl.g:2631:1: ( ( rule__IfExpression__ExpAssignment_1 ) )
            // InternalOcl.g:2632:2: ( rule__IfExpression__ExpAssignment_1 )
            {
             before(grammarAccess.getIfExpressionAccess().getExpAssignment_1()); 
            // InternalOcl.g:2633:2: ( rule__IfExpression__ExpAssignment_1 )
            // InternalOcl.g:2633:3: rule__IfExpression__ExpAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__IfExpression__ExpAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getIfExpressionAccess().getExpAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExpression__Group__1__Impl"


    // $ANTLR start "rule__IfExpression__Group__2"
    // InternalOcl.g:2641:1: rule__IfExpression__Group__2 : rule__IfExpression__Group__2__Impl rule__IfExpression__Group__3 ;
    public final void rule__IfExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2645:1: ( rule__IfExpression__Group__2__Impl rule__IfExpression__Group__3 )
            // InternalOcl.g:2646:2: rule__IfExpression__Group__2__Impl rule__IfExpression__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__IfExpression__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IfExpression__Group__3();

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
    // $ANTLR end "rule__IfExpression__Group__2"


    // $ANTLR start "rule__IfExpression__Group__2__Impl"
    // InternalOcl.g:2653:1: rule__IfExpression__Group__2__Impl : ( 'then' ) ;
    public final void rule__IfExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2657:1: ( ( 'then' ) )
            // InternalOcl.g:2658:1: ( 'then' )
            {
            // InternalOcl.g:2658:1: ( 'then' )
            // InternalOcl.g:2659:2: 'then'
            {
             before(grammarAccess.getIfExpressionAccess().getThenKeyword_2()); 
            match(input,85,FOLLOW_2); 
             after(grammarAccess.getIfExpressionAccess().getThenKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExpression__Group__2__Impl"


    // $ANTLR start "rule__IfExpression__Group__3"
    // InternalOcl.g:2668:1: rule__IfExpression__Group__3 : rule__IfExpression__Group__3__Impl rule__IfExpression__Group__4 ;
    public final void rule__IfExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2672:1: ( rule__IfExpression__Group__3__Impl rule__IfExpression__Group__4 )
            // InternalOcl.g:2673:2: rule__IfExpression__Group__3__Impl rule__IfExpression__Group__4
            {
            pushFollow(FOLLOW_20);
            rule__IfExpression__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IfExpression__Group__4();

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
    // $ANTLR end "rule__IfExpression__Group__3"


    // $ANTLR start "rule__IfExpression__Group__3__Impl"
    // InternalOcl.g:2680:1: rule__IfExpression__Group__3__Impl : ( ( rule__IfExpression__ExpAssignment_3 ) ) ;
    public final void rule__IfExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2684:1: ( ( ( rule__IfExpression__ExpAssignment_3 ) ) )
            // InternalOcl.g:2685:1: ( ( rule__IfExpression__ExpAssignment_3 ) )
            {
            // InternalOcl.g:2685:1: ( ( rule__IfExpression__ExpAssignment_3 ) )
            // InternalOcl.g:2686:2: ( rule__IfExpression__ExpAssignment_3 )
            {
             before(grammarAccess.getIfExpressionAccess().getExpAssignment_3()); 
            // InternalOcl.g:2687:2: ( rule__IfExpression__ExpAssignment_3 )
            // InternalOcl.g:2687:3: rule__IfExpression__ExpAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__IfExpression__ExpAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getIfExpressionAccess().getExpAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExpression__Group__3__Impl"


    // $ANTLR start "rule__IfExpression__Group__4"
    // InternalOcl.g:2695:1: rule__IfExpression__Group__4 : rule__IfExpression__Group__4__Impl rule__IfExpression__Group__5 ;
    public final void rule__IfExpression__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2699:1: ( rule__IfExpression__Group__4__Impl rule__IfExpression__Group__5 )
            // InternalOcl.g:2700:2: rule__IfExpression__Group__4__Impl rule__IfExpression__Group__5
            {
            pushFollow(FOLLOW_20);
            rule__IfExpression__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IfExpression__Group__5();

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
    // $ANTLR end "rule__IfExpression__Group__4"


    // $ANTLR start "rule__IfExpression__Group__4__Impl"
    // InternalOcl.g:2707:1: rule__IfExpression__Group__4__Impl : ( ( rule__IfExpression__Group_4__0 )? ) ;
    public final void rule__IfExpression__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2711:1: ( ( ( rule__IfExpression__Group_4__0 )? ) )
            // InternalOcl.g:2712:1: ( ( rule__IfExpression__Group_4__0 )? )
            {
            // InternalOcl.g:2712:1: ( ( rule__IfExpression__Group_4__0 )? )
            // InternalOcl.g:2713:2: ( rule__IfExpression__Group_4__0 )?
            {
             before(grammarAccess.getIfExpressionAccess().getGroup_4()); 
            // InternalOcl.g:2714:2: ( rule__IfExpression__Group_4__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==87) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalOcl.g:2714:3: rule__IfExpression__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__IfExpression__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getIfExpressionAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExpression__Group__4__Impl"


    // $ANTLR start "rule__IfExpression__Group__5"
    // InternalOcl.g:2722:1: rule__IfExpression__Group__5 : rule__IfExpression__Group__5__Impl ;
    public final void rule__IfExpression__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2726:1: ( rule__IfExpression__Group__5__Impl )
            // InternalOcl.g:2727:2: rule__IfExpression__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IfExpression__Group__5__Impl();

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
    // $ANTLR end "rule__IfExpression__Group__5"


    // $ANTLR start "rule__IfExpression__Group__5__Impl"
    // InternalOcl.g:2733:1: rule__IfExpression__Group__5__Impl : ( 'endif' ) ;
    public final void rule__IfExpression__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2737:1: ( ( 'endif' ) )
            // InternalOcl.g:2738:1: ( 'endif' )
            {
            // InternalOcl.g:2738:1: ( 'endif' )
            // InternalOcl.g:2739:2: 'endif'
            {
             before(grammarAccess.getIfExpressionAccess().getEndifKeyword_5()); 
            match(input,86,FOLLOW_2); 
             after(grammarAccess.getIfExpressionAccess().getEndifKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExpression__Group__5__Impl"


    // $ANTLR start "rule__IfExpression__Group_4__0"
    // InternalOcl.g:2749:1: rule__IfExpression__Group_4__0 : rule__IfExpression__Group_4__0__Impl rule__IfExpression__Group_4__1 ;
    public final void rule__IfExpression__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2753:1: ( rule__IfExpression__Group_4__0__Impl rule__IfExpression__Group_4__1 )
            // InternalOcl.g:2754:2: rule__IfExpression__Group_4__0__Impl rule__IfExpression__Group_4__1
            {
            pushFollow(FOLLOW_6);
            rule__IfExpression__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IfExpression__Group_4__1();

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
    // $ANTLR end "rule__IfExpression__Group_4__0"


    // $ANTLR start "rule__IfExpression__Group_4__0__Impl"
    // InternalOcl.g:2761:1: rule__IfExpression__Group_4__0__Impl : ( 'else' ) ;
    public final void rule__IfExpression__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2765:1: ( ( 'else' ) )
            // InternalOcl.g:2766:1: ( 'else' )
            {
            // InternalOcl.g:2766:1: ( 'else' )
            // InternalOcl.g:2767:2: 'else'
            {
             before(grammarAccess.getIfExpressionAccess().getElseKeyword_4_0()); 
            match(input,87,FOLLOW_2); 
             after(grammarAccess.getIfExpressionAccess().getElseKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExpression__Group_4__0__Impl"


    // $ANTLR start "rule__IfExpression__Group_4__1"
    // InternalOcl.g:2776:1: rule__IfExpression__Group_4__1 : rule__IfExpression__Group_4__1__Impl ;
    public final void rule__IfExpression__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2780:1: ( rule__IfExpression__Group_4__1__Impl )
            // InternalOcl.g:2781:2: rule__IfExpression__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IfExpression__Group_4__1__Impl();

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
    // $ANTLR end "rule__IfExpression__Group_4__1"


    // $ANTLR start "rule__IfExpression__Group_4__1__Impl"
    // InternalOcl.g:2787:1: rule__IfExpression__Group_4__1__Impl : ( ( rule__IfExpression__ExpAssignment_4_1 ) ) ;
    public final void rule__IfExpression__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2791:1: ( ( ( rule__IfExpression__ExpAssignment_4_1 ) ) )
            // InternalOcl.g:2792:1: ( ( rule__IfExpression__ExpAssignment_4_1 ) )
            {
            // InternalOcl.g:2792:1: ( ( rule__IfExpression__ExpAssignment_4_1 ) )
            // InternalOcl.g:2793:2: ( rule__IfExpression__ExpAssignment_4_1 )
            {
             before(grammarAccess.getIfExpressionAccess().getExpAssignment_4_1()); 
            // InternalOcl.g:2794:2: ( rule__IfExpression__ExpAssignment_4_1 )
            // InternalOcl.g:2794:3: rule__IfExpression__ExpAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__IfExpression__ExpAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getIfExpressionAccess().getExpAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExpression__Group_4__1__Impl"


    // $ANTLR start "rule__FeatureCallParameters__Group__0"
    // InternalOcl.g:2803:1: rule__FeatureCallParameters__Group__0 : rule__FeatureCallParameters__Group__0__Impl rule__FeatureCallParameters__Group__1 ;
    public final void rule__FeatureCallParameters__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2807:1: ( rule__FeatureCallParameters__Group__0__Impl rule__FeatureCallParameters__Group__1 )
            // InternalOcl.g:2808:2: rule__FeatureCallParameters__Group__0__Impl rule__FeatureCallParameters__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__FeatureCallParameters__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FeatureCallParameters__Group__1();

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
    // $ANTLR end "rule__FeatureCallParameters__Group__0"


    // $ANTLR start "rule__FeatureCallParameters__Group__0__Impl"
    // InternalOcl.g:2815:1: rule__FeatureCallParameters__Group__0__Impl : ( '(' ) ;
    public final void rule__FeatureCallParameters__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2819:1: ( ( '(' ) )
            // InternalOcl.g:2820:1: ( '(' )
            {
            // InternalOcl.g:2820:1: ( '(' )
            // InternalOcl.g:2821:2: '('
            {
             before(grammarAccess.getFeatureCallParametersAccess().getLeftParenthesisKeyword_0()); 
            match(input,82,FOLLOW_2); 
             after(grammarAccess.getFeatureCallParametersAccess().getLeftParenthesisKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCallParameters__Group__0__Impl"


    // $ANTLR start "rule__FeatureCallParameters__Group__1"
    // InternalOcl.g:2830:1: rule__FeatureCallParameters__Group__1 : rule__FeatureCallParameters__Group__1__Impl rule__FeatureCallParameters__Group__2 ;
    public final void rule__FeatureCallParameters__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2834:1: ( rule__FeatureCallParameters__Group__1__Impl rule__FeatureCallParameters__Group__2 )
            // InternalOcl.g:2835:2: rule__FeatureCallParameters__Group__1__Impl rule__FeatureCallParameters__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__FeatureCallParameters__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FeatureCallParameters__Group__2();

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
    // $ANTLR end "rule__FeatureCallParameters__Group__1"


    // $ANTLR start "rule__FeatureCallParameters__Group__1__Impl"
    // InternalOcl.g:2842:1: rule__FeatureCallParameters__Group__1__Impl : ( ( rule__FeatureCallParameters__DecsAssignment_1 )? ) ;
    public final void rule__FeatureCallParameters__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2846:1: ( ( ( rule__FeatureCallParameters__DecsAssignment_1 )? ) )
            // InternalOcl.g:2847:1: ( ( rule__FeatureCallParameters__DecsAssignment_1 )? )
            {
            // InternalOcl.g:2847:1: ( ( rule__FeatureCallParameters__DecsAssignment_1 )? )
            // InternalOcl.g:2848:2: ( rule__FeatureCallParameters__DecsAssignment_1 )?
            {
             before(grammarAccess.getFeatureCallParametersAccess().getDecsAssignment_1()); 
            // InternalOcl.g:2849:2: ( rule__FeatureCallParameters__DecsAssignment_1 )?
            int alt32=2;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // InternalOcl.g:2849:3: rule__FeatureCallParameters__DecsAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__FeatureCallParameters__DecsAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFeatureCallParametersAccess().getDecsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCallParameters__Group__1__Impl"


    // $ANTLR start "rule__FeatureCallParameters__Group__2"
    // InternalOcl.g:2857:1: rule__FeatureCallParameters__Group__2 : rule__FeatureCallParameters__Group__2__Impl rule__FeatureCallParameters__Group__3 ;
    public final void rule__FeatureCallParameters__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2861:1: ( rule__FeatureCallParameters__Group__2__Impl rule__FeatureCallParameters__Group__3 )
            // InternalOcl.g:2862:2: rule__FeatureCallParameters__Group__2__Impl rule__FeatureCallParameters__Group__3
            {
            pushFollow(FOLLOW_18);
            rule__FeatureCallParameters__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FeatureCallParameters__Group__3();

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
    // $ANTLR end "rule__FeatureCallParameters__Group__2"


    // $ANTLR start "rule__FeatureCallParameters__Group__2__Impl"
    // InternalOcl.g:2869:1: rule__FeatureCallParameters__Group__2__Impl : ( ( rule__FeatureCallParameters__ParamsAssignment_2 ) ) ;
    public final void rule__FeatureCallParameters__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2873:1: ( ( ( rule__FeatureCallParameters__ParamsAssignment_2 ) ) )
            // InternalOcl.g:2874:1: ( ( rule__FeatureCallParameters__ParamsAssignment_2 ) )
            {
            // InternalOcl.g:2874:1: ( ( rule__FeatureCallParameters__ParamsAssignment_2 ) )
            // InternalOcl.g:2875:2: ( rule__FeatureCallParameters__ParamsAssignment_2 )
            {
             before(grammarAccess.getFeatureCallParametersAccess().getParamsAssignment_2()); 
            // InternalOcl.g:2876:2: ( rule__FeatureCallParameters__ParamsAssignment_2 )
            // InternalOcl.g:2876:3: rule__FeatureCallParameters__ParamsAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__FeatureCallParameters__ParamsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getFeatureCallParametersAccess().getParamsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCallParameters__Group__2__Impl"


    // $ANTLR start "rule__FeatureCallParameters__Group__3"
    // InternalOcl.g:2884:1: rule__FeatureCallParameters__Group__3 : rule__FeatureCallParameters__Group__3__Impl ;
    public final void rule__FeatureCallParameters__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2888:1: ( rule__FeatureCallParameters__Group__3__Impl )
            // InternalOcl.g:2889:2: rule__FeatureCallParameters__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FeatureCallParameters__Group__3__Impl();

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
    // $ANTLR end "rule__FeatureCallParameters__Group__3"


    // $ANTLR start "rule__FeatureCallParameters__Group__3__Impl"
    // InternalOcl.g:2895:1: rule__FeatureCallParameters__Group__3__Impl : ( ')' ) ;
    public final void rule__FeatureCallParameters__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2899:1: ( ( ')' ) )
            // InternalOcl.g:2900:1: ( ')' )
            {
            // InternalOcl.g:2900:1: ( ')' )
            // InternalOcl.g:2901:2: ')'
            {
             before(grammarAccess.getFeatureCallParametersAccess().getRightParenthesisKeyword_3()); 
            match(input,83,FOLLOW_2); 
             after(grammarAccess.getFeatureCallParametersAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCallParameters__Group__3__Impl"


    // $ANTLR start "rule__Literal__Group_2__0"
    // InternalOcl.g:2911:1: rule__Literal__Group_2__0 : rule__Literal__Group_2__0__Impl rule__Literal__Group_2__1 ;
    public final void rule__Literal__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2915:1: ( rule__Literal__Group_2__0__Impl rule__Literal__Group_2__1 )
            // InternalOcl.g:2916:2: rule__Literal__Group_2__0__Impl rule__Literal__Group_2__1
            {
            pushFollow(FOLLOW_21);
            rule__Literal__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Literal__Group_2__1();

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
    // $ANTLR end "rule__Literal__Group_2__0"


    // $ANTLR start "rule__Literal__Group_2__0__Impl"
    // InternalOcl.g:2923:1: rule__Literal__Group_2__0__Impl : ( '#' ) ;
    public final void rule__Literal__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2927:1: ( ( '#' ) )
            // InternalOcl.g:2928:1: ( '#' )
            {
            // InternalOcl.g:2928:1: ( '#' )
            // InternalOcl.g:2929:2: '#'
            {
             before(grammarAccess.getLiteralAccess().getNumberSignKeyword_2_0()); 
            match(input,88,FOLLOW_2); 
             after(grammarAccess.getLiteralAccess().getNumberSignKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_2__0__Impl"


    // $ANTLR start "rule__Literal__Group_2__1"
    // InternalOcl.g:2938:1: rule__Literal__Group_2__1 : rule__Literal__Group_2__1__Impl ;
    public final void rule__Literal__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2942:1: ( rule__Literal__Group_2__1__Impl )
            // InternalOcl.g:2943:2: rule__Literal__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Literal__Group_2__1__Impl();

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
    // $ANTLR end "rule__Literal__Group_2__1"


    // $ANTLR start "rule__Literal__Group_2__1__Impl"
    // InternalOcl.g:2949:1: rule__Literal__Group_2__1__Impl : ( ( rule__Literal__NameAssignment_2_1 ) ) ;
    public final void rule__Literal__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2953:1: ( ( ( rule__Literal__NameAssignment_2_1 ) ) )
            // InternalOcl.g:2954:1: ( ( rule__Literal__NameAssignment_2_1 ) )
            {
            // InternalOcl.g:2954:1: ( ( rule__Literal__NameAssignment_2_1 ) )
            // InternalOcl.g:2955:2: ( rule__Literal__NameAssignment_2_1 )
            {
             before(grammarAccess.getLiteralAccess().getNameAssignment_2_1()); 
            // InternalOcl.g:2956:2: ( rule__Literal__NameAssignment_2_1 )
            // InternalOcl.g:2956:3: rule__Literal__NameAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Literal__NameAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getLiteralAccess().getNameAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_2__1__Impl"


    // $ANTLR start "rule__EnumerationType__Group__0"
    // InternalOcl.g:2965:1: rule__EnumerationType__Group__0 : rule__EnumerationType__Group__0__Impl rule__EnumerationType__Group__1 ;
    public final void rule__EnumerationType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2969:1: ( rule__EnumerationType__Group__0__Impl rule__EnumerationType__Group__1 )
            // InternalOcl.g:2970:2: rule__EnumerationType__Group__0__Impl rule__EnumerationType__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__EnumerationType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EnumerationType__Group__1();

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
    // $ANTLR end "rule__EnumerationType__Group__0"


    // $ANTLR start "rule__EnumerationType__Group__0__Impl"
    // InternalOcl.g:2977:1: rule__EnumerationType__Group__0__Impl : ( 'enum' ) ;
    public final void rule__EnumerationType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2981:1: ( ( 'enum' ) )
            // InternalOcl.g:2982:1: ( 'enum' )
            {
            // InternalOcl.g:2982:1: ( 'enum' )
            // InternalOcl.g:2983:2: 'enum'
            {
             before(grammarAccess.getEnumerationTypeAccess().getEnumKeyword_0()); 
            match(input,89,FOLLOW_2); 
             after(grammarAccess.getEnumerationTypeAccess().getEnumKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationType__Group__0__Impl"


    // $ANTLR start "rule__EnumerationType__Group__1"
    // InternalOcl.g:2992:1: rule__EnumerationType__Group__1 : rule__EnumerationType__Group__1__Impl rule__EnumerationType__Group__2 ;
    public final void rule__EnumerationType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:2996:1: ( rule__EnumerationType__Group__1__Impl rule__EnumerationType__Group__2 )
            // InternalOcl.g:2997:2: rule__EnumerationType__Group__1__Impl rule__EnumerationType__Group__2
            {
            pushFollow(FOLLOW_23);
            rule__EnumerationType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EnumerationType__Group__2();

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
    // $ANTLR end "rule__EnumerationType__Group__1"


    // $ANTLR start "rule__EnumerationType__Group__1__Impl"
    // InternalOcl.g:3004:1: rule__EnumerationType__Group__1__Impl : ( '{' ) ;
    public final void rule__EnumerationType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3008:1: ( ( '{' ) )
            // InternalOcl.g:3009:1: ( '{' )
            {
            // InternalOcl.g:3009:1: ( '{' )
            // InternalOcl.g:3010:2: '{'
            {
             before(grammarAccess.getEnumerationTypeAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,90,FOLLOW_2); 
             after(grammarAccess.getEnumerationTypeAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationType__Group__1__Impl"


    // $ANTLR start "rule__EnumerationType__Group__2"
    // InternalOcl.g:3019:1: rule__EnumerationType__Group__2 : rule__EnumerationType__Group__2__Impl rule__EnumerationType__Group__3 ;
    public final void rule__EnumerationType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3023:1: ( rule__EnumerationType__Group__2__Impl rule__EnumerationType__Group__3 )
            // InternalOcl.g:3024:2: rule__EnumerationType__Group__2__Impl rule__EnumerationType__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__EnumerationType__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EnumerationType__Group__3();

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
    // $ANTLR end "rule__EnumerationType__Group__2"


    // $ANTLR start "rule__EnumerationType__Group__2__Impl"
    // InternalOcl.g:3031:1: rule__EnumerationType__Group__2__Impl : ( ( rule__EnumerationType__Group_2__0 ) ) ;
    public final void rule__EnumerationType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3035:1: ( ( ( rule__EnumerationType__Group_2__0 ) ) )
            // InternalOcl.g:3036:1: ( ( rule__EnumerationType__Group_2__0 ) )
            {
            // InternalOcl.g:3036:1: ( ( rule__EnumerationType__Group_2__0 ) )
            // InternalOcl.g:3037:2: ( rule__EnumerationType__Group_2__0 )
            {
             before(grammarAccess.getEnumerationTypeAccess().getGroup_2()); 
            // InternalOcl.g:3038:2: ( rule__EnumerationType__Group_2__0 )
            // InternalOcl.g:3038:3: rule__EnumerationType__Group_2__0
            {
            pushFollow(FOLLOW_2);
            rule__EnumerationType__Group_2__0();

            state._fsp--;


            }

             after(grammarAccess.getEnumerationTypeAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationType__Group__2__Impl"


    // $ANTLR start "rule__EnumerationType__Group__3"
    // InternalOcl.g:3046:1: rule__EnumerationType__Group__3 : rule__EnumerationType__Group__3__Impl rule__EnumerationType__Group__4 ;
    public final void rule__EnumerationType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3050:1: ( rule__EnumerationType__Group__3__Impl rule__EnumerationType__Group__4 )
            // InternalOcl.g:3051:2: rule__EnumerationType__Group__3__Impl rule__EnumerationType__Group__4
            {
            pushFollow(FOLLOW_24);
            rule__EnumerationType__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EnumerationType__Group__4();

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
    // $ANTLR end "rule__EnumerationType__Group__3"


    // $ANTLR start "rule__EnumerationType__Group__3__Impl"
    // InternalOcl.g:3058:1: rule__EnumerationType__Group__3__Impl : ( ( rule__EnumerationType__Group_3__0 )* ) ;
    public final void rule__EnumerationType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3062:1: ( ( ( rule__EnumerationType__Group_3__0 )* ) )
            // InternalOcl.g:3063:1: ( ( rule__EnumerationType__Group_3__0 )* )
            {
            // InternalOcl.g:3063:1: ( ( rule__EnumerationType__Group_3__0 )* )
            // InternalOcl.g:3064:2: ( rule__EnumerationType__Group_3__0 )*
            {
             before(grammarAccess.getEnumerationTypeAccess().getGroup_3()); 
            // InternalOcl.g:3065:2: ( rule__EnumerationType__Group_3__0 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==92) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalOcl.g:3065:3: rule__EnumerationType__Group_3__0
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__EnumerationType__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

             after(grammarAccess.getEnumerationTypeAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationType__Group__3__Impl"


    // $ANTLR start "rule__EnumerationType__Group__4"
    // InternalOcl.g:3073:1: rule__EnumerationType__Group__4 : rule__EnumerationType__Group__4__Impl ;
    public final void rule__EnumerationType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3077:1: ( rule__EnumerationType__Group__4__Impl )
            // InternalOcl.g:3078:2: rule__EnumerationType__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EnumerationType__Group__4__Impl();

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
    // $ANTLR end "rule__EnumerationType__Group__4"


    // $ANTLR start "rule__EnumerationType__Group__4__Impl"
    // InternalOcl.g:3084:1: rule__EnumerationType__Group__4__Impl : ( '}' ) ;
    public final void rule__EnumerationType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3088:1: ( ( '}' ) )
            // InternalOcl.g:3089:1: ( '}' )
            {
            // InternalOcl.g:3089:1: ( '}' )
            // InternalOcl.g:3090:2: '}'
            {
             before(grammarAccess.getEnumerationTypeAccess().getRightCurlyBracketKeyword_4()); 
            match(input,91,FOLLOW_2); 
             after(grammarAccess.getEnumerationTypeAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationType__Group__4__Impl"


    // $ANTLR start "rule__EnumerationType__Group_2__0"
    // InternalOcl.g:3100:1: rule__EnumerationType__Group_2__0 : rule__EnumerationType__Group_2__0__Impl rule__EnumerationType__Group_2__1 ;
    public final void rule__EnumerationType__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3104:1: ( rule__EnumerationType__Group_2__0__Impl rule__EnumerationType__Group_2__1 )
            // InternalOcl.g:3105:2: rule__EnumerationType__Group_2__0__Impl rule__EnumerationType__Group_2__1
            {
            pushFollow(FOLLOW_17);
            rule__EnumerationType__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EnumerationType__Group_2__1();

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
    // $ANTLR end "rule__EnumerationType__Group_2__0"


    // $ANTLR start "rule__EnumerationType__Group_2__0__Impl"
    // InternalOcl.g:3112:1: rule__EnumerationType__Group_2__0__Impl : ( '#' ) ;
    public final void rule__EnumerationType__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3116:1: ( ( '#' ) )
            // InternalOcl.g:3117:1: ( '#' )
            {
            // InternalOcl.g:3117:1: ( '#' )
            // InternalOcl.g:3118:2: '#'
            {
             before(grammarAccess.getEnumerationTypeAccess().getNumberSignKeyword_2_0()); 
            match(input,88,FOLLOW_2); 
             after(grammarAccess.getEnumerationTypeAccess().getNumberSignKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationType__Group_2__0__Impl"


    // $ANTLR start "rule__EnumerationType__Group_2__1"
    // InternalOcl.g:3127:1: rule__EnumerationType__Group_2__1 : rule__EnumerationType__Group_2__1__Impl ;
    public final void rule__EnumerationType__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3131:1: ( rule__EnumerationType__Group_2__1__Impl )
            // InternalOcl.g:3132:2: rule__EnumerationType__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EnumerationType__Group_2__1__Impl();

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
    // $ANTLR end "rule__EnumerationType__Group_2__1"


    // $ANTLR start "rule__EnumerationType__Group_2__1__Impl"
    // InternalOcl.g:3138:1: rule__EnumerationType__Group_2__1__Impl : ( ( rule__EnumerationType__LeftAssignment_2_1 ) ) ;
    public final void rule__EnumerationType__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3142:1: ( ( ( rule__EnumerationType__LeftAssignment_2_1 ) ) )
            // InternalOcl.g:3143:1: ( ( rule__EnumerationType__LeftAssignment_2_1 ) )
            {
            // InternalOcl.g:3143:1: ( ( rule__EnumerationType__LeftAssignment_2_1 ) )
            // InternalOcl.g:3144:2: ( rule__EnumerationType__LeftAssignment_2_1 )
            {
             before(grammarAccess.getEnumerationTypeAccess().getLeftAssignment_2_1()); 
            // InternalOcl.g:3145:2: ( rule__EnumerationType__LeftAssignment_2_1 )
            // InternalOcl.g:3145:3: rule__EnumerationType__LeftAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__EnumerationType__LeftAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getEnumerationTypeAccess().getLeftAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationType__Group_2__1__Impl"


    // $ANTLR start "rule__EnumerationType__Group_3__0"
    // InternalOcl.g:3154:1: rule__EnumerationType__Group_3__0 : rule__EnumerationType__Group_3__0__Impl rule__EnumerationType__Group_3__1 ;
    public final void rule__EnumerationType__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3158:1: ( rule__EnumerationType__Group_3__0__Impl rule__EnumerationType__Group_3__1 )
            // InternalOcl.g:3159:2: rule__EnumerationType__Group_3__0__Impl rule__EnumerationType__Group_3__1
            {
            pushFollow(FOLLOW_23);
            rule__EnumerationType__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EnumerationType__Group_3__1();

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
    // $ANTLR end "rule__EnumerationType__Group_3__0"


    // $ANTLR start "rule__EnumerationType__Group_3__0__Impl"
    // InternalOcl.g:3166:1: rule__EnumerationType__Group_3__0__Impl : ( ',' ) ;
    public final void rule__EnumerationType__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3170:1: ( ( ',' ) )
            // InternalOcl.g:3171:1: ( ',' )
            {
            // InternalOcl.g:3171:1: ( ',' )
            // InternalOcl.g:3172:2: ','
            {
             before(grammarAccess.getEnumerationTypeAccess().getCommaKeyword_3_0()); 
            match(input,92,FOLLOW_2); 
             after(grammarAccess.getEnumerationTypeAccess().getCommaKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationType__Group_3__0__Impl"


    // $ANTLR start "rule__EnumerationType__Group_3__1"
    // InternalOcl.g:3181:1: rule__EnumerationType__Group_3__1 : rule__EnumerationType__Group_3__1__Impl rule__EnumerationType__Group_3__2 ;
    public final void rule__EnumerationType__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3185:1: ( rule__EnumerationType__Group_3__1__Impl rule__EnumerationType__Group_3__2 )
            // InternalOcl.g:3186:2: rule__EnumerationType__Group_3__1__Impl rule__EnumerationType__Group_3__2
            {
            pushFollow(FOLLOW_17);
            rule__EnumerationType__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EnumerationType__Group_3__2();

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
    // $ANTLR end "rule__EnumerationType__Group_3__1"


    // $ANTLR start "rule__EnumerationType__Group_3__1__Impl"
    // InternalOcl.g:3193:1: rule__EnumerationType__Group_3__1__Impl : ( '#' ) ;
    public final void rule__EnumerationType__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3197:1: ( ( '#' ) )
            // InternalOcl.g:3198:1: ( '#' )
            {
            // InternalOcl.g:3198:1: ( '#' )
            // InternalOcl.g:3199:2: '#'
            {
             before(grammarAccess.getEnumerationTypeAccess().getNumberSignKeyword_3_1()); 
            match(input,88,FOLLOW_2); 
             after(grammarAccess.getEnumerationTypeAccess().getNumberSignKeyword_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationType__Group_3__1__Impl"


    // $ANTLR start "rule__EnumerationType__Group_3__2"
    // InternalOcl.g:3208:1: rule__EnumerationType__Group_3__2 : rule__EnumerationType__Group_3__2__Impl ;
    public final void rule__EnumerationType__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3212:1: ( rule__EnumerationType__Group_3__2__Impl )
            // InternalOcl.g:3213:2: rule__EnumerationType__Group_3__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EnumerationType__Group_3__2__Impl();

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
    // $ANTLR end "rule__EnumerationType__Group_3__2"


    // $ANTLR start "rule__EnumerationType__Group_3__2__Impl"
    // InternalOcl.g:3219:1: rule__EnumerationType__Group_3__2__Impl : ( ( rule__EnumerationType__RightsAssignment_3_2 ) ) ;
    public final void rule__EnumerationType__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3223:1: ( ( ( rule__EnumerationType__RightsAssignment_3_2 ) ) )
            // InternalOcl.g:3224:1: ( ( rule__EnumerationType__RightsAssignment_3_2 ) )
            {
            // InternalOcl.g:3224:1: ( ( rule__EnumerationType__RightsAssignment_3_2 ) )
            // InternalOcl.g:3225:2: ( rule__EnumerationType__RightsAssignment_3_2 )
            {
             before(grammarAccess.getEnumerationTypeAccess().getRightsAssignment_3_2()); 
            // InternalOcl.g:3226:2: ( rule__EnumerationType__RightsAssignment_3_2 )
            // InternalOcl.g:3226:3: rule__EnumerationType__RightsAssignment_3_2
            {
            pushFollow(FOLLOW_2);
            rule__EnumerationType__RightsAssignment_3_2();

            state._fsp--;


            }

             after(grammarAccess.getEnumerationTypeAccess().getRightsAssignment_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationType__Group_3__2__Impl"


    // $ANTLR start "rule__LiteralCollection__Group__0"
    // InternalOcl.g:3235:1: rule__LiteralCollection__Group__0 : rule__LiteralCollection__Group__0__Impl rule__LiteralCollection__Group__1 ;
    public final void rule__LiteralCollection__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3239:1: ( rule__LiteralCollection__Group__0__Impl rule__LiteralCollection__Group__1 )
            // InternalOcl.g:3240:2: rule__LiteralCollection__Group__0__Impl rule__LiteralCollection__Group__1
            {
            pushFollow(FOLLOW_25);
            rule__LiteralCollection__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LiteralCollection__Group__1();

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
    // $ANTLR end "rule__LiteralCollection__Group__0"


    // $ANTLR start "rule__LiteralCollection__Group__0__Impl"
    // InternalOcl.g:3247:1: rule__LiteralCollection__Group__0__Impl : ( () ) ;
    public final void rule__LiteralCollection__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3251:1: ( ( () ) )
            // InternalOcl.g:3252:1: ( () )
            {
            // InternalOcl.g:3252:1: ( () )
            // InternalOcl.g:3253:2: ()
            {
             before(grammarAccess.getLiteralCollectionAccess().getLiteralCollectionAction_0()); 
            // InternalOcl.g:3254:2: ()
            // InternalOcl.g:3254:3: 
            {
            }

             after(grammarAccess.getLiteralCollectionAccess().getLiteralCollectionAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralCollection__Group__0__Impl"


    // $ANTLR start "rule__LiteralCollection__Group__1"
    // InternalOcl.g:3262:1: rule__LiteralCollection__Group__1 : rule__LiteralCollection__Group__1__Impl rule__LiteralCollection__Group__2 ;
    public final void rule__LiteralCollection__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3266:1: ( rule__LiteralCollection__Group__1__Impl rule__LiteralCollection__Group__2 )
            // InternalOcl.g:3267:2: rule__LiteralCollection__Group__1__Impl rule__LiteralCollection__Group__2
            {
            pushFollow(FOLLOW_22);
            rule__LiteralCollection__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LiteralCollection__Group__2();

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
    // $ANTLR end "rule__LiteralCollection__Group__1"


    // $ANTLR start "rule__LiteralCollection__Group__1__Impl"
    // InternalOcl.g:3274:1: rule__LiteralCollection__Group__1__Impl : ( ( rule__LiteralCollection__NameAssignment_1 ) ) ;
    public final void rule__LiteralCollection__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3278:1: ( ( ( rule__LiteralCollection__NameAssignment_1 ) ) )
            // InternalOcl.g:3279:1: ( ( rule__LiteralCollection__NameAssignment_1 ) )
            {
            // InternalOcl.g:3279:1: ( ( rule__LiteralCollection__NameAssignment_1 ) )
            // InternalOcl.g:3280:2: ( rule__LiteralCollection__NameAssignment_1 )
            {
             before(grammarAccess.getLiteralCollectionAccess().getNameAssignment_1()); 
            // InternalOcl.g:3281:2: ( rule__LiteralCollection__NameAssignment_1 )
            // InternalOcl.g:3281:3: rule__LiteralCollection__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__LiteralCollection__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getLiteralCollectionAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralCollection__Group__1__Impl"


    // $ANTLR start "rule__LiteralCollection__Group__2"
    // InternalOcl.g:3289:1: rule__LiteralCollection__Group__2 : rule__LiteralCollection__Group__2__Impl rule__LiteralCollection__Group__3 ;
    public final void rule__LiteralCollection__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3293:1: ( rule__LiteralCollection__Group__2__Impl rule__LiteralCollection__Group__3 )
            // InternalOcl.g:3294:2: rule__LiteralCollection__Group__2__Impl rule__LiteralCollection__Group__3
            {
            pushFollow(FOLLOW_26);
            rule__LiteralCollection__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LiteralCollection__Group__3();

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
    // $ANTLR end "rule__LiteralCollection__Group__2"


    // $ANTLR start "rule__LiteralCollection__Group__2__Impl"
    // InternalOcl.g:3301:1: rule__LiteralCollection__Group__2__Impl : ( '{' ) ;
    public final void rule__LiteralCollection__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3305:1: ( ( '{' ) )
            // InternalOcl.g:3306:1: ( '{' )
            {
            // InternalOcl.g:3306:1: ( '{' )
            // InternalOcl.g:3307:2: '{'
            {
             before(grammarAccess.getLiteralCollectionAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,90,FOLLOW_2); 
             after(grammarAccess.getLiteralCollectionAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralCollection__Group__2__Impl"


    // $ANTLR start "rule__LiteralCollection__Group__3"
    // InternalOcl.g:3316:1: rule__LiteralCollection__Group__3 : rule__LiteralCollection__Group__3__Impl rule__LiteralCollection__Group__4 ;
    public final void rule__LiteralCollection__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3320:1: ( rule__LiteralCollection__Group__3__Impl rule__LiteralCollection__Group__4 )
            // InternalOcl.g:3321:2: rule__LiteralCollection__Group__3__Impl rule__LiteralCollection__Group__4
            {
            pushFollow(FOLLOW_26);
            rule__LiteralCollection__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LiteralCollection__Group__4();

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
    // $ANTLR end "rule__LiteralCollection__Group__3"


    // $ANTLR start "rule__LiteralCollection__Group__3__Impl"
    // InternalOcl.g:3328:1: rule__LiteralCollection__Group__3__Impl : ( ( rule__LiteralCollection__ExpAssignment_3 )? ) ;
    public final void rule__LiteralCollection__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3332:1: ( ( ( rule__LiteralCollection__ExpAssignment_3 )? ) )
            // InternalOcl.g:3333:1: ( ( rule__LiteralCollection__ExpAssignment_3 )? )
            {
            // InternalOcl.g:3333:1: ( ( rule__LiteralCollection__ExpAssignment_3 )? )
            // InternalOcl.g:3334:2: ( rule__LiteralCollection__ExpAssignment_3 )?
            {
             before(grammarAccess.getLiteralCollectionAccess().getExpAssignment_3()); 
            // InternalOcl.g:3335:2: ( rule__LiteralCollection__ExpAssignment_3 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_TYPENAME_TERMINAL||(LA34_0>=RULE_STRING && LA34_0<=RULE_NAME_TERMINAL)||(LA34_0>=24 && LA34_0<=63)||(LA34_0>=66 && LA34_0<=67)||LA34_0==82||LA34_0==84||LA34_0==88||LA34_0==99) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalOcl.g:3335:3: rule__LiteralCollection__ExpAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__LiteralCollection__ExpAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLiteralCollectionAccess().getExpAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralCollection__Group__3__Impl"


    // $ANTLR start "rule__LiteralCollection__Group__4"
    // InternalOcl.g:3343:1: rule__LiteralCollection__Group__4 : rule__LiteralCollection__Group__4__Impl ;
    public final void rule__LiteralCollection__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3347:1: ( rule__LiteralCollection__Group__4__Impl )
            // InternalOcl.g:3348:2: rule__LiteralCollection__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LiteralCollection__Group__4__Impl();

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
    // $ANTLR end "rule__LiteralCollection__Group__4"


    // $ANTLR start "rule__LiteralCollection__Group__4__Impl"
    // InternalOcl.g:3354:1: rule__LiteralCollection__Group__4__Impl : ( '}' ) ;
    public final void rule__LiteralCollection__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3358:1: ( ( '}' ) )
            // InternalOcl.g:3359:1: ( '}' )
            {
            // InternalOcl.g:3359:1: ( '}' )
            // InternalOcl.g:3360:2: '}'
            {
             before(grammarAccess.getLiteralCollectionAccess().getRightCurlyBracketKeyword_4()); 
            match(input,91,FOLLOW_2); 
             after(grammarAccess.getLiteralCollectionAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralCollection__Group__4__Impl"


    // $ANTLR start "rule__ExpressionListOrRange__Group__0"
    // InternalOcl.g:3370:1: rule__ExpressionListOrRange__Group__0 : rule__ExpressionListOrRange__Group__0__Impl rule__ExpressionListOrRange__Group__1 ;
    public final void rule__ExpressionListOrRange__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3374:1: ( rule__ExpressionListOrRange__Group__0__Impl rule__ExpressionListOrRange__Group__1 )
            // InternalOcl.g:3375:2: rule__ExpressionListOrRange__Group__0__Impl rule__ExpressionListOrRange__Group__1
            {
            pushFollow(FOLLOW_27);
            rule__ExpressionListOrRange__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExpressionListOrRange__Group__1();

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
    // $ANTLR end "rule__ExpressionListOrRange__Group__0"


    // $ANTLR start "rule__ExpressionListOrRange__Group__0__Impl"
    // InternalOcl.g:3382:1: rule__ExpressionListOrRange__Group__0__Impl : ( ( rule__ExpressionListOrRange__ExpAssignment_0 ) ) ;
    public final void rule__ExpressionListOrRange__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3386:1: ( ( ( rule__ExpressionListOrRange__ExpAssignment_0 ) ) )
            // InternalOcl.g:3387:1: ( ( rule__ExpressionListOrRange__ExpAssignment_0 ) )
            {
            // InternalOcl.g:3387:1: ( ( rule__ExpressionListOrRange__ExpAssignment_0 ) )
            // InternalOcl.g:3388:2: ( rule__ExpressionListOrRange__ExpAssignment_0 )
            {
             before(grammarAccess.getExpressionListOrRangeAccess().getExpAssignment_0()); 
            // InternalOcl.g:3389:2: ( rule__ExpressionListOrRange__ExpAssignment_0 )
            // InternalOcl.g:3389:3: rule__ExpressionListOrRange__ExpAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ExpressionListOrRange__ExpAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getExpressionListOrRangeAccess().getExpAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionListOrRange__Group__0__Impl"


    // $ANTLR start "rule__ExpressionListOrRange__Group__1"
    // InternalOcl.g:3397:1: rule__ExpressionListOrRange__Group__1 : rule__ExpressionListOrRange__Group__1__Impl ;
    public final void rule__ExpressionListOrRange__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3401:1: ( rule__ExpressionListOrRange__Group__1__Impl )
            // InternalOcl.g:3402:2: rule__ExpressionListOrRange__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExpressionListOrRange__Group__1__Impl();

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
    // $ANTLR end "rule__ExpressionListOrRange__Group__1"


    // $ANTLR start "rule__ExpressionListOrRange__Group__1__Impl"
    // InternalOcl.g:3408:1: rule__ExpressionListOrRange__Group__1__Impl : ( ( rule__ExpressionListOrRange__Alternatives_1 )? ) ;
    public final void rule__ExpressionListOrRange__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3412:1: ( ( ( rule__ExpressionListOrRange__Alternatives_1 )? ) )
            // InternalOcl.g:3413:1: ( ( rule__ExpressionListOrRange__Alternatives_1 )? )
            {
            // InternalOcl.g:3413:1: ( ( rule__ExpressionListOrRange__Alternatives_1 )? )
            // InternalOcl.g:3414:2: ( rule__ExpressionListOrRange__Alternatives_1 )?
            {
             before(grammarAccess.getExpressionListOrRangeAccess().getAlternatives_1()); 
            // InternalOcl.g:3415:2: ( rule__ExpressionListOrRange__Alternatives_1 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=92 && LA35_0<=93)) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalOcl.g:3415:3: rule__ExpressionListOrRange__Alternatives_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__ExpressionListOrRange__Alternatives_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getExpressionListOrRangeAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionListOrRange__Group__1__Impl"


    // $ANTLR start "rule__ExpressionListOrRange__Group_1_0__0"
    // InternalOcl.g:3424:1: rule__ExpressionListOrRange__Group_1_0__0 : rule__ExpressionListOrRange__Group_1_0__0__Impl rule__ExpressionListOrRange__Group_1_0__1 ;
    public final void rule__ExpressionListOrRange__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3428:1: ( rule__ExpressionListOrRange__Group_1_0__0__Impl rule__ExpressionListOrRange__Group_1_0__1 )
            // InternalOcl.g:3429:2: rule__ExpressionListOrRange__Group_1_0__0__Impl rule__ExpressionListOrRange__Group_1_0__1
            {
            pushFollow(FOLLOW_6);
            rule__ExpressionListOrRange__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExpressionListOrRange__Group_1_0__1();

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
    // $ANTLR end "rule__ExpressionListOrRange__Group_1_0__0"


    // $ANTLR start "rule__ExpressionListOrRange__Group_1_0__0__Impl"
    // InternalOcl.g:3436:1: rule__ExpressionListOrRange__Group_1_0__0__Impl : ( ',' ) ;
    public final void rule__ExpressionListOrRange__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3440:1: ( ( ',' ) )
            // InternalOcl.g:3441:1: ( ',' )
            {
            // InternalOcl.g:3441:1: ( ',' )
            // InternalOcl.g:3442:2: ','
            {
             before(grammarAccess.getExpressionListOrRangeAccess().getCommaKeyword_1_0_0()); 
            match(input,92,FOLLOW_2); 
             after(grammarAccess.getExpressionListOrRangeAccess().getCommaKeyword_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionListOrRange__Group_1_0__0__Impl"


    // $ANTLR start "rule__ExpressionListOrRange__Group_1_0__1"
    // InternalOcl.g:3451:1: rule__ExpressionListOrRange__Group_1_0__1 : rule__ExpressionListOrRange__Group_1_0__1__Impl ;
    public final void rule__ExpressionListOrRange__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3455:1: ( rule__ExpressionListOrRange__Group_1_0__1__Impl )
            // InternalOcl.g:3456:2: rule__ExpressionListOrRange__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExpressionListOrRange__Group_1_0__1__Impl();

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
    // $ANTLR end "rule__ExpressionListOrRange__Group_1_0__1"


    // $ANTLR start "rule__ExpressionListOrRange__Group_1_0__1__Impl"
    // InternalOcl.g:3462:1: rule__ExpressionListOrRange__Group_1_0__1__Impl : ( ( rule__ExpressionListOrRange__ExpAssignment_1_0_1 ) ) ;
    public final void rule__ExpressionListOrRange__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3466:1: ( ( ( rule__ExpressionListOrRange__ExpAssignment_1_0_1 ) ) )
            // InternalOcl.g:3467:1: ( ( rule__ExpressionListOrRange__ExpAssignment_1_0_1 ) )
            {
            // InternalOcl.g:3467:1: ( ( rule__ExpressionListOrRange__ExpAssignment_1_0_1 ) )
            // InternalOcl.g:3468:2: ( rule__ExpressionListOrRange__ExpAssignment_1_0_1 )
            {
             before(grammarAccess.getExpressionListOrRangeAccess().getExpAssignment_1_0_1()); 
            // InternalOcl.g:3469:2: ( rule__ExpressionListOrRange__ExpAssignment_1_0_1 )
            // InternalOcl.g:3469:3: rule__ExpressionListOrRange__ExpAssignment_1_0_1
            {
            pushFollow(FOLLOW_2);
            rule__ExpressionListOrRange__ExpAssignment_1_0_1();

            state._fsp--;


            }

             after(grammarAccess.getExpressionListOrRangeAccess().getExpAssignment_1_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionListOrRange__Group_1_0__1__Impl"


    // $ANTLR start "rule__ExpressionListOrRange__Group_1_1__0"
    // InternalOcl.g:3478:1: rule__ExpressionListOrRange__Group_1_1__0 : rule__ExpressionListOrRange__Group_1_1__0__Impl rule__ExpressionListOrRange__Group_1_1__1 ;
    public final void rule__ExpressionListOrRange__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3482:1: ( rule__ExpressionListOrRange__Group_1_1__0__Impl rule__ExpressionListOrRange__Group_1_1__1 )
            // InternalOcl.g:3483:2: rule__ExpressionListOrRange__Group_1_1__0__Impl rule__ExpressionListOrRange__Group_1_1__1
            {
            pushFollow(FOLLOW_6);
            rule__ExpressionListOrRange__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExpressionListOrRange__Group_1_1__1();

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
    // $ANTLR end "rule__ExpressionListOrRange__Group_1_1__0"


    // $ANTLR start "rule__ExpressionListOrRange__Group_1_1__0__Impl"
    // InternalOcl.g:3490:1: rule__ExpressionListOrRange__Group_1_1__0__Impl : ( '..' ) ;
    public final void rule__ExpressionListOrRange__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3494:1: ( ( '..' ) )
            // InternalOcl.g:3495:1: ( '..' )
            {
            // InternalOcl.g:3495:1: ( '..' )
            // InternalOcl.g:3496:2: '..'
            {
             before(grammarAccess.getExpressionListOrRangeAccess().getFullStopFullStopKeyword_1_1_0()); 
            match(input,93,FOLLOW_2); 
             after(grammarAccess.getExpressionListOrRangeAccess().getFullStopFullStopKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionListOrRange__Group_1_1__0__Impl"


    // $ANTLR start "rule__ExpressionListOrRange__Group_1_1__1"
    // InternalOcl.g:3505:1: rule__ExpressionListOrRange__Group_1_1__1 : rule__ExpressionListOrRange__Group_1_1__1__Impl ;
    public final void rule__ExpressionListOrRange__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3509:1: ( rule__ExpressionListOrRange__Group_1_1__1__Impl )
            // InternalOcl.g:3510:2: rule__ExpressionListOrRange__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExpressionListOrRange__Group_1_1__1__Impl();

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
    // $ANTLR end "rule__ExpressionListOrRange__Group_1_1__1"


    // $ANTLR start "rule__ExpressionListOrRange__Group_1_1__1__Impl"
    // InternalOcl.g:3516:1: rule__ExpressionListOrRange__Group_1_1__1__Impl : ( ( rule__ExpressionListOrRange__ExpAssignment_1_1_1 ) ) ;
    public final void rule__ExpressionListOrRange__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3520:1: ( ( ( rule__ExpressionListOrRange__ExpAssignment_1_1_1 ) ) )
            // InternalOcl.g:3521:1: ( ( rule__ExpressionListOrRange__ExpAssignment_1_1_1 ) )
            {
            // InternalOcl.g:3521:1: ( ( rule__ExpressionListOrRange__ExpAssignment_1_1_1 ) )
            // InternalOcl.g:3522:2: ( rule__ExpressionListOrRange__ExpAssignment_1_1_1 )
            {
             before(grammarAccess.getExpressionListOrRangeAccess().getExpAssignment_1_1_1()); 
            // InternalOcl.g:3523:2: ( rule__ExpressionListOrRange__ExpAssignment_1_1_1 )
            // InternalOcl.g:3523:3: rule__ExpressionListOrRange__ExpAssignment_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__ExpressionListOrRange__ExpAssignment_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getExpressionListOrRangeAccess().getExpAssignment_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionListOrRange__Group_1_1__1__Impl"


    // $ANTLR start "rule__FeatureCall__Group__0"
    // InternalOcl.g:3532:1: rule__FeatureCall__Group__0 : rule__FeatureCall__Group__0__Impl rule__FeatureCall__Group__1 ;
    public final void rule__FeatureCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3536:1: ( rule__FeatureCall__Group__0__Impl rule__FeatureCall__Group__1 )
            // InternalOcl.g:3537:2: rule__FeatureCall__Group__0__Impl rule__FeatureCall__Group__1
            {
            pushFollow(FOLLOW_28);
            rule__FeatureCall__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FeatureCall__Group__1();

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
    // $ANTLR end "rule__FeatureCall__Group__0"


    // $ANTLR start "rule__FeatureCall__Group__0__Impl"
    // InternalOcl.g:3544:1: rule__FeatureCall__Group__0__Impl : ( rulePathName ) ;
    public final void rule__FeatureCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3548:1: ( ( rulePathName ) )
            // InternalOcl.g:3549:1: ( rulePathName )
            {
            // InternalOcl.g:3549:1: ( rulePathName )
            // InternalOcl.g:3550:2: rulePathName
            {
             before(grammarAccess.getFeatureCallAccess().getPathNameParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            rulePathName();

            state._fsp--;

             after(grammarAccess.getFeatureCallAccess().getPathNameParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCall__Group__0__Impl"


    // $ANTLR start "rule__FeatureCall__Group__1"
    // InternalOcl.g:3559:1: rule__FeatureCall__Group__1 : rule__FeatureCall__Group__1__Impl rule__FeatureCall__Group__2 ;
    public final void rule__FeatureCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3563:1: ( rule__FeatureCall__Group__1__Impl rule__FeatureCall__Group__2 )
            // InternalOcl.g:3564:2: rule__FeatureCall__Group__1__Impl rule__FeatureCall__Group__2
            {
            pushFollow(FOLLOW_28);
            rule__FeatureCall__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FeatureCall__Group__2();

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
    // $ANTLR end "rule__FeatureCall__Group__1"


    // $ANTLR start "rule__FeatureCall__Group__1__Impl"
    // InternalOcl.g:3571:1: rule__FeatureCall__Group__1__Impl : ( ( rule__FeatureCall__ParamsAssignment_1 )? ) ;
    public final void rule__FeatureCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3575:1: ( ( ( rule__FeatureCall__ParamsAssignment_1 )? ) )
            // InternalOcl.g:3576:1: ( ( rule__FeatureCall__ParamsAssignment_1 )? )
            {
            // InternalOcl.g:3576:1: ( ( rule__FeatureCall__ParamsAssignment_1 )? )
            // InternalOcl.g:3577:2: ( rule__FeatureCall__ParamsAssignment_1 )?
            {
             before(grammarAccess.getFeatureCallAccess().getParamsAssignment_1()); 
            // InternalOcl.g:3578:2: ( rule__FeatureCall__ParamsAssignment_1 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==97) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalOcl.g:3578:3: rule__FeatureCall__ParamsAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__FeatureCall__ParamsAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFeatureCallAccess().getParamsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCall__Group__1__Impl"


    // $ANTLR start "rule__FeatureCall__Group__2"
    // InternalOcl.g:3586:1: rule__FeatureCall__Group__2 : rule__FeatureCall__Group__2__Impl rule__FeatureCall__Group__3 ;
    public final void rule__FeatureCall__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3590:1: ( rule__FeatureCall__Group__2__Impl rule__FeatureCall__Group__3 )
            // InternalOcl.g:3591:2: rule__FeatureCall__Group__2__Impl rule__FeatureCall__Group__3
            {
            pushFollow(FOLLOW_28);
            rule__FeatureCall__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FeatureCall__Group__3();

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
    // $ANTLR end "rule__FeatureCall__Group__2"


    // $ANTLR start "rule__FeatureCall__Group__2__Impl"
    // InternalOcl.g:3598:1: rule__FeatureCall__Group__2__Impl : ( ( rule__FeatureCall__ParamsAssignment_2 )? ) ;
    public final void rule__FeatureCall__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3602:1: ( ( ( rule__FeatureCall__ParamsAssignment_2 )? ) )
            // InternalOcl.g:3603:1: ( ( rule__FeatureCall__ParamsAssignment_2 )? )
            {
            // InternalOcl.g:3603:1: ( ( rule__FeatureCall__ParamsAssignment_2 )? )
            // InternalOcl.g:3604:2: ( rule__FeatureCall__ParamsAssignment_2 )?
            {
             before(grammarAccess.getFeatureCallAccess().getParamsAssignment_2()); 
            // InternalOcl.g:3605:2: ( rule__FeatureCall__ParamsAssignment_2 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==94) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalOcl.g:3605:3: rule__FeatureCall__ParamsAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__FeatureCall__ParamsAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFeatureCallAccess().getParamsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCall__Group__2__Impl"


    // $ANTLR start "rule__FeatureCall__Group__3"
    // InternalOcl.g:3613:1: rule__FeatureCall__Group__3 : rule__FeatureCall__Group__3__Impl ;
    public final void rule__FeatureCall__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3617:1: ( rule__FeatureCall__Group__3__Impl )
            // InternalOcl.g:3618:2: rule__FeatureCall__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FeatureCall__Group__3__Impl();

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
    // $ANTLR end "rule__FeatureCall__Group__3"


    // $ANTLR start "rule__FeatureCall__Group__3__Impl"
    // InternalOcl.g:3624:1: rule__FeatureCall__Group__3__Impl : ( ( rule__FeatureCall__ParamsAssignment_3 )? ) ;
    public final void rule__FeatureCall__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3628:1: ( ( ( rule__FeatureCall__ParamsAssignment_3 )? ) )
            // InternalOcl.g:3629:1: ( ( rule__FeatureCall__ParamsAssignment_3 )? )
            {
            // InternalOcl.g:3629:1: ( ( rule__FeatureCall__ParamsAssignment_3 )? )
            // InternalOcl.g:3630:2: ( rule__FeatureCall__ParamsAssignment_3 )?
            {
             before(grammarAccess.getFeatureCallAccess().getParamsAssignment_3()); 
            // InternalOcl.g:3631:2: ( rule__FeatureCall__ParamsAssignment_3 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==82) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalOcl.g:3631:3: rule__FeatureCall__ParamsAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__FeatureCall__ParamsAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFeatureCallAccess().getParamsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCall__Group__3__Impl"


    // $ANTLR start "rule__Qualifiers__Group__0"
    // InternalOcl.g:3640:1: rule__Qualifiers__Group__0 : rule__Qualifiers__Group__0__Impl rule__Qualifiers__Group__1 ;
    public final void rule__Qualifiers__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3644:1: ( rule__Qualifiers__Group__0__Impl rule__Qualifiers__Group__1 )
            // InternalOcl.g:3645:2: rule__Qualifiers__Group__0__Impl rule__Qualifiers__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__Qualifiers__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Qualifiers__Group__1();

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
    // $ANTLR end "rule__Qualifiers__Group__0"


    // $ANTLR start "rule__Qualifiers__Group__0__Impl"
    // InternalOcl.g:3652:1: rule__Qualifiers__Group__0__Impl : ( '[' ) ;
    public final void rule__Qualifiers__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3656:1: ( ( '[' ) )
            // InternalOcl.g:3657:1: ( '[' )
            {
            // InternalOcl.g:3657:1: ( '[' )
            // InternalOcl.g:3658:2: '['
            {
             before(grammarAccess.getQualifiersAccess().getLeftSquareBracketKeyword_0()); 
            match(input,94,FOLLOW_2); 
             after(grammarAccess.getQualifiersAccess().getLeftSquareBracketKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Qualifiers__Group__0__Impl"


    // $ANTLR start "rule__Qualifiers__Group__1"
    // InternalOcl.g:3667:1: rule__Qualifiers__Group__1 : rule__Qualifiers__Group__1__Impl rule__Qualifiers__Group__2 ;
    public final void rule__Qualifiers__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3671:1: ( rule__Qualifiers__Group__1__Impl rule__Qualifiers__Group__2 )
            // InternalOcl.g:3672:2: rule__Qualifiers__Group__1__Impl rule__Qualifiers__Group__2
            {
            pushFollow(FOLLOW_29);
            rule__Qualifiers__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Qualifiers__Group__2();

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
    // $ANTLR end "rule__Qualifiers__Group__1"


    // $ANTLR start "rule__Qualifiers__Group__1__Impl"
    // InternalOcl.g:3679:1: rule__Qualifiers__Group__1__Impl : ( ruleActualParameterList ) ;
    public final void rule__Qualifiers__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3683:1: ( ( ruleActualParameterList ) )
            // InternalOcl.g:3684:1: ( ruleActualParameterList )
            {
            // InternalOcl.g:3684:1: ( ruleActualParameterList )
            // InternalOcl.g:3685:2: ruleActualParameterList
            {
             before(grammarAccess.getQualifiersAccess().getActualParameterListParserRuleCall_1()); 
            pushFollow(FOLLOW_2);
            ruleActualParameterList();

            state._fsp--;

             after(grammarAccess.getQualifiersAccess().getActualParameterListParserRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Qualifiers__Group__1__Impl"


    // $ANTLR start "rule__Qualifiers__Group__2"
    // InternalOcl.g:3694:1: rule__Qualifiers__Group__2 : rule__Qualifiers__Group__2__Impl ;
    public final void rule__Qualifiers__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3698:1: ( rule__Qualifiers__Group__2__Impl )
            // InternalOcl.g:3699:2: rule__Qualifiers__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Qualifiers__Group__2__Impl();

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
    // $ANTLR end "rule__Qualifiers__Group__2"


    // $ANTLR start "rule__Qualifiers__Group__2__Impl"
    // InternalOcl.g:3705:1: rule__Qualifiers__Group__2__Impl : ( ']' ) ;
    public final void rule__Qualifiers__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3709:1: ( ( ']' ) )
            // InternalOcl.g:3710:1: ( ']' )
            {
            // InternalOcl.g:3710:1: ( ']' )
            // InternalOcl.g:3711:2: ']'
            {
             before(grammarAccess.getQualifiersAccess().getRightSquareBracketKeyword_2()); 
            match(input,95,FOLLOW_2); 
             after(grammarAccess.getQualifiersAccess().getRightSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Qualifiers__Group__2__Impl"


    // $ANTLR start "rule__Declarator__Group__0"
    // InternalOcl.g:3721:1: rule__Declarator__Group__0 : rule__Declarator__Group__0__Impl rule__Declarator__Group__1 ;
    public final void rule__Declarator__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3725:1: ( rule__Declarator__Group__0__Impl rule__Declarator__Group__1 )
            // InternalOcl.g:3726:2: rule__Declarator__Group__0__Impl rule__Declarator__Group__1
            {
            pushFollow(FOLLOW_30);
            rule__Declarator__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Declarator__Group__1();

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
    // $ANTLR end "rule__Declarator__Group__0"


    // $ANTLR start "rule__Declarator__Group__0__Impl"
    // InternalOcl.g:3733:1: rule__Declarator__Group__0__Impl : ( ( rule__Declarator__NameAssignment_0 ) ) ;
    public final void rule__Declarator__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3737:1: ( ( ( rule__Declarator__NameAssignment_0 ) ) )
            // InternalOcl.g:3738:1: ( ( rule__Declarator__NameAssignment_0 ) )
            {
            // InternalOcl.g:3738:1: ( ( rule__Declarator__NameAssignment_0 ) )
            // InternalOcl.g:3739:2: ( rule__Declarator__NameAssignment_0 )
            {
             before(grammarAccess.getDeclaratorAccess().getNameAssignment_0()); 
            // InternalOcl.g:3740:2: ( rule__Declarator__NameAssignment_0 )
            // InternalOcl.g:3740:3: rule__Declarator__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Declarator__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getDeclaratorAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declarator__Group__0__Impl"


    // $ANTLR start "rule__Declarator__Group__1"
    // InternalOcl.g:3748:1: rule__Declarator__Group__1 : rule__Declarator__Group__1__Impl rule__Declarator__Group__2 ;
    public final void rule__Declarator__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3752:1: ( rule__Declarator__Group__1__Impl rule__Declarator__Group__2 )
            // InternalOcl.g:3753:2: rule__Declarator__Group__1__Impl rule__Declarator__Group__2
            {
            pushFollow(FOLLOW_30);
            rule__Declarator__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Declarator__Group__2();

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
    // $ANTLR end "rule__Declarator__Group__1"


    // $ANTLR start "rule__Declarator__Group__1__Impl"
    // InternalOcl.g:3760:1: rule__Declarator__Group__1__Impl : ( ( rule__Declarator__Group_1__0 )* ) ;
    public final void rule__Declarator__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3764:1: ( ( ( rule__Declarator__Group_1__0 )* ) )
            // InternalOcl.g:3765:1: ( ( rule__Declarator__Group_1__0 )* )
            {
            // InternalOcl.g:3765:1: ( ( rule__Declarator__Group_1__0 )* )
            // InternalOcl.g:3766:2: ( rule__Declarator__Group_1__0 )*
            {
             before(grammarAccess.getDeclaratorAccess().getGroup_1()); 
            // InternalOcl.g:3767:2: ( rule__Declarator__Group_1__0 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==92) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalOcl.g:3767:3: rule__Declarator__Group_1__0
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__Declarator__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

             after(grammarAccess.getDeclaratorAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declarator__Group__1__Impl"


    // $ANTLR start "rule__Declarator__Group__2"
    // InternalOcl.g:3775:1: rule__Declarator__Group__2 : rule__Declarator__Group__2__Impl rule__Declarator__Group__3 ;
    public final void rule__Declarator__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3779:1: ( rule__Declarator__Group__2__Impl rule__Declarator__Group__3 )
            // InternalOcl.g:3780:2: rule__Declarator__Group__2__Impl rule__Declarator__Group__3
            {
            pushFollow(FOLLOW_30);
            rule__Declarator__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Declarator__Group__3();

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
    // $ANTLR end "rule__Declarator__Group__2"


    // $ANTLR start "rule__Declarator__Group__2__Impl"
    // InternalOcl.g:3787:1: rule__Declarator__Group__2__Impl : ( ( rule__Declarator__Group_2__0 )? ) ;
    public final void rule__Declarator__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3791:1: ( ( ( rule__Declarator__Group_2__0 )? ) )
            // InternalOcl.g:3792:1: ( ( rule__Declarator__Group_2__0 )? )
            {
            // InternalOcl.g:3792:1: ( ( rule__Declarator__Group_2__0 )? )
            // InternalOcl.g:3793:2: ( rule__Declarator__Group_2__0 )?
            {
             before(grammarAccess.getDeclaratorAccess().getGroup_2()); 
            // InternalOcl.g:3794:2: ( rule__Declarator__Group_2__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_COLON) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalOcl.g:3794:3: rule__Declarator__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Declarator__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDeclaratorAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declarator__Group__2__Impl"


    // $ANTLR start "rule__Declarator__Group__3"
    // InternalOcl.g:3802:1: rule__Declarator__Group__3 : rule__Declarator__Group__3__Impl ;
    public final void rule__Declarator__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3806:1: ( rule__Declarator__Group__3__Impl )
            // InternalOcl.g:3807:2: rule__Declarator__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Declarator__Group__3__Impl();

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
    // $ANTLR end "rule__Declarator__Group__3"


    // $ANTLR start "rule__Declarator__Group__3__Impl"
    // InternalOcl.g:3813:1: rule__Declarator__Group__3__Impl : ( '|' ) ;
    public final void rule__Declarator__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3817:1: ( ( '|' ) )
            // InternalOcl.g:3818:1: ( '|' )
            {
            // InternalOcl.g:3818:1: ( '|' )
            // InternalOcl.g:3819:2: '|'
            {
             before(grammarAccess.getDeclaratorAccess().getVerticalLineKeyword_3()); 
            match(input,96,FOLLOW_2); 
             after(grammarAccess.getDeclaratorAccess().getVerticalLineKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declarator__Group__3__Impl"


    // $ANTLR start "rule__Declarator__Group_1__0"
    // InternalOcl.g:3829:1: rule__Declarator__Group_1__0 : rule__Declarator__Group_1__0__Impl rule__Declarator__Group_1__1 ;
    public final void rule__Declarator__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3833:1: ( rule__Declarator__Group_1__0__Impl rule__Declarator__Group_1__1 )
            // InternalOcl.g:3834:2: rule__Declarator__Group_1__0__Impl rule__Declarator__Group_1__1
            {
            pushFollow(FOLLOW_17);
            rule__Declarator__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Declarator__Group_1__1();

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
    // $ANTLR end "rule__Declarator__Group_1__0"


    // $ANTLR start "rule__Declarator__Group_1__0__Impl"
    // InternalOcl.g:3841:1: rule__Declarator__Group_1__0__Impl : ( ',' ) ;
    public final void rule__Declarator__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3845:1: ( ( ',' ) )
            // InternalOcl.g:3846:1: ( ',' )
            {
            // InternalOcl.g:3846:1: ( ',' )
            // InternalOcl.g:3847:2: ','
            {
             before(grammarAccess.getDeclaratorAccess().getCommaKeyword_1_0()); 
            match(input,92,FOLLOW_2); 
             after(grammarAccess.getDeclaratorAccess().getCommaKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declarator__Group_1__0__Impl"


    // $ANTLR start "rule__Declarator__Group_1__1"
    // InternalOcl.g:3856:1: rule__Declarator__Group_1__1 : rule__Declarator__Group_1__1__Impl ;
    public final void rule__Declarator__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3860:1: ( rule__Declarator__Group_1__1__Impl )
            // InternalOcl.g:3861:2: rule__Declarator__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Declarator__Group_1__1__Impl();

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
    // $ANTLR end "rule__Declarator__Group_1__1"


    // $ANTLR start "rule__Declarator__Group_1__1__Impl"
    // InternalOcl.g:3867:1: rule__Declarator__Group_1__1__Impl : ( ( rule__Declarator__NameAssignment_1_1 ) ) ;
    public final void rule__Declarator__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3871:1: ( ( ( rule__Declarator__NameAssignment_1_1 ) ) )
            // InternalOcl.g:3872:1: ( ( rule__Declarator__NameAssignment_1_1 ) )
            {
            // InternalOcl.g:3872:1: ( ( rule__Declarator__NameAssignment_1_1 ) )
            // InternalOcl.g:3873:2: ( rule__Declarator__NameAssignment_1_1 )
            {
             before(grammarAccess.getDeclaratorAccess().getNameAssignment_1_1()); 
            // InternalOcl.g:3874:2: ( rule__Declarator__NameAssignment_1_1 )
            // InternalOcl.g:3874:3: rule__Declarator__NameAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Declarator__NameAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getDeclaratorAccess().getNameAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declarator__Group_1__1__Impl"


    // $ANTLR start "rule__Declarator__Group_2__0"
    // InternalOcl.g:3883:1: rule__Declarator__Group_2__0 : rule__Declarator__Group_2__0__Impl rule__Declarator__Group_2__1 ;
    public final void rule__Declarator__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3887:1: ( rule__Declarator__Group_2__0__Impl rule__Declarator__Group_2__1 )
            // InternalOcl.g:3888:2: rule__Declarator__Group_2__0__Impl rule__Declarator__Group_2__1
            {
            pushFollow(FOLLOW_31);
            rule__Declarator__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Declarator__Group_2__1();

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
    // $ANTLR end "rule__Declarator__Group_2__0"


    // $ANTLR start "rule__Declarator__Group_2__0__Impl"
    // InternalOcl.g:3895:1: rule__Declarator__Group_2__0__Impl : ( RULE_COLON ) ;
    public final void rule__Declarator__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3899:1: ( ( RULE_COLON ) )
            // InternalOcl.g:3900:1: ( RULE_COLON )
            {
            // InternalOcl.g:3900:1: ( RULE_COLON )
            // InternalOcl.g:3901:2: RULE_COLON
            {
             before(grammarAccess.getDeclaratorAccess().getCOLONTerminalRuleCall_2_0()); 
            match(input,RULE_COLON,FOLLOW_2); 
             after(grammarAccess.getDeclaratorAccess().getCOLONTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declarator__Group_2__0__Impl"


    // $ANTLR start "rule__Declarator__Group_2__1"
    // InternalOcl.g:3910:1: rule__Declarator__Group_2__1 : rule__Declarator__Group_2__1__Impl ;
    public final void rule__Declarator__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3914:1: ( rule__Declarator__Group_2__1__Impl )
            // InternalOcl.g:3915:2: rule__Declarator__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Declarator__Group_2__1__Impl();

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
    // $ANTLR end "rule__Declarator__Group_2__1"


    // $ANTLR start "rule__Declarator__Group_2__1__Impl"
    // InternalOcl.g:3921:1: rule__Declarator__Group_2__1__Impl : ( ( rule__Declarator__TypeAssignment_2_1 ) ) ;
    public final void rule__Declarator__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3925:1: ( ( ( rule__Declarator__TypeAssignment_2_1 ) ) )
            // InternalOcl.g:3926:1: ( ( rule__Declarator__TypeAssignment_2_1 ) )
            {
            // InternalOcl.g:3926:1: ( ( rule__Declarator__TypeAssignment_2_1 ) )
            // InternalOcl.g:3927:2: ( rule__Declarator__TypeAssignment_2_1 )
            {
             before(grammarAccess.getDeclaratorAccess().getTypeAssignment_2_1()); 
            // InternalOcl.g:3928:2: ( rule__Declarator__TypeAssignment_2_1 )
            // InternalOcl.g:3928:3: rule__Declarator__TypeAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Declarator__TypeAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getDeclaratorAccess().getTypeAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declarator__Group_2__1__Impl"


    // $ANTLR start "rule__PathTypeName__Group__0"
    // InternalOcl.g:3937:1: rule__PathTypeName__Group__0 : rule__PathTypeName__Group__0__Impl rule__PathTypeName__Group__1 ;
    public final void rule__PathTypeName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3941:1: ( rule__PathTypeName__Group__0__Impl rule__PathTypeName__Group__1 )
            // InternalOcl.g:3942:2: rule__PathTypeName__Group__0__Impl rule__PathTypeName__Group__1
            {
            pushFollow(FOLLOW_32);
            rule__PathTypeName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PathTypeName__Group__1();

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
    // $ANTLR end "rule__PathTypeName__Group__0"


    // $ANTLR start "rule__PathTypeName__Group__0__Impl"
    // InternalOcl.g:3949:1: rule__PathTypeName__Group__0__Impl : ( ( rule__PathTypeName__LeftAssignment_0 ) ) ;
    public final void rule__PathTypeName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3953:1: ( ( ( rule__PathTypeName__LeftAssignment_0 ) ) )
            // InternalOcl.g:3954:1: ( ( rule__PathTypeName__LeftAssignment_0 ) )
            {
            // InternalOcl.g:3954:1: ( ( rule__PathTypeName__LeftAssignment_0 ) )
            // InternalOcl.g:3955:2: ( rule__PathTypeName__LeftAssignment_0 )
            {
             before(grammarAccess.getPathTypeNameAccess().getLeftAssignment_0()); 
            // InternalOcl.g:3956:2: ( rule__PathTypeName__LeftAssignment_0 )
            // InternalOcl.g:3956:3: rule__PathTypeName__LeftAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__PathTypeName__LeftAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getPathTypeNameAccess().getLeftAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathTypeName__Group__0__Impl"


    // $ANTLR start "rule__PathTypeName__Group__1"
    // InternalOcl.g:3964:1: rule__PathTypeName__Group__1 : rule__PathTypeName__Group__1__Impl ;
    public final void rule__PathTypeName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3968:1: ( rule__PathTypeName__Group__1__Impl )
            // InternalOcl.g:3969:2: rule__PathTypeName__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PathTypeName__Group__1__Impl();

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
    // $ANTLR end "rule__PathTypeName__Group__1"


    // $ANTLR start "rule__PathTypeName__Group__1__Impl"
    // InternalOcl.g:3975:1: rule__PathTypeName__Group__1__Impl : ( ( rule__PathTypeName__Group_1__0 )* ) ;
    public final void rule__PathTypeName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3979:1: ( ( ( rule__PathTypeName__Group_1__0 )* ) )
            // InternalOcl.g:3980:1: ( ( rule__PathTypeName__Group_1__0 )* )
            {
            // InternalOcl.g:3980:1: ( ( rule__PathTypeName__Group_1__0 )* )
            // InternalOcl.g:3981:2: ( rule__PathTypeName__Group_1__0 )*
            {
             before(grammarAccess.getPathTypeNameAccess().getGroup_1()); 
            // InternalOcl.g:3982:2: ( rule__PathTypeName__Group_1__0 )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==RULE_DOUBLE_COLON) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalOcl.g:3982:3: rule__PathTypeName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_33);
            	    rule__PathTypeName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

             after(grammarAccess.getPathTypeNameAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathTypeName__Group__1__Impl"


    // $ANTLR start "rule__PathTypeName__Group_1__0"
    // InternalOcl.g:3991:1: rule__PathTypeName__Group_1__0 : rule__PathTypeName__Group_1__0__Impl rule__PathTypeName__Group_1__1 ;
    public final void rule__PathTypeName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:3995:1: ( rule__PathTypeName__Group_1__0__Impl rule__PathTypeName__Group_1__1 )
            // InternalOcl.g:3996:2: rule__PathTypeName__Group_1__0__Impl rule__PathTypeName__Group_1__1
            {
            pushFollow(FOLLOW_4);
            rule__PathTypeName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PathTypeName__Group_1__1();

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
    // $ANTLR end "rule__PathTypeName__Group_1__0"


    // $ANTLR start "rule__PathTypeName__Group_1__0__Impl"
    // InternalOcl.g:4003:1: rule__PathTypeName__Group_1__0__Impl : ( RULE_DOUBLE_COLON ) ;
    public final void rule__PathTypeName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4007:1: ( ( RULE_DOUBLE_COLON ) )
            // InternalOcl.g:4008:1: ( RULE_DOUBLE_COLON )
            {
            // InternalOcl.g:4008:1: ( RULE_DOUBLE_COLON )
            // InternalOcl.g:4009:2: RULE_DOUBLE_COLON
            {
             before(grammarAccess.getPathTypeNameAccess().getDOUBLE_COLONTerminalRuleCall_1_0()); 
            match(input,RULE_DOUBLE_COLON,FOLLOW_2); 
             after(grammarAccess.getPathTypeNameAccess().getDOUBLE_COLONTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathTypeName__Group_1__0__Impl"


    // $ANTLR start "rule__PathTypeName__Group_1__1"
    // InternalOcl.g:4018:1: rule__PathTypeName__Group_1__1 : rule__PathTypeName__Group_1__1__Impl ;
    public final void rule__PathTypeName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4022:1: ( rule__PathTypeName__Group_1__1__Impl )
            // InternalOcl.g:4023:2: rule__PathTypeName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PathTypeName__Group_1__1__Impl();

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
    // $ANTLR end "rule__PathTypeName__Group_1__1"


    // $ANTLR start "rule__PathTypeName__Group_1__1__Impl"
    // InternalOcl.g:4029:1: rule__PathTypeName__Group_1__1__Impl : ( ( rule__PathTypeName__RightsAssignment_1_1 ) ) ;
    public final void rule__PathTypeName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4033:1: ( ( ( rule__PathTypeName__RightsAssignment_1_1 ) ) )
            // InternalOcl.g:4034:1: ( ( rule__PathTypeName__RightsAssignment_1_1 ) )
            {
            // InternalOcl.g:4034:1: ( ( rule__PathTypeName__RightsAssignment_1_1 ) )
            // InternalOcl.g:4035:2: ( rule__PathTypeName__RightsAssignment_1_1 )
            {
             before(grammarAccess.getPathTypeNameAccess().getRightsAssignment_1_1()); 
            // InternalOcl.g:4036:2: ( rule__PathTypeName__RightsAssignment_1_1 )
            // InternalOcl.g:4036:3: rule__PathTypeName__RightsAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__PathTypeName__RightsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getPathTypeNameAccess().getRightsAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathTypeName__Group_1__1__Impl"


    // $ANTLR start "rule__PathName__Group__0"
    // InternalOcl.g:4045:1: rule__PathName__Group__0 : rule__PathName__Group__0__Impl rule__PathName__Group__1 ;
    public final void rule__PathName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4049:1: ( rule__PathName__Group__0__Impl rule__PathName__Group__1 )
            // InternalOcl.g:4050:2: rule__PathName__Group__0__Impl rule__PathName__Group__1
            {
            pushFollow(FOLLOW_32);
            rule__PathName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PathName__Group__1();

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
    // $ANTLR end "rule__PathName__Group__0"


    // $ANTLR start "rule__PathName__Group__0__Impl"
    // InternalOcl.g:4057:1: rule__PathName__Group__0__Impl : ( ( rule__PathName__LeftAssignment_0 ) ) ;
    public final void rule__PathName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4061:1: ( ( ( rule__PathName__LeftAssignment_0 ) ) )
            // InternalOcl.g:4062:1: ( ( rule__PathName__LeftAssignment_0 ) )
            {
            // InternalOcl.g:4062:1: ( ( rule__PathName__LeftAssignment_0 ) )
            // InternalOcl.g:4063:2: ( rule__PathName__LeftAssignment_0 )
            {
             before(grammarAccess.getPathNameAccess().getLeftAssignment_0()); 
            // InternalOcl.g:4064:2: ( rule__PathName__LeftAssignment_0 )
            // InternalOcl.g:4064:3: rule__PathName__LeftAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__PathName__LeftAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getPathNameAccess().getLeftAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathName__Group__0__Impl"


    // $ANTLR start "rule__PathName__Group__1"
    // InternalOcl.g:4072:1: rule__PathName__Group__1 : rule__PathName__Group__1__Impl ;
    public final void rule__PathName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4076:1: ( rule__PathName__Group__1__Impl )
            // InternalOcl.g:4077:2: rule__PathName__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PathName__Group__1__Impl();

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
    // $ANTLR end "rule__PathName__Group__1"


    // $ANTLR start "rule__PathName__Group__1__Impl"
    // InternalOcl.g:4083:1: rule__PathName__Group__1__Impl : ( ( rule__PathName__Group_1__0 )* ) ;
    public final void rule__PathName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4087:1: ( ( ( rule__PathName__Group_1__0 )* ) )
            // InternalOcl.g:4088:1: ( ( rule__PathName__Group_1__0 )* )
            {
            // InternalOcl.g:4088:1: ( ( rule__PathName__Group_1__0 )* )
            // InternalOcl.g:4089:2: ( rule__PathName__Group_1__0 )*
            {
             before(grammarAccess.getPathNameAccess().getGroup_1()); 
            // InternalOcl.g:4090:2: ( rule__PathName__Group_1__0 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==RULE_DOUBLE_COLON) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalOcl.g:4090:3: rule__PathName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_33);
            	    rule__PathName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

             after(grammarAccess.getPathNameAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathName__Group__1__Impl"


    // $ANTLR start "rule__PathName__Group_1__0"
    // InternalOcl.g:4099:1: rule__PathName__Group_1__0 : rule__PathName__Group_1__0__Impl rule__PathName__Group_1__1 ;
    public final void rule__PathName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4103:1: ( rule__PathName__Group_1__0__Impl rule__PathName__Group_1__1 )
            // InternalOcl.g:4104:2: rule__PathName__Group_1__0__Impl rule__PathName__Group_1__1
            {
            pushFollow(FOLLOW_17);
            rule__PathName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PathName__Group_1__1();

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
    // $ANTLR end "rule__PathName__Group_1__0"


    // $ANTLR start "rule__PathName__Group_1__0__Impl"
    // InternalOcl.g:4111:1: rule__PathName__Group_1__0__Impl : ( RULE_DOUBLE_COLON ) ;
    public final void rule__PathName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4115:1: ( ( RULE_DOUBLE_COLON ) )
            // InternalOcl.g:4116:1: ( RULE_DOUBLE_COLON )
            {
            // InternalOcl.g:4116:1: ( RULE_DOUBLE_COLON )
            // InternalOcl.g:4117:2: RULE_DOUBLE_COLON
            {
             before(grammarAccess.getPathNameAccess().getDOUBLE_COLONTerminalRuleCall_1_0()); 
            match(input,RULE_DOUBLE_COLON,FOLLOW_2); 
             after(grammarAccess.getPathNameAccess().getDOUBLE_COLONTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathName__Group_1__0__Impl"


    // $ANTLR start "rule__PathName__Group_1__1"
    // InternalOcl.g:4126:1: rule__PathName__Group_1__1 : rule__PathName__Group_1__1__Impl ;
    public final void rule__PathName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4130:1: ( rule__PathName__Group_1__1__Impl )
            // InternalOcl.g:4131:2: rule__PathName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PathName__Group_1__1__Impl();

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
    // $ANTLR end "rule__PathName__Group_1__1"


    // $ANTLR start "rule__PathName__Group_1__1__Impl"
    // InternalOcl.g:4137:1: rule__PathName__Group_1__1__Impl : ( ( rule__PathName__RightsAssignment_1_1 ) ) ;
    public final void rule__PathName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4141:1: ( ( ( rule__PathName__RightsAssignment_1_1 ) ) )
            // InternalOcl.g:4142:1: ( ( rule__PathName__RightsAssignment_1_1 ) )
            {
            // InternalOcl.g:4142:1: ( ( rule__PathName__RightsAssignment_1_1 ) )
            // InternalOcl.g:4143:2: ( rule__PathName__RightsAssignment_1_1 )
            {
             before(grammarAccess.getPathNameAccess().getRightsAssignment_1_1()); 
            // InternalOcl.g:4144:2: ( rule__PathName__RightsAssignment_1_1 )
            // InternalOcl.g:4144:3: rule__PathName__RightsAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__PathName__RightsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getPathNameAccess().getRightsAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathName__Group_1__1__Impl"


    // $ANTLR start "rule__TimeExpression__Group__0"
    // InternalOcl.g:4153:1: rule__TimeExpression__Group__0 : rule__TimeExpression__Group__0__Impl rule__TimeExpression__Group__1 ;
    public final void rule__TimeExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4157:1: ( rule__TimeExpression__Group__0__Impl rule__TimeExpression__Group__1 )
            // InternalOcl.g:4158:2: rule__TimeExpression__Group__0__Impl rule__TimeExpression__Group__1
            {
            pushFollow(FOLLOW_21);
            rule__TimeExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TimeExpression__Group__1();

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
    // $ANTLR end "rule__TimeExpression__Group__0"


    // $ANTLR start "rule__TimeExpression__Group__0__Impl"
    // InternalOcl.g:4165:1: rule__TimeExpression__Group__0__Impl : ( '@' ) ;
    public final void rule__TimeExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4169:1: ( ( '@' ) )
            // InternalOcl.g:4170:1: ( '@' )
            {
            // InternalOcl.g:4170:1: ( '@' )
            // InternalOcl.g:4171:2: '@'
            {
             before(grammarAccess.getTimeExpressionAccess().getCommercialAtKeyword_0()); 
            match(input,97,FOLLOW_2); 
             after(grammarAccess.getTimeExpressionAccess().getCommercialAtKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeExpression__Group__0__Impl"


    // $ANTLR start "rule__TimeExpression__Group__1"
    // InternalOcl.g:4180:1: rule__TimeExpression__Group__1 : rule__TimeExpression__Group__1__Impl ;
    public final void rule__TimeExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4184:1: ( rule__TimeExpression__Group__1__Impl )
            // InternalOcl.g:4185:2: rule__TimeExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TimeExpression__Group__1__Impl();

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
    // $ANTLR end "rule__TimeExpression__Group__1"


    // $ANTLR start "rule__TimeExpression__Group__1__Impl"
    // InternalOcl.g:4191:1: rule__TimeExpression__Group__1__Impl : ( ( rule__TimeExpression__NameAssignment_1 ) ) ;
    public final void rule__TimeExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4195:1: ( ( ( rule__TimeExpression__NameAssignment_1 ) ) )
            // InternalOcl.g:4196:1: ( ( rule__TimeExpression__NameAssignment_1 ) )
            {
            // InternalOcl.g:4196:1: ( ( rule__TimeExpression__NameAssignment_1 ) )
            // InternalOcl.g:4197:2: ( rule__TimeExpression__NameAssignment_1 )
            {
             before(grammarAccess.getTimeExpressionAccess().getNameAssignment_1()); 
            // InternalOcl.g:4198:2: ( rule__TimeExpression__NameAssignment_1 )
            // InternalOcl.g:4198:3: rule__TimeExpression__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__TimeExpression__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTimeExpressionAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeExpression__Group__1__Impl"


    // $ANTLR start "rule__ActualParameterList__Group__0"
    // InternalOcl.g:4207:1: rule__ActualParameterList__Group__0 : rule__ActualParameterList__Group__0__Impl rule__ActualParameterList__Group__1 ;
    public final void rule__ActualParameterList__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4211:1: ( rule__ActualParameterList__Group__0__Impl rule__ActualParameterList__Group__1 )
            // InternalOcl.g:4212:2: rule__ActualParameterList__Group__0__Impl rule__ActualParameterList__Group__1
            {
            pushFollow(FOLLOW_34);
            rule__ActualParameterList__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ActualParameterList__Group__1();

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
    // $ANTLR end "rule__ActualParameterList__Group__0"


    // $ANTLR start "rule__ActualParameterList__Group__0__Impl"
    // InternalOcl.g:4219:1: rule__ActualParameterList__Group__0__Impl : ( ( rule__ActualParameterList__ExpAssignment_0 ) ) ;
    public final void rule__ActualParameterList__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4223:1: ( ( ( rule__ActualParameterList__ExpAssignment_0 ) ) )
            // InternalOcl.g:4224:1: ( ( rule__ActualParameterList__ExpAssignment_0 ) )
            {
            // InternalOcl.g:4224:1: ( ( rule__ActualParameterList__ExpAssignment_0 ) )
            // InternalOcl.g:4225:2: ( rule__ActualParameterList__ExpAssignment_0 )
            {
             before(grammarAccess.getActualParameterListAccess().getExpAssignment_0()); 
            // InternalOcl.g:4226:2: ( rule__ActualParameterList__ExpAssignment_0 )
            // InternalOcl.g:4226:3: rule__ActualParameterList__ExpAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ActualParameterList__ExpAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getActualParameterListAccess().getExpAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActualParameterList__Group__0__Impl"


    // $ANTLR start "rule__ActualParameterList__Group__1"
    // InternalOcl.g:4234:1: rule__ActualParameterList__Group__1 : rule__ActualParameterList__Group__1__Impl ;
    public final void rule__ActualParameterList__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4238:1: ( rule__ActualParameterList__Group__1__Impl )
            // InternalOcl.g:4239:2: rule__ActualParameterList__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ActualParameterList__Group__1__Impl();

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
    // $ANTLR end "rule__ActualParameterList__Group__1"


    // $ANTLR start "rule__ActualParameterList__Group__1__Impl"
    // InternalOcl.g:4245:1: rule__ActualParameterList__Group__1__Impl : ( ( rule__ActualParameterList__Group_1__0 )* ) ;
    public final void rule__ActualParameterList__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4249:1: ( ( ( rule__ActualParameterList__Group_1__0 )* ) )
            // InternalOcl.g:4250:1: ( ( rule__ActualParameterList__Group_1__0 )* )
            {
            // InternalOcl.g:4250:1: ( ( rule__ActualParameterList__Group_1__0 )* )
            // InternalOcl.g:4251:2: ( rule__ActualParameterList__Group_1__0 )*
            {
             before(grammarAccess.getActualParameterListAccess().getGroup_1()); 
            // InternalOcl.g:4252:2: ( rule__ActualParameterList__Group_1__0 )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==92) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalOcl.g:4252:3: rule__ActualParameterList__Group_1__0
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__ActualParameterList__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

             after(grammarAccess.getActualParameterListAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActualParameterList__Group__1__Impl"


    // $ANTLR start "rule__ActualParameterList__Group_1__0"
    // InternalOcl.g:4261:1: rule__ActualParameterList__Group_1__0 : rule__ActualParameterList__Group_1__0__Impl rule__ActualParameterList__Group_1__1 ;
    public final void rule__ActualParameterList__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4265:1: ( rule__ActualParameterList__Group_1__0__Impl rule__ActualParameterList__Group_1__1 )
            // InternalOcl.g:4266:2: rule__ActualParameterList__Group_1__0__Impl rule__ActualParameterList__Group_1__1
            {
            pushFollow(FOLLOW_6);
            rule__ActualParameterList__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ActualParameterList__Group_1__1();

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
    // $ANTLR end "rule__ActualParameterList__Group_1__0"


    // $ANTLR start "rule__ActualParameterList__Group_1__0__Impl"
    // InternalOcl.g:4273:1: rule__ActualParameterList__Group_1__0__Impl : ( ',' ) ;
    public final void rule__ActualParameterList__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4277:1: ( ( ',' ) )
            // InternalOcl.g:4278:1: ( ',' )
            {
            // InternalOcl.g:4278:1: ( ',' )
            // InternalOcl.g:4279:2: ','
            {
             before(grammarAccess.getActualParameterListAccess().getCommaKeyword_1_0()); 
            match(input,92,FOLLOW_2); 
             after(grammarAccess.getActualParameterListAccess().getCommaKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActualParameterList__Group_1__0__Impl"


    // $ANTLR start "rule__ActualParameterList__Group_1__1"
    // InternalOcl.g:4288:1: rule__ActualParameterList__Group_1__1 : rule__ActualParameterList__Group_1__1__Impl ;
    public final void rule__ActualParameterList__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4292:1: ( rule__ActualParameterList__Group_1__1__Impl )
            // InternalOcl.g:4293:2: rule__ActualParameterList__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ActualParameterList__Group_1__1__Impl();

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
    // $ANTLR end "rule__ActualParameterList__Group_1__1"


    // $ANTLR start "rule__ActualParameterList__Group_1__1__Impl"
    // InternalOcl.g:4299:1: rule__ActualParameterList__Group_1__1__Impl : ( ( rule__ActualParameterList__ExpAssignment_1_1 ) ) ;
    public final void rule__ActualParameterList__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4303:1: ( ( ( rule__ActualParameterList__ExpAssignment_1_1 ) ) )
            // InternalOcl.g:4304:1: ( ( rule__ActualParameterList__ExpAssignment_1_1 ) )
            {
            // InternalOcl.g:4304:1: ( ( rule__ActualParameterList__ExpAssignment_1_1 ) )
            // InternalOcl.g:4305:2: ( rule__ActualParameterList__ExpAssignment_1_1 )
            {
             before(grammarAccess.getActualParameterListAccess().getExpAssignment_1_1()); 
            // InternalOcl.g:4306:2: ( rule__ActualParameterList__ExpAssignment_1_1 )
            // InternalOcl.g:4306:3: rule__ActualParameterList__ExpAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__ActualParameterList__ExpAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getActualParameterListAccess().getExpAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActualParameterList__Group_1__1__Impl"


    // $ANTLR start "rule__NoParamFunction__Group__0"
    // InternalOcl.g:4315:1: rule__NoParamFunction__Group__0 : rule__NoParamFunction__Group__0__Impl rule__NoParamFunction__Group__1 ;
    public final void rule__NoParamFunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4319:1: ( rule__NoParamFunction__Group__0__Impl rule__NoParamFunction__Group__1 )
            // InternalOcl.g:4320:2: rule__NoParamFunction__Group__0__Impl rule__NoParamFunction__Group__1
            {
            pushFollow(FOLLOW_35);
            rule__NoParamFunction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NoParamFunction__Group__1();

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
    // $ANTLR end "rule__NoParamFunction__Group__0"


    // $ANTLR start "rule__NoParamFunction__Group__0__Impl"
    // InternalOcl.g:4327:1: rule__NoParamFunction__Group__0__Impl : ( ( rule__NoParamFunction__NameAssignment_0 ) ) ;
    public final void rule__NoParamFunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4331:1: ( ( ( rule__NoParamFunction__NameAssignment_0 ) ) )
            // InternalOcl.g:4332:1: ( ( rule__NoParamFunction__NameAssignment_0 ) )
            {
            // InternalOcl.g:4332:1: ( ( rule__NoParamFunction__NameAssignment_0 ) )
            // InternalOcl.g:4333:2: ( rule__NoParamFunction__NameAssignment_0 )
            {
             before(grammarAccess.getNoParamFunctionAccess().getNameAssignment_0()); 
            // InternalOcl.g:4334:2: ( rule__NoParamFunction__NameAssignment_0 )
            // InternalOcl.g:4334:3: rule__NoParamFunction__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__NoParamFunction__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getNoParamFunctionAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NoParamFunction__Group__0__Impl"


    // $ANTLR start "rule__NoParamFunction__Group__1"
    // InternalOcl.g:4342:1: rule__NoParamFunction__Group__1 : rule__NoParamFunction__Group__1__Impl ;
    public final void rule__NoParamFunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4346:1: ( rule__NoParamFunction__Group__1__Impl )
            // InternalOcl.g:4347:2: rule__NoParamFunction__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NoParamFunction__Group__1__Impl();

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
    // $ANTLR end "rule__NoParamFunction__Group__1"


    // $ANTLR start "rule__NoParamFunction__Group__1__Impl"
    // InternalOcl.g:4353:1: rule__NoParamFunction__Group__1__Impl : ( '()' ) ;
    public final void rule__NoParamFunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4357:1: ( ( '()' ) )
            // InternalOcl.g:4358:1: ( '()' )
            {
            // InternalOcl.g:4358:1: ( '()' )
            // InternalOcl.g:4359:2: '()'
            {
             before(grammarAccess.getNoParamFunctionAccess().getLeftParenthesisRightParenthesisKeyword_1()); 
            match(input,98,FOLLOW_2); 
             after(grammarAccess.getNoParamFunctionAccess().getLeftParenthesisRightParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NoParamFunction__Group__1__Impl"


    // $ANTLR start "rule__OneTypeParamFunction__Group__0"
    // InternalOcl.g:4369:1: rule__OneTypeParamFunction__Group__0 : rule__OneTypeParamFunction__Group__0__Impl rule__OneTypeParamFunction__Group__1 ;
    public final void rule__OneTypeParamFunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4373:1: ( rule__OneTypeParamFunction__Group__0__Impl rule__OneTypeParamFunction__Group__1 )
            // InternalOcl.g:4374:2: rule__OneTypeParamFunction__Group__0__Impl rule__OneTypeParamFunction__Group__1
            {
            pushFollow(FOLLOW_36);
            rule__OneTypeParamFunction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OneTypeParamFunction__Group__1();

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
    // $ANTLR end "rule__OneTypeParamFunction__Group__0"


    // $ANTLR start "rule__OneTypeParamFunction__Group__0__Impl"
    // InternalOcl.g:4381:1: rule__OneTypeParamFunction__Group__0__Impl : ( ( rule__OneTypeParamFunction__NameAssignment_0 ) ) ;
    public final void rule__OneTypeParamFunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4385:1: ( ( ( rule__OneTypeParamFunction__NameAssignment_0 ) ) )
            // InternalOcl.g:4386:1: ( ( rule__OneTypeParamFunction__NameAssignment_0 ) )
            {
            // InternalOcl.g:4386:1: ( ( rule__OneTypeParamFunction__NameAssignment_0 ) )
            // InternalOcl.g:4387:2: ( rule__OneTypeParamFunction__NameAssignment_0 )
            {
             before(grammarAccess.getOneTypeParamFunctionAccess().getNameAssignment_0()); 
            // InternalOcl.g:4388:2: ( rule__OneTypeParamFunction__NameAssignment_0 )
            // InternalOcl.g:4388:3: rule__OneTypeParamFunction__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__OneTypeParamFunction__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getOneTypeParamFunctionAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OneTypeParamFunction__Group__0__Impl"


    // $ANTLR start "rule__OneTypeParamFunction__Group__1"
    // InternalOcl.g:4396:1: rule__OneTypeParamFunction__Group__1 : rule__OneTypeParamFunction__Group__1__Impl rule__OneTypeParamFunction__Group__2 ;
    public final void rule__OneTypeParamFunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4400:1: ( rule__OneTypeParamFunction__Group__1__Impl rule__OneTypeParamFunction__Group__2 )
            // InternalOcl.g:4401:2: rule__OneTypeParamFunction__Group__1__Impl rule__OneTypeParamFunction__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__OneTypeParamFunction__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OneTypeParamFunction__Group__2();

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
    // $ANTLR end "rule__OneTypeParamFunction__Group__1"


    // $ANTLR start "rule__OneTypeParamFunction__Group__1__Impl"
    // InternalOcl.g:4408:1: rule__OneTypeParamFunction__Group__1__Impl : ( '(' ) ;
    public final void rule__OneTypeParamFunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4412:1: ( ( '(' ) )
            // InternalOcl.g:4413:1: ( '(' )
            {
            // InternalOcl.g:4413:1: ( '(' )
            // InternalOcl.g:4414:2: '('
            {
             before(grammarAccess.getOneTypeParamFunctionAccess().getLeftParenthesisKeyword_1()); 
            match(input,82,FOLLOW_2); 
             after(grammarAccess.getOneTypeParamFunctionAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OneTypeParamFunction__Group__1__Impl"


    // $ANTLR start "rule__OneTypeParamFunction__Group__2"
    // InternalOcl.g:4423:1: rule__OneTypeParamFunction__Group__2 : rule__OneTypeParamFunction__Group__2__Impl rule__OneTypeParamFunction__Group__3 ;
    public final void rule__OneTypeParamFunction__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4427:1: ( rule__OneTypeParamFunction__Group__2__Impl rule__OneTypeParamFunction__Group__3 )
            // InternalOcl.g:4428:2: rule__OneTypeParamFunction__Group__2__Impl rule__OneTypeParamFunction__Group__3
            {
            pushFollow(FOLLOW_18);
            rule__OneTypeParamFunction__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OneTypeParamFunction__Group__3();

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
    // $ANTLR end "rule__OneTypeParamFunction__Group__2"


    // $ANTLR start "rule__OneTypeParamFunction__Group__2__Impl"
    // InternalOcl.g:4435:1: rule__OneTypeParamFunction__Group__2__Impl : ( RULE_TYPENAME_TERMINAL ) ;
    public final void rule__OneTypeParamFunction__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4439:1: ( ( RULE_TYPENAME_TERMINAL ) )
            // InternalOcl.g:4440:1: ( RULE_TYPENAME_TERMINAL )
            {
            // InternalOcl.g:4440:1: ( RULE_TYPENAME_TERMINAL )
            // InternalOcl.g:4441:2: RULE_TYPENAME_TERMINAL
            {
             before(grammarAccess.getOneTypeParamFunctionAccess().getTYPENAME_TERMINALTerminalRuleCall_2()); 
            match(input,RULE_TYPENAME_TERMINAL,FOLLOW_2); 
             after(grammarAccess.getOneTypeParamFunctionAccess().getTYPENAME_TERMINALTerminalRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OneTypeParamFunction__Group__2__Impl"


    // $ANTLR start "rule__OneTypeParamFunction__Group__3"
    // InternalOcl.g:4450:1: rule__OneTypeParamFunction__Group__3 : rule__OneTypeParamFunction__Group__3__Impl ;
    public final void rule__OneTypeParamFunction__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4454:1: ( rule__OneTypeParamFunction__Group__3__Impl )
            // InternalOcl.g:4455:2: rule__OneTypeParamFunction__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OneTypeParamFunction__Group__3__Impl();

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
    // $ANTLR end "rule__OneTypeParamFunction__Group__3"


    // $ANTLR start "rule__OneTypeParamFunction__Group__3__Impl"
    // InternalOcl.g:4461:1: rule__OneTypeParamFunction__Group__3__Impl : ( ')' ) ;
    public final void rule__OneTypeParamFunction__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4465:1: ( ( ')' ) )
            // InternalOcl.g:4466:1: ( ')' )
            {
            // InternalOcl.g:4466:1: ( ')' )
            // InternalOcl.g:4467:2: ')'
            {
             before(grammarAccess.getOneTypeParamFunctionAccess().getRightParenthesisKeyword_3()); 
            match(input,83,FOLLOW_2); 
             after(grammarAccess.getOneTypeParamFunctionAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OneTypeParamFunction__Group__3__Impl"


    // $ANTLR start "rule__OneStringParamFunction__Group__0"
    // InternalOcl.g:4477:1: rule__OneStringParamFunction__Group__0 : rule__OneStringParamFunction__Group__0__Impl rule__OneStringParamFunction__Group__1 ;
    public final void rule__OneStringParamFunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4481:1: ( rule__OneStringParamFunction__Group__0__Impl rule__OneStringParamFunction__Group__1 )
            // InternalOcl.g:4482:2: rule__OneStringParamFunction__Group__0__Impl rule__OneStringParamFunction__Group__1
            {
            pushFollow(FOLLOW_36);
            rule__OneStringParamFunction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OneStringParamFunction__Group__1();

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
    // $ANTLR end "rule__OneStringParamFunction__Group__0"


    // $ANTLR start "rule__OneStringParamFunction__Group__0__Impl"
    // InternalOcl.g:4489:1: rule__OneStringParamFunction__Group__0__Impl : ( ( rule__OneStringParamFunction__NameAssignment_0 ) ) ;
    public final void rule__OneStringParamFunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4493:1: ( ( ( rule__OneStringParamFunction__NameAssignment_0 ) ) )
            // InternalOcl.g:4494:1: ( ( rule__OneStringParamFunction__NameAssignment_0 ) )
            {
            // InternalOcl.g:4494:1: ( ( rule__OneStringParamFunction__NameAssignment_0 ) )
            // InternalOcl.g:4495:2: ( rule__OneStringParamFunction__NameAssignment_0 )
            {
             before(grammarAccess.getOneStringParamFunctionAccess().getNameAssignment_0()); 
            // InternalOcl.g:4496:2: ( rule__OneStringParamFunction__NameAssignment_0 )
            // InternalOcl.g:4496:3: rule__OneStringParamFunction__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__OneStringParamFunction__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getOneStringParamFunctionAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OneStringParamFunction__Group__0__Impl"


    // $ANTLR start "rule__OneStringParamFunction__Group__1"
    // InternalOcl.g:4504:1: rule__OneStringParamFunction__Group__1 : rule__OneStringParamFunction__Group__1__Impl rule__OneStringParamFunction__Group__2 ;
    public final void rule__OneStringParamFunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4508:1: ( rule__OneStringParamFunction__Group__1__Impl rule__OneStringParamFunction__Group__2 )
            // InternalOcl.g:4509:2: rule__OneStringParamFunction__Group__1__Impl rule__OneStringParamFunction__Group__2
            {
            pushFollow(FOLLOW_37);
            rule__OneStringParamFunction__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OneStringParamFunction__Group__2();

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
    // $ANTLR end "rule__OneStringParamFunction__Group__1"


    // $ANTLR start "rule__OneStringParamFunction__Group__1__Impl"
    // InternalOcl.g:4516:1: rule__OneStringParamFunction__Group__1__Impl : ( '(' ) ;
    public final void rule__OneStringParamFunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4520:1: ( ( '(' ) )
            // InternalOcl.g:4521:1: ( '(' )
            {
            // InternalOcl.g:4521:1: ( '(' )
            // InternalOcl.g:4522:2: '('
            {
             before(grammarAccess.getOneStringParamFunctionAccess().getLeftParenthesisKeyword_1()); 
            match(input,82,FOLLOW_2); 
             after(grammarAccess.getOneStringParamFunctionAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OneStringParamFunction__Group__1__Impl"


    // $ANTLR start "rule__OneStringParamFunction__Group__2"
    // InternalOcl.g:4531:1: rule__OneStringParamFunction__Group__2 : rule__OneStringParamFunction__Group__2__Impl rule__OneStringParamFunction__Group__3 ;
    public final void rule__OneStringParamFunction__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4535:1: ( rule__OneStringParamFunction__Group__2__Impl rule__OneStringParamFunction__Group__3 )
            // InternalOcl.g:4536:2: rule__OneStringParamFunction__Group__2__Impl rule__OneStringParamFunction__Group__3
            {
            pushFollow(FOLLOW_18);
            rule__OneStringParamFunction__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OneStringParamFunction__Group__3();

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
    // $ANTLR end "rule__OneStringParamFunction__Group__2"


    // $ANTLR start "rule__OneStringParamFunction__Group__2__Impl"
    // InternalOcl.g:4543:1: rule__OneStringParamFunction__Group__2__Impl : ( RULE_STRING ) ;
    public final void rule__OneStringParamFunction__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4547:1: ( ( RULE_STRING ) )
            // InternalOcl.g:4548:1: ( RULE_STRING )
            {
            // InternalOcl.g:4548:1: ( RULE_STRING )
            // InternalOcl.g:4549:2: RULE_STRING
            {
             before(grammarAccess.getOneStringParamFunctionAccess().getSTRINGTerminalRuleCall_2()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getOneStringParamFunctionAccess().getSTRINGTerminalRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OneStringParamFunction__Group__2__Impl"


    // $ANTLR start "rule__OneStringParamFunction__Group__3"
    // InternalOcl.g:4558:1: rule__OneStringParamFunction__Group__3 : rule__OneStringParamFunction__Group__3__Impl ;
    public final void rule__OneStringParamFunction__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4562:1: ( rule__OneStringParamFunction__Group__3__Impl )
            // InternalOcl.g:4563:2: rule__OneStringParamFunction__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OneStringParamFunction__Group__3__Impl();

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
    // $ANTLR end "rule__OneStringParamFunction__Group__3"


    // $ANTLR start "rule__OneStringParamFunction__Group__3__Impl"
    // InternalOcl.g:4569:1: rule__OneStringParamFunction__Group__3__Impl : ( ')' ) ;
    public final void rule__OneStringParamFunction__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4573:1: ( ( ')' ) )
            // InternalOcl.g:4574:1: ( ')' )
            {
            // InternalOcl.g:4574:1: ( ')' )
            // InternalOcl.g:4575:2: ')'
            {
             before(grammarAccess.getOneStringParamFunctionAccess().getRightParenthesisKeyword_3()); 
            match(input,83,FOLLOW_2); 
             after(grammarAccess.getOneStringParamFunctionAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OneStringParamFunction__Group__3__Impl"


    // $ANTLR start "rule__TwoStringParamFunction__Group__0"
    // InternalOcl.g:4585:1: rule__TwoStringParamFunction__Group__0 : rule__TwoStringParamFunction__Group__0__Impl rule__TwoStringParamFunction__Group__1 ;
    public final void rule__TwoStringParamFunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4589:1: ( rule__TwoStringParamFunction__Group__0__Impl rule__TwoStringParamFunction__Group__1 )
            // InternalOcl.g:4590:2: rule__TwoStringParamFunction__Group__0__Impl rule__TwoStringParamFunction__Group__1
            {
            pushFollow(FOLLOW_36);
            rule__TwoStringParamFunction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TwoStringParamFunction__Group__1();

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
    // $ANTLR end "rule__TwoStringParamFunction__Group__0"


    // $ANTLR start "rule__TwoStringParamFunction__Group__0__Impl"
    // InternalOcl.g:4597:1: rule__TwoStringParamFunction__Group__0__Impl : ( ( rule__TwoStringParamFunction__NameAssignment_0 ) ) ;
    public final void rule__TwoStringParamFunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4601:1: ( ( ( rule__TwoStringParamFunction__NameAssignment_0 ) ) )
            // InternalOcl.g:4602:1: ( ( rule__TwoStringParamFunction__NameAssignment_0 ) )
            {
            // InternalOcl.g:4602:1: ( ( rule__TwoStringParamFunction__NameAssignment_0 ) )
            // InternalOcl.g:4603:2: ( rule__TwoStringParamFunction__NameAssignment_0 )
            {
             before(grammarAccess.getTwoStringParamFunctionAccess().getNameAssignment_0()); 
            // InternalOcl.g:4604:2: ( rule__TwoStringParamFunction__NameAssignment_0 )
            // InternalOcl.g:4604:3: rule__TwoStringParamFunction__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__TwoStringParamFunction__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getTwoStringParamFunctionAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoStringParamFunction__Group__0__Impl"


    // $ANTLR start "rule__TwoStringParamFunction__Group__1"
    // InternalOcl.g:4612:1: rule__TwoStringParamFunction__Group__1 : rule__TwoStringParamFunction__Group__1__Impl rule__TwoStringParamFunction__Group__2 ;
    public final void rule__TwoStringParamFunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4616:1: ( rule__TwoStringParamFunction__Group__1__Impl rule__TwoStringParamFunction__Group__2 )
            // InternalOcl.g:4617:2: rule__TwoStringParamFunction__Group__1__Impl rule__TwoStringParamFunction__Group__2
            {
            pushFollow(FOLLOW_37);
            rule__TwoStringParamFunction__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TwoStringParamFunction__Group__2();

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
    // $ANTLR end "rule__TwoStringParamFunction__Group__1"


    // $ANTLR start "rule__TwoStringParamFunction__Group__1__Impl"
    // InternalOcl.g:4624:1: rule__TwoStringParamFunction__Group__1__Impl : ( '(' ) ;
    public final void rule__TwoStringParamFunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4628:1: ( ( '(' ) )
            // InternalOcl.g:4629:1: ( '(' )
            {
            // InternalOcl.g:4629:1: ( '(' )
            // InternalOcl.g:4630:2: '('
            {
             before(grammarAccess.getTwoStringParamFunctionAccess().getLeftParenthesisKeyword_1()); 
            match(input,82,FOLLOW_2); 
             after(grammarAccess.getTwoStringParamFunctionAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoStringParamFunction__Group__1__Impl"


    // $ANTLR start "rule__TwoStringParamFunction__Group__2"
    // InternalOcl.g:4639:1: rule__TwoStringParamFunction__Group__2 : rule__TwoStringParamFunction__Group__2__Impl rule__TwoStringParamFunction__Group__3 ;
    public final void rule__TwoStringParamFunction__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4643:1: ( rule__TwoStringParamFunction__Group__2__Impl rule__TwoStringParamFunction__Group__3 )
            // InternalOcl.g:4644:2: rule__TwoStringParamFunction__Group__2__Impl rule__TwoStringParamFunction__Group__3
            {
            pushFollow(FOLLOW_34);
            rule__TwoStringParamFunction__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TwoStringParamFunction__Group__3();

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
    // $ANTLR end "rule__TwoStringParamFunction__Group__2"


    // $ANTLR start "rule__TwoStringParamFunction__Group__2__Impl"
    // InternalOcl.g:4651:1: rule__TwoStringParamFunction__Group__2__Impl : ( RULE_STRING ) ;
    public final void rule__TwoStringParamFunction__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4655:1: ( ( RULE_STRING ) )
            // InternalOcl.g:4656:1: ( RULE_STRING )
            {
            // InternalOcl.g:4656:1: ( RULE_STRING )
            // InternalOcl.g:4657:2: RULE_STRING
            {
             before(grammarAccess.getTwoStringParamFunctionAccess().getSTRINGTerminalRuleCall_2()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getTwoStringParamFunctionAccess().getSTRINGTerminalRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoStringParamFunction__Group__2__Impl"


    // $ANTLR start "rule__TwoStringParamFunction__Group__3"
    // InternalOcl.g:4666:1: rule__TwoStringParamFunction__Group__3 : rule__TwoStringParamFunction__Group__3__Impl rule__TwoStringParamFunction__Group__4 ;
    public final void rule__TwoStringParamFunction__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4670:1: ( rule__TwoStringParamFunction__Group__3__Impl rule__TwoStringParamFunction__Group__4 )
            // InternalOcl.g:4671:2: rule__TwoStringParamFunction__Group__3__Impl rule__TwoStringParamFunction__Group__4
            {
            pushFollow(FOLLOW_37);
            rule__TwoStringParamFunction__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TwoStringParamFunction__Group__4();

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
    // $ANTLR end "rule__TwoStringParamFunction__Group__3"


    // $ANTLR start "rule__TwoStringParamFunction__Group__3__Impl"
    // InternalOcl.g:4678:1: rule__TwoStringParamFunction__Group__3__Impl : ( ',' ) ;
    public final void rule__TwoStringParamFunction__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4682:1: ( ( ',' ) )
            // InternalOcl.g:4683:1: ( ',' )
            {
            // InternalOcl.g:4683:1: ( ',' )
            // InternalOcl.g:4684:2: ','
            {
             before(grammarAccess.getTwoStringParamFunctionAccess().getCommaKeyword_3()); 
            match(input,92,FOLLOW_2); 
             after(grammarAccess.getTwoStringParamFunctionAccess().getCommaKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoStringParamFunction__Group__3__Impl"


    // $ANTLR start "rule__TwoStringParamFunction__Group__4"
    // InternalOcl.g:4693:1: rule__TwoStringParamFunction__Group__4 : rule__TwoStringParamFunction__Group__4__Impl rule__TwoStringParamFunction__Group__5 ;
    public final void rule__TwoStringParamFunction__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4697:1: ( rule__TwoStringParamFunction__Group__4__Impl rule__TwoStringParamFunction__Group__5 )
            // InternalOcl.g:4698:2: rule__TwoStringParamFunction__Group__4__Impl rule__TwoStringParamFunction__Group__5
            {
            pushFollow(FOLLOW_18);
            rule__TwoStringParamFunction__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TwoStringParamFunction__Group__5();

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
    // $ANTLR end "rule__TwoStringParamFunction__Group__4"


    // $ANTLR start "rule__TwoStringParamFunction__Group__4__Impl"
    // InternalOcl.g:4705:1: rule__TwoStringParamFunction__Group__4__Impl : ( RULE_STRING ) ;
    public final void rule__TwoStringParamFunction__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4709:1: ( ( RULE_STRING ) )
            // InternalOcl.g:4710:1: ( RULE_STRING )
            {
            // InternalOcl.g:4710:1: ( RULE_STRING )
            // InternalOcl.g:4711:2: RULE_STRING
            {
             before(grammarAccess.getTwoStringParamFunctionAccess().getSTRINGTerminalRuleCall_4()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getTwoStringParamFunctionAccess().getSTRINGTerminalRuleCall_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoStringParamFunction__Group__4__Impl"


    // $ANTLR start "rule__TwoStringParamFunction__Group__5"
    // InternalOcl.g:4720:1: rule__TwoStringParamFunction__Group__5 : rule__TwoStringParamFunction__Group__5__Impl ;
    public final void rule__TwoStringParamFunction__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4724:1: ( rule__TwoStringParamFunction__Group__5__Impl )
            // InternalOcl.g:4725:2: rule__TwoStringParamFunction__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TwoStringParamFunction__Group__5__Impl();

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
    // $ANTLR end "rule__TwoStringParamFunction__Group__5"


    // $ANTLR start "rule__TwoStringParamFunction__Group__5__Impl"
    // InternalOcl.g:4731:1: rule__TwoStringParamFunction__Group__5__Impl : ( ')' ) ;
    public final void rule__TwoStringParamFunction__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4735:1: ( ( ')' ) )
            // InternalOcl.g:4736:1: ( ')' )
            {
            // InternalOcl.g:4736:1: ( ')' )
            // InternalOcl.g:4737:2: ')'
            {
             before(grammarAccess.getTwoStringParamFunctionAccess().getRightParenthesisKeyword_5()); 
            match(input,83,FOLLOW_2); 
             after(grammarAccess.getTwoStringParamFunctionAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoStringParamFunction__Group__5__Impl"


    // $ANTLR start "rule__OneIntegerParamFunction__Group__0"
    // InternalOcl.g:4747:1: rule__OneIntegerParamFunction__Group__0 : rule__OneIntegerParamFunction__Group__0__Impl rule__OneIntegerParamFunction__Group__1 ;
    public final void rule__OneIntegerParamFunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4751:1: ( rule__OneIntegerParamFunction__Group__0__Impl rule__OneIntegerParamFunction__Group__1 )
            // InternalOcl.g:4752:2: rule__OneIntegerParamFunction__Group__0__Impl rule__OneIntegerParamFunction__Group__1
            {
            pushFollow(FOLLOW_36);
            rule__OneIntegerParamFunction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OneIntegerParamFunction__Group__1();

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
    // $ANTLR end "rule__OneIntegerParamFunction__Group__0"


    // $ANTLR start "rule__OneIntegerParamFunction__Group__0__Impl"
    // InternalOcl.g:4759:1: rule__OneIntegerParamFunction__Group__0__Impl : ( ( rule__OneIntegerParamFunction__NameAssignment_0 ) ) ;
    public final void rule__OneIntegerParamFunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4763:1: ( ( ( rule__OneIntegerParamFunction__NameAssignment_0 ) ) )
            // InternalOcl.g:4764:1: ( ( rule__OneIntegerParamFunction__NameAssignment_0 ) )
            {
            // InternalOcl.g:4764:1: ( ( rule__OneIntegerParamFunction__NameAssignment_0 ) )
            // InternalOcl.g:4765:2: ( rule__OneIntegerParamFunction__NameAssignment_0 )
            {
             before(grammarAccess.getOneIntegerParamFunctionAccess().getNameAssignment_0()); 
            // InternalOcl.g:4766:2: ( rule__OneIntegerParamFunction__NameAssignment_0 )
            // InternalOcl.g:4766:3: rule__OneIntegerParamFunction__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__OneIntegerParamFunction__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getOneIntegerParamFunctionAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OneIntegerParamFunction__Group__0__Impl"


    // $ANTLR start "rule__OneIntegerParamFunction__Group__1"
    // InternalOcl.g:4774:1: rule__OneIntegerParamFunction__Group__1 : rule__OneIntegerParamFunction__Group__1__Impl rule__OneIntegerParamFunction__Group__2 ;
    public final void rule__OneIntegerParamFunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4778:1: ( rule__OneIntegerParamFunction__Group__1__Impl rule__OneIntegerParamFunction__Group__2 )
            // InternalOcl.g:4779:2: rule__OneIntegerParamFunction__Group__1__Impl rule__OneIntegerParamFunction__Group__2
            {
            pushFollow(FOLLOW_38);
            rule__OneIntegerParamFunction__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OneIntegerParamFunction__Group__2();

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
    // $ANTLR end "rule__OneIntegerParamFunction__Group__1"


    // $ANTLR start "rule__OneIntegerParamFunction__Group__1__Impl"
    // InternalOcl.g:4786:1: rule__OneIntegerParamFunction__Group__1__Impl : ( '(' ) ;
    public final void rule__OneIntegerParamFunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4790:1: ( ( '(' ) )
            // InternalOcl.g:4791:1: ( '(' )
            {
            // InternalOcl.g:4791:1: ( '(' )
            // InternalOcl.g:4792:2: '('
            {
             before(grammarAccess.getOneIntegerParamFunctionAccess().getLeftParenthesisKeyword_1()); 
            match(input,82,FOLLOW_2); 
             after(grammarAccess.getOneIntegerParamFunctionAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OneIntegerParamFunction__Group__1__Impl"


    // $ANTLR start "rule__OneIntegerParamFunction__Group__2"
    // InternalOcl.g:4801:1: rule__OneIntegerParamFunction__Group__2 : rule__OneIntegerParamFunction__Group__2__Impl rule__OneIntegerParamFunction__Group__3 ;
    public final void rule__OneIntegerParamFunction__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4805:1: ( rule__OneIntegerParamFunction__Group__2__Impl rule__OneIntegerParamFunction__Group__3 )
            // InternalOcl.g:4806:2: rule__OneIntegerParamFunction__Group__2__Impl rule__OneIntegerParamFunction__Group__3
            {
            pushFollow(FOLLOW_18);
            rule__OneIntegerParamFunction__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OneIntegerParamFunction__Group__3();

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
    // $ANTLR end "rule__OneIntegerParamFunction__Group__2"


    // $ANTLR start "rule__OneIntegerParamFunction__Group__2__Impl"
    // InternalOcl.g:4813:1: rule__OneIntegerParamFunction__Group__2__Impl : ( RULE_NUMBER ) ;
    public final void rule__OneIntegerParamFunction__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4817:1: ( ( RULE_NUMBER ) )
            // InternalOcl.g:4818:1: ( RULE_NUMBER )
            {
            // InternalOcl.g:4818:1: ( RULE_NUMBER )
            // InternalOcl.g:4819:2: RULE_NUMBER
            {
             before(grammarAccess.getOneIntegerParamFunctionAccess().getNUMBERTerminalRuleCall_2()); 
            match(input,RULE_NUMBER,FOLLOW_2); 
             after(grammarAccess.getOneIntegerParamFunctionAccess().getNUMBERTerminalRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OneIntegerParamFunction__Group__2__Impl"


    // $ANTLR start "rule__OneIntegerParamFunction__Group__3"
    // InternalOcl.g:4828:1: rule__OneIntegerParamFunction__Group__3 : rule__OneIntegerParamFunction__Group__3__Impl ;
    public final void rule__OneIntegerParamFunction__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4832:1: ( rule__OneIntegerParamFunction__Group__3__Impl )
            // InternalOcl.g:4833:2: rule__OneIntegerParamFunction__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OneIntegerParamFunction__Group__3__Impl();

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
    // $ANTLR end "rule__OneIntegerParamFunction__Group__3"


    // $ANTLR start "rule__OneIntegerParamFunction__Group__3__Impl"
    // InternalOcl.g:4839:1: rule__OneIntegerParamFunction__Group__3__Impl : ( ')' ) ;
    public final void rule__OneIntegerParamFunction__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4843:1: ( ( ')' ) )
            // InternalOcl.g:4844:1: ( ')' )
            {
            // InternalOcl.g:4844:1: ( ')' )
            // InternalOcl.g:4845:2: ')'
            {
             before(grammarAccess.getOneIntegerParamFunctionAccess().getRightParenthesisKeyword_3()); 
            match(input,83,FOLLOW_2); 
             after(grammarAccess.getOneIntegerParamFunctionAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OneIntegerParamFunction__Group__3__Impl"


    // $ANTLR start "rule__TwoIntegerParamFunction__Group__0"
    // InternalOcl.g:4855:1: rule__TwoIntegerParamFunction__Group__0 : rule__TwoIntegerParamFunction__Group__0__Impl rule__TwoIntegerParamFunction__Group__1 ;
    public final void rule__TwoIntegerParamFunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4859:1: ( rule__TwoIntegerParamFunction__Group__0__Impl rule__TwoIntegerParamFunction__Group__1 )
            // InternalOcl.g:4860:2: rule__TwoIntegerParamFunction__Group__0__Impl rule__TwoIntegerParamFunction__Group__1
            {
            pushFollow(FOLLOW_36);
            rule__TwoIntegerParamFunction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TwoIntegerParamFunction__Group__1();

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
    // $ANTLR end "rule__TwoIntegerParamFunction__Group__0"


    // $ANTLR start "rule__TwoIntegerParamFunction__Group__0__Impl"
    // InternalOcl.g:4867:1: rule__TwoIntegerParamFunction__Group__0__Impl : ( ( rule__TwoIntegerParamFunction__NameAssignment_0 ) ) ;
    public final void rule__TwoIntegerParamFunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4871:1: ( ( ( rule__TwoIntegerParamFunction__NameAssignment_0 ) ) )
            // InternalOcl.g:4872:1: ( ( rule__TwoIntegerParamFunction__NameAssignment_0 ) )
            {
            // InternalOcl.g:4872:1: ( ( rule__TwoIntegerParamFunction__NameAssignment_0 ) )
            // InternalOcl.g:4873:2: ( rule__TwoIntegerParamFunction__NameAssignment_0 )
            {
             before(grammarAccess.getTwoIntegerParamFunctionAccess().getNameAssignment_0()); 
            // InternalOcl.g:4874:2: ( rule__TwoIntegerParamFunction__NameAssignment_0 )
            // InternalOcl.g:4874:3: rule__TwoIntegerParamFunction__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__TwoIntegerParamFunction__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getTwoIntegerParamFunctionAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoIntegerParamFunction__Group__0__Impl"


    // $ANTLR start "rule__TwoIntegerParamFunction__Group__1"
    // InternalOcl.g:4882:1: rule__TwoIntegerParamFunction__Group__1 : rule__TwoIntegerParamFunction__Group__1__Impl rule__TwoIntegerParamFunction__Group__2 ;
    public final void rule__TwoIntegerParamFunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4886:1: ( rule__TwoIntegerParamFunction__Group__1__Impl rule__TwoIntegerParamFunction__Group__2 )
            // InternalOcl.g:4887:2: rule__TwoIntegerParamFunction__Group__1__Impl rule__TwoIntegerParamFunction__Group__2
            {
            pushFollow(FOLLOW_38);
            rule__TwoIntegerParamFunction__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TwoIntegerParamFunction__Group__2();

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
    // $ANTLR end "rule__TwoIntegerParamFunction__Group__1"


    // $ANTLR start "rule__TwoIntegerParamFunction__Group__1__Impl"
    // InternalOcl.g:4894:1: rule__TwoIntegerParamFunction__Group__1__Impl : ( '(' ) ;
    public final void rule__TwoIntegerParamFunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4898:1: ( ( '(' ) )
            // InternalOcl.g:4899:1: ( '(' )
            {
            // InternalOcl.g:4899:1: ( '(' )
            // InternalOcl.g:4900:2: '('
            {
             before(grammarAccess.getTwoIntegerParamFunctionAccess().getLeftParenthesisKeyword_1()); 
            match(input,82,FOLLOW_2); 
             after(grammarAccess.getTwoIntegerParamFunctionAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoIntegerParamFunction__Group__1__Impl"


    // $ANTLR start "rule__TwoIntegerParamFunction__Group__2"
    // InternalOcl.g:4909:1: rule__TwoIntegerParamFunction__Group__2 : rule__TwoIntegerParamFunction__Group__2__Impl rule__TwoIntegerParamFunction__Group__3 ;
    public final void rule__TwoIntegerParamFunction__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4913:1: ( rule__TwoIntegerParamFunction__Group__2__Impl rule__TwoIntegerParamFunction__Group__3 )
            // InternalOcl.g:4914:2: rule__TwoIntegerParamFunction__Group__2__Impl rule__TwoIntegerParamFunction__Group__3
            {
            pushFollow(FOLLOW_34);
            rule__TwoIntegerParamFunction__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TwoIntegerParamFunction__Group__3();

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
    // $ANTLR end "rule__TwoIntegerParamFunction__Group__2"


    // $ANTLR start "rule__TwoIntegerParamFunction__Group__2__Impl"
    // InternalOcl.g:4921:1: rule__TwoIntegerParamFunction__Group__2__Impl : ( RULE_NUMBER ) ;
    public final void rule__TwoIntegerParamFunction__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4925:1: ( ( RULE_NUMBER ) )
            // InternalOcl.g:4926:1: ( RULE_NUMBER )
            {
            // InternalOcl.g:4926:1: ( RULE_NUMBER )
            // InternalOcl.g:4927:2: RULE_NUMBER
            {
             before(grammarAccess.getTwoIntegerParamFunctionAccess().getNUMBERTerminalRuleCall_2()); 
            match(input,RULE_NUMBER,FOLLOW_2); 
             after(grammarAccess.getTwoIntegerParamFunctionAccess().getNUMBERTerminalRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoIntegerParamFunction__Group__2__Impl"


    // $ANTLR start "rule__TwoIntegerParamFunction__Group__3"
    // InternalOcl.g:4936:1: rule__TwoIntegerParamFunction__Group__3 : rule__TwoIntegerParamFunction__Group__3__Impl rule__TwoIntegerParamFunction__Group__4 ;
    public final void rule__TwoIntegerParamFunction__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4940:1: ( rule__TwoIntegerParamFunction__Group__3__Impl rule__TwoIntegerParamFunction__Group__4 )
            // InternalOcl.g:4941:2: rule__TwoIntegerParamFunction__Group__3__Impl rule__TwoIntegerParamFunction__Group__4
            {
            pushFollow(FOLLOW_38);
            rule__TwoIntegerParamFunction__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TwoIntegerParamFunction__Group__4();

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
    // $ANTLR end "rule__TwoIntegerParamFunction__Group__3"


    // $ANTLR start "rule__TwoIntegerParamFunction__Group__3__Impl"
    // InternalOcl.g:4948:1: rule__TwoIntegerParamFunction__Group__3__Impl : ( ',' ) ;
    public final void rule__TwoIntegerParamFunction__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4952:1: ( ( ',' ) )
            // InternalOcl.g:4953:1: ( ',' )
            {
            // InternalOcl.g:4953:1: ( ',' )
            // InternalOcl.g:4954:2: ','
            {
             before(grammarAccess.getTwoIntegerParamFunctionAccess().getCommaKeyword_3()); 
            match(input,92,FOLLOW_2); 
             after(grammarAccess.getTwoIntegerParamFunctionAccess().getCommaKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoIntegerParamFunction__Group__3__Impl"


    // $ANTLR start "rule__TwoIntegerParamFunction__Group__4"
    // InternalOcl.g:4963:1: rule__TwoIntegerParamFunction__Group__4 : rule__TwoIntegerParamFunction__Group__4__Impl rule__TwoIntegerParamFunction__Group__5 ;
    public final void rule__TwoIntegerParamFunction__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4967:1: ( rule__TwoIntegerParamFunction__Group__4__Impl rule__TwoIntegerParamFunction__Group__5 )
            // InternalOcl.g:4968:2: rule__TwoIntegerParamFunction__Group__4__Impl rule__TwoIntegerParamFunction__Group__5
            {
            pushFollow(FOLLOW_18);
            rule__TwoIntegerParamFunction__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TwoIntegerParamFunction__Group__5();

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
    // $ANTLR end "rule__TwoIntegerParamFunction__Group__4"


    // $ANTLR start "rule__TwoIntegerParamFunction__Group__4__Impl"
    // InternalOcl.g:4975:1: rule__TwoIntegerParamFunction__Group__4__Impl : ( RULE_NUMBER ) ;
    public final void rule__TwoIntegerParamFunction__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4979:1: ( ( RULE_NUMBER ) )
            // InternalOcl.g:4980:1: ( RULE_NUMBER )
            {
            // InternalOcl.g:4980:1: ( RULE_NUMBER )
            // InternalOcl.g:4981:2: RULE_NUMBER
            {
             before(grammarAccess.getTwoIntegerParamFunctionAccess().getNUMBERTerminalRuleCall_4()); 
            match(input,RULE_NUMBER,FOLLOW_2); 
             after(grammarAccess.getTwoIntegerParamFunctionAccess().getNUMBERTerminalRuleCall_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoIntegerParamFunction__Group__4__Impl"


    // $ANTLR start "rule__TwoIntegerParamFunction__Group__5"
    // InternalOcl.g:4990:1: rule__TwoIntegerParamFunction__Group__5 : rule__TwoIntegerParamFunction__Group__5__Impl ;
    public final void rule__TwoIntegerParamFunction__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:4994:1: ( rule__TwoIntegerParamFunction__Group__5__Impl )
            // InternalOcl.g:4995:2: rule__TwoIntegerParamFunction__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TwoIntegerParamFunction__Group__5__Impl();

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
    // $ANTLR end "rule__TwoIntegerParamFunction__Group__5"


    // $ANTLR start "rule__TwoIntegerParamFunction__Group__5__Impl"
    // InternalOcl.g:5001:1: rule__TwoIntegerParamFunction__Group__5__Impl : ( ')' ) ;
    public final void rule__TwoIntegerParamFunction__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5005:1: ( ( ')' ) )
            // InternalOcl.g:5006:1: ( ')' )
            {
            // InternalOcl.g:5006:1: ( ')' )
            // InternalOcl.g:5007:2: ')'
            {
             before(grammarAccess.getTwoIntegerParamFunctionAccess().getRightParenthesisKeyword_5()); 
            match(input,83,FOLLOW_2); 
             after(grammarAccess.getTwoIntegerParamFunctionAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoIntegerParamFunction__Group__5__Impl"


    // $ANTLR start "rule__LogicalExpression__ExpAssignment_0"
    // InternalOcl.g:5017:1: rule__LogicalExpression__ExpAssignment_0 : ( ruleRelationalExpression ) ;
    public final void rule__LogicalExpression__ExpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5021:1: ( ( ruleRelationalExpression ) )
            // InternalOcl.g:5022:2: ( ruleRelationalExpression )
            {
            // InternalOcl.g:5022:2: ( ruleRelationalExpression )
            // InternalOcl.g:5023:3: ruleRelationalExpression
            {
             before(grammarAccess.getLogicalExpressionAccess().getExpRelationalExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleRelationalExpression();

            state._fsp--;

             after(grammarAccess.getLogicalExpressionAccess().getExpRelationalExpressionParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalExpression__ExpAssignment_0"


    // $ANTLR start "rule__LogicalExpression__OpAssignment_1_0"
    // InternalOcl.g:5032:1: rule__LogicalExpression__OpAssignment_1_0 : ( ruleLogicalOperator ) ;
    public final void rule__LogicalExpression__OpAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5036:1: ( ( ruleLogicalOperator ) )
            // InternalOcl.g:5037:2: ( ruleLogicalOperator )
            {
            // InternalOcl.g:5037:2: ( ruleLogicalOperator )
            // InternalOcl.g:5038:3: ruleLogicalOperator
            {
             before(grammarAccess.getLogicalExpressionAccess().getOpLogicalOperatorParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleLogicalOperator();

            state._fsp--;

             after(grammarAccess.getLogicalExpressionAccess().getOpLogicalOperatorParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalExpression__OpAssignment_1_0"


    // $ANTLR start "rule__LogicalExpression__ExpAssignment_1_1"
    // InternalOcl.g:5047:1: rule__LogicalExpression__ExpAssignment_1_1 : ( ruleRelationalExpression ) ;
    public final void rule__LogicalExpression__ExpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5051:1: ( ( ruleRelationalExpression ) )
            // InternalOcl.g:5052:2: ( ruleRelationalExpression )
            {
            // InternalOcl.g:5052:2: ( ruleRelationalExpression )
            // InternalOcl.g:5053:3: ruleRelationalExpression
            {
             before(grammarAccess.getLogicalExpressionAccess().getExpRelationalExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleRelationalExpression();

            state._fsp--;

             after(grammarAccess.getLogicalExpressionAccess().getExpRelationalExpressionParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalExpression__ExpAssignment_1_1"


    // $ANTLR start "rule__RelationalExpression__ExpAssignment_0"
    // InternalOcl.g:5062:1: rule__RelationalExpression__ExpAssignment_0 : ( ruleAdditiveExpression ) ;
    public final void rule__RelationalExpression__ExpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5066:1: ( ( ruleAdditiveExpression ) )
            // InternalOcl.g:5067:2: ( ruleAdditiveExpression )
            {
            // InternalOcl.g:5067:2: ( ruleAdditiveExpression )
            // InternalOcl.g:5068:3: ruleAdditiveExpression
            {
             before(grammarAccess.getRelationalExpressionAccess().getExpAdditiveExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleAdditiveExpression();

            state._fsp--;

             after(grammarAccess.getRelationalExpressionAccess().getExpAdditiveExpressionParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpression__ExpAssignment_0"


    // $ANTLR start "rule__RelationalExpression__OpAssignment_1_0"
    // InternalOcl.g:5077:1: rule__RelationalExpression__OpAssignment_1_0 : ( ruleRelationalOperator ) ;
    public final void rule__RelationalExpression__OpAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5081:1: ( ( ruleRelationalOperator ) )
            // InternalOcl.g:5082:2: ( ruleRelationalOperator )
            {
            // InternalOcl.g:5082:2: ( ruleRelationalOperator )
            // InternalOcl.g:5083:3: ruleRelationalOperator
            {
             before(grammarAccess.getRelationalExpressionAccess().getOpRelationalOperatorParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleRelationalOperator();

            state._fsp--;

             after(grammarAccess.getRelationalExpressionAccess().getOpRelationalOperatorParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpression__OpAssignment_1_0"


    // $ANTLR start "rule__RelationalExpression__ExpAssignment_1_1"
    // InternalOcl.g:5092:1: rule__RelationalExpression__ExpAssignment_1_1 : ( ruleAdditiveExpression ) ;
    public final void rule__RelationalExpression__ExpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5096:1: ( ( ruleAdditiveExpression ) )
            // InternalOcl.g:5097:2: ( ruleAdditiveExpression )
            {
            // InternalOcl.g:5097:2: ( ruleAdditiveExpression )
            // InternalOcl.g:5098:3: ruleAdditiveExpression
            {
             before(grammarAccess.getRelationalExpressionAccess().getExpAdditiveExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAdditiveExpression();

            state._fsp--;

             after(grammarAccess.getRelationalExpressionAccess().getExpAdditiveExpressionParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpression__ExpAssignment_1_1"


    // $ANTLR start "rule__AdditiveExpression__ExpAssignment_0"
    // InternalOcl.g:5107:1: rule__AdditiveExpression__ExpAssignment_0 : ( ruleMultiplicativeExpression ) ;
    public final void rule__AdditiveExpression__ExpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5111:1: ( ( ruleMultiplicativeExpression ) )
            // InternalOcl.g:5112:2: ( ruleMultiplicativeExpression )
            {
            // InternalOcl.g:5112:2: ( ruleMultiplicativeExpression )
            // InternalOcl.g:5113:3: ruleMultiplicativeExpression
            {
             before(grammarAccess.getAdditiveExpressionAccess().getExpMultiplicativeExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleMultiplicativeExpression();

            state._fsp--;

             after(grammarAccess.getAdditiveExpressionAccess().getExpMultiplicativeExpressionParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpression__ExpAssignment_0"


    // $ANTLR start "rule__AdditiveExpression__OpAssignment_1_0"
    // InternalOcl.g:5122:1: rule__AdditiveExpression__OpAssignment_1_0 : ( ruleAddOperator ) ;
    public final void rule__AdditiveExpression__OpAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5126:1: ( ( ruleAddOperator ) )
            // InternalOcl.g:5127:2: ( ruleAddOperator )
            {
            // InternalOcl.g:5127:2: ( ruleAddOperator )
            // InternalOcl.g:5128:3: ruleAddOperator
            {
             before(grammarAccess.getAdditiveExpressionAccess().getOpAddOperatorParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleAddOperator();

            state._fsp--;

             after(grammarAccess.getAdditiveExpressionAccess().getOpAddOperatorParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpression__OpAssignment_1_0"


    // $ANTLR start "rule__AdditiveExpression__ExpAssignment_1_1"
    // InternalOcl.g:5137:1: rule__AdditiveExpression__ExpAssignment_1_1 : ( ruleMultiplicativeExpression ) ;
    public final void rule__AdditiveExpression__ExpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5141:1: ( ( ruleMultiplicativeExpression ) )
            // InternalOcl.g:5142:2: ( ruleMultiplicativeExpression )
            {
            // InternalOcl.g:5142:2: ( ruleMultiplicativeExpression )
            // InternalOcl.g:5143:3: ruleMultiplicativeExpression
            {
             before(grammarAccess.getAdditiveExpressionAccess().getExpMultiplicativeExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleMultiplicativeExpression();

            state._fsp--;

             after(grammarAccess.getAdditiveExpressionAccess().getExpMultiplicativeExpressionParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpression__ExpAssignment_1_1"


    // $ANTLR start "rule__MultiplicativeExpression__ExpAssignment_0"
    // InternalOcl.g:5152:1: rule__MultiplicativeExpression__ExpAssignment_0 : ( ruleUnaryExpression ) ;
    public final void rule__MultiplicativeExpression__ExpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5156:1: ( ( ruleUnaryExpression ) )
            // InternalOcl.g:5157:2: ( ruleUnaryExpression )
            {
            // InternalOcl.g:5157:2: ( ruleUnaryExpression )
            // InternalOcl.g:5158:3: ruleUnaryExpression
            {
             before(grammarAccess.getMultiplicativeExpressionAccess().getExpUnaryExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleUnaryExpression();

            state._fsp--;

             after(grammarAccess.getMultiplicativeExpressionAccess().getExpUnaryExpressionParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpression__ExpAssignment_0"


    // $ANTLR start "rule__MultiplicativeExpression__OpAssignment_1_0"
    // InternalOcl.g:5167:1: rule__MultiplicativeExpression__OpAssignment_1_0 : ( ruleMultiplyOperator ) ;
    public final void rule__MultiplicativeExpression__OpAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5171:1: ( ( ruleMultiplyOperator ) )
            // InternalOcl.g:5172:2: ( ruleMultiplyOperator )
            {
            // InternalOcl.g:5172:2: ( ruleMultiplyOperator )
            // InternalOcl.g:5173:3: ruleMultiplyOperator
            {
             before(grammarAccess.getMultiplicativeExpressionAccess().getOpMultiplyOperatorParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleMultiplyOperator();

            state._fsp--;

             after(grammarAccess.getMultiplicativeExpressionAccess().getOpMultiplyOperatorParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpression__OpAssignment_1_0"


    // $ANTLR start "rule__MultiplicativeExpression__ExpAssignment_1_1"
    // InternalOcl.g:5182:1: rule__MultiplicativeExpression__ExpAssignment_1_1 : ( ruleUnaryExpression ) ;
    public final void rule__MultiplicativeExpression__ExpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5186:1: ( ( ruleUnaryExpression ) )
            // InternalOcl.g:5187:2: ( ruleUnaryExpression )
            {
            // InternalOcl.g:5187:2: ( ruleUnaryExpression )
            // InternalOcl.g:5188:3: ruleUnaryExpression
            {
             before(grammarAccess.getMultiplicativeExpressionAccess().getExpUnaryExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleUnaryExpression();

            state._fsp--;

             after(grammarAccess.getMultiplicativeExpressionAccess().getExpUnaryExpressionParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpression__ExpAssignment_1_1"


    // $ANTLR start "rule__UnaryExpression__OpAssignment_0"
    // InternalOcl.g:5197:1: rule__UnaryExpression__OpAssignment_0 : ( ruleUnaryOperator ) ;
    public final void rule__UnaryExpression__OpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5201:1: ( ( ruleUnaryOperator ) )
            // InternalOcl.g:5202:2: ( ruleUnaryOperator )
            {
            // InternalOcl.g:5202:2: ( ruleUnaryOperator )
            // InternalOcl.g:5203:3: ruleUnaryOperator
            {
             before(grammarAccess.getUnaryExpressionAccess().getOpUnaryOperatorParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleUnaryOperator();

            state._fsp--;

             after(grammarAccess.getUnaryExpressionAccess().getOpUnaryOperatorParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryExpression__OpAssignment_0"


    // $ANTLR start "rule__UnaryExpression__ExpAssignment_1"
    // InternalOcl.g:5212:1: rule__UnaryExpression__ExpAssignment_1 : ( rulePostfixExpression ) ;
    public final void rule__UnaryExpression__ExpAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5216:1: ( ( rulePostfixExpression ) )
            // InternalOcl.g:5217:2: ( rulePostfixExpression )
            {
            // InternalOcl.g:5217:2: ( rulePostfixExpression )
            // InternalOcl.g:5218:3: rulePostfixExpression
            {
             before(grammarAccess.getUnaryExpressionAccess().getExpPostfixExpressionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            rulePostfixExpression();

            state._fsp--;

             after(grammarAccess.getUnaryExpressionAccess().getExpPostfixExpressionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryExpression__ExpAssignment_1"


    // $ANTLR start "rule__PostfixExpression__OpAssignment_1_0"
    // InternalOcl.g:5227:1: rule__PostfixExpression__OpAssignment_1_0 : ( ruleNavigationOperator ) ;
    public final void rule__PostfixExpression__OpAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5231:1: ( ( ruleNavigationOperator ) )
            // InternalOcl.g:5232:2: ( ruleNavigationOperator )
            {
            // InternalOcl.g:5232:2: ( ruleNavigationOperator )
            // InternalOcl.g:5233:3: ruleNavigationOperator
            {
             before(grammarAccess.getPostfixExpressionAccess().getOpNavigationOperatorParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleNavigationOperator();

            state._fsp--;

             after(grammarAccess.getPostfixExpressionAccess().getOpNavigationOperatorParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PostfixExpression__OpAssignment_1_0"


    // $ANTLR start "rule__PostfixExpression__FeaturesAssignment_1_1"
    // InternalOcl.g:5242:1: rule__PostfixExpression__FeaturesAssignment_1_1 : ( ruleFeatureCall ) ;
    public final void rule__PostfixExpression__FeaturesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5246:1: ( ( ruleFeatureCall ) )
            // InternalOcl.g:5247:2: ( ruleFeatureCall )
            {
            // InternalOcl.g:5247:2: ( ruleFeatureCall )
            // InternalOcl.g:5248:3: ruleFeatureCall
            {
             before(grammarAccess.getPostfixExpressionAccess().getFeaturesFeatureCallParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleFeatureCall();

            state._fsp--;

             after(grammarAccess.getPostfixExpressionAccess().getFeaturesFeatureCallParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PostfixExpression__FeaturesAssignment_1_1"


    // $ANTLR start "rule__IfExpression__ExpAssignment_1"
    // InternalOcl.g:5257:1: rule__IfExpression__ExpAssignment_1 : ( ruleExpression ) ;
    public final void rule__IfExpression__ExpAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5261:1: ( ( ruleExpression ) )
            // InternalOcl.g:5262:2: ( ruleExpression )
            {
            // InternalOcl.g:5262:2: ( ruleExpression )
            // InternalOcl.g:5263:3: ruleExpression
            {
             before(grammarAccess.getIfExpressionAccess().getExpExpressionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getIfExpressionAccess().getExpExpressionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExpression__ExpAssignment_1"


    // $ANTLR start "rule__IfExpression__ExpAssignment_3"
    // InternalOcl.g:5272:1: rule__IfExpression__ExpAssignment_3 : ( ruleExpression ) ;
    public final void rule__IfExpression__ExpAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5276:1: ( ( ruleExpression ) )
            // InternalOcl.g:5277:2: ( ruleExpression )
            {
            // InternalOcl.g:5277:2: ( ruleExpression )
            // InternalOcl.g:5278:3: ruleExpression
            {
             before(grammarAccess.getIfExpressionAccess().getExpExpressionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getIfExpressionAccess().getExpExpressionParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExpression__ExpAssignment_3"


    // $ANTLR start "rule__IfExpression__ExpAssignment_4_1"
    // InternalOcl.g:5287:1: rule__IfExpression__ExpAssignment_4_1 : ( ruleExpression ) ;
    public final void rule__IfExpression__ExpAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5291:1: ( ( ruleExpression ) )
            // InternalOcl.g:5292:2: ( ruleExpression )
            {
            // InternalOcl.g:5292:2: ( ruleExpression )
            // InternalOcl.g:5293:3: ruleExpression
            {
             before(grammarAccess.getIfExpressionAccess().getExpExpressionParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getIfExpressionAccess().getExpExpressionParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExpression__ExpAssignment_4_1"


    // $ANTLR start "rule__FeatureCallParameters__DecsAssignment_1"
    // InternalOcl.g:5302:1: rule__FeatureCallParameters__DecsAssignment_1 : ( ruleDeclarator ) ;
    public final void rule__FeatureCallParameters__DecsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5306:1: ( ( ruleDeclarator ) )
            // InternalOcl.g:5307:2: ( ruleDeclarator )
            {
            // InternalOcl.g:5307:2: ( ruleDeclarator )
            // InternalOcl.g:5308:3: ruleDeclarator
            {
             before(grammarAccess.getFeatureCallParametersAccess().getDecsDeclaratorParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDeclarator();

            state._fsp--;

             after(grammarAccess.getFeatureCallParametersAccess().getDecsDeclaratorParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCallParameters__DecsAssignment_1"


    // $ANTLR start "rule__FeatureCallParameters__ParamsAssignment_2"
    // InternalOcl.g:5317:1: rule__FeatureCallParameters__ParamsAssignment_2 : ( ruleActualParameterList ) ;
    public final void rule__FeatureCallParameters__ParamsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5321:1: ( ( ruleActualParameterList ) )
            // InternalOcl.g:5322:2: ( ruleActualParameterList )
            {
            // InternalOcl.g:5322:2: ( ruleActualParameterList )
            // InternalOcl.g:5323:3: ruleActualParameterList
            {
             before(grammarAccess.getFeatureCallParametersAccess().getParamsActualParameterListParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleActualParameterList();

            state._fsp--;

             after(grammarAccess.getFeatureCallParametersAccess().getParamsActualParameterListParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCallParameters__ParamsAssignment_2"


    // $ANTLR start "rule__Literal__NameAssignment_0"
    // InternalOcl.g:5332:1: rule__Literal__NameAssignment_0 : ( RULE_STRING ) ;
    public final void rule__Literal__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5336:1: ( ( RULE_STRING ) )
            // InternalOcl.g:5337:2: ( RULE_STRING )
            {
            // InternalOcl.g:5337:2: ( RULE_STRING )
            // InternalOcl.g:5338:3: RULE_STRING
            {
             before(grammarAccess.getLiteralAccess().getNameSTRINGTerminalRuleCall_0_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getLiteralAccess().getNameSTRINGTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__NameAssignment_0"


    // $ANTLR start "rule__Literal__NameAssignment_1"
    // InternalOcl.g:5347:1: rule__Literal__NameAssignment_1 : ( RULE_NUMBER ) ;
    public final void rule__Literal__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5351:1: ( ( RULE_NUMBER ) )
            // InternalOcl.g:5352:2: ( RULE_NUMBER )
            {
            // InternalOcl.g:5352:2: ( RULE_NUMBER )
            // InternalOcl.g:5353:3: RULE_NUMBER
            {
             before(grammarAccess.getLiteralAccess().getNameNUMBERTerminalRuleCall_1_0()); 
            match(input,RULE_NUMBER,FOLLOW_2); 
             after(grammarAccess.getLiteralAccess().getNameNUMBERTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__NameAssignment_1"


    // $ANTLR start "rule__Literal__NameAssignment_2_1"
    // InternalOcl.g:5362:1: rule__Literal__NameAssignment_2_1 : ( RULE_NAME_TERMINAL ) ;
    public final void rule__Literal__NameAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5366:1: ( ( RULE_NAME_TERMINAL ) )
            // InternalOcl.g:5367:2: ( RULE_NAME_TERMINAL )
            {
            // InternalOcl.g:5367:2: ( RULE_NAME_TERMINAL )
            // InternalOcl.g:5368:3: RULE_NAME_TERMINAL
            {
             before(grammarAccess.getLiteralAccess().getNameNAME_TERMINALTerminalRuleCall_2_1_0()); 
            match(input,RULE_NAME_TERMINAL,FOLLOW_2); 
             after(grammarAccess.getLiteralAccess().getNameNAME_TERMINALTerminalRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__NameAssignment_2_1"


    // $ANTLR start "rule__EnumerationType__LeftAssignment_2_1"
    // InternalOcl.g:5377:1: rule__EnumerationType__LeftAssignment_2_1 : ( ruleName ) ;
    public final void rule__EnumerationType__LeftAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5381:1: ( ( ruleName ) )
            // InternalOcl.g:5382:2: ( ruleName )
            {
            // InternalOcl.g:5382:2: ( ruleName )
            // InternalOcl.g:5383:3: ruleName
            {
             before(grammarAccess.getEnumerationTypeAccess().getLeftNameParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleName();

            state._fsp--;

             after(grammarAccess.getEnumerationTypeAccess().getLeftNameParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationType__LeftAssignment_2_1"


    // $ANTLR start "rule__EnumerationType__RightsAssignment_3_2"
    // InternalOcl.g:5392:1: rule__EnumerationType__RightsAssignment_3_2 : ( ruleName ) ;
    public final void rule__EnumerationType__RightsAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5396:1: ( ( ruleName ) )
            // InternalOcl.g:5397:2: ( ruleName )
            {
            // InternalOcl.g:5397:2: ( ruleName )
            // InternalOcl.g:5398:3: ruleName
            {
             before(grammarAccess.getEnumerationTypeAccess().getRightsNameParserRuleCall_3_2_0()); 
            pushFollow(FOLLOW_2);
            ruleName();

            state._fsp--;

             after(grammarAccess.getEnumerationTypeAccess().getRightsNameParserRuleCall_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumerationType__RightsAssignment_3_2"


    // $ANTLR start "rule__LiteralCollection__NameAssignment_1"
    // InternalOcl.g:5407:1: rule__LiteralCollection__NameAssignment_1 : ( ruleCollectionKind ) ;
    public final void rule__LiteralCollection__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5411:1: ( ( ruleCollectionKind ) )
            // InternalOcl.g:5412:2: ( ruleCollectionKind )
            {
            // InternalOcl.g:5412:2: ( ruleCollectionKind )
            // InternalOcl.g:5413:3: ruleCollectionKind
            {
             before(grammarAccess.getLiteralCollectionAccess().getNameCollectionKindParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleCollectionKind();

            state._fsp--;

             after(grammarAccess.getLiteralCollectionAccess().getNameCollectionKindParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralCollection__NameAssignment_1"


    // $ANTLR start "rule__LiteralCollection__ExpAssignment_3"
    // InternalOcl.g:5422:1: rule__LiteralCollection__ExpAssignment_3 : ( ruleExpressionListOrRange ) ;
    public final void rule__LiteralCollection__ExpAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5426:1: ( ( ruleExpressionListOrRange ) )
            // InternalOcl.g:5427:2: ( ruleExpressionListOrRange )
            {
            // InternalOcl.g:5427:2: ( ruleExpressionListOrRange )
            // InternalOcl.g:5428:3: ruleExpressionListOrRange
            {
             before(grammarAccess.getLiteralCollectionAccess().getExpExpressionListOrRangeParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleExpressionListOrRange();

            state._fsp--;

             after(grammarAccess.getLiteralCollectionAccess().getExpExpressionListOrRangeParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralCollection__ExpAssignment_3"


    // $ANTLR start "rule__ExpressionListOrRange__ExpAssignment_0"
    // InternalOcl.g:5437:1: rule__ExpressionListOrRange__ExpAssignment_0 : ( ruleExpression ) ;
    public final void rule__ExpressionListOrRange__ExpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5441:1: ( ( ruleExpression ) )
            // InternalOcl.g:5442:2: ( ruleExpression )
            {
            // InternalOcl.g:5442:2: ( ruleExpression )
            // InternalOcl.g:5443:3: ruleExpression
            {
             before(grammarAccess.getExpressionListOrRangeAccess().getExpExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getExpressionListOrRangeAccess().getExpExpressionParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionListOrRange__ExpAssignment_0"


    // $ANTLR start "rule__ExpressionListOrRange__ExpAssignment_1_0_1"
    // InternalOcl.g:5452:1: rule__ExpressionListOrRange__ExpAssignment_1_0_1 : ( ruleExpression ) ;
    public final void rule__ExpressionListOrRange__ExpAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5456:1: ( ( ruleExpression ) )
            // InternalOcl.g:5457:2: ( ruleExpression )
            {
            // InternalOcl.g:5457:2: ( ruleExpression )
            // InternalOcl.g:5458:3: ruleExpression
            {
             before(grammarAccess.getExpressionListOrRangeAccess().getExpExpressionParserRuleCall_1_0_1_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getExpressionListOrRangeAccess().getExpExpressionParserRuleCall_1_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionListOrRange__ExpAssignment_1_0_1"


    // $ANTLR start "rule__ExpressionListOrRange__ExpAssignment_1_1_1"
    // InternalOcl.g:5467:1: rule__ExpressionListOrRange__ExpAssignment_1_1_1 : ( ruleExpression ) ;
    public final void rule__ExpressionListOrRange__ExpAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5471:1: ( ( ruleExpression ) )
            // InternalOcl.g:5472:2: ( ruleExpression )
            {
            // InternalOcl.g:5472:2: ( ruleExpression )
            // InternalOcl.g:5473:3: ruleExpression
            {
             before(grammarAccess.getExpressionListOrRangeAccess().getExpExpressionParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getExpressionListOrRangeAccess().getExpExpressionParserRuleCall_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionListOrRange__ExpAssignment_1_1_1"


    // $ANTLR start "rule__FeatureCall__ParamsAssignment_1"
    // InternalOcl.g:5482:1: rule__FeatureCall__ParamsAssignment_1 : ( ruleTimeExpression ) ;
    public final void rule__FeatureCall__ParamsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5486:1: ( ( ruleTimeExpression ) )
            // InternalOcl.g:5487:2: ( ruleTimeExpression )
            {
            // InternalOcl.g:5487:2: ( ruleTimeExpression )
            // InternalOcl.g:5488:3: ruleTimeExpression
            {
             before(grammarAccess.getFeatureCallAccess().getParamsTimeExpressionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTimeExpression();

            state._fsp--;

             after(grammarAccess.getFeatureCallAccess().getParamsTimeExpressionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCall__ParamsAssignment_1"


    // $ANTLR start "rule__FeatureCall__ParamsAssignment_2"
    // InternalOcl.g:5497:1: rule__FeatureCall__ParamsAssignment_2 : ( ruleQualifiers ) ;
    public final void rule__FeatureCall__ParamsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5501:1: ( ( ruleQualifiers ) )
            // InternalOcl.g:5502:2: ( ruleQualifiers )
            {
            // InternalOcl.g:5502:2: ( ruleQualifiers )
            // InternalOcl.g:5503:3: ruleQualifiers
            {
             before(grammarAccess.getFeatureCallAccess().getParamsQualifiersParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleQualifiers();

            state._fsp--;

             after(grammarAccess.getFeatureCallAccess().getParamsQualifiersParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCall__ParamsAssignment_2"


    // $ANTLR start "rule__FeatureCall__ParamsAssignment_3"
    // InternalOcl.g:5512:1: rule__FeatureCall__ParamsAssignment_3 : ( ruleFeatureCallParameters ) ;
    public final void rule__FeatureCall__ParamsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5516:1: ( ( ruleFeatureCallParameters ) )
            // InternalOcl.g:5517:2: ( ruleFeatureCallParameters )
            {
            // InternalOcl.g:5517:2: ( ruleFeatureCallParameters )
            // InternalOcl.g:5518:3: ruleFeatureCallParameters
            {
             before(grammarAccess.getFeatureCallAccess().getParamsFeatureCallParametersParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleFeatureCallParameters();

            state._fsp--;

             after(grammarAccess.getFeatureCallAccess().getParamsFeatureCallParametersParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureCall__ParamsAssignment_3"


    // $ANTLR start "rule__Declarator__NameAssignment_0"
    // InternalOcl.g:5527:1: rule__Declarator__NameAssignment_0 : ( ruleName ) ;
    public final void rule__Declarator__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5531:1: ( ( ruleName ) )
            // InternalOcl.g:5532:2: ( ruleName )
            {
            // InternalOcl.g:5532:2: ( ruleName )
            // InternalOcl.g:5533:3: ruleName
            {
             before(grammarAccess.getDeclaratorAccess().getNameNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleName();

            state._fsp--;

             after(grammarAccess.getDeclaratorAccess().getNameNameParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declarator__NameAssignment_0"


    // $ANTLR start "rule__Declarator__NameAssignment_1_1"
    // InternalOcl.g:5542:1: rule__Declarator__NameAssignment_1_1 : ( ruleName ) ;
    public final void rule__Declarator__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5546:1: ( ( ruleName ) )
            // InternalOcl.g:5547:2: ( ruleName )
            {
            // InternalOcl.g:5547:2: ( ruleName )
            // InternalOcl.g:5548:3: ruleName
            {
             before(grammarAccess.getDeclaratorAccess().getNameNameParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleName();

            state._fsp--;

             after(grammarAccess.getDeclaratorAccess().getNameNameParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declarator__NameAssignment_1_1"


    // $ANTLR start "rule__Declarator__TypeAssignment_2_1"
    // InternalOcl.g:5557:1: rule__Declarator__TypeAssignment_2_1 : ( ruleSimpleTypeSpecifier ) ;
    public final void rule__Declarator__TypeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5561:1: ( ( ruleSimpleTypeSpecifier ) )
            // InternalOcl.g:5562:2: ( ruleSimpleTypeSpecifier )
            {
            // InternalOcl.g:5562:2: ( ruleSimpleTypeSpecifier )
            // InternalOcl.g:5563:3: ruleSimpleTypeSpecifier
            {
             before(grammarAccess.getDeclaratorAccess().getTypeSimpleTypeSpecifierParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleSimpleTypeSpecifier();

            state._fsp--;

             after(grammarAccess.getDeclaratorAccess().getTypeSimpleTypeSpecifierParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declarator__TypeAssignment_2_1"


    // $ANTLR start "rule__PathTypeName__LeftAssignment_0"
    // InternalOcl.g:5572:1: rule__PathTypeName__LeftAssignment_0 : ( ruleTypeName ) ;
    public final void rule__PathTypeName__LeftAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5576:1: ( ( ruleTypeName ) )
            // InternalOcl.g:5577:2: ( ruleTypeName )
            {
            // InternalOcl.g:5577:2: ( ruleTypeName )
            // InternalOcl.g:5578:3: ruleTypeName
            {
             before(grammarAccess.getPathTypeNameAccess().getLeftTypeNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleTypeName();

            state._fsp--;

             after(grammarAccess.getPathTypeNameAccess().getLeftTypeNameParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathTypeName__LeftAssignment_0"


    // $ANTLR start "rule__PathTypeName__RightsAssignment_1_1"
    // InternalOcl.g:5587:1: rule__PathTypeName__RightsAssignment_1_1 : ( ruleTypeName ) ;
    public final void rule__PathTypeName__RightsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5591:1: ( ( ruleTypeName ) )
            // InternalOcl.g:5592:2: ( ruleTypeName )
            {
            // InternalOcl.g:5592:2: ( ruleTypeName )
            // InternalOcl.g:5593:3: ruleTypeName
            {
             before(grammarAccess.getPathTypeNameAccess().getRightsTypeNameParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTypeName();

            state._fsp--;

             after(grammarAccess.getPathTypeNameAccess().getRightsTypeNameParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathTypeName__RightsAssignment_1_1"


    // $ANTLR start "rule__PathName__LeftAssignment_0"
    // InternalOcl.g:5602:1: rule__PathName__LeftAssignment_0 : ( ( rule__PathName__LeftAlternatives_0_0 ) ) ;
    public final void rule__PathName__LeftAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5606:1: ( ( ( rule__PathName__LeftAlternatives_0_0 ) ) )
            // InternalOcl.g:5607:2: ( ( rule__PathName__LeftAlternatives_0_0 ) )
            {
            // InternalOcl.g:5607:2: ( ( rule__PathName__LeftAlternatives_0_0 ) )
            // InternalOcl.g:5608:3: ( rule__PathName__LeftAlternatives_0_0 )
            {
             before(grammarAccess.getPathNameAccess().getLeftAlternatives_0_0()); 
            // InternalOcl.g:5609:3: ( rule__PathName__LeftAlternatives_0_0 )
            // InternalOcl.g:5609:4: rule__PathName__LeftAlternatives_0_0
            {
            pushFollow(FOLLOW_2);
            rule__PathName__LeftAlternatives_0_0();

            state._fsp--;


            }

             after(grammarAccess.getPathNameAccess().getLeftAlternatives_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathName__LeftAssignment_0"


    // $ANTLR start "rule__PathName__RightsAssignment_1_1"
    // InternalOcl.g:5617:1: rule__PathName__RightsAssignment_1_1 : ( ( rule__PathName__RightsAlternatives_1_1_0 ) ) ;
    public final void rule__PathName__RightsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5621:1: ( ( ( rule__PathName__RightsAlternatives_1_1_0 ) ) )
            // InternalOcl.g:5622:2: ( ( rule__PathName__RightsAlternatives_1_1_0 ) )
            {
            // InternalOcl.g:5622:2: ( ( rule__PathName__RightsAlternatives_1_1_0 ) )
            // InternalOcl.g:5623:3: ( rule__PathName__RightsAlternatives_1_1_0 )
            {
             before(grammarAccess.getPathNameAccess().getRightsAlternatives_1_1_0()); 
            // InternalOcl.g:5624:3: ( rule__PathName__RightsAlternatives_1_1_0 )
            // InternalOcl.g:5624:4: rule__PathName__RightsAlternatives_1_1_0
            {
            pushFollow(FOLLOW_2);
            rule__PathName__RightsAlternatives_1_1_0();

            state._fsp--;


            }

             after(grammarAccess.getPathNameAccess().getRightsAlternatives_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathName__RightsAssignment_1_1"


    // $ANTLR start "rule__TimeExpression__NameAssignment_1"
    // InternalOcl.g:5632:1: rule__TimeExpression__NameAssignment_1 : ( RULE_NAME_TERMINAL ) ;
    public final void rule__TimeExpression__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5636:1: ( ( RULE_NAME_TERMINAL ) )
            // InternalOcl.g:5637:2: ( RULE_NAME_TERMINAL )
            {
            // InternalOcl.g:5637:2: ( RULE_NAME_TERMINAL )
            // InternalOcl.g:5638:3: RULE_NAME_TERMINAL
            {
             before(grammarAccess.getTimeExpressionAccess().getNameNAME_TERMINALTerminalRuleCall_1_0()); 
            match(input,RULE_NAME_TERMINAL,FOLLOW_2); 
             after(grammarAccess.getTimeExpressionAccess().getNameNAME_TERMINALTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeExpression__NameAssignment_1"


    // $ANTLR start "rule__ActualParameterList__ExpAssignment_0"
    // InternalOcl.g:5647:1: rule__ActualParameterList__ExpAssignment_0 : ( ruleExpression ) ;
    public final void rule__ActualParameterList__ExpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5651:1: ( ( ruleExpression ) )
            // InternalOcl.g:5652:2: ( ruleExpression )
            {
            // InternalOcl.g:5652:2: ( ruleExpression )
            // InternalOcl.g:5653:3: ruleExpression
            {
             before(grammarAccess.getActualParameterListAccess().getExpExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getActualParameterListAccess().getExpExpressionParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActualParameterList__ExpAssignment_0"


    // $ANTLR start "rule__ActualParameterList__ExpAssignment_1_1"
    // InternalOcl.g:5662:1: rule__ActualParameterList__ExpAssignment_1_1 : ( ruleExpression ) ;
    public final void rule__ActualParameterList__ExpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5666:1: ( ( ruleExpression ) )
            // InternalOcl.g:5667:2: ( ruleExpression )
            {
            // InternalOcl.g:5667:2: ( ruleExpression )
            // InternalOcl.g:5668:3: ruleExpression
            {
             before(grammarAccess.getActualParameterListAccess().getExpExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getActualParameterListAccess().getExpExpressionParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActualParameterList__ExpAssignment_1_1"


    // $ANTLR start "rule__TypeName__NameAssignment"
    // InternalOcl.g:5677:1: rule__TypeName__NameAssignment : ( RULE_TYPENAME_TERMINAL ) ;
    public final void rule__TypeName__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5681:1: ( ( RULE_TYPENAME_TERMINAL ) )
            // InternalOcl.g:5682:2: ( RULE_TYPENAME_TERMINAL )
            {
            // InternalOcl.g:5682:2: ( RULE_TYPENAME_TERMINAL )
            // InternalOcl.g:5683:3: RULE_TYPENAME_TERMINAL
            {
             before(grammarAccess.getTypeNameAccess().getNameTYPENAME_TERMINALTerminalRuleCall_0()); 
            match(input,RULE_TYPENAME_TERMINAL,FOLLOW_2); 
             after(grammarAccess.getTypeNameAccess().getNameTYPENAME_TERMINALTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeName__NameAssignment"


    // $ANTLR start "rule__Attribute__NameAssignment"
    // InternalOcl.g:5692:1: rule__Attribute__NameAssignment : ( RULE_NAME_TERMINAL ) ;
    public final void rule__Attribute__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5696:1: ( ( RULE_NAME_TERMINAL ) )
            // InternalOcl.g:5697:2: ( RULE_NAME_TERMINAL )
            {
            // InternalOcl.g:5697:2: ( RULE_NAME_TERMINAL )
            // InternalOcl.g:5698:3: RULE_NAME_TERMINAL
            {
             before(grammarAccess.getAttributeAccess().getNameNAME_TERMINALTerminalRuleCall_0()); 
            match(input,RULE_NAME_TERMINAL,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getNameNAME_TERMINALTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__NameAssignment"


    // $ANTLR start "rule__NoParamFunction__NameAssignment_0"
    // InternalOcl.g:5707:1: rule__NoParamFunction__NameAssignment_0 : ( ( rule__NoParamFunction__NameAlternatives_0_0 ) ) ;
    public final void rule__NoParamFunction__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5711:1: ( ( ( rule__NoParamFunction__NameAlternatives_0_0 ) ) )
            // InternalOcl.g:5712:2: ( ( rule__NoParamFunction__NameAlternatives_0_0 ) )
            {
            // InternalOcl.g:5712:2: ( ( rule__NoParamFunction__NameAlternatives_0_0 ) )
            // InternalOcl.g:5713:3: ( rule__NoParamFunction__NameAlternatives_0_0 )
            {
             before(grammarAccess.getNoParamFunctionAccess().getNameAlternatives_0_0()); 
            // InternalOcl.g:5714:3: ( rule__NoParamFunction__NameAlternatives_0_0 )
            // InternalOcl.g:5714:4: rule__NoParamFunction__NameAlternatives_0_0
            {
            pushFollow(FOLLOW_2);
            rule__NoParamFunction__NameAlternatives_0_0();

            state._fsp--;


            }

             after(grammarAccess.getNoParamFunctionAccess().getNameAlternatives_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NoParamFunction__NameAssignment_0"


    // $ANTLR start "rule__OneTypeParamFunction__NameAssignment_0"
    // InternalOcl.g:5722:1: rule__OneTypeParamFunction__NameAssignment_0 : ( ( rule__OneTypeParamFunction__NameAlternatives_0_0 ) ) ;
    public final void rule__OneTypeParamFunction__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5726:1: ( ( ( rule__OneTypeParamFunction__NameAlternatives_0_0 ) ) )
            // InternalOcl.g:5727:2: ( ( rule__OneTypeParamFunction__NameAlternatives_0_0 ) )
            {
            // InternalOcl.g:5727:2: ( ( rule__OneTypeParamFunction__NameAlternatives_0_0 ) )
            // InternalOcl.g:5728:3: ( rule__OneTypeParamFunction__NameAlternatives_0_0 )
            {
             before(grammarAccess.getOneTypeParamFunctionAccess().getNameAlternatives_0_0()); 
            // InternalOcl.g:5729:3: ( rule__OneTypeParamFunction__NameAlternatives_0_0 )
            // InternalOcl.g:5729:4: rule__OneTypeParamFunction__NameAlternatives_0_0
            {
            pushFollow(FOLLOW_2);
            rule__OneTypeParamFunction__NameAlternatives_0_0();

            state._fsp--;


            }

             after(grammarAccess.getOneTypeParamFunctionAccess().getNameAlternatives_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OneTypeParamFunction__NameAssignment_0"


    // $ANTLR start "rule__OneStringParamFunction__NameAssignment_0"
    // InternalOcl.g:5737:1: rule__OneStringParamFunction__NameAssignment_0 : ( ( rule__OneStringParamFunction__NameAlternatives_0_0 ) ) ;
    public final void rule__OneStringParamFunction__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5741:1: ( ( ( rule__OneStringParamFunction__NameAlternatives_0_0 ) ) )
            // InternalOcl.g:5742:2: ( ( rule__OneStringParamFunction__NameAlternatives_0_0 ) )
            {
            // InternalOcl.g:5742:2: ( ( rule__OneStringParamFunction__NameAlternatives_0_0 ) )
            // InternalOcl.g:5743:3: ( rule__OneStringParamFunction__NameAlternatives_0_0 )
            {
             before(grammarAccess.getOneStringParamFunctionAccess().getNameAlternatives_0_0()); 
            // InternalOcl.g:5744:3: ( rule__OneStringParamFunction__NameAlternatives_0_0 )
            // InternalOcl.g:5744:4: rule__OneStringParamFunction__NameAlternatives_0_0
            {
            pushFollow(FOLLOW_2);
            rule__OneStringParamFunction__NameAlternatives_0_0();

            state._fsp--;


            }

             after(grammarAccess.getOneStringParamFunctionAccess().getNameAlternatives_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OneStringParamFunction__NameAssignment_0"


    // $ANTLR start "rule__TwoStringParamFunction__NameAssignment_0"
    // InternalOcl.g:5752:1: rule__TwoStringParamFunction__NameAssignment_0 : ( ( rule__TwoStringParamFunction__NameAlternatives_0_0 ) ) ;
    public final void rule__TwoStringParamFunction__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5756:1: ( ( ( rule__TwoStringParamFunction__NameAlternatives_0_0 ) ) )
            // InternalOcl.g:5757:2: ( ( rule__TwoStringParamFunction__NameAlternatives_0_0 ) )
            {
            // InternalOcl.g:5757:2: ( ( rule__TwoStringParamFunction__NameAlternatives_0_0 ) )
            // InternalOcl.g:5758:3: ( rule__TwoStringParamFunction__NameAlternatives_0_0 )
            {
             before(grammarAccess.getTwoStringParamFunctionAccess().getNameAlternatives_0_0()); 
            // InternalOcl.g:5759:3: ( rule__TwoStringParamFunction__NameAlternatives_0_0 )
            // InternalOcl.g:5759:4: rule__TwoStringParamFunction__NameAlternatives_0_0
            {
            pushFollow(FOLLOW_2);
            rule__TwoStringParamFunction__NameAlternatives_0_0();

            state._fsp--;


            }

             after(grammarAccess.getTwoStringParamFunctionAccess().getNameAlternatives_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoStringParamFunction__NameAssignment_0"


    // $ANTLR start "rule__OneIntegerParamFunction__NameAssignment_0"
    // InternalOcl.g:5767:1: rule__OneIntegerParamFunction__NameAssignment_0 : ( ( 'at' ) ) ;
    public final void rule__OneIntegerParamFunction__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5771:1: ( ( ( 'at' ) ) )
            // InternalOcl.g:5772:2: ( ( 'at' ) )
            {
            // InternalOcl.g:5772:2: ( ( 'at' ) )
            // InternalOcl.g:5773:3: ( 'at' )
            {
             before(grammarAccess.getOneIntegerParamFunctionAccess().getNameAtKeyword_0_0()); 
            // InternalOcl.g:5774:3: ( 'at' )
            // InternalOcl.g:5775:4: 'at'
            {
             before(grammarAccess.getOneIntegerParamFunctionAccess().getNameAtKeyword_0_0()); 
            match(input,99,FOLLOW_2); 
             after(grammarAccess.getOneIntegerParamFunctionAccess().getNameAtKeyword_0_0()); 

            }

             after(grammarAccess.getOneIntegerParamFunctionAccess().getNameAtKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OneIntegerParamFunction__NameAssignment_0"


    // $ANTLR start "rule__TwoIntegerParamFunction__NameAssignment_0"
    // InternalOcl.g:5786:1: rule__TwoIntegerParamFunction__NameAssignment_0 : ( ( rule__TwoIntegerParamFunction__NameAlternatives_0_0 ) ) ;
    public final void rule__TwoIntegerParamFunction__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5790:1: ( ( ( rule__TwoIntegerParamFunction__NameAlternatives_0_0 ) ) )
            // InternalOcl.g:5791:2: ( ( rule__TwoIntegerParamFunction__NameAlternatives_0_0 ) )
            {
            // InternalOcl.g:5791:2: ( ( rule__TwoIntegerParamFunction__NameAlternatives_0_0 ) )
            // InternalOcl.g:5792:3: ( rule__TwoIntegerParamFunction__NameAlternatives_0_0 )
            {
             before(grammarAccess.getTwoIntegerParamFunctionAccess().getNameAlternatives_0_0()); 
            // InternalOcl.g:5793:3: ( rule__TwoIntegerParamFunction__NameAlternatives_0_0 )
            // InternalOcl.g:5793:4: rule__TwoIntegerParamFunction__NameAlternatives_0_0
            {
            pushFollow(FOLLOW_2);
            rule__TwoIntegerParamFunction__NameAlternatives_0_0();

            state._fsp--;


            }

             after(grammarAccess.getTwoIntegerParamFunctionAccess().getNameAlternatives_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoIntegerParamFunction__NameAssignment_0"


    // $ANTLR start "rule__CollectionKind__NameAssignment"
    // InternalOcl.g:5801:1: rule__CollectionKind__NameAssignment : ( ( rule__CollectionKind__NameAlternatives_0 ) ) ;
    public final void rule__CollectionKind__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5805:1: ( ( ( rule__CollectionKind__NameAlternatives_0 ) ) )
            // InternalOcl.g:5806:2: ( ( rule__CollectionKind__NameAlternatives_0 ) )
            {
            // InternalOcl.g:5806:2: ( ( rule__CollectionKind__NameAlternatives_0 ) )
            // InternalOcl.g:5807:3: ( rule__CollectionKind__NameAlternatives_0 )
            {
             before(grammarAccess.getCollectionKindAccess().getNameAlternatives_0()); 
            // InternalOcl.g:5808:3: ( rule__CollectionKind__NameAlternatives_0 )
            // InternalOcl.g:5808:4: rule__CollectionKind__NameAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__CollectionKind__NameAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getCollectionKindAccess().getNameAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionKind__NameAssignment"


    // $ANTLR start "rule__NavigationOperator__NameAssignment"
    // InternalOcl.g:5816:1: rule__NavigationOperator__NameAssignment : ( ( rule__NavigationOperator__NameAlternatives_0 ) ) ;
    public final void rule__NavigationOperator__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5820:1: ( ( ( rule__NavigationOperator__NameAlternatives_0 ) ) )
            // InternalOcl.g:5821:2: ( ( rule__NavigationOperator__NameAlternatives_0 ) )
            {
            // InternalOcl.g:5821:2: ( ( rule__NavigationOperator__NameAlternatives_0 ) )
            // InternalOcl.g:5822:3: ( rule__NavigationOperator__NameAlternatives_0 )
            {
             before(grammarAccess.getNavigationOperatorAccess().getNameAlternatives_0()); 
            // InternalOcl.g:5823:3: ( rule__NavigationOperator__NameAlternatives_0 )
            // InternalOcl.g:5823:4: rule__NavigationOperator__NameAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__NavigationOperator__NameAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getNavigationOperatorAccess().getNameAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationOperator__NameAssignment"


    // $ANTLR start "rule__UnaryOperator__NameAssignment"
    // InternalOcl.g:5831:1: rule__UnaryOperator__NameAssignment : ( ( rule__UnaryOperator__NameAlternatives_0 ) ) ;
    public final void rule__UnaryOperator__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5835:1: ( ( ( rule__UnaryOperator__NameAlternatives_0 ) ) )
            // InternalOcl.g:5836:2: ( ( rule__UnaryOperator__NameAlternatives_0 ) )
            {
            // InternalOcl.g:5836:2: ( ( rule__UnaryOperator__NameAlternatives_0 ) )
            // InternalOcl.g:5837:3: ( rule__UnaryOperator__NameAlternatives_0 )
            {
             before(grammarAccess.getUnaryOperatorAccess().getNameAlternatives_0()); 
            // InternalOcl.g:5838:3: ( rule__UnaryOperator__NameAlternatives_0 )
            // InternalOcl.g:5838:4: rule__UnaryOperator__NameAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__UnaryOperator__NameAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getUnaryOperatorAccess().getNameAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryOperator__NameAssignment"


    // $ANTLR start "rule__MultiplyOperator__NameAssignment"
    // InternalOcl.g:5846:1: rule__MultiplyOperator__NameAssignment : ( ( rule__MultiplyOperator__NameAlternatives_0 ) ) ;
    public final void rule__MultiplyOperator__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5850:1: ( ( ( rule__MultiplyOperator__NameAlternatives_0 ) ) )
            // InternalOcl.g:5851:2: ( ( rule__MultiplyOperator__NameAlternatives_0 ) )
            {
            // InternalOcl.g:5851:2: ( ( rule__MultiplyOperator__NameAlternatives_0 ) )
            // InternalOcl.g:5852:3: ( rule__MultiplyOperator__NameAlternatives_0 )
            {
             before(grammarAccess.getMultiplyOperatorAccess().getNameAlternatives_0()); 
            // InternalOcl.g:5853:3: ( rule__MultiplyOperator__NameAlternatives_0 )
            // InternalOcl.g:5853:4: rule__MultiplyOperator__NameAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__MultiplyOperator__NameAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getMultiplyOperatorAccess().getNameAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplyOperator__NameAssignment"


    // $ANTLR start "rule__AddOperator__NameAssignment"
    // InternalOcl.g:5861:1: rule__AddOperator__NameAssignment : ( ( rule__AddOperator__NameAlternatives_0 ) ) ;
    public final void rule__AddOperator__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5865:1: ( ( ( rule__AddOperator__NameAlternatives_0 ) ) )
            // InternalOcl.g:5866:2: ( ( rule__AddOperator__NameAlternatives_0 ) )
            {
            // InternalOcl.g:5866:2: ( ( rule__AddOperator__NameAlternatives_0 ) )
            // InternalOcl.g:5867:3: ( rule__AddOperator__NameAlternatives_0 )
            {
             before(grammarAccess.getAddOperatorAccess().getNameAlternatives_0()); 
            // InternalOcl.g:5868:3: ( rule__AddOperator__NameAlternatives_0 )
            // InternalOcl.g:5868:4: rule__AddOperator__NameAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__AddOperator__NameAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getAddOperatorAccess().getNameAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AddOperator__NameAssignment"


    // $ANTLR start "rule__RelationalOperator__NameAssignment"
    // InternalOcl.g:5876:1: rule__RelationalOperator__NameAssignment : ( ( rule__RelationalOperator__NameAlternatives_0 ) ) ;
    public final void rule__RelationalOperator__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5880:1: ( ( ( rule__RelationalOperator__NameAlternatives_0 ) ) )
            // InternalOcl.g:5881:2: ( ( rule__RelationalOperator__NameAlternatives_0 ) )
            {
            // InternalOcl.g:5881:2: ( ( rule__RelationalOperator__NameAlternatives_0 ) )
            // InternalOcl.g:5882:3: ( rule__RelationalOperator__NameAlternatives_0 )
            {
             before(grammarAccess.getRelationalOperatorAccess().getNameAlternatives_0()); 
            // InternalOcl.g:5883:3: ( rule__RelationalOperator__NameAlternatives_0 )
            // InternalOcl.g:5883:4: rule__RelationalOperator__NameAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__RelationalOperator__NameAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getRelationalOperatorAccess().getNameAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalOperator__NameAssignment"


    // $ANTLR start "rule__LogicalOperator__NameAssignment"
    // InternalOcl.g:5891:1: rule__LogicalOperator__NameAssignment : ( ( rule__LogicalOperator__NameAlternatives_0 ) ) ;
    public final void rule__LogicalOperator__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOcl.g:5895:1: ( ( ( rule__LogicalOperator__NameAlternatives_0 ) ) )
            // InternalOcl.g:5896:2: ( ( rule__LogicalOperator__NameAlternatives_0 ) )
            {
            // InternalOcl.g:5896:2: ( ( rule__LogicalOperator__NameAlternatives_0 ) )
            // InternalOcl.g:5897:3: ( rule__LogicalOperator__NameAlternatives_0 )
            {
             before(grammarAccess.getLogicalOperatorAccess().getNameAlternatives_0()); 
            // InternalOcl.g:5898:3: ( rule__LogicalOperator__NameAlternatives_0 )
            // InternalOcl.g:5898:4: rule__LogicalOperator__NameAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__LogicalOperator__NameAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getLogicalOperatorAccess().getNameAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalOperator__NameAssignment"

    // Delegated rules


    protected DFA32 dfa32 = new DFA32(this);
    static final String dfa_1s = "\170\uffff";
    static final String dfa_2s = "\1\4\1\5\27\142\16\122\1\uffff\1\4\1\uffff\1\5\1\4\2\7\2\10\1\5\27\142\16\122\2\123\2\134\1\123\1\5\1\4\2\7\2\10\2\5\1\7\1\10\1\5\2\123\2\134\3\123\2\5\1\7\1\10\3\5\2\123\2\5";
    static final String dfa_3s = "\1\143\1\141\27\142\16\122\1\uffff\1\143\1\uffff\1\141\1\4\2\7\2\10\1\141\27\142\16\122\2\123\2\134\1\123\1\141\1\4\2\7\2\10\2\141\1\7\1\10\1\141\2\123\2\134\3\123\2\141\1\7\1\10\3\141\2\123\2\141";
    static final String dfa_4s = "\47\uffff\1\2\1\uffff\1\1\116\uffff";
    static final String dfa_5s = "\170\uffff}>";
    static final String[] dfa_6s = {
            "\1\47\2\uffff\2\47\1\1\16\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\4\47\2\uffff\2\47\16\uffff\1\47\1\uffff\1\47\3\uffff\1\47\12\uffff\1\46",
            "\1\51\1\47\71\uffff\3\47\1\uffff\15\47\1\uffff\2\47\10\uffff\1\50\1\uffff\1\47\1\uffff\1\51\1\47",
            "\1\52",
            "\1\52",
            "\1\52",
            "\1\52",
            "\1\52",
            "\1\52",
            "\1\52",
            "\1\52",
            "\1\52",
            "\1\52",
            "\1\52",
            "\1\52",
            "\1\52",
            "\1\52",
            "\1\52",
            "\1\52",
            "\1\52",
            "\1\52",
            "\1\52",
            "\1\52",
            "\1\52",
            "\1\52",
            "\1\52",
            "\1\53",
            "\1\53",
            "\1\54",
            "\1\54",
            "\1\54",
            "\1\54",
            "\1\54",
            "\1\54",
            "\1\55",
            "\1\55",
            "\1\56",
            "\1\56",
            "\1\56",
            "\1\57",
            "",
            "\1\47\2\uffff\2\47\1\60\16\uffff\1\61\1\62\1\63\1\64\1\65\1\66\1\67\1\70\1\71\1\72\1\73\1\74\1\75\1\76\1\77\1\100\1\101\1\102\1\103\1\104\1\105\1\106\1\107\1\110\1\111\1\112\1\113\1\114\1\115\1\116\1\117\1\120\1\121\1\122\1\123\1\124\4\47\2\uffff\2\47\16\uffff\1\47\1\uffff\1\47\3\uffff\1\47\12\uffff\1\125",
            "",
            "\1\51\1\47\71\uffff\3\47\1\uffff\15\47\1\uffff\2\47\10\uffff\1\50\1\uffff\1\47\1\uffff\1\51\1\47",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\51\1\47\71\uffff\3\47\1\uffff\15\47\1\uffff\2\47\10\uffff\1\50\1\uffff\1\47\1\uffff\1\51\1\47",
            "\1\133",
            "\1\133",
            "\1\133",
            "\1\133",
            "\1\133",
            "\1\133",
            "\1\133",
            "\1\133",
            "\1\133",
            "\1\133",
            "\1\133",
            "\1\133",
            "\1\133",
            "\1\133",
            "\1\133",
            "\1\133",
            "\1\133",
            "\1\133",
            "\1\133",
            "\1\133",
            "\1\133",
            "\1\133",
            "\1\133",
            "\1\134",
            "\1\134",
            "\1\135",
            "\1\135",
            "\1\135",
            "\1\135",
            "\1\135",
            "\1\135",
            "\1\136",
            "\1\136",
            "\1\137",
            "\1\137",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\51\1\47\71\uffff\3\47\1\uffff\15\47\1\uffff\2\47\10\uffff\1\50\1\uffff\1\47\1\uffff\1\51\1\47",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\51\1\47\71\uffff\3\47\1\uffff\15\47\1\uffff\2\47\10\uffff\1\50\1\uffff\1\47\1\uffff\1\51\1\47",
            "\1\51\1\47\71\uffff\3\47\1\uffff\15\47\1\uffff\2\47\10\uffff\1\50\1\uffff\1\47\1\uffff\1\51\1\47",
            "\1\153",
            "\1\154",
            "\1\51\1\47\71\uffff\3\47\1\uffff\15\47\1\uffff\2\47\10\uffff\1\50\1\uffff\1\47\1\uffff\1\51\1\47",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\51\1\47\71\uffff\3\47\1\uffff\15\47\1\uffff\2\47\10\uffff\1\50\1\uffff\1\47\1\uffff\1\51\1\47",
            "\1\51\1\47\71\uffff\3\47\1\uffff\15\47\1\uffff\2\47\10\uffff\1\50\1\uffff\1\47\1\uffff\1\51\1\47",
            "\1\164",
            "\1\165",
            "\1\51\1\47\71\uffff\3\47\1\uffff\15\47\1\uffff\2\47\10\uffff\1\50\1\uffff\1\47\1\uffff\1\51\1\47",
            "\1\51\1\47\71\uffff\3\47\1\uffff\15\47\1\uffff\2\47\10\uffff\1\50\1\uffff\1\47\1\uffff\1\51\1\47",
            "\1\51\1\47\71\uffff\3\47\1\uffff\15\47\1\uffff\2\47\10\uffff\1\50\1\uffff\1\47\1\uffff\1\51\1\47",
            "\1\166",
            "\1\167",
            "\1\51\1\47\71\uffff\3\47\1\uffff\15\47\1\uffff\2\47\10\uffff\1\50\1\uffff\1\47\1\uffff\1\51\1\47",
            "\1\51\1\47\71\uffff\3\47\1\uffff\15\47\1\uffff\2\47\10\uffff\1\50\1\uffff\1\47\1\uffff\1\51\1\47"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "2849:2: ( rule__FeatureCallParameters__DecsAssignment_1 )?";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000002L,0x0000000010000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000E00000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0xFFFFFFFFFF000390L,0x000000080114000CL});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000000L,0x000000000001E000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000002L,0x000000000001E000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001F80L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000044L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000044L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000030L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000030L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000CL});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000003L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0FFFFFFFFF000210L,0x0000000800000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000000L,0x0000000000C00000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x0000000018000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0xF000000000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0xFFFFFFFFFF000390L,0x000000080914000CL});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000000L,0x0000000030000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000000L,0x0000000240040000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000020L,0x0000000110000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000010L,0x0000000002000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000100L});

}