package com.n2.sprintburst.response;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class LichSuHoaDonResponse {
    private int id;
    private int idHoaDon;
    private int idNhanVien;
    private Date ngayTacDong;
    private String ghiChu;
   

   

}
