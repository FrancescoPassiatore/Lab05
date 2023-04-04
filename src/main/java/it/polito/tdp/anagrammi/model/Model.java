package it.polito.tdp.anagrammi.model;

import java.util.List;

import it.polito.tdp.anagrammi.Dao.AnagrammiDAO;

public class Model {
	
	AnagrammiDAO anagrammaDao;
	Anagramma anagramma;
	
	public Model() {
		this.anagrammaDao =new AnagrammiDAO();	
		this.anagramma = new Anagramma();
	}

	
	public List<String> calcolaAnagramma(String parola){
		return this.anagramma.calcolaAnagramma(parola);
		
	}
	
	public boolean isCorrect(String anagramma) {
		return this.anagrammaDao.isCorrect(anagramma);
	}

}
