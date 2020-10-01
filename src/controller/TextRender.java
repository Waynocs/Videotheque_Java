package controller;

import java.io.*;
import java.time.temporal.ChronoUnit;

import model.*;

public class TextRender {
    private TextRender(){}

    public static void printCommande(Commande comm, OutputStream stream) {
        PrintWriter writer = new PrintWriter(stream);
        writer.println("Commande : ");
        writer.println("Client : " + comm.getClient());
        writer.println("Debut : " + comm.getDebut());
        writer.println();
        {
            int pos = 32;
            writer.print("produit:");
            while (pos > 0) {
                writer.print(" ");
                pos--;
            }
            writer.print("fin :          ");
            writer.println("prix :");
        }
        writer.println("___________________________________________________________");
        float total = 0;
        for(Produit item : comm.getProduits()) {
            String desc = item.getClass().getSimpleName()+":"+item.getTitre();
            int pos = 40 - desc.length();
            writer.print(desc);
            while (pos > 0) {
                writer.print(" ");
                pos--;
            }
            desc = comm.getFin(item).toString();
            pos = 14 - desc.length();
            writer.print(desc);
            while (pos > 0) {
                writer.print(" ");
                pos--;
            }
            long jours = comm.getDebut().until(comm.getFin(item), ChronoUnit.DAYS);
            total += item.getPrix((int)jours);
            writer.println(item.getPrix((int)jours)+" euros ");
        }

        writer.println("___________________________________________________________");
        if (comm.getClient() instanceof ClientFidele || comm.getReduction() > 0)
            writer.println("Total produits : " + total+" euros ");
        if (comm.getClient() instanceof ClientFidele) {
            writer.println("Reduction client fidele : -" + round(total*.1f)+" euros ");
            if (comm.getReduction() > 0)
                writer.println("Sous-total : " + round(total*.9f)+" euros ");
        }
        if (comm.getReduction() > 0)
            writer.println("Reduction applicable : -" + comm.getReduction() + " euros ");
        writer.println("Total : " + round(comm.getPrix())+" euros ");
        writer.flush();
    }
    private static float round(float value) {
        return Math.round(value*100)/100f;
    }
}