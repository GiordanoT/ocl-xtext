package org.xtext.ocl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.ocl.services.OclGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalOclParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_TYPENAME_TERMINAL", "RULE_STRING", "RULE_NUMBER", "RULE_NAME_TERMINAL", "RULE_COLON", "RULE_DOUBLE_COLON", "RULE_LOWER", "RULE_UPPER", "RULE_LETTER", "RULE_DIGIT", "RULE_IDCHAR", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'context'", "'inv:'", "'pre:'", "'post:'", "'('", "')'", "'if'", "'then'", "'else'", "'endif'", "'#'", "'enum'", "'{'", "','", "'}'", "'..'", "'['", "']'", "'|'", "'@'", "'allInstaces'", "'oclType'", "'toString'", "'refImmediateComposite'", "'size'", "'toInteger'", "'toUpper'", "'toReal'", "'toLower'", "'toSequence'", "'trim'", "'isEmpty'", "'oclIsUndefined'", "'floor'", "'round'", "'notEmpty'", "'asBag'", "'asSequence'", "'sum'", "'asSet'", "'flatten'", "'first'", "'last'", "'()'", "'oclTypeOf'", "'oclisKindOf'", "'concat'", "'startsWith'", "'endsWith'", "'indexOf'", "'lastIndexOf'", "'split'", "'replaceAll'", "'regexReplaceAll'", "'at'", "'substring'", "'subSequence'", "'subOrderedSet'", "'Set'", "'Bag'", "'Sequence'", "'Collection'", "'.'", "'->'", "'-'", "'not'", "'*'", "'/'", "'+'", "'='", "'>'", "'<'", "'>='", "'<='", "'<>'", "'and'", "'or'", "'xor'", "'implies'"
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
    public static final int RULE_COLON=8;
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
    public static final int RULE_DOUBLE_COLON=9;
    public static final int RULE_NAME_TERMINAL=7;
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
    public static final int RULE_STRING=5;
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
    public static final int RULE_NUMBER=6;
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

        public InternalOclParser(TokenStream input, OclGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Start";
       	}

       	@Override
       	protected OclGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleStart"
    // InternalOcl.g:64:1: entryRuleStart returns [EObject current=null] : iv_ruleStart= ruleStart EOF ;
    public final EObject entryRuleStart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStart = null;


        try {
            // InternalOcl.g:64:46: (iv_ruleStart= ruleStart EOF )
            // InternalOcl.g:65:2: iv_ruleStart= ruleStart EOF
            {
             newCompositeNode(grammarAccess.getStartRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStart=ruleStart();

            state._fsp--;

             current =iv_ruleStart; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleStart"


    // $ANTLR start "ruleStart"
    // InternalOcl.g:71:1: ruleStart returns [EObject current=null] : ( (this_Expression_0= ruleExpression )? | this_ContextExpression_1= ruleContextExpression ) ;
    public final EObject ruleStart() throws RecognitionException {
        EObject current = null;

        EObject this_Expression_0 = null;

        EObject this_ContextExpression_1 = null;



        	enterRule();

        try {
            // InternalOcl.g:77:2: ( ( (this_Expression_0= ruleExpression )? | this_ContextExpression_1= ruleContextExpression ) )
            // InternalOcl.g:78:2: ( (this_Expression_0= ruleExpression )? | this_ContextExpression_1= ruleContextExpression )
            {
            // InternalOcl.g:78:2: ( (this_Expression_0= ruleExpression )? | this_ContextExpression_1= ruleContextExpression )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==EOF||(LA2_0>=RULE_TYPENAME_TERMINAL && LA2_0<=RULE_NAME_TERMINAL)||LA2_0==25||LA2_0==27||LA2_0==31||(LA2_0>=41 && LA2_0<=63)||(LA2_0>=65 && LA2_0<=82)||(LA2_0>=85 && LA2_0<=86)) ) {
                alt2=1;
            }
            else if ( (LA2_0==21) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalOcl.g:79:3: (this_Expression_0= ruleExpression )?
                    {
                    // InternalOcl.g:79:3: (this_Expression_0= ruleExpression )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( ((LA1_0>=RULE_TYPENAME_TERMINAL && LA1_0<=RULE_NAME_TERMINAL)||LA1_0==25||LA1_0==27||LA1_0==31||(LA1_0>=41 && LA1_0<=63)||(LA1_0>=65 && LA1_0<=82)||(LA1_0>=85 && LA1_0<=86)) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // InternalOcl.g:80:4: this_Expression_0= ruleExpression
                            {

                            				newCompositeNode(grammarAccess.getStartAccess().getExpressionParserRuleCall_0());
                            			
                            pushFollow(FOLLOW_2);
                            this_Expression_0=ruleExpression();

                            state._fsp--;


                            				current = this_Expression_0;
                            				afterParserOrEnumRuleCall();
                            			

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // InternalOcl.g:90:3: this_ContextExpression_1= ruleContextExpression
                    {

                    			newCompositeNode(grammarAccess.getStartAccess().getContextExpressionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ContextExpression_1=ruleContextExpression();

                    state._fsp--;


                    			current = this_ContextExpression_1;
                    			afterParserOrEnumRuleCall();
                    		

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
    // $ANTLR end "ruleStart"


    // $ANTLR start "entryRuleContextExpression"
    // InternalOcl.g:102:1: entryRuleContextExpression returns [EObject current=null] : iv_ruleContextExpression= ruleContextExpression EOF ;
    public final EObject entryRuleContextExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContextExpression = null;


        try {
            // InternalOcl.g:102:58: (iv_ruleContextExpression= ruleContextExpression EOF )
            // InternalOcl.g:103:2: iv_ruleContextExpression= ruleContextExpression EOF
            {
             newCompositeNode(grammarAccess.getContextExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContextExpression=ruleContextExpression();

            state._fsp--;

             current =iv_ruleContextExpression; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleContextExpression"


    // $ANTLR start "ruleContextExpression"
    // InternalOcl.g:109:1: ruleContextExpression returns [EObject current=null] : (otherlv_0= 'context' this_TYPENAME_TERMINAL_1= RULE_TYPENAME_TERMINAL (otherlv_2= 'inv:' | otherlv_3= 'pre:' | otherlv_4= 'post:' ) this_Expression_5= ruleExpression ) ;
    public final EObject ruleContextExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_TYPENAME_TERMINAL_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject this_Expression_5 = null;



        	enterRule();

        try {
            // InternalOcl.g:115:2: ( (otherlv_0= 'context' this_TYPENAME_TERMINAL_1= RULE_TYPENAME_TERMINAL (otherlv_2= 'inv:' | otherlv_3= 'pre:' | otherlv_4= 'post:' ) this_Expression_5= ruleExpression ) )
            // InternalOcl.g:116:2: (otherlv_0= 'context' this_TYPENAME_TERMINAL_1= RULE_TYPENAME_TERMINAL (otherlv_2= 'inv:' | otherlv_3= 'pre:' | otherlv_4= 'post:' ) this_Expression_5= ruleExpression )
            {
            // InternalOcl.g:116:2: (otherlv_0= 'context' this_TYPENAME_TERMINAL_1= RULE_TYPENAME_TERMINAL (otherlv_2= 'inv:' | otherlv_3= 'pre:' | otherlv_4= 'post:' ) this_Expression_5= ruleExpression )
            // InternalOcl.g:117:3: otherlv_0= 'context' this_TYPENAME_TERMINAL_1= RULE_TYPENAME_TERMINAL (otherlv_2= 'inv:' | otherlv_3= 'pre:' | otherlv_4= 'post:' ) this_Expression_5= ruleExpression
            {
            otherlv_0=(Token)match(input,21,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getContextExpressionAccess().getContextKeyword_0());
            		
            this_TYPENAME_TERMINAL_1=(Token)match(input,RULE_TYPENAME_TERMINAL,FOLLOW_4); 

            			newLeafNode(this_TYPENAME_TERMINAL_1, grammarAccess.getContextExpressionAccess().getTYPENAME_TERMINALTerminalRuleCall_1());
            		
            // InternalOcl.g:125:3: (otherlv_2= 'inv:' | otherlv_3= 'pre:' | otherlv_4= 'post:' )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt3=1;
                }
                break;
            case 23:
                {
                alt3=2;
                }
                break;
            case 24:
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
                    // InternalOcl.g:126:4: otherlv_2= 'inv:'
                    {
                    otherlv_2=(Token)match(input,22,FOLLOW_5); 

                    				newLeafNode(otherlv_2, grammarAccess.getContextExpressionAccess().getInvKeyword_2_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalOcl.g:131:4: otherlv_3= 'pre:'
                    {
                    otherlv_3=(Token)match(input,23,FOLLOW_5); 

                    				newLeafNode(otherlv_3, grammarAccess.getContextExpressionAccess().getPreKeyword_2_1());
                    			

                    }
                    break;
                case 3 :
                    // InternalOcl.g:136:4: otherlv_4= 'post:'
                    {
                    otherlv_4=(Token)match(input,24,FOLLOW_5); 

                    				newLeafNode(otherlv_4, grammarAccess.getContextExpressionAccess().getPostKeyword_2_2());
                    			

                    }
                    break;

            }


            			newCompositeNode(grammarAccess.getContextExpressionAccess().getExpressionParserRuleCall_3());
            		
            pushFollow(FOLLOW_2);
            this_Expression_5=ruleExpression();

            state._fsp--;


            			current = this_Expression_5;
            			afterParserOrEnumRuleCall();
            		

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
    // $ANTLR end "ruleContextExpression"


    // $ANTLR start "entryRuleExpression"
    // InternalOcl.g:153:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalOcl.g:153:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalOcl.g:154:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalOcl.g:160:1: ruleExpression returns [EObject current=null] : this_LogicalExpression_0= ruleLogicalExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalExpression_0 = null;



        	enterRule();

        try {
            // InternalOcl.g:166:2: (this_LogicalExpression_0= ruleLogicalExpression )
            // InternalOcl.g:167:2: this_LogicalExpression_0= ruleLogicalExpression
            {

            		newCompositeNode(grammarAccess.getExpressionAccess().getLogicalExpressionParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_LogicalExpression_0=ruleLogicalExpression();

            state._fsp--;


            		current = this_LogicalExpression_0;
            		afterParserOrEnumRuleCall();
            	

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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleLogicalExpression"
    // InternalOcl.g:178:1: entryRuleLogicalExpression returns [EObject current=null] : iv_ruleLogicalExpression= ruleLogicalExpression EOF ;
    public final EObject entryRuleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpression = null;


        try {
            // InternalOcl.g:178:58: (iv_ruleLogicalExpression= ruleLogicalExpression EOF )
            // InternalOcl.g:179:2: iv_ruleLogicalExpression= ruleLogicalExpression EOF
            {
             newCompositeNode(grammarAccess.getLogicalExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLogicalExpression=ruleLogicalExpression();

            state._fsp--;

             current =iv_ruleLogicalExpression; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleLogicalExpression"


    // $ANTLR start "ruleLogicalExpression"
    // InternalOcl.g:185:1: ruleLogicalExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( (lv_op_1_0= ruleLogicalOperator ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )* ) ;
    public final EObject ruleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_exp_0_0 = null;

        EObject lv_op_1_0 = null;

        EObject lv_exp_2_0 = null;



        	enterRule();

        try {
            // InternalOcl.g:191:2: ( ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( (lv_op_1_0= ruleLogicalOperator ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )* ) )
            // InternalOcl.g:192:2: ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( (lv_op_1_0= ruleLogicalOperator ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )* )
            {
            // InternalOcl.g:192:2: ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( (lv_op_1_0= ruleLogicalOperator ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )* )
            // InternalOcl.g:193:3: ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( (lv_op_1_0= ruleLogicalOperator ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )*
            {
            // InternalOcl.g:193:3: ( (lv_exp_0_0= ruleRelationalExpression ) )
            // InternalOcl.g:194:4: (lv_exp_0_0= ruleRelationalExpression )
            {
            // InternalOcl.g:194:4: (lv_exp_0_0= ruleRelationalExpression )
            // InternalOcl.g:195:5: lv_exp_0_0= ruleRelationalExpression
            {

            					newCompositeNode(grammarAccess.getLogicalExpressionAccess().getExpRelationalExpressionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_6);
            lv_exp_0_0=ruleRelationalExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLogicalExpressionRule());
            					}
            					add(
            						current,
            						"exp",
            						lv_exp_0_0,
            						"org.xtext.ocl.Ocl.RelationalExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOcl.g:212:3: ( ( (lv_op_1_0= ruleLogicalOperator ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=96 && LA4_0<=99)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalOcl.g:213:4: ( (lv_op_1_0= ruleLogicalOperator ) ) ( (lv_exp_2_0= ruleRelationalExpression ) )
            	    {
            	    // InternalOcl.g:213:4: ( (lv_op_1_0= ruleLogicalOperator ) )
            	    // InternalOcl.g:214:5: (lv_op_1_0= ruleLogicalOperator )
            	    {
            	    // InternalOcl.g:214:5: (lv_op_1_0= ruleLogicalOperator )
            	    // InternalOcl.g:215:6: lv_op_1_0= ruleLogicalOperator
            	    {

            	    						newCompositeNode(grammarAccess.getLogicalExpressionAccess().getOpLogicalOperatorParserRuleCall_1_0_0());
            	    					
            	    pushFollow(FOLLOW_5);
            	    lv_op_1_0=ruleLogicalOperator();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getLogicalExpressionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"op",
            	    							lv_op_1_0,
            	    							"org.xtext.ocl.Ocl.LogicalOperator");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    // InternalOcl.g:232:4: ( (lv_exp_2_0= ruleRelationalExpression ) )
            	    // InternalOcl.g:233:5: (lv_exp_2_0= ruleRelationalExpression )
            	    {
            	    // InternalOcl.g:233:5: (lv_exp_2_0= ruleRelationalExpression )
            	    // InternalOcl.g:234:6: lv_exp_2_0= ruleRelationalExpression
            	    {

            	    						newCompositeNode(grammarAccess.getLogicalExpressionAccess().getExpRelationalExpressionParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_6);
            	    lv_exp_2_0=ruleRelationalExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getLogicalExpressionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"exp",
            	    							lv_exp_2_0,
            	    							"org.xtext.ocl.Ocl.RelationalExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
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
    // $ANTLR end "ruleLogicalExpression"


    // $ANTLR start "entryRuleRelationalExpression"
    // InternalOcl.g:256:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // InternalOcl.g:256:61: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // InternalOcl.g:257:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
             newCompositeNode(grammarAccess.getRelationalExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRelationalExpression=ruleRelationalExpression();

            state._fsp--;

             current =iv_ruleRelationalExpression; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleRelationalExpression"


    // $ANTLR start "ruleRelationalExpression"
    // InternalOcl.g:263:1: ruleRelationalExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= ruleRelationalOperator ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) )? ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_exp_0_0 = null;

        EObject lv_op_1_0 = null;

        EObject lv_exp_2_0 = null;



        	enterRule();

        try {
            // InternalOcl.g:269:2: ( ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= ruleRelationalOperator ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) )? ) )
            // InternalOcl.g:270:2: ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= ruleRelationalOperator ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) )? )
            {
            // InternalOcl.g:270:2: ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= ruleRelationalOperator ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) )? )
            // InternalOcl.g:271:3: ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= ruleRelationalOperator ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) )?
            {
            // InternalOcl.g:271:3: ( (lv_exp_0_0= ruleAdditiveExpression ) )
            // InternalOcl.g:272:4: (lv_exp_0_0= ruleAdditiveExpression )
            {
            // InternalOcl.g:272:4: (lv_exp_0_0= ruleAdditiveExpression )
            // InternalOcl.g:273:5: lv_exp_0_0= ruleAdditiveExpression
            {

            					newCompositeNode(grammarAccess.getRelationalExpressionAccess().getExpAdditiveExpressionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_7);
            lv_exp_0_0=ruleAdditiveExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
            					}
            					add(
            						current,
            						"exp",
            						lv_exp_0_0,
            						"org.xtext.ocl.Ocl.AdditiveExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOcl.g:290:3: ( ( (lv_op_1_0= ruleRelationalOperator ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=90 && LA5_0<=95)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalOcl.g:291:4: ( (lv_op_1_0= ruleRelationalOperator ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) )
                    {
                    // InternalOcl.g:291:4: ( (lv_op_1_0= ruleRelationalOperator ) )
                    // InternalOcl.g:292:5: (lv_op_1_0= ruleRelationalOperator )
                    {
                    // InternalOcl.g:292:5: (lv_op_1_0= ruleRelationalOperator )
                    // InternalOcl.g:293:6: lv_op_1_0= ruleRelationalOperator
                    {

                    						newCompositeNode(grammarAccess.getRelationalExpressionAccess().getOpRelationalOperatorParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_5);
                    lv_op_1_0=ruleRelationalOperator();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
                    						}
                    						add(
                    							current,
                    							"op",
                    							lv_op_1_0,
                    							"org.xtext.ocl.Ocl.RelationalOperator");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalOcl.g:310:4: ( (lv_exp_2_0= ruleAdditiveExpression ) )
                    // InternalOcl.g:311:5: (lv_exp_2_0= ruleAdditiveExpression )
                    {
                    // InternalOcl.g:311:5: (lv_exp_2_0= ruleAdditiveExpression )
                    // InternalOcl.g:312:6: lv_exp_2_0= ruleAdditiveExpression
                    {

                    						newCompositeNode(grammarAccess.getRelationalExpressionAccess().getExpAdditiveExpressionParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_exp_2_0=ruleAdditiveExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
                    						}
                    						add(
                    							current,
                    							"exp",
                    							lv_exp_2_0,
                    							"org.xtext.ocl.Ocl.AdditiveExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleRelationalExpression"


    // $ANTLR start "entryRuleAdditiveExpression"
    // InternalOcl.g:334:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalOcl.g:334:59: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalOcl.g:335:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
             newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();

            state._fsp--;

             current =iv_ruleAdditiveExpression; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleAdditiveExpression"


    // $ANTLR start "ruleAdditiveExpression"
    // InternalOcl.g:341:1: ruleAdditiveExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( (lv_op_1_0= ruleAddOperator ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_exp_0_0 = null;

        EObject lv_op_1_0 = null;

        EObject lv_exp_2_0 = null;



        	enterRule();

        try {
            // InternalOcl.g:347:2: ( ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( (lv_op_1_0= ruleAddOperator ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* ) )
            // InternalOcl.g:348:2: ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( (lv_op_1_0= ruleAddOperator ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* )
            {
            // InternalOcl.g:348:2: ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( (lv_op_1_0= ruleAddOperator ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* )
            // InternalOcl.g:349:3: ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( (lv_op_1_0= ruleAddOperator ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )*
            {
            // InternalOcl.g:349:3: ( (lv_exp_0_0= ruleMultiplicativeExpression ) )
            // InternalOcl.g:350:4: (lv_exp_0_0= ruleMultiplicativeExpression )
            {
            // InternalOcl.g:350:4: (lv_exp_0_0= ruleMultiplicativeExpression )
            // InternalOcl.g:351:5: lv_exp_0_0= ruleMultiplicativeExpression
            {

            					newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExpMultiplicativeExpressionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_8);
            lv_exp_0_0=ruleMultiplicativeExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            					}
            					add(
            						current,
            						"exp",
            						lv_exp_0_0,
            						"org.xtext.ocl.Ocl.MultiplicativeExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOcl.g:368:3: ( ( (lv_op_1_0= ruleAddOperator ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==85||LA6_0==89) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalOcl.g:369:4: ( (lv_op_1_0= ruleAddOperator ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) )
            	    {
            	    // InternalOcl.g:369:4: ( (lv_op_1_0= ruleAddOperator ) )
            	    // InternalOcl.g:370:5: (lv_op_1_0= ruleAddOperator )
            	    {
            	    // InternalOcl.g:370:5: (lv_op_1_0= ruleAddOperator )
            	    // InternalOcl.g:371:6: lv_op_1_0= ruleAddOperator
            	    {

            	    						newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getOpAddOperatorParserRuleCall_1_0_0());
            	    					
            	    pushFollow(FOLLOW_5);
            	    lv_op_1_0=ruleAddOperator();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"op",
            	    							lv_op_1_0,
            	    							"org.xtext.ocl.Ocl.AddOperator");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    // InternalOcl.g:388:4: ( (lv_exp_2_0= ruleMultiplicativeExpression ) )
            	    // InternalOcl.g:389:5: (lv_exp_2_0= ruleMultiplicativeExpression )
            	    {
            	    // InternalOcl.g:389:5: (lv_exp_2_0= ruleMultiplicativeExpression )
            	    // InternalOcl.g:390:6: lv_exp_2_0= ruleMultiplicativeExpression
            	    {

            	    						newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExpMultiplicativeExpressionParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_8);
            	    lv_exp_2_0=ruleMultiplicativeExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"exp",
            	    							lv_exp_2_0,
            	    							"org.xtext.ocl.Ocl.MultiplicativeExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
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
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleMultiplicativeExpression"
    // InternalOcl.g:412:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalOcl.g:412:65: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalOcl.g:413:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
             newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();

            state._fsp--;

             current =iv_ruleMultiplicativeExpression; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleMultiplicativeExpression"


    // $ANTLR start "ruleMultiplicativeExpression"
    // InternalOcl.g:419:1: ruleMultiplicativeExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( (lv_op_1_0= ruleMultiplyOperator ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_exp_0_0 = null;

        EObject lv_op_1_0 = null;

        EObject lv_exp_2_0 = null;



        	enterRule();

        try {
            // InternalOcl.g:425:2: ( ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( (lv_op_1_0= ruleMultiplyOperator ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* ) )
            // InternalOcl.g:426:2: ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( (lv_op_1_0= ruleMultiplyOperator ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* )
            {
            // InternalOcl.g:426:2: ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( (lv_op_1_0= ruleMultiplyOperator ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* )
            // InternalOcl.g:427:3: ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( (lv_op_1_0= ruleMultiplyOperator ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )*
            {
            // InternalOcl.g:427:3: ( (lv_exp_0_0= ruleUnaryExpression ) )
            // InternalOcl.g:428:4: (lv_exp_0_0= ruleUnaryExpression )
            {
            // InternalOcl.g:428:4: (lv_exp_0_0= ruleUnaryExpression )
            // InternalOcl.g:429:5: lv_exp_0_0= ruleUnaryExpression
            {

            					newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExpUnaryExpressionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_9);
            lv_exp_0_0=ruleUnaryExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
            					}
            					add(
            						current,
            						"exp",
            						lv_exp_0_0,
            						"org.xtext.ocl.Ocl.UnaryExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOcl.g:446:3: ( ( (lv_op_1_0= ruleMultiplyOperator ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=87 && LA7_0<=88)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalOcl.g:447:4: ( (lv_op_1_0= ruleMultiplyOperator ) ) ( (lv_exp_2_0= ruleUnaryExpression ) )
            	    {
            	    // InternalOcl.g:447:4: ( (lv_op_1_0= ruleMultiplyOperator ) )
            	    // InternalOcl.g:448:5: (lv_op_1_0= ruleMultiplyOperator )
            	    {
            	    // InternalOcl.g:448:5: (lv_op_1_0= ruleMultiplyOperator )
            	    // InternalOcl.g:449:6: lv_op_1_0= ruleMultiplyOperator
            	    {

            	    						newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOpMultiplyOperatorParserRuleCall_1_0_0());
            	    					
            	    pushFollow(FOLLOW_5);
            	    lv_op_1_0=ruleMultiplyOperator();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"op",
            	    							lv_op_1_0,
            	    							"org.xtext.ocl.Ocl.MultiplyOperator");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    // InternalOcl.g:466:4: ( (lv_exp_2_0= ruleUnaryExpression ) )
            	    // InternalOcl.g:467:5: (lv_exp_2_0= ruleUnaryExpression )
            	    {
            	    // InternalOcl.g:467:5: (lv_exp_2_0= ruleUnaryExpression )
            	    // InternalOcl.g:468:6: lv_exp_2_0= ruleUnaryExpression
            	    {

            	    						newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExpUnaryExpressionParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_9);
            	    lv_exp_2_0=ruleUnaryExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"exp",
            	    							lv_exp_2_0,
            	    							"org.xtext.ocl.Ocl.UnaryExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
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
    // $ANTLR end "ruleMultiplicativeExpression"


    // $ANTLR start "entryRuleUnaryExpression"
    // InternalOcl.g:490:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalOcl.g:490:56: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalOcl.g:491:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
             newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;

             current =iv_ruleUnaryExpression; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleUnaryExpression"


    // $ANTLR start "ruleUnaryExpression"
    // InternalOcl.g:497:1: ruleUnaryExpression returns [EObject current=null] : ( ( (lv_op_0_0= ruleUnaryOperator ) )* ( (lv_exp_1_0= rulePostfixExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_op_0_0 = null;

        EObject lv_exp_1_0 = null;



        	enterRule();

        try {
            // InternalOcl.g:503:2: ( ( ( (lv_op_0_0= ruleUnaryOperator ) )* ( (lv_exp_1_0= rulePostfixExpression ) ) ) )
            // InternalOcl.g:504:2: ( ( (lv_op_0_0= ruleUnaryOperator ) )* ( (lv_exp_1_0= rulePostfixExpression ) ) )
            {
            // InternalOcl.g:504:2: ( ( (lv_op_0_0= ruleUnaryOperator ) )* ( (lv_exp_1_0= rulePostfixExpression ) ) )
            // InternalOcl.g:505:3: ( (lv_op_0_0= ruleUnaryOperator ) )* ( (lv_exp_1_0= rulePostfixExpression ) )
            {
            // InternalOcl.g:505:3: ( (lv_op_0_0= ruleUnaryOperator ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=85 && LA8_0<=86)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalOcl.g:506:4: (lv_op_0_0= ruleUnaryOperator )
            	    {
            	    // InternalOcl.g:506:4: (lv_op_0_0= ruleUnaryOperator )
            	    // InternalOcl.g:507:5: lv_op_0_0= ruleUnaryOperator
            	    {

            	    					newCompositeNode(grammarAccess.getUnaryExpressionAccess().getOpUnaryOperatorParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_op_0_0=ruleUnaryOperator();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"op",
            	    						lv_op_0_0,
            	    						"org.xtext.ocl.Ocl.UnaryOperator");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // InternalOcl.g:524:3: ( (lv_exp_1_0= rulePostfixExpression ) )
            // InternalOcl.g:525:4: (lv_exp_1_0= rulePostfixExpression )
            {
            // InternalOcl.g:525:4: (lv_exp_1_0= rulePostfixExpression )
            // InternalOcl.g:526:5: lv_exp_1_0= rulePostfixExpression
            {

            					newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExpPostfixExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_exp_1_0=rulePostfixExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
            					}
            					set(
            						current,
            						"exp",
            						lv_exp_1_0,
            						"org.xtext.ocl.Ocl.PostfixExpression");
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
    // $ANTLR end "ruleUnaryExpression"


    // $ANTLR start "entryRulePostfixExpression"
    // InternalOcl.g:547:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // InternalOcl.g:547:58: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // InternalOcl.g:548:2: iv_rulePostfixExpression= rulePostfixExpression EOF
            {
             newCompositeNode(grammarAccess.getPostfixExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePostfixExpression=rulePostfixExpression();

            state._fsp--;

             current =iv_rulePostfixExpression; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRulePostfixExpression"


    // $ANTLR start "rulePostfixExpression"
    // InternalOcl.g:554:1: rulePostfixExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( ( (lv_op_1_0= ruleNavigationOperator ) ) ( (lv_features_2_0= ruleFeatureCall ) ) )* ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpression_0 = null;

        EObject lv_op_1_0 = null;

        EObject lv_features_2_0 = null;



        	enterRule();

        try {
            // InternalOcl.g:560:2: ( (this_PrimaryExpression_0= rulePrimaryExpression ( ( (lv_op_1_0= ruleNavigationOperator ) ) ( (lv_features_2_0= ruleFeatureCall ) ) )* ) )
            // InternalOcl.g:561:2: (this_PrimaryExpression_0= rulePrimaryExpression ( ( (lv_op_1_0= ruleNavigationOperator ) ) ( (lv_features_2_0= ruleFeatureCall ) ) )* )
            {
            // InternalOcl.g:561:2: (this_PrimaryExpression_0= rulePrimaryExpression ( ( (lv_op_1_0= ruleNavigationOperator ) ) ( (lv_features_2_0= ruleFeatureCall ) ) )* )
            // InternalOcl.g:562:3: this_PrimaryExpression_0= rulePrimaryExpression ( ( (lv_op_1_0= ruleNavigationOperator ) ) ( (lv_features_2_0= ruleFeatureCall ) ) )*
            {

            			newCompositeNode(grammarAccess.getPostfixExpressionAccess().getPrimaryExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_10);
            this_PrimaryExpression_0=rulePrimaryExpression();

            state._fsp--;


            			current = this_PrimaryExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalOcl.g:570:3: ( ( (lv_op_1_0= ruleNavigationOperator ) ) ( (lv_features_2_0= ruleFeatureCall ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=83 && LA9_0<=84)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalOcl.g:571:4: ( (lv_op_1_0= ruleNavigationOperator ) ) ( (lv_features_2_0= ruleFeatureCall ) )
            	    {
            	    // InternalOcl.g:571:4: ( (lv_op_1_0= ruleNavigationOperator ) )
            	    // InternalOcl.g:572:5: (lv_op_1_0= ruleNavigationOperator )
            	    {
            	    // InternalOcl.g:572:5: (lv_op_1_0= ruleNavigationOperator )
            	    // InternalOcl.g:573:6: lv_op_1_0= ruleNavigationOperator
            	    {

            	    						newCompositeNode(grammarAccess.getPostfixExpressionAccess().getOpNavigationOperatorParserRuleCall_1_0_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_op_1_0=ruleNavigationOperator();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPostfixExpressionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"op",
            	    							lv_op_1_0,
            	    							"org.xtext.ocl.Ocl.NavigationOperator");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    // InternalOcl.g:590:4: ( (lv_features_2_0= ruleFeatureCall ) )
            	    // InternalOcl.g:591:5: (lv_features_2_0= ruleFeatureCall )
            	    {
            	    // InternalOcl.g:591:5: (lv_features_2_0= ruleFeatureCall )
            	    // InternalOcl.g:592:6: lv_features_2_0= ruleFeatureCall
            	    {

            	    						newCompositeNode(grammarAccess.getPostfixExpressionAccess().getFeaturesFeatureCallParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_10);
            	    lv_features_2_0=ruleFeatureCall();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPostfixExpressionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"features",
            	    							lv_features_2_0,
            	    							"org.xtext.ocl.Ocl.FeatureCall");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
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
    // $ANTLR end "rulePostfixExpression"


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalOcl.g:614:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalOcl.g:614:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalOcl.g:615:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // InternalOcl.g:621:1: rulePrimaryExpression returns [EObject current=null] : (this_LiteralCollection_0= ruleLiteralCollection | this_Literal_1= ruleLiteral | this_FeatureCall_2= ruleFeatureCall | (otherlv_3= '(' this_Expression_4= ruleExpression otherlv_5= ')' ) | this_IfExpression_6= ruleIfExpression ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject this_LiteralCollection_0 = null;

        EObject this_Literal_1 = null;

        EObject this_FeatureCall_2 = null;

        EObject this_Expression_4 = null;

        EObject this_IfExpression_6 = null;



        	enterRule();

        try {
            // InternalOcl.g:627:2: ( (this_LiteralCollection_0= ruleLiteralCollection | this_Literal_1= ruleLiteral | this_FeatureCall_2= ruleFeatureCall | (otherlv_3= '(' this_Expression_4= ruleExpression otherlv_5= ')' ) | this_IfExpression_6= ruleIfExpression ) )
            // InternalOcl.g:628:2: (this_LiteralCollection_0= ruleLiteralCollection | this_Literal_1= ruleLiteral | this_FeatureCall_2= ruleFeatureCall | (otherlv_3= '(' this_Expression_4= ruleExpression otherlv_5= ')' ) | this_IfExpression_6= ruleIfExpression )
            {
            // InternalOcl.g:628:2: (this_LiteralCollection_0= ruleLiteralCollection | this_Literal_1= ruleLiteral | this_FeatureCall_2= ruleFeatureCall | (otherlv_3= '(' this_Expression_4= ruleExpression otherlv_5= ')' ) | this_IfExpression_6= ruleIfExpression )
            int alt10=5;
            switch ( input.LA(1) ) {
            case 79:
            case 80:
            case 81:
            case 82:
                {
                alt10=1;
                }
                break;
            case RULE_STRING:
            case RULE_NUMBER:
            case 31:
                {
                alt10=2;
                }
                break;
            case RULE_TYPENAME_TERMINAL:
            case RULE_NAME_TERMINAL:
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
            case 60:
            case 61:
            case 62:
            case 63:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
                {
                alt10=3;
                }
                break;
            case 25:
                {
                alt10=4;
                }
                break;
            case 27:
                {
                alt10=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalOcl.g:629:3: this_LiteralCollection_0= ruleLiteralCollection
                    {

                    			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLiteralCollectionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_LiteralCollection_0=ruleLiteralCollection();

                    state._fsp--;


                    			current = this_LiteralCollection_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOcl.g:638:3: this_Literal_1= ruleLiteral
                    {

                    			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLiteralParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Literal_1=ruleLiteral();

                    state._fsp--;


                    			current = this_Literal_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalOcl.g:647:3: this_FeatureCall_2= ruleFeatureCall
                    {

                    			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getFeatureCallParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_FeatureCall_2=ruleFeatureCall();

                    state._fsp--;


                    			current = this_FeatureCall_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalOcl.g:656:3: (otherlv_3= '(' this_Expression_4= ruleExpression otherlv_5= ')' )
                    {
                    // InternalOcl.g:656:3: (otherlv_3= '(' this_Expression_4= ruleExpression otherlv_5= ')' )
                    // InternalOcl.g:657:4: otherlv_3= '(' this_Expression_4= ruleExpression otherlv_5= ')'
                    {
                    otherlv_3=(Token)match(input,25,FOLLOW_5); 

                    				newLeafNode(otherlv_3, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_3_0());
                    			

                    				newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_3_1());
                    			
                    pushFollow(FOLLOW_12);
                    this_Expression_4=ruleExpression();

                    state._fsp--;


                    				current = this_Expression_4;
                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_5=(Token)match(input,26,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_3_2());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalOcl.g:675:3: this_IfExpression_6= ruleIfExpression
                    {

                    			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getIfExpressionParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_IfExpression_6=ruleIfExpression();

                    state._fsp--;


                    			current = this_IfExpression_6;
                    			afterParserOrEnumRuleCall();
                    		

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
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleIfExpression"
    // InternalOcl.g:687:1: entryRuleIfExpression returns [EObject current=null] : iv_ruleIfExpression= ruleIfExpression EOF ;
    public final EObject entryRuleIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpression = null;


        try {
            // InternalOcl.g:687:53: (iv_ruleIfExpression= ruleIfExpression EOF )
            // InternalOcl.g:688:2: iv_ruleIfExpression= ruleIfExpression EOF
            {
             newCompositeNode(grammarAccess.getIfExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIfExpression=ruleIfExpression();

            state._fsp--;

             current =iv_ruleIfExpression; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleIfExpression"


    // $ANTLR start "ruleIfExpression"
    // InternalOcl.g:694:1: ruleIfExpression returns [EObject current=null] : (otherlv_0= 'if' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_exp_3_0= ruleExpression ) ) (otherlv_4= 'else' ( (lv_exp_5_0= ruleExpression ) ) )? otherlv_6= 'endif' ) ;
    public final EObject ruleIfExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_exp_1_0 = null;

        EObject lv_exp_3_0 = null;

        EObject lv_exp_5_0 = null;



        	enterRule();

        try {
            // InternalOcl.g:700:2: ( (otherlv_0= 'if' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_exp_3_0= ruleExpression ) ) (otherlv_4= 'else' ( (lv_exp_5_0= ruleExpression ) ) )? otherlv_6= 'endif' ) )
            // InternalOcl.g:701:2: (otherlv_0= 'if' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_exp_3_0= ruleExpression ) ) (otherlv_4= 'else' ( (lv_exp_5_0= ruleExpression ) ) )? otherlv_6= 'endif' )
            {
            // InternalOcl.g:701:2: (otherlv_0= 'if' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_exp_3_0= ruleExpression ) ) (otherlv_4= 'else' ( (lv_exp_5_0= ruleExpression ) ) )? otherlv_6= 'endif' )
            // InternalOcl.g:702:3: otherlv_0= 'if' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_exp_3_0= ruleExpression ) ) (otherlv_4= 'else' ( (lv_exp_5_0= ruleExpression ) ) )? otherlv_6= 'endif'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getIfExpressionAccess().getIfKeyword_0());
            		
            // InternalOcl.g:706:3: ( (lv_exp_1_0= ruleExpression ) )
            // InternalOcl.g:707:4: (lv_exp_1_0= ruleExpression )
            {
            // InternalOcl.g:707:4: (lv_exp_1_0= ruleExpression )
            // InternalOcl.g:708:5: lv_exp_1_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getIfExpressionAccess().getExpExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_13);
            lv_exp_1_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIfExpressionRule());
            					}
            					add(
            						current,
            						"exp",
            						lv_exp_1_0,
            						"org.xtext.ocl.Ocl.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,28,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getIfExpressionAccess().getThenKeyword_2());
            		
            // InternalOcl.g:729:3: ( (lv_exp_3_0= ruleExpression ) )
            // InternalOcl.g:730:4: (lv_exp_3_0= ruleExpression )
            {
            // InternalOcl.g:730:4: (lv_exp_3_0= ruleExpression )
            // InternalOcl.g:731:5: lv_exp_3_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getIfExpressionAccess().getExpExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_14);
            lv_exp_3_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIfExpressionRule());
            					}
            					add(
            						current,
            						"exp",
            						lv_exp_3_0,
            						"org.xtext.ocl.Ocl.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOcl.g:748:3: (otherlv_4= 'else' ( (lv_exp_5_0= ruleExpression ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==29) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalOcl.g:749:4: otherlv_4= 'else' ( (lv_exp_5_0= ruleExpression ) )
                    {
                    otherlv_4=(Token)match(input,29,FOLLOW_5); 

                    				newLeafNode(otherlv_4, grammarAccess.getIfExpressionAccess().getElseKeyword_4_0());
                    			
                    // InternalOcl.g:753:4: ( (lv_exp_5_0= ruleExpression ) )
                    // InternalOcl.g:754:5: (lv_exp_5_0= ruleExpression )
                    {
                    // InternalOcl.g:754:5: (lv_exp_5_0= ruleExpression )
                    // InternalOcl.g:755:6: lv_exp_5_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getIfExpressionAccess().getExpExpressionParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_15);
                    lv_exp_5_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIfExpressionRule());
                    						}
                    						add(
                    							current,
                    							"exp",
                    							lv_exp_5_0,
                    							"org.xtext.ocl.Ocl.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,30,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getIfExpressionAccess().getEndifKeyword_5());
            		

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
    // $ANTLR end "ruleIfExpression"


    // $ANTLR start "entryRuleFeatureCallParameters"
    // InternalOcl.g:781:1: entryRuleFeatureCallParameters returns [EObject current=null] : iv_ruleFeatureCallParameters= ruleFeatureCallParameters EOF ;
    public final EObject entryRuleFeatureCallParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureCallParameters = null;


        try {
            // InternalOcl.g:781:62: (iv_ruleFeatureCallParameters= ruleFeatureCallParameters EOF )
            // InternalOcl.g:782:2: iv_ruleFeatureCallParameters= ruleFeatureCallParameters EOF
            {
             newCompositeNode(grammarAccess.getFeatureCallParametersRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFeatureCallParameters=ruleFeatureCallParameters();

            state._fsp--;

             current =iv_ruleFeatureCallParameters; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleFeatureCallParameters"


    // $ANTLR start "ruleFeatureCallParameters"
    // InternalOcl.g:788:1: ruleFeatureCallParameters returns [EObject current=null] : (otherlv_0= '(' ( (lv_decs_1_0= ruleDeclarator ) )? ( (lv_params_2_0= ruleActualParameterList ) ) otherlv_3= ')' ) ;
    public final EObject ruleFeatureCallParameters() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject lv_decs_1_0 = null;

        EObject lv_params_2_0 = null;



        	enterRule();

        try {
            // InternalOcl.g:794:2: ( (otherlv_0= '(' ( (lv_decs_1_0= ruleDeclarator ) )? ( (lv_params_2_0= ruleActualParameterList ) ) otherlv_3= ')' ) )
            // InternalOcl.g:795:2: (otherlv_0= '(' ( (lv_decs_1_0= ruleDeclarator ) )? ( (lv_params_2_0= ruleActualParameterList ) ) otherlv_3= ')' )
            {
            // InternalOcl.g:795:2: (otherlv_0= '(' ( (lv_decs_1_0= ruleDeclarator ) )? ( (lv_params_2_0= ruleActualParameterList ) ) otherlv_3= ')' )
            // InternalOcl.g:796:3: otherlv_0= '(' ( (lv_decs_1_0= ruleDeclarator ) )? ( (lv_params_2_0= ruleActualParameterList ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getFeatureCallParametersAccess().getLeftParenthesisKeyword_0());
            		
            // InternalOcl.g:800:3: ( (lv_decs_1_0= ruleDeclarator ) )?
            int alt12=2;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // InternalOcl.g:801:4: (lv_decs_1_0= ruleDeclarator )
                    {
                    // InternalOcl.g:801:4: (lv_decs_1_0= ruleDeclarator )
                    // InternalOcl.g:802:5: lv_decs_1_0= ruleDeclarator
                    {

                    					newCompositeNode(grammarAccess.getFeatureCallParametersAccess().getDecsDeclaratorParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_5);
                    lv_decs_1_0=ruleDeclarator();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getFeatureCallParametersRule());
                    					}
                    					set(
                    						current,
                    						"decs",
                    						lv_decs_1_0,
                    						"org.xtext.ocl.Ocl.Declarator");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalOcl.g:819:3: ( (lv_params_2_0= ruleActualParameterList ) )
            // InternalOcl.g:820:4: (lv_params_2_0= ruleActualParameterList )
            {
            // InternalOcl.g:820:4: (lv_params_2_0= ruleActualParameterList )
            // InternalOcl.g:821:5: lv_params_2_0= ruleActualParameterList
            {

            					newCompositeNode(grammarAccess.getFeatureCallParametersAccess().getParamsActualParameterListParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_12);
            lv_params_2_0=ruleActualParameterList();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFeatureCallParametersRule());
            					}
            					set(
            						current,
            						"params",
            						lv_params_2_0,
            						"org.xtext.ocl.Ocl.ActualParameterList");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getFeatureCallParametersAccess().getRightParenthesisKeyword_3());
            		

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
    // $ANTLR end "ruleFeatureCallParameters"


    // $ANTLR start "entryRuleLiteral"
    // InternalOcl.g:846:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // InternalOcl.g:846:48: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalOcl.g:847:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // InternalOcl.g:853:1: ruleLiteral returns [EObject current=null] : ( ( (lv_name_0_0= RULE_STRING ) ) | ( (lv_name_1_0= RULE_NUMBER ) ) | (otherlv_2= '#' ( (lv_name_3_0= RULE_NAME_TERMINAL ) ) ) ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;


        	enterRule();

        try {
            // InternalOcl.g:859:2: ( ( ( (lv_name_0_0= RULE_STRING ) ) | ( (lv_name_1_0= RULE_NUMBER ) ) | (otherlv_2= '#' ( (lv_name_3_0= RULE_NAME_TERMINAL ) ) ) ) )
            // InternalOcl.g:860:2: ( ( (lv_name_0_0= RULE_STRING ) ) | ( (lv_name_1_0= RULE_NUMBER ) ) | (otherlv_2= '#' ( (lv_name_3_0= RULE_NAME_TERMINAL ) ) ) )
            {
            // InternalOcl.g:860:2: ( ( (lv_name_0_0= RULE_STRING ) ) | ( (lv_name_1_0= RULE_NUMBER ) ) | (otherlv_2= '#' ( (lv_name_3_0= RULE_NAME_TERMINAL ) ) ) )
            int alt13=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt13=1;
                }
                break;
            case RULE_NUMBER:
                {
                alt13=2;
                }
                break;
            case 31:
                {
                alt13=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalOcl.g:861:3: ( (lv_name_0_0= RULE_STRING ) )
                    {
                    // InternalOcl.g:861:3: ( (lv_name_0_0= RULE_STRING ) )
                    // InternalOcl.g:862:4: (lv_name_0_0= RULE_STRING )
                    {
                    // InternalOcl.g:862:4: (lv_name_0_0= RULE_STRING )
                    // InternalOcl.g:863:5: lv_name_0_0= RULE_STRING
                    {
                    lv_name_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    					newLeafNode(lv_name_0_0, grammarAccess.getLiteralAccess().getNameSTRINGTerminalRuleCall_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getLiteralRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"name",
                    						lv_name_0_0,
                    						"org.eclipse.xtext.common.Terminals.STRING");
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalOcl.g:880:3: ( (lv_name_1_0= RULE_NUMBER ) )
                    {
                    // InternalOcl.g:880:3: ( (lv_name_1_0= RULE_NUMBER ) )
                    // InternalOcl.g:881:4: (lv_name_1_0= RULE_NUMBER )
                    {
                    // InternalOcl.g:881:4: (lv_name_1_0= RULE_NUMBER )
                    // InternalOcl.g:882:5: lv_name_1_0= RULE_NUMBER
                    {
                    lv_name_1_0=(Token)match(input,RULE_NUMBER,FOLLOW_2); 

                    					newLeafNode(lv_name_1_0, grammarAccess.getLiteralAccess().getNameNUMBERTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getLiteralRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"name",
                    						lv_name_1_0,
                    						"org.xtext.ocl.Ocl.NUMBER");
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalOcl.g:899:3: (otherlv_2= '#' ( (lv_name_3_0= RULE_NAME_TERMINAL ) ) )
                    {
                    // InternalOcl.g:899:3: (otherlv_2= '#' ( (lv_name_3_0= RULE_NAME_TERMINAL ) ) )
                    // InternalOcl.g:900:4: otherlv_2= '#' ( (lv_name_3_0= RULE_NAME_TERMINAL ) )
                    {
                    otherlv_2=(Token)match(input,31,FOLLOW_16); 

                    				newLeafNode(otherlv_2, grammarAccess.getLiteralAccess().getNumberSignKeyword_2_0());
                    			
                    // InternalOcl.g:904:4: ( (lv_name_3_0= RULE_NAME_TERMINAL ) )
                    // InternalOcl.g:905:5: (lv_name_3_0= RULE_NAME_TERMINAL )
                    {
                    // InternalOcl.g:905:5: (lv_name_3_0= RULE_NAME_TERMINAL )
                    // InternalOcl.g:906:6: lv_name_3_0= RULE_NAME_TERMINAL
                    {
                    lv_name_3_0=(Token)match(input,RULE_NAME_TERMINAL,FOLLOW_2); 

                    						newLeafNode(lv_name_3_0, grammarAccess.getLiteralAccess().getNameNAME_TERMINALTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLiteralRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_3_0,
                    							"org.xtext.ocl.Ocl.NAME_TERMINAL");
                    					

                    }


                    }


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
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleEnumerationType"
    // InternalOcl.g:927:1: entryRuleEnumerationType returns [EObject current=null] : iv_ruleEnumerationType= ruleEnumerationType EOF ;
    public final EObject entryRuleEnumerationType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationType = null;


        try {
            // InternalOcl.g:927:56: (iv_ruleEnumerationType= ruleEnumerationType EOF )
            // InternalOcl.g:928:2: iv_ruleEnumerationType= ruleEnumerationType EOF
            {
             newCompositeNode(grammarAccess.getEnumerationTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumerationType=ruleEnumerationType();

            state._fsp--;

             current =iv_ruleEnumerationType; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleEnumerationType"


    // $ANTLR start "ruleEnumerationType"
    // InternalOcl.g:934:1: ruleEnumerationType returns [EObject current=null] : (otherlv_0= 'enum' otherlv_1= '{' (otherlv_2= '#' ( (lv_left_3_0= ruleName ) ) ) (otherlv_4= ',' otherlv_5= '#' ( (lv_rights_6_0= ruleName ) ) )* otherlv_7= '}' ) ;
    public final EObject ruleEnumerationType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_left_3_0 = null;

        EObject lv_rights_6_0 = null;



        	enterRule();

        try {
            // InternalOcl.g:940:2: ( (otherlv_0= 'enum' otherlv_1= '{' (otherlv_2= '#' ( (lv_left_3_0= ruleName ) ) ) (otherlv_4= ',' otherlv_5= '#' ( (lv_rights_6_0= ruleName ) ) )* otherlv_7= '}' ) )
            // InternalOcl.g:941:2: (otherlv_0= 'enum' otherlv_1= '{' (otherlv_2= '#' ( (lv_left_3_0= ruleName ) ) ) (otherlv_4= ',' otherlv_5= '#' ( (lv_rights_6_0= ruleName ) ) )* otherlv_7= '}' )
            {
            // InternalOcl.g:941:2: (otherlv_0= 'enum' otherlv_1= '{' (otherlv_2= '#' ( (lv_left_3_0= ruleName ) ) ) (otherlv_4= ',' otherlv_5= '#' ( (lv_rights_6_0= ruleName ) ) )* otherlv_7= '}' )
            // InternalOcl.g:942:3: otherlv_0= 'enum' otherlv_1= '{' (otherlv_2= '#' ( (lv_left_3_0= ruleName ) ) ) (otherlv_4= ',' otherlv_5= '#' ( (lv_rights_6_0= ruleName ) ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_17); 

            			newLeafNode(otherlv_0, grammarAccess.getEnumerationTypeAccess().getEnumKeyword_0());
            		
            otherlv_1=(Token)match(input,33,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getEnumerationTypeAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalOcl.g:950:3: (otherlv_2= '#' ( (lv_left_3_0= ruleName ) ) )
            // InternalOcl.g:951:4: otherlv_2= '#' ( (lv_left_3_0= ruleName ) )
            {
            otherlv_2=(Token)match(input,31,FOLLOW_11); 

            				newLeafNode(otherlv_2, grammarAccess.getEnumerationTypeAccess().getNumberSignKeyword_2_0());
            			
            // InternalOcl.g:955:4: ( (lv_left_3_0= ruleName ) )
            // InternalOcl.g:956:5: (lv_left_3_0= ruleName )
            {
            // InternalOcl.g:956:5: (lv_left_3_0= ruleName )
            // InternalOcl.g:957:6: lv_left_3_0= ruleName
            {

            						newCompositeNode(grammarAccess.getEnumerationTypeAccess().getLeftNameParserRuleCall_2_1_0());
            					
            pushFollow(FOLLOW_19);
            lv_left_3_0=ruleName();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getEnumerationTypeRule());
            						}
            						set(
            							current,
            							"left",
            							lv_left_3_0,
            							"org.xtext.ocl.Ocl.Name");
            						afterParserOrEnumRuleCall();
            					

            }


            }


            }

            // InternalOcl.g:975:3: (otherlv_4= ',' otherlv_5= '#' ( (lv_rights_6_0= ruleName ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==34) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalOcl.g:976:4: otherlv_4= ',' otherlv_5= '#' ( (lv_rights_6_0= ruleName ) )
            	    {
            	    otherlv_4=(Token)match(input,34,FOLLOW_18); 

            	    				newLeafNode(otherlv_4, grammarAccess.getEnumerationTypeAccess().getCommaKeyword_3_0());
            	    			
            	    otherlv_5=(Token)match(input,31,FOLLOW_11); 

            	    				newLeafNode(otherlv_5, grammarAccess.getEnumerationTypeAccess().getNumberSignKeyword_3_1());
            	    			
            	    // InternalOcl.g:984:4: ( (lv_rights_6_0= ruleName ) )
            	    // InternalOcl.g:985:5: (lv_rights_6_0= ruleName )
            	    {
            	    // InternalOcl.g:985:5: (lv_rights_6_0= ruleName )
            	    // InternalOcl.g:986:6: lv_rights_6_0= ruleName
            	    {

            	    						newCompositeNode(grammarAccess.getEnumerationTypeAccess().getRightsNameParserRuleCall_3_2_0());
            	    					
            	    pushFollow(FOLLOW_19);
            	    lv_rights_6_0=ruleName();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getEnumerationTypeRule());
            	    						}
            	    						add(
            	    							current,
            	    							"rights",
            	    							lv_rights_6_0,
            	    							"org.xtext.ocl.Ocl.Name");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            otherlv_7=(Token)match(input,35,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getEnumerationTypeAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "ruleEnumerationType"


    // $ANTLR start "entryRuleSimpleTypeSpecifier"
    // InternalOcl.g:1012:1: entryRuleSimpleTypeSpecifier returns [EObject current=null] : iv_ruleSimpleTypeSpecifier= ruleSimpleTypeSpecifier EOF ;
    public final EObject entryRuleSimpleTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleTypeSpecifier = null;


        try {
            // InternalOcl.g:1012:60: (iv_ruleSimpleTypeSpecifier= ruleSimpleTypeSpecifier EOF )
            // InternalOcl.g:1013:2: iv_ruleSimpleTypeSpecifier= ruleSimpleTypeSpecifier EOF
            {
             newCompositeNode(grammarAccess.getSimpleTypeSpecifierRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSimpleTypeSpecifier=ruleSimpleTypeSpecifier();

            state._fsp--;

             current =iv_ruleSimpleTypeSpecifier; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleSimpleTypeSpecifier"


    // $ANTLR start "ruleSimpleTypeSpecifier"
    // InternalOcl.g:1019:1: ruleSimpleTypeSpecifier returns [EObject current=null] : (this_PathTypeName_0= rulePathTypeName | this_EnumerationType_1= ruleEnumerationType ) ;
    public final EObject ruleSimpleTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject this_PathTypeName_0 = null;

        EObject this_EnumerationType_1 = null;



        	enterRule();

        try {
            // InternalOcl.g:1025:2: ( (this_PathTypeName_0= rulePathTypeName | this_EnumerationType_1= ruleEnumerationType ) )
            // InternalOcl.g:1026:2: (this_PathTypeName_0= rulePathTypeName | this_EnumerationType_1= ruleEnumerationType )
            {
            // InternalOcl.g:1026:2: (this_PathTypeName_0= rulePathTypeName | this_EnumerationType_1= ruleEnumerationType )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_TYPENAME_TERMINAL) ) {
                alt15=1;
            }
            else if ( (LA15_0==32) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalOcl.g:1027:3: this_PathTypeName_0= rulePathTypeName
                    {

                    			newCompositeNode(grammarAccess.getSimpleTypeSpecifierAccess().getPathTypeNameParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_PathTypeName_0=rulePathTypeName();

                    state._fsp--;


                    			current = this_PathTypeName_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOcl.g:1036:3: this_EnumerationType_1= ruleEnumerationType
                    {

                    			newCompositeNode(grammarAccess.getSimpleTypeSpecifierAccess().getEnumerationTypeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_EnumerationType_1=ruleEnumerationType();

                    state._fsp--;


                    			current = this_EnumerationType_1;
                    			afterParserOrEnumRuleCall();
                    		

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
    // $ANTLR end "ruleSimpleTypeSpecifier"


    // $ANTLR start "entryRuleLiteralCollection"
    // InternalOcl.g:1048:1: entryRuleLiteralCollection returns [EObject current=null] : iv_ruleLiteralCollection= ruleLiteralCollection EOF ;
    public final EObject entryRuleLiteralCollection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralCollection = null;


        try {
            // InternalOcl.g:1048:58: (iv_ruleLiteralCollection= ruleLiteralCollection EOF )
            // InternalOcl.g:1049:2: iv_ruleLiteralCollection= ruleLiteralCollection EOF
            {
             newCompositeNode(grammarAccess.getLiteralCollectionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteralCollection=ruleLiteralCollection();

            state._fsp--;

             current =iv_ruleLiteralCollection; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleLiteralCollection"


    // $ANTLR start "ruleLiteralCollection"
    // InternalOcl.g:1055:1: ruleLiteralCollection returns [EObject current=null] : ( () ( (lv_name_1_0= ruleCollectionKind ) ) otherlv_2= '{' ( (lv_exp_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}' ) ;
    public final EObject ruleLiteralCollection() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_name_1_0 = null;

        EObject lv_exp_3_0 = null;



        	enterRule();

        try {
            // InternalOcl.g:1061:2: ( ( () ( (lv_name_1_0= ruleCollectionKind ) ) otherlv_2= '{' ( (lv_exp_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}' ) )
            // InternalOcl.g:1062:2: ( () ( (lv_name_1_0= ruleCollectionKind ) ) otherlv_2= '{' ( (lv_exp_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}' )
            {
            // InternalOcl.g:1062:2: ( () ( (lv_name_1_0= ruleCollectionKind ) ) otherlv_2= '{' ( (lv_exp_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}' )
            // InternalOcl.g:1063:3: () ( (lv_name_1_0= ruleCollectionKind ) ) otherlv_2= '{' ( (lv_exp_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}'
            {
            // InternalOcl.g:1063:3: ()
            // InternalOcl.g:1064:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLiteralCollectionAccess().getLiteralCollectionAction_0(),
            					current);
            			

            }

            // InternalOcl.g:1070:3: ( (lv_name_1_0= ruleCollectionKind ) )
            // InternalOcl.g:1071:4: (lv_name_1_0= ruleCollectionKind )
            {
            // InternalOcl.g:1071:4: (lv_name_1_0= ruleCollectionKind )
            // InternalOcl.g:1072:5: lv_name_1_0= ruleCollectionKind
            {

            					newCompositeNode(grammarAccess.getLiteralCollectionAccess().getNameCollectionKindParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_17);
            lv_name_1_0=ruleCollectionKind();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLiteralCollectionRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.ocl.Ocl.CollectionKind");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,33,FOLLOW_20); 

            			newLeafNode(otherlv_2, grammarAccess.getLiteralCollectionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOcl.g:1093:3: ( (lv_exp_3_0= ruleExpressionListOrRange ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=RULE_TYPENAME_TERMINAL && LA16_0<=RULE_NAME_TERMINAL)||LA16_0==25||LA16_0==27||LA16_0==31||(LA16_0>=41 && LA16_0<=63)||(LA16_0>=65 && LA16_0<=82)||(LA16_0>=85 && LA16_0<=86)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalOcl.g:1094:4: (lv_exp_3_0= ruleExpressionListOrRange )
                    {
                    // InternalOcl.g:1094:4: (lv_exp_3_0= ruleExpressionListOrRange )
                    // InternalOcl.g:1095:5: lv_exp_3_0= ruleExpressionListOrRange
                    {

                    					newCompositeNode(grammarAccess.getLiteralCollectionAccess().getExpExpressionListOrRangeParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_21);
                    lv_exp_3_0=ruleExpressionListOrRange();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getLiteralCollectionRule());
                    					}
                    					set(
                    						current,
                    						"exp",
                    						lv_exp_3_0,
                    						"org.xtext.ocl.Ocl.ExpressionListOrRange");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,35,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getLiteralCollectionAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "ruleLiteralCollection"


    // $ANTLR start "entryRuleExpressionListOrRange"
    // InternalOcl.g:1120:1: entryRuleExpressionListOrRange returns [EObject current=null] : iv_ruleExpressionListOrRange= ruleExpressionListOrRange EOF ;
    public final EObject entryRuleExpressionListOrRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionListOrRange = null;


        try {
            // InternalOcl.g:1120:62: (iv_ruleExpressionListOrRange= ruleExpressionListOrRange EOF )
            // InternalOcl.g:1121:2: iv_ruleExpressionListOrRange= ruleExpressionListOrRange EOF
            {
             newCompositeNode(grammarAccess.getExpressionListOrRangeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpressionListOrRange=ruleExpressionListOrRange();

            state._fsp--;

             current =iv_ruleExpressionListOrRange; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleExpressionListOrRange"


    // $ANTLR start "ruleExpressionListOrRange"
    // InternalOcl.g:1127:1: ruleExpressionListOrRange returns [EObject current=null] : ( ( (lv_exp_0_0= ruleExpression ) ) ( (otherlv_1= ',' ( (lv_exp_2_0= ruleExpression ) ) )+ | (otherlv_3= '..' ( (lv_exp_4_0= ruleExpression ) ) ) )? ) ;
    public final EObject ruleExpressionListOrRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;

        EObject lv_exp_4_0 = null;



        	enterRule();

        try {
            // InternalOcl.g:1133:2: ( ( ( (lv_exp_0_0= ruleExpression ) ) ( (otherlv_1= ',' ( (lv_exp_2_0= ruleExpression ) ) )+ | (otherlv_3= '..' ( (lv_exp_4_0= ruleExpression ) ) ) )? ) )
            // InternalOcl.g:1134:2: ( ( (lv_exp_0_0= ruleExpression ) ) ( (otherlv_1= ',' ( (lv_exp_2_0= ruleExpression ) ) )+ | (otherlv_3= '..' ( (lv_exp_4_0= ruleExpression ) ) ) )? )
            {
            // InternalOcl.g:1134:2: ( ( (lv_exp_0_0= ruleExpression ) ) ( (otherlv_1= ',' ( (lv_exp_2_0= ruleExpression ) ) )+ | (otherlv_3= '..' ( (lv_exp_4_0= ruleExpression ) ) ) )? )
            // InternalOcl.g:1135:3: ( (lv_exp_0_0= ruleExpression ) ) ( (otherlv_1= ',' ( (lv_exp_2_0= ruleExpression ) ) )+ | (otherlv_3= '..' ( (lv_exp_4_0= ruleExpression ) ) ) )?
            {
            // InternalOcl.g:1135:3: ( (lv_exp_0_0= ruleExpression ) )
            // InternalOcl.g:1136:4: (lv_exp_0_0= ruleExpression )
            {
            // InternalOcl.g:1136:4: (lv_exp_0_0= ruleExpression )
            // InternalOcl.g:1137:5: lv_exp_0_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getExpressionListOrRangeAccess().getExpExpressionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_22);
            lv_exp_0_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExpressionListOrRangeRule());
            					}
            					add(
            						current,
            						"exp",
            						lv_exp_0_0,
            						"org.xtext.ocl.Ocl.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOcl.g:1154:3: ( (otherlv_1= ',' ( (lv_exp_2_0= ruleExpression ) ) )+ | (otherlv_3= '..' ( (lv_exp_4_0= ruleExpression ) ) ) )?
            int alt18=3;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==34) ) {
                alt18=1;
            }
            else if ( (LA18_0==36) ) {
                alt18=2;
            }
            switch (alt18) {
                case 1 :
                    // InternalOcl.g:1155:4: (otherlv_1= ',' ( (lv_exp_2_0= ruleExpression ) ) )+
                    {
                    // InternalOcl.g:1155:4: (otherlv_1= ',' ( (lv_exp_2_0= ruleExpression ) ) )+
                    int cnt17=0;
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==34) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalOcl.g:1156:5: otherlv_1= ',' ( (lv_exp_2_0= ruleExpression ) )
                    	    {
                    	    otherlv_1=(Token)match(input,34,FOLLOW_5); 

                    	    					newLeafNode(otherlv_1, grammarAccess.getExpressionListOrRangeAccess().getCommaKeyword_1_0_0());
                    	    				
                    	    // InternalOcl.g:1160:5: ( (lv_exp_2_0= ruleExpression ) )
                    	    // InternalOcl.g:1161:6: (lv_exp_2_0= ruleExpression )
                    	    {
                    	    // InternalOcl.g:1161:6: (lv_exp_2_0= ruleExpression )
                    	    // InternalOcl.g:1162:7: lv_exp_2_0= ruleExpression
                    	    {

                    	    							newCompositeNode(grammarAccess.getExpressionListOrRangeAccess().getExpExpressionParserRuleCall_1_0_1_0());
                    	    						
                    	    pushFollow(FOLLOW_23);
                    	    lv_exp_2_0=ruleExpression();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getExpressionListOrRangeRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"exp",
                    	    								lv_exp_2_0,
                    	    								"org.xtext.ocl.Ocl.Expression");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt17 >= 1 ) break loop17;
                                EarlyExitException eee =
                                    new EarlyExitException(17, input);
                                throw eee;
                        }
                        cnt17++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // InternalOcl.g:1181:4: (otherlv_3= '..' ( (lv_exp_4_0= ruleExpression ) ) )
                    {
                    // InternalOcl.g:1181:4: (otherlv_3= '..' ( (lv_exp_4_0= ruleExpression ) ) )
                    // InternalOcl.g:1182:5: otherlv_3= '..' ( (lv_exp_4_0= ruleExpression ) )
                    {
                    otherlv_3=(Token)match(input,36,FOLLOW_5); 

                    					newLeafNode(otherlv_3, grammarAccess.getExpressionListOrRangeAccess().getFullStopFullStopKeyword_1_1_0());
                    				
                    // InternalOcl.g:1186:5: ( (lv_exp_4_0= ruleExpression ) )
                    // InternalOcl.g:1187:6: (lv_exp_4_0= ruleExpression )
                    {
                    // InternalOcl.g:1187:6: (lv_exp_4_0= ruleExpression )
                    // InternalOcl.g:1188:7: lv_exp_4_0= ruleExpression
                    {

                    							newCompositeNode(grammarAccess.getExpressionListOrRangeAccess().getExpExpressionParserRuleCall_1_1_1_0());
                    						
                    pushFollow(FOLLOW_2);
                    lv_exp_4_0=ruleExpression();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getExpressionListOrRangeRule());
                    							}
                    							add(
                    								current,
                    								"exp",
                    								lv_exp_4_0,
                    								"org.xtext.ocl.Ocl.Expression");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleExpressionListOrRange"


    // $ANTLR start "entryRuleFeatureCall"
    // InternalOcl.g:1211:1: entryRuleFeatureCall returns [EObject current=null] : iv_ruleFeatureCall= ruleFeatureCall EOF ;
    public final EObject entryRuleFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureCall = null;


        try {
            // InternalOcl.g:1211:52: (iv_ruleFeatureCall= ruleFeatureCall EOF )
            // InternalOcl.g:1212:2: iv_ruleFeatureCall= ruleFeatureCall EOF
            {
             newCompositeNode(grammarAccess.getFeatureCallRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFeatureCall=ruleFeatureCall();

            state._fsp--;

             current =iv_ruleFeatureCall; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleFeatureCall"


    // $ANTLR start "ruleFeatureCall"
    // InternalOcl.g:1218:1: ruleFeatureCall returns [EObject current=null] : (this_PathName_0= rulePathName ( (lv_params_1_0= ruleTimeExpression ) )? ( (lv_params_2_0= ruleQualifiers ) )? ( (lv_params_3_0= ruleFeatureCallParameters ) )? ) ;
    public final EObject ruleFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject this_PathName_0 = null;

        EObject lv_params_1_0 = null;

        EObject lv_params_2_0 = null;

        EObject lv_params_3_0 = null;



        	enterRule();

        try {
            // InternalOcl.g:1224:2: ( (this_PathName_0= rulePathName ( (lv_params_1_0= ruleTimeExpression ) )? ( (lv_params_2_0= ruleQualifiers ) )? ( (lv_params_3_0= ruleFeatureCallParameters ) )? ) )
            // InternalOcl.g:1225:2: (this_PathName_0= rulePathName ( (lv_params_1_0= ruleTimeExpression ) )? ( (lv_params_2_0= ruleQualifiers ) )? ( (lv_params_3_0= ruleFeatureCallParameters ) )? )
            {
            // InternalOcl.g:1225:2: (this_PathName_0= rulePathName ( (lv_params_1_0= ruleTimeExpression ) )? ( (lv_params_2_0= ruleQualifiers ) )? ( (lv_params_3_0= ruleFeatureCallParameters ) )? )
            // InternalOcl.g:1226:3: this_PathName_0= rulePathName ( (lv_params_1_0= ruleTimeExpression ) )? ( (lv_params_2_0= ruleQualifiers ) )? ( (lv_params_3_0= ruleFeatureCallParameters ) )?
            {

            			newCompositeNode(grammarAccess.getFeatureCallAccess().getPathNameParserRuleCall_0());
            		
            pushFollow(FOLLOW_24);
            this_PathName_0=rulePathName();

            state._fsp--;


            			current = this_PathName_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalOcl.g:1234:3: ( (lv_params_1_0= ruleTimeExpression ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==40) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalOcl.g:1235:4: (lv_params_1_0= ruleTimeExpression )
                    {
                    // InternalOcl.g:1235:4: (lv_params_1_0= ruleTimeExpression )
                    // InternalOcl.g:1236:5: lv_params_1_0= ruleTimeExpression
                    {

                    					newCompositeNode(grammarAccess.getFeatureCallAccess().getParamsTimeExpressionParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_25);
                    lv_params_1_0=ruleTimeExpression();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getFeatureCallRule());
                    					}
                    					add(
                    						current,
                    						"params",
                    						lv_params_1_0,
                    						"org.xtext.ocl.Ocl.TimeExpression");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalOcl.g:1253:3: ( (lv_params_2_0= ruleQualifiers ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==37) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalOcl.g:1254:4: (lv_params_2_0= ruleQualifiers )
                    {
                    // InternalOcl.g:1254:4: (lv_params_2_0= ruleQualifiers )
                    // InternalOcl.g:1255:5: lv_params_2_0= ruleQualifiers
                    {

                    					newCompositeNode(grammarAccess.getFeatureCallAccess().getParamsQualifiersParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_26);
                    lv_params_2_0=ruleQualifiers();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getFeatureCallRule());
                    					}
                    					add(
                    						current,
                    						"params",
                    						lv_params_2_0,
                    						"org.xtext.ocl.Ocl.Qualifiers");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalOcl.g:1272:3: ( (lv_params_3_0= ruleFeatureCallParameters ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==25) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalOcl.g:1273:4: (lv_params_3_0= ruleFeatureCallParameters )
                    {
                    // InternalOcl.g:1273:4: (lv_params_3_0= ruleFeatureCallParameters )
                    // InternalOcl.g:1274:5: lv_params_3_0= ruleFeatureCallParameters
                    {

                    					newCompositeNode(grammarAccess.getFeatureCallAccess().getParamsFeatureCallParametersParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_params_3_0=ruleFeatureCallParameters();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getFeatureCallRule());
                    					}
                    					add(
                    						current,
                    						"params",
                    						lv_params_3_0,
                    						"org.xtext.ocl.Ocl.FeatureCallParameters");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

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
    // $ANTLR end "ruleFeatureCall"


    // $ANTLR start "entryRuleQualifiers"
    // InternalOcl.g:1295:1: entryRuleQualifiers returns [EObject current=null] : iv_ruleQualifiers= ruleQualifiers EOF ;
    public final EObject entryRuleQualifiers() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiers = null;


        try {
            // InternalOcl.g:1295:51: (iv_ruleQualifiers= ruleQualifiers EOF )
            // InternalOcl.g:1296:2: iv_ruleQualifiers= ruleQualifiers EOF
            {
             newCompositeNode(grammarAccess.getQualifiersRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiers=ruleQualifiers();

            state._fsp--;

             current =iv_ruleQualifiers; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleQualifiers"


    // $ANTLR start "ruleQualifiers"
    // InternalOcl.g:1302:1: ruleQualifiers returns [EObject current=null] : (otherlv_0= '[' this_ActualParameterList_1= ruleActualParameterList otherlv_2= ']' ) ;
    public final EObject ruleQualifiers() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_ActualParameterList_1 = null;



        	enterRule();

        try {
            // InternalOcl.g:1308:2: ( (otherlv_0= '[' this_ActualParameterList_1= ruleActualParameterList otherlv_2= ']' ) )
            // InternalOcl.g:1309:2: (otherlv_0= '[' this_ActualParameterList_1= ruleActualParameterList otherlv_2= ']' )
            {
            // InternalOcl.g:1309:2: (otherlv_0= '[' this_ActualParameterList_1= ruleActualParameterList otherlv_2= ']' )
            // InternalOcl.g:1310:3: otherlv_0= '[' this_ActualParameterList_1= ruleActualParameterList otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getQualifiersAccess().getLeftSquareBracketKeyword_0());
            		

            			newCompositeNode(grammarAccess.getQualifiersAccess().getActualParameterListParserRuleCall_1());
            		
            pushFollow(FOLLOW_27);
            this_ActualParameterList_1=ruleActualParameterList();

            state._fsp--;


            			current = this_ActualParameterList_1;
            			afterParserOrEnumRuleCall();
            		
            otherlv_2=(Token)match(input,38,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getQualifiersAccess().getRightSquareBracketKeyword_2());
            		

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
    // $ANTLR end "ruleQualifiers"


    // $ANTLR start "entryRuleDeclarator"
    // InternalOcl.g:1330:1: entryRuleDeclarator returns [EObject current=null] : iv_ruleDeclarator= ruleDeclarator EOF ;
    public final EObject entryRuleDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclarator = null;


        try {
            // InternalOcl.g:1330:51: (iv_ruleDeclarator= ruleDeclarator EOF )
            // InternalOcl.g:1331:2: iv_ruleDeclarator= ruleDeclarator EOF
            {
             newCompositeNode(grammarAccess.getDeclaratorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDeclarator=ruleDeclarator();

            state._fsp--;

             current =iv_ruleDeclarator; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleDeclarator"


    // $ANTLR start "ruleDeclarator"
    // InternalOcl.g:1337:1: ruleDeclarator returns [EObject current=null] : ( ( (lv_name_0_0= ruleName ) ) (otherlv_1= ',' ( (lv_name_2_0= ruleName ) ) )* (this_COLON_3= RULE_COLON ( (lv_type_4_0= ruleSimpleTypeSpecifier ) ) )? otherlv_5= '|' ) ;
    public final EObject ruleDeclarator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_COLON_3=null;
        Token otherlv_5=null;
        EObject lv_name_0_0 = null;

        EObject lv_name_2_0 = null;

        EObject lv_type_4_0 = null;



        	enterRule();

        try {
            // InternalOcl.g:1343:2: ( ( ( (lv_name_0_0= ruleName ) ) (otherlv_1= ',' ( (lv_name_2_0= ruleName ) ) )* (this_COLON_3= RULE_COLON ( (lv_type_4_0= ruleSimpleTypeSpecifier ) ) )? otherlv_5= '|' ) )
            // InternalOcl.g:1344:2: ( ( (lv_name_0_0= ruleName ) ) (otherlv_1= ',' ( (lv_name_2_0= ruleName ) ) )* (this_COLON_3= RULE_COLON ( (lv_type_4_0= ruleSimpleTypeSpecifier ) ) )? otherlv_5= '|' )
            {
            // InternalOcl.g:1344:2: ( ( (lv_name_0_0= ruleName ) ) (otherlv_1= ',' ( (lv_name_2_0= ruleName ) ) )* (this_COLON_3= RULE_COLON ( (lv_type_4_0= ruleSimpleTypeSpecifier ) ) )? otherlv_5= '|' )
            // InternalOcl.g:1345:3: ( (lv_name_0_0= ruleName ) ) (otherlv_1= ',' ( (lv_name_2_0= ruleName ) ) )* (this_COLON_3= RULE_COLON ( (lv_type_4_0= ruleSimpleTypeSpecifier ) ) )? otherlv_5= '|'
            {
            // InternalOcl.g:1345:3: ( (lv_name_0_0= ruleName ) )
            // InternalOcl.g:1346:4: (lv_name_0_0= ruleName )
            {
            // InternalOcl.g:1346:4: (lv_name_0_0= ruleName )
            // InternalOcl.g:1347:5: lv_name_0_0= ruleName
            {

            					newCompositeNode(grammarAccess.getDeclaratorAccess().getNameNameParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_28);
            lv_name_0_0=ruleName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDeclaratorRule());
            					}
            					add(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.xtext.ocl.Ocl.Name");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOcl.g:1364:3: (otherlv_1= ',' ( (lv_name_2_0= ruleName ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==34) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalOcl.g:1365:4: otherlv_1= ',' ( (lv_name_2_0= ruleName ) )
            	    {
            	    otherlv_1=(Token)match(input,34,FOLLOW_11); 

            	    				newLeafNode(otherlv_1, grammarAccess.getDeclaratorAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalOcl.g:1369:4: ( (lv_name_2_0= ruleName ) )
            	    // InternalOcl.g:1370:5: (lv_name_2_0= ruleName )
            	    {
            	    // InternalOcl.g:1370:5: (lv_name_2_0= ruleName )
            	    // InternalOcl.g:1371:6: lv_name_2_0= ruleName
            	    {

            	    						newCompositeNode(grammarAccess.getDeclaratorAccess().getNameNameParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_28);
            	    lv_name_2_0=ruleName();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDeclaratorRule());
            	    						}
            	    						add(
            	    							current,
            	    							"name",
            	    							lv_name_2_0,
            	    							"org.xtext.ocl.Ocl.Name");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            // InternalOcl.g:1389:3: (this_COLON_3= RULE_COLON ( (lv_type_4_0= ruleSimpleTypeSpecifier ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_COLON) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalOcl.g:1390:4: this_COLON_3= RULE_COLON ( (lv_type_4_0= ruleSimpleTypeSpecifier ) )
                    {
                    this_COLON_3=(Token)match(input,RULE_COLON,FOLLOW_29); 

                    				newLeafNode(this_COLON_3, grammarAccess.getDeclaratorAccess().getCOLONTerminalRuleCall_2_0());
                    			
                    // InternalOcl.g:1394:4: ( (lv_type_4_0= ruleSimpleTypeSpecifier ) )
                    // InternalOcl.g:1395:5: (lv_type_4_0= ruleSimpleTypeSpecifier )
                    {
                    // InternalOcl.g:1395:5: (lv_type_4_0= ruleSimpleTypeSpecifier )
                    // InternalOcl.g:1396:6: lv_type_4_0= ruleSimpleTypeSpecifier
                    {

                    						newCompositeNode(grammarAccess.getDeclaratorAccess().getTypeSimpleTypeSpecifierParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_30);
                    lv_type_4_0=ruleSimpleTypeSpecifier();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDeclaratorRule());
                    						}
                    						set(
                    							current,
                    							"type",
                    							lv_type_4_0,
                    							"org.xtext.ocl.Ocl.SimpleTypeSpecifier");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getDeclaratorAccess().getVerticalLineKeyword_3());
            		

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
    // $ANTLR end "ruleDeclarator"


    // $ANTLR start "entryRulePathTypeName"
    // InternalOcl.g:1422:1: entryRulePathTypeName returns [EObject current=null] : iv_rulePathTypeName= rulePathTypeName EOF ;
    public final EObject entryRulePathTypeName() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathTypeName = null;


        try {
            // InternalOcl.g:1422:53: (iv_rulePathTypeName= rulePathTypeName EOF )
            // InternalOcl.g:1423:2: iv_rulePathTypeName= rulePathTypeName EOF
            {
             newCompositeNode(grammarAccess.getPathTypeNameRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePathTypeName=rulePathTypeName();

            state._fsp--;

             current =iv_rulePathTypeName; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRulePathTypeName"


    // $ANTLR start "rulePathTypeName"
    // InternalOcl.g:1429:1: rulePathTypeName returns [EObject current=null] : ( ( (lv_left_0_0= ruleTypeName ) ) (this_DOUBLE_COLON_1= RULE_DOUBLE_COLON ( (lv_rights_2_0= ruleTypeName ) ) )* ) ;
    public final EObject rulePathTypeName() throws RecognitionException {
        EObject current = null;

        Token this_DOUBLE_COLON_1=null;
        EObject lv_left_0_0 = null;

        EObject lv_rights_2_0 = null;



        	enterRule();

        try {
            // InternalOcl.g:1435:2: ( ( ( (lv_left_0_0= ruleTypeName ) ) (this_DOUBLE_COLON_1= RULE_DOUBLE_COLON ( (lv_rights_2_0= ruleTypeName ) ) )* ) )
            // InternalOcl.g:1436:2: ( ( (lv_left_0_0= ruleTypeName ) ) (this_DOUBLE_COLON_1= RULE_DOUBLE_COLON ( (lv_rights_2_0= ruleTypeName ) ) )* )
            {
            // InternalOcl.g:1436:2: ( ( (lv_left_0_0= ruleTypeName ) ) (this_DOUBLE_COLON_1= RULE_DOUBLE_COLON ( (lv_rights_2_0= ruleTypeName ) ) )* )
            // InternalOcl.g:1437:3: ( (lv_left_0_0= ruleTypeName ) ) (this_DOUBLE_COLON_1= RULE_DOUBLE_COLON ( (lv_rights_2_0= ruleTypeName ) ) )*
            {
            // InternalOcl.g:1437:3: ( (lv_left_0_0= ruleTypeName ) )
            // InternalOcl.g:1438:4: (lv_left_0_0= ruleTypeName )
            {
            // InternalOcl.g:1438:4: (lv_left_0_0= ruleTypeName )
            // InternalOcl.g:1439:5: lv_left_0_0= ruleTypeName
            {

            					newCompositeNode(grammarAccess.getPathTypeNameAccess().getLeftTypeNameParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_31);
            lv_left_0_0=ruleTypeName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPathTypeNameRule());
            					}
            					set(
            						current,
            						"left",
            						lv_left_0_0,
            						"org.xtext.ocl.Ocl.TypeName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOcl.g:1456:3: (this_DOUBLE_COLON_1= RULE_DOUBLE_COLON ( (lv_rights_2_0= ruleTypeName ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_DOUBLE_COLON) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalOcl.g:1457:4: this_DOUBLE_COLON_1= RULE_DOUBLE_COLON ( (lv_rights_2_0= ruleTypeName ) )
            	    {
            	    this_DOUBLE_COLON_1=(Token)match(input,RULE_DOUBLE_COLON,FOLLOW_3); 

            	    				newLeafNode(this_DOUBLE_COLON_1, grammarAccess.getPathTypeNameAccess().getDOUBLE_COLONTerminalRuleCall_1_0());
            	    			
            	    // InternalOcl.g:1461:4: ( (lv_rights_2_0= ruleTypeName ) )
            	    // InternalOcl.g:1462:5: (lv_rights_2_0= ruleTypeName )
            	    {
            	    // InternalOcl.g:1462:5: (lv_rights_2_0= ruleTypeName )
            	    // InternalOcl.g:1463:6: lv_rights_2_0= ruleTypeName
            	    {

            	    						newCompositeNode(grammarAccess.getPathTypeNameAccess().getRightsTypeNameParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_31);
            	    lv_rights_2_0=ruleTypeName();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPathTypeNameRule());
            	    						}
            	    						add(
            	    							current,
            	    							"rights",
            	    							lv_rights_2_0,
            	    							"org.xtext.ocl.Ocl.TypeName");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
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
    // $ANTLR end "rulePathTypeName"


    // $ANTLR start "entryRulePathName"
    // InternalOcl.g:1485:1: entryRulePathName returns [EObject current=null] : iv_rulePathName= rulePathName EOF ;
    public final EObject entryRulePathName() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathName = null;


        try {
            // InternalOcl.g:1485:49: (iv_rulePathName= rulePathName EOF )
            // InternalOcl.g:1486:2: iv_rulePathName= rulePathName EOF
            {
             newCompositeNode(grammarAccess.getPathNameRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePathName=rulePathName();

            state._fsp--;

             current =iv_rulePathName; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRulePathName"


    // $ANTLR start "rulePathName"
    // InternalOcl.g:1492:1: rulePathName returns [EObject current=null] : ( ( ( (lv_left_0_1= ruleTypeName | lv_left_0_2= ruleName ) ) ) (this_DOUBLE_COLON_1= RULE_DOUBLE_COLON ( ( (lv_rights_2_1= ruleTypeName | lv_rights_2_2= ruleName ) ) ) )* ) ;
    public final EObject rulePathName() throws RecognitionException {
        EObject current = null;

        Token this_DOUBLE_COLON_1=null;
        EObject lv_left_0_1 = null;

        EObject lv_left_0_2 = null;

        EObject lv_rights_2_1 = null;

        EObject lv_rights_2_2 = null;



        	enterRule();

        try {
            // InternalOcl.g:1498:2: ( ( ( ( (lv_left_0_1= ruleTypeName | lv_left_0_2= ruleName ) ) ) (this_DOUBLE_COLON_1= RULE_DOUBLE_COLON ( ( (lv_rights_2_1= ruleTypeName | lv_rights_2_2= ruleName ) ) ) )* ) )
            // InternalOcl.g:1499:2: ( ( ( (lv_left_0_1= ruleTypeName | lv_left_0_2= ruleName ) ) ) (this_DOUBLE_COLON_1= RULE_DOUBLE_COLON ( ( (lv_rights_2_1= ruleTypeName | lv_rights_2_2= ruleName ) ) ) )* )
            {
            // InternalOcl.g:1499:2: ( ( ( (lv_left_0_1= ruleTypeName | lv_left_0_2= ruleName ) ) ) (this_DOUBLE_COLON_1= RULE_DOUBLE_COLON ( ( (lv_rights_2_1= ruleTypeName | lv_rights_2_2= ruleName ) ) ) )* )
            // InternalOcl.g:1500:3: ( ( (lv_left_0_1= ruleTypeName | lv_left_0_2= ruleName ) ) ) (this_DOUBLE_COLON_1= RULE_DOUBLE_COLON ( ( (lv_rights_2_1= ruleTypeName | lv_rights_2_2= ruleName ) ) ) )*
            {
            // InternalOcl.g:1500:3: ( ( (lv_left_0_1= ruleTypeName | lv_left_0_2= ruleName ) ) )
            // InternalOcl.g:1501:4: ( (lv_left_0_1= ruleTypeName | lv_left_0_2= ruleName ) )
            {
            // InternalOcl.g:1501:4: ( (lv_left_0_1= ruleTypeName | lv_left_0_2= ruleName ) )
            // InternalOcl.g:1502:5: (lv_left_0_1= ruleTypeName | lv_left_0_2= ruleName )
            {
            // InternalOcl.g:1502:5: (lv_left_0_1= ruleTypeName | lv_left_0_2= ruleName )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_TYPENAME_TERMINAL) ) {
                alt25=1;
            }
            else if ( (LA25_0==RULE_NAME_TERMINAL||(LA25_0>=41 && LA25_0<=63)||(LA25_0>=65 && LA25_0<=78)) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // InternalOcl.g:1503:6: lv_left_0_1= ruleTypeName
                    {

                    						newCompositeNode(grammarAccess.getPathNameAccess().getLeftTypeNameParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_31);
                    lv_left_0_1=ruleTypeName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPathNameRule());
                    						}
                    						set(
                    							current,
                    							"left",
                    							lv_left_0_1,
                    							"org.xtext.ocl.Ocl.TypeName");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;
                case 2 :
                    // InternalOcl.g:1519:6: lv_left_0_2= ruleName
                    {

                    						newCompositeNode(grammarAccess.getPathNameAccess().getLeftNameParserRuleCall_0_0_1());
                    					
                    pushFollow(FOLLOW_31);
                    lv_left_0_2=ruleName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPathNameRule());
                    						}
                    						set(
                    							current,
                    							"left",
                    							lv_left_0_2,
                    							"org.xtext.ocl.Ocl.Name");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;

            }


            }


            }

            // InternalOcl.g:1537:3: (this_DOUBLE_COLON_1= RULE_DOUBLE_COLON ( ( (lv_rights_2_1= ruleTypeName | lv_rights_2_2= ruleName ) ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_DOUBLE_COLON) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalOcl.g:1538:4: this_DOUBLE_COLON_1= RULE_DOUBLE_COLON ( ( (lv_rights_2_1= ruleTypeName | lv_rights_2_2= ruleName ) ) )
            	    {
            	    this_DOUBLE_COLON_1=(Token)match(input,RULE_DOUBLE_COLON,FOLLOW_11); 

            	    				newLeafNode(this_DOUBLE_COLON_1, grammarAccess.getPathNameAccess().getDOUBLE_COLONTerminalRuleCall_1_0());
            	    			
            	    // InternalOcl.g:1542:4: ( ( (lv_rights_2_1= ruleTypeName | lv_rights_2_2= ruleName ) ) )
            	    // InternalOcl.g:1543:5: ( (lv_rights_2_1= ruleTypeName | lv_rights_2_2= ruleName ) )
            	    {
            	    // InternalOcl.g:1543:5: ( (lv_rights_2_1= ruleTypeName | lv_rights_2_2= ruleName ) )
            	    // InternalOcl.g:1544:6: (lv_rights_2_1= ruleTypeName | lv_rights_2_2= ruleName )
            	    {
            	    // InternalOcl.g:1544:6: (lv_rights_2_1= ruleTypeName | lv_rights_2_2= ruleName )
            	    int alt26=2;
            	    int LA26_0 = input.LA(1);

            	    if ( (LA26_0==RULE_TYPENAME_TERMINAL) ) {
            	        alt26=1;
            	    }
            	    else if ( (LA26_0==RULE_NAME_TERMINAL||(LA26_0>=41 && LA26_0<=63)||(LA26_0>=65 && LA26_0<=78)) ) {
            	        alt26=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 26, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt26) {
            	        case 1 :
            	            // InternalOcl.g:1545:7: lv_rights_2_1= ruleTypeName
            	            {

            	            							newCompositeNode(grammarAccess.getPathNameAccess().getRightsTypeNameParserRuleCall_1_1_0_0());
            	            						
            	            pushFollow(FOLLOW_31);
            	            lv_rights_2_1=ruleTypeName();

            	            state._fsp--;


            	            							if (current==null) {
            	            								current = createModelElementForParent(grammarAccess.getPathNameRule());
            	            							}
            	            							add(
            	            								current,
            	            								"rights",
            	            								lv_rights_2_1,
            	            								"org.xtext.ocl.Ocl.TypeName");
            	            							afterParserOrEnumRuleCall();
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalOcl.g:1561:7: lv_rights_2_2= ruleName
            	            {

            	            							newCompositeNode(grammarAccess.getPathNameAccess().getRightsNameParserRuleCall_1_1_0_1());
            	            						
            	            pushFollow(FOLLOW_31);
            	            lv_rights_2_2=ruleName();

            	            state._fsp--;


            	            							if (current==null) {
            	            								current = createModelElementForParent(grammarAccess.getPathNameRule());
            	            							}
            	            							add(
            	            								current,
            	            								"rights",
            	            								lv_rights_2_2,
            	            								"org.xtext.ocl.Ocl.Name");
            	            							afterParserOrEnumRuleCall();
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
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
    // $ANTLR end "rulePathName"


    // $ANTLR start "entryRuleTimeExpression"
    // InternalOcl.g:1584:1: entryRuleTimeExpression returns [EObject current=null] : iv_ruleTimeExpression= ruleTimeExpression EOF ;
    public final EObject entryRuleTimeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeExpression = null;


        try {
            // InternalOcl.g:1584:55: (iv_ruleTimeExpression= ruleTimeExpression EOF )
            // InternalOcl.g:1585:2: iv_ruleTimeExpression= ruleTimeExpression EOF
            {
             newCompositeNode(grammarAccess.getTimeExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimeExpression=ruleTimeExpression();

            state._fsp--;

             current =iv_ruleTimeExpression; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleTimeExpression"


    // $ANTLR start "ruleTimeExpression"
    // InternalOcl.g:1591:1: ruleTimeExpression returns [EObject current=null] : (otherlv_0= '@' ( (lv_name_1_0= RULE_NAME_TERMINAL ) ) ) ;
    public final EObject ruleTimeExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalOcl.g:1597:2: ( (otherlv_0= '@' ( (lv_name_1_0= RULE_NAME_TERMINAL ) ) ) )
            // InternalOcl.g:1598:2: (otherlv_0= '@' ( (lv_name_1_0= RULE_NAME_TERMINAL ) ) )
            {
            // InternalOcl.g:1598:2: (otherlv_0= '@' ( (lv_name_1_0= RULE_NAME_TERMINAL ) ) )
            // InternalOcl.g:1599:3: otherlv_0= '@' ( (lv_name_1_0= RULE_NAME_TERMINAL ) )
            {
            otherlv_0=(Token)match(input,40,FOLLOW_16); 

            			newLeafNode(otherlv_0, grammarAccess.getTimeExpressionAccess().getCommercialAtKeyword_0());
            		
            // InternalOcl.g:1603:3: ( (lv_name_1_0= RULE_NAME_TERMINAL ) )
            // InternalOcl.g:1604:4: (lv_name_1_0= RULE_NAME_TERMINAL )
            {
            // InternalOcl.g:1604:4: (lv_name_1_0= RULE_NAME_TERMINAL )
            // InternalOcl.g:1605:5: lv_name_1_0= RULE_NAME_TERMINAL
            {
            lv_name_1_0=(Token)match(input,RULE_NAME_TERMINAL,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getTimeExpressionAccess().getNameNAME_TERMINALTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTimeExpressionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.ocl.Ocl.NAME_TERMINAL");
            				

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
    // $ANTLR end "ruleTimeExpression"


    // $ANTLR start "entryRuleActualParameterList"
    // InternalOcl.g:1625:1: entryRuleActualParameterList returns [EObject current=null] : iv_ruleActualParameterList= ruleActualParameterList EOF ;
    public final EObject entryRuleActualParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActualParameterList = null;


        try {
            // InternalOcl.g:1625:60: (iv_ruleActualParameterList= ruleActualParameterList EOF )
            // InternalOcl.g:1626:2: iv_ruleActualParameterList= ruleActualParameterList EOF
            {
             newCompositeNode(grammarAccess.getActualParameterListRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleActualParameterList=ruleActualParameterList();

            state._fsp--;

             current =iv_ruleActualParameterList; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleActualParameterList"


    // $ANTLR start "ruleActualParameterList"
    // InternalOcl.g:1632:1: ruleActualParameterList returns [EObject current=null] : ( ( (lv_exp_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_exp_2_0= ruleExpression ) ) )* ) ;
    public final EObject ruleActualParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;



        	enterRule();

        try {
            // InternalOcl.g:1638:2: ( ( ( (lv_exp_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_exp_2_0= ruleExpression ) ) )* ) )
            // InternalOcl.g:1639:2: ( ( (lv_exp_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_exp_2_0= ruleExpression ) ) )* )
            {
            // InternalOcl.g:1639:2: ( ( (lv_exp_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_exp_2_0= ruleExpression ) ) )* )
            // InternalOcl.g:1640:3: ( (lv_exp_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_exp_2_0= ruleExpression ) ) )*
            {
            // InternalOcl.g:1640:3: ( (lv_exp_0_0= ruleExpression ) )
            // InternalOcl.g:1641:4: (lv_exp_0_0= ruleExpression )
            {
            // InternalOcl.g:1641:4: (lv_exp_0_0= ruleExpression )
            // InternalOcl.g:1642:5: lv_exp_0_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getActualParameterListAccess().getExpExpressionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_23);
            lv_exp_0_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getActualParameterListRule());
            					}
            					add(
            						current,
            						"exp",
            						lv_exp_0_0,
            						"org.xtext.ocl.Ocl.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOcl.g:1659:3: (otherlv_1= ',' ( (lv_exp_2_0= ruleExpression ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==34) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalOcl.g:1660:4: otherlv_1= ',' ( (lv_exp_2_0= ruleExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,34,FOLLOW_5); 

            	    				newLeafNode(otherlv_1, grammarAccess.getActualParameterListAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalOcl.g:1664:4: ( (lv_exp_2_0= ruleExpression ) )
            	    // InternalOcl.g:1665:5: (lv_exp_2_0= ruleExpression )
            	    {
            	    // InternalOcl.g:1665:5: (lv_exp_2_0= ruleExpression )
            	    // InternalOcl.g:1666:6: lv_exp_2_0= ruleExpression
            	    {

            	    						newCompositeNode(grammarAccess.getActualParameterListAccess().getExpExpressionParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_23);
            	    lv_exp_2_0=ruleExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getActualParameterListRule());
            	    						}
            	    						add(
            	    							current,
            	    							"exp",
            	    							lv_exp_2_0,
            	    							"org.xtext.ocl.Ocl.Expression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
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
    // $ANTLR end "ruleActualParameterList"


    // $ANTLR start "entryRuleTypeName"
    // InternalOcl.g:1688:1: entryRuleTypeName returns [EObject current=null] : iv_ruleTypeName= ruleTypeName EOF ;
    public final EObject entryRuleTypeName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeName = null;


        try {
            // InternalOcl.g:1688:49: (iv_ruleTypeName= ruleTypeName EOF )
            // InternalOcl.g:1689:2: iv_ruleTypeName= ruleTypeName EOF
            {
             newCompositeNode(grammarAccess.getTypeNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTypeName=ruleTypeName();

            state._fsp--;

             current =iv_ruleTypeName; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleTypeName"


    // $ANTLR start "ruleTypeName"
    // InternalOcl.g:1695:1: ruleTypeName returns [EObject current=null] : ( (lv_name_0_0= RULE_TYPENAME_TERMINAL ) ) ;
    public final EObject ruleTypeName() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalOcl.g:1701:2: ( ( (lv_name_0_0= RULE_TYPENAME_TERMINAL ) ) )
            // InternalOcl.g:1702:2: ( (lv_name_0_0= RULE_TYPENAME_TERMINAL ) )
            {
            // InternalOcl.g:1702:2: ( (lv_name_0_0= RULE_TYPENAME_TERMINAL ) )
            // InternalOcl.g:1703:3: (lv_name_0_0= RULE_TYPENAME_TERMINAL )
            {
            // InternalOcl.g:1703:3: (lv_name_0_0= RULE_TYPENAME_TERMINAL )
            // InternalOcl.g:1704:4: lv_name_0_0= RULE_TYPENAME_TERMINAL
            {
            lv_name_0_0=(Token)match(input,RULE_TYPENAME_TERMINAL,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getTypeNameAccess().getNameTYPENAME_TERMINALTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getTypeNameRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"org.xtext.ocl.Ocl.TYPENAME_TERMINAL");
            			

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
    // $ANTLR end "ruleTypeName"


    // $ANTLR start "entryRuleName"
    // InternalOcl.g:1723:1: entryRuleName returns [EObject current=null] : iv_ruleName= ruleName EOF ;
    public final EObject entryRuleName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleName = null;


        try {
            // InternalOcl.g:1723:45: (iv_ruleName= ruleName EOF )
            // InternalOcl.g:1724:2: iv_ruleName= ruleName EOF
            {
             newCompositeNode(grammarAccess.getNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleName=ruleName();

            state._fsp--;

             current =iv_ruleName; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleName"


    // $ANTLR start "ruleName"
    // InternalOcl.g:1730:1: ruleName returns [EObject current=null] : (this_Attribute_0= ruleAttribute | this_Function_1= ruleFunction ) ;
    public final EObject ruleName() throws RecognitionException {
        EObject current = null;

        EObject this_Attribute_0 = null;

        EObject this_Function_1 = null;



        	enterRule();

        try {
            // InternalOcl.g:1736:2: ( (this_Attribute_0= ruleAttribute | this_Function_1= ruleFunction ) )
            // InternalOcl.g:1737:2: (this_Attribute_0= ruleAttribute | this_Function_1= ruleFunction )
            {
            // InternalOcl.g:1737:2: (this_Attribute_0= ruleAttribute | this_Function_1= ruleFunction )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_NAME_TERMINAL) ) {
                alt29=1;
            }
            else if ( ((LA29_0>=41 && LA29_0<=63)||(LA29_0>=65 && LA29_0<=78)) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // InternalOcl.g:1738:3: this_Attribute_0= ruleAttribute
                    {

                    			newCompositeNode(grammarAccess.getNameAccess().getAttributeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Attribute_0=ruleAttribute();

                    state._fsp--;


                    			current = this_Attribute_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOcl.g:1747:3: this_Function_1= ruleFunction
                    {

                    			newCompositeNode(grammarAccess.getNameAccess().getFunctionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Function_1=ruleFunction();

                    state._fsp--;


                    			current = this_Function_1;
                    			afterParserOrEnumRuleCall();
                    		

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
    // $ANTLR end "ruleName"


    // $ANTLR start "entryRuleAttribute"
    // InternalOcl.g:1759:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalOcl.g:1759:50: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalOcl.g:1760:2: iv_ruleAttribute= ruleAttribute EOF
            {
             newCompositeNode(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalOcl.g:1766:1: ruleAttribute returns [EObject current=null] : ( (lv_name_0_0= RULE_NAME_TERMINAL ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalOcl.g:1772:2: ( ( (lv_name_0_0= RULE_NAME_TERMINAL ) ) )
            // InternalOcl.g:1773:2: ( (lv_name_0_0= RULE_NAME_TERMINAL ) )
            {
            // InternalOcl.g:1773:2: ( (lv_name_0_0= RULE_NAME_TERMINAL ) )
            // InternalOcl.g:1774:3: (lv_name_0_0= RULE_NAME_TERMINAL )
            {
            // InternalOcl.g:1774:3: (lv_name_0_0= RULE_NAME_TERMINAL )
            // InternalOcl.g:1775:4: lv_name_0_0= RULE_NAME_TERMINAL
            {
            lv_name_0_0=(Token)match(input,RULE_NAME_TERMINAL,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getAttributeAccess().getNameNAME_TERMINALTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getAttributeRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"org.xtext.ocl.Ocl.NAME_TERMINAL");
            			

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
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleFunction"
    // InternalOcl.g:1794:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // InternalOcl.g:1794:49: (iv_ruleFunction= ruleFunction EOF )
            // InternalOcl.g:1795:2: iv_ruleFunction= ruleFunction EOF
            {
             newCompositeNode(grammarAccess.getFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFunction=ruleFunction();

            state._fsp--;

             current =iv_ruleFunction; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleFunction"


    // $ANTLR start "ruleFunction"
    // InternalOcl.g:1801:1: ruleFunction returns [EObject current=null] : (this_NoParamFunction_0= ruleNoParamFunction | this_OneTypeParamFunction_1= ruleOneTypeParamFunction | this_OneStringParamFunction_2= ruleOneStringParamFunction | this_TwoStringParamFunction_3= ruleTwoStringParamFunction | this_TwoIntegerParamFunction_4= ruleTwoIntegerParamFunction | this_OneIntegerParamFunction_5= ruleOneIntegerParamFunction ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        EObject this_NoParamFunction_0 = null;

        EObject this_OneTypeParamFunction_1 = null;

        EObject this_OneStringParamFunction_2 = null;

        EObject this_TwoStringParamFunction_3 = null;

        EObject this_TwoIntegerParamFunction_4 = null;

        EObject this_OneIntegerParamFunction_5 = null;



        	enterRule();

        try {
            // InternalOcl.g:1807:2: ( (this_NoParamFunction_0= ruleNoParamFunction | this_OneTypeParamFunction_1= ruleOneTypeParamFunction | this_OneStringParamFunction_2= ruleOneStringParamFunction | this_TwoStringParamFunction_3= ruleTwoStringParamFunction | this_TwoIntegerParamFunction_4= ruleTwoIntegerParamFunction | this_OneIntegerParamFunction_5= ruleOneIntegerParamFunction ) )
            // InternalOcl.g:1808:2: (this_NoParamFunction_0= ruleNoParamFunction | this_OneTypeParamFunction_1= ruleOneTypeParamFunction | this_OneStringParamFunction_2= ruleOneStringParamFunction | this_TwoStringParamFunction_3= ruleTwoStringParamFunction | this_TwoIntegerParamFunction_4= ruleTwoIntegerParamFunction | this_OneIntegerParamFunction_5= ruleOneIntegerParamFunction )
            {
            // InternalOcl.g:1808:2: (this_NoParamFunction_0= ruleNoParamFunction | this_OneTypeParamFunction_1= ruleOneTypeParamFunction | this_OneStringParamFunction_2= ruleOneStringParamFunction | this_TwoStringParamFunction_3= ruleTwoStringParamFunction | this_TwoIntegerParamFunction_4= ruleTwoIntegerParamFunction | this_OneIntegerParamFunction_5= ruleOneIntegerParamFunction )
            int alt30=6;
            switch ( input.LA(1) ) {
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
            case 60:
            case 61:
            case 62:
            case 63:
                {
                alt30=1;
                }
                break;
            case 65:
            case 66:
                {
                alt30=2;
                }
                break;
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
                {
                alt30=3;
                }
                break;
            case 73:
            case 74:
                {
                alt30=4;
                }
                break;
            case 76:
            case 77:
            case 78:
                {
                alt30=5;
                }
                break;
            case 75:
                {
                alt30=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // InternalOcl.g:1809:3: this_NoParamFunction_0= ruleNoParamFunction
                    {

                    			newCompositeNode(grammarAccess.getFunctionAccess().getNoParamFunctionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_NoParamFunction_0=ruleNoParamFunction();

                    state._fsp--;


                    			current = this_NoParamFunction_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOcl.g:1818:3: this_OneTypeParamFunction_1= ruleOneTypeParamFunction
                    {

                    			newCompositeNode(grammarAccess.getFunctionAccess().getOneTypeParamFunctionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_OneTypeParamFunction_1=ruleOneTypeParamFunction();

                    state._fsp--;


                    			current = this_OneTypeParamFunction_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalOcl.g:1827:3: this_OneStringParamFunction_2= ruleOneStringParamFunction
                    {

                    			newCompositeNode(grammarAccess.getFunctionAccess().getOneStringParamFunctionParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_OneStringParamFunction_2=ruleOneStringParamFunction();

                    state._fsp--;


                    			current = this_OneStringParamFunction_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalOcl.g:1836:3: this_TwoStringParamFunction_3= ruleTwoStringParamFunction
                    {

                    			newCompositeNode(grammarAccess.getFunctionAccess().getTwoStringParamFunctionParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_TwoStringParamFunction_3=ruleTwoStringParamFunction();

                    state._fsp--;


                    			current = this_TwoStringParamFunction_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalOcl.g:1845:3: this_TwoIntegerParamFunction_4= ruleTwoIntegerParamFunction
                    {

                    			newCompositeNode(grammarAccess.getFunctionAccess().getTwoIntegerParamFunctionParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_TwoIntegerParamFunction_4=ruleTwoIntegerParamFunction();

                    state._fsp--;


                    			current = this_TwoIntegerParamFunction_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalOcl.g:1854:3: this_OneIntegerParamFunction_5= ruleOneIntegerParamFunction
                    {

                    			newCompositeNode(grammarAccess.getFunctionAccess().getOneIntegerParamFunctionParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_OneIntegerParamFunction_5=ruleOneIntegerParamFunction();

                    state._fsp--;


                    			current = this_OneIntegerParamFunction_5;
                    			afterParserOrEnumRuleCall();
                    		

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
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRuleNoParamFunction"
    // InternalOcl.g:1866:1: entryRuleNoParamFunction returns [EObject current=null] : iv_ruleNoParamFunction= ruleNoParamFunction EOF ;
    public final EObject entryRuleNoParamFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNoParamFunction = null;


        try {
            // InternalOcl.g:1866:56: (iv_ruleNoParamFunction= ruleNoParamFunction EOF )
            // InternalOcl.g:1867:2: iv_ruleNoParamFunction= ruleNoParamFunction EOF
            {
             newCompositeNode(grammarAccess.getNoParamFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNoParamFunction=ruleNoParamFunction();

            state._fsp--;

             current =iv_ruleNoParamFunction; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleNoParamFunction"


    // $ANTLR start "ruleNoParamFunction"
    // InternalOcl.g:1873:1: ruleNoParamFunction returns [EObject current=null] : ( ( ( (lv_name_0_1= 'allInstaces' | lv_name_0_2= 'oclType' | lv_name_0_3= 'toString' | lv_name_0_4= 'refImmediateComposite' | lv_name_0_5= 'size' | lv_name_0_6= 'toInteger' | lv_name_0_7= 'toUpper' | lv_name_0_8= 'toReal' | lv_name_0_9= 'toLower' | lv_name_0_10= 'toSequence' | lv_name_0_11= 'trim' | lv_name_0_12= 'isEmpty' | lv_name_0_13= 'oclIsUndefined' | lv_name_0_14= 'floor' | lv_name_0_15= 'round' | lv_name_0_16= 'notEmpty' | lv_name_0_17= 'asBag' | lv_name_0_18= 'asSequence' | lv_name_0_19= 'sum' | lv_name_0_20= 'asSet' | lv_name_0_21= 'flatten' | lv_name_0_22= 'first' | lv_name_0_23= 'last' ) ) ) otherlv_1= '()' ) ;
    public final EObject ruleNoParamFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token lv_name_0_3=null;
        Token lv_name_0_4=null;
        Token lv_name_0_5=null;
        Token lv_name_0_6=null;
        Token lv_name_0_7=null;
        Token lv_name_0_8=null;
        Token lv_name_0_9=null;
        Token lv_name_0_10=null;
        Token lv_name_0_11=null;
        Token lv_name_0_12=null;
        Token lv_name_0_13=null;
        Token lv_name_0_14=null;
        Token lv_name_0_15=null;
        Token lv_name_0_16=null;
        Token lv_name_0_17=null;
        Token lv_name_0_18=null;
        Token lv_name_0_19=null;
        Token lv_name_0_20=null;
        Token lv_name_0_21=null;
        Token lv_name_0_22=null;
        Token lv_name_0_23=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOcl.g:1879:2: ( ( ( ( (lv_name_0_1= 'allInstaces' | lv_name_0_2= 'oclType' | lv_name_0_3= 'toString' | lv_name_0_4= 'refImmediateComposite' | lv_name_0_5= 'size' | lv_name_0_6= 'toInteger' | lv_name_0_7= 'toUpper' | lv_name_0_8= 'toReal' | lv_name_0_9= 'toLower' | lv_name_0_10= 'toSequence' | lv_name_0_11= 'trim' | lv_name_0_12= 'isEmpty' | lv_name_0_13= 'oclIsUndefined' | lv_name_0_14= 'floor' | lv_name_0_15= 'round' | lv_name_0_16= 'notEmpty' | lv_name_0_17= 'asBag' | lv_name_0_18= 'asSequence' | lv_name_0_19= 'sum' | lv_name_0_20= 'asSet' | lv_name_0_21= 'flatten' | lv_name_0_22= 'first' | lv_name_0_23= 'last' ) ) ) otherlv_1= '()' ) )
            // InternalOcl.g:1880:2: ( ( ( (lv_name_0_1= 'allInstaces' | lv_name_0_2= 'oclType' | lv_name_0_3= 'toString' | lv_name_0_4= 'refImmediateComposite' | lv_name_0_5= 'size' | lv_name_0_6= 'toInteger' | lv_name_0_7= 'toUpper' | lv_name_0_8= 'toReal' | lv_name_0_9= 'toLower' | lv_name_0_10= 'toSequence' | lv_name_0_11= 'trim' | lv_name_0_12= 'isEmpty' | lv_name_0_13= 'oclIsUndefined' | lv_name_0_14= 'floor' | lv_name_0_15= 'round' | lv_name_0_16= 'notEmpty' | lv_name_0_17= 'asBag' | lv_name_0_18= 'asSequence' | lv_name_0_19= 'sum' | lv_name_0_20= 'asSet' | lv_name_0_21= 'flatten' | lv_name_0_22= 'first' | lv_name_0_23= 'last' ) ) ) otherlv_1= '()' )
            {
            // InternalOcl.g:1880:2: ( ( ( (lv_name_0_1= 'allInstaces' | lv_name_0_2= 'oclType' | lv_name_0_3= 'toString' | lv_name_0_4= 'refImmediateComposite' | lv_name_0_5= 'size' | lv_name_0_6= 'toInteger' | lv_name_0_7= 'toUpper' | lv_name_0_8= 'toReal' | lv_name_0_9= 'toLower' | lv_name_0_10= 'toSequence' | lv_name_0_11= 'trim' | lv_name_0_12= 'isEmpty' | lv_name_0_13= 'oclIsUndefined' | lv_name_0_14= 'floor' | lv_name_0_15= 'round' | lv_name_0_16= 'notEmpty' | lv_name_0_17= 'asBag' | lv_name_0_18= 'asSequence' | lv_name_0_19= 'sum' | lv_name_0_20= 'asSet' | lv_name_0_21= 'flatten' | lv_name_0_22= 'first' | lv_name_0_23= 'last' ) ) ) otherlv_1= '()' )
            // InternalOcl.g:1881:3: ( ( (lv_name_0_1= 'allInstaces' | lv_name_0_2= 'oclType' | lv_name_0_3= 'toString' | lv_name_0_4= 'refImmediateComposite' | lv_name_0_5= 'size' | lv_name_0_6= 'toInteger' | lv_name_0_7= 'toUpper' | lv_name_0_8= 'toReal' | lv_name_0_9= 'toLower' | lv_name_0_10= 'toSequence' | lv_name_0_11= 'trim' | lv_name_0_12= 'isEmpty' | lv_name_0_13= 'oclIsUndefined' | lv_name_0_14= 'floor' | lv_name_0_15= 'round' | lv_name_0_16= 'notEmpty' | lv_name_0_17= 'asBag' | lv_name_0_18= 'asSequence' | lv_name_0_19= 'sum' | lv_name_0_20= 'asSet' | lv_name_0_21= 'flatten' | lv_name_0_22= 'first' | lv_name_0_23= 'last' ) ) ) otherlv_1= '()'
            {
            // InternalOcl.g:1881:3: ( ( (lv_name_0_1= 'allInstaces' | lv_name_0_2= 'oclType' | lv_name_0_3= 'toString' | lv_name_0_4= 'refImmediateComposite' | lv_name_0_5= 'size' | lv_name_0_6= 'toInteger' | lv_name_0_7= 'toUpper' | lv_name_0_8= 'toReal' | lv_name_0_9= 'toLower' | lv_name_0_10= 'toSequence' | lv_name_0_11= 'trim' | lv_name_0_12= 'isEmpty' | lv_name_0_13= 'oclIsUndefined' | lv_name_0_14= 'floor' | lv_name_0_15= 'round' | lv_name_0_16= 'notEmpty' | lv_name_0_17= 'asBag' | lv_name_0_18= 'asSequence' | lv_name_0_19= 'sum' | lv_name_0_20= 'asSet' | lv_name_0_21= 'flatten' | lv_name_0_22= 'first' | lv_name_0_23= 'last' ) ) )
            // InternalOcl.g:1882:4: ( (lv_name_0_1= 'allInstaces' | lv_name_0_2= 'oclType' | lv_name_0_3= 'toString' | lv_name_0_4= 'refImmediateComposite' | lv_name_0_5= 'size' | lv_name_0_6= 'toInteger' | lv_name_0_7= 'toUpper' | lv_name_0_8= 'toReal' | lv_name_0_9= 'toLower' | lv_name_0_10= 'toSequence' | lv_name_0_11= 'trim' | lv_name_0_12= 'isEmpty' | lv_name_0_13= 'oclIsUndefined' | lv_name_0_14= 'floor' | lv_name_0_15= 'round' | lv_name_0_16= 'notEmpty' | lv_name_0_17= 'asBag' | lv_name_0_18= 'asSequence' | lv_name_0_19= 'sum' | lv_name_0_20= 'asSet' | lv_name_0_21= 'flatten' | lv_name_0_22= 'first' | lv_name_0_23= 'last' ) )
            {
            // InternalOcl.g:1882:4: ( (lv_name_0_1= 'allInstaces' | lv_name_0_2= 'oclType' | lv_name_0_3= 'toString' | lv_name_0_4= 'refImmediateComposite' | lv_name_0_5= 'size' | lv_name_0_6= 'toInteger' | lv_name_0_7= 'toUpper' | lv_name_0_8= 'toReal' | lv_name_0_9= 'toLower' | lv_name_0_10= 'toSequence' | lv_name_0_11= 'trim' | lv_name_0_12= 'isEmpty' | lv_name_0_13= 'oclIsUndefined' | lv_name_0_14= 'floor' | lv_name_0_15= 'round' | lv_name_0_16= 'notEmpty' | lv_name_0_17= 'asBag' | lv_name_0_18= 'asSequence' | lv_name_0_19= 'sum' | lv_name_0_20= 'asSet' | lv_name_0_21= 'flatten' | lv_name_0_22= 'first' | lv_name_0_23= 'last' ) )
            // InternalOcl.g:1883:5: (lv_name_0_1= 'allInstaces' | lv_name_0_2= 'oclType' | lv_name_0_3= 'toString' | lv_name_0_4= 'refImmediateComposite' | lv_name_0_5= 'size' | lv_name_0_6= 'toInteger' | lv_name_0_7= 'toUpper' | lv_name_0_8= 'toReal' | lv_name_0_9= 'toLower' | lv_name_0_10= 'toSequence' | lv_name_0_11= 'trim' | lv_name_0_12= 'isEmpty' | lv_name_0_13= 'oclIsUndefined' | lv_name_0_14= 'floor' | lv_name_0_15= 'round' | lv_name_0_16= 'notEmpty' | lv_name_0_17= 'asBag' | lv_name_0_18= 'asSequence' | lv_name_0_19= 'sum' | lv_name_0_20= 'asSet' | lv_name_0_21= 'flatten' | lv_name_0_22= 'first' | lv_name_0_23= 'last' )
            {
            // InternalOcl.g:1883:5: (lv_name_0_1= 'allInstaces' | lv_name_0_2= 'oclType' | lv_name_0_3= 'toString' | lv_name_0_4= 'refImmediateComposite' | lv_name_0_5= 'size' | lv_name_0_6= 'toInteger' | lv_name_0_7= 'toUpper' | lv_name_0_8= 'toReal' | lv_name_0_9= 'toLower' | lv_name_0_10= 'toSequence' | lv_name_0_11= 'trim' | lv_name_0_12= 'isEmpty' | lv_name_0_13= 'oclIsUndefined' | lv_name_0_14= 'floor' | lv_name_0_15= 'round' | lv_name_0_16= 'notEmpty' | lv_name_0_17= 'asBag' | lv_name_0_18= 'asSequence' | lv_name_0_19= 'sum' | lv_name_0_20= 'asSet' | lv_name_0_21= 'flatten' | lv_name_0_22= 'first' | lv_name_0_23= 'last' )
            int alt31=23;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt31=1;
                }
                break;
            case 42:
                {
                alt31=2;
                }
                break;
            case 43:
                {
                alt31=3;
                }
                break;
            case 44:
                {
                alt31=4;
                }
                break;
            case 45:
                {
                alt31=5;
                }
                break;
            case 46:
                {
                alt31=6;
                }
                break;
            case 47:
                {
                alt31=7;
                }
                break;
            case 48:
                {
                alt31=8;
                }
                break;
            case 49:
                {
                alt31=9;
                }
                break;
            case 50:
                {
                alt31=10;
                }
                break;
            case 51:
                {
                alt31=11;
                }
                break;
            case 52:
                {
                alt31=12;
                }
                break;
            case 53:
                {
                alt31=13;
                }
                break;
            case 54:
                {
                alt31=14;
                }
                break;
            case 55:
                {
                alt31=15;
                }
                break;
            case 56:
                {
                alt31=16;
                }
                break;
            case 57:
                {
                alt31=17;
                }
                break;
            case 58:
                {
                alt31=18;
                }
                break;
            case 59:
                {
                alt31=19;
                }
                break;
            case 60:
                {
                alt31=20;
                }
                break;
            case 61:
                {
                alt31=21;
                }
                break;
            case 62:
                {
                alt31=22;
                }
                break;
            case 63:
                {
                alt31=23;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // InternalOcl.g:1884:6: lv_name_0_1= 'allInstaces'
                    {
                    lv_name_0_1=(Token)match(input,41,FOLLOW_32); 

                    						newLeafNode(lv_name_0_1, grammarAccess.getNoParamFunctionAccess().getNameAllInstacesKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNoParamFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalOcl.g:1895:6: lv_name_0_2= 'oclType'
                    {
                    lv_name_0_2=(Token)match(input,42,FOLLOW_32); 

                    						newLeafNode(lv_name_0_2, grammarAccess.getNoParamFunctionAccess().getNameOclTypeKeyword_0_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNoParamFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_2, null);
                    					

                    }
                    break;
                case 3 :
                    // InternalOcl.g:1906:6: lv_name_0_3= 'toString'
                    {
                    lv_name_0_3=(Token)match(input,43,FOLLOW_32); 

                    						newLeafNode(lv_name_0_3, grammarAccess.getNoParamFunctionAccess().getNameToStringKeyword_0_0_2());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNoParamFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_3, null);
                    					

                    }
                    break;
                case 4 :
                    // InternalOcl.g:1917:6: lv_name_0_4= 'refImmediateComposite'
                    {
                    lv_name_0_4=(Token)match(input,44,FOLLOW_32); 

                    						newLeafNode(lv_name_0_4, grammarAccess.getNoParamFunctionAccess().getNameRefImmediateCompositeKeyword_0_0_3());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNoParamFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_4, null);
                    					

                    }
                    break;
                case 5 :
                    // InternalOcl.g:1928:6: lv_name_0_5= 'size'
                    {
                    lv_name_0_5=(Token)match(input,45,FOLLOW_32); 

                    						newLeafNode(lv_name_0_5, grammarAccess.getNoParamFunctionAccess().getNameSizeKeyword_0_0_4());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNoParamFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_5, null);
                    					

                    }
                    break;
                case 6 :
                    // InternalOcl.g:1939:6: lv_name_0_6= 'toInteger'
                    {
                    lv_name_0_6=(Token)match(input,46,FOLLOW_32); 

                    						newLeafNode(lv_name_0_6, grammarAccess.getNoParamFunctionAccess().getNameToIntegerKeyword_0_0_5());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNoParamFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_6, null);
                    					

                    }
                    break;
                case 7 :
                    // InternalOcl.g:1950:6: lv_name_0_7= 'toUpper'
                    {
                    lv_name_0_7=(Token)match(input,47,FOLLOW_32); 

                    						newLeafNode(lv_name_0_7, grammarAccess.getNoParamFunctionAccess().getNameToUpperKeyword_0_0_6());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNoParamFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_7, null);
                    					

                    }
                    break;
                case 8 :
                    // InternalOcl.g:1961:6: lv_name_0_8= 'toReal'
                    {
                    lv_name_0_8=(Token)match(input,48,FOLLOW_32); 

                    						newLeafNode(lv_name_0_8, grammarAccess.getNoParamFunctionAccess().getNameToRealKeyword_0_0_7());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNoParamFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_8, null);
                    					

                    }
                    break;
                case 9 :
                    // InternalOcl.g:1972:6: lv_name_0_9= 'toLower'
                    {
                    lv_name_0_9=(Token)match(input,49,FOLLOW_32); 

                    						newLeafNode(lv_name_0_9, grammarAccess.getNoParamFunctionAccess().getNameToLowerKeyword_0_0_8());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNoParamFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_9, null);
                    					

                    }
                    break;
                case 10 :
                    // InternalOcl.g:1983:6: lv_name_0_10= 'toSequence'
                    {
                    lv_name_0_10=(Token)match(input,50,FOLLOW_32); 

                    						newLeafNode(lv_name_0_10, grammarAccess.getNoParamFunctionAccess().getNameToSequenceKeyword_0_0_9());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNoParamFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_10, null);
                    					

                    }
                    break;
                case 11 :
                    // InternalOcl.g:1994:6: lv_name_0_11= 'trim'
                    {
                    lv_name_0_11=(Token)match(input,51,FOLLOW_32); 

                    						newLeafNode(lv_name_0_11, grammarAccess.getNoParamFunctionAccess().getNameTrimKeyword_0_0_10());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNoParamFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_11, null);
                    					

                    }
                    break;
                case 12 :
                    // InternalOcl.g:2005:6: lv_name_0_12= 'isEmpty'
                    {
                    lv_name_0_12=(Token)match(input,52,FOLLOW_32); 

                    						newLeafNode(lv_name_0_12, grammarAccess.getNoParamFunctionAccess().getNameIsEmptyKeyword_0_0_11());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNoParamFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_12, null);
                    					

                    }
                    break;
                case 13 :
                    // InternalOcl.g:2016:6: lv_name_0_13= 'oclIsUndefined'
                    {
                    lv_name_0_13=(Token)match(input,53,FOLLOW_32); 

                    						newLeafNode(lv_name_0_13, grammarAccess.getNoParamFunctionAccess().getNameOclIsUndefinedKeyword_0_0_12());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNoParamFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_13, null);
                    					

                    }
                    break;
                case 14 :
                    // InternalOcl.g:2027:6: lv_name_0_14= 'floor'
                    {
                    lv_name_0_14=(Token)match(input,54,FOLLOW_32); 

                    						newLeafNode(lv_name_0_14, grammarAccess.getNoParamFunctionAccess().getNameFloorKeyword_0_0_13());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNoParamFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_14, null);
                    					

                    }
                    break;
                case 15 :
                    // InternalOcl.g:2038:6: lv_name_0_15= 'round'
                    {
                    lv_name_0_15=(Token)match(input,55,FOLLOW_32); 

                    						newLeafNode(lv_name_0_15, grammarAccess.getNoParamFunctionAccess().getNameRoundKeyword_0_0_14());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNoParamFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_15, null);
                    					

                    }
                    break;
                case 16 :
                    // InternalOcl.g:2049:6: lv_name_0_16= 'notEmpty'
                    {
                    lv_name_0_16=(Token)match(input,56,FOLLOW_32); 

                    						newLeafNode(lv_name_0_16, grammarAccess.getNoParamFunctionAccess().getNameNotEmptyKeyword_0_0_15());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNoParamFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_16, null);
                    					

                    }
                    break;
                case 17 :
                    // InternalOcl.g:2060:6: lv_name_0_17= 'asBag'
                    {
                    lv_name_0_17=(Token)match(input,57,FOLLOW_32); 

                    						newLeafNode(lv_name_0_17, grammarAccess.getNoParamFunctionAccess().getNameAsBagKeyword_0_0_16());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNoParamFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_17, null);
                    					

                    }
                    break;
                case 18 :
                    // InternalOcl.g:2071:6: lv_name_0_18= 'asSequence'
                    {
                    lv_name_0_18=(Token)match(input,58,FOLLOW_32); 

                    						newLeafNode(lv_name_0_18, grammarAccess.getNoParamFunctionAccess().getNameAsSequenceKeyword_0_0_17());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNoParamFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_18, null);
                    					

                    }
                    break;
                case 19 :
                    // InternalOcl.g:2082:6: lv_name_0_19= 'sum'
                    {
                    lv_name_0_19=(Token)match(input,59,FOLLOW_32); 

                    						newLeafNode(lv_name_0_19, grammarAccess.getNoParamFunctionAccess().getNameSumKeyword_0_0_18());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNoParamFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_19, null);
                    					

                    }
                    break;
                case 20 :
                    // InternalOcl.g:2093:6: lv_name_0_20= 'asSet'
                    {
                    lv_name_0_20=(Token)match(input,60,FOLLOW_32); 

                    						newLeafNode(lv_name_0_20, grammarAccess.getNoParamFunctionAccess().getNameAsSetKeyword_0_0_19());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNoParamFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_20, null);
                    					

                    }
                    break;
                case 21 :
                    // InternalOcl.g:2104:6: lv_name_0_21= 'flatten'
                    {
                    lv_name_0_21=(Token)match(input,61,FOLLOW_32); 

                    						newLeafNode(lv_name_0_21, grammarAccess.getNoParamFunctionAccess().getNameFlattenKeyword_0_0_20());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNoParamFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_21, null);
                    					

                    }
                    break;
                case 22 :
                    // InternalOcl.g:2115:6: lv_name_0_22= 'first'
                    {
                    lv_name_0_22=(Token)match(input,62,FOLLOW_32); 

                    						newLeafNode(lv_name_0_22, grammarAccess.getNoParamFunctionAccess().getNameFirstKeyword_0_0_21());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNoParamFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_22, null);
                    					

                    }
                    break;
                case 23 :
                    // InternalOcl.g:2126:6: lv_name_0_23= 'last'
                    {
                    lv_name_0_23=(Token)match(input,63,FOLLOW_32); 

                    						newLeafNode(lv_name_0_23, grammarAccess.getNoParamFunctionAccess().getNameLastKeyword_0_0_22());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNoParamFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_23, null);
                    					

                    }
                    break;

            }


            }


            }

            otherlv_1=(Token)match(input,64,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getNoParamFunctionAccess().getLeftParenthesisRightParenthesisKeyword_1());
            		

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
    // $ANTLR end "ruleNoParamFunction"


    // $ANTLR start "entryRuleOneTypeParamFunction"
    // InternalOcl.g:2147:1: entryRuleOneTypeParamFunction returns [EObject current=null] : iv_ruleOneTypeParamFunction= ruleOneTypeParamFunction EOF ;
    public final EObject entryRuleOneTypeParamFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOneTypeParamFunction = null;


        try {
            // InternalOcl.g:2147:61: (iv_ruleOneTypeParamFunction= ruleOneTypeParamFunction EOF )
            // InternalOcl.g:2148:2: iv_ruleOneTypeParamFunction= ruleOneTypeParamFunction EOF
            {
             newCompositeNode(grammarAccess.getOneTypeParamFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOneTypeParamFunction=ruleOneTypeParamFunction();

            state._fsp--;

             current =iv_ruleOneTypeParamFunction; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleOneTypeParamFunction"


    // $ANTLR start "ruleOneTypeParamFunction"
    // InternalOcl.g:2154:1: ruleOneTypeParamFunction returns [EObject current=null] : ( ( ( (lv_name_0_1= 'oclTypeOf' | lv_name_0_2= 'oclisKindOf' ) ) ) otherlv_1= '(' this_TYPENAME_TERMINAL_2= RULE_TYPENAME_TERMINAL otherlv_3= ')' ) ;
    public final EObject ruleOneTypeParamFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token otherlv_1=null;
        Token this_TYPENAME_TERMINAL_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalOcl.g:2160:2: ( ( ( ( (lv_name_0_1= 'oclTypeOf' | lv_name_0_2= 'oclisKindOf' ) ) ) otherlv_1= '(' this_TYPENAME_TERMINAL_2= RULE_TYPENAME_TERMINAL otherlv_3= ')' ) )
            // InternalOcl.g:2161:2: ( ( ( (lv_name_0_1= 'oclTypeOf' | lv_name_0_2= 'oclisKindOf' ) ) ) otherlv_1= '(' this_TYPENAME_TERMINAL_2= RULE_TYPENAME_TERMINAL otherlv_3= ')' )
            {
            // InternalOcl.g:2161:2: ( ( ( (lv_name_0_1= 'oclTypeOf' | lv_name_0_2= 'oclisKindOf' ) ) ) otherlv_1= '(' this_TYPENAME_TERMINAL_2= RULE_TYPENAME_TERMINAL otherlv_3= ')' )
            // InternalOcl.g:2162:3: ( ( (lv_name_0_1= 'oclTypeOf' | lv_name_0_2= 'oclisKindOf' ) ) ) otherlv_1= '(' this_TYPENAME_TERMINAL_2= RULE_TYPENAME_TERMINAL otherlv_3= ')'
            {
            // InternalOcl.g:2162:3: ( ( (lv_name_0_1= 'oclTypeOf' | lv_name_0_2= 'oclisKindOf' ) ) )
            // InternalOcl.g:2163:4: ( (lv_name_0_1= 'oclTypeOf' | lv_name_0_2= 'oclisKindOf' ) )
            {
            // InternalOcl.g:2163:4: ( (lv_name_0_1= 'oclTypeOf' | lv_name_0_2= 'oclisKindOf' ) )
            // InternalOcl.g:2164:5: (lv_name_0_1= 'oclTypeOf' | lv_name_0_2= 'oclisKindOf' )
            {
            // InternalOcl.g:2164:5: (lv_name_0_1= 'oclTypeOf' | lv_name_0_2= 'oclisKindOf' )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==65) ) {
                alt32=1;
            }
            else if ( (LA32_0==66) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // InternalOcl.g:2165:6: lv_name_0_1= 'oclTypeOf'
                    {
                    lv_name_0_1=(Token)match(input,65,FOLLOW_33); 

                    						newLeafNode(lv_name_0_1, grammarAccess.getOneTypeParamFunctionAccess().getNameOclTypeOfKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOneTypeParamFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalOcl.g:2176:6: lv_name_0_2= 'oclisKindOf'
                    {
                    lv_name_0_2=(Token)match(input,66,FOLLOW_33); 

                    						newLeafNode(lv_name_0_2, grammarAccess.getOneTypeParamFunctionAccess().getNameOclisKindOfKeyword_0_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOneTypeParamFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_2, null);
                    					

                    }
                    break;

            }


            }


            }

            otherlv_1=(Token)match(input,25,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getOneTypeParamFunctionAccess().getLeftParenthesisKeyword_1());
            		
            this_TYPENAME_TERMINAL_2=(Token)match(input,RULE_TYPENAME_TERMINAL,FOLLOW_12); 

            			newLeafNode(this_TYPENAME_TERMINAL_2, grammarAccess.getOneTypeParamFunctionAccess().getTYPENAME_TERMINALTerminalRuleCall_2());
            		
            otherlv_3=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getOneTypeParamFunctionAccess().getRightParenthesisKeyword_3());
            		

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
    // $ANTLR end "ruleOneTypeParamFunction"


    // $ANTLR start "entryRuleOneStringParamFunction"
    // InternalOcl.g:2205:1: entryRuleOneStringParamFunction returns [EObject current=null] : iv_ruleOneStringParamFunction= ruleOneStringParamFunction EOF ;
    public final EObject entryRuleOneStringParamFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOneStringParamFunction = null;


        try {
            // InternalOcl.g:2205:63: (iv_ruleOneStringParamFunction= ruleOneStringParamFunction EOF )
            // InternalOcl.g:2206:2: iv_ruleOneStringParamFunction= ruleOneStringParamFunction EOF
            {
             newCompositeNode(grammarAccess.getOneStringParamFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOneStringParamFunction=ruleOneStringParamFunction();

            state._fsp--;

             current =iv_ruleOneStringParamFunction; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleOneStringParamFunction"


    // $ANTLR start "ruleOneStringParamFunction"
    // InternalOcl.g:2212:1: ruleOneStringParamFunction returns [EObject current=null] : ( ( ( (lv_name_0_1= 'concat' | lv_name_0_2= 'startsWith' | lv_name_0_3= 'endsWith' | lv_name_0_4= 'indexOf' | lv_name_0_5= 'lastIndexOf' | lv_name_0_6= 'split' ) ) ) otherlv_1= '(' this_STRING_2= RULE_STRING otherlv_3= ')' ) ;
    public final EObject ruleOneStringParamFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token lv_name_0_3=null;
        Token lv_name_0_4=null;
        Token lv_name_0_5=null;
        Token lv_name_0_6=null;
        Token otherlv_1=null;
        Token this_STRING_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalOcl.g:2218:2: ( ( ( ( (lv_name_0_1= 'concat' | lv_name_0_2= 'startsWith' | lv_name_0_3= 'endsWith' | lv_name_0_4= 'indexOf' | lv_name_0_5= 'lastIndexOf' | lv_name_0_6= 'split' ) ) ) otherlv_1= '(' this_STRING_2= RULE_STRING otherlv_3= ')' ) )
            // InternalOcl.g:2219:2: ( ( ( (lv_name_0_1= 'concat' | lv_name_0_2= 'startsWith' | lv_name_0_3= 'endsWith' | lv_name_0_4= 'indexOf' | lv_name_0_5= 'lastIndexOf' | lv_name_0_6= 'split' ) ) ) otherlv_1= '(' this_STRING_2= RULE_STRING otherlv_3= ')' )
            {
            // InternalOcl.g:2219:2: ( ( ( (lv_name_0_1= 'concat' | lv_name_0_2= 'startsWith' | lv_name_0_3= 'endsWith' | lv_name_0_4= 'indexOf' | lv_name_0_5= 'lastIndexOf' | lv_name_0_6= 'split' ) ) ) otherlv_1= '(' this_STRING_2= RULE_STRING otherlv_3= ')' )
            // InternalOcl.g:2220:3: ( ( (lv_name_0_1= 'concat' | lv_name_0_2= 'startsWith' | lv_name_0_3= 'endsWith' | lv_name_0_4= 'indexOf' | lv_name_0_5= 'lastIndexOf' | lv_name_0_6= 'split' ) ) ) otherlv_1= '(' this_STRING_2= RULE_STRING otherlv_3= ')'
            {
            // InternalOcl.g:2220:3: ( ( (lv_name_0_1= 'concat' | lv_name_0_2= 'startsWith' | lv_name_0_3= 'endsWith' | lv_name_0_4= 'indexOf' | lv_name_0_5= 'lastIndexOf' | lv_name_0_6= 'split' ) ) )
            // InternalOcl.g:2221:4: ( (lv_name_0_1= 'concat' | lv_name_0_2= 'startsWith' | lv_name_0_3= 'endsWith' | lv_name_0_4= 'indexOf' | lv_name_0_5= 'lastIndexOf' | lv_name_0_6= 'split' ) )
            {
            // InternalOcl.g:2221:4: ( (lv_name_0_1= 'concat' | lv_name_0_2= 'startsWith' | lv_name_0_3= 'endsWith' | lv_name_0_4= 'indexOf' | lv_name_0_5= 'lastIndexOf' | lv_name_0_6= 'split' ) )
            // InternalOcl.g:2222:5: (lv_name_0_1= 'concat' | lv_name_0_2= 'startsWith' | lv_name_0_3= 'endsWith' | lv_name_0_4= 'indexOf' | lv_name_0_5= 'lastIndexOf' | lv_name_0_6= 'split' )
            {
            // InternalOcl.g:2222:5: (lv_name_0_1= 'concat' | lv_name_0_2= 'startsWith' | lv_name_0_3= 'endsWith' | lv_name_0_4= 'indexOf' | lv_name_0_5= 'lastIndexOf' | lv_name_0_6= 'split' )
            int alt33=6;
            switch ( input.LA(1) ) {
            case 67:
                {
                alt33=1;
                }
                break;
            case 68:
                {
                alt33=2;
                }
                break;
            case 69:
                {
                alt33=3;
                }
                break;
            case 70:
                {
                alt33=4;
                }
                break;
            case 71:
                {
                alt33=5;
                }
                break;
            case 72:
                {
                alt33=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // InternalOcl.g:2223:6: lv_name_0_1= 'concat'
                    {
                    lv_name_0_1=(Token)match(input,67,FOLLOW_33); 

                    						newLeafNode(lv_name_0_1, grammarAccess.getOneStringParamFunctionAccess().getNameConcatKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOneStringParamFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalOcl.g:2234:6: lv_name_0_2= 'startsWith'
                    {
                    lv_name_0_2=(Token)match(input,68,FOLLOW_33); 

                    						newLeafNode(lv_name_0_2, grammarAccess.getOneStringParamFunctionAccess().getNameStartsWithKeyword_0_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOneStringParamFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_2, null);
                    					

                    }
                    break;
                case 3 :
                    // InternalOcl.g:2245:6: lv_name_0_3= 'endsWith'
                    {
                    lv_name_0_3=(Token)match(input,69,FOLLOW_33); 

                    						newLeafNode(lv_name_0_3, grammarAccess.getOneStringParamFunctionAccess().getNameEndsWithKeyword_0_0_2());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOneStringParamFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_3, null);
                    					

                    }
                    break;
                case 4 :
                    // InternalOcl.g:2256:6: lv_name_0_4= 'indexOf'
                    {
                    lv_name_0_4=(Token)match(input,70,FOLLOW_33); 

                    						newLeafNode(lv_name_0_4, grammarAccess.getOneStringParamFunctionAccess().getNameIndexOfKeyword_0_0_3());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOneStringParamFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_4, null);
                    					

                    }
                    break;
                case 5 :
                    // InternalOcl.g:2267:6: lv_name_0_5= 'lastIndexOf'
                    {
                    lv_name_0_5=(Token)match(input,71,FOLLOW_33); 

                    						newLeafNode(lv_name_0_5, grammarAccess.getOneStringParamFunctionAccess().getNameLastIndexOfKeyword_0_0_4());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOneStringParamFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_5, null);
                    					

                    }
                    break;
                case 6 :
                    // InternalOcl.g:2278:6: lv_name_0_6= 'split'
                    {
                    lv_name_0_6=(Token)match(input,72,FOLLOW_33); 

                    						newLeafNode(lv_name_0_6, grammarAccess.getOneStringParamFunctionAccess().getNameSplitKeyword_0_0_5());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOneStringParamFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_6, null);
                    					

                    }
                    break;

            }


            }


            }

            otherlv_1=(Token)match(input,25,FOLLOW_34); 

            			newLeafNode(otherlv_1, grammarAccess.getOneStringParamFunctionAccess().getLeftParenthesisKeyword_1());
            		
            this_STRING_2=(Token)match(input,RULE_STRING,FOLLOW_12); 

            			newLeafNode(this_STRING_2, grammarAccess.getOneStringParamFunctionAccess().getSTRINGTerminalRuleCall_2());
            		
            otherlv_3=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getOneStringParamFunctionAccess().getRightParenthesisKeyword_3());
            		

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
    // $ANTLR end "ruleOneStringParamFunction"


    // $ANTLR start "entryRuleTwoStringParamFunction"
    // InternalOcl.g:2307:1: entryRuleTwoStringParamFunction returns [EObject current=null] : iv_ruleTwoStringParamFunction= ruleTwoStringParamFunction EOF ;
    public final EObject entryRuleTwoStringParamFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTwoStringParamFunction = null;


        try {
            // InternalOcl.g:2307:63: (iv_ruleTwoStringParamFunction= ruleTwoStringParamFunction EOF )
            // InternalOcl.g:2308:2: iv_ruleTwoStringParamFunction= ruleTwoStringParamFunction EOF
            {
             newCompositeNode(grammarAccess.getTwoStringParamFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTwoStringParamFunction=ruleTwoStringParamFunction();

            state._fsp--;

             current =iv_ruleTwoStringParamFunction; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleTwoStringParamFunction"


    // $ANTLR start "ruleTwoStringParamFunction"
    // InternalOcl.g:2314:1: ruleTwoStringParamFunction returns [EObject current=null] : ( ( ( (lv_name_0_1= 'replaceAll' | lv_name_0_2= 'regexReplaceAll' ) ) ) otherlv_1= '(' this_STRING_2= RULE_STRING otherlv_3= ',' this_STRING_4= RULE_STRING otherlv_5= ')' ) ;
    public final EObject ruleTwoStringParamFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token otherlv_1=null;
        Token this_STRING_2=null;
        Token otherlv_3=null;
        Token this_STRING_4=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalOcl.g:2320:2: ( ( ( ( (lv_name_0_1= 'replaceAll' | lv_name_0_2= 'regexReplaceAll' ) ) ) otherlv_1= '(' this_STRING_2= RULE_STRING otherlv_3= ',' this_STRING_4= RULE_STRING otherlv_5= ')' ) )
            // InternalOcl.g:2321:2: ( ( ( (lv_name_0_1= 'replaceAll' | lv_name_0_2= 'regexReplaceAll' ) ) ) otherlv_1= '(' this_STRING_2= RULE_STRING otherlv_3= ',' this_STRING_4= RULE_STRING otherlv_5= ')' )
            {
            // InternalOcl.g:2321:2: ( ( ( (lv_name_0_1= 'replaceAll' | lv_name_0_2= 'regexReplaceAll' ) ) ) otherlv_1= '(' this_STRING_2= RULE_STRING otherlv_3= ',' this_STRING_4= RULE_STRING otherlv_5= ')' )
            // InternalOcl.g:2322:3: ( ( (lv_name_0_1= 'replaceAll' | lv_name_0_2= 'regexReplaceAll' ) ) ) otherlv_1= '(' this_STRING_2= RULE_STRING otherlv_3= ',' this_STRING_4= RULE_STRING otherlv_5= ')'
            {
            // InternalOcl.g:2322:3: ( ( (lv_name_0_1= 'replaceAll' | lv_name_0_2= 'regexReplaceAll' ) ) )
            // InternalOcl.g:2323:4: ( (lv_name_0_1= 'replaceAll' | lv_name_0_2= 'regexReplaceAll' ) )
            {
            // InternalOcl.g:2323:4: ( (lv_name_0_1= 'replaceAll' | lv_name_0_2= 'regexReplaceAll' ) )
            // InternalOcl.g:2324:5: (lv_name_0_1= 'replaceAll' | lv_name_0_2= 'regexReplaceAll' )
            {
            // InternalOcl.g:2324:5: (lv_name_0_1= 'replaceAll' | lv_name_0_2= 'regexReplaceAll' )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==73) ) {
                alt34=1;
            }
            else if ( (LA34_0==74) ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // InternalOcl.g:2325:6: lv_name_0_1= 'replaceAll'
                    {
                    lv_name_0_1=(Token)match(input,73,FOLLOW_33); 

                    						newLeafNode(lv_name_0_1, grammarAccess.getTwoStringParamFunctionAccess().getNameReplaceAllKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTwoStringParamFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalOcl.g:2336:6: lv_name_0_2= 'regexReplaceAll'
                    {
                    lv_name_0_2=(Token)match(input,74,FOLLOW_33); 

                    						newLeafNode(lv_name_0_2, grammarAccess.getTwoStringParamFunctionAccess().getNameRegexReplaceAllKeyword_0_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTwoStringParamFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_2, null);
                    					

                    }
                    break;

            }


            }


            }

            otherlv_1=(Token)match(input,25,FOLLOW_34); 

            			newLeafNode(otherlv_1, grammarAccess.getTwoStringParamFunctionAccess().getLeftParenthesisKeyword_1());
            		
            this_STRING_2=(Token)match(input,RULE_STRING,FOLLOW_35); 

            			newLeafNode(this_STRING_2, grammarAccess.getTwoStringParamFunctionAccess().getSTRINGTerminalRuleCall_2());
            		
            otherlv_3=(Token)match(input,34,FOLLOW_34); 

            			newLeafNode(otherlv_3, grammarAccess.getTwoStringParamFunctionAccess().getCommaKeyword_3());
            		
            this_STRING_4=(Token)match(input,RULE_STRING,FOLLOW_12); 

            			newLeafNode(this_STRING_4, grammarAccess.getTwoStringParamFunctionAccess().getSTRINGTerminalRuleCall_4());
            		
            otherlv_5=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getTwoStringParamFunctionAccess().getRightParenthesisKeyword_5());
            		

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
    // $ANTLR end "ruleTwoStringParamFunction"


    // $ANTLR start "entryRuleOneIntegerParamFunction"
    // InternalOcl.g:2373:1: entryRuleOneIntegerParamFunction returns [EObject current=null] : iv_ruleOneIntegerParamFunction= ruleOneIntegerParamFunction EOF ;
    public final EObject entryRuleOneIntegerParamFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOneIntegerParamFunction = null;


        try {
            // InternalOcl.g:2373:64: (iv_ruleOneIntegerParamFunction= ruleOneIntegerParamFunction EOF )
            // InternalOcl.g:2374:2: iv_ruleOneIntegerParamFunction= ruleOneIntegerParamFunction EOF
            {
             newCompositeNode(grammarAccess.getOneIntegerParamFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOneIntegerParamFunction=ruleOneIntegerParamFunction();

            state._fsp--;

             current =iv_ruleOneIntegerParamFunction; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleOneIntegerParamFunction"


    // $ANTLR start "ruleOneIntegerParamFunction"
    // InternalOcl.g:2380:1: ruleOneIntegerParamFunction returns [EObject current=null] : ( ( (lv_name_0_0= 'at' ) ) otherlv_1= '(' this_NUMBER_2= RULE_NUMBER otherlv_3= ')' ) ;
    public final EObject ruleOneIntegerParamFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token this_NUMBER_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalOcl.g:2386:2: ( ( ( (lv_name_0_0= 'at' ) ) otherlv_1= '(' this_NUMBER_2= RULE_NUMBER otherlv_3= ')' ) )
            // InternalOcl.g:2387:2: ( ( (lv_name_0_0= 'at' ) ) otherlv_1= '(' this_NUMBER_2= RULE_NUMBER otherlv_3= ')' )
            {
            // InternalOcl.g:2387:2: ( ( (lv_name_0_0= 'at' ) ) otherlv_1= '(' this_NUMBER_2= RULE_NUMBER otherlv_3= ')' )
            // InternalOcl.g:2388:3: ( (lv_name_0_0= 'at' ) ) otherlv_1= '(' this_NUMBER_2= RULE_NUMBER otherlv_3= ')'
            {
            // InternalOcl.g:2388:3: ( (lv_name_0_0= 'at' ) )
            // InternalOcl.g:2389:4: (lv_name_0_0= 'at' )
            {
            // InternalOcl.g:2389:4: (lv_name_0_0= 'at' )
            // InternalOcl.g:2390:5: lv_name_0_0= 'at'
            {
            lv_name_0_0=(Token)match(input,75,FOLLOW_33); 

            					newLeafNode(lv_name_0_0, grammarAccess.getOneIntegerParamFunctionAccess().getNameAtKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOneIntegerParamFunctionRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "at");
            				

            }


            }

            otherlv_1=(Token)match(input,25,FOLLOW_36); 

            			newLeafNode(otherlv_1, grammarAccess.getOneIntegerParamFunctionAccess().getLeftParenthesisKeyword_1());
            		
            this_NUMBER_2=(Token)match(input,RULE_NUMBER,FOLLOW_12); 

            			newLeafNode(this_NUMBER_2, grammarAccess.getOneIntegerParamFunctionAccess().getNUMBERTerminalRuleCall_2());
            		
            otherlv_3=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getOneIntegerParamFunctionAccess().getRightParenthesisKeyword_3());
            		

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
    // $ANTLR end "ruleOneIntegerParamFunction"


    // $ANTLR start "entryRuleTwoIntegerParamFunction"
    // InternalOcl.g:2418:1: entryRuleTwoIntegerParamFunction returns [EObject current=null] : iv_ruleTwoIntegerParamFunction= ruleTwoIntegerParamFunction EOF ;
    public final EObject entryRuleTwoIntegerParamFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTwoIntegerParamFunction = null;


        try {
            // InternalOcl.g:2418:64: (iv_ruleTwoIntegerParamFunction= ruleTwoIntegerParamFunction EOF )
            // InternalOcl.g:2419:2: iv_ruleTwoIntegerParamFunction= ruleTwoIntegerParamFunction EOF
            {
             newCompositeNode(grammarAccess.getTwoIntegerParamFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTwoIntegerParamFunction=ruleTwoIntegerParamFunction();

            state._fsp--;

             current =iv_ruleTwoIntegerParamFunction; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleTwoIntegerParamFunction"


    // $ANTLR start "ruleTwoIntegerParamFunction"
    // InternalOcl.g:2425:1: ruleTwoIntegerParamFunction returns [EObject current=null] : ( ( ( (lv_name_0_1= 'substring' | lv_name_0_2= 'subSequence' | lv_name_0_3= 'subOrderedSet' ) ) ) otherlv_1= '(' this_NUMBER_2= RULE_NUMBER otherlv_3= ',' this_NUMBER_4= RULE_NUMBER otherlv_5= ')' ) ;
    public final EObject ruleTwoIntegerParamFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token lv_name_0_3=null;
        Token otherlv_1=null;
        Token this_NUMBER_2=null;
        Token otherlv_3=null;
        Token this_NUMBER_4=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalOcl.g:2431:2: ( ( ( ( (lv_name_0_1= 'substring' | lv_name_0_2= 'subSequence' | lv_name_0_3= 'subOrderedSet' ) ) ) otherlv_1= '(' this_NUMBER_2= RULE_NUMBER otherlv_3= ',' this_NUMBER_4= RULE_NUMBER otherlv_5= ')' ) )
            // InternalOcl.g:2432:2: ( ( ( (lv_name_0_1= 'substring' | lv_name_0_2= 'subSequence' | lv_name_0_3= 'subOrderedSet' ) ) ) otherlv_1= '(' this_NUMBER_2= RULE_NUMBER otherlv_3= ',' this_NUMBER_4= RULE_NUMBER otherlv_5= ')' )
            {
            // InternalOcl.g:2432:2: ( ( ( (lv_name_0_1= 'substring' | lv_name_0_2= 'subSequence' | lv_name_0_3= 'subOrderedSet' ) ) ) otherlv_1= '(' this_NUMBER_2= RULE_NUMBER otherlv_3= ',' this_NUMBER_4= RULE_NUMBER otherlv_5= ')' )
            // InternalOcl.g:2433:3: ( ( (lv_name_0_1= 'substring' | lv_name_0_2= 'subSequence' | lv_name_0_3= 'subOrderedSet' ) ) ) otherlv_1= '(' this_NUMBER_2= RULE_NUMBER otherlv_3= ',' this_NUMBER_4= RULE_NUMBER otherlv_5= ')'
            {
            // InternalOcl.g:2433:3: ( ( (lv_name_0_1= 'substring' | lv_name_0_2= 'subSequence' | lv_name_0_3= 'subOrderedSet' ) ) )
            // InternalOcl.g:2434:4: ( (lv_name_0_1= 'substring' | lv_name_0_2= 'subSequence' | lv_name_0_3= 'subOrderedSet' ) )
            {
            // InternalOcl.g:2434:4: ( (lv_name_0_1= 'substring' | lv_name_0_2= 'subSequence' | lv_name_0_3= 'subOrderedSet' ) )
            // InternalOcl.g:2435:5: (lv_name_0_1= 'substring' | lv_name_0_2= 'subSequence' | lv_name_0_3= 'subOrderedSet' )
            {
            // InternalOcl.g:2435:5: (lv_name_0_1= 'substring' | lv_name_0_2= 'subSequence' | lv_name_0_3= 'subOrderedSet' )
            int alt35=3;
            switch ( input.LA(1) ) {
            case 76:
                {
                alt35=1;
                }
                break;
            case 77:
                {
                alt35=2;
                }
                break;
            case 78:
                {
                alt35=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // InternalOcl.g:2436:6: lv_name_0_1= 'substring'
                    {
                    lv_name_0_1=(Token)match(input,76,FOLLOW_33); 

                    						newLeafNode(lv_name_0_1, grammarAccess.getTwoIntegerParamFunctionAccess().getNameSubstringKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTwoIntegerParamFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalOcl.g:2447:6: lv_name_0_2= 'subSequence'
                    {
                    lv_name_0_2=(Token)match(input,77,FOLLOW_33); 

                    						newLeafNode(lv_name_0_2, grammarAccess.getTwoIntegerParamFunctionAccess().getNameSubSequenceKeyword_0_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTwoIntegerParamFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_2, null);
                    					

                    }
                    break;
                case 3 :
                    // InternalOcl.g:2458:6: lv_name_0_3= 'subOrderedSet'
                    {
                    lv_name_0_3=(Token)match(input,78,FOLLOW_33); 

                    						newLeafNode(lv_name_0_3, grammarAccess.getTwoIntegerParamFunctionAccess().getNameSubOrderedSetKeyword_0_0_2());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTwoIntegerParamFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_3, null);
                    					

                    }
                    break;

            }


            }


            }

            otherlv_1=(Token)match(input,25,FOLLOW_36); 

            			newLeafNode(otherlv_1, grammarAccess.getTwoIntegerParamFunctionAccess().getLeftParenthesisKeyword_1());
            		
            this_NUMBER_2=(Token)match(input,RULE_NUMBER,FOLLOW_35); 

            			newLeafNode(this_NUMBER_2, grammarAccess.getTwoIntegerParamFunctionAccess().getNUMBERTerminalRuleCall_2());
            		
            otherlv_3=(Token)match(input,34,FOLLOW_36); 

            			newLeafNode(otherlv_3, grammarAccess.getTwoIntegerParamFunctionAccess().getCommaKeyword_3());
            		
            this_NUMBER_4=(Token)match(input,RULE_NUMBER,FOLLOW_12); 

            			newLeafNode(this_NUMBER_4, grammarAccess.getTwoIntegerParamFunctionAccess().getNUMBERTerminalRuleCall_4());
            		
            otherlv_5=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getTwoIntegerParamFunctionAccess().getRightParenthesisKeyword_5());
            		

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
    // $ANTLR end "ruleTwoIntegerParamFunction"


    // $ANTLR start "entryRuleCollectionKind"
    // InternalOcl.g:2495:1: entryRuleCollectionKind returns [EObject current=null] : iv_ruleCollectionKind= ruleCollectionKind EOF ;
    public final EObject entryRuleCollectionKind() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionKind = null;


        try {
            // InternalOcl.g:2495:55: (iv_ruleCollectionKind= ruleCollectionKind EOF )
            // InternalOcl.g:2496:2: iv_ruleCollectionKind= ruleCollectionKind EOF
            {
             newCompositeNode(grammarAccess.getCollectionKindRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCollectionKind=ruleCollectionKind();

            state._fsp--;

             current =iv_ruleCollectionKind; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleCollectionKind"


    // $ANTLR start "ruleCollectionKind"
    // InternalOcl.g:2502:1: ruleCollectionKind returns [EObject current=null] : ( ( (lv_name_0_1= 'Set' | lv_name_0_2= 'Bag' | lv_name_0_3= 'Sequence' | lv_name_0_4= 'Collection' ) ) ) ;
    public final EObject ruleCollectionKind() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token lv_name_0_3=null;
        Token lv_name_0_4=null;


        	enterRule();

        try {
            // InternalOcl.g:2508:2: ( ( ( (lv_name_0_1= 'Set' | lv_name_0_2= 'Bag' | lv_name_0_3= 'Sequence' | lv_name_0_4= 'Collection' ) ) ) )
            // InternalOcl.g:2509:2: ( ( (lv_name_0_1= 'Set' | lv_name_0_2= 'Bag' | lv_name_0_3= 'Sequence' | lv_name_0_4= 'Collection' ) ) )
            {
            // InternalOcl.g:2509:2: ( ( (lv_name_0_1= 'Set' | lv_name_0_2= 'Bag' | lv_name_0_3= 'Sequence' | lv_name_0_4= 'Collection' ) ) )
            // InternalOcl.g:2510:3: ( (lv_name_0_1= 'Set' | lv_name_0_2= 'Bag' | lv_name_0_3= 'Sequence' | lv_name_0_4= 'Collection' ) )
            {
            // InternalOcl.g:2510:3: ( (lv_name_0_1= 'Set' | lv_name_0_2= 'Bag' | lv_name_0_3= 'Sequence' | lv_name_0_4= 'Collection' ) )
            // InternalOcl.g:2511:4: (lv_name_0_1= 'Set' | lv_name_0_2= 'Bag' | lv_name_0_3= 'Sequence' | lv_name_0_4= 'Collection' )
            {
            // InternalOcl.g:2511:4: (lv_name_0_1= 'Set' | lv_name_0_2= 'Bag' | lv_name_0_3= 'Sequence' | lv_name_0_4= 'Collection' )
            int alt36=4;
            switch ( input.LA(1) ) {
            case 79:
                {
                alt36=1;
                }
                break;
            case 80:
                {
                alt36=2;
                }
                break;
            case 81:
                {
                alt36=3;
                }
                break;
            case 82:
                {
                alt36=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // InternalOcl.g:2512:5: lv_name_0_1= 'Set'
                    {
                    lv_name_0_1=(Token)match(input,79,FOLLOW_2); 

                    					newLeafNode(lv_name_0_1, grammarAccess.getCollectionKindAccess().getNameSetKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getCollectionKindRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalOcl.g:2523:5: lv_name_0_2= 'Bag'
                    {
                    lv_name_0_2=(Token)match(input,80,FOLLOW_2); 

                    					newLeafNode(lv_name_0_2, grammarAccess.getCollectionKindAccess().getNameBagKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getCollectionKindRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalOcl.g:2534:5: lv_name_0_3= 'Sequence'
                    {
                    lv_name_0_3=(Token)match(input,81,FOLLOW_2); 

                    					newLeafNode(lv_name_0_3, grammarAccess.getCollectionKindAccess().getNameSequenceKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getCollectionKindRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_3, null);
                    				

                    }
                    break;
                case 4 :
                    // InternalOcl.g:2545:5: lv_name_0_4= 'Collection'
                    {
                    lv_name_0_4=(Token)match(input,82,FOLLOW_2); 

                    					newLeafNode(lv_name_0_4, grammarAccess.getCollectionKindAccess().getNameCollectionKeyword_0_3());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getCollectionKindRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_4, null);
                    				

                    }
                    break;

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
    // $ANTLR end "ruleCollectionKind"


    // $ANTLR start "entryRuleNavigationOperator"
    // InternalOcl.g:2561:1: entryRuleNavigationOperator returns [EObject current=null] : iv_ruleNavigationOperator= ruleNavigationOperator EOF ;
    public final EObject entryRuleNavigationOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigationOperator = null;


        try {
            // InternalOcl.g:2561:59: (iv_ruleNavigationOperator= ruleNavigationOperator EOF )
            // InternalOcl.g:2562:2: iv_ruleNavigationOperator= ruleNavigationOperator EOF
            {
             newCompositeNode(grammarAccess.getNavigationOperatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNavigationOperator=ruleNavigationOperator();

            state._fsp--;

             current =iv_ruleNavigationOperator; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleNavigationOperator"


    // $ANTLR start "ruleNavigationOperator"
    // InternalOcl.g:2568:1: ruleNavigationOperator returns [EObject current=null] : ( ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) ) ) ;
    public final EObject ruleNavigationOperator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;


        	enterRule();

        try {
            // InternalOcl.g:2574:2: ( ( ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) ) ) )
            // InternalOcl.g:2575:2: ( ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) ) )
            {
            // InternalOcl.g:2575:2: ( ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) ) )
            // InternalOcl.g:2576:3: ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) )
            {
            // InternalOcl.g:2576:3: ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) )
            // InternalOcl.g:2577:4: (lv_name_0_1= '.' | lv_name_0_2= '->' )
            {
            // InternalOcl.g:2577:4: (lv_name_0_1= '.' | lv_name_0_2= '->' )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==83) ) {
                alt37=1;
            }
            else if ( (LA37_0==84) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // InternalOcl.g:2578:5: lv_name_0_1= '.'
                    {
                    lv_name_0_1=(Token)match(input,83,FOLLOW_2); 

                    					newLeafNode(lv_name_0_1, grammarAccess.getNavigationOperatorAccess().getNameFullStopKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getNavigationOperatorRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalOcl.g:2589:5: lv_name_0_2= '->'
                    {
                    lv_name_0_2=(Token)match(input,84,FOLLOW_2); 

                    					newLeafNode(lv_name_0_2, grammarAccess.getNavigationOperatorAccess().getNameHyphenMinusGreaterThanSignKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getNavigationOperatorRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_2, null);
                    				

                    }
                    break;

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
    // $ANTLR end "ruleNavigationOperator"


    // $ANTLR start "entryRuleUnaryOperator"
    // InternalOcl.g:2605:1: entryRuleUnaryOperator returns [EObject current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final EObject entryRuleUnaryOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryOperator = null;


        try {
            // InternalOcl.g:2605:54: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // InternalOcl.g:2606:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
            {
             newCompositeNode(grammarAccess.getUnaryOperatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnaryOperator=ruleUnaryOperator();

            state._fsp--;

             current =iv_ruleUnaryOperator; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleUnaryOperator"


    // $ANTLR start "ruleUnaryOperator"
    // InternalOcl.g:2612:1: ruleUnaryOperator returns [EObject current=null] : ( ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) ) ) ;
    public final EObject ruleUnaryOperator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;


        	enterRule();

        try {
            // InternalOcl.g:2618:2: ( ( ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) ) ) )
            // InternalOcl.g:2619:2: ( ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) ) )
            {
            // InternalOcl.g:2619:2: ( ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) ) )
            // InternalOcl.g:2620:3: ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) )
            {
            // InternalOcl.g:2620:3: ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) )
            // InternalOcl.g:2621:4: (lv_name_0_1= '-' | lv_name_0_2= 'not' )
            {
            // InternalOcl.g:2621:4: (lv_name_0_1= '-' | lv_name_0_2= 'not' )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==85) ) {
                alt38=1;
            }
            else if ( (LA38_0==86) ) {
                alt38=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // InternalOcl.g:2622:5: lv_name_0_1= '-'
                    {
                    lv_name_0_1=(Token)match(input,85,FOLLOW_2); 

                    					newLeafNode(lv_name_0_1, grammarAccess.getUnaryOperatorAccess().getNameHyphenMinusKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getUnaryOperatorRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalOcl.g:2633:5: lv_name_0_2= 'not'
                    {
                    lv_name_0_2=(Token)match(input,86,FOLLOW_2); 

                    					newLeafNode(lv_name_0_2, grammarAccess.getUnaryOperatorAccess().getNameNotKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getUnaryOperatorRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_2, null);
                    				

                    }
                    break;

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
    // $ANTLR end "ruleUnaryOperator"


    // $ANTLR start "entryRuleMultiplyOperator"
    // InternalOcl.g:2649:1: entryRuleMultiplyOperator returns [EObject current=null] : iv_ruleMultiplyOperator= ruleMultiplyOperator EOF ;
    public final EObject entryRuleMultiplyOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplyOperator = null;


        try {
            // InternalOcl.g:2649:57: (iv_ruleMultiplyOperator= ruleMultiplyOperator EOF )
            // InternalOcl.g:2650:2: iv_ruleMultiplyOperator= ruleMultiplyOperator EOF
            {
             newCompositeNode(grammarAccess.getMultiplyOperatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMultiplyOperator=ruleMultiplyOperator();

            state._fsp--;

             current =iv_ruleMultiplyOperator; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleMultiplyOperator"


    // $ANTLR start "ruleMultiplyOperator"
    // InternalOcl.g:2656:1: ruleMultiplyOperator returns [EObject current=null] : ( ( (lv_name_0_1= '*' | lv_name_0_2= '/' ) ) ) ;
    public final EObject ruleMultiplyOperator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;


        	enterRule();

        try {
            // InternalOcl.g:2662:2: ( ( ( (lv_name_0_1= '*' | lv_name_0_2= '/' ) ) ) )
            // InternalOcl.g:2663:2: ( ( (lv_name_0_1= '*' | lv_name_0_2= '/' ) ) )
            {
            // InternalOcl.g:2663:2: ( ( (lv_name_0_1= '*' | lv_name_0_2= '/' ) ) )
            // InternalOcl.g:2664:3: ( (lv_name_0_1= '*' | lv_name_0_2= '/' ) )
            {
            // InternalOcl.g:2664:3: ( (lv_name_0_1= '*' | lv_name_0_2= '/' ) )
            // InternalOcl.g:2665:4: (lv_name_0_1= '*' | lv_name_0_2= '/' )
            {
            // InternalOcl.g:2665:4: (lv_name_0_1= '*' | lv_name_0_2= '/' )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==87) ) {
                alt39=1;
            }
            else if ( (LA39_0==88) ) {
                alt39=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // InternalOcl.g:2666:5: lv_name_0_1= '*'
                    {
                    lv_name_0_1=(Token)match(input,87,FOLLOW_2); 

                    					newLeafNode(lv_name_0_1, grammarAccess.getMultiplyOperatorAccess().getNameAsteriskKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMultiplyOperatorRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalOcl.g:2677:5: lv_name_0_2= '/'
                    {
                    lv_name_0_2=(Token)match(input,88,FOLLOW_2); 

                    					newLeafNode(lv_name_0_2, grammarAccess.getMultiplyOperatorAccess().getNameSolidusKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMultiplyOperatorRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_2, null);
                    				

                    }
                    break;

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
    // $ANTLR end "ruleMultiplyOperator"


    // $ANTLR start "entryRuleAddOperator"
    // InternalOcl.g:2693:1: entryRuleAddOperator returns [EObject current=null] : iv_ruleAddOperator= ruleAddOperator EOF ;
    public final EObject entryRuleAddOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddOperator = null;


        try {
            // InternalOcl.g:2693:52: (iv_ruleAddOperator= ruleAddOperator EOF )
            // InternalOcl.g:2694:2: iv_ruleAddOperator= ruleAddOperator EOF
            {
             newCompositeNode(grammarAccess.getAddOperatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAddOperator=ruleAddOperator();

            state._fsp--;

             current =iv_ruleAddOperator; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleAddOperator"


    // $ANTLR start "ruleAddOperator"
    // InternalOcl.g:2700:1: ruleAddOperator returns [EObject current=null] : ( ( (lv_name_0_1= '+' | lv_name_0_2= '-' ) ) ) ;
    public final EObject ruleAddOperator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;


        	enterRule();

        try {
            // InternalOcl.g:2706:2: ( ( ( (lv_name_0_1= '+' | lv_name_0_2= '-' ) ) ) )
            // InternalOcl.g:2707:2: ( ( (lv_name_0_1= '+' | lv_name_0_2= '-' ) ) )
            {
            // InternalOcl.g:2707:2: ( ( (lv_name_0_1= '+' | lv_name_0_2= '-' ) ) )
            // InternalOcl.g:2708:3: ( (lv_name_0_1= '+' | lv_name_0_2= '-' ) )
            {
            // InternalOcl.g:2708:3: ( (lv_name_0_1= '+' | lv_name_0_2= '-' ) )
            // InternalOcl.g:2709:4: (lv_name_0_1= '+' | lv_name_0_2= '-' )
            {
            // InternalOcl.g:2709:4: (lv_name_0_1= '+' | lv_name_0_2= '-' )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==89) ) {
                alt40=1;
            }
            else if ( (LA40_0==85) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // InternalOcl.g:2710:5: lv_name_0_1= '+'
                    {
                    lv_name_0_1=(Token)match(input,89,FOLLOW_2); 

                    					newLeafNode(lv_name_0_1, grammarAccess.getAddOperatorAccess().getNamePlusSignKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAddOperatorRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalOcl.g:2721:5: lv_name_0_2= '-'
                    {
                    lv_name_0_2=(Token)match(input,85,FOLLOW_2); 

                    					newLeafNode(lv_name_0_2, grammarAccess.getAddOperatorAccess().getNameHyphenMinusKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAddOperatorRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_2, null);
                    				

                    }
                    break;

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
    // $ANTLR end "ruleAddOperator"


    // $ANTLR start "entryRuleRelationalOperator"
    // InternalOcl.g:2737:1: entryRuleRelationalOperator returns [EObject current=null] : iv_ruleRelationalOperator= ruleRelationalOperator EOF ;
    public final EObject entryRuleRelationalOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalOperator = null;


        try {
            // InternalOcl.g:2737:59: (iv_ruleRelationalOperator= ruleRelationalOperator EOF )
            // InternalOcl.g:2738:2: iv_ruleRelationalOperator= ruleRelationalOperator EOF
            {
             newCompositeNode(grammarAccess.getRelationalOperatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRelationalOperator=ruleRelationalOperator();

            state._fsp--;

             current =iv_ruleRelationalOperator; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleRelationalOperator"


    // $ANTLR start "ruleRelationalOperator"
    // InternalOcl.g:2744:1: ruleRelationalOperator returns [EObject current=null] : ( ( (lv_name_0_1= '=' | lv_name_0_2= '>' | lv_name_0_3= '<' | lv_name_0_4= '>=' | lv_name_0_5= '<=' | lv_name_0_6= '<>' ) ) ) ;
    public final EObject ruleRelationalOperator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token lv_name_0_3=null;
        Token lv_name_0_4=null;
        Token lv_name_0_5=null;
        Token lv_name_0_6=null;


        	enterRule();

        try {
            // InternalOcl.g:2750:2: ( ( ( (lv_name_0_1= '=' | lv_name_0_2= '>' | lv_name_0_3= '<' | lv_name_0_4= '>=' | lv_name_0_5= '<=' | lv_name_0_6= '<>' ) ) ) )
            // InternalOcl.g:2751:2: ( ( (lv_name_0_1= '=' | lv_name_0_2= '>' | lv_name_0_3= '<' | lv_name_0_4= '>=' | lv_name_0_5= '<=' | lv_name_0_6= '<>' ) ) )
            {
            // InternalOcl.g:2751:2: ( ( (lv_name_0_1= '=' | lv_name_0_2= '>' | lv_name_0_3= '<' | lv_name_0_4= '>=' | lv_name_0_5= '<=' | lv_name_0_6= '<>' ) ) )
            // InternalOcl.g:2752:3: ( (lv_name_0_1= '=' | lv_name_0_2= '>' | lv_name_0_3= '<' | lv_name_0_4= '>=' | lv_name_0_5= '<=' | lv_name_0_6= '<>' ) )
            {
            // InternalOcl.g:2752:3: ( (lv_name_0_1= '=' | lv_name_0_2= '>' | lv_name_0_3= '<' | lv_name_0_4= '>=' | lv_name_0_5= '<=' | lv_name_0_6= '<>' ) )
            // InternalOcl.g:2753:4: (lv_name_0_1= '=' | lv_name_0_2= '>' | lv_name_0_3= '<' | lv_name_0_4= '>=' | lv_name_0_5= '<=' | lv_name_0_6= '<>' )
            {
            // InternalOcl.g:2753:4: (lv_name_0_1= '=' | lv_name_0_2= '>' | lv_name_0_3= '<' | lv_name_0_4= '>=' | lv_name_0_5= '<=' | lv_name_0_6= '<>' )
            int alt41=6;
            switch ( input.LA(1) ) {
            case 90:
                {
                alt41=1;
                }
                break;
            case 91:
                {
                alt41=2;
                }
                break;
            case 92:
                {
                alt41=3;
                }
                break;
            case 93:
                {
                alt41=4;
                }
                break;
            case 94:
                {
                alt41=5;
                }
                break;
            case 95:
                {
                alt41=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // InternalOcl.g:2754:5: lv_name_0_1= '='
                    {
                    lv_name_0_1=(Token)match(input,90,FOLLOW_2); 

                    					newLeafNode(lv_name_0_1, grammarAccess.getRelationalOperatorAccess().getNameEqualsSignKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getRelationalOperatorRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalOcl.g:2765:5: lv_name_0_2= '>'
                    {
                    lv_name_0_2=(Token)match(input,91,FOLLOW_2); 

                    					newLeafNode(lv_name_0_2, grammarAccess.getRelationalOperatorAccess().getNameGreaterThanSignKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getRelationalOperatorRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalOcl.g:2776:5: lv_name_0_3= '<'
                    {
                    lv_name_0_3=(Token)match(input,92,FOLLOW_2); 

                    					newLeafNode(lv_name_0_3, grammarAccess.getRelationalOperatorAccess().getNameLessThanSignKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getRelationalOperatorRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_3, null);
                    				

                    }
                    break;
                case 4 :
                    // InternalOcl.g:2787:5: lv_name_0_4= '>='
                    {
                    lv_name_0_4=(Token)match(input,93,FOLLOW_2); 

                    					newLeafNode(lv_name_0_4, grammarAccess.getRelationalOperatorAccess().getNameGreaterThanSignEqualsSignKeyword_0_3());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getRelationalOperatorRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_4, null);
                    				

                    }
                    break;
                case 5 :
                    // InternalOcl.g:2798:5: lv_name_0_5= '<='
                    {
                    lv_name_0_5=(Token)match(input,94,FOLLOW_2); 

                    					newLeafNode(lv_name_0_5, grammarAccess.getRelationalOperatorAccess().getNameLessThanSignEqualsSignKeyword_0_4());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getRelationalOperatorRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_5, null);
                    				

                    }
                    break;
                case 6 :
                    // InternalOcl.g:2809:5: lv_name_0_6= '<>'
                    {
                    lv_name_0_6=(Token)match(input,95,FOLLOW_2); 

                    					newLeafNode(lv_name_0_6, grammarAccess.getRelationalOperatorAccess().getNameLessThanSignGreaterThanSignKeyword_0_5());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getRelationalOperatorRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_6, null);
                    				

                    }
                    break;

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
    // $ANTLR end "ruleRelationalOperator"


    // $ANTLR start "entryRuleLogicalOperator"
    // InternalOcl.g:2825:1: entryRuleLogicalOperator returns [EObject current=null] : iv_ruleLogicalOperator= ruleLogicalOperator EOF ;
    public final EObject entryRuleLogicalOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOperator = null;


        try {
            // InternalOcl.g:2825:56: (iv_ruleLogicalOperator= ruleLogicalOperator EOF )
            // InternalOcl.g:2826:2: iv_ruleLogicalOperator= ruleLogicalOperator EOF
            {
             newCompositeNode(grammarAccess.getLogicalOperatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLogicalOperator=ruleLogicalOperator();

            state._fsp--;

             current =iv_ruleLogicalOperator; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleLogicalOperator"


    // $ANTLR start "ruleLogicalOperator"
    // InternalOcl.g:2832:1: ruleLogicalOperator returns [EObject current=null] : ( ( (lv_name_0_1= 'and' | lv_name_0_2= 'or' | lv_name_0_3= 'xor' | lv_name_0_4= 'implies' ) ) ) ;
    public final EObject ruleLogicalOperator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token lv_name_0_3=null;
        Token lv_name_0_4=null;


        	enterRule();

        try {
            // InternalOcl.g:2838:2: ( ( ( (lv_name_0_1= 'and' | lv_name_0_2= 'or' | lv_name_0_3= 'xor' | lv_name_0_4= 'implies' ) ) ) )
            // InternalOcl.g:2839:2: ( ( (lv_name_0_1= 'and' | lv_name_0_2= 'or' | lv_name_0_3= 'xor' | lv_name_0_4= 'implies' ) ) )
            {
            // InternalOcl.g:2839:2: ( ( (lv_name_0_1= 'and' | lv_name_0_2= 'or' | lv_name_0_3= 'xor' | lv_name_0_4= 'implies' ) ) )
            // InternalOcl.g:2840:3: ( (lv_name_0_1= 'and' | lv_name_0_2= 'or' | lv_name_0_3= 'xor' | lv_name_0_4= 'implies' ) )
            {
            // InternalOcl.g:2840:3: ( (lv_name_0_1= 'and' | lv_name_0_2= 'or' | lv_name_0_3= 'xor' | lv_name_0_4= 'implies' ) )
            // InternalOcl.g:2841:4: (lv_name_0_1= 'and' | lv_name_0_2= 'or' | lv_name_0_3= 'xor' | lv_name_0_4= 'implies' )
            {
            // InternalOcl.g:2841:4: (lv_name_0_1= 'and' | lv_name_0_2= 'or' | lv_name_0_3= 'xor' | lv_name_0_4= 'implies' )
            int alt42=4;
            switch ( input.LA(1) ) {
            case 96:
                {
                alt42=1;
                }
                break;
            case 97:
                {
                alt42=2;
                }
                break;
            case 98:
                {
                alt42=3;
                }
                break;
            case 99:
                {
                alt42=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // InternalOcl.g:2842:5: lv_name_0_1= 'and'
                    {
                    lv_name_0_1=(Token)match(input,96,FOLLOW_2); 

                    					newLeafNode(lv_name_0_1, grammarAccess.getLogicalOperatorAccess().getNameAndKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getLogicalOperatorRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalOcl.g:2853:5: lv_name_0_2= 'or'
                    {
                    lv_name_0_2=(Token)match(input,97,FOLLOW_2); 

                    					newLeafNode(lv_name_0_2, grammarAccess.getLogicalOperatorAccess().getNameOrKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getLogicalOperatorRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalOcl.g:2864:5: lv_name_0_3= 'xor'
                    {
                    lv_name_0_3=(Token)match(input,98,FOLLOW_2); 

                    					newLeafNode(lv_name_0_3, grammarAccess.getLogicalOperatorAccess().getNameXorKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getLogicalOperatorRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_3, null);
                    				

                    }
                    break;
                case 4 :
                    // InternalOcl.g:2875:5: lv_name_0_4= 'implies'
                    {
                    lv_name_0_4=(Token)match(input,99,FOLLOW_2); 

                    					newLeafNode(lv_name_0_4, grammarAccess.getLogicalOperatorAccess().getNameImpliesKeyword_0_3());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getLogicalOperatorRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_4, null);
                    				

                    }
                    break;

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
    // $ANTLR end "ruleLogicalOperator"

    // Delegated rules


    protected DFA12 dfa12 = new DFA12(this);
    static final String dfa_1s = "\170\uffff";
    static final String dfa_2s = "\1\4\1\10\27\100\16\31\1\uffff\1\4\1\uffff\1\10\1\4\2\5\2\6\1\10\27\100\16\31\2\32\2\42\1\32\1\10\1\4\2\5\2\6\2\10\1\5\1\6\1\10\2\32\2\42\3\32\2\10\1\5\1\6\3\10\2\32\2\10";
    static final String dfa_3s = "\1\126\1\143\27\100\16\31\1\uffff\1\126\1\uffff\1\143\1\4\2\5\2\6\1\143\27\100\16\31\2\32\2\42\1\32\1\143\1\4\2\5\2\6\2\143\1\5\1\6\1\143\2\32\2\42\3\32\2\143\1\5\1\6\3\143\2\32\2\143";
    static final String dfa_4s = "\47\uffff\1\2\1\uffff\1\1\116\uffff";
    static final String dfa_5s = "\170\uffff}>";
    static final String[] dfa_6s = {
            "\3\47\1\1\21\uffff\1\47\1\uffff\1\47\3\uffff\1\47\11\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\uffff\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\46\1\43\1\44\1\45\4\47\2\uffff\2\47",
            "\1\51\1\47\17\uffff\2\47\7\uffff\1\50\2\uffff\1\47\1\uffff\1\51\1\47\52\uffff\3\47\1\uffff\15\47",
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
            "\3\47\1\60\21\uffff\1\47\1\uffff\1\47\3\uffff\1\47\11\uffff\1\61\1\62\1\63\1\64\1\65\1\66\1\67\1\70\1\71\1\72\1\73\1\74\1\75\1\76\1\77\1\100\1\101\1\102\1\103\1\104\1\105\1\106\1\107\1\uffff\1\110\1\111\1\112\1\113\1\114\1\115\1\116\1\117\1\120\1\121\1\125\1\122\1\123\1\124\4\47\2\uffff\2\47",
            "",
            "\1\51\1\47\17\uffff\2\47\7\uffff\1\50\2\uffff\1\47\1\uffff\1\51\1\47\52\uffff\3\47\1\uffff\15\47",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\51\1\47\17\uffff\2\47\7\uffff\1\50\2\uffff\1\47\1\uffff\1\51\1\47\52\uffff\3\47\1\uffff\15\47",
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
            "\1\51\1\47\17\uffff\2\47\7\uffff\1\50\2\uffff\1\47\1\uffff\1\51\1\47\52\uffff\3\47\1\uffff\15\47",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\51\1\47\17\uffff\2\47\7\uffff\1\50\2\uffff\1\47\1\uffff\1\51\1\47\52\uffff\3\47\1\uffff\15\47",
            "\1\51\1\47\17\uffff\2\47\7\uffff\1\50\2\uffff\1\47\1\uffff\1\51\1\47\52\uffff\3\47\1\uffff\15\47",
            "\1\153",
            "\1\154",
            "\1\51\1\47\17\uffff\2\47\7\uffff\1\50\2\uffff\1\47\1\uffff\1\51\1\47\52\uffff\3\47\1\uffff\15\47",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\51\1\47\17\uffff\2\47\7\uffff\1\50\2\uffff\1\47\1\uffff\1\51\1\47\52\uffff\3\47\1\uffff\15\47",
            "\1\51\1\47\17\uffff\2\47\7\uffff\1\50\2\uffff\1\47\1\uffff\1\51\1\47\52\uffff\3\47\1\uffff\15\47",
            "\1\164",
            "\1\165",
            "\1\51\1\47\17\uffff\2\47\7\uffff\1\50\2\uffff\1\47\1\uffff\1\51\1\47\52\uffff\3\47\1\uffff\15\47",
            "\1\51\1\47\17\uffff\2\47\7\uffff\1\50\2\uffff\1\47\1\uffff\1\51\1\47\52\uffff\3\47\1\uffff\15\47",
            "\1\51\1\47\17\uffff\2\47\7\uffff\1\50\2\uffff\1\47\1\uffff\1\51\1\47\52\uffff\3\47\1\uffff\15\47",
            "\1\166",
            "\1\167",
            "\1\51\1\47\17\uffff\2\47\7\uffff\1\50\2\uffff\1\47\1\uffff\1\51\1\47\52\uffff\3\47\1\uffff\15\47",
            "\1\51\1\47\17\uffff\2\47\7\uffff\1\50\2\uffff\1\47\1\uffff\1\51\1\47\52\uffff\3\47\1\uffff\15\47"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "800:3: ( (lv_decs_1_0= ruleDeclarator ) )?";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000001C00000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0xFFFFFE008A0000F0L,0x000000000067FFFEL});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000002L,0x0000000F00000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000002L,0x00000000FC000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000002L,0x0000000002200000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000002L,0x0000000001800000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000002L,0x0000000000180000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0xFFFFFE0000000090L,0x0000000000007FFEL});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0xFFFFFE088A0000F0L,0x000000000067FFFEL});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000001400000002L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000012002000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000002002000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000008400000100L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000100000010L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000040L});

}