package com.marceloluiz.Pokedex.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marceloluiz.Pokedex.models.PokeData;
import com.marceloluiz.Pokedex.models.PokeSprite;
import com.marceloluiz.Pokedex.models.PokeSprite.Sprites;
import com.marceloluiz.Pokedex.models.PokeStats;
import com.marceloluiz.Pokedex.models.PokeWeakness;
import com.marceloluiz.Pokedex.models.entities.PokemonPokedex;
import com.marceloluiz.Pokedex.models.enums.PokeType;

public class PokemonPokedexDeserializer {
	private String json;
	private ObjectMapper mapper;
	private JsonNode jsonNode;
	private APIConsumption apiConsumption;
	
	public String getJson() {
		return json;
	}

	public void setJson(int i) {
		this.json = "https://pokeapi.co/api/v2/pokemon/" + i;
	}
	
	public PokemonPokedex createPokemon(PokemonPokedex pokemon) {
		PokeSprite shinySprite = getSprites().get(1);
		
		for(PokeData data : getBaseData()) {
			pokemon = new PokemonPokedex(data.getId(),
					data.getName().toUpperCase(),
					getSprites().stream().map(PokeSprite::getUrl).findFirst().orElse(null).toString(),
					shinySprite.getUrl(),
					getTypes(),
					getStats(),
					getWeaknesses(),
					getGeneration(),
					data.getHeight(),
					data.getWeight(),
					getRegion().toUpperCase()); 
		}
		return pokemon;
	}

	private Set<PokeType> getWeaknesses() {
		Set<PokeType> weaknesses = new HashSet<>();
		
		getTypes().forEach(t -> {
			for(PokeType weak : t.weak) {
				weaknesses.add(weak);
			}
		});	
		
		return (getTypes().size() > 1) ? PokeWeakness.allWeaknesses(getTypes()) : weaknesses;
		
	}

	private String getRegion() {
		if(getGeneration()==1) return "kanto";
		if(getGeneration()==2) return "johto";
		if(getGeneration()==3) return "hoenn";
		if(getGeneration()==4) return "sinnoh";
		if(getGeneration()==5) return "unova";
		if(getGeneration()==6) return "kalos";
		if(getGeneration()==7) return "alola";
		if(getGeneration()==8) return "galar,hisui";
		if(getGeneration()==9) return "paldea";
		else return "not-found";
	}

	private int getGeneration() {
		for(PokeData data : getBaseData()) {
			if(data.getId() <= 151) return 1;
			else if(data.getId() <= 251) return 2;
			else if(data.getId() <= 386) return 3;
			else if(data.getId() <= 493) return 4;
			else if(data.getId() <= 649) return 5;
			else if(data.getId() <= 721) return 6;
			else if(data.getId() <= 809) return 7;
			else if(data.getId() <= 905) return 8;
			else if(data.getId() <= 1025) return 9;
			else return 0;
		}
		return 0;
	}
	
	private List<PokeData> getBaseData() {
		apiConsumption = new APIConsumption();
		
		ConvertData convert;
		PokeData data;
		
		List<PokeData> urlList = new ArrayList<>();
		
		String baseJson = apiConsumption.gettingData(getJson());
		
		convert = new ConvertData();
		data = convert.getData(baseJson, PokeData.class);
		
		urlList.add(data);
		
		return urlList;
	}
	
	private List<PokeType> getTypes() {
		List<Integer> type = new ArrayList<>();
		
		for(PokeData baseData : getBaseData()) {
			String typeList = baseData.getTypeList().toString();
			
			boolean found;
			String find = "";
			for(int i = 1; i <= PokeType.values().length; i++) {
				find = "/type/" + i + "/";
				found = typeList.contains(find);
				
				if(found == true) {
					type.add(i);
				}
				
			}	
		}
		
		List<PokeType> pokeType = new ArrayList<>();
		
		for(Integer convertedType : type) {
			pokeType.add(PokeType.getById(convertedType));
		}
		 
		return pokeType;
	}
	
	private List<PokeStats> getStats() {
		apiConsumption = new APIConsumption();
		mapper = new ObjectMapper();
		List<PokeStats> pokeStats = new ArrayList<>();	
		
		try {
			String baseJson = apiConsumption.gettingData(getJson());			
			jsonNode = mapper.readTree(baseJson);
			JsonNode statsArray = jsonNode.get("stats");
			
			for(int i = 0; i < statsArray.size(); i++) {
				JsonNode stat = statsArray.get(i);
				pokeStats.add(new PokeStats(PokeStats.Stats.getById(i+1),
						stat.get("base_stat").asInt()));
			}
			
			return pokeStats;
			
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private List<PokeSprite> getSprites() {
		apiConsumption = new APIConsumption();
		mapper = new ObjectMapper();
		List<PokeSprite> pokeSprites = new ArrayList<>();	
		
		try {	
			String baseJson = apiConsumption.gettingData(getJson());		
			jsonNode = mapper.readTree(baseJson);
			JsonNode spritesObject = jsonNode.get("sprites");
			
			for(int i = 0; i < PokeSprite.Sprites.values().length; i++) {
				PokeSprite.Sprites typeSprites = Sprites.values()[i];
				JsonNode urlNode = spritesObject.get(typeSprites.name().toLowerCase());
				pokeSprites.add(new PokeSprite(typeSprites, urlNode.isNull() ? null : urlNode.toString().replace("\"", "")));
				
			}
			
			return pokeSprites;
			
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
