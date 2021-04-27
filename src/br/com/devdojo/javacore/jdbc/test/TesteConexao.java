package br.com.devdojo.javacore.jdbc.test;

import br.com.devdojo.javacore.jdbc.classes.Comprador;
import br.com.devdojo.javacore.jdbc.conn.ConexaoFactory;
import br.com.devdojo.javacore.jdbc.db.CompradorDB;

import java.sql.Connection;
import java.util.List;

public class TesteConexao {
    public static void main(String[] args) {
//        Connection conexao = ConexaoFactory.getConexao();
//        atualizar();
//        List<Comprador> compradorList = buscarPorNome("ago");
//        System.out.println(compradorList);
//        CompradorDB.selectMetaData();
//        CompradorDB.checkDriverStatus();
//        CompradorDB.testTypeScroll();
//        CompradorDB.updateNamesToLowerCase();
//        System.out.println(CompradorDB.searchByNamePreparedStatement("thiago alberto"));
//        CompradorDB.updatePreparedStatement(new Comprador(5, "123.456.789-99", "Miguelito Pimenta"));
//        System.out.println(CompradorDB.searchByNameCallableStatemente("miguel"));
//        System.out.println(CompradorDB.searchByNameRowSet("miche"));
//        CompradorDB.updateRowSet(new Comprador(3,"171.769.054-87","GIL"));
//        CompradorDB.updateRowSetCached(new Comprador(3,"171.769.054-87","GIL"));
        CompradorDB.saveTrasanction();
    }

    public static void inserir() {
        Comprador comprador = new Comprador("171.769.054-87", "Gilvanete Ataide");
        CompradorDB compradorDB = new CompradorDB();
        compradorDB.save(comprador);
    }

    public static void deletar() {
        Comprador comprador = new Comprador();
        comprador.setId(2);
        CompradorDB.delete(comprador);
    }

    public static void atualizar() {
        Comprador comprador = new Comprador(1, "083.388.654-19", "Thiago Alberto");
        CompradorDB.update(comprador);
    }

    public static List<Comprador> selecionarTudo() {
        return CompradorDB.selectAll();
    }

    public static List<Comprador> buscarPorNome(String nome){
        return CompradorDB.searchByName(nome);
    }
}
