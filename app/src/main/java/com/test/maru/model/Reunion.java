package com.test.maru.model;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Reunion {

    private int avatar;
    private String heure;
    private String lieu;
    private String sujet;
    private List<String> emails;

    public Reunion(String heure, String lieu, String sujet, List<String> emails) {

        //this.avatar = avatar;
        this.heure = heure;
        this.lieu = lieu;
        this.sujet = sujet;
        this.emails = emails;
    }

    public Reunion() {
        this.emails = new ArrayList<String>();

    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
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


    public List<String> getMails() {
        return emails;
    }

    public void setMails(List<String> mails) {
        this.emails = mails;
    }


}
