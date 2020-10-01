package view;

import java.time.LocalDate;

import javax.swing.*;

import controller.Videotheque;
import model.*;

import java.awt.*;
import java.awt.event.*;

public class NewProd extends SubFrame {

    private static final long serialVersionUID = 1L;

    public NewProd(Window parent) {
        super(parent);
        setTitle("Nouveau produit");
        setSize(200, 100);
        JPanel pn = new JPanel();
        pn.setLayout(new BoxLayout(pn, BoxLayout.Y_AXIS));
        add(pn);
        JComboBox<String> types = new JComboBox<>();
        pn.add(types);
        types.addItem("BD");
        types.addItem("Manuel scolaire");
        types.addItem("Roman");
        types.addItem("Dictionnaire");
        types.addItem("CD");
        types.addItem("DVD");
        
        JButton valider = new JButton("Suivant");
        pn.add(valider);
        Window instance = this;
        valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField special = new JTextField(10);
                JLabel description = new JLabel();
                if (types.getSelectedIndex() < 3)
                    description.setText("Auteur: ");
                else if (types.getSelectedIndex() == 3)
                    description.setText("Langue: ");
                else if (types.getSelectedIndex() == 4)
                    description.setText("Annee de sortie(aaaa-mm-jj): ");
                else if (types.getSelectedIndex() == 5)
                    description.setText("Realisateur: ");
                JFrame detail = new SubFrame(parent);
                detail.setLocationRelativeTo(instance);
                detail.setSize(400, 400);
                detail.setTitle("Nouveau produit");
                JPanel principal = new JPanel();
                detail.add(principal);
                principal.setLayout(new GridLayout(6, 2, 50, 5));
                JTextField titre = new JTextField(10);
                JSpinner prix = new JSpinner(new SpinnerNumberModel(1, 0, Double.MAX_VALUE, .5));
                JSpinner id = new JSpinner(new SpinnerNumberModel(0, Integer.MIN_VALUE, Integer.MAX_VALUE, 1000));
                JSpinner qte = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
                principal.add(new JLabel("titre: "));
                principal.add(titre);
                principal.add(new JLabel("prix journalier: "));
                principal.add(prix);
                principal.add(new JLabel("quantite: "));
                principal.add(qte);
                principal.add(description);
                principal.add(special);
                principal.add(new JLabel("identifiant: "));
                principal.add(id);
                JButton valider = new JButton("Terminer ");
                principal.add(valider);
                valider.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        switch (types.getSelectedIndex()) {
                            case 0:
                            Videotheque.ajouterProduit(new BD(special.getText(), titre.getText(), (Integer)id.getValue(), (float)(double)prix.getValue()), (Integer)qte.getValue());
                            break;
                            case 1:
                            Videotheque.ajouterProduit(new ManuelScolaire(special.getText(), titre.getText(), (Integer)id.getValue(), (float)(double)prix.getValue()), (Integer)qte.getValue());
                            break;
                            case 2:
                            Videotheque.ajouterProduit(new Roman(special.getText(), titre.getText(), (Integer)id.getValue(), (float)(double)prix.getValue()), (Integer)qte.getValue());
                            break;
                            case 3:
                            Videotheque.ajouterProduit(new Dictionnaire(special.getText(), titre.getText(), (Integer)id.getValue(), (float)(double)prix.getValue()), (Integer)qte.getValue());
                            break;
                            case 4:
                            Videotheque.ajouterProduit(new CD(LocalDate.parse(special.getText()), titre.getText(), (Integer)id.getValue(), (float)(double)prix.getValue()), (Integer)qte.getValue());
                            break;
                            case 5:
                            Videotheque.ajouterProduit(new DVD(special.getText(), titre.getText(), (Integer)id.getValue(), (float)(double)prix.getValue()), (Integer)qte.getValue());
                            break;
                        }
                        instance.setEnabled(false);
                        detail.dispatchEvent(new WindowEvent(detail, WindowEvent.WINDOW_CLOSING));
                    }
                });
                setVisible(false);
                detail.setVisible(true);
            }
        });
    }
}