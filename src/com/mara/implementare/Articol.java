package com.mara.implementare;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.mara.interfata.Publicatie;

public class Articol extends Publicatie{
	
	@Override
	public String toString() {
		return id + ". " + autor + "	" + titlu + "	" + categorie + "	" + publicatie + "	" + formatDate(dataPublicatie);
	}
	
	public static int TERMEN_IMPRUMUT = 2;
	
	public static double PENALIZARE = 0.1;
	
	protected String publicatie;
	
	protected LocalDate dataPublicatie;
	
	public Articol(String autor, String titlu, String categorie, String publicatie, LocalDate dataPublicatie) {
		super.autor = autor;
		super.titlu = titlu;
		super.categorie = categorie;
		this.publicatie = publicatie;
		this.dataPublicatie = dataPublicatie;
	}

	//trebuie să marcheze elementul ca fiind împrumutat și să stabilească data acestuia de împrumut. Aruncă o excepție dacă elementul este indisponibil cu mesajul „Publicatia <id> este indisponibila!”.
	@Override
	public void imprumuta(LocalDate dataImprumut) throws Exception { 
		if(isDisponibil()) {
			this.disponibil = false;
			this.dataImprumut = dataImprumut;
			System.out.println("Publicatia " + this.id + "  a fost imprumutata.");
		}else
			throw new Exception("Publicatia " + this.id + "  este indisponibila!");
	}

	/* trebuie să marcheze elementul ca fiind returnat. Aruncă o excepție dacă elementul nu a fost împrumutat cu mesajul „Publicatia <id> nu poate fi returnata (nu a fost imprumutata)!” 
	 * și dacă termenul a fost depășit, cu mesajul „Termen depasit pentru publicatia <id>!”.
	 */
	@Override
	public void returneaza(LocalDate dataRetur) throws Exception {
		if(isDisponibil()) {
			throw new Exception("Publicatia " + this.id + "  nu poate fi returnata (nu a fost imprumutata)!");
		}else {
			long weeks = ChronoUnit.WEEKS.between(this.dataImprumut, dataRetur);
			if(weeks > TERMEN_IMPRUMUT) {
				throw new Exception("Termen depasit pentru publicatia " + this.id);
			}else {
				this.disponibil = true;
				this.dataImprumut = null;
				System.out.println("Publicatia " + this.id + "  a fost returnata.");
			}
		}
	}

	//returnează valoarea penalizării în funcție de durata depășirii termenului de restituire.
	@Override
	public void calculPenalizare(LocalDate dataRetur){
		if(!isDisponibil()) {
			long weeks = ChronoUnit.WEEKS.between(this.dataImprumut, dataRetur);
			if(weeks > TERMEN_IMPRUMUT) {
				long days = ChronoUnit.DAYS.between(this.dataImprumut, dataRetur);
				double penalizare = days * PENALIZARE;
				System.out.println("Penalizare " + penalizare + " lei.");
			}
		}
	}

}
