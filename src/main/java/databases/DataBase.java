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
    public String getStringValue(String query, String tableName, int columnIndex) throws SQLException {
        String resultString = null;
        Connection connection = null;

        try {
            //open connection here
            PropertiesFile propertiesFile = new PropertiesFile();
            connection = getConnection(propertiesFile.getDataBaseLogin(), propertiesFile.getDataBasePassword());
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query + tableName);

            if (rs.next()) {
                resultString = rs.getString(columnIndex);
            }

            System.out.println(resultString);

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
        Connection connection = null;

        //open connection here
        PropertiesFile propertiesFile = new PropertiesFile();
        connection = getConnection(propertiesFile.getDataBaseLogin(), propertiesFile.getDataBasePassword());
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        ResultSetMetaData rsmd = resultSet.getMetaData();
        // get column count
        int columnCount = rsmd.getColumnCount();
        // print column Label
        for (int i = 1; i <=columnCount ; ++i) {
            System.out.print(rsmd.getColumnLabel(i) + "\t\t\t\t");
        }
        System.out.println();
        System.out.println();

        // print column Values
        while (resultSet.next()) {
            for (int i = 1; i <= columnCount; ++i) {
                String columnValue = resultSet.getString(i);
                System.out.print(columnValue + "\t\t\t\t");
                String str = rsmd.getColumnName(i) + ": " + columnValue;
                columnFields.add(str);
            }
            System.out.println();

            if (!connection.isClosed()) {
                connection.close();
            }
        }
        return columnFields;
    }

    /**
     * Method is used to get a Map
     */
//        public static HashMap<String, String> getMap () {
//
//        }


    public static void main (String[]args) throws SQLException {
        DataBase db = new DataBase();
        PropertiesFile propertiesFile = new PropertiesFile();
        db.getListOfValues("select * from ticket");
    }
}


