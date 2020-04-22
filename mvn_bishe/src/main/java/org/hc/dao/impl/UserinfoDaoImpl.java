package org.hc.dao.impl;

import org.hc.dao.UserinfoDao;
import org.hc.pojo.Userinfo;
import org.hc.util.BaseDao;
import org.hc.util.PageUserinfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserinfoDaoImpl extends BaseDao implements UserinfoDao {
    @Override
    public List<Userinfo> all(String name) {
        List<Userinfo> list = new ArrayList<>();
        StringBuilder sql =new StringBuilder( "select * from userinfo");
        ResultSet rs =null;
        if(name!=null &&  !name.equals("")) {
            sql.append(" where loginName like ?");
            Object[] objs ={"%"+name+"%"};
            rs = this.executeSQL(sql.toString(),objs);
        }else{
            rs = this.executeSQL(sql.toString());
        }
        try {
            while (rs.next()) {
                Userinfo Users =new Userinfo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
                list.add(Users);

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            this.closeResource();
        }
        return list;
    }
    @Override
    public int addUsers(Userinfo user) {
        String sql = "insert into userinfo(loginName,loginPass,phone) values(?,?,?)";
        Object[] objs = {user.getLoginName(),user.getLoginPass(),user.getPhone()};
        return this.executeUpdate(sql, objs);
    }
    @Override
    public int updateUsers(Userinfo user) {
        String sql = "update userinfo set loginName=?,loginPass=?,phone=?,realname=?,identify=? where userId=?";
        Object[] objs = {user.getLoginName(),user.getLoginPass(),user.getPhone(),user.getRealname(),user.getIdentify(),user.getUserId()};
        return this.executeUpdate(sql, objs);
    }
    @Override
    public int delUsers(int id) {
        String sql = "delete from userinfo where userId=?";
        Object[] objs = {id};
        return this.executeUpdate(sql, objs);
    }
    @Override
    public Userinfo getUsers(int id) {
        String sql="select * from userinfo where userId=?";
        Object[] objs ={id};
        ResultSet rs = this.executeSQL(sql,objs);
        Userinfo user =null;
        try {
            while (rs.next()) {
                user=new Userinfo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            this.closeResource();
        }
        return user;
    }
    @Override
    public int login(Userinfo users) {
        String sql="SELECT count(1) from userinfo where loginName=? and loginPass=?";
        Object[] objs ={users.getLoginName(),users.getLoginPass()};
        ResultSet rs = this.executeSQL(sql,objs);
        try {
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeResource();
        }
        return 0;
    }
    @Override
    public Userinfo getUserinfoName(String loginName) {
        String sql="select * from userinfo where loginName = ? ";
        Object[] objs={loginName};
        ResultSet rs=this.executeSQL(sql,objs);
        Userinfo userinfo=null;
        try {
            while (rs.next()){
                userinfo=new Userinfo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            this.closeResource();
        }
        return userinfo;
    }

    @Override
    public int getCount() {
        String sql="select count(1) from userinfo";
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
    public List<Userinfo> getPageInfo(PageUserinfo pageInfo) {
        List<Userinfo> list= new ArrayList<>();
        ResultSet rs=null;
        String sql="select * from userinfo LIMIT ?,?";
        Object[] objs={(pageInfo.getCurrentPage()-1)*pageInfo.getRows(),pageInfo.getRows()};
        rs= this.executeSQL(sql,objs);
        try {
            while(rs.next()){
                Userinfo  userinfo=new Userinfo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
                list.add(userinfo);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            this.closeResource();
        }
        return list;
    }
}
