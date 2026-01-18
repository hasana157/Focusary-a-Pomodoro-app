// BackgroundManager.java
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class BackgroundManager {
    private static final String DATA_FILE = "backgrounds.ser";
    private static final String BG_FOLDER = "Backgrounds";

    // Load from folder and serialize
    public static void initializeBackgrounds() {
        File folder = new File(BG_FOLDER);
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".png") || name.endsWith(".jpg"));

        List<String> paths = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                paths.add(file.getPath());
            }
        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            out.writeObject(paths);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Deserialize
    public static List<String> loadBackgrounds() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            return (List<String>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
