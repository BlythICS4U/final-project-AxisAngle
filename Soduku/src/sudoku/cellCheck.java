/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author bachle
 */
public class cellCheck {

    public boolean isCorrect;
    public boolean userInput;
    public int input;

    /**
     * Get isCorrect of cellCheck
     *
     * @return cellCheck isCorrect
     */
    public boolean getIsCorrect() {
        return this.isCorrect;
    }

    /**
     * Get input of cellCheck
     *
     * @return cellCheck input
     */
    public int getInput() {
        return this.input;
    }

    /**
     * Get userInput of cellCheck
     *
     * @return cellCheck userInput
     */
    public boolean getUserInput() {
        return this.userInput;
    }
}
