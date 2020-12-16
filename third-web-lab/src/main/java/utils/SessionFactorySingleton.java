package utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactorySingleton {
    private static SessionFactory sessionFactory;


    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null) {
            try {
                StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
                Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
                return metadata.getSessionFactoryBuilder().build();
            } catch(Throwable th){
                System.err.println("Enitial SessionFactory creation failed"+th);
            }
        }
        return sessionFactory;
    }
}