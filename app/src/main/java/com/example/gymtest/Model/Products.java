package com.example.gymtest.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Products implements Serializable {
    int id_sanpham;
    String tensanpham;
    String image;
    String gia;
    String thongtin, admin_id, soluongcon,daban, trangthai;
    ArrayList<Products> Products;

    public ArrayList<com.example.gymtest.Model.Products> getProducts() {
        return Products;
    }

    public void setProducts(ArrayList<com.example.gymtest.Model.Products> products) {
        Products = products;
    }

    public Products(int id_sanpham, String tensanpham, String image, String gia, String thongtin, String admin_id, String soluongcon, String daban, String trangthai) {
        this.id_sanpham = id_sanpham;
        this.tensanpham = tensanpham;
        this.image = image;
        this.gia = gia;
        this.thongtin = thongtin;
        this.admin_id = admin_id;
        this.soluongcon = soluongcon;
        this.daban = daban;
        this.trangthai = trangthai;
    }

    public int getId_sanpham() {
        return id_sanpham;
    }

    public void setId_sanpham(int id_sanpham) {
        this.id_sanpham = id_sanpham;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getThongtin() {
        return thongtin;
    }

    public void setThongtin(String thongtin) {
        this.thongtin = thongtin;
    }

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    public String getSoluongcon() {
        return soluongcon;
    }

    public void setSoluongcon(String soluongcon) {
        this.soluongcon = soluongcon;
    }

    public String getDaban() {
        return daban;
    }

    public void setDaban(String daban) {
        this.daban = daban;
    }
}
