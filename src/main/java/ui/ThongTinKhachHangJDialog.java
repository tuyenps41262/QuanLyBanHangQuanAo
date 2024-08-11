
package ui;

import DAO.KhachHangDAO;
import DAO.TaiKhoanDAO_1;
import entity.TaiKhoan;
import entity.khachHang;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import util.Auth;

public class ThongTinKhachHangJDialog extends javax.swing.JDialog {
    ArrayList<khachHang> dskh = new ArrayList<>();
    ArrayList<TaiKhoan> dstk = new ArrayList<>();
    khachHang kh = new khachHang();
    TaiKhoan tk = new TaiKhoan();
    KhachHangDAO Khdao;
    TaiKhoanDAO_1 tkDao =new TaiKhoanDAO_1();
    
    public ThongTinKhachHangJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setLocationRelativeTo(null);
        initComponents();
        Khdao = new KhachHangDAO();
        dstk = (ArrayList<TaiKhoan>) tkDao.selectAll();
        dskh = (ArrayList<khachHang>) Khdao.selectAll();
        ShowDetail();
        XuLytext(false);
        
    }
    
    
    void ShowDetail() {
          khachHang kh = Khdao.selectById(String.valueOf(Auth.user.getIdKH()));
            txtIdKh.setText(String.valueOf(kh.getIdKh()));
            txtTenKH.setText(kh.getTenKh());
            txtsdtKH.setText(kh.getDienThoai());
            txtEmailKH.setText(kh.getEmail());
            txtDiaChiKH.setText(kh.getDiachi());
//            rdoNam.setSelected(kh.getGioiTinh().equals("Nam"));
//            rdoNu.setSelected(kh.getGioiTinh().equals("Nư"));
//            rdoKhac.setSelected(kh.getGioiTinh().equals("Khac"));             
                if (kh.getGioiTinh().equals("Nam")) {
                    rdoNam.setSelected(true);
                } else if (kh.getGioiTinh().equals("Nữ")) {
                    rdoNu.setSelected(true);
                } else {
                    rdoKhac.setSelected(true);
                }
            TaiKhoan tk = tkDao.selectById2(String.valueOf(kh.getIdKh()));
            if (tk != null) {
                 txtUser.setText(tk.getUsername());
                txtpass.setText(tk.getMatkhau());
//                buttonGroup1.clearSelection();
            } else {
              txtUser.setText("");
              txtpass.setText("");
            }
     //   }
    }
    
       void XuLytext(boolean t) {
        txtIdKh.setEditable(t);
        txtTenKH.setEditable(t);
        txtpass.setEditable(t);
        txtsdtKH.setEditable(t);
        txtEmailKH.setEditable(t);
        txtDiaChiKH.setEditable(t);
        txtUser.setEditable(t);
        rdoNam.setEnabled(t);
        rdoNu.setEnabled(t);
        rdoKhac.setEnabled(t);
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jpnUser = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtpass = new javax.swing.JPasswordField();
        jpnAdmin = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtsdtKH = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtDiaChiKH = new javax.swing.JTextArea();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtEmailKH = new javax.swing.JTextField();
        txtIdKh = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        rdoKhac = new javax.swing.JRadioButton();
        btnDoiMK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("THÔNG TIN KHÁCH HÀNG");

        jpnUser.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "User Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Variable", 1, 12), new java.awt.Color(255, 102, 0))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Password");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setText("UserName");

        txtUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnUserLayout = new javax.swing.GroupLayout(jpnUser);
        jpnUser.setLayout(jpnUserLayout);
        jpnUserLayout.setHorizontalGroup(
            jpnUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnUserLayout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnUserLayout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jpnUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jpnUserLayout.setVerticalGroup(
            jpnUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnUserLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jpnUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addGap(18, 18, 18)
                .addGroup(jpnUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jpnAdmin.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Admin Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 1, 18), new java.awt.Color(255, 102, 0))); // NOI18N

        jLabel23.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 51, 0));
        jLabel23.setText("Tên khách hàng");

        jLabel20.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 0));
        jLabel20.setText("ID khách hàng");

        txtTenKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTenKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKHActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(51, 51, 0));
        jLabel26.setText("Giới tính");

        jLabel27.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(51, 51, 0));
        jLabel27.setText("Số điện thoại");

        txtsdtKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtsdtKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsdtKHActionPerformed(evt);
            }
        });
        txtsdtKH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtsdtKHKeyTyped(evt);
            }
        });

        txtDiaChiKH.setColumns(20);
        txtDiaChiKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDiaChiKH.setRows(5);
        jScrollPane5.setViewportView(txtDiaChiKH);

        jLabel24.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 51, 0));
        jLabel24.setText("Địa chỉ");

        jLabel25.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(51, 51, 0));
        jLabel25.setText("Email");

        txtEmailKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmailKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailKHActionPerformed(evt);
            }
        });

        txtIdKh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIdKh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdKhActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoNam);
        rdoNam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoNu.setText("Nữ");
        rdoNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNuActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoKhac);
        rdoKhac.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoKhac.setText("Khác");
        rdoKhac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoKhacActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnAdminLayout = new javax.swing.GroupLayout(jpnAdmin);
        jpnAdmin.setLayout(jpnAdminLayout);
        jpnAdminLayout.setHorizontalGroup(
            jpnAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnAdminLayout.createSequentialGroup()
                        .addGroup(jpnAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(jpnAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpnAdminLayout.createSequentialGroup()
                                .addComponent(rdoNam)
                                .addGap(40, 40, 40)
                                .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdoKhac, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtsdtKH, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                            .addComponent(txtEmailKH, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpnAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtTenKH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                                .addComponent(txtIdKh, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnAdminLayout.createSequentialGroup()
                        .addGroup(jpnAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpnAdminLayout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        jpnAdminLayout.setVerticalGroup(
            jpnAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnAdminLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jpnAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpnAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdKh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpnAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu)
                    .addComponent(rdoKhac))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(txtsdtKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jpnAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtEmailKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jpnAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addContainerGap())
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpnAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(btnDoiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDoiMK)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void txtTenKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKHActionPerformed

    private void txtsdtKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsdtKHActionPerformed
        // TODO add your handling code here:
        //   checkSo();
    }//GEN-LAST:event_txtsdtKHActionPerformed

    private void txtsdtKHKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsdtKHKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsdtKHKeyTyped

    private void txtEmailKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailKHActionPerformed
        // TODO add your handling code here:
        //  checkEmail();
    }//GEN-LAST:event_txtEmailKHActionPerformed

    private void txtIdKhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdKhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdKhActionPerformed

    private void rdoNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNuActionPerformed

    private void rdoKhacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoKhacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoKhacActionPerformed

    private void btnDoiMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDoiMKActionPerformed

    private void btnDoiMKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoiMKMouseClicked
        // TODO add your handling code here:
        this.dispose(); //dong tab 
         new DoiMatKhauJDialog(null, true).setVisible(true);
            
    }//GEN-LAST:event_btnDoiMKMouseClicked

   
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
            java.util.logging.Logger.getLogger(ThongTinKhachHangJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongTinKhachHangJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongTinKhachHangJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongTinKhachHangJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThongTinKhachHangJDialog dialog = new ThongTinKhachHangJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel jpnAdmin;
    private javax.swing.JPanel jpnUser;
    private javax.swing.JRadioButton rdoKhac;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTextArea txtDiaChiKH;
    private javax.swing.JTextField txtEmailKH;
    private javax.swing.JTextField txtIdKh;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtUser;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtsdtKH;
    // End of variables declaration//GEN-END:variables

}
