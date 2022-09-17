//Libraries needed for the class.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 * This main class has the main panel of the Arcade Project. It has the main menu panel on the side, where players can choose from the instructions and 2 games.
 * I have also created a cardlayout method to show the different panels I have created. In the cardpanel, I have the Chicken game, Tic-Tac-Toe, and finally the instructions.
 *
 * @author (Shahmeer Ali)
 * @version (1/9/2020)
 */
public class main extends JFrame implements ActionListener
{
    //Global Variables
    JPanel panel;
    JPanel panel2;
    JPanel panel3;
    CardLayout cl;
    JPanel cardpanel;
    
    public static void main (String [] args)
    {
       //This is the main method. It creates the whole JFrame.
       JFrame window = new JFrame ("Arcade");
       main mw =new main();
       main content = new main (); 
       mw.setLocation (100,100);
       mw.setSize (1500,800);
       mw.setResizable (true);
       mw.setVisible (true);
        
    }
    
    
    
    public main ()
    {
        //This is the constructor, where I create all the components such as buttons and labels.
        
        //panel1(title)
        panel = new JPanel ();
        setBackground (new Color (204,204,204));
        JLabel title = new JLabel ("Game Theory Arcade!");
        title.setFont (new Font ("Jokerman", Font.BOLD, 35));
        title.setForeground (Color.black);
        title.setBackground (new Color (204,204,204));
        title.setBackground (new Color (204,204,204));
        add (title);
        panel.add(title);
        add (panel);
        
        //panel2(main menu on the side)
        panel2 = new JPanel ();
        setBackground (new Color (204,204,204));
       
        //setting a boxlayout for all the labels and buttons in the main menu.
        BoxLayout boxlayout = new BoxLayout (panel2, BoxLayout.Y_AXIS);
        panel2.setLayout (boxlayout);
        
        //title that says (Main Menu)
        JLabel maintitle = new JLabel ("Main Menu");
        maintitle.setFont (new Font ("Arial", Font.BOLD, 14));
        maintitle.setForeground (Color.blue);
        maintitle.setBackground (new Color (204,204,204));
        maintitle.setBackground (new Color (204,204,204));
        add (maintitle);
        
        //Jlabel (Please Choose:)
        JLabel choose = new JLabel ("Please Choose:");
        choose.setFont (new Font ("Arial", Font.BOLD, 14));
        choose.setForeground (Color.blue);
        choose.setBackground (new Color (204,204,204));
        choose.setBackground (new Color (204,204,204));
        add (choose);
        
        //Instructions button
        JButton instructions = new JButton ("Instructions");
        instructions.setBackground (new Color (204,204,204));
        instructions.setForeground (Color.red);
        
        instructions.setBorderPainted (false);
        instructions.setActionCommand ("instructions");
        instructions.addActionListener (this);
        add (instructions);
        
        //TicTacToe Button button
        JButton tictactoe = new JButton ("TicTacToe   ");
        tictactoe.setBackground (new Color (204,204,204));
        tictactoe.setForeground (Color.red);
        
        tictactoe.setBorderPainted (false);
        tictactoe.setActionCommand ("ttt");
        tictactoe.addActionListener (this);
        add (tictactoe);
        
        //chicken game button
        JButton chickengame = new JButton ("Chicken      ");
        chickengame.setBackground (new Color (204,204,204));
        chickengame.setForeground (Color.red);
        
        chickengame.setBorderPainted (false);
        chickengame.setActionCommand ("cg");
        chickengame.addActionListener (this);
        add (chickengame);

        //Grouping the buttons together.
        ButtonGroup group = new ButtonGroup();       
        
        group.add (instructions);
        group.add (tictactoe);
        group.add (chickengame);
        
        panel2.add (maintitle);
        panel2.add(choose);
        
        //advanced learning (adding space between buttons in boxlayout)
        panel2.add(Box.createRigidArea(new Dimension(0,7)));
        panel2.add(instructions);
        panel2.add(Box.createRigidArea(new Dimension(0,25)));
        panel2.add(tictactoe);
        panel2.add(Box.createRigidArea(new Dimension(0,25)));
        panel2.add(chickengame);
        panel2.add(Box.createRigidArea(new Dimension(0,25)));

        add (panel2);
        
        //panel3 (splashpage)
        panel3 = new JPanel ();
        setBackground (new Color (204,204,204));
        panel3.setLayout (new BorderLayout());
        JLabel gif= new JLabel (createImageIcon ("splash.GIF"));
        panel3.add(gif, BorderLayout.CENTER);
            
                    
        //BorderLayout for panels
        setLayout (new BorderLayout ());
        add(panel, BorderLayout.NORTH);
        add(panel2, BorderLayout.WEST);
                
        //card layout for games panel
        cl = new CardLayout(30,40);
        cardpanel = new JPanel();
        cardpanel.setLayout(cl);
        getContentPane().add(cardpanel, BorderLayout.CENTER);
        
        //showing the splash page at open
        cardpanel.add(panel3, "4");
        cl.show (cardpanel,"4");
          
    }
    
    public void actionPerformed (ActionEvent e)
    {
        //CardLayout
        if(e.getActionCommand().equals("instructions"))
        {
            //calling instructions class if "instructions" button is pressed.
            instructions instpanel = new instructions();
            cardpanel.add(instpanel,"1");
            cl.show(cardpanel, "1");
            
        }
        
        else if (e.getActionCommand().equals("ttt"))
        {
            //calling TicTacToe class if "TicTacToe" button is pressed.
            TicTacToe tic = new TicTacToe ();
            cardpanel.add(tic,"2");
            cl.show(cardpanel, "2");
            
        }

        else if (e.getActionCommand().equals("cg"))
        {
            //calling Chicken game if the "Chicken" button is pressed.
            chicken cgame = new chicken();                  
            cardpanel.add(cgame,"3");
            cl.show(cardpanel, "3");
          }
        
    }
    
    
    //for ImageIcon
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
    