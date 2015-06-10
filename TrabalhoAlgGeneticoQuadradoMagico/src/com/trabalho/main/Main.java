package com.trabalho.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.trabalho.model.Cromossomo;

public class Main {

	private static final int TOTAL_INTERACOES = 50;
	
	private List<Cromossomo> listaCromossomo = new ArrayList<Cromossomo>();
	private Integer qtdIteracoes=0;
	
	private Integer numeroMagico;
	private Integer tamanhoMatriz;
	
	Random random = new Random();
	
	public static void main(String[] args) {

		Main main = new Main();
		main.execute();

	}

	private void execute() {

		this.getEntradaDados();

		this.iniciaPopulacao();
		
		while(this.verificaNumeroMagicoLinhas()) {
			
			qtdIteracoes++;
			System.out.println("GERAÇÃO " + qtdIteracoes + "\n");
			//this.printCromossomos();
			
			this.printQuadradoMagico();
			
			//O melhor permanecerá na lista
			Cromossomo pai1 = obtemMelhorCromossomo();
			listaCromossomo.remove(pai1);
			
			Cromossomo pai2 = obtemMelhorCromossomo();
			listaCromossomo.remove(pai2);		
			
			
			Cromossomo filho1 = realizaCruzamento(pai1, pai2);;
			Cromossomo filho2 = realizaCruzamento(pai2, pai1);;

			listaCromossomo.add(filho1);
			listaCromossomo.add(filho2);


		}
		
		//System.out.println("\n\nMelhor cromossomo em " + qtdIteracoes + " gerações:\n" + obtemMelhorCromossomo());
//		System.out.println("\nCromossomos Resultantes:");
//		this.printCromossomos();
		
		this.printQuadradoMagico();

	}

	private void printQuadradoMagico(){
		
		System.out.println("-------------------");
		for (Cromossomo cromossomo : listaCromossomo) {
			System.out.println(cromossomo.getValores());
		}
		System.out.println("-------------------");
		
	}
	
	// VERIFICA SE O TOTAL DE CADA LINHA CHEGOU AO NUMERO MÁGICO
	private boolean verificaTotalLinha(){
		
		for (Cromossomo c : listaCromossomo) {
			if(c.getAptidao() != numeroMagico) return false;
		}
		
		return true;
		
	}
	
	// VERIFICA SE O TOTAL DE CADA COLUNA CHEGOU AO NUMERO MÁGICO
	private boolean verificaTotalColuna(){
		return false;
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
		
		
		
		int pos1 = random.nextInt(tamanhoMatriz-1);
		int pos2 = random.nextInt(tamanhoMatriz-1);
	
		Integer cidade1 = p1.getGene(pos1);
		Integer cidade2 = p1.getGene(pos2);
		
		p1.setGene(pos2, cidade1);
		p1.setGene(pos1, cidade2);
		
		return p1;
	}
	
	// DE 2 PAIS RETORNA 1 FILHO
	private Cromossomo realizaCruzamento(Cromossomo p1, Cromossomo p2){
		
		List<Integer> genesFilho1 = new ArrayList<Integer>(Arrays.asList(p2.getGene(0), p2.getGene(1), p1.getGene(2), p1.getGene(3)));
		
		Cromossomo filho = new Cromossomo(genesFilho1);
		
		
		return this.realizaMutacao(filho);
	}
	
	private Cromossomo obtemMelhorCromossomo() {
		
		//this.ordenaGenesPelaAptidao(listaCromossomo);
		
		// PEGA ALEATÓRIO
		while(true){
			Cromossomo melhorCrom = listaCromossomo.get(random.nextInt(3));
			
			if(melhorCrom.getAptidao() != numeroMagico) return melhorCrom;
			
		}
		
	}
	
	private boolean verificaNumeroMagicoLinhas(){

		for (Cromossomo crom : listaCromossomo) {
			
			if (crom.getAptidao() != numeroMagico) {
				return true;
			}

		}
		
		return false;
	}
	
	// Para ordenar por numeros  
    private static void ordenaGenesPelaAptidao(List<Cromossomo> lista) {  
        Collections.sort(lista, new Comparator<Cromossomo>() {  
            @Override  
            public int compare(Cromossomo o1, Cromossomo o2) {  
                return o1.getAptidao().compareTo(o2.getAptidao());  
            }  
           
     });  
    }  
	
	private Boolean objetivoAtingido() {

		return qtdIteracoes == TOTAL_INTERACOES;
		
	}

	private void iniciaPopulacao() {
		
		int contador = 0;
		
		// POPULAÇÃO INICIADA PARA UM QUADRADO DE 4 LINHAS E 4 COLUNAS
		for(int i=0; i < tamanhoMatriz; i++){

		// MONTA OS GENES
		List<Integer> genes = new ArrayList<Integer>();
		for (int j = 0; j < tamanhoMatriz; j++) {
			contador++;
			genes.add(contador);
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
