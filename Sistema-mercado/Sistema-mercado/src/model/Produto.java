
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Produto {
    
    private String id;
    private String nome;
    private String descricao;
    private double valor;
    
    private int qtde;
    private int qtdeVendida;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public int getQtdeVendida() {
        return qtdeVendida;
    }

    public void setQtdeVendida(int qtdeVendida) {
        this.qtdeVendida = qtdeVendida;
    }
    
       
    public static boolean insert(Produto produto){
        String sql = "INSERT INTO produtos(nome,descricao,valor) VALUES (?,?,?)";
        Connection conn;
        
        conn = ConnectionFactory.getConnection();
        PreparedStatement stm = null;

        try {
            stm = conn.prepareStatement(sql);

            stm.setString(1, produto.getNome());
            stm.setString(2, produto.getDescricao());
            stm.setDouble(3, produto.getValor());
            stm.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        } finally {
            ConnectionFactory.closeConnection(conn, stm);
        }
    }
    public static boolean delete(Produto produto){
        String sql = "DELETE FROM produtos WHERE id = ?";
        Connection conn;
        
        conn = ConnectionFactory.getConnection();
        PreparedStatement stm = null;

        try {
            stm = conn.prepareStatement(sql);
            stm.setString(1, produto.getId());
            stm.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        } finally {
            ConnectionFactory.closeConnection(conn, stm);
        }
    }
    public static boolean update(Produto produto){
        String sql =    "UPDATE produtos SET nome = ? , descricao = ? "
                +       ", valor = ?, qtdeVendida = ? WHERE id = ?";
        Connection conn;
        
        conn = ConnectionFactory.getConnection();
        PreparedStatement stm = null;

        try {
            stm = conn.prepareStatement(sql);

            
            stm.setString(1, produto.getNome());
            stm.setString(2, produto.getDescricao());
            stm.setDouble(3, produto.getValor());
            stm.setInt(4, produto.getQtdeVendida());
            stm.setString(5, produto.getId());
            
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        } finally {
            ConnectionFactory.closeConnection(conn, stm);
        }
    }
    
    public static ArrayList<Produto> findTodosProdutos(){
    
        String sql = "SELECT * FROM produtos";
        Connection conn;
        PreparedStatement stm = null;
        ResultSet rs = null;
        conn = ConnectionFactory.getConnection();

        ArrayList<Produto> produtos = new ArrayList<>();

        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                Produto p = new Produto();

                p.setId( rs.getString("id") );
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setQtdeVendida(rs.getInt("qtdeVendida"));
                p.setValor(rs.getDouble("valor"));
                
                produtos.add(p);
            }
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stm, rs);
        }

        return produtos;
    }
    
    public static ArrayList<Produto> findProdutoEspecifico(String filtro){
    
        String sql =    "SELECT * FROM produtos "
                +       "WHERE nome LIKE ?";
        Connection conn;
        PreparedStatement stm = null;
        ResultSet rs = null;
        conn = ConnectionFactory.getConnection();

        ArrayList<Produto> produtos = new ArrayList<>();

        try {
            stm = conn.prepareStatement(sql);
            
            stm.setString(1, filtro.trim() + "%" );
            
            rs = stm.executeQuery();
            while (rs.next()) {
                Produto p = new Produto();

                p.setId( rs.getString("id") );
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setQtdeVendida(rs.getInt("qtdeVendida"));
                p.setValor(rs.getDouble("valor"));
                
                produtos.add(p);
            }
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stm, rs);
        }

        return produtos;
    }
    
    
}
