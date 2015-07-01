/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpyak;

/**
 *
 * @author Atef
 */
public class Dvd extends Article {

	private int nbDisques = 1;
	private boolean bonus = false;

	public Dvd(Film film, int nbDisques, boolean bonus) {
		super(film);
		this.nbDisques = nbDisques;
		this.bonus = bonus;
	}

	public boolean hasBonus() {
		return bonus;
	}

	public int getNbDisques() {
		return nbDisques;
	}

	@Override
	public String getDescription(boolean complete) {
		String s = "";
		s += String.format("DVD (%d disque(s)%s)\n", nbDisques, (bonus ? " avec bonus" : ""));
		s += super.getDescription(complete);
		return s;
	}

	@Override
	public double tarifLocation() {
		return 2 + (nbDisques > 1 || bonus ? 0.5 : 0) + (getFilm() != null ? getFilm().isNouveaute() ? 0.75 : 0 : 0);
	}

	@Override
	public void finalize() throws Throwable {
		super.finalize();
		System.out.println(this.getClass().getName()+" Objet nettoyé de la mémoire");
	}
}
