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
public class readFilesTest {

    private static String[][] test1;
    private static String[][] test2;
    
    public readFilesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {

        test1 = new String[][]{
            {" ", " ", " ", "8", " ", "7", " ", " ", " "},
            {" ", " ", "2", " ", "3", " ", " ", "6", " "},
            {" ", "9", "3", "5", " ", " ", " ", " ", " "},
            {"4", " ", "5", " ", "9", " ", " ", " ", "6"},
            {" ", "7", " ", "1", " ", "2", " ", "8", " "},
            {"9", " ", " ", " ", "8", " ", "3", " ", "7"},
            {" ", " ", " ", " ", " ", "8", "7", "1", " "},
            {" ", "5", " ", " ", "7", " ", "2", " ", " "},
            {" ", " ", " ", "3", " ", "9", " ", " ", " "}};
   //     test2 = new String[][]
               
    }

    /**
     * Test of readPuzzle method, of class readFiles.
     */
    @Test
    public void testReadPuzzle() {

        Assert.assertArrayEquals(readFiles.readPuzzle("Easy.txt"), test1);
    }

    /**
     * Test of readFile method, of class readFiles.
     */
    @Test
    public void testReadFile()
    {
        String[] test = new String[] {"Medium.txt", "Hard.txt", "Easy.txt"};
        assertEquals(readFiles.getFiles("puzzles"), test);
    }
}
