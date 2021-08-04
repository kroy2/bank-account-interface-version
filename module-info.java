module Project {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
	requires javafx.media;
	opens Controllers to javafx.graphics, javafx.fxml;
}