package at.patrick.petzmann.verleihplattform.Klassen;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class Verleihsystem{

    public static Verleihsystem verleihsystem;
    //--Variablen-----------------------------------------------------------------------------------
    private ArrayList<User> users;
    private ArrayList<Gegenstand> gegenstaende;
    private ArrayList<Dienstleistung> dienstleistungen;

    private String[] filterReturnNames;
    private int[] filterReturnPictureRes;
    private int[] filterReturnItemId;

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
    public boolean createItem(User owner, String name, String adresse, String plz, String ort, Date vonDatum, Date bisDatum, Kategorie kategorie)
    {
        Item item = itemFactory.createItem(owner,name,adresse,plz,ort,vonDatum,bisDatum,kategorie);

        // Wenn Gegenstand
        if (item.getKategorie().equals(Kategorie.GEGENSTAND))
        {
            for (Gegenstand g:gegenstaende) {
                if(g.getId()==item.getId())
                {
                    return false; // Wenn schon vorhanden
                }
            }
            gegenstaende.add((Gegenstand)item);
            return true;
        }

        // Wen Dienstleistung
        if (item.getKategorie().equals(Kategorie.DIENSTLEISTUNG))
        {
            for (Dienstleistung d:dienstleistungen)
            {
                if (d.getId()== item.getId())
                {
                    return false;
                }
            }
            dienstleistungen.add((Dienstleistung)item);
            return true;
        }

        return false;
    }

    /**
     * gibt das Item mit der id zurück
     * @param id
     * @return
     */
    public Item returnItemById(int id)
    {
        for (Gegenstand g:gegenstaende)
        {
            if (g.getId()==id)
                return g;
        }
        for (Dienstleistung d:dienstleistungen)
        {
            if (d.getId()==id)
                return d;
        }
        return null;
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

    /**
     *
     * @param filterText
     * @param kategorie
     */
    public void setCurrentFilter(TextView filterText,User user, Kategorie kategorie)
    {
        int i = 0;
        if(kategorie.equals(Kategorie.DIENSTLEISTUNG))
        {
            filterReturnNames = new String[dienstleistungen.size()];
            filterReturnPictureRes = new int[dienstleistungen.size()];
            filterReturnItemId = new int[dienstleistungen.size()];

            for (Dienstleistung d: dienstleistungen) 
            {
                filterReturnItemId[i] = d.getId();
                filterReturnNames[i] = d.getName();
                filterReturnPictureRes[i] = d.getImageRessource();
                i++;
            }
        }

        if(kategorie.equals(Kategorie.GEGENSTAND))
        {
            filterReturnNames = new String[gegenstaende.size()];
            filterReturnPictureRes = new int[gegenstaende.size()];
            filterReturnItemId = new int[gegenstaende.size()];

            for (Gegenstand g: gegenstaende)
            {
                filterReturnItemId[i] = g.getId();
                filterReturnNames[i] = g.getName();
                filterReturnPictureRes[i] = g.getImageRessource();
                i++;
            }
        }
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

    public String[] getFilterReturnNames() {
        return filterReturnNames;
    }

    public int[] getFilterReturnPictureRes() {
        return filterReturnPictureRes;
    }

    public int[] getFilterReturnItemId() {
        return filterReturnItemId;
    }
}
