package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.Videotheque;
import model.Commande;

public class Commandes extends SubFrame {

	private static final long serialVersionUID = -4346397433005974007L;

	public Commandes(Window parent, Iterable<Commande> comm) {
		super(parent);
		Window instance = this;
		JPanel liste = new JPanel();
		setSize(400, 150);
		setTitle("Commandes");
		liste.setLayout(new BoxLayout(liste, BoxLayout.Y_AXIS));
		add(new JScrollPane(liste));
		for (Commande item : comm) {
			JPanel pn = new JPanel();
			pn.setLayout(new BoxLayout(pn, BoxLayout.X_AXIS));
			pn.add(new JLabel(item.getClient() + " ; " + item.getDebut()));
			JButton see = new JButton("voir commande");
			JButton delete = new JButton("supprimer");
			pn.add(see);
			pn.add(delete);
			delete.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					liste.remove(pn);
					Videotheque.retirerCommande(item);
					liste.revalidate();
					liste.repaint();
				}
			});
			see.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new VisuComm(instance, item).setVisible(true);
				}
			});
			liste.add(pn);
		}

		
	
	}
	
}
