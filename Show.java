package javaproject.AWT_AND_SWING;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import net.proteanit.sql.DbUtils;

public class Show extends JFrame implements ActionListener {
    JTable table;
    
    Connection con= null;
    Statement smt = null;
    ResultSet rs = null;
    Show(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        table = new JTable();
        table.setBounds(0, 40, 500, 400);
        add(table);
        
        JButton b1 = new JButton();
        b1.setName("BackBtn");
        b1.setBackground(Color.green);
        b1.setForeground(Color.black);
        b1.setBounds(200,500,100,30);
        b1.addActionListener(this);
        add(b1);
        
        JLabel l1 = new JLabel("Task");
        l1.setBounds(10, 10, 100, 20);
        add(l1);
      
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","root");
            smt = con.createStatement();
            rs=smt.executeQuery("select * from tasks");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
        
        setBounds(300,200,1050,600);
        setVisible(true);
    }
    private void ActionPerformed(java.awt.event.ActionEvent evt) {
        Main m = new Main();
        m.setVisible(true);
        this.setVisible(false);
         }
    public static void main(String[]args){
        new Show();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
