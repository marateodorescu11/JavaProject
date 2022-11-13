package com.mara.interfata;

public abstract class Media extends Item implements Consultabil{
	
	//reprezintă suportul fizic pe care se găsește elementul media – CD, DVD etc.
	protected String suport;
	
	public boolean isDisponibil() {
		return disponibil;
	}

}
