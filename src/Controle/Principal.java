package Controle;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;

import Entidades.Gene;
import Entidades.Individuo;
import Entidades.Populacao;

public class Principal {
	
	public static void main(String[] args) throws IOException 
	{
		
		Populacao populacaoInicial = new Populacao();
		
		ControlePopulacao.geraPopulacaoInicial(populacaoInicial);
		Imprime.imprimePopulacao(populacaoInicial);
		
		Dados dados = new Dados();
		dados.leArquivo();
		dados.imprimeDados();
		
	
	}

}
