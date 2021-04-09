package br.com.devdojo.javacore.introducaometodos.classes;

/* DevDojo
Aulas 29 e 30 - Retornos de Métodos
Aulas 31 e 32 - Método com Parâmetro tipo Reference e This
* */

public class Calculadora {

    public void somaDoisNumeros() {
        System.out.println(5 + 5);
    }

    public void subtrairDoisNumeros() {
        System.out.println(5 - 5);
    }

    public void multiplicaDoisNumeros(int num1, int num2) {
        System.out.println(num1 * num2);
    }

    public double divideDoisNumeros(double num1, double num2) {
//        double result = num1 / num2;
//        return result;
        if (num2 != 0) {
            return num1 / num2;
        } else {
            return 0;
        }
    }

    public void imprimeDoisNumerosDivididos(double num1, double num2) {
//        if(num2 != 0) {
//            System.out.println(num1 / num2);
//        }else{
//            System.out.println("Não é possível dividir por zero");
//        }

        if (num2 != 0) {
            System.out.println(num1 / num2);
            return;
        }
        System.out.println("Não é possível dividir por zero");

    }

    public void alteraDoisNumeros(int num1, int num2) {
        num1 = 30;
        num2 = 40;
        System.out.println("Dentro de Altera dois números");
        System.out.println("num1: " + num1);
        System.out.println("num2: " + num2);
    }

    public void somaArray(int[] numeros) {
        int soma = 0;
        for (int num : numeros) {
            soma += num;
        }

        System.out.println(soma);
    }


    /* Aula 33 - Passagem de Parâmetros VarArgs
     * Nota: somente é possível ter um varargs por assinatura de método.
     * Logo o exemplo abaixo apresenta erro de compilação:
     * Exemplo:
     *      public void somaVarArgs(int... numeros, String... nomes) => Isso representará um erro de compilação.
     *
     * Se precisar que o método tenha mais parâmetros, o varargs tem que ser o último. Caso contrário será retornado
     * um erro de compilação.
     *
     * Exemplo:
     * public void somaVarArgs(Double num1, int... numeros) => Sem erro
     * public void somaVarArgs(int... numeros,Double num1) => Erro de compilação*/
    public void somaVarArgs(int... numeros) {
        int soma = 0;
        for (int num : numeros) {
            soma += num;
        }

        System.out.println(soma);
    }
}
