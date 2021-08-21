package br.com.devdojo.javacore.stream.test;

import br.com.devdojo.javacore.stream.classes.Genero;
import br.com.devdojo.javacore.stream.classes.Maioridade;
import br.com.devdojo.javacore.stream.classes.People;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

//Agrupamento
public class StreamTeste6Collectors2 {
    public static void main(String[] args) {
        List<People> people = People.dbOfPeople();

        /**
         * Agrupar por Genero todos os objetos de tipo People
         * .:: Método sem o Collectors ::.
         * */
        Map<Genero, List<People>> agrupaGeneroLista = new HashMap<>();
        List<People> masculino = new ArrayList<>();
        List<People> feminino = new ArrayList<>();

        for (People person : people) {
            if(Genero.MASCULINO.equals(person.getGenero())){
                masculino.add(person);
            }else{
                feminino.add(person);
            }
        }
        agrupaGeneroLista.put(Genero.MASCULINO,masculino);
        agrupaGeneroLista.put(Genero.FEMININO,feminino);
        System.out.println(agrupaGeneroLista);

        /**
         * Utilizando o Collectors
         *
         * */

        Map<Genero, List<People>> collect = people.stream().collect(Collectors.groupingBy(People::getGenero));
        System.out.println(collect);

        /**
         * Agrupar por maioridade
         *
         * Obs: Não há associação entre o Maioridade e o objeto People
         * */
        Map<Maioridade, List<People>> collect1 = people.stream().collect(Collectors.groupingBy(p -> {
            if (p.getAge() < 18) return Maioridade.MENOR;
            else return Maioridade.ADULTO;
        }));

        System.out.println(collect1);

        /**
         * Agrupar por Genero e Maioridade
         *
         * Obs: Collectors.groupingBy -> aceita encadeamento
         * */
        Map<Genero, Map<Maioridade, List<People>>> collect2 = people.stream().collect(Collectors.groupingBy(People::getGenero, Collectors.groupingBy(p -> {
            if (p.getAge() < 18) return Maioridade.MENOR;
            else return Maioridade.ADULTO;
        })));

        System.out.println(collect2);


        /**
         * Agrupar por Genero e Quantidade
         *
         * */
        Map<Genero, Long> collect3 = people.stream().collect(Collectors.groupingBy(People::getGenero, Collectors.counting()));
        System.out.println(collect);

        /**
         * Agrupar por Genero e Maior Salário
         *
         * Obs: Utilizando o Collectors.maxBy nós teremos um Optional como retorno, o que pode não ser tão útil. O Optional,
         *      caso ele não retorne nada, não será retornado nenhuma linha para o Map, pois o valor a ser retornado é nulo.
         *      E dentro do Collectors.groupingBy não será computado.
         *
         *      Para sanar essa situação, foi feito a utilização do Collectors.collectingAndThen dentro do Collectors.groupingBy. Esse método
         *      nos ajuda a buscar um valor após a execução de outro método. E ao invés de retornar um Optional, podemos retornar
         *      uma referência do próprio objeto.
         *
         * */
        Map<Genero, Optional<People>> collect4 = people.stream().collect(Collectors.groupingBy(People::getGenero, Collectors.maxBy(Comparator.comparing(People::getSalary))));
        System.out.println(collect4);

        Map<Genero, People> collect5 = people.stream().collect(Collectors.groupingBy(People::getGenero,
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(People::getSalary)), Optional::get)));

        System.out.println(collect5);


        /**
         * Agrupar por Genero e Estatísticas
         *
         * */
        Map<Genero, DoubleSummaryStatistics> collect6 = people.stream().collect(Collectors.groupingBy(People::getGenero, Collectors.summarizingDouble(People::getSalary)));
        System.out.println(collect6);

        /**
         * Agrupar por Genero e Maioridade(este de forma distinta)
         *
         * */
        Map<Genero, List<Maioridade>> collect7 = people.stream().collect(Collectors.groupingBy(People::getGenero, Collectors.mapping(p -> {
            if (p.getAge() > 18) return Maioridade.ADULTO;
            else return Maioridade.MENOR;
        }, toList())));
        System.out.println(collect7);

        Map<Genero, Set<Maioridade>> collect8 = people.stream().collect(Collectors.groupingBy(People::getGenero, Collectors.mapping(p -> {
            if (p.getAge() > 18) return Maioridade.ADULTO;
            else return Maioridade.MENOR;
        }, toSet())));
        System.out.println(collect8);


    }
}
