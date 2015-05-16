package com.trabalho.model;

import java.util.Arrays;

import com.trabalho.enuns.RotaEnum;

public class Cromossomo {
	
	private String[] gene = new String[8];
	private Integer aptidao;
	
	public Cromossomo() {
		
	}
	
	public Cromossomo(String[] genes) {
		this.gene = genes;
		this.calculaAptidao();
	}
	
	private void calculaAptidao() {

		Integer somador=0;
		String cidades;
		int y=1;
		for(int i = 0; i < gene.length; i++){

			if(y < gene.length){
				cidades = this.gene[i] + this.gene[y];
				somador += getDistanciaCidade(cidades);
			}
			
			y++;
		}

		y = gene.length;
		
		// CALCULA A ULTIMA CIDADE
		cidades = this.gene[0] + this.gene[--y];
		somador += getDistanciaCidade(cidades);

		this.aptidao = somador;
		
	}
	
	private Integer getDistanciaCidade(String cidades){
		
		switch (cidades) {
			case "AB": return RotaEnum.AB.getValue();
			case "AC": return RotaEnum.AC.getValue();
			case "AD": return RotaEnum.AD.getValue();
			case "AE": return RotaEnum.AE.getValue();
			case "AF": return RotaEnum.AF.getValue();
			case "AG": return RotaEnum.AG.getValue();
			case "AH": return RotaEnum.AH.getValue();
			
			case "BA": return RotaEnum.BA.getValue();
			case "BC": return RotaEnum.BC.getValue();
			case "BD": return RotaEnum.BD.getValue();
			case "BE": return RotaEnum.BE.getValue();
			case "BF": return RotaEnum.BF.getValue();
			case "BG": return RotaEnum.BG.getValue();
			case "BH": return RotaEnum.BH.getValue();
			
			case "CA": return RotaEnum.CA.getValue();
			case "CB": return RotaEnum.CB.getValue();
			case "CD": return RotaEnum.CD.getValue();
			case "CE": return RotaEnum.CE.getValue();
			case "CF": return RotaEnum.CF.getValue();
			case "CG": return RotaEnum.CG.getValue();
			case "CH": return RotaEnum.CH.getValue();
			
			case "DA": return RotaEnum.DA.getValue();
			case "DB": return RotaEnum.DB.getValue();
			case "DC": return RotaEnum.DC.getValue();
			case "DE": return RotaEnum.DE.getValue();
			case "DF": return RotaEnum.DF.getValue();
			case "DG": return RotaEnum.DG.getValue();
			case "DH": return RotaEnum.DH.getValue();
			
			case "EA": return RotaEnum.EA.getValue();
			case "EB": return RotaEnum.EB.getValue();
			case "EC": return RotaEnum.EC.getValue();
			case "ED": return RotaEnum.ED.getValue();
			case "EF": return RotaEnum.EF.getValue();
			case "EG": return RotaEnum.EG.getValue();
			case "EH": return RotaEnum.EH.getValue();
			
			case "FA": return RotaEnum.FA.getValue();
			case "FB": return RotaEnum.FB.getValue();
			case "FC": return RotaEnum.FC.getValue();
			case "FD": return RotaEnum.FD.getValue();
			case "FE": return RotaEnum.FE.getValue();
			case "FG": return RotaEnum.FG.getValue();
			case "FH": return RotaEnum.FH.getValue();
			
			case "GA": return RotaEnum.GA.getValue();
			case "GB": return RotaEnum.GB.getValue();
			case "GC": return RotaEnum.GC.getValue();
			case "GD": return RotaEnum.GD.getValue();
			case "GE": return RotaEnum.GE.getValue();
			case "GF": return RotaEnum.GF.getValue();
			case "GH": return RotaEnum.GH.getValue();
			
			case "HA": return RotaEnum.HA.getValue();
			case "HB": return RotaEnum.HB.getValue();
			case "HC": return RotaEnum.HC.getValue();
			case "HD": return RotaEnum.HD.getValue();
			case "HE": return RotaEnum.HE.getValue();
			case "HF": return RotaEnum.HF.getValue();
			case "HG": return RotaEnum.HG.getValue();
		}
		
		return 0;
		
	}

	public Integer getAptidao(){
		this.calculaAptidao();
		return this.aptidao;
	}
	
	public String getGene(int posicao){
		return this.gene[posicao];
	}
	
	public String[] getGene(){
		return this.gene;
	}
	
	public void setGene(int posicao, String value){
		this.gene[posicao] = value;
	}
	
	public void setGene(String[] gene){
		this.gene = gene;
	}
	
	@Override
	public String toString() {
		String ret = "{";

		for (String s : gene) {
			ret += s + ", ";
		}
		
		ret += this.getGene(0);
		ret += "}";
		return ret + ": Aptidao: " + this.getAptidao().toString();
	}
	
}
