package domain;

import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class DepartmentRepositoryImpl implements DepartmentRepository {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    public Department findById(Long id) {
        return session.find(Department.class, id);
    }

    public void save(Department department) {
        Transaction transaction = session.beginTransaction();
        session.persist(department);
        transaction.commit();

    }
    public void closeSession() {
        session.close();
    }
}
