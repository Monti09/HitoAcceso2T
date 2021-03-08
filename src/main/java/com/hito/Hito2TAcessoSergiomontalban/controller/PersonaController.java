package com.hito.Hito2TAcessoSergiomontalban.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hito.Hito2TAcessoSergiomontalban.model.PersonaModel;
import com.hito.Hito2TAcessoSergiomontalban.repositorry.PersonaRepository;

@Controller
public class PersonaController {

	@Autowired
	private PersonaRepository pr;
	
	@GetMapping("/")
	public String verPersonas(Model model) {
		
		model.addAttribute("personas", pr.findAll());
		return "listado";
		
	}
	
	@GetMapping("/insertar")
	public String insertPersona(Model model) {
		model.addAttribute("personas", new PersonaModel());
		return "insertarPersona";
	}
	
	@PostMapping("/insertarPersona")
	public String insertPersona(PersonaModel persona){
		pr.save(persona);
		return "redirect:/insercionCorrecta";
	}
	
	@GetMapping("/insercionCorrecta")
	public String insertCorrect(Model model) {
		return "correcto";
	}
	
	@RequestMapping(path = "/eliminar/{id}")
	public String eliminarPersona(PersonaModel persona, @PathVariable("id") int id) {
		pr.delete(persona);
		return "correcto";
	}
	
	@RequestMapping(path = "/editar/{id}")
	public String editarPersona(Model model, PersonaModel persona, @PathVariable("id") int id) {
			Optional<PersonaModel> personita = pr.findById(persona.getId());	
			
			PersonaModel newPersona = personita.get();
			newPersona.setId(personita.get().getId());
			newPersona.setNombre(personita.get().getNombre());
			newPersona.setApellido(personita.get().getApellido());
			newPersona.setCiudad(personita.get().getCiudad());
			newPersona.setPais(personita.get().getPais());

			model.addAttribute("personas", newPersona);

		return "modificar";
	}
	
	@PostMapping("/modificarPersona")
	public String modificarPersona(PersonaModel persona){
		pr.save(persona);
		return "redirect:/insercionCorrecta";
	}
	
	@GetMapping("/buscar")
	public String buscarBy(PersonaModel persona) {
		return "busqueda";
	}
	
	@GetMapping("/buscarciudad")
	public String buscarByCiudad(Model model, PersonaModel persona) {
		PersonaModel newPersona = new PersonaModel();
		model.addAttribute("personas", newPersona);
		return "filtrobusquedaciudad";
	}
	
	@GetMapping("/buscarpais")
	public String buscarByPais(Model model, PersonaModel persona) {
		PersonaModel newPersona = new PersonaModel();
		model.addAttribute("personas", newPersona);
		return "filtrobusquedapais";
	}
	
	@PostMapping("/buscarciudadresul")
	public String buscarByCiudadResul(Model model, PersonaModel persona) {
		model.addAttribute("personas", pr.findByCiudad(persona.getCiudad()));
		return "buscarciudad";
	}
	
	@PostMapping("/buscarpaisresul")
	public String buscarByPaisResul(Model model, PersonaModel persona) {
		model.addAttribute("personas", pr.findByPais(persona.getPais()));
		return "buscarpais";
	}
	
	// POSTMAN
	@PostMapping("/POSTMAN/insertarpersonas")
	public ResponseEntity<PersonaModel> insertPersonaPOSTMAN(@RequestBody PersonaModel personaModel) {
		PersonaModel salida = pr.save(personaModel);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(salida);
	}
			
	@GetMapping("/POSTMAN/personas")
	public ResponseEntity<List<PersonaModel>> getAllPersonas() {
		List<PersonaModel> salida = pr.findAll();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(salida);
	}
	
}
