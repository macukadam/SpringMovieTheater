package io.org.movie;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.org.saloon.Saloon;

@Entity
public class Movie {

	@Id
	private String id;
	private String name;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Saloon saloon;

	public Movie(String id, String name, String saloonId) {
		super();
		this.id = id;
		this.name = name;
		this.saloon = new Saloon(saloonId, "");
	}

	public Movie(String id, String name, Saloon saloon) {
		super();
		this.id = id;
		this.name = name;
		this.saloon = saloon;
	}
	
	public Movie() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSaloons(Saloon saloon) {
		this.saloon = saloon;
	}	
	
	public Saloon getSaloons() {
		return saloon;
	}	
}
