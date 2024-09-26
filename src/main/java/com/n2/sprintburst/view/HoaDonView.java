/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.n2.sprintburst.view;
//import com.mycompany.sprintburst.entity.HoaDon;
//import com.mycompany.sprintburst.entity.HoaDonChiTiet;
//import com.mycompany.sprintburst.entity.LichSuHoaDon;
//import com.mycompany.sprintburst.service.HoaDonChiTietService;
//import com.mycompany.sprintburst.service.HoaDonService;
//import com.mycompany.sprintburst.service.LichSuHoaDonService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mtt
 */
public class HoaDonView extends javax.swing.JInternalFrame  {
    /**
     * Creates new form Test
     */
//    DefaultTableModel dtm = new DefaultTableModel();
//    HoaDonService hoaDonService = new HoaDonService();
//    HoaDonChiTietService hoaDonChiTietService = new HoaDonChiTietService();
//    LichSuHoaDonService lichSuHoaDonService = new LichSuHoaDonService();
//    List<HoaDon> list = new ArrayList<>();
    public HoaDonView() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
//        hoaDonService = new HoaDonService();
//        hoaDonChiTietService = new HoaDonChiTietService();
//        fillTableHoaDon();
//        loadComboBox();
    }
//    private void showTableHoaDon(ArrayList<HoaDon> lists) {
//        dtm.setRowCount(0);
//        lists.forEach(s -> dtm.addRow(new Object[]{
//            s.getId(), s.getMaHoaDon(),s.getIdKhachHang(),
//            s.getIdNhanVien(),  s.getNgayTao(),s.getTongTruocGiamGia(),s.getTongSauGiamGia(),s.getGhiChu(),
//            s.getTenNguoiNhan(), s.getDienThoaiNguoiNhan(),s.getDiaChiNguoiNhan(),
//          s.getIdTrangThaiHoaDon()?"Đã thanh toán":"Chưa thanh toán",s.getIdPhieuGiamGia()
//        }));
//    }
//    
//    private void loadComboBox() {
//        String[] items = new String[]{"Đã thanh toán", "Chưa thanh toán"};
//        cbbTrangThai.setModel(new DefaultComboBoxModel<>(items));
//    }
//    public void fillTableHoaDon(){
//        List<HoaDon> hoaDons = hoaDonService.getAllHD();
//        dtm = (DefaultTableModel) tblHoaDon.getModel();
//        dtm.setRowCount(0);
//        for (HoaDon hd : hoaDons){
//            Object row2[] = new Object[13];
//            row2[0] = hd.getId();
//            row2[1] = hd.getMaHoaDon();
//            row2[2]= hd.getIdKhachHang();
//            row2[3] = hd.getIdNhanVien();
//            row2[4] = hd.getNgayTao();
//            row2[5] = hd.getTongTruocGiamGia();
//            row2[6] = hd.getTongSauGiamGia();
//            row2[7] = hd.getGhiChu();
//            row2[8] = hd.getTenNguoiNhan();
//            row2[9] = hd.getDienThoaiNguoiNhan();
//            row2[10] = hd.getDiaChiNguoiNhan();
//            row2[11] = hd.getIdTrangThaiHoaDon()?"Đã thanh toán":"Chưa thanh toán";
//            row2[12] = hd.getIdPhieuGiamGia();
//            dtm.addRow(row2);
//        }
//    }
//    private void loadHoaDonData(String selectedTrangThai) {
//        dtm.setRowCount(0);
//        for (HoaDon hoaDon : list) {
//            if ("Tất cả".equals(selectedTrangThai) || hoaDon.getIdTrangThaiHoaDon().equals(selectedTrangThai)) {
//                dtm.addRow(new Object[]{hoaDon.getId(),hoaDon.getMaHoaDon(), hoaDon.getIdKhachHang(),hoaDon.getIdNhanVien(),hoaDon.getNgayTao(),hoaDon.getTongTruocGiamGia(),hoaDon.getTongSauGiamGia(),
//                    hoaDon.getGhiChu(),hoaDon.getTenNguoiNhan(),hoaDon.getDienThoaiNguoiNhan(),hoaDon.getDiaChiNguoiNhan(),hoaDon.getIdTrangThaiHoaDon(),hoaDon.getIdPhieuGiamGia()});
//            }
//        }
//    }
//    private void fillTableHoaDonChiTiet(List<HoaDonChiTiet> chiTietList) {
//    // Lấy mô hình của bảng tblHoaDonChiTiet
//    dtm = (DefaultTableModel) tblHoaDonChiTiet.getModel();
//    dtm.setRowCount(0); // Xóa các dòng cũ
//    // Thêm từng chi tiết hóa đơn vào bảng
//    for (HoaDonChiTiet chiTiet : chiTietList) {
//        Object row[] = new Object[6];
//            row[0] = chiTiet.getId();
//            row[1] = chiTiet.getIdsanPhamChiTiet();
//            row[2] = chiTiet.getIdhoaDon();
//            row[3] = chiTiet.getSoLuong();
//            row[4] = chiTiet.getGiaBan();
//            row[5] = chiTiet.isTrangThai()?"Đã thanh toán":"Chưa thanh toán";
//            dtm.addRow(row);
//    }
//}
//     public void fillTableLichSuHoaDon(List<LichSuHoaDon> lichSuHoaDons){
//        dtm = (DefaultTableModel) tblLichSuHoaDon.getModel();
//        dtm.setRowCount(0);
//        for (LichSuHoaDon ls : lichSuHoaDons){
//            Object row1[] = new Object[5];
//            row1[0] = ls.getId();
//            row1[1] = ls.getIdHoaDon();
//            row1[2] = ls.getIdNhanVien();
//            row1[4] = ls.getNgayTacDong();
//            row1[3] = ls.getGhiChu();
//            dtm.addRow(row1);
//        }
//        
//    }
//     
//    
//    public void Load() {
//    int selectedRow = tblHoaDon.getSelectedRow();
//
//    if (selectedRow != -1) {
//        DefaultTableModel modelHoaDon = (DefaultTableModel) tblHoaDon.getModel();
//        DefaultTableModel modelLichSuHoaDon = (DefaultTableModel) tblLichSuHoaDon.getModel();
//    DefaultTableModel modelHoaDonChiTiet = (DefaultTableModel) tblHoaDonChiTiet.getModel();
//        int columnCount = tblHoaDon.getColumnCount();
//        int columnCountHoaDonChiTiet = tblHoaDonChiTiet.getColumnCount();
//        Object[] rowData = new Object[columnCount];
//        for (int i = 0; i < columnCount; i++) {
//            rowData[i] = modelHoaDon.getValueAt(selectedRow, i);
//        }
//        modelLichSuHoaDon.addRow(rowData);
//        
//         Object[] rowDataHoaDonChiTiet = new Object[columnCountHoaDonChiTiet];
//
//        for (int i = 0; i < columnCountHoaDonChiTiet; i++) {
//            rowDataHoaDonChiTiet[i] = modelHoaDon.getValueAt(selectedRow, i); 
//        }
//        modelHoaDonChiTiet.addRow(rowDataHoaDonChiTiet);
//    } else {
//        System.out.println("Ko in tblHoaDon.");
//    }
//}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnTimKiem = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbbTrangThai = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDonChiTiet = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblLichSuHoaDon = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1630, 700));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel2.setText("Tìm kiếm hóa đơn :");

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã hóa đơn", "ID Khách hàng", "ID Nhân viên", "Ngày tạo", "Tổng trước giảm giá", "Tổng sau giảm giá", "Ghi chú", "Tên người nhận", "Số điện thoại", "Địa chỉ", "Trạng thái", "Phiếu giảm giá"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        jButton4.setText("In hóa đơn");

        jButton5.setText("Xuất danh sách");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel1.setText("Trạng thái hóa đơn");

        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chưa thanh toán", "Đã thanh toán" }));
        cbbTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTrangThaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(272, 272, 272)
                .addComponent(jButton5)
                .addGap(276, 276, 276))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTimKiem)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnTimKiem)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn chi tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblHoaDonChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ID Hóa đơn", "ID Sản phẩm chi tiết", "Số lượng", "Gía bán", "Trạng thái"
            }
        ));
        jScrollPane2.setViewportView(tblHoaDonChiTiet);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lịch sử hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblLichSuHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ID Hóa đơn", "ID Nhân viên", "Ghi chú", "Ngày tác động"
            }
        ));
        jScrollPane3.setViewportView(tblLichSuHoaDon);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1088, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
//       String idCanTim = txtTimKiem.getText().trim();
//        if (hoaDonService.timKiem(idCanTim).isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Khong tim thay");
//        }else{
//            JOptionPane.showMessageDialog(this, "Tim thay ma");
//            this.showTableHoaDon(hoaDonService.timKiem(idCanTim));
//            Load();
//        }
//  
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        

    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void cbbTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTrangThaiActionPerformed
//        // TODO add your handling code here:
//          String selectedTrangThai = (String) cbbTrangThai.getSelectedItem();
//                loadHoaDonData(selectedTrangThai);
        
    }//GEN-LAST:event_cbbTrangThaiActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:
//         int id = hoaDonService.getAllHD().get(tblHoaDon.getSelectedRow()).getId();
//         fillTableHoaDonChiTiet(hoaDonChiTietService.getAll(id));
//         fillTableLichSuHoaDon(lichSuHoaDonService.getAll1(id));
//        Load();
        
    }//GEN-LAST:event_tblHoaDonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new HoaDonView().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblHoaDonChiTiet;
    private javax.swing.JTable tblLichSuHoaDon;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

    
}
