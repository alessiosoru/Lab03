package it.polito.tdp.spellchecker.model;

public class RichWord {
	private String inputParola;
	private boolean corretta;
	
	public RichWord(String inputParola, boolean corretta) {
		this.inputParola = inputParola;
		this.corretta = corretta;
	}

	public String getInputParola() {
		return inputParola;
	}

	public void setInputParola(String inputParola) {
		this.inputParola = inputParola;
	}

	public boolean isCorretta() {
		return corretta;
	}

	public void setCorretta(boolean corretta) {
		this.corretta = corretta;
	}

	@Override
	public String toString() {
		// Stampo solo la parola e non anche se � corretta o meno
		return this.inputParola.toString()+"\n";
	}
	
	

}
