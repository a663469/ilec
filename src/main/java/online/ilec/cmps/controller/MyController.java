package online.ilec.cmps.controller;

import online.ilec.cmps.entity.references.SchSymbol;
import online.ilec.cmps.service.IlecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private IlecService ilecService;

    @RequestMapping("/")
    public String showAllSchSymbols(Model model) {
        List<SchSymbol> allSchSymbols = ilecService.getAllSchSymbols();
        model.addAttribute("allSchSymbols", allSchSymbols);

        return "all-sch-symbols";
    }
}
