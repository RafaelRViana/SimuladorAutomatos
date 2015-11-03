package br.unisc.simuladorautomatos.gui;

import br.unisc.simuladorautomatos.automato.Estado;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JPanel;

public class PanelEstado extends JPanel {
 
    private final int LARGURA_FLECHA = 20;
    private Estado estado;
    
    public PanelEstado(Estado estado) {
        this.estado = estado;
        
        setSize( new Dimension( 50 + LARGURA_FLECHA, 50 ) );
        setBackground( new Color( 0, 0, 0, 0 ) );
    }
    
    @Override
    protected void paintComponent( Graphics g ) {
        super.paintComponent( g );
        
        Graphics2D g2d = ( Graphics2D ) g;
        g2d.setRenderingHint( RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON );
        
        //Desenhar estado
        g2d.setPaint( Color.WHITE );
        g2d.fill( new Ellipse2D.Double(
                LARGURA_FLECHA, 0, 
                this.getWidth() - LARGURA_FLECHA, getHeight() ) );
        
        g2d.setPaint( Color.BLACK );
        g2d.draw( new Ellipse2D.Double( 
                LARGURA_FLECHA, 0, 
                this.getWidth() - ( LARGURA_FLECHA + 1 ), getHeight() - 1  ) );
        
        //Desenhar flecha, se estado inicial
        if ( estado.isFim() ) {
            g2d.draw( new Line2D.Double( 
                    0, getHeight() / 2, 
                    LARGURA_FLECHA, getHeight() / 2  ) );
            g2d.draw( new Line2D.Double( 
                    LARGURA_FLECHA - 5, ( getHeight() / 2 ) - 5, 
                    LARGURA_FLECHA, getHeight() / 2  ) );
            g2d.draw( new Line2D.Double( 
                    LARGURA_FLECHA - 5, ( getHeight() / 2 ) + 5, 
                    LARGURA_FLECHA, getHeight() / 2  ) );
        }
        
        //Desenhar circulo ao redor, se estado final
        if ( estado.isFim() ) {
            g2d.draw( new Ellipse2D.Double( 
                    LARGURA_FLECHA + 5, 5, 
                    this.getWidth() - ( LARGURA_FLECHA + 11 ), getHeight() - 11 ) );
        }
        
        FontMetrics fm = g2d.getFontMetrics();
        g2d.drawString( estado.toString(), 
                LARGURA_FLECHA + ( 50 / 2 ) - ( fm.stringWidth( estado.toString() ) / 2 ), 
                ( getHeight() / 2 ) + ( fm.getHeight() / 3 ) );
        
    }
    
}