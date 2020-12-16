package utils;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateUtils {

    private Session currentSession;
    private Transaction currentTransaction;

    public Session openCurrentSession() {
        SessionFactorySingleton sessionFactorySingleton = new SessionFactorySingleton();
        currentSession = sessionFactorySingleton.getSessionFactory().openSession();
        return currentSession;
    }
}