package sample;

import BarCode.Example;
import BarCode.generateRandomUnique;
import Data.BarCodeVarifier;
import Data.DataBase;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import net.sourceforge.barbecue.BarcodeException;

import java.util.Random;

/**
 * Created by abdullah on 10/11/16.
 */
public class AddProductsController
{
    public static int barcodestart=100000;
    public static int barcodeend=199999;
   @FXML
    private Button generate;
    @FXML
    private Button add;
    @FXML
    private Button barcode;
    @FXML
    private TextField productname;
    @FXML
    private TextField productprice;
    @FXML
    private TextField productcode;
    @FXML
    private TextField productquantity;
    @FXML
    public void initialize()
    {
        }
    public void Add()
    {
        DataBase db;
        db = new DataBase();
        db.DBConnect();
        db.setProducts(productname.getText(),productprice.getText(),productcode.getText(),productquantity.getText());

    }
    public void generateBarCode()
    {

        String bars;
        while(true)
        {
            bars=generateBarCodeString();
            generateRandomUnique gen=new generateRandomUnique();
            if(gen.check(bars))
            {
                break;
            }
            else
            {
                continue;
            }
        }

        Example ex=new Example(bars);
        try {
            ex.outputtingBarcodeAsPNG();
        } catch (BarcodeException e) {
            e.printStackTrace();
        }
        BarCodeVarifier bar=new BarCodeVarifier();
        bar.DBConnect();
        bar.setData(bars);
        productcode.setText(bars);


    }
    public void scanBarCode()
    {

    }
    private String generateBarCodeString()
    {
       String BarCode= "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 5) {
            int index = (int) (rnd.nextFloat() * BarCode.length());
            salt.append(BarCode.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
}
