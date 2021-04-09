package br.com.devdojo.javacore.nio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NormalizacaoTest {
    public static void main(String[] args) {
        String diretorioProjeto = "devdojo\\home\\thiago\\dev";
        String arquivoTxt = "..\\..\\Arquivo.txt";
        Path p1 = Paths.get(diretorioProjeto,arquivoTxt);

        System.out.println(p1); //sem normalização
        System.out.println(p1.normalize()); // com normalização

        Path p2 = Paths.get("home/./thiago/./dev");
        System.out.println(p2); //sem normalização
        System.out.println(p2.normalize()); //com normalização


    }
}
