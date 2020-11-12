package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HealthBar {
    JFrame window;
    JPanel HPBar, Buttonpanel;
    JProgressBar HealthBar;
    JButton attack,heal;
    Container con;
    DamageHandler damage=new DamageHandler();
    //int player max hp
    private int maxhp;
    //current player hp
    private int hp;

    HealthBar() {

        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        con = window.getContentPane();

        HPBar = new JPanel();
        HPBar.setBounds(250, 250, 300, 30);
        HPBar.setBackground(Color.BLACK);
        con.add(HPBar);

        HealthBar = new JProgressBar(0,maxhp);
        HealthBar.setPreferredSize(new Dimension(300, 30));
        HealthBar.setValue(100);
        HealthBar.setBackground(Color.RED);
        HealthBar.setForeground(Color.GREEN);
        HPBar.add(HealthBar);

        Buttonpanel = new JPanel();
        Buttonpanel.setBounds(300, 300, 300, 40);
        Buttonpanel.setBackground(Color.BLACK);

        attack = new JButton("Attack");
        attack.setBackground(Color.BLACK);
        attack.setPreferredSize(new Dimension(120, 20));
        attack.setForeground(Color.WHITE);
        attack.addActionListener(damage);
        attack.setActionCommand("att");
        attack.setFocusPainted(false);
        Buttonpanel.add(attack);
        heal= new JButton("Heal");
        heal.setBackground(Color.BLACK);
        heal.setPreferredSize(new Dimension(120,20));
        heal.setForeground(Color.WHITE);
        heal.addActionListener(damage);
        heal.setActionCommand("heal");
        heal.setFocusPainted(false);
        Buttonpanel.add(heal);
        con.add(Buttonpanel);
        hp = 100;
        window.setVisible(true);

    }

    public void DamageReceived() {
        hp = hp - 10;
        HealthBar.setValue(hp);
    }
    public void HealReceived(){
        hp=hp+10;
        HealthBar.setValue(hp);

    }

    class DamageHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String c=e.getActionCommand();
            switch (c){
                case "att":DamageReceived();break;
                case "heal":HealReceived();break;
            }
        }
    }
}
