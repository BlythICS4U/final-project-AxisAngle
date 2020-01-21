/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author bachle
 */
public class logicTest_144 {

    private static int[][] test1;
    private static logic stuff;

    public logicTest_144() {
    }

    @BeforeClass
    public static void setUpClass() {
        test1 = new int[][]{
            {1, -1, 3, -1, -1, -1, -1, -1, -1},
            {-1, 5, 6, 7, -1, 2, -1, 3, -1},
            {2, 7, -1, -1, 9, -1, -1, -1, -1},
            {-1, 6, -1, -1, 7, 1, -1, 8, -1},
            {-1, -1, 1, 8, -1, 5, 6, -1, -1},
            {-1, 3, -1, 6, 2, -1, -1, 7, -1},
            {-1, -1, -1, -1, 5, -1, -1, 6, 7},
            {-1, 1, -1, 9, -1, 6, 4, 2, -1},
            {-1, -1, -1, -1, -1, -1, 3, -1, 9}};

        stuff = new logic();

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
