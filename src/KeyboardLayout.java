import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class KeyboardLayout extends JPanel implements ActionListener {
    private final JButton[] keys = new JButton[26];
    ActionListener keyListener;
    GuessWord hiddenWord;
    ImageIcon[] icon;
    WordDisplay display;
    int y=0;
    Man man;
    KeyboardLayout() {
        icon = new ImageIcon[6];
        hiddenWord = new GuessWord();
        display = new WordDisplay();
        man = new Man();
        this.setLayout(new GridLayout(2,2));
        this.setPreferredSize(new Dimension(600,100));
        setSprites();
        setKeys();
        addKeys();
        display.blanks.setText(hiddenWord.getBlank());
    }
    public void setKeys() {
        int ascii = 65;
        for(int i=0; i<keys.length;i++) {
            keys[i] = new JButton(Character.toString((char) ascii));
            keys[i].addActionListener(this);
            ascii++;
        }
    }
    public void addKeys() {
        for(JButton b: keys)
            this.add(b);
    }

    public WordDisplay getDisplay() {
        return display;
    }

    public Man getMan() {
        return man;
    }

    public void buttonState(JButton b) {
        if(hiddenWord.validity(b)) {
            b.setBackground(Color.GREEN);
            b.setEnabled(false);
        }
        else {
            man.miss.setText(Integer.toString(hiddenWord.getMistakes()));
            man.background.setIcon(icon[y]);
            b.setBackground(Color.RED);
            b.setEnabled(false);
            y++;
        }
    }

    public void setSprites() {
        icon[0] = new ImageIcon("src/Sprites/Sprite01.png");
        icon[1] = new ImageIcon("src/Sprites/Sprite02.png");
        icon[2] = new ImageIcon("src/Sprites/Sprite03.png");
        icon[3] = new ImageIcon("src/Sprites/Sprite04.png");
        icon[4] = new ImageIcon("src/Sprites/Sprite05.png");
        icon[5] = new ImageIcon("src/Sprites/Sprite06.png");
    }


    private void endState() {
        if(hiddenWord.checkGameState() && hiddenWord.checkWin()){
            man.test.setText("You Win!");
            for(JButton button: keys) {
                button.setEnabled(false);
            }
        }
        else if(hiddenWord.checkGameState() && !hiddenWord.checkWin()) {
            man.test.setText("You Lose!");
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
        repaint();
    }

}
