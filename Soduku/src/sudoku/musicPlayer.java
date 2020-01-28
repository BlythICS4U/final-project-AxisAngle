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
    private Clip clip;
    
    /**
     * Plays audio file
     * @param fileName 
     */
    public void playMusic(String fileName)
    {
        try {
            File filePath = new File("music/" + fileName);
            if(filePath.exists())
            {
                AudioInputStream input = AudioSystem.getAudioInputStream(filePath);
                
                clip = AudioSystem.getClip();
                clip.open(input);
                startMusic();
               
                JOptionPane intialize = new JOptionPane();      
            }  
            
                  } catch (Exception ex)
                
                  {
                    ex.printStackTrace();
                }
    }
   
    /**
    * pauses audio
    */
    public void pauseMusic()
    {
        clip.stop();
    }
    
    /**
     * starts audio
     */
     public void startMusic()
    {
        clip.start();
    }
     
     
     /**
      * Stops the current audio playing
      */
     public void stopMusic()
     {
         if(clip != null){
         clip.close();
         }
     }
     /**
      * loops audio
      */
     public void loopMusic()
     {
         clip.loop(Clip.LOOP_CONTINUOUSLY);
     }
     
     /**
      * Unloops audio
      */
     public void unLoopMusic()
     {
         clip.loop(0);
     }
}
