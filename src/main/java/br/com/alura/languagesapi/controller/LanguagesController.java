package br.com.alura.languagesapi.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.languagesapi.model.LanguageModel;
import br.com.alura.languagesapi.repository.LanguageRepository;
import br.com.alura.languagesapi.service.LanguageService;

@RestController
@RequestMapping("/languages")
public class LanguagesController {
	
	@Autowired
	private LanguageRepository languageRepository;
	@Autowired
	private LanguageService languageService;
	
	@GetMapping
	public ResponseEntity<List<LanguageModel>> getAll() {
		return ResponseEntity.ok(languageRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LanguageModel> getById(@PathVariable String id) {
		return ResponseEntity.ok(languageRepository.findById(id).get());
	}
	
	@PostMapping
	public ResponseEntity<LanguageModel> create(@RequestBody LanguageModel body) {
		return ResponseEntity.created(null).body(languageRepository.save(body));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<LanguageModel> update(@PathVariable String id, @RequestBody LanguageModel body) throws FileNotFoundException {		
		return ResponseEntity.ok(languageService.update(id, body));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable String id) {
		languageRepository.deleteById(id);
		return ResponseEntity.accepted().body(String.format("Linguagem ID %s deletada com sucesso", id));
	}
}
