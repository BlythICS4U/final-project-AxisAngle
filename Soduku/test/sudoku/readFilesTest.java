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
    
    public readFilesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of readFile method, of class readFiles.
     */
    @Test
    public void testReadFile() {
       readFiles.getFiles("puzzle");
    }
    
}
