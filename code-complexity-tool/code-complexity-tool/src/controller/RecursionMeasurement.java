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
 * @author Laksara Welideniya
 */
public class RecursionMeasurement {

    public static ArrayList<StatementLine> calculateComplexityByRecursion(String[] stArray) {

        int x, y;
        int startFunction, endFunction;
        double ctc = 0, cs = 0, ci = 0;
        String methodName;
        boolean isRecursion = false;
        double Cr;

        //allFunctions - array with all the functions found in the string
        ArrayList<IndividualFunction> allFunctions = General.divideToFunctions(stArray);
        ArrayList<IndividualFunction> recursionFunctions = new ArrayList<>();
        System.out.println("----------------------------------------------------------------------------------------------------");
        for (y = 0; y < allFunctions.size(); y++) {
            IndividualFunction f2 = allFunctions.get(y);
            System.out.println(f2.getStart());
            System.out.println(f2.getEnd());
            System.out.println(f2.getMethodName());
        }

        ArrayList<StatementLine> recursionCtc = ControlStructureMeasurement.calculateComplexityByType(allFunctions, stArray);
        ArrayList<StatementLine> recursionCnc = ControlStructureMeasurement.calculateComplexityByNestingControlStructure(allFunctions, stArray);

        for (x = 0; x < allFunctions.size(); x++) {
            isRecursion = false;

            startFunction = allFunctions.get(x).getStart() + 1;
            endFunction = allFunctions.get(x).getEnd();
            methodName = allFunctions.get(x).getMethodName();

            while (startFunction < endFunction) {
                System.out.println("Inside Line : " + startFunction);
                if (stArray[startFunction].contains(methodName)) {
                    isRecursion = true;
                    //calculate complexity due to recursion
                    Cr = getRecursionComplexity(ci, cs, ctc);
                }
                startFunction++;
            }
            if (isRecursion) {
                System.out.println("the x value is :" + x);
                recursionFunctions.add(allFunctions.get(x));
            }

        }

        for (y = 0; y < recursionFunctions.size(); y++) {

            System.out.println("Function Name :" + recursionFunctions.get(y).getMethodName());
            System.out.println("Start Line :" + (recursionFunctions.get(y).getStart() + 1));
            System.out.println("End Line :" + (recursionFunctions.get(y).getEnd() + 1));

            System.out.println("");

        }

        for (int a = 0; a < recursionFunctions.size(); a++) {
            IndividualFunction f2 = recursionFunctions.get(a);
            startFunction = f2.getStart() + 1;
            endFunction = f2.getEnd() + 1;
            System.out.println("Recursion Functions Cnc and Ctc---------------------------------------------------------");
            while (startFunction <= endFunction) {

                for (y = 0; y < recursionCtc.size(); y++) {
                    if (startFunction == recursionCtc.get(y).getLineNumber()) {
                        System.out.println("Line number :" + startFunction + " Recursion Ctc is : " + recursionCtc.get(y).getComplexity());
                    }
                }

                for (y = 0; y < recursionCnc.size(); y++) {
                    if (startFunction == recursionCnc.get(y).getLineNumber()) {
                        System.out.println("Line number :" + startFunction + " Recursion Cnc is : " + recursionCnc.get(y).getComplexity());
                    }
                }

                startFunction++;
            }
        }

        return null;

    }

    public static double getRecursionComplexity(double CsComplexity, double CncComplexity, double CiComplexity) {
        return (CsComplexity + CncComplexity + CiComplexity) * 2;
    }

}
