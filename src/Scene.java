import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Scene extends JPanel{
    KeyboardLayout userInput;
    JButton quit;
    GuessWord word;
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
    public JButton getQuit() {
        return quit;
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
    ImageIcon[] icon;
    JLabel background;
    JLabel winState;
    Man() {
        winState = new JLabel("");
        winState.setForeground(Color.white);
        winState.setFont(new Font("Arial", Font.BOLD,23));
        icon = new ImageIcon[7];
        setSprites();
        background = new JLabel();
        background.setIcon(icon[0]);
        this.setPreferredSize(new Dimension(600,200));
        this.setBackground(Color.BLACK);
        this.add(winState);
        this.add(background);
    }

    public void setSprites() {
        icon[0] = new ImageIcon("src/Sprites/Sprite00.png");
        icon[1] = new ImageIcon("src/Sprites/Sprite01.png");
        icon[2] = new ImageIcon("src/Sprites/Sprite02.png");
        icon[3] = new ImageIcon("src/Sprites/Sprite03.png");
        icon[4] = new ImageIcon("src/Sprites/Sprite04.png");
        icon[5] = new ImageIcon("src/Sprites/Sprite05.png");
        icon[6] = new ImageIcon("src/Sprites/Sprite06.png");
    }

    public ImageIcon[] getSprites() {
        return icon;
    }

    public void setWinState(String s) {
        winState.setText(s);
    }

}