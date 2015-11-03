package br.unisc.simuladorautomatos.core;

public class AnalisadorDeSentencas {

	public boolean isGramaticaRegular(String expressao) {
		if(expressao == null)
			return false;
		
		return expressao.trim().startsWith("G");
	}
	
}