/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.FileReader;
import java.io.FileNotFoundException;
import view.ConsoleViewFormatter;

/**
 *
 * @author Laksara Welideniya This is the main class for the Code Complexity
 * Tool and the entry point to the application
 */
public class CodeComplexityTool {

    //Relative File Location    
    public static void main(String[] args) throws FileNotFoundException {
        String filepath1a = "../recursive.txt";
        String filepath1b = "../recursiive.txt";
        String filepath2a = "../nonrecursive.txt";
        String filepath2b = "../nonrecursiive.txt";
        
        ConsoleViewFormatter view = new ConsoleViewFormatter();
        view.DisplayHeader();
        
//        view.InterpretFileByLine(filepath1a);
//        view.InterpretEntireFile(filepath1b);
//        view.InterpretFileByLine(filepath2a);
          view.InterpretEntireFile(filepath2b);

    }

}		