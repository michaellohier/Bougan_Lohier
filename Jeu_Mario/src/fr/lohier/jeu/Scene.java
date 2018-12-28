package fr.lohier.jeu;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Scene extends JPanel{
	private ImageIcon icoFond;
	private Image imgFond1;
	private Image imgFond2;

	
	private ImageIcon icoMario;
	private Image imgMario;

	private int xFond1;
	private int xFond2;
	private int dx;
	
	public Scene(){		
		
		super();
		
		
		this.dx = 0;
		this.xFond1 = -50;
		this.xFond2 = 750;

		
		icoFond = new ImageIcon(getClass().getResource("/Images/fondEcran.png"));
		this.imgFond1 = this.icoFond.getImage();
		this.imgFond2 = this.icoFond.getImage();
		icoMario = new ImageIcon(getClass().getResource("/Images/marioMarcheDroite.png"));
		this.imgMario = this.icoMario.getImage();
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Clavier());
		
		Thread chronoEcran = new Thread(new Chrono());
		chronoEcran.start();
		}	
	
	
	
	public void deplacementFond() {
		this.xFond1 = this.xFond1 - this.dx;
		this.xFond2 = this.xFond2 - this.dx;
		
		if (this.xFond1 == -800){this.xFond1 = 800;}
		else if (this.xFond2 == -800){this.xFond2 = 800;}
		else if (this.xFond1 == 800){this.xFond1 = -800;}
		else if (this.xFond2 == 800){this.xFond2 = -800;}
	}


	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;
		
		this.deplacementFond();
		
		g2.drawImage(this.imgFond1, this.xFond1, 0, null);
		g2.drawImage(this.imgFond2, this.xFond2, 0, null);
		g2.drawImage(this.imgMario, 300, 245, null);

	}

	//**** GETTERS ****//	

	public int getDx() {
		return dx;
	}

	
	//**** SETTERS ****//	

	public void setDx(int dx) {
		this.dx = dx;
	}
	
}

	
