package view;

import controller.ControllerTelaMenu;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaMenu extends javax.swing.JFrame {

    public TelaMenu() {
        setLookAndFeel();
        initComponents();
        this.setVisible(true);   
        ControllerTelaMenu.setRefTelaMenu(this);
        ControllerTelaMenu.inicializarSistema();
    }


    public JButton getClientesbt() {
        return clientesbt;
    }

    public JPanel getMenupanel() {
        return menupanel;
    }

    public JButton getPedidobt() {
        return pedidobt;
    }

    public JButton getProdutosbt() {
        return produtosbt;
    }

    public JLabel getNomeSistemalb() {
        return nomeSistemalb;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menupanel = new javax.swing.JPanel();
        nomeSistemalb = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pedidobt = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        clientesbt = new javax.swing.JButton();
        produtosbt = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        arquivoMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        editarMenu = new javax.swing.JMenu();
        aparenciaSistemabt = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");

        menupanel.setBackground(new java.awt.Color(54, 111, 255));

        nomeSistemalb.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        nomeSistemalb.setForeground(new java.awt.Color(255, 255, 255));
        nomeSistemalb.setText("[NOME DO SISTEMA]");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        pedidobt.setBackground(new java.awt.Color(54, 111, 255));
        pedidobt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/pedido.png"))); // NOI18N
        pedidobt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidobtActionPerformed(evt);
            }
        });

        jLabel1.setText("<html>Realizar<br>Pedidos</html>");

        jLabel2.setText("Clientes");

        clientesbt.setBackground(new java.awt.Color(54, 111, 255));
        clientesbt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/clientes.png"))); // NOI18N
        clientesbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesbtActionPerformed(evt);
            }
        });

        produtosbt.setBackground(new java.awt.Color(54, 111, 255));
        produtosbt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/produto.png"))); // NOI18N
        produtosbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtosbtActionPerformed(evt);
            }
        });

        jLabel3.setText("Produtos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pedidobt, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clientesbt, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(produtosbt, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3)))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(produtosbt, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(clientesbt, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pedidobt, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout menupanelLayout = new javax.swing.GroupLayout(menupanel);
        menupanel.setLayout(menupanelLayout);
        menupanelLayout.setHorizontalGroup(
            menupanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menupanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menupanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menupanelLayout.createSequentialGroup()
                        .addComponent(nomeSistemalb)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        menupanelLayout.setVerticalGroup(
            menupanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menupanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(nomeSistemalb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        arquivoMenu.setText("Arquivo");

        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        arquivoMenu.add(jMenuItem1);

        jMenuBar1.add(arquivoMenu);

        editarMenu.setText("Editar");

        aparenciaSistemabt.setText("Aparência tela inical");
        aparenciaSistemabt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aparenciaSistemabtActionPerformed(evt);
            }
        });
        editarMenu.add(aparenciaSistemabt);

        jMenuBar1.add(editarMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menupanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menupanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aparenciaSistemabtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aparenciaSistemabtActionPerformed
        ControllerTelaMenu.abrirTelaAparenciaSistema();
    }//GEN-LAST:event_aparenciaSistemabtActionPerformed

    private void produtosbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtosbtActionPerformed
        ControllerTelaMenu.abrirTelaProdutos();
    }//GEN-LAST:event_produtosbtActionPerformed

    private void clientesbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesbtActionPerformed
        ControllerTelaMenu.abrirTelaClientes();
    }//GEN-LAST:event_clientesbtActionPerformed

    private void pedidobtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidobtActionPerformed
        ControllerTelaMenu.abrirTelaRealizarPedido();
    }//GEN-LAST:event_pedidobtActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        ControllerTelaMenu.sair();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    
    

    public static void main(String args[]) {
        new TelaMenu();
    }
    
    private void setLookAndFeel(){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aparenciaSistemabt;
    private javax.swing.JMenu arquivoMenu;
    private javax.swing.JButton clientesbt;
    private javax.swing.JMenu editarMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel menupanel;
    private javax.swing.JLabel nomeSistemalb;
    private javax.swing.JButton pedidobt;
    private javax.swing.JButton produtosbt;
    // End of variables declaration//GEN-END:variables
}
