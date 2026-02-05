package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class Order extends JFrame implements ActionListener,MouseListener
{
	JPanel p1;
    JLabel l2,l3,l6,l8,l9,l10,l11,l12,l13;
    JButton b1,b2,b3,b4,b5,b6,viewCart;
	Cursor c1;
	ImageIcon img20;
	ImageIcon back=new ImageIcon(Objects.requireNonNull(getClass().getResource("backButton.png")));

	public Order()
	{
		super("Order");
        this.setSize(1380,750);
		this.setLocation(300, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

        img20 = new ImageIcon(Objects.requireNonNull(getClass().getResource("Foodflow logo.png")));
		this.setIconImage(img20.getImage());

        c1 = new Cursor(Cursor.HAND_CURSOR);

		p1=new JPanel();
        p1.setSize(new Dimension(500,500));
        p1.setBackground(Color.white);
        p1.setLayout(null);

		l6=new JLabel();
		l6.setIcon(back);
		l6.setBounds(30, 30, 33, 33);
		l6.addMouseListener(this);
		p1.add(l6);

		l2=new JLabel();
        l2.setText("Order Food");
        l2.setForeground(Color.black);
        l2.setBounds(535,30,500,40);
        l2.setLayout(null);
        l2.setFont(new Font("Monotype Corsiva",Font.BOLD,60));
        p1.add(l2);

		l3=new JLabel();
        l3.setText("What type food would you like to order?");
        l3.setForeground(Color.black);
        l3.setBounds(450,90,500,50);
        l3.setLayout(null);
        l3.setFont(new Font("Monotype Corsiva",Font.PLAIN,30));
        p1.add(l3);

		viewCart = new JButton("View Cart");
		viewCart.setBounds(1100, 30, 150, 40); // adjust position to fit your layout
		viewCart.setFont(new Font("Arial", Font.PLAIN, 15));
		viewCart.setForeground(Color.BLACK);
		viewCart.setCursor(c1);
		viewCart.addActionListener(this);
		p1.add(viewCart);

		l8=new JLabel();
        l8.setText("Hor's D'eouvre");
        l8.setForeground(Color.black);
        l8.setBounds(60,510,500,40);
        l8.setLayout(null);
        l8.setFont(new Font("Monotype Corsiva",Font.BOLD,25));
        p1.add(l8);

		l9=new JLabel();
        l9.setText("Soup");
        l9.setForeground(Color.black);
        l9.setBounds(320,250,500,40);
        l9.setLayout(null);
        l9.setFont(new Font("Monotype Corsiva",Font.BOLD,25));
        p1.add(l9);

		l10=new JLabel();
        l10.setText("Appetizer");
        l10.setForeground(Color.black);
        l10.setBounds(520,510,500,40);
        l10.setLayout(null);
        l10.setFont(new Font("Monotype Corsiva",Font.BOLD,25));
        p1.add(l10);

		l11=new JLabel();
        l11.setText("Salad");
        l11.setForeground(Color.black);
        l11.setBounds(760,250,500,40);
        l11.setLayout(null);
        l11.setFont(new Font("Monotype Corsiva",Font.BOLD,25));
        p1.add(l11);

		l12=new JLabel();
        l12.setText("Main Course");
        l12.setForeground(Color.black);
        l12.setBounds(940,510,500,40);
        l12.setLayout(null);
        l12.setFont(new Font("Monotype Corsiva",Font.BOLD,25));
        p1.add(l12);

		l13=new JLabel();
        l13.setText("Drinks");
        l13.setForeground(Color.black);
        l13.setBounds(1190,250,500,40);
        l13.setLayout(null);
        l13.setFont(new Font("Monotype Corsiva",Font.BOLD,25));
        p1.add(l13);

		b1 = new JButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("hors (1).jpg"))));
		b1.setBounds(30,200,200,300);
		b1.setCursor(c1);
		b1.addActionListener(this);
		p1.add(b1);

		b2 = new JButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("soup1 (2) (1).jpg"))));
		b2.setBounds(250,300,200,300);
		b2.setCursor(c1);
		b2.addActionListener(this);
		p1.add(b2);

		b3 = new JButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("appetizer (1) (1).jpg"))));
		b3.setBounds(470,200,200,300);
		b3.setCursor(c1);
		b3.addActionListener(this);
		p1.add(b3);

		b4 = new JButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("salad1 (1) (1).jpg"))));
		b4.setBounds(690,300,200,300);
		b4.setCursor(c1);
		b4.addActionListener(this);
		p1.add(b4);

		b5 = new JButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("dish (1) (1).jpg"))));
		b5.setBounds(910,200,200,300);
		b5.setCursor(c1);
		b5.addActionListener(this);
		p1.add(b5);

		b6 = new JButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("drinks (3) (1).jpg"))));
		b6.setBounds(1130,300,200,300);
		b6.setCursor(c1);
		b6.addActionListener(this);
		p1.add(b6);

		this.add(p1);
	}
	 public void mouseClicked(MouseEvent e) {

		if(e.getSource()==l6) {
			user u=new user();
		    this.setVisible(false);
			u.setVisible(true);
		}

	}
	public void mousePressed(MouseEvent e) {

	}
	public void mouseReleased(MouseEvent e) {

	}
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==l6) {
			l6.setForeground(Color.BLACK);
		}

	}
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==l6) {
			l6.setForeground(Color.WHITE);
		}

	}
	 public void actionPerformed(ActionEvent e)
	{
        if(e.getSource()==b1)
	    {
			Order1 o1=new Order1();
		    this.setVisible(false);
			o1.setVisible(true);
	    }
		if(e.getSource()==b2)
	    {
			Order2 o2=new Order2();
		    this.setVisible(false);
			o2.setVisible(true);
	    }
		if(e.getSource()==b3)
	    {
			Order3 o3=new Order3();
		    this.setVisible(false);
			o3.setVisible(true);
	    }
		if(e.getSource()==b4)
	    {
			Order4 o4=new Order4();
		    this.setVisible(false);
			o4.setVisible(true);
	    }
		if(e.getSource()==b5)
	    {
			Order5 o5=new Order5();
		    this.setVisible(false);
			o5.setVisible(true);
	    }
		if(e.getSource()==b6)
	    {
			Order6 o6=new Order6();
		    this.setVisible(false);
			o6.setVisible(true);
	    }
		if(e.getSource() == viewCart) {
			new CartView(this).setVisible(true);
		}

	}
	public static void main(String[]args) {
		Order form=new Order();
		form.setVisible(true);
	}
}