
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.io.File;

public class BackgroundSelectorPanel extends JPanel {
    private boolean folderLoaded = false;

    public BackgroundSelectorPanel(BackgroundPanel backgroundPanel) {
        setLayout(new FlowLayout(FlowLayout.LEFT)); // Align to top-left

        // Simple button with text
        JButton loadBtn = new JButton("Backgrounds");

        loadBtn.addActionListener(e -> {
            if (folderLoaded) return;

            List<String> paths = BackgroundManager.loadBackgrounds();
            for (String path : paths) {
                JButton bgButton = new JButton(new File(path).getName());
                bgButton.addActionListener(ev -> backgroundPanel.setBackgroundImage(path));
                add(bgButton);
            }

            folderLoaded = true;
            revalidate();
            repaint();
        });

        add(loadBtn);
        setOpaque(false); // So background is visible
    }
}

