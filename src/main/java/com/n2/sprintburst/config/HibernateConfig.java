package com.n2.sprintburst.config;


import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.n2.sprintburst.entity.*;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.schema.Action;

import java.lang.reflect.InvocationTargetException;

public class HibernateConfig {
    private static final SessionFactory sessionFactory;
    private static final String user = "sa";
    private static final String password = "changeme";


    static {
        sessionFactory = new Configuration()
                //annotated classes
                .addAnnotatedClass(NhanVien.class)
                .addAnnotatedClass(KhachHang.class)
                .addAnnotatedClass(SanPham.class)
                .addAnnotatedClass(ThuongHieu.class)
                .addAnnotatedClass(XuatXu.class)
                .addAnnotatedClass(ChatLieu.class)
                .addAnnotatedClass(DeGiay.class)
                .addAnnotatedClass(CoGiay.class)
                .addAnnotatedClass(MauSac.class)
                .addAnnotatedClass(Size.class)
                .addAnnotatedClass(SanPhamChiTiet.class)
                .addAnnotatedClass(PhieuGiamGia.class)
                .addAnnotatedClass(TrangThaiHoaDon.class)
                .addAnnotatedClass(HoaDon.class)
                .addAnnotatedClass(HoaDonChiTiet.class)
                .addAnnotatedClass(ThanhToan.class)
                .addAnnotatedClass(LichSuHoaDon.class)

                //MSSQL
                .setProperty(AvailableSettings.JAKARTA_JDBC_URL, "jdbc:sqlserver://localhost:1433;databaseName=SPRINT_BURST;encrypt=true;trustServerCertificate=true;")
                // Credentials
                .setProperty(AvailableSettings.JAKARTA_JDBC_USER, user)
                .setProperty(AvailableSettings.JAKARTA_JDBC_PASSWORD, password)
                // Automatic schema export
//                .setProperty(AvailableSettings.JAKARTA_HBM2DDL_DATABASE_ACTION,Action.SPEC_ACTION_DROP_AND_CREATE)
                // SQL statement logging
                .setProperty(AvailableSettings.SHOW_SQL, true)
                .setProperty(AvailableSettings.FORMAT_SQL, true)
                .setProperty(AvailableSettings.HIGHLIGHT_SQL, true)
                // Create a new SessionFactory
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void main(String[] args) {
        System.out.println(getSessionFactory());

        NhanVien nv = new NhanVien();
        nv.setMaTaiKhoan("nv1");
        nv.setHoTen("aaaa");

        insertNv(nv); //thêm nv1

        nv.setHoTen(("bbbb"));
        updateNvById(nv); // đổi tên của nv1 thành bbbb


        NhanVien nvUpdate = new NhanVien();
        nvUpdate.setMaTaiKhoan("nv1"); //muốn update nv có mã này
        nvUpdate.setEmail("zzzzzzzzz"); //update email
        updateNvByMa(nvUpdate); //tìm nv theo mã và update


    }

    //tạo nv mới
    public static void insertNv(NhanVien nv) {
        try {
            getSessionFactory().inTransaction(session -> {
                session.persist(nv);
                session.flush();
                session.close();
            });
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    //update nv qua id
    public static void updateNvById(NhanVien nv) {
        try {
            getSessionFactory().inTransaction(session -> {
                session.merge(nv);
                session.flush();
                session.close();
            });
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    //update nv qua ma
    public static void updateNvByMa(NhanVien nv) {
        try {
            getSessionFactory().inTransaction(session -> {
                NhanVien found = session.createSelectionQuery("from NhanVien where maTaiKhoan = :maTaiKhoan", NhanVien.class)
                        .setParameter("maTaiKhoan", nv.getMaTaiKhoan())
                        .getSingleResult(); //tìm nv có trong db với mã này

                found.setEmail(nv.getEmail()); //chuyển các thuộc tính có thể đc update từ nv sang found
                //ten....
                //dia chi....
                //dien thoai....

                //lưu found vào db
                session.merge(found);
                //thực hiện các câu lệnh db
                session.flush();
            });
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


}
