package com.vinay.eyeexercise;

import java.io.Serializable;

public class FirstDataModel implements Serializable {
    private String name;
   // private String image;

    public FirstDataModel(String name) {
        this.name = name;
       // this.image = image;
    }
    public String getName(){ return name; }
  //  public String getImage(){return image;}
}

