package controllers;

import dao.Dao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import model.Product;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import service.ProductDaoImpl;

import java.io.IOException;

public class MainWindowController {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private TilePane tilePane;

    private final ObservableList<Product> products = FXCollections.observableArrayList();

    private MyListener myListener;

    FlowPane flowPane;

    public void initialize(){
        openWindow();
        rubberWindow();
        initData();

        for (Product product : products){

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/tile.fxml"));
            try {
                flowPane = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            TileController tileController = loader.getController();
            tileController.setData(product,myListener);

            tilePane.getChildren().add(flowPane);

            if (product.getIsActive() == 0)
                flowPane.setStyle("-fx-background-color: #b4b3b3");
        }
    }
    public void rubberWindow(){
        scrollPane.widthProperty().addListener((obj,oldValue,newValue) -> {
            tilePane.setPrefWidth(newValue.doubleValue());
        });
    }
    public void initData(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Dao<Product,Integer> productDaoImpl = new ProductDaoImpl(factory);
        products.addAll(productDaoImpl.readByAll());
    }
    public void openWindow(){
        myListener = product -> {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/productItem.fxml"));
            stage.setScene(new Scene(fxmlLoader.load()));
            ProductItemController productItemController = fxmlLoader.getController();
            productItemController.setData(product);
            stage.show();
        };
    }
}
