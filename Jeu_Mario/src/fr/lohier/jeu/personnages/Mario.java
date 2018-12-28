package fr.lohier.jeu.personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Mario extends Personnage{
	//**** VARIABLES ****//
		private Image imgMario;
		private ImageIcon icoMario;	


		//**** CONSTRUCTEUR	****//	
		public Mario(int x, int y) {
			super(x, y, 28, 50);
			this.icoMario = new ImageIcon(getClass().getResource("/images/marioMarcheDroite.png"));
	        this.imgMario = icoMario.getImage();		

		}

		//**** GETTERS ****//		
		public Image getImgMario() {return imgMario;}
		
}
