package Controle;

import Entidades.Individuo;
import Entidades.Populacao;

public class Imprime {
	
	public static void imprimeIndividuo(Individuo individuo)
	{
		for(int j = 0; j < Parametros.GENE; j++)
		{
			int operador = individuo.geneIndividuo[j].operador;
			System.out.println("\nIndividuo "+j+" \nOperadores:");
			System.out.println(" >> Operador: "+individuo.geneIndividuo[j].operador);
			System.out.println(" >> Peso: " +individuo.geneIndividuo[j].peso);
			System.out.println(" >> Valor "+individuo.geneIndividuo[j].valor);
		}
		
	}
		
	public static void imprimePopulacao(Populacao populacaoInicial)
		{
			System.out.println("Populacao: ");
			for(int i = 0; i < Parametros.POPULACAO; i++)
				imprimeIndividuo(populacaoInicial.populacao.get(i));
			
		}

}
