import domain.Department;
import domain.DepartmentRepository;
import domain.DepartmentRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import util.HibernateUtil;

import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Department department = session.find(Department.class, 1);

        System.out.println("Found a department - " + department.getName());


        //add object
       /* Transaction transaction = session.beginTransaction();
        Department newDepatment = new Department();
        newDepatment.setName("New DEP");
        session.persist(newDepatment);
        transaction.commit();
        session.close();*/

        DepartmentRepository repo = new DepartmentRepositoryImpl();
        Department dep = new Department();
        dep.setName("BEST DEP EVA");
        repo.save(dep);
        repo.closeSession();
    }
}
