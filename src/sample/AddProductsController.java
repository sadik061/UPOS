package sample;

import BarCode.Example;
import BarCode.generateRandomUnique;
import DataBase.BarCodeVarifier;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

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
    public void generateBarCode()
    {
        int number;
        do{
            generateRandomUnique gen=new generateRandomUnique(barcodestart,barcodeend);
            number=gen.generate();
        }while(generateRandomUnique.status==false);
        Example ex=new Example(number);
        try {
            ex.outputtingBarcodeAsPNG();
        } catch (BarcodeException e) {
            e.printStackTrace();
        }
        BarCodeVarifier bar=new BarCodeVarifier();
        bar.DBConnect();
        bar.setData(number);
        productcode.setText(Integer.toString(number));
    }
    public void scanBarCode()
    {

    }
}
