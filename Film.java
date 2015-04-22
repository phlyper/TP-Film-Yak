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
public class Film {

	private String titre;
	private boolean nouveaute = false;
	private Realisateur realisateur = null;
	private ArrayList<Article> articles = new ArrayList<Article>();

	public Film(String titre, Realisateur realisateur) {
		this.titre = titre;
		this.realisateur = realisateur;
		realisateur.AddFilm(this);
	}

	public Dvd nouveauDvd(int nbDisques, boolean bonus) {
		Dvd dvd = new Dvd(this, nbDisques, bonus);
		articles.add(dvd);
		return dvd;
	}

	public Vhs nouveauVhs(TypeVhs type) {
		Vhs vhs = new Vhs(this, type);
		articles.add(vhs);
		return vhs;
	}

	public Dvd dvdDisponible() {
		for (Article article : articles) {
			if (article instanceof Dvd) {
				if (article.getEmprunteur() == null) {
					return (Dvd) article;
				}
			}
		}
		return null;
	}

	public Vhs vhsDisponible() {
		for (Article article : articles) {
			if (article instanceof Vhs) {
				if (article.getEmprunteur() == null) {
					return (Vhs) article;
				}
			}
		}
		return null;
	}

	public void retirerArticle(Article article) {
		articles.remove(article);
	}

	public String getTitre() {
		return titre;
	}

	public boolean isNouveaute() {
		return nouveaute;
	}

	public void setNouveaute(boolean nouveaute) {
		this.nouveaute = nouveaute;
	}

	public Realisateur getRealisateur() {
		return realisateur;
	}

	public ArrayList<Article> getArticles() {
		return articles;
	}

	@Override
	public void finalize() throws Throwable {
		super.finalize();
		System.out.println(this.getClass().getName()+" Objet nettoyé de la mémoire");
	}
}
