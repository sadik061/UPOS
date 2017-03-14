package ExcelFiles;

import org.apache.poi.xssf.usermodel.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by abdullah on 7/20/16.
 */
public class CreateXcelFile
{
    private String timeStamp = new SimpleDateFormat("yyyy/MM/dd-MM-yyyy").format(Calendar.getInstance().getTime());
    private String excelloc;

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getExcelloc() {
        return excelloc;
    }

    public void create() {
        try {

            File f = new File("c:/ExcelForPos/"+timeStamp+".xlsx");
            File txt = new File("c:/ExcelForPos/location.txt");
            if(!f.exists())
            {
                File parent_directory = f.getParentFile();
                if (null != parent_directory)
                {
                    parent_directory.mkdirs();
                }
                f.createNewFile();


                File txtParentFile= txt.getParentFile();
                if (null != parent_directory)
                {
                    parent_directory.mkdirs();
                }
                txt.createNewFile();
                //adding default value into txt that is 0
                try {
                    PrintWriter writer = new PrintWriter(txt, "UTF-8");
                    try {
                        writer.write(0);
                        writer.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }catch(Exception e)
                {
                    e.printStackTrace();
                }

                // Directory path where the xls file will be created
                String destinationFilePath =f+"";

                // Create object of FileOutputStream
                FileOutputStream fout = new FileOutputStream(destinationFilePath);

                // Build the Excel File
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                XSSFWorkbook workBook = new XSSFWorkbook();

                // Create the spreadsheet
                XSSFSheet spreadSheet = workBook.createSheet("Hello_World");

                // Create the first row
                XSSFRow row = spreadSheet.createRow((short) 0);

                // Create the cells and write to the file
                XSSFCell cell;
                spreadSheet.setColumnWidth(0, 5000);
                spreadSheet.setColumnWidth(1, 10000);

                // Write default value
                cell = row.createCell(0);
                cell.setCellValue(new XSSFRichTextString("Order Number"));

                // Write dafault value
                cell = row.createCell(1);
                cell.setCellValue(new XSSFRichTextString("Product Name"));

                // Write dafault value
                cell = row.createCell(2);
                cell.setCellValue(new XSSFRichTextString("Product Quantity"));

                // Write dafault value
                cell = row.createCell(3);
                cell.setCellValue(new XSSFRichTextString("Product BarCode"));

                // Write dafault value
                cell = row.createCell(4);
                cell.setCellValue(new XSSFRichTextString("Per Product Price"));

                // Write dafault value
                cell = row.createCell(5);
                cell.setCellValue(new XSSFRichTextString("Total Price"));

                workBook.write(outputStream);

                outputStream.writeTo(fout);
                outputStream.close();

                fout.close();
                System.out.println(f.toString());
                excelloc=f.toString();
            }


        } catch (Exception ex) {
            System.out.println("Unable to Create File");
        }
    }
}

