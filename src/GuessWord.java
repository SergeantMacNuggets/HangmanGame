import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.*;

class GuessWord extends JPanel {
    JLabel guess;
    GuessWord() {
        this.guess = new JLabel("_ _ _ _   _ _ _ _ _");
        guess.setFont(new Font("Ariel", Font.PLAIN, 34));
        guess.setForeground(Color.WHITE);
        this.setBackground(Color.BLUE);
        this.add(guess);
    }
}


