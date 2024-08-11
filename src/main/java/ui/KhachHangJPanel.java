
package ui;

import DAO.KhachHangDAO;
import entity.khachHang;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import entity.TaiKhoan;
import DAO.TaiKhoanDAO_1;
import java.sql.SQLException;
import java.text.Normalizer;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import util.MsgBox;

public class KhachHangJPanel extends javax.swing.JPanel {
    ArrayList<khachHang> dskh = new ArrayList<>();
    ArrayList<TaiKhoan> dstk = new ArrayList<>();
    int vitri = 0;
    int flag = 0;
    private int row = 0;
    khachHang kh = new khachHang();
    TaiKhoan tk = new TaiKhoan();
    KhachHangDAO Khdao;
    TaiKhoanDAO_1 tkDao =new TaiKhoanDAO_1();
    
    public KhachHangJPanel() {
        initComponents();
        Khdao = new KhachHangDAO();
        dstk = (ArrayList<TaiKhoan>) tkDao.selectAll();
        dskh = (ArrayList<khachHang>) Khdao.selectAll();
        tblKhachHang.setRowSelectionInterval(vitri, vitri);
        HienThitable();
        ShowDetail();
        XuLytext(false);
        XuLyChucNang(true);
    }

   void HienThitable() {
    String[] header = {"IdKH", "TenKH", "Email", "DienThoai", "GioiTinh", "DiaChi"};
    DefaultTableModel model = new DefaultTableModel(header, 0);
    
    Collections.sort(dskh, Comparator.comparing(khachHang::getIdKh));
    List<khachHang> list = Khdao.SearchByID(txtTimKiem2.getText());
    
    for (khachHang kh : list) {
     //   for (TaiKhoan tk : dstk) {
        //    if (kh.getIdKh() == tk.getIdKH())
            Object[] row = {kh.getIdKh(), kh.getTenKh(), kh.getEmail(), kh.getDienThoai(), 
            kh.getGioiTinh(), kh.getDiachi()};
               model.addRow(row);
            }
      //  }
    //}
    tblKhachHang.setModel(model);
}
    
    void ShowDetail() {
    if (vitri >= 0 && vitri < dskh.size()) {
        khachHang kh = dskh.get(vitri);
        txtIdKh.setText(String.valueOf(kh.getIdKh()));
        txtTenKH.setText(kh.getTenKh());
        txtsdtKH.setText(kh.getDienThoai());
        txtEmailKH.setText(kh.getEmail());
        txtDiaChiKH.setText(kh.getDiachi());
        
        String gioiTinh = kh.getGioiTinh();
        rdoNam.setSelected(gioiTinh.equalsIgnoreCase("Nam"));
        rdoNu.setSelected(gioiTinh.equalsIgnoreCase("Nữ"));
        rdoKhac.setSelected(gioiTinh.equalsIgnoreCase("Khac"));
    }
}
     
      void edit() {
        String IdKH = tblKhachHang.getValueAt(tblKhachHang.getSelectedRow(), 0).toString();
        khachHang kh = Khdao.selectById(IdKH);
       // this.setForm(kh);
        HienThitable(); 
        Tabs.setSelectedIndex(0);
    }  
            
     void checkSo(){
        String mauDT = "(0\\d) {9,10}";
        if(!(txtsdtKH.getText().matches(mauDT))){
            JOptionPane.showMessageDialog(this, "Số điện thoại bắt đầu từ số 0");
            txtsdtKH.setText(" ");
        }
    }// kiểm tra sdt
      
     void checkEmail() {
        String mauEmail = "\\w+@\\w+(\\.\\w+){1,2}";
        if (!(txtEmailKH.getText().matches(mauEmail))) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập @gmail.com");
            txtEmailKH.setText("");
        }
    }// biểu thức chính quy email 
     
     void reset() {
        txtsdtKH.setText(" ");
        txtTenKH.setText(" ");
        txtDiaChiKH.setText("");
        txtEmailKH.setText("");
        buttonGroup1.clearSelection();
    }// xoá 
     
       void XuLyChucNang(boolean a) {
        btnLuu.setEnabled(!a);
        btnSua.setEnabled(a);
    }

    void XuLytext(boolean t) {
        txtTenKH.setEditable(t);
        txtsdtKH.setEditable(t);
        txtEmailKH.setEditable(t);
        txtDiaChiKH.setEditable(t);
        rdoNam.setEnabled(t);
        rdoNu.setEnabled(t);
        rdoKhac.setEnabled(t);
    }
    
     private void updateKH() {
        String gioiTinh;
        if (rdoNam.isSelected()) {
           gioiTinh = "Nam";
        } else if (rdoNu.isSelected()) {
            gioiTinh = "Nữ";
        } else {
            gioiTinh = "Khác";
        }
       int idKH = Integer.parseInt(txtIdKh.getText().trim());
        kh.setIdKh(idKH);
        kh.setTenKh(txtTenKH.getText().trim());
        kh.setDienThoai(txtsdtKH.getText().trim());
        kh.setGioiTinh(gioiTinh);
        kh.setDiachi(txtDiaChiKH.getText().trim());
        kh.setEmail(txtEmailKH.getText().trim());
        try {
            Khdao.update(kh);
            this.HienThitable();//cập nhật xong đổ lại vào bảng
             MsgBox.alert(this, "Cập nhật thành công");
        } catch (Exception e) {
            MsgBox.alert(this, "Cập nhật thất bại");
        }
     }

     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Tabs = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
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
        btnPrev = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        txtTimKiem2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel1.setText("KHÁCH HÀNG");

        Tabs.setBackground(new java.awt.Color(204, 153, 0));
        Tabs.setForeground(new java.awt.Color(255, 255, 255));
        Tabs.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        Tabs.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Admin Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 1, 18), new java.awt.Color(255, 102, 0))); // NOI18N

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(11, 11, 11)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtIdKh, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(rdoNam)
                            .addGap(40, 40, 40)
                            .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(rdoKhac, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtEmailKH, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtsdtKH, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdKh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu)
                    .addComponent(rdoKhac))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(txtsdtKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel25))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtEmailKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        btnPrev.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnPrev.setText("<<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnFirst.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnFirst.setText("|<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLast.setText(">|");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnLuu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLuu.setIcon(new javax.swing.ImageIcon("D:\\DuAn1_ps39536\\src\\main\\resources\\icons\\Save.png")); // NOI18N
        btnLuu.setText("Save");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon("D:\\DuAn1_ps39536\\src\\main\\resources\\icons\\Edit.png")); // NOI18N
        btnSua.setText("Update");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)
                                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSua))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(136, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrev)
                    .addComponent(btnLast)
                    .addComponent(btnNext)
                    .addComponent(btnFirst))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua)
                    .addComponent(btnLuu))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        Tabs.addTab("CẬP NHẬT", jPanel3);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TÌM KIẾM", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 102, 0))); // NOI18N

        txtTimKiem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtTimKiem2MouseReleased(evt);
            }
        });
        txtTimKiem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiem2ActionPerformed(evt);
            }
        });
        txtTimKiem2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiem2KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(209, 209, 209))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(txtTimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã KH", "Tên KH", "Email", "Điện thoại", "Giới tính", "Địa chỉ "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Tabs.addTab("DANH SÁCH", jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Tabs))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        vitri--;
        if (vitri > 0) {
            //Hienthitextbox();
            btnNext.setEnabled(true);
            btnLast.setEnabled(true);
        } else {
            vitri = 0;
            btnFirst.setEnabled(false);
            btnPrev.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Đang ở đầu danh sách!");
        }
        XuLytext(false);
        ShowDetail();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
          vitri = 0;
        ShowDetail();
        JOptionPane.showMessageDialog(null, "Đang ở đầu danh sách!");
        btnFirst.setEnabled(false);
        btnNext.setEnabled(true);
        btnPrev.setEnabled(false);
        btnLast.setEnabled(true);
        XuLytext(false); 
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        vitri++;
        if (vitri == dskh.size()) {
            vitri = dskh.size() - 1;
            btnNext.setEnabled(false);
            btnLast.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Đang ở cuối danh sách!");
        }
        btnFirst.setEnabled(true);
        btnPrev.setEnabled(true);
        XuLytext(false);
        ShowDetail();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        vitri = dskh.size() - 1;
        JOptionPane.showMessageDialog(null, "Đang ở cuối danh sách!");
        btnFirst.setEnabled(true);
        btnNext.setEnabled(false);
        btnPrev.setEnabled(true);
        btnLast.setEnabled(false);
        ShowDetail();
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        if (flag == 1) {
            updateKH();
         //   MsgBox.alert(this, "Thêm thành công");
        }
        flag=0;
        dskh.clear();
        Khdao = new KhachHangDAO();
        dskh = (ArrayList<khachHang>) Khdao.selectAll();
        ShowDetail();
        HienThitable();
         XuLyChucNang(false);
        XuLyChucNang(true);
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
          int kq = JOptionPane.showConfirmDialog(this, "Bạn có cập nhật không? ");
        if (kq == JOptionPane.YES_OPTION) {
            flag = 1;
            XuLytext(true);
            XuLyChucNang(false);
        } else {
            XuLytext(false);
        }  
    }//GEN-LAST:event_btnSuaActionPerformed

    private void txtTimKiem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiem2ActionPerformed

    private void txtTenKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKHActionPerformed

    private void txtIdKhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdKhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdKhActionPerformed

    private void txtsdtKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsdtKHActionPerformed
        // TODO add your handling code here:
        checkSo();
    }//GEN-LAST:event_txtsdtKHActionPerformed

    private void txtEmailKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailKHActionPerformed
        // TODO add your handling code here:
        checkEmail();
    }//GEN-LAST:event_txtEmailKHActionPerformed

    private void rdoNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNuActionPerformed

    private void rdoKhacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoKhacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoKhacActionPerformed

    private void txtTimKiem2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiem2MouseReleased
        // TODO add your handling code here:
        HienThitable();
    }//GEN-LAST:event_txtTimKiem2MouseReleased

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        // TODO add your handling code here:
         vitri = tblKhachHang.getSelectedRow();
         ShowDetail();
        if (evt.getClickCount() == 1) {
            this.row = tblKhachHang.rowAtPoint(evt.getPoint());
            edit();
            XuLytext(false);
        }
    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void txtTimKiem2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiem2KeyReleased
        // TODO add your handling code here:
        HienThitable();
    }//GEN-LAST:event_txtTimKiem2KeyReleased

    private void txtsdtKHKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsdtKHKeyTyped
        // TODO add your handling code here:
         char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtsdtKHKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Tabs;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSua;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rdoKhac;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextArea txtDiaChiKH;
    private javax.swing.JTextField txtEmailKH;
    private javax.swing.JTextField txtIdKh;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTimKiem2;
    private javax.swing.JTextField txtsdtKH;
    // End of variables declaration//GEN-END:variables
}
