package sample;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by abdullah on 10/11/16.
 */
public class ReportProducts
{
    private final SimpleStringProperty ProductId;
    private final SimpleStringProperty ProductName;
    private final SimpleStringProperty ProductQuantity;
    private final SimpleStringProperty ProductBarCode;
    private final SimpleStringProperty PerProductPrice;
    private final SimpleStringProperty TotalPrice;




    public ReportProducts(String productId, String productName, String productQuantity, String productBarCode, String perProductPrice, String totalPrice) {
        ProductId = new SimpleStringProperty(productId);
        ProductName = new SimpleStringProperty(productName);
        ProductQuantity = new SimpleStringProperty(productQuantity);
        ProductBarCode = new SimpleStringProperty(productBarCode);
        PerProductPrice = new SimpleStringProperty(perProductPrice);
        TotalPrice =  new SimpleStringProperty(totalPrice);

    }

    public String getProductId() {
        return ProductId.get();
    }

    public SimpleStringProperty productIdProperty() {
        return ProductId;
    }

    public void setProductId(String productId) {
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

    public String getPerProductPrice() {
        return PerProductPrice.get();
    }

    public SimpleStringProperty perProductPriceProperty() {
        return PerProductPrice;
    }

    public void setPerProductPrice(String perProductPrice) {
        this.PerProductPrice.set(perProductPrice);
    }
    public String getTotalPrice() {
        return TotalPrice.get();
    }

    public SimpleStringProperty totalPriceProperty() {
        return TotalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.TotalPrice.set(totalPrice);
    }
}
