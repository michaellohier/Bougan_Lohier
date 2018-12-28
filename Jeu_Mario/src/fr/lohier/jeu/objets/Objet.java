package fr.lohier.jeu.objets;



public class Objet {
	//**** VARIABLES ****//
		private int largeur, hauteur; //dimensions de l'objet
		private int x, y; //position de l'objet	

		//**** CONSTRUCTEUR ****//	
		public Objet(int x, int y, int largeur, int hauteur){		
		    this.x = x;
			this.y = y;
			this.largeur = largeur;
			this.hauteur = hauteur;		
		}
		
		   //**** GETTERS ****//	
	    public int getX() {return x;}

		public int getY() {return y;}

		public int getLargeur() {return largeur;}

		public int getHauteur() {return hauteur;}
		

		//**** SETTERS ****//	
		public void setX(int x) {this.x = x;}

		public void setY(int y) {this.y = y;}

		public void setLarg(int largeur) {this.largeur = largeur;}

		public void setHaut(int hauteur) {this.hauteur = hauteur;}
		
		//**** METHODES ****//
		
		
}
