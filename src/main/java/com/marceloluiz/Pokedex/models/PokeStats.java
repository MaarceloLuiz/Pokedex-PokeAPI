package com.marceloluiz.Pokedex.models;

public class PokeStats {
	
    private Stats stat;
    private Integer baseStat;

    public PokeStats() {
    }
    
    public PokeStats(Stats stat, int baseStat) {
		this.stat = stat;
		this.baseStat = baseStat;
	}
    

	public Stats getStat() {
		return stat;
	}

	public void setStat(Stats type) {
		this.stat = type;
	}


	public Integer getBaseStat() {
		return baseStat;
	}

	public void setBaseStat(Integer baseStat) {
		this.baseStat = baseStat;
	}

	public enum Stats {

        HP(1),
        ATTACK(2),
        DEFENSE(3),
        SPECIAL_ATTACK(4),
        SPECIAL_DEFENSE(5),
        SPEED(6),
        ACCURACY(7),
        EVASION(8);

        private int id;

		private Stats(int id) {
			this.id = id;
		}

		public int getId() {
			return id;
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
