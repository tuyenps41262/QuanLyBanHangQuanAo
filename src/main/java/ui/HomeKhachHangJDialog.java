package ui;

import DAO.KhachHangDAO;
import javax.swing.JPanel;
import util.Auth;

public class HomeKhachHangJDialog extends javax.swing.JDialog {

    private JPanel jpanel;
    KhachHangDAO khdao = new KhachHangDAO();

    public HomeKhachHangJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        ThongtinTaiKhoan();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblSPGioHang = new javax.swing.JLabel();
        lblHoaDon = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblTenThongTin = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblDangXuat = new javax.swing.JLabel();
        lblDatHang = new javax.swing.JLabel();
        pnMain = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblSPGioHang.setBackground(new java.awt.Color(204, 102, 0));
        lblSPGioHang.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblSPGioHang.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSPGioHang.setText("SẢN PHẨM - GIỎ HÀNG");
        lblSPGioHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSPGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSPGioHangMouseClicked(evt);
            }
        });

        lblHoaDon.setBackground(new java.awt.Color(255, 153, 0));
        lblHoaDon.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblHoaDon.setForeground(new java.awt.Color(51, 0, 51));
        lblHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblHoaDon.setText("HOÁ ĐƠN");
        lblHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHoaDonMouseClicked(evt);
            }
        });

        lblTenThongTin.setFont(new java.awt.Font("Helvetica Neue", 2, 18)); // NOI18N
        lblTenThongTin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenThongTin.setText("Văn A");
        lblTenThongTin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTenThongTinMouseClicked(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblDangXuat.setBackground(new java.awt.Color(255, 153, 0));
        lblDangXuat.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblDangXuat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDangXuat.setText("ĐĂNG XUẤT");
        lblDangXuat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDangXuatMouseClicked(evt);
            }
        });

        lblDatHang.setBackground(new java.awt.Color(255, 153, 0));
        lblDatHang.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblDatHang.setForeground(new java.awt.Color(51, 0, 51));
        lblDatHang.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDatHang.setText("ĐẶT HÀNG");
        lblDatHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDatHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDatHangMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(28, 28, 28))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(lblTenThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblSPGioHang, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDatHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addComponent(lblTenThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(lblSPGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(lblHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(lblDatHang, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(lblDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pnMain.setLayout(new java.awt.BorderLayout());

        jLabel4.setText("jLabel4");
        pnMain.add(jLabel4, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblSPGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSPGioHangMouseClicked
        showPanel(new Sp_GioHang());
    }//GEN-LAST:event_lblSPGioHangMouseClicked

    private void lblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoaDonMouseClicked
        // TODO add your handling code here:
        showPanel(new HoaDonJPanel());
    }//GEN-LAST:event_lblHoaDonMouseClicked

    private void lblTenThongTinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTenThongTinMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            new ThongTinKhachHangJDialog(null, true).setVisible(true);
        }
    }//GEN-LAST:event_lblTenThongTinMouseClicked

    private void lblDangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangXuatMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new LoginJDialog(null, true).setVisible(true);

    }//GEN-LAST:event_lblDangXuatMouseClicked

    private void lblDatHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDatHangMouseClicked
        showPanel(new DatHangJPanel());
    }//GEN-LAST:event_lblDatHangMouseClicked

    public void ThongtinTaiKhoan() {
        lblTenThongTin.setText(khdao.selectById(String.valueOf(Auth.user.getIdKH())).getTenKh());
    }

    private void showPanel(JPanel panel) {
        jpanel = panel;
        pnMain.removeAll();
        pnMain.add(jpanel);
        pnMain.validate();
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HomeKhachHangJDialog dialog = new HomeKhachHangJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDangXuat;
    private javax.swing.JLabel lblDatHang;
    private javax.swing.JLabel lblHoaDon;
    private javax.swing.JLabel lblSPGioHang;
    private javax.swing.JLabel lblTenThongTin;
    private javax.swing.JPanel pnMain;
    // End of variables declaration//GEN-END:variables
}
