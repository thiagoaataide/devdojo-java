package br.com.devdojo.javacore.colecoes.test;

import br.com.devdojo.javacore.colecoes.classes.Celular;
import br.com.devdojo.javacore.colecoes.classes.Produto;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

class CelularNomeComparator implements Comparator<Celular> {

    @Override
    public int compare(Celular o1, Celular o2) {
        return o1.getNome().compareTo(o2.getNome());
    }
}

public class TreeSetTest {
    public static void main(String[] args) {
        Produto p1 = new Produto("123", "Leptop Lenovo", 2000.0, 0);
        Produto p2 = new Produto("312", "Picanha", 69.9, 10);
        Produto p3 = new Produto("879", "Teclado Rayzer", 1000.0, 5);
        Produto p4 = new Produto("012", "Samsung Galaxy S7 64GB", 3250.5, 0);
        Produto p5 = new Produto("012", "Samsung Galaxy S6 64GB", 3250.5, 0);
        Celular celular = new Celular("iPhone 7", "123131");
        NavigableSet<Produto> produtoNavigableSet = new TreeSet<>();
        NavigableSet<Celular> celularNavigableSet = new TreeSet<>(new CelularNomeComparator()); //sem o comparator teremos um erro em tempo de execução.

//        celularNavigableSet.add(celular);
//        for (Celular celular1 : celularNavigableSet) {
//            System.out.println(celular1);
//        }

        produtoNavigableSet.add(p1);
        produtoNavigableSet.add(p2);
        produtoNavigableSet.add(p3);
        produtoNavigableSet.add(p4);
        produtoNavigableSet.add(p5);

//        for (Produto produto : produtoNavigableSet.descendingSet()) { //traz em ordem descrescente
        for (Produto produto : produtoNavigableSet) {
            System.out.println(produto);
        }

        System.out.println("---------------------------------------------");
        //lower <
        //floor <=
        //higher >
        //ceiling >=

        System.out.println(produtoNavigableSet.lower(p3));

        //pollFirst - retorna o primeiro elemento da lista, e o remove da lista.
        //pollLast - retorna o último elemento da lista, e o remove da lista.


    }

}
