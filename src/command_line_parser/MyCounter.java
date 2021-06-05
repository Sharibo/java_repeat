package command_line_parser;

import java.io.IOException;
import java.util.Map;

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

        
        for ( Map.Entry<String, Integer> entry : wc.getWords().entrySet() ) {
            System.out.println(entry.getKey() + "   " + entry.getValue());
        }

    }
}
