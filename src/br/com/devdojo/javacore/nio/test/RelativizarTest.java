package br.com.devdojo.javacore.nio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativizarTest {
    public static void main(String[] args) {
        Path dir = Paths.get("/home/thiago");
        Path classe = Paths.get("/home/thiago/java/Pessoa.java");
        Path pathToClasse = dir.relativize(classe);

        System.out.println(pathToClasse);

        Path absoluto1 = Paths.get("/home/thiago");
        Path absoluto2 = Paths.get("/usr/local");
        Path absoluto3 = Paths.get("/home/thiago/java/Pessoa.java");
        Path relativo1 = Paths.get("temp");
        Path relativo2 = Paths.get("temp/Funcioario.java");

        // a leitura à ser feita é a seguinte:
        //o primeiro path é onde quero chegar, e relativizamos com o path 2 para achar um caminho.
        //no caso do item 2 estamos partindo com caminho /home/thiago/java/Pessoa.java e quero chegar em /home/thiago
        //logo, o retorno é ..\.. que representa retornar um diretório.
        System.out.println("1 : " + absoluto1.relativize(absoluto3));
        System.out.println("2 : " + absoluto3.relativize(absoluto1));
        System.out.println("3 : " + absoluto1.relativize(absoluto2));
        System.out.println("4 : " + relativo1.relativize(relativo2));
        /*No item 5 teremos um erro de IlligalArgumentExcpetion pois não é possível através de um
          caminho absoluto, alcançar um caminho relativo. Pois não sabemos onde está o diretório "temp"
         */
        System.out.println("5 : " + absoluto1.relativize(relativo1));


    }
}
