package br.com.devdojo.introducao.controlefluxo;

public class ControleFluxo6 {
    public static void main(String[] args) {

       double valotTotal = 30000;

       for(int parcela = (int) valotTotal; parcela >= 1;parcela--){
           double valorParcela = valotTotal / parcela;
           if(valorParcela < 1000){
               //Continue ignore o código abaixo.
               continue; //Se o a condição do IF for verdadeiro, ele entra no continue que faz a chamada ao inicio do for.
           }

           System.out.println("Parcela " + parcela + " R$ " + valorParcela);
       }

    }
}
