package library.assistant.database;

import javax.swing.*;
import java.sql.*;
import java.sql.Statement;

public class DatabaseHandler {
    private static DatabaseHandler handler;

    private static final String DB_URL = "jdbc:derby:database;create=true";
    private static Connection conn = null;
    private static Statement stmt = null;

    public DatabaseHandler(){
        createConnection();
        setUpBookTable();
    }


    public void createConnection(){
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            conn = DriverManager.getConnection(DB_URL);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setUpBookTable(){
        String tableName = "BOOK";
        try{
            stmt = conn.createStatement();
            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null,null,tableName.toUpperCase(),null);
            if(tables.next()){
                System.out.println("Table " + tableName + " exist.");
            }else {
                stmt.execute("CREATE TABLE " + tableName + "("
                    + "id varchar(200) primary key,\n"
                    + "title varchar(200),\n"
                    + "author varchar(200),\n"
                    + "publisher varchar(100),\n"
                    + "intcode varchar(100),\n"
                    + "isAvai boolean default true)");
            }
        }catch (SQLException e){
            System.err.println(e.getMessage() + " --- setupDatabase");
        }
    }


    public ResultSet execQuery(String query){
        ResultSet result;
        try{
            stmt = conn.createStatement();
            result = stmt.executeQuery(query);
        }catch (SQLException e){
            System.out.println("Exception at execQuery:dataHandler " + e.getLocalizedMessage());
            return null;
        }
        return result;
    }

    public boolean execAction(String query){
        try {
            stmt = conn.createStatement();
            stmt.execute(query);
            return true;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error Occured", JOptionPane.ERROR_MESSAGE);
            System.out.println("Exception at execQuery:dataHandler " + e.getLocalizedMessage());
            return false;
        }
    }
}
