package br.com.devdojo.javacore.colecoes.test;

import br.com.devdojo.javacore.colecoes.classes.Produto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorTest {
    public static void main(String[] args) {
        List<Produto> produtos = new LinkedList<>();

        Produto p1 = new Produto("123", "Leptop Lenovo", 2000.0,0);
        Produto p2 = new Produto("312", "Picanha", 69.9,10);
        Produto p3 = new Produto("879", "Teclado Rayzer", 1000.0,5);
        Produto p4 = new Produto("012", "Samsung Galaxy S7 64GB", 3250.5,0);
        produtos.add(p1);
        produtos.add(p2);
        produtos.add(p3);
        produtos.add(p4);
        System.out.println(produtos.size());


        /**
         * Não é bom utilizar o for para remover itens de um List<><>
         * */
        Iterator<Produto> produtoIterator = produtos.iterator();
        //hasNext - Verificar se há um próximo elemento na lista;
        //nest - pega o próximo da lista.
        while (produtoIterator.hasNext()){
            Produto produto = produtoIterator.next();
            if(produto.getQuantidade() == 0){
//            if(produtoIterator.next().getQuantidade() == 0){ //outra forma de fazer.
                produtoIterator.remove();
            }
        }
        System.out.println(produtos.size());


    }
}
