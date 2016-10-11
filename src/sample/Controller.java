package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
    private AnchorPane homepane;
    @FXML
    private AnchorPane viewpane;
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
        home.setClosable(false);
    }
    //for go to another tab by a button click
    public void gotoTab(ActionEvent event)
    {
        tabpane.getSelectionModel().select(view);
    }

}
