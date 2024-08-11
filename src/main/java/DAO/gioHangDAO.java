
package DAO;
import entity.GioHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.JdbcHelper;


public class gioHangDAO extends HomeDAO<GioHang, String>{
    String INSERT_SQL = "insert into GioHang(IdSP, SoLuong, IdKH) values(?, ?, ?)";
    String SELECT_ALL_BY_IDKH = "SELECT gh.IdSP, sp.TenSP, sp.GiaBan, gh.SoLuong FROM GioHang gh LEFT JOIN SanPham sp ON gh.IdSP = sp.IdSP WHERE IdKH = ?";
    String SELECT_ONE_SQL = "SELECT * FROM GioHang WHERE Idsp = ? AND IdKH = ?";
    String DELETE_SQL = "DELETE GioHang WHERE IdSP = ? and IdKH = ?";
    String UPDATE_SQL = "UPDATE GioHang set SoLuong = ? where Idsp = ? AND IdKH = ?";
    
    public boolean delete(String idSP, int idKH) {
        int result = JdbcHelper.update(DELETE_SQL, idSP, idKH);
        return result > 0;
    }
    
    @Override
    public void insert(GioHang entity) {
       JdbcHelper.update(INSERT_SQL, entity.getIdSP(), entity.getSoLuong(), entity.getIdKH());
    }

    @Override
    public void update(GioHang entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getSoLuong(), entity.getIdSP(), entity.getIdKH());
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<GioHang> selectAll() {
        return this.selectBySQL("select * from GioHang");
    }

    public List<GioHang> getAllByIdKH(int idKH) {
        List<GioHang> list = new ArrayList<GioHang>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.query(SELECT_ALL_BY_IDKH, idKH);
                while (rs.next()) {
                    GioHang gioHang = new GioHang();
                    gioHang.setIdSP(rs.getString("idSP"));
                    //gioHang.setIdKH(rs.getInt("idKH"));
                    gioHang.setTenSP(rs.getString("TenSP"));
                    gioHang.setGiaBan(rs.getDouble("GiaBan"));
                    gioHang.setSoLuong(rs.getInt("soLuong"));
                    
                    list.add(gioHang);
                }

            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    protected List<GioHang> selectBySQL(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public GioHang selectById(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public GioHang getOneById(String idSP, int idKH) {
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.query(SELECT_ONE_SQL, idSP, idKH);
                while (rs.next()) {
                    GioHang gioHang = new GioHang();
                    gioHang.setIdSP(rs.getString("idSP"));
                    gioHang.setIdKH(rs.getInt("idKH"));
                    gioHang.setSoLuong(rs.getInt("soLuong"));
                    return gioHang;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
    
}
