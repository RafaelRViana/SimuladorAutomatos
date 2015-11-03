package br.unisc.simuladorautomatos.gui;

import br.unisc.simuladorautomatos.automato.Automato;
import br.unisc.simuladorautomatos.automato.Estado;
import br.unisc.simuladorautomatos.automato.Transicao;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class PanelAutomato extends javax.swing.JPanel {

    private Automato automato = new Automato();
    
    public PanelAutomato() {
        setSize(700, 500);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtNomeAutomato = new javax.swing.JTextArea();

        txtNomeAutomato.setColumns(20);
        txtNomeAutomato.setRows(5);
        jScrollPane1.setViewportView(txtNomeAutomato);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtNomeAutomato;
    // End of variables declaration//GEN-END:variables

    public void setAutomato(Automato automato) {
        this.automato = automato;
        txtNomeAutomato.setText(automato.toString());
    }
    
    /*
    @Override
    protected void paintComponent( Graphics g ) {
        super.paintComponent( g );
        
        Graphics2D g2d = ( Graphics2D ) g;
        g2d.setRenderingHint( RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON );
        
        g2d.setPaint( Color.BLACK );
        FontMetrics fm = g2d.getFontMetrics();
        
        g2d.draw( new Rectangle2D.Double( 0, 0, getWidth() - 1, getHeight() - 1 ) );
        
        g2d.setPaint( Color.BLACK );
        
        for ( Estado e : automato.getEstados() ) {
            for ( Transicao t : e.getTransicoes() ) {
                
                // se estado origem e destino são diferentes, traça a reta
                if ( !t.getDestino().equals( e ) ) {

                    // desenha a linha de ligação
                    g2d.draw( new Line2D.Double(
                            e.getXCentral(), e.getYCentral(), 
                            t.getDestino().getXCentral(), 
                            t.getDestino().getYCentral() ) );

                    // desenha os símbolos da ligação
                    String simbolos = t.getSimbolo();
                    int meiaLargSimbolos = fm.stringWidth( simbolos ) / 2;
                    g2d.drawString( simbolos,
                            e.getXCentral() + ( ( t.getDestino().getXCentral() - e.getXCentral() ) / 2 ) - meiaLargSimbolos,
                            e.getYCentral() + ( ( t.getDestino().getYCentral() - e.getYCentral() ) / 2 ) - 5 );

                    // gera a hipotenusa
                    double h = GUIUtils.calcularHipotenusa(
                            e.getXCentral(), e.getYCentral(),
                            t.getDestino().getXCentral(),
                            t.getDestino().getYCentral() );

                    // gera o grau relativo entre os estados
                    double gr = GUIUtils.calcularGrauRelativo(
                            e.getXCentral(), e.getYCentral(),
                            t.getDestino().getXCentral(),
                            t.getDestino().getYCentral() );

                    // calcula o x e y do início da flecha
                    // sendo que h deve ser dubtraido do raio do estado que no caso
                    // é 25, pois a flecha deve ser desenhada na borda do estado
                    double x = ( h - 25 ) * Math.cos( Math.toRadians( gr ) );
                    double y = ( h - 25 ) * Math.sin( Math.toRadians( gr ) );
                    
                    // desenha a flecha
                    // cria um novo Graphics a partir do original
                    Graphics2D g2df = ( Graphics2D ) g2d.create();

                    // faz a translação para a coordenada que deve ser a origem
                    g2df.translate( x + e.getXCentral(), y + e.getYCentral());

                    // rotaciona
                    g2df.rotate( Math.toRadians( gr ) );

                    // desenha a flecha
                    g2df.draw( new Line2D.Double( 0, 0, -5, -5 ) );
                    g2df.draw( new Line2D.Double( 0, 0, -5, 5 ) );

                    // libera o graphics, não sendo necessário voltar a translação
                    // nem a rotação
                    g2df.dispose();

                } else { // caso contrário, desenha arco
                    
                    g2d.draw( new Ellipse2D.Double(
                            e.getXCentral(), e.getYCentral() - 40, 30, 30 ) );
                    
                    g2d.draw( new Line2D.Double(
                            e.getXCentral() + 21, e.getYCentral() - 11, 
                            e.getXCentral() + 30, e.getYCentral() - 11 ) );
                    
                    g2d.draw( new Line2D.Double(
                            e.getXCentral() + 22, e.getYCentral() - 11, 
                            e.getXCentral() + 21, e.getYCentral() - 20 ) );
                    
                    g2d.drawString( t.getSimbolo(),
                            e.getXCentral() + 15,
                            e.getYCentral() - 45 );
                    
                }
                
            }
            
        }
        
        
    }
    */
}