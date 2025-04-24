package com.example.demo12;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;

import static com.example.demo12.loginController.server;

public class AddMovieController implements Serializable {
    @FXML
    public TextField titlefield;
    @FXML
    public TextField yearfield;
    @FXML
    public TextField genre1field;
    @FXML
    public TextField genre2field;
    @FXML
    public TextField genre3field;
    @FXML
    public  TextField timefield;
    @FXML
    public TextField budgetfield;
    @FXML
    public TextField revenuefield;

    public void OnAddClick(ActionEvent actionEvent) throws IOException {
        String title=titlefield.getText();
        int year=Integer.parseInt(yearfield.getText());


        String genre1="null";
        String genre2="null";
        String genre3="null";
        if(genre1!=null)
        { genre1=genre1field.getText();}
        if(genre2!=null)
        {
            genre2=genre2field.getText();
        }
        if(genre3!=null)
        {
            genre3=genre3field.getText();
        }

        int runningtime=Integer.parseInt(timefield.getText());
        long budget=Long.parseLong(budgetfield.getText());
        long revenue=Long.parseLong(revenuefield.getText());
        String p=null;
        Movie m=new Movie(title,year,genre1,genre2,genre3,runningtime,Client.list.get(0).getProduction_Company(),budget,revenue);
        server.write(new DataWrapper(2,m));
        Client.list.add(m);

    }

    public void OnBackClick(ActionEvent actionEvent)throws IOException {
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Client.class.getResource("MainPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850, 500);
        stage.setScene(scene);

    }
}
