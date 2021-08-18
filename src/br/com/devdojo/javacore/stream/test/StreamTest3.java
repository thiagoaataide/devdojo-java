package br.com.devdojo.javacore.stream.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class StreamTest3 {
    public static void main(String[] args) {
        List<List<String>> nomes = new ArrayList<>();
        nomes.add(asList("DevDojo", "Valeu por aumentar a letra"));
        nomes.add(asList("Willian", "pq vc demorou 180 aulas pra isso?"));
        nomes.add(asList("Willian", "Michele", "Thiago", "Bruno"));

        List<String> collect = nomes.stream().flatMap(Collection::stream).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println(nomes);

        List<String> palavras = asList("Veggeta", "Goku", "Kuririm");
        String [] split = palavras.get(0).split("");
        System.out.println(Arrays.toString(split)); //Split utilizando a função da própria lista.

        // agora usando Streams
        List<String[]> collect1 = palavras.stream().map(p -> p.split("")).collect(Collectors.toList());
        Stream<String> stream = Arrays.stream((String[]) palavras.toArray());
        List<String> collect2 = palavras
                .stream()
                .map(p -> p.split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        System.out.println(collect2);
    }
}
