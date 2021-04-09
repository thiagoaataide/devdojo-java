package br.com.devdojo.introducao.controlefluxo;

public class ControleFluxo2 {
    public static void main(String[] args) {

        /*Operador Ternário
        * */

        int idade = 20;
        String status;
        if(idade < 18){
             status = "Não Adulto";
        } else{
            status = "Adulto";
        }

        // Operador ternário já atribuindo a variável
        status = idade< 18 ? "Não Adulto" : "Adulto";
        System.out.println(status);
    }
}
