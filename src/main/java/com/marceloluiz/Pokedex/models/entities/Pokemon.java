package com.marceloluiz.Pokedex.models.entities;

import com.marceloluiz.Pokedex.models.PokeSprite;
import com.marceloluiz.Pokedex.models.PokeStats;
import com.marceloluiz.Pokedex.models.enums.PokeType;

public class Pokemon {
	private Integer pokeID;
	private String pokeName;
	private PokeType[] pokeType;
	private PokeStats[] pokeStatus;
	private PokeSprite[] pokeSprites;
	
	public Pokemon() {
	}
	
	public Pokemon(Integer pokeID, String pokeName, PokeType[] pokeType, PokeStats[] pokeStatus, PokeSprite[] pokeSprites) {
		this.pokeID = pokeID;
		this.pokeName = pokeName;
		this.pokeType = pokeType;
		this.pokeStatus = pokeStatus;
		this.pokeSprites = pokeSprites;
	}

	public Integer getPokeID() {
		return pokeID;
	}

	public void setPokeID(Integer pokeID) {
		this.pokeID = pokeID;
	}

	public String getPokeName() {
		return pokeName;
	}

	public void setPokeName(String pokeName) {
		this.pokeName = pokeName;
	}

	public PokeType[] getPokeType() {
		return pokeType;
	}

	public void setPokeType(PokeType[] pokeType) {
		this.pokeType = pokeType;
	}

	public PokeStats[] getPokeStatus() {
		return pokeStatus;
	}

	public void setPokeStatus(PokeStats[] pokeStatus) {
		this.pokeStatus = pokeStatus;
	}

	public PokeSprite[] getPokeSprites() {
		return pokeSprites;
	}

	public void setPokeSprites(PokeSprite[] pokeSprites) {
		this.pokeSprites = pokeSprites;
	}
	
	
}
