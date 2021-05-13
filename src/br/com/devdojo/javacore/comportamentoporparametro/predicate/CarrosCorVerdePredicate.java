package br.com.devdojo.javacore.comportamentoporparametro.predicate;

import br.com.devdojo.javacore.comportamentoporparametro.classes.Carro;
import br.com.devdojo.javacore.comportamentoporparametro.interfaces.CarroPredicate;

public class CarrosCorVerdePredicate implements CarroPredicate {
    @Override
    public boolean teste(Carro carro) {
        return carro.getCor().equals("verde");
    }
}
