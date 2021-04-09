package br.com.devdojo.introducao.controlefluxo;

public class ExercicioControleFluxo {
    public static void main(String[] args) {
        float salario = 2100f;
        float imposto;

        /*
        salario < 1000 Imposto: 5%
        salario >= 1000 && salario < 2000 Imposto: 10%
        salario >= 2000 && < 4000 Imposto: 15%
        salario > 5000 Imposto =25%
        * */

        if (salario<1000){
            imposto = salario * 0.05f;
        } else if(salario >= 1000 && salario < 2000){
            imposto = salario * 0.10f;
        } else if (salario >=2000 && salario < 4000){
            imposto = salario * 0.15f;
        }else {
            imposto = salario * 0.25f;
        }

        System.out.println(imposto);


    }
}
