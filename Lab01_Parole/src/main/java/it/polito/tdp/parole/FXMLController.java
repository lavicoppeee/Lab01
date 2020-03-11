package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    @FXML
    private TextArea txtTempo;

    @FXML
    private Button btnCancella;
    
	@FXML
	void doCancella(ActionEvent event) {
		long tempoI = System.nanoTime();
		String parola = txtResult.getSelectedText();
		elenco.removeParola(parola);
		txtResult.clear();

		for (String p : elenco.getElenco())
			txtResult.appendText(p + "\n");

		long tempoF = System.nanoTime();
		String t=String.valueOf(tempoF-tempoI);
		txtTempo.appendText(t);

	}

    @FXML
    void doInsert(ActionEvent event) {
    	// TODO
    	long tempoI = System.nanoTime();
    	String parola=txtParola.getText();
    	
    	//controllo che inserisca na parola
    	if(parola.length()==0) {
    		txtResult.appendText("Devi inserire una parola");
    		return;
    	}
    	//aggiungo all'elenco
    	elenco.addParola(parola);
    	txtResult.clear();
    	
    	for(String p: elenco.getElenco())
    		txtResult.appendText(p+"\n");
    	
    	txtParola.clear();
    	long tempoF = System.nanoTime();
		String t=String.valueOf(tempoF-tempoI);
		txtTempo.appendText(t);

    }

    @FXML
    void doReset(ActionEvent event) {
    	// TODO
    	long tempoI = System.nanoTime();
    	elenco.reset();
    	txtResult.clear();
    	txtParola.clear();
    	long tempoF = System.nanoTime();
		String t=String.valueOf(tempoF-tempoI);
		txtTempo.appendText(t);
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}














