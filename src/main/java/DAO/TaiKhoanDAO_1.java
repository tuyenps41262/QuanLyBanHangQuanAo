
package DAO;
import entity.TaiKhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import util.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.MsgBox;

public class TaiKhoanDAO_1 extends HomeDAO<TaiKhoan, String> {
   
    public static TaiKhoanDAO_1 getInstance() {
         return new TaiKhoanDAO_1();
    }
    private String username;
    private String SQL_USERNAME = "Select * from  TaiKhoan  where username=? and matkhau =? ";
     
      @Override
    public void insert(TaiKhoan entity) {
    }

    @Override
    public void update(TaiKhoan entity) {
        JdbcHelper.update("Update TaiKhoan set  username=?, matkhau=? , vaitro=? , trangthai=? where username=?", 
            entity.getUsername(),entity.getMatkhau(),entity.getVaitro(), entity.isTrangthai(),entity.getUsername());
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
   @Override
    public List<TaiKhoan> selectAll() {
        String sql= "Select * from  TaiKhoan ";
        return this.selectBySQL(sql);
    }
    
    public TaiKhoan selectById(String username, String password) {
            List<TaiKhoan> list= this. selectBySQL(SQL_USERNAME, username, password );
            return list.size() >0 ? list.get(0): null;
    }
    
    public TaiKhoan selectById1 (String username) {
            String sql = " Select * from  TaiKhoan  where IDNV=?";
            List<TaiKhoan> list= this. selectBySQL(sql, username);
            return list.size() >0 ? list.get(0): null;
    }
    
    public TaiKhoan selectById2(String username) {
            String sql = " Select * from  TaiKhoan  where IDKH=?";
            List<TaiKhoan> list= this. selectBySQL(sql, username);
            return list.size() >0 ? list.get(0): null;
    }

    public TaiKhoan selectByIdd(String id) {
        String sql = "SELECT * FROM TaiKhoan WHERE idnv = ?";
        List<TaiKhoan> list = this.selectBySQL(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }
    
      public boolean checkLogin(String username, String MatKhau) {
        List<TaiKhoan> users = getUserByID(username);
        for (TaiKhoan tk : users) {
            if (tk.getMatkhau().equals(MatKhau)) {
                return true;
            }
        }
        return false;
    } 

     public List<TaiKhoan> getUserByID(String HoTen) {
        List<TaiKhoan> users = new ArrayList<>();
        PreparedStatement sttm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM  TaiKhoan  WHERE username = ?";
//            sttm = PreparedStatement(sql);
            sttm.setString(1, username);
            rs = sttm.executeQuery();
            while (rs.next()) {
                 TaiKhoan user = new TaiKhoan();
                user.setUsername(rs.getString("username"));
                user.setMatkhau(rs.getString("matkhau"));
                user.setVaitro(rs.getString("vaitro"));
                //
                user.setTrangthai(rs.getBoolean("trangthai"));
                user.setIdNV(rs.getInt("IdNV"));
                user.setIdKH(rs.getInt("IdKH"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (sttm != null) {
                    sttm.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing database resources: " + e.toString());
            }
        }
        return users;
    }
     
    @Override
    protected List<TaiKhoan> selectBySQL(String sql, Object... args) {
       List<TaiKhoan> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.query(sql, args);
                while(rs.next()){
                    TaiKhoan entity=new TaiKhoan();
                    entity.setUsername(rs.getString("username"));
                    entity.setMatkhau(rs.getString("matkhau"));
                    entity.setVaitro(rs.getString("vaitro"));
                    entity.setTrangthai(rs.getBoolean("trangthai"));
                    entity.setIdNV(rs.getInt("IdNV"));
                     entity.setIdKH(rs.getInt("IdKH"));
                    
                    list.add(entity);
                }
            } 
            finally{
                if(rs != null)
                    rs.getStatement().getConnection().close();
            }
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return list;
    }

    @Override
    public TaiKhoan selectById(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
  
}
