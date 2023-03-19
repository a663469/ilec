package ilecDB;


import ilecDB.entity.Component;
import ilecDB.entity.SpecificComponent;
import ilecDB.entity.references.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionIlec {
    public static void main(String[] args) throws HibernateException {
        SessionFactory factory = new Configuration()
                .configure("hibernate_ilec.cfg.xml")
                .addAnnotatedClass(Component.class)
                .addAnnotatedClass(SpecificComponent.class)
                .addAnnotatedClass(SchSymbol.class)
                .addAnnotatedClass(FootprintRef.class)
                .addAnnotatedClass(ManufacturerRef.class)
                .addAnnotatedClass(PartStatusRef.class)
                .addAnnotatedClass(TempRangeRef.class)
                .addAnnotatedClass(ComponentRef.class)
                .addAnnotatedClass(GroupRef.class)
                .addAnnotatedClass(CategoryRef.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            // Запись данных в БД
            {
                SchSymbol sch = new SchSymbol("vt");
                session.save(sch);

//                FootprintRef fr = new FootprintRef("R2_0402");
//                session.save(fr);
//
//                ManufacturerRef mfr = new ManufacturerRef("Yageo", "Chine");
//                session.save(mfr);
//
//                PartStatusRef psr = new PartStatusRef("Active");
//                session.save(psr);
//
//                TempRangeRef trr = new TempRangeRef(-40, 80);
//                session.save(trr);
//
//                ComponentRef cmpr = new ComponentRef("Resistors");
//                session.save(cmpr);
//
//                GroupRef gr = new GroupRef("Chip");
//                cmpr.addGroup(gr);
//                session.save(gr);
//
//                CategoryRef cr = new CategoryRef("0402");
//                gr.addCategoryRef(cr);
//                session.save(cr);
//
//                SpecificComponent sc1 = new SpecificComponent("RC0402FR-075K1L", "datasheets");
//                mfr.addSpecificComponent(sc1);
//                psr.addSpecificComponent(sc1);
//                trr.addSpecificComponent(sc1);
//
//                SpecificComponent sc2 = new SpecificComponent("RC0402JR-075K1L", "datasheets");
//                mfr.addSpecificComponent(sc2);
//                psr.addSpecificComponent(sc2);
//                trr.addSpecificComponent(sc2);
//
//                Component cmp = new Component("CR-0402-5K1-J");
//                cmp.addSpecificComponent(sc1);
//                cmp.addSpecificComponent(sc2);
//
//                sch.addComponent(cmp);
//                fr.addComponent(cmp);
//                cmp.setComponentRef(cmpr);
//                gr.addComponent(cmp);
//                cr.addComponent(cmp);
//
//                session.save(cmp);
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
