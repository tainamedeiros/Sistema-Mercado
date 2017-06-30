package model;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {

    public static final String PATHBD = System.getProperty("user.dir") + File.separator + "BancoDeDados";
    public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    public static final String URL = "jdbc:derby:" + PATHBD;
    public static final String USER = "root";
    public static final String PASS = "";
    public static File banco = new File("BancoDeDados");

    
    //Caso o banco de dados
    public static boolean createDb() {
        Connection conn;
        Statement stm;
        if (banco.exists()) {
            System.out.println("A banco de dados já foi criado anteriormente...");
        } else {
            try {
                Class.forName(DRIVER);
                String bd = URL + ";create=true";
                conn = DriverManager.getConnection(bd);
                PreparedStatement ps;

                String criarTabelaClientes = 
                          "CREATE TABLE clientes("
                        + "cpf CHAR(15) PRIMARY KEY,"
                        + "nome VARCHAR(50) NOT NULL,"
                        + "sobrenome VARCHAR(50) NOT NULL,"
                        + "email VARCHAR(50),"
                        + "telefone VARCHAR(16),"
                        + "valorGasto DECIMAL(10,2),"
                        + "qtdeProdutos INT)";
                ps = conn.prepareStatement(criarTabelaClientes);
                ps.execute();
                ps.close();
                System.out.println("Tabela clientes gerada");

                String criarTabelaProdutos = 
                          "CREATE TABLE produtos("
                        + "id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                        + "nome VARCHAR(100),"
                        + "descricao VARCHAR(255),"
                        + "qtdeVendida INT,"
                        + "valor DECIMAL(10,2))";
                stm = conn.createStatement();

                stm.executeUpdate(criarTabelaProdutos);
                stm.close();
                System.out.println("Tabela produtos gerada");
                
                String criarTabelaPedidos = 
                          "CREATE TABLE pedidos("
                        + "id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                        + "valoTotal DECIMAL(10,2),"
                        + "cpfCliente CHAR(15) REFERENCES clientes(cpf),"
                        + "data DATE,"
                        + "qtdeProdutos INT)";
                stm = conn.createStatement();
                stm.executeUpdate(criarTabelaPedidos);
                stm.close();
                
                System.out.println("Tabela pedidos gerada");                
                
                
                return true;

            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return false;
    }

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão", ex);
        }
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.err.println("Erro:" + ex);
            }
        }
    }

    public static void closeConnection(Connection conn, PreparedStatement stm) {
        if (stm != null) {
            try {
                stm.close();
            } catch (SQLException ex) {
                System.err.println("Erro:" + ex);
            }
        }
        closeConnection(conn);
    }

    public static void closeConnection(Connection conn, PreparedStatement stm, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("Erro:" + ex);
            }
        }
        closeConnection(conn, stm);
    }

}
