package model;

public class Dictionnaire extends Document {
    private String langue;
    public Dictionnaire(String langue, String titre, long id, float tarif) {
        super(titre, id, tarif);
        setLangue(langue);
    }
    public Dictionnaire() {
        super();
        setLangue("");
    }
    public void setLangue(String l) {
        langue = l;
    }
    public String getLangue() {
        return langue;
    }
}
