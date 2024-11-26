package com.marceloluiz.Pokedex.models.entities;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PokeStats {
	
    private Stats stat;
    private Integer baseStat;

	@Getter
    public enum Stats {

        HP(1),
        ATTACK(2),
        DEFENSE(3),
        SPECIAL_ATTACK(4),
        SPECIAL_DEFENSE(5),
        SPEED(6),
        ACCURACY(7),
        EVASION(8);

        private final int id;

		private Stats(int id) {
			this.id = id;
		}

        public static Stats getById(Integer id) {
			for(Stats e : Stats.values()) {
				if(e.id == id) return e;
			}
			throw new IllegalArgumentException();
		}
        
    }

	@Override
	public String toString() {
		return "PokeStats [stat=" + stat + ", baseStat=" + baseStat + "]";
	}
	
}
