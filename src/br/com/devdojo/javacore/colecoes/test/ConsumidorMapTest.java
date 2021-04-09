package br.com.devdojo.javacore.colecoes.test;

import br.com.devdojo.javacore.colecoes.classes.Consumidor;
import br.com.devdojo.javacore.colecoes.classes.Produto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsumidorMapTest {
    public static void main(String[] args) {
        Consumidor c1 = new Consumidor("Thiago","08338865419");
        Consumidor c2 = new Consumidor("DevDojo","17176905487");
        Produto p1 = new Produto("123", "Leptop Lenovo", 2000.0);
        Produto p2 = new Produto("312", "Picanha", 69.9);
        Produto p3 = new Produto("879", "Teclado Rayzer", 1000.0);
        Produto p4 = new Produto("012", "Samsung Galaxy S7 64GB", 3250.5);

        Map<Consumidor,List<Produto>> map = new HashMap<>();

        List<Produto> produtosCon1 = new ArrayList<>();
        produtosCon1.add(p1);
        produtosCon1.add(p2);

        List<Produto> produtosCon2 = new ArrayList<>();
        produtosCon2.add(p3);
        produtosCon2.add(p4);

        map.put(c1, produtosCon1);
        map.put(c2, produtosCon2);

        for(Map.Entry<Consumidor,List<Produto>> entry : map.entrySet()){
            System.out.println(entry.getKey().getNome());
            for(Produto produto : entry.getValue()){
                System.out.println(produto.getNome());
            }
        }

//        map.put(c1,p2);
//        map.put(c2,p4);

//        for(Map.Entry<Consumidor,Produto> entry : map.entrySet()){
//            System.out.println(entry.getKey().getNome() + " - " + entry.getValue().getNome());
//        }

    }
}
