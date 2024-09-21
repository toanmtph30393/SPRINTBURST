/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.n2.sprintburst.service;

import com.n2.sprintburst.config.HibernateConfig;
import com.n2.sprintburst.entity.SanPham;
import com.n2.sprintburst.entity.SanPhamChiTiet;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Mtt
 */
public class SanPhamChiTietService {

    public static List<SanPhamChiTiet> getAllActive() {
        try {
            Session s = HibernateConfig.getSessionFactory().openSession();
            return s.createQuery("from SanPhamChiTiet where trangThai = :status", SanPhamChiTiet.class)
                    .setParameter("status", true)
                    .getResultList();
        } catch (Exception e) {
            throw e;
        }
    }

    public static void addOrUpdate(SanPhamChiTiet spct) {
        try {
            HibernateConfig.getSessionFactory().inTransaction(s -> {
                SanPhamChiTiet found = s.createSelectionQuery("from SanPhamChiTiet order by id desc", SanPhamChiTiet.class).setMaxResults(1).getSingleResultOrNull();

                int newId;
                if (found == null) {
                    newId = 1;
                } else {
                    newId = found.getId() + 1;
                }

                spct.setMaSanPhamChiTiet("SPCT" + newId);
                s.merge(spct);
                s.flush();
            });

        } catch (Exception e) {
            throw e;
        }
    }

    public static void main(String[] args) {
        SanPhamChiTiet spct = new SanPhamChiTiet();
        SanPham sp = new SanPham();

        spct.setSanPham(sp);
        sp.setId(1);

        addOrUpdate(spct);
    }
}
