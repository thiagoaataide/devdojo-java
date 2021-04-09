package br.com.devdojo.javacore.nio.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipandoTest {
    public static void main(String[] args) {
        Path dirZip = Paths.get("pasta/subpasta");//onde vai ser gerado o arquivo zip
        Path dirFiles = Paths.get("pasta/subpasta/subsubpast"); //onde estão os arquivos a zipar
        Path zipFile = dirZip.resolve("arquivo_qualquer.zip"); //nome do arquivo zip


        try (ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(zipFile.toFile()));
             DirectoryStream<Path> stream = Files.newDirectoryStream(dirFiles)) {
            for (Path path : stream) {
//                System.out.println(path);
                ZipEntry zipEntry = new ZipEntry(path.getFileName().toFile().toString()); //arquivo a ser adicionado ao zip
                zip.putNextEntry(zipEntry); //criando um arquivo de entrada.
                FileInputStream fileInputStream = new FileInputStream(path.toFile());
                byte[] buff = new byte[2048];
                int bytesRead;
                while ((bytesRead = fileInputStream.read(buff)) > 0){
                    zip.write(buff);
                }
                zip.flush();
                zip.closeEntry();
                fileInputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
