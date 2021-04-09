package br.com.devdojo.introducao;

public class ImprimindoVariaveis {
    public static void main (String[] args){

        /* Tipo Primitivos - Em java há 8 tipos primitivos de dados.
        INT
        DOUBLE
        FLOAT
        BOOLEAN
        CHAR
        BYTE
        SHORT
        LONG

        Fora essas ainda há o tipo Reference String
        STRING
        * */

        //Declarando variável [TIPO + NOME_VARIAVEL]
        int idade = 10;
        int idade2 = 20;

        /*
        O resultado das duas linhas abaixo são diferentes, pois o Java identifica
        que após a string, tudo será concatenado como string.
        * */
        System.out.println(idade+idade2+" é a idade");
        System.out.println("Idade: "+idade+idade2);
    }
}
