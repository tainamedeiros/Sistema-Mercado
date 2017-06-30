package controller;


import java.awt.Color;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JOptionPane;
import model.ConnectionFactory;
import view.TelaAparenciaSistema;
import view.TelaClientes;
import view.TelaMenu;
import view.TelaProdutos;
import view.TelaRealizarPedidos;

public class ControllerTelaMenu {

    private static TelaMenu t;
    
    public static void setRefTelaMenu(TelaMenu tela){
        t = tela;
    }
    public static void inicializarSistema() {
        
        t.setLocationRelativeTo(null);
        configurarTelaIncial();
        t.setVisible(false);
        if (ConnectionFactory.banco.exists()) {
            JOptionPane.showMessageDialog(t,"Bem vindo, banco de dados carregado com sucesso");
            t.setVisible(true);
        } else {
            System.out.println("Entrou aqui");
            if (ConnectionFactory.createDb()) {
                JOptionPane.showMessageDialog(null, "Banco de dados criado com sucesso!");
                t.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao criar banco de dados!");
                System.exit(1);
            }
        }
    }
    
    
    public static void abrirTelaProdutos() {
        new TelaProdutos().setVisible(true);
    }

    public static void abrirTelaClientes() {
        new TelaClientes().setVisible(true);
    }

    public static void abrirTelaRealizarPedido() {
        new TelaRealizarPedidos().setVisible(true);
    }
    public static void sair(){
        if(JOptionPane.showConfirmDialog(t,"Tem certeza que deseja sair do sistema?",
                "Sair do sistema",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
            System.exit(1);
    }
    public static void abrirTelaAparenciaSistema(){
        new TelaAparenciaSistema().setVisible(true);
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
    private static String lerNomeConfig(){
        Path path = Paths.get("config.txt");
        try{
            byte[] texto = Files.readAllBytes(path);
            String leitura = new String(texto);
            String aux[] = leitura.split(";");
            
            return aux[0];
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public static void configurarTelaIncial(){
        Color cor = lerCorConfig();
        String nomeSistema = lerNomeConfig();
        System.out.println(cor);
        System.out.println(nomeSistema);
        t.getClientesbt().setBackground(cor);
        t.getProdutosbt().setBackground(cor);
        t.getPedidobt().setBackground(cor);
        t.getMenupanel().setBackground(cor);
        t.getNomeSistemalb().setText(nomeSistema);
    }
    
    
    

    
    
    
}
