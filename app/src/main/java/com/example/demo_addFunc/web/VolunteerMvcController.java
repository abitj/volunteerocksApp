package com.example.demo_addFunc.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo_addFunc.exception.RecordNotFoundException;
import com.example.demo_addFunc.model.VolunteerEntity;
import com.example.demo_addFunc.service.VolunteerService;

@Controller
@RequestMapping("/")
public class VolunteerMvcController {
    
	@Autowired
	VolunteerService service;

	@RequestMapping
	public String getAllVolunteers(Model model) 
	{
		List<VolunteerEntity> list = service.getAllVolunteers();

		model.addAttribute("volunteers", list);
		return "list-volunteers";
	}

	@RequestMapping(path = {"/edit", "/edit/{id}"})
	public String editVolunteerById(Model model, @PathVariable("id") Optional<Long> id) 
							throws RecordNotFoundException 
	{
		if (id.isPresent()) {
			VolunteerEntity entity = service.getVolunteerById(id.get());
			model.addAttribute("volunteer", entity);
		} else {
			model.addAttribute("volunteer", new VolunteerEntity());
		}
		return "add-edit-volunteer";
	}
	
	@RequestMapping(path = "/delete/{id}")
	public String deleteVolunteerById(Model model, @PathVariable("id") Long id) 
							throws RecordNotFoundException 
	{
		service.deleteVolunteerById(id);
		return "redirect:/";
	}

	@RequestMapping(path = "/createVolunteer", method = RequestMethod.POST)
	public String createOrUpdateVolunteer(VolunteerEntity volunteer) 
	{
		service.createOrUpdateVolunteer(volunteer);
		return "redirect:/";
	}
}