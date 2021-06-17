/**
 * @author Matthew Werner
 *
 **/

package com.shad.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shad.languages.models.Language;
import com.shad.languages.repositories.LanguageRepository;


// make sure you add the Service annotation to the Service class
@Service
public class LanguageService {
	// instantiate a new repository
	private final LanguageRepository langRepo;
	
	// set up a constructor for the service
	public LanguageService(LanguageRepository langRepo) {
		this.langRepo = langRepo;
	}
	
    // returns all entries
    public List<Language> allLanguages() {
        return langRepo.findAll();
    }
    
    // creates an entry
    public Language createLanguage(Language l) {
        return langRepo.save(l);
    }
    
    // finds an entry
    public Language findLanguage(Integer id) {
        Optional<Language> optLang = langRepo.findById(id);
        
        if(optLang.isPresent()) {
            return optLang.get();
        } else {
            return null;
        }
    }
    
    // updates an entry
    public Language updateLanguage(Integer id, 
    						String name, 
    						String creator, 
    						String version) {
    	Optional<Language> optLang = langRepo.findById(id);
    	Language lang = this.findLanguage(id);    		
    	
    	if(optLang.isPresent()) {
    		// if the entry is present, update it
    		return langRepo.save(lang);
    	}
    	
    	return null;

    }
    
    // add an overloaded method to update a language
    public Language updateLanguage(Language l) {
    	Optional<Language> optLang = Optional.of(l); 
    	
    	// if the entry is present, update it 
    	if(optLang.isPresent()) {
    		return langRepo.save(l);
    	}
    	
    	return null;
    }
    
    // delete an entry
    public void deleteLanguage(Integer id) {
    	Optional<Language> optLang = langRepo.findById(id);
    	
    	// check to see if the entry exists
        if(optLang.isPresent()) {
        	langRepo.deleteById(id);
        }
 
    }
}
