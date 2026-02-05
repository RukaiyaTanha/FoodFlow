package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class BkashP extends JFrame implements ActionListener
{
	JPanel p1;
    JLabel l1,l2;
	JTextField t1,t2,t3;
    JButton b1,b2;
	Cursor c1;
	ImageIcon img20;
	ImageIcon payment1 = new ImageIcon(Objects.requireNonNull(getClass().getResource("bkash_app.gif")));
	public BkashP()
	{
		super("Payment");
		this.setSize(1380,750);
		this.setLocation(300, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(125,23,67));
		
        img20 = new ImageIcon(Objects.requireNonNull(getClass().getResource("Foodflow logo.png")));
		this.setIconImage(img20.getImage());
		
        c1 = new Cursor(Cursor.HAND_CURSOR);
		
		p1=new JPanel();
        p1.setSize(new Dimension(1920,1080));
        p1.setBackground(new Color(125,23,67));
        p1.setLayout(null);
        this.add(p1);
		
		l1=new JLabel();
		l1.setIcon(payment1);
		l1.setBounds(550,50,800,600);
		p1.add(l1);
		
		l2=new JLabel();
        l2.setText("Bkash Payment");
        l2.setForeground(Color.white);
        l2.setBounds(120,70,500,50);
        l2.setLayout(null);
        l2.setFont(new Font("Tahoma",Font.BOLD,40));
        p1.add(l2);
		
		t1 = new MyTextField();
		t1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t1.setForeground(Color.white);
		t1.setOpaque(false);
		t1.setBounds(80,200,380,50);
		((MyTextField) t1).setHint("Merchant");
		p1.add(t1);
		
		t2 = new MyTextField();
		t2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t2.setForeground(Color.white);
		t2.setOpaque(false);
		t2.setBounds(80,280,380,50);
		((MyTextField) t2).setHint("PIN");
		p1.add(t2);
		
		t3 = new MyTextField();
		t3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t3.setForeground(Color.white);
		t3.setOpaque(false);
		t3.setBounds(80,360,380,50);
		((MyTextField) t3).setHint("Bkash Account Number");
		p1.add(t3);
		
		b1 = new MyButton();
		b1.setText("Proceed");
		b1.setFocusPainted(false);
		b1.setBounds(290,500,180,40);
		b1.setFont(new Font("Tahoma", Font.BOLD, 20));
		b1.setCursor(c1);
		((MyButton) b1).setRedius(8);
		b1.setBorder(null);
        p1.add(b1);
		b1.addActionListener(this);
		b1.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                b1.setBackground(new Color(125,23,67));
                b1.setForeground(new Color(255, 255, 255));
            }
            public void mouseExited(MouseEvent e) {
                b1.setForeground(new Color(125,23,67));
                b1.setBackground(new Color(255, 255, 255));
            }
        });
			
		b2 = new MyButton();
		b2.setText("Close");
        b2.setFocusPainted(false);
		b2.setBounds(70,500,180,40);
		b2.setFont(new Font("Tahoma", Font.BOLD, 20));
		b2.setCursor(c1);
		((MyButton) b2).setRedius(8);
		b2.setBorder(null);
		p1.add(b2);
		b2.addActionListener(this);
		b2.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                b2.setBackground(new Color(125,23,67));
                b2.setForeground(new Color(255, 255, 255));
            }
            public void mouseExited(MouseEvent e) {
                b2.setForeground(new Color(125,23,67));
                b2.setBackground(new Color(255, 255, 255));
            }
        });
		
	}
	
	 public void actionPerformed(ActionEvent e) 
	{
        if(e.getSource()==b1) 
		{
			String id1=t1.getText();
			String id2=t2.getText();
			String id3=t3.getText();
			
			
			if(id1.isEmpty()==true || id2.isEmpty()==true || id3.isEmpty()==true) 
			{
				JOptionPane.showMessageDialog(null,"Text boxes cannot be empty!","This is a massage box",0);
		    }
			
		else if(e.getSource()==b1)
	    {
			JOptionPane.showMessageDialog(null,"Payment Succesfully done!","This is a massage box",1);
			
			Order o=new Order();
		    this.setVisible(false);
			o.setVisible(true);	
	    }
        }
        else if(e.getSource()==b2)
	    {
            Payment p=new Payment();
		    this.setVisible(false);
			p.setVisible(true);	
	    }
    }
	public static void main(String[]args) {
		BkashP form =new BkashP();
		form.setVisible(true);
	}
}   
