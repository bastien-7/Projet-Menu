import java.awt.Color;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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
		//j.add(i);
		//j.add(sousMenu);
		//j.add(i3);
		//j2.add(i4);
		JMenuB.add(j);
		JMenuB.add(j2);
		frame.setJMenuBar(JMenuB);
		frame.add(itemSelect);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
