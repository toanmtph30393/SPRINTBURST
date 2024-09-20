    package com.n2.sprintburst.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.SoftDeleteType;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "NhanVien")
@SoftDelete(strategy = SoftDeleteType.ACTIVE, columnName = "trangThai")
public class NhanVien {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "maTaiKhoan")
    @NaturalId
    private String maTaiKhoan;

    @Column(name = "email")
    @NaturalId
    private String email;

    @Column(name = "dienThoai")
    @NaturalId
    private String dienThoai;

    @Column(name = "password")
    private String password;

    @Column(name = "hoTen")
    private String hoTen;

    @Column(name = "diaChi")
    private String diaChi;

    @Column(name = "ghiChu")
    private String ghiChu;

    @Column(name = "laQuanLy")
    private boolean laQuanLy;

    @Column(name = "ngayTao")
    private LocalDateTime ngayTao;

    @Column(name = "ngayCapNhat")
    @Version
    private LocalDateTime ngayCapNhat;

    @Column(name = "ngayXoa")
    private LocalDateTime ngayXoa;

    @Column(name = "trangThai", insertable=false, updatable=false)
    private boolean trangThai;

}
