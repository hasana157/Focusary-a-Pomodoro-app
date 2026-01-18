import javax.sound.sampled.*;
import java.io.File;
import java.util.List;
import java.util.Iterator;

public class SoundManager {
    private Clip clip;
    private Iterator<String> songIterator;

    public void playSongs(List<String> songPaths) {
        if (songPaths == null || songPaths.isEmpty()) return;

        songIterator = songPaths.iterator();
        playNextSong();
    }

    private void playNextSong() {
        if (songIterator != null && songIterator.hasNext()) {
            String nextFile = songIterator.next();
            playSound(nextFile, this::playNextSong);  // callback to play next
        }
    }

    public void playSound(String filePath, Runnable onComplete) {
    try {
        if (clip != null) {
            clip.stop();
            clip.close();
        }

        AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File(filePath));
        clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();

        clip.addLineListener(event -> {
            if (event.getType() == LineEvent.Type.STOP) {
                clip.close();
                if (onComplete != null) onComplete.run();
            }
        });

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
}
