package presentacion;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import aplicacion.*;

public class GameGUI extends JPanel{
	
	private FroggerManager manager;
	
	//To Draw
	private Player player1, player2;
	private Collisionable[] collisionables;
	
	//Thread
	private Hilo hilo;

	public GameGUI(int mode, BufferedImage p1Sprite, BufferedImage p2Sprite) {
		Assets.Start();
		manager = new FroggerManager(mode, p1Sprite, p2Sprite);
		toDraw();
		hilo = new Hilo(manager, this);
		hilo.start();
		setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
        super.paintComponent(g);
		g.drawImage(Assets.street, 0, 330, 800, 150, null);
		//Sprites
		for(Collisionable col: collisionables) {
			g.drawImage(col.getSprite(), col.getX(), col.getY(), col.getWidth(), col.getHeight(), null);
		}
		
		//Score & Time & Lives
		g.setColor(Color.white);
		g.setFont(new Font("Serif", Font.BOLD, 30));
		//PLayer1
		g.drawString("Score P1: " + player1.getScore(), 10, 565);
		g.drawString("Lives P1: " + player1.getLives(), 200, 565);
		g.drawString("Ronda: " + (manager.getRonda() +1), 500, 595);
		g.setColor(Color.yellow);
		g.drawString("Time", 710, 565);
		g.setColor(Color.red);
		g.fillRect(700, 538, -300, 30);
		g.setColor(Color.green);
		g.fillRect(700, 538, -300 + manager.getTime(), 30);
		
		//Scenary
		g.drawImage(Assets.finalGrass, 0, -5, 800, 80, null);
	
		//Players
		g.drawImage(player1.getSprite(), player1.getX(), player1.getY(), player1.getWidth(), player1.getHeight(), null);
		if(player2 != null) {
			g.drawImage(player2.getSprite(), player2.getX(), player2.getY(), player2.getWidth(), player2.getHeight(), null);
			g.setColor(Color.green);
			g.drawString("Score P2: " + player2.getScore(), 10, 595);
			g.drawString("Lives P2: " + player2.getLives(), 200, 595);
		}
		
		Toolkit.getDefaultToolkit().sync();
		
	}
	
	public void toDraw() {
		player1 = manager.getPlayerOne();
		player2 = manager.getPlayerTwo();
		collisionables = manager.getCollisionables();
	} 
	
	public void windowSettings(JFrame jFrame) {
		setBackground(Color.black);
		setLayout(null);
		jFrame.setTitle("Frogger Game");
		jFrame.setSize(800,640);
		jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
		jFrame.setLocationRelativeTo(null);
		jFrame.setResizable(false);
		jFrame.add(this);
		jFrame.addKeyListener(new EventosKeyboard());
		jFrame.validate();
		jFrame.dispose();
        jFrame.setVisible(true);
	}
	
	
	
	
	

	//Getters && setters
	public FroggerManager getManager() {
		return manager;
	}

	public void setManager(FroggerManager manager) {
		this.manager = manager;
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public Collisionable[] getCollisionables() {
		return collisionables;
	}

	public void setCollisionables(Collisionable[] collisionables) {
		this.collisionables = collisionables;
	}

	
}
