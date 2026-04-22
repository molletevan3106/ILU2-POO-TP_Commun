package entite;

public class ReservationHotel extends Reservation {
	private int nbLitSimple;
    private int nbLitDouble;
    private int numChambre;

    public ReservationHotel(int jour, int mois, int nbLitSimple, int nbLitDouble, int numChambre) {
        super(jour, mois);
        this.nbLitSimple = nbLitSimple;
        this.nbLitDouble = nbLitDouble;
        this.numChambre = numChambre;
    }
    @Override
    public String toString() {
        return "Le " + getJour() + "/" + getMois() + " : chambre n°" + numChambre + 
               " avec " + nbLitSimple + " lit(s) simple(s) et " + nbLitDouble + " lit(s) double(s).";
    }
}

