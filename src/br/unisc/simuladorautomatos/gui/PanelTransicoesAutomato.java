package br.unisc.simuladorautomatos.gui;

import br.unisc.simuladorautomatos.automato.Automato;
import br.unisc.simuladorautomatos.automato.Estado;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rafael
 */
public class PanelTransicoesAutomato extends javax.swing.JPanel {

    public Automato automato;
    private TelaPrincipal janela;

    public PanelTransicoesAutomato(Automato automato, TelaPrincipal janela) {
        initComponents();
        setSize(700, 500);
        
        this.automato =  automato;
        this.janela = janela;
    }
    
    public void createTable(){
        String[] nomesDasColunas = new String[this.automato.getAlfabeto().length+1];
        nomesDasColunas[0] = "";
        for(int x=0; x<this.automato.getAlfabeto().length; x++){
            nomesDasColunas[x+1] = this.automato.getAlfabeto()[x];
        }
        
        DefaultTableModel table = (DefaultTableModel) jTable1.getModel();
        table.setRowCount(this.automato.getEstados().size());
        table.setColumnCount(nomesDasColunas.length);
        table.setColumnIdentifiers(nomesDasColunas);
        
        for(int x=0; x < automato.getEstados().size(); x++){
            Estado estado = automato.getEstados().get(x);
            
            if(estado.isInicio() && estado.isFim()){
                jTable1.setValueAt("-> * "+estado.toString(), x, 0);
            }else if(estado.isInicio()){
                jTable1.setValueAt("->"+estado.toString(), x, 0);
            } else if(estado.isFim()){
                jTable1.setValueAt("*"+estado.toString(), x, 0);
            } else {
                jTable1.setValueAt(estado.toString(), x, 0);
            }
        }
        jTable1.setShowGrid(true);
        jTable1.setModel(table);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btFinalizarCriacaoAutomato = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jLabel1.setText("Transições");

        btFinalizarCriacaoAutomato.setText("Finalizar");
        btFinalizarCriacaoAutomato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFinalizarCriacaoAutomatoActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addContainerGap(371, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGap(20, 20, 20)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btFinalizarCriacaoAutomato)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btFinalizarCriacaoAutomato)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btFinalizarCriacaoAutomatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFinalizarCriacaoAutomatoActionPerformed
        
        for(int x=0; x < automato.getEstados().size();x++) {
            Estado atual = automato.getEstados().get(x);
            
            for (int y=0;y< automato.getAlfabeto().length;y++){
                
                String simbolo = automato.getAlfabeto()[y]; 
                String stringEstadoDestino = (String) jTable1.getValueAt(x, y+1);
                
                if(stringEstadoDestino != null) {
                    
                    //transições não deterministicas q0,q1 (o estado atual reconhece o mesmo simbolo para dois estados destinos)
                    if(stringEstadoDestino.contains(",")) {
                        String[] estados = stringEstadoDestino.split(",");
                        
                        for(String s : estados) {
                            Estado estadoDestino = automato.getEstado(s);
                
                            if(estadoDestino != null) {
                                atual.criarTransicao(simbolo, estadoDestino);
                            }
                        }
                    } else {
                        Estado estadoDestino = automato.getEstado(stringEstadoDestino);
                
                        if(estadoDestino != null) {
                            atual.criarTransicao(simbolo, estadoDestino);
                        }
                    }
                        
                    
                }    
            }
        }
       
       this.setVisible(false);
       janela.exibicaoAutomato.setVisible(true);
       janela.exibicaoAutomato.setAutomato(automato);
    }//GEN-LAST:event_btFinalizarCriacaoAutomatoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btFinalizarCriacaoAutomato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
