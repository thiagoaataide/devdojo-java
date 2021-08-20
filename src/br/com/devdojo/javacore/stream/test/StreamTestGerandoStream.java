package br.com.devdojo.javacore.stream.test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Locale;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTestGerandoStream {
    public static void main(String[] args) {

        //Criando streams de números
        IntStream.rangeClosed(1,80).filter(v->v % 2 == 0).forEach(v-> System.out.printf(v+", "));
        System.out.println();
        IntStream.range(1,80).filter(v->v % 2 == 0).forEach(v-> System.out.printf(v+", "));

        System.out.println();

        //Criando streams de strings
        Stream<String> stringStream = Stream.of("thiago", "teste", "qualquer coisa pode ser escrita aqui.");
        stringStream.map(String::toUpperCase).forEach(s-> System.out.print(s+" "));
        Stream<Object> empty = Stream.empty();

        System.out.println();

        //Criando streams de arrays
        int numeros[] = {1,2,3,4,5};
        IntStream stream = Arrays.stream(numeros);
        OptionalDouble average = stream.average();
        System.out.println(average.getAsDouble());

        //Criando streams de arquivos
        try(Stream<String> conteudo = Files.lines(Paths.get("Teste.txt"), Charset.defaultCharset()) ){
            conteudo
                    .flatMap(p-> Arrays.stream(p.split("\n")))
                    .filter(p->p.contains("File"))
                    .forEach(System.out::println);
        }catch (IOException e){
            e.printStackTrace();
        }


        //Streams Infinitos - CUIDADO
        Stream.iterate(1, n-> n +2).limit(10).forEach(System.out::println);

        /**
         * Sequência de Fibonacci
         * Original: 0, 1, 1, 2, 3, 5, 8, 13, 21...
         * Arrays Agrupados com valores: [0,1] [1,1] [1,2] [2,3] [3,5] [5,8]
         * */
        Stream.iterate(new int[]{0,1}, p-> new int[]{p[1], p[0] + p[1]})
                .limit(5)
                .forEach(t-> System.out.println(Arrays.toString(t)));

        Stream.iterate(new int[]{0,1}, p-> new int[]{p[1], p[0] + p[1]})
                .limit(5)
                .map(t->t[0])
                .forEach(t-> System.out.println(t));

    }
}
