import java.awt.Button;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.Console;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputListener;

public class MyMouseListener implements MouseInputListener {
	private BublingMenu bMenu; //bubble menu
	private JComponent item; //item en dessous du curseur
	private JPanel panel; //panel
	private Vector<JComponent> menusFavoris; //liste des menus favoris
	private JComponent closer; //menu favori le plus proche du curseur (celui ou va le bubble)

	public MyMouseListener(BublingMenu bMenu, Vector<JComponent> menusFavoris, JPanel panel) {
		// TODO Auto-generated constructor stub
		this.bMenu = bMenu;
		this.menusFavoris = menusFavoris;
		this.panel = panel;
	}

	public MyMouseListener(BublingMenu bMenu, JComponent item, JPanel panel, Vector<JComponent> menusFavoris) {
		// TODO Auto-generated constructor stub
		this.bMenu = bMenu;
		this.item = item;
		this.menusFavoris = menusFavoris;
		this.panel = panel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getButton() == MouseEvent.BUTTON1) {
			if (this.closer instanceof JMenu) { // si l'item favori le plus proche du curseur est un JMenu (Menu 1 ou Menu 2)
				((JMenu) this.closer).doClick(); //effectue un clic sur le menu favori le plus proche du curseur
			} else if (this.closer instanceof JMenuItem) { // si l'item favori le plus proche du curseur est un JMenuItem (Item 0, 1, 2, 3, 4, ...)
				((JMenuItem) this.closer).doClick(); //effectue un clic sur l'item favori le plus proche du curseur
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) { //On replace ici le bubble menu sur l'item favori et visible le plus proche après un clic.

		JComponent closer = null;
		double minDist = -1;
		for (JComponent c : menusFavoris) { //pour tous les menus et items favoris)
			if (c.isShowing()) { //si l'item est visible (menu ouvert ou non)
				double dist = c.getLocation().distance(e.getX() - c.getWidth() / 2, e.getY() - c.getHeight() / 2); //calcul de la distance
				if (minDist == -1) { //on trouve le min
					minDist = dist;
					closer = c;
				} else if (dist < minDist) {
					minDist = dist;
					closer = c;
				}
			}
			changeCloser(closer); //changement de l'item favoris le plus proche sur celui avec la distance min
			bMenu.setBounds(e.getX() - (int) minDist, e.getY() - (int) minDist, (int) (minDist * 2),
					(int) (minDist * 2)); //on set les bounds du bubble menu en fonction de l'item favori le plus proche (le bubble menu s'affiche dans le max de ses bounds)
		}
		bMenu.repaint();

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) { //quand on bouge la souris
		Point mouse = e.getPoint();
		if (this.item != null && panel != null) {
			mouse = SwingUtilities.convertPoint(item, e.getX(), e.getY(), panel); //permet de convertir la position de la souris dans l'item en la position de la souris dans la frame
		}
		JComponent closer = null;
		double minDist = -1;
		for (JComponent c : menusFavoris) { //pour tous les menus et items favoris)
			if (c.isShowing()) {  //si l'item est visible (menu ouvert ou non)
				double dist;

				Point comp = c.getLocationOnScreen();
				comp.x += c.getWidth() / 2;
				comp.y += c.getHeight() / 2;
				SwingUtilities.convertPointFromScreen(comp, panel); //permet de convertir la position de l'item ou du menu pour avoir sa position réelle dans la frame
				dist = comp.distance(mouse); // calcul de la distance
				if (minDist == -1) { //calcul du plus proche
					minDist = dist;
					closer = c;
				} else if (dist < minDist) {
					minDist = dist;
					closer = c;
				}
			}
		}
		changeCloser(closer); //changement du closer avec celui qui est le plus proche
		bMenu.setBounds((int) mouse.getX() - (int) minDist, (int) mouse.getY() - (int) minDist, (int) minDist * 2,
				(int) minDist * 2); //on set les bounds du bubble menu en fonction de l'item favori le plus proche (le bubble menu s'affiche dans le max de ses bounds)
		bMenu.repaint();
	}

	private void changeCloser(JComponent newCloser) { //methode qui change l'item le plus proche du curseur et change aussi sa couleur.
		if (this.closer != null) {
			this.closer.setOpaque(true);
			this.closer.setBackground(Color.GRAY);
		}
		this.closer = newCloser;
		this.closer.setBackground(Color.BLUE);
	}

}
