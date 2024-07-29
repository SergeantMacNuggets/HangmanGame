import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.*;
import java.io.File;
import java.net.URL;

class KeyboardLayout extends JPanel implements ActionListener {
    private final JButton[] keys = new JButton[26];
    private ActionListener keyListener;
    private GuessWord hiddenWord;
    private ImageIcon[] sprites;
    private WordDisplay display;
    private AudioInputStream audioIn;
    private URL soundURL;
    private Clip clip;
    private int y=1;
    private Man man;
    KeyboardLayout(GuessWord hiddenWord) {
        soundURL = getClass().getResource("Sounds//Correct.wav");
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

    private void playSound() {
        try {
            audioIn = AudioSystem.getAudioInputStream(soundURL);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
        } catch (Exception e) {
            System.out.println("Audio file cannot be found");
        }
        clip.start();
    }

    private void setKeys() {
        int ascii = 65;
        for(int i=0; i<keys.length;i++) {
            keys[i] = new JButton(Character.toString((char) ascii));
            keys[i].addActionListener(this);
            ascii++;
        }
    }
    private void addKeys() {
        for(JButton b: keys) {
            b.setBackground(Color.BLACK);
            b.setForeground(Color.yellow);
            this.add(b);
        }
    }

    public WordDisplay getDisplay() {
        return display;
    }

    public Man getMan() {
        return man;
    }

    private void buttonState(JButton b) {
        if(hiddenWord.validity(b)) {
            b.setBackground(Color.GREEN);
            playSound();
            b.setEnabled(false);
        }
        else {
            man.background.setIcon(sprites[y]);
            b.setBackground(Color.RED);
            b.setEnabled(false);
            y++;
        }
    }

    private void endState() {
        if(hiddenWord.checkGameState() && hiddenWord.checkWin()){
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

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton specificButton = (JButton) e.getSource();
        buttonState(specificButton);
        display.blanks.setText(hiddenWord.getBlank());
        endState();
    }

}
