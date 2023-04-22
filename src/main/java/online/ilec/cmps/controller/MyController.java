package online.ilec.cmps.controller;

import online.ilec.cmps.entity.references.SchSymbol;
import online.ilec.cmps.service.IlecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
//@RequestMapping("/sch")
public class MyController {

    @Autowired
    private IlecService ilecService;

    @RequestMapping("/")
    public String showAllSchSymbols(Model model) {
        List<SchSymbol> allSchSymbols = ilecService.getAllSchSymbols();
        model.addAttribute("allSchSymbols", allSchSymbols);
        return "all-sch-symbols";
    }

    @RequestMapping("/addNewSchSymbol")
    public String addSchSymbol(Model model){
        SchSymbol schSymbol = new SchSymbol();
        model.addAttribute("schSymbol", schSymbol);
        return "sch-symbol-info";
    }

    @RequestMapping("/saveSchSymbol")
    public String saveSchSymbol(@ModelAttribute("schSymbol") SchSymbol schSymbol) {
        ilecService.saveSchSymbol(schSymbol);
        return "redirect:/";
    }

    @RequestMapping("/updateSchSymbol")
    public String updateSchSymbol(@RequestParam("schSymbolId") int id, Model model) {
        SchSymbol schSymbol = ilecService.getSchSymbol(id);
        model.addAttribute("schSymbol", schSymbol);
        return "sch-symbol-info";
    }

    @RequestMapping("/deleteSchSymbol")
    public String deleteSchSymbol(@RequestParam("schSymbolId") int id) {
        ilecService.deleteSchSymbol(id);
        return "redirect:/";
    }
}
