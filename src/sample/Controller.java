package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.io.IOException;

public class Controller
{
    @FXML
    private TabPane tabpane;
    @FXML
    private Tab home;
    @FXML
    private Tab view;
    @FXML
    private Tab transiction;
    @FXML
    private Tab report;
    @FXML
    private Tab products;
    @FXML
    private Tab addproducts;
    @FXML
    public void initialize()
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth=screenSize.width;
        int screenHeight=screenSize.height;
        tabpane.setPrefSize(screenWidth,screenHeight);
        //for adding a fxml file in the tab view
        /*
        Node node;
        try {
            node = (Node) FXMLLoader.load(getClass().getResource("Home.fxml"));
            homepane.getChildren().setAll(node);
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        tabpane.getSelectionModel().selectedItemProperty().addListener((e, o, n) -> {
            // Load ProductPane content:
            if(n == home)
            {
                loadHomeTab();
            }
            else if(n == view)
            {
                loadViewTab();
            }
            else if(n == transiction)
            {
                loadTransictionTab();
            }
            else if(n == report)
            {
                loadReportTab();
            }
            else if(n == products)
            {
                loadProductsTab();
            }
            else if(n == addproducts)
            {
                loadAddProductsTab();
            }
        });
    }
    private void loadHomeTab() {
        try {

            Parent p = FXMLLoader.load(getClass().getResource("Home.fxml"));
            home.setContent(p);

        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    private void loadViewTab() {
        try {

            Parent p = FXMLLoader.load(getClass().getResource("View.fxml"));
            view.setContent(p);

        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    private void loadTransictionTab() {
        try {

            Parent p = FXMLLoader.load(getClass().getResource("Transiction.fxml"));
            transiction.setContent(p);

        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    private void loadReportTab() {
        try {

            Parent p = FXMLLoader.load(getClass().getResource("Report.fxml"));
            report.setContent(p);

        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    private void loadProductsTab() {
        try {

            Parent p = FXMLLoader.load(getClass().getResource("Products.fxml"));
            products.setContent(p);

        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    private void loadAddProductsTab() {
        try {

            Parent p = FXMLLoader.load(getClass().getResource("AddProducts.fxml"));
            addproducts.setContent(p);

        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    //for go to another tab by a button click
    public void gotoTab(ActionEvent event)
    {
        tabpane.getSelectionModel().select(view);
    }

}
