
package DAO;

import entity.NhanVien;
import entity.TaiKhoan;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import util.JdbcHelper;
import java.util.List;

public class NhanVienDAO extends HomeDAO<NhanVien, String> {

    String INSERT_SQL = "INSERT INTO NhanVien(IdNV,TenNv, DienThoai, Email, GioiTinh, DiaChi) values (?,?,?,?,?,?) ";
    String UPDATE_SQL = "UPDATE NhanVien set TenNv=?, DienThoai=?, Email=?, GioiTinh=?, DiaChi=? where IdNV=?";
    String DELETE_SQL = "DELETE FROM NhanVien WHERE IdNV=? ";
    String SELECT_ALL = "SELECT * FROM NhanVien";
    String SELECT_ALL_BYID = "SELECT * FROM NhanVien WHERE IdNV=?";
    int nhanvienid;

    @Override
    public void insert(NhanVien nv) {
        JdbcHelper.update(INSERT_SQL, nv.getIdNv(), nv.getTenNv(), nv.getDienThoai(), nv.getEmail(), nv.getGioiTinh(), nv.getDiaChi());
    }

    @Override
    public void update(NhanVien nv) {
        JdbcHelper.update(UPDATE_SQL, nv.getTenNv(), nv.getDienThoai(), nv.getEmail(), nv.getGioiTinh(), nv.getDiaChi(), nv.getIdNv());

    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<NhanVien> selectAll() {
        return this.selectBySQL(SELECT_ALL);

    }

    @Override
    public NhanVien selectById(String id) {
        List<NhanVien> list = this.selectBySQL(SELECT_ALL_BYID, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<NhanVien> selectBySQL(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.query(sql, args);
                while (rs.next()) {
                    NhanVien nv = new NhanVien();
                    nv.setIdNv(rs.getInt("IdNV"));
                    nv.setTenNv(rs.getString("TenNV"));
                    nv.setDienThoai(rs.getString("DienThoai"));
                    nv.setEmail(rs.getString("Email"));
                    nv.setGioiTinh(rs.getString("GioiTinh"));
                    nv.setDiaChi(rs.getString("DiaChi"));
                    list.add(nv);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public int getNhanVienID() {
        return nhanvienid;
    }

    public void createNhanVienAndUser(String hoTen, String dienthoai, String email, String gioitinh, String diachi,
            String username, String password, String vaitro, boolean trangthai) throws SQLException {
        String sql = "{CALL sp_CreateNhanVienAndUser(?,?,?,?,?,?,?,?,?)}";
        JdbcHelper.update(sql, hoTen, dienthoai, email, gioitinh, diachi,
                username, password, vaitro, trangthai);

    }
    
     public List<NhanVien> SearchByID(String key ){
             String sql = " select * from nhanvien where idNV like ? or tenNV in( select tenNV from nhanvien where tenNV like ?) ";
            return this.selectBySQL(sql, "%"+key+"%", "%"+key +"%");
    }
}

