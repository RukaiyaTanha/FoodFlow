package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class Order2 extends JFrame implements ActionListener, MouseListener {

	JPanel p1;
	JLabel l2,l3,l6,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19;
	JButton b1,b2,b3,b4,b5,b6, viewCart, confirm;
	Cursor c1;
	ImageIcon img20;
	ImageIcon back = new ImageIcon(Objects.requireNonNull(getClass().getResource("backButton.png")));

	public Order2() {

		super("Soup");
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

		// Back
		l6 = new JLabel(back);
		l6.setBounds(30,30,33,33);
		l6.addMouseListener(this);
		p1.add(l6);

		// Title
		l2 = new JLabel("Soup");
		l2.setBounds(535,30,500,40);
		l2.setFont(new Font("Monotype Corsiva",Font.BOLD,60));
		p1.add(l2);

		l3 = new JLabel("What type Soup would you like to order?");
		l3.setBounds(450,90,500,50);
		l3.setFont(new Font("Monotype Corsiva",Font.PLAIN,30));
		p1.add(l3);

		// View Cart
		viewCart = new JButton("View Cart");
		viewCart.setBounds(1100, 30, 150, 40);
		viewCart.setFont(new Font("Arial", Font.PLAIN, 15));
		viewCart.setCursor(c1);
		viewCart.addActionListener(this);
		p1.add(viewCart);

		// Labels
		l8 = new JLabel("Scallop Bisque"); l8.setBounds(50,510,500,40); l8.setFont(new Font("Monotype Corsiva",Font.BOLD,25)); p1.add(l8);
		l9 = new JLabel("Chicken Soup"); l9.setBounds(280,510,500,40); l9.setFont(new Font("Monotype Corsiva",Font.BOLD,25)); p1.add(l9);
		l10 = new JLabel("Seafood Soup"); l10.setBounds(500,510,500,40); l10.setFont(new Font("Monotype Corsiva",Font.BOLD,25)); p1.add(l10);
		l11 = new JLabel("Bone Broth Soup"); l11.setBounds(700,510,500,40); l11.setFont(new Font("Monotype Corsiva",Font.BOLD,25)); p1.add(l11);
		l12 = new JLabel("Thai Soup"); l12.setBounds(960,510,500,40); l12.setFont(new Font("Monotype Corsiva",Font.BOLD,25)); p1.add(l12);
		l13 = new JLabel("Cream Mushroom Soup"); l13.setBounds(1140,510,500,40); l13.setFont(new Font("Monotype Corsiva",Font.BOLD,20)); p1.add(l13);

		// Prices
		l14 = new JLabel("Price: 100/= "); l14.setBounds(60,540,500,40); l14.setFont(new Font("Monotype Corsiva",Font.BOLD,25)); p1.add(l14);
		l15 = new JLabel("Price: 100/= "); l15.setBounds(280,540,500,40); l15.setFont(new Font("Monotype Corsiva",Font.BOLD,25)); p1.add(l15);
		l16 = new JLabel("Price: 100/= "); l16.setBounds(520,540,500,40); l16.setFont(new Font("Monotype Corsiva",Font.BOLD,25)); p1.add(l16);
		l17 = new JLabel("Price: 100/= "); l17.setBounds(730,540,500,40); l17.setFont(new Font("Monotype Corsiva",Font.BOLD,25)); p1.add(l17);
		l18 = new JLabel("Price: 100/= "); l18.setBounds(950,540,500,40); l18.setFont(new Font("Monotype Corsiva",Font.BOLD,25)); p1.add(l18);
		l19 = new JLabel("Price: 100/= "); l19.setBounds(1170,540,500,40); l19.setFont(new Font("Monotype Corsiva",Font.BOLD,25)); p1.add(l19);

		// Buttons
		b1 = new JButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("scallop (1).jpg"))));
		b1.setBounds(30,200,200,300); b1.setCursor(c1); b1.addActionListener(this); p1.add(b1);

		b2 = new JButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("chicken (1).jpg"))));
		b2.setBounds(250,200,200,300); b2.setCursor(c1); b2.addActionListener(this); p1.add(b2);

		b3 = new JButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("seafood (1).jpg"))));
		b3.setBounds(470,200,200,300); b3.setCursor(c1); b3.addActionListener(this); p1.add(b3);

		b4 = new JButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("bone broth (1).jpg"))));
		b4.setBounds(690,200,200,300); b4.setCursor(c1); b4.addActionListener(this); p1.add(b4);

		b5 = new JButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("thai soup (1).jpg"))));
		b5.setBounds(910,200,200,300); b5.setCursor(c1); b5.addActionListener(this); p1.add(b5);

		b6 = new JButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("cream soup (1).jpg"))));
		b6.setBounds(1130,200,200,300); b6.setCursor(c1); b6.addActionListener(this); p1.add(b6);

		// Confirm
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
			this.setVisible(false);
			new Order().setVisible(true);
		}
	}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}

	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==b1){ Cart.addItem("Scallop Bisque",100); JOptionPane.showMessageDialog(this,"Added Scallop Bisque"); }
		if(e.getSource()==b2){ Cart.addItem("Chicken Soup",100); JOptionPane.showMessageDialog(this,"Added Chicken Soup"); }
		if(e.getSource()==b3){ Cart.addItem("Seafood Soup",100); JOptionPane.showMessageDialog(this,"Added Seafood Soup"); }
		if(e.getSource()==b4){ Cart.addItem("Bone Broth Soup",100); JOptionPane.showMessageDialog(this,"Added Bone Broth Soup"); }
		if(e.getSource()==b5){ Cart.addItem("Thai Soup",100); JOptionPane.showMessageDialog(this,"Added Thai Soup"); }
		if(e.getSource()==b6){ Cart.addItem("Cream Mushroom Soup",100); JOptionPane.showMessageDialog(this,"Added Cream Mushroom Soup"); }

		if(e.getSource()==viewCart){
			new CartView(this).setVisible(true);
		}

		if(e.getSource()==confirm){
			this.setVisible(false);
			new Payment().setVisible(true);
		}
	}

	public static void main(String[] args) {
		new Order2().setVisible(true);
	}
}
