package Entidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import Controle.Parametros;


public class Dados {
	
	private int[][]  matrizDados = new int[358][Parametros.GENE];
	
	public Dados()
	{
		
	}
	
	public void inserePosicao(int posicaoX, int posicaoY, int elemento)
	{
		this.matrizDados[posicaoX][posicaoY] = elemento;
		
	}
	
	public int recuperaPosicao(int posicaoX, int posicaoY)
	{
		return this.matrizDados[posicaoX][posicaoY];
	}
	
	public int tamanhoArray()
	{
		return this.matrizDados.length;
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
					
					for(int j = 0; j < 35; j++)
					{
						int atributo = Integer.parseInt(atributos[j]);
						this.inserePosicao(i,j,atributo);
					}
					i++;
				}
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
