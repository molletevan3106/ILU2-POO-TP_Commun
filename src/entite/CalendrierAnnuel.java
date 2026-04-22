package entite;

public class CalendrierAnnuel {

	private Mois[] calendrier;

	public CalendrierAnnuel() {
		this.calendrier = new Mois[12];
		calendrier[0]= new Mois("janvier", 31);
		calendrier[1]= new Mois("février", 28);
		calendrier[2]= new Mois("mars", 31);
		calendrier[3]= new Mois("avril", 30);
		calendrier[4]= new Mois("mai", 31);
		calendrier[5]= new Mois("juin", 30);
		calendrier[6]= new Mois("juillet", 31);
		calendrier[7]= new Mois("aout", 31);
		calendrier[8]= new Mois("septembre", 30);
		calendrier[9]= new Mois("octobre", 31);
		calendrier[10]= new Mois("novembre", 30);
		calendrier[11]= new Mois("decembre", 31);
	}
	private static class Mois {
		private String nom;
		private boolean[] jours;

		private Mois(String nom, int nbJours) {
			this.nom = nom;
			this.jours = new boolean[nbJours];
		}

		private boolean estLibre(int jour) {
			return (jour >= 1 && jour <= jours.length && !jours[jour - 1]);
		}

		private void reserver(int jour) {
			if (!estLibre(jour)) {
				throw new IllegalStateException("Le jour " + jour + " du mois " + nom + " est déjà réservé.");
			}
			jours[jour-1] = true;
		}
	}

	public boolean estLibre(int jour, int mois) {
		boolean libre=false;
		if (mois<=12&&mois>=1) {
			libre=calendrier[mois-1].estLibre(jour);
		}
		return libre;
	}
	public boolean reserver(int jour, int mois) {
		if (mois<=12&&mois>=1) {
			try {
	            calendrier[mois - 1].reserver(jour);
	            return true;
	        } catch (IllegalStateException e) {
	            return false;
	        }
		}
		return false;
	}
}
