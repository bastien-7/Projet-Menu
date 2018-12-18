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
		panel.setBounds(0, 0, 700, 700);

		bMenu.setBounds(0, 0, 100, 100);

		JMenuItem fav1 = new JMenuItem("item 3");
		fav1.addActionListener(new ActionListener() {
            
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println("hello");
				itemSelect2.setText(fav1.getText());
				
				//bMenu.repaint();
				
				
			}
       });
		JMenuItem fav2 = new JMenuItem("item 11");
		fav2.addActionListener(new ActionListener() {
            
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println("hello");
				itemSelect2.setText(fav2.getText());
				
				//bMenu.repaint();
				
				
			}
       });
		
		


		for(int l = 0; l<15; l++) {
			JMenuItem i = new JMenuItem("item "+l);
			switch(l) {
			case 3:
				//j.add(fav1);
				j.add(i);
				menusFavoris.add(i);
				break;
			case 11:
				//j.add(fav2);
				j.add(i);
				menusFavoris.add(i);
				break;
			default:
				j.add(i);
				break;
			}
			i.addMouseMotionListener(new MyMouseListener(bMenu, i, panel, menusFavoris,21));
			i.addActionListener(new ActionListener() {
	             
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//System.out.println("hello");
					itemSelect2.setText(i.getText());
					
					//bMenu.repaint();
					
					
				}
	        });
			i.addMouseListener(new MyMouseListener(bMenu, i, panel, menusFavoris,21));
			
			
//			if (l == 3 || l == 11 || l == 7) {
//				j.add(fav1);
//				j.add(fav2);
//			} else {
//				j.add(i);
//			}
		}

		/*menusFavoris.add(fav1);
		menusFavoris.add(fav2);
		
		fav1.addMouseMotionListener(new MyMouseListener(bMenu, fav1, panel, menusFavoris));
		fav2.addMouseMotionListener(new MyMouseListener(bMenu, fav2, panel, menusFavoris));*/

		for (int m = 15; m< 23; m++) {
			JMenuItem i = new JMenuItem("item "+m);
			i.addMouseMotionListener(new MyMouseListener(bMenu, i, panel, menusFavoris,21));
			sousMenu.add(i);
		}
		j.addMouseMotionListener(new MyMouseListener(bMenu, j,panel, menusFavoris,21));
		j2.addMouseMotionListener(new MyMouseListener(bMenu, j2,panel, menusFavoris,21));
		JMenuB.addMouseMotionListener(new MyMouseListener(bMenu, menusFavoris,21));
		sousMenu.addMouseMotionListener(new MyMouseListener(bMenu, sousMenu, panel, menusFavoris,21));


		//System.out.println(((JMenuItem)itemSelectionne).getText());
		for(int k = 0 ; k<menusFavoris.size(); k++) {
			menusFavoris.get(k).setOpaque(true);
			menusFavoris.get(k).setBackground(Color.GRAY);
		}

		itemSelect2.setBounds(600,600,100,30);
		MyMouseListener mil =new MyMouseListener(bMenu,menusFavoris,21); 
		panel.addMouseListener(mil);
		panel.addMouseMotionListener(mil);
		
		
		
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
