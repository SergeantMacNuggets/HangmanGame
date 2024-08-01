import javax.swing.*;
import java.awt.*;
/**
 * The {@code Scene} class represents the main panel for the game scene. It organizes and displays
 * various components including a quit button, user input interface, and a guessing word component.
 */
class Scene extends JPanel{
    private KeyboardLayout userInput;
    private JButton quit;
    private GuessWord word;
    /**
     * Constructs a {@code Scene} object.
     * @param w the {@code Words} object used to initialize the {@code GuessWord} component
     */
    Scene(Words w) {
        word = new GuessWord(w);
        quit = new JButton("X");
        quit.setFont(new Font("Arial",Font.BOLD,14));
        quit.setPreferredSize(new Dimension(45,40));
        quit.setBackground(Color.black);
        quit.setForeground(Color.red);
        quit.setBorderPainted(false);
        userInput = new KeyboardLayout(word);
        this.setLayout(new BorderLayout());
        this.add(quit,BorderLayout.LINE_START);
        this.add(userInput.getDisplay(), BorderLayout.EAST);
        this.add(userInput,BorderLayout.SOUTH);
        this.add(userInput.getMan(),BorderLayout.NORTH);
    }
    /**
     * Returns the quit button of the scene.
     *
     * @return the {@code JButton} used to quit the game
     */
    public JButton getQuit() {
        return quit;
    }
}
/**
 * The {@code WordDisplay} class represents a panel that displays the blanks for the guessing word.
 */
class WordDisplay extends JPanel {
    JLabel blanks;
    /**
     * Constructs a {@code WordDisplay} object.
     * Initializes the display with a blank label set to a specific font and color.
     */
    WordDisplay() {
        blanks = new JLabel("");
        blanks.setFont(new Font("Arial", Font.BOLD,34));
        this.setPreferredSize(new Dimension(600,40));
        this.setBackground(Color.BLACK);
        blanks.setForeground(Color.yellow);
        this.add(blanks);
    }
}
/**
 * The {@code Man} class represents a panel that displays a series of sprites and win state information.
 */
class Man extends JPanel {
    private ImageIcon[] icon;
    JLabel background;
    private JLabel winState;
    /**
     * Constructs a {@code Man} object.
     * Initializes the panel with a win state label and loads the sprite images.
     */
    Man() {
        winState = new JLabel("");
        winState.setForeground(Color.white);
        winState.setFont(new Font("Arial", Font.BOLD,23));
        icon = new ImageIcon[7];
        try {
            setSprites();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Sprites file are missing in the folder");
            System.exit(0);
        }
        background = new JLabel();
        background.setIcon(icon[0]);
        this.setPreferredSize(new Dimension(600,200));
        this.setBackground(Color.BLACK);
        this.add(winState);
        this.add(background);
    }
    /**
     * Loads sprite images from resources into the icon array.
     * @throws Exception if the sprite files are not found or cannot be loaded
     */
    public void setSprites() throws Exception{
        icon[0] = new ImageIcon(getClass().getClassLoader().getResource("Sprites/Background/Sprite00.png"));
        icon[1] = new ImageIcon(getClass().getClassLoader().getResource("Sprites/Background/Sprite01.png"));
        icon[2] = new ImageIcon(getClass().getClassLoader().getResource("Sprites/Background/Sprite02.png"));
        icon[3] = new ImageIcon(getClass().getClassLoader().getResource("Sprites/Background/Sprite03.png"));
        icon[4] = new ImageIcon(getClass().getClassLoader().getResource("Sprites/Background/Sprite04.png"));
        icon[5] = new ImageIcon(getClass().getClassLoader().getResource("Sprites/Background/Sprite05.png"));
        icon[6] = new ImageIcon(getClass().getClassLoader().getResource("Sprites/Background/Sprite06.png"));
    }
    /**
     * Returns the array of sprite images.
     * @return an array of {@code ImageIcon} objects representing the sprites
     */
    public ImageIcon[] getSprites() {
        return icon;
    }
    /**
     * Sets the text of the win state label.
     * @param s the text to display for the win state
     */
    public void setWinState(String s) {
        winState.setText(s);
    }
}