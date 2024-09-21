/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.n2.sprintburst.service;

import com.n2.sprintburst.config.HibernateConfig;
import com.n2.sprintburst.entity.HoaDon;
import com.n2.sprintburst.response.HoaDonResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NhokHip
 */
public class HoaDonService {
     public ArrayList<HoaDonResponse> getAll() {
    String sql = """
                 SELECT [id]
                       ,[idKhachHang]
                       ,[idNhanVien]
                       ,[idPhieuGiamGia]
                       ,[idTrangThaiHoaDon]
                       ,[tongSauGiamGia]
                       ,[tongTruocGiamGia]
                       ,[ngayTao]
                       ,[diaChiNguoiNhan]
                       ,[dienThoaiNguoiNhan]
                       ,[ghiChu]
                       ,[maHoaDon]
                       ,[tenNguoiNhan]
                 FROM [dbo].[HoaDon]
                 """;
    ArrayList<HoaDonResponse> lists = new ArrayList<>();
    try (Connection con = (Connection) HibernateConfig.getSessionFactory();  
         PreparedStatement ps = con.prepareStatement(sql)) {
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            HoaDonResponse response = HoaDonResponse.builder()
                    .id(rs.getInt("id"))
                    .idKhachHang(rs.getString("idKhachHang"))
                    .idNhanVien(rs.getString("idNhanVien"))
                    .idphieuGiamGia(rs.getString("idPhieuGiamGia"))
                    .idtrangThaiHoaDon(rs.getString("idTrangThaiHoaDon"))
                    .tongSauGiamGia(rs.getInt("tongSauGiamGia")) 
                    .tongTruocGiamGia(rs.getInt("tongTruocGiamGia"))
                    .ngayTao(rs.getTimestamp("ngayTao").toLocalDateTime())  
                    .diaChiNguoiNhan(rs.getString("diaChiNguoiNhan"))
                    .dienThoaiNguoiNhan(rs.getString("dienThoaiNguoiNhan"))
                    .ghiChu(rs.getString("ghiChu"))
                    .maHoaDon(rs.getString("maHoaDon"))
                    .tenNguoiNhan(rs.getString("tenNguoiNhan"))
                    .build();
            lists.add(response);
        }
    } catch (Exception e) {
        e.printStackTrace(System.out);
    }
    return lists;
}


}
