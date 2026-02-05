package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class Order1 extends JFrame implements ActionListener, MouseListener {
	JPanel p1;
	JLabel l2,l3,l6,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19;
	JButton b1,b2,b3,b4,b5,b6, confirm, viewCart;
	Cursor c1;
	ImageIcon img20;
	ImageIcon back = new ImageIcon(Objects.requireNonNull(Order1.class.getResource("backButton.png")));

	public Order1() {
		super("Hor's Deouvre");
		this.setSize(1380,750);
		this.setLocation(300, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		img20 = new ImageIcon(Objects.requireNonNull(getClass().getResource("Foodflow logo.png")));
		this.setIconImage(img20.getImage());

		c1 = new Cursor(Cursor.HAND_CURSOR);

		p1 = new JPanel();
		p1.setSize(new Dimension(500,500));
		p1.setBackground(Color.white);
		p1.setLayout(null);

		// Back button
		l6 = new JLabel();
		l6.setIcon(back);
		l6.setBounds(30,30,33,33);
		l6.addMouseListener(this);
		p1.add(l6);

		// Title & subtitle
		l2 = new JLabel("Hor's D'eouvre");
		l2.setForeground(Color.black);
		l2.setBounds(535,30,500,40);
		l2.setFont(new Font("Monotype Corsiva",Font.BOLD,60));
		p1.add(l2);

		l3 = new JLabel("What type Hor's D'eouvre would you like to order?");
		l3.setForeground(Color.black);
		l3.setBounds(410,90,550,60);
		l3.setFont(new Font("Monotype Corsiva",Font.PLAIN,30));
		p1.add(l3);

		// View Cart button
		viewCart = new JButton("View Cart");
		viewCart.setBounds(1100, 30, 150, 40);
		viewCart.setFont(new Font("Arial", Font.PLAIN, 15));
		viewCart.setCursor(c1);
		viewCart.addActionListener(this);
		p1.add(viewCart);

		// Item labels
		l8 = new JLabel("Small Skewers"); l8.setBounds(60,510,500,40); l8.setFont(new Font("Monotype Corsiva",Font.BOLD,25)); p1.add(l8);
		l9 = new JLabel("Meatballs"); l9.setBounds(290,510,500,40); l9.setFont(new Font("Monotype Corsiva",Font.BOLD,25)); p1.add(l9);
		l10 = new JLabel("Wrapped Hor's D'euvre"); l10.setBounds(470,510,500,40); l10.setFont(new Font("Monotype Corsiva",Font.BOLD,20)); p1.add(l10);
		l11 = new JLabel("Filled Dough"); l11.setBounds(730,510,500,40); l11.setFont(new Font("Monotype Corsiva",Font.BOLD,25)); p1.add(l11);
		l12 = new JLabel("Canapes"); l12.setBounds(970,510,500,40); l12.setFont(new Font("Monotype Corsiva",Font.BOLD,25)); p1.add(l12);
		l13 = new JLabel("Crudites"); l13.setBounds(1190,510,500,40); l13.setFont(new Font("Monotype Corsiva",Font.BOLD,25)); p1.add(l13);

		// Price labels
		l14 = new JLabel("Price: 500/= "); l14.setBounds(60,540,500,40); l14.setFont(new Font("Monotype Corsiva",Font.BOLD,25)); p1.add(l14);
		l15 = new JLabel("Price: 500/= "); l15.setBounds(280,540,500,40); l15.setFont(new Font("Monotype Corsiva",Font.BOLD,25)); p1.add(l15);
		l16 = new JLabel("Price: 500/= "); l16.setBounds(520,540,500,40); l16.setFont(new Font("Monotype Corsiva",Font.BOLD,25)); p1.add(l16);
		l17 = new JLabel("Price: 500/= "); l17.setBounds(730,540,500,40); l17.setFont(new Font("Monotype Corsiva",Font.BOLD,25)); p1.add(l17);
		l18 = new JLabel("Price: 500/= "); l18.setBounds(950,540,500,40); l18.setFont(new Font("Monotype Corsiva",Font.BOLD,25)); p1.add(l18);
		l19 = new JLabel("Price: 500/= "); l19.setBounds(1170,540,500,40); l19.setFont(new Font("Monotype Corsiva",Font.BOLD,25)); p1.add(l19);

		// Item buttons with price 500 each
		b1 = new JButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("skewers (1).jpg")))); b1.setBounds(30,200,200,300); b1.setCursor(c1); b1.addActionListener(this); p1.add(b1);
		b2 = new JButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("meatballs (1).jpg")))); b2.setBounds(250,200,200,300); b2.setCursor(c1); b2.addActionListener(this); p1.add(b2);
		b3 = new JButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("wrapped (1).jpg")))); b3.setBounds(470,200,200,300); b3.setCursor(c1); b3.addActionListener(this); p1.add(b3);
		b4 = new JButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("dough (1).jpg")))); b4.setBounds(690,200,200,300); b4.setCursor(c1); b4.addActionListener(this); p1.add(b4);
		b5 = new JButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("canapes (1).jpg")))); b5.setBounds(910,200,200,300); b5.setCursor(c1); b5.addActionListener(this); p1.add(b5);
		b6 = new JButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("crudites (1).jpg")))); b6.setBounds(1130,200,200,300); b6.setCursor(c1); b6.addActionListener(this); p1.add(b6);

		// Confirm button
		confirm = new JButton("Confirm");
		confirm.setBounds(1100, 630, 150, 50);
		confirm.setFont(new Font("Arial", Font.BOLD, 15));
		confirm.setCursor(c1);
		confirm.addActionListener(this);
		p1.add(confirm);

		this.add(p1);
	}

	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==l6) {
			Order o = new Order();
			this.setVisible(false);
			o.setVisible(true);
		}
	}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) { if(e.getSource()==l6) l6.setForeground(Color.BLACK); }
	public void mouseExited(MouseEvent e) { if(e.getSource()==l6) l6.setForeground(Color.WHITE); }

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) { Cart.addItem("Small Skewers",500); JOptionPane.showMessageDialog(this,"Added Small Skewers"); }
		if(e.getSource() == b2) { Cart.addItem("Meatballs",500); JOptionPane.showMessageDialog(this,"Added Meatballs"); }
		if(e.getSource() == b3) { Cart.addItem("Wrapped Hor's D'euvre",500); JOptionPane.showMessageDialog(this,"Added Wrapped Hor's D'euvre"); }
		if(e.getSource() == b4) { Cart.addItem("Filled Dough",500); JOptionPane.showMessageDialog(this,"Added Filled Dough"); }
		if(e.getSource() == b5) { Cart.addItem("Canapes",500); JOptionPane.showMessageDialog(this,"Added Canapes"); }
		if(e.getSource() == b6) { Cart.addItem("Crudites",500); JOptionPane.showMessageDialog(this,"Added Crudites"); }

		if(e.getSource() == viewCart) {
			new CartView(this).setVisible(true);
		}

		if(e.getSource() == confirm) {
			Payment p = new Payment();
			this.setVisible(false);
			p.setVisible(true);
		}
	}

	public static void main(String[] args) {
		Order1 form = new Order1();
		form.setVisible(true);
	}
}
