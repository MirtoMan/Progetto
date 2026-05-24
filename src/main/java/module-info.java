module it.unical.kindled {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jbcrypt;


    opens it.unical.kindled to javafx.fxml;
    exports it.unical.kindled;
    exports it.unical.kindled.controller;
    opens it.unical.kindled.controller to javafx.fxml;
}