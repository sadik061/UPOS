package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    static Stage window;

    public static Stage getWindow() {
        return window;
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Process process = Runtime.getRuntime().exec("C:\\xampp\\xampp_start.exe");
        Process process1 = Runtime.getRuntime().exec("C:\\xampp\\mysql\\bin\\mysqld.exe");
        window= primaryStage;
        window.setTitle("ZAM ZAM SUPER SHOP");
        window.setScene(new Scene(root, 300, 275));
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
