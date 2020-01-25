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
                    for (int a = 1; a <= 9; a++) {
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
     * @return 
     */
    public String[][] solve() {
        boolean reducedBox = true;
        boolean reducedVertical = true;
        boolean reducedHorizontal = true;
        boolean reducedBox1 = true;
        boolean reducedVertical1 = true;
        boolean reducedHorizontal1 = true;
        int stuff = 0;
        while (reducedBox || reducedVertical || reducedHorizontal || reducedBox1 || reducedVertical1 || reducedHorizontal1) {

            //solveBox
            for (int a = 0; a < 3; a++) {
                for (int b = 0; b < 3; b++) {
                    cell[] box = getBox(a, b);
                    reducedBox = eliminatePossibleValues(box);
                    reducedBox1 = fixedNumber(box);

                }
            }

            //solveVertical
            cell[] column = new cell[9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    column[j] = cells[i][j];
                }
                reducedVertical = eliminatePossibleValues(column);
                reducedVertical1 = fixedNumber(column);
            }

            //solveHorizontal
            cell[] row = new cell[9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    row[j] = cells[j][i];
                }
                reducedHorizontal = eliminatePossibleValues(row);
                reducedHorizontal1 = fixedNumber(row);
            }
            
            stuff++;
        }

        printPossibleValues();
        printBoard();
        String[][] num = new String[9][9];
        for(int i = 0; i < 9 ; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                if(cells[i][j].possibleValues.size() == 1)
                {
                    num[i][j] = cells[i][j].possibleValues.toString();
                }
                else
                {
                    num[i][j] = " ";
                }
            }
        }
        return num;
    }

    /**
     *
     * @param colNum
     * @return
     */
    private cell[] getColumn(int colNum) {
        cell[] col = new cell[9];

        for (int i = 0; i < 9; i++) {
            col[i] = cells[i][colNum];
        }
        return col;
    }

    public void printPossibleValues() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                System.out.println((i + 1) + " " + (j + 1) + " " + cells[i][j].possibleValues);
            }

        }
    }

    public void printBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (cells[i][j].possibleValues.size() == 1) {
                    System.out.print(cells[i][j].getFixedNumber() + " ");
                } else {
                    System.out.print("X ");
                }

            }
            System.out.println();
        }
    }

    /**
     *
     * @param array
     * @return
     */
    private boolean fixedNumber(cell[] array) {
        boolean update = false;
        Set<Integer> numbers = new HashSet<>();

        for (int i = 0; i < 9; i++) {

            if (!array[i].isFixed()) {
                numbers.addAll(array[i].possibleValues);
            }
        }

        Object[] stuff = numbers.toArray();

        for (int i = 0; i < stuff.length; i++) {
            int num = (int) stuff[i];
            ArrayList<cell> stuff1 = new ArrayList<>();

            for (int j = 0; j < 9; j++) {
                if (array[j].possibleValues.contains(num)) {
                    stuff1.add(array[j]);
                }
            }

            if (stuff1.size() == 1) {
                update = true;
                stuff1.get(0).possibleValues = new HashSet();
                stuff1.get(0).possibleValues.add(num);
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
    private boolean eliminatePossibleValues(cell[] arrayInput) {
        ArrayList<Integer> numbers = new ArrayList<>();
        boolean update = false;

        for (int i = 0; i < 9; i++) {

            if (arrayInput[i].isFixed()) {
                numbers.add(arrayInput[i].getFixedNumber());
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
