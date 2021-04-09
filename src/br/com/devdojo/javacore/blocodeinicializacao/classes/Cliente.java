package br.com.devdojo.javacore.blocodeinicializacao.classes;
/*
 * Aulas:
 * 31 - Blocos de Inicialização

 * */

public class Cliente {
    private int[] parcelas;

    /*Declaração do bloco de inicialização*/
    {
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

    public int[] getParcelas() {
        return parcelas;
    }

    public void setParcelas(int[] parcelas) {
        this.parcelas = parcelas;
    }
}
