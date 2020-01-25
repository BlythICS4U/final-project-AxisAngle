/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author bachle
 */
public class logicTest_58 {

    private static int[][] test1;
    private static logic stuff;
    public logicTest_58() {
    }

    @BeforeClass
    public static void setUpClass() {
        stuff = new logic();
        
        test1 = new int[][]{
            {-1, 3, -1, -1, -1, 7, 8, -1, -1},
            {9, 6, -1, -1, 1, -1, 5, -1, -1},
            {-1, -1, -1, 4, -1, -1, -1, 6, 1},
            {-1, -1, 7, -1, -1, -1, -1, -1, 8},
            {-1, 4, -1, 1, -1, -1, -1, 7, -1},
            {5, -1, -1, -1, -1, -1, 2, -1, -1},
            {4, 9, -1, -1, -1, 6, -1, -1, -1},
            {-1, -1, 2, -1, 8, -1, -1, 9, 3},
            {-1, -1, 5, 3, -1, -1, -1, -1, -1}};
        

    }

    /**
     * Test of setup method, of class logic.
     */
    @Test
    public void testSetup() {
        stuff.setup(test1);

    }

    /**
     *
     */
    @Test
    public void testSolve() {
        stuff.solve();
    }
}
