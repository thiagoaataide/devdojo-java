package br.com.devdojo.javacore.jdbc.db;

import br.com.devdojo.javacore.jdbc.classes.Comprador;
import br.com.devdojo.javacore.jdbc.conn.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompradorDAO {
    /**
     * Inserir registro em uma tabela
     */
    public static void save(Comprador comprador) {
        String sql = "INSERT INTO `agencia`.`comprador` (`cpf`,`nome`) VALUES (?, ?)";


        try(Connection conn = ConexaoFactory.getConexao();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1,comprador.getCpf());
            ps.setString(2,comprador.getNome());
            ps.executeUpdate();


            System.out.println("Registro inserido com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Remover registro de uma tabela
     */
    public static void delete(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("Não foi possível excluir o registro");
            return;
        }
        String sql = "DELETE FROM `agencia`.`comprador` WHERE `id` = ?";

        try(Connection conn = ConexaoFactory.getConexao();
            PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, comprador.getId());
            ps.executeUpdate();

            System.out.println("Registro excluído com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * Realizar uma atualização em um registro no banco
     */
    public static void update(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("Não foi possível atualizar o registro");
            return;
        }
        String sql = "UPDATE `agencia`.`comprador` SET `cpf` = ?, `nome` = ? WHERE `id` = ?";


        try(Connection conn = ConexaoFactory.getConexao();
            PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, comprador.getCpf());
            ps.setString(2, comprador.getNome());
            ps.setInt(3, comprador.getId());
            ps.executeUpdate();

            System.out.println("Registro atualizado com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Buscar todos os registros de uma tabela
     */
    public static List<Comprador> selectAll() {
        String sql = "SELECT id, cpf, nome FROM agencia.comprador";
        List<Comprador> compradorList = new ArrayList<>();

        try(Connection conn = ConexaoFactory.getConexao();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);) {

            while (rs.next()) {
                compradorList.add(new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));
            }

            return compradorList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }


    /**
     * Realizar uma busca por nome, o nome pode ser qualquer coisa e a consulta usará o LIKE %% para tentar achar
     * qualquer parte deste nome, e retornar os registros, se houverem.
     * <p>
     * Aqui também foi implementado o try-with-resourses para melhor gerenciar os recursos.
     */
    public static List<Comprador> searchByName(String nome) {
        String sql = "SELECT id, cpf, nome FROM agencia.comprador WHERE nome LIKE ?";
        List<Comprador> compradorList = new ArrayList<>();

        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setString(1,"%"+nome+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                compradorList.add(new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));
            }
            ConexaoFactory.close(rs);
            return compradorList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }


    public static Comprador searchById(Integer id) {
        String sql = "SELECT id, cpf, nome FROM agencia.comprador WHERE id = ?";

        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome"));
            }
            ConexaoFactory.close(rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

}
