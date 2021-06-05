package command_line_parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class WordCounter {

    private String inFile;
    private String outFile;
    private static String testString = "Can i use this string in my program?\nYes, i can use it.";

    HashMap<String, Integer> words = new HashMap<String, Integer>();


    public WordCounter(String inFile, String outFile) {
        this.inFile = inFile;
        this.outFile = outFile;
    }


    public HashMap<String, Integer> getWords() {
        return words;
    }


    public void countWords() throws IOException {
        Reader reader;
        int num = 0;

        if (inFile == null) {
            reader = new StringReader(testString);
        } else {
            reader = new StringReader(inFile);
        }

        
        try (BufferedReader br = new BufferedReader(reader)) {

            for (String line = br.readLine(); line != null; line = br.readLine()) {
                StringTokenizer stkz = new StringTokenizer(line);

                while (stkz.hasMoreTokens()) {
                    String token = stkz.nextToken();
                    
                    if (words.containsKey(token)) {
                        int n = words.get(token);
                        n++;
                        words.put(token, n);
                    } else {
                        words.put(token, 1);
                        num++;
                    }
                }

            }

        } catch (IOException | NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("num = " + num);
    }    

}
