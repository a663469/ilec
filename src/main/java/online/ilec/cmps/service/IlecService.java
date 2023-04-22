package online.ilec.cmps.service;

import online.ilec.cmps.entity.SpecificComponent;
import online.ilec.cmps.entity.references.SchSymbol;

import java.util.List;

public interface IlecService {
//    public List<SpecificComponent> getAllSpecificComponents();
    public List<SchSymbol> getAllSchSymbols();
    public void saveSchSymbol(SchSymbol schSymbol);

    public SchSymbol getSchSymbol(int id);

    public void deleteSchSymbol(int id);
}
