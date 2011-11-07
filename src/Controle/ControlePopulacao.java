package Controle;

import java.util.ArrayList;

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
	
	public static void calculaAvaliacaoIndividuo(Dados dados,Individuo individuo, int classe) {
		
		/*
		 * Este array é para ver quais genes podem ser possiveis regras (peso < 0.3)
		 * Coloquei assim para ficar mais facil a visualizacao
		 */
		ArrayList<Integer> genesParaAvaliar = new ArrayList<Integer>();
		for (int i = 0; i < Parametros.GENE; i++) {
			if (individuo.geneIndividuo[i].peso < Parametros.LIMIAR_INDIVIDUO) {
				genesParaAvaliar.add(i);
			}
		}
		
		int verdadeiro_positivo = 0;
		int verdadeiro_negativo = 0;
		int falso_positivo = 0;
		int falso_negativo = 0;
		
		float especificidade;
		float sensitividade;

		int ok = 0;
		
		for (int i = 0; i < Parametros.TREINAMENTO; i++) {
			for (int k = 0; k < genesParaAvaliar.size(); k++) {
				
				int posicao = genesParaAvaliar.get(k);
				int tipo_operador = individuo.geneIndividuo[posicao].operador;

				switch (tipo_operador) {
				case 0:
					if ((individuo.geneIndividuo[posicao].valor == dados.recuperaPosicao(i, k)))
						ok++;

				case 1:
					if ((individuo.geneIndividuo[posicao].valor < dados.recuperaPosicao(i, k)))
						ok++;

				case 2:
					if ((individuo.geneIndividuo[posicao].valor >= dados.recuperaPosicao(i, k)))
						ok++;

				case 3:
					if ((individuo.geneIndividuo[posicao].valor != dados.recuperaPosicao(i, k)))
						ok++;

				}
			}
			/*
			 * se ok == genesParaAvaliar.size todas as regras estavam iguais a base. 
			 * Se a classe for igual, entao é verdadeiro positivo
			 */
			if (ok == genesParaAvaliar.size()) {
				if (dados.recuperaPosicao(i, Parametros.GENE-1) == classe)
					verdadeiro_positivo++;
				else
					verdadeiro_negativo++;
			} else {
				if (dados.recuperaPosicao(i, Parametros.GENE-1) == classe)
					falso_positivo++;
				else
					falso_negativo++;
			}
		}
		
		float dividendo1 = (verdadeiro_positivo + falso_negativo + 1);
		float dividendo2 = (verdadeiro_negativo + falso_positivo + 1);
		
		especificidade = (verdadeiro_positivo + 1)/dividendo1;
		sensitividade = (verdadeiro_negativo + 1)/dividendo2;
		individuo.avaliacao = (especificidade * sensitividade);
	}



	public static void avaliaPopulacao(Populacao populacao, Dados dados,int classe) {
		for (int i = 0; i < populacao.tamanhoPopulacao(); i++) {
			Individuo individuo = populacao.getIndividuo(i);
			calculaAvaliacaoIndividuo(dados, individuo, classe);
		}
	}

}
