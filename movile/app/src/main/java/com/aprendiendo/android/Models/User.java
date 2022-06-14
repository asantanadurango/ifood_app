package com.aprendiendo.android.Models;

public class User {


    public int id;
    public String name;
    public String email;
    public String adress;
    public String password;
    public int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
