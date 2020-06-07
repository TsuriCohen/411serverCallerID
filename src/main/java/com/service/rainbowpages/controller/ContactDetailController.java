package com.service.rainbowpages.controller;

import com.service.rainbowpages.modal.ContactDetail;
import com.service.rainbowpages.service.ContactDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Controller
public class ContactDetailController {

    private final ContactDetailService contactDetailService;

    public ContactDetailController(ContactDetailService contactDetailService) {
        this.contactDetailService = contactDetailService;
    }

    @RequestMapping(value = "/searchBy",method = RequestMethod.GET)
    public String getNameByContactNumber(@RequestParam(value = "q", required = false) String name, Model model){
        ContactDetail result = contactDetailService.getNameByContactNumber(name);
        model.addAttribute("details",result);
        return "search-contact";
    }

    @RequestMapping(value = "/searchNumber",method = RequestMethod.GET)
    public String searchNumberPage() {
        return "search-contact";
    }

    @PostMapping(path = "/save")
    public String saveTransaction(ContactDetail contactDetail) {
        contactDetailService.saveContactDetails(contactDetail);
        return "redirect:/";
    }

    @RequestMapping(path = "/delete/{id}")
    public String deleteContactDetailById(Model model, @PathVariable("id") Long id){
        contactDetailService.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping(path = {"/edit", "/edit/{id}"})
    public String editEmployeeById(Model model, @PathVariable("id") Optional<Long> id){
        if (id.isPresent()) {
            ContactDetail contactDetail = contactDetailService.getContactDetailById(id.get());
            model.addAttribute("contact", contactDetail);
        } else {
            model.addAttribute("contact", new ContactDetail());
        }
        return "add-edit-contacts";
    }

    @RequestMapping("/")
    public String getAllTransaction(Model model) {
        List<ContactDetail> contactDetailList = contactDetailService.getAllContacts(); 
        model.addAttribute("contacts",contactDetailList);
        return "list-contact-details";
    }
}
