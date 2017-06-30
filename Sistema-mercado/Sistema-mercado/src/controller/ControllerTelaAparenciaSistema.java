package controller;

import java.awt.Color;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JOptionPane;
import view.TelaAparenciaSistema;


public class ControllerTelaAparenciaSistema {
    
    private static TelaAparenciaSistema t;
    
    public static void setRefTelaAparenciaSistema(TelaAparenciaSistema tela){
        t = tela;
       
    }
    
    public static void inicializarTela(){
        t.setLocationRelativeTo(null);
        t.getTitulopanel().setBackground(lerCorConfig());
    }
   
    
    public static void salvar(){
        Path path = Paths.get("config.txt");  
        String nomeSistema  = t.getNomeSistemtxt().getText();
        String corTema      = t.getCorSelecionada();
        
        
        try{
            byte[] texto = (nomeSistema + ";" + corTema).getBytes();
            System.out.println("Gravando : " + texto);
            Files.write(path, texto);
            JOptionPane.showMessageDialog(t, "Reinicie o sistema para concluir as alterações");
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        t.dispose();
    }

    public static void azul() {
        t.setCorSelecionada("54,111,255");
    }

    public static void vermelho() {
        t.setCorSelecionada("201,9,9");
    }

    public static void laranja() {
        t.setCorSelecionada("255,118,0");
    }

    public static void verde() {
        t.setCorSelecionada("9,201,112");
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
    
    
    
    
}
