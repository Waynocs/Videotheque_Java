package model;

public abstract class Livre extends Document {
    private String auteur;
    public Livre(String auteur, String titre, long id, float tarif) {
        super(titre, id, tarif);
        setAuteur(auteur);
    }
    public Livre() {
        super();
        setAuteur("");
    }
    public void setAuteur(String a) {
        auteur = a;
    }
    public String getAuteur() {
        return auteur;
    }
}