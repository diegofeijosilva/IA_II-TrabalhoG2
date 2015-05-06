package com.exercicio.main;

public class Cromossomo {
	
	private int[] gene = new int[9];
	private int aptidao;
	private int[] valorGene = new int[9];
	
	public Cromossomo() {
		
	}
	
	public Cromossomo(int[] genes, int[] valorGenes) {
		this.gene = genes;
		this.valorGene = valorGenes;
		calculaAptidao();
	}
	
	private void calculaAptidao() {
		int somador1 = 0;
		int somador0 = 0;
		
		for(int i = 0; i < 9; i++) {
			if(this.gene[i] == 1) { //Soma genes 1
				somador1 += this.valorGene[i];
			} else { //Soma genes 0
				somador0 += this.valorGene[i];
			}
		}
		
		this.aptidao = Math.abs(somador1 - somador0);
	}

	public int[] getGene() {
		return gene;
	}

	public void setGene(int[] gene) {
		this.gene = gene;
	}

	public int getAptidao() {
		return aptidao;
	}

	public void setAptidao(int aptidao) {
		this.aptidao = aptidao;
	}

	public int[] getValorGene() {
		return valorGene;
	}

	public void setValorGene(int[] valorGene) {
		this.valorGene = valorGene;
	}
	
	
	@Override
	public String toString() {
		String genes = "";
		String valorGenesC1 = "";
		String valorGenesC2 = "";
		String valorGenes = "";
		String cromossoma = "";
		
		for(int i=0; i < this.gene.length; i++) {
			
			genes += "[" + addEspaco(new Integer(gene[i]).toString()) + "] " ;
			valorGenes += "[" + addEspaco(new Integer(valorGene[i]).toString()) + "] ";
			
			if(gene[i] == 1) {
				valorGenesC1 += new Integer(valorGene[i]).toString() + ", ";
			} else {
				valorGenesC2 += new Integer(valorGene[i]).toString() + ", ";
			}
		}
		
		cromossoma += "Genes:\n";
		cromossoma += genes + "\n";
		cromossoma += valorGenes + "\n"; 
		cromossoma += "Conjuntos:\n";
		cromossoma += "C1 = {" + valorGenesC1.substring(0, valorGenesC1.length() - 2) + "}\n";
		cromossoma += "C2 = {" + valorGenesC2.substring(0, valorGenesC2.length() - 2) + "}\n";
		cromossoma += "Aptidão: " + new Integer(aptidao).toString();
		
		return cromossoma;
	}
	
	private String addEspaco(String str) {
		if(str.length() == 1) {
			return " " + str;
		} else {
			return str;
		}
	}
	
	
	
}
