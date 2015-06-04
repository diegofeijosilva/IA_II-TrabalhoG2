package com.trabalho.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.trabalho.model.Cromossomo;

public class Main {

	private static final int TOTAL_INTERACOES = 10000;
	
	private List<Cromossomo> listaCromossomo = new ArrayList<Cromossomo>();
	private Integer qtdIteracoes=0;
	
	private Integer numeroMagico;
	private Integer tamanhoMatriz;
	
	public static void main(String[] args) {

		Main main = new Main();
		main.execute();

	}

	private void execute() {

		this.getEntradaDados();

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
			
			Cromossomo filho1 = realizaCruzamento(pai1, pai2);
			
			// ADICIONA OS FILHOS
			listaCromossomo.add(filho1);
			
			// MANTÉM O MELHOR CROMOSSOMO DESTA GERAÇÃO
			listaCromossomo.add(pai1);

		}
		
		//System.out.println("\n\nMelhor cromossomo em " + qtdIteracoes + " gerações:\n" + obtemMelhorCromossomo());
		System.out.println("\nCromossomos Resultantes:");
		this.printCromossomos();

	}



	private void printCromossomos() {

		System.out.println("------------------------------------------------------");
		System.out.println("Cromossomo 1\n" + listaCromossomo.get(0).toString() + "\n");
		System.out.println("Cromossomo 2\n" + listaCromossomo.get(1).toString() + "\n");
		System.out.println("Cromossomo 3\n" + listaCromossomo.get(2).toString() + "\n");
		System.out.println("Cromossomo 4\n" + listaCromossomo.get(3).toString() + "\n");
		System.out.println("------------------------------------------------------");
	}
	
	private Cromossomo realizaMutacao(Cromossomo p1){
		
//		Random random = new Random();
//		
//		int pos1 = random.nextInt(8);
//		int pos2 = random.nextInt(8);
//	
//		String cidade1 = p1.getGene(pos1);
//		String cidade2 = p1.getGene(pos2);
//		
//		p1.setGene(pos2, cidade1);
//		p1.setGene(pos1, cidade2);
//		
//		return p1;
		
		return null;
	}
	
	// DE 2 PAIS RETORNA 1 FILHOS
	private Cromossomo realizaCruzamento(Cromossomo p1, Cromossomo p2){
		
		List<Integer> genesFilho1 = new ArrayList<Integer>(Arrays.asList(p2.getGene(0), p2.getGene(1), p1.getGene(2), p1.getGene(3)));
		
		Cromossomo filho = new Cromossomo(genesFilho1);
		
//		Cromossomo filho = new Cromossomo(new String[]{p1.getGene(0), p1.getGene(1), p1.getGene(2), p1.getGene(3), p2.getGene(4), p2.getGene(5), p2.getGene(6), p2.getGene(7)});
//		
//		int i = 0;
//		String valores[] = new String[] {"A","B","C","D","E","F","G","H"};
//		while(this.verificaDuplicidades(filho.getGene()) != -1){
//		
//			int posTroca = this.verificaDuplicidades(filho.getGene());
//			
//			if(i>filho.getGene().length) i=0; 
//
//			filho.setGene(posTroca, valores[i++]);
//			
//		}
//		
//		// GARANTE QUE NÃO HOUVE DUPLICIDADE
//		filho.setGene(this.removeRepetidos(filho.getGene()));
//		
//		return realizaMutacao(filho);
		
		return filho;
	}
	
	private Cromossomo obtemMelhorCromossomo() {
		
		Cromossomo melhorCrom = listaCromossomo.get(0);

		for (Cromossomo crom : listaCromossomo) {
			
			if (crom.getAptidao() == numeroMagico) {
				melhorCrom = crom;
			}

		}

		return melhorCrom;
	}
	
	private Boolean objetivoAtingido() {

		return qtdIteracoes == TOTAL_INTERACOES;
		
	}

	private void iniciaPopulacao() {
		
		Random random = new Random();
		for(int i=0; i < tamanhoMatriz; i++){
			
			// MONTA OS GENES
			List<Integer> genes = new ArrayList<Integer>();
			for (int j = 0; j < tamanhoMatriz; j++) {
				genes.add(random.nextInt(numeroMagico/tamanhoMatriz));
			}
			
			// ADICIONA O CROMOSSOMO COM OS GENES
			listaCromossomo.add(new Cromossomo(genes));
			
		}

	}
	
	private void getEntradaDados() {
		Scanner dados = new Scanner(System.in);

		System.out.print("\nINFORME O NÚMERO MÁGICO: ");
		numeroMagico = Integer.parseInt(dados.next());
		
		System.out.print("\nINFORME O TAMANHO DO QUADRADO MÁGICO: ");
		tamanhoMatriz = Integer.parseInt(dados.next());
	}

}
