package com.example.demo12;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;

public class TransferPageController implements Serializable {

    @FXML
    Button Confirmbutton;
    @FXML
    TextField moviefield;
    @FXML
    TextField companyfield;

    public static SocketWrapper transfer;
    TransferPageController controller;



    public void OnConfirmClick(ActionEvent actionEvent)throws IOException {
        transfer.write(new DataWrapper(1,new TransferMessage(moviefield.getText(),companyfield.getText())));
        for(int i=0;i<Client.list.size();i++)
        {
            if(Client.list.get(i).getTitle().equalsIgnoreCase(moviefield.getText()))
            {
                Client.list.remove(i);
                break;
            }
        }

    }
    public void connect(TransferPageController controller)
    {
        this.controller=controller;
        controller.connect(this);
    }

    public void OnBackClick(ActionEvent actionEvent)throws IOException {
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Client.class.getResource("MainPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850, 500);
        stage.setScene(scene);

    }
}
