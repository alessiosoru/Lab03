package it.polito.tdp.spellchecker.controller;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import java.net.URL;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class SpellCheckerController {
	
	private Dictionary model;
	private List<String> paroleInserite;
	
    public SpellCheckerController() {
		this.paroleInserite = new LinkedList<String>();
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> boxLanguage;

    @FXML
    private TextArea txtInserito;

    @FXML
    private Button spellCheckButton;

    @FXML
    private TextArea txtCorretto;

    @FXML
    private Label labelErrori;

    @FXML
    private Button clearTextButton;

    @FXML
    private Label labelStato;
    @FXML
    void doClearText(ActionEvent event) {
    	this.txtInserito.clear();
		this.txtCorretto.clear();
		paroleInserite.clear();

    }
    
    @FXML
    void handleNuovaTraduzione(ActionEvent event) {
    	if((this.boxLanguage.getValue())!=null) {
    		this.txtInserito.clear();
    		this.txtCorretto.clear();
    		this.txtInserito.setDisable(false);
    		this.txtCorretto.setDisable(false);
    		this.clearTextButton.setDisable(false);
    		this.spellCheckButton.setDisable(false);
    	} else {
    		this.txtInserito.setDisable(false);
    		this.txtCorretto.setDisable(false);
    		this.clearTextButton.setDisable(false);
    		this.spellCheckButton.setDisable(false);
    	}
    		

    }

    @FXML
    void doSpellCheck(ActionEvent event) {

    	// Seleziona la lingua
    	this.model.loadDictionary(boxLanguage.getValue());
    	
    	// Leggi il testo
    	String testo = this.txtInserito.getText();
    	testo = testo.replaceAll("[.,\\/#!?$%\\^&\\*;:{}=\\-_`~()\\[\\]]", "");
    	testo = testo.replaceAll("\n", " ");

//    	String parole[] = testo.split(" ");
//    	for(String p : parole) {
//    		this.paroleInserite.add(p);
//    	}
    	StringTokenizer parole = new StringTokenizer(testo, " ");
    	while(parole.hasMoreTokens()) {
    		paroleInserite.add(parole.nextToken());
    	}
    	
    	// Checking e Stampa parole errate
    	long  startTime = System.nanoTime();
    	int i = 0 ;
    	this.txtCorretto.clear();
    	for(RichWord rw : model.paroleSbagliate(paroleInserite)) {
    		this.txtCorretto.appendText(rw.toString());
    		i++;
    	}  
    	long  endTime = System.nanoTime();
    	float totalTime = (float)(endTime-startTime)/1000000000;
    	
    	// Stampa numero di errori
    	this.labelErrori.setText("The text contains "+i+" errors");
    	
    	// Stampa tempo impiegato per controllo ortografico
    	this.labelStato.setText("Spell check completed in "+totalTime+" seconds");

    }

    @FXML
    void initialize() {
        assert boxLanguage != null : "fx:id=\"boxLanguage\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtInserito != null : "fx:id=\"txtInserito\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert spellCheckButton != null : "fx:id=\"spellCheckButton\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtCorretto != null : "fx:id=\"txtCorretto\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert labelErrori != null : "fx:id=\"labelErrori\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert clearTextButton != null : "fx:id=\"clearTextButton\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert labelStato != null : "fx:id=\"labelStato\" was not injected: check your FXML file 'SpellChecker.fxml'.";

    }
    
    public void setModel(Dictionary model) {
    	
    	txtInserito.setText("Selezionare una lingua");
    	
       	boxLanguage.getItems().addAll("English", "Italian");
    	
    	labelErrori.setText("");
		labelStato.setText("");
		this.model = model;
	}
}