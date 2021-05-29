package command_line_parser;

public class ComLineParserMain {
    public static void main(String[] args) {
        String[] arguments = {"-wOutfileName", "-rInfileName"};

        ComLineParser cmp = new ComLineParser(new String[] {"?", "r", "w"});

        cmp.Parse(arguments);
    }
    
}
