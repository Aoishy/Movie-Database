package com.example.demo12;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ByGenreController {
    static List<Movie> movieList;

    public TextField GenreField;
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
    void initialize(){
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

    public void GenreClick(ActionEvent actionEvent) throws IOException
    { List<Movie> Genrelist = new ArrayList<>();
        Table.getItems().clear();
        for(Movie m:Client.list)
        {  if(m.getGenre1().equalsIgnoreCase(GenreField.getText())||m.getGenre2().equalsIgnoreCase(GenreField.getText())||m.getGenre3().equalsIgnoreCase(GenreField.getText()))
           Genrelist.add(m);
        }
        for(Movie m:Genrelist)
        {
            Table.getItems().add(m);
        }
    }

    public void BackClick(ActionEvent actionEvent)throws IOException {
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Client.class.getResource("SearchMoviesPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850, 500);
        stage.setScene(scene);
    }
}
