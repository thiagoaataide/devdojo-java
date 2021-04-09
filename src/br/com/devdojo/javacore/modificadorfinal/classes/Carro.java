package br.com.devdojo.javacore.modificadorfinal.classes;

public class Carro {

    private static final double VELOCIDADE_FINAL = 250;
//    public static final double VELOCIDADE_FINAL = 250;
    private final Comprador COMPRADOR = new Comprador();
    private String nome;
    private String marca;

    /*É possível realizar a inicialização de uma constante pelo construtor,
    * com tudo se ela utilizar o modificador static, significa que ela existe antes mesmo do objeto;
    * Por isso não é possível inicializar a mesma no construtor, e isso acarreta em erro de compilação.*/
//    public Carro() {
//        VELOCIDADE_FINAL = 200;
//    }

    /*É possível manter a declaração da variável com o modificador static, e utilizar um bloco de inicialização*/
//    static {
//        VELOCIDADE_FINAL = 200;
//    }

    @Override
    public String toString() {
        return "Carro{" +
                "nome='" + nome + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }

    public static double getVelocidadeFinal() {
        return VELOCIDADE_FINAL;
    }

    public Comprador getComprador() {
        return COMPRADOR;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
