package at.patrick.petzmann.verleihplattform.Klassen;

import java.util.ArrayList;

public class User {

    //--Variablen------------------------------------------------------
    private int id;
    private String userName;
    private String password;
    private int points;
    private ArrayList<Item> gelieheneGegenstände;

    private String[] itemName;
    private int[] idNumber;
    private int[] pictureCode;

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

    public String[] getItemName() {
        return itemName;
    }

    public int[] getIdNumber() {
        return idNumber;
    }

    public int[] getPictureCode() {
        return pictureCode;
    }

    public ArrayList<Item> getGelieheneGegenstände() {
        return gelieheneGegenstände;
    }

    public void addGelieheneGegenstände(Item item) {
        for (Item i : gelieheneGegenstände) {
            if (i.getId() == item.getId()) {
                // to-do Error Message dass gegenstand schon in der liste ist.
                return;
            }
        }
        this.gelieheneGegenstände.add(item);
        filterForArrays();
    }

    public void deleteGelieheneGegenstände(Item item) {
        for (Item i : gelieheneGegenstände) {
            if (i.getId() == item.getId()) {
                gelieheneGegenstände.remove(item);
                filterForArrays();
                return;
            }
        }
        //to-do error message dass element nicht in der Liste ist
    }

    private void filterForArrays() {

        this.itemName = new String[gelieheneGegenstände.size()];
        this.idNumber = new int[gelieheneGegenstände.size()];
        this.pictureCode = new int[gelieheneGegenstände.size()];

        for (int i = 0; i < gelieheneGegenstände.size(); i++) {
            this.itemName[i] = gelieheneGegenstände.get(i).getName();
            this.idNumber[i] = gelieheneGegenstände.get(i).getId();
            this.pictureCode[i] = gelieheneGegenstände.get(i).getImageRessource();
        }
    }

}
