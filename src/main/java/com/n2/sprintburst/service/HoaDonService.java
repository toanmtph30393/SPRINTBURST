/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.n2.sprintburst.service;

import com.n2.sprintburst.config.HibernateConfig;
import com.n2.sprintburst.entity.HoaDon;
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
     public List<HoaDon> getAllHoaDon() {
    List<HoaDon> hd = new ArrayList<>();
    String sql = "SELECT [id]\n" +
"      ,[idKhachHang]\n" +
"      ,[idNhanVien]\n" +
"      ,[idPhieuGiamGia]\n" +
"      ,[idTrangThaiHoaDon]\n" +
"      ,[tongSauGiamGia]\n" +
"      ,[tongTruocGiamGia]\n" +
"      ,[ngayTao]\n" +
"      ,[diaChiNguoiNhan]\n" +
"      ,[dienThoaiNguoiNhan]\n" +
"      ,[ghiChu]\n" +
"      ,[maHoaDon]\n" +
"      ,[tenNguoiNhan]\n" +
"  FROM [dbo].[HoaDon]";
    
    try (Connection con = (Connection) new HibernateConfig().getSessionFactory();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
//            HoaDon h;
//            h = new HoaDon(
//                    rs.getInt(1),        
//                    rs.getString(2),     
//                    rs.getString(3),     
//                    rs.getInt(4),        
//                    rs.getInt(5),        
//                    rs.getString(6),       
//                    rs.getInt(7),         
//                    rs.getDate(8),        
//                    rs.getString(9),      
//                    rs.getString(10),     
//                    rs.getString(11),     
//                    rs.getString(12),     
//                    rs.getInt(13)      
//            );
//            hd.add(h);
        }
        System.out.println("Load data thành công");
    } catch (Exception e) {
        System.out.println("Load data thất bại");
        System.out.println(e);
    }
    
    return hd;
    }
}
