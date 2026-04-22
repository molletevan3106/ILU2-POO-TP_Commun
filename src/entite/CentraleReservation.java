package entite;

public class CentraleReservation<T extends EntiteReservable<F>, F extends Formulaire> {
	private T[] listeEntites;
	private int nbEntites;

	public CentraleReservation(T[] listeEntites) {
		this.listeEntites = listeEntites;
		this.nbEntites = 0;
	}

	public int ajouterEntite(T entite) {
		int numero = nbEntites + 1;
		entite.setIdentification(numero);
		listeEntites[nbEntites] = entite;
		nbEntites++;
		return numero;
	}

	public int[] donnerPossibilites(F formulaire) {
		int[] possibilites = new int[nbEntites];
		for (int i = 0; i < nbEntites; i++) {
			if (listeEntites[i].compatible(formulaire) && listeEntites[i].estLibre(formulaire)) {
				possibilites[i] = listeEntites[i].getIdentification();
			} else {
				possibilites[i] = 0;
			}
		}
		return possibilites;
	}

	public Reservation reserver(int numeroEntite, F formulaire) {

		T entite = listeEntites[numeroEntite - 1];

		formulaire.setIdentificationEntite(numeroEntite);

		return entite.reserver(formulaire);
	}
}