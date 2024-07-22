import javax.swing.JFrame;
import java.awt.*;

class Window extends JFrame {
    Window() {
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,800);
        this.setResizable(false);
        this.add(new Scene(),BorderLayout.CENTER);
        this.add(new KeyboardLayout(),BorderLayout.SOUTH);
        this.setVisible(true);
    }
}

public class Main {
    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "true");
        new Window();
    }
}