package it.polito.tdp.anagrammi.model;

import java.util.LinkedList;
import java.util.List;

public class Anagramma {
	
	public List<String> calcolaAnagramma(String parola) {
	
		if (parola.length()==1) {
			List<String> risultato = new LinkedList<String>();
			risultato.add(parola);
			return risultato ;
			
		}else {
			
			List<String> risultato = new LinkedList<String>();
		
		   for (int pos = 0 ; pos < parola.length(); pos++) {
			
			 char lettera = parola.charAt(pos);
			 String restanti = parola.substring(0, pos)+ parola.substring(pos+1);
			
			 List<String> anagrammiRestanti = calcolaAnagramma(restanti);
			 
			 for (String sol:anagrammiRestanti) {
				 risultato.add(lettera+sol);
			 }
			
		}
		   return risultato;
		   }
	
	}

}
