package at.patrick.petzmann.verleihplattform.Klassen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Verleihsystem implements Serializable{

    public static Verleihsystem verleihsystem;
    //--Variablen-----------------------------------------------------------------------------------
    private ArrayList<User> users;
    private ArrayList<Gegenstand> gegenstaende;
    private ArrayList<Dienstleistung> dienstleistungen;

    private User activeUser = null;

    private ItemFactory itemFactory;

    //--Methoden------------------------------------------------------------------------------------

    /**
     * Fügt einen user in die ArrayList users hinzu
     */
    public void addUser(User user)
    {
        for (User u:users)
        {
            if (u.getId()==user.getId() || u.getUserName()==user.getUserName())
            {
                return; // Wenn der User schon enthalten ist
            }
        }
        users.add(user);
    }


    /**
     * Erstellt ein Item und fügt es gleich in die richtige Liste ein
     * @param owner Besitzer des Items
     * @param name  Name des Items
     * @param adresse
     * @param plz
     * @param ort
     * @param vonDatum
     * @param bisDatum
     * @param kategorie Kategorie des Items
     */
    public void createItem(User owner, String name, String adresse, String plz, String ort, Date vonDatum, Date bisDatum, Kategorie kategorie)
    {
        Item item = itemFactory.createItem(owner,name,adresse,plz,ort,vonDatum,bisDatum,kategorie);

        // Wenn Gegenstand
        if (item.getKategorie().equals(Kategorie.GEGENSTAND))
        {
            for (Gegenstand g:gegenstaende) {
                if(g.getId()==item.getId())
                {
                    return; // Wenn schon vorhanden
                }
                gegenstaende.add((Gegenstand)item);
            }
        }

        // Wen Dienstleistung
        if (item.getKategorie().equals(Kategorie.DIENSTLEISTUNG))
        {
            for (Dienstleistung d:dienstleistungen)
            {
                if (d.getId()== item.getId())
                {
                    return;
                }
                dienstleistungen.add((Dienstleistung)item);
            }
        }

    }

    /**
     * Gibt das Item mit der id aus der entsprechenden Kategorie zurück
     * @param id
     * @param kategorie
     * @return
     */
    public Item returnItemByCategorie(int id, Kategorie kategorie)
    {
        if (kategorie.equals(Kategorie.GEGENSTAND))
        {
            for (Gegenstand g:gegenstaende)
            {
                if (g.getId()==id)
                    return g;
            }
        }

        if (kategorie.equals(Kategorie.DIENSTLEISTUNG))
        {
            for (Dienstleistung d:dienstleistungen)
            {
                if (d.getId()==id)
                    return d;
            }
        }

        return null;
    }


    /**
     * Wenn Benutzername und Passwort stimmen wir true zurückgegeben und activeUser wird gesetzz
     * sonst wird false zurückgegeben
     * @param username
     * @param password
     * @return
     */
    public boolean login(String username, String password)
    {
        User toLogin = null;

        for (User u:users)
        {
            if (u.getUserName().equals(username) && u.getPassword().equals(password))
            {
                activeUser = u;
                return true;
            }
        }

        return false;
    }




    //--Konstruktor---------------------------------------------------------------------------------
    public Verleihsystem(ArrayList<User> users, ArrayList<Gegenstand> gegenstaende, ArrayList<Dienstleistung> dienstleistungen, ItemFactory itemFactory) {
        this.users = users;
        this.gegenstaende = gegenstaende;
        this.dienstleistungen = dienstleistungen;
        this.itemFactory = itemFactory;
    }

    //--Getter und Setter---------------------------------------------------------------------------
    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Gegenstand> getGegenstaende() {
        return gegenstaende;
    }

    public void setGegenstaende(ArrayList<Gegenstand> gegenstaende) {
        this.gegenstaende = gegenstaende;
    }

    public ArrayList<Dienstleistung> getDienstleistungen() {
        return dienstleistungen;
    }

    public void setDienstleistungen(ArrayList<Dienstleistung> dienstleistungen) {
        this.dienstleistungen = dienstleistungen;
    }

    public ItemFactory getItemFactory() {
        return itemFactory;
    }

    public void setItemFactory(ItemFactory itemFactory) {
        this.itemFactory = itemFactory;
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    public static void setVerleihsystem(Verleihsystem verleihsystem) {
        Verleihsystem.verleihsystem = verleihsystem;
    }

    public static Verleihsystem getVerleihsystem() {
        return verleihsystem;
    }
}
