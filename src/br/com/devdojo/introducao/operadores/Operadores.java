package br.com.devdojo.introducao.operadores;

public class Operadores {
    public static void main(String[] args){
        /*Operadores Aritiméticos
        + (Soma)
        - (Subtração)
        * (Multiplicação)
        / (Divisão)
        % (Resto da Divisão)
        * */
        int n1 = 10;
        int n2 = 20;
        int soma = n1 + n2;
        System.out.println(+n1+n2); //30
        System.out.println("A soma é: "+n1+n2); //1020
        System.out.println(n1+n2+" É a soma"); //30
        System.out.println("A soma é: "+soma); //30
        System.out.println("A soma é: "+(n1+n2)); //30
        System.out.println("A multiplicação é: "+(n1*n2)); //300
        System.out.println("A divisão é: "+(n1/n2)); //0

        double numeroDouble = 10d;
        float numeroFloat = 20f;
        numeroFloat = (float) numeroDouble;
        int resto = 19%2;
        System.out.println("O resto da divisão é: "+ resto);
        System.out.println(numeroFloat);




    }
}
