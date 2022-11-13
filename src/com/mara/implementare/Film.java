package com.mara.implementare;

import com.mara.interfata.Media;


public class Film extends Media{
	
	@Override
	public String toString() {
		return id + ". " + suport + "	" + titlu + "	" + an + "	" + gen + "	" + regizor;
	}
	
	protected String titlu;
	
	protected int an;
	
	protected String gen;
	
	protected String regizor;
	
	public Film(String suport, String titlu, int an, String gen, String regizor) {
		super.suport = suport;
		this.titlu = titlu;
		this.an = an;
		this.gen = gen;
		this.regizor = regizor;
	}

	@Override
	public void consulta() {
		this.disponibil = false;
		System.out.println("Media " + this.id + " este in consultare.");
	}

	@Override
	public void elibereaza() {
		this.disponibil = true;
		System.out.println("Media " + this.id + " este libera.");
	}
}
