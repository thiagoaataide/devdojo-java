package br.com.devdojo.javacore.polimorfismo.test;

import br.com.devdojo.javacore.polimorfismo.classes.ArquivoDAOImpl;
import br.com.devdojo.javacore.polimorfismo.classes.DatabaseDAOImpl;
import br.com.devdojo.javacore.polimorfismo.classes.GenericDAO;

public class DAOTest {
    public static void main(String[] args) {
//        ArquivoDAOImpl arquivoDAO = new ArquivoDAOImpl();
//        arquivoDAO.save();

        /*
        * Essa forma de programação orientada a interface te permite trocar a implementação
        * alterando apenas para o conteúdo de outra classe que também implementa
        * a mesma interface. Ficando assim uma manutenção mais
        * fácil;*/

//        GenericDAO arquivoDAO = new ArquivoDAOImpl();
        GenericDAO arquivoDAO = new DatabaseDAOImpl();
        arquivoDAO.save();
    }
}
