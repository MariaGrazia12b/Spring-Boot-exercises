package com.develhope.demoController;


public class BookRequest {
    private String titolo, autore, editore;
    private int pubblicazione;

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
        return pubblicazione;
    }

    public void setPubblcazione(int pubblcazione) {
        this.pubblicazione = pubblcazione;
    }


    public BookRequest(String titolo, String autore, String editore, int pubblicazione) {
        this.titolo = titolo;
        this.autore = autore;
        this.editore = editore;
        this.pubblicazione = pubblicazione;
    }

}
