package com.trabalho.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import com.trabalho.model.Cromossomo;

public class Main {

	private static final int TOTAL_INTERACOES = 1000;
	
	private List<Cromossomo> listaCromossomo = new ArrayList<Cromossomo>();
	private Integer qtdIteracoes=0;
	
	public static void main(String[] args) {

		Main main = new Main();
		main.execute();

	}

	private void execute() {

		this.iniciaPopulacao();
		
		while(!objetivoAtingido()) {
			
			qtdIteracoes++;
			System.out.println("GERAÇÃO " + qtdIteracoes + "\n");
			this.printCromossomos();
			
			//O melhor permanecerá na lista
			Cromossomo pai1 = obtemMelhorCromossomo();
			listaCromossomo.remove(pai1);
			
			
			Cromossomo pai2 = obtemMelhorCromossomo();
			listaCromossomo.remove(pai2);
			Cromossomo pai3 = obtemMelhorCromossomo();
			listaCromossomo.remove(pai3);
			Cromossomo pai4 = obtemMelhorCromossomo();
			listaCromossomo.remove(pai4);
			Cromossomo pai5 = obtemMelhorCromossomo();
			listaCromossomo.remove(pai5);
			
			
			Cromossomo filho1 = realizaCruzamento(pai1, pai2);
			Cromossomo filho2 = realizaCruzamento(pai2, pai1);
			
			Cromossomo filho3 = realizaCruzamento(pai3, pai4);
			Cromossomo filho4 = realizaCruzamento(pai5, pai4);
			
			// ADICIONA OS FILHOS
			listaCromossomo.add(filho1);
			listaCromossomo.add(filho2);
			listaCromossomo.add(filho3);
			listaCromossomo.add(filho4);
			
			// ADICIONA O MELHOR CROMOSSOMO DESTA GERAÇÃO
			listaCromossomo.add(pai1);

		}
		
		System.out.println("\n\nMelhor cromossomo em " + qtdIteracoes + " gerações:\n" + obtemMelhorCromossomo());
		System.out.println("\nCromossomos Resultantes:");
		this.printCromossomos();

	}

	private void printCromossomos() {
		System.out.println("------------------------------------------------------");
		System.out.println("Cromossomo 1\n" + listaCromossomo.get(0).toString() + "\n");
		System.out.println("Cromossomo 2\n" + listaCromossomo.get(1).toString() + "\n");
		System.out.println("Cromossomo 3\n" + listaCromossomo.get(2).toString() + "\n");
		System.out.println("Cromossomo 4\n" + listaCromossomo.get(3).toString() + "\n");
		System.out.println("Cromossomo 5\n" + listaCromossomo.get(4).toString() + "\n");
		System.out.println("------------------------------------------------------");
	}
	
	private Cromossomo realizaMutacao(Cromossomo p1){
		
		Random random = new Random();
		
		int pos1 = random.nextInt(8);
		int pos2 = random.nextInt(8);
	
		String cidade1 = p1.getGene(pos1);
		String cidade2 = p1.getGene(pos2);
		
		p1.setGene(pos2, cidade1);
		p1.setGene(pos1, cidade2);
		
		return p1;
	}
	
	// DE 2 PAIS RETORNA 1 FILHOS
	private Cromossomo realizaCruzamento(Cromossomo p1, Cromossomo p2){
		
		Cromossomo filho = new Cromossomo(new String[]{p1.getGene(0), p1.getGene(1), p1.getGene(2), p1.getGene(3), p2.getGene(4), p2.getGene(5), p2.getGene(6), p2.getGene(7)});
		
		int i = 0;
		String valores[] = new String[] {"A","B","C","D","E","F","G","H"};
		while(this.verificaDuplicidades(filho.getGene()) != -1){
		
			int posTroca = this.verificaDuplicidades(filho.getGene());
			
			if(i>filho.getGene().length) i=0; 

			filho.setGene(posTroca, valores[i++]);
			
		}
		
		// GARANTE QUE NÃO HOUVE DUPLICIDADE
		filho.setGene(this.removeRepetidos(filho.getGene()));
		
		return realizaMutacao(filho);
	}
	
	private String[] removeRepetidos(String[] gene){        
		return new HashSet<String>(Arrays.asList(gene)).toArray(new String[0]);  
	}
	
	private Integer verificaDuplicidades(String[] gene){
		
		for (int i=0; i < gene.length; i++) {
			int a = Collections.frequency(Arrays.asList(gene), gene[i]);  
			
			if(a > 1) return i;
		}
		
		return -1;
		
	}
	
	private Cromossomo obtemMelhorCromossomo() {
		
		Cromossomo melhorCrom = listaCromossomo.get(0);

		for (Cromossomo crom : listaCromossomo) {
			
			if (crom.getAptidao() < melhorCrom.getAptidao()) {
				melhorCrom = crom;
			}

		}

		return melhorCrom;
	}
	
	private Boolean objetivoAtingido() {

		return qtdIteracoes == TOTAL_INTERACOES;
		
	}

	private void iniciaPopulacao() {
		
		// INICIEI COM OS PIORES CROMOSSOMOS POSSÍVEIS
		
		// APTIDÃO = 1520
		listaCromossomo.add(new Cromossomo(new String[] {"E","A","F","B","C","G","D","H"}));
		
		// APTIDÃO = 1318
		listaCromossomo.add(new Cromossomo(new String[] {"D","F","A","C","B","E","H","G"}));
		
		// APTIDÃO = 1187
		listaCromossomo.add(new Cromossomo(new String[] {"G","D","H","C","E","B","A","F"}));
		
		// APTIDÃO = 1011
		listaCromossomo.add(new Cromossomo(new String[] {"H","A","F","E","D","C","B","G"}));

		// APTIDÃO = 665
		listaCromossomo.add(new Cromossomo(new String[] {"G","A","H","C","E","B","D","F"}));



	}

}
