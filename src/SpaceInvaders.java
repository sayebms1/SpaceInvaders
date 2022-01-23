import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SpaceInvaders extends JFrame implements KeyListener{
	JPanel panel;
	int[] invadersX = new int[34];
	int[] invadersY = new int[34];
	int userX = 300;
	int userY = 350;
	int[] invadersMovement = new int[34];
	
	public int initInvaderPos() {
		for(int i=0; i<33; i++) {
			
			invadersX[i] = getRandomNumber(0, 675);
			invadersY[i] = getRandomNumber(0, 545);
		}
		return 0;
	}
	
	public int initInvaderVel() {
		for(int i=0; i<33; i++) {
			
			invadersMovement[i] = 10;
		}
		return 0;
	}
	
	public int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
	public SpaceInvaders() {
		
		super("Space Invaders");
		init();
		setVisible(true);
	}
	
	public void init() {
		
		initInvaderPos();
		initInvaderVel();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		addKeyListener(this);
		panel = new JPanel() {
			
			protected void paintComponent(Graphics g) {
				BufferedImage img;
				try {
					img = ImageIO.read(new File("/Users/sayebms1/eclipse-workspace/SpaceInvadersGame/src/background.jpeg"));
					g.drawImage(img, 0, 0, 700, 600, null); /* Note that 700 stand for y and 600 stands for x dim */
					
					
					for(int i=0; i<=33; i++) {
						
						invadersX[i] += invadersMovement[i];
								
						BufferedImage invader = ImageIO.read(new File("/Users/sayebms1/eclipse-workspace/SpaceInvadersGame/src/invaders.png"));
						if (invadersX[i] <=10) {
							invadersMovement[i] = 10;
						}else if(invadersX[i]>=596) {
							invadersMovement[i] = -10;
						} 
//						invadersX[i] = invadersX[i] + invadersMovement[i];
						g.drawImage(invader, invadersX[i], invadersY[i], 26, 26, null);
					}
				
				BufferedImage user = ImageIO.read(new File("/Users/sayebms1/eclipse-workspace/SpaceInvadersGame/src/bh copy.png"));
				if(userX<=3) {
					userX = 4;
				}else if (userX>=597) {
					userX = 596;
				}
				if(userY<=3) {
					userY=4;
				}else if(userY>=523) {
					userY=522;
				}
				g.drawImage(user, userX, userY, 100, 50, null);
				repaint();
				
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			};
		};
		add(panel);
		setSize(700,600);
	}
	

	
	public static void main(String[] args) {
		new SpaceInvaders();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==37) {
			userX -= 5;
		}else if (e.getKeyCode()==39){
			userX +=5;
		}else if (e.getKeyCode()==40){
			userY +=5;
		}else if (e.getKeyCode()==38) {
			userY -=5;
		}
		repaint();
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
