package br.com.devdojo.patterns.singleton.classes;

import java.util.HashSet;
import java.util.Set;

public class AviaoSingletonEager {
    private static final AviaoSingletonEager INSTANCE = new AviaoSingletonEager();
    private Set<String> assentosDisponiveis;

    public static AviaoSingletonEager getInstance(){
        return INSTANCE;
    }

    private AviaoSingletonEager(){
        this.assentosDisponiveis = new HashSet<>();
        assentosDisponiveis.add("1A");
        assentosDisponiveis.add("1B");
        assentosDisponiveis.add("1C");
    }

    public boolean bookAssento(String assento){
        return assentosDisponiveis.remove(assento);
    }
}
