package Controle;



import java.util.ArrayList;

import Entidades.Individuo;
import Entidades.Populacao;

public class ControleCrossover {
	
	ArrayList<Individuo> invididuosCrossover = new ArrayList<Individuo>();
	
	public static void crossoverIndividuos(Individuo pai1,Individuo pai2)
	{
		int ponto1;
		int ponto2;
		
		Individuo filho1 = null;
		Individuo filho2 = null;
		
		do{
			ponto1 = (int) (Math.random()*33);
			ponto2 = (int) (Math.random()*33);
		}while((ponto1 == 0 || ponto1 == 33) && (ponto2 == 0 || ponto2 == 33));
		
		if(ponto2 > ponto1)
		{
			for(int i = 0; i < Parametros.GENE; i++)
			{
				if(i < ponto1)
				{
					filho1.geneIndividuo[i] = pai1.geneIndividuo[i];
					filho2.geneIndividuo[i] = pai2.geneIndividuo[i];
				}
				
			
			}
		}
		
		
	}
	
	public static void crossoverPopulacao(Populacao populacao)
	{

		for(int i = 0; i < populacao.tamanhoPopulacao(); i++)
		{
			
			Individuo individuo1 = populacao.getIndividuo(0);
			Individuo individuo2 = populacao.getIndividuo(1);
			
			crossoverIndividuos(individuo1,individuo2);
		}
	}
	
	
	
}
