module it.unical.kindled {
    requires javafx.controls;
    requires javafx.fxml;


    opens it.unical.kindled to javafx.fxml;
    exports it.unical.kindled;
}