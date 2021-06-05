package command_line_parser;

import java.io.IOException;
import java.util.Enumeration;

public class MyCounter {

    public static void main(String[] args) {
        SimpleParser sp = new SimpleParser();
        // sp.Parse(args);

        // WordCounter wc = new WordCounter(null, null);
        WordCounter wc = new WordCounter(sp.getInFile(), null);
        
        try {
            wc.countWords();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Enumeration keys = wc.getWords().keys();
        while (keys.hasMoreElements()) {
            String w = keys.nextElement().toString();
            int n = (int) wc.getWords().get(w);
            System.out.println(w + "   " + n);
        }
    }
}
