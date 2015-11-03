package br.unisc.simuladorautomatos.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GramaticaRegular {
	
	private List<String> nodosTerminais;
	
	private List<String> nodosNaoTerminais;
	
	private String formalizacao;
	
	private String simboloInicial;
        
        private String produções;
	
	private Map<String, String> linguagem = new HashMap<String, String>();
	
	public GramaticaRegular(String expressao) {
		StringUtils utils = new StringUtils();
		String parametros = utils.extrairConteudoEntreSimbolos(expressao, "{", "}");
	
		String nodosNaoTerminais[] = utils.extrairConteudoEntreSimbolos(parametros, "{", "}").split(",");
		String nodosTerminais[] = utils.extrairConteudoEntreSimbolos(parametros, "(", ")").split(",");
		
		String subPalavra[] = utils.removerTrechoDaPalavra(parametros, "{", "),").split(",");
		
		this.formalizacao = subPalavra[0];
		this.simboloInicial = subPalavra[1];
	}
	
	public void reconhecerLinguagem(String linguagem) {
		this.linguagem = new HashMap<>();
		
		
	}

        public void setProducoes(String producoes){
                this.produções = producoes;
              
        }
                
	public List<String> getNodosTerminais() {
		return nodosTerminais;
	}

	public List<String> getNodosNaoTerminais() {
		return nodosNaoTerminais;
	}

	public String getFormalizacao() {
		return formalizacao;
	}

	public String getSimboloInicial() {
		return simboloInicial;
	}

	public Map<String, String> getLinguagem() {
		return linguagem;
	}
	
}