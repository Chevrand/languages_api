package br.com.alura.languagesapi.service;

import java.io.FileNotFoundException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.languagesapi.model.LanguageModel;
import br.com.alura.languagesapi.repository.LanguageRepository;

@Service
public class LanguageService {
	
	@Autowired
	private LanguageRepository languageRepository;
	
	public LanguageModel update(String id, LanguageModel body) throws FileNotFoundException {
		Optional<LanguageModel> language = languageRepository.findById(id);
		LanguageModel languageDb = null;
		if (language.isPresent()) {
			languageDb = language.get();
			if (body.getTitle() != null) languageDb.setTitle(body.getTitle());
			if (body.getUrlImage() != null) languageDb.setUrlImage(body.getUrlImage());
			if (body.getRanking() != null) languageDb.setRanking(body.getRanking());			
		} else {
			throw new FileNotFoundException("Linguagem não encontrada");
		}

		return languageRepository.save(languageDb);
	}

}
