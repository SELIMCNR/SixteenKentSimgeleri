package com.selimcinar.kentsimgeleri;

import java.io.Serializable; //Landmark sınıfı serileştirilebilir oldu interface eklendi

public class Landmark implements Serializable {
    String name;
    String country;
    String details;
    int image;

    //Constructor
    public Landmark(String name,String country,String details,int image){
        this.name=name;
        this.country=country;
        this.details=details;
        this.image=image;
    }
}
