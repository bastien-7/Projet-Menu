import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class MyMouseListener implements MouseInputListener{
	private BublingMenu bMenu;
	private JMenuItem item;
	private JPanel panel;
	private Vector<JComponent> menusFavoris;
	
	public MyMouseListener(BublingMenu bMenu, Vector<JComponent> menusFavoris) {
		// TODO Auto-generated constructor stub
		this.bMenu = bMenu;
		this.menusFavoris = menusFavoris;
	}
	
	public MyMouseListener(BublingMenu bMenu, JMenuItem item, JPanel panel) {
		// TODO Auto-generated constructor stub
		this.bMenu = bMenu;
		this.item = item;
		this.panel = panel;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		if(this.item != null && this.panel != null) {
			bMenu.setBounds(e.getX()+(int)item.getLocation().getX()-100/2, e.getY()+(int)item.getLocation().getY()+16-100/2, 100, 100);
		}else {
			JComponent closer;
			double minDist=-1;
			for(JComponent c : menusFavoris) {
				if(c.isVisible()) {
					double dist = c.getLocation().distance(e.getX(), e.getY());
					if(minDist==-1) {
						minDist = dist;
						closer = c;
					}else if(dist < minDist) {
						minDist = dist;
						closer = c;
					}
				}
			}
			
			bMenu.setBounds(e.getX()-(int)minDist/2, e.getY()-32-(int)minDist/2, (int)minDist, (int)minDist);
		}
		//		bMenu.setMousePos(e.getX()-(panel.getX()), e.getY()-JMenuB.getHeight());
		bMenu.repaint();
	}

}
