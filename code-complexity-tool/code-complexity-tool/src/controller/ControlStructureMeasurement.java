/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.IndividualFunction;
import model.StatementLine;

/**
 *
 * @author
 */
public class ControlStructureMeasurement {

    public static ArrayList<StatementLine> calculateComplexityByType(ArrayList<IndividualFunction> functionList, String[] stArray) {

        int x;
        int y;
        int z;
        int a;
        int start;
        int end;
        int switchStart, switchEnd;
        int numberOfCases;
        String[] lineToChars;
        ArrayList<String> bracketCheckSwitch = new ArrayList<>();
        boolean isLinePresent;

        int Ctc;

        ArrayList<StatementLine> StatementList = new ArrayList<>();

        String[] divideBySpaces;
        if (functionList.size() == 0) {
            return null;
        }

        for (x = 0; x < functionList.size(); x++) {
            IndividualFunction f1 = functionList.get(x);
            start = f1.getStart();
            end = f1.getEnd();

            while (start != end + 1) {
                Ctc = 0;
                numberOfCases = 0;
                System.out.println("Line number " + start + " : " + stArray[start]);

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

                if (stArray[start].contains("do") && stArray[start].contains("{")) {
                    System.out.println("Line number " + start + " has a do statement");
                    Ctc = Ctc + 2;

                    divideBySpaces = stArray[start].split("\\s");
                    for (y = 0; y < divideBySpaces.length; y++) {
                        if (divideBySpaces[y].equals("&&") || divideBySpaces[y].equals("||") || divideBySpaces[y].equals("&") || divideBySpaces[y].equals("|")) {
                            Ctc++;
                        }
                    }
                }

                if (stArray[start].contains("catch") && stArray[start].contains("(") && stArray[start].contains(")") && stArray[start].contains("{")) {
                    System.out.println("Line number " + start + " has a Catch statement");
                    Ctc++;

                }

                if (stArray[start].contains("switch") && stArray[start].contains("(") && stArray[start].contains(")") && stArray[start].contains("{")) {
                    System.out.println("Line number " + start + " has a Switch statement");

                    divideBySpaces = stArray[start].split("\\s");
                    for (y = 0; y < divideBySpaces.length; y++) {
                        if (divideBySpaces[y].equals("{")) {
                            bracketCheckSwitch.add("{");
                        }
                    }

                    for (z = start + 1; z < end; z++) {
                        lineToChars = stArray[z].split("(?!^)");
                        for (a = 0; a < lineToChars.length; a++) {

                            if (lineToChars[a].contains("{")) {
                                bracketCheckSwitch.add("{");
                                System.out.println("{");
                                System.out.println(bracketCheckSwitch.toString());
                            }
                            if (lineToChars[a].contains("}")) {
                                bracketCheckSwitch.remove(bracketCheckSwitch.size() - 1);
                                System.out.println("}");
                                System.out.println(bracketCheckSwitch.toString());
                            }

                        }
                        if (bracketCheckSwitch.toString() == "[]") {
                            break;
                        }
                    }
                    System.out.println("Switch is from " + start + " to " + z);
                    switchStart = start;
                    switchEnd = z;

                    while (switchStart < switchEnd + 1) {
                        if (stArray[switchStart].contains("case")) {
                            numberOfCases++;
                        }
                        switchStart++;
                    }

                    Ctc = Ctc + numberOfCases;
                }

                StatementLine s1 = new StatementLine(start, Ctc);
                StatementList.add(s1);
                start++;
            }
            System.out.println("");
        }

        ArrayList<StatementLine> displayCtcList = new ArrayList<>();

        for (y = 0; y < stArray.length; y++) {
            isLinePresent = true;
            for (a = 0; a < StatementList.size(); a++) {
                if (StatementList.get(a).getLineNumber() == y) {
                    isLinePresent = false;
                }
            }
            if (isLinePresent) {
                StatementList.add(new StatementLine(y, 0));
            }
        }

        for (y = 1; y <= StatementList.size(); y++) {
            for (z = 0; z < StatementList.size(); z++) {
                if (StatementList.get(z).getLineNumber() + 1 == y) {
                    StatementLine s1 = new StatementLine(y, StatementList.get(z).getComplexity());
                    displayCtcList.add(s1);
                }
            }
        }

        return displayCtcList;

    }

    public static ArrayList<StatementLine> calculateComplexityByNestingControlStructure(ArrayList<IndividualFunction> functionList, String[] stArray) {

        int x, a, y, z;
        int start;
        int end;
        int Cnc;
        boolean isLinePresent;
        String[] lineToChars;
        ArrayList<String> bracketNesting = new ArrayList<>();

        ArrayList<StatementLine> StatementList = new ArrayList<>();
        for (x = 0; x < functionList.size(); x++) {

            IndividualFunction f1 = functionList.get(x);
            start = f1.getStart();
            end = f1.getEnd();

            while (start != end + 1) {
                Cnc = 0;

                if ((stArray[start].contains("if") && stArray[start].contains("(") && stArray[start].contains("(")) || (stArray[start].contains("for") && stArray[start].contains("(") && stArray[start].contains("(") && stArray[start].contains("{")) || (stArray[start].contains("while") && stArray[start].contains("(") && stArray[start].contains("(")) || (stArray[start].contains("for") && stArray[start].contains("(") && stArray[start].contains("(") && stArray[start].contains("{")) || (stArray[start].contains("do") && stArray[start].contains("{")) || (stArray[start].contains("switch") && stArray[start].contains("(") && stArray[start].contains("(") && stArray[start].contains("{"))) {
                    lineToChars = stArray[start].split("(?!^)");

                    for (a = 0; a < lineToChars.length; a++) {
//						 System.out.println(lineToChars[a]);
                        if (lineToChars[a].contains("{")) {
                            bracketNesting.add("{");
                            System.out.println(bracketNesting.get(bracketNesting.size() - 1));
                        }
                        if (lineToChars[a].contains("}")) {
                            bracketNesting.remove(bracketNesting.size() - 1);
                        }
                    }
                }

                lineToChars = stArray[start].split("(?!^)");

                for (a = 0; a < lineToChars.length; a++) {
//					 System.out.println(lineToChars[a]);
                    if (bracketNesting.toString() == "[]") {
                        break;
                    }
                    if (lineToChars[a].contains("}")) {
                        bracketNesting.remove(bracketNesting.size() - 1);
                    }
                }
                Cnc = Cnc + bracketNesting.size();
                //				 System.out.println("Cnc ------------------------------------------------------------------------------------");
                //				 System.out.println("Linu number" + (start+1) + "Cnc is" +Cnc);

                StatementLine s1 = new StatementLine(start, Cnc);
                StatementList.add(s1);
                start++;
            }

        }

        ArrayList<StatementLine> displayCtcList = new ArrayList<>();

        for (y = 0; y < stArray.length; y++) {
            isLinePresent = true;
            for (a = 0; a < StatementList.size(); a++) {
                if (StatementList.get(a).getLineNumber() == y) {
                    isLinePresent = false;
                }
            }
            if (isLinePresent) {
                StatementList.add(new StatementLine(y, 0));
            }
        }

        for (y = 1; y <= StatementList.size(); y++) {
            for (z = 0; z < StatementList.size(); z++) {
                if (StatementList.get(z).getLineNumber() + 1 == y) {
                    StatementLine s1 = new StatementLine(y, StatementList.get(z).getComplexity());
                    displayCtcList.add(s1);
                }
            }
        }
        return displayCtcList;
    }

}
