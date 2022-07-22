package kaucher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class FirstPage extends JFrame  {
    //private static JFrame frame;
    private static JButton logIn;
    private static JButton signUp;
    private Container c;
    private Font f;
    private Cursor cursor;
    private ImageIcon img1;
    Connection connection=null;
    PreparedStatement preparedStatement=null;
    ResultSet resultSet=null;

    FirstPage() {

        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //this.setForeground(Color.green);
        this.setLayout(null);
        this.setTitle("Blood For Life");

        c=this.getContentPane();
        c.setBackground(Color.pink);

        f=new Font("Arial",Font.BOLD,14);
        cursor=new Cursor(Cursor.HAND_CURSOR);

//        ImageIcon image = new ImageIcon("Blood for life.img");
//        JLabel pn = new JLabel("", image, JLabel.CENTER);
//        pn.setBounds(60, 60, 400, 400);
//        frame.add(pn);


        ///////////////////////////////////////////////////////
        JLabel label = new JLabel("User Name");
        label.setBounds(60, 100, 280, 30);
        label.setFont(f);
        label.setLayout(null);
        this.add(label);

        JTextField userName = new JTextField();
        userName.setBounds(80, 5, 200, 20);
        //userName.setBackground(Color.LIGHT_GRAY);
        userName.setHorizontalAlignment(JTextField.CENTER);
        label.add(userName);


        /////////////////////////////////////////////////////////////////////

        //////////////////////////////////////////////////////
        JLabel label2 = new JLabel("Password");
        label2.setBounds(60, 130, 280, 30);
        label2.setFont(f);
        label2.setLayout(null);
        this.add(label2);

        JPasswordField passWord = new JPasswordField();
        passWord.setBounds(80, 5, 200, 20);
        passWord.setHorizontalAlignment(JPasswordField.CENTER);
        label2.add(passWord);
        ////////////////////////////////////////////////////////////////////////////////////////

       // img1=new ImageIcon(getClass().getResource("login2.png"));
        logIn = new JButton("Log In");
        logIn.setBounds(170, 180, 80, 40);
        logIn.setCursor(cursor);
        logIn.setBackground(Color.pink);
        this.add(logIn);
  //      logIn.addActionListener(new FirstPage());
        logIn.addActionListener(a ->{
//            dispose();
//           new logIn();

            String name = userName.getText();
            String password = passWord.getText();

            String query = ("SELECT * FROM donnerinfo WHERE Ussername=? AND pass=?" );
          //  String db2=new Dbc(query).getString();
            String db = null;
            try {
               // db = new Dbc().getText(query);
                connection=new Dbc().Connect();
                preparedStatement=connection.prepareStatement(query);
                preparedStatement.setString(1,name);
                preparedStatement.setString(2,password);
                resultSet=preparedStatement.executeQuery();
                while(resultSet.next()){
                  db = resultSet.getString("pass");
                    //System.out.println(resultSet.getString(1) + "  " + resultSet.getString(2) + "  " + resultSet.getInt(3) + "  " + resultSet.getString(4) + "  " + resultSet.getString(5) + "  " + resultSet.getString(6) + "  " + resultSet.getString(7));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(password.equals(db)){
               System.out.println("hurrrah");
               dispose();
               new logIn();
           }
            else {
                JOptionPane.showMessageDialog(null,"Wrong Usser Name or Password");
               // System.out.println("wrong username or password");
            }



//            try{
//                Class.forName("com.mysql.jdbc.Driver");
//                Connection con= DriverManager.getConnection(
//                        "jdbc:mysql://localhost:3306/blood_for_life","root","");
//                Statement stmt=con.createStatement();
//                ResultSet rs=stmt.executeQuery("select * from donnerinfo");
//                while(rs.next()) {
//                    System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getInt(3) + "  " + rs.getString(4) + "  " + rs.getString(5) + "  " + rs.getString(6) + "  " + rs.getString(7));
//                    if (rs.getString(7) == passWord.getText()){
//                    System.out.println("Hurrah");
//                    };
//                };
//
//
//                con.close();
//            }catch(Exception e){ System.out.println("password not match");}


/**
            String q = ("SELECT * FROM donnerinfo" );

            try {
                // db = new Dbc().getText(query);
                connection=new Dbc().Connect();
                preparedStatement=connection.prepareStatement(q);
                resultSet=preparedStatement.executeQuery();
                while(resultSet.next()){
                    System.out.println(resultSet.getString(1) + "  " + resultSet.getString(2) + "  " + resultSet.getInt(3) + "  " + resultSet.getString(4) + "  " + resultSet.getString(5) + "  " + resultSet.getString(6) + "  " + resultSet.getString(7));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }


*/



        });




        JLabel ifYOuNew=new JLabel();
        ifYOuNew.setBounds(90,270,150,80);
        ifYOuNew.setText("If you are New then, ");
        ifYOuNew.setFont(new Font("Verdana", Font.PLAIN, 13));
        ifYOuNew.setForeground(Color.blue);
        this.add(ifYOuNew);


        signUp = new JButton("Sign UP");
        signUp.setBounds(230, 299, 80, 25);
        signUp.setCursor(cursor);
        signUp.setBackground(Color.black);
        signUp.setForeground(Color.pink);
        this.add(signUp);
       // signUp.addActionListener(new FirstPage());
        signUp.addActionListener(e -> {
            dispose();
            new SignUp();
        });




//        c=this.getContentPane();
//        c.setBackground(Color.pink);


        this.setVisible(true);


    }


    //No Use
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//
//        if (e.getSource() == logIn) {
//            //System.out.println("Logged In");
//           // this.dispose();
//            new logIn();
//
//        }
//        if (e.getSource() == signUp) {
//            System.out.println("Signed Up");
//            //frame.dispose();
//            new SignUp();
//
//        }
//
//    }


}
