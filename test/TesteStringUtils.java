import static org.junit.Assert.*;

import org.junit.Test;

import br.unisc.simuladorautomatos.core.StringUtils;


public class TesteStringUtils {

	private StringUtils utils = new StringUtils();
	
	@Test
	public void deveriaRetirarConteudoEntreSimbolos() {
		String expressao = "G={{S,A,B},(a,b),P,S}";
		assertEquals(utils.extrairConteudoEntreSimbolos(expressao, "{", "}"), "{S,A,B},(a,b),P,S");
		assertEquals(utils.extrairConteudoEntreSimbolos("{S,A,B},(a,b),P,S", "{", "}"), "S,A,B");
		assertEquals(utils.extrairConteudoEntreSimbolos("{S,A,B},(a,b),P,S", "(", ")"), "a,b");
	}

	@Test
	public void deveriaRemoverUmTrecho() {
		String parametros = "{S,A,B},(a,b),P,S";
		assertEquals("P,S", utils.removerTrechoDaPalavra(parametros, "{", "),"));
	}
	
}