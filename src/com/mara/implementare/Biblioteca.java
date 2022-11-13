package com.mara.implementare;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.mara.interfata.Media;
import com.mara.interfata.Publicatie;


public class Biblioteca {
	
	private static int contor = 0;
	
	private List<Publicatie> publicatii;
	
	private List<Media> medii;
	
	public Biblioteca() {
		publicatii = new ArrayList<Publicatie>();
		medii = new ArrayList<Media>();
	}

	//atribuie un id unic publicatiei si o adauga in lista de publicatii. Initial trebuie sa fie disponibila????
	public void adaugaPublicatie(Publicatie publicatie) {		
		publicatie.setId(++contor);
		publicatii.add(publicatie);
	}
	
	//atribuie un id unic elementului media și îl adaugă în lista de media. Inițial trebuie să fie disponibilă ???
	public void adaugaMedia(Media media) {
		media.setId(++contor);
		medii.add(media);
		
	}
	
	//afișează lista tuturor publicațiilor precedată de eticheta „Catalog publicatii:”
	public void catalogPublicatii() {
		System.out.println("Catalog publicatii:");
		for(int i=0; i< publicatii.size(); i++) {
			System.out.println(publicatii.get(i).toString());
		}
	}
	
	//afișează lista tuturor elementelor media precedată de eticheta „Catalog media:”.
	public void catalogMedia() {
		System.out.println("Catalog media:");
		for(int i=0; i< medii.size(); i++) {
			System.out.println(medii.get(i).toString());
		}
	}
	
	//afișează lista tuturor publicațiilor disponibile precedată de eticheta „Publicatii disponibile:”.
	public void publicatiiDisponibile() {
		System.out.println("Publicatii disponibile:");
		for(int i=0; i< publicatii.size(); i++) {
			Publicatie publicatie = publicatii.get(i);
			if(publicatie.isDisponibil())
				System.out.println(publicatie.toString());
		}
	}
	
	//afișează lista tuturor publicațiilor împrumutate precedată de eticheta „Publicatii imprumutate:”.
	public void publicatiiImprumutate() {
		System.out.println("Publicatii imprumutate:");
		for(int i=0; i< publicatii.size(); i++) {
			Publicatie publicatie = publicatii.get(i);
			if(!publicatie.isDisponibil())
				System.out.println(publicatie.toString());
		}
	}
	
	//afișează lista tuturor publicațiilor care sunt din categoria pasată ca parametru. Lista este precedată de eticheta „Publicatii din categoria X:”.
	public void consultarePublicatieDupaCategorie(String categorie) {
		System.out.println("Publicatii din categoria " + categorie + " : ");
		for(int i=0; i< publicatii.size(); i++) {
			Publicatie publicatie = publicatii.get(i);
			if(publicatie.getCategorie().equals(categorie))
				System.out.println(publicatie.toString());
		}
	}
	
	//afișează lista tuturor publicațiilor care au autorul pasat ca parametru. Lista este precedată de eticheta „Publicatii scrise de X:”.
	public void consultarePublicatieDupaAutor(String autor) {
		System.out.println("Publicatii scrise de " + autor + " : ");
		for(int i=0; i< publicatii.size(); i++) {
			Publicatie publicatie = publicatii.get(i);
			if(publicatie.getAutor().equals(autor))
				System.out.println(publicatie.toString());
		}
	}
	
	//marchează ca împrumutată publicația cu id-ul dat ca parametru. Afișează mesajul „Publicatia <id> a fost imprumutata.” dacă a fost împrumutată cu succes. 
	//Afișează mesajul „Publicatia <id> nu a fost gasita!” în cazul în care id-ul este invalid.
	public void imprumutaPublicatie(int id, LocalDate dataImprumut) {
		for(int i=0; i< publicatii.size(); i++) {
			Publicatie publicatie = publicatii.get(i);
			if(id == publicatie.getId()) {
				try {
					publicatie.imprumuta(dataImprumut);
				} catch (Exception e) { 
					System.out.println(e.getMessage());
				}
				return;
			}
		}
		System.out.println("Publicatia " + id + " nu a fost gasita!");
	}
	
	/*marchează ca returnată publicația cu id-ul dat ca parametru. 
	 * Afișează mesajul „Publicația <id> a fost returnată.” dacă publicația a fost returnată cu succes. 
	 * Afișează mesajul „Publicatia <id> nu a fost gasita!” în cazul în care id-ul este invalid. 
	 * Afișează mesajul „Publicatia <id> nu poate fi returnata (nu a fost imprumutata)!” dacă id-ul nu corespunde unei publicații împrumutate. 
	 * Afișează mesajul „Termen depășit pentru publicatia <id>” în cazul în care termenul de returnare a fost depășit (dataImprumut + TERMEN_IMPRUMUT săptămâni < dataRetur). 
	 * Afișează mesajul „Penalizare X lei” în cazul în care termenul a fost depășit (calculul penalizării se face în felul următor: numărul de zile după termenul de împrumut * PENALIZARE).
	 */
	public void returneazaPublicatie(int id, LocalDate dataRetur) {
		for(int i=0; i< publicatii.size(); i++) {
			Publicatie publicatie = publicatii.get(i);
			if(id == publicatie.getId()) {
				try {
					publicatie.returneaza(dataRetur);
				} catch (Exception e) {
					System.out.println(e.getMessage());
					if(e.getMessage().contains("Termen depasit pentru publicatia")) {
						publicatie.calculPenalizare(dataRetur);
					}
				}
				return;
			}
		}
		System.out.println("Publicatia " + id + " nu a fost gasita!");
	}
	
	//marchează elementul media ca fiind indisponibil (nu ține cont de disponibilitatea sau indisponibilitatea acestuia).
	public void consultaMedia(int id) {
		for(int i=0; i< medii.size(); i++) {
			Media media = medii.get(i);
			if(id == media.getId()) {
				media.consulta();
				return;
			}
		}
		System.out.println("Media " + id + " nu a fost gasita!");
	}
	
	//marchează elementul media ca fiind disponibil (nu ține cont de disponibilitatea sau indisponibilitatea acestuia).
	public void elibereazaMedia(int id) {
		for(int i=0; i< medii.size(); i++) {
			Media media = medii.get(i);
			if(id == media.getId()) {
				media.elibereaza();
				return;
			}
		}
		System.out.println("Media " + id + " nu a fost gasita!");
	}
}
