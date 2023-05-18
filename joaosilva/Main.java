package joaosilva;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        String path = JOptionPane.showInputDialog(null, "Entre o caminho do arquivo");
        analyze(path);
    }
    
    private static void analyze(String path) {
        File file = new File(path);
        if (file.exists()) {
            String name = file.getName() + " existe";
            String isArquivo = file.isFile() ? "É um arquivo" : "Não é um arquivo";
            String isDiretorio = file.isDirectory() ? "É um diretório" : "Não é um diretório";
            String isAbsolute = file.isAbsolute() ? "É absoluto" : "Não é absoluto";
            String modified = "Modificado pela útlima vez: " + file.lastModified();
            String length = "Tamanho: " + file.length();
            String caminho = "Caminho: " + file.getPath();
            String caminhoAbsoluto = "Caminho completo: " + file.getAbsolutePath();
            String parent = "Parent: " + file.getParent();            
            StringBuilder builder = new StringBuilder();
            builder.append(Arrays.stream(new String[]{name, isArquivo, isDiretorio, isAbsolute, modified, length, caminho, caminhoAbsoluto, parent}).collect(Collectors.joining("\n")));
            if (file.isDirectory()) {
                builder.append("\nArquivos na pasta:");
                Arrays.stream(file.list()).map(l -> "\n" + l).forEach(builder::append);
            }
            JOptionPane.showMessageDialog(null, builder.toString());
        } else {
            JOptionPane.showMessageDialog(null, path + " não existe");
        }
    }
}