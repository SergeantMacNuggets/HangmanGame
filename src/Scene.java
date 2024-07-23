import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.BorderLayout;


class Scene extends JPanel{
    Scene() {
        ImageIcon background = new ImageIcon("BackgroundSprites\\Background.png");
        this.setLayout(new BorderLayout());
//        this.setPreferredSize(new Dimension(800,400));
        this.add(new JLabel(background));
        this.add(new GuessWord(),BorderLayout.SOUTH);
    }
}
