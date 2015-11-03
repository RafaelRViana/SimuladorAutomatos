
import br.unisc.simuladorautomatos.automato.Estado;
import br.unisc.simuladorautomatos.automato.Transicao;
import org.junit.Test;
import static org.junit.Assert.*;

public class TesteTransicao {
 
    @Test
    public void deveriaExibirToStringTransicao() {
        Estado e1 = new Estado("q0");
        Estado e2 = new Estado("q1");
        Transicao t = new Transicao(e1, e2, "a");
        
        assertEquals("q0 -> a = q1", t.toString());
    }
    
}