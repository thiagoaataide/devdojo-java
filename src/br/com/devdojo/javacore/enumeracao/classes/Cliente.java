package br.com.devdojo.javacore.enumeracao.classes;

public class Cliente {
    public   enum TipoPagamento{
        AVISTA,APRAZO
    }

    private String nome;
    private TipoCliente tipo;
    private TipoPagamento tipoPagamento;

    public Cliente(String nome, TipoCliente tipo, TipoPagamento tipoPagamento) {
        this.nome = nome;
        this.tipo = tipo;
        this.tipoPagamento = tipoPagamento;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", tipo=" + tipo.getTipo() + '\'' +
                ", tipoPagamento=" + tipoPagamento +
                '}';
    }

    //    public static final int PESSOA_FISICA;
//    public static final int PESSOA_JURIDICA;
//
//    static {
//        PESSOA_FISICA = 1;
//        PESSOA_JURIDICA = 2;
//    }
//
//    public Cliente(String nome, int tipo) {
//        this.nome = nome;
//        this.tipo = tipo;
//    }
//
//    @Override
//    public String toString() {
//        String tipo;
//        if(this.tipo == 1)
//            tipo = "Pessoa Física";
//        else tipo = "Pessoa Jurídica";
//        return "Nome: "+ this.nome + " Tipo: "+ tipo;
//    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

//    public static int getPessoaFisica() {
//        return PESSOA_FISICA;
//    }
//
//    public static int getPessoaJuridica() {
//        return PESSOA_JURIDICA;
//    }

//    public int getTipo() {
//        return tipo;
//    }
//
//    public void setTipo(int tipo) {
//        this.tipo = tipo;
//    }
}
