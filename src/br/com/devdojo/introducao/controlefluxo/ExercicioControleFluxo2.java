package br.com.devdojo.introducao.controlefluxo;

public class ExercicioControleFluxo2 {
    public static void main(String[] args) {
        /*
        Criar um switch dado o valor de 1 a 7
        Considerando o 1 domingo imprima se é dial util ou final de semana.
        * */
        int dia = 3;
        switch (dia) {
            case 1:
            case 7:
                System.out.println("É Final de Semana");
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                System.out.println("É Dia Útil");
                break;
            default:
                System.out.println("Não é um dia da semana válido!");
        }


    }
}
