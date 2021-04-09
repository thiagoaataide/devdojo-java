package br.com.devdojo.javacore.colecoes.test;

import br.com.devdojo.javacore.colecoes.classes.Produto;

import java.util.*;

class ProdutoNomeComparator implements Comparator<Produto>{

    @Override
    public int compare(Produto o1, Produto o2) {
        return o1.getNome().compareTo(o2.getNome());
    }
}

public class SortProdutoTest {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        Produto[] produtoArray = new Produto[4];

        Produto p1 = new Produto("123", "Leptop Lenovo", 2000.0);
        Produto p2 = new Produto("312", "Picanha", 69.9);
        Produto p3 = new Produto("879", "Teclado Rayzer", 1000.0);
        Produto p4 = new Produto("012", "Samsung Galaxy S7 64GB", 3250.5);
        produtos.add(p1);
        produtos.add(p2);
        produtos.add(p3);
        produtos.add(p4);
        Collections.sort(produtos);
        Collections.sort(produtos, new ProdutoNomeComparator()); //passando comparator para order por nome.

        produtoArray[0] = p1;
        produtoArray[1] = p2;
        produtoArray[2] = p3;
        produtoArray[3] = p4;

//        for (Produto produto : produtos) {
//            System.out.println(produto);
//        }

        Arrays.sort(produtoArray, new ProdutoNomeComparator());
        for (Produto produto : produtoArray) {
            System.out.println(produto);
        }
    }


}
