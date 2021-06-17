/**
 * @author Matthew Werner
 * 
 **/

package com.shad.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shad.languages.models.Language;
import com.shad.languages.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService langService;
	
	public LanguageController(LanguageService langService) {
		this.langService = langService;
	}
	
	// set up a route to redirect from localhost:8080 to the default route (/languages) 
	@RequestMapping("/")
	public String redirect() {
        return "redirect:/languages";
	}
	
	// set up the default route which shows all entries 
	@RequestMapping("/languages")
	public String index(Model model, @ModelAttribute("language") Language l) {
		List<Language> languages = langService.allLanguages();
		model.addAttribute("languages", languages);
		return "index.jsp";
	}
	
	// set up a route to show a single entry
	@RequestMapping(value="/languages/{id}")
	public String showOne(@PathVariable("id") Integer id, Model model) {
		Language l = langService.findLanguage(id);
		model.addAttribute("language", l);
		return "read.jsp";
	}
	
	// set up a route to render the create page
    @RequestMapping("/languages/new")
    public String displayCreate(@ModelAttribute("language") Language l) {
        return "index.jsp";
    }
    
    // set up a route to create a new entry and add it to the database
    @RequestMapping(value="/languages", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("language") Language l, 
    		BindingResult result) {
        if (result.hasErrors()) {
            return "index.jsp";
        } else {
        	langService.createLanguage(l);
            return "redirect:/languages";
        }
    }
    
    // add a route to display the edit page
    @RequestMapping("/languages/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
    	Language l = langService.findLanguage(id);
        model.addAttribute("language", l);
        return "update.jsp";
    }
    
    // update the entry if it exists
    @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("language") Language l,
    		BindingResult result) {
        if (result.hasErrors()) {
            return "update.jsp";
        } else {
            langService.updateLanguage(l);
            return "redirect:/languages";
        }
    }
    
    // create a route for deleting an entry
    @RequestMapping(value="/languages/delete/{id}", method=RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id) {
        langService.deleteLanguage(id);
        return "redirect:/languages";
    }
    
}
