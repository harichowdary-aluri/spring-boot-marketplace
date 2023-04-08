package com.productregistration.model;

import java.util.List;

public class InputProduct {
    private String productName;
    private int Quantity_available;
    private int price;
    private String category;
    private String modelNO;
    private String  noOfDaysUsed;
    private String yearOfProductSold;
    private List<FileHandle> fileHandle;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity_available() {
        return Quantity_available;
    }

    public void setQuantity_available(int quantity_available) {
        Quantity_available = quantity_available;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getModelNO() {
        return modelNO;
    }

    public void setModelNO(String modelNO) {
        this.modelNO = modelNO;
    }

    public String getNoOfDaysUsed() {
        return noOfDaysUsed;
    }

    public void setNoOfDaysUsed(String noOfDaysUsed) {
        this.noOfDaysUsed = noOfDaysUsed;
    }

    public String getYearOfProductSold() {
        return yearOfProductSold;
    }

    public void setYearOfProductSold(String yearOfProductSold) {
        this.yearOfProductSold = yearOfProductSold;
    }

    public List<FileHandle> getFileHandle() {
        return fileHandle;
    }

    public void setFileHandle(List<FileHandle> fileHandle) {
        this.fileHandle = fileHandle;
    }

}
