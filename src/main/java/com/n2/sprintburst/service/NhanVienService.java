/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.n2.sprintburst.service;

import com.n2.sprintburst.config.HibernateConfig;
import com.n2.sprintburst.entity.NhanVien;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class NhanVienService {
    public Session session;

    public List<NhanVien> getAllNhanVien() {
        session = HibernateConfig.getSessionFactory().openSession();
        List<NhanVien> list = session.createQuery("from NhanVien", NhanVien.class).list();
        session.close();
        return list;
    }

    public NhanVien getNhanVienById(int id) {
        session = HibernateConfig.getSessionFactory().openSession();
        NhanVien nhanVien = session.get(NhanVien.class, id);
        session.close();
        return nhanVien;
    }

    public void saveNhanVien(NhanVien nhanVien) {
        session = HibernateConfig.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(nhanVien); // Sử dụng persist cho đối tượng mới
        session.getTransaction().commit();
        session.close();
    }

    public void updateNhanVien(NhanVien nhanVien) {
        session = HibernateConfig.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(nhanVien); // Sử dụng merge để cập nhật đối tượng đã tồn tại
        session.getTransaction().commit();
        session.close();
    }

    public void deleteNhanVien(int id) {
        session = HibernateConfig.getSessionFactory().openSession();
        session.beginTransaction();
        NhanVien nhanVien = getNhanVienById(id);
        if (nhanVien != null) {
            session.remove(nhanVien);
        }
        session.getTransaction().commit();
        session.close();
    }
}
