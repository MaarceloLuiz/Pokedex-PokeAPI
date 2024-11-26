package com.marceloluiz.Pokedex.models.entities;

import java.util.List;
import java.util.Set;

import com.marceloluiz.Pokedex.models.PokeStats;
import com.marceloluiz.Pokedex.models.enums.PokeType;

public class PokemonPokedex {
	
    private int id; //number label
    private String name;
    private String image;
    private String shinyImg;
    private List<PokeType> pokeType;
    private List<PokeStats> stats;
    private Set<PokeType> weaknesses;
    private int generation;
    private String height;
    private String weight;
    private String region;
    
    public PokemonPokedex() {
    }

	public PokemonPokedex(int id, String name, String image, String shinyImg, List<PokeType> pokeType,
			List<PokeStats> stats, Set<PokeType> weaknesses, int generation, String height, String weight, String region) {
		this.id = id;
		this.name = name;
		this.image = image;
		this.shinyImg = shinyImg;
		this.pokeType = pokeType;
		this.stats = stats;
		this.weaknesses = weaknesses;
		this.generation = generation;
		this.height = height;
		this.weight = weight;
		this.region = region;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<PokeType> getPokeType() {
		return pokeType;
	}

	public List<PokeStats> getStats() {
		return stats;
	}

	public Set<PokeType> getWeaknesses() {
		return weaknesses;
	}

	public int getGeneration() {
		return generation;
	}

	public void setGeneration(int generation) {
		this.generation = generation;
	}

	public String getShinyImg() {
		return shinyImg;
	}

	public void setShinyImg(String shinyImg) {
		this.shinyImg = shinyImg;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "PokemonPokedex [id=" + id
				+ ", \nname=" + name
				+ ", \nimage=" + image
				+ ", \nshinyImg=" + shinyImg
				+ ", \npokeType=" + pokeType
				+ ", \nstats=" + stats
				+ ", \nweaknesses=" + weaknesses
				+ ", \ngeneration=" + generation
				+ ", \nheight=" + height
				+ ", \nweight=" + weight
				+ ", \nregion=" + region + "]";
	}

}
