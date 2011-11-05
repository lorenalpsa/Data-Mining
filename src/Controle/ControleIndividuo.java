package Controle;
import Entidades.Gene;
import Entidades.Individuo;

public class ControleIndividuo {
	
	public static Individuo criaNovoIndividuo()
	{	
		Gene[] gene_individuo = new Gene[Parametros.GENE];
		
		for(int i = 0; i < Parametros.GENE; i++)
		{
			Gene gene = ControleGene.criaGeneIndividuo(i);
			gene_individuo[i] = gene;

		}
		
		return new Individuo(gene_individuo);
	}

}
