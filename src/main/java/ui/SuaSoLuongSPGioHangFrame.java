package ui;

import DAO.gioHangDAO;
import entity.GioHang;
import util.MsgBox;
import javax.swing.JOptionPane;

public class SuaSoLuongSPGioHangFrame extends javax.swing.JFrame {

    private Sp_GioHang parentPanel;
    private int soLuong;
    private String idSP;
    private int idKH;
    private String tenSanPham;

    gioHangDAO gioHangDAO;


    SuaSoLuongSPGioHangFrame(Sp_GioHang aThis, int soLuong, String idSP, int idKH, String tenSanPham) {
        initComponents();
        setLocationRelativeTo(null);
        this.parentPanel = parentPanel;
        this.soLuong = soLuong;
        this.idSP = idSP;
        this.idKH = idKH;
        this.tenSanPham = tenSanPham;
        gioHangDAO = new gioHangDAO();
        spinnerSoLuong.setValue(soLuong);
        lblTenSanPham.setText("Sản phẩm: " + tenSanPham);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSoLuong = new javax.swing.JLabel();
        spinnerSoLuong = new javax.swing.JSpinner();
        btnOk = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblTenSanPham = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblSoLuong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSoLuong.setText("Số lượng");

        btnOk.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblTenSanPham.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOk)
                        .addGap(30, 30, 30)
                        .addComponent(btnCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spinnerSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblTenSanPham)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSoLuong)
                    .addComponent(spinnerSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk)
                    .addComponent(btnCancel))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        int soluong;
        try {
            soluong = Integer.parseInt(String.valueOf(spinnerSoLuong.getValue()));
            if (soluong <= 0) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng lớn hơn 0");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng ở dạng số nguyên!");
            return;
        }

        GioHang gioHang = new GioHang();
        gioHang.setSoLuong(soluong);
        gioHang.setIdSP(this.idSP);
        gioHang.setIdKH(this.idKH);
        gioHangDAO.update(gioHang);
        this.dispose();
//        new GioHangJDialog().setVisible(true);
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        new Sp_GioHang().setVisible(true);
    }//GEN-LAST:event_btnCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JLabel lblTenSanPham;
    private javax.swing.JSpinner spinnerSoLuong;
    // End of variables declaration//GEN-END:variables
}
