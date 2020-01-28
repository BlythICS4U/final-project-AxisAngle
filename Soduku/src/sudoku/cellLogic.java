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
public class cellLogic {

    public Set<Integer> possibleValues;
    public boolean isInput;

    public cellLogic() {
        possibleValues = new HashSet<Integer>();
    }

    /**
     * Get first number of cellLogic
     *
     * @return first number of cellLogic
     */
    public int getFirstNumber() {
        return (int) this.possibleValues.toArray()[0];
    }

    /**
     * Get possibleValues for cellLogic
     *
     * @return possible values for cellLogic
     */
    public Set<Integer> getPossibleValues() {
        return this.possibleValues;
    }

    /**
     * Get isInput for cellLogic
     *
     * @return isInput of cellLogic
     */
    public boolean getIsInput() {
        return this.isInput;
    }

    /**
     *Returns a Boolean depending on if the length is one 
     * 
     * @return Boolean
     */
    public boolean isFixed() {
        return possibleValues.size() == 1;
    }

}
