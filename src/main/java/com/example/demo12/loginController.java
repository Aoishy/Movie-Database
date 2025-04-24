package com.example.demo12;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class loginController {
    public static SocketWrapper server;
    @FXML
    public TextField companyfield;
    public void onloginbutton(ActionEvent actionEvent) throws IOException {

        server.write(new DataWrapper(0,companyfield.getText()));
        FXMLLoader fxmlLoader=new FXMLLoader(Client.class.getResource("MainPage.fxml"));
        Scene scene=new Scene(fxmlLoader.load(),850,500);
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Main Production Company");
        stage.setScene(scene);
        stage.show();


    }
}
