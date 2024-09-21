<<<<<<< Updated upstream
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.n2.sprintburst.response;

/**
 *
 * @author NhokHip
 */
public class HoaDonChiTietResponse {
    
}
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.n2.sprintburst.response;

import com.n2.sprintburst.entity.HoaDon;
import com.n2.sprintburst.entity.SanPhamChiTiet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author NhokHip
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter 
@Setter 
@ToString
@Builder
public class HoaDonChiTietResponse {
    private int id;
    private int soLuong;
    private int giaBan;
    private boolean trangThai;
    private HoaDon hoaDon;
    private SanPhamChiTiet sanPhamChiTiet;
}
>>>>>>> Stashed changes
