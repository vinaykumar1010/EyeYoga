package com.vinay.eyeexercise;

import java.io.Serializable;

public class FirstDataModel implements Serializable {
    private String name;
    private  String description;
   // private String image;

    public FirstDataModel(String name , String description) {
        this.name = name;
        this.description = description;
       // this.image = image;
    }
    public String getName(){ return name; }
  //  public String getImage(){return image;}
    public String getDescription(){
        return  description;
    }
}

