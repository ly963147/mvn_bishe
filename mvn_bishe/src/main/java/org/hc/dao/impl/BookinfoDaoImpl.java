package org.hc.dao.impl;

import org.hc.dao.BookinfoDao;
import org.hc.pojo.Bookinfo;
import org.hc.util.BaseDao;
import org.hc.util.PageBookinfo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookinfoDaoImpl extends BaseDao implements BookinfoDao {
    @Override
    public int getCount() {
        String sql="select count(1) from bookinfo";
        ResultSet rs=this.executeSQL(sql);
        try {
            rs.next();
            return rs.getInt(1);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            this.closeResource();
        }
        return 0;
    }
    @Override
    public List<Bookinfo> getPageInfo(PageBookinfo pageBookinfo) {
        List<Bookinfo> list= new ArrayList<>();
        ResultSet rs=null;
        String sql="select * from bookinfo LIMIT ?,?";
        Object[] objs={(pageBookinfo.getCurrentPage()-1)*pageBookinfo.getRows(),pageBookinfo.getRows()};
        rs= this.executeSQL(sql,objs);
        try {
            while(rs.next()){
                Bookinfo bookinfo=new Bookinfo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5),rs.getString(6));
                list.add(bookinfo);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            this.closeResource();
        }
        return list;
    }

    @Override
    public int addBooks(Bookinfo bookinfo) {
        String sql = "insert into bookinfo(bookName,remark,bookPrice,author,bookImage) values(?,?,?,?,?)";
        Object[] objs = {bookinfo.getBookName(),bookinfo.getRemark(),bookinfo.getBookPrice(),bookinfo.getAuthor(),bookinfo.getBookImage()};
        return this.executeUpdate(sql, objs);
    }

    @Override
    public int updateBooks(Bookinfo bookinfo) {
        String sql = "update bookinfo set bookName=?,remark=?,bookPrice=?,author=? where bookId=?";
        Object[] objs = {bookinfo.getBookName(),bookinfo.getRemark(),bookinfo.getBookPrice(),bookinfo.getAuthor(),bookinfo.getBookId()};
        return this.executeUpdate(sql, objs);
    }

    @Override
    public int delBooks(int id) {
        String sql = "delete from bookinfo where bookId=?";
        Object[] objs = {id};
        return this.executeUpdate(sql, objs);
    }

    @Override
    public Bookinfo getBooks(int id) {
        String sql="select * from bookinfo where bookId=?";
        Object[] objs ={id};
        ResultSet rs = this.executeSQL(sql,objs);
        Bookinfo book =null;
        try {
            while (rs.next()) {
                book=new Bookinfo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5),rs.getString(6));
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            this.closeResource();
        }
        return book;
    }

    @Override
    public Bookinfo getBooks(String name) {
        String sql="select * from bookinfo where bookName = ? ";
        Object[] objs={name};
        ResultSet rs=this.executeSQL(sql,objs);
        Bookinfo bookinfo=null;
        try {
            while (rs.next()){
               bookinfo=new Bookinfo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5),rs.getString(6));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            this.closeResource();
        }
        return bookinfo;
    }
}
