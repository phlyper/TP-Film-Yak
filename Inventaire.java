/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpyak;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Atef
 */
public class Inventaire {

	/**
	 * La classe Hashtable permet de stocker des données sous la forme clé -
	 * valeur dans une variable et les parcourir facilement. Cette classe
	 * Hashtable du package java.util est synchronisée, c'est-à-dire qu'elle est
	 * conçue pour être utilisée par des applications qui gèrent des processus
	 * multiples, ou multithread.
	 */
	public Hashtable<Integer, Article> articles = new Hashtable<Integer, Article>();

	public Article findArticle(int noInventaire) {
		return articles.get(new Integer(noInventaire));
	}

	public int nouveauDvd(Film f, int nbDisques, boolean bonus) {
		Dvd dvd = f.nouveauDvd(nbDisques, bonus);
		articles.put(new Integer(dvd.getNumeroInventaire()), dvd);
		return dvd.getNumeroInventaire();
	}

	public int nouveauVhs(Film f, TypeVhs type) {
		Vhs vhs = f.nouveauVhs(type);
		articles.put(new Integer(vhs.getNumeroInventaire()), vhs);
		return vhs.getNumeroInventaire();
	}

	public void supprimerArticle(int noInventaire) throws ArticleException {
		Article article = this.findArticle(noInventaire);
		if (article != null) {
			if (article.getEmprunteur() != null) {
				throw new ArticleException("Article emprunté");
			} else {
				if (articles.remove(new Integer(noInventaire)) != null) {
					article.getFilm().retirerArticle(article);
				}
			}
		}
	}

	@Override
	public String toString() {
		String s = "";
		Enumeration<Article> articles = this.articles.elements();
		while (articles.hasMoreElements()) {
			Article article = articles.nextElement();
			s += String.format("%s", article.getDescription(true));
		}
		return s;
	}

	@Override
	public void finalize() throws Throwable {
		super.finalize();
		System.out.println(this.getClass().getName() + " Objet nettoyé de la mémoire");
	}

	public static void main(String[] args) {
		Inventaire inventaire = new Inventaire();
		Realisateur realisateur = new Realisateur("James", "Cameron");
		Film film = new Film("Avatar", realisateur);
		int no1 = inventaire.nouveauDvd(film, 1, false);
		int no2 = inventaire.nouveauDvd(film, 1, false);
		int no3 = inventaire.nouveauVhs(film, TypeVhs.PAL);
		Adherent adherent = new Adherent("John", "Doe", "10 rue de la Liberté");
		Article articleNo1 = null;
		articleNo1 = inventaire.findArticle(no1);
		if (articleNo1 != null) {
			adherent.emprunter(articleNo1);
		}
		for (Article article : film.getArticles()) {
			System.out.println(article.getDescription(true) + "\n");
		}
		System.out.println("--------------------------------------------");
		try {
			inventaire.supprimerArticle(no2);
		} catch (ArticleException e) {
			System.out.println(e.getMessage());
		}
		try {
			inventaire.supprimerArticle(no1);
		} catch (ArticleException e) {
			System.out.println(e);
			System.out.println("--------------------------------------------");
		} finally {
			for (Article article : film.getArticles()) {
				System.out.println(article.getDescription(true) + "\n");
			}
			System.out.println("--------------------------------------------");
		}
		try {
			System.out.println("before \n" + inventaire);
			inventaire.finalize();
			System.out.println("after \n" + inventaire);
		} catch (Throwable ex) {
			Logger.getLogger(Inventaire.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
