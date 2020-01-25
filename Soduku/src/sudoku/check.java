/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author bachle
 */
public class check {

    private cellCheck[][] cells = new cellCheck[9][9];

    public void setup(int[][] array, boolean[][] isUserInput) {
        for (int i = 0; i < 9; i++) {
                cells[i][j] = new cellCheck();

                if (array[i][j] == -1) {
                    cells[i][j].isCorrect = true;
                    cells[i][j].userInput = false;
                    cells[i][j].input = -1;

                } else {
                    if (isUserInput[i][j]) {

                        cells[i][j].isCorrect = true;
                        cells[i][j].userInput = true;
                        cells[i][j].input = array[i][j];
                    } else {

                        cells[i][j].isCorrect = true;
                        cells[i][j].userInput = false;
                        cells[i][j].input = array[i][j];
                    }
                }
            }
        }

    }

    /**
     *
     * @param array
     */
    public void checkDuplicate(cellCheck[] array) {
        Set<Integer> placeholder = new HashSet<>();

        for(int i = 0; i < 9; i++)
        {
            if(!array[i].userInput)
            {
                placeholder.add(array[i].getInput());
            }
        }
        
        for (int i = 0; i < array.length; i++) {

            if (array[i].getInput() != -1) {

                if (placeholder.add(array[i].getInput()) == false && array[i].getUserInput()) {
                    array[i].isCorrect = false;
                }

            }
        }

    }

    /**
     *
     * @return Boolean array
     */
    public boolean[][] checkBoard() {

        //Check Vertical
        for (int i = 0; i < 9; i++) {
            cellCheck[] vertical = getColumn(i);
            checkDuplicate(vertical);

        //Check Horizontal
            cellCheck[] horizontal = getRow(i);
            checkDuplicate(horizontal);
        }

        //Check box
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cellCheck[] box = getBox(i, j);
                checkDuplicate(box);
            }

        }

        boolean[][] wrongNumbers = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                wrongNumbers[i][j] = cells[i][j].getIsCorrect();
            }
        }

        return wrongNumbers;
    }

    /**
     *
     * @param colNum
     * @return
     */
    private cellCheck[] getColumn(int colNum) {
        cellCheck[] col = new cellCheck[9];
        for (int i = 0; i < 9; i++) {
            col[i] = cells[i][colNum];
        }
        return col;
    }

    private cellCheck[] getRow(int rowNum) {
        cellCheck[] row = new cellCheck[9];
        for (int i = 0; i < 9; i++) {
            row[i] = cells[i][rowNum];
        }
        return row;
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    private cellCheck[] getBox(int a, int b) {
        cellCheck[] box = new cellCheck[9];
        int index = 0;

        for (int i = a * 3; i < (a + 1) * 3; i++) {

            for (int j = b * 3; j < (b + 1) * 3; j++) {
                box[index] = cells[i][j];
                index++;
            }

        }
        return box;
    }
}
