
package ui;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import DAO.NhanVienDAO;
import entity.NhanVien;
import entity.TaiKhoan;
import java.sql.SQLException;
import java.text.Normalizer;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;
import DAO.TaiKhoanDAO_1;
import java.util.Collections;
import java.util.Comparator;
import util.MsgBox;

public class NhanVienPanel extends javax.swing.JPanel {

    List<NhanVien> dsnv = new ArrayList<>();
    List<TaiKhoan> dstk = new ArrayList<>();
    int vitri = 0;
    int flag = 0;
    private int row = 0;
    NhanVien nv = new NhanVien();
    TaiKhoan tk = new TaiKhoan();
    NhanVienDAO nvdao;
    TaiKhoanDAO_1 tkdao = new TaiKhoanDAO_1();  
    
    public NhanVienPanel() {
        nvdao = new NhanVienDAO();
        dstk = (ArrayList<TaiKhoan>) tkdao.selectAll();
        dsnv = (ArrayList<NhanVien>) nvdao.selectAll();
        initComponents();
        tblNhanVien.setRowSelectionInterval(vitri, vitri);
        Hienthitextbox();
        hienthidslen_Table();
        XuLytext(false);
        XuLyChucNang(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        Tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        txttenNV = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        rdoKhac = new javax.swing.JRadioButton();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        lblEmail1 = new javax.swing.JLabel();
        txtDienThoai = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtidNV = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtpass = new javax.swing.JPasswordField();
        rdoHoatDong = new javax.swing.JRadioButton();
        rdoNgungHĐ = new javax.swing.JRadioButton();
        btnNew = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        txttimKiem = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setForeground(new java.awt.Color(204, 153, 0));

        Tabs.setBackground(new java.awt.Color(204, 153, 0));
        Tabs.setForeground(new java.awt.Color(255, 255, 255));
        Tabs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Tabs.setFont(new java.awt.Font("Mshtakan", 1, 14)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 1, 14), new java.awt.Color(204, 102, 0))); // NOI18N
        jPanel1.setMaximumSize(new java.awt.Dimension(30000, 30000));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Admin Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 1, 14), new java.awt.Color(204, 102, 0))); // NOI18N

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Tên Nhân Viên ");

        txttenNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txttenNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttenNVKeyReleased(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setText("Địa chỉ ");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setText("Giới tính ");

        buttonGroup2.add(rdoNam);
        rdoNam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoNam.setText("Nam");

        buttonGroup2.add(rdoNu);
        rdoNu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoNu.setText("Nữ");
        rdoNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNuActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdoKhac);
        rdoKhac.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoKhac.setText("Khác");
        rdoKhac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoKhacActionPerformed(evt);
            }
        });

        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmail.setText("Email");

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        jScrollPane1.setViewportView(txtDiaChi);

        lblEmail1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmail1.setText("Điện thoại");

        txtDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDienThoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDienThoaiActionPerformed(evt);
            }
        });
        txtDienThoai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDienThoaiKeyTyped(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setText("ID Nhân Viên");

        txtidNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtidNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidNVActionPerformed(evt);
            }
        });
        txtidNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtidNVKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(lblEmail)
                                .addGap(32, 32, 32)
                                .addComponent(txtEmail))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdoNam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoKhac, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txttenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(33, 33, 33))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblEmail1)
                        .addGap(26, 26, 26)
                        .addComponent(txtDienThoai)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel27)
                .addGap(18, 18, 18)
                .addComponent(txtidNV, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtidNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail1)
                    .addComponent(txtDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu)
                    .addComponent(rdoKhac))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail))
                .addGap(32, 32, 32)
                .addComponent(jLabel29)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "User Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 1, 14), new java.awt.Color(204, 102, 0))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Password");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("UserName");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setText("Status");

        txtUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoHoatDong);
        rdoHoatDong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoHoatDong.setText("Hoạt động ");

        buttonGroup1.add(rdoNgungHĐ);
        rdoNgungHĐ.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoNgungHĐ.setText("Ngưng hoạt động");
        rdoNgungHĐ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNgungHĐActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdoHoatDong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoNgungHĐ))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtpass))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel25)
                            .addGap(33, 33, 33)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addGap(44, 44, 44)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(rdoHoatDong)
                    .addComponent(rdoNgungHĐ))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        btnNew.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnNew.setIcon(new javax.swing.ImageIcon("D:\\DuAn1_ps39536\\src\\main\\resources\\icons\\Add.png")); // NOI18N
        btnNew.setText("ADD");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnupdate.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnupdate.setIcon(new javax.swing.ImageIcon("D:\\DuAn1_ps39536\\src\\main\\resources\\icons\\Edit.png")); // NOI18N
        btnupdate.setText("UPDATE");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon("D:\\DuAn1_ps39536\\src\\main\\resources\\icons\\Save.png")); // NOI18N
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnFirst.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnFirst.setText("| <");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrev.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnPrev.setText("<<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnLast.setText("> |");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnFirst)
                        .addGap(26, 26, 26)
                        .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnupdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst)
                    .addComponent(btnPrev)
                    .addComponent(btnNext)
                    .addComponent(btnLast))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(btnupdate)
                    .addComponent(btnSave))
                .addGap(61, 61, 61))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Tabs.addTab("CẬP NHẬT", jPanel1);

        jPanel3.setForeground(new java.awt.Color(255, 204, 0));

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Họ tên", "Giới tính", "Điện thoại ", "Email", "Trạng thái", "Password", "UserName", "Địa chỉ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblNhanVienMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblNhanVien);

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txttimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttimKiemActionPerformed(evt);
            }
        });
        txttimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttimKiemKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txttimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txttimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 14, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        Tabs.addTab("DANH SÁCH ", jPanel3);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 25)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("NHÂN VIÊN");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(Tabs)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tabs)
                .addContainerGap())
        );

        add(jPanel4, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void rdoNgungHĐActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNgungHĐActionPerformed

    }//GEN-LAST:event_rdoNgungHĐActionPerformed

    private void rdoNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNuActionPerformed

    private void rdoKhacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoKhacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoKhacActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        reset();
        flag=1;
        XuLyChucNang(false);
        XuLytext(true);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        int kq = JOptionPane.showConfirmDialog(this, "Bạn có cập nhật không? ");
        if (kq == JOptionPane.YES_OPTION) {
            flag = 2;
            XuLytext(true);
            XuLyChucNang(false);
        } else {
            XuLytext(false);
        }  
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if (flag == 1) {
            addNhanVien();
         //   MsgBox.alert(this, "Thêm thành công");
        }
        if (flag == 2) {
                updateNV();
           // JOptionPane.showMessageDialog(this, "Cập nhật thành công");   
        }
        flag=0;
        dsnv.clear();
        dstk.clear();
        nvdao = new NhanVienDAO();
        dstk = (ArrayList<TaiKhoan>) tkdao.selectAll();
        dsnv = (ArrayList<NhanVien>) nvdao.selectAll();
        Hienthitextbox();
        hienthidslen_Table();
         XuLyChucNang(false);
        XuLyChucNang(true);
      //  XuLytext(true);
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
         vitri = 0;
        JOptionPane.showMessageDialog(null, "Đang ở đầu danh sách!");
        btnFirst.setEnabled(false);
        btnNext.setEnabled(true);
        btnPrev.setEnabled(false);
        btnLast.setEnabled(true);
        XuLytext(false); 
        Hienthitextbox();
    }//GEN-LAST:event_btnFirstActionPerformed

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
        Hienthitextbox();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        vitri++;
        if (vitri == dsnv.size()) {
            vitri = dsnv.size() - 1;
            btnNext.setEnabled(false);
            btnLast.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Đang ở cuối danh sách!");
        }
        btnFirst.setEnabled(true);
        btnPrev.setEnabled(true);
        XuLytext(false);

        Hienthitextbox();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
         vitri = dsnv.size() - 1;
        JOptionPane.showMessageDialog(null, "Đang ở cuối danh sách!");
        //hienthidslen_Table();
        btnFirst.setEnabled(true);
        btnNext.setEnabled(false);
        btnPrev.setEnabled(true);
        btnLast.setEnabled(false);
        tblNhanVien.setRowSelectionInterval(vitri, vitri);
        Hienthitextbox();
    }//GEN-LAST:event_btnLastActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        vitri = tblNhanVien.getSelectedRow();
        if (evt.getClickCount() == 1) {
            this.row = tblNhanVien.rowAtPoint(evt.getPoint());
            edit();
            XuLytext(false);
        }
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void txttimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttimKiemKeyReleased
        // TODO add your handling code here:
        hienthidslen_Table();
    }//GEN-LAST:event_txttimKiemKeyReleased

    private void tblNhanVienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMousePressed

    }//GEN-LAST:event_tblNhanVienMousePressed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
        checkEmail();
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtDienThoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDienThoaiActionPerformed
        // TODO add your handling code here:
        checkSo();
    }//GEN-LAST:event_txtDienThoaiActionPerformed

    private void txtDienThoaiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDienThoaiKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDienThoaiKeyTyped

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtUserActionPerformed

    private void txttenNVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttenNVKeyReleased
        // TODO add your handling code here:     
        if(flag ==1){
           updateuser();
        }
    }//GEN-LAST:event_txttenNVKeyReleased

    private void txttimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttimKiemActionPerformed

    private void txtidNVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidNVKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidNVKeyReleased

    private void txtidNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidNVActionPerformed

    void XuLyChucNang(boolean a) {
        btnNew.setEnabled(a);
        btnSave.setEnabled(!a);
        btnupdate.setEnabled(a);
    }

    void XuLytext(boolean t) {
        txtidNV.setEditable(t);
        txttenNV.setEditable(t);
        txtpass.setEditable(t);
        txtDienThoai.setEditable(t);
        txtEmail.setEditable(t);
        txtDiaChi.setEditable(t);
        txtUser.setEditable(t);
        rdoNam.setEnabled(t);
        rdoNu.setEnabled(t);
        rdoKhac.setEnabled(t);
        rdoHoatDong.setEnabled(t);
        rdoNgungHĐ.setEnabled(t);
    }

    void hienthidslen_Table() {
        String[] headers = {"IdNV", "TenNV", "DienThoai", "Email", "GioiTinh", "Diachi", "UserName", "Password", "Trạng thái"};
        DefaultTableModel model = new DefaultTableModel(headers, 0);
        // Sắp xếp danh sách nhân viên theo mã nhân viên (IdNV)
        Collections.sort(dsnv, Comparator.comparingInt(NhanVien::getIdNv));
        List<NhanVien> list = nvdao.SearchByID((txttimKiem.getText()));
        for (NhanVien x : list) {
            boolean isAdded = false;
            for (TaiKhoan s : dstk) {
                if (x.getIdNv() == s.getIdNV()) {
                        Object[] row = {x.getIdNv(), x.getTenNv(), x.getDienThoai(), x.getEmail(), x.getGioiTinh(),
                            x.getDiaChi(), s.getUsername(), s.getMatkhau(), s.isTrangthai()};
                        model.addRow(row);
                        isAdded = true;
                        break; // Ngừng duyệt dstk khi đã thêm dữ liệu cho nhân viên này
                    }
                }
                // Nếu không có tài khoản liên kết, thêm dòng trống cho nhân viên đó
                if (!isAdded) {
                    Object[] row = {x.getIdNv(), x.getTenNv(), x.getDienThoai(), x.getEmail(), x.getGioiTinh(),
                        x.getDiaChi(), "", "", false};
                    model.addRow(row);
                }
        }
        tblNhanVien.setModel(model);
    }

    void Hienthitextbox() {
        if (vitri >= 0 && vitri < dsnv.size()) {
            NhanVien nv = dsnv.get(vitri);
           txtidNV.setText(nv.getIdNv() + "");
            txttenNV.setText(nv.getTenNv());
            txtDienThoai.setText(nv.getDienThoai());
           
             String gioiTinh = nv.getGioiTinh();
            rdoNam.setSelected(gioiTinh.equals("Nam"));
            rdoNu.setSelected(gioiTinh.equals("Nữ"));
            rdoKhac.setSelected(gioiTinh.equals("Khac"));
            
            txtEmail.setText(nv.getEmail());
            txtDiaChi.setText(nv.getDiaChi()); 
           
            TaiKhoan tk = tkdao.selectById1(String.valueOf(nv.getIdNv()));
            if (tk == null) {
                txtUser.setText("");
                txtpass.setText("");
                buttonGroup1.clearSelection();
            } else {
                txtUser.setText(tk.getUsername());
                txtpass.setText(tk.getMatkhau());
                if (tk.isTrangthai()) {
                    rdoHoatDong.setSelected(true);
                } else {
                    rdoNgungHĐ.setSelected(true);
                }
            }
        }
    }

    void edit() {
        String manv = tblNhanVien.getValueAt(tblNhanVien.getSelectedRow(), 0).toString();
        NhanVien nv = nvdao.selectById(manv);
        Hienthitextbox();
        Tabs.setSelectedIndex(0);
    }

    public void checkSo() {
        String mauDT = "0(\\d){9,10}";
        if (!(txtDienThoai.getText().matches(mauDT))) {
            JOptionPane.showMessageDialog(this, "Số điện thoại gồm 10 số bắt đầu từ 0");
            txtDienThoai.setText("");
        }
    }// kiểm tra số 

    public void checkEmail() {
        String mauEmail = "\\w+@\\w+(\\.\\w+){1,2}";
        if (!(txtEmail.getText().matches(mauEmail))) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập @gmail.com");
            txtEmail.setText("");
        }
    }// biểu thức chính quy email 

    private void reset() {
       txtidNV.setText(" ");
        txtDienThoai.setText(" ");
        txttenNV.setText(" ");
        txtDiaChi.setText("");
        txtEmail.setText("");
        txtUser.setText("");
        txtpass.setText("");
        rdoHoatDong.setSelected(true);
        buttonGroup2.clearSelection();

    }// xoá 

    //tạo user từ name gợi ý 
    private String UserfromName(String tennv) {
        if (tennv == null || tennv.isEmpty()) {
            return "";
        }
        String[] cut = tennv.split(" "); // để cắt khoảng trắng giữa hok và tên
        //StringBuilder là kiểu dữ liệu được sử dụng để tạo một đối tượng có thể thay đổi được
        //StringBuilder cho phép thực hiện các thao tác như nối chuỗi, chèn, xóa, thay thế trên chuỗi 
        StringBuilder username = new StringBuilder();

        for (int i = 0; i < cut.length - 1; i++) {
            username.append(cut[i].charAt(0));
        }
        username.append(cut[cut.length - 1]);
        return BoDauTV(username).toLowerCase();
    }

    //hàm xoá dấu tiếng việt
    public static String BoDauTV(StringBuilder input) {
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{M}");
        return pattern.matcher(normalized).replaceAll("");
    }

    private void addNhanVien() {
        String hoten = txttenNV.getText().trim();//bỏ khoảng trắng 
        String email = txtEmail.getText().trim();
        String diachi = txtDiaChi.getText().trim();
        String dt = txtDienThoai.getText().trim();
        String username = txtUser.getText().trim();
        String password = txtpass.getText().trim();
        String gioiTinh = nv.getGioiTinh();
        if (rdoNam.isSelected()) {
           gioiTinh = "Nam";
        } else if (rdoNu.isSelected()) {
            gioiTinh = "Nữ";
        } else {
            gioiTinh = "Khác";
        }
      
        boolean status =tk.isTrangthai();
        try {
            nvdao.createNhanVienAndUser(hoten, dt, email, gioiTinh, diachi, username, password, "admin", true );
            reset();
        hienthidslen_Table();
        MsgBox.alert(this, "Thêm Nhân Viên Thành Công");
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateuser() {
        String hoten = txttenNV.getText().trim();
        String username = UserfromName(hoten);
        txtUser.setText(username);
    }
   
   private void updateNV() {
        String username = txtUser.getText();
        String gioiTinh;
        if (rdoNam.isSelected()) {
           gioiTinh = "Nam";
        } else if (rdoNu.isSelected()) {
            gioiTinh = "Nữ";
        } else {
            gioiTinh = "Khác";
        }
        boolean trangthai;
        if (rdoHoatDong.isSelected()) {
            trangthai = true;
        } else {
            trangthai = false;
        }
       int idNV = Integer.parseInt(txtidNV.getText().trim());
       nv.setIdNv(idNV);
        nv.setTenNv(txttenNV.getText().trim());
        nv.setDienThoai(txtDienThoai.getText().trim());
        nv.setGioiTinh(gioiTinh);
        nv.setDiaChi(txtDiaChi.getText().trim());
        nv.setEmail(txtEmail.getText().trim());
        tk.setUsername(username);
        tk.setMatkhau(txtpass.getText().trim());
        tk.setTrangthai(trangthai);
        try {
            nvdao.update(nv);
            tkdao.update(tk);
            this.hienthidslen_Table();//cập nhật xong đổ lại vào bảng
             MsgBox.alert(this, "Cập nhật thành công");
        } catch (Exception e) {
            MsgBox.alert(this, "Cập nhật thất bại");
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Tabs;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnupdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmail1;
    private javax.swing.JRadioButton rdoHoatDong;
    private javax.swing.JRadioButton rdoKhac;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNgungHĐ;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtDienThoai;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtUser;
    private javax.swing.JTextField txtidNV;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txttenNV;
    private javax.swing.JTextField txttimKiem;
    // End of variables declaration//GEN-END:variables
}
