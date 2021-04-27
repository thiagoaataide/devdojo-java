package br.com.devdojo.javacore.jdbc.db;

import br.com.devdojo.javacore.jdbc.classes.Comprador;
import br.com.devdojo.javacore.jdbc.classes.MyRowSetListener;
import br.com.devdojo.javacore.jdbc.conn.ConexaoFactory;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompradorDB {
    /**
     * Inserir registro em uma tabela
     */
    public static void save(Comprador comprador) {
        String sql = "INSERT INTO `agencia`.`comprador` (`cpf`,`nome`) VALUES ('" + comprador.getCpf() + "','" + comprador.getNome() + "')";
        Connection conn = ConexaoFactory.getConexao();

        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            ConexaoFactory.close(conn, stmt);
            System.out.println("Registro inserido com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * - Inserindo um registro através de uma transação.
     */
    public static void saveTrasanction() {
        String sql1 = "INSERT INTO `agencia`.`comprador` (`cpf`,`nome`) VALUES ('" + "TESTE1" + "','" + "TESTE1" + "')";
        String sql2 = "INSERT INTO `agencia`.`comprador` (`cpf`,`nome`) VALUES ('" + "TESTE2" + "','" + "TESTE2" + "')";
        String sql3 = "INSERT INTO `agencia`.`comprador` (`cpf`,`nome`) VALUES ('" + "TESTE3" + "','" + "TESTE3" + "')";
        Connection conn = ConexaoFactory.getConexao();
        Savepoint savepoint = null;

        try {
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql2);
            savepoint = conn.setSavepoint(); //salvando os statements antes da excceção
            if(true){
                throw new SQLException();
            }
            stmt.executeUpdate(sql3);
            conn.commit();

            ConexaoFactory.close(conn, stmt);
            System.out.println("Registro inserido com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback(savepoint); // volta para o exato momento do savepoint, e o que foi executado será persistido após o commit.
                conn.commit();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
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
        String sql = "DELETE FROM `agencia`.`comprador` WHERE `id` ='" + comprador.getId() + "'";
        Connection conn = ConexaoFactory.getConexao();

        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            ConexaoFactory.close(conn, stmt);
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
        String sql = "UPDATE `agencia`.`comprador` SET `cpf` = '" + comprador.getCpf() + "', `nome` = '" + comprador.getNome() + "' WHERE `id` ='" + comprador.getId() + "'";
        Connection conn = ConexaoFactory.getConexao();

        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            ConexaoFactory.close(conn, stmt);
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
        Connection conn = ConexaoFactory.getConexao();
        List<Comprador> compradorList = new ArrayList<>();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                compradorList.add(new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));
//                System.out.println(rs.getInt("id"));
//                System.out.println(rs.getString("cpf"));
//                System.out.println(rs.getString("nome"));
            }


            ConexaoFactory.close(conn, stmt, rs);
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
        String sql = "SELECT id, cpf, nome FROM agencia.comprador WHERE nome LIKE '%" + nome + "%'";
        List<Comprador> compradorList = new ArrayList<>();

        try (Connection conn = ConexaoFactory.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);) {
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
     * Realizar um consulta e a partir de algum membro de retorno do mesmo obter os dados de metadados
     */
    public static void selectMetaData() {
        String sql = "SELECT * FROM agencia.comprador";

        Connection conn = ConexaoFactory.getConexao();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();

            rs.next();
            int qtdColunas = rsmd.getColumnCount();
            System.out.println("Quantidade de Colunes: " + qtdColunas);
            for (int i = 1; i <= qtdColunas; i++) {
                System.out.println("Tabela: " + rsmd.getTableName(i));
                System.out.println("Coluna: " + rsmd.getColumnName(i));
                System.out.println("Tamanho Coluna: " + rsmd.getColumnDisplaySize(i));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Verificar quais modos estão disponíveis em nosso Driver de banco de dados.
     */
    public static void checkDriverStatus() {
        Connection conn = ConexaoFactory.getConexao();

        try {
            DatabaseMetaData dbmd = conn.getMetaData();
            if (dbmd.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
                System.out.println("Suporta TYPE_FORWARD_ONLY");
                if (dbmd.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE))
                    System.out.println("e também suporta CONCUR_UPDATABLE");
            }

            if (dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                System.out.println("Suporta TYPE_SCROLL_INSENSITIVE");
                if (dbmd.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE))
                    System.out.println("e também suporta CONCUR_UPDATABLE");
            }

            if (dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                System.out.println("Suporta TYPE_SCROLL_SENSITIVE");
                if (dbmd.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE))
                    System.out.println("e também suporta CONCUR_UPDATABLE");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoFactory.close(conn);
        }
    }


    /**
     * Navegando no ResultSet no modo TYPE_SCROLL_INSENSITIVE para permitir ir e voltar no ResultSet
     */
    public static void testTypeScroll() {
        String sql = "SELECT id, cpf, nome FROM agencia.comprador";
        Connection conn = ConexaoFactory.getConexao();

        try {
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.last()) {
                System.out.println("Ultima linha: " + new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));
                System.out.println("Número da última linha: " + rs.getRow());
            }
            System.out.println("Retornou para  a primeira linha: " + rs.first());
            System.out.println("Primeira linha: " + rs.getRow());
            rs.absolute(4);
            System.out.println("Linha 4 " + new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));
            rs.relative(-2);
            System.out.println("Voltando 2 linhas " + new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));
            System.out.println("É a primeira linha? " + rs.isFirst());
            System.out.println("É a última linha? " + rs.isLast());

            System.out.println("----------- Última Linha -----------");
            rs.afterLast();
            while (rs.previous()) {
                System.out.println(new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));
            }

            ConexaoFactory.close(conn, stmt, rs);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    /***
     * Alterando dados no ResultSet e no DB através do ResultSet.
     * Checando quais operações são deectáveis, para verificar se houver um insert, delete ou update.
     * Insrindo novo registro a partir de um registro já existente com conceito de registro temporário.
     * Removendo uma linha do db e rs
     */
    public static void updateNamesToLowerCase() {
        String sql = "SELECT id, cpf, nome FROM agencia.comprador";

        try (Connection conn = ConexaoFactory.getConexao();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql);) {

            DatabaseMetaData rsmd = conn.getMetaData();
            System.out.println(rsmd.updatesAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
            System.out.println(rsmd.insertsAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
            System.out.println(rsmd.deletesAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));

            while (rs.next()) {
                rs.updateString("nome", rs.getString("nome").toLowerCase()); //atualiza apenas no resultset e não no db
                rs.updateRow(); // agora atualiza db
            }

            rs.beforeFirst();
            while (rs.next()) {
                System.out.println(rs.getString("nome"));
            }

            rs.absolute(2); // ir para linha do rs
            String nome = rs.getString("nome"); //obeter a coluna nome da linha 2
            rs.moveToInsertRow(); // criar uma linha de insert temporária
            rs.updateString("cpf", "999.999.999-99"); // atualizar atributos da linha temporária
            rs.updateString("nome", nome.toUpperCase()); // atualizar atributos da linha temporária
            rs.insertRow(); // inserir a linha, ou seja persistir
            rs.moveToCurrentRow(); // retornar para linha original
            System.out.println(rs.getString("nome") + "Linha: " + rs.getRow());

            /*Para remover a linha do banco pelo ResultSet*/
//            rs.absolute(6); // ir para linha
//            rs.deleteRow(); // remover linha do db

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Executando uma busca com o PreparedStatement
     */
    public static List<Comprador> searchByNamePreparedStatement(String nome) {
        String sql = "SELECT id, cpf, nome FROM agencia.comprador WHERE nome LIKE ?";
        List<Comprador> compradorList = new ArrayList<>();

        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setString(1, nome);
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

    public static void updatePreparedStatement(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("Não foi possível atualizar o registro");
            return;
        }
        String sql = "UPDATE `agencia`.`comprador` SET `cpf` = ?, `nome` = ? WHERE `id` = ? ";
        Connection conn = ConexaoFactory.getConexao();

        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, comprador.getCpf());
            st.setString(2, comprador.getNome());
            st.setInt(3, comprador.getId());

            st.executeUpdate();
            ConexaoFactory.close(conn, st);


            System.out.println("Registro atualizado com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * Executando uma busca com o CallableStatement
     * Realizando uma busca através da chamda de uma procedure.
     */
    public static List<Comprador> searchByNameCallableStatemente(String nome) {
        String sql = "call agencia.SP_GET_COMPRADORES_POR_NOME( ? )";
        List<Comprador> compradorList = new ArrayList<>();

        try (Connection conn = ConexaoFactory.getConexao();
             CallableStatement cb = conn.prepareCall(sql);) {

            cb.setString(1, "%" + nome + "%");
            ResultSet rs = cb.executeQuery();

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

    /**
     * - Realizando uma busca pelo nome
     * - Utilizando uma conexão através do RowSet Connected
     * - Utilizando o Listener: RowSetListener para identificar os eventos ocorridos.
     */
    public static List<Comprador> searchByNameRowSet(String nome) {
        String sql = "SELECT id, cpf, nome FROM agencia.comprador WHERE nome LIKE ?";
        List<Comprador> compradorList = new ArrayList<>();

        try (JdbcRowSet jrs = ConexaoFactory.getRowSetConnection();) {
            jrs.addRowSetListener(new MyRowSetListener()); //adicionado o listener
            jrs.setCommand(sql);
            jrs.setString(1, "%" + nome + "%");
            jrs.execute();

            while (jrs.next()) {
                compradorList.add(new Comprador(jrs.getInt("id"), jrs.getString("cpf"), jrs.getString("nome")));
            }

            return compradorList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    /**
     * - Realizando Update através de uma conexão com RowSet
     * - Utilizando o Listener: RowSetListener para identificar os eventos ocorridos.
     */
    public static void updateRowSet(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("Não foi possível atualizar o registro");
            return;
        }
//        String sql = "UPDATE `agencia`.`comprador` SET `cpf` = ?, `nome` = ? WHERE `id` = ? ";
        String sql = "SELECT id, cpf, nome FROM `agencia`.`comprador` WHERE `id` = ? ";

        try (JdbcRowSet jrs = ConexaoFactory.getRowSetConnection();) {
            jrs.addRowSetListener(new MyRowSetListener());//adicionado listener
            jrs.setCommand(sql);
            jrs.setInt(1, comprador.getId());
            jrs.execute();

            jrs.next(); //acessar o próximo registro
            jrs.updateString("nome", "TIA LETE");
            jrs.updateRow();

            System.out.println("Registro atualizado com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * - Utilizando o RowSetCached
     * - Realizando Update através de uma conexão com RowSet
     * - Utilizando o Listener: RowSetListener para identificar os eventos ocorridos.
     */
    public static void updateRowSetCached(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("Não foi possível atualizar o registro");
            return;
        }
        String sql = "SELECT id, cpf, nome FROM comprador WHERE id = ? ";

        try (CachedRowSet crs = ConexaoFactory.getRowSetConnectionCached();) {
//            crs.addRowSetListener(new MyRowSetListener());//adicionado listener
            crs.setCommand(sql);
            crs.setInt(1, comprador.getId());
            crs.execute();

            crs.next(); //acessar o próximo registro
            crs.updateString("nome", "Gilvanete de Souza");
            crs.updateRow();
//            Thread.sleep(10000);
            crs.acceptChanges();

            System.out.println("Registro atualizado com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

