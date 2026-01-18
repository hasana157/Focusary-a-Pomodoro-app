import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class MainFrame extends JFrame {
    private ToDoPanel toDoPanel;
   private NotesPanel notesPanel;
private JButton todoButton;
private JButton notesButton;
private SoundManager soundManager;
      
    private QuoteManager quoteManager;
    private PomodoroPanel pomodoroPanel;
    private JButton pomodoroButton;
    private JLabel timeLabel;
    private JLabel greetingLabel;j
    private Timer timer;

    // CardLayout components
    private JPanel cardPanel;
    private CardLayout cardLayout;

    public MainFrame() {
        setTitle("Focusary");
        setSize(1000, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        quoteManager = new QuoteManager();

        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(new BorderLayout());

        // Initialize CardLayout
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setOpaque(false);

        // === Center Panel (Main View: Clock + Greeting) ===
        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(false);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        greetingLabel = new JLabel("Rest easy. You've done well today!");
        greetingLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        greetingLabel.setForeground(Color.WHITE);
        greetingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        greetingLabel.setHorizontalAlignment(SwingConstants.CENTER);

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("SansSerif", Font.BOLD, 120));
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        updateTime();

        centerPanel.add(Box.createVerticalGlue());
        centerPanel.add(greetingLabel);
        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(timeLabel);
        centerPanel.add(Box.createVerticalGlue());

        // === Pomodoro Panel ===
        pomodoroPanel = new PomodoroPanel(quoteManager);
        pomodoroPanel.setOpaque(false);
        toDoPanel = new ToDoPanel();
       toDoPanel.setOpaque(false);
        cardPanel.add(toDoPanel, "TODO");

       notesPanel = new NotesPanel();
         notesPanel.setOpaque(false);
          cardPanel.add(notesPanel, "NOTES");


        cardPanel.add(centerPanel, "MAIN");
        cardPanel.add(pomodoroPanel, "POMODORO");

        JPanel selectorPanel = new BackgroundSelectorPanel(backgroundPanel);
        selectorPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        selectorPanel.setOpaque(false);

        pomodoroButton = new JButton("Pomodoro");
        selectorPanel.add(pomodoroButton);
        todoButton = new JButton("Tasks");
notesButton = new JButton("Notes");

soundManager = new SoundManager();

JButton playMusicButton = new JButton("Play Music");
JButton stopMusicButton = new JButton("Stop Music");
selectorPanel.add(playMusicButton);
selectorPanel.add(stopMusicButton);

playMusicButton.addActionListener(e -> {
   ArrayList<String> songs = SongSelectorPanel.loadSongsFromFolder("Sounds");
   System.out.println("Loaded songs: " + songs); // Debug

   if (songs.isEmpty()) {
       JOptionPane.showMessageDialog(this, "No songs found!");
   } else {
       soundManager.playSongs(songs);
   }
});

stopMusicButton.addActionListener(e -> soundManager.stop());



selectorPanel.add(todoButton);
selectorPanel.add(notesButton);

todoButton.addActionListener(e -> cardLayout.show(cardPanel, "TODO"));
notesButton.addActionListener(e -> cardLayout.show(cardPanel, "NOTES"));


        pomodoroButton.addActionListener(e -> {
            boolean showPomodoro = !pomodoroPanel.isShowing();
            if (showPomodoro) {
                pomodoroPanel.setRandomQuote();
                cardLayout.show(cardPanel, "POMODORO");
            } else {
                cardLayout.show(cardPanel, "MAIN");
            }
            revalidate();
            repaint();
        });

        backgroundPanel.add(selectorPanel, BorderLayout.NORTH);
backgroundPanel.add(cardPanel, BorderLayout.CENTER);

// Show MAIN view on startup
cardLayout.show(cardPanel, "MAIN");

timer = new Timer(1000, e -> updateTime());
timer.start();

setContentPane(backgroundPanel);
setVisible(true);

    }

    private void updateTime() {
        String timeStr = new SimpleDateFormat("HH:mm").format(new Date());
        timeLabel.setText(timeStr);
    }

    public static void main(String[] args) {
        BackgroundManager.initializeBackgrounds();
        SwingUtilities.invokeLater(MainFrame::new);
    }
}