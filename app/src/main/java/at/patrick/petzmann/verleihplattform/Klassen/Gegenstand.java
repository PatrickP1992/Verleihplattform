package at.patrick.petzmann.verleihplattform.Klassen;

import java.util.Date;

public class Gegenstand extends Item {

    private final Kategorie kategorie = Kategorie.GEGENSTAND;

    public Gegenstand(User owner, int id, String name, String adresse, String plz, String ort, Date vonDatum, Date bisDatum, Kategorie kategorie) {
        super(owner, id, name, adresse, plz, ort, vonDatum, bisDatum,kategorie);
    }

    public Kategorie getKategorie() {
        return kategorie;
    }
}
