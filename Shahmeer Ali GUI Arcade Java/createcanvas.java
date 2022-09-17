//Libraries needed for the class
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 * This class has all the components added to the game, the buttons and score. Also, the decisioning for who wins is done in this class.
 *
 * @author (Shahmeer Ali)
 * @version (1/9/2020)
 */
public class createcanvas extends JPanel implements ActionListener
{
    //Global Variables   
    JPanel panel;
    JLabel lossscore1;
    JLabel winscore1;
    JLabel tiescore1;
    JLabel player;
    public  createcanvas() //Constructor
    {
        
        JButton ho= new JButton ("Head On");
        ho.addActionListener(this);
        ho.setActionCommand ("HO");
        ho.setForeground (Color.red);
        ho.setBackground (Color.yellow);
        add (ho); 
           
 
        JButton sw = new JButton ("Swerve");
        sw.addActionListener(this);
        sw.setActionCommand ("SW");
        sw.setForeground (Color.red);
        sw.setBackground (Color.yellow);
        add (sw);    
        
        //new stuff adding score
        panel = new JPanel ();
        setBackground(new Color (204,204,204));
        
        JLabel wins = new JLabel ("Wins-");
        wins.setFont (new Font ("Arial", Font.BOLD, 16));
        add(wins);
        
        winscore1 = new JLabel ("0");
        winscore1.setFont (new Font ("Arial", Font.BOLD,16));
        add(winscore1);
        
        JLabel losses = new JLabel ("Losses-");
        losses.setFont (new Font ("Arial", Font.BOLD, 16));
        add(losses);
        
        lossscore1 = new JLabel ("0");
        lossscore1.setFont (new Font("Arial", Font.BOLD, 16));
        add(lossscore1);
        
        JLabel tie = new JLabel ("Tie-");
        tie.setFont (new Font ("Arial", Font.BOLD, 16));
        add(tie);
        
        tiescore1 = new JLabel ("0");
        tiescore1.setFont (new Font("Arial", Font.BOLD, 16));
        add(tiescore1);
        
        player = new JLabel ("You are  the blue square");
        player.setFont (new Font ("Arial", Font.BOLD, 16));
        add(player);
        
        panel.add(wins);
        panel.add(winscore1);
        panel.add(losses);
        panel.add(lossscore1);
        panel.add(tie);
        panel.add(tiescore1);
        panel.add(player);
        
        panel.add(ho);
        panel.add(sw);
        
        add(panel);
 
    }
    //Global Variables
    int user=0;
   
    //Images when the user inputs their choice for the chicken game.
    ImageIcon chick = createImageIcon("finalchicken.PNG");
    ImageIcon youwin = createImageIcon("youwin.PNG");
    ImageIcon boom = createImageIcon("boom.PNG");
    ImageIcon tie = createImageIcon("chickentie.PNG");
    
    //these variables are used to increase score for (win, loss, tie)
     int lossscore2=0;
     int winscore2=0;
     int tiescore2=0;
     
    public void actionPerformed (ActionEvent e)
    {
       //Random generator
       int computer = (int) (Math.random()*2)+1;
       
       //setting value for user playing
       if (e.getActionCommand().equals ("SW"))
       {
           user=1;  // user 1 - SW
       }
       else if (e.getActionCommand().equals("HO"))
       {
           user=2; //user 2 - HO
       }
       
       //final decisioning
      
        if (user==1&&computer==2)
        {
          //showing the Message Dialog to tell user if they win, loose, or tie. There is also an image produced.
          JOptionPane.showMessageDialog (null, 
                                       "Game Over! " + "You lost, you are a chicken, your opponent went head on!", 
                                       "Game Over!", 
                                       JOptionPane.INFORMATION_MESSAGE,chick);
          //increase loss score.                             
          lossscore2++;
          lossscore1.setText(Integer.toString(lossscore2));
          
          getParent().repaint(); //to enable repainting chicken from this child panel
          
        }
        else if(user==2&&computer==1)
        {
          //showing the Message Dialog to tell user if they win, loose, or tie. There is also an image produced.
          JOptionPane.showMessageDialog (null, 
                                       "Game Over! " + "You won, your opponent was a chicken and swerved!", 
                                       "Game Over!", 
                                       JOptionPane.INFORMATION_MESSAGE,youwin);
          //increase win score                             
          winscore2++;           
          winscore1.setText(Integer.toString(winscore2));  
           
          getParent().repaint(); //to enable repainting chicken from this child panel
        }
      
        else if(user==2&&computer==2)
        {
          //showing the Message Dialog to tell user if they win, loose, or tie. There is also an image produced.
          JOptionPane.showMessageDialog (null, 
                                       "Game Over! " + " Its a tie, both of you went head on and died!", 
                                       "Game Over!", 
                                       JOptionPane.INFORMATION_MESSAGE,boom);
          //increase tie score.                             
          tiescore2++;
          tiescore1.setText(Integer.toString(tiescore2));
          
          getParent().repaint(); //to enable repainting chicken from this child panel
        }
       
        else if(user==1&&computer==1)
        {
           //showing the Message Dialog to tell user if they win, loose, or tie. There is also an image produced.
           JOptionPane.showMessageDialog (null, 
                                       "Game Over! " + "You tie, you are both chickens and swerved!", 
                                       "Game Over!", 
                                       JOptionPane.INFORMATION_MESSAGE,tie);
           //increase tie score.                            
           tiescore2++;     
           tiescore1.setText(Integer.toString(tiescore2));
           
           getParent().repaint(); //to enable repainting chicken from this child panel
        }
          
    }
    
    //ImageIcon.    
    protected static ImageIcon createImageIcon (String path) 
    {
    java.net.URL imgURL = main.class.getResource (path);
    if (imgURL !=null)
    {
        return new ImageIcon (imgURL);
    }
    else
    {
        System.err.println ("Couldn't find file:" + path);
        return null;
    }
    }

     
} 