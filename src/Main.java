import javax.swing.JFrame;
import java.awt.*;

class Window extends JFrame {
    Window() {
        this.setLayout(new GridLayout(2,0));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,800);
        this.setResizable(false);
        this.add(new Scene());
        this.add(new KeyboardLayout());
        this.setVisible(true);

    }
}

public class Main {
    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "true");
        new Window();
    }
}