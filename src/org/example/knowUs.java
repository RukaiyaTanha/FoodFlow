package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;
import java.util.Objects;

public class knowUs extends JFrame implements MouseListener {

    JPanel mainPanel;
    JLabel titleLabel, projectLabel, teamLabel, member1Label, member2Label;
    JLabel whyLabel, reason1, reason2, reason3, reason4, thanksLabel;
    JLabel contactLabel, emailLabel, phoneLabel, websiteLabel;
    JButton mapBtn;
    Cursor cursor;
    ImageIcon backIcon,img20;
    JLabel backLabel;

    public knowUs() {
        super("Know About Us");
        this.setSize(540, 570);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        // Cursor
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // Back button
        backIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("backButton.png")));
        backLabel = new JLabel(backIcon);
        backLabel.setBounds(20, 30, 33, 33);
        backLabel.addMouseListener(this);
        this.add(backLabel);

        img20 = new ImageIcon(Objects.requireNonNull(getClass().getResource("Foodflow logo.png")));
        this.setIconImage(img20.getImage());

        // Main panel with scroll
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setPreferredSize(new Dimension(500, 900));
        mainPanel.setBackground(Color.white);

        JScrollPane scroll = new JScrollPane(mainPanel);
        scroll.setBounds(0, 0, 540, 780);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.add(scroll);

        int y = 30;

        // Title
        titleLabel = new JLabel("Welcome to Foodflow");
        titleLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 40));
        titleLabel.setBounds(80, y, 400, 40);
        mainPanel.add(titleLabel);

        y += 50;
        projectLabel = new JLabel("Hi! This is Rukaiya, I have created my project for you.");
        projectLabel.setFont(new Font("Arial", Font.PLAIN, 17));
        projectLabel.setBounds(60, y, 400, 30);
        mainPanel.add(projectLabel);

        y += 50;
        whyLabel = new JLabel("Why need a management system?");
        whyLabel.setFont(new Font("Arial", Font.BOLD, 20));
        whyLabel.setForeground(Color.red);
        whyLabel.setBounds(90, y, 400, 30);
        mainPanel.add(whyLabel);

        y += 30;
        reason1 = new JLabel("- Super easy recipe and menu management.");
        reason1.setFont(new Font("Arial", Font.PLAIN, 18));
        reason1.setBounds(50, y, 400, 30);
        mainPanel.add(reason1);

        y += 25;
        reason2 = new JLabel("- Simplified online ordering.");
        reason2.setFont(new Font("Arial", Font.PLAIN, 18));
        reason2.setBounds(50, y, 400, 30);
        mainPanel.add(reason2);

        y += 25;
        reason3 = new JLabel("- Managing accounts can be much easier.");
        reason3.setFont(new Font("Arial", Font.PLAIN, 18));
        reason3.setBounds(50, y, 400, 30);
        mainPanel.add(reason3);

        y += 25;
        reason4 = new JLabel("- Helps you save costs.");
        reason4.setFont(new Font("Arial", Font.PLAIN, 18));
        reason4.setBounds(50, y, 400, 30);
        mainPanel.add(reason4);

        y += 50;
        thanksLabel = new JLabel("I will keep updating. Thank you!");
        thanksLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        thanksLabel.setForeground(Color.blue);
        thanksLabel.setBounds(130, y, 400, 30);
        mainPanel.add(thanksLabel);

        y += 50;
        // Contact Info
        contactLabel = new JLabel("Contact Us:");
        contactLabel.setFont(new Font("Arial", Font.BOLD, 20));
        contactLabel.setBounds(60, y, 200, 30);
        mainPanel.add(contactLabel);

        y += 30;
        emailLabel = new JLabel("Email: info@foodflow.com");
        emailLabel.setBounds(70, y, 400, 30);
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        mainPanel.add(emailLabel);

        y += 25;
        phoneLabel = new JLabel("Phone: +880 1234 567890");
        phoneLabel.setBounds(70, y, 400, 30);
        phoneLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        mainPanel.add(phoneLabel);

        y += 25;
        websiteLabel = new JLabel("Website: www.foodflow.com");
        websiteLabel.setBounds(70, y, 400, 30);
        websiteLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        mainPanel.add(websiteLabel);

        y += 40;
        // Map button
        mapBtn = new JButton("View Map in Browser");
        mapBtn.setBounds(150, y, 200, 30);
        mapBtn.setCursor(cursor);
        mapBtn.addActionListener(ev -> {
            try {
                Desktop.getDesktop().browse(new URI("https://www.google.com/maps/place/Foodflow/@64.9808752,11.8086842,6.67z/data=!4m6!3m5!1s0x6b1f5ffdf98b6eed:0x2e4d99c98f4d9540!8m2!3d64.55875!4d17.70995!16s%2Fg%2F11y10z210k?entry=ttu&g_ep=EgoyMDI2MDIwMS4wIKXMDSoKLDEwMDc5MjA3M0gBUAM%3D"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        mainPanel.add(mapBtn);

        this.setVisible(true);
    }

    private void openLink(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == backLabel) {
            this.setVisible(false);
            new user().setVisible(true);
        }
    }

    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) { backLabel.setForeground(Color.BLACK); }
    @Override public void mouseExited(MouseEvent e) { backLabel.setForeground(Color.WHITE); }

    public static void main(String[] args) {
        new knowUs();
    }
}
