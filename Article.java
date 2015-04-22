package tpyak;

/**
 *
 * @author Atef
 */
public abstract class Article {

	private static int noArticle = 1;
	private int noInventaire;
	private Film film = null;
	private Adherent emprunteur = null;

	protected Article(Film film) {
		this.film = film;
		noInventaire = noArticle;
		noArticle++;
	}

	public Film getFilm() {
		return film;
	}

	public Adherent getEmprunteur() {
		return emprunteur;
	}

	public void setEmprunteur(Adherent adherent) {
		this.emprunteur = adherent;
	}

	public String getDescription(boolean complete) {
		String s = "";
		s += String.format("Numéro d’inventaire : %d\n", noInventaire);
		if (complete) {
			s += String.format("Titre du film : %s\n", film != null ? film.getTitre() : "");
			s += String.format("Réalisateur : %s %s\n", film != null ? film.getRealisateur().getNom() : "", film != null ? film.getRealisateur().getPrenom() : "");
		}
		s += String.format("Nouveauté : %s\n", film.isNouveaute() ? "oui" : "non");
		s += String.format("%s\n", emprunteur == null ? "Disponible" : String.format("Emprunté par le membre n° : %d", emprunteur.getNoAdherent()));
		return s;
	}

	public abstract double tarifLocation();

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public int getNumeroInventaire() {
		return noInventaire;
	}

	public void setNoInventaire(int noInventaire) {
		this.noInventaire = noInventaire;
	}

}
