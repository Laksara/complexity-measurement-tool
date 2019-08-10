/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import constants.DefinitionConstants;
import constants.WeightConstants;
import static controller.SizeMeasurement.totalSizeComplexity;
import java.util.ArrayList;
import model.IndividualFunction;
import model.StatementLine;

/**
 *
 * @author Laksara Welideniya
 */
public class General {

    public static ArrayList<IndividualFunction> divideToFunctions(String[] stArray) {

        int x = stArray.length;
        int y;
        int z;
        int a;
        int b;

        int start = 0;
        int end;
        int switchStart, switchEnd;
        int numberOfCases;
        String[] lineToChars;
        ArrayList<String> bracketCheckSwitch = new ArrayList<>();
        boolean isLinePresent;
        String divideBySpaces[];
        int Ctc = 0;

        ArrayList<StatementLine> StatementList = new ArrayList<>();

        String methodName = null;

        ArrayList<IndividualFunction> FunctionList = new ArrayList<>();

        String[] methodLineSplitBySpaces;

        System.out.println(x);
        for (y = 0; y < x; y++) {

            System.out.println("Line " + y + "  : " + stArray[y]);

        }

//		 System.out.println("The type of complexity is : " + type);
//		 System.out.println("The type of Language is : " + language);
        // Divide each function for java
        ArrayList<Integer> methodNameLineNumberList = new ArrayList<>(); // stores the line number of method starting

        ArrayList<String> bracketCheckArray = new ArrayList<>();  // used to store opening and closing brackets to divide the functions

        System.out.println("The lines of method name are given below \n");
        for (y = 0; y < x; y++) {

            if ((stArray[y].contains("public") || stArray[y].contains("private") || stArray[y].contains("protected")) || (stArray[y].contains("void") || stArray[y].contains("int") || stArray[y].contains("long") || stArray[y].contains("float") || stArray[y].contains("double") || stArray[y].contains("boolean") || stArray[y].contains("String") || stArray[y].contains("ArrayList"))) {
                // Modifier Checked

                // Return Type Checked
                if (stArray[y].contains("(") && stArray[y].contains(")") && stArray[y].contains("{")) {
                    System.out.println(stArray[y]);
                    methodNameLineNumberList.add(y);
                }

            }

            if (stArray[start].contains("if") && stArray[start].contains("(") && stArray[start].contains(")")) {
                System.out.println("Line number " + start + " has a if statement");
                Ctc++;

                divideBySpaces = stArray[start].split("\\s");
                for (y = 0; y < divideBySpaces.length; y++) {
                    if (divideBySpaces[y].equals("&&") || divideBySpaces[y].equals("||") || divideBySpaces[y].equals("&") || divideBySpaces[y].equals("|")) {
                        Ctc++;
                    }
                }
            }

            if (stArray[start].contains("for") && stArray[start].contains("(") && stArray[start].contains(")") && stArray[start].contains("{")) {
                System.out.println("Line number " + start + " has a for statement");
                Ctc = Ctc + 2;

                divideBySpaces = stArray[start].split("\\s");
                for (y = 0; y < divideBySpaces.length; y++) {
                    if (divideBySpaces[y].equals("&&") || divideBySpaces[y].equals("||") || divideBySpaces[y].equals("&") || divideBySpaces[y].equals("|")) {
                        Ctc++;
                    }
                }
            }

            if (stArray[start].contains("while") && stArray[start].contains("(") && stArray[start].contains(")") && stArray[start].contains("{")) {
                System.out.println("Line number " + start + " has a While statement");
                Ctc = Ctc + 2;

                divideBySpaces = stArray[start].split("\\s");
                for (y = 0; y < divideBySpaces.length; y++) {
                    if (divideBySpaces[y].equals("&&") || divideBySpaces[y].equals("||") || divideBySpaces[y].equals("&") || divideBySpaces[y].equals("|")) {
                        Ctc++;
                    }
                }
            }

        }
        System.out.println(methodNameLineNumberList.size());
        for (y = 0; y < methodNameLineNumberList.size(); y++) {
            System.out.println("Line number : " + methodNameLineNumberList.get(y));

            for (z = methodNameLineNumberList.get(y); z < stArray.length; z++) {
                lineToChars = stArray[z].split("(?!^)");

                for (a = 0; a < lineToChars.length; a++) {
                    if (lineToChars[a].contains("{")) {
                        bracketCheckArray.add("{");
                        System.out.println("{");
                        System.out.println(bracketCheckArray.toString());
                    }
                    if (lineToChars[a].contains("}")) {
                        bracketCheckArray.remove(bracketCheckArray.size() - 1);
                        System.out.println("}");
                        System.out.println(bracketCheckArray.toString());
                    }

                }

                if (bracketCheckArray.toString() == "[]") {
                    break;
                }
            }
            System.out.println("From :" + methodNameLineNumberList.get(y) + " To : " + z);
            methodLineSplitBySpaces = stArray[methodNameLineNumberList.get(y)].split("\\s");
            for (b = 0; b < methodLineSplitBySpaces.length; b++) {

                if (methodLineSplitBySpaces[b].contains("(")) {
                    System.out.println(methodLineSplitBySpaces[b]);
                    System.out.println(methodLineSplitBySpaces[b].split("\\(")[0]);
                    methodName = methodLineSplitBySpaces[b].split("\\(")[0];
                }
            }
            IndividualFunction f1 = new IndividualFunction(methodNameLineNumberList.get(y), z, methodName);
            FunctionList.add(f1);
        }

        for (y = 0; y < FunctionList.size(); y++) {
            IndividualFunction f2 = FunctionList.get(y);
            System.out.println(f2.getStart());
            System.out.println(f2.getEnd());
            System.out.println(f2.getMethodName());
        }

        return FunctionList;

    }

}
