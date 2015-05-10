package com.trabalho.main;

import java.util.ArrayList;
import java.util.List;

import com.trabalho.model.Cromossomo;

public class Main {

	private static final int TOTAL_INTERACOES = 5;
	
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
			System.out.println("Cromossomo 1\n" + listaCromossomo.get(0).toString() + "\n");
			System.out.println("Cromossomo 2\n" + listaCromossomo.get(1).toString() + "\n");
			System.out.println("Cromossomo 3\n" + listaCromossomo.get(2).toString() + "\n");
			System.out.println("Cromossomo 4\n" + listaCromossomo.get(3).toString() + "\n");
			System.out.println("Cromossomo 5\n" + listaCromossomo.get(4).toString() + "\n");
			System.out.println("------------------------------------------------------");
			
			//Seleciona melhores pais
			Cromossomo pai1 = obtemMelhorCromossomo();
			listaCromossomo.remove(pai1);
			Cromossomo pai2 = obtemMelhorCromossomo();
			listaCromossomo.remove(pai2);
			Cromossomo pai3 = obtemMelhorCromossomo();
			listaCromossomo.remove(pai3);
			Cromossomo pai4 = obtemMelhorCromossomo();
			listaCromossomo.remove(pai4);
			
			
			Cromossomo filho1 = realizaCruzamento(pai1, pai2);
			Cromossomo filho2 = realizaCruzamento(pai3, pai4);
			
			// ADICIONA OS FILHOS
			listaCromossomo.add(filho1);
			listaCromossomo.add(filho2);
			
			// ADICIONA O PAI1 E PAI2 QUE EM TESE SÃO OS MELHORES
			listaCromossomo.add(pai1);
			listaCromossomo.add(pai2);
			
//			//Gera novos filhos c/ mutação
//			Cromossomo filho1 = new Cromossomo(new int[]{pai1.getGene()[0],  pai1.getGene()[1],  pai1.getGene()[2], pai1.getGene()[3], negado(pai1.getGene()[4]),  pai2.getGene()[5], pai2.getGene()[6], pai2.getGene()[7], pai2.getGene()[8] },valorGenes);
//			Cromossomo filho2 = new Cromossomo(new int[]{pai2.getGene()[0],  pai2.getGene()[1],  pai2.getGene()[2], pai2.getGene()[3], negado(pai2.getGene()[4]),  pai1.getGene()[5], pai1.getGene()[6], pai1.getGene()[7], pai1.getGene()[8] },valorGenes);
//			listaCromossomo.add(filho1);
//			listaCromossomo.add(filho2);

		}
		
		System.out.println("Melhor cromossomo em " + qtdIteracoes + " gerações:\n" + obtemMelhorCromossomo());

	}
	
	private Cromossomo realizaMutacao(Cromossomo p1){
	
		String cidade1 = p1.getGene(3);
		String cidade2 = p1.getGene(6);
		
		p1.setGene(6, cidade1);
		p1.setGene(3, cidade2);
		
		return p1;
	}
	
	// DE 2 PAIS RETORNA 2 FILHOS
	private Cromossomo realizaCruzamento(Cromossomo p1, Cromossomo p2){
		
		Cromossomo filho = new Cromossomo(new String[]{p1.getGene(0), p1.getGene(1), p1.getGene(2), p1.getGene(3), p1.getGene(4), p2.getGene(0), p2.getGene(1), p2.getGene(2), p1.getGene(0)});
		
		return realizaMutacao(filho);
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

		// A,B,C,D,E,F,G,H,A
		listaCromossomo.add(new Cromossomo(new String[] {"A","B","C","D","E","F","G","H","A"}));

		// H,G,F,E,D,C,B,A,H
		listaCromossomo.add(new Cromossomo(new String[] {"H","G","F","E","D","C","B","A","H"}));

		// D,H,A,C,B,E,F,G,D
		listaCromossomo.add(new Cromossomo(new String[] {"D","H","A","C","B","E","F","G","D"}));

		// E,A,F,B,C,G,D,H,E
		listaCromossomo.add(new Cromossomo(new String[] {"E","A","F","B","C","G","D","H","E"}));

		// G,A,H,C,E,B,D,F,G
		listaCromossomo.add(new Cromossomo(new String[] {"G","A","H","C","E","B","D","F","G"}));

	}

}
