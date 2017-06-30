
package controller;

import java.awt.Color;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Produto;
import view.TelaProdutos;


public class ControllerTelaProdutos {
    
    private static TelaProdutos t;
    
    public static void setRefTelaProdutos(TelaProdutos tela){
        t = tela;
    }
    
    public static void inicializarTela(){
        t.setLocationRelativeTo(null);
        t.getTitulopanel().setBackground(lerCorConfig());
        buscarTodosProdutos();
        preencherTabelaProdutostb();
        
    }
    
    private static void getAllFieldValues(){
        
        Produto p = new Produto();
        
        p.setNome(t.getNometxt().getText());
        p.setDescricao(t.getDescricaotxt().getText());
        p.setValor(Double.parseDouble( t.getValortxt().getText().replace(",", ".") ));
        
        t.setProduto(p);
    }
    
    private static void setAllFieldValuesToUpdate(){
        if(t.getProduto() != null){
            t.getProduto().setNome(t.getNometxt().getText());
            t.getProduto().setDescricao(t.getDescricaotxt().getText());
            t.getProduto().setValor(Double.parseDouble( t.getValortxt().getText().replace(",", ".") ));
        }
    }
    
    private static void buscarTodosProdutos(){
        t.setListaProdutos(Produto.findTodosProdutos());
    }
    
    private static void preencherTabelaProdutostb(){
        DefaultTableModel dft = new DefaultTableModel(null, 
                new String[]{"id", "Nome", "Descr.", "valor", "qtde.vendida"});
        for (Produto p : t.getListaProdutos()) 
            dft.addRow(new String[]{"" + p.getId(), 
                p.getNome(), p.getDescricao(), ""+p.getValor(), ""+p.getQtdeVendida()});
        t.getProdutostb().setModel(dft);
    }
    
    public static void cadastrar(){
        if(verificarValidezCampos()){
            getAllFieldValues();
            if ( Produto.insert(t.getProduto() ) ) {
                JOptionPane.showMessageDialog(t, "Sucesso ao cadastrar produto",
                        "Cadastrar cliente",JOptionPane.PLAIN_MESSAGE);
                preencherCampos(true);
                buscarTodosProdutos();
                preencherTabelaProdutostb();
            } else {
                JOptionPane.showMessageDialog(t, "Falha ao cadastrar produto",
                        "Cadastrar cliente",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private static void preencherCampos(boolean opcao){
        if(opcao){
            t.getDescricaotxt().setText("");
            t.getNometxt().setText("");
            t.getValortxt().setText("");
        }else{
            Produto p = t.getProduto();
            t.getDescricaotxt().setText(p.getDescricao());
            t.getNometxt().setText(p.getNome());
            t.getValortxt().setText(""+p.getValor());
        }
        t.getCadastrarbt().setEnabled(true);
    }
    
    public static void deletar(){
        if ( (t.getProduto()!= null) && JOptionPane.showConfirmDialog(t, 
                "Você quer realmente deletar este produto?","Deletar produto",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            if( Produto.delete(t.getProduto()) ){
                JOptionPane.showMessageDialog(t, "Sucesso ao deletar produto",
                    "Cadastrar produto",JOptionPane.PLAIN_MESSAGE);
                preencherCampos(true);
                buscarTodosProdutos();
                preencherTabelaProdutostb();
            } else {
                JOptionPane.showMessageDialog(t,"Falha ao deletar produto",
                    "Cadastrar produto",JOptionPane.ERROR_MESSAGE);
                preencherCampos(true);
            }
        }
    }
    public static void alterar(){
        setAllFieldValuesToUpdate();
        if ( (t.getProduto()!= null) && JOptionPane.showConfirmDialog(t, 
                "Você quer realmente alterar este produto?","Alterar produto",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            if( Produto.update(t.getProduto()) ){
                JOptionPane.showMessageDialog(t, "Sucesso ao alterar produto",
                    "Alterar produto",JOptionPane.PLAIN_MESSAGE);
                preencherCampos(true);
                buscarTodosProdutos();
                preencherTabelaProdutostb();
            } else {
                JOptionPane.showMessageDialog(t,"Falha ao alterar produto",
                    "Alterar produto",JOptionPane.ERROR_MESSAGE);
                preencherCampos(true);
            }
        }
    }
    
    
    public static void selecionarCliente(){
        setProdutoSelecTabela();
        preencherCampos(false);
        t.getCadastrarbt().setEnabled(false);
    }
    
    private static void setProdutoSelecTabela(){
        t.setProduto(t.getListaProdutos().get(t.getProdutostb().getSelectedRow() ) );
    }
        public static void pesquisarProduto(){
        t.setListaProdutos(Produto.findProdutoEspecifico(t.getPesquisartxt().getText() ));
        preencherTabelaProdutostb();
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

    public static void limparTela() {
        preencherCampos(true);
    }
    
    public static boolean verificarValidezCampos(){
        return !(t.getNometxt().getText().isEmpty() && t.getValortxt().getText().isEmpty());
    }
}
