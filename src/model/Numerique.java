package model;

public abstract class Numerique extends Produit {
    public Numerique(String titre, long id, float tarif) {
        super(titre, id, tarif);
    }
    public Numerique() {
        super();
    }
}
