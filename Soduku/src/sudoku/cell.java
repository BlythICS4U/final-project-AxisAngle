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
public class cell {

    public Set<Integer> possibleValues;
    public boolean isInput;

    public cell() {
        possibleValues = new HashSet<Integer>();
    }

    /**
     *
     * @return
     */
    public int getFixedNumber() {
        return (int) this.possibleValues.toArray()[0];
    }

    /**
     *
     * @return
     */
    public Set<Integer> getPossibleValues() {
        return this.possibleValues;
    }

    /**
     *
     * @return
     */
    public boolean getIsInput() {
        return this.isInput;
    }

    /**
     *
     * @return
     */
    public boolean isFixed() {
        return possibleValues.size() == 1;
    }

}
