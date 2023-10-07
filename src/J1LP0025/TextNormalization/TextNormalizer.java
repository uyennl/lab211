/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1LP0025.TextNormalization;


import J1LP0025.ReadWriteFile.ReadWriteFile;
import J1LP0025.TextNormalization.normalizer.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Text normalizer
 * This has normalizer "There are no blank lines between line"
 *
 * @author uyen
 */
public class TextNormalizer {
    private final String BASE_PATH = new File("").getAbsolutePath();
    private final String READ_PATH = "\\src\\J1LP0025\\data\\input.txt";
    private final String WRITE_PATH = "\\src\\J1LP0025\\data\\output.txt";
    private ArrayList<INormalizable> normalizers;
    ReadWriteFile readWriteFile = new ReadWriteFile();

    public TextNormalizer() {
        this.normalizers = new ArrayList<>();
    }

    /**
     * append new normalizer
     */
    public void addNormalizer(INormalizable normalizer) {
        this.normalizers.add(normalizer);
    }

    /**
     * normalize the source string and remove empty lines
     */
    public String normalize(String source) {
        StringTokenizer token = new StringTokenizer(source, "\n");
        String normalized = new String();

        while (token.hasMoreTokens()) {
            String line = token.nextToken().trim();
            if (line.isEmpty())
                continue;

            for (INormalizable normalizer : this.normalizers) {
                line = normalizer.normalize(line);
            }

            normalized += (line + '\n');
        }

        return normalized.substring(0, normalized.length() - 1); //remove \n at the end
    }

    public void normalizerText() {
        TextNormalizer normalizer = new TextNormalizer();

        normalizer.addNormalizer(new OnlySpaceBetweenWordsNormalizer());
        normalizer.addNormalizer(new OnlySpaceAfterMarkNormalizer(","));
        normalizer.addNormalizer(new OnlySpaceAfterMarkNormalizer(":"));
        normalizer.addNormalizer(new UppercaseFirstCharOfSentenceNormalizer());
        normalizer.addNormalizer(new DotAtTheEndNormalizer());
        normalizer.addNormalizer(new OnlySpaceBetweenMarkNormalizer("\""));
        normalizer.addNormalizer(new NoSpaceInQuoteNormalizer());

        String content = null;

        System.out.print("READING input.txt...");
        try {
            content = readWriteFile.readFile(BASE_PATH + READ_PATH);
        } catch (IOException ex) {
            System.out.println("FAIL");
            System.out.println("ERROR: " + ex.getMessage());
            System.exit(0);
        }
        System.out.println("DONE");

        System.out.print("NORMALIZING CONTENT...");
        String normalized = normalizer.normalize(content);
        System.out.println("DONE");

        System.out.println("WRITING CONTENT TO output.txt");
        try {
            readWriteFile.writeFile(normalized, BASE_PATH + WRITE_PATH);
        } catch (IOException ex) {
            System.out.println("FAIL.");
            System.out.println("ERROR: " + ex.getMessage());
            System.exit(0);
        }
        System.out.println("DONE");
    }
}
