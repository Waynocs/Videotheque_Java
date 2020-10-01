package controller;

import java.util.*;
import java.time.LocalDate;
import model.*;

public class Videotheque {
	private static Map<Produit, Integer> produits;
    private static Collection<Client> clients;
    private static Collection<Commande> commandes;
    private Videotheque() {}
    public static void initialiser() {
        produits = new HashMap<Produit, Integer>();
        clients = new ArrayList<Client>();
        commandes = new ArrayList<Commande>();
    }
    
    public static boolean ajouterClient(Client c) {
        if (clients.contains(c))
            return false;
        clients.add(c);
        return true;
    }
    public static boolean retirerClient(Client c) {
        return clients.remove(c);
    }
    public static int ajouterProduit(Produit p, int n) {
        if (produits.containsKey(p))
            produits.put(p, produits.get(p) + n);
        else
            produits.put(p, n);
        return produits.get(p);
    }
    public static boolean retirerProduit(Produit p) {
    	return produits.remove(p) != null;
    }
    public static boolean ajouterCommande(Commande c) {
        if (commandes.contains(c))
            return false;
        commandes.add(c);
        return true;
    }
    public static boolean retirerCommande(Commande c) {
        return commandes.remove(c);
    }
    
    public static int getStock(Produit p, LocalDate temps) {
        int total = produits.get(p);
        for(Commande comm : commandes)
            if (comm.getProduits().contains(p))
                if (!comm.getDebut().isAfter(temps) && comm.getFin(p).isAfter(temps))
                    total--;
        return total;
    }
    public static Collection<Produit> produitsDisponibles(LocalDate temps) {
        Collection<Produit> result = new ArrayList<Produit>();
        for(Produit prod : produits.keySet())
            if (getStock(prod, temps) > 0)
                result.add(prod);
        return result;
    }
    public static Collection<Produit> produitsIndisponibles(LocalDate temps) {
        Collection<Produit> result = new ArrayList<Produit>();
        for(Produit prod : produits.keySet())
            if (getStock(prod, temps) <= 0)
                result.add(prod);
        return result;
    }
    public static Collection<Produit> tousProduits() {
        return produits.keySet();
    }
	public static Collection<Client> getClients() {
        return clients;
    }
    public static Collection<Commande> getCommandes() {
        return commandes;
    }
    
   
    
}
