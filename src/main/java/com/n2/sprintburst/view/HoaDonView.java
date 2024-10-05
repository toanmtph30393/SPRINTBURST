package com.n2.sprintburst.view;

import com.n2.sprintburst.entity.HoaDon;
import com.n2.sprintburst.entity.HoaDonChiTiet;
import com.n2.sprintburst.service.HoaDonChiTietService;
import com.n2.sprintburst.service.HoaDonService;
import com.n2.sprintburst.utils.ExportPdfHoaDon;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HoaDonView extends javax.swing.JInternalFrame {

    /**
     * Creates new form Test
     */
    DefaultTableModel defaultTableModel = new DefaultTableModel();
    DefaultTableModel defaultTableModel1 = new DefaultTableModel();
    HoaDonService hoaDonService = new HoaDonService();
    HoaDonChiTietService hoaDonChiTietService = new HoaDonChiTietService();
    List<HoaDon> hd = new ArrayList<>();
    List<HoaDonChiTiet> hdct = new ArrayList<>();

    public HoaDonView() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        defaultTableModel = (DefaultTableModel) tblHoaDon.getModel();
        defaultTableModel1 = (DefaultTableModel) tblHoaDonChiTiet.getModel();
        fillData();
    }

    public void fillData() {
        hd = hoaDonService.getAllHoaDon();

        defaultTableModel.setRowCount(0);
        for (HoaDon hoaDon : hd) {
            defaultTableModel.addRow(new Object[]{
                hoaDon.getId(),
                hoaDon.getMaHoaDon(),
                hoaDon.getKhachHang() == null ? null : hoaDon.getKhachHang().getId(),
                hoaDon.getNhanVien(),
                hoaDon.getNgayTao(),
                hoaDon.getTongTruocGiamGia(),
                hoaDon.getTongSauGiamGia(),
                hoaDon.getGhiChu(),
                hoaDon.getTenNguoiNhan(),
                hoaDon.getDienThoaiNguoiNhan(),
                hoaDon.getDiaChiNguoiNhan(),
                hoaDon.getTrangThaiHoaDon() == null ? null : hoaDon.getTrangThaiHoaDon().getTen(),
                hoaDon.getPhieuGiamGia() == null ? null : hoaDon.getPhieuGiamGia().getTenGiamGia()
            });
        }
    }

    public void LoadHoaDonChiTiet(List<HoaDonChiTiet> chiTietList) {
        hdct = hoaDonChiTietService.getAllHoaDonChiTiets();

        defaultTableModel1.setRowCount(0);
        for (HoaDonChiTiet hoaDonChiTiet : hdct) {
            defaultTableModel1.addRow(new Object[]{
                hoaDonChiTiet.getId(),
                hoaDonChiTiet.getHoaDon().getMaHoaDon(),
                hoaDonChiTiet.getSanPhamChiTiet().getId(),
                hoaDonChiTiet.getGiaBan(),
                hoaDonChiTiet.getSoLuong(),
                hoaDonChiTiet.isTrangThai() ? "Còn hàng" : "Hết hàng",});
        }
    }

    public void resetTableHDCT() {
        if (tblHoaDonChiTiet.getRowCount() > 0) {
            defaultTableModel1.setRowCount(0);
        }

    }

    private void exportExcelHD() {
        try {
            JFileChooser fileChooser = new JFileChooser("/");
            fileChooser.setDialogTitle("Export xls file");
            FileNameExtensionFilter extFilter = new FileNameExtensionFilter("Excel spreadsheet files", "xls", "xlsx", "xism");
            fileChooser.setFileFilter(extFilter);

            int confirm = fileChooser.showSaveDialog(this);

            if (confirm == JFileChooser.APPROVE_OPTION) {
                // Create Excel workbook and sheet
                XSSFWorkbook excelWorkbook = new XSSFWorkbook();
                XSSFSheet sheet = excelWorkbook.createSheet("HD_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_kk_mm_ss")));

                XSSFRow row = null;
                Cell cell = null;

                // Header row
                row = sheet.createRow(0); // Adjust row index here if needed
                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue("DANH SACH HOA DON");
                row = sheet.createRow(1); // Adjust header row
                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue("STT");
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue("Ma Hoa Don");
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue("Khach Hang");
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue("Nhan Vien");
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue("Ngay Tao");
                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue("Tong Truoc Giam Gia");
                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue("Tong Sau Giam Gia");
                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue("Ghi Chu");
                cell = row.createCell(8, CellType.STRING);
                cell.setCellValue("Ten Nguoi Nhan");
                cell = row.createCell(9, CellType.STRING);
                cell.setCellValue("So Dien Thoai");
                cell = row.createCell(10, CellType.STRING);
                cell.setCellValue("Dia Chi");
                cell = row.createCell(11, CellType.STRING);
                cell.setCellValue("Trang Thai");
                cell = row.createCell(12, CellType.STRING);
                cell.setCellValue("Phieu Giam Gia");
                // Fill sheet with table data from tblHoaDon
                for (int rowIndex = 0; rowIndex < tblHoaDon.getRowCount(); rowIndex++) {
                    XSSFRow sheetRow = sheet.createRow(rowIndex + 2); // Start after header

                    for (int colIndex = 0; colIndex < tblHoaDon.getColumnCount(); colIndex++) {
                        XSSFCell cellData = sheetRow.createCell(colIndex);

                        Object data = tblHoaDon.getValueAt(rowIndex, colIndex);

                        if (data == null) {
                            continue;
                        }

                        cellData.setCellValue(data.toString());
                    }
                }

                // Ensure the chosen file has the correct extension
                File selectedFile = fileChooser.getSelectedFile();
                String filePath = selectedFile.getAbsolutePath();
                if (!filePath.endsWith(".xlsx")) {
                    filePath += ".xlsx";
                }

                FileOutputStream fos = new FileOutputStream(filePath);
                BufferedOutputStream bos = new BufferedOutputStream(fos);

                excelWorkbook.write(bos);
                bos.close();
                excelWorkbook.close(); // Close the workbook to release resources

                JOptionPane.showMessageDialog(this, "Export successful!");

            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error during export: " + e.getMessage());
        }
    }

    public void Load() {
        int selectedRow = tblHoaDon.getSelectedRow();

        if (selectedRow != -1) {
            DefaultTableModel modelHoaDon = (DefaultTableModel) tblHoaDon.getModel();
            DefaultTableModel modelLichSuHoaDon = (DefaultTableModel) tblLichSuHoaDon.getModel();
            DefaultTableModel modelHoaDonChiTiet = (DefaultTableModel) tblHoaDonChiTiet.getModel();
            int columnCount = tblHoaDon.getColumnCount();
            int columnCountHoaDonChiTiet = tblHoaDonChiTiet.getColumnCount();
            Object[] rowData = new Object[columnCount];
            for (int i = 0; i < columnCount; i++) {
                rowData[i] = modelHoaDon.getValueAt(selectedRow, i);
            }
            modelLichSuHoaDon.addRow(rowData);

            Object[] rowDataHoaDonChiTiet = new Object[columnCountHoaDonChiTiet];

            for (int i = 0; i < columnCountHoaDonChiTiet; i++) {
                rowDataHoaDonChiTiet[i] = modelHoaDon.getValueAt(selectedRow, i);
            }
            modelHoaDonChiTiet.addRow(rowDataHoaDonChiTiet);
        } else {
            System.out.println("Ko in tblHoaDon.");
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnTimKiem = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        btnXuatEx = new javax.swing.JButton();
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
                "STT", "Mã hóa đơn", "Khách hàng", "Nhân viên", "Ngày tạo", "Tổng trước giảm giá", "Tổng sau giảm giá", "Ghi chú", "Tên người nhận", "Số điện thoại", "Địa chỉ", "Trạng thái", "Phiếu giảm giá"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        jButton4.setText("In hóa đơn");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnXuatEx.setText("Xuất danh sách");
        btnXuatEx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatExActionPerformed(evt);
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
                .addContainerGap(388, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(272, 272, 272)
                .addComponent(btnXuatEx)
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
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane1)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(btnXuatEx))
                .addGap(10, 10, 10))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn chi tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblHoaDonChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Hóa đơn", "Sản phẩm chi tiết", "Số lượng", "Gía bán", "Trạng thái"
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
                "STT", "Hóa đơn", "Nhân viên", "Ghi chú", "Ngày tác động"
            }
        ));
        jScrollPane3.setViewportView(tblLichSuHoaDon);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) tblHoaDon.getModel();
        TableRowSorter<DefaultTableModel> ab = new TableRowSorter<>(dtm);
        tblHoaDon.setRowSorter(ab);
        ab.setRowFilter(RowFilter.regexFilter(txtTimKiem.getText()));
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnXuatExActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatExActionPerformed
        // TODO add your handling code here:
        exportExcelHD();

    }//GEN-LAST:event_btnXuatExActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void cbbTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTrangThaiActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cbbTrangThaiActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:
        int id = hoaDonService.getAllHoaDon().get(tblHoaDon.getSelectedRow()).getId();
        LoadHoaDonChiTiet(hoaDonChiTietService.getHoaDonByID(id));
        Load();


    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try {
            int row = this.tblHoaDon.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Chọn 1 hóa đơn để in");
                return;
            }
            String ma = this.tblHoaDon.getValueAt(row, 1).toString();
            HoaDon hoaDon = hoaDonService.findHdByMa(ma);
            if (hoaDon.getId() == 2) {
                int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn in hóa đơn không?");
                if (confirm == JOptionPane.YES_OPTION) {
                    JFileChooser avatarChooser = new JFileChooser("D:\\");
                    avatarChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); //Giới hạn chỉ chọn đc thư mục
                    FileNameExtensionFilter avatarFilter = new FileNameExtensionFilter("Exel File", "xlsx");
                    avatarChooser.setFileFilter(avatarFilter);
                    avatarChooser.setAcceptAllFileFilterUsed(false);
                    int selectFileCheck = avatarChooser.showOpenDialog(this);
                    File selectedFile = avatarChooser.getSelectedFile();
                    if (!(selectFileCheck == JFileChooser.APPROVE_OPTION)) {
                        return;
                    }
                    //Muốn lấy đường dẫn và để vào export PDF thì 
                    String path = selectedFile.getAbsolutePath();
                    if (hoaDon.getId() == 0) {
                        ExportPdfHoaDon export = new ExportPdfHoaDon();
                        export.exportBill(hoaDon, hdct, path);
                    }
                    JOptionPane.showMessageDialog(this, "In hóa đơn thành công");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Hãy chọn 1 hóa đơn đã thanh toán");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXuatEx;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JButton jButton4;
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
