package application;

import java.sql.SQLException;
import java.util.List;

import dao.ConnectionHandler;
import dao.PokemonDao;
import entity.Pokemon;

public class Application {
	
	public static void main(String[] args) {
		PokemonDao dao = new PokemonDao();
		try {
			//dao.createPokemon("Squirtle", "Water", 4);
			//Pokemon pokemon = dao.getPokemonById(4);
//			List<Pokemon> pokemon = dao.getAllPokemon();
//			for (Pokemon p : pokemon) {
//				System.out.println(p.getId() + " " + p.getName() + " " + p.getType() + " " + p.getLevel());
//			}
			//dao.deletePokemonById(4);
			dao.updatePokemon(2, "Charmeleon", "Fire", 18);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
