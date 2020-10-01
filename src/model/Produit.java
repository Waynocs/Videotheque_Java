package model;

public abstract class Produit {
    protected String titre;
    private long id;
    private float tarif;
    public Produit() {
        this("", 0, 1);
    }
    public Produit(String titre, long id, float tarif) {
        setTitre(titre);
        setId(id);
        setTarif(tarif);
    }
    public void setTitre(String t) {
        this.titre = t;
    }
    public String getTitre() {
        return titre;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }
    public void setTarif(float t) {
        this.tarif = t;
    }
    public float getTarif() {
        return tarif;
    }
    public float getPrix(int jours) {
        return jours * tarif;
    }
    @Override
    public String toString() {
        return getTitre();
    }
}
