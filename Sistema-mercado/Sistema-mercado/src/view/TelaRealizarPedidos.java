package view;

import controller.ControllerTelaRealizarPedidos;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.Cliente;
import model.Pedido;
import model.Produto;

public class TelaRealizarPedidos extends javax.swing.JFrame {

  
    private ArrayList<Produto> produtos;
    private ArrayList<Cliente> clientes;
    private Produto produto;
    private Pedido pedido;
    private boolean finalizar = false;
    
    public TelaRealizarPedidos() {
        initComponents();
        ControllerTelaRealizarPedidos.setRefTelaRealizarPedidos(this);
        ControllerTelaRealizarPedidos.inicializarTela();
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    public JPanel getTitulopanel() {
        return titulopanel;
    }

    public JButton getCancelarbt() {
        return cancelarbt;
    }

    public JPanel getClientespanel() {
        return clientespanel;
    }

    public JTable getClientestb() {
        return clientestb;
    }

    public JButton getFinalizarbt() {
        return finalizarbt;
    }

    public JTable getItemstb() {
        return itemstb;
    }

    public JTextField getPesquisarClientetxt() {
        return pesquisarClientetxt;
    }

    public JTextField getPesquisartxt() {
        return pesquisartxt;
    }

    public JTable getProdutostb() {
        return produtostb;
    }

    public JTextField getQtdetxt() {
        return qtdetxt;
    }

    public JLabel getSubtotallbl() {
        return subtotallbl;
    }

    public JLabel getTotallbl() {
        return totallbl;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public boolean isFinalizar() {
        return finalizar;
    }

    public void setFinalizar(boolean finalizar) {
        this.finalizar = finalizar;
    }
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        titulopanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pesquisartxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        pesquisarbt = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        produtostb = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        subtotallbl = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        inserirbt = new javax.swing.JButton();
        qtdetxt = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        itemstb = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        totallbl = new javax.swing.JLabel();
        removerbt = new javax.swing.JButton();
        clientespanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        clientestb = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        pesquisarClientetxt = new javax.swing.JTextField();
        pesquisarClientebt = new javax.swing.JButton();
        cancelarbt = new javax.swing.JButton();
        finalizarbt = new javax.swing.JButton();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        titulopanel.setBackground(new java.awt.Color(54, 111, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Realizar Pedido");

        javax.swing.GroupLayout titulopanelLayout = new javax.swing.GroupLayout(titulopanel);
        titulopanel.setLayout(titulopanelLayout);
        titulopanelLayout.setHorizontalGroup(
            titulopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titulopanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        titulopanelLayout.setVerticalGroup(
            titulopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titulopanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setText("Pesquisar");

        pesquisarbt.setBackground(new java.awt.Color(54, 111, 255));
        pesquisarbt.setForeground(new java.awt.Color(255, 255, 255));
        pesquisarbt.setText("Pesquisar");
        pesquisarbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarbtActionPerformed(evt);
            }
        });

        produtostb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        produtostb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                produtostbMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(produtostb);

        jLabel7.setText("Produtos");

        jLabel2.setText("Qtde");

        jLabel3.setText("Subtotal");

        subtotallbl.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        subtotallbl.setText("00.00");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("R$:");

        inserirbt.setBackground(new java.awt.Color(16, 183, 52));
        inserirbt.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        inserirbt.setForeground(new java.awt.Color(255, 255, 255));
        inserirbt.setText("+");
        inserirbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirbtActionPerformed(evt);
            }
        });

        qtdetxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        qtdetxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                qtdetxtFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pesquisartxt, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(qtdetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(subtotallbl)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pesquisarbt)
                    .addComponent(inserirbt))
                .addGap(74, 74, 74))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisartxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesquisarbt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qtdetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(subtotallbl)
                            .addComponent(jLabel5)
                            .addComponent(inserirbt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        itemstb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        itemstb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemstbMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(itemstb);

        jLabel6.setText("Items");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setText("Total");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setText("R$:");

        totallbl.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        totallbl.setText("00.00");

        removerbt.setBackground(new java.awt.Color(233, 70, 70));
        removerbt.setForeground(new java.awt.Color(255, 255, 255));
        removerbt.setText("--");
        removerbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerbtActionPerformed(evt);
            }
        });

        clientespanel.setBackground(new java.awt.Color(255, 255, 255));
        clientespanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 204, 255), null, null));

        clientestb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        clientestb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clientestbMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(clientestb);

        jLabel12.setText("Cliente");

        pesquisarClientebt.setBackground(new java.awt.Color(54, 111, 255));
        pesquisarClientebt.setForeground(new java.awt.Color(255, 255, 255));
        pesquisarClientebt.setText("Pesquisar");
        pesquisarClientebt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarClientebtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout clientespanelLayout = new javax.swing.GroupLayout(clientespanel);
        clientespanel.setLayout(clientespanelLayout);
        clientespanelLayout.setHorizontalGroup(
            clientespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientespanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clientespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                    .addGroup(clientespanelLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(clientespanelLayout.createSequentialGroup()
                        .addComponent(pesquisarClientetxt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pesquisarClientebt)))
                .addContainerGap())
        );
        clientespanelLayout.setVerticalGroup(
            clientespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clientespanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(clientespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisarClientetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesquisarClientebt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );

        cancelarbt.setBackground(new java.awt.Color(233, 70, 70));
        cancelarbt.setForeground(new java.awt.Color(255, 255, 255));
        cancelarbt.setText("<html>Cancelar<br>\nPedido</html>");
        cancelarbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarbtActionPerformed(evt);
            }
        });

        finalizarbt.setBackground(new java.awt.Color(16, 183, 52));
        finalizarbt.setForeground(new java.awt.Color(255, 255, 255));
        finalizarbt.setText("<html>Finalizar\n<br>\nPedido</html>");
        finalizarbt.setActionCommand("<html>Finalizar<br>\nPedido</html>");
        finalizarbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarbtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totallbl)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelarbt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(finalizarbt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removerbt))
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clientespanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(10, 10, 10)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(removerbt)
                                        .addGap(0, 139, Short.MAX_VALUE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                            .addComponent(clientespanel, javax.swing.GroupLayout.PREFERRED_SIZE, 189, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(totallbl)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelarbt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(finalizarbt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titulopanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titulopanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pesquisarbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarbtActionPerformed
        ControllerTelaRealizarPedidos.pesquisarProduto();
    }//GEN-LAST:event_pesquisarbtActionPerformed

    private void produtostbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_produtostbMouseClicked
        ControllerTelaRealizarPedidos.selectionarProduto();
    }//GEN-LAST:event_produtostbMouseClicked

    private void qtdetxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_qtdetxtFocusLost
        ControllerTelaRealizarPedidos.atualizarSubtotal();
    }//GEN-LAST:event_qtdetxtFocusLost

    private void inserirbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirbtActionPerformed
        ControllerTelaRealizarPedidos.inserirProdutoNoPredido();
    }//GEN-LAST:event_inserirbtActionPerformed

    private void removerbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerbtActionPerformed
        ControllerTelaRealizarPedidos.removerProdutoDoPedido();
    }//GEN-LAST:event_removerbtActionPerformed

    private void itemstbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemstbMouseClicked
        ControllerTelaRealizarPedidos.selecionarItem();
    }//GEN-LAST:event_itemstbMouseClicked

    private void cancelarbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarbtActionPerformed
        ControllerTelaRealizarPedidos.inicializarTela();
    }//GEN-LAST:event_cancelarbtActionPerformed

    private void finalizarbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarbtActionPerformed
        ControllerTelaRealizarPedidos.finalizarPedido();
    }//GEN-LAST:event_finalizarbtActionPerformed

    private void pesquisarClientebtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarClientebtActionPerformed
        ControllerTelaRealizarPedidos.pesquisarCliente();
    }//GEN-LAST:event_pesquisarClientebtActionPerformed

    private void clientestbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientestbMouseClicked
        ControllerTelaRealizarPedidos.selecionarCliente();
    }//GEN-LAST:event_clientestbMouseClicked

   
    private void setLookAndFeel() {
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
    private javax.swing.JButton cancelarbt;
    private javax.swing.JPanel clientespanel;
    private javax.swing.JTable clientestb;
    private javax.swing.JButton finalizarbt;
    private javax.swing.JButton inserirbt;
    private javax.swing.JTable itemstb;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton pesquisarClientebt;
    private javax.swing.JTextField pesquisarClientetxt;
    private javax.swing.JButton pesquisarbt;
    private javax.swing.JTextField pesquisartxt;
    private javax.swing.JTable produtostb;
    private javax.swing.JFormattedTextField qtdetxt;
    private javax.swing.JButton removerbt;
    private javax.swing.JLabel subtotallbl;
    private javax.swing.JPanel titulopanel;
    private javax.swing.JLabel totallbl;
    // End of variables declaration//GEN-END:variables
}
