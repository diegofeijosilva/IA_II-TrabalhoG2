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

	@Override
	public String toString() {
		String ret = "{";

		for (Integer i : genes) {
			ret += i + ",";
		}

		ret += "}";
		return ret + ": Aptidao: " + this.getAptidao().toString();
	}
	
}
