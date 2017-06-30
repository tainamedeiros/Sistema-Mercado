
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Cliente {
    
    private String cpf;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String email;
    
    private int qtdeProdutos;
    private double valorGasto;
    
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getQtdeProdutos() {
        return qtdeProdutos;
    }

    public void setQtdeProdutos(int qtdeProdutos) {
        this.qtdeProdutos = qtdeProdutos;
    }

    public double getValorGasto() {
        return valorGasto;
    }

    public void setValorGasto(double valorGasto) {
        this.valorGasto = valorGasto;
    }
    
    
 
    
    
    public static boolean insert(Cliente cliente){
        String sql = "INSERT INTO clientes(cpf,nome,sobrenome,email,telefone) VALUES (?,?,?,?,?)";
        Connection conn;
        
        conn = ConnectionFactory.getConnection();
        PreparedStatement stm = null;

        try {
            stm = conn.prepareStatement(sql);

            stm.setString(1, cliente.getCpf());
            stm.setString(2, cliente.getNome());
            stm.setString(3, cliente.getSobrenome());
            stm.setString(4, cliente.getEmail());
            stm.setString(5, cliente.getTelefone());
            stm.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        } finally {
            ConnectionFactory.closeConnection(conn, stm);
        }
    }
    public static boolean delete(Cliente cliente){
        String sql = "DELETE FROM clientes WHERE cpf=?";
        Connection conn;
        
        conn = ConnectionFactory.getConnection();
        PreparedStatement stm = null;

        try {
            stm = conn.prepareStatement(sql);
            stm.setString(1, cliente.getCpf());
            stm.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        } finally {
            ConnectionFactory.closeConnection(conn, stm);
        }
    }
    public static boolean update(Cliente cliente){
        String sql =    "UPDATE clientes SET cpf = ?, nome = ? , sobrenome = ? "
                +       ", email = ?,telefone = ?, valorGasto = ? , qtdeProdutos = ?"
                +       " WHERE cpf = ?";
        Connection conn;
        
        conn = ConnectionFactory.getConnection();
        PreparedStatement stm = null;

        try {
            stm = conn.prepareStatement(sql);

            stm.setString(1, cliente.getCpf());
            stm.setString(2, cliente.getNome());
            stm.setString(3, cliente.getSobrenome());
            stm.setString(4, cliente.getEmail());
            stm.setString(5, cliente.getTelefone());
            stm.setDouble(6, cliente.getValorGasto());
            stm.setInt(7, cliente.getQtdeProdutos());
            stm.setString(8, cliente.getCpf());
            
            
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        } finally {
            ConnectionFactory.closeConnection(conn, stm);
        }
    }
    
    public static ArrayList<Cliente> findTodosClientes(){
    
        String sql = "SELECT * FROM clientes";
        Connection conn;
        PreparedStatement stm = null;
        ResultSet rs = null;
        conn = ConnectionFactory.getConnection();

        ArrayList<Cliente> clientes = new ArrayList<>();

        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();

                c.setCpf( rs.getString("cpf") );
                c.setNome(rs.getString("nome"));
                c.setSobrenome(rs.getString("sobrenome"));
                c.setEmail(rs.getString("email"));
                c.setTelefone(rs.getString("telefone"));
                c.setQtdeProdutos(rs.getInt("qtdeProdutos"));
                c.setValorGasto(rs.getDouble("valorGasto"));

                clientes.add(c);
            }
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stm, rs);
        }

        return clientes;
    }
    
    public static ArrayList<Cliente> findClienteEspecifico(String filtro){
    
        String sql =    "SELECT * FROM clientes "
                +       "WHERE nome LIKE ? OR sobrenome LIKE ?";
        Connection conn;
        PreparedStatement stm = null;
        ResultSet rs = null;
        conn = ConnectionFactory.getConnection();

        ArrayList<Cliente> clientes = new ArrayList<>();

        try {
            stm = conn.prepareStatement(sql);
            
            stm.setString(1, filtro.trim() + "%" );
            stm.setString(2, filtro.trim() + "%" );
            
            rs = stm.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();

                c.setCpf( rs.getString("cpf") );
                c.setNome(rs.getString("nome"));
                c.setSobrenome(rs.getString("sobrenome"));
                c.setEmail(rs.getString("email"));
                c.setTelefone(rs.getString("telefone"));
                c.setQtdeProdutos(rs.getInt("qtdeProdutos"));
                c.setValorGasto(rs.getDouble("valorGasto"));

                clientes.add(c);
            }
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stm, rs);
        }

        return clientes;
    }

    @Override
    public String toString() {
        return "Cliente{" + "cpf=" + cpf + ", nome=" + nome + ", sobrenome=" + 
                sobrenome + ", telefone=" + telefone + ", email=" + email + 
                ", qtdeProdutos=" + qtdeProdutos + ", valorGasto=" + 
                valorGasto + '}';
    }
    
    
    
    
    
}
