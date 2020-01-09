package at.patrick.petzmann.verleihplattform.Klassen;

import java.util.ArrayList;

public class User {

    //--Variablen------------------------------------------------------
    private int id;
    private String userName;
    private String password;

    // --Konstruktor----------------------------------------------------
    public User(int id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    //--Getter und Setter----------------------------------------------
    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
