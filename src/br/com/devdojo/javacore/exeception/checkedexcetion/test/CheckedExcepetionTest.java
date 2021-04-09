package br.com.devdojo.javacore.exeception.checkedexcetion.test;

import java.io.File;
import java.io.IOException;

public class CheckedExcepetionTest {
    public static void main(String[] args) {
//        criarArquivo();
        abrirArquivo();
    }

    public static void criarArquivo() {
        File file = new  File("Teste.txt");

        try{
            System.out.println("Arquivo criado? " + file.createNewFile());
            System.out.println("Arquivo Criado Com Sucesso.");
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void abrirArquivo() {
        File file = new  File("Teste.txt");

        try{

            System.out.println("Abrindo um arquivo");
            System.out.println("Executando a leitura do arquivo");
//            throw new Exception();
            System.out.println("Escrevendo no Arquivo");
        }catch (Exception e){
            System.out.println("Dentro do Cacth");
            e.printStackTrace();
        } finally {
            System.out.println("Fechar o arquivo");
        }
    }
}
