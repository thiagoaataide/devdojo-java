package br.com.devdojo.introducao.operadores;

public class OperadoresDeAtirbuicao {
    /*Operadores de Atribuição
        = (Atribuição)
        -=
        +=
        *=
        /=
        %=
    * */

    public static void main(String[] args) {

        int salario = 1800;
        int salario2 = 1800;
        //As duas linhas abaixo fazem a mesma coisa!
        salario = salario + 1000;
        salario2 += 1000;
        salario2 -= 1000;
        salario2 *= 1.1;
        salario2 = salario2 + (int)(salario * 0.1); //cast

        System.out.println(salario2);
    }
}
