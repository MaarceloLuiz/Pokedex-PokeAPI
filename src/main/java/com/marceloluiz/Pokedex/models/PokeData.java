package com.marceloluiz.Pokedex.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokeData {
	
	private int id;
	private String name;
	private List<Object> typeList;
	private String height;
    private String weight;
	
	public PokeData() {
	}
	
	public PokeData(int id, String name, List<Object> typeList, String height, String weight) {
		this.id = id;
		this.name = name;
		this.typeList = typeList;
		this.height = height;
		this.weight = weight;
	}

	@JsonAlias("id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@JsonAlias("name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonAlias("types")
	public List<Object> getTypeList() {
		return typeList;
	}
	
	@JsonAlias("height")
	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	@JsonAlias("weight")
	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "PokeData [id=" + id
				+ ", name=" + name
				+ ", typeList=" + typeList
				+ ", height=" + height
				+ ", weight=" + weight + "]";
	}

}
