package tpyak;

import java.util.ArrayList;

/**
 *
 * @author Atef
 */
public class Realisateur {
	
	private String nom;
	private String prenom;
	private ArrayList<Film> films = new ArrayList<Film>();

	public Realisateur(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public void AddFilm(Film film) {
		films.add(film);
	}
	
	public ArrayList<Film> films() {
		return films;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

}
