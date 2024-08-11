package ui;

import DAO.HoaDonChiTietDAO;
import DAO.HoaDonDAO;
import DAO.SanPhamDAO;
import DAO.gioHangDAO;
import entity.GioHang;

import entity.HoaDon;
import entity.HoaDonChiTiet;
import entity.SanPham;
import java.awt.FlowLayout;
import java.awt.Image;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import util.Auth;
import util.MsgBox;
import util.XDate;

public class Sp_GioHang extends javax.swing.JPanel {

    private JPanel jpanel;

    DecimalFormat formatter = new DecimalFormat("###,###,###");
    SanPhamDAO spdao;
    gioHangDAO ghdao;
    // HoaDonDAO hddao = new HoaDonDAO();
    SanPham sp;
    List<SanPham> dssp;
    // List<HoaDon> dshd;
    int vitri = 0;
    int row = 0;
    //HoaDon hd = new HoaDon();
    //HoaDonChiTietDAO hdctdao = new HoaDonChiTietDAO();

    public Sp_GioHang() {
        initComponents();
        spdao = new SanPhamDAO();
        dssp = (ArrayList<SanPham>) spdao.selectAll();
        //   dshd = (ArrayList<HoaDon>) hddao.selectAll();
        ghdao = new gioHangDAO();
        fillToSanPham();
        fillToCart();
    }

    void fillToSanPham() {
        String[] headers = {"IdSP", "TenSP", "SoLuong", "MoTa", "GiaBan", "LoaiSp", "Hinh"};
        DefaultTableModel model = new DefaultTableModel(headers, 0);
        List<SanPham> dssp = spdao.SearchByID((txtTimKiem.getText()));
        for (SanPham s : dssp) {
            Object[] row = {s.getIdSp(), s.getTenSp(), s.getSoLuong(), s.getMoTa(), s.getGiaBan(), s.getLoaiSp(), s.getHinh()};
            model.addRow(row);
        }
        tblSanPham.setModel(model);

    }

    void fillToCart() {
        String[] headers = {"ID", "TenSP", "GiaBan", "SoLuong"};
        DefaultTableModel model = new DefaultTableModel(headers, 0);
        List<GioHang> dsGioHang = ghdao.getAllByIdKH(Auth.user.getIdKH());
        for (GioHang gh : dsGioHang) {
            Object[] row = {gh.getIdSP(), gh.getTenSP(), gh.getGiaBan(), gh.getSoLuong()};
            model.addRow(row);
        }
        tblCart.setModel(model);
    }

    public void loadData() {
        fillToSanPham();
        fillToCart();
        setEnabled(true);
    }

    
    
    public void loadDataToGioHang() {
        // Kiểm tra xem người dùng đã chọn sản phẩm chưa
        int selectedRow = tblSanPham.getSelectedRow();
        if (selectedRow == -1) {
            MsgBox.alert(this, "Vui lòng chọn sản phẩm cần thêm!");
            return;
        }

        // Lấy số lượng từ spinner
        int soLuong;
        try {
            soLuong = (int) spnSoLuong.getValue();
            if (soLuong <= 0) {
                JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0!");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng ở dạng số nguyên!");
            return;
        }

        // Lấy thông tin sản phẩm từ bảng sản phẩm
        String idSanPham = String.valueOf(tblSanPham.getValueAt(selectedRow, 0));

        // Kiểm tra xem sản phẩm đã có trong giỏ hàng chưa
        GioHang gioHang = ghdao.getOneById(idSanPham, Auth.user.getIdKH());
        if (gioHang != null) {
            // Cập nhật số lượng sản phẩm trong giỏ hàng
            soLuong += gioHang.getSoLuong();
            gioHang.setSoLuong(soLuong);
            ghdao.update(gioHang);
        } else {
            // Thêm sản phẩm mới vào giỏ hàng
            GioHang newGioHang = new GioHang();
            newGioHang.setIdSP(idSanPham);
            newGioHang.setIdKH(Auth.user.getIdKH());
            newGioHang.setSoLuong(soLuong);
            ghdao.insert(newGioHang);
        }
        // Cập nhật lại dữ liệu trong giỏ hàng
        fillToCart();
    }

   public void suaSoLuong() {
    int row = tblCart.getSelectedRow();
    if (row == -1) {
        MsgBox.alert(this, "Vui lòng chọn sản phẩm cần sửa số lượng");
    } else {
        String idSP = String.valueOf(tblCart.getValueAt(row, 0));
        String tenSanPham = String.valueOf(tblCart.getValueAt(row, 1));
        int soLuong = Integer.parseInt(String.valueOf(tblCart.getValueAt(row, 3)));
        int idKH = Auth.user.getIdKH();
        SuaSoLuongSPGioHangFrame suaFrame = new SuaSoLuongSPGioHangFrame(Sp_GioHang.this, soLuong, idSP, idKH, tenSanPham);
        suaFrame.setVisible(true);
      //  HomeKhachHangJDialog.dispose(); // Đóng HomeKhachHangJDialog
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCart = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAddCart = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoaSP = new javax.swing.JButton();
        spnSoLuong = new javax.swing.JSpinner();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SẢN PHẨM ");

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "IdSP", "TenSP", "Số lượng", "Mô tả", " giá ", "Loại sp", "hinh"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtTimKiem.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm Kiếm Sản Phẩm"));
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiem)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdSP", "Tên Sản Phẩm", "Đơn Giá", "Số lượng"
            }
        ));
        tblCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCartMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblCart);

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("GIỎ HÀNG");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel4.setText("Số lượng ");

        btnAddCart.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btnAddCart.setText("Thêm vào giỏ hàng");
        btnAddCart.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnAddCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddCartMouseClicked(evt);
            }
        });
        btnAddCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCartActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.setText("Sửa Số Lượng ");
        btnSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaMouseClicked(evt);
            }
        });
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoaSP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoaSP.setText("Xoá Sản Phẩm ");
        btnXoaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel4)
                        .addGap(34, 34, 34)
                        .addComponent(spnSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddCart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSua)
                        .addGap(51, 51, 51)
                        .addComponent(btnXoaSP)
                        .addGap(50, 50, 50))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua)
                    .addComponent(btnXoaSP)
                    .addComponent(jLabel4)
                    .addComponent(btnAddCart)
                    .addComponent(spnSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddCartMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_btnAddCartMouseClicked

    private void btnAddCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCartActionPerformed
        loadDataToGioHang();
        fillToCart();
        //txtTongTien.setText("0");
    }//GEN-LAST:event_btnAddCartActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        // TODO add your handling code here:

        //MsgBox.alert(this, "hjksdjajfjefjw");
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void tblCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCartMouseClicked
        // TODO add your handling code here:
        //filltoTableCart();
    }//GEN-LAST:event_tblCartMouseClicked

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
        fillToSanPham();
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void btnXoaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSPActionPerformed
        // TODO add your handling code here:
        int row = tblCart.getSelectedRow();
        if (row == - 1) {
            MsgBox.alert(this, "Vui lòng chọn sản phẩm cần xóa");
        } else {
            int confirm = JOptionPane.showConfirmDialog(Sp_GioHang.this, "Bạn chắc chắn muốn xóa không ?");

            if (confirm == JOptionPane.YES_OPTION) {
                String idSP = String.valueOf(tblCart.getValueAt(row, 0));
                int idKH = Auth.user.getIdKH();
                ghdao.delete(idSP, idKH);
                fillToCart();
            }
        }
    }//GEN-LAST:event_btnXoaSPActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        suaSoLuong();
        fillToCart();
        this.setEnabled(false);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaMouseClicked
        // TODO add your handling code here
        //new SuaSoLuongSPGioHangFrame().setVisible(true);
        //new SuaSoLuongSPGioHangFrame(GioHang, , TOOL_TIP_TEXT_KEY, WIDTH, TOOL_TIP_TEXT_KEY)
        
//        suaSoLuong();
//        fillToCart();
//        this.setEnabled(false);
    //new SuaSoLuongSPGioHangFrame().setVisible(true);
    //new SuaSoLuongSanPhamJDailog(parent, true).setVisible(true);

    }//GEN-LAST:event_btnSuaMouseClicked

//    private void showPanel(JPanel panel) {
//        jpanel = panel;
//        pnMain.removeAll();
//        pnMain.add(jpanel);
//        pnMain.validate();
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCart;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnXoaSP;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner spnSoLuong;
    private javax.swing.JTable tblCart;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

}
