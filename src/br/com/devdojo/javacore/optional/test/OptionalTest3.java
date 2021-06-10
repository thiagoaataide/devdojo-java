package br.com.devdojo.javacore.optional.test;

import br.com.devdojo.javacore.optional.classes.Carro;
import br.com.devdojo.javacore.optional.classes.Pessoa;
import br.com.devdojo.javacore.optional.classes.Seguradora;

import java.util.Optional;

public class OptionalTest3 {
    public static void main(String[] args) {
        Seguradora seguradora = new Seguradora("Tokio Marine");
        Carro carro = new Carro(seguradora,"HB20S");
        Carro carro2 = new Carro("Fox");
        Pessoa p = new Pessoa(carro,"Thiago Alberto");
        Pessoa p2 = new Pessoa("Thiago Alberto");
        Pessoa p3 = null;
        Pessoa p4 = new Pessoa(carro2,"Thiago Alberto");

        System.out.println(obterNomeSeguradora(Optional.ofNullable(p)));
        System.out.println(obterNomeSeguradora(Optional.ofNullable(p2)));
        System.out.println(obterNomeSeguradora(Optional.ofNullable(p3)));
        System.out.println(obterNomeSeguradora(Optional.ofNullable(p4)));

        System.out.println(obterNomeCarro(Optional.ofNullable(p)));
        System.out.println(obterNomeCarro(Optional.ofNullable(p2)));

    }

    public static String obterNomeSeguradora(Optional<Pessoa> p){
        System.out.println(
                p.flatMap(Pessoa::getCarro)
                        .flatMap(Carro::getSeguradora)
                        .map(Seguradora::getNome)
                        .orElse("Não existe seguradora")
        );
        return "";
    }

    public static String obterNomeCarro(Optional<Pessoa> p){
        System.out.println(
                p.flatMap(Pessoa::getCarro)
                        .map(Carro::getNome)
                        .orElse("Não existe carro"));
        return "";
    }
}
