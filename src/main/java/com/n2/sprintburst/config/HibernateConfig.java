<<<<<<< HEAD
<<<<<<< Updated upstream
package com.n2.sprintburst.config;


import com.n2.sprintburst.entity.*;
=======
package com.n2.sprintburst.config;

import com.n2.sprintburst.entity.*;
import jakarta.persistence.EntityManagerFactory;
>>>>>>> ab1b8049a7509197e5a33dde5075f82531b6e7e5
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.schema.Action;

public class HibernateConfig {
<<<<<<< HEAD
=======

>>>>>>> ab1b8049a7509197e5a33dde5075f82531b6e7e5
    private static final SessionFactory sessionFactory;
    private static final String user = "sa";
    private static final String password = "changeme";

<<<<<<< HEAD

=======
>>>>>>> ab1b8049a7509197e5a33dde5075f82531b6e7e5
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
<<<<<<< HEAD

=======
>>>>>>> ab1b8049a7509197e5a33dde5075f82531b6e7e5
                //MSSQL
                .setProperty(AvailableSettings.JAKARTA_JDBC_URL, "jdbc:sqlserver://localhost:1433;databaseName=SPRINT_BURST;encrypt=true;trustServerCertificate=true;")
                // Credentials
                .setProperty(AvailableSettings.JAKARTA_JDBC_USER, user)
                .setProperty(AvailableSettings.JAKARTA_JDBC_PASSWORD, password)
                // Automatic schema export
<<<<<<< HEAD
                .setProperty(AvailableSettings.JAKARTA_HBM2DDL_DATABASE_ACTION,
                        Action.SPEC_ACTION_DROP_AND_CREATE)
=======
                //                .setProperty(AvailableSettings.JAKARTA_HBM2DDL_DATABASE_ACTION,
                //                        Action.SPEC_ACTION_DROP_AND_CREATE)
>>>>>>> ab1b8049a7509197e5a33dde5075f82531b6e7e5
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

<<<<<<< HEAD
    public static void main(String[] args) {
        getSessionFactory().inTransaction(s -> {
            NhanVien nv = new NhanVien();
            nv.setHoTen("aaaaaaaaaaaaaaaa");
            nv.setDienThoai("000000000");
            s.persist(nv);

            KhachHang kh = new KhachHang();
            kh.setTenKhachHang("aaaaaaaaaaaaaaaa");
            kh.setDienThoai("000000000");
            kh.setNhanVien(nv);

            s.persist(kh);

            s.flush();


        });
=======
    public static EntityManagerFactory entityManagerFactory() {
        return sessionFactory.unwrap(EntityManagerFactory.class);
    }

    public static void main(String[] args) {

>>>>>>> ab1b8049a7509197e5a33dde5075f82531b6e7e5
        System.out.println(getSessionFactory());
    }

}
<<<<<<< HEAD
=======
package com.n2.sprintburst.config;


import com.n2.sprintburst.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.schema.Action;

public class HibernateConfig {
    private static final SessionFactory sessionFactory;
    private static final String user = "sa";
    private static final String password = "123456";


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
                .setProperty(AvailableSettings.JAKARTA_HBM2DDL_DATABASE_ACTION,
                        Action.SPEC_ACTION_DROP_AND_CREATE)
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
        getSessionFactory().inTransaction(s -> {
            NhanVien nv = new NhanVien();
            nv.setHoTen("aaaaaaaaaaaaaaaa");
            nv.setDienThoai("000000000");
            s.persist(nv);

            KhachHang kh = new KhachHang();
            kh.setTenKhachHang("aaaaaaaaaaaaaaaa");
            kh.setDienThoai("000000000");
            kh.setNhanVien(nv);

            s.persist(kh);

            s.flush();


        });
        System.out.println(getSessionFactory());
    }

}
>>>>>>> Stashed changes
=======
>>>>>>> ab1b8049a7509197e5a33dde5075f82531b6e7e5
