package DataBase;

import com.mysql.jdbc.PreparedStatement;
import sample.ReportCotroller;
import sample.ReportProducts;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by abdullah on 11/13/16.
 */




public class BarCodeVarifier{
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
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/phpmyadmin","root","rifat20081995");
            st= con.createStatement();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error :"+ex);
        }
    }

    //Getting Data For Login
    public boolean varify(int n)
    {
        try
        {
            String query="SELECT * FROM UPOS_BarCodeNumber";
            rs=st.executeQuery(query);
            while(rs.next())
            {
                int number=rs.getInt("Number");
                if(n==number)
                {
                    con.close();
                    return false;
                }
            }
            con.close();
        }catch(Exception ex)
        {
            //JOptionPane.showMessageDialog(null,"Error :"+ex);
        }

        return true;
    }
    //Inserting Data into database
    public void setData(int number)
    {
        try
        {

            PreparedStatement statement=(PreparedStatement)con.prepareStatement("INSERT INTO UPOS_BarCodeNumber(Id,Number)VALUES(?,?)");
            statement.setInt(1,0);
            statement.setInt(2, number);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null,"SuccesFully Generated");
            con.close();
            statement.close();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Error :"+ex);
        }
    }



}
