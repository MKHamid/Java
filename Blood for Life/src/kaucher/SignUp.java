package kaucher;

import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignUp extends JFrame  {
    //private static JFrame frame;
    private static JTextField name,phone,address,pass,usserT;
    private static JLabel nameLbl,bGrpLbl,phoneLbl,addressLbl,distric,division,pss,usser,imglbl;
    private static JComboBox cb,div;
    private static JButton sign;
    private Container c;
    private ImageIcon icon;
    Connection connection=null;
    PreparedStatement preparedStatement=null;
    ResultSet resultSet=null;

    static JCheckBoxMenuItem check1,check2,check3,check4,check5,check6,check7,check8;
    SignUp(){
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Blood For Life");

        c=this.getContentPane();
        c.setBackground(Color.CYAN);


        nameLbl =new JLabel("Name");
        nameLbl.setBounds(20,5,50,30);
        this.add(nameLbl);
        name=new JTextField();
        name.setBounds(80,8,150,25);
        this.add(name);



        bGrpLbl=new JLabel("Blood Group");
        bGrpLbl.setBounds(20,50,80,30);
        this.add(bGrpLbl);

        String st[]={"A+","A-","B+","B-","O+","O-","AB+","AB-"};
        cb=new JComboBox(st);
        cb.setBounds(100,50,60,30);
        this.add(cb);



        phoneLbl=new JLabel("Phone");
       phoneLbl.setBounds(20,90,80,30);
       this.add(phoneLbl);

       phone=new JTextField();
       phone.setBounds(80,90,150,25);
       phone.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               String s=phone.getText();
               if(s.isEmpty()){
                   JOptionPane.showMessageDialog(null,"Please enter Phone Number");
               }
           }
       });
       this.add(phone);


       addressLbl=new JLabel("Adress");
       addressLbl.setBounds(20,130,80,30);
       this.add(addressLbl);

       address=new JTextField();
       address.setBounds(80,130,150,25);
       this.add(address);


        division= new JLabel("District");
        division.setBounds(20,170,80,30);
        this.add(division);

        String division_name[]={"Dhaka","Sylhet","Barisal","Chittagong","Khulna","Mymensingh","Rajshahi","Rangpur"};
        div=new JComboBox(division_name);
        div.setBounds(80,170,100,30);
        this.add(div);


        usser=new JLabel("Set a new Ussername");
        usser.setBounds(20,210,150,30);
        usser.setForeground(Color.red);
        this.add(usser);


        usserT=new JTextField();
        usserT.setBounds(20,240,150,25);
        this.add(usserT);



        pss=new JLabel("Set a New Password");
        pss.setBounds(200,210,150,30);
        pss.setForeground(Color.red);
        this.add(pss);

        pass=new JTextField();
        pass.setBounds(200,240,150,25);
        this.add(pass);


        sign=new JButton("Sign UP");
        sign.setBounds(150,290,80,40);
        sign.setBackground(Color.GREEN);
        this.add(sign);
//        sign.addActionListener(e ->{
//            //dispose();
//            new SignUp();
//        });

        sign.addActionListener(new ActionListener() {
            String db;
            @Override
            public void actionPerformed(ActionEvent e) {
                String usser=usserT.getText();
                String query=("SELECT * FROM donnerinfo WHERE Ussername=?");
                try {
                    // db = new Dbc().getText(query);
                    connection=new Dbc().Connect();
                    preparedStatement=connection.prepareStatement(query);
                    preparedStatement.setString(1,usser);
                    resultSet=preparedStatement.executeQuery();
                    while(resultSet.next()){
                        db = resultSet.getString("Ussername");
                    }

                } catch (SQLException e1) {
                    e1.printStackTrace();

                }

                if(!usser.equals(db)) {
                    String q=("INSERT INTO donnerinfo VALUES (?,?,?,?,?,?,?)");
                    try {
                        // db = new Dbc().getText(query);
                        connection=new Dbc().Connect();preparedStatement=connection.prepareStatement(q);
                       preparedStatement.setString(1,name.getText());
                       preparedStatement.setString(2,cb.getSelectedItem().toString());
                       preparedStatement.setString(3,phone.getText());
                       preparedStatement.setString(4,address.getText());
                       preparedStatement.setString(5,div.getSelectedItem().toString());
                       preparedStatement.setString(6,usserT.getText());
                       preparedStatement.setString(7,pass.getText());
                       preparedStatement.executeUpdate();

                    } catch (SQLException e1) {
                        e1.printStackTrace();

                    }
                    dispose();
                    JOptionPane.showMessageDialog(null, "Signed Up Successful");
                    new FirstPage();
                }
                else {
                    JOptionPane.showMessageDialog(null,"Try Another ussername");
                }

            }
        });

//        icon=new ImageIcon(getClass().getResource("blood.jpg"));
//        imglbl=new JLabel(icon);
//        imglbl.setBounds(0,0,100,100);
//        this.add(imglbl);




        this.setVisible(true);

    }
}
