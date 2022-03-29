package com.example.aulaarqsfwmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MyContact {

    private  int id;
    private  String name;

    public MyContact() { super(); }

    public MyContact(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}