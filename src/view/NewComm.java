package view;

import javax.swing.*;

import controller.Videotheque;
import model.*;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.*;

public class NewComm extends SubFrame {
    private static final long serialVersionUID = 1L;

    public NewComm(Window parent) {
        super(parent);
        Window instance = this;
        setTitle("Nouvelle commande");
        setSize(800, 200);
        Map<Produit, Long> prods = new HashMap<>();
        JPanel diviseur = new JPanel(new GridLayout(1, 3));
        JPanel liste = new JPanel();
        liste.setLayout(new BoxLayout(liste, BoxLayout.Y_AXIS));
        JPanel principal = new JPanel(new GridLayout(4,2));
        JPanel ajouteur = new JPanel(new GridLayout(4,2));
        diviseur.add(principal);
        diviseur.add(ajouteur);
        diviseur.add(new JScrollPane(liste));
        add(diviseur);
        JComboBox<Client> clients = new JComboBox<>(Videotheque.getClients().toArray(new Client[0]));
        principal.add(new JLabel("Client :"));
        principal.add(clients);
        JTextField date = new JTextField(10);
        principal.add(new JLabel("Date(aaaa-mm-jj) :"));
        principal.add(date);
        JSpinner reduc = new JSpinner(new SpinnerNumberModel(0, 0, Double.MAX_VALUE, .5f));
        principal.add(new JLabel("Reduction :"));
        principal.add(reduc);
        JButton valider = new JButton("Terminer");
        principal.add(valider);
        valider.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Commande curr = new Commande((Client)clients.getSelectedItem(), LocalDate.parse(date.getText()), (float)(double)reduc.getValue());
                for (Map.Entry<Produit, Long> entry : prods.entrySet())
                    curr.ajouterProduit(entry.getKey(), entry.getValue());
                Videotheque.ajouterCommande(curr);
                dispatchEvent(new WindowEvent(instance, WindowEvent.WINDOW_CLOSING));
            }
        });
        ajouteur.add(new JLabel("Ajouter produit :"));
        ajouteur.add(new JLabel());
        JComboBox<Produit> produits = new JComboBox<>(Videotheque.tousProduits().toArray(new Produit[0]));
        ajouteur.add(new JLabel("Produit :"));
        ajouteur.add(produits);
        JSpinner jours = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
        ajouteur.add(new JLabel("Nombre de jours"));
        ajouteur.add(jours);
        JButton ajouterProd = new JButton("Ajouter");
        ajouteur.add(new JLabel());
        ajouteur.add(ajouterProd);
        ajouterProd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!prods.containsKey(produits.getSelectedItem())) {
                    Produit prod = (Produit)produits.getSelectedItem();
                    JPanel toAdd = new JPanel(new GridLayout(1,3));
                    toAdd.add(new JLabel(prod + ","));
                    toAdd.add(new JLabel("Jours :" + jours.getValue()));
                    JButton remove = new JButton("Retirer");
                    toAdd.add(remove);
                    remove.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            liste.remove(toAdd);
                            prods.remove(prod);
                            liste.revalidate();
                            liste.repaint();
                        }
                    });
                    prods.put(prod, (long)(int)jours.getValue());
                    liste.add(toAdd);
                    liste.revalidate();
                    liste.repaint();
        }
            }
        });
    }
}