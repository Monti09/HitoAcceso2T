package com.hito.Hito2TAcessoSergiomontalban.repositorry;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hito.Hito2TAcessoSergiomontalban.model.PersonaModel;

public interface PersonaRepository extends MongoRepository<PersonaModel, Integer>{

	List<PersonaModel> findByPais(String string);

	List<PersonaModel> findByCiudad(String string);
	
}
