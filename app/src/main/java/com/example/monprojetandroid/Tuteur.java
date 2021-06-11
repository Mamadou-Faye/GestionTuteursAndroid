package com.example.monprojetandroid;

public class Tuteur {
    private int idTuteur;
    private String nom;
    private String prenom;
    private String email;
    private Filiere filiere;


    public int getIdTuteur() {
        return idTuteur;
    }

    public void setIdTuteur(int idTuteur) {
        this.idTuteur = idTuteur;
    }

    public Tuteur getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public Tuteur() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Tuteur(int idTuteur, String nom, String prenom, String email, Filiere filiere) {
        super();
        this.idTuteur = idTuteur;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.filiere = filiere;
    }
}
