//libraries needed for the class
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * This class will portray the instructions for the two games. This class is called in the main class. The user will be able to click on the instructions buton and this will appear.
 *
 * @author (Shahmeer Ali)
 * @version (1/9/2020)
 */
public class instructions extends JPanel implements ActionListener
{
    public static void main (String [] args)
    {
        //nothing in main
    }
    
    //constructor
    public instructions()
    {
                
        //creating panel 3
        JPanel panel3 = new JPanel ();  
        BoxLayout boxlayout = new BoxLayout (panel3, BoxLayout.Y_AXIS);
        panel3.setLayout(boxlayout);

        
        //chicken instructions title
        JLabel ci = new JLabel ("Chicken Instructions");
        ci.setFont (new Font ("Arial", Font.BOLD, 24));
        ci.setForeground (Color.black);
        ci.setBackground (new Color (204,204,204));               
        //aligning text JLabel
        ci.setHorizontalAlignment(JLabel.CENTER);
        ci.setVerticalAlignment(JLabel.TOP);
        add (ci,BorderLayout.NORTH);
        
        //instructions for chicken          
        JTextArea jt = new JTextArea ("The game of chicken is a model conflict for two players in game theory. Two players start far away facing each other on motorcycles. When the game starts the motorcycles will come closer together, once they are in close distance, you must make a critical decision. You could either swerve, or go straight. Depending on your decision, you could either win, tie, suffer in an accident, or be called a chicken. Below is a diagram showing the payoff matrix for the game, depending on the decisions made by each person. In this arcade, it is a single player game.");
        jt.setFont (new Font ("Arial",Font.BOLD,17));
        jt.setSize(500,50);
        jt.setLineWrap(true);
        jt.setEditable(false);
        jt.setBorder(BorderFactory.createEmptyBorder());
        jt.setOpaque(false);
        add(jt, BorderLayout.CENTER);
        //adding this image(payoff matrix chart for the Chicken Game0
        JLabel pm = new JLabel (createImageIcon ("payoff matrix.PNG"));
        pm.setHorizontalAlignment(JLabel.CENTER);        
        add(pm);
        
        //TicTacToe instructions label
        JLabel t = new JLabel ("TicTacToe Instructions");
        t.setFont (new Font ("Arial", Font.BOLD, 24));
        t.setForeground (Color.black);
        t.setBackground (new Color (204,204,204));  
        //alignment
        t.setHorizontalAlignment(JLabel.CENTER);
        add(t);
        
        //Instructions text for tictactoe
        JTextArea tt = new JTextArea (" This version of TicTacToe is sports themed, with both soccer balls and basketballs. This game is a 2 player game which challenges each player to perform to the best of their abilities. There is a 4x4 grid in which you can place your image, depending on which ball you are. The person who is the makes the first move is the soccer ball, pressing any open spot they wish. The second player will be the basketball. Players will alternate turns, and can only place their image on an empty spot. The objective of the game is to match your image 4 in a row, either horizontally, diagonnally, or vertically. If all spaces are filled up and neither player has their image placed 4 slots in a row, the game ends in a tie. They would then press the TicTacToe button to restart.");
        tt.setFont (new Font ("Arial", Font.BOLD, 17));
        tt.setSize(550,70);
        tt.setLineWrap(true);
        tt.setEditable(false);
        tt.setBorder(BorderFactory.createEmptyBorder());
        tt.setOpaque(false);
        add(tt, BorderLayout.EAST);
        Dimension size = tt.getPreferredSize();     
       
        add(tt);
        
        
        
        //adding all components for panel3
        panel3.add(ci);
        panel3.add(jt);
        panel3.add(pm);
        panel3.add(Box.createRigidArea(new Dimension(0,30)));
        panel3.add(t);
        panel3.add(tt);
        add (panel3);
        
        

    }
    
    public void actionPerformed (ActionEvent e)
    {
        //I don't need anything in the ActionPerformed.
        
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
    
    