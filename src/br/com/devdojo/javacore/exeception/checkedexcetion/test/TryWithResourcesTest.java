package br.com.devdojo.javacore.exeception.checkedexcetion.test;

import br.com.devdojo.javacore.exeception.checkedexcetion.classes.Leitor1;
import br.com.devdojo.javacore.exeception.checkedexcetion.classes.Leitor2;

import java.io.*;

public class TryWithResourcesTest {
    public static void main(String[] args) {
        leitores();
    }

    //Java 6
    public static void lerArquivoOld() {
        Reader reader = null;
        try {
            reader = new BufferedReader(new FileReader("text.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //Java 7
    public static void lerArquivo() throws IOException {
        try (Reader reader = new BufferedReader(new FileReader("text.txt"))) {
        }
    }

    //Java 7
    public static void leitores() {
        try (Leitor1 leitor1 = new Leitor1();
             Leitor2 leitor2 = new Leitor2()) {
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
