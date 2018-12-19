import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Programme {

	public static void main(String[] args) {
		Vector<JComponent> menusFavoris = new Vector<>(); //Liste des menus favoris entrés à la main.

		JFrame frame = new JFrame(); //fenetre
		frame.setSize(800, 800); //taille de la fenetre fixe
		JMenuBar JMenuB = new JMenuBar(); //barre de menu
		JMenuB.setLayout(new GridBagLayout()); // pour pouvoir avoir les menus au centre

		JMenu j = new JMenu("Menu 1"); 
		menusFavoris.add(j); //on ajoute le menu 1 aux menus favoris
		JMenu j2 = new JMenu("Menu 2");
		menusFavoris.add(j2); //on ajoute le menu 2 aux menus favoris
		JMenu sousMenu = new JMenu("SousMenu 1");

		JLabel itemSelect2 = new JLabel("Aucun item selectionné"); //ce champ sert à savoir quel item nous avons sélectionné en dernier (pour voir ou vont les clics)

		BublingMenu bMenu = new BublingMenu(50, 50); //création du bubling menu

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(JMenuB, BorderLayout.NORTH); //on ajoute la barre de menu au jpanel
		panel.setBounds(0, 0, 700, 700); //definition d'une taille de jpanel

		bMenu.setBounds(0, 0, 100, 100); //définition d'une taille de bubble menu (le bubble menu est toujours dessiné de la taille de ses bounds)

		for (int l = 0; l < 15; l++) { //création du premier menu
			JMenuItem i = new JMenuItem("item " + l);
			switch (l) {
			case 3: //3eme item
				j.add(i); //ajout de l'item 3 au menu
				menusFavoris.add(i); //ajout de l'item 3 au menus favoris
				break;
			case 11: //11eme item - le sous menu
				JMenu fav2 = new JMenu("Sous menu 1"); // création du sous menu
				fav2.addMouseMotionListener(new MyMouseListener(bMenu, fav2, panel, menusFavoris)); //ajout du motion listener au sous menu (pour que le bubble menu suivent quand notre curseur est dans le menu.)
				JMenuItem smi1 = new JMenuItem("SSItem 1"); //création du sous item 1
				smi1.addMouseMotionListener(new MyMouseListener(bMenu, smi1, panel, menusFavoris)); //ajout du motion listener au sous menu (pour que le bubble menu suivent quand notre curseur est dans le menu.)
				JMenuItem smi2 = new JMenuItem("SSItem 2"); // création du sous item2
				smi2.addMouseMotionListener(new MyMouseListener(bMenu, smi2, panel, menusFavoris)); //ajout du motion listener au sous menu (pour que le bubble menu suivent quand notre curseur est dans le menu.)

				smi1.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) { //action quand on clique sur un item du menu.
						itemSelect2.setText(smi1.getText());
					}
				});
				smi2.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) { //action quand on clique sur un item du menu.
						itemSelect2.setText(smi2.getText());
					}
				});

				fav2.add(smi1); //ajout des sous items au sous menu
				fav2.add(smi2);
				j.add(fav2); //ajout du sous menu au menu 1

				menusFavoris.add(fav2); //ajout du sous menu aux menus favoris
				menusFavoris.add(smi1); //ajout du sous item aux menus favoris
				break;
			default: //cas par défaut
				j.add(i); //ajout de l'item au menu
				break;
			}
			i.addMouseMotionListener(new MyMouseListener(bMenu, i, panel, menusFavoris)); //ajout du motion listener au menu (pour que le bubble menu suivent quand notre curseur est dans le menu.)
			i.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) { //action quand on clique sur un item du menu.
					itemSelect2.setText(i.getText());
				}
			});

			i.addMouseListener(new MyMouseListener(bMenu, i, panel, menusFavoris)); //ajout du listener au menu (pour que le bubble menu suivent quand notre curseur est dans le menu.)
		}

		for (int l = 0; l < 15; l++) { //création du second menu
			JMenuItem i = new JMenuItem("item " + l);
			switch (l) {
			case 3: //3eme item
				j2.add(i); //ajout de l'item 3 au menu
				menusFavoris.add(i); //ajout de l'item 3 au menus favoris
				break; 
			case 11: //11eme item - le sous menu
				JMenu fav2 = new JMenu("Sous menu 1"); // création du sous menu
				JMenuItem smi1 = new JMenuItem("SSItem 1"); //création du sous item 1
				smi1.addMouseMotionListener(new MyMouseListener(bMenu, smi1, panel, menusFavoris)); //ajout du motion listener au sous menu (pour que le bubble menu suivent quand notre curseur est dans le menu.)
				smi1.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) { //action quand on clique sur un item du menu.
						itemSelect2.setText(smi1.getText());
					}
				});
				JMenuItem smi2 = new JMenuItem("SSItem 2"); //création du sous item 2
				smi2.addMouseMotionListener(new MyMouseListener(bMenu, smi2, panel, menusFavoris)); //ajout du motion listener au menu (pour que le bubble menu suivent quand notre curseur est dans le menu.)
				smi2.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) { //action quand on clique sur un item du menu.
						itemSelect2.setText(smi2.getText());
					}
				});
				fav2.add(smi1); //ajout des sous items au sous menu
				fav2.add(smi2);
				j2.add(fav2); //ajout du sous menu au menu 2

				menusFavoris.add(fav2); //ajout du sous menu aux menus favoris
				menusFavoris.add(smi1); //ajout du sous item aux menus favoris
				break;
			default: //cas par défaut
				j2.add(i); //ajout de l'item au menu
				break;
			}
			i.addMouseMotionListener(new MyMouseListener(bMenu, i, panel, menusFavoris)); //ajout du listener au menu (pour que le bubble menu suivent quand notre curseur est dans le menu.)
			i.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) { //action quand on clique sur un item du menu.
					itemSelect2.setText(i.getText());
				}
			}); 
			i.addMouseListener(new MyMouseListener(bMenu, i, panel, menusFavoris)); //ajout du listener au menu (pour que le bubble menu suivent quand notre curseur est dans le menu.)
		}

		for (int k = 0; k < menusFavoris.size(); k++) { //coloration en gris des menus favoris
			menusFavoris.get(k).setOpaque(true);
			menusFavoris.get(k).setBackground(Color.GRAY);
		}

		itemSelect2.setBounds(600, 600, 200, 30); //affichage du texte pour l'item sélectionné
		MyMouseListener mil = new MyMouseListener(bMenu, menusFavoris, panel);
		panel.addMouseListener(mil); //ajout du listener au panel pour pouvoir récupérer les clics sur le panel
		panel.addMouseMotionListener(mil); //ajout du listener au panel pour pouvoir faire bouger le bubble menu avec le curseur sur le panel

		JMenuB.add(j); //ajout du menu 1 à la barre de menu
		JMenuB.add(j2);//ajout du menu 2 à la barre de menu
		frame.add(itemSelect2); //ajout de l'item selectionné à la fenetre
		frame.add(panel); //ajout du panel à la fenetre
		frame.setGlassPane(bMenu); //ajout du bubble menu sur le glasspane de la fenetre (au dessus de tous les autres composants)
		bMenu.setVisible(true); //rendu visible du bubble menu

		frame.setVisible(true); //rendu visible de la fenetre
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //lorsque l'on ferme la fenetre cela kill le processus associé.

	}

}
