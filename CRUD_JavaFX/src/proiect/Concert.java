package proiect;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
public class Concert {
private final IntegerProperty idConcert;
private final StringProperty Denumire;
private final StringProperty Locatie;
private final StringProperty GenMuzical;
public Concert(Integer idConcert, String Denumire, String Locatie, String GenMuzical) {
this.idConcert = new SimpleIntegerProperty(idConcert);
this.Denumire = new SimpleStringProperty(Denumire);
this.Locatie = new SimpleStringProperty(Locatie);
this.GenMuzical = new SimpleStringProperty(GenMuzical);
}
public Integer getIdConcert() {
return idConcert.get();
}
public String getDenumire() {
return Denumire.get();
}
public String getLocatie() {
return Locatie.get();
}
public String getGenMuzical() {
return GenMuzical.get();
}
public void setIdConcert(Integer valoare) {
	idConcert.set(valoare);
}
public void setDenumire(String valoare) {
	Denumire.set(valoare);
}
public void setLocatie(String valoare) {
	Locatie.set(valoare);
}
public void setGenMuzical(String valoare) {
	GenMuzical.set(valoare);
}
public IntegerProperty idConcertProperty() {
return idConcert;
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