package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;

import controller.TextRender;
import model.Commande;
import model.Produit;

public class VisuComm extends SubFrame {

	private static final long serialVersionUID = -4346397433005974007L;

	public VisuComm(Window parent, Commande comm) {
		super(parent);

		JPanel pnPrincipal = new JPanel();
		pnPrincipal.setLayout(new BoxLayout(pnPrincipal, BoxLayout.Y_AXIS));
		add(pnPrincipal);
		pnPrincipal.add(new JLabel("Client: " + comm.getClient()));
		pnPrincipal.add(new JLabel("Date: " + comm.getDebut()));
		pnPrincipal.add(new JLabel("Réduction: " + comm.getReduction() + " € "));
		pnPrincipal.add(new JLabel("Total: " + comm.getPrix() + " € "));
		JButton export = new JButton("exporter dans le fichier commande.txt");
		pnPrincipal.add(export);
		export.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				File output = new File("commande.txt");
				if (!output.exists())
					try {
						output.createNewFile();
					} catch (IOException exc) {
						return;
					}
				try {
					OutputStream stream = new FileOutputStream(output);
					TextRender.printCommande(comm, stream);
					stream.close();
				} catch (FileNotFoundException exc) {
				} catch (IOException exc) {
				}
			}
		});
		JPanel liste = new JPanel();
		setSize(400, 200);
		setTitle("Clients");
		liste.setLayout(new BoxLayout(liste, BoxLayout.Y_AXIS));
		pnPrincipal.add(new JScrollPane(liste));
		for (Produit item : comm.getProduits()) {
			JPanel pn = new JPanel();
			pn.setLayout(new BoxLayout(pn, BoxLayout.X_AXIS));
			pn.add(new JLabel(item.getTitre() + " ; " + item.getClass().getSimpleName() + " ; fin: " + comm.getFin(item)));
			liste.add(pn);
		}

	}
	
}
