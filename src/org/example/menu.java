package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class menu extends JFrame implements MouseListener {
	JLabel l1, l30;
	JPanel p1, p2, p3,p4,p5,p6;
	ImageIcon img20;
	ImageIcon back = new ImageIcon(Objects.requireNonNull(menu.class.getResource("back1.png")));


	public menu() {
		this.setTitle("Show Menu");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1300, 900);
		this.setLocation(250, 100);
		this.getContentPane().setBackground(new Color(28, 28, 28));
		this.setLayout(null);

		img20 = new ImageIcon(Objects.requireNonNull(menu.class.getResource("Foodflow logo.png")));
		this.setIconImage(img20.getImage());

		l1 = new JLabel("Our Foodflow Menu");
		l1.setFont(new Font("Monotype Corsiva", Font.BOLD, 60));
		l1.setForeground(Color.white);
		l1.setBounds(350, 10, 2000, 100);
		this.add(l1);

		l30 = new JLabel();
		l30.setIcon(back);
		l30.setBounds(40, 30, 40, 40);
		l30.addMouseListener(this);
		this.add(l30);

		// Panels for tables
		p1 = createCategoryPanel("Hor's D'eouvre", 50, 140);
		p2 = createCategoryPanel("Soup", 480, 140);
		p3 = createCategoryPanel("Drinks", 930, 140);
		p4 = createCategoryPanel("Appetizer", 50, 500);
		p5 = createCategoryPanel("Salad", 480, 500);
		p6 = createCategoryPanel("Main Course", 930, 500);

		// Add tables
		String[][] mainDishData = {
				{"Small Skewers", "100/-"},
				{"Meatballs", "100/-"},
				{"Wrapped Hor's D'euvre", "100/-"},
				{"Filled Dough", "100/-"},
				{"Canapes", "100/-"},
				{"Crudites", "100/-"},
		};
		addTableToPanel(p1, mainDishData);

		String[][] fastFoodData = {
				{"Scallop Bisque", "120/-"},
				{"Chicken Soup", "180/-"},
				{"Seafood Soup", "160/-"},
				{"Bone Broth Soup", "125/-"},
				{"Thai Soup", "110/-"},
				{"Cream Mushroom Soup", "150/-"},
		};
		addTableToPanel(p2, fastFoodData);

		String[][] drinksData = {
				{"Tea", "100/-"},
				{"Coffee Milkshake", "100/-"},
				{"Kombucha", "100/-"},
				{"Ginger Beer", "100/-"},
				{"Punch", "100/-"},
				{"Lemonade", "100/-"},
		};
		addTableToPanel(p3, drinksData);

		String[][] AppetizerData = {
				{"Stuffed Mushroom", "100/-"},
				{"Prawn Cocktails", "100/-"},
				{"Bruschetta", "100/-"},
				{"Crostini", "100/-"},
				{"Deviles Egg", "100/-"},
				{"Cheese Puffs", "100/-"},
		};
		addTableToPanel(p4, AppetizerData);

		String[][] SaladData = {
				{"Green Salad", "100/-"},
				{"Salmon Salad", "100/-"},
				{"Pasta Salad", "100/-"},
				{"Seafood Salad", "100/-"},
				{"Vagetable Salad", "100/-"},
				{"Potato Salad", "100/-"},
		};
		addTableToPanel(p5, SaladData);

		String[][] MainCourseData = {
				{"Chicken Tacos", "100/-"},
				{"Lasagna", "100/-"},
				{"Butter Chicken", "100/-"},
				{"Crab Cake", "100/-"},
				{"Biriyani", "100/-"},
				{"Grilled Steak", "100/-"},
		};
		addTableToPanel(p6, MainCourseData);

		this.add(p1);
		this.add(p2);
		this.add(p3);
		this.add(p4);
		this.add(p5);
		this.add(p6);
	}

	private JPanel createCategoryPanel(String title, int x, int y) {
		JPanel panel = new JPanel();
		panel.setBounds(x, y, 300, 300);
		panel.setBackground(new Color(140, 140, 140));
		panel.setLayout(new BorderLayout());

		JLabel label = new JLabel(title);
		label.setFont(new Font("Arial", Font.BOLD, 25));
		label.setForeground(Color.black);
		label.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label, BorderLayout.NORTH);

		return panel;
	}

	private void addTableToPanel(JPanel panel, String[][] data) {
		String[] columns = {"Item", "Price"};
		DefaultTableModel model = new DefaultTableModel(data, columns) {
			public boolean isCellEditable(int row, int column) {
				return false; // table read-only
			}
		};
		JTable table = new JTable(model);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setRowHeight(40);
		JScrollPane scroll = new JScrollPane(table);
		panel.add(scroll, BorderLayout.CENTER);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == l30) {
			user u = new user();
			this.setVisible(false);
			u.setVisible(true);
		}
	}

	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

	public static void main(String[] args) {
		menu form = new menu();
		form.setVisible(true);
	}
}
