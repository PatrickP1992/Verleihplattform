package at.patrick.petzmann.verleihplattform.Klassen;

import java.util.ArrayList;

public class User {

    //--Variablen------------------------------------------------------
    private int id;
    private String userName;
    private String password;
    private int points;
    private ArrayList<Item> gelieheneGegenstände;

    // --Konstruktor----------------------------------------------------
    public User(int id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.points = 5;
        gelieheneGegenstände = new ArrayList<>();
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

    public int getPoints() {
        return points;
    }

    public void setPointsPlus() {
        this.points = this.points + 5;
    }

    public void setPointsMinus() {
        if (this.points - 1 > 0) {
            this.points--;
        }

    }

    public ArrayList<Item> getGelieheneGegenstände() {
        return gelieheneGegenstände;
    }

    public void addGelieheneGegenstände(Item item) {
        for (Item i:gelieheneGegenstände) {
            if(i.getId() == item.getId()){
                // to-do Error Message dass gegenstand schon in der liste ist.
                return;
            }
        }
        this.gelieheneGegenstände.add(item);
    }

    public void deleteGelieheneGegenstände(Item item){
        for (Item i:gelieheneGegenstände) {
            if(i.getId() == item.getId()){
                gelieheneGegenstände.remove(item);
                return;
            }
        }
        //to-do error message dass element nicht in der Liste ist
    }

}
