package br.com.devdojo.javacore.nio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ResolvendoPathsTest {
    public static void main(String[] args) {
        Path dir = Paths.get("home\\thiago");
        Path arquivo = Paths.get("dev\\Arquivo.txt");
        Path result = dir.resolve(arquivo);
        System.out.println(result);

        Path absoluto = Paths.get("/home/thiago");
        Path relativo = Paths.get("dev");
        Path file = Paths.get("file.txt");

        System.out.println("1: " + absoluto.resolve(relativo) );
        System.out.println("2: " + absoluto.resolve(file));
        System.out.println("3: " + relativo.resolve(file));
        System.out.println("4: " + relativo.resolve(absoluto));
        System.out.println("5: " + file.resolve(absoluto));
        System.out.println("6: " + file.resolve(relativo));

        /*Na sequências acima, a particularidade fica por conota dos itens 4 e 5
        * Pois estamos tentando resolver um path com um path absoluto, e qualquer coisa
        * comparada com um absoluto, retorna o absoluto.*/
    }
}
