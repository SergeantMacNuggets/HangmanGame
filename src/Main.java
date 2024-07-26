import javax.swing.JFrame;
import java.awt.BorderLayout;

class Window extends JFrame {
    Window() {
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);
        this.setResizable(false);
        this.add(new Scene());
        this.setVisible(true);
        this.pack();
    }
}

public class Main {
    public static void main(String[] args) {
        new Window();
    }
}