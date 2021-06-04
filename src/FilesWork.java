import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class FilesWork {
    
    public static void main(String[] args) {
        
        File file = new File("test.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }

        File dir = new File(".");
        File[] files = dir.listFiles(new FileFilter() {

            @Override
            public boolean accept(File currentFile) {
                return currentFile.isFile();
            }
        });

        for (File f : files) {
            System.out.println(f.getName());
        }

        
    }
}
