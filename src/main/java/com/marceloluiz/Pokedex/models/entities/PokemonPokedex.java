package com.marceloluiz.Pokedex.models.entities;

import java.util.List;
import java.util.Set;

import com.marceloluiz.Pokedex.models.enums.PokeType;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PokemonPokedex {
	@Setter
    private int id; //number label
	@Setter
    private String name;
	@Setter
    private String image;
	@Setter
    private String shinyImg;

    private List<PokeType> pokeType;
    private List<PokeStats> stats;
    private Set<PokeType> weaknesses;

	@Setter
    private int generation;
	@Setter
    private String height;
	@Setter
    private String weight;
	@Setter
    private String region;

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
