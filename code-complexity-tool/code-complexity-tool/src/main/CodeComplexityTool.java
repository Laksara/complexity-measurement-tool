/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.FileReader;
import java.io.FileNotFoundException;

/**
 *
 * @author Laksara Welideniya
 * This is the main class for the Code Complexity Tool and the entry point
 * to the application
 */
public class CodeComplexityTool {

    /**
     * Input File that needs to be read to measure code complexity
     */
    public static void main(String[] args) throws FileNotFoundException {        
        //Input relative location of test file
        FileReader.ReadFile("../testcode.java");
    }
    
}
