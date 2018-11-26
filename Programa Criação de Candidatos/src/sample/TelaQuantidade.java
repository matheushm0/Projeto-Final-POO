package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Digitos;

import java.util.ArrayList;
import java.util.List;

public class TelaQuantidade {

    public TextField txtCargo;

    public TextField txtQuantidade;

    public ComboBox <Digitos> cbDigitos;

    private List <Digitos> digitos = new ArrayList<>();

    private ObservableList<Digitos> obsDigitos;

    public void carregarDigitos(){

        Digitos digitos2 = new Digitos (2, "2");
        Digitos digitos3 = new Digitos (3, "3");
        Digitos digitos4 = new Digitos (4, "4");
        Digitos digitos5 = new Digitos (5, "5");
        Digitos digitos6 = new Digitos (6, "6");

        digitos.add(digitos2);
        digitos.add(digitos3);
        digitos.add(digitos4);
        digitos.add(digitos5);
        digitos.add(digitos6);

        obsDigitos = FXCollections.observableArrayList(digitos);

        cbDigitos.setItems(obsDigitos);


    }

    @FXML
    void initialize() {
        assert txtCargo != null : "fx:id=\"txtCargo\" was not injected: check your FXML file 'TelaQuantidade.fxml'.";
        assert txtQuantidade != null : "fx:id=\"txtQuantidade\" was not injected: check your FXML file 'TelaQuantidade.fxml'.";
        assert cbDigitos != null : "fx:id=\"cbDigitos\" was not injected: check your FXML file 'TelaQuantidade.fxml'.";
        carregarDigitos();

    }

}
