package com.example.demo12;

import java.io.Serializable;

public class DataWrapper implements Serializable {
    public int Id;
    public Object Data;
    public DataWrapper(int Id,Object Data)
    {
        this.Id=Id;
        this.Data=Data;
    }
}

