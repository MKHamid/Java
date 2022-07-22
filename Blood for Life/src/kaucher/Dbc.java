package kaucher;

import java.sql.*;

public class Dbc {

    Connection connection;

    public Connection Connect() throws SQLException {
        String dbUrl = "jdbc:mysql://localhost:3306/bloodforlife";
        String user = "root";
        String password = "";

        connection = DriverManager.getConnection(dbUrl, user, password);
        connection.setAutoCommit(true);
        System.out.println("Database Connection Successful");
        return connection;
    }
}





/**

public class Dbc {
        private Connection connection;
        private Statement statement;

        public Dbc(){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodforlife", "root", "");
                statement = connection.createStatement();
            }catch (Exception e){
                System.out.println("Connection Failed");
            }
        }

        public void get(String query) {
            try{
                ResultSet rs = statement.executeQuery(query);
                while(rs.next()){
                    //System.out.println(rs.getString(7));
                }
            } catch (Exception e) {
                System.out.println("ERROR");
            }
        }

        public String getText(String query) throws SQLException {
            String text = null;
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                text = rs.getString(7);
            }
            return text;
        }

        public void insert(String query) {
            try{
                statement.executeUpdate(query); // insert or update
            } catch (Exception e) {
                System.out.println("Insertion Failed");
            }
        }
    }


    //CREATE TABLE donnerinfo(Name VARCHAR(30),Bloodgroup VARCHAR(30),Phone VARCHAR(30),Adress VARCHAR(30),Division VARCHAR(30),Ussername VARCHAR(30),pass VARCHAR(30));

 */