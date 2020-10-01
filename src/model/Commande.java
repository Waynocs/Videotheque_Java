package model;



public class Commande {
    private java.time.LocalDate debut;
    private java.util.Map<Produit, Long> emprunts;
    private Client client;
    private float reduction;
    
    public Commande(Client client) {
        this(client, java.time.LocalDate.now(), 0);
    }
    public Commande(Client client, java.time.LocalDate debut, float reduc) {
        setClient(client);
        setDebut(debut);
        emprunts = new java.util.HashMap<Produit, Long>();
        setReduction(reduc);
    }
    
    public void setReduction(float r) {
        reduction = r;
    }
    public float getReduction() {
        return reduction;
    }
    
    public void setDebut(java.time.LocalDate d) {
        debut = d;
    }
    
    public java.time.LocalDate getDebut() {
        return debut;
    }
    
    public void setClient(Client c) {
        client = c;
    }
    
    public Client getClient() {
        return client;
    }
    
    public java.util.Collection<Produit> getProduits() {
        return new java.util.ArrayList<Produit>(emprunts.keySet());
    }
    
    public java.time.LocalDate getFin(Produit p) {
        return debut.plusDays(emprunts.get(p));
    }
    
    public void ajouterProduit(Produit p, long jours) {
        emprunts.put(p, jours);
    }
    
    public void retirerProduit(Produit p) {
        emprunts.remove(p);
    }
    
    public float getPrix() {
        float result = 0;
        for (java.util.Map.Entry<Produit, Long> entry : emprunts.entrySet())
            result += entry.getKey().getPrix((int)(long)entry.getValue());
        if (client instanceof ClientFidele)
            result *= .9f;
        return result - reduction;
    }
    
}
