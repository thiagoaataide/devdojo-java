package br.com.devdojo.javacore.stream.test;

import br.com.devdojo.javacore.stream.classes.Pessoas;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {

        List<Pessoas> pessoas = new Pessoas().popularPessoas();
        Stream<Pessoas> portuguesa = pessoas.stream().filter(pessoa -> pessoa.getNacionalidade().equals("Brasil"));
        System.out.println(portuguesa.count());
        //---------------------------------------------------------------------------------------------------------
        Stream<Integer> idades = pessoas.stream().filter(o -> o.getNacionalidade().equals("Brasil")).map(Pessoas::getIdade);
        Object[] objects = idades.toArray();

        for (Object object : objects) {
            System.out.println(object);
        }

        //---------------------------------------------------------------------------------------------------------

        Stream<String> nomes = pessoas.stream()
                .filter(p -> p.getNacionalidade().equals("Brasil"))
                .sorted(Comparator.comparing(Pessoas::getNome))
                .map(Pessoas::getNacionalidade);

        Object[] listaNomes = nomes.toArray();

        for (Object nome : listaNomes) {
            System.out.println(nome);
        }

        //---------------------------------------------------------------------------------------------------------

        /*Forma de Implementar o Distict pra tipos complexos*/
        Set<String> set = new HashSet<>(pessoas.size());
        List<Pessoas> listOfObjects = pessoas.stream().filter(p -> set.add(p.getNome())).collect(Collectors.toList());

        for (Pessoas listOfObject : listOfObjects) {
            System.out.println(listOfObject.getNome());
        }
        System.out.println("Tamanho da Lista: " + listOfObjects.size());

        //---------------------------------------------------------------------------------------------------------
        Collection<String> alfabeto = new Pessoas().listaLetras();
        List<String> distintos = alfabeto.stream().distinct().collect(Collectors.toList());

        for (String distinto : distintos) {
            System.out.print(distinto);
        }
        System.out.println();
        //----------------------------------------------------------------------------------------------------------

        pessoas.stream().forEach(p -> System.out.println(p.getNome()));


    }
}
