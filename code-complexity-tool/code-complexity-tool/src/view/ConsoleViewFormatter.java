/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.FileReader;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laksara Welideniya Format code to output to console
 */
public class ConsoleViewFormatter {

    public void DisplayHeader() {
        System.out.println("***Code Complexity Measurement Tool***");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t Cs\t Ctc\t Cnc\t Ci\t TW\t Cps\t Cr");
    }

    public void InterpretFileByLine(String filepath) {
        try {
            //Input relative location of test file
            FileReader.ReadFile(filepath);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConsoleViewFormatter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public void InterpretEntireFile(String filepath) {
        try {
            //Input relative location of test file
            FileReader.ReadEntireFile(filepath);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConsoleViewFormatter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
