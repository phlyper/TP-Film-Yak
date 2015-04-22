package tpyak;

/**
 *
 * @author Atef
 */
public class Vhs extends Article {

	TypeVhs type = null;

	public Vhs(Film film, TypeVhs type) {
		super(film);
		this.type = type;
	}

	public TypeVhs getType() {
		return type;
	}

	@Override
	public String getDescription(boolean complete) {
		String s = "";
		s += String.format("VHS (%s)\n", type);
		s += super.getDescription(complete);
		return s;
	}

	@Override
	public double tarifLocation() {
		return 1.5 + (getFilm() != null ? getFilm().isNouveaute() ? 0.5 : 0 : 0);
	}

}
