package command_line_parser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimpleParser extends ComLineParser {
    private String inFile;
    private String outFile;

    public String getInFile() {
        
        try {
            inFile = readFromFile("readme.txt");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        return inFile;
    }    

    private static String readFromFile(String File) throws IOException {
        BufferedReader br =
        new BufferedReader(new InputStreamReader(new FileInputStream(File), "UTF-8"));

        StringBuffer sb = new StringBuffer();
        
        String fileLine = "";
        
        while (true) {
            fileLine = br.readLine();

            if (fileLine != null) {
                sb.append(fileLine);
            } else {
                break;
            }
        }

        return sb.toString();

    }

    public String getOutFile() {
        return outFile;
    }


    public SimpleParser() {
        super(new String[] { "?", "r", "w" });
    }

    @Override
    protected void OnUsage(String errorKey) {
        if (errorKey != null)
            System.out.println("Command-line switch error:" + errorKey);

        System.out.println("формат ком.строки: имяПрограммы [-r<input-fileName>] [-w<output-fileName>]");
        System.out.println("   -?  показать Help файл");
        System.out.println("   -r  задать имя входного файла");
        System.out.println("   -w  выполнить вывод в указанный файл");
    }

    @Override
    protected SwitchStatus OnSwitch(String key, String keyValue) {
        SwitchStatus status = SwitchStatus.NoError;

        switch (key) {
            case "?":
                status = SwitchStatus.ShowUsage;
                break;
            case "r":
                if (keyValue.length() < 1) {
                    System.out.println("Нет имени входного файла.");
                    status = SwitchStatus.Error;
                } else
                    inFile = keyValue;
                break;
            case "w":
                if (keyValue.length() < 1) {
                    System.out.println("Нет имени выходного файла.");
                    status = SwitchStatus.Error;
                } else
                    outFile = keyValue;
                break;
            default:
                status = SwitchStatus.Error;
                break;
        }
        return status;
    }
}
