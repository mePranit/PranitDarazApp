package com.example.pranitdarazapp.modal;

public class Products {

    public String get_productId() {
        return _productId;
    }

    public void set_productId(String _productId) {
        this._productId = _productId;
    }

    public String get_productName() {
        return _productName;
    }

    public void set_productName(String _productName) {
        this._productName = _productName;
    }

    public String get_productPrice() {
        return _productPrice;
    }

    public void set_productPrice(String _productPrice) {
        this._productPrice = _productPrice;
    }

    public String get_productImage() {
        return _productImage;
    }

    public void set_productImage(String _productImage) {
        this._productImage = _productImage;
    }

    private String _productId;
    private String _productName;
    private String _productPrice;
    private String _productImage;

}