package br.com.devdojo.javacore.nio.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CriandoPathTest {
    public static void main(String[] args) {
        //C:\Users\Thiago Alberto\workspaceSankhya\projetos\clientes\devdojo
        //é possível obter o arquivo de todas as formas abaixo.
        Path p1 = Paths.get("C:\\Users\\Thiago Alberto\\workspaceSankhya\\projetos\\clientes\\devdojo\\Arquivo.txt");
        Path p2 = Paths.get("C:\\Users\\Thiago Alberto\\workspaceSankhya\\projetos\\clientes\\devdojo", "Arquivo.txt");
        Path p3 = Paths.get("C:", "\\Users\\Thiago Alberto\\workspaceSankhya\\projetos\\clientes\\devdojo", "Arquivo.txt");
        Path p4 = Paths.get("C:", "Users", "Thiago Alberto", "workspaceSankhya", "projetos", "clientes", "devdojo", "Arquivo.txt");

//        System.out.println(p4.toAbsolutePath());
        File file = p4.toFile();
        Path path = file.toPath();

        Path path1 = Paths.get("pasta");
        Path path2 = Paths.get("pasta\\subpasta\\subsubpast");
        Path arquivo = Paths.get("pasta\\subpasta\\subsubpast\\file.txt");
        try {
            if (Files.notExists(path2.getParent()))
//            Files.createDirectories(path2); // criação de vários
                Files.createDirectories(path2.getParent()); // como path2 tem o caminho + arquivo, o getParent() vai obter apenas os dados dos diretórios.
//            Files.createDirectory(path1); //apenas um diretório, retorna exceção se houver um ou mais deiretórios na hierarquia não criados.

            if (Files.notExists(arquivo))
                Files.createFile(arquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path source = Paths.get("folder2/Arquivo2.txt");
//        Path target = Paths.get("pasta\\subpasta\\subsubpast");
        Path target = Paths.get(path2.toString() + "\\arquivoCopiado2.txt");

        try {
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            /*Através da classe StandardCopyOption temos as opções de cópia para o método copy*/

            //deletando um arquivo
            Files.deleteIfExists(target);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
