package br.com.devdojo.javacore.lambda.test;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

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


        List<Double> list = tamonhoStrings(asList("Thiago", "Michele", "Gilvanete", "Carlos"), (String s) -> Double.parseDouble(String.valueOf(s.length())));
        List<String> listString = tamonhoStrings(asList("Thiago", "Michele", "Gilvanete", "Carlos"), (String s) -> s);
        System.out.println(list);
        System.out.println(listString);
    }

    public static <T> void forEach(List<T> list, Consumer<T> c){
        for (T t : list) {
            c.accept(t);
        }
    }

    public static <T,R> List<R> tamonhoStrings(List<T> list, Function<T,R> f){
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(f.apply(t));
        }

        return result;
    }
}
