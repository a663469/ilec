package spobreo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;


public class SessionForGetDataFromSPO {
    public static void main(String[] args) throws HibernateException {
        for (ComponentFormSPO c : getList())
                System.out.println(c);
    }

    public static List<ComponentFormSPO> getList() {
        List<ComponentFormSPO> cfspoList = new ArrayList<>();

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(ComponentFormSPO.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            // Считывание данных со базы spobreo
            cfspoList = session.createQuery("from ComponentFormSPO").getResultList();

            session.getTransaction();
        } finally {
            session.close();
            factory.close();
        }
        return cfspoList;
    }
}
