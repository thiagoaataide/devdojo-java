package br.com.devdojo.javacore.generics.test;

import java.util.ArrayList;
import java.util.List;

public class MetodoGenericoTest {
    public static void main(String[] args) {
//        criarArray(new Cachorro());
        List<Cachorro> cachorroList = criarArray(new Cachorro());
        System.out.println(cachorroList);
    }

    public static <T extends Animal> List<T> criarArray(T t){
        List<T> lista = new ArrayList<>();
        lista.add(t);
//        System.out.println(lista);
        return lista;
    }
}
