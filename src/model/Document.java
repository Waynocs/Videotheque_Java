package model;

public abstract class Document extends Produit {
    public Document(String titre, long id, float tarif) {
        super(titre, id, tarif);
    }
    public Document() {
        super();
    }
}