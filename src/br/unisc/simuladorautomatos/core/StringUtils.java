package br.unisc.simuladorautomatos.core;

public class StringUtils {

	public String extrairConteudoEntreSimbolos(String palavra, String simboloAbertura, String simboloFechamento) {
		return palavra.substring(palavra.indexOf(simboloAbertura) + 1, palavra.lastIndexOf(simboloFechamento));
	}

	public String removerTrechoDaPalavra(String palavra, String simboloAbertura, String simboloFechamento) {
		String trechoInicial = palavra.substring(0, palavra.indexOf(simboloAbertura));
		
		//Se simbolo fechamento � ) preciso somar 1 no valor do lastIndexOf
		//Se simbolo fechamento � ), preciso somar 2 no valor do lastIndexOf
		//Por isso, o valor da soma � igual ao n�mero de caracteres da String
		String trechoFinal = palavra.substring(palavra.lastIndexOf(simboloFechamento) + simboloFechamento.length());
		
		return trechoInicial.concat(trechoFinal);
	}
	
}