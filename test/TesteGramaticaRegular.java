
import static org.junit.Assert.*;

import org.junit.Test;

import br.unisc.simuladorautomatos.core.GramaticaRegular;
import br.unisc.simuladorautomatos.exceptions.SimboloFormalizadorNaoReconhecido;


public class TesteGramaticaRegular {

	@Test
	public void deveriaCriarGramaticaRegular() {
		GramaticaRegular gramatica = new GramaticaRegular("G={{S,A,B},(a,b),P,S}");
		assertEquals(gramatica.getNodosNaoTerminais().size(), 3);
		assertEquals(gramatica.getNodosTerminais().size(), 2);
		assertEquals(gramatica.getFormalizacao(), "P");
		assertEquals(gramatica.getSimboloInicial(), "S");
	}
	
	@Test(expected=SimboloFormalizadorNaoReconhecido.class)
	public void deveriaDispararExcecaoAoNaoReconhecerSimboloFormalizador() {
		GramaticaRegular gramatica = new GramaticaRegular("G={{S,A,B},(a,b),P,S}");
		gramatica.reconhecerLinguagem("Z:{(S;A)(S;aB)(aA;AbS)(aA;a)(B;b)(B;)}");
	}
	
	@Test
	public void deveriaReconhecerLinguagemDaGramaticaRegular() {
		GramaticaRegular gramatica = new GramaticaRegular("G={{S,A,B},(a,b),P,S}");
		gramatica.reconhecerLinguagem("P:{(S;A)(S;aB)(aA;AbS)(aA;a)(B;b)(B;)}");
	
		assertEquals(gramatica.getLinguagem().size(), 6);
	}
	
}