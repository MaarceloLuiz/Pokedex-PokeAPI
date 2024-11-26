package com.marceloluiz.Pokedex.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.marceloluiz.Pokedex.db.DB;
import com.marceloluiz.Pokedex.db.DbException;
import com.marceloluiz.Pokedex.model.dao.PokemonDao;
import com.marceloluiz.Pokedex.models.entities.Pokemon;

public class PokemonDaoJDBC implements PokemonDao {
	
	private Connection conn;
	
	public PokemonDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Pokemon obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"INSERT INTO pokemon "
					+ "(PokemonId, PokeImageUrl, PokeName, PokeType, HP, Attack, Defense, SpecialAttack, SpecialDefense) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, obj.getPokeID());
			st.setString(2, obj.getPokeSprites()[0].toString());
			st.setString(3, obj.getPokeName());
			st.setString(4, obj.getPokeType().toString());
			st.setString(5, obj.getPokeStatus()[0].toString());
			st.setString(6, obj.getPokeStatus()[1].toString());
			st.setString(7, obj.getPokeStatus()[2].toString());
			st.setString(8, obj.getPokeStatus()[3].toString());
			st.setString(9, obj.getPokeStatus()[4].toString());
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					obj.setPokeID(id);
				}
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void update(Pokemon obj) {
//		PreparedStatement st = null;
//		
//		try {
//			st = conn.prepareStatement(
//					"UPDATE pokemon "
//					+ "SET PokeName = ? "
//					+ "WHERE PokemonId = ?");
//			
//			st.setString(1, obj.getPokeName());
//			st.setInt(2, obj.getPokeID());
//			
//			st.executeUpdate();
//		}
//		catch(SQLException e) {
//			throw new DbException(e.getMessage());
//		}
//		finally {
//			DB.closeStatement(st);
//		}

	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("DELETE FROM pokemon WHERE PokemonId = ?");
			
			st.setInt(1, id);
			
			st.executeUpdate();
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public Pokemon findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT * FROM pokemon WHERE PokemonId = ?");
			
			st.setInt(1, id);
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				Pokemon poke = new Pokemon();
				poke.setPokeID(rs.getInt("PokemonId"));
				poke.setPokeName(rs.getString("PokeName"));
				
				return poke;
			}
			return null;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Pokemon> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT * FROM pokemon ORDER BY PokemonId");
			
			rs = st.executeQuery();
			
			List<Pokemon> list = new ArrayList<>();
			
			while(rs.next()) {
				Pokemon poke = new Pokemon();
				poke.setPokeID(rs.getInt("PokemonId"));
				poke.setPokeName(rs.getString("PokeName"));
				
				list.add(poke);
			}
			return list;
			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

}
