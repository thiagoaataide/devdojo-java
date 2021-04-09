package br.com.devdojo.javacore.nio.test;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AtributosBasicosTest {
    public static void main(String[] args) throws IOException {
        //getTime() no Calendar retorna um Date
        Date primeiroDeDezembro = new GregorianCalendar(2015, Calendar.DECEMBER, 1).getTime();
        File file = new File("folder\\Arquivo3.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //getTime() no Date retorna um Long
        file.setLastModified(primeiroDeDezembro.getTime());
        System.out.println(file.lastModified());
        file.delete();

        Path path = Paths.get("folder\\Arquivo4.txt");
        try {
            if (Files.notExists(path))
                Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileTime fileTime = FileTime.fromMillis(primeiroDeDezembro.getTime());
        Files.setLastModifiedTime(path, fileTime);
        System.out.println(Files.getLastModifiedTime(path));
        Files.deleteIfExists(path);

        /*Atributos Básicos das Novas Classes*/

        path = Paths.get("C:\\Users\\Thiago Alberto\\workspaceSankhya\\projetos\\clientes\\devdojo\\src\\br\\com\\devdojo\\javacore\\introducaoclasses\\classes\\Carro.java");

        System.out.println(Files.isReadable(path));
        System.out.println(Files.isWritable(path));
        System.out.println(Files.isExecutable(path));
        /* Novas Interfaces - Leitura
        BasciFilesAttributes: Atributos básicos de todos os sistemas operacionais;
        PosixFileAttributes: Atributos básicos de todos os sistemas operacionais Unix e/ou Linux;
        DosFilesAttributes: Atributos básicos voltado para Windows

        Obs: Todos os métodos nestas interface são apenas para leitura, nenhum deles poderá fazer
        alteração.
        */
        System.out.println("############### BasicFileAttributes ###############");

        BasicFileAttributes atributosBasicos = Files.readAttributes(path,BasicFileAttributes.class);
        System.out.println("Create " + atributosBasicos.creationTime());
        System.out.println("lastAccess " + atributosBasicos.lastAccessTime());
        System.out.println("lasModified " + atributosBasicos.lastModifiedTime());
        System.out.println("Direcotry? " + atributosBasicos.isDirectory());
        System.out.println("SymbolicLink? " + atributosBasicos.isSymbolicLink());
        System.out.println("Regular File? " + atributosBasicos.isRegularFile());


        /* Novas Interfaces - Modificação
           BasicAttributeView:
           PosixFileAttributeView:
           DosFileAttributeView:
           FileOwnerAttributeView: Usado para citar o dono do arquivo ou principal;
           AclFileAttributeView: Permissões mais avançadas para trabalhar com atributos e arquivos
         */

        System.out.println("############### BasicFileAttributesView ###############");
        BasicFileAttributeView attributeView = Files.getFileAttributeView(path,BasicFileAttributeView.class);
        FileTime lastModified = atributosBasicos.lastModifiedTime();
        FileTime createdTime = atributosBasicos.creationTime();
        FileTime lastAccess = FileTime.fromMillis(System.currentTimeMillis());
        attributeView.setTimes(lastModified,lastAccess,createdTime); //realizando a alteração

        //Fazer a leitura novamente após a alteração
        atributosBasicos = Files.readAttributes(path,BasicFileAttributes.class);

        //reiprimindo após alteração

        System.out.println("Create " + atributosBasicos.creationTime());
        System.out.println("lastAccess " + atributosBasicos.lastAccessTime());
        System.out.println("lasModified " + atributosBasicos.lastModifiedTime());
    }
}
