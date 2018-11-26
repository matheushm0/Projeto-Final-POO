package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class Controller {

    public Button buttonCriar;

    public Button buttonSair;


    public void acaoCriarCandidatos(ActionEvent actionEvent) throws IOException {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Senha");
        dialog.setHeaderText("Informe sua senha de administrador.");
        dialog.setContentText("Senha: ");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            System.out.println("Sua senha: " + result.get());
        }
        result.ifPresent(senha -> System.out.println("Senha: " + senha));

        Parent tela_quantidade_parent = FXMLLoader.load(getClass().getResource("TelaQuantidade.fxml"));
        Scene tela_quantidade_scene = new Scene(tela_quantidade_parent);
        Stage app_stage = ((Stage)((Node) actionEvent.getSource()).getScene().getWindow());
        app_stage.setScene(tela_quantidade_scene);
        app_stage.show();

    }


    public void acaoSair(ActionEvent actionEvent) {

        Stage stage = (Stage) buttonSair.getScene().getWindow();
        stage.close();

    }
}
