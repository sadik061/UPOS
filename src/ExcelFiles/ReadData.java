package ExcelFiles;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import sample.ReportCotroller;
import sample.ReportProducts;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;


/**
 * Created by abdullah on 6/12/16.
 */
public class ReadData
{
    String [] arr=new String[10];
    ReportCotroller re=new ReportCotroller();
    int i=0;
    int count=0;
    public void read(String arg)
    {
        try
        {
            File src=new File(arg+"");

            FileInputStream fis = new FileInputStream(src);

            XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
            XSSFSheet mySheet = myWorkBook.getSheetAt(0);
            Iterator<Row> rowIterator = mySheet.iterator();

            while (rowIterator.hasNext())
            {
                Row row = rowIterator.next();
                // For each row, iterate through each columns
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                            arr[i]=cell.getStringCellValue();
                            i++;
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            arr[i]=Double.toString(cell.getNumericCellValue());
                            i++;
                            break;
                        default:
                    }
                }
                i=0;
                if(count!=0)
                {
                    ReportProducts or=new  ReportProducts(arr[0],arr[1],arr[2],arr[3],arr[4], arr[5]);
                    re.AddintoList(or);
                }
                count++;
            }
        }
        catch (Exception ex)
        {
            System.out.println("File is not readable");
        }
    }
}
