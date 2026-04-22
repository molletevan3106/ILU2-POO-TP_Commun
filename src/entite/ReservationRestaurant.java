package entite;

public class ReservationRestaurant extends Reservation {
	private int numService;
    private int numTable;

    public ReservationRestaurant(int jour, int mois, int numService, int numTable) {
        super(jour, mois);
        this.numService = numService;
        this.numTable = numTable;
    }
    @Override
    public String toString() {
        String service = (numService == 1) ? "premier" : "deuxième";
        return "Le " + getJour() + "/" + getMois() + " : table " + numTable + 
               " pour le " + service + " service.";
    }
}
