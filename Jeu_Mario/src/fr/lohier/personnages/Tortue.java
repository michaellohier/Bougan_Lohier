package fr.lohier.personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

import fr.lohier.objets.Objet;

public class Tortue extends Personnage implements Runnable{
	//**** VARIABLES ****//
	private final int PAUSE = 15; // temps d'attente en ms entre 2 tours de boucle
	private int dxTortue;	
	private Image imgTortue;
	private ImageIcon icoTortue;


	//**** CONSTRUCTEUR	****//
	public Tortue(int x, int y) {		
		super(x, y, 27, 30);
		super.setVersDroite(true);
		super.setMarche(true);	
		this.dxTortue = 1;
		icoTortue = new ImageIcon(getClass().getResource("/images/tortueArretDroite.png"));
		imgTortue = icoTortue.getImage();
		Thread chronoTortue = new Thread(this);
		chronoTortue.start();

	}


	//**** GETTERS ****//		
	public Image getImgTortue() {return imgTortue;}


	//**** METHODES ****//	

	@Override
	public void run() {		
		try{Thread.sleep(20);} // on attend 20 ms avant d'appeler bouge pour que tous les objets soient compl�tement cr��s
		catch (InterruptedException e){}				
		while(true){ // boucle infinie
			if(this.vivant) {
				this.bouge();
				try{Thread.sleep(PAUSE);}
				catch (InterruptedException e){}
			}		
		}
	}

	public void contact(Objet objet) {			
		if(super.contactAvant(objet) == true && this.isVersDroite() == true){					
			super.setVersDroite(false);
			this.dxTortue = -1; 
		}else if(super.contactArriere(objet) == true && this.isVersDroite() == false){
			super.setVersDroite(true);
			this.dxTortue = 1;     
		}	
	}

	public void contact(Personnage personnage) {			
		if(super.contactAvant(personnage) == true && this.isVersDroite() == true){					
			super.setVersDroite(false);
			this.dxTortue = -1; 
		}else if(super.contactArriere(personnage) == true && this.isVersDroite() == false){
			super.setVersDroite(true);
			this.dxTortue = 1;     
		}	
	}

	public void bouge(){ // Deplacement du Tortue
		if(super.isVersDroite() == true){this.dxTortue = 1;}
		else{this.dxTortue = -1;}
		super.setX(super.getX() + this.dxTortue);
	}

	public Image meurt(){		
		String str;	
		ImageIcon ico;
		Image img;

		str = "/images/tortueFermee.png";	
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}




}
