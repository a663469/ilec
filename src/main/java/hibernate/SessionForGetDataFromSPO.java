package hibernate;

import hibernate.entity.ComponentFormSPO;
import hibernate.entity.component.SpecificComponent;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


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

//            ComponentFormSPO cmp = new ComponentFormSPO("first", "second", "cat");
//            session.save(cmp);

            // Считывание данных со базы spobreo
//            List<ComponentFormSPO> cfspoList = session.createQuery("from ComponentFormSPO").getResultList();
//            for (ComponentFormSPO c : cfspoList)
//                System.out.println(c);



//            ComponentFormSPO cmp = session.get(ComponentFormSPO.class, 2);
//            System.out.println(cmp);

//            ComponentRef componentRef = new ComponentRef("Resistors");
//            componentRef.addGroupToComponent(new GroupRef("Chip"));
//            componentRef.addGroupToComponent(new GroupRef("Yageo"));

//            session.save(componentRef);

//            CurrentElement currentElement = new CurrentElement("RC0603FR-071KL");
//            System.out.println(currentElement);
//            session.save(currentElement);

//            List<CurrentElement> currentElementList = session.createQuery("from CurrentElement").getResultList();
//            for (CurrentElement ce : currentElementList)
//                System.out.println(ce);
            SpecificComponent ce = session.get(SpecificComponent.class, 1);
            System.out.println(ce);

            session.getTransaction();
        } finally {
			session.close();
            factory.close();
			System.out.println("Done!");
        }
    }
}
