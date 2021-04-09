package br.com.devdojo.introducao.controlefluxo;

public class ControleFluxo5 {
    public static void main(String[] args) {
        /*Dado o valor de um carro, descubra em quantas vezes ele pode ser parcelado.
        Levando em conta que o valor da parcela não pode ser menor que 1000.00.
        * */

        double valorTotal = 30000;

//        for(int parcela=1;parcela <= valorTotal; parcela++){
//            double valorParcela = valorTotal / parcela;
//            if(valorParcela >= 1000) {
//                System.out.println("Parcela " + parcela + " R$ " + valorParcela);
//            }else {
//                System.out.println("Saindo do Laco");
//                break;
//            }
//            System.out.println("Fora do Laço");
//        }

        for(int parcela=1;parcela <= valorTotal; parcela++) {
            double valorParcela = valorTotal / parcela;
           if(valorParcela < 1000){
               break;
           }
            System.out.println("Parcela " + parcela + " R$ " + valorParcela);
        }

    }
}
