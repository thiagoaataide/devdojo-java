package br.com.devdojo.javacore.io.test;

import java.io.*;

public class StreamsTest {
    public static void main(String[] args) {
//        gravador();
//        leitor();
//        gravadorBuffered();
        leitorBuffered();
    }

    private static void gravador(){
        // O sistema operacional e a IDE irão fazer uma conversão dos bytes a seus correspondentes na tabela ASC
        byte[] dados = {65,66,67,68,69};
        try(FileOutputStream gravador = new FileOutputStream("pasta/stream.txt")) {
            for (byte dado : dados) {
                gravador.write(dado);
            }
            System.out.println("Dados gravados com sucesso");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void gravadorBuffered(){
        // O sistema operacional e a IDE irão fazer uma conversão dos bytes a seus correspondentes na tabela ASC
        byte[] dados = {70,71,72,73,74,75};
        try(BufferedOutputStream gravadorBuffer = new BufferedOutputStream(new FileOutputStream("pasta/stream.txt"))) {
            for (byte dado : dados) {
                gravadorBuffer.write(dado);
                gravadorBuffer.flush(); //imprimir tudo que está em memória
            }
            System.out.println("Dados gravados com sucesso");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void leitor(){
        /**
         * Na leitura, o fim do arquivo retornará -1. Por isso será preciso criar um controle
         * para verificar quando o arquivo foi lido inteiramente.
         *
         * */
        try(FileInputStream leitor = new FileInputStream("pasta/stream.txt")) {
            int leitura;
            while ((leitura = leitor.read()) != -1){
                byte dadoLido = (byte) leitura;
                System.out.println(" " + dadoLido);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void leitorBuffered(){
        // O sistema operacional e a IDE irão fazer uma conversão dos bytes a seus correspondentes na tabela ASC
        byte[] dados = {70,71,72,73,74,75};
        try(BufferedInputStream leitorBuffer = new BufferedInputStream(new FileInputStream("pasta/stream.txt"))) {
            int leitura;
            while ((leitura = leitorBuffer.read()) != -1){
                byte dadosLido = (byte) leitura;
                System.out.println(" "+dadosLido);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
