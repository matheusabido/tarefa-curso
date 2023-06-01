package textosequencial;

import java.io.File;
import java.util.Scanner;

public class TextFileReader {
    private Scanner scanner;
    
    public void openFile() throws Exception {
        scanner = new Scanner(new File("clients.txt"));
    }
    
    public void readRecords() {
        Account account = new Account();
        while (scanner.hasNext()) {
            account.setAccount(scanner.nextInt());
            account.setFirstName(scanner.next());
            account.setLastName(scanner.next());
            account.setBalance(scanner.nextDouble());
            System.out.format("%-10d%-12s%-12s%10.2f\n", account.getAccount(), account.getFirstName(), account.getLastName(), account.getBalance());
        }
    }
    
    public void closeFile() {
        if (scanner != null) scanner.close();
    }
}