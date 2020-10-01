package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import controller.Videotheque;
import model.*;

public class Main extends JFrame {

	private static final long serialVersionUID = -5276643838848973371L;

	public Main() {
		
		Client vincent = new Client("Time", "Vincent", 23156);
		Client gerard = new Client("Menvuça", "Gérard", 23156);		
		Videotheque.ajouterClient(vincent);
		Videotheque.ajouterClient(gerard);
		
		CD cd = new CD(LocalDate.of(2018, 04, 28), "Johnny Hallyday", 12, 8);
		Videotheque.ajouterProduit(cd, 5);

		
		this.setTitle("Videotheque");
		this.setSize(400, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
	

		java.awt.Window instance = this;

		Box b1 = Box.createHorizontalBox();
		JButton clients = new JButton("Clients");
		clients.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Clients(instance, Videotheque.getClients()).setVisible(true);
			}
		});
	    b1.add(clients);
		JButton commandes = new JButton("Commandes");
		commandes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Commandes(instance, Videotheque.getCommandes()).setVisible(true);
			}
		});
	    b1.add(commandes);
		JButton produits = new JButton("Produits");
		produits.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Produits(instance, Videotheque.tousProduits()).setVisible(true);
			}
		});
	    b1.add(produits);
	  
	    Box b2 = Box.createHorizontalBox();
		JButton prodDispo = new JButton("Produits disponibles");
		prodDispo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Produits(instance, Videotheque.produitsDisponibles(LocalDate.now())).setVisible(true);
			}
		});
	    b2.add(prodDispo);
		JButton prodIndispo = new JButton("Produits indisponibles");
		prodIndispo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Produits(instance, Videotheque.produitsIndisponibles(LocalDate.now())).setVisible(true);
			}
		});
	    b2.add(prodIndispo);
	   
	    Box b3 = Box.createHorizontalBox();
		JButton ajProd = new JButton("Ajouter produit");
		ajProd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new NewProd(instance).setVisible(true);
			}
		});
	    b3.add(ajProd);
		JButton ajComm = new JButton("Ajouter commande");
		ajComm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new NewComm(instance).setVisible(true);
			}
		});
	    b3.add(ajComm);
		JButton ajClient = new JButton("Ajouter client");
		ajClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new NewClient(instance).setVisible(true);
			}
		});
	    b3.add(ajClient);
	   
	    Box b4 = Box.createVerticalBox();
	    b4.add(b1);
	    b4.add(b2);
	    b4.add(b3);

	    this.getContentPane().add(b4);
	    

	
	  
	    
	    
	    
		
	}
	public static void main(String[] args) throws Exception {
		Videotheque.initialiser();
		UIManager.setLookAndFeel(new NimbusLookAndFeel());


		Main myWindow = new Main();


		myWindow.setVisible(true);
	}
	public static Object getSpecificData(Produit p) {
		if (p instanceof Livre)
			return ((Livre)p).getAuteur();
		else if (p instanceof Dictionnaire)
			return ((Dictionnaire)p).getLangue();
		else if (p instanceof CD)
			return ((CD)p).getDate();
		else if (p instanceof DVD)
			return ((DVD)p).getRealisateur();
		else
			return null;
	}
}
