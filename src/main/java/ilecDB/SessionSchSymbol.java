package ilecDB;

import ilecDB.entity.Component;
import ilecDB.entity.SpecificComponent;
import ilecDB.entity.references.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class SessionSchSymbol {
    public static void addSchSymbol(String SymbolName) {
        System.out.println("addSchSymbol");
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

//            //Checking for uniqueness
            List<SchSymbol> schSymbols = session.createQuery("from SchSymbol where name = '" + SymbolName + "'").getResultList();
            if(schSymbols.size() == 0) {
                SchSymbol sch = new SchSymbol(SymbolName);
                session.save(sch);
            } else {
                schSymbols.forEach(System.out::println);
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("SessionAddSchSymbol error: " + e);
        } finally {
            session.close();
            factory.close();
            System.out.println("Done!");
        }
    }
}
