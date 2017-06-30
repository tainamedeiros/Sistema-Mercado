
package controller;

import java.awt.Color;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Pedido;
import model.Produto;
import view.TelaRealizarPedidos;

public class ControllerTelaRealizarPedidos {
    
    private static TelaRealizarPedidos t;
    
    public static void setRefTelaRealizarPedidos(TelaRealizarPedidos tela){
        t = tela;
    }
    
    public static void inicializarTela(){
        t.setLocationRelativeTo(null);
        t.getTitulopanel().setBackground(lerCorConfig());
        t.getClientespanel().setVisible(false);
        t.setPedido(new Pedido());
        preencherTabelaItemstb();
        if(t.getProdutos()!=null) preencherTabelaProdutostb();
        t.setFinalizar(false);
        limparTela();
    }
    
    public static void pesquisarProduto(){
        t.setProdutos(Produto.findProdutoEspecifico(t.getPesquisartxt().getText()));
        preencherTabelaProdutostb();
        
    }
    
    public static void pesquisarCliente(){
        t.setClientes(Cliente.findClienteEspecifico(t.getPesquisarClientetxt().getText()));
        preencherTabelaClientestb();
    }
    
    public static void selectionarProduto(){
        if(t.getProdutostb().getRowCount() > 0){
            t.setProduto(t.getProdutos().get(t.getProdutostb().getSelectedRow() ));
            t.getQtdetxt().setText("1");
            t.getProduto().setQtde(1);
            atualizarSubtotal();
        }
    }
    
    public static void inserirProdutoNoPredido(){
        t.getPedido().adicionarProduto(t.getProduto());
        preencherTabelaItemstb();
        atualizarTotal();
        limparTela();
    }
    
    public static void atualizarSubtotal(){
        if(t.getProduto()!=null && !( t.getQtdetxt().getText().isEmpty() ) ){
            t.getProduto().setQtde(Integer.parseInt(t.getQtdetxt().getText()));
            t.getSubtotallbl().setText(""+t.getProduto().getValor() * t.getProduto().getQtde());
        }
    }
    
    
    
    
    
    private static void preencherTabelaProdutostb(){
        DefaultTableModel dft = new DefaultTableModel(null, 
                new String[]{"id", "Nome", "Descr.", "valor"});
        if(t.getProdutos()!=null){
            for (Produto p : t.getProdutos()) 
                dft.addRow(new String[]{"" + p.getId(), 
                    p.getNome(), p.getDescricao(), ""+p.getValor()});
        }
        t.getProdutostb().setModel(dft);
    }
    
    private static void preencherTabelaItemstb() {
        DefaultTableModel dft = new DefaultTableModel(null,
                new String[]{"cod", "Nome", "valor", "Subtotal"});
        int i = 1;
        for (Produto p : t.getPedido().getItemsPedido()) {
            dft.addRow(new String[]{"" + i, p.getNome(), "" + p.getValor(),
                (p.getValor() * p.getQtde()) + ""});
            i++;
        }
        t.getItemstb().setModel(dft);
    }
    private static void preencherTabelaClientestb(){
        DefaultTableModel dft = new DefaultTableModel(null,
                new String[]{"Nome", "Sobrenome","cpf" });
        int i = 1;
        for (Cliente c : t.getClientes()) {
            dft.addRow(new String[]{c.getNome(),c.getSobrenome(),c.getCpf()});
            i++;
        }
        t.getClientestb().setModel(dft);
    }
    
    private static void atualizarTotal(){
        t.getTotallbl().setText( "" + t.getPedido().getTotal());
    }
    
    
    
    
    
    private static Color lerCorConfig(){
        Path path = Paths.get("config.txt");
        try{
            byte[] texto = Files.readAllBytes(path);
            String leitura = new String(texto);
            String aux[] = leitura.split(";");
            String[] configs = aux[1].split(",");
            Color cor = new Color(Integer.parseInt(configs[0]),Integer.parseInt(configs[1]),
                    Integer.parseInt(configs[2]));
            
            return cor;
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public static void removerProdutoDoPedido() {
        t.getPedido().removerProduto( t.getProduto() );
        preencherTabelaItemstb();
        atualizarTotal();
        limparTela();
    }

    public static void selecionarItem() {
        if(t.getItemstb().getRowCount()>0){
            t.setProduto(t.getPedido().getItemsPedido().get( t.getItemstb().getSelectedRow() ));
        }
    }
    
    public static void abrirPanelClientes(){
        t.getClientespanel().setVisible(true);
    }
    public static void fecharPanelClientes(){
        t.getClientespanel().setVisible(false);
    }
    

    private static void limparTela(){
        t.getPesquisartxt().setText("");
        t.setProdutos(new ArrayList<>());
        t.setProduto(new Produto());
        preencherTabelaProdutostb();
        atualizarTotal();
        t.getQtdetxt().setText("");
        t.getSubtotallbl().setText("00.00");
        if(t.getItemstb().getRowCount()>0) abrirPanelClientes();
        else fecharPanelClientes();
    }

    public static void finalizarPedido() {
        if(t.isFinalizar()){
            if(JOptionPane.showConfirmDialog(t, "Finalizar pedido?","Finalizar pedido",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION ){
                if(Pedido.insert(t.getPedido())){
                    atualizarProdutosDoPedido();
                    atualizarClienteDoPedido();

                    JOptionPane.showMessageDialog(t,"Pedido realizado com sucesso!","Sucesso",JOptionPane.PLAIN_MESSAGE);
                    inicializarTela();
                }else{
                    JOptionPane.showMessageDialog(t,"Falha ao realizar pedido!","Falha",JOptionPane.ERROR_MESSAGE);
                    inicializarTela();
                }            
            }
        }else{
            JOptionPane.showMessageDialog(t, "Complete o seu pedido antes de finalizar!");
        }
    }

    public static void selecionarCliente() {
        if(t.getClientestb().getRowCount()>0){
            t.getPedido().setCliente( t.getClientes().get( t.getClientestb().getSelectedRow() ));
            System.out.println(t.getPedido().getCliente());
            t.setFinalizar(true);
        }
    }
    
    private static void atualizarProdutosDoPedido() {
        for (Produto p : t.getPedido().getItemsPedido()) {
            p.setQtdeVendida(p.getQtdeVendida() + p.getQtde());
            Produto.update(p);
        }
    }

    private static void atualizarClienteDoPedido() {
        
        Cliente c = t.getPedido().getCliente();
        c.setValorGasto( c.getValorGasto() + t.getPedido().getTotal() );
        for(Produto p:t.getPedido().getItemsPedido()){
            c.setQtdeProdutos( c.getQtdeProdutos() + p.getQtde());
        }
        Cliente.update(c);
    }
    
}
