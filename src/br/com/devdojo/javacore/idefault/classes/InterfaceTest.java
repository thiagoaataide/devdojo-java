package br.com.devdojo.javacore.idefault.classes;

import br.com.devdojo.javacore.idefault.interfaces.MyList;

public class InterfaceTest implements MyList {
    public static void main(String[] args) {
        //Invocando comportamento estático da interface
        MyList.sort();

        InterfaceTest o = new InterfaceTest();
        //Sobrescrevendo método da interface
        o.add();

        //Invocando método concreto da interface
        o.remove();
    }

    @Override
    public void add() {
        System.out.println("Sobrescrevendo método abstrato na interface.");
    }
}
