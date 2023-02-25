package hibernate;

import entity.ComponentFormSPO;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class SessionForGetDataFromSPO {
    public static void main(String[] args) throws HibernateException {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(ComponentFormSPO.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
//            List<ComponentFormSPO> cfspos = session.createQuery("from *").getResultList();
//            for (ComponentFormSPO c : cfspos)
//                System.out.println(c);

            session.getTransaction();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
        System.out.println("!!!end!!!");
    }
}