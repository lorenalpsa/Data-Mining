package Controle;

import java.util.List;

import Entidades.Individuo;

public class Torneio {
	
	public static Individuo executaTorneio(List<Individuo> individuos){
		Individuo melhor = individuos.get(0);
		Individuo individuo;
		for(int i=1; i < individuos.size(); i++){
			individuo = individuos.get(i);
			if(individuo.getAvaliacao() > melhor.getAvaliacao()){
				melhor = individuo;
			}
		}		
		return melhor;
	}
	
}
