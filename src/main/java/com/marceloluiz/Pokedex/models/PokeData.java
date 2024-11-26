package com.marceloluiz.Pokedex.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PokeData {
	@JsonAlias("id")
	private int id;
	@JsonAlias("name")
	private String name;
	@JsonAlias("types")
	private List<Object> typeList;
	@JsonAlias("height")
	private String height;
	@JsonAlias("weight")
    private String weight;

	@Override
	public String toString() {
		return "PokeData [id=" + id
				+ ", name=" + name
				+ ", typeList=" + typeList
				+ ", height=" + height
				+ ", weight=" + weight + "]";
	}

}
