package model;

public class Client {
    private long id;
    private String nom;
    private String prenom;
    public Client() {
        this("", "", 0);
    }
    public Client(String nom, String prenom, long id) {
        setId(id);
        setNom(nom);
        setPrenom(prenom);
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }
    public void setNom(String n) {
        nom = n;
    }
    public String getNom() {
        return nom;
    }
    public void setPrenom(String p) {
        prenom = p;
    }
    public String getPrenom() {
        return prenom;
    }
    
    @Override
    public String toString() {
        return getPrenom() + " " + getNom();
    }
}