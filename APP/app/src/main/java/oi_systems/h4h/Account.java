package oi_systems.h4h;

/**
 * Created by Šarūnas on 2018-06-03.
 */

public class Account {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String address;
    private String phoneNr;
    private int coins;
    private double rating;

    static private int ids = 0;

    public Account(String name, String surname, String email, String password, String address, String phoneNr){
        this.id = ids;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phoneNr = phoneNr;
        //coins = 99;
        //rating = 4.5;
        ids++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }
}
