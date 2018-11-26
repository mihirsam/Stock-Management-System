package MainBranch.Database;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class DatabaseConn
{
    public static String dbPath = "D:\\study_materials\\Java\\Resources\\Database\\smsDemo.accdb";

    public static ResultSet MainDatabase() throws SQLException
    {
        ResultSet errorRS;
        try
        {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:ucanaccess://"+dbPath);

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
            conn = DriverManager.getConnection("jdbc:ucanaccess://"+dbPath);

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
            conn = DriverManager.getConnection("jdbc:ucanaccess://"+dbPath);

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

    public static boolean UpdateBuyData(String finalName, int finalId, int finalQuantity, double finalPrice, double TotalPrice) throws SQLException
    {
        try{
            int flag = 0;

            //setting today date
            Date today = new Date();
            String s = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a").format(today);
            SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
            Date date = simpleDate.parse(s);
            java.sql.Date sqlDate = new java.sql.Date( date.getTime() );

            Connection conn;
            conn = DriverManager.getConnection("jdbc:ucanaccess://"+dbPath);

            Statement stmt;
            stmt = conn.createStatement();


            ResultSet rs = stmt.executeQuery("SELECT * from Database");

            if(rs != null)
            {
                while(rs.next())
                {
                    String proId, proName, proQty,proPrice;
                    proId = rs.getString("ID");
                    proName = rs.getString("ProName");
                    proQty = rs.getString("Quantity");
                    proPrice = rs.getString("Price");

                    int tempId =Integer.parseInt(proId);

                    if(proName.equals(finalName) && tempId == finalId)
                    {
                        final int tempQty = Integer.parseInt(proQty)+finalQuantity;

                        PreparedStatement update = conn.prepareStatement("update Database set Quantity = ? where ID=?" );
                        update.setInt(2, tempId);
                        update.setInt(1, tempQty);
                        update.executeUpdate();

                        PreparedStatement insert = conn.prepareStatement("insert into BuyTable (ID, ProName, Quantity, Price, TotalPrice, BuyDate) VALUES(?, ?, ?, ?, ?, ?)" );
                        insert.setInt(1, tempId);
                        insert.setString(2, proName);
                        insert.setInt(3, finalQuantity);
                        insert.setDouble(4, finalPrice);
                        insert.setDouble(5, TotalPrice);
                        insert.setDate(6, sqlDate);
                        insert.executeUpdate();

                        flag++;
                       // return true;
                    }
                }
            }

            if (flag != 0)
                return true;
            else
                return false;
        }
        catch (Exception el)
        {
            el.printStackTrace();
            return false;
        }
    }

    public static boolean UpdateSalesData(int finalId, String finalName, int finalQty, double finalPrice, double TotalPrice, String custName, String custNo) throws SQLException
    {
        try
        {
            int flag = 0;

            //setting today date
            Date today = new Date();
            String s = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a").format(today);
            SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
            Date date = simpleDate.parse(s);
            java.sql.Date sqlDate = new java.sql.Date( date.getTime() );

            Connection conn;
            conn = DriverManager.getConnection("jdbc:ucanaccess://"+dbPath);

            Statement stmt;
            stmt = conn.createStatement();


            ResultSet rs = stmt.executeQuery("SELECT * from Database");

            if (rs != null)
            {
                while(rs.next())
                {
                    String proId, proName, proQty;

                    proId = rs.getString("ID");
                    proName = rs.getString("ProName");
                    proQty = rs.getString("Quantity");

                    int tempQty = Integer.parseInt(proQty);
                    int tempId = Integer.parseInt(proId);

                    if (proName.equals(finalName) && tempId == finalId && tempQty >= finalQty)
                    {
                        tempQty -= finalQty;
                        int proPrice = (int)finalPrice;
                        int totalProPrice = (int)TotalPrice;

                        PreparedStatement update = conn.prepareStatement("UPDATE Database set Quantity = ? where ID = ?");
                        update.setInt(1, tempQty);
                        update.setInt(2, tempId);
                        update.executeUpdate();

                        PreparedStatement insert = conn.prepareStatement("insert into SalesTable (ProId, ProName, CustName, CustPhNo, Price, Quantity, TotalPrice, SellDate) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
                        insert.setInt(1, tempId);
                        insert.setString(2, proName);
                        insert.setString(3, custName);
                        insert.setString(4, custNo);
                        insert.setInt(5, totalProPrice);
                        insert.setInt(6, finalQty);
                        insert.setInt(7, totalProPrice);
                        insert.setDate(8, sqlDate);
                        insert.executeUpdate();

                        flag++;
                        //return true;
                    }
                }
            }

            if (flag != 0)
                return true;
            else
                return false;
        }

        catch (Exception el)
        {
            el.printStackTrace();
            return false;
        }
    }
}
