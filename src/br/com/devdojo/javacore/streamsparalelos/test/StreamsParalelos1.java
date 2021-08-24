package br.com.devdojo.javacore.streamsparalelos.test;



import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamsParalelos1 {
    public static void main(String[] args) {
        long num = 10_000_000;
        somaFor(num);
        somaStream(num);
        somaParallelStreamIterate(num);
        somaRangeClosedStream(num);
        somaRangeClosedParallelStream(num);
        //Obter quantos processadores podem ser utilizados para gerar as threads
        System.out.println(Runtime.getRuntime().availableProcessors());
        //Alterar a quantidade de Threads do sistema de forma global, afetando todos os Streams paralelos.
//        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","12");
    }

    private static void somaFor(long num){
        System.out.println("For");
        long init = System.currentTimeMillis();
        long result = 0;
        for (long i = 1L; i <= num; i++) {
            result += i;
        }
        long end = System.currentTimeMillis();

        System.out.println(result + " " + (end - init) + " ms");
    }


    private static void somaStream(long num){
        System.out.println("Stream Sequencial");
        long init = System.currentTimeMillis();
        long result = 0;
        result = Stream.iterate(1L, i -> i + 1).limit(num).reduce(0L,Long::sum);
        long end = System.currentTimeMillis();

        System.out.println(result + " " + (end - init) + " ms");
    }

    private static void somaParallelStreamIterate(long num){
        System.out.println("Stream Paralelos");
        long init = System.currentTimeMillis();
        long result = 0;
        result = Stream.iterate(1L, i -> i + 1).parallel().limit(num).reduce(0L,Long::sum);
        long end = System.currentTimeMillis();

        System.out.println(result + " " + (end - init) + " ms");
    }

    private static void somaRangeClosedStream(long num){
        System.out.println("Range Closed Stream");
        long init = System.currentTimeMillis();
        long result = 0;
        result = LongStream.rangeClosed(1l, num).reduce(0L,Long::sum);
        long end = System.currentTimeMillis();

        System.out.println(result + " " + (end - init) + " ms");
    }

    private static void somaRangeClosedParallelStream(long num){
        System.out.println("Range Closed Stream Parallel");
        long init = System.currentTimeMillis();
        long result = 0;
        result = LongStream.rangeClosed(1l, num).parallel().reduce(0L,Long::sum);
        long end = System.currentTimeMillis();

        System.out.println(result + " " + (end - init) + " ms");
    }
}
