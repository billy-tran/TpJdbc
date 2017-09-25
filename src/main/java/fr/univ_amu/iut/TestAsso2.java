package fr.univ_amu.iut;

import fr.univ_amu.iut.beans.Module;
import fr.univ_amu.iut.beans.Prof;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestAsso2 {

	// La requete de test
	static final String req = "SELECT NUM_PROF, NOM_PROF, PRENOM_PROF, MAT_SPEC " +
			"FROM PROF ";


	public static void main(String[] args) throws SQLException {
		// Connexion a la base
		System.out.println("Connexion a ");
		try (Connection conn = ConnexionUnique.getInstance().getConnexion()){
			System.out.println("Connecte\n");
			// Creation d'une instruction SQL
			Statement stmt = conn.createStatement();
			// Execution de la requete
			System.out.println("Execution de la requete : " + req );
			ResultSet rset = stmt.executeQuery(req);
			// Affichage du resultat
			List<Prof> listeProfResp = new ArrayList<>();
			while (rset.next()){
				Prof prof = new Prof();
				prof.setNumProf(rset.getInt("NUM_PROF"));
				prof.setNomProf(rset.getString("NOM_PROF"));
				prof.setPrenomProf(rset.getString("PRENOM_PROF"));
				Module module = new Module();
				module.setCode(rset.getString("MAT_SPEC"));
				prof.setMatSpec(module);
				listeProfResp.add(prof);
			}
			// Fermeture de l'instruction (liberation des ressources)
			stmt.close();
			System.out.println(listeProfResp);
			System.out.println("\nOk.\n");
		} catch (SQLException e) {
			e.printStackTrace();// Arggg!!!
			System.out.println(e.getMessage() + "\n");
		}
	}
}

