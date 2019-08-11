/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sukanya
 */
public class SizeMeasurementTest {
    
    String inputString = "for (int i = 0; i < 10; i++){";
    
    public SizeMeasurementTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        String inputString = "for( int i = 0; i < 10; i++ ){ ";
        int inputStringLength = inputString.length();

    }
    
    @After
    public void tearDown() {
    }
    /**
     * Test of findRefDefComplexity method, of class SizeMeasurement.
     */
    
    @Test
    public void testFindRefDefComplexity() {
        System.out.println("findRefDefComplexity");
        SizeMeasurement instance = new SizeMeasurement(inputString);
        double expResult = 0.00;
        SizeMeasurement result = instance.findRefDefComplexity(instance);
        assertEquals(expResult, result.getSizeComplexity(),0);    
    }

    /**
     * Test of findNdttKeywordComplexity method, of class SizeMeasurement.
     */
    @Test
    public void testFindNdttKeywordComplexity() {
        System.out.println("findNdttKeywordComplexity");
        SizeMeasurement instance = new SizeMeasurement(inputString);
        double expResult = 0.0;
        SizeMeasurement result = instance.findNdttKeywordComplexity(instance);
        assertEquals(expResult, result.getSizeComplexity(),0);   
    }

    /**
     * Test of findArithmeticComplexity method, of class SizeMeasurement.
     */
    @Test
    public void testFindArithmeticComplexity() {
        System.out.println("findArithmeticComplexity");
        SizeMeasurement instance = new SizeMeasurement(inputString);
        double expResult = 3.0;
        SizeMeasurement result = instance.findArithmeticComplexity(instance);
        assertEquals(expResult, result.getSizeComplexity(),0);
    }

    /**
     * Test of findRelationalComplexity method, of class SizeMeasurement.
     */
    @Test
    public void testFindRelationalComplexity() {
        System.out.println("findRelationalComplexity");
        SizeMeasurement instance = new SizeMeasurement(inputString);
        double expResult = 1.0;
        SizeMeasurement result = instance.findRelationalComplexity(instance);
        assertEquals(expResult, result.getSizeComplexity(),0);
    }

    /**
     * Test of findLogicalComplexity method, of class SizeMeasurement.
     */
    @Test
    public void testFindLogicalComplexity() {
        System.out.println("findLogicalComplexity");
        SizeMeasurement instance = new SizeMeasurement(inputString);
        double expResult = 0.0;
        SizeMeasurement result = instance.findLogicalComplexity(instance);
        assertEquals(expResult, result.getSizeComplexity(),0);

    }

    /**
     * Test of findBitwiseComplexity method, of class SizeMeasurement.
     */
    @Test
    public void testFindBitwiseComplexity() {
        System.out.println("findBitwiseComplexity");
        SizeMeasurement instance = new SizeMeasurement(inputString);
        double expResult = 0.0;
        SizeMeasurement result = instance.findBitwiseComplexity(instance);
        assertEquals(expResult, result.getSizeComplexity(),0);
    }

    /**
     * Test of findMiscellaneousComplexity method, of class SizeMeasurement.
     */
    @Test
    public void testFindMiscellaneousComplexity() {
        System.out.println("findMiscellaneousComplexity");
        SizeMeasurement instance = new SizeMeasurement(inputString);
        double expResult = 0.0;
        SizeMeasurement result = instance.findMiscellaneousComplexity(instance);
        assertEquals(expResult, result.getSizeComplexity(),0);
    }

    /**
     * Test of findAssignmentComplexity method, of class SizeMeasurement.
     */
    @Test
    public void testFindAssignmentComplexity() {
        System.out.println("findAssignmentComplexity");
        SizeMeasurement instance = new SizeMeasurement(inputString);
        double expResult = 1.0;
        SizeMeasurement result = instance.findAssignmentComplexity(instance);
        assertEquals(expResult, result.getSizeComplexity(),0);
    }

    /**
     * Test of findKeywordComplexity method, of class SizeMeasurement.
     */
    @Test
    public void testFindKeywordComplexity() {
        System.out.println("findKeywordComplexity");
        SizeMeasurement instance = new SizeMeasurement(inputString);
        double expResult = 2.0;
        SizeMeasurement result = instance.findKeywordComplexity(instance);
        assertEquals(expResult, result.getSizeComplexity(),0);
    }

    /**
     * Test of findManipulatorsComplexity method, of class SizeMeasurement.
     */
    @Test
    public void testFindManipulatorsComplexity() {
        System.out.println("findManipulatorsComplexity");
        SizeMeasurement instance = new SizeMeasurement(inputString);
        double expResult = 1.0;
        SizeMeasurement result = instance.findManipulatorsComplexity(instance);
        assertEquals(expResult, result.getSizeComplexity(),0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findQuotesComplexity method, of class SizeMeasurement.
     */
    @Test
    public void testFindQuotesComplexity() {
        System.out.println("findQuotesComplexity");
        SizeMeasurement instance = new SizeMeasurement(inputString);
        double expResult = 0.0;
        SizeMeasurement result = instance.findQuotesComplexity(instance);
        assertEquals(expResult, result.getSizeComplexity(),0);

    }

    /**
     * Test of findNamesComplexity method, of class SizeMeasurement.
     */
    @Test
    public void testFindNamesComplexity() {
        System.out.println("findNamesComplexity");
        SizeMeasurement instance = new SizeMeasurement(inputString);
        double expResult = 0.0;
        SizeMeasurement result = instance.findNamesComplexity(instance);
        assertEquals(expResult, result.getSizeComplexity(),0);
    }

    /**
     * Test of findNumbersComplexity method, of class SizeMeasurement.
     */
    @Test
    public void testFindNumbersComplexity() {
        System.out.println("findNumbersComplexity");
        SizeMeasurement instance = new SizeMeasurement(inputString);
        double expResult = 2.0;
        SizeMeasurement result = instance.findNumbersComplexity(instance);
        assertEquals(expResult, result.getSizeComplexity(),0);
    }
    
}
