package br.unisc.simuladorautomatos.automato;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Rafael
 */
@XStreamAlias(value="transicao")
public class Transicao {
 
    private Estado origem;
    
    private Estado destino;
    
    private String simbolo;
    
    public Transicao() {} //Exigido pelo XStream
    
    public Transicao(Estado origem, Estado destino, String simbolo) {
        this.origem = origem;
        this.destino = destino;
        this.simbolo = simbolo;
    }

    public Estado getDestino() {
        return destino;
    }

    public Estado getOrigem() {
        return origem;
    }

    public String getSimbolo() {
        return simbolo;
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder(origem.toString());
        s.append(" -> ").append(simbolo).append(" = ").append(destino.toString());
        
        return s.toString();
    }
    
}