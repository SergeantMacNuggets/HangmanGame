import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Scene extends JPanel{
    KeyboardLayout userInput;
    Scene() {
        userInput = new KeyboardLayout();
//        background = new ImageIcon("src/BackgroundSprites/Background.png");
        this.setLayout(new BorderLayout());
        this.add(userInput.getDisplay(), BorderLayout.EAST);
        this.add(userInput,BorderLayout.SOUTH);
        this.add(userInput.getMan(),BorderLayout.NORTH);
    }

}

class WordDisplay extends JPanel {
    JLabel blanks;
    WordDisplay() {
        blanks = new JLabel("");
        blanks.setFont(new Font("Arial", Font.BOLD,34));
        this.setPreferredSize(new Dimension(600,40));
        this.setBackground(Color.BLACK);
        blanks.setForeground(Color.yellow);
        this.add(blanks);
    }
}

class Man extends JPanel {
    ImageIcon icon;
    JLabel background;
    JLabel test;
    JLabel miss;
    Man() {
        background = new JLabel();
        icon = new ImageIcon("src/Sprites/Sprite00.png");
        background.setIcon(icon);
        this.setPreferredSize(new Dimension(600,200));
        this.setBackground(Color.BLACK);
        test = new JLabel("Currently Playing");
        miss = new JLabel("6");
        this.add(test);
        this.add(miss);
        this.add(background);
    }
}