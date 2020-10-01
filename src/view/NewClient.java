package view;

import javax.swing.*;

import controller.Videotheque;
import model.*;

import java.awt.*;
import java.awt.event.*;

public class NewClient extends SubFrame {
    private static final long serialVersionUID = 1L;

    public NewClient(Window parent) {
        super(parent);
        Window instance = this;
        setTitle("Nouveau client");
        setSize(350, 200);
        JPanel pn = new JPanel(new GridLayout(5, 2));
        add(pn);
        JTextField prenom = new JTextField(10);
        JTextField nom = new JTextField(10);
        JCheckBox fidele = new JCheckBox("Client fidele");
        JSpinner id = new JSpinner(new SpinnerNumberModel(0, Integer.MIN_VALUE, Integer.MAX_VALUE, 1000));
        JButton valider = new JButton("Terminer");
        valider.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                if (fidele.isSelected())
                    Videotheque.ajouterClient(new ClientFidele(nom.getText(), prenom.getText(), (Integer)id.getValue()));
                else
                    Videotheque.ajouterClient(new Client(nom.getText(), prenom.getText(), (Integer)id.getValue()));
                dispatchEvent(new WindowEvent(instance, WindowEvent.WINDOW_CLOSING));
            }
        });
        pn.add(new JLabel("Prenom :"));
        pn.add(prenom);
        pn.add(new JLabel("Nom :"));
        pn.add(nom);
        pn.add(new JLabel(""));
        pn.add(fidele);
        pn.add(new JLabel("Identifiant :"));
        pn.add(id);
        pn.add(valider);
    }
}