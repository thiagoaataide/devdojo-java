package br.com.devdojo.javacore.stream.test;

import br.com.devdojo.javacore.stream.classes.People;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//Redução e Sumarização em um único valor.

public class StreamTeste6Collectors1 {
    public static void main(String[] args) {
        List<People> people = People.dbOfPeople();

        //Contar
        System.out.println(people.stream().count());
        System.out.println(people.stream().collect(Collectors.counting()));

        //Máximo
        Optional<People> max = people.stream().max(Comparator.comparing(People::getSalary));
        System.out.println(max.get().getSalary());
        Optional<People> collect = people.stream().collect(Collectors.maxBy(Comparator.comparing(People::getSalary)));
        System.out.println(collect.get().getSalary());

        //Soma
        System.out.println(people.stream().mapToDouble(People::getSalary).sum());
        System.out.println(people.stream().collect(Collectors.summingDouble(People::getSalary)));

        //Média
        System.out.println(people.stream().mapToDouble(People::getSalary).average());
        System.out.println(people.stream().collect(Collectors.averagingDouble(People::getSalary)));

        //Sumariando e trazendo todos os valores
        DoubleSummaryStatistics collect1 = people.stream().collect(Collectors.summarizingDouble(People::getSalary));
        System.out.println(collect1);
        System.out.println(collect1.getMax());
        System.out.println(collect1.getMin());
        System.out.println(collect1.getAverage());
        System.out.println(collect1.getCount());

        //Join de Strings
        System.out.println(people.stream().map(People::getName).collect(Collectors.joining()));
        System.out.println(people.stream().map(People::getName).collect(Collectors.joining(", ")));

    }
}
