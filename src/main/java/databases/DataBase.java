package databases;

import helpfiles.PropertiesFile;
import org.openqa.selenium.WebElement;
import org.postgresql.core.SqlCommand;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class DataBase {
    /**
     * Method is used to establish connection with database (tickets_hub_foxminded)
     */
    public Connection getConnection(String user, String pass) throws SQLException {
        Connection conn;
        String dbURL = "jdbc:postgresql://176.36.27.131:5433/tickets_hub_foxminded";
        conn = DriverManager.getConnection(dbURL, user, pass);
        if (conn != null) {
            System.out.println("Connected to database 'tickets_hub_foxminded' is SUCCESSFUL!!!");
        } else {
            System.out.println("Connection to database'tickets_hub_foxminded' is FAILED");
        }
        return conn;
    }

    /**
     * Method is used to get a single value from the database
     */
    public String getStringValue(String query, int columnIndex) throws SQLException {
        String resultString = null;
        Connection connection = null;

        try {
            //open connection here
            PropertiesFile propertiesFile = new PropertiesFile();
            connection = getConnection(propertiesFile.getDataBaseLogin(), propertiesFile.getDataBasePassword());
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            if (rs.next()) {
                resultString = rs.getString(columnIndex);
            }

        } catch (Exception e) {
            System.out.println("Close connection");
        } finally {
            if (!connection.isClosed()) {
                connection.close();
                System.out.println();
            }
        }
        return resultString;
    }

    /**
     * Method is used to get a list of values from database
     */
    public ArrayList<String> getListOfValues(String query) throws SQLException {
        ArrayList<String> columnFields = new ArrayList<>();
        String resultString = null;
        Connection connection = null;

        try {
            //open connection here
            PropertiesFile propertiesFile = new PropertiesFile();
            connection = getConnection(propertiesFile.getDataBaseLogin(), propertiesFile.getDataBasePassword());
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = resultSet.getString(i);

                    System.out.print(rsmd.getColumnName(i) + ": " + columnValue);

                    String str = rsmd.getColumnName(i) + ": " + columnValue;
                    columnFields.add(str);
                }
                System.out.println("");
            }

        } catch (Exception e) {
            System.out.println("Close connection");
        } finally {
            if (!connection.isClosed()) {
                connection.close();
                System.out.println();
            }
        }
        return columnFields;
    }


        /**
         * Method is used to get a String
         */
//        public static String getString () {
//
//        }

        /**
         * Method is used to get a Map
         */
//        public static HashMap<String, String> getMap () {
//
//        }

        /**
         * Method is used to get a List
         */
//        public static List getList () {
//
//        }
        public static void main (String[]args) throws SQLException {
            DataBase db = new DataBase();
            PropertiesFile propertiesFile = new PropertiesFile();
            db.getListOfValues("select ticket.company_ticket_id as id from ticket left join category on ticket.id=category_id where creation_timestamp >='19.04.2018' and done_deadline <='03.05.2018'");
        }
    }


