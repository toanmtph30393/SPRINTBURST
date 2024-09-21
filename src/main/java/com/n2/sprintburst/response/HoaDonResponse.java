package com.n2.sprintburst.response;

import java.util.Date;
public class HoaDonResponse {
    private int id;
    private int idKhachHang;
    private int idNhanVien;
    private int idPhieuGiamGia;
    private int idTrangThaiHoaDon;
    private int tongSauGiamGia;
    private int tongTruocGiamGia;
    private Date ngayTao;
    private String diaChiNguoiNhan;
    private String dienThoaiNguoiNhan;
    private String ghiChu;
    private String maHoaDon;
    private String tenNguoiNhan;

    public HoaDonResponse() {
    }

    public HoaDonResponse(int id, int idKhachHang, int idNhanVien, int idPhieuGiamGia, int idTrangThaiHoaDon, int tongSauGiamGia, int tongTruocGiamGia, Date ngayTao, String diaChiNguoiNhan, String dienThoaiNguoiNhan, String ghiChu, String maHoaDon, String tenNguoiNhan) {
        this.id = id;
        this.idKhachHang = idKhachHang;
        this.idNhanVien = idNhanVien;
        this.idPhieuGiamGia = idPhieuGiamGia;
        this.idTrangThaiHoaDon = idTrangThaiHoaDon;
        this.tongSauGiamGia = tongSauGiamGia;
        this.tongTruocGiamGia = tongTruocGiamGia;
        this.ngayTao = ngayTao;
        this.diaChiNguoiNhan = diaChiNguoiNhan;
        this.dienThoaiNguoiNhan = dienThoaiNguoiNhan;
        this.ghiChu = ghiChu;
        this.maHoaDon = maHoaDon;
        this.tenNguoiNhan = tenNguoiNhan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public int getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(int idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public int getIdPhieuGiamGia() {
        return idPhieuGiamGia;
    }

    public void setIdPhieuGiamGia(int idPhieuGiamGia) {
        this.idPhieuGiamGia = idPhieuGiamGia;
    }

    public int getIdTrangThaiHoaDon() {
        return idTrangThaiHoaDon;
    }

    public void setIdTrangThaiHoaDon(int idTrangThaiHoaDon) {
        this.idTrangThaiHoaDon = idTrangThaiHoaDon;
    }

    public int getTongSauGiamGia() {
        return tongSauGiamGia;
    }

    public void setTongSauGiamGia(int tongSauGiamGia) {
        this.tongSauGiamGia = tongSauGiamGia;
    }

    public int getTongTruocGiamGia() {
        return tongTruocGiamGia;
    }

    public void setTongTruocGiamGia(int tongTruocGiamGia) {
        this.tongTruocGiamGia = tongTruocGiamGia;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getDiaChiNguoiNhan() {
        return diaChiNguoiNhan;
    }

    public void setDiaChiNguoiNhan(String diaChiNguoiNhan) {
        this.diaChiNguoiNhan = diaChiNguoiNhan;
    }

    public String getDienThoaiNguoiNhan() {
        return dienThoaiNguoiNhan;
    }

    public void setDienThoaiNguoiNhan(String dienThoaiNguoiNhan) {
        this.dienThoaiNguoiNhan = dienThoaiNguoiNhan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

   
}
