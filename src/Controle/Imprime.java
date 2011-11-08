package Controle;

import Entidades.Individuo;
import Entidades.Populacao;

public class Imprime {
	
	public static void imprimeIndividuo(Individuo individuo)
	{
		for(int j = 0; j < Parametros.GENE; j++)
		{
			int operador = individuo.geneIndividuo[j].operador;
			System.out.println("\nGene "+j+" \nOperadores:");
			System.out.println(" >> Operador: "+individuo.geneIndividuo[j].operador);
			System.out.println(" >> Peso: " +individuo.geneIndividuo[j].peso);
			System.out.println(" >> Valor "+individuo.geneIndividuo[j].valor);
			System.out.println(" >> Avaliacao: "+individuo.avaliacao);
		}
		
	}
		
	public static void imprimePopulacao(Populacao populacaoInicial)
		{
			System.out.println("Populacao: ");
			for(int i = 0; i < 1; i++)
			{
				System.out.println("Individuo "+i);
				imprimeIndividuo(populacaoInicial.populacao.get(i));
			}
				
			
		}

}
