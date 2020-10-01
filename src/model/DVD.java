package model;

public class DVD extends Numerique {
    private String realisateur;
    public DVD(String realisateur, String titre, long id, float tarif) {
        super(titre, id, tarif);
        setRealisateur(realisateur);
    }
    public DVD() {
        super();
        setRealisateur("");
    }
    public void setRealisateur(String r) {
        realisateur = r;
    }
    public String getRealisateur() {
        return realisateur;
    }
}