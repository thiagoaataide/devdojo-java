package br.com.devdojo.javacore.io.test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileTest {
    public static void main(String[] args) {
        File file = new File("Arquivo.txt"); // assim cria o arquivo dentro do projeto, também é possível passar o caminho do arquivo.

        try {
            boolean newFile = file.createNewFile();
            System.out.println(newFile);
            boolean exists = file.exists();

            System.out.println(file.getAbsolutePath());
            System.out.println(file.getPath());
//            if(exists){
//                System.out.println("Existe o arquivo? " + exists);
//                file.delete();
//            }

            boolean r = file.canRead(); // Permissão de Leitura
            boolean w = file.canWrite(); // Permissão de Escrita
            boolean x = file.canExecute(); // Permissão de Execução
            boolean directory = file.isDirectory(); //Diretório?
            boolean hidden = file.isHidden();// oculto?
            System.out.println(new Date(file.lastModified()));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
