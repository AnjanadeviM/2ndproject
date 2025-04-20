import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class URLShortener {
    private Map<String, String> shortToLong = new HashMap<>();
    private Map<String, String> longToShort = new HashMap<>();
    private static final String DOMAIN = "http://short.ly/";
    private int id = 1000;
    private static final String FILE_NAME = "links.txt";

    public URLShortener() {
        loadFromFile();
    }

    public String shortenURL(String longURL) {
        if (longToShort.containsKey(longURL)) {
            return DOMAIN + longToShort.get(longURL);
        }

        String shortCode = Integer.toHexString(id++);
        shortToLong.put(shortCode, longURL);
        longToShort.put(longURL, shortCode);
        saveToFile();
        return DOMAIN + shortCode;
    }

    public String expandURL(String shortURL) {
        String shortCode = shortURL.replace(DOMAIN, "");
        return shortToLong.getOrDefault(shortCode, "Invalid short URL!");
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Map.Entry<String, String> entry : shortToLong.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 2);
                if (parts.length == 2) {
                    shortToLong.put(parts[0], parts[1]);
                    longToShort.put(parts[1], parts[0]);
                }
            }
        } catch (IOException e) {
            // First run – file might not exist yet
        }
    }
}
