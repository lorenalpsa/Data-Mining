package Entidades;

import java.util.ArrayList;

import Controle.Parametros;

public class Individuo {
	
	public Gene[] geneIndividuo = new Gene[Parametros.GENE];
	public float avaliacao;
	
	public Individuo(Gene[] genes_individuo)
	{
		this.geneIndividuo = genes_individuo;
		this.avaliacao = 0;
	}

	public Gene[] getGeneIndividuo() {
		return geneIndividuo;
	}

	public void setGeneIndividuo(Gene[] geneIndividuo) {
		this.geneIndividuo = geneIndividuo;
	}

	public float getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(float avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	


}
