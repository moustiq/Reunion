package com.test.maru.model;

public class Reunion {

    private String heure;
    private String lieu;
    private String sujet;
    // TODO: rename to email
    // devrait etre une `List<String>`
    private String mails;

    public Reunion(String heure, String lieu, String sujet, String mails) {
        this.heure = heure;
        this.lieu = lieu;
        this.sujet = sujet;
        this.mails = mails;
    }


    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getMails() {
        return mails;
    }

    public void setMails(String mails) {
        this.mails = mails;
    }
}
