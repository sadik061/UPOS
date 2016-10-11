/**
 * Created by abdullah on 10/11/16.
 */
package DataBase;

import com.mysql.jdbc.PreparedStatement;
import sample.ReportCotroller;
import sample.ReportProducts;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBase {
    public int myid;
    private Connection con;
    private Statement st;
    private ResultSet rs;
    String[] Name=new String[1000];
    int i=0;
    public void DBConnect()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/phpmyadmin","root","rifat20081995");
            st= con.createStatement();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error :"+ex);
        }
    }

    //Getting Data For Login
    public boolean getData(String n,String p)
    {
        try
        {
            String query="SELECT * FROM Login";
            rs=st.executeQuery(query);
            while(rs.next())
            {
                String username=rs.getString("UserName");
                String pass=rs.getString("Password");
                if(n.equals(username)&&p.equals(pass))
                {
                    con.close();
                    return true;
                }
            }
            con.close();
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Error :"+ex);
        }

        return false;
    }

    ReportCotroller rc=new ReportCotroller();
    //Getting Data For Items
    public boolean getProducts()
    {
        try
        {
            String query="SELECT * FROM UPOS_Products";
            rs=st.executeQuery(query);
            while(rs.next())
            {
                int id=Integer.parseInt(rs.getString("Id"));
                String name=rs.getString("ProductName");
                String quantity=rs.getString("ProductQuantity");
                String barcode=rs.getString("ProductBarCode");
                int price=Integer.parseInt(rs.getString("PerProductPrice"));

                ReportProducts re=new ReportProducts(id,name,quantity,barcode,price);
                rc.AddintoList(re);

            }
            con.close();
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Error :"+ex);
        }

        return false;
    }


    //Inserting Data into database from signup
    public void setData(String name,String phn,String user,String pass)
    {
        try
        {

            PreparedStatement statement=(PreparedStatement)con.prepareStatement("INSERT INTO ClientInfo(Id,Name,Phone,UserName,Password)VALUES(?,?,?,?,?)");
            statement.setInt(1,0);
            statement.setString(2, name);
            statement.setString(3,phn);
            statement.setString(4,user);
            statement.setString(5,pass);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null,"SuccesFully Registered");
            con.close();
            statement.close();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Error :"+ex);
        }
    }

}
