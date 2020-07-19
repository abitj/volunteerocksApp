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
import com.example.demo_addFunc.model.OpportunityEntity;
import com.example.demo_addFunc.service.OpportunityService;

@Controller
@RequestMapping("/opp")
public class OpportunityMvcController {
    
	@Autowired
	OpportunityService oppService;

	@RequestMapping(path = {"/edit", "/edit/{id}"})
	public String editOpportunityById(Model model, @PathVariable("id") Optional<Long> id) 
							throws RecordNotFoundException 
	{
		if (id.isPresent()) {
			OpportunityEntity entity = oppService.getOpportunityById(id.get());
			model.addAttribute("opportunity", entity);
		} else {
			model.addAttribute("opportunity", new OpportunityEntity());
		}
		return "add-edit-opportunity";
	}
	
	@RequestMapping(path = "/createOpportunity", method = RequestMethod.POST)
	public String createOrUpdateOpportunity(OpportunityEntity opportunity) 
	{
		oppService.createOrUpdateOpportunity(opportunity);
		return "redirect:/opp";
	}
	/*
	@RequestMapping
	public String getAllVolunteers(Model model) 
	{
		List<VolunteerEntity> list = service.getAllVolunteers();

		model.addAttribute("volunteers", list);
		return "list-volunteers";
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
*/
	@RequestMapping
	public String getAllOpportunities(Model model) 
	{
		List<OpportunityEntity> list = oppService.getAllOpportunities();

		model.addAttribute("opportunities", list);
		return "list-opportunities";
	}

}