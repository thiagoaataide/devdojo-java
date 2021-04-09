package br.com.devdojo.introducao.controlefluxo;

public class ControleFluxo3 {

    public static void main(String[] args) {
        byte dia = 3;

        if (dia == 1){
            System.out.println("Domingo");
        } else if (dia == 2){
            System.out.println("Segunda");
        } else if (dia == 3){
            System.out.println("Terça");
        } else if(dia == 4){
            System.out.println("Quarta");
        }else if (dia == 5){
            System.out.println("Quinta");
        } else if (dia == 6){
            System.out.println("Sexta");
        } else if(dia == 7){
            System.out.println("Sábado");
        } else {
            System.out.println("Não é um dia da semana válido!");
        }

        /*switch só aceita as seguintes variáveis:
        char
        int
        byte
        short
        enum
        String
        * */
        switch (dia){
            case 1:
                System.out.println("Domingo");
                break;
            case 2:
                System.out.println("Segunda");
                break;
            case 3:
                System.out.println("Terça");
                break;
            case 4:
                System.out.println("Quarta");
                break;
            case 5:
                System.out.println("Quinta");
                break;
            case 6:
                System.out.println("Sexta");
                break;
            case 7:
                System.out.println("Sábado");
                break;
        }

        char sexo = 'M';
        switch (sexo){
            case 'F':
                System.out.println("Feminino");
                break;
            case 'M':
                System.out.println("Masculino");
                break;
            default:
                System.out.println("Nenhuma das opções anteriores");
        }

    }
}
