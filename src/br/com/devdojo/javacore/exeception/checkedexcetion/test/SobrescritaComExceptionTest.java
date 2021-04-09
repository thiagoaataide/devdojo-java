package br.com.devdojo.javacore.exeception.checkedexcetion.test;

import br.com.devdojo.javacore.exeception.checkedexcetion.classes.Funcionario;
import br.com.devdojo.javacore.exeception.checkedexcetion.classes.Pessoa;
import br.com.devdojo.javacore.exeception.customexception.LoginInvalidException;

import java.io.FileNotFoundException;

public class SobrescritaComExceptionTest {
    public static void main(String[] args) {
        Funcionario f = new Funcionario();
        Pessoa p = new Pessoa();

        /*
        * Ao sobrescrever um método de uma classe que lança exceção, o mesmo pode não mais
        * lançar nenhuma exceção e não ser necessário o tratamento da mesma.*/
//        f.salvar();
        try {
            p.salvar();
        } catch (LoginInvalidException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
