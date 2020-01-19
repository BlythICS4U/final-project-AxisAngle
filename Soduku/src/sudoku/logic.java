/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.ArrayList;

/**
 *
 * @author bachle
 */
public class logic {

    private cell[][] cells = new cell[9][9];

    /**
     *
     * @param input
     */
    public void setup(int[][] input) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cells[i][j] = new cell();
                if (input[i][j] > 0) {
                    cells[i][j].possibleValues.add(input[i][j]);
                    cells[i][j].isInput = true;
                } else {
                    for (int a = 0; a < 9; a++) {
                        cells[i][j].possibleValues.add(a);
                        cells[i][j].isInput = false;
                    }
                }
            }
        }
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public cell getCell(int x, int y) {
        return this.cells[x][y];
    }

    
    /**
     * 
     * @param array 
     */
    public void solve(cell[][] array) {

        boolean reduced = true;

        while (reduced) {

            //checkBox
            for (int a = 0; a < 3; a++) {
                for (int b = 0; b < 3; b++) {
                    cell[] box = getBox(a, b);
                    checkBox(box);
                }

                //checkVertical
                
                
                
                
                //checkHorizontal
            }
        }
    }

    /**
     * 
     * @param a
     * @param b
     * @return 
     */
    private cell[] getBox(int a, int b) {
        cell[] box = new cell[9];
        int index = 0;
        for (int i = a * 3; i < (a + 1) * 3; i++) {

            for (int j = b * 3; j < (b + 1) * 3; j++) {
                box[index] = cells[i][j];
                index++;
            }

        }
        return box;
    }

    /**
     *
     * @param arrayInput
     */
    private void checkBox(cell[] arrayInput) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 9; i++) {

            if (arrayInput[i].isFixed()) {
                numbers.add(arrayInput[i].getFixedNumber());

            }
        }

        for (int i = 0; i < 3; i++) {

            if (!arrayInput[i].isFixed()) {
                arrayInput[i].possibleValues.removeAll(numbers);
            }

        }
    }

    /**
     *
     * @param array
     * @return
     */
    private static boolean checkHorizontal(int[][] array) {
        for (int i = 0; i < 9; i++) {

        }
        return true;
    }

    /**
     *
     * @param array
     * @return
     */
    private static boolean checkVertical(int[][] array) {

        return true;
    }
}
