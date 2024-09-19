/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.n2.sprintburst.utils;

import com.n2.sprintburst.config.HibernateConfig;
import com.n2.sprintburst.entity.SanPham;
import java.time.LocalDateTime;

/**
 *
 * @author Mtt
 */
public class PlaceHolderdata {

    public static void insertData() {

        HibernateConfig.getSessionFactory().inTransaction(s -> {
            SanPham sp1 = new SanPham(0, "tena", "sp001", LocalDateTime.now(), null, null, true);
            SanPham sp2 = new SanPham(0, "tenb", "sp002", LocalDateTime.now(), null, null, true);
            SanPham sp3 = new SanPham(0, "tenb", "sp003", LocalDateTime.now(), null, null, true);
            s.persist(sp1);
            s.persist(sp2);
            s.persist(sp3);
            s.flush();
        });
    }
}
