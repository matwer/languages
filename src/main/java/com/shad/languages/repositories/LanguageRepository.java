/**
 * @author Matthew Werner
 *
 **/

package com.shad.languages.repositories;

import org.springframework.data.repository.CrudRepository;

import com.shad.languages.models.Language;

import java.util.List;


//CrudRepository<model, primary key type> - this gives us access to CRUD
public interface LanguageRepository extends CrudRepository<Language, Integer> {
	
	// creates a query to select * from languages
	List<Language> findAll();
}
