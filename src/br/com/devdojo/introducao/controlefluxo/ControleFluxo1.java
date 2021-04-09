package br.com.devdojo.introducao.controlefluxo;

public class ControleFluxo1 {
    public static void main(String[] args) {
        //idade < 15 Categoria: Infntil
        //Idade > 15 && idade < 18 Categoria: Juvenil
        //Idade >= 18 Categoria: Adulto
        int idade = 20;
        float salario = 2000f;
        String categoria = "";
//        boolean c = false;

        // Esse resultado é true porque se trata de um operador de atribuição
//        if(c = true){
//            System.out.println("Entrou no true");
//        }

        // aqui é uitlizado um operador de comparação
//        if(c == true){
//            System.out.println("Entrou no true");
//        }

        if(idade>= 20){
            System.out.println("Entra no clube");
        }else{
            System.out.println("não entra no clube");
        }

        if(idade < 15){
            categoria = "Infantril";
        } else if(idade > 15 && idade < 18 ){
            categoria = "Juvenil";
        }
        else {
            categoria = "Adulto";
        }

        System.out.println(categoria);

        /*
        Operador ternário
        * */



    }
}
