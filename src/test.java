import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class test {

	public static void main(String[] args) {

		BublingMenu bMenu = new BublingMenu(50, 50);

		JFrame frame = new JFrame();
		frame.setSize(600, 800);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		JLayeredPane jLPane = new JLayeredPane();

		JMenuBar jMenuB = new JMenuBar();
		JMenu j = new JMenu("Menu 1");
		JMenu j2 = new JMenu("Menu 2");
		JMenu sousMenu = new JMenu("SousMenu 1");

		JMenuItem i = new JMenuItem("Jaune");
		JMenuItem h = new JMenuItem("Bleu");

		JMenuItem i2 = new JMenuItem("item 2");

		j.add(i);
		j.add(h);
		j.add(sousMenu);
		sousMenu.add(i2);
		jMenuB.add(j);
		jMenuB.add(j2);
		panel.add(jMenuB, BorderLayout.NORTH);
		panel.setBounds(0, 0, 600, 800);

		bMenu.setBounds(0, 0, 600, 800);

		jLPane.add(panel, JLayeredPane.DEFAULT_LAYER);
		jLPane.add(bMenu, JLayeredPane.POPUP_LAYER);

		frame.add(jLPane);
		frame.setVisible(true);

		MouseInputListener mil = new MouseInputListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				bMenu.setMousePos(e.getX(), e.getY());
				bMenu.repaint();
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Stub de la méthode généré automatiquement

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Stub de la méthode généré automatiquement

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Stub de la méthode généré automatiquement

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Stub de la méthode généré automatiquement

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Stub de la méthode généré automatiquement

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Stub de la méthode généré automatiquement

			}
		};

		frame.addMouseMotionListener(mil);
		j.addMouseMotionListener(mil);
		i.addMouseMotionListener(mil);
//		while(true) {
//			System.out.println("Pos x : "+i.getX()+ "Pos Y:"+i.getY());
//			System.out.println("Pos x : "+h.getX()+ "Pos Y:"+h.getY());
//
//			
//		}
	}

}
