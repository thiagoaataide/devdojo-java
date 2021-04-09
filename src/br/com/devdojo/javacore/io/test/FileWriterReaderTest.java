package br.com.devdojo.javacore.io.test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterReaderTest {
    public static void main(String[] args) {

        File f = new File("Arquivo-Thiago.txt");
        try (FileWriter fw = new FileWriter(f)) { //usando o try with resources como a maior classe pai implmenta o clesable é possível utilizar.
//            FileWriter fw = new FileWriter(f,true); //aqui habilita o append para concatenar tudo no fim do arquivo.
            fw.write("Escrevendo uma mensagem no arquivo \nE pulando a linha 10");
            fw.flush();
//            fw.close();

            FileReader fr = new FileReader(f);

            char[] in = new char[500];
            int size = fr.read(in);
            System.out.println("Quantidade de Caracteres: " + size);
            for (char c : in) {
                System.out.print(c);
            }

            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
