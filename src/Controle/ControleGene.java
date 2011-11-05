package Controle;

import Entidades.Gene;

public class ControleGene {
	
	public static Gene criaGeneIndividuo(int indice)
	{
		
		float peso = (float)(Math.random());
		int operador = (int) ((Math.random()*Gene.OPERADORES.length));
		int valor;
		
		if(indice == 10)
		valor = (int) ((Math.random()*Parametros.VALOR_ATRIBUTO11)); 
		
		else
			if(indice == 33)
				valor = (int) ((Math.random()*Parametros.AGE));
			else
				valor = (int) ((Math.random()*Parametros.VALOR));
		
		
		
		return new Gene(peso, operador, valor);
	}

}
