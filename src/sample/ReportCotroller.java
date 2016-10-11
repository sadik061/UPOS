package sample;

/**
 * Created by abdullah on 10/11/16.
 */

import DataBase.DataBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.*;


public class ReportCotroller
{
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth=screenSize.width;
    int screenHeight=screenSize.height;

    private static ObservableList<ReportProducts> products = FXCollections.observableArrayList();

    @FXML
    private TableView producttable;
    @FXML
    public void initialize()
    {
        products.clear();
        producttable.setPrefSize(screenWidth,screenHeight);

        DataBase db=new DataBase();
        db.DBConnect();
        db.getProducts();

        TableColumn<ReportProducts, String> number = new TableColumn<>("Product Id");
        number.setCellValueFactory(new PropertyValueFactory<ReportProducts, String>("ProductId"));

        TableColumn<ReportProducts, String> name = new TableColumn<>("Product Name");
        name.setCellValueFactory(new PropertyValueFactory<ReportProducts, String>("ProductName"));

        TableColumn<ReportProducts, String> quantity = new TableColumn<>("Product Quantity");
        quantity.setCellValueFactory(new PropertyValueFactory<ReportProducts, String>("ProductQuantity"));

        TableColumn<ReportProducts, String> barcode = new TableColumn<>("Product BarCode");
        barcode.setCellValueFactory(new PropertyValueFactory<ReportProducts, String>("ProductBarCode"));

        TableColumn<ReportProducts, String> price = new TableColumn<>("Per Product Price");
        price.setCellValueFactory(new PropertyValueFactory<ReportProducts, String>("PerProductPrice"));


        producttable.setItems(products);
        producttable.getColumns().addAll(number,name,quantity,barcode,price);

    }
    public void AddintoList(ReportProducts or)
    {
        products.add(or);
    }
}
