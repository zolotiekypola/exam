package controllers;

import model.Product;

import java.io.IOException;

public interface MyListener {
    void onClickListener(Product product) throws IOException;
}
