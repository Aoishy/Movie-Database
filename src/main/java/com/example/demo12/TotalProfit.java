package com.example.demo12;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TotalProfit  {
   @FXML
    Label userlabel;



    public void ClickToGetTotalProfit(ActionEvent actionEvent)throws IOException {

      long totalprofit=0;
        for(Movie m:Client.list)
        {
            totalprofit+=(m.getRevenue()- m.getBudget());
        }
        for(Movie m:Client.list)
        {
          userlabel.setText(String.valueOf(totalprofit));
        }
    }

    public void OnBackClick(ActionEvent actionEvent)throws IOException {
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Client.class.getResource("MainPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850, 500);
        stage.setScene(scene);
    }
}
