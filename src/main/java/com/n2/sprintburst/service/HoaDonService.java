/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.n2.sprintburst.service;

import com.n2.sprintburst.config.HibernateConfig;
import com.n2.sprintburst.entity.HoaDon;
import com.n2.sprintburst.entity.KhachHang;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Admin
 */
public class HoaDonService {

    public Session session;

    public List<HoaDon> getAllHoaDon() {
        session = HibernateConfig.getSessionFactory().openSession();
        List<HoaDon> list = session.createQuery("from HoaDon", HoaDon.class).list();
        session.close();//        

        return list;
    }

    public List<HoaDon> getHoaDonByKhachHangID(int idKhachHang) {
        session = HibernateConfig.getSessionFactory().openSession();
        KhachHang kh = new KhachHang();
        kh.setId(idKhachHang);
        List<HoaDon> list = session.createQuery("from HoaDon where hoaDon = :hoaDon ", HoaDon.class)
                .setParameter("khachHang",kh )
                .list();
        session.close();//        

        return list;
    }
    
    public HoaDon timKiemHoaDon(String mahd) {
        List<HoaDon> hoaDons = getAllHoaDon();
        for (HoaDon hd : hoaDons) {
            if (hd.getMaHoaDon().equals(mahd)) {
                return hd;
            }
        }
        return null;
    }
     public HoaDon findHdByMa(String ma) {
        HoaDon h = null;
        try {
            session = HibernateConfig.getSessionFactory().openSession();
            String hql = "SELECT \n" +
"      maHoaDon\n" +
"  FROM HoaDon\n" +
"  where maHoaDon = :maHoaDon";
            Query query = session.createQuery(hql);
            query.setParameter("maHoaDon", ma);
            if (query.getSingleResult() != null) {
                h = (HoaDon) query.getSingleResult();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return h;
    }
}
