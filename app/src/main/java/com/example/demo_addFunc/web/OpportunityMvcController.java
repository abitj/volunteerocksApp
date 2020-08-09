/**
 * Implementation of the Opportunity controller
 */
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
	OpportunityService service;

	/**
	 * Edits the opportunity entity
	 * <p>
	 * Selects the opportunity by id then presents the values for editing
	 * <p>
	 * @param model
	 * @param idid of the opportunity to retrieve for editing
	 * @return add-edit-opportunity html resource template
	 * @throws RecordNotFoundException
	 */
	@RequestMapping(path = {"/edit", "/edit/{id}"})
	public String editOpportunityById(Model model, @PathVariable("id") Optional<Long> id) 
							throws RecordNotFoundException 
	{
		if (id.isPresent()) {
			OpportunityEntity entity = service.getOpportunityById(id.get());
			model.addAttribute("opportunity", entity);
		} else {
			model.addAttribute("opportunity", new OpportunityEntity());
		}
		return "add-edit-opportunity";
	}
	
	/**
	 * Create a new opportunity or edit an existing opportunity
	 * <p>
	 * @param opportunity
	 * @return Redirects to list of opportunities
	 */
	@RequestMapping(path = "/createOpportunity", method = RequestMethod.POST)
	public String createOrUpdateOpportunity(OpportunityEntity opportunity) 
	{
		service.createOrUpdateOpportunity(opportunity);
		return "redirect:/opp";
	}

	/**
	 * Delete the opportunity by id
	 * <p>
	 * @param model
	 * @param id unique id of the opportunity to delete
	 * @return Redirects to list of opportunities
	 * @throws RecordNotFoundException
	 */
	@RequestMapping(path = "/delete/{id}")
	public String deleteOpportunityById(Model model, @PathVariable("id") Long id) 
							throws RecordNotFoundException 
	{
		service.deleteOpportunityById(id);
		return "redirect:/opp";
	}

	/**
	 * Lists all current opporunity records
	 * <p>
	 * @param model
	 * @return list-opportunities html resource template
	 */
	@RequestMapping
	public String getAllOpportunities(Model model) 
	{
		List<OpportunityEntity> list = service.getAllOpportunities();

		model.addAttribute("opportunities", list);
		return "list-opportunities";
	}

	/**
	 * Allow a volunter to sign up for an opportunity
	 * <p>
	 * @param opportunity
	 * @return Redirect to volunteer info entry page
	 */
	@RequestMapping(path = "/signUp", method = RequestMethod.POST)
	public String signUp(OpportunityEntity opportunity) 
	{
		return "redirect:/vol";
	}

}