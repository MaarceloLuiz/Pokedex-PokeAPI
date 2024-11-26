package com.marceloluiz.Pokedex.model.dao;

import com.marceloluiz.Pokedex.db.DB;
import com.marceloluiz.Pokedex.model.dao.impl.PokemonDaoJDBC;

public class DaoFactory {
	
	public static PokemonDao createPokemonDao() {
		return new PokemonDaoJDBC(DB.getConnection());
	}

}
