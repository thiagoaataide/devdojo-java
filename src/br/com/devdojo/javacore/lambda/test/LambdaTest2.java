package br.com.devdojo.javacore.lambda.test;
import br.com.devdojo.javacore.lambda.classes.Carro;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import static java.util.Arrays.asList;

public class LambdaTest2 {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        lista.add("Thiago");
        lista.add("Thiago");
        lista.add("Thiago");
        lista.add("Thiago");


//        forEach(lista, (String s) -> System.out.println(s));
        forEach(asList("Thiago", "Michele", "Gilvanete", "Carlos"), (String s) -> System.out.println(s));
        forEach(asList(1,5,10,9), (Integer s) -> System.out.println(s));


        List<Double> list = map(asList("Thiago", "Michele", "Gilvanete", "Carlos"), (String s) -> Double.parseDouble(String.valueOf(s.length())));
        List<String> listString = map(asList("Thiago", "Michele", "Gilvanete", "Carlos"), (String s) -> s);
        System.out.println(list);
        System.out.println(listString);

        List<Carro> carros = asList(new Carro("preto", 2018),new Carro("azul", 2018),new Carro("rosa", 2018));

        List<String> listaCores = map(carros, (Carro c) -> c.getCor() );
        System.out.println(listaCores);

        Predicate<Integer> pares = (Integer i) -> i % 2 == 0;
        IntPredicate impares = (int i) -> i % 2 == 1; //melhor performance pra tipos primitivos.
        System.out.println(pares.test(6001));
        System.out.println(impares.test(6001));

        Predicate<String> p = (String s) -> listaCores.add(s);
        Consumer<String> b = (String s) -> listaCores.add(s);
//        p.test("amarelo");
        b.accept("amarelo");
        System.out.println(listaCores);
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
