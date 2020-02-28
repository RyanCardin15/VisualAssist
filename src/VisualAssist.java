/*
Author: Ryan Cardin
Version: 1.0
Date: 10/19/19

This program creates a virtual keyboard and highlights the keys pressed while displaying the text on the screen.
This is to help the user see what they are typing without looking down on their own keyboard
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


/*
This class contains arrays of strings that hold the values of the buttons on a keyboard and adds them to JButtons that
highlight as you press the keys
 */
public class VisualAssist extends JFrame implements KeyListener
{
    //These are arrays of strings that contain the values of each row of the keyboard
    String Row1[] = {"1","2","3","4","5","6","7","8","9","0"};
    String Row2[] = {"Q","W","E","R","T","Y","U","I","O","P"};
    String Row3[] = {"A","S","D","F","G","H","J","K","L"};
    String Row4[] = {"Z","X","C","V","B","N","M"};
    String Row5[]={" "};

    //These are all of the buttons on the pressable keyboard
    Character A[]={'1','2','3','4','5','6','7','8','9','0','Q','W','E','R','T','Y','U','I','O','P','A','S','D','F','G','H','J','K','L','Z','X','C','V','B','N','M',' '};
    //Creating arrays of JButtons
    JButton First[];
    JButton Sec[];
    JButton Trd[];
    JButton Fourth[];
    JButton Fifth[];
    Color regcolor = new JButton().getBackground();
    JButton temp;
    KeyEvent pressed;

    /*
    This method takes the event of the key pressed and compares it to the string and finds the key. It then changes its background color to red
    @param KeyEvent

     */
    public void keyPressed(KeyEvent evt)
    {
        //stores the value of the key
        Character temporary = Character.toUpperCase(evt.getKeyChar());
        String comp = Character.toString(temporary);

        for(int i = 0; i < A.length; i++)
        {
            if(temporary.equals(A[i]))
            {
                for(int x = 0; x < Row1.length; x++)
                {
                    if(comp.equals(Row1[x]))
                    {
                        First[x].setBackground(Color.red);
                        break;
                    }
                }
                for(int c = 0; c < Row2.length; c++)
                {
                    if(comp.equals(Row2[c]))
                    {
                        Sec[c].setBackground(Color.red);
                        break;
                    }
                }
                for(int v = 0; v < Row3.length; v++)
                {
                    if(comp.equals(Row3[v]))
                    {
                        Trd[v].setBackground(Color.red);
                        break;
                    }
                }
                for(int b = 0; b < Row4.length; b++)
                {
                    if(comp.equals(Row4[b]))
                    {
                        Fourth[b].setBackground(Color.red);
                        break;
                    }
                }
                for(int m = 0; m < Row5.length; m++)
                {
                    if(comp.equals(Row5[m]))
                    {
                        Fifth[m].setBackground(Color.red);
                        break;
                    }
                }
            }
        }




    }
    /*
        This method takes the key released and changes its background color to the original color
        @param KeyEvent
     */
    public void keyReleased(KeyEvent evt)
    {
        //Stores the value of the key that was released
        Character temporary = Character.toUpperCase(evt.getKeyChar());
        String comp = Character.toString(temporary);

        for (int i = 0; i < A.length; i++) {
            if (temporary.equals(A[i])) {
                for (int x = 0; x < Row1.length; x++) {
                    if (comp.equals(Row1[x])) {
                        First[x].setBackground(regcolor);
                        break;
                    }
                }
                for (int c = 0; c < Row2.length; c++) {
                    if (comp.equals(Row2[c])) {
                        Sec[c].setBackground(regcolor);
                        break;
                    }
                }
                for (int v = 0; v < Row3.length; v++) {
                    if (comp.equals(Row3[v])) {
                        Trd[v].setBackground(regcolor);
                        break;
                    }
                }
                for (int b = 0; b < Row4.length; b++) {
                    if (comp.equals(Row4[b])) {
                        Fourth[b].setBackground(regcolor);
                        break;
                    }
                }
                for (int m = 0; m < Row5.length; m++) {
                    if (comp.equals(Row5[m])) {
                        Fifth[m].setBackground(regcolor);
                        break;
                    }
                }
            }

        }
    }
    /*
    This is the main function. All it does is create an instance of keyboard and make it visible
     */
    public static void main(String[] args)
    {
        new VisualAssist().setVisible(true);
    }
    /*
    This is the constructor. It initializes the virtual keyboard
     */
    public VisualAssist()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setPreferredSize(new Dimension(800,400));
        this.setLocation(50,50);

        InitWidgets();
    }
    /*
    This method creates all of the buttons and the window. It creates the buttons from the arrays of strings initilized
    and used the JButton arrays initialized as well

    @return void
    @param none
     */
    private void InitWidgets()
    {
        //Setting up the buttons
        JTextArea Text = new JTextArea();
        Text.setPreferredSize(new Dimension(600,200));

        JLabel Info = new JLabel("<html>Type something on yout keyboard.The keys pressed will be highlighted on the virtual keyboard.<br> Note : Clicking with your mouse will not do anything. <br><br> </html>" );

        Info.setFont(new Font("Verdana",Font.BOLD,12));

        //setting up the window
        setLayout(new BorderLayout());

        JPanel JpNorth = new JPanel();
        JPanel JpCenter = new JPanel();
        JPanel JpKeyboard = new JPanel();
        JPanel JpNote = new JPanel();
        add( JpNorth, BorderLayout.NORTH);
        add( JpNote);
        add( JpCenter, BorderLayout.CENTER);
        add(JpKeyboard, BorderLayout.SOUTH);

        JpNorth.setLayout(new BorderLayout());
        JpNorth.add(Info, BorderLayout.WEST);
        JpNorth.add(Info, BorderLayout.SOUTH);

        JpCenter.setLayout( new BorderLayout());
        JpCenter.add(Text, BorderLayout.WEST);
        JpCenter.add(Text, BorderLayout.CENTER);


        JpKeyboard.setLayout(new GridLayout(6,1));

        pack();

        //creating JButtons for the first row
        First = new JButton[Row1.length];
        //creating the grid of buttons from our string arrays
        JPanel Q = new JPanel(new GridLayout(1, Row1.length));
        //setting each button to the characters in our string arrays initialized earlier
        for(int j = 0; j < Row1.length; ++j)
        {
            //The setup in this loop is different from the rest because I am setting up the size of the buttons
            JButton B= new JButton(Row1[j]);
            B.setPreferredSize(new Dimension(90,40));
            First[j] = B;
            Q.add(First[j]);
        }
        JpKeyboard.add(Q);

        //creating the JButtons and grid for the second row
        Sec = new JButton[Row2.length];
        Q = new JPanel(new GridLayout(1, Row2.length));
        //setting each button equal to the characters in our string array for the second row
        for(int j = 0; j < Row2.length; ++j)
        {
            Sec[j] = new JButton(Row2[j]);
            Q.add(Sec[j]);

        }
        JpKeyboard.add(Q);
        //creating the JButtons and the grid for the third row
        Trd = new JButton[Row3.length];
        Q = new JPanel(new GridLayout(1, Row3.length));
        //this does the same as the previous loops
        for(int J = 0; J < Row3.length; ++J)
        {
            Trd[J] = new JButton(Row3[J]);
            Q.add(Trd[J]);
        }
        JpKeyboard.add(Q);

        //creating the JButtons and the grid for the fourth row
        Fourth = new JButton[Row4.length];
        Q = new JPanel(new GridLayout(1, Row4.length));
        //This does the same as the previous loops
        for(int J = 0; J < Row4.length; ++J)
        {
            Fourth[J] = new JButton(Row4[J]);
            Q.add(Fourth[J]);
            if(J==Row4.length-2)
                Q.add(new JPanel());

        }
        Q.add(new JPanel());
        JpKeyboard.add(Q);


        Fifth = new JButton[Row5.length];
        Q = new JPanel(new GridLayout(1, Row5.length));
        //This creates the space
        for(int J = 0; J < 1; ++J)
        {
            JPanel spacePanel = new JPanel();
            Q.add(spacePanel);
        }

        for(int J = 0; J < Row5.length; ++J)
        {
            //This if statement creates the space button
            if(J==0)
            {
                JButton B = new JButton(Row5[J]);
                Fifth[J]=B;

                Q.add(new JPanel());Q.add(new JPanel());Q.add(new JPanel());Q.add(new JPanel());Q.add(new JPanel());Q.add(new JPanel());Q.add(new JPanel());Q.add(new JPanel());
                Container GlassPane = (Container) getRootPane().getGlassPane();
                GlassPane.setVisible(true);
                GlassPane.setLayout(new GridBagLayout());
                GridBagConstraints Gbc = new GridBagConstraints();
                Gbc.weightx = 1.0;
                Gbc.weighty = 1.0;
                Gbc.fill = GridBagConstraints.NONE;
                Gbc.insets = new Insets(getBounds().y-350, 180, 0, 20);
                Gbc.anchor = GridBagConstraints.SOUTHWEST;
                B.setPreferredSize(new Dimension(450,50));
                GlassPane.add(Fifth[J], Gbc);
            }
            if(J==0)
            {
                JPanel spacePanel = new JPanel();
                Q.add(spacePanel);
            }
        }
        JpKeyboard.add(Q);

        getContentPane().addKeyListener(this);
        Text.addKeyListener(this);
        //adding key Listeners
        for(JButton B : First)
            B.addKeyListener(this);

        for(JButton B : Sec)
            B.addKeyListener(this);
        for(JButton B : Trd)
            B.addKeyListener(this);

        for(JButton B : Fourth)
            B.addKeyListener(this);

        for(JButton B : Fifth)
            B.addKeyListener(this);

    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        pressed = arg0;
    }
}