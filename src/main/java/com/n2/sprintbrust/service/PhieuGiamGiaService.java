/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.n2.sprintbrust.service;

import com.n2.sprintburst.config.HibernateConfig;
import com.n2.sprintburst.entity.PhieuGiamGia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nhai1
 */
public class PhieuGiamGiaService {
    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;
    public List<PhieuGiamGia>getAll(){
        sql = "select * from PhieuGiamGia";
        List<PhieuGiamGia> listGG = new ArrayList<>();
        try {
            //con = HibernateConfig.getSessionFactory();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
//            while(rs.next()){
//               PhieuGiamGia PGG = new PhieuGiamGia
//                       (rs.getString(1),
//                        rs.getString(2), 
//                        rs.getInt(3), 
//                        rs.getString(4),
//                        rs.getString(5));  
//                listGG.add(PGG);
//            }
            return listGG; 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
