package DAO;

import entity.HoaDon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.JdbcHelper;


public class HoaDonDAO extends HomeDAO<HoaDon, String> {

    String INSERT_SQL = "INSERT INTO HoaDon(IdHD, DienThoai, TrangThaiThanhToan, NgayLap, DiaChi, IdKH) values (?,?,?,?,?,?) ";
    String UPDATE_SQL = "UPDATE HoaDon set DienThoai=?, TrangThaiThanhToan=?, NgayLap =?, DiaChi=?, IdKH =?, where IdHD=?";
    String DELETE_SQL = "DELETE FROM HoaDon WHERE IdHD=? ";
    String SELECT_ALL = "SELECT * FROM HoaDon";
    String SELECT_ALL_BYID = "SELECT * FROM HoaDon WHERE IdHD=?";
    String INSERT_SQLL = "INSERT INTO HoaDon(SoDienThoai, TrangThaiThanhToan, NgayLap, DiaChi, TenNguoiNhan, ThanhTien, IdKH) values (?,?,?,?,?,?,?) ";
    String SELECT_BY_IDKH = "SELECT * FROM HoaDon WHERE IdKH=?";

    @Override
    public void insert(HoaDon entity) {
        JdbcHelper.update(INSERT_SQL, entity.getIdHD(), entity.getDienThoai(), entity.getTrangThaiThanhToan(), entity.getNgayLap(), entity.getDiaChi(), entity.getIdKH());
    }

    @Override
    public void update(HoaDon entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getIdHD(), entity.getDienThoai(), entity.getTrangThaiThanhToan(), entity.getNgayLap(), entity.getDiaChi(), entity.getIdKH());
    }

    public void delete(Integer id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<HoaDon> selectAll() {
        return this.selectBySQL(SELECT_ALL);
    }

    public int taoHoaDon(HoaDon entity) {
        return JdbcHelper.updateReturnGeneratedId(INSERT_SQLL, entity.getDienThoai(), entity.getTrangThaiThanhToan(), entity.getNgayLap(), entity.getDiaChi(), entity.getTenNguoiNhan(), entity.getThanhTien(), entity.getIdKH());
    }

    public HoaDon selectById(Integer id) {
        List<HoaDon> list = this.selectBySQL(SELECT_ALL_BYID, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<HoaDon> selectById1(String id) {
        return this.selectBySQL(SELECT_ALL_BYID, id);

    }
    
    public List<HoaDon> selectByIdKH(int idKH) {
        return this.selectBySQL(SELECT_BY_IDKH, idKH); 

    }

    @Override
    protected List<HoaDon> selectBySQL(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setIdHD(rs.getString("IdHD"));
                hd.setDienThoai(rs.getString("SoDienThoai"));
                hd.setTrangThaiThanhToan(rs.getString("TrangThaiThanhToan"));
                hd.setNgayLap(rs.getDate("NgayLap"));
                hd.setDiaChi(rs.getString("DiaChi"));
                hd.setTenNguoiNhan(rs.getString("TenNguoiNhan"));
                hd.setThanhTien(rs.getDouble("ThanhTien"));
                hd.setIdKH(rs.getInt("IdKH"));

                list.add(hd);
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

    @Override
    public void delete(String key) {

    }

    public void delete1(String key, String key2) {
        JdbcHelper.update("delete *from hoadonchitiet where idhd =? and idsp=?", key, key2);
    }

    @Override
    public HoaDon selectById(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
