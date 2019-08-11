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
 * Class to measure complexity due to size All code
 * must be correctly formatted and have whitespace separate operators
 */
public class SizeMeasurement {

    private String inputString = "";
    private double inputStringLength = 0;
    private ArrayList<String> tokenList = new ArrayList<>();

    private double sizeComplexity;
    private double lineCount = 0;
    public static double totalSizeComplexity = 0;

    public SizeMeasurement(String inputString) {
        this.inputString = inputString;
        this.inputStringLength = inputString.length();
    }

    public void calculateSizeComplexity(SizeMeasurement sm) {
        findRefDefComplexity(sm);
        findNdttKeywordComplexity(sm);
        findArithmeticComplexity(sm);
        findRelationalComplexity(sm);
        findLogicalComplexity(sm);
        findBitwiseComplexity(sm);
        findMiscellaneousComplexity(sm);
        findAssignmentComplexity(sm);
        findKeywordComplexity(sm);
        findManipulatorsComplexity(sm);
        findQuotesComplexity(sm);
        findNamesComplexity(sm);
        findNumbersComplexity(sm);
    }

    public double getSizeComplexity() {
        return sizeComplexity;
    }

    public static double getTotalSizeComplexity() {
        return totalSizeComplexity;
    }

    public void printTokens() {
        for (String token : tokenList) {
            System.out.print(token + " ");
        }
    }

    public SizeMeasurement findRefDefComplexity(SizeMeasurement sm) {
        int refdefcount = 0, fromIndex = 0;
        for (String value : DefinitionConstants.REFDEREFSTRING) {
            while ((fromIndex = inputString.indexOf(value, fromIndex)) != -1) {
                refdefcount++;
                fromIndex++;
                sm.sizeComplexity += WeightConstants.REFDEREF;
                tokenList.add(value);
            }
        }
        totalSizeComplexity += sizeComplexity;
        return sm;
    }

    //NDTT keywords will usually have spaces around them
    public SizeMeasurement findNdttKeywordComplexity(SizeMeasurement sm) {
        int ndttcount = 0, fromIndex = 0;
        for (String value : DefinitionConstants.NDTTKEYWORDSTRING) {
            while ((fromIndex = inputString.indexOf(value, fromIndex)) != -1) {
                ndttcount++;
                fromIndex++;
                sm.sizeComplexity += WeightConstants.NDTTKEYWORD;
                tokenList.add(value);
            }
        }
        totalSizeComplexity += sizeComplexity;
        return sm;
    }

    public SizeMeasurement findArithmeticComplexity(SizeMeasurement sm) {
        int arithmeticcount = 0, fromIndex = 0;
        for (String value : DefinitionConstants.ARITHMETICOPSSTRING) {
            while ((fromIndex = inputString.indexOf(value, fromIndex)) != -1) {
                arithmeticcount++;
                fromIndex++;
                sm.sizeComplexity += WeightConstants.ARITHMETICOPS;
                tokenList.add(value);
            }

        }
        totalSizeComplexity += sizeComplexity;
        return sm;
    }

    public SizeMeasurement findRelationalComplexity(SizeMeasurement sm) {
        int relationalcount = 0, fromIndex = 0;
        for (String value : DefinitionConstants.RELATIONALOPSSTRING) {
            while ((fromIndex = inputString.indexOf(value, fromIndex)) != -1) {
                relationalcount++;
                fromIndex++;
                sm.sizeComplexity += WeightConstants.RELATIONALOPS;
                tokenList.add(value);
            }
        }
        totalSizeComplexity += sizeComplexity;
        return sm;

    }

    public SizeMeasurement findLogicalComplexity(SizeMeasurement sm) {
        int logicalcount = 0, fromIndex = 0;
        for (String value : DefinitionConstants.LOGICALOPSSTRING) {
            while ((fromIndex = inputString.indexOf(value, fromIndex)) != -1) {
                logicalcount++;
                fromIndex++;
                sm.sizeComplexity += WeightConstants.LOGICALOPS;
                tokenList.add(value);
            }
        }
        totalSizeComplexity += sizeComplexity;
        return sm;
    }

    public SizeMeasurement findBitwiseComplexity(SizeMeasurement sm) {
        int bitwisecount = 0, fromIndex = 0;
        for (String value : DefinitionConstants.BITWISEOPSSTRING) {
            while ((fromIndex = inputString.indexOf(value, fromIndex)) != -1) {
                bitwisecount++;
                fromIndex++;
                sm.sizeComplexity += WeightConstants.BITWISEOPS;
                tokenList.add(value);
            }
        }
        totalSizeComplexity += sizeComplexity;
        return sm;
    }

    public SizeMeasurement findMiscellaneousComplexity(SizeMeasurement sm) {
        int miscellaneouscount = 0, fromIndex = 0;
        for (String value : DefinitionConstants.MISCELLANEOUSOPSSTRING) {
            while ((fromIndex = inputString.indexOf(value, fromIndex)) != -1) {
                miscellaneouscount++;
                fromIndex++;
                sm.sizeComplexity += WeightConstants.MISCELLANEOUSOPS;
                tokenList.add(value);
            }
        }
        totalSizeComplexity += sizeComplexity;
        return sm;
    }

    public SizeMeasurement findAssignmentComplexity(SizeMeasurement sm) {
        int assignmentcount = 0, fromIndex = 0;
        for (String value : DefinitionConstants.ASSIGNMENTOPSSTRING) {
            while ((fromIndex = inputString.indexOf(value, fromIndex)) != -1) {
                assignmentcount++;
                fromIndex++;
                sm.sizeComplexity += WeightConstants.ASSIGNMENTOPS;
                tokenList.add(value);
            }
        }
        totalSizeComplexity += sizeComplexity;
        return sm;
    }

    public SizeMeasurement findKeywordComplexity(SizeMeasurement sm) {
        int keywordcount = 0, fromIndex = 0;
        for (String value : DefinitionConstants.KEYWORDOPSSTRING) {
            while ((fromIndex = inputString.indexOf(value, fromIndex)) != -1) {
                keywordcount++;
                fromIndex++;
                sm.sizeComplexity += WeightConstants.ASSIGNMENTOPS;
                tokenList.add(value);
            }
        }
        totalSizeComplexity += sizeComplexity;
        return sm;
    }

    public SizeMeasurement findManipulatorsComplexity(SizeMeasurement sm) {
        int manipulatorcount = 0, fromIndex = 0;
        for (String value : DefinitionConstants.MANIPULATORSSTRING) {
            while ((fromIndex = inputString.indexOf(value, fromIndex)) != -1) {
                manipulatorcount++;
                fromIndex++;
                sm.sizeComplexity += WeightConstants.MANIPULATORS;
                tokenList.add(value);
            }
        }
        totalSizeComplexity += sizeComplexity;
        return sm;
    }

    //for every double quote add 1
    public SizeMeasurement findQuotesComplexity(SizeMeasurement sm) {
        double quotescount = 0;
        int fromIndex = 0;
        for (String value : DefinitionConstants.QUOTESSTRING) {
            while ((fromIndex = inputString.indexOf(value, fromIndex)) != -1) {
                quotescount += 0.5;
                fromIndex++;
                sm.sizeComplexity += WeightConstants.QUOTES;
                tokenList.add(value);
            }
        }
        totalSizeComplexity += sizeComplexity;
        return sm;
    }

    public SizeMeasurement findNamesComplexity(SizeMeasurement sm) {
        int namescount = 0, fromIndex = 0;
        for (String value : DefinitionConstants.NAMESSTRING) {
            while ((fromIndex = inputString.indexOf(value, fromIndex)) != -1) {
                namescount++;
                fromIndex++;
                sm.sizeComplexity += WeightConstants.NAMES;
                tokenList.add(value);
            }
        }
        totalSizeComplexity += sizeComplexity;
        return sm;
    }

    //Match every number set in the given string
    public SizeMeasurement findNumbersComplexity(SizeMeasurement sm) {
        int numberscount = 0;
        Matcher matcher = DefinitionConstants.NUMBERSPATTERN.matcher(inputString);
        while (matcher.find()) {
            numberscount++;
            sm.sizeComplexity += WeightConstants.NUMBERS;
            tokenList.add(matcher.group());
        }
        totalSizeComplexity += sizeComplexity;
        return sm;
    }

}
