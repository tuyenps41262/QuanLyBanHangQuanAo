/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;
import DAO.HoaDonDAO;
import DAO.QuanLyHoaDonDAO;
import DAO.KhachHangDAO;
import entity.HoaDon;
import entity.HoaDonChiTiet;
import entity.khachHang;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import util.Auth;
import util.XDate;

public class QuanLyHoaDonJPanel extends javax.swing.JPanel {

    ArrayList<HoaDon> hd = new ArrayList<>();
    ArrayList<khachHang> dskh = new ArrayList<>();
    QuanLyHoaDonDAO qlhddao;
    KhachHangDAO khdao;


    public QuanLyHoaDonJPanel() {
        initComponents();
        qlhddao = new QuanLyHoaDonDAO();
        khdao = new KhachHangDAO();
        hd = (ArrayList<HoaDon>) qlhddao.selectAll();
        dskh = (ArrayList<khachHang>) khdao.selectAll();
        HienThitable();
    }

    void HienThitable() {
        String[] header = {"ID Hóa đơn", "Điện thoại", "Trạng Thái", "Ngày lập", "Địa chỉ","Tên người nhận","Thành tiền", "ID Khách hàng"};
        DefaultTableModel model = new DefaultTableModel(header, 0);
        List<khachHang> list = khdao.SearchByID((txtTimkiem.getText()));
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtTimkiem = new javax.swing.JTextField();
        btnSreach = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tblHoaDonChiTIet = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 102));
        jLabel2.setText("Tìm kiếm:");

        btnSreach.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        btnSreach.setForeground(new java.awt.Color(255, 102, 102));
        btnSreach.setText("Tìm");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSreach)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimkiem)
                    .addComponent(btnSreach))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        tblHoaDonChiTIet.addTab("DANH SÁCH HÓA ĐƠN", jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tblHoaDonChiTIet)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(tblHoaDonChiTIet, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSreach;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTabbedPane tblHoaDonChiTIet;
    private javax.swing.JTextField txtTimkiem;
    // End of variables declaration//GEN-END:variables
}
