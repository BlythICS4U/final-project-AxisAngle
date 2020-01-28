/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author bachle
 */
public class checkTest {

    private static check check;
    
    private static boolean[][] userInput1;
    private static int[][] test1;
    private static boolean[][] expected1;
    
    private static boolean[][] userInput2;
    private static int[][] test2;
    private static boolean[][] expected2;

    public checkTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        check = new check();

        test1 = new int[][]{
            {1, -1, 3, -1, -1, -1, -1, -1, -1},
            {-1, 5, 6, 7, -1, 2, -1, 3, -1},
            {2, 7, -1, -1, 9, -1, -1, -1, -1},
            {-1, 6, -1, -1, 7, 1, -1, 8, -1},
            {-1, -1, 1, 8, -1, 5, 6, -1, -1},
            {-1, 3, -1, 6, 2, -1, -1, 7, -1},
            {-1, -1, -1, -1, 5, -1, -1, 6, 7},
            {-1, 1, -1, 9, -1, 6, 4, 2, -1},
            {2, -1, -1, -1, -1, -1, 3, -1, 9}
        };
        userInput1 = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (test1[i][j] == -1) {
                    userInput1[i][j] = true;
                } else {
                    userInput1[i][j] = false;
                }
            }
        }
        userInput1[8][0] = true;
        
        
        
        
          expected1 = new boolean[][]{
            {true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true},
            {false, true, true, true, true, true, true, true, true}
        };
          
          userInput2 = new boolean[9][9];
          for(int i = 0; i < 9; i++)
          {
              for(int j = 0; j < 9; j++)
              {
                  userInput2[i][j] = true;
              }
          }
          
          test2 = new int[][]{
            {-1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1}
        };
          
            expected2 = new boolean[][]{
            {true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true}
        };
            
    }

    /**
     * Test of checkBoard method, of class check.
     */
    @Test
    public void testCheckBoard() {
        check.setup(test1, userInput1);
        Assert.assertArrayEquals(check.checkBoard(), expected1);
        
         check.setup(test2, userInput2);
        Assert.assertArrayEquals(check.checkBoard(), expected2);
    }
}
