
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
 * This is the chicken class, where the image and cars are made. Using Graphics2d I created 2 cars, and I have created the set background for the game as well.
 *
 * @author (Shahmeer Ali)
 * @version (1/12/2020)
 */
public class chicken extends JPanel implements ActionListener
{
    //Global Variables
    Timer t = new Timer (50, this); //timer that gets invoked every 50 ms and triggers action command

    Image roadwatermark; //background image of chicken game 
    
    double xpos =0, ypos=getHeight(), shiftx = 10, shifty = 10; // Computer is red car
    double xpos2 = getWidth(), ypos2=getHeight(), shiftx2 = 10, shifty2 = 10; //Player's car is (blue)
    
    //these are the labels for the 2 cars.
    int txpos = 0, typos=520;
    int txpos2 = 1200, typos2 = 520;
    
    String cputxt, playertxt;
    
    // idea to use paintcomponent came from macheads 101 tutorials, however it is customised for my game.
      public void paintComponent (Graphics g)
    {
          super.paintComponent(g);
     
     
          //draws background image of a Jpanel
          PicPanel("chickenbackground.PNG"); //image requires exception handling thus PicPanel()
     
          //the following drawimage() is from stackoverflow https://stackoverflow.com/questions/43861991/how-to-put-an-image-from-a-jfilechooser?noredirect=1&lq=1
          g.drawImage(roadwatermark,0, 0,getWidth(), getHeight(), this);  
     
          // the idea for following code came from macheads 101 - https://www.youtube.com/watch?v=DtVZ6bVmVlU
     
          //creating t
          Graphics2D car = (Graphics2D) g;
          Rectangle2D r = new Rectangle2D.Double (xpos,ypos,40,40);
          car.setPaint (Color.RED);
          car.draw(r);
          car.fill(r);
          //label for computer car.
          Graphics2D comptext = (Graphics2D) g;
          comptext.setColor (Color.WHITE);
          comptext.setFont(new Font("Times New Roman", Font.BOLD, 16));
          comptext.drawString("CPU",txpos,typos);
         
     
          //Creating second rectangle
          Rectangle2D r2 = new Rectangle2D.Double (xpos2,ypos2,40,40);
          car.setPaint (Color.BLUE);
          car.draw(r2);
          car.fill(r2);
          //label for user car.
          Graphics2D playertext = (Graphics2D) g;
          playertext.setColor (Color.WHITE);
          playertext.setFont(new Font("Times New Roman", Font.BOLD, 16));
          playertext.drawString("YOU",txpos2,typos2);   
   
          
          t.start(); //starting timer which invokes actionlistener automatically
    
          //starting here; this is my code to manage the movement of cars
         if ((xpos2-xpos) <=120)// play sound when car stops when the distance between them is <=120
       {
    
         sound("rev.WAV");
         t.stop(); // to avoid cars continuously moving
      
         //setting to original to enable repaint when clicked on creatcanvas() button
         xpos = 0; 
         xpos2 = getWidth();
         txpos=0;
         txpos2=getWidth();
       }
    }
    
    public chicken ()
    {
        //creating a child panel with buttons to make decisions
        createcanvas cv = new createcanvas ();
        add(cv);
    }
    
    public void actionPerformed (ActionEvent e)
    {
        
        xpos += shiftx; //car moving along x-axis
        txpos += shiftx;
        
        xpos2 -= shiftx2;  // xpos2 decreasing for red car because starting from right side
        txpos2 -=shiftx2;
        
        repaint(); //calls paintcomponent for redraw as long as the distance between car is >= 120
        

    }
    
    //the picpanel method is needed to catch exception imageio.read()- alvin alexander https://alvinalexander.com/blog/post/java/open-read-image-file-java-imageio-class
    public void PicPanel(String fname)
    {
        //try and catch is a useful method. If the file name is not found the program wont crash.
        //reads the image
        try{
            roadwatermark = ImageIO.read(new File(fname));
          }
        catch (Exception ioe) 
        {
        }
    }
    
    public void sound (String filename)
    {

        File fn = new File (filename);
        PlaySound (fn);
        
    }

    public void PlaySound (File Sound)
    {
        try {
            //getting sound
            Clip clip = AudioSystem.getClip ();
            clip.open (AudioSystem.getAudioInputStream (Sound));
            clip.start ();
            
            Thread.sleep(clip.getMicrosecondLength () /1000);
            }
       catch (Exception e)
        {
        }
   }

}    