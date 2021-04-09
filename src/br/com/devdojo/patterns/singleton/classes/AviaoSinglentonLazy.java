package br.com.devdojo.patterns.singleton.classes;

import java.util.HashSet;
import java.util.Set;

public class AviaoSinglentonLazy {

    private static AviaoSinglentonLazy INSTANCE;
    private Set<String> assentosDisponiveis;

//    public  static AviaoSinglentonLazy getInstance(){
//        if(INSTANCE == null){
//            INSTANCE = new AviaoSinglentonLazy();
//        }
//        return INSTANCE;
//    }


    //thread save
//    public synchronized  static AviaoSinglentonLazy getInstance(){
    public static AviaoSinglentonLazy getInstance(){
        if(INSTANCE == null){
            synchronized (AviaoSinglentonLazy.class) {
                if(INSTANCE == null)
                    INSTANCE = new AviaoSinglentonLazy();
            }

        }
        return INSTANCE;
    }

    private AviaoSinglentonLazy(){
        this.assentosDisponiveis = new HashSet<>();
        assentosDisponiveis.add("1A");
        assentosDisponiveis.add("1B");
        assentosDisponiveis.add("1C");
    }

    public boolean bookAssento(String assento){
        return assentosDisponiveis.remove(assento);
    }
}
