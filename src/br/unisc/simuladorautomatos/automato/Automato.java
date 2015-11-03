package br.unisc.simuladorautomatos.automato;

import br.unisc.simuladorautomatos.core.Logger;
import br.unisc.simuladorautomatos.exceptions.AutomatoException;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.util.ArrayList;
import java.util.List;

@XStreamAlias(value="automato")
public class Automato {

	private String[] alfabeto;
	
	private List<Estado> estados = new ArrayList<>();
	
        @XStreamOmitField
        private List<Estado> estadosComAnalisePendente = new ArrayList<>();

	public void setEstados(Estado... lista) {
            for(Estado e : lista) {
            	estados.add(e);
            }
	}
        
	public List<Estado> getEstados() {
            return estados;
	}
	
	public List<Estado> getEstadosComAnalisePendente() {
            return estadosComAnalisePendente;
	}

        public String[] getAlfabeto(){
            return alfabeto;
        }
                

	/** 
	 * Vai receber um estado de transição, este estado pode ser composto por mais de um estado.
	 * Para cada estado da lista, deve-se buscar qual o valor de transição para o valor
	 * passado como parametro, conforme a tabela de transições original.
	 * 
	 * Caso não tenha uma transição na tabela, deve-se assumir a união de um elemento vazio
	 * ou seja, não será incluido estado na lista.
	 */
	public Estado verificarTransicao(Estado estado, String valor) {
		
		//Irá armazenar todos os estados que foram encontrados nas transições
		Estado estadoGeradoAposTransicao = new Estado();
		
		//Para cada um dos estados interno, devo buscar o estado interno correpondente na lista de 
		//transiçõa
		for(EstadoInterno e : estado.getEstados()) {
		
			Estado estadoEquivalente = getEstado(e.getNome());
                        List<Estado> estadosSeguintesParaValor = estadoEquivalente.lerSimbolo(valor);
                        
                        if(estadosSeguintesParaValor != null) {
                            for(Estado e2 : estadosSeguintesParaValor) {
                                estadoGeradoAposTransicao.addEstado( e2 );
                            }
                        }
		}
	
		return estadoGeradoAposTransicao;
	}

	public Automato determinizar() {
                Logger.clear();
                Logger.log("Iniciando o processo de determinização");
                
                if(isDeterministico()) {
                    Logger.log("Não é possível determinizar um automato determinístico.");
                    Logger.log("Processo de determinização concluido.");
                    return this;
                } else {
                    Automato automatoGerado = new Automato();
                    automatoGerado.setAlfabeto(this.alfabeto);

                    Estado estadoInicial = getEstadoInicialSemTransicoes();

                    if(estadoInicial == null) {
                        Logger.log("ERRO: Não existe estado inicial neste automato.");
                    }

                    automatoGerado.addEstado(estadoInicial);

                    //Vou gerar novas transições até ler todos os estados gerados
                    while(automatoGerado.getEstadosComAnalisePendente().size() > 0 ) {

                            Estado atual = automatoGerado.getEstadosComAnalisePendente().get(0);

                            for(String simbolo : alfabeto) {
                                    Estado estadoGerado = verificarTransicao(atual, simbolo);
                                    atual.criarTransicao(simbolo, estadoGerado);
                                    Logger.log(String.format("([%s], %s) = [%s]\n", atual, simbolo, estadoGerado));

                                    if(!automatoGerado.getEstados().contains(estadoGerado)) {   
                                        automatoGerado.addEstado(estadoGerado);
                                    }
                            }

                            automatoGerado.removeEstadoDaListaDeAnalise(atual);
                    }
                
                    Logger.log("Processo de determinização concluido.");
                    return automatoGerado;
                }
	}
        
        public boolean isDeterministico() {
            //Verificar todas as transições de todos os estados
            //Se um estado tiver duas transições para o mesmo simbolo lido
            //nao e deterministico
            for(Estado e : getEstados()) {
                if(!e.isDeterministico())
                    return false;
            }
            
            return true;
        }

	private void removeEstadoDaListaDeAnalise(Estado atual) {
		estadosComAnalisePendente.remove(atual);
	}

	private void addEstado(Estado estado) {
		estados.add(estado);
		estadosComAnalisePendente.add(estado);
	}

	public void setAlfabeto(String... alfabeto) {
		this.alfabeto = alfabeto;         
	}
        
        public Estado getEstado(String nome) {
            
            Estado pesquisa;
            
            if(nome.contains(",")) {
                String[] nomes = nome.split(",");
                pesquisa = new Estado(nomes);
            } else {
                pesquisa = new Estado(nome);
            }
            
            for(Estado e : estados) {
                if( e.equals(pesquisa) ) {
                    return e;
                }
            }
            
            return null;
        }

    //o reconhecimento de sentença preciso do estado inicial com as transições
    private Estado getEstadoInicial() {
        for(Estado e : getEstados()) {
            if(e.isInicio()) {
                return e;
            }
        }
        
        return null;
    }
        
    //a determinização precisa do estado inicial sem as transições já existentes (precisa do estado limpo)
    private Estado getEstadoInicialSemTransicoes() {
        for(Estado e : getEstados()) {
            if(e.isInicio()) {
                return new Estado(e);
            }
        }
        
        return null;
    }

    //Estado que não seja final, a partir do qual não seja possível alcalçar nenhum estado final
    public List<Estado> getEstadosMortos() {
        List<Estado> estadosMortos = new ArrayList<>();
        
        for(Estado e : getEstados()) {
            if(!e.alcancaEstadoFinal()) {
                estadosMortos.add(e);
            }
        }
        
        return estadosMortos;
    }

    public List<Estado> getEstadosInacessiveis() {
        List<Estado> estadosInacessiveis = new ArrayList<>(estados);
        
        estadosInacessiveis.remove(getEstadoInicial());
        
        for(Estado e : getEstados()) {
            for(Transicao t : e.getTransicoes()) {
                if(!t.getDestino().equals(t.getOrigem())) {
                    estadosInacessiveis.remove(t.getDestino());
                }
            }
        }
        
        return estadosInacessiveis;
    }
    
    public boolean reconhecerSentenca(String sentenca) throws AutomatoException {
        Logger.clear();
        Logger.log("Iniciando o processo de reconhecimento");
        
        if(!isDeterministico()) {
            throw new AutomatoException("Não é possível reconhecer sentença em um automato não deterministico."); //FIXME Nao pode mesmo??
        }
        
        char[] simbolos = sentenca.toCharArray();
        int index = 0;
        
        Estado atual = getEstadoInicial();
        
        while(index < simbolos.length) {
            List<Estado> estadosReconhecidos = atual.lerSimbolo(String.valueOf(simbolos[index]));
            
            if(!estadosReconhecidos.isEmpty()) {
                atual = estadosReconhecidos.get(0);
            } else {
                Logger.log(String.format("A sentenca %s não foi reconhecida.", sentenca));
                Logger.log("Processo de reconhecimento concluido.");
                return false;
            }
            
            index++;
        }
        
        Logger.log(String.format("A sentenca %s foi reconhecida.", sentenca));
        Logger.log("Processo de reconhecimento concluido.");
        return true;
    }
 
    public String toString() {
        StringBuilder nome = new StringBuilder();
        
        nome.append("ALFABETO: ");
        for(int i = 0; i < alfabeto.length; i++) {
            if(i != 0) {
                nome.append(" , ");
            }
            nome.append(alfabeto[i]);
        }
        
        nome.append("\n\n");
        
        nome.append("ESTADOS: ");
        for(Estado e : estados) {
            nome.append("\n");
            nome.append(e.toString());
            if(e.isInicio()) {
                nome.append(" (INICIAL) ");
            }
            if(e.isFim()) {
                nome.append(" (FINAL) ");
            }
            nome.append("\n");
            
            for(Transicao t : e.getTransicoes()) {
                nome.append(t.toString());
                nome.append("\n");
            }
        }
        
        return nome.toString();
    }

    public Automato minimizar() {
        Logger.clear();
        Logger.log("Iniciando o processo de minimização");
                
        if(!isDeterministico()) {
            Logger.log("Não é possível minimizar um automato não determinístico.");
            Logger.log("Processo de minimização concluido.");
            return this;
        } else {
            Automato automatoGerado = new Automato();
            automatoGerado.setAlfabeto(this.alfabeto);
            
            List<Estado> estadosMortos = getEstadosMortos();
            List<Estado> estadosInacessiveis = getEstadosInacessiveis();
        
            Logger.log("Estados inacessiveis: " + estadosInacessiveis.toString());
            Logger.log("Estados mortos: " + estadosMortos.toString());
            Logger.log("Processo de minimização incompleto - falta implementar classes de equivalencia.");
            return this; //FIXME
        }
    }
    
}