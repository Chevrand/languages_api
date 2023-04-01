package br.com.alura.languagesapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "languages")
public class LanguageModel {
	
	@Id
	private String id;
	
	private String title;
	
	private String urlImage;
	
	private Integer ranking;

	public LanguageModel() {
		// default constructor
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public Integer getRanking() {
		return ranking;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}

	public String getId() {
		return id;
	}
}
