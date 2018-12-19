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
	private BublingMenu bMenu;
	private JComponent item;
	private JPanel panel;
	private Vector<JComponent> menusFavoris;
	private JComponent closer;

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
			if (this.closer instanceof JMenu) {
				((JMenu) this.closer).doClick();
			} else if (this.closer instanceof JMenuItem) {
				((JMenuItem) this.closer).doClick();
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {

		JComponent closer = null;
		double minDist = -1;
		for (JComponent c : menusFavoris) {
			if (c.isShowing()) {
				double dist = c.getLocation().distance(e.getX() - c.getWidth() / 2, e.getY() - c.getHeight() / 2);
				if (minDist == -1) {
					minDist = dist;
					closer = c;
				} else if (dist < minDist) {
					minDist = dist;
					closer = c;
				}
			}
			changeCloser(closer);
			bMenu.setBounds(e.getX() - (int) minDist, e.getY() - (int) minDist, (int) (minDist * 2),
					(int) (minDist * 2));
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
	public void mouseMoved(MouseEvent e) {
		Point mouse = e.getPoint();
		if (this.item != null && panel != null) {
			mouse = SwingUtilities.convertPoint(item, e.getX(), e.getY(), panel);
		}
		JComponent closer = null;
		double minDist = -1;
		for (JComponent c : menusFavoris) {
			if (c.isShowing()) {
				double dist;

				Point comp = c.getLocationOnScreen();
				comp.x += c.getWidth() / 2;
				comp.y += c.getHeight() / 2;
				SwingUtilities.convertPointFromScreen(comp, panel);
				dist = comp.distance(mouse);
				if (minDist == -1) {
					minDist = dist;
					closer = c;
				} else if (dist < minDist) {
					minDist = dist;
					closer = c;
				}
			}
		}
		changeCloser(closer);
		bMenu.setBounds((int) mouse.getX() - (int) minDist, (int) mouse.getY() - (int) minDist, (int) minDist * 2,
				(int) minDist * 2);
		bMenu.repaint();
	}

	private void changeCloser(JComponent newCloser) {
		if (this.closer != null) {
			this.closer.setOpaque(true);
			this.closer.setBackground(Color.GRAY);
		}
		this.closer = newCloser;
		this.closer.setBackground(Color.BLUE);
	}

}
