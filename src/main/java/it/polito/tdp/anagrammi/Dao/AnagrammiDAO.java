package it.polito.tdp.anagrammi.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class AnagrammiDAO {
	
	public boolean isCorrect(String anagramma) {

		final String sql = "SELECT * FROM parola ";

		List<String> parole = new LinkedList<String>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String parola= rs.getString("nome");
				parole.add(parola);

			}

			conn.close();
			st.close();
			
			if (parole.contains(anagramma)) {
				return true;
			} else {
				return false;
			}
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}}
}


