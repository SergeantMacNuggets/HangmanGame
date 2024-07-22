import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.*;

class KeyboardLayout extends JPanel {
    JButton[] keys = new JButton[26];

    KeyboardLayout() {
        this.setLayout(new GridLayout(2,2));
        this.setKeys();
        this.addKeys();
    }

    public void setKeys() {
        int ascii = 65;
        for(int i=0; i<keys.length;i++) {
            keys[i] = new JButton(Character.toString((char) ascii));
            ascii++;
        }
    }
    public void addKeys() {
        for(JButton b: keys) {
            this.add(b);
        }
    }
}
