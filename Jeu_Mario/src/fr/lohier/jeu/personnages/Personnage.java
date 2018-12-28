package fr.lohier.jeu.personnages;

public class Personnage {
	//**** VARIABLES ****//
		private int largeur, hauteur; //dimensions du personnage
		private int x, y; //position du personnage	
		protected boolean marche; // vrai quand le personnage marche
		protected boolean versDroite; // vrai quand le personnage est tourn� vers la droite
		public int compteur; // compteur des pas du personnage
		protected boolean vivant; //vrai quand le personnage est vivant
		public int compteurMort; //utilis� lorsque le personnage meurt
		
		
		//**** CONSTRUCTEUR ****//
		public Personnage(int x, int y, int largeur, int hauteur){				
			this.x = x;
			this.y = y;
			this.largeur = largeur;
			this.hauteur = hauteur;		
			this.compteur = 0;
			this.vivant = true;
			this.compteurMort = 0;
		}


		//**** GETTERS ****//	
		public int getX() {return x;}

		public int getY() {return y;}

	    public int getLargeur() {return largeur;}
	    
		public int getHauteur() {return hauteur;}

		public boolean isMarche() {return marche;}

		public boolean isVersDroite() {return versDroite;}

		public int getCompteur() {return compteur;}
			
		public boolean isVivant() {return vivant;}

		public int getCompteurMort() {return compteurMort;}
		
		
		//**** SETTERS ****//	
		public void setX(int x) {this.x = x;}

		public void setY(int y) {this.y = y;}
		
		public void setLargeur(int largeur) {this.largeur = largeur;}

		public void setHauteur(int hauteur) {this.hauteur = hauteur;}
		
		public void setMarche(boolean marche) {this.marche = marche;}
		
		public void setVersDroite(boolean versDroite) {this.versDroite = versDroite;}

		public void setCompteur(int compteur) {this.compteur = compteur;}
		
		public void setVivant(boolean vivant) {this.vivant = vivant;}
		
		public void setCompteurMort(int compteurMort) {this.compteurMort = compteurMort;}


}
