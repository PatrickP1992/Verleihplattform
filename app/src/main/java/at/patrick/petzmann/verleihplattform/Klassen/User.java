package at.patrick.petzmann.verleihplattform.Klassen;

import java.util.ArrayList;

public class User {

    //--Variablen------------------------------------------------------
    private int id;
    private String userName;
    private String password;
    private int points;
    private ArrayList<Item> gelieheneItems;

    private String[] itemName;
    private int[] idNumber;
    private int[] pictureCode;

    // --Konstruktor----------------------------------------------------
    public User(int id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.points = 5;
        gelieheneItems = new ArrayList<>();
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
            this.points = this.points - 1;
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

    public ArrayList<Item> getGelieheneItems() {
        return gelieheneItems;
    }

    public void addGelieheneGegenstände(Item item) {
        for (Item i : gelieheneItems) {
            if (i.getId() == item.getId()) {
                // to-do Error Message dass gegenstand schon in der liste ist.
                return;
            }
        }
        this.gelieheneItems.add(item);
        filterForArrays();
    }

    public void deleteGelieheneGegenstände(Item item) {
        for (Item i : gelieheneItems) {
            if (i.getId() == item.getId()) {
                gelieheneItems.remove(item);
                filterForArrays();
                return;
            }
        }
        //to-do error message dass element nicht in der Liste ist
    }

    private void filterForArrays() {

        this.itemName = new String[gelieheneItems.size()];
        this.idNumber = new int[gelieheneItems.size()];
        this.pictureCode = new int[gelieheneItems.size()];

        for (int i = 0; i < gelieheneItems.size(); i++) {
            this.itemName[i] = gelieheneItems.get(i).getName();
            this.idNumber[i] = gelieheneItems.get(i).getId();
            this.pictureCode[i] = gelieheneItems.get(i).getImageRessource();
        }
    }

}
