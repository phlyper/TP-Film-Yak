/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpyak;

import java.util.ArrayList;

/**
 *
 * @author Atef
 */
public class Adherent {

	private static int compteurAdherent = 1;
	private String nom;
	private String prenom;
	private String adresse;
	private int noAdherent;
	private ArrayList<Article> articlesEmpruntes = new ArrayList<Article>();

	public Adherent(String nom, String prenom, String adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.noAdherent = Adherent.compteurAdherent;
		Adherent.compteurAdherent++;
	}

	@Override
	public String toString() {
		String s = String.format("Adherent {noAdherent: %d, nom: %s, prenom: %s, adresse: %s, articlesEmpruntes: [\n", noAdherent, nom, prenom, adresse, articlesEmpruntes);
		for (Article article : articlesEmpruntes) {
			s += String.format("{\n%s}, ", article.getDescription(true));
		}
		s = s.substring(0, s.length() - 2);
		s += "\n]}";
		return s;
	}

	public void emprunter(Article article) {
		if (article != null && article.getEmprunteur() == null) {
			article.setEmprunteur(this);
			articlesEmpruntes.add(article);
		}
	}

	public void rendre(Article article) {
		if (article != null) {
			article.setEmprunteur(null);
			articlesEmpruntes.remove(article);
		}
	}

	public ArrayList<Article> emprunts() {
		return articlesEmpruntes;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getNoAdherent() {
		return noAdherent;
	}

	@Override
	public void finalize() throws Throwable {
		super.finalize();
		System.out.println(this.getClass().getName()+" Objet nettoyé de la mémoire");
	}

}
