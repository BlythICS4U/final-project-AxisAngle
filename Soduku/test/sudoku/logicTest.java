/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author bachle
 */
public class logicTest {

    private static int[][] test1;
    private static cell[][] cellTest1;
    private static int[][] temp;
    private static logic stuff;

    public logicTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        test1 = new int[][]{
            {-1, -1, -1, 8, -1, 7, -1, -1, -1},
            {-1, -1, 2, -1, 3, -1, -1, 6, -1},
            {-1, 9, 3, 5, -1, -1, -1, -1, -1},
            {4, -1, 5, -1, 9, -1, -1, -1, 6},
            {-1, 7, -1, 1, -1, 2, -1, 8, -1},
            {9, -1, -1, -1, 8, -1, 3, -1, 7},
            {-1, -1, -1, -1, -1, 8, 7, 1, -1},
            {-1, 5, -1, -1, 7, -1, 2, -1, -1},
            {-1, -1, -1, 3, -1, 9, -1, -1, -1},};
  
        stuff = new logic();
       
    }

    /**
     * Test of setup method, of class logic.
     */
    @Test
    public void testSetup() {
      stuff.setup(test1);
        
        assertFalse(stuff.getCell(0, 0).isInput);
        assertEquals(stuff.getCell(0, 0).possibleValues.size(), 9);
        
        assertTrue(stuff.getCell(0, 3).isInput);
        assertEquals(stuff.getCell(0, 3).possibleValues.size(), 1);
        assertTrue(stuff.getCell(0, 3).possibleValues.contains(8));
    }

}
