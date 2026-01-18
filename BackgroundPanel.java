import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    // Default constructor loads default image
    public BackgroundPanel() {
        setBackgroundImage("Default.jpg");
    }

    // Constructor with custom image path
    public BackgroundPanel(String initialPath) {
        setBackgroundImage(initialPath);
    }

    public void setBackgroundImage(String path) {
        try {
            backgroundImage = new ImageIcon(path).getImage();
        } catch (Exception e) {
            System.out.println("Failed to load background: " + path);
            backgroundImage = null;
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
