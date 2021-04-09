package br.com.devdojo.javacore.io.test;

import java.io.*;

public class BufferedTest {
    public static void main(String[] args) {
        File f = new File("Arquivo-Thiago.txt");
        try {
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Escrevendo uma mensagem no arquivo");
            bw.newLine(); //nova linha; pula linha;
            bw.write("E pulando uma linha");
            bw.flush();
            bw.close();

            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String s = null;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
