import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.*;
import java.io.File;
import java.net.URL;
/**
 * Represents a keyboard layout for a hangman-style game. This panel includes
 * buttons for each letter of the alphabet and manages interactions between the
 * user and the game state. It updates the display and sound effects based on
 * user input and game progress.
 * <p>
 * This class extends {@link JPanel} and implements {@link ActionListener} to
 * handle button clicks. It contains buttons for each letter, a word display,
 * and manages the game state and sound effects.
 * </p>
 */
class KeyboardLayout extends JPanel implements ActionListener {
    private final JButton[] keys = new JButton[26];
    private ActionListener keyListener;
    private GuessWord hiddenWord;
    private ImageIcon[] sprites;
    private ImageIcon missingWordSprite;
    private WordDisplay display;
    private URL soundURL;
    private int y=1;
    private Man man;
    /**
     * Constructs a {@code KeyboardLayout} panel with the given hidden word.
     * <p>
     * Initializes the layout, creates buttons for each letter, sets up sound
     * effects, and configures the display for the hidden word.
     * </p>
     * @param hiddenWord the {@link GuessWord} object representing the word to be guessed
     */
    KeyboardLayout(GuessWord hiddenWord) {
        soundURL = getClass().getResource("Sounds/Correct.wav");
        this.hiddenWord = hiddenWord;
        display = new WordDisplay();
        man = new Man();
        sprites = man.getSprites();
        this.setLayout(new GridLayout(2,2));
        this.setPreferredSize(new Dimension(600,100));
        setKeys();
        addKeys();
        display.blanks.setText(hiddenWord.getBlank());
    }
    /**
     * Plays a sound effect when a correct letter is guessed.
     * <p>
     * Loads and plays the sound from the specified URL.
     * </p>
     * @param sound the URL of the sound file to be played
     */
    private void playSound(URL sound) {
        Clip clip = null;
        try {
            AudioInputStream audioIn;
            audioIn = AudioSystem.getAudioInputStream(sound);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Correct.wav file cannot be found");
            System.exit(0);

        }
        clip.start();
    }
    /**
     * Initializes buttons for each letter of the alphabet.
     * <p>
     * Each button is assigned a letter and an action listener.
     * </p>
     */
    private void setKeys() {
        int ascii = 65;
        for(int i=0; i<keys.length;i++) {
            keys[i] = new JButton(Character.toString((char) ascii));
            keys[i].addActionListener(this);
            ascii++;
        }
    }
    /**
     * Adds the letter buttons to the panel with specific styling.
     * <p>
     * Sets the background color of the buttons to black and the foreground color
     * to yellow.
     * </p>
     */
    private void addKeys() {
        for(JButton b: keys) {
            b.setBackground(Color.BLACK);
            b.setForeground(Color.yellow);
            this.add(b);
        }
    }
    /**
     * Returns the {@link WordDisplay} object used to show the current state of the word.
     * @return the {@link WordDisplay} object
     */
    public WordDisplay getDisplay() {
        return display;
    }

    /**
     * Returns the {@link Man} object representing the hangman figure.
     * @return the {@link Man} object
     */
    public Man getMan() {
        return man;
    }
    /**
     * Updates the state of the button based on whether the guessed letter is correct.
     * <p>
     * Changes the button color and disables it. Updates the hangman figure and plays
     * a sound if the guess is correct.
     * </p>
     * @param b the {@link JButton} representing the guessed letter
     */
    private void buttonState(JButton b) {
        if(hiddenWord.validity(b)) {
            b.setBackground(Color.GREEN);
            playSound(soundURL);
            b.setEnabled(false);
        }
        else {
            man.background.setIcon(sprites[y]);
            b.setBackground(Color.RED);
            b.setEnabled(false);
            y++;
        }
    }
    /**
     * Ends the game by checking the final state and updating the display accordingly.
     * <p>
     * Shows a win or lose message and updates the background image based on the game result.
     * Disables all letter buttons.
     * </p>
     */
    private void endState() {
        if(hiddenWord.checkGameState() && hiddenWord.checkWin()){
            try {
                missingWordSprite = new ImageIcon(getClass().getClassLoader().getResource("Sprites/" +
                        hiddenWord.getClassWord() + "/" + hiddenWord.getSecretWord() + ".png"));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, hiddenWord.getSecretWord() + ".png file cannot be found");
            }
            man.background.setIcon(missingWordSprite);
            man.setWinState("You Win!");
            for(JButton button: keys) {
                button.setEnabled(false);
            }
        }
        else if(hiddenWord.checkGameState() && !hiddenWord.checkWin()) {
            man.setWinState("You Lose!");
            for(JButton button: keys) {
                button.setEnabled(false);
            }
        }
    }
    /**
     * Handles button click events. Updates button state, word display, and game state.
     * @param e the {@link ActionEvent} representing the button click
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton specificButton = (JButton) e.getSource();
        buttonState(specificButton);
        display.blanks.setText(hiddenWord.getBlank());
        endState();
    }

}
