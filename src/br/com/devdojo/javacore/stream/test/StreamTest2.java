package br.com.devdojo.javacore.stream.test;

import br.com.devdojo.javacore.stream.classes.People;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest2 {
    /**
     * 1. Buscar os três primeiros nomes de pessoas com menos de 25 anos.
     * 2. Ordernados pelo nome.
     * */
    public static void main(String[] args) {
        /**
         * Solução com Java 7 - Sem utilizar as Streams*/

        List<People> people = People.dbOfPeople();
        List<String> names = new ArrayList<>();
        Collections.sort(people, ((o1, o2) -> o1.getName().compareTo(o2.getName())));

        for (People person : people) {
            if(person.getAge() < 25){
                names.add(person.getName());

                if(names.size() >= 3){
                    break;
                }
            }
        }

        System.out.println(names);

        /**
         * Solução com Java 8 - Utilizando Streams
         * */

        List<String> names2 = people
                .stream() // Inicio do processamento em pipeline
                .filter(p-> p.getAge() < 25) // Realizar filtro usando um Predicate através do método filter.
                .sorted(Comparator.comparing(People::getName)) // Ordenar os objetos filtrados por nome.
                .limit(3) // Limitar o retorno as 3 coincidências.
                .map(People::getName) // Alterar o formato dos dados, people é uma Collection, mas iremos retorno apenas os nomes em uma lista;
                .collect(Collectors.toList()); // Transformar o retorno em uma lista.

        System.out.println(names2);


        System.out.println(people
                .stream() // Inicio do processamento em pipeline
                .distinct() // Retornar valores distintos
                .filter(p-> p.getAge() < 25) // Realizar filtro usando um Predicate através do método filter.
                .map(People::getName) // Alterar o formato dos dados, people é uma Collection, mas iremos retorno apenas os nomes em uma lista;
                .count() // Transformar o retorno em uma lista.
        );

        people.stream().forEach(System.out::println);

        /**
         * Métodos da Stream
         *
         * São de dois tipos: Intermidiate e Terminal
         *
         * - Intermidiate: todos estes métodos retorna um outro stream, permitindo encadear novos métodos.
         *      Ex: filter, sorted, limit, map, distinct
         * - Terminal: retornam um valor que não é stream.
         *      Ex: collect, forEach
         *
         *  Observação Importante: os métodos Intermidiate não irão realizar nenhum tipo de processamento, até que
         *                          uma operação Terminal seja invocada naquele stream. Trata-se de um encadeamento lazy,
         *                          pois as operações Intermidiate podem sofre um merge e serem processadas em um único
         *                          passo pela operação terminal.*/
    }
}
