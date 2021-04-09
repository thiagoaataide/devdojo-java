package br.com.devdojo.introducao.operadores;

public class OperadoresLogicos {
    /*Operadores Lógicos
            && (E)
            || (OU)

    */
    public static void main(String[] args){
        int idade = 18;
        float salario = 1000f;

        System.out.println(idade >= 18 && salario >= 1000);
        System.out.println(idade >= 18 && salario >= 3000);
        System.out.println(idade >= 18 || salario >= 3000);
        System.out.println(idade >= 16 || salario >= 2000);

    }
}
