package br.com.devdojo.digitalinnovationone.lambdas;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FuncoesAltaOrdem {
    public static void main(String[] args) {
        Operacao somar = (a,b) -> a + b;
        Operacao subtrair = (a,b) -> a - b;
        Operacao multiplicar = (a,b) -> a * b;
        Operacao dividir = (a,b) -> a / b;

        System.out.println(executarOperacao(somar,8,4));
        System.out.println(executarOperacao(subtrair,8,4));
        System.out.println(executarOperacao(multiplicar,8,4));
        System.out.println(executarOperacao(dividir,8,4));
    }


    public static int executarOperacao(Operacao o, int a, int b){
        return  o.calculo(a,b);
    }
}

interface Operacao{
    int calculo(int a, int b);
}
