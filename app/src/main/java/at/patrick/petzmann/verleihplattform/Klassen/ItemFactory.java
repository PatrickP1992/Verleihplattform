package at.patrick.petzmann.verleihplattform.Klassen;

import java.util.Date;

public class ItemFactory {
    private static int id = 0;

    public Item createItem(User owner, String name, String adresse, String plz, String ort, Date vonDatum, Date bisDatum, Kategorie kategorie)
    {
        Item item = null;
        if(kategorie.equals(Kategorie.DIENSTLEISTUNG))
        {
            item = new Dienstleistung(owner,id, name, adresse,plz, ort, vonDatum, bisDatum, kategorie);
            id++;
            return item;
        }
        else if (kategorie.equals(Kategorie.GEGENSTAND))
        {
            item = new Gegenstand(owner,id, name, adresse,plz, ort, vonDatum, bisDatum, kategorie);
            id++;
            return item;
        }
        return null;
    }
}
