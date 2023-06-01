package textosequencial;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        if (!new File("clients.txt").exists()) {
            TextFileManager manager = new TextFileManager();
            manager.openFile();
            manager.addRecords();
            manager.closeFile();
        } else {
            TextFileReader reader = new TextFileReader();
            reader.openFile();
            reader.readRecords();
            reader.closeFile();
        }
    }
}