package com.n2.sprintburst.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.SoftDeleteType;

import java.time.LocalDateTime;

@Entity
@Table(name = "ThanhToan")
public class ThanhToan {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Version
    @Column(name = "ngayThanhToan")
    private LocalDateTime ngayThanhToan;

    @Column(name = "soTienMat")
    private int soTienMat;

    @Column(name = "soTienChuyen")
    private int soTienChuyen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idHoaDon", referencedColumnName = "id")
    private HoaDon hoaDon;
}
