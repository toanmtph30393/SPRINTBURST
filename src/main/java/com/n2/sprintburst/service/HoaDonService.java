/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.n2.sprintburst.service;

import com.n2.sprintburst.config.HibernateConfig;
import com.n2.sprintburst.entity.HoaDon;
import java.util.List;
import org.hibernate.Session;

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
}
