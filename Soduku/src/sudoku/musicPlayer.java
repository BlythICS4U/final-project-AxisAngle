/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

/**
 *
 * @author bachle
 */
public class musicPlayer {
   
    void playMusic(String fileName)
    {
        try {
            File filePath = new File("music/" + fileName);
            if(filePath.exists())
            {
                AudioInputStream input = AudioSystem.getAudioInputStream(filePath);
                Clip clip = AudioSystem.getClip();
                clip.open(input);
                clip.start();
                
                JOptionPane bruh = new JOptionPane();
                bruh.showMessageDialog(null, "bruhhhh");
                bruh.setVisible(false);
                
            }
            
            else
            {
                System.out.println("bruh it doesn't exist");
            }
        } catch (Exception ex)
                {
                    ex.printStackTrace();
                }
    }
}
