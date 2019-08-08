/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package constants;

import java.util.regex.Pattern;

/**
 *
 * @author Laksara Welideniya
 */
public class DefinitionConstants {

    //Reference (&) and dereference (*) operators
    public final static String REFDEREFSTRING[] = new String[]{" & ", " * "};

    //‘new’, ‘delete’, ‘throw’, and ‘throws’ key words
    public final static String NDTTKEYWORDSTRING[] = new String[]{"new ", "delete ", "throw ", "throws "};

    //Arithmetic operators → { + - * / % ++ -- }
    public final static String ARITHMETICOPSSTRING[] = new String[]{" + ", " - ", " / ", " * ", " % ", " ++", " --", "++;", "--;"};

    //Relation operators → { == != > < >= <= }
    public final static String RELATIONALOPSSTRING[] = new String[]{" == ", " != ", " > ", " < ", " >= ", " <= "};

    //Logical operators → { && || ! }
    public final static String LOGICALOPSSTRING[] = new String[]{" && ", " || ", " ! "};

    //Bitwise operators → { | ^ ~ << >> >>> <<< }
    public final static String BITWISEOPSSTRING[] = new String[]{" | ", " ^ ", " << ", " >> ", " >>> ", " <<< "};

    //Miscellaneous operators → { , ->. :: }
    public final static String MISCELLANEOUSOPSSTRING[] = new String[]{" , ", " -> ", ".", "::"};

    //Assignment operators → {+= -= *= /= = >>>= |= &= %= <<= >>= ^= }
    public final static String ASSIGNMENTOPSSTRING[] = new String[]{" += ", " -= ", " *= ", " /= ", " = ", " >>>= ", " != ", " &= ", " %= ", " <<= ", " >>= ", " ^= "};

    //Key words → {void, double, int, float, string, printf, println, cout, cin, ‘if’, ‘for’, ‘while’, ‘do-while’, ‘switch’, ‘case’ etc.}
    public final static String KEYWORDOPSSTRING[] = new String[]{"void", "double", "int", "float", "string", "printf", "println", "cout", "cin", "if", "for", "while", "do-while", "switch", "case"};

    //Manipulators → {‘endl’, ‘ \n’, etc. }
    public final static String MANIPULATORSSTRING[] = new String[]{"endl", "\\n"};

    //Text inside a pair of double quotes → {Eg: “The greatest is” }
    public final static String QUOTESSTRING[] = new String[]{"\"", " \""};

    //Class, method, object, variable, and array names
    public final static String NAMESSTRING[] = new String[]{"class ", " int ", " boolean ", "long"};

    //Numeric values (numbers)
    public final static Pattern NUMBERSPATTERN = Pattern.compile("\\d+");
}
