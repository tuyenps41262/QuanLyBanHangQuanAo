
package ui;

import DAO.SanPhamDAO;
import entity.SanPham;
import java.util.List;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(850, 680);
        f.setLocationRelativeTo(null);
     //SanPhamNewJPanel nvp = new SanPhamNewJPanel();
   //  KhachHangNewJPanel nvp = new KhachHangNewJPanel();
  //  NhanVienPanel nvp = new NhanVienPanel();
  // ThongTinKhachHangNewJPanel nvp = new ThongTinKhachHangNewJPanel();
        //DangKyKhachHangNewJPanel nvp = new DangKyKhachHangNewJPanel();
      //    HoaDonNewJPanel nvp = new HoaDonNewJPanel();
     // ThongKeNewJPanel nvp = new ThongKeNewJPanel();
     Sp_GioHang nvp = new Sp_GioHang();
         f.add(nvp);
        f.setVisible(true);
//        SanPhamDAO sp = new SanPhamDAO();
//        List<SanPham> list = sp.selectAll();
//        for (SanPham sanPham : list) {
//            System.out.println(sanPham.toString());
//        }
    }
}
