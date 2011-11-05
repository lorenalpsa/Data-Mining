import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import Controle.ControleIndividuo;
import Controle.ControlePopulacao;
import Controle.Parametros;
import Controle.Roleta;
import Entidades.Individuo;
import Entidades.Populacao;

public class RoletaTest {
	
	@Test
	public void geraRoleta(){
		Populacao populacao = new Populacao(); 
		ControlePopulacao.geraPopulacaoInicial(populacao);
		populacao.getIndividuo(0).setAvaliacao(0.3f);
		populacao.getIndividuo(1).setAvaliacao(0.5f);
		populacao.getIndividuo(2).setAvaliacao(0.2f);
		Roleta roleta = new Roleta(populacao);
		roleta.geraRoleta();		
		assertEquals(new Integer(30), roleta.getIndividuos().get(0));
		assertEquals(new Integer(80), roleta.getIndividuos().get(1));
		assertEquals(new Integer(100), roleta.getIndividuos().get(2));
	}
	
	@Test
	public void achaIndividuo(){
		Populacao populacao = new Populacao();
		populacao.insereIndividuo(ControleIndividuo.criaNovoIndividuo(), 0);
		populacao.insereIndividuo(ControleIndividuo.criaNovoIndividuo(), 1);
		populacao.insereIndividuo(ControleIndividuo.criaNovoIndividuo(), 2);
		populacao.getIndividuo(0).setAvaliacao(0.3f);
		populacao.getIndividuo(1).setAvaliacao(0.5f);
		populacao.getIndividuo(2).setAvaliacao(0.2f);
		Roleta roleta = new Roleta(populacao);
		roleta.geraRoleta();
		Individuo individuo = roleta.achaIndividuoNaRoleta(70);
		assertEquals(0.5f, individuo.getAvaliacao(), 0);
	}
	
	@Test
	public void selecionaPais(){
		Populacao populacao = new Populacao();
		populacao.insereIndividuo(ControleIndividuo.criaNovoIndividuo(), 0);
		populacao.insereIndividuo(ControleIndividuo.criaNovoIndividuo(), 1);
		populacao.insereIndividuo(ControleIndividuo.criaNovoIndividuo(), 2);
		populacao.insereIndividuo(ControleIndividuo.criaNovoIndividuo(), 4);
		populacao.getIndividuo(0).setAvaliacao(0.3f);
		populacao.getIndividuo(1).setAvaliacao(0.4f);
		populacao.getIndividuo(2).setAvaliacao(0.2f);
		populacao.getIndividuo(3).setAvaliacao(0.1f);
		Roleta roleta = new Roleta(populacao);
		roleta.geraRoleta();
		List<Individuo> individuos = roleta.selecionaPais();
		assertEquals(Parametros.TOUR, individuos.size());
	}
}
