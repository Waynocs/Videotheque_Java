package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.Videotheque;
import model.Client;
import model.ClientFidele;

public class Clients extends SubFrame {

	private static final long serialVersionUID = -4346397433005974007L;

	public Clients(Window parent, Iterable<Client> cl) {
		super(parent);

		JPanel liste = new JPanel();
		setSize(400, 150);
		setTitle("Clients");
		liste.setLayout(new BoxLayout(liste, BoxLayout.Y_AXIS));
		add(new JScrollPane(liste));
		for (Client item : cl) {
			JPanel pn = new JPanel();
			pn.setLayout(new BoxLayout(pn, BoxLayout.X_AXIS));
			pn.add(new JLabel(item + " ; " + (item instanceof ClientFidele?" fidele":" infidele")));
			JButton delete = new JButton("supprimer");
			pn.add(delete);
			delete.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					liste.remove(pn);
					Videotheque.retirerClient(item);
					liste.revalidate();
					liste.repaint();
				}
			});
			liste.add(pn);
		}

		
	
	}
	
}
