package online.ilec.cmps.dao;

import online.ilec.cmps.entity.references.SchSymbol;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
}
