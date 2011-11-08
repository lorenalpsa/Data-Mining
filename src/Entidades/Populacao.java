package Entidades;
import java.util.ArrayList;

import Controle.Parametros;

public class Populacao {
	
	public ArrayList<Individuo> populacao = new ArrayList<Individuo>(Parametros.POPULACAO);
	//public Individuo[] populacao = new Individuo[Parametros.POPULACAO];
	
	
	public void insereIndividuo(Individuo individuo, int indice)
	{
		this.populacao.add(individuo);
	}
	
	public int tamanhoPopulacao()
	{
		return this.populacao.size();
	}

	public Individuo getIndividuo(int indice)
	{
		return this.populacao.get(indice);
	}
	
	
	
	
}
