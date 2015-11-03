package br.unisc.simuladorautomatos.gui;

import br.unisc.simuladorautomatos.automato.Automato;
import br.unisc.simuladorautomatos.automato.Estado;
import br.unisc.simuladorautomatos.automato.TipoEstado;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

public class PanelSimbolosAutomato extends javax.swing.JPanel {

    private DefaultListModel lista = new DefaultListModel();  
    String[] alfabeto;
    private Automato automato;
    private TelaPrincipal janela;
    private DefaultTableModel table = new DefaultTableModel();
    private Estado[] estados;
    private String estado_inicial="";
    
    public PanelSimbolosAutomato(Automato automato, TelaPrincipal janela) {
        initComponents();
        setSize(800,600);
        
        this.automato = automato;
        this.janela =  janela;
        
        if (lista.getSize() == 0){
            btRemoveSimbolo.setEnabled(false);
        } else {
            btRemoveSimbolo.setEnabled(true);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        btProximaTela = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfNomeSimbolo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaDeSimbolos = new javax.swing.JList();
        btAdicionaSimbolo = new javax.swing.JButton();
        btRemoveSimbolo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfNomeEstado = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        btAdicionaEstado = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaDeEstados = new javax.swing.JTable();
        btRemoveEstado = new javax.swing.JButton();

        jButton5.setText("Remover Estado");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btProximaTela.setText("Próximo >>");
        btProximaTela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProximaTelaActionPerformed(evt);
            }
        });

        jLabel1.setText("Alfabeto");

        jScrollPane1.setViewportView(listaDeSimbolos);

        btAdicionaSimbolo.setText("Adicionar Símbolo");
        btAdicionaSimbolo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionaSimboloActionPerformed(evt);
            }
        });

        btRemoveSimbolo.setText("Remover Símbolo");
        btRemoveSimbolo.setToolTipText("Para remover, selecione o símbolo na lista e clique em Remover Símbolo");
        btRemoveSimbolo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoveSimboloActionPerformed(evt);
            }
        });

        jLabel2.setText("Estados");

        tfNomeEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomeEstadoActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Inicial");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("Final");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        btAdicionaEstado.setText("Adicionar estado");
        btAdicionaEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionaEstadoActionPerformed(evt);
            }
        });

        tabelaDeEstados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Inicio", "Fim"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabelaDeEstados);

        btRemoveEstado.setText("Remover Estado");
        btRemoveEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoveEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 346, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfNomeEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btAdicionaEstado)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btRemoveEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btProximaTela))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(tfNomeSimbolo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(6, 6, 6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btRemoveSimbolo)
                                .addComponent(btAdicionaSimbolo)))
                        .addComponent(jLabel1)))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(tfNomeSimbolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btAdicionaSimbolo))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btRemoveSimbolo)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btProximaTela)
                            .addComponent(btRemoveEstado)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(3, 3, 3)
                                .addComponent(tfNomeEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCheckBox1)
                                    .addComponent(jCheckBox2)
                                    .addComponent(btAdicionaEstado))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btProximaTelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProximaTelaActionPerformed
        alfabeto = new String[lista.getSize()];  
        for(int x=0;x<lista.getSize();x++){
            alfabeto[x] = lista.get(x).toString(); 
        }
        
        this.automato.setAlfabeto(alfabeto);
        
        estados = new Estado[tabelaDeEstados.getRowCount()];

        for (int linha = 0; linha < tabelaDeEstados.getRowCount(); linha++) {
            String nome = (String) tabelaDeEstados.getValueAt(linha, 0);
            if (tabelaDeEstados.getValueAt(linha, 1) == true) {
                estados[linha] = new Estado(TipoEstado.INICIO, nome);
            } else if (tabelaDeEstados.getValueAt(linha, 2) == true) {
                estados[linha] = new Estado(TipoEstado.FIM, nome);
            } else if (tabelaDeEstados.getValueAt(linha, 1) == true && tabelaDeEstados.getValueAt(linha, 2) == true) {
                estados[linha] = new Estado(TipoEstado.INICIO, TipoEstado.FIM, nome);
            } else {
                estados[linha] = new Estado(nome);
            }
        }
        automato.setEstados(estados);
        
        this.setVisible(false);
        this.janela.transicoes.setVisible(true);
        this.janela.transicoes.createTable(); 
    }//GEN-LAST:event_btProximaTelaActionPerformed

    private void btAdicionaSimboloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionaSimboloActionPerformed
        lista.addElement(tfNomeSimbolo.getText());
        listaDeSimbolos.setModel(lista);
        btRemoveSimbolo.setEnabled(true);
        tfNomeSimbolo.setText("");
    }//GEN-LAST:event_btAdicionaSimboloActionPerformed

    private void btRemoveSimboloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoveSimboloActionPerformed
        if(lista.getSize() > 0 && (!listaDeSimbolos.isSelectionEmpty())){
            int index = listaDeSimbolos.getSelectedIndex();
            lista.remove(index);
            listaDeSimbolos.setModel(lista);
            if (lista.getSize() == 0){
            btRemoveSimbolo.setEnabled(false);
            }
        }
    }//GEN-LAST:event_btRemoveSimboloActionPerformed

    private void tfNomeEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomeEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomeEstadoActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed

   }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed

   }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void btAdicionaEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionaEstadoActionPerformed
        table = (DefaultTableModel) tabelaDeEstados.getModel();

        if (jCheckBox1.isSelected() && jCheckBox2.isSelected()) {
            table.addRow(new Object[]{tfNomeEstado.getText(), true, true});
            jCheckBox1.doClick();
            jCheckBox1.setEnabled(false);
            jCheckBox2.doClick();
        } else if (jCheckBox1.isSelected()) {
            table.addRow(new Object[]{tfNomeEstado.getText(), true, null});
            jCheckBox1.doClick();
            jCheckBox1.setEnabled(false);
            jCheckBox2.setEnabled(true);
            estado_inicial = tfNomeEstado.getText();
        } else if (jCheckBox2.isSelected()) {
            table.addRow(new Object[]{tfNomeEstado.getText(), null, true});
            jCheckBox2.doClick();
        } else {
            table.addRow(new Object[]{tfNomeEstado.getText(), null, null});
        }

        tabelaDeEstados.setModel(table);
        tfNomeEstado.setText("");
    }//GEN-LAST:event_btAdicionaEstadoActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        table = (DefaultTableModel) tabelaDeEstados.getModel();
        int index = tabelaDeEstados.getSelectedRow();
        table.removeRow(index);
        jCheckBox1.setEnabled(true);
        tabelaDeEstados.setModel(table);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btRemoveEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoveEstadoActionPerformed
        table = (DefaultTableModel) tabelaDeEstados.getModel();
        int index = tabelaDeEstados.getSelectedRow();
        table.removeRow(index);
        jCheckBox1.setEnabled(true);
        tabelaDeEstados.setModel(table);
    }//GEN-LAST:event_btRemoveEstadoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionaEstado;
    private javax.swing.JButton btAdicionaSimbolo;
    private javax.swing.JButton btProximaTela;
    private javax.swing.JButton btRemoveEstado;
    private javax.swing.JButton btRemoveSimbolo;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listaDeSimbolos;
    private javax.swing.JTable tabelaDeEstados;
    private javax.swing.JTextField tfNomeEstado;
    private javax.swing.JTextField tfNomeSimbolo;
    // End of variables declaration//GEN-END:variables
}
