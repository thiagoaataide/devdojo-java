package br.com.devdojo.javacore.colecoes.test;

import br.com.devdojo.javacore.colecoes.classes.Produto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTest {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(2);
        numeros.add(0);
        numeros.add(4);
        numeros.add(3);
        // ( - (ponto de inserção) -1)
        Collections.sort(numeros);
        //Indices: 0,1,2,3
        //Valores: 0,2,3,4
        System.out.println(Collections.binarySearch(numeros, 0)); //a lista deve ser ordenada,caso não teremos um erro.


        List<Produto> produtos = new ArrayList<>();

        Produto p1 = new Produto("123", "Leptop Lenovo", 2000.0);
        Produto p2 = new Produto("312", "Picanha", 69.9);
        Produto p3 = new Produto("879", "Teclado Rayzer", 1000.0);
        Produto p4 = new Produto("012", "Samsung Galaxy S7 64GB", 3250.5);
        produtos.add(p1);
        produtos.add(p2);
        produtos.add(p3);
        produtos.add(p4);
        Collections.sort(produtos, new ProdutoNomeComparator());
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
        Produto p5 = new Produto("000", "Zntena", 50.0);
        System.out.println(Collections.binarySearch(produtos, p2, new ProdutoNomeComparator()));
    }
}
