package hibernate;


import hibernate.entity.component.Component;
import hibernate.entity.component.SpecificComponent;
import hibernate.entity.component.references.FootprintRef;
import hibernate.entity.component.references.SchSymbolRef;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class SessionIlec {
    public static void main(String[] args) throws HibernateException {
        SessionFactory factory = new Configuration()
                .configure("hibernate_ilec.cfg.xml")
                .addAnnotatedClass(Component.class)
                .addAnnotatedClass(SpecificComponent.class)
                .addAnnotatedClass(SchSymbolRef.class)
                .addAnnotatedClass(FootprintRef.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            // Запись данных в БД
            {
                SchSymbolRef sch = new SchSymbolRef("res");
                session.save(sch);

                FootprintRef fr = new FootprintRef("R2_0402");
                session.save(fr);

                Component cmp = new Component("CR-0402-5K1-J");
                SpecificComponent sc1 = new SpecificComponent("RC0402FR-075K1L");
                SpecificComponent sc2 = new SpecificComponent("RC0402JR-075K1L");
                cmp.addSpecificComponentToComponent(sc1);
                cmp.addSpecificComponentToComponent(sc2);
                sch.addComponentToSchSymbolRef(cmp);
                fr.addComponentToFootprintRef(cmp);
                session.save(cmp);

                System.out.println(sch.getComponents());

                for (SpecificComponent sc : cmp.getSpecificComponentList())
                    System.out.println(sc);
            }

            // Чтение одного объекта с БД
//            {
//                SpecificComponent sc = session.get(SpecificComponent.class, 1);
//                System.out.println(sc);
//            }

            // Чтеник нескольких объектов
//            {
//                List<SpecificComponent> scs = session.createQuery("from SpecificComponent").getResultList();
//                for (SpecificComponent sc : scs)
//                    System.out.println(sc);
//            }

            // Удаление данных с БД
//            {
//                Component cmp = session.get(Component.class, 10);
//                session.delete(cmp);
//            }
//            {
//                SpecificComponent sc = session.get(SpecificComponent.class, 9);
//                session.delete(sc);
//            }
//            {
//                SchSymbolRef sch = session.get(SchSymbolRef.class, 2);
//                session.delete(sch);
//            }

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
            System.out.println("Done!");
        }
    }
}
