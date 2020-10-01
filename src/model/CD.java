package model;

public class CD extends Numerique {
    private java.time.LocalDate date;
    public CD(java.time.LocalDate date, String titre, long id, float tarif) {
        super(titre, id, tarif);
        setDate(date);
    }
    public CD() {
        super();
        setDate(java.time.LocalDate.now());
    }
    public void setDate(java.time.LocalDate d) {
        date = d;
    }
    public java.time.LocalDate getDate() {
        return date;
    }
}