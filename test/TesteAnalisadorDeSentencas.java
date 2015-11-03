import static org.junit.Assert.*;

import org.junit.Test;

import br.unisc.simuladorautomatos.core.AnalisadorDeSentencas;


public class TesteAnalisadorDeSentencas {

	private AnalisadorDeSentencas analisador = new AnalisadorDeSentencas();
	
	@Test
	public void deveriaReconhecerUmaGramaticaRegular() {
		assertTrue(analisador.isGramaticaRegular("G={{S,A,B},(a,b),P,S}"));
		assertTrue(analisador.isGramaticaRegular(" G={{S,A,B},(a,b),P,S}"));
		assertFalse(analisador.isGramaticaRegular(null));
	}
	
}