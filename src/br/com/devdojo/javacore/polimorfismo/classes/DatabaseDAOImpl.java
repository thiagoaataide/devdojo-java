package br.com.devdojo.javacore.polimorfismo.classes;

public class DatabaseDAOImpl implements GenericDAO{

    @Override
    public void save() {
        System.out.println("Salvando dados nos Banco de Dados!");
    }
}
