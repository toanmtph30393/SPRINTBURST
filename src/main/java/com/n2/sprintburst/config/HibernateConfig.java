package com.n2.sprintburst.config;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.schema.Action;

public class HibernateConfig {
    private static final SessionFactory sessionFactory;
    private static final String user = "sa";
    private static final String password = "changeme";


    static {
        sessionFactory = new Configuration()
                //annotated classes
                //MSSQL
                .setProperty(AvailableSettings.JAKARTA_JDBC_URL, "jdbc:sqlserver://localhost:1433;databaseName=SPRINT_BURSt;encrypt=true;trustServerCertificate=true;")
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
        System.out.println(getSessionFactory());
    }

}
