package br.com.devdojo.javacore.comportamentoporparametro.interfaces;

import br.com.devdojo.javacore.comportamentoporparametro.classes.Carro;

public interface CarroPredicate {
    boolean teste(Carro carro);
}
