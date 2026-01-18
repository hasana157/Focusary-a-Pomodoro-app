import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PomodoroPanel extends JPanel {
    private JLabel timerLabel;
    private JTextArea quoteArea;

    private JButton startButton, pauseButton, resetButton;
    private PomodoroTimer pomodoroTimer;
    private QuoteManager quoteManager;

    public PomodoroPanel(QuoteManager quoteManager) {
        this.quoteManager = quoteManager;
        this.pomodoroTimer = new PomodoroTimer(25);

        setOpaque(false);
        setLayout(null); // Use null layout for absolute positioning

        // === QUOTE FLOATING TOP-RIGHT ===
        quoteArea = new JTextArea("Stay focused!");
        quoteArea.setFont(new Font("SansSerif", Font.BOLD, 16));
        quoteArea.setForeground(Color.WHITE);
        quoteArea.setOpaque(false);
        quoteArea.setEditable(false);
        quoteArea.setWrapStyleWord(true);
        quoteArea.setLineWrap(true);
        quoteArea.setFocusable(false);
        quoteArea.setBounds(700, 10, 280, 60); // Adjust for top-right placement
        add(quoteArea);

        // === TIMER LABEL ===
        timerLabel = new JLabel("25:00", SwingConstants.CENTER);
        timerLabel.setFont(new Font("SansSerif", Font.BOLD, 100));
        timerLabel.setForeground(Color.WHITE);
        timerLabel.setSize(400, 120);
        add(timerLabel); // We will set its location dynamically

        // === BUTTONS ===
        startButton = new JButton("Start");
        pauseButton = new JButton("Pause");
        resetButton = new JButton("Reset");

        startButton.setSize(80, 30);
        pauseButton.setSize(80, 30);
        resetButton.setSize(80, 30);

        add(startButton);
        add(pauseButton);
        add(resetButton);

        // === Position on Resize ===
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int panelWidth = getWidth();
                int panelHeight = getHeight();

                // Center the timer label
                int timerX = (panelWidth - timerLabel.getWidth()) / 2;
                int timerY = panelHeight / 2 - 100;
                timerLabel.setLocation(timerX, timerY);

                // Position buttons below the timer
                int buttonY = timerY + timerLabel.getHeight() + 20;
                int totalButtonWidth = 3 * 80 + 2 * 10;
                int startX = (panelWidth - totalButtonWidth) / 2;

                startButton.setLocation(startX, buttonY);
                pauseButton.setLocation(startX + 90, buttonY);  // 80 width + 10 spacing
                resetButton.setLocation(startX + 180, buttonY);
            }
        });

        // === Timer Logic ===
        pomodoroTimer.setOnTick(() -> SwingUtilities.invokeLater(() -> {
            int remaining = pomodoroTimer.getRemainingTime();
            timerLabel.setText(String.format("%02d:%02d", remaining / 60, remaining % 60));
        }));

        pomodoroTimer.setOnFinish(() -> SwingUtilities.invokeLater(() ->
                JOptionPane.showMessageDialog(this, "Time's up! Take a break.")
        ));

        startButton.addActionListener(e -> pomodoroTimer.start());
        pauseButton.addActionListener(e -> pomodoroTimer.pause());
        resetButton.addActionListener(e -> {
            pomodoroTimer.reset(25);
            timerLabel.setText("25:00");
        });
    }

    public void setRandomQuote() {
        quoteArea.setText(quoteManager.getRandomQuote());
    }
}
