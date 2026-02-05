package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class Owner extends JFrame implements ActionListener
{
		JLabel l1,l4,l7;
		JTextField t1;
		JButton b1,b2; 
		JPanel p1;
		JPasswordField pf;
		JCheckBox c;
		Cursor c1;
		ImageIcon img20;
        ImageIcon fp=new ImageIcon(Objects.requireNonNull(getClass().getResource("foodpic (5).jpg")));
		
	public Owner()
	{
		super("Owner Login");
		this.setSize(1415,760);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(new Color(109,109,121));
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		img20 = new ImageIcon(Objects.requireNonNull(getClass().getResource("Foodflow logo.png")));
		this.setIconImage(img20.getImage());
		
		c1 = new Cursor(Cursor.HAND_CURSOR);

		p1 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				// set color with alpha for transparency (0-255)
				g.setColor(new Color(48, 27, 8, 150)); // 150 = semi-transparent
				g.fillRect(0, 0, getWidth(), getHeight());
			}
		};
		p1.setLayout(null);
		p1.setOpaque(false); // important
		p1.setBounds(850, 80, 430, 500);
		this.add(p1);

		l1 = new JLabel("Owner Login");
		l1.setFont(new Font("Monotype Corsiva",Font.BOLD,50));
		l1.setForeground(Color.white);
		l1.setBounds(100,50,300,50);
		p1.add(l1);
		
		t1 = new MyTextField();
		t1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t1.setForeground(Color.white);
		t1.setOpaque(false);
		t1.setBounds(50,170,340,50);
		((MyTextField) t1).setHint("Username");
		p1.add(t1);
		
		pf = new MyPasswordField();
		pf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pf.setForeground(Color.white);
		pf.setOpaque(false);
		pf.setBounds(50,250,340,50);
		((MyPasswordField) pf).setHint("Password");
		p1.add(pf);
		
		l4=new JLabel();
		l4.setFont(new Font("Arial",Font.BOLD,12));
		l4.setForeground(Color.white);
		l4.setBounds(840,400,340,30);
		p1.add(l4);
		
		c = new JCheckBox("Show Password");
		c.setFocusPainted(false);
		c.setContentAreaFilled(false);
		c.setCursor(c1);
		c.setForeground(new Color(255, 255, 255));
		c.setFont(new Font("Tahoma",Font.PLAIN,17));
		c.setBorder(null);
		c.setBounds(50,300,340,30);
		p1.add(c);
		c.addActionListener(this);	
		
		b1 = new MyButton();
		b1.setText("Log in");
		b1.setFocusPainted(false);
		b1.setBounds(45, 400, 160, 40);
		b1.setFont(new Font("Tahoma", Font.BOLD, 20));
		b1.setCursor(c1);
		((MyButton) b1).setRedius(8);
		b1.setBorder(null);
		p1.add(b1);
		b1.addActionListener(this);
		b1.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                b1.setBackground(new Color(48,27,8));
                b1.setForeground(new Color(255, 255, 255));
            }
            public void mouseExited(MouseEvent e) {
                b1.setForeground(new Color(48,27,8));
                b1.setBackground(new Color(255, 255, 255));
            }
        });
			
		b2 = new MyButton();
		b2.setText("Back");
		b2.setFocusPainted(false);
		b2.setBounds(225, 400, 160, 40);
		b2.setFont(new Font("Tahoma", Font.BOLD, 20));
		b2.setCursor(c1);
		((MyButton) b2).setRedius(8);
		b2.setBorder(null);
		p1.add(b2);
		b2.addActionListener(this);
		b2.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                b2.setBackground(new Color(48,27,8));
                b2.setForeground(new Color(255, 255, 255));
            }
            public void mouseExited(MouseEvent e) {
                b2.setForeground(new Color(48,27,8));
                b2.setBackground(new Color(255, 255, 255));
            }
        });

		l7=new JLabel();
        l7.setIcon(fp);
        l7.setBounds(-200,-200,2560,1600);
        this.add(l7);
        this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == b2)
		{
			FoodCover fc = new FoodCover();
			this.setVisible(false);
			fc.setVisible(true);
		}

		if(e.getSource() == b1)
		{
			String id = t1.getText();
			char[] pass = pf.getPassword();
			String password = new String(pass);

			if(id.isEmpty() || password.isEmpty())
			{
				l4.setText("Text boxes cannot be empty!");
				return; // optional, prevents further checking
			}

			if(id.equals("Admin") && password.equals("2023"))
			{
				//JOptionPane.showMessageDialog(null,"Username:Owner  Password:2023","Massage Box",1);
				management ma = new management();
				this.setVisible(false);
				ma.setVisible(true);
			}
		}

		if(c.isSelected())
		{
			pf.setEchoChar((char) 0);
		}
		else
		{
			pf.setEchoChar('●');
		}
	}

	public static void main(String[]args) {
		Owner O =new Owner();
		O.setVisible(true);
	}
		
}