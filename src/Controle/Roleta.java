package Controle;

import java.util.ArrayList;
import java.util.List;

import Entidades.*;

public class Roleta {
	
	private List<Integer> individuos;
	private Populacao populacao;
	
	public Roleta(Populacao populacao){
		this.populacao = populacao;
		individuos = new ArrayList<Integer>(populacao.tamanhoPopulacao());
		geraRoleta();		
	}
	
	public List<Individuo> selecionaPais(){
		List<Individuo> individuosSelecionados = new ArrayList<Individuo>();
		List<Integer> casas = new ArrayList<Integer>();
		for(int i=0; i < Parametros.TOUR; i++){
			casas.add((int) (Math.random()*100));
		}
		for(int i=0; i< casas.size(); i++){
			individuosSelecionados.add(achaIndividuoNaRoleta(casas.get(i)));
		}
		return individuosSelecionados;
	}		

	public void geraRoleta(){
		Integer valor = (int) (populacao.getIndividuo(0).getAvaliacao()*100);
		individuos.add(valor);
		for(int i=1; i < populacao.tamanhoPopulacao(); i++){
			valor = individuos.get(i-1) + (int)(populacao.getIndividuo(i).getAvaliacao()*100); 
			individuos.add(valor);
		}
	}
	
	public Individuo achaIndividuoNaRoleta(int casa){
		int esq = 0;
		int dir = individuos.size()-1;
		int meio;
		
		while(esq <= dir){
			meio = esq + ((dir-esq)/2);
			if(individuos.get(meio) < casa){
				esq = meio+1;
			}
			else if(individuos.get(meio) >= casa){
				if(casa < individuos.get(meio+1)){
					return populacao.getIndividuo(meio);
				}
				else dir = meio-1;
			}
		}
		return null;
	}

	public List<Integer> getIndividuos() {
		return individuos;
	}

	public void setIndividuos(List<Integer> individuos) {
		this.individuos = individuos;
	}

	public Populacao getPopulacao() {
		return populacao;
	}

	public void setPopulacao(Populacao populacao) {
		this.populacao = populacao;
	}	
}
