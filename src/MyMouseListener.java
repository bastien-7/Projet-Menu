import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class MyMouseListener implements MouseInputListener{
	private BublingMenu bMenu;
	private JMenuItem item;
	private JPanel panel;
	
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
		bMenu.setBounds(e.getX()+(item.getX()-panel.getX())-100/2, e.getY()+(item.getY()-panel.getY())+16-100/2, 100, 100);
//		bMenu.setMousePos(e.getX()-(panel.getX()), e.getY()-JMenuB.getHeight());
		bMenu.repaint();
	}

}
