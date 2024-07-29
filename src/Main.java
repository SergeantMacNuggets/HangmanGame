import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

class Window extends JFrame implements ActionListener {
    private Menu menu,menu1;
    private Scene scene;
    private Categories category;
    Window() {
        this.setTitle("Hangman");
        this.setIconImage(new ImageIcon("src/BackgroundSprites/2230897.png").getImage());
        menu = new Menu();
        menu.playButton().addActionListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);
        this.setResizable(false);
        this.playSound(getClass().getResource("Sounds/Intro.wav"));
        this.add(menu);
        this.setVisible(true);
        this.pack();
    }

    private void playSound(URL sound) {
        Clip clip = null;
        try {
            AudioInputStream audioIn;
            audioIn = AudioSystem.getAudioInputStream(sound);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Intro.wav file cannot be found");
            System.exit(0);
        }
        clip.start();
    }

    private void setCategories(Categories c){
        for(JButton button: c.getButtons()) {
            button.addActionListener(this);
        }
    }

    private void addRemove(Scene scene) {
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