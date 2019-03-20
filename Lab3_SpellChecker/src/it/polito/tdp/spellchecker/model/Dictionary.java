package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.*;

public class Dictionary {
	
//	private Map<String, String> dictionary;
	private List<String> dictionary;
	
	public Dictionary() {
//		this.dictionary = new TreeMap<String, String>();
		this.dictionary = new LinkedList<String>();
	}

	public void loadDictionary(String language) {
		
//		language = language.toLowerCase();
//		String first = language.substring(0, 0);
//		language = first.toUpperCase().toString()+language.substring(1);
		// non necessario perchè preimposto le due lingue nella comboBox,
		// l'utente sceglie, non le scrive
		try {
			FileReader fr = new FileReader("rsc/"+language+".txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			while((word = br.readLine()) != null) {
//				dictionary.put(word, word);
				dictionary.add(word);
			}
			
			br.close();
		} catch (IOException e) {
			System.out.println("Errore nella lettura del file");
		}
	}
	
	public List<RichWord> spellCheckText(List<String> inputTextList){
		List<RichWord> richWords = new LinkedList<RichWord>();  
		for(String w : inputTextList) {
			RichWord rw = new RichWord(w, cercaParola(w));
			richWords.add(rw);
		}
		return richWords;		
	}

	/**
	 * Dato una parola {@link String}, determina se è presente nel dizionario, 
	 * percuiiò se è corretta
	 * 
	 * @param w
	 * @return {@code true} se ha trovato la parola nel dizionario (è corretta)
	 * 			{@code false} altrimenti (non è corretta)
	 * 
	 */
	private boolean cercaParola(String w) {
		int pos = this.dictionary.indexOf(w);
		if(pos==-1)
			return false;
		else
			return true;
	}

}
