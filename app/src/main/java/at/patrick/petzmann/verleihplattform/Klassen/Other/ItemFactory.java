package at.patrick.petzmann.verleihplattform.Klassen.Other;

import java.util.Date;

import at.patrick.petzmann.verleihplattform.Klassen.System.Dienstleistung;
import at.patrick.petzmann.verleihplattform.Klassen.System.Gegenstand;
import at.patrick.petzmann.verleihplattform.Klassen.System.Item;
import at.patrick.petzmann.verleihplattform.Klassen.System.Kategorie;
import at.patrick.petzmann.verleihplattform.Klassen.System.User;

public class ItemFactory {
    private static int id = 1;


    /**
     * Erstellt ein Item und vergibt automatisch eine ID
     * @param owner
     * @param name
     * @param adresse
     * @param plz
     * @param ort
     * @param vonDatum
     * @param bisDatum
     * @param kategorie
     * @return
     */
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
