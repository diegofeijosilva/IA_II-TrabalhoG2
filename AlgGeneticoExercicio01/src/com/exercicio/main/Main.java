package com.exercicio.main;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static int[] valorGenes = new int[] { 10, 20, 1, 2, 10, 5, 5, 3, 10 };

	public static int qtdIteracoes;

	public static List<Cromossomo> listaCrom = new ArrayList<Cromossomo>();

	public static void main(String[] args) {	

		listaCrom.add(new Cromossomo(new int[]{1,  0,  1, 0, 0,  1, 0, 1, 1 }, valorGenes));
		listaCrom.add(new Cromossomo(new int[]{0,  0,  1, 1, 0,  1, 0, 0, 1 }, valorGenes));
		listaCrom.add(new Cromossomo(new int[]{0,  0,  0, 1, 0,  0, 1, 1, 0 }, valorGenes));
		listaCrom.add(new Cromossomo(new int[]{1,  1,  0, 0, 0,  0, 1, 0, 1 }, valorGenes));

		while(!objetivoAtingido()) {
			qtdIteracoes++;
			System.out.println("GERAÇÃO " + qtdIteracoes + "\n");
			System.out.println("Cromossoma 1\n" + listaCrom.get(0).toString() + "\n");
			System.out.println("Cromossoma 2\n" + listaCrom.get(1).toString() + "\n");
			System.out.println("Cromossoma 3\n" + listaCrom.get(2).toString() + "\n");
			System.out.println("Cromossoma 4\n" + listaCrom.get(3).toString() + "\n");
			System.out.println("------------------------------------------------------");
			
			
			//Seleciona melhores pais
			Cromossomo pai1 = obtemMelhorCrom();
			listaCrom.remove(pai1);
			Cromossomo pai2 = obtemMelhorCrom();
			listaCrom = new ArrayList<Cromossomo>();
			listaCrom.add(pai1);
			listaCrom.add(pai2);
			
			//Gera novos filhos c/ mutação
			Cromossomo filho1 = new Cromossomo(new int[]{pai1.getGene()[0],  pai1.getGene()[1],  pai1.getGene()[2], pai1.getGene()[3], negado(pai1.getGene()[4]),  pai2.getGene()[5], pai2.getGene()[6], pai2.getGene()[7], pai2.getGene()[8] },valorGenes);
			Cromossomo filho2 = new Cromossomo(new int[]{pai2.getGene()[0],  pai2.getGene()[1],  pai2.getGene()[2], pai2.getGene()[3], negado(pai2.getGene()[4]),  pai1.getGene()[5], pai1.getGene()[6], pai1.getGene()[7], pai1.getGene()[8] },valorGenes);
			listaCrom.add(filho1);
			listaCrom.add(filho2);
		}

		
		System.out.println("Melhor cromossoma em " + qtdIteracoes + " gerações:\n" + obtemMelhorCrom());

	}

	public static boolean objetivoAtingido() {
		boolean cond1 = listaCrom.get(0).getAptidao() == 0;
		boolean cond2 = listaCrom.get(1).getAptidao() == 0;
		boolean cond3 = listaCrom.get(2).getAptidao() == 0;
		boolean cond4 = listaCrom.get(3).getAptidao() == 0;
		boolean cond5 = qtdIteracoes == 25000;

		return cond1 || cond2 || cond3 || cond4 || cond5;

	}

	public static Cromossomo obtemMelhorCrom() {
		Cromossomo melhorCrom = listaCrom.get(0);

		for (Cromossomo crom : listaCrom) {
			if (crom.getAptidao() == 0) {
				return crom;
			}

			if (crom.getAptidao() < melhorCrom.getAptidao()) {
				melhorCrom = crom;
			}
		}

		return melhorCrom;
	}
	
	public static int negado(int bit) {
		if(bit == 1) {
			return 0;
		} else {
			return 1;
		}
	}

}
