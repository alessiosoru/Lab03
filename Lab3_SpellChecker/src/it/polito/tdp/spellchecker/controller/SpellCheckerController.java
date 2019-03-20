package it.polito.tdp.spellchecker.controller;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class SpellCheckerController {
	
	private Dictionary model;

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

    }

    @FXML
    void doSpellCheck(ActionEvent event) {

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
    	
       	boxLanguage.getItems().addAll("English", "Italiano");
    	
    	labelErrori.setText("");
		labelStato.setText("");
		this.model = model;
	}
}