package br.com.devdojo.javacore.lambda.test;

import br.com.devdojo.javacore.lambda.classes.Carro;
import br.com.devdojo.javacore.lambda.classes.ComparadorCarro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

import static java.util.Arrays.asList;

public class LambdaTest3 {
    public static void main(String[] args) {
        //Method Reference
//        forEach(asList("Thiago", "Michele", "Gilvanete", "Carlos"), System.out::println);

        List<Carro> carros = asList(new Carro("Vermelho", 2000),new Carro("Azul", 2011),new Carro("Preto", 1995));


        /**
         * Ambas as linhas abaixo geram o mesmo efeito, porém na segunda oinha temos a opção de utilizar o Method Reference.
         * Primeira Chamada - Lambda - (Carro o1, Carro o2) -> o1.getCor().compareTo(o2.getCor())
         * Segunda Chamada - Reference to a static method - ComparadorCarro::comparePorCor
         * Terceira Chamada - Reference to an instance method of a particular object
         *      ComparadorCarro comparadorCarro = new ComparadorCarro();
         *      Collections.sort(carros,comparadorCarro::comparePorAno);
         * Quarta Chamada - Reference to an instance method of an arbitrary object of a particular type.
         * */

        //Lambda
        Collections.sort(carros, (Carro o1, Carro o2) -> o1.getCor().compareTo(o2.getCor()));
        System.out.println(carros);

        //Reference to a static method
        Collections.sort(carros, ComparadorCarro::comparePorCor);
        System.out.println(carros); // ordenado por cor


        //Reference to an instance method of a particular object
        ComparadorCarro comparadorCarro = new ComparadorCarro();
//        Collections.sort(carros,comparadorCarro::comparePorAno);
        Supplier<ComparadorCarro> comparadorCarroSupplier = ComparadorCarro::new; //Utilizando o o reference to a constructor
        Collections.sort(carros,comparadorCarroSupplier.get()::comparePorAno); //chamando a partir do supplier
        System.out.println(carros); // ordenado por ano

        //Reference to an instance method of an arbitrary object of a particular type.
        List<String> nomes = asList("Thiago", "Michele", "Gilvanete", "Carlos","Ano","Breno");
        nomes.sort((s1,s2) -> s1.compareTo(s2));
        nomes.sort(String::compareTo);
        System.out.println(nomes);

        Function<String,Integer> stringToInteger = (String s) -> Integer.parseInt(s);
        Function<String,Integer> stringToInteger2 = Integer::parseInt;
        System.out.println(stringToInteger2.apply("90"));

        BiPredicate<List<String>, String> contains = (lista,elemento) -> lista.contains(elemento);
        BiPredicate<List<String>, String> contains2 = List::contains;
        System.out.println(contains2.test(nomes,"Michele"));

        //Reference to a constructor
        BiFunction<String, Integer, Carro> carroBiFunction = (s,i) -> new Carro(s,i);
        BiFunction<String, Integer, Carro> carroBiFunction2 = Carro::new;
        System.out.println(carroBiFunction2.apply("Roda", 1989));

    }

    public static <T> void forEach(List<T> list, Consumer<T> c){
        for (T t : list) {
            c.accept(t);
        }
    }

    public static <T,R> List<R> map(List<T> list, Function<T,R> f){
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(f.apply(t));
        }

        return result;
    }
}
