package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Pedido {
    
    private String id;
    private ArrayList<Produto> itemsPedido;
    private Cliente cliente;
    private Date dataCompra;
    private double total;
    
    public Pedido(){
        itemsPedido = new ArrayList<>();
        dataCompra = new Date();
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Produto> getItemsPedido() {
        return itemsPedido;
    }

    public void setItemsPedido(ArrayList<Produto> itemsPedido) {
        this.itemsPedido = itemsPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public void adicionarProduto(Produto p){
        this.itemsPedido.add(p);
        this.total += p.getQtde() * p.getValor();
    }
    
    public void removerProduto(Produto p){
        this.itemsPedido.remove(p);
        this.total -= p.getQtde() * p.getValor();
    }
    
    public static boolean insert(Pedido pedido){
        String sql = 
                "INSERT INTO pedidos(valoTotal, cpfCliente, data, qtdeProdutos) VALUES (?,?,?,?)";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Connection conn;
        
        conn = ConnectionFactory.getConnection();
        PreparedStatement stm = null;

        try {
            stm = conn.prepareStatement(sql);

            stm.setDouble(1, pedido.getTotal());
            stm.setString(2, pedido.getCliente().getCpf());
            stm.setString(3, format.format(pedido.getDataCompra() ));
            stm.setInt(4, pedido.getItemsPedido().size());
            stm.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        } finally {
            ConnectionFactory.closeConnection(conn, stm);
        }
    }
    
    public static ArrayList<Pedido> find(String filtro) {

        ArrayList<Pedido> pedidos = new ArrayList<>();
        Connection conn;
        String sql
                = "SELECT id, valoTotal, data "
                + "FROM pedidos "
                + "WHERE cpfCliente = ?";

        conn = ConnectionFactory.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            stm = conn.prepareStatement(sql);
            stm.setString(1, filtro);
            rs = stm.executeQuery();
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setId(rs.getString("id"));
                pedido.setTotal(rs.getDouble("valoTotal"));
                pedido.setDataCompra((Date) rs.getDate("data"));
                pedidos.add(pedido);
            }

            return pedidos;
        } catch (SQLException ex) {
            System.out.println("Erro " + ex);
        }

        return pedidos;
    }
    
    
}
