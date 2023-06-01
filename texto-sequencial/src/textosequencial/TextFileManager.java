package textosequencial;

import java.util.Formatter;
import java.util.Scanner;

public class TextFileManager {
    private Formatter output;
    
    public void openFile() throws Exception {
        output = new Formatter("clients.txt");
    }
    
    public void addRecords() {
        Account account = new Account();
        Scanner scanner = new Scanner(System.in);
        System.out.println("{account} {first name} {last name} {balance}");
        do {
            try {
                account.setAccount(scanner.nextInt());
                account.setFirstName(scanner.next());
                account.setLastName(scanner.next());
                account.setBalance(scanner.nextDouble());
                if (account.getAccount() > 0) {
                    output.format("%d %s %s %.2f\n", account.getAccount(), account.getFirstName(), account.getLastName(), account.getBalance());
                } else {
                    System.out.println("Código inválido.");
                }
            } catch (Exception ex) {}
        } while (continuar(scanner));
    }
    
    public boolean continuar(Scanner scanner) {
        System.out.print("Continuar (true/false): ");
        return scanner.nextBoolean();
    }
    
    public void closeFile() {
        if (output != null) output.close();
    }
}