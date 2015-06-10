package com.trabalho.model;

import java.util.ArrayList;
import java.util.List;

public class Cromossomo {
	
	private List<Integer> genes = new ArrayList<Integer>();
	private Integer aptidao=0;
	
	public Cromossomo(List<Integer> genes) {
		this.genes = genes;
		this.calculaAptidao();
	}
	
	private void calculaAptidao() {
		this.aptidao = 0;
		for (Integer i : genes) {
			this.aptidao += i;
		}	
	}

	public Integer getAptidao(){
		this.calculaAptidao();
		return this.aptidao;
	}
	
	public Integer getGene(Integer pos){
		return genes.get(pos);
	}
	
	public void setGene(Integer pos, Integer valor){
		this.genes.set(pos, valor);
	}
	
	public List<Integer> getListaGene(){
		return this.genes;
	}

	@Override
	public String toString() {
		String ret = "{";

		for (Integer i : genes) {
			ret += i + ",";
		}

		ret += "}";
		return ret + ": Aptidao: " + this.getAptidao().toString();
	}
	
	public String getValores(){
		
		String ret = "";
		Integer total=0;

		for (Integer i : genes) {
			total += i;
			ret += "|"+i+"|";
		}
		
		ret += " = " + this.aptidao;
		
		return ret;
	}
	
}
