/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.n2.sprintburst.utils;

import com.n2.sprintburst.config.HibernateConfig;
import com.n2.sprintburst.entity.MauSac;
import com.n2.sprintburst.entity.SanPham;
import com.n2.sprintburst.entity.SanPhamChiTiet;
import java.time.LocalDateTime;

/**
 *
 * @author Mtt
 */
public class PlaceHolderdata {

    public static void insertData() {

        HibernateConfig.getSessionFactory().inTransaction(s -> {
            SanPham sp1 = new SanPham(0, "tena", "sp001", LocalDateTime.now(), null, null, true, null);
            SanPham sp2 = new SanPham(0, "tenb", "sp002", LocalDateTime.now(), null, null, true, null);
            SanPham sp3 = new SanPham(0, "tenb", "sp003", LocalDateTime.now(), null, null, true, null);
            s.persist(sp1);
            s.persist(sp2);
            s.persist(sp3);
            s.flush();
        });
    }

    public static void main(String[] args) {
        System.err.println(new SanPhamChiTiet(1, "aaa", "bbb", "ccc", LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), true, 1, 2, null, null, null, null, null, null, new MauSac(0, "ff"), null).toString());
    }
}
