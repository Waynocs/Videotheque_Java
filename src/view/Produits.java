package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.*;

import controller.Videotheque;
import model.Produit;

public class Produits extends SubFrame {

	private static final long serialVersionUID = -4346397433005974007L;

	public Produits(Window parent, Iterable<Produit> prod) {
		super(parent);

		JPanel liste = new JPanel();
		this.setSize(300, 150);
		this.setTitle("Produits");
		liste.setLayout(new BoxLayout(liste, BoxLayout.Y_AXIS));
		add(new JScrollPane(liste));
		for (Produit item : prod) {
			JPanel pn = new JPanel();
			pn.setLayout(new BoxLayout(pn, BoxLayout.X_AXIS));
			pn.add(new JLabel(item.getTitre() + " ; " + item.getClass().getSimpleName() + " ; stock : " + Videotheque.getStock(item, LocalDate.now()) + " ; "+Main.getSpecificData(item)));
			JButton delete = new JButton("supprimer");
			pn.add(delete);
			delete.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					liste.remove(pn);
					Videotheque.retirerProduit(item);
					liste.revalidate();
					liste.repaint();
				}
			});
			liste.add(pn);
		}

		
	
	}
	
}
