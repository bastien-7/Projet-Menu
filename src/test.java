import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class test {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(600, 800);
		JMenuBar JMenuB = new JMenuBar();
		JMenu j = new JMenu("Menu 1");
		JMenu j2 = new JMenu("Menu 2");
		JMenu sousMenu = new JMenu("SousMenu 1");
		
		JMenuItem i = new JMenuItem("item1");
		
		JMenuItem i2 = new JMenuItem("item 2");

		j.add(i);
		j.add(sousMenu);
		sousMenu.add(i2);
		JMenuB.add(j);
		JMenuB.add(j2);
		frame.setJMenuBar(JMenuB);
		frame.setVisible(true);
	}
	
}
