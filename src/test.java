import java.awt.Color;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
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
		Vector<JMenuItem> menusFavoris = new Vector<>();
		JMenuItem itemSelectionne = null;

		JFrame frame = new JFrame();
		frame.setSize(800, 800);
		JMenuBar JMenuB = new JMenuBar();
		JMenu j = new JMenu("Menu 1");
		JMenu j2 = new JMenu("Menu 2");
		JMenu sousMenu = new JMenu("SousMenu 1");

		for(int l = 0; l<15; l++) {
			JMenuItem i = new JMenuItem("item "+l);
			j.add(i);

			if (l==3 || l==11) {
				menusFavoris.add(i);
				itemSelectionne = i;
			}

			if (l == 7) {
				j.add(sousMenu);
			}
		}

		for (int m = 15; m< 23; m++) {
			JMenuItem i = new JMenuItem("item "+m);
			sousMenu.add(i);
		}



		JLabel itemSelect = new JLabel(itemSelectionne.getText());
		for(int k = 0 ; k<menusFavoris.size(); k++) {
			menusFavoris.get(k).setBackground(Color.GRAY);
		}

		itemSelect.setBounds(700,700,100,30);

		BublingMenu bMenu = new BublingMenu(50, 50);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		JLayeredPane jLPane = new JLayeredPane();

		panel.add(JMenuB, BorderLayout.NORTH);
		panel.setBounds(0, 0, 800, 800);

		bMenu.setBounds(0, 0, 800, 800);

		jLPane.add(panel, JLayeredPane.DEFAULT_LAYER);
		jLPane.add(bMenu, JLayeredPane.POPUP_LAYER);


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
		JMenuB.add(j);
		JMenuB.add(j2);
		frame.add(itemSelect);
		frame.add(jLPane);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
