import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Window extends JFrame implements ActionListener {
    Menu menu,menu1;
    Scene scene;
    Categories category;
    Window() {
        this.setTitle("Hangman");
        this.setIconImage(new ImageIcon("src/BackgroundSprites/2230897.png").getImage());
        menu = new Menu();
        menu.playButton().addActionListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);
        this.setResizable(false);
        this.add(menu);
        this.setVisible(true);
        this.pack();
    }

    public void setCategories(Categories c){
        for(JButton button: c.getButtons()) {
            button.addActionListener(this);
        }
    }

    public void addRemove(Scene scene) {
        scene.getQuit().addActionListener(this);
        getContentPane().removeAll();
        getContentPane().add(scene);
        this.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton specificButton = (JButton) e.getSource();
        switch(specificButton.getText()) {
            case "Play":
                category = new Categories();
                getContentPane().removeAll();
                getContentPane().revalidate();
                setCategories(category);
                getContentPane().add(category);
                break;
            case "Sport":
                addRemove(new Scene(new Sport()));
                break;
            case "Animals":
                addRemove(new Scene(new Animals()));
                break;
            case "Job":
                addRemove(new Scene(new Job()));
                break;
            case "Food":
                addRemove(new Scene(new Food()));
                break;
            case "Country":
                addRemove(new Scene(new Country()));
                break;
            case "X":
                menu1 = new Menu();
                menu1.playButton().addActionListener(this);
                getContentPane().removeAll();
                getContentPane().revalidate();
                getContentPane().add(menu1);
                break;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        new Window();
    }
}