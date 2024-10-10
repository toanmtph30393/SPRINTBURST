/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.n2.sprintburst.view;

import com.n2.sprintburst.entity.NhanVien;
import com.n2.sprintburst.service.NhanVienService;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Admin
 */
public class NhanVienView extends javax.swing.JInternalFrame {

    DefaultTableModel defaultTableModel = new DefaultTableModel();
    NhanVienService nhanVienService = new NhanVienService();
    List<NhanVien> nv = new ArrayList<>();
    long idChon;

    /**
     * Creates new form NhanVienView
     */
    public NhanVienView() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);

        setUpTable();
        defaultTableModel = (DefaultTableModel) tblBangNhanVien.getModel();
        fillData();
    }

    public void setUpTable() {
        tblBangNhanVien.setModel(defaultTableModel);
        defaultTableModel.setColumnIdentifiers(new String[]{"Stt", "Là quản lý", "Trạng thái", "Ngày cập nhập", "Ngày tạo", "Ngày Xoá", "Địa chỉ", "Điện thoại", "Email", "Ghi chú", "Họ tên", "Mã tài khoản", "PassWord"});
    }

    private void clearForm() {
        txtId.setText("");
        cboLaQuanLy.removeAllItems();
        txtNgayCapNhap.setText("");
        txtNgayTao.setText("");
        txtNgayXoa.setText("");
        txtDiaChi.setText("");
        txtDienThoai.setText("");
        txtEmail.setText("");
        txtGhiChu.setText("");
        txtHoTen.setText("");
        txtMaTaiKhoan.setText("");
        txtPassword.setText("");

        fillData();
    }

    public void fillData() {
        nv = nhanVienService.getAllNhanVien();

        defaultTableModel.setRowCount(0);
        for (NhanVien nhanVien : nv) {
            defaultTableModel.addRow(new Object[]{
                nhanVien.getId(),
                nhanVien.isLaQuanLy(),
                nhanVien.isTrangThai(),
                nhanVien.getNgayCapNhat(),
                nhanVien.getNgayTao(),
                nhanVien.getNgayXoa(),
                nhanVien.getDiaChi(),
                nhanVien.getDienThoai(),
                nhanVien.getEmail(),
                nhanVien.getGhiChu(),
                nhanVien.getHoTen(),
                nhanVien.getMaTaiKhoan(),
                nhanVien.getPassword(),});
        }
    }

    int index;

    public void showData() {
        NhanVien nv = nhanVienService.getAllNhanVien().get(index);

        txtId.setText(String.valueOf(nv.getId()));
        if (nv.isLaQuanLy()) {
            cboLaQuanLy.setSelectedItem("Quản lý"); // Đặt là Quản lý
        } else {
            cboLaQuanLy.setSelectedItem("Nhân viên"); // Đặt là Nhân viên
        }
        if (nv.isTrangThai()) {
            rdoĐangLam.setSelected(true); // Đang làm
        } else {
            rdoDaNghi.setSelected(true); // Đã nghỉ
        }

        txtNgayCapNhap.setText(nv.getNgayCapNhat().toString());
        txtNgayTao.setText(nv.getNgayTao().toString());
        txtNgayXoa.setText(nv.getNgayXoa().toString());

        txtDiaChi.setText(nv.getDiaChi());
        txtDienThoai.setText(nv.getDienThoai());
        txtEmail.setText(nv.getEmail());
        txtGhiChu.setText(nv.getGhiChu());
        txtHoTen.setText(nv.getHoTen());
        txtMaTaiKhoan.setText(nv.getMaTaiKhoan());
        txtPassword.setText(nv.getPassword());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNgayTao = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        txtNgayCapNhap = new javax.swing.JTextField();
        txtMaTaiKhoan = new javax.swing.JTextField();
        txtGhiChu = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtDienThoai = new javax.swing.JTextField();
        txtNgayXoa = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        cboLaQuanLy = new javax.swing.JComboBox<>();
        rdoĐangLam = new javax.swing.JRadioButton();
        rdoDaNghi = new javax.swing.JRadioButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtTimKiemNhanVien = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBangNhanVien = new javax.swing.JTable();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1360, 800));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thiết lập thông tin nhân viên"));

        jLabel2.setText("Stt");

        jLabel3.setText("Chức vụ");

        jLabel4.setText("Emai");

        jLabel5.setText("Ngày xoá");

        jLabel6.setText("Điện thoại");

        jLabel7.setText("Ngày tạo");

        jLabel8.setText("Ngày cập nhập");

        jLabel9.setText("Trạng thái");

        jLabel10.setText("Ghi chú");

        jLabel11.setText("Địa chỉ");

        jLabel12.setText("Họ tên");

        jLabel13.setText("Ma tài khản");

        jLabel14.setText("Password");

        txtId.setEnabled(false);

        txtNgayTao.setEnabled(false);

        txtNgayCapNhap.setEnabled(false);

        txtNgayXoa.setEnabled(false);

        cboLaQuanLy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản lý", "Nhân viên" }));

        buttonGroup1.add(rdoĐangLam);
        rdoĐangLam.setText("Đang làm");

        buttonGroup1.add(rdoDaNghi);
        rdoDaNghi.setText("Đã nghỉ");

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaMouseClicked(evt);
            }
        });

        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Refresh.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLamMoiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel14))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(517, 517, 517)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNgayXoa)
                            .addComponent(txtDiaChi)
                            .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(109, 109, 109)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(34, 34, 34)
                                .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMaTaiKhoan))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(47, 47, 47)
                                .addComponent(txtEmail)))
                        .addGap(0, 61, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThem)
                        .addGap(183, 183, 183)
                        .addComponent(btnSua)
                        .addGap(199, 199, 199)
                        .addComponent(btnLamMoi)
                        .addGap(410, 410, 410))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(rdoĐangLam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(rdoDaNghi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(cboLaQuanLy, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNgayCapNhap)
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(767, 767, 767))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboLaQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoĐangLam)
                    .addComponent(rdoDaNghi))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(txtNgayCapNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnLamMoi))
                .addGap(34, 34, 34))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách nhân viên"));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("tìm kiếm"));

        txtTimKiemNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemNhanVienActionPerformed(evt);
            }
        });

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Search.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiemNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        tblBangNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblBangNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangNhanVienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBangNhanVien);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblBangNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangNhanVienMouseClicked

        index = tblBangNhanVien.getSelectedRow();
        showData();
    }//GEN-LAST:event_tblBangNhanVienMouseClicked

    private void btnLamMoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLamMoiMouseClicked

        clearForm();
        JOptionPane.showMessageDialog(this, "Làm Mới Thành Công.");
    }//GEN-LAST:event_btnLamMoiMouseClicked

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked


        NhanVien nv = new NhanVien();
        boolean laQuanLy = cboLaQuanLy.getSelectedIndex() == 1; // Giả sử "Có" là chỉ số 1
        nv.setLaQuanLy(laQuanLy);

        if (rdoĐangLam.isSelected()) {
            nv.setTrangThai(true);  // "Đang làm" -> true
        } else if (rdoDaNghi.isSelected()) {
            nv.setTrangThai(false);  // "Đã nghỉ" -> false
        }
        nv.setDiaChi(txtDiaChi.getText());
        nv.setDienThoai(txtDienThoai.getText());
        nv.setEmail(txtEmail.getText());
        nv.setGhiChu(txtGhiChu.getText());
        nv.setHoTen(txtHoTen.getText());
        nv.setMaTaiKhoan(txtMaTaiKhoan.getText());
        nv.setPassword(txtPassword.getText());

        
        nhanVienService.saveNhanVien(nv);
        JOptionPane.showMessageDialog(this, "Thêm mới thành công");
        fillData();
    }//GEN-LAST:event_btnThemMouseClicked

    private void btnSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaMouseClicked
        // TODO add your handling code here:
        String id = txtId.getText();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID không được để trống.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Tìm khách hàng hiện tại trong cơ sở dữ liệu
        NhanVien nv = nhanVienService.getNhanVienById(id); // Phương thức tìm kiếm theo ID

        if (nv == null) {
            JOptionPane.showMessageDialog(this, "Khách hàng không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra các trường không được để trống
        if (nhanVienService.isEmpty(txtPassword, "Không để trống pass")) {
            return;
        }
        if (nhanVienService.isEmpty(txtDiaChi, "Không để trống dia chi")) {
            return;
        }
        if (nhanVienService.isEmpty(txtHoTen, "Không để trống ho tên")) {
            return;
        }
        if (nhanVienService.isEmpty(txtDienThoai, "Không để trống điện thoại")) {
            return;
        }
        if (nhanVienService.isEmpty(txtEmail, "Không để trống Emai")) {
            return;
        }
        if (nhanVienService.isEmpty(txtGhiChu, "Không để trống ghi chú")) {
            return;
        }

        String vaiTro = cboLaQuanLy.getSelectedItem().toString();
        boolean isQuanLy = vaiTro.equals("Quản lý"); // Nếu chọn "Quản lý" thì isQuanLy sẽ là true
       
        // Xác nhận cập nhật
        int luaChon = JOptionPane.showConfirmDialog(this, "Xác nhận thực hiện", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (luaChon == JOptionPane.YES_OPTION) {
            // Cập nhật thông tin vào đối tượng đã tìm thấy
            nv.setPassword(txtPassword.getText());
            nv.setDiaChi(txtDiaChi.getText());
            nv.setHoTen(txtHoTen.getText());
            nv.setDienThoai(txtDienThoai.getText());
            nv.setEmail(txtEmail.getText());
            nv.setGhiChu(txtGhiChu.getText());
            nv.setLaQuanLy(isQuanLy);
            if (rdoĐangLam.isSelected()) {
                nv.setTrangThai(true);  // "Đang làm" -> true
            } else if (rdoDaNghi.isSelected()) {
                nv.setTrangThai(false);  // "Đã nghỉ" -> false
            }

            // Cập nhật khách hàng
            nhanVienService.updateNhanVien(nv);
            fillData(); // Làm mới bảng dữ liệu sau khi cập nhật
            JOptionPane.showMessageDialog(this, "Cập nhật thành công");
        }


    }//GEN-LAST:event_btnSuaMouseClicked

    private void txtTimKiemNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemNhanVienActionPerformed
        // TODO add your handling code here:

        DefaultTableModel dtm = (DefaultTableModel) tblBangNhanVien.getModel();
        TableRowSorter<DefaultTableModel> ab = new TableRowSorter<>(dtm);
        tblBangNhanVien.setRowSorter(ab);
        ab.setRowFilter(RowFilter.regexFilter(txtTimKiemNhanVien.getText()));
    }//GEN-LAST:event_txtTimKiemNhanVienActionPerformed




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboLaQuanLy;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdoDaNghi;
    private javax.swing.JRadioButton rdoĐangLam;
    private javax.swing.JTable tblBangNhanVien;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtDienThoai;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMaTaiKhoan;
    private javax.swing.JTextField txtNgayCapNhap;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtNgayXoa;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtTimKiemNhanVien;
    // End of variables declaration//GEN-END:variables
}
