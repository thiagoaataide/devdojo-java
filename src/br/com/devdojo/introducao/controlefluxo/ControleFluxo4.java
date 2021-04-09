package br.com.devdojo.introducao.controlefluxo;

public class ControleFluxo4 {
    public static void main(String[] args) {
        int contador = 0;
        while (contador < 10) {
            System.out.println(contador);
            contador++;
        }

        int contador2 = 0;
        while (contador2 < 10) {
            System.out.println(++contador2);
        }

        int contador3 = 11;
        /*
        A diferença entre o While e Do-While é que enquanto no While só executa se a condição for
        verdadeira, o Do-While executa pelo menos uma vez para depois validar a condição.
        * */
        do {
            System.out.println("dentro do do while");
        } while (contador3 < 10);

        for (int i = 0; i < 10; i++) {
            System.out.println("Valor de i é: " + i);
        }
        /*Break é uma instrução utilizada para quebrar o laço, e pode ser utilizado com
        Switch, While, Do-While, For
         */

    }
}
