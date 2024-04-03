package proiect;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Artist {
private final IntegerProperty idArtist;
private final StringProperty Nume;
private final StringProperty Prenume;
private final StringProperty Instrument;
private final StringProperty NumeImpresar;
public Artist(Integer idArtist, String Nume, String Prenume, String Instrument, String NumeImpresar) {
this.idArtist = new SimpleIntegerProperty(idArtist);
this.Nume = new SimpleStringProperty(Nume);
this.Prenume = new SimpleStringProperty(Prenume);
this.Instrument = new SimpleStringProperty(Instrument);
this.NumeImpresar = new SimpleStringProperty(NumeImpresar);
}
public Integer getIdArtist() {
return idArtist.get();
}
public String getNume() {
return Nume.get();
}
public String getPrenume() {
return Prenume.get();
}
public String getInstrument() {
return Instrument.get();
}
public String getNumeImpresar() {
return NumeImpresar.get();
}
public void setIdArtist(Integer valoare) {
idArtist.set(valoare);
}
public void setNume(String valoare) {
Nume.set(valoare);
}
public void setPrenume(String valoare) {
Prenume.set(valoare);
}
public void setInstrument(String valoare) {
Instrument.set(valoare);
}
public void setNumeImpresar(String valoare) {
NumeImpresar.set(valoare);
}
public IntegerProperty idArtistProperty() {
return idArtist;
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
}
