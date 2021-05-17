package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Product;

public class ProductItemController {
    @FXML
    private ImageView imageView;

    @FXML
    private Label lblId;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblDescription;

    @FXML
    private Label lblMainImagePath;

    @FXML
    private Label lblIsActive;

    @FXML
    private Label lblManufacturer;


    public void setData(Product product){
        Image image = new Image(product.getMainImagePath().trim());
        imageView.setImage(image);
        lblId.setText(String.format("%d",product.getId()));
        lblTitle.setText(product.getTitle());
        lblCost.setText(String.format("%.2f",product.getCost()));
        lblDescription.setText(product.getDescription());
        lblMainImagePath.setText(product.getMainImagePath().trim());
        lblIsActive.setText(String.valueOf(product.getIsActive()));
        lblManufacturer.setText(String.valueOf(product.getManufacturer()));
    }
}
