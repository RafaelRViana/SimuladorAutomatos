package br.unisc.simuladorautomatos.gui;

import br.unisc.simuladorautomatos.automato.*;
import br.unisc.simuladorautomatos.core.GramaticaRegular;
import br.unisc.simuladorautomatos.exceptions.AutomatoException;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TelaPrincipal extends javax.swing.JFrame {

    public PanelSimbolosAutomato simbolos;
    public PanelTransicoesAutomato transicoes;
    public PanelAutomato exibicaoAutomato;
    public Automato automato;
    public PanelGramaticaRegular gramatica;
    public GramaticaRegular gramatica_regular;
    
    public TelaPrincipal() {
        initComponents();
        setSize(800,600);
        setLocation(250, 50);
 
        novaExpressao.setEnabled(false);
        
        exibicaoAutomato = new PanelAutomato();
        exibicaoAutomato.setBounds(0, 0, exibicaoAutomato.getWidth(), exibicaoAutomato.getHeight());
        this.getContentPane().add(exibicaoAutomato);
        exibicaoAutomato.setVisible(true);
        
        //TESTE
        //Estado q0,q1,q2,q3;
        //automato.setAlfabeto("a", "b");
                
        //q0 = new Estado(TipoEstado.INICIO, "q0");
        //q1 = new Estado("q1");
        //q2 = new Estado("q2");
        //q3 = new Estado(TipoEstado.FIM, "q3");
	//automato.setEstados(q0, q1, q2, q3);
		
         //       q0.criarTransicao("a", q0);
         //       q0.criarTransicao("a", q1);
         //       q0.criarTransicao("b", q0);
		
         //       q1.criarTransicao("a", q2);
                
         //       q2.criarTransicao("a", q3);
        //panelAutomato.setAutomato(automato);
        //System.out.println("Graphics 1 => " + getGraphics());
        //System.out.println("Graphics => " + panelAutomato.getGraphics());
        //panelAutomato.paintComponent(panelAutomato.getGraphics());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtConsole = new javax.swing.JTextArea();
        btDeterminizar = new javax.swing.JButton();
        btMinimizar = new javax.swing.JButton();
        tfSentenca = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemNovo = new javax.swing.JMenuItem();
        itemAbrir = new javax.swing.JMenuItem();
        itemEditar = new javax.swing.JMenuItem();
        itemSalvar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        novaExpressao = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        novaGramatica = new javax.swing.JMenuItem();
        editarGramatica = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtConsole.setColumns(20);
        txtConsole.setRows(5);
        jScrollPane1.setViewportView(txtConsole);

        btDeterminizar.setText("Determinizar");
        btDeterminizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeterminizarActionPerformed(evt);
            }
        });

        btMinimizar.setText("Minimizar");
        btMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMinimizarActionPerformed(evt);
            }
        });

        jButton1.setText("Reconhecer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu1.setText("Automato");

        itemNovo.setText("Novo");
        itemNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNovoActionPerformed(evt);
            }
        });
        jMenu1.add(itemNovo);

        itemAbrir.setText("Abrir");
        itemAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAbrirActionPerformed(evt);
            }
        });
        jMenu1.add(itemAbrir);

        itemEditar.setText("Editar Transições");
        itemEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEditarActionPerformed(evt);
            }
        });
        jMenu1.add(itemEditar);

        itemSalvar.setText("Salvar");
        itemSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalvarActionPerformed(evt);
            }
        });
        jMenu1.add(itemSalvar);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Expressão Regular");

        novaExpressao.setText("Novo");
        novaExpressao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novaExpressaoActionPerformed(evt);
            }
        });
        jMenu2.add(novaExpressao);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Gramatica Regular");

        novaGramatica.setText("Novo");
        novaGramatica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novaGramaticaActionPerformed(evt);
            }
        });
        jMenu3.add(novaGramatica);

        editarGramatica.setText("Editar");
        editarGramatica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarGramaticaActionPerformed(evt);
            }
        });
        jMenu3.add(editarGramatica);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btDeterminizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btMinimizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSentenca, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 130, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(260, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDeterminizar)
                    .addComponent(btMinimizar)
                    .addComponent(tfSentenca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-691)/2, (screenSize.height-444)/2, 691, 444);
    }// </editor-fold>//GEN-END:initComponents

    private void itemAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAbrirActionPerformed
      JFileChooser chooser = new JFileChooser();
            
            int opcaoSelecionada = chooser.showSaveDialog(this);
            
            if(opcaoSelecionada == JFileChooser.APPROVE_OPTION) {
                
                FileReader reader = null;
                try {
                    XStream xstream = new XStream(new DomDriver());
                    xstream.processAnnotations(Automato.class);
                    xstream.processAnnotations(Estado.class);
                    xstream.processAnnotations(EstadoInterno.class);
                    xstream.processAnnotations(Transicao.class);
                    reader = new FileReader(chooser.getSelectedFile());
                    automato = (Automato) xstream.fromXML(reader);
                } catch (IOException ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        reader.close();
                    } catch (IOException ex) {
                        Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
        this.exibicaoAutomato.setVisible(true);
        if(simbolos!=null) this.simbolos.setVisible(false);
        if(transicoes!=null) this.transicoes.setVisible(false);
        this.exibicaoAutomato.setAutomato(automato);
    }//GEN-LAST:event_itemAbrirActionPerformed

    private void itemNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNovoActionPerformed
        this.automato = new Automato();
        
        simbolos = new PanelSimbolosAutomato(automato,this);
        simbolos.setBounds(0, 0, simbolos.getWidth(), simbolos.getHeight());
        this.getContentPane().add(simbolos);
        simbolos.setVisible(false);
        
        transicoes = new PanelTransicoesAutomato(automato, this);
        transicoes.setBounds(0, 0, transicoes.getWidth(), transicoes.getHeight());
        this.getContentPane().add(transicoes);
        transicoes.setVisible(false);
        
        this.txtConsole.setText("");
        this.tfSentenca.setText("");
        
        this.simbolos.setVisible(true);
        this.exibicaoAutomato.setVisible(false);
    }//GEN-LAST:event_itemNovoActionPerformed

    private void btDeterminizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeterminizarActionPerformed
        automato = automato.determinizar();
        txtConsole.setText(br.unisc.simuladorautomatos.core.Logger.getLog());
        this.exibicaoAutomato.setVisible(true);
        this.exibicaoAutomato.setAutomato(automato);
    }//GEN-LAST:event_btDeterminizarActionPerformed

    private void btMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMinimizarActionPerformed
        automato = automato.minimizar();
        txtConsole.setText(br.unisc.simuladorautomatos.core.Logger.getLog());
        this.exibicaoAutomato.setVisible(true);
        this.exibicaoAutomato.setAutomato(automato);
    }//GEN-LAST:event_btMinimizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            boolean reconhecerSentenca = automato.reconhecerSentenca(tfSentenca.getText());
            txtConsole.setText(br.unisc.simuladorautomatos.core.Logger.getLog());
        } catch (AutomatoException ex) {
            txtConsole.setText(br.unisc.simuladorautomatos.core.Logger.getLog());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void itemSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalvarActionPerformed
        JFileChooser chooser = new JFileChooser();
            
            int opcaoSelecionada = chooser.showSaveDialog(this);
            
            if(opcaoSelecionada == JFileChooser.APPROVE_OPTION) {
                
                FileWriter writer = null;
                try {
                    XStream xstream = new XStream(new DomDriver());
                    xstream.processAnnotations(Automato.class);
                    xstream.processAnnotations(Estado.class);
                    xstream.processAnnotations(EstadoInterno.class);
                    xstream.processAnnotations(Transicao.class);
                    writer = new FileWriter(chooser.getSelectedFile());
                    xstream.toXML(automato, writer);
                } catch (IOException ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        writer.close();
                    } catch (IOException ex) {
                        Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
    }//GEN-LAST:event_itemSalvarActionPerformed

    private void itemEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEditarActionPerformed
        exibicaoAutomato.setVisible(false);
        transicoes.setVisible(true);
    }//GEN-LAST:event_itemEditarActionPerformed

    private void novaExpressaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novaExpressaoActionPerformed
  
    }//GEN-LAST:event_novaExpressaoActionPerformed

    private void novaGramaticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novaGramaticaActionPerformed
        exibicaoAutomato.setVisible(false);
        
        gramatica = new PanelGramaticaRegular(this.gramatica_regular,this);
        gramatica.setBounds(0, 0, gramatica.getWidth(), gramatica.getHeight());
        this.getContentPane().add(gramatica);
        gramatica.setVisible(true);

    }//GEN-LAST:event_novaGramaticaActionPerformed

    private void editarGramaticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarGramaticaActionPerformed
        exibicaoAutomato.setVisible(false);
        gramatica.setVisible(true);

    }//GEN-LAST:event_editarGramaticaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDeterminizar;
    private javax.swing.JButton btMinimizar;
    private javax.swing.JMenuItem editarGramatica;
    private javax.swing.JMenuItem itemAbrir;
    private javax.swing.JMenuItem itemEditar;
    private javax.swing.JMenuItem itemNovo;
    private javax.swing.JMenuItem itemSalvar;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem novaExpressao;
    private javax.swing.JMenuItem novaGramatica;
    private javax.swing.JTextField tfSentenca;
    private javax.swing.JTextArea txtConsole;
    // End of variables declaration//GEN-END:variables
}