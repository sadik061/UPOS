package Data;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

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
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/UPOS","root","rifat20081995");
            st= con.createStatement();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error :"+ex);
        }
    }

    //Getting Data For Login
    public HashMap getAllBarCode()
    {
        HashMap<String ,Integer> arr=new HashMap<>();
        try
        {
            String query="SELECT * FROM UPOS_BarCodeNumber";
            rs=st.executeQuery(query);
            while(rs.next())
            {
                String code=rs.getString("Number");
                arr.put(code,1);
            }
            con.close();
        }catch(Exception ex)
        {
            //JOptionPane.showMessageDialog(null,"Error :"+ex);
        }
        return arr;

    }
    //Inserting Data into database
    public void setData(String number)
    {
        try
        {

            PreparedStatement statement=(PreparedStatement)con.prepareStatement("INSERT INTO UPOS_BarCodeNumber(Id,Number)VALUES(?,?)");
            statement.setInt(1,0);
            statement.setString(2, number);
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
