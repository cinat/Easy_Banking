/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmsimulator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener {
    JLabel l1,l2,l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1,b2,b3;
    Login(){
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ATMSimulator/icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l14 = new JLabel(i3);
        l14.setBounds(60, 90, 100, 100);
        add(l14);
        
        setTitle("AUTOMATED TELLER MACHINE");
        
        //Initializing global variables
        l1= new JLabel("Welcome to ATM");
        l1.setFont(new Font("Osward", Font.BOLD,38));
        
        
        l2= new JLabel("Card No:");
        l2.setFont(new Font("Raleway",Font.BOLD,28));
        
        l3= new JLabel("PIN :");
        l3.setFont(new Font("Raleway",Font.BOLD,28));
        
        tf1= new JTextField(15);
        pf2=new JPasswordField(15);
        
        b1=new JButton("SIGN IN");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2= new JButton("CLEAR");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b3=new JButton("SIGN UP");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        
        setLayout(null);
        
        l1.setBounds(175,50,450,200);
        add(l1);
        
        l2.setBounds(125,150,375,200);
        add(l2);
        
        l3.setBounds(125,225,375,200);
        add(l3);
        
        tf1.setFont(new Font("Arial",Font.BOLD,14));
        tf1.setBounds(300,235,230,30);
        add(tf1);
        
        pf2.setFont(new Font("Arial",Font.BOLD,14));
        pf2.setBounds(300,310,230,30);
        add(pf2);
        
        b1.setFont(new Font("Arial",Font.BOLD,14));
        b1.setBounds(300,400,100,30);
        add(b1);
        
        b2.setFont(new Font("Arial",Font.BOLD,14));
        b2.setBounds(430,400,100,30);
        add(b2);
        
        b3.setFont(new Font("Arial",Font.BOLD,14));
        b3.setBounds(300,450,230,30);
        add(b3);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        //background color
        getContentPane().setBackground(Color.WHITE);
        
        setSize(650,650); // size of the screen(frame)
        setLocation(500,50);//200 from above and 500 from left
        setVisible(true);// to see the frame
        
        
    }
    @Override
     public void actionPerformed(ActionEvent ae)
         {
            try{
                Conn c1= new Conn();
                String a= tf1.getText();
                String b= pf2.getText();
                String q= "select * from login where cardno = '"+a+"' and pin ='"+b+"'";
                ResultSet rs = c1.s.executeQuery(q);
                //ResultSet is a java object that contains the result of SQL query
               
               if(ae.getSource()==b1)//if we click on button b1(we get the source)
               {
                   if(rs.next())
                   {
                       setVisible(false);
                       new Transactions(b).setVisible(true);
                       
                   }
                   else
                   {
                       JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");
                   }
                   
               }
               else if(ae.getSource()==b2)
               {
                   tf1.setText("");
                   pf2.setText("");
               }
               else if(ae.getSource()==b3)
               {
                   new Signup().setVisible(true);
                   setVisible(false);
               }
            }
            catch( Exception e)
            {
                e.printStackTrace();
                System.out.println("error: "+e);
            }
        }
    public static void main (String[]args){
        new Login().setVisible(true);
    }
        
        
        
    }
    
