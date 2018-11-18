package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Pokemon;

public class PokemonDao {
	
	private final Connection connection = ConnectionHandler.getConnection();
	private final String CREATE_POKEMON = "INSERT INTO pokemon(name, type, level) VALUES(?,?,?)";
	private final String GET_POKEMON_BY_ID = "SELECT * FROM pokemon WHERE id=?";
	private final String GET_ALL_POKEMON = "SELECT * FROM pokemon";
	private final String DELETE_POKEMON_BY_ID = "DELETE FROM pokemon WHERE id=?";
	private final String UPDATE_POKEMON = "UPDATE pokemon SET name=?, type=?, level=? WHERE id=?";
	
	public void createPokemon(String name, String type, int level) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_POKEMON);
		ps.setString(1, name);
		ps.setString(2, type);
		ps.setInt(3, level);
		ps.executeUpdate();
	}
	
	public Pokemon getPokemonById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_POKEMON_BY_ID);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return mapResultsToPokemon(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
	}
	
	public List<Pokemon> getAllPokemon() throws SQLException {
		List<Pokemon> pokemon = new ArrayList<Pokemon>();
		PreparedStatement ps = connection.prepareStatement(GET_ALL_POKEMON);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			pokemon.add(mapResultsToPokemon(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		}
		return pokemon;
	}
	
	public void deletePokemonById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_POKEMON_BY_ID);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	public void updatePokemon(int id, String name, String type, int level) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_POKEMON);
		ps.setString(1, name);
		ps.setString(2, type);
		ps.setInt(3, level);
		ps.setInt(4, id);
		ps.executeUpdate();
	}
	
	private Pokemon mapResultsToPokemon(int id, String name, String type, int level) {
		return new Pokemon(id, name, type, level);
	}

}
