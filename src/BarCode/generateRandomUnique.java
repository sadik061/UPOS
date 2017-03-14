package BarCode;

import Data.BarCodeVarifier;

import java.util.HashMap;

/**
 * Created by abdullah on 11/13/16.
 */
public class generateRandomUnique
{
    //define ArrayList to hold Integer objects
    public static HashMap<String ,Integer> arr=new HashMap<>();
    public boolean check(String data)
    {
        BarCodeVarifier bar=new BarCodeVarifier();
        bar.DBConnect();
        arr=bar.getAllBarCode();

            if(arr.containsKey(data))
            {
                return false;
            }
            else
            {
                return true;
            }

    }



}
