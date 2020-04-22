package org.hc.dao.impl;

import org.hc.dao.DianpingDao;
import org.hc.pojo.Dianping;
import org.hc.util.BaseDao;
import org.hc.util.PageDianping;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DianpingDaoImpl extends BaseDao implements DianpingDao {
    @Override
    public List<Dianping> all(int id) {
        List<Dianping> list = new ArrayList<>();
        String sql ="select * from dianping where bookId = ?";
        Object[] objs ={id};
        ResultSet rs =null;
        rs = this.executeSQL(sql,objs);
        try {
            while (rs.next()) {
                Dianping dianping =new Dianping(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6));
                list.add(dianping);

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            this.closeResource();
        }
        return list;
    }

    @Override
    public int getCount() {
        String sql="select count(1) from dianping";
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
    public List<Dianping> getPageInfo(PageDianping pageDianping) {
        List<Dianping> list= new ArrayList<>();
        ResultSet rs=null;
        String sql="select * from dianping LIMIT ?,?";
        Object[] objs={(pageDianping.getCurrentPage()-1)*pageDianping.getRows(),pageDianping.getRows()};
        rs= this.executeSQL(sql,objs);
        try {
            while(rs.next()){
                Dianping dianping=new Dianping(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6));
                list.add(dianping);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            this.closeResource();
        }
        return list;
    }

    @Override
    public int delDianping(int id) {
        String sql = "delete from dianping where did=?";
        Object[] objs = {id};
        return this.executeUpdate(sql, objs);
    }
}
