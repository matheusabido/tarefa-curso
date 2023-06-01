package textosequencial;

public class Main {

    public static void main(String[] args) throws Exception {
        TextFileManager manager = new TextFileManager();
        manager.openFile();
        manager.addRecords();
        manager.closeFile();
    }
}