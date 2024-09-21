/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.n2.sprintburst.repository;

import com.n2.sprintburst.config.HibernateConfig;
import com.n2.sprintburst.entity.HoaDon;
import com.n2.sprintburst.entity.SanPhamChiTiet;
import com.n2.sprintburst.response.HoaDonChiTietResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author NhokHip
 */
public class HoaDonChiTietRepository {
//    public ArrayList<HoaDonChiTietResponse> getAll(Integer hoaDonID) {
//    String sql = """
//                 SELECT [giaBan]
//                       ,[id]
//                       ,[idHoaDon]
//                       ,[idSanPhamChiTiet]
//                       ,[soLuong]
//                       ,[trangThai]
//                   FROM [dbo].[HoaDonChiTiet]
//                   WHERE idHoaDon = ?
//                 """;
//    ArrayList<HoaDonChiTietResponse> lists = new ArrayList<>();
//    try (Connection con = (Connection) HibernateConfig.getSessionFactory();
//         PreparedStatement ps = con.prepareStatement(sql)) {
//        ps.setObject(1, hoaDonID);  // Set the hoaDonID in the query
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()) {
//            HoaDon hoaDon = new HoaDon();  // You should load the HoaDon entity from DB or mock it here
//            SanPhamChiTiet sanPhamChiTiet = new SanPhamChiTiet();  // Same for SanPhamChiTiet
//
//            HoaDonChiTietResponse response = HoaDonChiTietResponse.builder()
//                    .giaBan(rs.getInt("giaBan"))
//                    .id(rs.getInt("id"))
//                    .soLuong(rs.getInt("soLuong"))
//                    .trangThai(rs.getBoolean("trangThai"))  // Assuming trangThai is a boolean
//                    .hoaDon(hoaDon)  // You would need to load the HoaDon entity here
//                    .sanPhamChiTiet(sanPhamChiTiet)  // You would need to load the SanPhamChiTiet entity here
//                    .build();
//            lists.add(response);
//        }
//    } catch (Exception e) {
//        e.printStackTrace(System.out);
//    }
//    return lists;
//}


}
