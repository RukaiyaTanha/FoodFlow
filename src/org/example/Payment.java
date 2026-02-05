package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class Payment extends JFrame implements ActionListener,MouseListener
{
	JPanel p1;
    JLabel l1,l3,l6;
    JButton b1,b2,b3,b4;
	Cursor c1;
	ImageIcon img20;
	ImageIcon back = new ImageIcon(Objects.requireNonNull(getClass().getResource("backButton.png")));
	ImageIcon payment = new ImageIcon(Objects.requireNonNull(getClass().getResource("payment.jpg")));
	public Payment()
	{
		super("Payment");
		this.setSize(1380,750);
		this.setLocation(300, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(255,255,255));
		
        img20 = new ImageIcon(Objects.requireNonNull(getClass().getResource("Foodflow logo.png")));
		this.setIconImage(img20.getImage());
		
        c1 = new Cursor(Cursor.HAND_CURSOR);
		
		p1=new JPanel();
        p1.setSize(new Dimension(700,1080));
        p1.setBackground(Color.white);
        p1.setLayout(null);
        this.add(p1);
		
		l1=new JLabel();
		l1.setIcon(payment);
		l1.setBounds(750,70,564,564);
		this.add(l1);
		
		l6=new JLabel();
		l6.setIcon(back);
		l6.setBounds(30, 30, 33, 33);
		l6.addMouseListener(this);
		p1.add(l6);
		
		b1 = new JButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("bkash (2).jpg"))));
		b1.setBounds(110,130,200,200);
		b1.setCursor(c1);
		b1.addActionListener(this);
		p1.add(b1);
		
		b2 = new JButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("nagad (3).jpg"))));
		b2.setBounds(400,130,200,200);
		b2.setCursor(c1);
		b2.addActionListener(this);
		p1.add(b2);
		
		b3 = new JButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("cad (1) (1).jpg"))));
		b3.setBounds(110,400,200,200);
		b3.setCursor(c1);
		b3.addActionListener(this);
		p1.add(b3);
		
		b4 = new JButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("visa (2).jpg"))));
		b4.setBounds(400,400,200,200);
		b4.setCursor(c1);
		b4.addActionListener(this);
		p1.add(b4);
		
		l3=new JLabel();
        l3.setText("We accept these secure payment");
        l3.setForeground(Color.red);
        l3.setBounds(160,30,500,50);
        l3.setLayout(null);
        l3.setFont(new Font("Tahoma",Font.BOLD,25));
        p1.add(l3);
		
		
	}
	public void mouseClicked(MouseEvent e) {
		
		if(e.getSource()==l6) {
			Order o=new Order();
		    this.setVisible(false);
			o.setVisible(true);
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
			int currentUserId = Session.loggedUserId;
			OrderDAO.saveOrder(currentUserId, "Bkash");
			BkashP bp = new BkashP();
			this.setVisible(false);
			bp.setVisible(true);
		}
		if(e.getSource()==b2)
		{
			int currentUserId = Session.loggedUserId;
			OrderDAO.saveOrder(currentUserId, "Nagad");
			nagad nd = new nagad();
			this.setVisible(false);
			nd.setVisible(true);
		}

		if(e.getSource()==b3)
		{
			int currentUserId = Session.loggedUserId;
			OrderDAO.saveOrder(currentUserId, "COD");
			COD cd = new COD();
			this.setVisible(false);
			cd.setVisible(true);
		}

		if(e.getSource()==b4)
		{
			int currentUserId = Session.loggedUserId;
			OrderDAO.saveOrder(currentUserId, "Visa");
			visa v = new visa();
			this.setVisible(false);
			v.setVisible(true);
		}
	}
        public static void main(String[]args) {
		Payment form =new Payment();
		form.setVisible(true);
	} 
} 
