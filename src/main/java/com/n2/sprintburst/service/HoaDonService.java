/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.n2.sprintburst.service;
import com.n2.sprintburst.entity.HoaDon;
import com.n2.sprintburst.response.HoaDonChiTietResponse;
import com.n2.sprintburst.response.HoaDonResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author NhokHip
 */
public class HoaDonService {
    public List<HoaDonResponse> getAllHD() {
        List<HoaDonResponse> hoaDons = new ArrayList<>();
    String sql = "SELECT id,idKhachHang,idNhanVien,idPhieuGiamGia,idTrangThaiHoaDon,tongSauGiamGia,tongTruocGiamGia,ngayTao,diaChiNguoiNhan,dienThoaiNguoiNhan,ghiChu,maHoaDon,tenNguoiNhan FROM HoaDon";
    try (Connection con = DBContext.getConnection();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery();
            ){
                while(rs.next()){
                    HoaDonResponse hd = new HoaDonResponse(
                            rs.getInt(1),
                            rs.getInt(2),
                            rs.getInt(3),
                            rs.getInt(4),
                            rs.getInt(5),
                            rs.getInt(6),
                            rs.getInt(7),
                            rs.getDate(8),
                            rs.getString(9),
                            rs.getString(10),
                            rs.getString(11),
                            rs.getString(12),
                            rs.getString(13)
                            
                    );
                    hoaDons.add(hd);
            }
            
        } catch (Exception e) {
        }
        return hoaDons;
    }
//    public List<HoaDon> searchHoaDon(String keyword) throws Exception {
//    List<HoaDon> result = new ArrayList<>();
//    String sql = "SELECT * FROM HoaDon WHERE ID LIKE ?";
//    
//    try (Connection con = DBContext.getConnection();
//         PreparedStatement ps = con.prepareStatement(sql);
//         ResultSet rs = ps.executeQuery();
//            ){
//        
//        while (rs.next()) {
//            HoaDonResponse hoaDon = new HoaDonResponse();
//            hoaDon.setId(rs.getInt("ID"));
//            hoaDon.setMaHoaDon(rs.getString("MaHoaDon"));
//            result.add(hoaDon);
//        }
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//    
//    return result;
//}
}
