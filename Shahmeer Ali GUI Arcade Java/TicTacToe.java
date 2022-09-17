import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This is the TicTacToe game with a little twist. Instead of connecting 3 in a row, the user will have to connect 4 of the same images in a row. Except for X's and O's, there are Soccer and Basketballs.
 * @author (Shahmeer Ali)
 * @version (1/9/2020)
 */
public class TicTacToe extends JPanel implements ActionListener
 {
  // Global Variables
  int rows = 4;
  JButton btn[] [] = new JButton [rows] [rows];
  int turn = 0;
  int butval[] [] = {{9, 9, 9, 9}, {9, 9, 9, 9}, {9, 9, 9, 9},{9, 9, 9, 9} }; //Set to nines to make wins easier to check
  int gameover = 0;
  
  //the two images, soccer and basketballs.
  ImageIcon choices [] = {createImageIcon("finalbasket.JPG"),createImageIcon("soccers.JPG")};
  
  public TicTacToe () {
    //setting gridlayout for game
    setLayout (new GridLayout( rows, rows));
    
    for (int x = 0 ; x < rows ; x++){
      for (int y = 0 ; y < rows ; y++){
        btn [x] [y] = new JButton ("   ");
        btn [x] [y].addActionListener (this);
        btn [x] [y].setActionCommand ("" + (x * 10 + y));
        btn [x] [y].setForeground (Color.black);
        btn [x] [y].setBackground (Color.black);
        btn [x] [y].setPreferredSize(new Dimension(60, 40));
        add (btn [x] [y]);
      }//end nested for
    }//end for
  }// end constructor
  
  public void actionPerformed (ActionEvent e){
    int i = Integer.parseInt (e.getActionCommand ());
    int row = i / 10; 
    int column = i % 10;
    
    if (gameover ==0)
    {
    // Put either ball on the button only if blank
    if (butval [row] [column] == 9){
      turn = (turn + 1) % 2;
      btn [row] [column].setIcon (choices [turn]);
      butval [row] [column] = turn;
      
      // Game over checks: current column, current row and both diagonals
      if (butval [row] [0] + butval [row] [1] + butval [row] [2] + butval [row] [3] == turn * 4 
            || butval [0] [column] + butval [1] [column] + butval [2] [column] + butval [3] [column]== turn * 4 
            || butval [0] [0] + butval [1] [1] + butval [2] [2] + butval [3] [3] == turn * 4 
            || butval [3] [0] + butval [2] [1] + butval [1] [2] + butval [0] [3]== turn * 4)
        {JOptionPane.showMessageDialog (null, 
                                       "Game Over! " +  "This icon has won!", 
                                       "Game Over!", 
                                       JOptionPane.INFORMATION_MESSAGE,
                                       choices[turn]);
         gameover = 1;
         }
       }
    }
    else 
    JOptionPane.showMessageDialog (null, 
                                       "Game Over! " +  "Play again by pressing TicTacToe button!", 
                                       "Game Over!", 
                                       JOptionPane.INFORMATION_MESSAGE);
  } //end actionPerformed
   protected static ImageIcon createImageIcon (String path) 
{
    java.net.URL imgURL = TicTacToe.class.getResource (path);
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
}//end class