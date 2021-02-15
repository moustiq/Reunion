package com.test.maru.model;

public class Reunion {

    private int heure;
    private String lieu;
    private String sujet;
    private String mails;

    public Reunion(int heure, String lieu, String sujet, String mails) {
        this.heure = heure;
        this.lieu = lieu;
        this.sujet = sujet;
        this.mails = mails;
    }


    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) {
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
