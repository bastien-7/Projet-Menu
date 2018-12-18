import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Vector;

import javax.swing.JComponent;

public class BublingMenu extends JComponent {
	
	private int mousePosX;
	private int mousePosY;
	private Vector<JComponent> favoris;
	
	public BublingMenu() {
		
	}
	
	public BublingMenu(int mousePosX, int mousePosY) {
		this.mousePosX=mousePosX;
		this.mousePosY=mousePosY;
	}

	public void setMousePos(int x, int y) {
		this.mousePosX=x;
		this.mousePosY=y;
	}
	
	public int getMousePosX() {
		return mousePosX;
	}

	public void setMousePosX(int mousePosX) {
		this.mousePosX = mousePosX;
	}

	public int getMousePosY() {
		return mousePosY;
	}

	public void setMousePosY(int mousePosY) {
		this.mousePosY = mousePosY;
	}

	public Vector<JComponent> getFavoris() {
		return favoris;
	}

	public void setFavoris(Vector<JComponent> favoris) {
		this.favoris = favoris;
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(new Color(0, 0, 0, 85));
		Rectangle bound = this.getBounds();
		if (this.getWidth() != 800 && this.getHeight() != 772) { //pour ne pas qu'il dessine le bubble menu en gros au début ou quand on clique sur un item
			g2.fillOval(0, 0, this.getWidth(), this.getHeight());
		}
	}
	
	
	
}
