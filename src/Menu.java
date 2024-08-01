import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Represents the main menu of the application.
 * This panel provides options to start the game or exit the application.
 * It contains a title label, a "Play" button, and an "Exit" button.
 */
public class Menu extends JPanel {
    private JButton play;
    private JButton quit;
    private JLabel title;
    /**
     * Constructs a new Menu panel.
     * Initializes and configures the title label, play button, and quit button.
     * Sets layout, dimensions, and background color for the panel.
     * Adds an action listener to the quit button to exit the application when clicked.
     */
    Menu() {
        title = new JLabel("Hangman");
        play = new JButton("Play");
        quit = new JButton("Exit");
        play.setForeground(Color.yellow);
        play.setBackground(Color.DARK_GRAY);
        quit.setForeground(Color.red);
        quit.setBackground(Color.DARK_GRAY);
        title.setFont(new Font("Arial",Font.BOLD,55));
        title.setForeground(Color.yellow);
        title.setBounds(170,30,600,100);
        play.setBounds(230,160,130,50);
        quit.setBounds(230,240,130,50);
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(600,360));
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        this.add(title);
        this.add(play);
        this.add(quit);
    }
    /**
     * Returns the "Play" button.
     * @return the JButton used to start the game.
     */
    public JButton playButton() {
        return play;
    }
}
/**
 * Represents the categories selection panel.
 * This panel displays a list of category options for the user to choose from.
 * It contains a label and a set of buttons representing different categories.
 */
class Categories extends JPanel {
    private JLabel option;
    private JButton[] choice;
    /**
     * Constructs a new Categories panel.
     * Initializes and configures the option label and buttons.
     * Sets layout, dimensions, and background color for the panel.
     * Calls a method to add buttons to the panel.
     */
    Categories() {
        choice = new JButton[5];
        option = new JLabel("Choose Categories:");
        this.setLayout(null);
        this.setPreferredSize(new Dimension(600,360));
        this.setBackground(Color.BLACK);
        option.setFont(new Font("Arial",Font.BOLD,20));
        option.setBounds(30,30,600,100);
        option.setForeground(Color.orange);
        addButtons();
        this.add(option);
    }
    /**
     * Returns an array of category buttons.
     * @return an array of JButtons representing category options.
     */
    public JButton[] getButtons() {
        return choice;
    }
    /**
     * Creates a JButton with the specified label and position.
     * @param s the label for the button.
     * @param x the x-coordinate for the button's position.
     * @param y the y-coordinate for the button's position.
     * @return a JButton configured with the specified label and position.
     */
    private JButton setButtons(String s, int x, int y) {
        JButton b = new JButton(s);
        b.setBounds(x,y,80,30);
        return b;
    }
    /**
     * Initializes and adds category buttons to the panel.
     * Configures the appearance of each button and places them on the panel.
     */
    private void addButtons() {
        int y = 120;
        String[] name = {"Sport", "Food", "Country", "Job", "Animals"};
        for(int i=0,x=30; i<choice.length;x+=100,i++) {
            choice[i] = setButtons(name[i],x,y);
            choice[i].setForeground(Color.yellow);
            choice[i].setBackground(Color.DARK_GRAY);
            this.add(choice[i]);
        }
    }
}
