/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.n2.sprintburst.service;

import com.n2.sprintburst.config.HibernateConfig;
import com.n2.sprintburst.entity.HoaDon;
import com.n2.sprintburst.entity.HoaDonChiTiet;
import com.n2.sprintburst.entity.SanPham;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author NhokHip
 */
public class HoaDonChiTietService {
    
    public Session session;
    
    public List<HoaDonChiTiet> getAllHoaDonChiTiets() {
        session = HibernateConfig.getSessionFactory().openSession();
        List<HoaDonChiTiet> list = session.createQuery("from HoaDonChiTiet", HoaDonChiTiet.class).list();
        session.close();//        

        return list;
    }
    
    public List<HoaDonChiTiet> getHoaDonByID(int idHoaDon) {
        session = HibernateConfig.getSessionFactory().openSession();
        HoaDon hd = new HoaDon();
        hd.setId(idHoaDon);
        List<HoaDonChiTiet> list = session.createQuery("from HoaDonChiTiet where hoaDon = :hoaDon ", HoaDonChiTiet.class)
                .setParameter("hoaDon", hd)
                .list();
        session.close();//        

        return list;
    }
    
    public static void add(HoaDonChiTiet hdct) {
        try {
            HibernateConfig.getSessionFactory().inTransaction(s -> {
                HoaDonChiTiet found = s.createSelectionQuery("from HoaDonChiTiet where hoaDon.id = :hdId and sanPhamChiTiet.id = :spctId", HoaDonChiTiet.class)
                        .setParameter("hdId", hdct.getHoaDon().getId())
                        .setParameter("spctId", hdct.getSanPhamChiTiet().getId())
                        .setMaxResults(1).getSingleResultOrNull();
                
                if (found != null) {
                    found.setSoLuong(found.getSoLuong() + 1);
                    s.flush();
                } else {
                    s.persist(hdct);
                    s.flush();
                }
            });
            
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    public static void remove(HoaDonChiTiet hdct) {
        try {
            HibernateConfig.getSessionFactory().inTransaction(s -> {
                s.remove(hdct);
                s.flush();
            });
        } catch (Exception e) {
            throw e;
        }
    }
    
}
