package br.com.devdojo.javacore.colecoes.test;

import br.com.devdojo.javacore.colecoes.classes.Produto;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        Produto p1 = new Produto("123", "Leptop Lenovo", 2000.0,0);
        Produto p2 = new Produto("312", "Picanha", 69.9,10);
        Produto p3 = new Produto("879", "Teclado Rayzer", 1000.0,5);
        Produto p4 = new Produto("012", "Samsung Galaxy S7 64GB", 3250.5,0);
        Produto p5 = new Produto("012", "Samsung Galaxy S6 64GB", 3250.5,0);

        Set<Produto> produtoSet = new LinkedHashSet<>();
        produtoSet.add(p1);
        produtoSet.add(p2);
        produtoSet.add(p3);
        produtoSet.add(p4);
        produtoSet.add(p5);

        produtoSet.stream().forEach(System.out::println);

    }
}
