package com.example.demo12;


import com.example.demo12.DataWrapper;
import com.example.demo12.Movie;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Server  implements Serializable {
    static List<Movie> movielist = new ArrayList<>();
    public static void main(String[] args)throws IOException {


        BufferedReader br = new BufferedReader(new FileReader("movies.txt"));
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String[] movieparts = line.split(",");
            String Title = movieparts[0];
            int Year = Integer.parseInt(movieparts[1]);
            String Genre1 = movieparts[2];
            String Genre2 = movieparts[3];
            String Genre3 = movieparts[4];
            int Running_Time = Integer.parseInt(movieparts[5]);
            String Production_Company = movieparts[6];
            long Budget = Long.parseLong(movieparts[7]);
            long Revenue = Long.parseLong(movieparts[8]);
            Movie m = new Movie(Title, Year, Genre1, Genre2, Genre3, Running_Time, Production_Company, Budget, Revenue);
            movielist.add(m);
        }
        br.close();

        ServerSocket server = new ServerSocket(3000);
        HashMap<String, SocketWrapper>ClientMap=new HashMap<>();




        while (true) {
            Socket clientSocket = server.accept();
            System.out.println("accepted");
            SocketWrapper client = new SocketWrapper(clientSocket);
            new Thread(() -> {
                try {
                    while (true) {

                        DataWrapper wrapper=(DataWrapper)client.read();
                        if(wrapper.Id==0)
                        {
                            String name=(String) wrapper.Data;
                            ClientMap.put(name.toUpperCase(),client);


                          List<Movie>companylist=new ArrayList<>();

                        for (Movie m : movielist) {
                            if (name.equalsIgnoreCase(m.getProduction_Company()))
                            { companylist.add(m);}
                        }

                        client.write(new DataWrapper(0,companylist));
                        System.out.println("first stage completed");


                    }
                        else if(wrapper.Id==1)
                        {
                            TransferMessage message = (TransferMessage) wrapper.Data;
                            String MovieTitle = message.MovieTitle;
                            String ReceiverCompany = message.ReceiverCompany;
                            System.out.println(MovieTitle+"sent to"+ReceiverCompany);
                            for (Movie m : movielist) {
                                if (m.getTitle().equalsIgnoreCase(MovieTitle)) {
                                    System.out.println("transferred movie: " + m.getTitle());
                                    m.setProduction_Company(ReceiverCompany);
                                    break;
                                }
                            }
                            writeTofile();
                        }
                        else if(wrapper.Id==2)
                        {
                            Movie m=(Movie) wrapper.Data;
                            movielist.add(m);
                            writeTofile();

                        }
                    }


                } catch (IOException e) {
                    throw new RuntimeException(e);}
                catch(ClassCastException e)
                {
                    throw new RuntimeException(e);
                }
                catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }).start();


        }


    }
    public static void writeTofile()throws IOException
    {
        BufferedWriter bw=new BufferedWriter(new FileWriter("movies.txt"));
        for(int i=0;i<movielist.size();i++)
        {
            Movie m=movielist.get(i);
            bw.write(m.getTitle()+","+m.getYear()+","+m.getGenre1()+","+m.getGenre2()+","+m.getGenre3()+","+m.getRunning_Time()+","+m.getProduction_Company()+","+m.getBudget()+","+m.getRevenue());
            if(i!=movielist.size()-1)
                bw.write(System.lineSeparator());

        }bw.close();
    }
}
