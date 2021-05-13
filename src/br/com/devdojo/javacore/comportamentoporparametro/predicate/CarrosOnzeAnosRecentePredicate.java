package br.com.devdojo.javacore.comportamentoporparametro.predicate;

import br.com.devdojo.javacore.comportamentoporparametro.classes.Carro;
import br.com.devdojo.javacore.comportamentoporparametro.interfaces.CarroPredicate;

import java.util.Calendar;

public class CarrosOnzeAnosRecentePredicate implements CarroPredicate {
    @Override
    public boolean teste(Carro carro) {
        return carro.getAno() > Calendar.getInstance().get(Calendar.YEAR) - 11;
    }
}
