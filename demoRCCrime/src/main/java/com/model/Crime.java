package com.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Crime {
	@XmlElement(name = "Category", required = true)
	String Category;
	@XmlElement(name = "arrest_count", required = true)
	String arrest_count;


	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getArrest_count() {
		return arrest_count;
	}
	public void setArrest_count(String arrest_count) {
		this.arrest_count = arrest_count;
	}	
}
