package fr.univ_amu.iut;

import fr.univ_amu.iut.beans.Etudiant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestEntite {

	// La requete de test
	static final String req = "SELECT NUM_ET, NOM_ET, PRENOM_ET " +
			"FROM ETUDIANT " +
			"WHERE VILLE_ET = 'AIX-EN-PROVENCE'";

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
			List<Etudiant> listeEtudiants = new ArrayList<>();
			while (rset.next()){
				Etudiant etudiant = new Etudiant();
				etudiant.setNumEt(rset.getInt("NUM_ET"));
				etudiant.setNomEt(rset.getString("NOM_ET"));
				etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
				listeEtudiants.add(etudiant);
			}
			// Fermeture de l'instruction (liberation des ressources)
			stmt.close();
			System.out.println(listeEtudiants);
			System.out.println("\nOk.\n");
		} catch (SQLException e) {
			e.printStackTrace();// Arggg!!!
			System.out.println(e.getMessage() + "\n");
		}
	}
}

