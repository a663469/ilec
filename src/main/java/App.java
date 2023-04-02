import ilecDB.SessionSchSymbol;
import ilecDB.entity.SpecificComponent;
import spobreo.ComponentFormSPO;
import spobreo.SessionForGetDataFromSPO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        List<ComponentFormSPO> cmpspo = SessionForGetDataFromSPO.getList();

        Set<String> schSymbols = new HashSet<>();

        for(ComponentFormSPO cmp : cmpspo) {
            schSymbols.add(cmp.getLibraryRef());
        }

        SessionSchSymbol.addSchSymbol(schSymbols);
    }
}
