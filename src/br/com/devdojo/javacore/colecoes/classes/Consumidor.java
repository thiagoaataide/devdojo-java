package br.com.devdojo.javacore.colecoes.classes;

public class Consumidor {
    private String nome;
    private String cpf;

    public Consumidor(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Consumidor)) return false;

        Consumidor that = (Consumidor) o;

        return getCpf().equals(that.getCpf());
    }

    @Override
    public int hashCode() {
        return getCpf().hashCode();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Consumidor{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
