package it.polito.tdp.parole.model;

import java.util.List;
import java.util.*;

public class Parole {
	
		private LinkedList<String> paroleL=new LinkedList<String>();
		
	public Parole() {
		//TODO
	}
	
	public void addParola(String p) {
		//TODO
		this.paroleL.add(p);
	}
	
	public List<String> getElenco() {
		//TODO
		paroleL.sort(new NomiComparator());
		return paroleL;
	}
	
	public void reset() {
		// TODO
		paroleL.remove();
	}

}
