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

    /**
     * sets up the class
     *
     * @param array
     * @param isUserInput
     */
    public void setup(int[][] array, boolean[][] isUserInput) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
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
     * finds duplicates
     *  
     * @param array
     */
    private void checkDuplicate(cellCheck[] array) {
        Set<Integer> placeholder = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            if (!array[i].userInput) {
                placeholder.add(array[i].input);
            }
        }

        for (int i = 0; i < array.length; i++) {

            if (array[i].input!= -1) {

                if (placeholder.add(array[i].input) == false && array[i].userInput) {
                    array[i].isCorrect = false;
                }

            }
        }

    }

    /**
     * checks board
     *
     * @return Boolean array
     */
    public boolean[][] checkBoard() {

       
        for (int i = 0; i < 9; i++) {
             
            //Check Vertical
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
                wrongNumbers[i][j] = cells[i][j].isCorrect;
            }
        }

        return wrongNumbers;
    }

    /**
     * get column of 2d array of cellCheck
     *
     * @param colNum
     * @return column of cellCheck
     */
    private cellCheck[] getColumn(int colNum) {
        cellCheck[] col = new cellCheck[9];
        for (int i = 0; i < 9; i++) {
            col[i] = cells[i][colNum];
        }
        return col;
    }

    /**
     * get row of 2d array of cellCheck
     *
     * @param rowNum
     * @return row of cellCheck
     */
    private cellCheck[] getRow(int rowNum) {
        cellCheck[] row = new cellCheck[9];
        for (int i = 0; i < 9; i++) {
            row[i] = cells[rowNum][i];
        }
        return row;
    }

    /**
     * gets box
     *
     * @param row
     * @param column
     * @return return array of the contents of the box
     */
    private cellCheck[] getBox(int row, int column) {
        cellCheck[] box = new cellCheck[9];
        int index = 0;

        for (int i = row * 3; i < (row + 1) * 3; i++) {

            for (int j = column * 3; j < (column + 1) * 3; j++) {
                box[index] = cells[i][j];
                index++;
            }

        }
        return box;
    }
    
    private cellCheck getCell(int row, int column)
    {
        return cells[row][column];
    }
}
