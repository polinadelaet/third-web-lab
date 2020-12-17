package dao.daoImpl;

import dao.Dao;
import hibernateEntity.PointEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.SessionFactorySingleton;


public class PointDao implements Dao<PointEntity> {

    private Session session;
    private SessionFactory sessionFactory;
    private Transaction transaction;

    @Override
    public void save(PointEntity pointEntity) {
        try {
            sessionFactory = SessionFactorySingleton.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(pointEntity);
            session.getTransaction().commit();
        } catch (RuntimeException runtimeException) {
            transaction.rollback();
        } finally {
            if (session != null) {
                session.close();
                sessionFactory.close();
            }
        }
    }
}
