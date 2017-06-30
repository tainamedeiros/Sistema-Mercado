
package controller;

import java.awt.Color;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Pedido;
import view.TelaClientes;

public class ControllerTelaClientes {
    
    private static TelaClientes t;
    
    public static void setRefTelaClientes(TelaClientes tela){
        t = tela;
    }
    
    public static void inicializarTela(){
        t.setLocationRelativeTo(null);
        t.getTitulopanel().setBackground(lerCorConfig());
        buscarTodosClientes();
        preencherTabelaClientestb();
    }
    
    public static void getAllFieldValues(){
        
        Cliente c = new Cliente();
        
        c.setNome(t.getNometxt().getText());
        c.setSobrenome(t.getSobrenometxt().getText());
        c.setCpf(t.getCpftxt().getText());
        c.setEmail(t.getEmailtxt().getText());
        c.setTelefone(t.getTelefonetxt().getText());
        
        t.setCliente(c);        
    }
    private static void setAllFieldValuesToUpdate() {
        if(t.getCliente()!=null){
            t.getCliente().setNome(t.getNometxt().getText());
            t.getCliente().setSobrenome(t.getSobrenometxt().getText());
            t.getCliente().setCpf(t.getCpftxt().getText());
            t.getCliente().setEmail(t.getEmailtxt().getText());
            t.getCliente().setTelefone(t.getTelefonetxt().getText());
        }
    }
        
    public static void cadastrar(){
        if(verificaValidezCampos()){
            getAllFieldValues();
            if(Cliente.insert(t.getCliente())){
                JOptionPane.showMessageDialog(t, "Sucesso ao cadastrar cliente",
                        "Cadastrar cliente",JOptionPane.PLAIN_MESSAGE);
                preencherCampos(true);
                buscarTodosClientes();
                preencherTabelaClientestb();
            }else{
                JOptionPane.showMessageDialog(t,"Falha ao cadastrar cliente",
                        "Cadastrar cliente",JOptionPane.ERROR_MESSAGE);
                preencherCampos(true);
            }
        }
    }
    public static void deletar(){
        if((t.getCliente()!= null) && JOptionPane.showConfirmDialog(t, 
                "Você quer realmente deletar este cliente?","Deletar cliente",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            if( Cliente.delete(t.getCliente()) ){
                JOptionPane.showMessageDialog(t, "Sucesso ao deletar cliente",
                    "Cadastrar cliente",JOptionPane.PLAIN_MESSAGE);
                preencherCampos(true);
                buscarTodosClientes();
                preencherTabelaClientestb();
            } else {
                JOptionPane.showMessageDialog(t,"Falha ao deletar cliente",
                    "Cadastrar cliente",JOptionPane.ERROR_MESSAGE);
                preencherCampos(true);
            }
        }
    }
    public static void alterar() {
        setAllFieldValuesToUpdate();
        if((t.getCliente()!= null) && JOptionPane.showConfirmDialog(t, 
                "Você quer realmente alterar este cliente?","Alterar cliente",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            if( Cliente.update(t.getCliente()) ){
                JOptionPane.showMessageDialog(t, "Sucesso ao alterar cliente",
                    "Cadastrar cliente",JOptionPane.PLAIN_MESSAGE);
                preencherCampos(true);
                buscarTodosClientes();
                preencherTabelaClientestb();
            } else {
                JOptionPane.showMessageDialog(t,"Falha ao alterar cliente",
                    "Cadastrar cliente",JOptionPane.ERROR_MESSAGE);
                preencherCampos(true);
            }
        }
    }
    public static void pesquisarCliente(){
        t.setListaClientes( Cliente.findClienteEspecifico(t.getPesquisartxt().getText() ));
        preencherTabelaClientestb();
    }
    
    
    public static void selecionarCliente(){
        setClienteSelecTabela();
        preencherCampos(false);
    }
    
    private static void buscarTodosClientes(){
        t.setListaClientes(Cliente.findTodosClientes());
    }
    
    
    private static void preencherTabelaClientestb(){
        DefaultTableModel dft = new DefaultTableModel(null, 
                new String[]{"cpf", "Nome", "Sobrenome", "email", "telefone","valorGasto","qtde.Prods"});
        for (Cliente c : t.getListaClientes()) 
            dft.addRow(new String[]{"" + c.getCpf(), 
                c.getNome(), c.getSobrenome(), c.getEmail(), c.getTelefone(),""+c.getValorGasto(),""+c.getQtdeProdutos()});
        t.getClientestb().setModel(dft);
    }
    private static void preencherTabelaPedidostb(){
        DefaultTableModel dft = new DefaultTableModel(null, 
                new String[]{"id", "Data", "Valor total"});
        for (Pedido p : t.getPedidos()) 
            dft.addRow(new String[]{ p.getId(), p.getDataCompra().toString() , p.getTotal()+"" });
        t.getPedidostb().setModel(dft);
    }
    
    
    /*
        true - limpar
        false - dados cliente
    */
    private static void preencherCampos(boolean opcao){
        if(opcao){
            t.getCpftxt().setText("");
            t.getNometxt().setText("");
            t.getSobrenometxt().setText("");
            t.getEmailtxt().setText("");
            t.getTelefonetxt().setText("");
        }else{
            Cliente c = t.getCliente();
            t.getCpftxt().setText(c.getCpf());
            t.getNometxt().setText(c.getNome());
            t.getSobrenometxt().setText(c.getSobrenome());
            t.getEmailtxt().setText(c.getEmail());
            t.getTelefonetxt().setText(c.getTelefone());
        }
    }
    
    private static void setClienteSelecTabela(){
        t.setCliente( t.getListaClientes().get(t.getClientestb().getSelectedRow() ) );
        System.out.println(t.getCliente());
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

    public static void pesquisarPedidos() {
        t.setPedidos(Pedido.find(t.getCliente().getCpf()));
        preencherTabelaPedidostb();
    }

    public static void limparTela() {
        preencherCampos(true);
    }

    public static boolean verificaValidezCampos(){
        return !(t.getNometxt().getText().isEmpty() && t.getSobrenometxt().getText().isEmpty());
    }
    
    
}
