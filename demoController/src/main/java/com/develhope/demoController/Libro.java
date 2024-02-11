package com.develhope.demoController;

public class Libro {

    private String titolo, autore, editore;
    private int pubblcazione, id;

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getEditore() {
        return editore;
    }

    public void setEditore(String editore) {
        this.editore = editore;
    }

    public int getPubblcazione() {
        return pubblcazione;
    }

    public void setPubblcazione(int pubblcazione) {
        this.pubblcazione = pubblcazione;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Libro(String titolo, String autore, String editore, int pubblcazione, int id) {
        this.titolo = titolo;
        this.autore = autore;
        this.editore = editore;
        this.pubblcazione = pubblcazione;
        this.id = id;


    }

    @Override
    public String toString() {
        return "Libro{" +
                "titolo='" + titolo + '\'' +
                ", autore='" + autore + '\'' +
                ", editore='" + editore + '\'' +
                ", pubblcazione=" + pubblcazione +
                ", id=" + id +
                '}';
    }
}
