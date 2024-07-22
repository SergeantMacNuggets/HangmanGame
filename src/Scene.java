import javax.swing.JPanel;
import java.awt.*;


class Scene extends JPanel{
    Scene() {
        this.setBackground(Color.BLUE);
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(800,400));
        this.add(new GuessWord(),BorderLayout.SOUTH);
    }
}
