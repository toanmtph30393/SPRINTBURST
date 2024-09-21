package com.n2.sprintburst.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.SoftDeleteType;

@Entity
@Table(name = "HoaDonChiTiet")
@SoftDelete(strategy = SoftDeleteType.ACTIVE, columnName = "trangThai")
public class HoaDonChiTiet {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "soLuong")
    private int soLuong;

    @Column(name = "giaBan")
    private int giaBan;

    @Column(name = "trangThai", insertable = false, updatable = false)
    private boolean trangThai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idHoaDon", referencedColumnName = "id")
    private HoaDon hoaDon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSanPhamChiTiet", referencedColumnName = "id")
    private SanPhamChiTiet sanPhamChiTiet;
}
