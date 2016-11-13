package BarCode;

import DataBase.BarCodeVarifier;
import sample.AddProductsController;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by abdullah on 11/13/16.
 */
public class generateRandomUnique
{
    //define ArrayList to hold Integer objects
    public static ArrayList<Integer> numbers = new ArrayList<Integer>();
    public static boolean status = false;
    public generateRandomUnique(int start,int end)
    {
        for(int i = start; i <= end; i++)
        {
            numbers.add(i+1);
        }
    }
    public static int generate()
    {

        Collections.shuffle(numbers);
        for (int i = 0; i <= 99999; i++)
        {
            BarCodeVarifier bar = new BarCodeVarifier();
            bar.DBConnect();
            status = bar.varify(numbers.get(i));
            if (status == true) {
                return numbers.get(i);
            }
            else
            {
                numbers.remove(i);
            }
        }
        if (status == false)
        {
            AddProductsController.barcodestart+=100000;
            AddProductsController.barcodeend+=100000;
        }
        return 0;
    }

}
