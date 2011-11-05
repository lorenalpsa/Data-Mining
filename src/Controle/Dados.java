package Controle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;


public class Dados {
	
	//private ArrayList<ArrayList<Integer>> matrizDados = new ArrayList<ArrayList<Integer>>();
	
	private ArrayList<ArrayList<Integer>> matrizDados = new ArrayList<ArrayList<Integer>>();
	
	public Dados()
	{
		ArrayList<Integer> atributos = new ArrayList<Integer>();
		this.matrizDados.add(atributos);
	}
	
	public void inserePosicao(int posicaoX, int posicaoY, int elemento)
	{
		int tamanho = tamanhoArray() - 1; 
		if(posicaoX > tamanho)
		{
			ArrayList<Integer> atributos = new ArrayList<Integer>();
			this.matrizDados.add(posicaoX, atributos);
		}
		this.matrizDados.get(posicaoX).add(posicaoY, elemento);
	}
	
	public int recuperaPosicao(int posicaoX, int posicaoY)
	{
		return this.matrizDados.get(posicaoX).get(posicaoY);
	}
	
	public int tamanhoArray()
	{
		return this.matrizDados.size();
	}
	
	public void leArquivo() 
	{
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(Parametros.CAMINHO_ARQUIVO));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.print("Erro ao buscar arquivo!" + e);
		}
	
		int i = 0;
		try {
			while(in.ready())
			{
				
				String stringLinha = in.readLine().toString();
				String atributos[] = stringLinha.split(",");
				
				if(!(atributos[33].toString().contains("?")))
				{
					
					for(int j = 0; j < 34; j++)
					{
						int atributo = Integer.parseInt(atributos[j]);
						this.inserePosicao(i,j,atributo);
					}
					i++;
				}
				//i++;
			}
		} catch (NumberFormatException e) {
			System.out.print("Erro ao converter numero!" + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.print("Erro ao ler arquivo!" + e);
			e.printStackTrace();
		}
		System.out.println(i);
	}
	
	public void imprimeDados()
	{
		for(int i = 0; i < this.tamanhoArray(); i++)
		{
			System.out.println("");
			for(int j = 0; j < 34; j++)
				System.out.println("["+i+","+j+"] "+this.recuperaPosicao(i, j));
		}
	}

}
