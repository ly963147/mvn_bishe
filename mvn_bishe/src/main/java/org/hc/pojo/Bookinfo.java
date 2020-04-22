package org.hc.pojo;

public class Bookinfo {
    private int bookId;
    private String bookName;
    private String remark;
    private double bookPrice;
    private String author;
    private String bookImage;

    public Bookinfo(int bookId, String bookName, String remark, double bookPrice, String author, String bookImage) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.remark = remark;
        this.bookPrice = bookPrice;
        this.author = author;
        this.bookImage = bookImage;
    }

    public Bookinfo(int bookId, String bookName, String remark, double bookPrice, String author) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.remark = remark;
        this.bookPrice = bookPrice;
        this.author = author;
    }

    public Bookinfo(String bookName, String remark, double bookPrice, String author, String bookImage) {
        this.bookName = bookName;
        this.remark = remark;
        this.bookPrice = bookPrice;
        this.author = author;
        this.bookImage = bookImage;
    }

    public Bookinfo() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }
}
