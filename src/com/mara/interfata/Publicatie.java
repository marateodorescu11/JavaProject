package com.mara.interfata;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public abstract class Publicatie extends Item implements Imprumutabil{
	
	protected String autor;
	
	protected String titlu;
	
	protected String categorie;
	
	protected LocalDate dataImprumut;
	
	public boolean isDisponibil() {
		return disponibil;
	}
	
	public String getAutor() {
		return autor;
	}

	public String getTitlu() {
		return titlu;
	}
	
	public String getCategorie() {
		return categorie;
	}
	
	public static String formatDate(LocalDate date) {
		return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
	}
}
