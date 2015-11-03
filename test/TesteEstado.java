import static org.junit.Assert.*;

import org.junit.Test;

import br.unisc.simuladorautomatos.automato.Estado;
import br.unisc.simuladorautomatos.automato.TipoEstado;


public class TesteEstado {

	@Test
	public void deveriaReconhecerDoisEstadosComoIguaisQuandoTemOMesmoNome() {
		Estado e1 = new Estado("q0");
		Estado e2 = new Estado("q0");
		
		assertEquals(e1, e2);
	}
	
	@Test
	public void deveriaReconhecerDoisEstadosComoIguaisQuandoTemListaComMesmoEstados() {
		Estado e1 = new Estado("q0", "q1");
		Estado e2 = new Estado("q0", "q1");
		
		assertEquals(e1, e2);
	}
        
        @Test
        public void deveriaAceitarDuasTransicoesParaOMesmoSimbolo() {
            Estado e1 = new Estado("q0");
            Estado e2 = new Estado("q1");
            Estado e3 = new Estado("q2");
            
            e1.criarTransicao("a", e2);
            e1.criarTransicao("a", e3);
            
            assertEquals(2, e1.getTransicoes().size());
            assertFalse(e1.isDeterministico());
        }
        
        @Test
        public void deveriaReconhecerAutomatoDeterministico() {
            Estado e1 = new Estado("q0");
            e1.criarTransicao("a", e1);
            assertTrue(e1.isDeterministico());
            
            Estado e2 = new Estado("q1");
            e1.criarTransicao("a", e2);
            assertFalse(e1.isDeterministico());
        }
        
        @Test
        public void deveriaReconhecerSeAlcancaEstadoFinalOuNao() {
            Estado e1 = new Estado(TipoEstado.INICIO, "q0");
            Estado e2 = new Estado("q1");
            Estado e3 = new Estado("q2");
            Estado e4 = new Estado(TipoEstado.FIM, "q3");
        
            e1.criarTransicao("a", e2);
            e1.criarTransicao("b", e3);
            
            e2.criarTransicao("a", e4);
            e3.criarTransicao("a", e3);
        
            assertTrue(e1.alcancaEstadoFinal());
            assertTrue(e2.alcancaEstadoFinal());
            assertFalse(e3.alcancaEstadoFinal());
            assertTrue(e4.alcancaEstadoFinal());
        }

        @Test
        public void deveriaMostrarNomeDoEstadoCorretamente() {
            Estado e = new Estado("q0");
            assertEquals("q0", e.toString());
            Estado e1 = new Estado("q0", "q1");
            assertEquals("[q0, q1]", e1.toString());
        }
	
}