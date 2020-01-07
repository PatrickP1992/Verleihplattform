package at.patrick.petzmann.verleihplattform.Klassen;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        User patrick   = new User(0,  "Patrick",   "1234");
        User stefan    = new User(1,  "Stefan",    "1234");
        User emanuel   = new User(2,  "Emanuel",   "1234");
        User christian = new User(3,  "Christian", "1234");

        ArrayList<User> users = new ArrayList<>();
        users.add(patrick);
        users.add(stefan);
        users.add(emanuel);
        users.add(christian);

        ArrayList<Dienstleistung> dienstleistungen = new ArrayList<>();
        ArrayList<Gegenstand> gegenstaende = new ArrayList<>();

        ItemFactory itemFactory = new ItemFactory();


    }





}
