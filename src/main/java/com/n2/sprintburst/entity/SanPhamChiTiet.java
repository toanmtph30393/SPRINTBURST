package com.n2.sprintburst.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.SoftDeleteType;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "SanPhamChiTiet")
@SoftDelete(strategy = SoftDeleteType.ACTIVE, columnName = "trangThai")
public class SanPhamChiTiet {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "maSanPhamChiTiet")
    private String maSanPhamChiTiet;

    @Column(name = "tenSanPhamChiTiet")
    private String tenSanPhamChiTiet;

    @Column(name = "moTa")
    private String moTa;

    @Column(name = "ngayTao")
    private LocalDateTime ngayTao;

    @Column(name = "ngayCapNhat")
    @Version
    private LocalDateTime ngayCapNhat;

    @Column(name = "ngayXoa")
    private LocalDateTime ngayXoa;

    @Column(name = "trangThai", insertable=false, updatable=false)
    private boolean trangThai;

    @Column(name = "giaBan")
    private int giaBan;

    @Column(name = "soLuong")
    private int soLuong;

    @ManyToOne
    @JoinColumn(name = "idSanPham", referencedColumnName = "id")
    private SanPham sanPham;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idThuongHieu", referencedColumnName = "id")
    private ThuongHieu thuongHieu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idXuatXu", referencedColumnName = "id")
    private XuatXu xuatXu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idChatLieu", referencedColumnName = "id")
    private ChatLieu chatLieu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDeGiay", referencedColumnName = "id")
    private DeGiay deGiay;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCoGiay", referencedColumnName = "id")
    private CoGiay coGiay;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMauSac", referencedColumnName = "id")
    private MauSac mauSac;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSize", referencedColumnName = "id")
    private Size size;
}
