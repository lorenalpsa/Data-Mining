import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import Controle.ControleIndividuo;
import Controle.Torneio;
import Entidades.Individuo;


public class TorneioTest {
	
	@Test
	public void executaTorneio(){
		List<Individuo> individuos = criaIndividuos();
		individuos.get(0).setAvaliacao(0.2f);
		individuos.get(1).setAvaliacao(0.3f);
		individuos.get(2).setAvaliacao(0.4f);
		Individuo melhor = Torneio.executaTorneio(individuos);
		assertEquals(0.4f, melhor.getAvaliacao(), 0);
	}
	
	private List<Individuo> criaIndividuos(){
		return Arrays.asList(
				ControleIndividuo.criaNovoIndividuo(),
				ControleIndividuo.criaNovoIndividuo(),
				ControleIndividuo.criaNovoIndividuo()
				);
	}

}
