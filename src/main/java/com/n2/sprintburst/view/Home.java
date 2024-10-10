/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.n2.sprintburst.view;

import com.n2.sprintburst.entity.NhanVien;
import com.n2.sprintburst.service.NhanVienService;
import com.n2.sprintburst.view.banHang.BanHangForm;
import com.n2.sprintburst.view.sanPham.SanPhamIframeBuffer;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public final class Home extends javax.swing.JFrame {

    // Khoi tao cac menu con
    BanHangForm banHangView;
    HoaDonView hoaDonView = new HoaDonView();
    TrangChuView trangChuView = new TrangChuView();
    KhachHangView khachHangView = new KhachHangView();
    NhanVienView nhanVienView = new NhanVienView();
    PhieuGiamGiaView phieuGiamGiaView = new PhieuGiamGiaView();
    SanPhamIframeBuffer sanPhamView = new SanPhamIframeBuffer();
    ThongKeView thongKeView = new ThongKeView();

    // Khoi tao bien check hien thi menu
    Boolean checkBanHangView = false;
    Boolean checkHoaDonView = false;
    Boolean checkTrangChuView = false;
    Boolean checkKhachHangView = false;
    Boolean checkNhanVienView = false;
    Boolean checkPhieuGiamGiaView = false;
    Boolean checkSanPhamView = false;
    Boolean checkThongKeView = false;

    //Logged in user information
    NhanVien userState;

    /**
     * Creates new form Home
     */
    public Home(NhanVien user) {
        setExtendedState(MAXIMIZED_BOTH);

        initComponents();

        setFrameIcon();

        userState = user;
        banHangView = new BanHangForm(userState);
        // Them menu vao man hinh
        add(banHangView);
        add(hoaDonView);
        add(trangChuView);
        add(khachHangView);
        add(nhanVienView);
        add(phieuGiamGiaView);
        add(sanPhamView);
        add(thongKeView);

        loadForm();

        int height = pnlMenuBar.getHeight();

        displayUserInfo();

        if (!user.isLaQuanLy()) {
            btnPhieuGiamGia.setVisible(false);
            btnThongKe.setVisible(false);
            btnNhanVien.setVisible(false);
//            pnlMenuBar.setSize(220, height);
        }
    }

    // Load lại menu khi chuyen form ve false;
    public void loadForm() {
        banHangView.setVisible(false);
        hoaDonView.setVisible(false);
        trangChuView.setVisible(false);
        khachHangView.setVisible(false);
        nhanVienView.setVisible(false);
        phieuGiamGiaView.setVisible(false);
        sanPhamView.setVisible(false);
        thongKeView.setVisible(false);
    }

    public void displayUserInfo() {
        txtUsername.setText(userState.getHoTen());
        txtUserRole.setText(userState.isLaQuanLy() ? "Quản lý" : "Nhân viên");
    }

    private void setFrameIcon() {
        ImageIcon logoIcon = null;
        java.net.URL imgURL = Home.class.getResource("/icon/mini_logo.png");
        if (imgURL != null) {
            logoIcon = new ImageIcon(imgURL);
            this.setIconImage(logoIcon.getImage());
        } else {
            JOptionPane.showMessageDialog(this, "Icon image not found.");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMenuBar = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnTrangChu = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnBanHang = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnHoaDon = new javax.swing.JLabel();
        pnlSanPham = new javax.swing.JPanel();
        btnSanPham = new javax.swing.JLabel();
        pnlKhachHang = new javax.swing.JPanel();
        btnKhachHang = new javax.swing.JLabel();
        pnlGiamGia = new javax.swing.JPanel();
        btnPhieuGiamGia = new javax.swing.JLabel();
        pnlThongKe = new javax.swing.JPanel();
        btnThongKe = new javax.swing.JLabel();
        pnlNhanVien = new javax.swing.JPanel();
        btnNhanVien = new javax.swing.JLabel();
        pnlUser = new javax.swing.JPanel();
        txtUsername = new javax.swing.JLabel();
        txtUserRole = new javax.swing.JLabel();
        txtUsername1 = new javax.swing.JLabel();
        txtUsername2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Giày thể thao SPRINTBURST");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(220, 2147483647));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setPreferredSize(new java.awt.Dimension(220, 596));

        pnlMenuBar.setPreferredSize(new java.awt.Dimension(220, 1080));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        btnTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Home_1.png"))); // NOI18N
        btnTrangChu.setText("Trang chủ");
        btnTrangChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTrangChuMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        btnBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Dollar.png"))); // NOI18N
        btnBanHang.setText("Bán hàng");
        btnBanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBanHangMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBanHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBanHang, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));

        btnHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/List_1.png"))); // NOI18N
        btnHoaDon.setText("Hoá đơn");
        btnHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHoaDonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        pnlSanPham.setBackground(new java.awt.Color(153, 153, 153));

        btnSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add to basket.png"))); // NOI18N
        btnSanPham.setText("Sản phẩm");
        btnSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSanPhamMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlSanPhamLayout = new javax.swing.GroupLayout(pnlSanPham);
        pnlSanPham.setLayout(pnlSanPhamLayout);
        pnlSanPhamLayout.setHorizontalGroup(
            pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlSanPhamLayout.setVerticalGroup(
            pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        pnlKhachHang.setBackground(new java.awt.Color(153, 153, 153));

        btnKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/User group.png"))); // NOI18N
        btnKhachHang.setText("Khách hàng");
        btnKhachHang.setMaximumSize(new java.awt.Dimension(81, 24));
        btnKhachHang.setMinimumSize(new java.awt.Dimension(81, 24));
        btnKhachHang.setPreferredSize(new java.awt.Dimension(81, 24));
        btnKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKhachHangMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlKhachHangLayout = new javax.swing.GroupLayout(pnlKhachHang);
        pnlKhachHang.setLayout(pnlKhachHangLayout);
        pnlKhachHangLayout.setHorizontalGroup(
            pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlKhachHangLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        pnlKhachHangLayout.setVerticalGroup(
            pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
            .addGroup(pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlKhachHangLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pnlGiamGia.setBackground(new java.awt.Color(153, 153, 153));

        btnPhieuGiamGia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Price list.png"))); // NOI18N
        btnPhieuGiamGia.setText("Phiếu giảm giá");
        btnPhieuGiamGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPhieuGiamGiaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlGiamGiaLayout = new javax.swing.GroupLayout(pnlGiamGia);
        pnlGiamGia.setLayout(pnlGiamGiaLayout);
        pnlGiamGiaLayout.setHorizontalGroup(
            pnlGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPhieuGiamGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlGiamGiaLayout.setVerticalGroup(
            pnlGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPhieuGiamGia, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        pnlThongKe.setBackground(new java.awt.Color(153, 153, 153));

        btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/3d bar chart.png"))); // NOI18N
        btnThongKe.setText("Thống kê");
        btnThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThongKeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlThongKeLayout = new javax.swing.GroupLayout(pnlThongKe);
        pnlThongKe.setLayout(pnlThongKeLayout);
        pnlThongKeLayout.setHorizontalGroup(
            pnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlThongKeLayout.setVerticalGroup(
            pnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        pnlNhanVien.setBackground(new java.awt.Color(153, 153, 153));

        btnNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Users.png"))); // NOI18N
        btnNhanVien.setText("Nhân viên");
        btnNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNhanVienMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlNhanVienLayout = new javax.swing.GroupLayout(pnlNhanVien);
        pnlNhanVien.setLayout(pnlNhanVienLayout);
        pnlNhanVienLayout.setHorizontalGroup(
            pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlNhanVienLayout.setVerticalGroup(
            pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        txtUsername.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtUsername.setText("Username");

        txtUserRole.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtUserRole.setText("Role");

        txtUsername1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUsername1.setText("Xin chào,");

        txtUsername2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUsername2.setText("Bạn là: ");

        javax.swing.GroupLayout pnlUserLayout = new javax.swing.GroupLayout(pnlUser);
        pnlUser.setLayout(pnlUserLayout);
        pnlUserLayout.setHorizontalGroup(
            pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlUserLayout.createSequentialGroup()
                        .addComponent(txtUsername1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUsername))
                    .addGroup(pnlUserLayout.createSequentialGroup()
                        .addComponent(txtUsername2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUserRole)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlUserLayout.setVerticalGroup(
            pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername)
                    .addComponent(txtUsername1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUserRole)
                    .addComponent(txtUsername2))
                .addContainerGap())
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sprintburst_logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout pnlMenuBarLayout = new javax.swing.GroupLayout(pnlMenuBar);
        pnlMenuBar.setLayout(pnlMenuBarLayout);
        pnlMenuBarLayout.setHorizontalGroup(
            pnlMenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlGiamGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlMenuBarLayout.setVerticalGroup(
            pnlMenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuBarLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(pnlUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMenuBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMenuBar, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTrangChuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangChuMouseClicked
        // set value check cua cac thang khac la false;
        checkBanHangView = false;
        checkHoaDonView = false;
        checkKhachHangView = false;
        checkNhanVienView = false;
        checkPhieuGiamGiaView = false;
        checkSanPhamView = false;
        checkThongKeView = false;
        // TODO add your handling code here:
        if (checkTrangChuView == true) {
            return;
        }

        //load lại form
        loadForm();
        // Hien thi menu, set vi tri, kich thuoc, set gia tri bien check
        trangChuView.setBounds(220, 0, 1360, 830);
        trangChuView.setVisible(true);
        checkTrangChuView = true;
    }//GEN-LAST:event_btnTrangChuMouseClicked

    private void btnBanHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBanHangMouseClicked
        // set value check cua cac thang khac la false;
        checkHoaDonView = false;
        checkTrangChuView = false;
        checkKhachHangView = false;
        checkNhanVienView = false;
        checkPhieuGiamGiaView = false;
        checkSanPhamView = false;
        checkThongKeView = false;
        // Kiem tra menu da hien thi chua, neu hien thi roi thi thoat ra ngoai
        if (checkBanHangView == true) {
            return;
        }

        // load lai form
        loadForm();
        // Hien thi menu, set vi tri, kich thuoc, set gia tri bien check
        banHangView.setBounds(220, 0, 1677, 1014);
        banHangView.setVisible(true);
        checkBanHangView = true;
    }//GEN-LAST:event_btnBanHangMouseClicked

    private void btnHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHoaDonMouseClicked
        // set value check cua cac thang khac la false;
        checkBanHangView = false;
        checkTrangChuView = false;
        checkKhachHangView = false;
        checkNhanVienView = false;
        checkPhieuGiamGiaView = false;
        checkSanPhamView = false;
        checkThongKeView = false;

        // TODO add your handling code here:
        if (checkHoaDonView == true) {
            return;
        }

        //load lại form
        loadForm();
        // Hien thi menu, set vi tri, kich thuoc, set gia tri bien check
        hoaDonView.setBounds(220, 0, 1360, 830);
        hoaDonView.setVisible(true);
        checkHoaDonView = true;
    }//GEN-LAST:event_btnHoaDonMouseClicked

    private void btnSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSanPhamMouseClicked
        // set value check cua cac thang khac la false;
        checkBanHangView = false;
        checkHoaDonView = false;
        checkTrangChuView = false;
        checkKhachHangView = false;
        checkNhanVienView = false;
        checkPhieuGiamGiaView = false;
        checkThongKeView = false;

        if (checkSanPhamView == true) {
            return;
        }

        //load lại form
        loadForm();
        // Hien thi menu, set vi tri, kich thuoc, set gia tri bien check
        sanPhamView.setBounds(420, 100, 950, 600);
        sanPhamView.setVisible(true);
        checkSanPhamView = true;
    }//GEN-LAST:event_btnSanPhamMouseClicked

    private void btnPhieuGiamGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPhieuGiamGiaMouseClicked
        // set value check cua cac thang khac la false;
        checkBanHangView = false;
        checkHoaDonView = false;
        checkTrangChuView = false;
        checkKhachHangView = false;
        checkNhanVienView = false;
        checkSanPhamView = false;
        checkThongKeView = false;

        // TODO add your handling code here:
        if (checkPhieuGiamGiaView == true) {
            return;
        }

        //load lại form
        loadForm();
        // Hien thi menu, set vi tri, kich thuoc, set gia tri bien check
        phieuGiamGiaView.setBounds(220, 0, 1360, 830);
        phieuGiamGiaView.setVisible(true);
        checkPhieuGiamGiaView = true;
    }//GEN-LAST:event_btnPhieuGiamGiaMouseClicked

    private void btnKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKhachHangMouseClicked
        // set value check cua cac thang khac la false;
        checkBanHangView = false;
        checkHoaDonView = false;
        checkTrangChuView = false;
        checkNhanVienView = false;
        checkPhieuGiamGiaView = false;
        checkSanPhamView = false;
        checkThongKeView = false;
        // TODO add your handling code here:
        if (checkKhachHangView == true) {
            return;
        }

        // load lai form
        loadForm();
        // Hien thi menu, set vi tri, kich thuoc, set gia tri bien check
        khachHangView.setBounds(220, 0, 1360, 830);
        khachHangView.setVisible(true);
        checkKhachHangView = true;
    }//GEN-LAST:event_btnKhachHangMouseClicked

    private void btnThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThongKeMouseClicked
        // set value check cua cac thang khac la false;
        checkBanHangView = false;
        checkHoaDonView = false;
        checkTrangChuView = false;
        checkKhachHangView = false;
        checkNhanVienView = false;
        checkPhieuGiamGiaView = false;
        checkSanPhamView = false;
        // TODO add your handling code here:
        if (checkThongKeView == true) {
            return;
        }

        //load lại form
        loadForm();
        // Hien thi menu, set vi tri, kich thuoc, set gia tri bien check
        thongKeView.setBounds(220, 0, 1360, 830);
        thongKeView.setVisible(true);
        checkThongKeView = true;
    }//GEN-LAST:event_btnThongKeMouseClicked

    private void btnNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNhanVienMouseClicked

        // set value check cua cac thang khac la false;
        checkBanHangView = false;
        checkHoaDonView = false;
        checkTrangChuView = false;
        checkKhachHangView = false;
        checkPhieuGiamGiaView = false;
        checkSanPhamView = false;
        checkThongKeView = false;

        // TODO add your handling code here:
        if (checkNhanVienView == true) {
            return;
        }

        //load lại form
        loadForm();
        // Hien thi menu, set vi tri, kich thuoc, set gia tri bien check
        nhanVienView.setBounds(220, 0, 1360, 830);
        nhanVienView.setVisible(true);
        checkNhanVienView = true;
    }//GEN-LAST:event_btnNhanVienMouseClicked

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home(new NhanVienService().getNhanVienById("1")).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBanHang;
    private javax.swing.JLabel btnHoaDon;
    private javax.swing.JLabel btnKhachHang;
    private javax.swing.JLabel btnNhanVien;
    private javax.swing.JLabel btnPhieuGiamGia;
    private javax.swing.JLabel btnSanPham;
    private javax.swing.JLabel btnThongKe;
    private javax.swing.JLabel btnTrangChu;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel pnlGiamGia;
    private javax.swing.JPanel pnlKhachHang;
    private javax.swing.JPanel pnlMenuBar;
    private javax.swing.JPanel pnlNhanVien;
    private javax.swing.JPanel pnlSanPham;
    private javax.swing.JPanel pnlThongKe;
    private javax.swing.JPanel pnlUser;
    private javax.swing.JLabel txtUserRole;
    private javax.swing.JLabel txtUsername;
    private javax.swing.JLabel txtUsername1;
    private javax.swing.JLabel txtUsername2;
    // End of variables declaration//GEN-END:variables
}
