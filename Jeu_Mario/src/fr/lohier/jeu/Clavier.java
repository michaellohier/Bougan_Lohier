package fr.lohier.jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Clavier implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
        	if(Main.scene.getxPos() == -1){ 
        		Main.scene.setxPos(0);
        		Main.scene.setxFond1(-50);
        		Main.scene.setxFond2(750);
        	}
        	Main.scene.mario.setMarche(true);
        	Main.scene.mario.setVersDroite(true);
			Main.scene.setDx(1);
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			Main.scene.setDx(-1);
	      	Main.scene.mario.setMarche(true);
        	Main.scene.mario.setVersDroite(false);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		Main.scene.mario.setMarche(false);
		Main.scene.setDx(0);
	}

}
