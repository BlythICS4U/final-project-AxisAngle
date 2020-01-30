/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author bachle
 */
public class logic {

    private cellLogic[][] cells = new cellLogic[9][9];

    /**
     * Sets up the class
     *
     * @param input
     */
    public void setup(int[][] input) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cells[i][j] = new cellLogic();
                if (input[i][j] > 0) {
                    cells[i][j].possibleValues.add(input[i][j]);
                    cells[i][j].userInput = true;
                } else {
                    for (int a = 1; a <= 9; a++) {
                        cells[i][j].possibleValues.add(a);
                        cells[i][j].userInput = false;
                    }
                }
            }
        }
    }

    /**
     * gets the cell
     *
     * @param row
     * @param col
     * @return cell
     */
    public cellLogic getCell(int row, int col) {
        return this.cells[row][col];
    }

    /**
     * Solves
     *
     * @return 2d String array with solution
     */
    public String[][] solve() {
        boolean reducedBox = true;
        boolean reducedVertical = true;
        boolean reducedHorizontal = true;
        boolean reducedBox1 = true;
        boolean reducedVertical1 = true;
        boolean reducedHorizontal1 = true;

        while (reducedBox || reducedVertical || reducedHorizontal || reducedBox1 || reducedVertical1 || reducedHorizontal1) {
            
            //reset status
            reducedBox =false;
            reducedVertical =false;
            reducedHorizontal=false;
            reducedBox1 =false;
            reducedVertical1 =false;
            reducedHorizontal1 =false;
            
            
            //solveBox
            for (int a = 0; a < 3; a++) {
                for (int b = 0; b < 3; b++) {
                    cellLogic[] box = getBox(a, b);
                    reducedBox = reducedBox ||  eliminatePossibleValues(box);
                    reducedBox1 = reducedBox1 ||  fixedNumber(box);

                }
            }

            for (int i = 0; i < 9; i++) {
                cellLogic[] column = getColumn(i);
                cellLogic[] row = getRow(i);

                //solveVertical
                reducedVertical =reducedVertical|| eliminatePossibleValues(column);
                reducedVertical1 =reducedVertical1 || fixedNumber(column);

                //solveHorizontal
                reducedHorizontal =reducedHorizontal || eliminatePossibleValues(row);
                reducedHorizontal1 =reducedHorizontal1 ||  fixedNumber(row);
            }
        }

        String[][] num = new String[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (cells[i][j].possibleValues.size() == 1) {
                    num[i][j] = cells[i][j].possibleValues.toString();
                    num[i][j] = num[i][j].replace("[", "");
                     num[i][j] = num[i][j].replace("]", "");
                } else {
                    num[i][j] = " ";
                }
            }
        }
        return num;
    }

    /**
     * get column of 2d array of cellLogic
     *
     * @param colNum
     * @return column of cellLogic
     */
    private cellLogic[] getColumn(int colNum) {
        cellLogic[] col = new cellLogic[9];

        for (int i = 0; i < 9; i++) {
            col[i] = cells[i][colNum];
        }
        return col;
    }

    /**
     * get row of 2d array of cellLogic
     *
     * @param rowNum
     * @return row of cellLogic
     */
    private cellLogic[] getRow(int rowNum) {
        cellLogic[] row = new cellLogic[9];
        for (int i = 0; i < 9; i++) {
            row[i] = cells[rowNum][i];
        }
        return row;
    }


    /**
     *
     * @param array
     * @return
     */
    private boolean fixedNumber(cellLogic[] array) {
        boolean update = false;
        Set<Integer> numbers = new HashSet<>();

        for (int i = 0; i < 9; i++) {

            if (!array[i].isFixed()) {
                numbers.addAll(array[i].possibleValues);
            }
            
        }

        Object[] placeholder = numbers.toArray();

        for (int i = 0; i < placeholder.length; i++) {
            int num = (int) placeholder[i];
            ArrayList<cellLogic> possibleNum = new ArrayList<>();

            for (int j = 0; j < 9; j++) {
                if (array[j].possibleValues.contains(num)) {
                    possibleNum.add(array[j]);
                }
                
            }

            if (possibleNum.size() == 1) {
                update = true;
                possibleNum.get(0).possibleValues = new HashSet<Integer>();
                possibleNum.get(0).possibleValues.add(num);
            }
        }

        return update;
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    private cellLogic[] getBox(int a, int b) {
        cellLogic[] box = new cellLogic[9];
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
     *Uses method of elimination to eliminate 
     * @param arrayInput
     */
    private boolean eliminatePossibleValues(cellLogic[] arrayInput) {
        ArrayList<Integer> numbers = new ArrayList<>();
        boolean update = false;

        for (int i = 0; i < 9; i++) {

            if (arrayInput[i].isFixed()) {
                numbers.add(arrayInput[i].getFirstNumber());
            }
        }

        for (int i = 0; i < 9; i++) {

            if (!arrayInput[i].isFixed()) {

                int nSize = arrayInput[i].possibleValues.size();
                arrayInput[i].possibleValues.removeAll(numbers);

                if (nSize > arrayInput[i].possibleValues.size()) {
                    update = true;
                }
            }
        }

        return update;
    }

}
