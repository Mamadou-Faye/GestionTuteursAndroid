package com.example.monprojetandroid;

public class Cours {

    private int idCours;
    private String nom;
    private Filiere idFiliere;

    public Cours(int idCours, String nom, Filiere idFiliere) {
        super();
        this.idCours = idCours;
        this.nom = nom;
        this.idFiliere = idFiliere;
    }

    public Cours() {
        super();
        // TODO Auto-generated constructor stub
    }
    public int getIdCours() {
        return idCours;
    }
    public void setIdCours(int idCours) {
        this.idCours = idCours;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Filiere getIdFiliere() {
        return idFiliere;
    }
    public void setIdFiliere(Filiere idFiliere) {
        this.idFiliere = idFiliere;
    }
}
