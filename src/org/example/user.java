package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class user extends JFrame implements ActionListener,MouseListener 
{
	JButton b1,b2,b3,b4;
	ImageIcon img20;
	JLabel l1,l6;
	Cursor c1;
	JPanel p1;
    ImageIcon back=new ImageIcon(Objects.requireNonNull(getClass().getResource("backButton.png")));
	
	public user()
	{
		//Frame
		super("User");
		this.setSize(1140, 640);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		img20 = new ImageIcon(Objects.requireNonNull(getClass().getResource("Foodflow logo.png")));
		this.setIconImage(img20.getImage());
		
		c1 = new Cursor(Cursor.HAND_CURSOR);
		
		l6=new JLabel();
		l6.setIcon(back);
		l6.setBounds(30, 30, 33, 33);
		l6.addMouseListener(this);
		this.add(l6);
		
        p1 = new JPanel();
		p1.setSize(new Dimension(1920,1080));
		p1.setBackground(new Color(127,127,127));
		p1.setLayout(null);
  		this.add(p1);

		b1 = new JButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("order1 (1).jpg"))));
		b1.setBounds(650,100,200,200);
		b1.setCursor(c1);
		b1.addActionListener(this);
		p1.add(b1);
		
		b2 = new JButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("menu1 (1).jpg"))));
		b2.setBounds(870,100,200,200);
		b2.setCursor(c1);
		b2.addActionListener(this);
		p1.add(b2);
		
		b3 = new JButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("feddback (1).jpg"))));
		b3.setBounds(650,320,200,200);
		b3.setCursor(c1);
		b3.addActionListener(this);
		p1.add(b3);
 
        b4 = new JButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("knowus (1).jpg"))));
		b4.setBounds(870,320,200,200);
		b4.setCursor(c1);
		b4.addActionListener(this);
		p1.add(b4);
		
		l1=new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("Userc.gif"))));
		l1.setBounds(-50,0,1252,648);
		p1.add(l1);

		this.setVisible(true);
		
	}
	 public void mouseClicked(MouseEvent e) {
		
		if(e.getSource()==l6) {
			this.setVisible(false);
			SignIn s=new SignIn();
			s.setVisible(true);
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
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1){
			this.setVisible(false);
			Order o=new Order();
			o.setVisible(true);
		}
		else if(e.getSource()==b2)
		{
			this.setVisible(false);
			menu m=new menu();
			m.setVisible(true);
		}
		else if(e.getSource()==b3)
		{
			this.setVisible(false);
			feedback f=new feedback();
			f.setVisible(true);
		}
		else if(e.getSource()==b4)
		{
			this.setVisible(false);
			knowUs k=new knowUs();
			k.setVisible(true);
		}

	}
	public static void main(String[]args) {
		user form=new user();
		form.setVisible(true);
	}
	
}