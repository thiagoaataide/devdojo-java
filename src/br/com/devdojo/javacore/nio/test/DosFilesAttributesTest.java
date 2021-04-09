package br.com.devdojo.javacore.nio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;

public class DosFilesAttributesTest {
    public static void main(String[] args) {
        Path path = Paths.get("folder2\\teste.txt");
        try {
            if (Files.notExists(path))
                Files.createFile(path);
            Files.setAttribute(path, "dos:hidden", true);
            Files.setAttribute(path, "dos:readonly", true);
            DosFileAttributes dos = Files.readAttributes(path, DosFileAttributes.class);
            System.out.println(dos.isHidden());
            System.out.println(dos.isReadOnly());

            /*Formas de setar atributos no arquivo usando Files ou a propria interface DosFileAttributeView*/
//            Files.setAttribute(path, "dos:hidden", false);
//            Files.setAttribute(path, "dos:readonly", false);
            DosFileAttributeView dosView = Files.getFileAttributeView(path,DosFileAttributeView.class);
            dosView.setHidden(false);
            dosView.setReadOnly(false);

            dos = Files.readAttributes(path, DosFileAttributes.class); //ler novamente os atributos do arquivo.
            System.out.println(dos.isHidden());
            System.out.println(dos.isReadOnly());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
