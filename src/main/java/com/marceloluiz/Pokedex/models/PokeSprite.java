package com.marceloluiz.Pokedex.models;

public class PokeSprite {
	
	private Sprites sprite;
	private String url;
	
	public PokeSprite() {
	}
	
	public PokeSprite(Sprites sprite, String url) {
		this.sprite = sprite;
		this.url = url;
	}

	public Sprites getSprite() {
		return sprite;
	}

	public void setSprite(Sprites sprite) {
		this.sprite = sprite;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	public enum Sprites{
		
		FRONT_DEFAULT(1),
		FRONT_SHINY(2),
		BACK_DEFAULT(3),
		BACK_SHINY(4);
		
		private int id;

		private Sprites(int id) {
			this.id = id;
		}

		public int getId() {
			return id;
		}
		
		public static Sprites getById(Integer id) {
			for(Sprites e : Sprites.values()) {
				if(e.id == id) return e;
			}
			throw new IllegalArgumentException();
		}

	}

	@Override
	public String toString() {
		return "PokeSprite [sprite=" + sprite + ", url=" + url + "]";
	}
	
}
