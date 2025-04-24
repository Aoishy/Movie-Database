package com.example.demo12;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Client extends Application {
    public static List<Movie> list=new ArrayList<Movie>();
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Client.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850, 500);
        stage.setTitle("Movie Database");
        stage.setScene(scene);
        stage.show();
    }
  //  public static List<Movie> list=new ArrayList<Movie>();

    public static void main(String[] args)throws IOException {
        SocketWrapper server=new SocketWrapper("127.0.0.1",3000);
        loginController.server=server;
        TransferPageController.transfer=server;

        new Thread(()->
        {
            try{
                while(true){

                    DataWrapper wrapper=(DataWrapper) server.read();
                    if(wrapper.Id==0)
                    {
                        list=(ArrayList<Movie>)wrapper.Data;
                        for(Movie m:list){
                            System.out.println(m.getTitle());

                        }

                        for(Movie m:list)
                            m.getTitle();
                    }
                }
            }catch (IOException e)
            {
                System.out.println("Server Disconnected");

            }catch (ClassNotFoundException e){
                throw new RuntimeException(e);
            }}).start();


        launch();

    }


}