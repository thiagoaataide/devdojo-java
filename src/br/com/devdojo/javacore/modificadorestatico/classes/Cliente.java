package br.com.devdojo.javacore.modificadorestatico.classes;
/*
 * Aulas:
 * 31 - Blocos de Inicialização

 * */

public class Cliente {
    private static int[] parcelas;

    /*Declaração do bloco de inicialização*/
    static {
        parcelas = new int[100];
        System.out.println("Dentro do bloco de inicialização");
        for(int i=1; i<=100;i++){
            parcelas[i-1] = i;
        }
    }

    public Cliente(){
        System.out.println("Dentro do Construtor");
//        for(int parcela : this.parcelas){
//            System.out.print(parcela + " ");
//        }
    }

    public static int[] getParcelas() {
        return parcelas;
    }

    public static void setParcelas(int[] parcelas) {
        Cliente.parcelas = parcelas;
    }
}
