package com.mara.interfata;


public interface Consultabil {
	
	//marchează elementul ca fiind indisponibil. În cazul în care este deja indisponibil nu se întâmplă nimic.
	void consulta();
	
	//marchează elementul ca fiind disponibil. În cazul în care este deja disponibil nu se întâmplă nimic.
	void elibereaza();

}
