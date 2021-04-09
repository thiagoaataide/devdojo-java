package br.com.devdojo.javacore.enumeracao.test;

import br.com.devdojo.javacore.enumeracao.classes.Cliente;
import br.com.devdojo.javacore.enumeracao.classes.TipoCliente;

public class ClienteTest {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Anna", TipoCliente.PESSOA_FISICA, Cliente.TipoPagamento.APRAZO);
        System.out.println(cliente);

        //Acessando método do enumerador;
        System.out.println(TipoCliente.PESSOA_JURIDICA.getTipo());
    }
}
