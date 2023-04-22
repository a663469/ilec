package online.ilec.cmps.dao;

import online.ilec.cmps.entity.references.SchSymbol;

import java.util.List;

public interface IlecDAO {
    public List<SchSymbol> getAllSchSymbols();
    public void saveSchSymbol(SchSymbol schSymbol);
    public SchSymbol getSchSymbol(int id);
    public void deleteSchSymbol(int id);
}
