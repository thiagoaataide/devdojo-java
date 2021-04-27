package br.com.devdojo.javacore.jdbc.conn;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.security.PublicKey;
import java.sql.*;

/**
 * Principais Interfaces do JDBC
 * <p>
 * - Connection
 * - Statement: é o objeto que irá trabalhar com os dados, e irá executar o comando no banco de dados.
 * - ResultSet
 * <p>
 * Para obter a conexão com o banco iremos utilizar a classe: DriverManager
 */

public class ConexaoFactory {

    public static Connection getConexao() {
        String url = "jdbc:mysql://localhost:33066/agencia";
        String user = "thiago";
        String password = "123456";

        try {
            return DriverManager.getConnection(url, user, password);
//            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static JdbcRowSet getRowSetConnection() {
        String url = "jdbc:mysql://localhost:33066/agencia";
        String user = "thiago";
        String password = "123456";

        try {
            JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
            jdbcRowSet.setUrl(url);
            jdbcRowSet.setUsername(user);
            jdbcRowSet.setPassword(password);

            return jdbcRowSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static CachedRowSet getRowSetConnectionCached() {
        String url = "jdbc:mysql://localhost:33066/agencia?autocommit=false";
        String user = "thiago";
        String password = "123456";

        try {
            CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
            cachedRowSet.setUrl(url);
            cachedRowSet.setUsername(user);
            cachedRowSet.setPassword(password);

            return cachedRowSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void close(Connection conn) {

        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void close(Connection conn, Statement stmt) {
        close(conn);

        try {
            if (stmt != null)
                stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        close(conn, stmt);

        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rs) {

        try {
            if (rs != null)
                rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
