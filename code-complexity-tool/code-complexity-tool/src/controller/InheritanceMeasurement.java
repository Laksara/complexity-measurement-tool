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

/**
 *
 * @author Laksara Welideniya
 */
public class InheritanceMeasurement {
    
    private String inputString = "";
    private double inputStringLength = 0;
    private ArrayList<String> tokenList = new ArrayList<>();
    
    private double inheritanceComplexity;
    private double lineCount = 0;
    public static double totalInheritanceComplexity = 0;
    
    public InheritanceMeasurement(String inputString) {
        this.inputString = inputString;
        this.inputStringLength = inputString.length();
    }
    
    public InheritanceMeasurement findInheritanceComplexity(InheritanceMeasurement im) {
        int keywordcount = 0, fromIndex = 0;
        for (String value : DefinitionConstants.INHERITANCEKEYWORD) {
            while ((fromIndex = inputString.indexOf(value, fromIndex)) != -1) {
                keywordcount++;
                fromIndex++;
                im.inheritanceComplexity += WeightConstants.INHERITANCE;
                tokenList.add(value);
            }
        }
        totalInheritanceComplexity += inheritanceComplexity;
        return im;
    }
    
    public double findComplexityDueToInheritance(SizeMeasurement sm){
        return sm.getSizeComplexity() + inheritanceComplexity;
    }
}
