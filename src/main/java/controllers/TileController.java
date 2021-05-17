package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import model.Product;

import java.io.IOException;

public class TileController {
    @FXML
    private FlowPane flowPane;

    @FXML
    private ImageView imageView;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblIsActive;

    private MyListener myListener;
    private Product product;

    @FXML
    private void click(MouseEvent event) throws IOException {
        myListener.onClickListener(product);
    }

    public void setData(Product product, MyListener myListener){
        this.myListener = myListener;
        this.product = product;
        Image image = new Image(product.getMainImagePath().trim());
        imageView.setImage(image);
        lblTitle.setText(subTitle(product.getTitle()));
        lblCost.setText(String.format("%.2f",product.getCost()));
        lblIsActive.setText(isActive(product.getIsActive()));
    }

    private String subTitle(String title){
        if (title.length() < 15)
            return title;
        return title.substring(0,15) + "...";
    }

    private String isActive(int isActive){
        return isActive == 0 ? "не активен" : "";
    }
}
