package com.marceloluiz.Pokedex.models.entities;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PokeSprite {
	
	private Sprites sprite;
	private String url;
	
	@Getter
    public enum Sprites{
		
		FRONT_DEFAULT(1),
		FRONT_SHINY(2),
		BACK_DEFAULT(3),
		BACK_SHINY(4);
		
		private final int id;

		private Sprites(int id) {
			this.id = id;
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
