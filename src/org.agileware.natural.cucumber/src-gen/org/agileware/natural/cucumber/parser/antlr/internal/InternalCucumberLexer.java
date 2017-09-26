package org.agileware.natural.cucumber.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalCucumberLexer extends Lexer {
    public static final int RULE_DOC_STRING=7;
    public static final int RULE_WORD=8;
    public static final int RULE_STRING=10;
    public static final int RULE_SL_COMMENT=14;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int EOF=-1;
    public static final int RULE_EOL=4;
    public static final int RULE_WS=15;
    public static final int RULE_TAGNAME=12;
    public static final int RULE_PLACEHOLDER=11;
    public static final int RULE_TABLE_ROW=6;
    public static final int RULE_INT=9;
    public static final int RULE_STEP_KEYWORD=5;
    public static final int RULE_NL=13;
    public static final int T__20=20;

    // delegates
    // delegators

    public InternalCucumberLexer() {;} 
    public InternalCucumberLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalCucumberLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalCucumber.g"; }

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCucumber.g:11:7: ( 'Feature:' )
            // InternalCucumber.g:11:9: 'Feature:'
            {
            match("Feature:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCucumber.g:12:7: ( 'Background:' )
            // InternalCucumber.g:12:9: 'Background:'
            {
            match("Background:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCucumber.g:13:7: ( 'Scenario:' )
            // InternalCucumber.g:13:9: 'Scenario:'
            {
            match("Scenario:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCucumber.g:14:7: ( 'Scenario Outline:' )
            // InternalCucumber.g:14:9: 'Scenario Outline:'
            {
            match("Scenario Outline:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCucumber.g:15:7: ( 'Examples:' )
            // InternalCucumber.g:15:9: 'Examples:'
            {
            match("Examples:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCucumber.g:1092:10: ( ( '-' )? ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )? )
            // InternalCucumber.g:1092:12: ( '-' )? ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )?
            {
            // InternalCucumber.g:1092:12: ( '-' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='-') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalCucumber.g:1092:12: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // InternalCucumber.g:1092:17: ( '0' .. '9' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalCucumber.g:1092:18: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            // InternalCucumber.g:1092:29: ( '.' ( '0' .. '9' )+ )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='.') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalCucumber.g:1092:30: '.' ( '0' .. '9' )+
                    {
                    match('.'); 
                    // InternalCucumber.g:1092:34: ( '0' .. '9' )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalCucumber.g:1092:35: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt3 >= 1 ) break loop3;
                                EarlyExitException eee =
                                    new EarlyExitException(3, input);
                                throw eee;
                        }
                        cnt3++;
                    } while (true);


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STEP_KEYWORD"
    public final void mRULE_STEP_KEYWORD() throws RecognitionException {
        try {
            int _type = RULE_STEP_KEYWORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCucumber.g:1094:19: ( ( 'Stas' | 'Given' | 'When' | 'Then' | 'And' | 'But' ) ( ' ' | '\\t' )+ )
            // InternalCucumber.g:1094:21: ( 'Stas' | 'Given' | 'When' | 'Then' | 'And' | 'But' ) ( ' ' | '\\t' )+
            {
            // InternalCucumber.g:1094:21: ( 'Stas' | 'Given' | 'When' | 'Then' | 'And' | 'But' )
            int alt5=6;
            switch ( input.LA(1) ) {
            case 'S':
                {
                alt5=1;
                }
                break;
            case 'G':
                {
                alt5=2;
                }
                break;
            case 'W':
                {
                alt5=3;
                }
                break;
            case 'T':
                {
                alt5=4;
                }
                break;
            case 'A':
                {
                alt5=5;
                }
                break;
            case 'B':
                {
                alt5=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalCucumber.g:1094:22: 'Stas'
                    {
                    match("Stas"); 


                    }
                    break;
                case 2 :
                    // InternalCucumber.g:1094:29: 'Given'
                    {
                    match("Given"); 


                    }
                    break;
                case 3 :
                    // InternalCucumber.g:1094:37: 'When'
                    {
                    match("When"); 


                    }
                    break;
                case 4 :
                    // InternalCucumber.g:1094:44: 'Then'
                    {
                    match("Then"); 


                    }
                    break;
                case 5 :
                    // InternalCucumber.g:1094:51: 'And'
                    {
                    match("And"); 


                    }
                    break;
                case 6 :
                    // InternalCucumber.g:1094:57: 'But'
                    {
                    match("But"); 


                    }
                    break;

            }

            // InternalCucumber.g:1094:64: ( ' ' | '\\t' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='\t'||LA6_0==' ') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalCucumber.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STEP_KEYWORD"

    // $ANTLR start "RULE_PLACEHOLDER"
    public final void mRULE_PLACEHOLDER() throws RecognitionException {
        try {
            int _type = RULE_PLACEHOLDER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCucumber.g:1096:18: ( '<' (~ ( ( '>' | ' ' | '\\t' | '\\n' | '\\r' ) ) )+ '>' )
            // InternalCucumber.g:1096:20: '<' (~ ( ( '>' | ' ' | '\\t' | '\\n' | '\\r' ) ) )+ '>'
            {
            match('<'); 
            // InternalCucumber.g:1096:24: (~ ( ( '>' | ' ' | '\\t' | '\\n' | '\\r' ) ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\u0000' && LA7_0<='\b')||(LA7_0>='\u000B' && LA7_0<='\f')||(LA7_0>='\u000E' && LA7_0<='\u001F')||(LA7_0>='!' && LA7_0<='=')||(LA7_0>='?' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalCucumber.g:1096:24: ~ ( ( '>' | ' ' | '\\t' | '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||(input.LA(1)>='!' && input.LA(1)<='=')||(input.LA(1)>='?' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_PLACEHOLDER"

    // $ANTLR start "RULE_TABLE_ROW"
    public final void mRULE_TABLE_ROW() throws RecognitionException {
        try {
            int _type = RULE_TABLE_ROW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCucumber.g:1098:16: ( '|' ( (~ ( ( '|' | '\\n' | '\\r' ) ) )* '|' )+ ( ' ' | '\\t' )* RULE_NL )
            // InternalCucumber.g:1098:18: '|' ( (~ ( ( '|' | '\\n' | '\\r' ) ) )* '|' )+ ( ' ' | '\\t' )* RULE_NL
            {
            match('|'); 
            // InternalCucumber.g:1098:22: ( (~ ( ( '|' | '\\n' | '\\r' ) ) )* '|' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                alt9 = dfa9.predict(input);
                switch (alt9) {
            	case 1 :
            	    // InternalCucumber.g:1098:23: (~ ( ( '|' | '\\n' | '\\r' ) ) )* '|'
            	    {
            	    // InternalCucumber.g:1098:23: (~ ( ( '|' | '\\n' | '\\r' ) ) )*
            	    loop8:
            	    do {
            	        int alt8=2;
            	        int LA8_0 = input.LA(1);

            	        if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='{')||(LA8_0>='}' && LA8_0<='\uFFFF')) ) {
            	            alt8=1;
            	        }


            	        switch (alt8) {
            	    	case 1 :
            	    	    // InternalCucumber.g:1098:23: ~ ( ( '|' | '\\n' | '\\r' ) )
            	    	    {
            	    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='{')||(input.LA(1)>='}' && input.LA(1)<='\uFFFF') ) {
            	    	        input.consume();

            	    	    }
            	    	    else {
            	    	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	    	        recover(mse);
            	    	        throw mse;}


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop8;
            	        }
            	    } while (true);

            	    match('|'); 

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);

            // InternalCucumber.g:1098:49: ( ' ' | '\\t' )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='\t'||LA10_0==' ') ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalCucumber.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            mRULE_NL(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_TABLE_ROW"

    // $ANTLR start "RULE_DOC_STRING"
    public final void mRULE_DOC_STRING() throws RecognitionException {
        try {
            int _type = RULE_DOC_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCucumber.g:1100:17: ( ( '\"\"\"' ( options {greedy=false; } : . )* '\"\"\"' | '\\'\\'\\'' ( options {greedy=false; } : . )* '\\'\\'\\'' ) RULE_NL )
            // InternalCucumber.g:1100:19: ( '\"\"\"' ( options {greedy=false; } : . )* '\"\"\"' | '\\'\\'\\'' ( options {greedy=false; } : . )* '\\'\\'\\'' ) RULE_NL
            {
            // InternalCucumber.g:1100:19: ( '\"\"\"' ( options {greedy=false; } : . )* '\"\"\"' | '\\'\\'\\'' ( options {greedy=false; } : . )* '\\'\\'\\'' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='\"') ) {
                alt13=1;
            }
            else if ( (LA13_0=='\'') ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalCucumber.g:1100:20: '\"\"\"' ( options {greedy=false; } : . )* '\"\"\"'
                    {
                    match("\"\"\""); 

                    // InternalCucumber.g:1100:26: ( options {greedy=false; } : . )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0=='\"') ) {
                            int LA11_1 = input.LA(2);

                            if ( (LA11_1=='\"') ) {
                                int LA11_3 = input.LA(3);

                                if ( (LA11_3=='\"') ) {
                                    alt11=2;
                                }
                                else if ( ((LA11_3>='\u0000' && LA11_3<='!')||(LA11_3>='#' && LA11_3<='\uFFFF')) ) {
                                    alt11=1;
                                }


                            }
                            else if ( ((LA11_1>='\u0000' && LA11_1<='!')||(LA11_1>='#' && LA11_1<='\uFFFF')) ) {
                                alt11=1;
                            }


                        }
                        else if ( ((LA11_0>='\u0000' && LA11_0<='!')||(LA11_0>='#' && LA11_0<='\uFFFF')) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalCucumber.g:1100:54: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    match("\"\"\""); 


                    }
                    break;
                case 2 :
                    // InternalCucumber.g:1100:64: '\\'\\'\\'' ( options {greedy=false; } : . )* '\\'\\'\\''
                    {
                    match("'''"); 

                    // InternalCucumber.g:1100:73: ( options {greedy=false; } : . )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0=='\'') ) {
                            int LA12_1 = input.LA(2);

                            if ( (LA12_1=='\'') ) {
                                int LA12_3 = input.LA(3);

                                if ( (LA12_3=='\'') ) {
                                    alt12=2;
                                }
                                else if ( ((LA12_3>='\u0000' && LA12_3<='&')||(LA12_3>='(' && LA12_3<='\uFFFF')) ) {
                                    alt12=1;
                                }


                            }
                            else if ( ((LA12_1>='\u0000' && LA12_1<='&')||(LA12_1>='(' && LA12_1<='\uFFFF')) ) {
                                alt12=1;
                            }


                        }
                        else if ( ((LA12_0>='\u0000' && LA12_0<='&')||(LA12_0>='(' && LA12_0<='\uFFFF')) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalCucumber.g:1100:101: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    match("'''"); 


                    }
                    break;

            }

            mRULE_NL(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DOC_STRING"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCucumber.g:1102:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' | '\\r' | '\\n' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' | '\\r' | '\\n' ) ) )* '\\'' ) )
            // InternalCucumber.g:1102:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' | '\\r' | '\\n' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' | '\\r' | '\\n' ) ) )* '\\'' )
            {
            // InternalCucumber.g:1102:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' | '\\r' | '\\n' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' | '\\r' | '\\n' ) ) )* '\\'' )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='\"') ) {
                alt16=1;
            }
            else if ( (LA16_0=='\'') ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalCucumber.g:1102:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' | '\\r' | '\\n' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalCucumber.g:1102:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' | '\\r' | '\\n' ) ) )*
                    loop14:
                    do {
                        int alt14=3;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0=='\\') ) {
                            alt14=1;
                        }
                        else if ( ((LA14_0>='\u0000' && LA14_0<='\t')||(LA14_0>='\u000B' && LA14_0<='\f')||(LA14_0>='\u000E' && LA14_0<='!')||(LA14_0>='#' && LA14_0<='[')||(LA14_0>=']' && LA14_0<='\uFFFF')) ) {
                            alt14=2;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalCucumber.g:1102:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalCucumber.g:1102:66: ~ ( ( '\\\\' | '\"' | '\\r' | '\\n' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalCucumber.g:1102:96: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' | '\\r' | '\\n' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalCucumber.g:1102:101: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' | '\\r' | '\\n' ) ) )*
                    loop15:
                    do {
                        int alt15=3;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0=='\\') ) {
                            alt15=1;
                        }
                        else if ( ((LA15_0>='\u0000' && LA15_0<='\t')||(LA15_0>='\u000B' && LA15_0<='\f')||(LA15_0>='\u000E' && LA15_0<='&')||(LA15_0>='(' && LA15_0<='[')||(LA15_0>=']' && LA15_0<='\uFFFF')) ) {
                            alt15=2;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalCucumber.g:1102:102: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalCucumber.g:1102:147: ~ ( ( '\\\\' | '\\'' | '\\r' | '\\n' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCucumber.g:1104:17: ( '#' (~ ( ( '\\n' | '\\r' ) ) )* RULE_NL )
            // InternalCucumber.g:1104:19: '#' (~ ( ( '\\n' | '\\r' ) ) )* RULE_NL
            {
            match('#'); 
            // InternalCucumber.g:1104:23: (~ ( ( '\\n' | '\\r' ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>='\u0000' && LA17_0<='\t')||(LA17_0>='\u000B' && LA17_0<='\f')||(LA17_0>='\u000E' && LA17_0<='\uFFFF')) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalCucumber.g:1104:23: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            mRULE_NL(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_TAGNAME"
    public final void mRULE_TAGNAME() throws RecognitionException {
        try {
            int _type = RULE_TAGNAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCucumber.g:1106:14: ( '@' (~ ( ( ' ' | '\\t' | '\\n' | '\\r' ) ) )+ )
            // InternalCucumber.g:1106:16: '@' (~ ( ( ' ' | '\\t' | '\\n' | '\\r' ) ) )+
            {
            match('@'); 
            // InternalCucumber.g:1106:20: (~ ( ( ' ' | '\\t' | '\\n' | '\\r' ) ) )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>='\u0000' && LA18_0<='\b')||(LA18_0>='\u000B' && LA18_0<='\f')||(LA18_0>='\u000E' && LA18_0<='\u001F')||(LA18_0>='!' && LA18_0<='\uFFFF')) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalCucumber.g:1106:20: ~ ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||(input.LA(1)>='!' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_TAGNAME"

    // $ANTLR start "RULE_WORD"
    public final void mRULE_WORD() throws RecognitionException {
        try {
            int _type = RULE_WORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCucumber.g:1108:11: (~ ( ( '@' | '|' | ' ' | '\\t' | '\\n' | '\\r' ) ) (~ ( ( ' ' | '\\t' | '\\n' | '\\r' ) ) )* )
            // InternalCucumber.g:1108:13: ~ ( ( '@' | '|' | ' ' | '\\t' | '\\n' | '\\r' ) ) (~ ( ( ' ' | '\\t' | '\\n' | '\\r' ) ) )*
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||(input.LA(1)>='!' && input.LA(1)<='?')||(input.LA(1)>='A' && input.LA(1)<='{')||(input.LA(1)>='}' && input.LA(1)<='\uFFFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalCucumber.g:1108:45: (~ ( ( ' ' | '\\t' | '\\n' | '\\r' ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>='\u0000' && LA19_0<='\b')||(LA19_0>='\u000B' && LA19_0<='\f')||(LA19_0>='\u000E' && LA19_0<='\u001F')||(LA19_0>='!' && LA19_0<='\uFFFF')) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalCucumber.g:1108:45: ~ ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||(input.LA(1)>='!' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WORD"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCucumber.g:1110:9: ( ( ' ' | '\\t' ) )
            // InternalCucumber.g:1110:11: ( ' ' | '\\t' )
            {
            if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_EOL"
    public final void mRULE_EOL() throws RecognitionException {
        try {
            int _type = RULE_EOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCucumber.g:1112:10: ( RULE_NL )
            // InternalCucumber.g:1112:12: RULE_NL
            {
            mRULE_NL(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_EOL"

    // $ANTLR start "RULE_NL"
    public final void mRULE_NL() throws RecognitionException {
        try {
            // InternalCucumber.g:1114:18: ( ( '\\r' )? ( '\\n' )? )
            // InternalCucumber.g:1114:20: ( '\\r' )? ( '\\n' )?
            {
            // InternalCucumber.g:1114:20: ( '\\r' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0=='\r') ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalCucumber.g:1114:20: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            // InternalCucumber.g:1114:26: ( '\\n' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0=='\n') ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalCucumber.g:1114:26: '\\n'
                    {
                    match('\n'); 

                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_NL"

    public void mTokens() throws RecognitionException {
        // InternalCucumber.g:1:8: ( T__16 | T__17 | T__18 | T__19 | T__20 | RULE_INT | RULE_STEP_KEYWORD | RULE_PLACEHOLDER | RULE_TABLE_ROW | RULE_DOC_STRING | RULE_STRING | RULE_SL_COMMENT | RULE_TAGNAME | RULE_WORD | RULE_WS | RULE_EOL )
        int alt22=16;
        alt22 = dfa22.predict(input);
        switch (alt22) {
            case 1 :
                // InternalCucumber.g:1:10: T__16
                {
                mT__16(); 

                }
                break;
            case 2 :
                // InternalCucumber.g:1:16: T__17
                {
                mT__17(); 

                }
                break;
            case 3 :
                // InternalCucumber.g:1:22: T__18
                {
                mT__18(); 

                }
                break;
            case 4 :
                // InternalCucumber.g:1:28: T__19
                {
                mT__19(); 

                }
                break;
            case 5 :
                // InternalCucumber.g:1:34: T__20
                {
                mT__20(); 

                }
                break;
            case 6 :
                // InternalCucumber.g:1:40: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 7 :
                // InternalCucumber.g:1:49: RULE_STEP_KEYWORD
                {
                mRULE_STEP_KEYWORD(); 

                }
                break;
            case 8 :
                // InternalCucumber.g:1:67: RULE_PLACEHOLDER
                {
                mRULE_PLACEHOLDER(); 

                }
                break;
            case 9 :
                // InternalCucumber.g:1:84: RULE_TABLE_ROW
                {
                mRULE_TABLE_ROW(); 

                }
                break;
            case 10 :
                // InternalCucumber.g:1:99: RULE_DOC_STRING
                {
                mRULE_DOC_STRING(); 

                }
                break;
            case 11 :
                // InternalCucumber.g:1:115: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 12 :
                // InternalCucumber.g:1:127: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 13 :
                // InternalCucumber.g:1:143: RULE_TAGNAME
                {
                mRULE_TAGNAME(); 

                }
                break;
            case 14 :
                // InternalCucumber.g:1:156: RULE_WORD
                {
                mRULE_WORD(); 

                }
                break;
            case 15 :
                // InternalCucumber.g:1:166: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 16 :
                // InternalCucumber.g:1:174: RULE_EOL
                {
                mRULE_EOL(); 

                }
                break;

        }

    }


    protected DFA9 dfa9 = new DFA9(this);
    protected DFA22 dfa22 = new DFA22(this);
    static final String DFA9_eotS =
        "\2\2\2\uffff";
    static final String DFA9_eofS =
        "\4\uffff";
    static final String DFA9_minS =
        "\2\0\2\uffff";
    static final String DFA9_maxS =
        "\2\uffff\2\uffff";
    static final String DFA9_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA9_specialS =
        "\1\0\1\1\2\uffff}>";
    static final String[] DFA9_transitionS = {
            "\11\3\1\1\1\uffff\2\3\1\uffff\22\3\1\1\uffdf\3",
            "\11\3\1\1\1\uffff\2\3\1\uffff\22\3\1\1\uffdf\3",
            "",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "()+ loopback of 1098:22: ( (~ ( ( '|' | '\\n' | '\\r' ) ) )* '|' )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA9_0 = input.LA(1);

                        s = -1;
                        if ( (LA9_0=='\t'||LA9_0==' ') ) {s = 1;}

                        else if ( ((LA9_0>='\u0000' && LA9_0<='\b')||(LA9_0>='\u000B' && LA9_0<='\f')||(LA9_0>='\u000E' && LA9_0<='\u001F')||(LA9_0>='!' && LA9_0<='\uFFFF')) ) {s = 3;}

                        else s = 2;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA9_1 = input.LA(1);

                        s = -1;
                        if ( (LA9_1=='\t'||LA9_1==' ') ) {s = 1;}

                        else if ( ((LA9_1>='\u0000' && LA9_1<='\b')||(LA9_1>='\u000B' && LA9_1<='\f')||(LA9_1>='\u000E' && LA9_1<='\u001F')||(LA9_1>='!' && LA9_1<='\uFFFF')) ) {s = 3;}

                        else s = 2;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 9, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA22_eotS =
        "\1\23\5\21\1\34\5\21\1\uffff\2\21\1\52\4\uffff\6\21\1\34\1\21\1\uffff\5\21\1\45\2\21\1\uffff\1\45\2\21\1\52\1\uffff\6\21\1\34\4\21\1\106\2\21\1\45\2\21\1\45\2\21\1\uffff\6\21\1\uffff\2\21\1\uffff\15\21\2\111\4\21\1\141\3\21\1\uffff\1\21\1\147\1\uffff\1\150\1\21\2\uffff\1\152\1\uffff";
    static final String DFA22_eofS =
        "\153\uffff";
    static final String DFA22_minS =
        "\1\0\1\145\1\141\1\143\1\170\1\60\1\0\1\151\2\150\1\156\1\0\1\uffff\3\0\4\uffff\1\141\1\143\1\164\1\145\2\141\1\0\1\60\1\uffff\1\166\2\145\1\144\2\0\1\42\1\0\1\uffff\1\0\1\42\2\0\1\uffff\1\164\1\153\1\11\1\156\1\163\1\155\1\0\1\145\2\156\1\11\7\0\1\165\1\147\1\uffff\1\141\1\11\1\160\1\156\2\11\1\uffff\2\0\1\uffff\2\0\3\162\1\154\1\11\2\0\1\145\1\157\1\151\1\145\2\0\1\72\1\165\1\157\1\163\1\0\1\156\1\40\1\72\1\uffff\1\144\1\0\1\uffff\1\0\1\72\2\uffff\1\0\1\uffff";
    static final String DFA22_maxS =
        "\1\uffff\1\145\1\165\1\164\1\170\1\71\1\uffff\1\151\2\150\1\156\1\uffff\1\uffff\3\uffff\4\uffff\1\141\1\143\1\164\1\145\2\141\1\uffff\1\71\1\uffff\1\166\2\145\1\144\2\uffff\1\165\1\uffff\1\uffff\1\uffff\1\165\2\uffff\1\uffff\1\164\1\153\1\40\1\156\1\163\1\155\1\uffff\1\145\2\156\1\40\7\uffff\1\165\1\147\1\uffff\1\141\1\40\1\160\1\156\2\40\1\uffff\2\uffff\1\uffff\2\uffff\3\162\1\154\1\40\2\uffff\1\145\1\157\1\151\1\145\2\uffff\1\72\1\165\1\157\1\163\1\uffff\1\156\2\72\1\uffff\1\144\1\uffff\1\uffff\1\uffff\1\72\2\uffff\1\uffff\1\uffff";
    static final String DFA22_acceptS =
        "\14\uffff\1\11\3\uffff\1\15\1\16\1\17\1\20\10\uffff\1\6\10\uffff\1\13\4\uffff\1\14\24\uffff\1\7\6\uffff\1\10\2\uffff\1\12\27\uffff\1\1\2\uffff\1\4\2\uffff\1\3\1\5\1\uffff\1\2";
    static final String DFA22_specialS =
        "\1\1\5\uffff\1\37\4\uffff\1\15\1\uffff\1\10\1\32\1\17\12\uffff\1\20\6\uffff\1\21\1\34\1\uffff\1\26\1\uffff\1\40\1\uffff\1\13\1\22\7\uffff\1\4\4\uffff\1\23\1\30\1\24\1\2\1\3\1\12\1\7\12\uffff\1\35\1\0\1\uffff\1\11\1\14\5\uffff\1\31\1\6\4\uffff\1\16\1\25\4\uffff\1\27\5\uffff\1\36\1\uffff\1\5\3\uffff\1\33\1\uffff}>";
    static final String[] DFA22_transitionS = {
            "\11\21\1\22\1\uffff\2\21\1\uffff\22\21\1\22\1\21\1\15\1\17\3\21\1\16\5\21\1\5\2\21\12\6\2\21\1\13\3\21\1\20\1\12\1\2\2\21\1\4\1\1\1\7\13\21\1\3\1\11\2\21\1\10\44\21\1\14\uff83\21",
            "\1\24",
            "\1\25\23\uffff\1\26",
            "\1\27\20\uffff\1\30",
            "\1\31",
            "\12\32",
            "\11\21\2\uffff\2\21\1\uffff\22\21\1\uffff\15\21\1\33\1\21\12\32\uffc6\21",
            "\1\35",
            "\1\36",
            "\1\37",
            "\1\40",
            "\11\41\2\uffff\2\41\1\uffff\22\41\1\uffff\35\41\1\uffff\uffc1\41",
            "",
            "\11\44\1\45\1\uffff\2\44\1\uffff\22\44\1\45\1\44\1\42\71\44\1\43\uffa3\44",
            "\11\50\1\45\1\uffff\2\50\1\uffff\22\50\1\45\6\50\1\46\64\50\1\47\uffa3\50",
            "\11\51\2\uffff\2\51\1\uffff\22\51\1\uffff\uffdf\51",
            "",
            "",
            "",
            "",
            "\1\53",
            "\1\54",
            "\1\55",
            "\1\56",
            "\1\57",
            "\1\60",
            "\11\21\2\uffff\2\21\1\uffff\22\21\1\uffff\15\21\1\33\1\21\12\32\uffc6\21",
            "\12\61",
            "",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\11\41\2\uffff\2\41\1\uffff\22\41\1\uffff\35\41\1\66\uffc1\41",
            "\11\21\2\uffff\2\21\1\uffff\22\21\1\uffff\1\21\1\67\uffdd\21",
            "\1\70\4\uffff\1\70\64\uffff\1\70\5\uffff\1\70\3\uffff\1\70\7\uffff\1\70\3\uffff\1\70\1\uffff\2\70",
            "\11\44\1\45\1\uffff\2\44\1\uffff\22\44\1\45\1\44\1\71\71\44\1\43\uffa3\44",
            "",
            "\11\21\2\uffff\2\21\1\uffff\22\21\1\uffff\6\21\1\72\uffd8\21",
            "\1\73\4\uffff\1\73\64\uffff\1\73\5\uffff\1\73\3\uffff\1\73\7\uffff\1\73\3\uffff\1\73\1\uffff\2\73",
            "\11\50\1\45\1\uffff\2\50\1\uffff\22\50\1\45\6\50\1\74\64\50\1\47\uffa3\50",
            "\11\51\2\uffff\2\51\1\uffff\22\51\1\uffff\uffdf\51",
            "",
            "\1\75",
            "\1\76",
            "\1\77\26\uffff\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\11\21\2\uffff\2\21\1\uffff\22\21\1\uffff\17\21\12\61\uffc6\21",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\77\26\uffff\1\77",
            "\11\21\2\uffff\2\21\1\uffff\22\21\1\uffff\uffdf\21",
            "\11\110\2\111\2\110\1\111\22\110\1\111\1\110\1\107\uffdd\110",
            "\11\44\1\45\1\uffff\2\44\1\uffff\22\44\1\45\1\44\1\71\71\44\1\43\uffa3\44",
            "\11\21\2\uffff\2\21\1\uffff\22\21\1\uffff\uffdf\21",
            "\11\113\2\111\2\113\1\111\22\113\1\111\6\113\1\112\uffd8\113",
            "\11\50\1\45\1\uffff\2\50\1\uffff\22\50\1\45\6\50\1\74\64\50\1\47\uffa3\50",
            "\11\21\2\uffff\2\21\1\uffff\22\21\1\uffff\uffdf\21",
            "\1\114",
            "\1\115",
            "",
            "\1\116",
            "\1\77\26\uffff\1\77",
            "\1\117",
            "\1\120",
            "\1\77\26\uffff\1\77",
            "\1\77\26\uffff\1\77",
            "",
            "\11\110\2\111\2\110\1\111\22\110\1\111\1\110\1\121\uffdd\110",
            "\11\110\2\111\2\110\1\111\22\110\1\111\1\110\1\107\uffdd\110",
            "",
            "\11\113\2\111\2\113\1\111\22\113\1\111\6\113\1\122\uffd8\113",
            "\11\113\2\111\2\113\1\111\22\113\1\111\6\113\1\112\uffd8\113",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\77\26\uffff\1\77",
            "\11\110\2\111\2\110\1\111\22\110\1\111\1\110\1\127\uffdd\110",
            "\11\113\2\111\2\113\1\111\22\113\1\111\6\113\1\130\uffd8\113",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\11\110\2\uffff\2\110\1\uffff\22\110\1\uffff\1\110\1\127\uffdd\110",
            "\11\113\2\uffff\2\113\1\uffff\22\113\1\uffff\6\113\1\130\uffd8\113",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\11\21\2\uffff\2\21\1\uffff\22\21\1\uffff\uffdf\21",
            "\1\142",
            "\1\144\31\uffff\1\143",
            "\1\145",
            "",
            "\1\146",
            "\11\21\2\uffff\2\21\1\uffff\22\21\1\uffff\uffdf\21",
            "",
            "\11\21\2\uffff\2\21\1\uffff\22\21\1\uffff\uffdf\21",
            "\1\151",
            "",
            "",
            "\11\21\2\uffff\2\21\1\uffff\22\21\1\uffff\uffdf\21",
            ""
    };

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__16 | T__17 | T__18 | T__19 | T__20 | RULE_INT | RULE_STEP_KEYWORD | RULE_PLACEHOLDER | RULE_TABLE_ROW | RULE_DOC_STRING | RULE_STRING | RULE_SL_COMMENT | RULE_TAGNAME | RULE_WORD | RULE_WS | RULE_EOL );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA22_72 = input.LA(1);

                        s = -1;
                        if ( (LA22_72=='\"') ) {s = 71;}

                        else if ( ((LA22_72>='\u0000' && LA22_72<='\b')||(LA22_72>='\u000B' && LA22_72<='\f')||(LA22_72>='\u000E' && LA22_72<='\u001F')||LA22_72=='!'||(LA22_72>='#' && LA22_72<='\uFFFF')) ) {s = 72;}

                        else if ( ((LA22_72>='\t' && LA22_72<='\n')||LA22_72=='\r'||LA22_72==' ') ) {s = 73;}

                        else s = 17;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA22_0 = input.LA(1);

                        s = -1;
                        if ( (LA22_0=='F') ) {s = 1;}

                        else if ( (LA22_0=='B') ) {s = 2;}

                        else if ( (LA22_0=='S') ) {s = 3;}

                        else if ( (LA22_0=='E') ) {s = 4;}

                        else if ( (LA22_0=='-') ) {s = 5;}

                        else if ( ((LA22_0>='0' && LA22_0<='9')) ) {s = 6;}

                        else if ( (LA22_0=='G') ) {s = 7;}

                        else if ( (LA22_0=='W') ) {s = 8;}

                        else if ( (LA22_0=='T') ) {s = 9;}

                        else if ( (LA22_0=='A') ) {s = 10;}

                        else if ( (LA22_0=='<') ) {s = 11;}

                        else if ( (LA22_0=='|') ) {s = 12;}

                        else if ( (LA22_0=='\"') ) {s = 13;}

                        else if ( (LA22_0=='\'') ) {s = 14;}

                        else if ( (LA22_0=='#') ) {s = 15;}

                        else if ( (LA22_0=='@') ) {s = 16;}

                        else if ( ((LA22_0>='\u0000' && LA22_0<='\b')||(LA22_0>='\u000B' && LA22_0<='\f')||(LA22_0>='\u000E' && LA22_0<='\u001F')||LA22_0=='!'||(LA22_0>='$' && LA22_0<='&')||(LA22_0>='(' && LA22_0<=',')||(LA22_0>='.' && LA22_0<='/')||(LA22_0>=':' && LA22_0<=';')||(LA22_0>='=' && LA22_0<='?')||(LA22_0>='C' && LA22_0<='D')||(LA22_0>='H' && LA22_0<='R')||(LA22_0>='U' && LA22_0<='V')||(LA22_0>='X' && LA22_0<='{')||(LA22_0>='}' && LA22_0<='\uFFFF')) ) {s = 17;}

                        else if ( (LA22_0=='\t'||LA22_0==' ') ) {s = 18;}

                        else s = 19;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA22_57 = input.LA(1);

                        s = -1;
                        if ( ((LA22_57>='\u0000' && LA22_57<='\b')||(LA22_57>='\u000B' && LA22_57<='\f')||(LA22_57>='\u000E' && LA22_57<='\u001F')||(LA22_57>='!' && LA22_57<='\uFFFF')) ) {s = 17;}

                        else s = 37;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA22_58 = input.LA(1);

                        s = -1;
                        if ( (LA22_58=='\'') ) {s = 74;}

                        else if ( ((LA22_58>='\t' && LA22_58<='\n')||LA22_58=='\r'||LA22_58==' ') ) {s = 73;}

                        else if ( ((LA22_58>='\u0000' && LA22_58<='\b')||(LA22_58>='\u000B' && LA22_58<='\f')||(LA22_58>='\u000E' && LA22_58<='\u001F')||(LA22_58>='!' && LA22_58<='&')||(LA22_58>='(' && LA22_58<='\uFFFF')) ) {s = 75;}

                        else s = 17;

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA22_49 = input.LA(1);

                        s = -1;
                        if ( ((LA22_49>='0' && LA22_49<='9')) ) {s = 49;}

                        else if ( ((LA22_49>='\u0000' && LA22_49<='\b')||(LA22_49>='\u000B' && LA22_49<='\f')||(LA22_49>='\u000E' && LA22_49<='\u001F')||(LA22_49>='!' && LA22_49<='/')||(LA22_49>=':' && LA22_49<='\uFFFF')) ) {s = 17;}

                        else s = 28;

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA22_101 = input.LA(1);

                        s = -1;
                        if ( ((LA22_101>='\u0000' && LA22_101<='\b')||(LA22_101>='\u000B' && LA22_101<='\f')||(LA22_101>='\u000E' && LA22_101<='\u001F')||(LA22_101>='!' && LA22_101<='\uFFFF')) ) {s = 17;}

                        else s = 104;

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA22_82 = input.LA(1);

                        s = -1;
                        if ( (LA22_82=='\'') ) {s = 88;}

                        else if ( ((LA22_82>='\u0000' && LA22_82<='\b')||(LA22_82>='\u000B' && LA22_82<='\f')||(LA22_82>='\u000E' && LA22_82<='\u001F')||(LA22_82>='!' && LA22_82<='&')||(LA22_82>='(' && LA22_82<='\uFFFF')) ) {s = 75;}

                        else if ( ((LA22_82>='\t' && LA22_82<='\n')||LA22_82=='\r'||LA22_82==' ') ) {s = 73;}

                        else s = 17;

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA22_60 = input.LA(1);

                        s = -1;
                        if ( ((LA22_60>='\u0000' && LA22_60<='\b')||(LA22_60>='\u000B' && LA22_60<='\f')||(LA22_60>='\u000E' && LA22_60<='\u001F')||(LA22_60>='!' && LA22_60<='\uFFFF')) ) {s = 17;}

                        else s = 37;

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA22_13 = input.LA(1);

                        s = -1;
                        if ( (LA22_13=='\"') ) {s = 34;}

                        else if ( (LA22_13=='\\') ) {s = 35;}

                        else if ( ((LA22_13>='\u0000' && LA22_13<='\b')||(LA22_13>='\u000B' && LA22_13<='\f')||(LA22_13>='\u000E' && LA22_13<='\u001F')||LA22_13=='!'||(LA22_13>='#' && LA22_13<='[')||(LA22_13>=']' && LA22_13<='\uFFFF')) ) {s = 36;}

                        else if ( (LA22_13=='\t'||LA22_13==' ') ) {s = 37;}

                        else s = 17;

                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA22_74 = input.LA(1);

                        s = -1;
                        if ( (LA22_74=='\'') ) {s = 82;}

                        else if ( ((LA22_74>='\u0000' && LA22_74<='\b')||(LA22_74>='\u000B' && LA22_74<='\f')||(LA22_74>='\u000E' && LA22_74<='\u001F')||(LA22_74>='!' && LA22_74<='&')||(LA22_74>='(' && LA22_74<='\uFFFF')) ) {s = 75;}

                        else if ( ((LA22_74>='\t' && LA22_74<='\n')||LA22_74=='\r'||LA22_74==' ') ) {s = 73;}

                        else s = 17;

                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA22_59 = input.LA(1);

                        s = -1;
                        if ( (LA22_59=='\'') ) {s = 60;}

                        else if ( (LA22_59=='\\') ) {s = 39;}

                        else if ( ((LA22_59>='\u0000' && LA22_59<='\b')||(LA22_59>='\u000B' && LA22_59<='\f')||(LA22_59>='\u000E' && LA22_59<='\u001F')||(LA22_59>='!' && LA22_59<='&')||(LA22_59>='(' && LA22_59<='[')||(LA22_59>=']' && LA22_59<='\uFFFF')) ) {s = 40;}

                        else if ( (LA22_59=='\t'||LA22_59==' ') ) {s = 37;}

                        else s = 17;

                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA22_40 = input.LA(1);

                        s = -1;
                        if ( (LA22_40=='\'') ) {s = 60;}

                        else if ( (LA22_40=='\\') ) {s = 39;}

                        else if ( ((LA22_40>='\u0000' && LA22_40<='\b')||(LA22_40>='\u000B' && LA22_40<='\f')||(LA22_40>='\u000E' && LA22_40<='\u001F')||(LA22_40>='!' && LA22_40<='&')||(LA22_40>='(' && LA22_40<='[')||(LA22_40>=']' && LA22_40<='\uFFFF')) ) {s = 40;}

                        else if ( (LA22_40=='\t'||LA22_40==' ') ) {s = 37;}

                        else s = 17;

                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA22_75 = input.LA(1);

                        s = -1;
                        if ( (LA22_75=='\'') ) {s = 74;}

                        else if ( ((LA22_75>='\u0000' && LA22_75<='\b')||(LA22_75>='\u000B' && LA22_75<='\f')||(LA22_75>='\u000E' && LA22_75<='\u001F')||(LA22_75>='!' && LA22_75<='&')||(LA22_75>='(' && LA22_75<='\uFFFF')) ) {s = 75;}

                        else if ( ((LA22_75>='\t' && LA22_75<='\n')||LA22_75=='\r'||LA22_75==' ') ) {s = 73;}

                        else s = 17;

                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA22_11 = input.LA(1);

                        s = -1;
                        if ( ((LA22_11>='\u0000' && LA22_11<='\b')||(LA22_11>='\u000B' && LA22_11<='\f')||(LA22_11>='\u000E' && LA22_11<='\u001F')||(LA22_11>='!' && LA22_11<='=')||(LA22_11>='?' && LA22_11<='\uFFFF')) ) {s = 33;}

                        else s = 17;

                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA22_87 = input.LA(1);

                        s = -1;
                        if ( (LA22_87=='\"') ) {s = 87;}

                        else if ( ((LA22_87>='\u0000' && LA22_87<='\b')||(LA22_87>='\u000B' && LA22_87<='\f')||(LA22_87>='\u000E' && LA22_87<='\u001F')||LA22_87=='!'||(LA22_87>='#' && LA22_87<='\uFFFF')) ) {s = 72;}

                        else s = 73;

                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA22_15 = input.LA(1);

                        s = -1;
                        if ( ((LA22_15>='\u0000' && LA22_15<='\b')||(LA22_15>='\u000B' && LA22_15<='\f')||(LA22_15>='\u000E' && LA22_15<='\u001F')||(LA22_15>='!' && LA22_15<='\uFFFF')) ) {s = 41;}

                        else s = 42;

                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA22_26 = input.LA(1);

                        s = -1;
                        if ( (LA22_26=='.') ) {s = 27;}

                        else if ( ((LA22_26>='0' && LA22_26<='9')) ) {s = 26;}

                        else if ( ((LA22_26>='\u0000' && LA22_26<='\b')||(LA22_26>='\u000B' && LA22_26<='\f')||(LA22_26>='\u000E' && LA22_26<='\u001F')||(LA22_26>='!' && LA22_26<='-')||LA22_26=='/'||(LA22_26>=':' && LA22_26<='\uFFFF')) ) {s = 17;}

                        else s = 28;

                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA22_33 = input.LA(1);

                        s = -1;
                        if ( (LA22_33=='>') ) {s = 54;}

                        else if ( ((LA22_33>='\u0000' && LA22_33<='\b')||(LA22_33>='\u000B' && LA22_33<='\f')||(LA22_33>='\u000E' && LA22_33<='\u001F')||(LA22_33>='!' && LA22_33<='=')||(LA22_33>='?' && LA22_33<='\uFFFF')) ) {s = 33;}

                        else s = 17;

                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA22_41 = input.LA(1);

                        s = -1;
                        if ( ((LA22_41>='\u0000' && LA22_41<='\b')||(LA22_41>='\u000B' && LA22_41<='\f')||(LA22_41>='\u000E' && LA22_41<='\u001F')||(LA22_41>='!' && LA22_41<='\uFFFF')) ) {s = 41;}

                        else s = 42;

                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA22_54 = input.LA(1);

                        s = -1;
                        if ( ((LA22_54>='\u0000' && LA22_54<='\b')||(LA22_54>='\u000B' && LA22_54<='\f')||(LA22_54>='\u000E' && LA22_54<='\u001F')||(LA22_54>='!' && LA22_54<='\uFFFF')) ) {s = 17;}

                        else s = 70;

                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA22_56 = input.LA(1);

                        s = -1;
                        if ( (LA22_56=='\"') ) {s = 57;}

                        else if ( (LA22_56=='\\') ) {s = 35;}

                        else if ( ((LA22_56>='\u0000' && LA22_56<='\b')||(LA22_56>='\u000B' && LA22_56<='\f')||(LA22_56>='\u000E' && LA22_56<='\u001F')||LA22_56=='!'||(LA22_56>='#' && LA22_56<='[')||(LA22_56>=']' && LA22_56<='\uFFFF')) ) {s = 36;}

                        else if ( (LA22_56=='\t'||LA22_56==' ') ) {s = 37;}

                        else s = 17;

                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA22_88 = input.LA(1);

                        s = -1;
                        if ( (LA22_88=='\'') ) {s = 88;}

                        else if ( ((LA22_88>='\u0000' && LA22_88<='\b')||(LA22_88>='\u000B' && LA22_88<='\f')||(LA22_88>='\u000E' && LA22_88<='\u001F')||(LA22_88>='!' && LA22_88<='&')||(LA22_88>='(' && LA22_88<='\uFFFF')) ) {s = 75;}

                        else s = 73;

                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA22_36 = input.LA(1);

                        s = -1;
                        if ( (LA22_36=='\"') ) {s = 57;}

                        else if ( (LA22_36=='\\') ) {s = 35;}

                        else if ( ((LA22_36>='\u0000' && LA22_36<='\b')||(LA22_36>='\u000B' && LA22_36<='\f')||(LA22_36>='\u000E' && LA22_36<='\u001F')||LA22_36=='!'||(LA22_36>='#' && LA22_36<='[')||(LA22_36>=']' && LA22_36<='\uFFFF')) ) {s = 36;}

                        else if ( (LA22_36=='\t'||LA22_36==' ') ) {s = 37;}

                        else s = 17;

                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA22_93 = input.LA(1);

                        s = -1;
                        if ( ((LA22_93>='\u0000' && LA22_93<='\b')||(LA22_93>='\u000B' && LA22_93<='\f')||(LA22_93>='\u000E' && LA22_93<='\u001F')||(LA22_93>='!' && LA22_93<='\uFFFF')) ) {s = 17;}

                        else s = 97;

                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA22_55 = input.LA(1);

                        s = -1;
                        if ( (LA22_55=='\"') ) {s = 71;}

                        else if ( ((LA22_55>='\u0000' && LA22_55<='\b')||(LA22_55>='\u000B' && LA22_55<='\f')||(LA22_55>='\u000E' && LA22_55<='\u001F')||LA22_55=='!'||(LA22_55>='#' && LA22_55<='\uFFFF')) ) {s = 72;}

                        else if ( ((LA22_55>='\t' && LA22_55<='\n')||LA22_55=='\r'||LA22_55==' ') ) {s = 73;}

                        else s = 17;

                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA22_81 = input.LA(1);

                        s = -1;
                        if ( (LA22_81=='\"') ) {s = 87;}

                        else if ( ((LA22_81>='\u0000' && LA22_81<='\b')||(LA22_81>='\u000B' && LA22_81<='\f')||(LA22_81>='\u000E' && LA22_81<='\u001F')||LA22_81=='!'||(LA22_81>='#' && LA22_81<='\uFFFF')) ) {s = 72;}

                        else if ( ((LA22_81>='\t' && LA22_81<='\n')||LA22_81=='\r'||LA22_81==' ') ) {s = 73;}

                        else s = 17;

                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA22_14 = input.LA(1);

                        s = -1;
                        if ( (LA22_14=='\'') ) {s = 38;}

                        else if ( (LA22_14=='\\') ) {s = 39;}

                        else if ( ((LA22_14>='\u0000' && LA22_14<='\b')||(LA22_14>='\u000B' && LA22_14<='\f')||(LA22_14>='\u000E' && LA22_14<='\u001F')||(LA22_14>='!' && LA22_14<='&')||(LA22_14>='(' && LA22_14<='[')||(LA22_14>=']' && LA22_14<='\uFFFF')) ) {s = 40;}

                        else if ( (LA22_14=='\t'||LA22_14==' ') ) {s = 37;}

                        else s = 17;

                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA22_105 = input.LA(1);

                        s = -1;
                        if ( ((LA22_105>='\u0000' && LA22_105<='\b')||(LA22_105>='\u000B' && LA22_105<='\f')||(LA22_105>='\u000E' && LA22_105<='\u001F')||(LA22_105>='!' && LA22_105<='\uFFFF')) ) {s = 17;}

                        else s = 106;

                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA22_34 = input.LA(1);

                        s = -1;
                        if ( (LA22_34=='\"') ) {s = 55;}

                        else if ( ((LA22_34>='\u0000' && LA22_34<='\b')||(LA22_34>='\u000B' && LA22_34<='\f')||(LA22_34>='\u000E' && LA22_34<='\u001F')||LA22_34=='!'||(LA22_34>='#' && LA22_34<='\uFFFF')) ) {s = 17;}

                        else s = 37;

                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA22_71 = input.LA(1);

                        s = -1;
                        if ( (LA22_71=='\"') ) {s = 81;}

                        else if ( ((LA22_71>='\u0000' && LA22_71<='\b')||(LA22_71>='\u000B' && LA22_71<='\f')||(LA22_71>='\u000E' && LA22_71<='\u001F')||LA22_71=='!'||(LA22_71>='#' && LA22_71<='\uFFFF')) ) {s = 72;}

                        else if ( ((LA22_71>='\t' && LA22_71<='\n')||LA22_71=='\r'||LA22_71==' ') ) {s = 73;}

                        else s = 17;

                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA22_99 = input.LA(1);

                        s = -1;
                        if ( ((LA22_99>='\u0000' && LA22_99<='\b')||(LA22_99>='\u000B' && LA22_99<='\f')||(LA22_99>='\u000E' && LA22_99<='\u001F')||(LA22_99>='!' && LA22_99<='\uFFFF')) ) {s = 17;}

                        else s = 103;

                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA22_6 = input.LA(1);

                        s = -1;
                        if ( (LA22_6=='.') ) {s = 27;}

                        else if ( ((LA22_6>='0' && LA22_6<='9')) ) {s = 26;}

                        else if ( ((LA22_6>='\u0000' && LA22_6<='\b')||(LA22_6>='\u000B' && LA22_6<='\f')||(LA22_6>='\u000E' && LA22_6<='\u001F')||(LA22_6>='!' && LA22_6<='-')||LA22_6=='/'||(LA22_6>=':' && LA22_6<='\uFFFF')) ) {s = 17;}

                        else s = 28;

                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA22_38 = input.LA(1);

                        s = -1;
                        if ( (LA22_38=='\'') ) {s = 58;}

                        else if ( ((LA22_38>='\u0000' && LA22_38<='\b')||(LA22_38>='\u000B' && LA22_38<='\f')||(LA22_38>='\u000E' && LA22_38<='\u001F')||(LA22_38>='!' && LA22_38<='&')||(LA22_38>='(' && LA22_38<='\uFFFF')) ) {s = 17;}

                        else s = 37;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 22, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}