/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import constants.DefinitionConstants;
import constants.WeightConstants;
import java.util.ArrayList;
import java.util.regex.Matcher;

/**
 *
 * @author Laksara Welideniya
 * Class to measure complexity due to size
 */
public class SizeMeasurement {
     private String inputString = "";
    private int inputStringLength = 0;
    private ArrayList<String> tokenList = new ArrayList<>();
    
    private int sizeComplexity = 0;
    private int lineCount = 0;
    
    public SizeMeasurement(String inputString){
        this.inputString = inputString;
        this.inputStringLength = inputString.length();
    }
    
    public int getSizeComplexity() {
        return sizeComplexity;
    }
    
    public void calculateSizeComplexity(SizeMeasurement sm){
        sm.findRefDefComplexity();
        sm.findNdttKeywordComplexity();
        sm.findArithmeticComplexity();
        sm.findRelationalComplexity();
        sm.findLogicalComplexity();
        sm.findBitwiseComplexity();
        sm.findMiscellaneousComplexity();
        sm.findAssignmentComplexity();
        sm.findKeywordComplexity();
        sm.findManipulatorsComplexity();
        sm.findQuotesComplexity();
        sm.findNamesComplexity();
        sm.findNumbersComplexity();        
    }
    
    public void printTokens(){
        for( String token: tokenList ){            
            System.out.println(token);            
        }
    }
    
    public void findRefDefComplexity(){
        int refdefcount = 0,fromIndex = 0;
        for(String value : DefinitionConstants.REFDEREFSTRING){
            while ((fromIndex = inputString.indexOf(value, fromIndex)) != -1 ){
                System.out.println("Found at index: " + fromIndex);
                refdefcount++;
                fromIndex++;
                sizeComplexity += WeightConstants.REFDEREF;
                tokenList.add(value);
            }
        }
    }
    
    public void findNdttKeywordComplexity(){
        int ndttcount = 0,fromIndex = 0;
        for(String value : DefinitionConstants.NDTTKEYWORDSTRING){
            while ((fromIndex = inputString.indexOf(value, fromIndex)) != -1 ){                
                System.out.println("Found at index: " + fromIndex);
                ndttcount++;
                fromIndex++;
                sizeComplexity += WeightConstants.NDTTKEYWORD;
                tokenList.add(value);                
            }
        }
    }
    
    public void findArithmeticComplexity(){
        int arithmeticcount = 0,fromIndex = 0;
        for(String value : DefinitionConstants.ARITHMETICOPSSTRING){
            while ((fromIndex = inputString.indexOf(value, fromIndex)) != -1 ){
                System.out.println("Found at index: " + fromIndex);
                arithmeticcount++;
                fromIndex++;
                sizeComplexity += WeightConstants.ARITHMETICOPS;
                tokenList.add(value);
            }
        }
    }
    
    public void findRelationalComplexity(){
        int relationalcount = 0,fromIndex = 0;
        for(String value : DefinitionConstants.RELATIONALOPSSTRING){
            while ((fromIndex = inputString.indexOf(value, fromIndex)) != -1 ){
                System.out.println("Found at index: " + fromIndex);
                relationalcount++;
                fromIndex++;
                sizeComplexity += WeightConstants.RELATIONALOPS;
                tokenList.add(value);
            }
        }
        
    }
    
    public void findLogicalComplexity(){
        int logicalcount = 0,fromIndex = 0;
        for(String value : DefinitionConstants.LOGICALOPSSTRING){
            while ((fromIndex = inputString.indexOf(value, fromIndex)) != -1 ){
                System.out.println("Found at index: " + fromIndex);
                logicalcount++;
                fromIndex++;
                sizeComplexity += WeightConstants.LOGICALOPS;
                tokenList.add(value);
            }
        }
    }
    
    public void findBitwiseComplexity(){
        int bitwisecount = 0,fromIndex = 0;
        for(String value : DefinitionConstants.BITWISEOPSSTRING){
            while ((fromIndex = inputString.indexOf(value, fromIndex)) != -1 ){
                System.out.println("Found at index: " + fromIndex);
                bitwisecount++;
                fromIndex++;
                sizeComplexity += WeightConstants.BITWISEOPS;
                tokenList.add(value);
            }
        }
    }
    
    public void findMiscellaneousComplexity(){
        int miscellaneouscount = 0,fromIndex = 0;
        for(String value : DefinitionConstants.MISCELLANEOUSOPSSTRING){
            while ((fromIndex = inputString.indexOf(value, fromIndex)) != -1 ){
                System.out.println("Found at index: " + fromIndex);
                miscellaneouscount++;
                fromIndex++;
                sizeComplexity += WeightConstants.MISCELLANEOUSOPS;
                tokenList.add(value);
            }
        }
    }
    
    public void findAssignmentComplexity(){
        int assignmentcount = 0,fromIndex = 0;
        for(String value : DefinitionConstants.ASSIGNMENTOPSSTRING){
            while ((fromIndex = inputString.indexOf(value, fromIndex)) != -1 ){
                System.out.println("Found at index: " + fromIndex);
                assignmentcount++;
                fromIndex++;
                sizeComplexity += WeightConstants.ASSIGNMENTOPS;
                tokenList.add(value);
            }
        }
    }
    
    public void findKeywordComplexity(){
        int keywordcount = 0,fromIndex = 0;
        for(String value : DefinitionConstants.KEYWORDOPSSTRING){
            while ((fromIndex = inputString.indexOf(value, fromIndex)) != -1 ){
                System.out.println("Found at index: " + fromIndex);
                keywordcount++;
                fromIndex++;
                sizeComplexity += WeightConstants.ASSIGNMENTOPS;
                tokenList.add(value);
            }
        }
    }   
    
    public void findManipulatorsComplexity(){
        int manipulatorcount = 0,fromIndex = 0;
        for(String value : DefinitionConstants.MANIPULATORSSTRING){
            while ((fromIndex = inputString.indexOf(value, fromIndex)) != -1 ){
                System.out.println("Found at index: " + fromIndex);
                manipulatorcount++;
                fromIndex++;
                sizeComplexity += WeightConstants.MANIPULATORS;
                tokenList.add(value);
            }
        }
    }
    
    public void findQuotesComplexity(){
        int quotescount = 0,fromIndex = 0;
        for(String value : DefinitionConstants.QUOTESSTRING){
            while ((fromIndex = inputString.indexOf(value, fromIndex)) != -1 ){
                System.out.println("Found at index: " + fromIndex);
                quotescount++;
                fromIndex++;
                sizeComplexity += WeightConstants.QUOTES;
                tokenList.add(value);
            }
        }
    }
    
    public void findNamesComplexity(){
        int namescount = 0,fromIndex = 0;
        for(String value : DefinitionConstants.NAMESSTRING){
            while ((fromIndex = inputString.indexOf(value, fromIndex)) != -1 ){
                System.out.println("Found at index: " + fromIndex);
                namescount++;
                fromIndex++;
                sizeComplexity += WeightConstants.NAMES;
                tokenList.add(value);
            }
        }
    }
    
    //Match every number set in the given string
    public void findNumbersComplexity(){
        int numberscount = 0;
        Matcher matcher = DefinitionConstants.NUMBERSPATTERN.matcher(inputString);
        while(matcher.find()){
            numberscount++;
            sizeComplexity += WeightConstants.NUMBERS;
            tokenList.add(matcher.group());
        }
        
    }        
    
}
