/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Laksara Welideniya
 * Read java, c++ files using scanner class
 */
public class FileReader {
    public static void ReadFile(String filepath) throws FileNotFoundException{
        // pass the path to the file as a parameter
        File file = new File(filepath);
        Scanner sc = new Scanner(file);
        
        while (sc.hasNextLine())
            System.out.println(sc.nextLine());
    }
}
