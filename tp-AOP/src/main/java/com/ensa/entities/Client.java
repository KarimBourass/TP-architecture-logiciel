package com.ensa.entities;

public class Client {
    private String nom;
    private Compte cp;
    public Client() {
    }
    public Client(String nom, Compte cp) {
        this.nom = nom;
        this.cp = cp;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Compte getCp() {
        return cp;
    }
    public void setCp(Compte cp) {
        this.cp = cp;
    }
    public void retirer(double mt){
        cp.debiter(mt);
    }
    public void verser(double mt){
        cp.approvisionner(mt);
    }

    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", cp=" + cp +
                '}';
    }
}
