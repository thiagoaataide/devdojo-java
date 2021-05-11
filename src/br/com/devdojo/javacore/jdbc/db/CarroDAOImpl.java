package br.com.devdojo.javacore.jdbc.db;

import br.com.devdojo.javacore.jdbc.classes.Carro;
import br.com.devdojo.javacore.jdbc.classes.Comprador;
import br.com.devdojo.javacore.jdbc.conn.ConexaoFactory;
import br.com.devdojo.javacore.jdbc.interfaces.CarroDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroDAOImpl implements CarroDAO {

    /**
     * Inserir registro em uma tabela
     */
    @Override
    public void save(Carro carro) {
        String sql = "INSERT INTO `agencia`.`carro` (`nome`, `placa`, `compradorid`) VALUES (?, ?, ?)";


        try(Connection conn = ConexaoFactory.getConexao();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1,carro.getNome());
            ps.setString(2,carro.getPlaca());
            ps.setInt(3,carro.getComprador().getId());
            ps.executeUpdate();


            System.out.println("Registro inserido com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Remover registro de uma tabela
     */
    @Override
    public void delete(Carro carro) {
        if (carro == null || carro.getId() == null) {
            System.out.println("Não foi possível excluir o registro");
            return;
        }
        String sql = "DELETE FROM `agencia`.`carro` WHERE `id` = ?";

        try(Connection conn = ConexaoFactory.getConexao();
            PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, carro.getId());
            ps.executeUpdate();

            System.out.println("Registro excluído com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * Realizar uma atualização em um registro no banco
     */
    @Override
    public void update(Carro carro) {
        if (carro == null || carro.getId() == null) {
            System.out.println("Não foi possível atualizar o registro");
            return;
        }
        String sql = "UPDATE `agencia`.`carro` SET `placa` = ?, `nome` = ? WHERE `id` = ?";


        try(Connection conn = ConexaoFactory.getConexao();
            PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, carro.getPlaca());
            ps.setString(2, carro.getNome());
            ps.setInt(3, carro.getId());
            ps.executeUpdate();

            System.out.println("Registro atualizado com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Buscar todos os registros de uma tabela
     */
    @Override
    public  List<Carro> selectAll() {
        String sql = "SELECT id, placa, nome, compradorid FROM agencia.carro";
        List<Carro> carroList = new ArrayList<>();

        try(Connection conn = ConexaoFactory.getConexao();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);) {

            while (rs.next()) {
                Comprador c = CompradorDAO.searchById(rs.getInt("compradorid"));
                carroList.add(new Carro(rs.getInt("id"), rs.getString("nome"), rs.getString("placa"),c));
            }

            return carroList;
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
    @Override
    public List<Carro> searchByName(String nome) {
        String sql = "SELECT id, nome, placa, compradorid FROM agencia.carro WHERE nome LIKE ?";
        List<Carro> compradorList = new ArrayList<>();

        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setString(1,"%"+nome+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Comprador comprador = CompradorDAO.searchById(rs.getInt("id"));
                compradorList.add(new Carro(rs.getInt("id"), rs.getString("nome"), rs.getString("placa"), comprador));
            }
            ConexaoFactory.close(rs);
            return compradorList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

}
