package br.unisc.simuladorautomatos.automato;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@XStreamAlias(value="estado")
public class Estado {
	
        private int XCentral = 0;
        private int YCentral = 0;
    
	//TODO disparar exception quando houver dois estados de inicio
	private Set<EstadoInterno> estados = new HashSet<>();
        
        private List<Transicao> transicoes = new ArrayList<>();
        
        //Exigido pelo XStream
        public Estado() {
            
        }
        
        public Estado(Estado estado) {
            this.estados = estado.getEstados();
        }
        
	public Estado(TipoEstado tipoEstado, String... nomes) {
		for(String nome : nomes) {
			estados.add(new EstadoInterno(nome, tipoEstado));
		}
	}
	
        public Estado(TipoEstado tipoEstadoI, TipoEstado tipoEstadoF, String... nomes) {
		for(String nome : nomes) {
			estados.add(new EstadoInterno(nome, tipoEstadoI, tipoEstadoF));
		}
	}
        
	public Estado(String... nomes) {
		for(String nome : nomes) {
			estados.add(new EstadoInterno(nome));
		}
	}
	
	public boolean isInicio() {
		for(EstadoInterno e : estados) {
			if(e.isInicio())
				return true;
		}
		
		return false;
	}
        
	public boolean isFim() {
		for(EstadoInterno e : estados) {
			if(e.isFim())
				return true;
		}
		
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estados == null) ? 0 : estados.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estado other = (Estado) obj;
		if (estados == null) {
			if (other.estados != null)
				return false;
		} else if (!estados.equals(other.estados))
			return false;
		return true;
	}

	@Override
	public String toString() {
            if(estados.size() == 1) {
                return estados.toArray()[0].toString();
            }
		return estados.toString();
	}

	public Set<EstadoInterno> getEstados() {
		return estados;
	}

	public void addEstado(Estado estado) {
		for(EstadoInterno e : estado.getEstados()) {
			estados.add(e);
		}
	}

        public void criarTransicao(String simbolo, Estado estadoDestino) {
            transicoes.add(new Transicao(this, estadoDestino, simbolo));
            System.out.println("transicaoxx => " + simbolo + " estado destino => " + estadoDestino + " estado origem => " + this );
        }
        
        public List<Estado> lerSimbolo(String simbolo) {
            List<Estado> estadosReconhecidos = new ArrayList<>();
            System.out.println("Transicoesxx => " + transicoes.size());
            for(Transicao t : transicoes) {
                System.out.println("transicaomm => " + t.getSimbolo() + " estado destino => " + t.getDestino() );
                if(t.getSimbolo().equals(simbolo)) {
                    estadosReconhecidos.add(t.getDestino());
                }
            }
            
            return estadosReconhecidos;
        }
        
        public boolean isDeterministico() {
            List<String> simbolosLidos = new ArrayList<>();
            for(Transicao t : transicoes) {
                if(simbolosLidos.contains(t.getSimbolo())) {
                    return false;
                }
                
                simbolosLidos.add(t.getSimbolo());
            }
            
            return true;
        }
        
        public boolean alcancaEstadoFinal() {
            
            if(isFim()) 
                return true;
            
            //se não é final preciso tentar alcançar o estado final a partir dele
            for(Transicao t : transicoes) {
                if( !t.getDestino().equals(this) )
                    if( t.getDestino().alcancaEstadoFinal() )
                    return true;
            }
            
            return false;
        }
        
        public List<Transicao> getTransicoes() {
            return transicoes;
        }

    public int getXCentral() {
        return XCentral;
    }

    public void setXCentral(int XCentral) {
        this.XCentral = XCentral;
    }

    public int getYCentral() {
        return YCentral;
    }

    public void setYCentral(int YCentral) {
        this.YCentral = YCentral;
    }

    
	
        
}