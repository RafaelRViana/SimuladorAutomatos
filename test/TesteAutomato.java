import br.unisc.simuladorautomatos.automato.*;
import br.unisc.simuladorautomatos.exceptions.AutomatoException;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class TesteAutomato {

	private Automato automato;
        private Estado q0, q1, q2, q3, q4, q5;
       
	@Before
	public void deveriaReconhecerAutomato() {
		automato = new Automato( );
		
		automato.setAlfabeto("a", "b");
                
                q0 = new Estado(TipoEstado.INICIO, "q0");
                q1 = new Estado("q1");
                q2 = new Estado("q2");
                q3 = new Estado(TipoEstado.FIM, "q3");
		automato.setEstados(q0, q1, q2, q3);
		
                q0.criarTransicao("a", q0);
                q0.criarTransicao("a", q1);
                q0.criarTransicao("b", q0);
		
                q1.criarTransicao("a", q2);
                
                q2.criarTransicao("a", q3);
        }
	
        @Test
        public void deveriaExibirToString() {
            System.out.println(automato.toString());
        }
        
        @Test
        public void deveriaVerificarSeAutomatoENaoDeterministico() {
            assertFalse(automato.isDeterministico());
        }
        
        @Test
        public void deveriaReconhecerSentenca() throws AutomatoException {
            automato = new Automato();
            automato.setAlfabeto("a", "b");
            
            q0 = new Estado(TipoEstado.INICIO, "q10");
            q1 = new Estado("q11");
            q2 = new Estado(TipoEstado.FIM, "q12");
            
            q0.criarTransicao("a", q1);
            q1.criarTransicao("b", q2);
            q2.criarTransicao("a", q2);
            
            automato.setEstados(q0,q1,q2);
            
            assertTrue(automato.reconhecerSentenca("aba"));
        }
        
        @Test
        public void deveriaCriarApenasUmEstadoInicialNaDeterminizacao() {
            automato = new Automato( );
		
            automato.setAlfabeto("0", "1");
                
            q0 = new Estado(TipoEstado.INICIO, "q0");
            q1 = new Estado("q1");
            q2 = new Estado("q2");
            q3 = new Estado("q3");
            q4 = new Estado(TipoEstado.FIM, "q4");
            automato.setEstados(q0, q1, q2, q3, q4);
		
            q0.criarTransicao("0", q0);
            q0.criarTransicao("1", q0);
            q0.criarTransicao("1", q1);
		
            q1.criarTransicao("0", q2);
            q1.criarTransicao("1", q2);
                
            q2.criarTransicao("0", q3);
            q2.criarTransicao("1", q3);
            
            q3.criarTransicao("0", q4);
            q3.criarTransicao("1", q4);
            
            Automato automatoGerado = automato.determinizar();
         
            int estadoInicial = 0;
            
            for(Estado e : automatoGerado.getEstados()) {
                if(e.isInicio()) {
                    estadoInicial++;
                }
            }
            
            assertEquals(1, estadoInicial);
        }
        
	//vai para mais de um estado lendo o mesmo simbolo nao-deterministico
	@Test
	public void deveriaVerificarTransicao() {
		Estado estados = automato.verificarTransicao(new Estado("q0"), "a");
		assertTrue(estados.getEstados().contains(new EstadoInterno("q0")));
		assertTrue(estados.getEstados().contains(new EstadoInterno("q1")));
		assertFalse(estados.getEstados().contains(new EstadoInterno("q2")));
		assertFalse(estados.getEstados().contains(new EstadoInterno("q3")));
	}
        
        @Test
        public void deveriaPegarEstadoComMaisDeUmNome() {
            Automato a = new Automato(); 
            a.setEstados(new Estado("q0", "q1"));
            
            assertNotNull(a.getEstado("q0,q1"));
        }
	
	@Test
	public void deveriaDeterminizarAutomato() {
		Automato automatoGerado = automato.determinizar();
                
                Estado q0 = automatoGerado.getEstado("q0");
                Estado q0q1 = automatoGerado.getEstado("q0,q1");
                Estado q0q1q2 = automatoGerado.getEstado("q0,q1,q2");
                Estado q0q1q2q3 = automatoGerado.getEstado("q0,q1,q2,q3");
                
                assertNotNull(q0);
                assertNotNull(q0q1);
                assertNotNull(q0q1q2);
                assertNotNull(q0q1q2q3);
                
                System.out.println("COMEÇAR LEITURA DE SIMBOLOS");
                //FIXME PROBLEMA ESTA CRIANDO UMA TRANSIÇÃO PARA CADA SIMBOLO A
                //NA VERDADE DEVERIA CRIAR UMA TRANSIÇÃO APENAS
                assertEquals(q0q1, q0.lerSimbolo("a").get(0));
                assertEquals(q0, q0.lerSimbolo("b").get(0));
		assertTrue(q0.isInicio());
		assertEquals(2, q0.getTransicoes().size());
	
		assertEquals(q0q1q2, q0q1.lerSimbolo("a").get(0));
		assertEquals(q0, q0q1.lerSimbolo("b").get(0));
		assertEquals(2, q0q1.getTransicoes().size());
		
		assertEquals(q0q1q2q3, q0q1q2.lerSimbolo("a").get(0));
		assertTrue(q0q1q2q3.isFim());
		assertEquals(q0, q0q1q2.lerSimbolo("b").get(0));
		assertEquals(2, q0q1q2.getTransicoes().size());
		
		assertEquals(q0q1q2q3, q0q1q2q3.lerSimbolo("a").get(0));
		assertEquals(q0, q0q1q2q3.lerSimbolo("b").get(0));
		assertEquals(2, q0q1q2q3.getTransicoes().size());
	}
	
	@Test
	public void deveriaDeterminizarAutomato2() {
		Automato a = new Automato();
		a.setAlfabeto("0", "1");
                q0 = new Estado(TipoEstado.INICIO, "q0");
                q1 = new Estado("q1");
                q2 = new Estado("q2");
                q3 = new Estado("q3");
                q4 = new Estado(TipoEstado.FIM, "q4");
		a.setEstados(q0,q1,q2,q3,q4);
		
                q0.criarTransicao("0", q0);
                q0.criarTransicao("1", q0);
                q0.criarTransicao("1", q1);
                
		q1.criarTransicao("0", q2);
                q1.criarTransicao("1", q2);
                
                q2.criarTransicao("0", q3);
                q2.criarTransicao("1", q3);
                
                q3.criarTransicao("0", q4);
                q3.criarTransicao("1", q4);
                
		Automato automatoGerado = a.determinizar();
		
		List<Estado> estadosGerados = automatoGerado.getEstados();
		System.out.println(estadosGerados.size());
		//TODO terminar asser��es
	}
        
        @Test
        public void deveriaEncontrarEstadosMortosOuInacessiveis() {
            Automato a = new Automato();
            
            q0 = new Estado(TipoEstado.INICIO, "q0");
            q1 = new Estado("q1");
            q2 = new Estado(TipoEstado.FIM, "q2");
            q3 = new Estado(TipoEstado.FIM, "q3");
            q4 = new Estado("q4");
            q5 = new Estado("q5");
            
            q0.criarTransicao("a", q1);
            q0.criarTransicao("b", q5);
            
            q1.criarTransicao("b", q2);
            
            q2.criarTransicao("a", q3);
            q2.criarTransicao("b", q2);
            
            q3.criarTransicao("a", q3);
            q3.criarTransicao("b", q3);
            
            q4.criarTransicao("a", q4);
            q4.criarTransicao("b", q1);
            
            q5.criarTransicao("a", q5);
            q5.criarTransicao("b", q5);
            
            a.setEstados(q0, q1, q2, q3, q4, q5);
            a.setAlfabeto("a", "b");
            
            List<Estado> estadosMortos = a.getEstadosMortos();
            assertEquals(1, estadosMortos.size());
            assertEquals(q5, estadosMortos.get(0));
            
            List<Estado> estadosInacessives = a.getEstadosInacessiveis();
            assertEquals(1, estadosInacessives.size());
            assertEquals(q4, estadosInacessives.get(0));
        }
	
}