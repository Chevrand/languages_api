package br.com.alura.languagesapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.alura.languagesapi.model.LanguageModel;

public interface LanguageRepository extends MongoRepository<LanguageModel, String>{

}
