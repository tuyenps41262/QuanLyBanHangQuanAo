
package DAO;
import entity.HoaDonChiTiet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.JdbcHelper;

public class HoaDonChiTietDAO  extends HomeDAO<HoaDonChiTiet, String>{
        String INSERT_SQL ="INSERT INTO HoaDonChitiet(SoLuong, GiaBan, IdHD, IdSP) values (?,?,?,?) ";
        String UPDATE_SQL="UPDATE HoaDonChitiet set SoLuong=?, GiaBan=?, IdSP =?, where IdHD=?";
        String DELETE_SQL="DELETE FROM HoaDonChitiet WHERE IdHD=? ";
        String SELECT_ALL="SELECT * FROM HoaDonChitiet";
        String SELECT_ALL_BYID = "SELECT * FROM HoaDonChitiet WHERE IdHD=?";
    @Override
    public void insert(HoaDonChiTiet entity) {
      JdbcHelper.update(INSERT_SQL,  entity.getSoLuong(), entity.getGiaBan(), entity.getIdHD(), entity.getIdSP());
    }

    @Override
    public void update(HoaDonChiTiet entity) {
     JdbcHelper.update(INSERT_SQL,  entity.getSoLuong(), entity.getGiaBan(), entity.getIdSP(),entity.getIdHD());
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public void delete1(String key, String key1) {
        JdbcHelper.update("delete from hoadonchitiet where idhd =? and idsp=?", key, key1);
    }

    @Override
    public List<HoaDonChiTiet> selectAll() {
          return this.selectBySQL(SELECT_ALL);
    }
     public List<HoaDonChiTiet> selectBYID1(String key) {
          return this.selectBySQL( SELECT_ALL_BYID,key);
    }

    @Override
    public HoaDonChiTiet selectById(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected List<HoaDonChiTiet> selectBySQL(String sql, Object... args) {
         List<HoaDonChiTiet> list = new ArrayList<>();
            ResultSet rs = null;
            try {
                rs = JdbcHelper.query(sql, args);
                while(rs.next()){
                     HoaDonChiTiet hdct = new HoaDonChiTiet();
                        hdct.setSoLuong(rs.getInt("SoLuong"));
                        hdct.setGiaBan(rs.getDouble("GiaBan"));
                        hdct.setIdHD(rs.getString("IdHD"));
                        hdct.setIdSP(rs.getString("IdSP"));
                   
                    list.add(hdct);
                }
                } catch (SQLException e) {
            throw new RuntimeException("Error selecting HoaDon: " + e.getMessage(), e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException("Error closing ResultSet: " + e.getMessage(), e);
                }
            }
        }
        return list;
    }
    
}
