/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.n2.sprintburst.view;

import com.n2.sprintburst.view.sanPham.SanPhamIframeBuffer;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public final class Home extends javax.swing.JFrame {

    // Khoi tao cac menu con
    BanHangView banHangView = new BanHangView();
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

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();

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
        jPanel6 = new javax.swing.JPanel();
        btnPhieuGiamGia = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btnKhachHang = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btnThongKe = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        btnNhanVien = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlMenuBar.setBackground(new java.awt.Color(204, 204, 204));

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

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));

        btnPhieuGiamGia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Price list.png"))); // NOI18N
        btnPhieuGiamGia.setText("Phiếu giảm giá");
        btnPhieuGiamGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPhieuGiamGiaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPhieuGiamGia, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPhieuGiamGia, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(153, 153, 153));

        btnKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/User group.png"))); // NOI18N
        btnKhachHang.setText("Khách hàng");
        btnKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKhachHangMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(153, 153, 153));

        btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/3d bar chart.png"))); // NOI18N
        btnThongKe.setText("Thống kê");
        btnThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThongKeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jPanel9.setBackground(new java.awt.Color(153, 153, 153));

        btnNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Users.png"))); // NOI18N
        btnNhanVien.setText("Nhân viên");
        btnNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNhanVienMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlMenuBarLayout = new javax.swing.GroupLayout(pnlMenuBar);
        pnlMenuBar.setLayout(pnlMenuBarLayout);
        pnlMenuBarLayout.setHorizontalGroup(
            pnlMenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlMenuBarLayout.setVerticalGroup(
            pnlMenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuBarLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMenuBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(912, 912, 912))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMenuBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        banHangView.setBounds(220, 0, 1360, 830);
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
                new Home().setVisible(true);
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel pnlMenuBar;
    private javax.swing.JPanel pnlSanPham;
    // End of variables declaration//GEN-END:variables
}
