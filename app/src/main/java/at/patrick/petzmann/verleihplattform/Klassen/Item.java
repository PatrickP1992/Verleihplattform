package at.patrick.petzmann.verleihplattform.Klassen;

import java.util.Date;

import at.patrick.petzmann.verleihplattform.R;

public abstract class Item {

    //--Variablen------------------------------------------------------
    private User owner;
    private User ausgeliehenVon;

    private int id ;

    private String name;
    private String adresse;
    private String plz;
    private String Ort;

    private Date vonDatum;
    private Date bisDatum;

    private Kategorie kategorie;

    private boolean verliehen;

    private int imageRessource;


    // --Konstruktor----------------------------------------------------
    public Item(User owner, int id, String name, String adresse, String plz, String ort, Date vonDatum, Date bisDatum, Kategorie kategorie) {
        this.owner = owner;
        this.id = id;
        this.name = name;
        this.adresse = adresse;
        this.plz = plz;
        Ort = ort;
        this.vonDatum = vonDatum;
        this.bisDatum = bisDatum;
        this.verliehen = false;
        this.kategorie = kategorie;
        imageRessource = R.drawable.ic_launcher_foreground; // Standart Bild
    }

    //--Getter und Setter----------------------------------------------
    public User getAusgeliehenVon() {
        return ausgeliehenVon;
    }

    public void setAusgeliehenVon(User ausgeliehenVon) {
        this.ausgeliehenVon = ausgeliehenVon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return Ort;
    }

    public void setOrt(String ort) {
        Ort = ort;
    }

    public Date getVonDatum() {
        return vonDatum;
    }

    public void setVonDatum(Date vonDatum) {
        this.vonDatum = vonDatum;
    }

    public Date getBisDatum() {
        return bisDatum;
    }

    public void setBisDatum(Date bisDatum) {
        this.bisDatum = bisDatum;
    }

    public boolean isVerliehen() {
        return verliehen;
    }

    public void setVerliehen(boolean verliehen) {
        this.verliehen = verliehen;
    }

    public Kategorie getKategorie() {
        return kategorie;
    }

    public int getId() {
        return id;
    }

    public User getOwner() {
        return owner;
    }

    public int getImageRessource() {
        return imageRessource;
    }

    public void setImageRessource(int imageRessource) {
        this.imageRessource = imageRessource;
    }
}
