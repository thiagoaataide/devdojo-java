package br.com.devdojo.javacore.nio.test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

class AcharTodosOsBkp extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (file.getFileName().toString().endsWith(".bkp")) {
            System.out.println(file.getFileName());
        }
        return FileVisitResult.CONTINUE; //Continuar entrando em todos os diretórios e retornar
    }


}

class PrintDirs extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        System.out.println("pre: " + dir);
        if(dir.getFileName().toString().equals("subsubpast")){
//            return FileVisitResult.TERMINATE; //encerra a busca ao alcançar o diretório: subsubpasta
//            return FileVisitResult.SKIP_SUBTREE; //ao alcançar o diretório subsubpasta, ignorar da busca tudo que estiver dentro dele
            return FileVisitResult.SKIP_SIBLINGS; //Ignorar da busca diretórios que estejam no mesmo nível.

        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
        System.out.println("post: " + dir);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        System.out.println("file: " + file.getFileName());
        return FileVisitResult.CONTINUE; //Continuar entrando em todos os diretórios e retornar
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

}

public class FileVisitorTest {
    public static void main(String[] args) throws IOException {
//        Files.walkFileTree(Paths.get("pasta"), new AcharTodosOsBkp());
        Files.walkFileTree(Paths.get("pasta"), new PrintDirs());
    }
}
