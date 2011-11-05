package Controle;

import Entidades.Gene;
import Entidades.Individuo;
import Entidades.Populacao;

public class ControlePopulacao {
	
	
	public static void geraPopulacaoInicial(Populacao populacaoInicial)
	{	
		Individuo  individuo;
		for(int i = 0; i < Parametros.POPULACAO; i++)
		{
			individuo = ControleIndividuo.criaNovoIndividuo();
			populacaoInicial.insereIndividuo(individuo,i);
		}
	}
	

	
}
