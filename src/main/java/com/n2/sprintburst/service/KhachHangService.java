/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.n2.sprintburst.service;

import com.n2.sprintburst.config.HibernateConfig;
import com.n2.sprintburst.entity.KhachHang;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class KhachHangService {

    public Session session;
    

    public List<KhachHang> getAllKhachHang() {
//        session = HibernateConfig.getSessionFactory().openSession();
//        List<KhachHang> list = session.createQuery("from KhachHang", KhachHang.class).list();
//        session.close();//        
        List<KhachHang> list = session.createQuery("from KhachHang", KhachHang.class).list();

        return list;
    }

    public KhachHang getKhachHangById(int id) {
        session = HibernateConfig.getSessionFactory().openSession();
        KhachHang nhanVien = session.get(KhachHang.class, id);
        session.close();
        return nhanVien;
    }

    public void saveKhachHang(KhachHang KhachHang) {
        session = HibernateConfig.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(KhachHang); // Sử dụng persist cho đối tượng mới
        session.getTransaction().commit();
        session.close();
    }

    public void updateKhachHang(KhachHang KhachHang) {
        session = HibernateConfig.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(KhachHang); // Sử dụng merge để cập nhật đối tượng đã tồn tại
        session.getTransaction().commit();
        session.close();
    }

    public void deleteKhachHang(int id) {
        session = HibernateConfig.getSessionFactory().openSession();
        session.beginTransaction();
        KhachHang nhanVien = getKhachHangById(id);
        if (nhanVien != null) {
            session.remove(nhanVien);
        }
        session.getTransaction().commit();
        session.close();
    }

     public boolean isEmpty(JTextField txt, String mss) {
        if (txt.getText().equals("")) {
            txt.getCursor();
            txt.requestFocus();
            txt.setBackground(Color.lightGray);
            JOptionPane.showMessageDialog(null, mss);
            return true;
        }else{
            return false;
        }
    }
}
