/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.n2.sprintburst.service;

import com.n2.sprintburst.config.HibernateConfig;
import com.n2.sprintburst.entity.SanPham;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;

/**
 *
 * @author Mtt
 */
public class SanPhamService {

    public static List<SanPham> getAllActive() {
        try {
            List<SanPham> list;
            Session s = HibernateConfig.getSessionFactory().openSession();
            var graph = s.createEntityGraph(SanPham.class);
            graph.addSubGraph(SanPhamChiTiet_.publisher);
            
            list = s.createNamedSelectionQuery("from SanPham", SanPham.class).getResultList();
            s.flush();

            return list;
        } catch (Exception e) {
            throw e;
        }
    }

}
