import java.io.File;
import java.util.ArrayList;

public class SongSelectorPanel {
    public static ArrayList<String> loadSongsFromFolder(String folderPath) {
        ArrayList<String> songs = new ArrayList<>();
        File folder = new File(folderPath);

        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".wav"));

            if (files != null) {
                for (File file : files) {
                    songs.add(file.getAbsolutePath());
                }
            }
        }

        return songs;
    }
}
