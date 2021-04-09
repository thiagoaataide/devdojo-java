package br.com.devdojo.javacore.enumeracao.classes;

public enum TipoCliente {
    //constant specific class body
    PESSOA_FISICA(1,"Pessoa Física"){
        public String getId(){
         return "C";
        }
    },PESSOA_JURIDICA(2,"Pessoa Jurídica");

    private int tipo;
    private String nomeTipo;

    TipoCliente(int tipo,String nomeTipo) {
        this.tipo = tipo;
        this.nomeTipo = nomeTipo;
    }

    public int getTipo() {
        return tipo;
    }

    public String getId(){
        return "A";
    }
}
