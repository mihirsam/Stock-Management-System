package MainBranch.Database;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class DatabaseConn
{
    public static ResultSet MainDatabase() throws SQLException
    {
        ResultSet errorRS;

        try
        {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:ucanaccess://D:\\study_materials\\Java\\Resources\\Database\\smsDemo.accdb");

            Statement stmt;
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * from Database");

            stmt.close();
            conn.close();

            return rs;
        }

        catch (Exception e)
        {
            System.out.println("\nError in loading main database!");
            throw e;
        }
    }

    public static ResultSet SalesDatabase() throws SQLException
    {
        try
        {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:ucanaccess://D:\\study_materials\\Java\\Resources\\Database\\smsDemo.accdb");

            Statement stmt;
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * from SalesTable");

            stmt.close();
            conn.close();

            return rs;
        }

        catch(Exception e)
        {
            System.out.println("\nError in loading Sales database!");
            throw e;
        }
    }

    public static ResultSet BuyDatabase() throws SQLException
    {
        try
        {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:ucanaccess://D:\\study_materials\\Java\\Resources\\Database\\smsDemo.accdb");

            Statement stmt;
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * from BuyTable");

            stmt.close();
            conn.close();

            return rs;
        }

        catch(Exception e)
        {
            System.out.println("\nError in loading Sales database!");
            throw e;
        }
    }
}
