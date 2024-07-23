import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class KeyboardLayout extends JPanel implements ActionListener {
    private final JButton[] keys = new JButton[26];
    GuessWord hiddenWord;
    KeyboardLayout() {
        hiddenWord = new GuessWord();
        this.setLayout(new GridLayout(2,2));
        this.setPreferredSize(new Dimension(800,200));
        this.setKeys();
        this.addKeys();
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

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton specificButton = (JButton) e.getSource();
        hiddenWord.gameState(specificButton);
    }
}
