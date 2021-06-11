package com.example.monprojetandroid;

public class Filiere {
    private int idFiliere;
    private String nom;
    private Tuteur chefFiliere;

    public Filiere() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Filiere(int idFiliere, String nom, Tuteur chefFiliere) {
        super();
        this.idFiliere = idFiliere;
        this.nom = nom;
        this.chefFiliere = chefFiliere;
    }

    public int getIdFiliere() {
        return idFiliere;
    }

    public void setIdFiliere(int idFiliere) {
        this.idFiliere = idFiliere;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public byte[] getChefFiliere() {
        return chefFiliere;
    }

    public void setChefFiliere(Tuteur chefFiliere) {
        this.chefFiliere = chefFiliere;
    }

}
