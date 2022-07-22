package kaucher;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.stream.Stream;

public class logIn extends JFrame {
   //private static JFrame frame;
    private static JComboBox sortDiv,sorGrp;
    private  static JButton filter,dflt;
    Connection connection=null;
    PreparedStatement preparedStatement=null;
    ResultSet resultSet=null;
    public JTable jt;
    public DefaultTableModel dtm;
    public JScrollPane jsp;
    String d1,A1;   ///////This is  new for testing
    String[]rows=new String[5];
    String[]cols={"Name","blood Group","Phone","Adress","Division"};

    logIn() {
        JOptionPane.showMessageDialog(null,"Log In Successful");


          this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Blood For Life");

//        BorderLayout layout = new BorderLayout();
//        layout.setHgap(10);
//        layout.setVgap(10);
//
//        this.setLayout(layout);


        JPanel logPanel=new JPanel();
        logPanel.setBounds(0,0,400,400);
        logPanel.setBackground(Color.CYAN);
       // this.add(logPanel,BorderLayout.CENTER);
        logPanel.setLayout(new GridLayout(0,1));
        this.add(logPanel);


        dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(cols);
        jt = new JTable(dtm);

        jt.getColumnModel().getColumn(0).setPreferredWidth(275);
        jt.getColumnModel().getColumn(1).setPreferredWidth(275);
        jt.getColumnModel().getColumn(2).setPreferredWidth(275);

        jt.getRowHeight(20);
        jt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jsp = new JScrollPane(jt);
        jsp.setBounds(20,20,425,200);



        try {
// String query = "SELECT COUNT(*), date,id,name,age,gender,address,phone,status,disease,room FROM patient";
            String query = "SELECT * FROM donnerinfo";
            connection = new Dbc().Connect();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                rows[0] = resultSet.getString(1);
                rows[1] = resultSet.getString(2);
                rows[2] = resultSet.getString(3);
                rows[3] = resultSet.getString(4);
                rows[4] = resultSet.getString(5);

                dtm.addRow(rows);
            }


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }




        JPanel logPanel2=new JPanel();
       logPanel2.setBounds(30,10,400,400);
        logPanel2.setBackground(Color.ORANGE);
        this.add(logPanel2,BorderLayout.NORTH);



        String divSt[]={"Dhaka","Sylhet","Barisal","Chittagong","Khulna","Mymensingh","Rajshahi","Rangpur"};
        sortDiv=new JComboBox(divSt);
        logPanel2.add(sortDiv);
        sortDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 d1=sortDiv.getSelectedItem().toString();

//                if(d1.equals("Dhaka")){
//                    try {
//                        dtm.getDataVector().removeAllElements();
//                        dtm.fireTableDataChanged();
//                        String query = "SELECT* FROM donnerinfo WHERE Division=?";
//                        connection = new Dbc().Connect();
//                        preparedStatement = connection.prepareStatement(query);
//                        preparedStatement.setString(1,d1);
//                        resultSet = preparedStatement.executeQuery();
//                        System.out.println("YESSS  "+String.valueOf(d1));
//
//                        while (resultSet.next()){
//                            rows[0] = resultSet.getString(1);
//                            rows[1] = resultSet.getString(2);
//                            rows[2] = resultSet.getString(3);
//                            rows[3] = resultSet.getString(4);
//                            rows[4] = resultSet.getString(5);
//
//                            dtm.addRow(rows);
//                        }
//                    } catch (SQLException a) {
//                        JOptionPane.showMessageDialog(null, a);
//                    }
//
//                }

            }
        });

        String grpSt[]={"A+","A-","B+","B-","O+","O-","AB+","AB-"};
        sorGrp=new JComboBox(grpSt);
        logPanel2.add(sorGrp);
        sorGrp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 A1 =sorGrp.getSelectedItem().toString();
                //String q={"SELECT* From donnerinfo Where bloodgroup=?"};

//                if(A1.equals("A+")){
//
//
//                    try {
//                        dtm.getDataVector().removeAllElements();
//                        dtm.fireTableDataChanged();
//                        String query = "SELECT* FROM donnerinfo WHERE Bloodgroup=?";
//                        connection = new Dbc().Connect();
//                        preparedStatement = connection.prepareStatement(query);
//                        preparedStatement.setString(1,A1);
//                        resultSet = preparedStatement.executeQuery();
//                        System.out.println("YESSS  "+String.valueOf(A1));
//
//                        while (resultSet.next()){
//                            rows[0] = resultSet.getString(1);
//                            rows[1] = resultSet.getString(2);
//                            rows[2] = resultSet.getString(3);
//                            rows[3] = resultSet.getString(4);
//                            rows[4] = resultSet.getString(5);
//
//                            dtm.addRow(rows);
//                        }
//                    } catch (SQLException a) {
//                        JOptionPane.showMessageDialog(null, a);
//                    }
//
//                }

            }
        });
        filter=new JButton("FIlter");
        logPanel2.add(filter);
        filter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                //System.out.println(A1);
                //System.out.println(d1);

                    try {
                        dtm.getDataVector().removeAllElements();
                        dtm.fireTableDataChanged();
                        String query = "SELECT* FROM donnerinfo WHERE Bloodgroup=? and Division=?";
                        connection = new Dbc().Connect();
                        preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setString(1,A1);
                        preparedStatement.setString(2,d1);
                        resultSet = preparedStatement.executeQuery();
                      //  System.out.println("YESSS  "+String.valueOf(A1));

                        while (resultSet.next()){
                            rows[0] = resultSet.getString(1);
                            rows[1] = resultSet.getString(2);
                            rows[2] = resultSet.getString(3);
                            rows[3] = resultSet.getString(4);
                            rows[4] = resultSet.getString(5);

                            dtm.addRow(rows);
                        }
                    } catch (SQLException a) {
                        JOptionPane.showMessageDialog(null, a);
                    }

            }
        });

        dflt=new JButton("Default");
        logPanel2.add(dflt);
        dflt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dtm.getDataVector().removeAllElements();
                    dtm.fireTableDataChanged();
                    String query = "SELECT * FROM donnerinfo";
                    connection = new Dbc().Connect();
                    preparedStatement = connection.prepareStatement(query);
                    resultSet = preparedStatement.executeQuery();

                    while (resultSet.next()){
                        rows[0] = resultSet.getString(1);
                        rows[1] = resultSet.getString(2);
                        rows[2] = resultSet.getString(3);
                        rows[3] = resultSet.getString(4);
                        rows[4] = resultSet.getString(5);

                        dtm.addRow(rows);
                    }


                } catch (SQLException a) {
                    JOptionPane.showMessageDialog(null, a);
                }
            }
        });


        JScrollPane bar=new JScrollPane(jt);
        logPanel.add(bar);





        this.setVisible(true);


    }

}
