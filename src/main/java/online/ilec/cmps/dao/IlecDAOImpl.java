package online.ilec.cmps.dao;

import online.ilec.cmps.entity.references.SchSymbol;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IlecDAOImpl implements IlecDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<SchSymbol> getAllSchSymbols() {
        Session session = sessionFactory.getCurrentSession();
        List<SchSymbol> allSchSymbols = session.createQuery("from SchSymbol").getResultList();
        return allSchSymbols;
    }

    @Override
    public void saveSchSymbol(SchSymbol schSymbol) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(schSymbol);
    }

    @Override
    public SchSymbol getSchSymbol(int id) {
        Session session = sessionFactory.getCurrentSession();
        SchSymbol schSymbol = session.get(SchSymbol.class, id);
        return schSymbol;
    }

    @Override
    public void deleteSchSymbol(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<SchSymbol> query = session.createQuery("delete from SchSymbol where id =:schSymbolId");
        query.setParameter("schSymbolId", id);
        query.executeUpdate();
    }


}
