module PIBD3 {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.base;
	
	opens proiect to javafx.graphics, javafx.fxml,javafx.base;
}
