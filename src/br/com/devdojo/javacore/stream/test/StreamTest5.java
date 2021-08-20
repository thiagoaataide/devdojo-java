package br.com.devdojo.javacore.stream.test;

import br.com.devdojo.javacore.stream.classes.People;

import java.util.Optional;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class StreamTest5 {
    public static void main(String[] args) {


        //Retorna um Optional porque não há como saber se irá retornar um novo valor.
        Optional<Integer> reduce = getStream().reduce((x, y) -> x + y);

        //Retorna um Integer.
        Integer soma = getStream().reduce(0, (x, y) -> x + y);

        //Forma simplificada de realizar a soma, também retornando um Optional.
        Optional<Integer> reduce2 = getStream().reduce(Integer::sum);

        Optional<Integer> mult = getStream().reduce((x, y) -> x * y);
        Integer mult2 = getStream().reduce(1, (x, y) -> x * y);

        Optional<Integer> max = getStream().reduce((x, y) -> x > y ? x : y);
        Optional<Integer> max2 = getStream().reduce(Integer::max);


        System.out.println(reduce.get());
        System.out.println(soma);
        System.out.println(reduce2.get());
        System.out.println(mult.get());
        System.out.println(mult2);
        System.out.println(max.get());
        System.out.println(max2.get());


        /**
         * O problema dessa lógica é que o Java sempre irá realizar os cálculos com os tipos
         * primitivos. E no caso, é utilizado o seu Wrapper, fazendo que será feito um auto-boxing.
         *
         * */
        Optional<Double> salary = People.dbOfPeople().stream()
                .filter(p -> p.getSalary() > 4000)
                .map(People::getSalary)
                .reduce(Double::sum);

        System.out.println(salary.get());

        double sum = People.dbOfPeople().stream()
                .filter(p -> p.getSalary() > 4000)
                .mapToDouble(People::getSalary)
                .sum();

        System.out.println(sum);

        DoubleStream doubleStream = People.dbOfPeople().stream()
                .filter(p -> p.getSalary() > 4000)
                .mapToDouble(People::getSalary);

        //Retornar o DoubleStream para um Stream<Double>
        Stream<Double> boxed = doubleStream.boxed();

    }

    private static Stream<Integer> getStream() {
        return asList(1,2,3,4,5,6).stream();
    }
}
