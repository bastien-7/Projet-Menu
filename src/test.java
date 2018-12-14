import java.awt.Color;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	//public static JLabel itemSelect = new JLabel("Item frappe");

	public static void main(String[] args) {
		Vector<JComponent> menusFavoris = new Vector<>();
		JMenuItem itemSelectionne = null;
		JFrame frame = new JFrame();
		frame.setSize(800, 800);
		JMenuBar JMenuB = new JMenuBar();
		JMenu j = new JMenu("Menu 1");
		menusFavoris.add(j);
		JMenu j2 = new JMenu("Menu 2");
		JMenu sousMenu = new JMenu("SousMenu 1");
		JLabel itemSelect2 = new JLabel("Item frappe");

		
		BublingMenu bMenu = new BublingMenu(50, 50);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());


		panel.add(JMenuB, BorderLayout.NORTH);
		panel.setBounds(0, 0, 800, 800);

		bMenu.setBounds(0, 0, 100, 100);


		for(int l = 0; l<15; l++) {
			JMenuItem i = new JMenuItem("item "+l);
			i.addMouseMotionListener(new MyMouseListener(bMenu, i, panel));
			i.addActionListener(new ActionListener() {
	             
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//System.out.println("hello");
					itemSelect2.setText(i.getText());
					
					//bMenu.repaint();
					
					
				}
	        });
			i.addMouseListener(new MyMouseListener(bMenu, i, panel));
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
			i.addMouseMotionListener(new MyMouseListener(bMenu, i, panel));
			sousMenu.add(i);
		}
		j.addMouseMotionListener(new MyMouseListener(bMenu, j,panel));
		j2.addMouseMotionListener(new MyMouseListener(bMenu, j2,panel));
		JMenuB.addMouseMotionListener(new MyMouseListener(bMenu, menusFavoris));
		sousMenu.addMouseMotionListener(new MyMouseListener(bMenu, sousMenu, panel));


		System.out.println(((JMenuItem)itemSelectionne).getText());
		for(int k = 0 ; k<menusFavoris.size(); k++) {
			menusFavoris.get(k).setOpaque(true);
			menusFavoris.get(k).setBackground(Color.GRAY);
		}

		itemSelect2.setBounds(700,700,100,30);

		frame.addMouseMotionListener(new MyMouseListener(bMenu,menusFavoris));
		JMenuB.add(j);
		JMenuB.add(j2);
		frame.add(itemSelect2);
		frame.add(panel);
		frame.setGlassPane(bMenu);
		bMenu.setVisible(true);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
