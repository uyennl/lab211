 package J1LP0025.ReadWriteFile;

import java.io.*;

public class ReadWriteFile {
    /**
     * read file
     */
    public String readFile(String filename) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        String content = new String();
        String line = null;

        while ((line = reader.readLine()) != null) {
            content += (line + '\n');
        }

        return content.substring(0, content.length() - 1); //remove \n at the end
    }

    /**
     * write to file
     */
    public void writeFile(String content, String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write(content);
        writer.close();
    }

}
