package online.ilec.cmps.service;

import online.ilec.cmps.dao.IlecDAO;
import online.ilec.cmps.entity.references.SchSymbol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class IlecServiceImpl implements IlecService{

    @Autowired
    private IlecDAO ilecDAO;
    @Override
    @Transactional
    public List<SchSymbol> getAllSchSymbols() {
        return ilecDAO.getAllSchSymbols();
    }
    @Override
    @Transactional
    public void saveSchSymbol(SchSymbol schSymbol) {
        ilecDAO.saveSchSymbol(schSymbol);
    }

    @Override
    @Transactional
    public SchSymbol getSchSymbol(int id) {
        return ilecDAO.getSchSymbol(id);
    }

    @Override
    @Transactional
    public void deleteSchSymbol(int id) {
        ilecDAO.deleteSchSymbol(id);
    }
}
