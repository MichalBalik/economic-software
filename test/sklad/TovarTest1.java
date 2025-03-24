/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sklad;

import junit.framework.TestCase;

/**
 *
 * @author Michal
 */
public class TovarTest1 extends TestCase {
    
    public TovarTest1(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of nazovTovaru method, of class Tovar.
     */
    public void testNazovTovaru() {
        System.out.println("nazovTovaru");
        Datum datumPridania = new Datum(24, 5, 2017) ;
        Datum datumSpotreby = new Datum(26, 5, 2017) ;
        Tovar instance = new Tovar(datumSpotreby, datumPridania, "testovane", 10, 20);
        String expResult = "testovane";
        String result = instance.nazovTovaru();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of cenaTovaru method, of class Tovar.
     */
    public void testCenaTovaru() {
        System.out.println("cenaTovaru");
        Datum datumPridania = new Datum(24, 5, 2017) ;
        Datum datumSpotreby = new Datum(26, 5, 2017) ;
        Tovar instance = new Tovar(datumSpotreby, datumPridania, "testovane", 10, 20);
        double expResult = 10.0;
        double result = instance.cenaTovaru();
        assertEquals(expResult, result );
        
    }

    /**
     * Test of datumPridania method, of class Tovar.
     */
    public void testDatumPridania() {
        System.out.println("datumPridania");
        Datum datumPridania = new Datum(24, 5, 2017) ;
        Datum datumSpotreby = new Datum(26, 5, 2017) ;
        Tovar instance = new Tovar(datumSpotreby, datumPridania, "testovane", 10, 20);
        Datum expResult = datumPridania;
        Datum result = instance.datumPridania();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of datumSpotreby method, of class Tovar.
     */
    public void testDatumSpotreby() {
        System.out.println("datumSpotreby");
        Datum datumPridania = new Datum(24, 5, 2017) ;
        Datum datumSpotreby = new Datum(26, 5, 2017) ;
        Tovar instance = new Tovar(datumSpotreby, datumPridania, "testovane", 10, 20);
        Datum expResult = datumSpotreby;
        Datum result = instance.datumSpotreby();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of pocetKusov method, of class Tovar.
     */
    public void testPocetKusov() {
        System.out.println("pocetKusov");
        Datum datumPridania = new Datum(24, 5, 2017) ;
        Datum datumSpotreby = new Datum(26, 5, 2017) ;
        Tovar instance = new Tovar(datumSpotreby, datumPridania, "testovane", 10, 20);
        int expResult = 20;
        int result = instance.pocetKusov();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of odoberTovar method, of class Tovar.
     */
    public void testOdoberTovar() {
        System.out.println("odoberTovar");
        int pomPocetKusov = 10;
        Datum datumPridania = new Datum(24, 5, 2017) ;
        Datum datumSpotreby = new Datum(26, 5, 2017) ;
        Tovar instance = new Tovar(datumSpotreby, datumPridania, "testovane", 10, 20);
        instance.odoberTovar(pomPocetKusov);
        int  result = instance.pocetKusov();
        int expResult = 10;
        assertEquals(expResult, result);
        
    }

    /**
     * Test of prijemTovar method, of class Tovar.
     */
    public void testPrijemTovar() {
        System.out.println("prijemTovar");
        int pomPocetKusov = 30;
        Datum datumPridania = new Datum(24, 5, 2017) ;
        Datum datumSpotreby = new Datum(26, 5, 2017) ;
        Tovar instance = new Tovar(datumSpotreby, datumPridania, "testovane", 10, 20);
        instance.prijemTovar(pomPocetKusov);
        int  result = instance.pocetKusov();
        int expResult = 50;
        assertEquals(expResult, result);
    }

    
    
}
