package entite;

public class Table extends EntiteReservable<FormulaireRestaurant> {

	@Override
	public boolean compatible(FormulaireRestaurant formulaire) {
		return true;
	}

	@Override
	public Reservation reserver(FormulaireRestaurant formulaire) {
		if (compatible(formulaire) && estLibre(formulaire)) {
			getCalendrier().reserver(formulaire.getJour(), formulaire.getMois());
			return new ReservationRestaurant(formulaire.getJour(), formulaire.getMois(), formulaire.getNumService(),
					getIdentification());
		}
		return null;
	}
}