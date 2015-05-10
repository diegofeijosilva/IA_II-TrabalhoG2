package com.trabalho.enuns;

public enum RotaEnum {

	AB(10),
	AC(153),
	AD(42),
	AE(37),
	AF(920),
	AG(410),
	AH(13),
	
	BA(10),
	BC(8),
	BD(27),
	BE(93),
	BF(45),
	BG(21),
	BH(18),
	
	CA(153),
	CB(8),
	CD(3),
	CE(21),
	CF(97),
	CG(410),
	CH(38),
	
	DA(42),
	DB(27),
	DC(3),
	DE(22),
	DF(45),
	DG(81),
	DH(6),
	
	EA(37),
	EB(93),
	EC(21),
	ED(22),
	EF(19),
	EG(80),
	EH(13),
	
	FA(920),
	FB(45),
	FC(97),
	FD(45),
	FE(19),
	FG(18),
	FH(23),
	
	GA(410),
	GB(21),
	GC(410),
	GD(81),
	GE(80),
	GF(18),
	GH(5),
	
	HA(13),
	HB(18),
	HC(38),
	HD(6),
	HE(13),
	HF(23),
	HG(5);
	
	private Integer value;
	
	private RotaEnum(int value) {
		
		this.value = value;
	}
	
	public Integer getValue(){
		return this.value;
	}
	
}
