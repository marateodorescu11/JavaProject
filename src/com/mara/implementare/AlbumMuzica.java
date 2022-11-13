package com.mara.implementare;

import com.mara.interfata.Media;

public class AlbumMuzica extends Media{
	
	@Override
	public String toString() {
		return id + ". " + suport + "	" + titlu + "	" + artist + "	" + gen;
	}
	
	protected String titlu;
	
	protected String artist;
	
	protected String gen;
	
	public AlbumMuzica(String suport, String titlu, String artist, String gen) {
		super.suport = suport;
		this.titlu = titlu;
		this.artist = artist;
		this.gen = gen;
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
