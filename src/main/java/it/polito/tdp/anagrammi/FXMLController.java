/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnCalcola"
    private Button btnCalcola; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML // fx:id="txtAnaCorretti"
    private TextArea txtAnaCorretti; // Value injected by FXMLLoader

    @FXML // fx:id="txtAnaErrati"
    private TextArea txtAnaErrati; // Value injected by FXMLLoader

    @FXML // fx:id="txtInsertWord"
    private TextField txtInsertWord; // Value injected by FXMLLoader

    @FXML
    void calcolaAnagramma(ActionEvent event) {
    	
    	List<String> risultato = new LinkedList<String>();
    	
    	String parola = this.txtInsertWord.getText();
    	risultato = this.model.calcolaAnagramma(parola);
    	
    	this.txtAnaCorretti.clear();
    	this.txtAnaErrati.clear();
    	
    	for (String s : risultato) {
    		if (this.model.isCorrect(s)==true) {
    			this.txtAnaCorretti.appendText(s+"\n");
    		} else {
    			this.txtAnaErrati.appendText(s+"\n");	
    		}
    	}
    	
    	

    }

    @FXML
    void reset(ActionEvent event) {
    	
    	this.txtAnaCorretti.clear();
    	this.txtAnaErrati.clear();

    }
    
    public void setModel(Model model) {
    	this.model= model;
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnaCorretti != null : "fx:id=\"txtAnaCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnaErrati != null : "fx:id=\"txtAnaErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInsertWord != null : "fx:id=\"txtInsertWord\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}
