package com.example.demo12;

import java.io.Serializable;

public class TransferMessage implements Serializable {
    public String MovieTitle;
    public String ReceiverCompany;
     public TransferMessage(String MovieTitle, String ReceiverCompany)
     {
         this.MovieTitle=MovieTitle;
         this.ReceiverCompany=ReceiverCompany;
     }

}
