/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author bachle
 */
public class readFiles {

    /**
     * Reads file
     *
     * @param puzzleName
     * @return 2D String array of the puzzle
     */
    public static String[][] readPuzzle(String puzzleName) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("puzzles/" + puzzleName));
            String[][] array = new String[9][9];
            String[] row = new String[9];
            String contentLine;

            for (int i = 0; i < 9; i++) {
                contentLine = br.readLine();
                row = contentLine.split("");
                for (int j = 0; j < 9; j++) {
                    if (row[j].equals("X") || row[j].equals("x")) {
                        array[i][j] = " ";

                    } else {
                        array[i][j] = row[j];
                    }
                }
            }
            return array;
        } catch (IOException ioe) {
            ioe.printStackTrace(System.out);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ioe) {
                System.out.println("Error in closing the BufferedReader");
                ioe.printStackTrace(System.out);
            }
        }
        return null;
    }

    /**
     * gets file names
     *
     * @param folderName
     * @return String array of file names
     */
    public static String[] getFiles(String folderName) {
        ArrayList<String> fileNames = new ArrayList<>();

        File[] files = new File(folderName).listFiles();

        for (File file : files) {
            if (file.isFile()) {

                if (!file.getName().equals(".DS_Store")) {
                    fileNames.add(file.getName());
                }
            }
        }

        String[] names = new String[fileNames.size()];

        for (int i = 0; i < names.length; i++) {
            names[i] = fileNames.get(i);
        }
        return names;
    }

}
