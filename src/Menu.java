import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel {
    private JButton play;
    private JButton quit;
    private JLabel title;
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

    public JButton playButton() {
        return play;
    }
}

class Categories extends JPanel {
    private JLabel option;
    private JButton[] choice;
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

    public JButton[] getButtons() {
        return choice;
    }

    private JButton setButtons(String s, int x, int y) {
        JButton b = new JButton(s);
        b.setBounds(x,y,80,30);
        return b;
    }
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
