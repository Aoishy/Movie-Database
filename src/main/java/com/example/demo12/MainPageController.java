package com.example.demo12;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {

    @FXML
    TableView<Movie> Table;
    @FXML
    TableColumn<Movie,String> Titlecol;
    @FXML
    TableColumn<Movie,Integer> Yearcol;
    @FXML
    TableColumn<Movie,String> G1col;
    @FXML
    TableColumn<Movie,String> G2col;
    @FXML
    TableColumn<Movie,String> G3col;
    @FXML
    TableColumn<Movie,Integer> Timecol;
    @FXML
    TableColumn<Movie,String> Companycol;
    @FXML
    TableColumn<Movie,Integer> Budgetcol;
    @FXML
    TableColumn<Movie,Integer> Revenuecol;
    @FXML



    public void initialize(URL location, ResourceBundle resources) {
        Titlecol.setCellValueFactory(new PropertyValueFactory<>("Title"));
        Yearcol.setCellValueFactory(new PropertyValueFactory<>("Year"));
        G1col.setCellValueFactory(new PropertyValueFactory<>("Genre1"));
        G2col.setCellValueFactory(new PropertyValueFactory<>("Genre2"));
        G3col.setCellValueFactory(new PropertyValueFactory<>("Genre3"));
        Timecol.setCellValueFactory(new PropertyValueFactory<>("Running_Time"));
        Companycol.setCellValueFactory(new PropertyValueFactory<>("Production_Company"));
        Budgetcol.setCellValueFactory(new PropertyValueFactory<>("Budget"));
        Revenuecol.setCellValueFactory(new PropertyValueFactory<>("Revenue"));


    }

    public void ClickShowAllMovies(ActionEvent actionEvent) throws IOException {
        Table.getItems().clear();
        for(Movie m:Client.list)
        {
            Table.getItems().add(m);
        }

    }

    public void ClickMaximumRevenue(ActionEvent actionEvent)throws IOException {
        Table.getItems().clear();
        long MaxRev=0;
        for(Movie m:Client.list)
        {
            if(MaxRev<m.getRevenue())
                MaxRev= m.getRevenue();
        }

        for(Movie m:Client.list)
        {
            if(MaxRev==m.getRevenue()){
                Table.getItems().add(m);
            }
        }

    }

    public void ClickTotalProfit(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader=new FXMLLoader(Client.class.getResource("TotalProfitPage.fxml"));
        Scene scene=new Scene(fxmlLoader.load(),850,500);
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Main Production Company");
        stage.setScene(scene);
        stage.show();

    }

    public void ClickRecentMovies(ActionEvent actionEvent)throws IOException {
        Table.getItems().clear();
        int year=0;
        for(Movie m:Client.list)
        {
            if(year<m.getYear())
                year=m.getYear();
        }Table.getItems().clear();;
        for(Movie m:Client.list)
        {
            if(year==m.getYear())
            {
                Table.getItems().add(m);
            }
        }
    }

    public void ClickTransferMovie(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(Client.class.getResource("TransferPage.fxml"));
        Scene scene=new Scene(fxmlLoader.load(),850,500);
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Transfer Scene");
        stage.setScene(scene);
        stage.show();
    }

    public void ClickSearchOptions(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(Client.class.getResource("SearchMoviesPage.fxml"));
        Scene scene=new Scene(fxmlLoader.load(),850,500);
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Search Movies");
        stage.setScene(scene);
        stage.show();
    }

    public void ClickBack(ActionEvent actionEvent)throws IOException {
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Client.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850, 500);
        stage.setScene(scene);


    }

    public void ClickAddMovie(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(Client.class.getResource("AddMoviePage.fxml"));
        Scene scene=new Scene(fxmlLoader.load(),850,500);
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Search Movies");
        stage.setScene(scene);
        stage.show();

    }
}
