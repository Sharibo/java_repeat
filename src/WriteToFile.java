import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class WriteToFile {

    public static void main(String[] args) {

        writeHelloToFile("hello.txt");

        String str;
        try {
            str = readFromFile("string.txt");
            System.out.println(str);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void writeHelloToFile(String hellotxt) {

        try (FileWriter writer = new FileWriter(hellotxt)) {
            writer.write("Привет из Java!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String readFromFile(String stringtxt) throws IOException {
        BufferedReader reader =
        new BufferedReader(new InputStreamReader(new FileInputStream(stringtxt), "UTF-8"));
        //new BufferedReader(new FileReader(stringtxt));

        String str = reader.readLine();
        return str;

    }
}
