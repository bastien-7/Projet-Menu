import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class MyMouseListener implements MouseInputListener{
	private BublingMenu bMenu;
	private JComponent item;
	private JPanel panel;
	private Vector<JComponent> menusFavoris;
	
	public MyMouseListener(BublingMenu bMenu, Vector<JComponent> menusFavoris) {
		// TODO Auto-generated constructor stub
		this.bMenu = bMenu;
		this.menusFavoris = menusFavoris;
	}
	
	public MyMouseListener(BublingMenu bMenu, JComponent item, JPanel panel, Vector<JComponent> menusFavoris) {
		// TODO Auto-generated constructor stub
		this.bMenu = bMenu;
		this.item = item;
		this.panel = panel;
		this.menusFavoris = menusFavoris;
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
			//System.out.println("else");

			JComponent closer = null;
			double minDist=-1;
			System.out.println("------------------");

			System.out.println(menusFavoris);
			for(JComponent c : menusFavoris) {
				if(c.isShowing()) {
					double dist = c.getLocation().distance(e.getX(), e.getY())*2 -c.getHeight() - c.getWidth();
					if(minDist==-1) {
						minDist = dist;
						closer = c;
					}else if(dist < minDist) {
						minDist = dist;
						closer = c;
					}
				}
			
			System.out.println(closer.toString());
			bMenu.setBounds(e.getX()-(int)minDist/2, e.getY()-32-(int)minDist/2, (int)minDist, (int)minDist);
		}
		//		bMenu.setMousePos(e.getX()-(panel.getX()), e.getY()-JMenuB.getHeight());
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
		// TODO Auto-generated method stub
		//System.out.println("echo");
		if(this.item != null && this.panel != null) {
			JComponent closer = null;
			double minDist=-1;
			for(JComponent c : menusFavoris) {
				if(c.isShowing()) {
					double dist = c.getLocation().distance(e.getX()+(int)item.getLocation().getX()-c.getWidth()/2, e.getY()+(int)item.getLocation().getY()- c.getHeight()/2);
					if(minDist==-1) {
						minDist = dist;
						closer = c;
					}else if(dist < minDist) {
						minDist = dist;
						closer = c;
					}
				}
			}
			bMenu.setBounds(e.getX()+(int)item.getLocation().getX()-(int)minDist, e.getY()+(int)item.getLocation().getY()+21-(int)minDist, (int)minDist*2, (int)minDist*2);
			
//			bMenu.setBounds(e.getX()+(int)item.getLocation().getX()-100/2, e.getY()+(int)item.getLocation().getY()+16-100/2, (int)minDist, (int)minDist);
			//System.out.println("if 1");
		}else {
			//System.out.println("else");

			JComponent closer = null;
			double minDist=-1;
			for(JComponent c : menusFavoris) {
				if(c.isShowing()) {
					double distRayon = c.getLocation().distance(e.getX()-c.getWidth()/2, e.getY()-c.getHeight()/2);
					if(minDist==-1) {
						minDist = distRayon;
						closer = c;
					}else if(distRayon < minDist) {
						minDist = distRayon;
						closer = c;
					}
				}
			}
			bMenu.setBounds(e.getX()-(int)minDist, e.getY()-(int)minDist, (int)minDist*2, (int)minDist*2);
		}
		//		bMenu.setMousePos(e.getX()-(panel.getX()), e.getY()-JMenuB.getHeight());
		bMenu.repaint();
	}

}
