package databases;

import helpfiles.PropertiesFile;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String getSingleStringValue(String query, int columnIndex) throws SQLException {
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
//        for (int i = 1; i <= columnCount; ++i) {
//            System.out.print(rsmd.getColumnLabel(i) + "\t\t\t\t");
//        }
        System.out.println();
        System.out.println();

        // get and print(optional) column Values
        while (resultSet.next()) {
            for (int i = 1; i <= columnCount; ++i) {
                String columnValue = resultSet.getString(i);
//                System.out.print(columnValue + "\t\t\t\t");
                String str = rsmd.getColumnLabel(i) + ": " + columnValue;
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
     * Method is used to check whether data isPresent in ArrayList of DataBase
     */
    public Boolean stringIsPresentInArray(String sqlQuery, String searchedString) throws SQLException {
        DataBase db = new DataBase();
        boolean isPresent = false;
        ArrayList<String> listOfDataFromDb = db.getListOfValues(sqlQuery);
        for (int i = 1; i < listOfDataFromDb.size(); i++) {
            if (listOfDataFromDb.get(i).contains(searchedString)) {
                isPresent = true;
            }
        }
        System.out.println(isPresent);
        return isPresent;
    }

    /**
     * Method is used to get resultSet, to be used when needed by Map method.
     */
    public ResultSet getResultSet(String query) throws SQLException {
        ResultSet resultSet;
        Connection connection = null;

        //open connection here
        PropertiesFile propertiesFile = new PropertiesFile();
        connection = getConnection(propertiesFile.getDataBaseLogin(), propertiesFile.getDataBasePassword());
        Statement statement = connection.createStatement();
        resultSet = statement.executeQuery(query);

        return resultSet;
    }

    /**
     * Method is used to return a Map
     */
    public Map<String, List<Object>> getMapDataFromDataBase(ResultSet resultSet, String key) throws SQLException {
        ResultSetMetaData md = resultSet.getMetaData();
        int columns = md.getColumnCount();
        Map<String, List<Object>> map = new HashMap<>(columns);

        for (int i = 1; i <= columns; ++i) {
            map.put(md.getColumnName(i), new ArrayList<>());
        }
        while (resultSet.next()) {
            for (int i = 1; i <= columns; ++i) {
                map.get(md.getColumnName(i)).add(resultSet.getObject(i));
            }
        }

        //print to console values from the Map
//        for (int i = 0; i < map.size(); i++) {
//            System.out.println(map.get(key));
//        }
        return map;
    }


    /**
     * Method is used to check whether data isPresent in a Map from DataBase
     */
    public Boolean stringIsPresentInMap(String sqlQuery, String key, String searchedString) throws SQLException {
        DataBase db = new DataBase();
        boolean isPresent = false;

        Map<String, List<Object>> mapDataFromDataBase = db.getMapDataFromDataBase(db.getResultSet(sqlQuery), key);

        for (int i = 1; i < mapDataFromDataBase.size(); i++) {
            if (mapDataFromDataBase.get(key).contains(searchedString)) {
                isPresent = true;
            }
        }
//        System.out.println("This is searched title: " + searchedString);
//        System.out.println("This is actual status, from the map: " + isPresent);
        return isPresent;
    }

    public static void main(String[] args) throws SQLException {
        DataBase db = new DataBase();
        PropertiesFile propertiesFile = new PropertiesFile();
        System.out.println(db.stringIsPresentInArray("select*from contact", "ffffff"));
    }
}


