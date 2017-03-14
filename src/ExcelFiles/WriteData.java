package ExcelFiles;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


/**
 * Created by abdullah on 6/12/16.
 */
public class WriteData
{
    int  ordernum;
    String products;
    String price;
    int loc;
    public void setAllData(int ordernum,String products, int loc)
    {
        this.loc=loc;
        this.ordernum=ordernum;
        this.products=products;
    }
    public void write(String args)
    {
        try {

            File src=new File(args+"");

            FileInputStream fis = new FileInputStream(src);

            XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
            XSSFSheet mySheet = myWorkBook.getSheetAt(0);

                mySheet.createRow(loc);
                mySheet.getRow(loc).createCell(0).setCellValue(ordernum);

                mySheet.getRow(loc).createCell(1).setCellValue(products);

            FileOutputStream out=new FileOutputStream(src);
            myWorkBook.write(out);
                myWorkBook.close();
            }
            catch (Exception ex) {
            System.out.println("File is not Writable");
        }

    }
}
