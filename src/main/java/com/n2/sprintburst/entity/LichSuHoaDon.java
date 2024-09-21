package com.n2.sprintburst.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "LichSuHoaDon")
public class LichSuHoaDon {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ngayTacDong")
    private LocalDateTime ngayTacDong;

    @Column(name = "ghiChu")
    private String ghiChu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idHoaDon", referencedColumnName = "id")
    private HoaDon hoaDon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idNhanVien", referencedColumnName = "id")
    private NhanVien nhanVien;
}
