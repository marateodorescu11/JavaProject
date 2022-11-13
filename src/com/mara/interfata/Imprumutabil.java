package com.mara.interfata;

import java.time.LocalDate;

public interface Imprumutabil {
	
	//trebuie să marcheze elementul ca fiind împrumutat și să stabilească data acestuia de împrumut. Aruncă o excepție dacă elementul este indisponibil cu mesajul „Publicatia <id> este indisponibila!”.
	void imprumuta(LocalDate dataImprumut) throws Exception;
	
	/* trebuie să marcheze elementul ca fiind returnat. Aruncă o excepție dacă elementul nu a fost împrumutat cu mesajul „Publicatia <id> nu poate fi returnata (nu a fost imprumutata)!” 
	 * și dacă termenul a fost depășit, cu mesajul „Termen depasit pentru publicatia <id>!”.
	 */
	void returneaza(LocalDate dataRetur) throws Exception;
	
	//returnează valoarea penalizării în funcție de durata depășirii termenului de restituire.
	void calculPenalizare(LocalDate dataRetur);

}
