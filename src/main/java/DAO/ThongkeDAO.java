package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.JdbcHelper;

public class ThongkeDAO {
    public List<Object[]> getThongKeTheoNam(int nam) {
        List<Object[]> list = new ArrayList<>();
        String sql = "{CALL sp_ThongKeTheoNam(?)}";
        
        try {
            ResultSet rs = JdbcHelper.query(sql, nam);
            while (rs.next()) {
                Object[] row = {
                    rs.getString("IdSP"),
                    rs.getString("TenSP"),
                    rs.getDouble("DoanhThu"),
                    rs.getInt("SoLuongBan"),
                    rs.getInt("LuongKhachHang")
                };
                list.add(row);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


