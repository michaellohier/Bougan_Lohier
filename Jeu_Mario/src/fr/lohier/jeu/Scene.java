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
	
	private ImageIcon icoMario;
	private Image imgMario;

	private int xFond1;
	
	public Scene(){		
		
		super();
		
		this.xFond1 = -50;
		
		this.icoFond = new ImageIcon(getClass().getResource("Images/fondEcran"));
		this.imgFond1 = this.icoFond.getImage();
		
		this.icoMario = new ImageIcon(getClass().getResource("Images/marioMarcheDroite"));
		this.imgMario = this.icoMario.getImage();
		}


	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;
		
		g2.drawImage(this.imgFond1, this.xFond1, 0, null);
		g2.drawImage(this.imgMario, 300, 245, null);

	}
	
}

	
