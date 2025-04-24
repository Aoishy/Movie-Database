package com.example.demo12;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class SearchMoviesController {
    static List<Movie> movieList;
    public void ClickSearchByTitle(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(Client.class.getResource("ByTitle.fxml"));
        Scene scene=new Scene(fxmlLoader.load(),850,500);
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("SearchByTitle");
        stage.setScene(scene);
        stage.show();
    }

    public void ClickSearchByYear(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(Client.class.getResource("ByYear.fxml"));
        Scene scene=new Scene(fxmlLoader.load(),850,500);
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("SearchByrReleasingYear");
        stage.setScene(scene);
        stage.show();
    }

    public void ClickSearchByGenre(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader=new FXMLLoader(Client.class.getResource("ByGenre.fxml"));
        Scene scene=new Scene(fxmlLoader.load(),850,500);
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("SearchByrReleasingYear");
        stage.setScene(scene);
        stage.show();
    }

    public void ClickSearchByTime(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(Client.class.getResource("ByTime.fxml"));
        Scene scene=new Scene(fxmlLoader.load(),850,500);
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("SearchByRunningTime");
        stage.setScene(scene);
        stage.show();
    }

    public void Clickback(ActionEvent actionEvent) throws IOException{
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Client.class.getResource("MainPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850, 500);
        stage.setScene(scene);
    }

    public void ClickTopMovies(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader=new FXMLLoader(Client.class.getResource("TopMovies.fxml"));
        Scene scene=new Scene(fxmlLoader.load(),850,500);
        Stage stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("SearchByRunningTime");
        stage.setScene(scene);
        stage.show();
    }
}
