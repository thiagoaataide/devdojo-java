package br.com.devdojo.javacore.introducaometodos.test;

import br.com.devdojo.javacore.introducaometodos.classes.Calculadora;

/* DevDojo
Aulas 29 e 30 - Retornos de Métodos
Aulas 31 e 32 - Método com Parâmetro tipo Reference e This
* */

public class ParametrosTeste {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        int num1 = 5;
        int num2 = 10;
        calc.alteraDoisNumeros(num1,num2);
        System.out.println("Dentro do Teste");
        System.out.println("num1: "+ num1);
        System.out.println("num2: "+ num2);



    }
}
