package br.com.devdojo.javacore.stream.test;

import br.com.devdojo.javacore.stream.classes.People;

import java.util.Comparator;
import java.util.List;

/**
 * Finding and matching
 *
 * */
public class StreamTest4 {
    public static void main(String[] args) {
        List<People> people = People.dbOfPeople();
        //Se alguma pessoal recebe um salário maior de 4000
        System.out.println(people.stream().anyMatch(p->p.getSalary() > 4000));
        //Se todas as pessoas forem maior de 18 anos
        System.out.println(people.stream().allMatch(p->p.getAge() > 18));
        //Se nenhuma pessoa tiver idade menor que 18 anos.
        System.out.println(people.stream().noneMatch(p->p.getAge() < 18));

        //findAny -> retorna um optional com qualquer um dos registros filtrados.
        //E através do Optional, é possível utilizar o ifPresent.
        people.stream().filter(p->p.getAge() < 25).findAny().ifPresent(o -> System.out.println(o.getName()));


        //Buscar qualquer pessoa acima dos 30 anos.
        //findFirst -> retorna um optional com o primeiro registro encontrado.
        //sorted -> utilizado para ordenar os dados.
        people.stream()
                .filter(people1 -> people1.getAge() > 30)
                .sorted(Comparator.comparing(People::getAge).reversed())
                .findFirst()
                .ifPresent(o -> System.out.println(o.getName()));
    }
}
