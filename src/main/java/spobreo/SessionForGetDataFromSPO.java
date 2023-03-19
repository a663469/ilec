package spobreo;

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
		Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            // Считывание данных со базы spobreo
            List<ComponentFormSPO> cfspoList = session.createQuery("from ComponentFormSPO").getResultList();
            for (ComponentFormSPO c : cfspoList)
                System.out.println(c);

//            ComponentFormSPO cmp = session.get(ComponentFormSPO.class, 2);
//            System.out.println(cmp);

            session.getTransaction();
        } finally {
			session.close();
            factory.close();
			System.out.println("Done!");
        }
    }
}
