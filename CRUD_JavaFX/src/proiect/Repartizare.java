package proiect;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Repartizare {
	private final IntegerProperty idRepartizare;
	private final IntegerProperty idArtist;
	private final IntegerProperty idConcert;
	private final StringProperty Nume;
	private final StringProperty Prenume;
	private final StringProperty Instrument;
	private final StringProperty NumeImpresar;
	private final StringProperty Denumire;
	private final StringProperty Locatie;
	private final StringProperty GenMuzical;
	
	
	public Repartizare(int idRepartizare, int idArtist, int idConcert,String Nume, String Prenume, String Instrument, String NumeImpresar,String Denumire, String Locatie, String GenMuzical) {
		this.idRepartizare = new SimpleIntegerProperty(idRepartizare);
		this.idArtist = new SimpleIntegerProperty(idArtist);
		this.idConcert = new SimpleIntegerProperty(idConcert);
		this.Nume = new SimpleStringProperty(Nume);
		this.Prenume = new SimpleStringProperty(Prenume);
		this.Instrument = new SimpleStringProperty(Instrument);
		this.NumeImpresar = new SimpleStringProperty(NumeImpresar);
		this.Denumire = new SimpleStringProperty(Denumire);
		this.Locatie = new SimpleStringProperty(Locatie);
		this.GenMuzical = new SimpleStringProperty(GenMuzical);
	}
	
	public Integer getIdRepartizare() {
		return idRepartizare.get();
	}
	
	
	public Integer getIdArtist() {
		return idArtist.get();
	}
	
	public Integer getIdProdus() {
		return idConcert.get();
	}

	public void setIdRepartizare(Integer valoare) {
		idRepartizare.set(valoare);
	}
	
	public void setIdArtist(Integer valoare) {
		idArtist.set(valoare);
	}

	public void setIdConcert(Integer valoare) {
		idConcert.set(valoare);
	}

	public IntegerProperty idRepartizareProperty() {
		return idRepartizare;
	}
	
	public IntegerProperty idArtistProperty() {
		return idArtist;
	}
	public IntegerProperty idConcertProperty() {
		return idConcert;
	}
	public StringProperty NumeProperty() {
		return Nume;
	}
	public StringProperty PrenumeProperty() {
		return Prenume;
	}
	public StringProperty InstrumentProperty() {
		return Instrument;
	}
	public StringProperty NumeImpresarProperty() {
		return NumeImpresar;
	}
	public StringProperty DenumireProperty() {
		return Denumire;
	}
	public StringProperty LocatieProperty() {
		return Locatie;
	}
	public StringProperty GenMuzicalProperty() {
		return GenMuzical;
	}
}
