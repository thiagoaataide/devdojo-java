package br.com.devdojo.javacore.comportamentoporparametro.test;

import br.com.devdojo.javacore.comportamentoporparametro.classes.Carro;
import br.com.devdojo.javacore.comportamentoporparametro.interfaces.CarroPredicate;
import br.com.devdojo.javacore.comportamentoporparametro.predicate.CarrosCorVerdePredicate;
import br.com.devdojo.javacore.comportamentoporparametro.predicate.CarrosOnzeAnosRecentePredicate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static java.util.Arrays.asList;

public class CarroTest {
    public static List<Carro> filtarCarroVerde(List<Carro> carros){
        List<Carro> result = new ArrayList<>();
        for (Carro carro : carros) {
            if(carro.getCor().equals("verde")){
                result.add(carro);
            }
        }

        return result;
    }

    public static List<Carro> filtarCarroVermelho(List<Carro> carros){
        List<Carro> result = new ArrayList<>();
        for (Carro carro : carros) {
            if(carro.getCor().equals("vermelho")){
                result.add(carro);
            }
        }

        return result;
    }

    public static List<Carro> filtarCarroPorCor(List<Carro> carros, String cor){
        List<Carro> result = new ArrayList<>();
        for (Carro carro : carros) {
            if(carro.getCor().equals(cor)){
                result.add(carro);
            }
        }

        return result;
    }

    public static List<Carro> filtarCarroOnzeAnos(List<Carro> carros){
        List<Carro> result = new ArrayList<>();
        for (Carro carro : carros) {
            if(carro.getAno() > Calendar.getInstance().get(Calendar.YEAR) - 11){
                result.add(carro);
            }
        }

        return result;
    }

    /**
     * Utilizando o padrão Strategy
     *
     **/
    public static List<Carro> filtrarCarros(List<Carro> carros, CarroPredicate predicate){
        List<Carro> result = new ArrayList<>();
        for (Carro carro : carros) {
            if(predicate.teste(carro)){
                result.add(carro);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Carro> carros = asList(new Carro("verde", 2011), new Carro("vermelho", 1995), new Carro("preto",2017));
//        System.out.println(filtarCarroVerde(carros));
//        System.out.println(filtarCarroVermelho(carros));
//        System.out.println(filtarCarroPorCor(carros,"verde"));
//        System.out.println(filtarCarroPorCor(carros,"preto"));
//        System.out.println(filtarCarroOnzeAnos(carros));
        System.out.println(filtrarCarros(carros, new CarrosOnzeAnosRecentePredicate()));
        System.out.println(filtrarCarros(carros, new CarrosCorVerdePredicate()));

    }
}
