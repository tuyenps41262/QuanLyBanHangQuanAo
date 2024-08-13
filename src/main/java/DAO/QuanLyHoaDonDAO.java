package DAO;

import entity.HoaDon;
import entity.khachHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.JdbcHelper;
import util.XDate;

public class QuanLyHoaDonDAO extends HomeDAO<HoaDon, String> {

    String SELECT_ALL = "SELECT * FROM HoaDon";

    @Override
    public List<HoaDon> selectAll() {
        return this.selectBySQL(SELECT_ALL);
    }

    @Override
    public void insert(HoaDon entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(HoaDon entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public HoaDon selectById(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    public List<HoaDon> SearchByID(String key) {
        String sql = " select * from KhachHang where IdKH like ? or TenKH in( select TenKH from KhachHang where TenKH like ?) ";
        return this.selectBySQL(sql, "%" + key + "%", "%" + key + "%");
    }
}
