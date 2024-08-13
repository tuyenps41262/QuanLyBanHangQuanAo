
package ui;

import DAO.HoaDonChiTietDAO;
import DAO.HoaDonDAO;
import DAO.KhachHangDAO;
import entity.HoaDon;
import entity.HoaDonChiTiet;
import entity.khachHang;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import util.Auth;
import util.XDate;

public class HoaDonJPanel extends javax.swing.JPanel {
    ArrayList<HoaDon> hd = new ArrayList<>();
    ArrayList<khachHang> dskh = new ArrayList<>();
    ArrayList<HoaDonChiTiet> dshdct = new ArrayList<>();
    HoaDonDAO hddao;
    KhachHangDAO khdao;
    HoaDonChiTietDAO hdctdao;
    
    
    
    public HoaDonJPanel() {
        initComponents();
        hddao = new HoaDonDAO();
        khdao = new KhachHangDAO();
        hd = (ArrayList<HoaDon>) hddao.selectByIdKH(Auth.user.getIdKH());
        dskh = (ArrayList<khachHang>) khdao.selectAll();
        HienThitable();
    }
    
    void HienThitable() {
        String[] header = {"ID Hóa đơn", "Điện thoại", "Trạng Thái", "Ngày lập", "Địa chỉ","Tên người nhận","Thành tiền", "ID Khách hàng"};
        DefaultTableModel model = new DefaultTableModel(header, 0);
//        List<khachHang> list = Khdao.SearchByID((txtTimKiem2.getText()));
        for (HoaDon x : hd) {
            for (khachHang s : dskh) {
                if (x.getIdKH() == s.getIdKh()) {
                    model.addRow(new Object[]{x.getIdHD(), x.getDienThoai(), x.getTrangThaiThanhToan(),XDate.toString(x.getNgayLap(), "yyyy/MM/dd"), x.getDiaChi(),x.getTenNguoiNhan(),x.getThanhTien(), x.getIdKH()});

                }
            }
        }
         tblHoaDon.setModel(model);
    }
    
  
     
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tblHoaDonChiTIet = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 102));
        jLabel1.setText("HÓA ĐƠN");

        tblHoaDonChiTIet.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id Hóa Đơn", "Điện Thoại", "Trạng Thai Hóa Đơn", "Ngày Lập", "Địa Chỉ", "Id Khách Hàng"
            }
        ));
        jScrollPane1.setViewportView(tblHoaDon);

        tblHoaDonChiTIet.addTab("Hóa đơn của bạn", jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tblHoaDonChiTIet, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(367, 367, 367)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tblHoaDonChiTIet, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTabbedPane tblHoaDonChiTIet;
    // End of variables declaration//GEN-END:variables
}
