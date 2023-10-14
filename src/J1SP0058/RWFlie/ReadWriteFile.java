package J1SP0058.RWFlie;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ReadWriteFile {
    private static final String BASE_PATH = new File("").getAbsolutePath();
    private static final String READ_PATH = "\\src\\J1SP0058\\Data\\dictionary.txt";
    private static final String DICTIONARY_FILE = BASE_PATH + READ_PATH;

    public void loadWordsFromFile(HashMap<String, String> hm) {
        try (BufferedReader reader = new BufferedReader(new FileReader(DICTIONARY_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    hm.put(parts[0], parts[1]);
                }
            }
            System.out.println("Dictionary loaded successfully.");
        } catch (IOException e) {
            System.out.println("No existing dictionary found. Creating a new one.");
        }
    }

    public void saveWordsToFile(HashMap<String, String> hm) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DICTIONARY_FILE))) {
            for (Map.Entry<String, String> entry : hm.entrySet()) {
                writer.println(entry.getKey() + "," + entry.getValue());
            }
            System.out.println("Dictionary saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving dictionary to the file.");
        }
    }
}