package proiect;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class ProiectController implements Initializable {
@FXML
private TableView<Artist> tabela_Artisti;
@FXML
private Tab tab_Artisti;
@FXML
private Button buton_IncarcareArtisti;
@FXML
private TableColumn<Artist, Integer> atribut_idArtist;
@FXML
private TableColumn<Artist, String> atribut_NumeA;
@FXML
private TableColumn<Artist, String> atribut_PrenumeA;
@FXML
private TableColumn<Artist, String> atribut_InstrumentA;
@FXML
private TableColumn<Artist, String> atribut_NumeImpresarA;
@FXML
private TextField inputNumeA;
@FXML
private TextField inputPrenumeA;
@FXML
private TextField inputInstrumentA;
@FXML
private TextField inputNumeImpresarA;
@FXML
private TextField inputNumeAm;
@FXML
private TextField inputPrenumeAm;
@FXML
private TextField inputInstrumentAm;
@FXML
private TextField inputNumeImpresarAm;
@FXML
private TableView<Concert> tabela_Concerte;
@FXML
private Tab tab_Concerte;
@FXML
private Button buton_IncarcareConcerte;
@FXML
private TableColumn<Concert, Integer> atribut_idConcert;
@FXML
private TableColumn<Concert, String> atribut_DenumireC;
@FXML
private TableColumn<Concert, String> atribut_LocatieC;
@FXML
private TableColumn<Concert, String> atribut_GenMuzicalC;
@FXML
private TextField inputDenumireC;
@FXML
private TextField inputLocatieC;
@FXML
private TextField inputGenMuzicalC;
@FXML
private TextField inputDenumireCm;
@FXML
private TextField inputLocatieCm;
@FXML
private TextField inputGenMuzicalCm;
@FXML
private TableView<Repartizare> tabela_Repartizari;
@FXML
private Tab tab_Repartizari;
@FXML
private Button buton_IncarcareRepartizari;
@FXML
private TableColumn<Repartizare, Integer> atribut_idRepartizare;
@FXML
private TableColumn<Repartizare, Integer> atribut_idArtistR;
@FXML
private TableColumn<Repartizare, Integer> atribut_idConcertR;
@FXML
private TableColumn<Repartizare, String> atribut_NumeR;
@FXML
private TableColumn<Repartizare, String> atribut_PrenumeR;
@FXML
private TableColumn<Repartizare, String> atribut_InstrumentR;
@FXML
private TableColumn<Repartizare, String> atribut_NumeImpresarR;
@FXML
private TableColumn<Repartizare, String> atribut_DenumireR;
@FXML
private TableColumn<Repartizare, String> atribut_LocatieR;
@FXML
private TableColumn<Repartizare, String> atribut_GenMuzicalR;
@FXML
private ComboBox combobox_artisti;
@FXML
private ComboBox combobox_concerte;
@FXML
private ComboBox combobox_artistim;
@FXML
private ComboBox combobox_concertem;
public static int x;
private ObservableList<Artist> dateArtisti;
private ObservableList<Concert> dateConcerte;
private ObservableList<Repartizare> dateRepartizari;
private DBOperations jb;
@Override
public void initialize(URL url, ResourceBundle rb) {
	jb = new DBOperations();
	if (combobox_artisti != null) {
		ObservableList<Integer> dateIdArtisti = FXCollections.observableArrayList();
		try {
			jb.connect();
			ResultSet rs = jb.vedeTabel("Artisti");
			while (rs.next()) {
				dateIdArtisti.add(rs.getInt("idArtist"));
			}
			jb.disconnect();
			combobox_artisti.setItems(dateIdArtisti);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	if (combobox_artistim != null) {
		ObservableList<Integer> dateIdArtisti = FXCollections.observableArrayList();
		try {
			jb.connect();
			ResultSet rs = jb.vedeTabel("Artisti");
			while (rs.next()) {
				dateIdArtisti.add(rs.getInt("idArtist"));
			}
			jb.disconnect();
			combobox_artistim.setItems(dateIdArtisti);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	if (combobox_concerte != null) {
		ObservableList<Integer> dateIdConcerte = FXCollections.observableArrayList();
		try {
			jb.connect();
			ResultSet rs = jb.vedeTabel("Concerte");
			while (rs.next()) {
				dateIdConcerte.add(rs.getInt("idConcert"));
			}
			jb.disconnect();
			combobox_concerte.setItems(dateIdConcerte);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	if (combobox_concertem != null) {
		ObservableList<Integer> dateIdConcerte = FXCollections.observableArrayList();
		try {
			jb.connect();
			ResultSet rs = jb.vedeTabel("Concerte");
			while (rs.next()) {
				dateIdConcerte.add(rs.getInt("idConcert"));
			}
			jb.disconnect();
			combobox_concertem.setItems(dateIdConcerte);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
}
@FXML
private void incarcaArtisti(ActionEvent event) throws SQLException, Exception {
jb.connect();
dateArtisti = FXCollections.observableArrayList();
ResultSet rs = jb.vedeTabel("artisti");
while (rs.next()) {
dateArtisti.add(new Artist(rs.getInt("idArtist"), rs.getString("Nume"), rs.getString("Prenume"), rs.getString("Instrument"), rs.getString("NumeImpresar")));
}
atribut_idArtist.setCellValueFactory(new PropertyValueFactory<>("idArtist"));
atribut_NumeA.setCellValueFactory(new PropertyValueFactory<>("Nume"));
atribut_PrenumeA.setCellValueFactory(new PropertyValueFactory<>("Prenume"));
atribut_InstrumentA.setCellValueFactory(new PropertyValueFactory<>("Instrument"));
atribut_NumeImpresarA.setCellValueFactory(new PropertyValueFactory<>("NumeImpresar"));
tabela_Artisti.setItems(null);
tabela_Artisti.setItems(dateArtisti);
jb.disconnect();
}
@FXML
private void startAdaugaArtist() throws IOException {
	Stage stage = new Stage();
	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("AdaugaArtist.fxml"));
	Scene scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}

@FXML
private void adaugaArtist() throws SQLException, Exception {
	String nume = inputNumeA.getText();
	String prenume = inputPrenumeA.getText();
	String instrument = inputInstrumentA.getText();
	String numeimpresar = inputNumeImpresarA.getText();
	
	jb.connect();
	jb.adaugaArtist(nume, prenume , instrument , numeimpresar);
	jb.disconnect();
}

@FXML
private void incarcaConcerte(ActionEvent event) throws SQLException, Exception {
jb.connect();
dateConcerte = FXCollections.observableArrayList();
ResultSet rs = jb.vedeTabel("concerte");
while (rs.next()) {
dateConcerte.add(new Concert(rs.getInt("idConcert"), rs.getString("Denumire"), rs.getString("Locatie"), rs.getString("GenMuzical")));
}
atribut_idConcert.setCellValueFactory(new PropertyValueFactory<>("idConcert"));
atribut_DenumireC.setCellValueFactory(new PropertyValueFactory<>("Denumire"));
atribut_LocatieC.setCellValueFactory(new PropertyValueFactory<>("Locatie"));
atribut_GenMuzicalC.setCellValueFactory(new PropertyValueFactory<>("GenMuzical"));
tabela_Concerte.setItems(null);
tabela_Concerte.setItems(dateConcerte);
jb.disconnect();
}

@FXML
private void startAdaugaConcert() throws IOException {
	Stage stage = new Stage();
	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("AdaugaConcert.fxml"));
	Scene scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}

@FXML
private void adaugaConcert() throws SQLException, Exception {
	String denumire = inputDenumireC.getText();
	String locatie = inputLocatieC.getText();
	String genmuzical = inputGenMuzicalC.getText();
	
	jb.connect();
	jb.adaugaConcert(denumire, locatie, genmuzical);
	jb.disconnect();
}

@FXML
private void incarcaRepartizari(ActionEvent event) throws SQLException, Exception {
	jb.connect();
	dateRepartizari = FXCollections.observableArrayList();
	ResultSet rs = jb.vedeRepartizare();
	while (rs.next()) {
		dateRepartizari.add(new Repartizare(rs.getInt("idRepartizare"), rs.getInt("idArtist_rep"), rs.getInt("idConcert_rep"), rs.getString("Nume") ,rs.getString("Prenume"),rs.getString("Instrument"),rs.getString("NumeImpresar"),rs.getString("Denumire"),rs.getString("Locatie"),rs.getString("GenMuzical")));
	}
	
	atribut_idRepartizare.setCellValueFactory(new PropertyValueFactory<>("idRepartizare"));
	atribut_idArtistR.setCellValueFactory(new PropertyValueFactory<>("idArtist"));
	atribut_idConcertR.setCellValueFactory(new PropertyValueFactory<>("idConcert"));
	atribut_NumeR.setCellValueFactory(new PropertyValueFactory<>("Nume"));
	atribut_PrenumeR.setCellValueFactory(new PropertyValueFactory<>("Prenume"));
	atribut_InstrumentR.setCellValueFactory(new PropertyValueFactory<>("Instrument"));
	atribut_NumeImpresarR.setCellValueFactory(new PropertyValueFactory<>("NumeImpresar"));
	atribut_DenumireR.setCellValueFactory(new PropertyValueFactory<>("Denumire"));
	atribut_LocatieR.setCellValueFactory(new PropertyValueFactory<>("Locatie"));
	atribut_GenMuzicalR.setCellValueFactory(new PropertyValueFactory<>("GenMuzical"));
	
	tabela_Repartizari.setItems(null);
	tabela_Repartizari.setItems(dateRepartizari);
	
	jb.disconnect();
}

@FXML
private void startAdaugaRepartizare() throws IOException {
	Stage stage = new Stage();
	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("AdaugaRepartizare.fxml"));
	Scene scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}

@FXML
private void adaugaRepartizare() throws SQLException, Exception {
	Integer idArtist = (Integer) combobox_artisti.getValue();
	Integer idConcert = (Integer) combobox_concerte.getValue();
	
	jb.connect();
	jb.adaugaRepartizare(idArtist, idConcert);
	jb.disconnect();
}
@FXML
private void stergeArtist(ActionEvent event) throws SQLException, Exception {
jb.connect();
Artist artist = tabela_Artisti.getSelectionModel().getSelectedItem();
if (artist != null) {
jb.stergeTabela("artisti", "idArtist",artist.getIdArtist());
} else {
System.out.println("Nu s-a putut face stergerea artistului!");
}
incarcaArtisti(event);
jb.disconnect();
}
@FXML
private void startModificaArtist() throws IOException {
	Artist artist = tabela_Artisti.getSelectionModel().getSelectedItem();
	
	if(artist!=null)
	{
		x=artist.getIdArtist();
	Stage stage = new Stage();
	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("ModificaArtist.fxml"));
	Scene scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
	}else {
	System.out.println("Nu s-a putut face modificarea artistului!");
	}
}
@FXML
private void modificaArtist(ActionEvent event) throws SQLException, Exception {
	try {
		
		jb.connect();
		String[] valori = {inputNumeAm.getText(), inputPrenumeAm.getText(), inputInstrumentAm.getText(), inputNumeImpresarAm.getText()};
		String[] campuri = {"Nume", "Prenume","Instrument", "NumeImpresar"};
		jb.modificaTabela("artisti", "idArtist",x ,campuri, valori);
		jb.disconnect();
		} catch(Exception e) {
		System.out.println("Error!");
		return;
		}
		jb.disconnect();
		}

@FXML
private void stergeConcert(ActionEvent event) throws SQLException, Exception {
jb.connect();
Concert concert = tabela_Concerte.getSelectionModel().getSelectedItem();
if (concert != null) {
jb.stergeTabela("concerte", "idConcert",concert.getIdConcert());
} else {
System.out.println("Nu s-a putut face stergerea concertului!");
}
incarcaConcerte(event);
jb.disconnect();
}
@FXML
private void startModificaConcert() throws IOException {
	Concert concert = tabela_Concerte.getSelectionModel().getSelectedItem();
	
	if(concert!=null)
	{
		x=concert.getIdConcert();
	Stage stage = new Stage();
	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("ModificaConcert.fxml"));
	Scene scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
	}else {
	System.out.println("Nu s-a putut face modificarea concertului!");
	}
}
@FXML
private void modificaConcert(ActionEvent event) throws SQLException, Exception {
	try {
		
		jb.connect();
		String[] valori = {inputDenumireCm.getText(), inputLocatieCm.getText(), inputGenMuzicalCm.getText()};
		String[] campuri = {"Denumire", "Locatie","GenMuzical"};
		jb.modificaTabela("concerte", "idConcert",x ,campuri, valori);
		jb.disconnect();
		} catch(Exception e) {
		System.out.println("Error!");
		return;
		}
		jb.disconnect();
		}
@FXML
private void stergeRepartizare(ActionEvent event) throws SQLException, Exception {
jb.connect();
Repartizare repartizare = tabela_Repartizari.getSelectionModel().getSelectedItem();
if (repartizare != null) {
jb.stergeTabela("repartizari", "idRepartizare",repartizare.getIdRepartizare());
} else {
System.out.println("Nu s-a putut face stergerea repartizarii!");
}
incarcaRepartizari(event);
jb.disconnect();
}
@FXML
private void startModificaRepartizare() throws IOException {
	Repartizare repartizare = tabela_Repartizari.getSelectionModel().getSelectedItem();
	
	if(repartizare!=null)
	{
		x=repartizare.getIdRepartizare();
	Stage stage = new Stage();
	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("ModificaRepartizare.fxml"));
	Scene scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
	}else {
	System.out.println("Nu s-a putut face modificarea repartizarii!");
	}
}
@FXML
private void modificaRepartizare(ActionEvent event) throws SQLException, Exception {
	try {
		
		jb.connect();
		String[] valori = {String.valueOf(combobox_artistim.getValue()),String.valueOf(combobox_concertem.getValue())}; 
		String[] campuri = {"idArtist", "idConcert"};
		jb.modificaTabela("repartizari", "idRepartizare",x ,campuri, valori);
		jb.disconnect();
		} catch(Exception e) {
		System.out.println("Error!");
		return;
		}
		jb.disconnect();
		}
}