package org.hc.pojo;

public class Dianping {
    private int did;
    private int bookId;
    private String pinjia;
    private String dpcontent;
    private int userId;
    private String dpdate;

    public Dianping(int did, int bookId, String pinjia, String dpcontent, int userId, String dpdate) {
        this.did = did;
        this.bookId = bookId;
        this.pinjia = pinjia;
        this.dpcontent = dpcontent;
        this.userId = userId;
        this.dpdate = dpdate;
    }

    public Dianping() {
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getPinjia() {
        return pinjia;
    }

    public void setPinjia(String pinjia) {
        this.pinjia = pinjia;
    }

    public String getDpcontent() {
        return dpcontent;
    }

    public void setDpcontent(String dpcontent) {
        this.dpcontent = dpcontent;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDpdate() {
        return dpdate;
    }

    public void setDpdate(String dpdate) {
        this.dpdate = dpdate;
    }
}
