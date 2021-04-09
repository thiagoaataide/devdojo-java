package br.com.devdojo.javacore.colecoes.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortListTest {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();
        nomes.add("Thiago");
        nomes.add("Alberto");
        nomes.add("Michele");
        nomes.add("Gilvanete");
        nomes.add("Carlos");
        Collections.sort(nomes);

        List<Double> numeros = new ArrayList<>();
        numeros.add(1.5);
        numeros.add(1.2);
        numeros.add(1.9);
        numeros.add(2d);
        Collections.sort(numeros);

        for (String nome : nomes) {
            System.out.println(nome);
        }

        for (Double numero : numeros) {
            System.out.println(numero);
        }

    }
}
