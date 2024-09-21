/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.n2.sprintburst.view.sanPham;

import com.n2.sprintburst.entity.SanPham;
import com.n2.sprintburst.entity.SanPhamChiTiet;
import com.n2.sprintburst.entity.Size;
import com.n2.sprintburst.entity.ThuocTinh;
import com.n2.sprintburst.service.SanPhamChiTietService;
import com.n2.sprintburst.service.SanPhamService;
import com.n2.sprintburst.service.ThuocTinhService;
import com.n2.sprintburst.utils.PlaceHolderdata;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mtt
 */
public class SanPhamView extends javax.swing.JPanel {

    //COMPONENT MODELS
    private DefaultTableModel sanPhamTableModel;
    private DefaultTableModel thuocTinhTableModel;
    private DefaultTableModel sanPhamChiTietTableModel;

    //STATES
    List<SanPham> sanPhamState;
    List<ThuocTinh> thuocTinhState;
    List<SanPhamChiTiet> sanPhamChiTietState;

    /**
     * Creates new form SanPhamView
     */
    public SanPhamView() {

        initComponents();

        //init component models
        sanPhamTableModel = (DefaultTableModel) tblSanPham.getModel();
        thuocTinhTableModel = (DefaultTableModel) tblThuocTinh.getModel();
        sanPhamChiTietTableModel = (DefaultTableModel) tblSanPhamChiTiet.getModel();

        //init state 
        initOrRefreshStateSanPham();
        initOrRefreshStateSanPhamChiTiet();

        //init table
        initSanPhamTable();
        renderSanPhamChiTietTable();

        Collections.reverse(sanPhamState);
        Collections.reverse(sanPhamChiTietState);
    }

    //STATES
    private void initOrRefreshStateSanPham() {
        sanPhamState = SanPhamService.getAllActive();
    }

    private void initOrRefreshStateThuocTinh() {

    }

    protected void initOrRefreshStateSanPhamChiTiet() {
        sanPhamChiTietState = SanPhamChiTietService.getAllActive();
    }

    //UI
    private void renderOrRefreshSanPhamForm() {
        initSanPhamTable();

        txtAddSanPhamName.setText("");
        txtSearchSanPham.setText("");
        cbxFilterTrangThaiSanPham.setSelectedIndex(0);
    }

    private void initSanPhamTable() {
        loadSanPhamTable(sanPhamState);

    }

    private void loadSanPhamTable(List<SanPham> list) {

        sanPhamTableModel.setRowCount(0);

        for (int i = 0; i < list.size(); i++) {
            SanPham sp = list.get(i);
            sanPhamTableModel.addRow(new Object[]{
                i + 1,
                sp.getMaSanPham(),
                sp.getTenSanPham(),
                sp.getSanPhamChiTiets().size(),
                sp.isTrangThai() ? "Đang bán" : "Ngừng bán"
            });
        }
    }

    private int getSelectedSanPhamTblIdx() {
        return tblSanPham.getSelectedRow();
    }

    private void filterThuocTinh(String rawText) {

        String tbl;

        switch (rawText) {
            case "Thương hiệu":
                tbl = "ThuongHieu";
                break;
            case "Xuất xứ":
                tbl = "XuatXu";
                break;
            case "Chất liệu":
                tbl = "ChatLieu";
                break;
            case "Đế giày":
                tbl = "DeGiay";
                break;
            case "Cổ giày":
                tbl = "CoGiay";
                break;
            case "Màu sắc":
                tbl = "MauSac";
                break;
            default:
                tbl = "Size";
                break;
        }
        System.err.println(rawText);
        System.err.println(tbl);

        thuocTinhState = ThuocTinhService.getThuocTinhByTableName(tbl);
        loadThuocTinhTable();
    }

    private void loadThuocTinhTable() {
        thuocTinhTableModel.setRowCount(0);

        if (thuocTinhState.isEmpty()) {
            System.err.println("state is empty");
            return;
        }
        if (thuocTinhState.get(0) instanceof Size) {
            for (ThuocTinh item : thuocTinhState) {
                Size row = (Size) item;
                thuocTinhTableModel.addRow(new Object[]{thuocTinhState.indexOf(item) + 1, row.getTen()});
            }
        } else {
            for (ThuocTinh item : thuocTinhState) {
                thuocTinhTableModel.addRow(new Object[]{thuocTinhState.indexOf(item) + 1, item.getTen()});
            }
        }
    }

    protected void renderSanPhamChiTietTable() {
        sanPhamChiTietTableModel.setRowCount(0);
        for (int i = 0; i < sanPhamChiTietState.size(); i++) {
            SanPhamChiTiet sp = sanPhamChiTietState.get(i);
            sanPhamChiTietTableModel.addRow(new Object[]{
                i + 1,
                sp.getMaSanPhamChiTiet(),
                sp.getSanPham() != null ? sp.getSanPham().getTenSanPham() : null,
                sp.getTenSanPhamChiTiet(),
                sp.getThuongHieu() != null ? sp.getThuongHieu().getTen() : null,
                sp.getXuatXu() != null ? sp.getXuatXu().getTen() : null,
                sp.getChatLieu() != null ? sp.getChatLieu().getTen() : null,
                sp.getDeGiay() != null ? sp.getDeGiay().getTen() : null,
                sp.getCoGiay() != null ? sp.getCoGiay().getTen() : null,
                sp.getMauSac() != null ? sp.getMauSac().getTen() : null,
                sp.getSize() != null ? sp.getSize().getTen() : null,
                sp.getGiaBan(),
                sp.getSoLuong()
            });
        }
    }

    //INTERACTIONS
    private void addSanPham() {
        try {
            String text = txtAddSanPhamName.getText();

            SanPham newSp = new SanPham();
            newSp.setTenSanPham(text);

            if (JOptionPane.showConfirmDialog(this, "add?", "add", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
                return;
            }
            SanPhamService.add(newSp);

            initOrRefreshStateSanPham();
            renderOrRefreshSanPhamForm();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void editSanPham() {
        try {
            String text = txtAddSanPhamName.getText();

            SanPham editSp = getSelectedSanPham();
            editSp.setTenSanPham(text);

            if (JOptionPane.showConfirmDialog(this, "edit?", "edit", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
                return;
            }
            SanPhamService.update(editSp);

            initOrRefreshStateSanPham();
            renderOrRefreshSanPhamForm();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void deleteSanPham() {
        try {
            SanPham deleteSp = getSelectedSanPham();
            if (JOptionPane.showConfirmDialog(this, "delete?", "delete", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
                return;
            }
            SanPhamService.delete(deleteSp);

            initOrRefreshStateSanPham();
            renderOrRefreshSanPhamForm();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void chooseSanPhamTblRow() {
        int idx = getSelectedSanPhamTblIdx();
        txtAddSanPhamName.setText(sanPhamState.get(idx).getTenSanPham());
    }

    private SanPham getSelectedSanPham() {
        int idx = getSelectedSanPhamTblIdx();
        return sanPhamState.get(idx);
    }

    private void filterSanPhamTable() {
        boolean status = cbxFilterTrangThaiSanPham.getSelectedIndex() == 0;
        String keyword = txtSearchSanPham.getText();

        sanPhamState = SanPhamService.getByFilter(status, keyword);
        loadSanPhamTable(sanPhamState);

    }

    private void addThuocTinh() {
        String rawText = ThuocTinhFilterGroup.getSelection().getActionCommand();
        String tbl;

        switch (rawText) {
            case "Thương hiệu":
                tbl = "ThuongHieu";
                break;
            case "Xuất xứ":
                tbl = "XuatXu";
                break;
            case "Chất liệu":
                tbl = "ChatLieu";
                break;
            case "Đế giày":
                tbl = "DeGiay";
                break;
            case "Cổ giày":
                tbl = "CoGiay";
                break;
            case "Màu sắc":
                tbl = "MauSac";
                break;
            default:
                tbl = "Size";
                break;
        }

        String ten = txtThuocTinhAdd.getText();

        ThuocTinhService.add(ten, tbl);
        filterThuocTinh(rawText);
        loadThuocTinhTable();

    }

    private void deleteThuocTinh() {
        String rawText = ThuocTinhFilterGroup.getSelection().getActionCommand();
        String tbl;

        switch (rawText) {
            case "Thương hiệu":
                tbl = "ThuongHieu";
                break;
            case "Xuất xứ":
                tbl = "XuatXu";
                break;
            case "Chất liệu":
                tbl = "ChatLieu";
                break;
            case "Đế giày":
                tbl = "DeGiay";
                break;
            case "Cổ giày":
                tbl = "CoGiay";
                break;
            case "Màu sắc":
                tbl = "MauSac";
                break;
            default:
                tbl = "Size";
                break;
        }

        String ten = tblThuocTinh.getValueAt(tblThuocTinh.getSelectedRow(), 1).toString();

        ThuocTinhService.delete(ten, tbl);

        filterThuocTinh(rawText);
        loadThuocTinhTable();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ThuocTinhFilterGroup = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        sanPhamTab = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        addPanel = new javax.swing.JPanel();
        txtAddSanPhamName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnAddSanPham = new javax.swing.JButton();
        actionPanel = new javax.swing.JPanel();
        btnEditSanPham = new javax.swing.JButton();
        btnDeleteSanPham = new javax.swing.JButton();
        btnAddSanPhamChiTiet = new javax.swing.JButton();
        btnResetFormSanPhamTab = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        cbxFilterTrangThaiSanPham = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSearchSanPham = new javax.swing.JTextField();
        sanPhamChiTietTab = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cbxXuatXu = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbxThuongHieu = new javax.swing.JComboBox<>();
        cbxChatLieu = new javax.swing.JComboBox<>();
        cbxMauSac = new javax.swing.JComboBox<>();
        cbxCoGiay = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cbxDeGiay = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        cbxSize = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtFilterPriceMin = new javax.swing.JTextField();
        txtFilterPriceMax = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtSeatchSPCT = new javax.swing.JTextField();
        btnSearchSPCT = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnAddSPCT = new javax.swing.JButton();
        btnExportExl = new javax.swing.JButton();
        btnExportQR = new javax.swing.JButton();
        btnImportQR = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnResetFromSPCT = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSanPhamChiTiet = new javax.swing.JTable();
        thuocTinhTab = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtThuocTinhAdd = new javax.swing.JTextField();
        btnAddThuocTinh = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnDeleteThuocTinh1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        rdoThuongHieu = new javax.swing.JRadioButton();
        rdoDeGiay = new javax.swing.JRadioButton();
        rdoXuatXu = new javax.swing.JRadioButton();
        rdoCoGiay = new javax.swing.JRadioButton();
        rdoChatLieu = new javax.swing.JRadioButton();
        rdoMauSac = new javax.swing.JRadioButton();
        rdoSize = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblThuocTinh = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(900, 600));

        jTabbedPane1.setMaximumSize(new java.awt.Dimension(9999, 600));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(900, 600));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(900, 600));

        sanPhamTab.setMaximumSize(new java.awt.Dimension(900, 600));
        sanPhamTab.setMinimumSize(new java.awt.Dimension(900, 600));
        sanPhamTab.setPreferredSize(new java.awt.Dimension(900, 600));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÔNG TIN SẢN PHẨM");

        addPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thao tác tên sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        addPanel.setPreferredSize(new java.awt.Dimension(420, 100));

        jLabel3.setText("Tên");

        btnAddSanPham.setText("Thêm");
        btnAddSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSanPhamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addPanelLayout = new javax.swing.GroupLayout(addPanel);
        addPanel.setLayout(addPanelLayout);
        addPanelLayout.setHorizontalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtAddSanPhamName, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAddSanPham)
                .addGap(0, 18, Short.MAX_VALUE))
        );
        addPanelLayout.setVerticalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddSanPhamName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnAddSanPham))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        actionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Hành động", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        actionPanel.setPreferredSize(new java.awt.Dimension(420, 100));

        btnEditSanPham.setText("Sửa");
        btnEditSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditSanPhamActionPerformed(evt);
            }
        });

        btnDeleteSanPham.setText("Xóa");
        btnDeleteSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSanPhamActionPerformed(evt);
            }
        });

        btnAddSanPhamChiTiet.setText("Thêm SPCT");
        btnAddSanPhamChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSanPhamChiTietActionPerformed(evt);
            }
        });

        btnResetFormSanPhamTab.setText("Reset form");
        btnResetFormSanPhamTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetFormSanPhamTabActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout actionPanelLayout = new javax.swing.GroupLayout(actionPanel);
        actionPanel.setLayout(actionPanelLayout);
        actionPanelLayout.setHorizontalGroup(
            actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, actionPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnResetFormSanPhamTab, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddSanPhamChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        actionPanelLayout.setVerticalGroup(
            actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditSanPham)
                    .addComponent(btnDeleteSanPham))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnResetFormSanPhamTab)
                    .addComponent(btnAddSanPhamChiTiet))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã", "Tên", "Số lượng", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblSanPham.getTableHeader().setReorderingAllowed(false);
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        jLabel4.setText("Trạng thái");

        cbxFilterTrangThaiSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang bán", "Ngừng bán" }));

        jLabel5.setText("Từ khóa");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Tìm kiếm");

        txtSearchSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchSanPhamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sanPhamTabLayout = new javax.swing.GroupLayout(sanPhamTab);
        sanPhamTab.setLayout(sanPhamTabLayout);
        sanPhamTabLayout.setHorizontalGroup(
            sanPhamTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sanPhamTabLayout.createSequentialGroup()
                .addGroup(sanPhamTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sanPhamTabLayout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sanPhamTabLayout.createSequentialGroup()
                        .addContainerGap(18, Short.MAX_VALUE)
                        .addGroup(sanPhamTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(sanPhamTabLayout.createSequentialGroup()
                                .addComponent(addPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(actionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(sanPhamTabLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxFilterTrangThaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearchSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6))))
                .addGap(18, 18, 18))
        );
        sanPhamTabLayout.setVerticalGroup(
            sanPhamTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sanPhamTabLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(sanPhamTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sanPhamTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(sanPhamTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxFilterTrangThaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(txtSearchSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("SẢN PHẨM", sanPhamTab);

        sanPhamChiTietTab.setMaximumSize(new java.awt.Dimension(900, 600));
        sanPhamChiTietTab.setMinimumSize(new java.awt.Dimension(900, 600));
        sanPhamChiTietTab.setPreferredSize(new java.awt.Dimension(900, 600));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("THÔNG TIN SẢN PHẨM CHI TIẾT");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        cbxXuatXu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Xuất xứ");

        jLabel10.setText("Thương hiệu");

        jLabel11.setText("Chất liệu");

        cbxThuongHieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxCoGiay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel12.setText("Cổ giày");

        jLabel13.setText("Đế giày");

        jLabel14.setText("Màu sắc");

        cbxDeGiay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel15.setText("Size");

        cbxSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel16.setText("Giá tối thiểu");

        jLabel17.setText("Giá tối đa");

        txtFilterPriceMin.setText("0");

        txtFilterPriceMax.setText("999999999");

        jLabel18.setText("Tên");

        btnSearchSPCT.setText("Search");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(cbxDeGiay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbxSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnSearchSPCT))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(cbxMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtFilterPriceMax, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cbxCoGiay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtFilterPriceMin, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(1, 1, 1)))
                        .addGap(14, 14, 14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSeatchSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(cbxDeGiay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(cbxSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(cbxCoGiay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(txtFilterPriceMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(cbxMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(txtFilterPriceMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cbxThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cbxXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cbxChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtSeatchSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchSPCT))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Hành động", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel2.setToolTipText("");

        btnAddSPCT.setText("Thêm SPCT");
        btnAddSPCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSPCTActionPerformed(evt);
            }
        });

        btnExportExl.setText("Xuất Excel");

        btnExportQR.setText("Xuất QR");

        btnImportQR.setText("Đọc QR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddSPCT)
                    .addComponent(btnExportQR, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnExportExl, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                    .addComponent(btnImportQR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddSPCT)
                    .addComponent(btnExportExl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExportQR)
                    .addComponent(btnImportQR))
                .addGap(19, 19, 19))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder()));

        btnResetFromSPCT.setText("Reset");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(btnResetFromSPCT)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnResetFromSPCT)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblSanPhamChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã spct", "Tên sp", "Tên spct", "Thương hiệu", "Xuất xứ", "Chất liệu", "Đế", "Cổ", "Màu", "Size", "Giá", "Số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPhamChiTiet.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblSanPhamChiTiet.getTableHeader().setReorderingAllowed(false);
        tblSanPhamChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamChiTietMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblSanPhamChiTiet);

        javax.swing.GroupLayout sanPhamChiTietTabLayout = new javax.swing.GroupLayout(sanPhamChiTietTab);
        sanPhamChiTietTab.setLayout(sanPhamChiTietTabLayout);
        sanPhamChiTietTabLayout.setHorizontalGroup(
            sanPhamChiTietTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sanPhamChiTietTabLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(sanPhamChiTietTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sanPhamChiTietTabLayout.createSequentialGroup()
                        .addGroup(sanPhamChiTietTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(sanPhamChiTietTabLayout.createSequentialGroup()
                                .addGap(283, 283, 283)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(sanPhamChiTietTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18))
        );
        sanPhamChiTietTabLayout.setVerticalGroup(
            sanPhamChiTietTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sanPhamChiTietTabLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(sanPhamChiTietTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(sanPhamChiTietTabLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CHI TIẾT SẢN PHẨM", sanPhamChiTietTab);

        thuocTinhTab.setMaximumSize(new java.awt.Dimension(900, 600));
        thuocTinhTab.setMinimumSize(new java.awt.Dimension(900, 600));
        thuocTinhTab.setPreferredSize(new java.awt.Dimension(900, 600));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("THUỘC TÍNH SẢN PHẨM");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thêm thuộc tính", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel3.setMinimumSize(new java.awt.Dimension(400, 100));

        jLabel2.setText("Tên");

        txtThuocTinhAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThuocTinhAddActionPerformed(evt);
            }
        });

        btnAddThuocTinh.setText("Thêm");
        btnAddThuocTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddThuocTinhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddThuocTinh)
                    .addComponent(txtThuocTinhAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtThuocTinhAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(btnAddThuocTinh)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Hành động", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel4.setMinimumSize(new java.awt.Dimension(100, 100));

        btnDeleteThuocTinh1.setText("Xóa");
        btnDeleteThuocTinh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteThuocTinh1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnDeleteThuocTinh1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnDeleteThuocTinh1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Bộ lọc", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel5.setToolTipText("");

        ThuocTinhFilterGroup.add(rdoThuongHieu);
        rdoThuongHieu.setText("Thương hiệu");
        rdoThuongHieu.setActionCommand("Thương hiệu");
        rdoThuongHieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoThuongHieuMouseClicked(evt);
            }
        });
        rdoThuongHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoThuongHieuActionPerformed(evt);
            }
        });

        ThuocTinhFilterGroup.add(rdoDeGiay);
        rdoDeGiay.setText("Đế giày");
        rdoDeGiay.setActionCommand("Đế giày");
        rdoDeGiay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoDeGiayMouseClicked(evt);
            }
        });

        ThuocTinhFilterGroup.add(rdoXuatXu);
        rdoXuatXu.setText("Xuất xứ");
        rdoXuatXu.setActionCommand("Xuất xứ");
        rdoXuatXu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoXuatXuMouseClicked(evt);
            }
        });

        ThuocTinhFilterGroup.add(rdoCoGiay);
        rdoCoGiay.setText("Cổ giày");
        rdoCoGiay.setActionCommand("Cổ giày");
        rdoCoGiay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoCoGiayMouseClicked(evt);
            }
        });

        ThuocTinhFilterGroup.add(rdoChatLieu);
        rdoChatLieu.setText("Chất liệu");
        rdoChatLieu.setActionCommand("Chất liệu");
        rdoChatLieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoChatLieuMouseClicked(evt);
            }
        });

        ThuocTinhFilterGroup.add(rdoMauSac);
        rdoMauSac.setText("Màu sắc");
        rdoMauSac.setActionCommand("Màu sắc");
        rdoMauSac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoMauSacMouseClicked(evt);
            }
        });

        ThuocTinhFilterGroup.add(rdoSize);
        rdoSize.setText("Size");
        rdoSize.setActionCommand("Size");
        rdoSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoSizeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdoThuongHieu)
                    .addComponent(rdoDeGiay)
                    .addComponent(rdoSize))
                .addGap(45, 45, 45)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(rdoCoGiay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdoMauSac))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(rdoXuatXu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(rdoChatLieu)))
                .addGap(58, 58, 58))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoThuongHieu)
                    .addComponent(rdoXuatXu)
                    .addComponent(rdoChatLieu))
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoDeGiay)
                    .addComponent(rdoCoGiay)
                    .addComponent(rdoMauSac))
                .addGap(33, 33, 33)
                .addComponent(rdoSize)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblThuocTinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "STT", "Tên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblThuocTinh.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblThuocTinh.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblThuocTinh);

        javax.swing.GroupLayout thuocTinhTabLayout = new javax.swing.GroupLayout(thuocTinhTab);
        thuocTinhTab.setLayout(thuocTinhTabLayout);
        thuocTinhTabLayout.setHorizontalGroup(
            thuocTinhTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(thuocTinhTabLayout.createSequentialGroup()
                .addGroup(thuocTinhTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(thuocTinhTabLayout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(thuocTinhTabLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(thuocTinhTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 854, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(thuocTinhTabLayout.createSequentialGroup()
                                .addGroup(thuocTinhTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        thuocTinhTabLayout.setVerticalGroup(
            thuocTinhTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(thuocTinhTabLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(thuocTinhTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(thuocTinhTabLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("THUỘC TÍNH SẢN PHẨM", thuocTinhTab);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditSanPhamActionPerformed
        editSanPham();
    }//GEN-LAST:event_btnEditSanPhamActionPerformed

    private void btnDeleteSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSanPhamActionPerformed
        deleteSanPham();
    }//GEN-LAST:event_btnDeleteSanPhamActionPerformed

    private void btnAddSanPhamChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSanPhamChiTietActionPerformed
        // TODO addOrUpdate your handling code here:
    }//GEN-LAST:event_btnAddSanPhamChiTietActionPerformed

    private void btnResetFormSanPhamTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetFormSanPhamTabActionPerformed
        renderOrRefreshSanPhamForm();
    }//GEN-LAST:event_btnResetFormSanPhamTabActionPerformed

    private void btnAddSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSanPhamActionPerformed
        addSanPham();
    }//GEN-LAST:event_btnAddSanPhamActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        chooseSanPhamTblRow();
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void txtSearchSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchSanPhamActionPerformed
        filterSanPhamTable();
    }//GEN-LAST:event_txtSearchSanPhamActionPerformed

    private void btnDeleteThuocTinh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteThuocTinh1ActionPerformed
        deleteThuocTinh();
    }//GEN-LAST:event_btnDeleteThuocTinh1ActionPerformed

    private void rdoThuongHieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoThuongHieuMouseClicked
        filterThuocTinh(rdoThuongHieu.getActionCommand());    }//GEN-LAST:event_rdoThuongHieuMouseClicked

    private void rdoXuatXuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoXuatXuMouseClicked
        filterThuocTinh(rdoXuatXu.getActionCommand());    }//GEN-LAST:event_rdoXuatXuMouseClicked

    private void rdoChatLieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoChatLieuMouseClicked
        filterThuocTinh(rdoChatLieu.getActionCommand());    }//GEN-LAST:event_rdoChatLieuMouseClicked

    private void rdoDeGiayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoDeGiayMouseClicked
        filterThuocTinh(rdoDeGiay.getActionCommand());    }//GEN-LAST:event_rdoDeGiayMouseClicked

    private void rdoCoGiayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoCoGiayMouseClicked
        filterThuocTinh(rdoCoGiay.getActionCommand());    }//GEN-LAST:event_rdoCoGiayMouseClicked

    private void rdoMauSacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoMauSacMouseClicked
        filterThuocTinh(rdoMauSac.getActionCommand());    }//GEN-LAST:event_rdoMauSacMouseClicked

    private void rdoSizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoSizeMouseClicked
        filterThuocTinh(rdoSize.getActionCommand());
    }//GEN-LAST:event_rdoSizeMouseClicked

    private void rdoThuongHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoThuongHieuActionPerformed
        // TODO addOrUpdate your handling code here:
    }//GEN-LAST:event_rdoThuongHieuActionPerformed

    private void txtThuocTinhAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThuocTinhAddActionPerformed
        // TODO addOrUpdate your handling code here:
    }//GEN-LAST:event_txtThuocTinhAddActionPerformed

    private void btnAddThuocTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddThuocTinhActionPerformed
        addThuocTinh();
    }//GEN-LAST:event_btnAddThuocTinhActionPerformed

    private void btnAddSPCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSPCTActionPerformed
        new SanPhamChiTietCreateview(this).setVisible(true);
    }//GEN-LAST:event_btnAddSPCTActionPerformed

    private void tblSanPhamChiTietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamChiTietMouseClicked
        SanPhamChiTiet spct = sanPhamChiTietState.get(tblSanPhamChiTiet.getSelectedRow());

        new SanPhamChiTietUpdateView(spct, this).setVisible(true);
    }//GEN-LAST:event_tblSanPhamChiTietMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup ThuocTinhFilterGroup;
    private javax.swing.JPanel actionPanel;
    private javax.swing.JPanel addPanel;
    private javax.swing.JButton btnAddSPCT;
    private javax.swing.JButton btnAddSanPham;
    private javax.swing.JButton btnAddSanPhamChiTiet;
    private javax.swing.JButton btnAddThuocTinh;
    private javax.swing.JButton btnDeleteSanPham;
    private javax.swing.JButton btnDeleteThuocTinh1;
    private javax.swing.JButton btnEditSanPham;
    private javax.swing.JButton btnExportExl;
    private javax.swing.JButton btnExportQR;
    private javax.swing.JButton btnImportQR;
    private javax.swing.JButton btnResetFormSanPhamTab;
    private javax.swing.JButton btnResetFromSPCT;
    private javax.swing.JButton btnSearchSPCT;
    private javax.swing.JComboBox<String> cbxChatLieu;
    private javax.swing.JComboBox<String> cbxCoGiay;
    private javax.swing.JComboBox<String> cbxDeGiay;
    private javax.swing.JComboBox<String> cbxFilterTrangThaiSanPham;
    private javax.swing.JComboBox<String> cbxMauSac;
    private javax.swing.JComboBox<String> cbxSize;
    private javax.swing.JComboBox<String> cbxThuongHieu;
    private javax.swing.JComboBox<String> cbxXuatXu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rdoChatLieu;
    private javax.swing.JRadioButton rdoCoGiay;
    private javax.swing.JRadioButton rdoDeGiay;
    private javax.swing.JRadioButton rdoMauSac;
    private javax.swing.JRadioButton rdoSize;
    private javax.swing.JRadioButton rdoThuongHieu;
    private javax.swing.JRadioButton rdoXuatXu;
    private javax.swing.JPanel sanPhamChiTietTab;
    private javax.swing.JPanel sanPhamTab;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTable tblSanPhamChiTiet;
    private javax.swing.JTable tblThuocTinh;
    private javax.swing.JPanel thuocTinhTab;
    private javax.swing.JTextField txtAddSanPhamName;
    private javax.swing.JTextField txtFilterPriceMax;
    private javax.swing.JTextField txtFilterPriceMin;
    private javax.swing.JTextField txtSearchSanPham;
    private javax.swing.JTextField txtSeatchSPCT;
    private javax.swing.JTextField txtThuocTinhAdd;
    // End of variables declaration//GEN-END:variables
}
