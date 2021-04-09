package br.com.devdojo.javacore.introducaometodos.test;

import br.com.devdojo.javacore.introducaometodos.classes.Calculadora;

/* DevDojo
Aulas 29 e 30 - Retornos de Métodos
Aulas 31 e 32 - Método com Parâmetro tipo Reference e This
* */

public class CalculadoraTest {

    public static void main(String... args) {
        Calculadora calculadora = new Calculadora();
        calculadora.somaDoisNumeros();
        calculadora.subtrairDoisNumeros();
        calculadora.multiplicaDoisNumeros(2,7); //aqui os valores passados são chamados de argumento.
        System.out.println("imprimir valor da divisão");

        double resultado = calculadora.divideDoisNumeros(10,2);
        System.out.println(calculadora.divideDoisNumeros(10,2));
        System.out.println(resultado);

        double divzero = calculadora.divideDoisNumeros(10,0);
        System.out.println(divzero);

        calculadora.imprimeDoisNumerosDivididos(10,0);

        int[] numeros = {1,2,3,4,5};
        calculadora.somaArray(numeros);
        /* Aula 33 - Passagem de Parâmetros VarArgs
        * VarArgs permite além de você passar um array como referência,
        * é possível passar os vales separados por vírgula.
        */
        calculadora.somaVarArgs(numeros);
        calculadora.somaVarArgs(1,2,3,4,5);
    }

}
