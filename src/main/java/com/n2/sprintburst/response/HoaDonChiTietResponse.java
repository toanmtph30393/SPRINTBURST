package com.n2.sprintburst.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class HoaDonChiTietResponse {

    private int id;
    private int soLuong;
    private int giaBan;
    private boolean trangThai;
    private int idhoaDon;
    private int idsanPhamChiTiet;

    
}
