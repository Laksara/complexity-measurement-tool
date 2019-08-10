/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.IndividualFunction;

/**
 *
 * @author Laksara Welideniya Read java, c++ files using scanner class
 */
public class FileReader {

    String stArray[];
    ArrayList<IndividualFunction> functionList;
    ArrayList<Double> ctcSum;
    double ctcTotal;

    public static void ReadFile(String filepath) throws FileNotFoundException {
        // pass the path to the file as a parameter
        File file = new File(filepath);
        Scanner sc = new Scanner(file);
        String readLine = "";
        SizeMeasurement sm = null;
        int LineCount = 0;

        while (sc.hasNextLine()) {
            readLine = sc.nextLine();
            sm = new SizeMeasurement(readLine);
            sm.calculateSizeComplexity(sm);
            System.out.print(LineCount++ + " ");
            System.out.print(readLine + "\t\t");
            sm.printTokens();
            System.out.print("\t\t\t\t------->");
            System.out.println(sm.getSizeComplexity() + " \n");
        }
        System.out.println("Total Size Complexity = " + sm.getTotalSizeComplexity());

    }

    //read plain file
    public static void ReadEntireFile(String filepath) throws FileNotFoundException {
        try {
            // pass the path to the file as a parameter
            File file = new File(filepath);
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //find total control structure ctc complexity - sum the ctc for each line and get the total
    public double FindCTCComplexity(ArrayList<Double> ctcList) {
        for (Double d : ctcList) {
            ctcTotal += d;
        }
        return ctcTotal;
    }

}
