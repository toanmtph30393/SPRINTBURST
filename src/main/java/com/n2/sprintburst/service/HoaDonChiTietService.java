/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.n2.sprintburst.service;
import com.n2.sprintburst.entity.HoaDonChiTiet;
import com.n2.sprintburst.response.HoaDonChiTietResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author NhokHip
 */
public class HoaDonChiTietService {
    public List<HoaDonChiTietResponse> getAll() {
    List<HoaDonChiTietResponse> hoaDonChiTiets = new ArrayList<>();
    String sql ="SELECT id,soLuong,giaBan,idHoaDon,idSanPhamChiTiet,trangThai FROM HoaDonChiTiet";
    try (   Connection con = DBContext.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
            ){
                while(rs.next()){
                    HoaDonChiTietResponse hdct = new HoaDonChiTietResponse(
                            rs.getInt(1),
                            rs.getInt(2),
                            rs.getInt(3),
                            rs.getBoolean(4),
                            rs.getInt(5),
                            rs.getInt(6)
                    );
                    hoaDonChiTiets.add(hdct);
            }
            
        } catch (Exception e) {
        }
        return hoaDonChiTiets;
    }
}
