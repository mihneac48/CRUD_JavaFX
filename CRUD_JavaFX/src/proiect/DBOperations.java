package proiect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBOperations {
	String error;
	Connection con;
	
	public DBOperations() {
	}
	public void connect() throws ClassNotFoundException, SQLException, Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/muzica?useSSL=false", "root", "123401234");
		} catch (ClassNotFoundException cnfe) {
			error = "ClassNotFoundException: Nu s-a gasit driverul bazei de date.";
			throw new ClassNotFoundException(error);
		} catch (SQLException cnfe) {
			error = "SQLException: Nu se poate conecta la baza de date.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "Exception: A aparut o exceptie neprevazuta in timp ce se stabilea legatura la baza de date.";
			throw new Exception(error);
		}
	}
	
	public ResultSet vedeTabel(String tabel) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String queryString = ("select * from `muzica`.`" + tabel + "`;");
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(queryString);
		} catch (SQLException sqle) {
			error = "SQLException: Interogarea nu a fost posibila.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "A aparut o exceptie in timp ce se extrageau datele.";
			throw new Exception(error);
		}
		return rs;
	}
	
	public ResultSet vedeRepartizare() throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String queryString = ("select a.Nume, a.Prenume , a.Instrument, a.NumeImpresar,b.Denumire , b.Locatie, b.GenMuzical, c.idRepartizare, c.idConcert idConcert_rep,c.idArtist idArtist_rep from artisti a,concerte b, repartizari c where a.idArtist = c.idArtist and b.idConcert = c.idConcert;");
					Statement stmt = con.createStatement(/*ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY*/);
					rs = stmt.executeQuery(queryString);
		} catch (SQLException sqle) {
			error = "SQLException: Interogarea nu a fost posibila.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "A aparut o exceptie in timp ce se extrageau datele.";
			throw new Exception(error);
		}
		return rs;}
	public void disconnect() throws SQLException {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException sqle) {
			error = ("SQLException: Nu se poate inchide conexiunea la baza de date.");
			throw new SQLException(error);
		}
	} 
	public void adaugaArtist(String Nume, String Prenume, String Instrument, String NumeImpresar) throws SQLException {
		try {
			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate("insert into `muzica`.`artisti`(Nume, Prenume, Instrument, NumeImpresar) values('" + Nume + "', '" + Prenume +
					"', '" + Instrument + "', '" + NumeImpresar + "');");
		} catch (SQLException sqle) {
			error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
			throw new SQLException(error);
		}
	}
	
	public void adaugaConcert(String Denumire, String Locatie, String GenMuzical) throws SQLException {
		try {
			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate("insert into `muzica`.`concerte`(Denumire, Locatie, GenMuzical) values('" + Denumire + "', '" + Locatie + "', '" + GenMuzical + "');");
		} catch (SQLException sqle) {
			error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
			throw new SQLException(error);
		}
	}
	public void adaugaRepartizare(int idArtist, int idConcert)
			throws SQLException, Exception {
		if (con != null) {
			try {
				Statement stmt;
				stmt = con.createStatement();
				stmt.executeUpdate(
						"insert into repartizari(idArtist, idConcert) values('"
								+ idArtist + "'  , '" + idConcert + "');");

			} catch (SQLException sqle) {
				error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
				throw new SQLException(error);
			}
		} else {
			error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
			throw new Exception(error);
		}
	} 
	public void stergeTabela(String tabela, String denumirePK, long id) throws SQLException, Exception {
		if (con != null) {
			try {
				Statement stmt;
				stmt = con.createStatement();
				stmt.executeUpdate("delete from " + tabela + " where " + denumirePK + " = '" + id + "';");
			} catch (SQLException sqle) {
				error = "ExceptieSQL: Stergere nereusita; este posibil sa existe duplicate.";
				throw new SQLException(error);
			}
		} else {
			error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
			throw new Exception(error);
		}
	} 
	public void modificaTabela(String tabela, String primarykey, long ID, String[] campuri, String[] valori)
			throws SQLException, Exception {
		String update = "update " + tabela + " set ";
		String temp = "";
		if (con != null) {
			try {
				for (int i = 0; i < campuri.length; i++) {
					if (i != (campuri.length - 1)) {
						temp = temp + campuri[i] + "='" + valori[i] + "', ";
					} else {
						temp = temp + campuri[i] + "='" + valori[i] + "' where " + primarykey + " = '" + ID + "';";
					}
				}
				update = update + temp;
				Statement stmt;
				stmt = con.createStatement();
				stmt.executeUpdate(update);
			} catch (SQLException sqle) {
				error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
				throw new SQLException(error);
			}
		} else {
			error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
			throw new Exception(error);
		}
	} 
	

	public ResultSet intoarceLinie(String tabela, int ID) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String queryString = ("SELECT * FROM " + tabela + " where idArtist=" + ID + ";");
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(queryString); 
		} catch (SQLException sqle) {
			error = "SQLException: Interogarea nu a fost posibila.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "A aparut o exceptie in timp ce se extrageau datele.";
			throw new Exception(error);
		}
		return rs;
	} 

	public ResultSet intoarceLinieDupaId(String tabela, String denumireId, int ID) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String queryString = ("SELECT * FROM " + tabela + " where " + denumireId + "=" + ID + ";");
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(queryString); 
		} catch (SQLException sqle) {
			error = "SQLException: Interogarea nu a fost posibila.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "A aparut o exceptie in timp ce se extrageau datele.";
			throw new Exception(error);
		}
		return rs;
	} 

	public ResultSet intoarceRepartizareId(int ID) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String queryString = ("SELECT a.Nume , a.Prenume, a.Instrument, a.NumeImpresar, b.Denumire, b.Locatie, b.GenMuzical, c.idRepartizare, c.idConcert idConcert_rep,c.idArtist idArtist_rep FROM artisti a, concerte b, repartizari c  WHERE a.idArtist = c.idArtist AND b.idConcert = c.idConcert and idRepartizare = '" +ID + "';");
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(queryString); 
		} catch (SQLException sqle) {
			error = "SQLException: Interogarea nu a fost posibila.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "A aparut o exceptie in timp ce se extrageau datele.";
			throw new Exception(error);
		}
		return rs;
	} 
}
