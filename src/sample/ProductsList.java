package sample;

/**
 * Created by abdullah on 11/15/16.
 */

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ProductsList
{
    private final SimpleIntegerProperty ProductId;
    private final SimpleStringProperty ProductName;
    private final SimpleStringProperty ProductQuantity;
    private final SimpleStringProperty ProductBarCode;
    private final SimpleIntegerProperty PerProductPrice;


    public ProductsList(int productId, String productName, String productQuantity, String productBarCode, int perProductPrice) {
        ProductId = new SimpleIntegerProperty(productId);
        ProductName = new SimpleStringProperty(productName);
        ProductQuantity = new SimpleStringProperty(productQuantity);
        ProductBarCode = new SimpleStringProperty(productBarCode);
        PerProductPrice = new SimpleIntegerProperty(perProductPrice);
    }

    public int getProductId() {
        return ProductId.get();
    }

    public SimpleIntegerProperty productIdProperty() {
        return ProductId;
    }

    public void setProductId(int productId) {
        this.ProductId.set(productId);
    }

    public String getProductName() {
        return ProductName.get();
    }

    public SimpleStringProperty productNameProperty() {
        return ProductName;
    }

    public void setProductName(String productName) {
        this.ProductName.set(productName);
    }

    public String getProductQuantity() {
        return ProductQuantity.get();
    }

    public SimpleStringProperty productQuantityProperty() {
        return ProductQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.ProductQuantity.set(productQuantity);
    }

    public String getProductBarCode() {
        return ProductBarCode.get();
    }

    public SimpleStringProperty productBarCodeProperty() {
        return ProductBarCode;
    }

    public void setProductBarCode(String productBarCode) {
        this.ProductBarCode.set(productBarCode);
    }

    public int getPerProductPrice() {
        return PerProductPrice.get();
    }

    public SimpleIntegerProperty perProductPriceProperty() {
        return PerProductPrice;
    }

    public void setPerProductPrice(int perProductPrice) {
        this.PerProductPrice.set(perProductPrice);
    }
}
