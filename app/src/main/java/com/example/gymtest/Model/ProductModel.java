package com.example.gymtest.Model;

import java.util.ArrayList;
import java.util.List;

public class ProductModel {
    boolean success;
    String message;
    ArrayList<Products> result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Products> getResult() {
        return result;
    }

    public void setResult(ArrayList<Products> result) {
        this.result = result;
    }
}
