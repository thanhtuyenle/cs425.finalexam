package edu.mum.cs.cs425.finalexam.controller;


import edu.mum.cs.cs425.finalexam.model.Citizen;
import edu.mum.cs.cs425.finalexam.model.State;
import edu.mum.cs.cs425.finalexam.service.ICitizenService;
import edu.mum.cs.cs425.finalexam.service.IStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
//@RequestMapping(value = "/citizening/secure/Citizens")
public class CitizenController {

    @Autowired
    private ICitizenService citizenService;

    @Autowired
    private IStateService stateService;

    @GetMapping(value = {"/finalexam/citizen/list"})
    public ModelAndView listCitizens() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("citizens", citizenService.getAllCitizens());
        mav.addObject("totalincome", citizenService.computeTotalNationalYearlyIncome());
        mav.addObject("now", LocalDate.now());
        mav.setViewName("citizen/list");
        return mav;
    }

    @GetMapping(value = "/finalexam/citizen/new")
    public String newCitizenForm(Model model) {
//        loadDataToModel(model);
        List<State> states = stateService.getAllStates();
        model.addAttribute("citizen", new Citizen());
        model.addAttribute("states", states);
//        model.addAttribute("CitizenTypes", CitizenTypes);
        model.addAttribute("now", LocalDate.now());
        return "citizen/new";
    }

    @PostMapping(value = "/finalexam/citizen/new")
    public String addNewCitizen(@Valid @ModelAttribute("citizen") Citizen Citizen,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            List<State> states = stateService.getAllStates();
//            List<CitizenType> CitizenTypes = CitizenTypeService.getAllCitizenTypes();
            model.addAttribute("states", states);
//            model.addAttribute("CitizenTypes", CitizenTypes);
            model.addAttribute("now", LocalDate.now());
//            loadDataToModel(model);
            return "citizen/new";
        }
        citizenService.addNewCitizen(Citizen);
        return "redirect:/finalexam/citizen/list";
    }

    private void loadDataToModel(Model model) {
//        List<State> States = StateService.getAllStates();
//        List<CitizenType> CitizenTypes = CitizenTypeService.getAllCitizenTypes();
//        model.addAttribute("Citizen", new Citizen());
//        model.addAttribute("States", States);
//        model.addAttribute("CitizenTypes", CitizenTypes);
//        model.addAttribute("now", LocalDate.now());
    }
}
