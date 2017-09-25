package fr.univ_amu.iut;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnexionUnique
{
	private Connection connexion;
	private static ConnexionUnique INSTANCE = new ConnexionUnique();
	static final String CONNECT_URL = "jdbc:mysql://mysql-projetwimbilly.alwaysdata.net/projetwimbilly_bd_av";
	static final String LOGIN = "131337_mdpinfodo";
	static final String PASSWORD = "trabil";
	private ConnexionUnique()
	{
		try {
			connexion= DriverManager.getConnection(CONNECT_URL,LOGIN,PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnexion()
	{
		return connexion;
	}

	public static ConnexionUnique getInstance()
	{
		return INSTANCE;
	}



}
