package entite;

public abstract class EntiteReservable<T extends Formulaire> {
	private CalendrierAnnuel calendrier = new CalendrierAnnuel();
	private int identification;

	public int getIdentification() {
		return identification;
	}

	public void setIdentification(int identification) {
		this.identification = identification;
	}

	public boolean estLibre(T formulaire) {
		return calendrier.estLibre(formulaire.getJour(), formulaire.getMois());
	}

	public abstract boolean compatible(T formulaire);

	public abstract Reservation reserver(T formulaire);

	protected CalendrierAnnuel getCalendrier() {
		return calendrier;
	}
}