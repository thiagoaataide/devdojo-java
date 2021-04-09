package br.com.devdojo.introducao.controlefluxo;

public class ExercicioControleFluxo3 {
    public static void main(String[] args) {

        for(int i = 0; i<= 100000;i++){
            float resto = 0;
            resto = i%2;
            if(resto==0f){
                System.out.println(i);
            }

        }


    }
}
