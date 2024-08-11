
package ui;

import DAO.NhanVienDAO;
import DAO.TaiKhoanDAO_1;
import entity.NhanVien;
import entity.TaiKhoan;
import java.util.ArrayList;
import util.Auth;

public class ThongTinNhanVienJDialog extends javax.swing.JDialog {
 ArrayList<NhanVien> dsnv = new ArrayList<>();
    ArrayList<TaiKhoan> dstk = new ArrayList<>();
    int vitri = 0;
    NhanVien nv = new NhanVien();
    TaiKhoan tk = new TaiKhoan();
    NhanVienDAO nhanVienDao = new NhanVienDAO();
    TaiKhoanDAO_1 tkDao = new TaiKhoanDAO_1();
    
    public ThongTinNhanVienJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        ShowDetail();
        XuLytext(false);
    }

      void ShowDetail() {
        NhanVien nv = nhanVienDao.selectById(String.valueOf(Auth.user.getIdNV()));
        txtIdNv.setText(String.valueOf(nv.getIdNv()));
        txtTenNv.setText(nv.getTenNv());
        txtsdtNv.setText(nv.getDienThoai());
        txtEmailNv.setText(nv.getEmail());
        txtDiaChiNv.setText(nv.getDiaChi());
//        rdoNam5.setSelected(nv.getGioiTinh().equalsIgnoreCase("Nam"));
//        rdoNu5.setSelected(nv.getGioiTinh().equalsIgnoreCase("Nư"));
//        rdoKhac5.setSelected(nv.getGioiTinh().equalsIgnoreCase("Khac"));

        if (nv.getGioiTinh().equals("Nam")) {
                    rdoNam5.setSelected(true);
                } else if (nv.getGioiTinh().equals("Nữ")) {
                    rdoNu5.setSelected(true);
                } else {
                    rdoKhac5.setSelected(true);
                }

        TaiKhoan tk = tkDao.selectByIdd(String.valueOf(nv.getIdNv()));
        if (tk != null) {
            txtUser1.setText(tk.getUsername());
            txtpass1.setText(tk.getMatkhau());
            buttonGroup1.clearSelection();
        } else {
            txtUser1.setText("");
            txtpass1.setText("");
        }
    }
        void XuLytext(boolean t) {
        txtIdNv.setEditable(t);
        txtTenNv.setEditable(t);
        txtpass1.setEditable(t);
        txtsdtNv.setEditable(t);
        txtEmailNv.setEditable(t);
        txtDiaChiNv.setEditable(t);
        txtUser1.setEditable(t);
        rdoNam5.setEnabled(t);
        rdoNu5.setEnabled(t);
        rdoKhac5.setEnabled(t);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jpnAdmin5 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        txtTenNv = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        txtsdtNv = new javax.swing.JTextField();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtDiaChiNv = new javax.swing.JTextArea();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        txtEmailNv = new javax.swing.JTextField();
        txtIdNv = new javax.swing.JTextField();
        rdoNam5 = new javax.swing.JRadioButton();
        rdoNu5 = new javax.swing.JRadioButton();
        rdoKhac5 = new javax.swing.JRadioButton();
        jpnUser1 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        txtUser1 = new javax.swing.JTextField();
        txtpass1 = new javax.swing.JPasswordField();
        btnDoiMK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("THÔNG TIN NHÂN VIÊN");

        jpnAdmin5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Admin Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 1, 18), new java.awt.Color(255, 102, 0))); // NOI18N

        jLabel50.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(51, 51, 0));
        jLabel50.setText("Tên Nhân Viên ");

        jLabel51.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(51, 51, 0));
        jLabel51.setText("ID Nhân Viên");

        txtTenNv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTenNv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenNvActionPerformed(evt);
            }
        });

        jLabel52.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(51, 51, 0));
        jLabel52.setText("Giới tính");

        jLabel53.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(51, 51, 0));
        jLabel53.setText("Số điện thoại");

        txtsdtNv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtsdtNv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsdtNvActionPerformed(evt);
            }
        });
        txtsdtNv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtsdtNvKeyTyped(evt);
            }
        });

        txtDiaChiNv.setColumns(20);
        txtDiaChiNv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDiaChiNv.setRows(5);
        jScrollPane10.setViewportView(txtDiaChiNv);

        jLabel54.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(51, 51, 0));
        jLabel54.setText("Địa chỉ");

        jLabel55.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(51, 51, 0));
        jLabel55.setText("Email");

        txtEmailNv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmailNv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailNvActionPerformed(evt);
            }
        });

        txtIdNv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIdNv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdNvActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoNam5);
        rdoNam5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoNam5.setText("Nam");

        buttonGroup1.add(rdoNu5);
        rdoNu5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoNu5.setText("Nữ");
        rdoNu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNu5ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoKhac5);
        rdoKhac5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoKhac5.setText("Khác");
        rdoKhac5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoKhac5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnAdmin5Layout = new javax.swing.GroupLayout(jpnAdmin5);
        jpnAdmin5.setLayout(jpnAdmin5Layout);
        jpnAdmin5Layout.setHorizontalGroup(
            jpnAdmin5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnAdmin5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnAdmin5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel55, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnAdmin5Layout.createSequentialGroup()
                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane10))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnAdmin5Layout.createSequentialGroup()
                        .addGroup(jpnAdmin5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel50, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(jpnAdmin5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpnAdmin5Layout.createSequentialGroup()
                                .addComponent(rdoNam5)
                                .addGap(40, 40, 40)
                                .addComponent(rdoNu5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdoKhac5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtTenNv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                            .addComponent(txtIdNv, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtsdtNv)
                            .addComponent(txtEmailNv, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(15, 15, 15))
        );
        jpnAdmin5Layout.setVerticalGroup(
            jpnAdmin5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnAdmin5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jpnAdmin5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(txtTenNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpnAdmin5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpnAdmin5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(rdoNam5)
                    .addComponent(rdoNu5)
                    .addComponent(rdoKhac5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnAdmin5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel53)
                    .addComponent(txtsdtNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jpnAdmin5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(txtEmailNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpnAdmin5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel54)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81))
        );

        jpnUser1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "User Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Variable", 1, 12), new java.awt.Color(255, 102, 0))); // NOI18N

        jLabel58.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel58.setText("Password");

        jLabel59.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel59.setText("UserName");

        txtUser1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUser1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnUser1Layout = new javax.swing.GroupLayout(jpnUser1);
        jpnUser1.setLayout(jpnUser1Layout);
        jpnUser1Layout.setHorizontalGroup(
            jpnUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnUser1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnUser1Layout.createSequentialGroup()
                        .addComponent(jLabel59)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnUser1Layout.createSequentialGroup()
                        .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jpnUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtpass1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jpnUser1Layout.setVerticalGroup(
            jpnUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnUser1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jpnUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59))
                .addGap(18, 18, 18)
                .addGroup(jpnUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        btnDoiMK.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDoiMK.setIcon(new javax.swing.ImageIcon("D:\\DuAn1_ps39536\\src\\main\\resources\\icons\\Open lock.png")); // NOI18N
        btnDoiMK.setText("Change Password");
        btnDoiMK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDoiMKMouseClicked(evt);
            }
        });
        btnDoiMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jpnAdmin5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(75, 75, 75)
                            .addComponent(jLabel1)
                            .addGap(131, 131, 131)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jpnUser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnDoiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnAdmin5, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnUser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDoiMK)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDoiMKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoiMKMouseClicked
        // TODO add your handling code here:
        new DoiMatKhauJDialog(null, true).setVisible(true);
        this.dispose(); //dong tab
    }//GEN-LAST:event_btnDoiMKMouseClicked

    private void btnDoiMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDoiMKActionPerformed

    private void txtTenNvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenNvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenNvActionPerformed

    private void txtsdtNvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsdtNvActionPerformed
        // TODO add your handling code here:
        //   checkSo();
    }//GEN-LAST:event_txtsdtNvActionPerformed

    private void txtsdtNvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsdtNvKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsdtNvKeyTyped

    private void txtEmailNvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailNvActionPerformed
        // TODO add your handling code here:
        //  checkEmail();
    }//GEN-LAST:event_txtEmailNvActionPerformed

    private void txtIdNvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdNvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdNvActionPerformed

    private void rdoNu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNu5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNu5ActionPerformed

    private void rdoKhac5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoKhac5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoKhac5ActionPerformed

    private void txtUser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUser1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUser1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThongTinNhanVienJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongTinNhanVienJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongTinNhanVienJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongTinNhanVienJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThongTinNhanVienJDialog dialog = new ThongTinNhanVienJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnDoiMK;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JPanel jpnAdmin;
    private javax.swing.JPanel jpnAdmin1;
    private javax.swing.JPanel jpnAdmin2;
    private javax.swing.JPanel jpnAdmin3;
    private javax.swing.JPanel jpnAdmin4;
    private javax.swing.JPanel jpnAdmin5;
    private javax.swing.JPanel jpnUser;
    private javax.swing.JPanel jpnUser1;
    private javax.swing.JRadioButton rdoKhac;
    private javax.swing.JRadioButton rdoKhac1;
    private javax.swing.JRadioButton rdoKhac2;
    private javax.swing.JRadioButton rdoKhac3;
    private javax.swing.JRadioButton rdoKhac4;
    private javax.swing.JRadioButton rdoKhac5;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNam1;
    private javax.swing.JRadioButton rdoNam2;
    private javax.swing.JRadioButton rdoNam3;
    private javax.swing.JRadioButton rdoNam4;
    private javax.swing.JRadioButton rdoNam5;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JRadioButton rdoNu1;
    private javax.swing.JRadioButton rdoNu2;
    private javax.swing.JRadioButton rdoNu3;
    private javax.swing.JRadioButton rdoNu4;
    private javax.swing.JRadioButton rdoNu5;
    private javax.swing.JTextArea txtDiaChiKH;
    private javax.swing.JTextArea txtDiaChiKH1;
    private javax.swing.JTextArea txtDiaChiKH2;
    private javax.swing.JTextArea txtDiaChiKH3;
    private javax.swing.JTextArea txtDiaChiKH4;
    private javax.swing.JTextArea txtDiaChiNv;
    private javax.swing.JTextField txtEmailKH;
    private javax.swing.JTextField txtEmailKH1;
    private javax.swing.JTextField txtEmailKH2;
    private javax.swing.JTextField txtEmailKH3;
    private javax.swing.JTextField txtEmailKH4;
    private javax.swing.JTextField txtEmailNv;
    private javax.swing.JTextField txtIdKh;
    private javax.swing.JTextField txtIdKh1;
    private javax.swing.JTextField txtIdKh2;
    private javax.swing.JTextField txtIdKh3;
    private javax.swing.JTextField txtIdKh4;
    private javax.swing.JTextField txtIdNv;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTenKH1;
    private javax.swing.JTextField txtTenKH2;
    private javax.swing.JTextField txtTenKH3;
    private javax.swing.JTextField txtTenKH4;
    private javax.swing.JTextField txtTenNv;
    private javax.swing.JTextField txtUser;
    private javax.swing.JTextField txtUser1;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JPasswordField txtpass1;
    private javax.swing.JTextField txtsdtKH;
    private javax.swing.JTextField txtsdtKH1;
    private javax.swing.JTextField txtsdtKH2;
    private javax.swing.JTextField txtsdtKH3;
    private javax.swing.JTextField txtsdtKH4;
    private javax.swing.JTextField txtsdtNv;
    // End of variables declaration//GEN-END:variables
}
