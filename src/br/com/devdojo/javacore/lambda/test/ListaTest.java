package br.com.devdojo.javacore.lambda.test;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class ListaTest {
    public static void main(String[] args) {
        List<Integer> listaNumerica = asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> novaLista = listaNumerica.stream().filter(c -> c.compareTo(5) > 0).collect(Collectors.toList());
        System.out.println(listaNumerica);
        System.out.println(novaLista);

    }
}
