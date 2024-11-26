package com.marceloluiz.Pokedex.models.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.marceloluiz.Pokedex.models.enums.PokeType;

public class PokeWeakness {
	
	public static Set<PokeType> allWeaknesses(List<PokeType> types){
		Set<PokeType> allWeaknesses = new HashSet<>();
		allWeaknesses.addAll(getWeaknesses(types.get(0)));
		allWeaknesses.addAll(getWeaknesses(types.get(1)));
		
		removeWeaknesses(allWeaknesses, types.get(0), types.get(1));
		
		return allWeaknesses;
	}
	
	private static Set<PokeType> getWeaknesses(PokeType type) {
        Set<PokeType> weaknesses = new HashSet<>();
        for(PokeType weak : type.weak) {
        	weaknesses.add(weak);
        }
        return weaknesses;
    }

    private static Set<PokeType> getStrengths(PokeType type) {
        Set<PokeType> strengths = new HashSet<>();
        for(PokeType strong : type.strong) {
        	strengths.add(strong);
        }
        return strengths;
    }

    private static void removeWeaknesses(Set<PokeType> combinedWeaknesses, PokeType type1, PokeType type2) {
        Set<PokeType> strengthsType1 = getStrengths(type1);
        Set<PokeType> strengthsType2 = getStrengths(type2);
        Set<PokeType> noEffectType1 = getNoEffect(type1);
        Set<PokeType> noEffectType2 = getNoEffect(type2);

        combinedWeaknesses.removeIf(weakness -> strengthsType1.contains(weakness) || strengthsType2.contains(weakness)
                || noEffectType1.contains(weakness) || noEffectType2.contains(weakness));
    }

    private static Set<PokeType> getNoEffect(PokeType type) {
        Set<PokeType> noEffect = new HashSet<>();
        for(PokeType non : type.noEffect) {
        	noEffect.add(non);
        }
        return noEffect;
    }
}
